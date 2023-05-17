package com.baidu.searchbox.network.support.okhttp.converters;

import com.baidu.searchbox.network.outback.core.Headers;
import com.baidu.searchbox.network.outback.core.internal.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class HeadersConverter {
    public static void checkName(String str) {
        if (str != null) {
            if (!str.isEmpty()) {
                int length = str.length();
                for (int i = 0; i < length; i++) {
                    char charAt = str.charAt(i);
                    if (charAt <= ' ' || charAt >= 127) {
                        throw new IllegalArgumentException(Util.format("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i), str));
                    }
                }
                return;
            }
            throw new IllegalArgumentException("name is empty");
        }
        throw new NullPointerException("name == null");
    }

    public static boolean checkValue(String str, String str2) {
        if (str != null) {
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char charAt = str.charAt(i);
                if ((charAt <= 31 && charAt != '\t') || charAt >= 127) {
                    return false;
                }
            }
            return true;
        }
        throw new NullPointerException("value for name " + str2 + " == null");
    }

    public static Headers fromOks(okhttp3.Headers headers) {
        ConverterUtils.requireNonNull(headers, "okHeaders should not be null");
        Map<String, List<String>> multimap = headers.toMultimap();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, List<String>> entry : multimap.entrySet()) {
            if (entry.getKey() != null && entry.getValue() != null) {
                String trim = entry.getKey().trim();
                checkName(trim);
                for (String str : entry.getValue()) {
                    if (checkValue(str, trim)) {
                        arrayList.add(trim);
                        arrayList.add(str);
                    }
                }
            } else {
                throw new IllegalArgumentException("Headers cannot be null");
            }
        }
        return Headers.of((String[]) arrayList.toArray(new String[0]));
    }

    public static okhttp3.Headers toOks(Headers headers) {
        ConverterUtils.requireNonNull(headers, "headers should not be null");
        Map<String, List<String>> multimap = headers.toMultimap();
        String[] strArr = new String[headers.size() * 2];
        int i = 0;
        for (Map.Entry<String, List<String>> entry : multimap.entrySet()) {
            if (entry.getKey() != null && entry.getValue() != null) {
                String trim = entry.getKey().trim();
                checkName(trim);
                for (String str : entry.getValue()) {
                    if (checkValue(str, trim)) {
                        strArr[i] = trim;
                        strArr[i + 1] = str;
                        i += 2;
                    }
                }
            } else {
                throw new IllegalArgumentException("Headers cannot be null");
            }
        }
        return okhttp3.Headers.of(strArr);
    }
}

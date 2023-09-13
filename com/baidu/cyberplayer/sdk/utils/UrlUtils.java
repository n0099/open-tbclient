package com.baidu.cyberplayer.sdk.utils;

import android.net.Uri;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class UrlUtils {
    public static Uri addCdnTag(Uri uri, String str) {
        if (TextUtils.isEmpty(str)) {
            return uri;
        }
        String query = uri.getQuery();
        if (query != null && query.contains(str)) {
            return uri;
        }
        if (query != null) {
            str = query + "&" + str;
        }
        return uri.buildUpon().clearQuery().encodedQuery(str).build();
    }

    public static Map<List<String>, String> freeHostparse(String str) {
        JSONArray optJSONArray;
        HashMap hashMap = new HashMap();
        if (TextUtils.isEmpty(str)) {
            return hashMap;
        }
        try {
            optJSONArray = new JSONObject(str).optJSONArray("video");
        } catch (Exception unused) {
            hashMap.clear();
        }
        if (optJSONArray == null) {
            return hashMap;
        }
        int length = optJSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            JSONArray optJSONArray2 = optJSONObject.optJSONArray("cdn_list");
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                arrayList.add(optJSONArray2.optString(i2));
            }
            hashMap.put(arrayList, optJSONObject.optString("target"));
        }
        return hashMap;
    }

    public static Uri replaceFreeHost(Uri uri, String str) {
        if (TextUtils.isEmpty(str)) {
            return uri;
        }
        Map<List<String>, String> freeHostparse = freeHostparse(str);
        if (freeHostparse != null && freeHostparse.size() > 0) {
            String uri2 = uri.toString();
            String str2 = uri2;
            for (Map.Entry<List<String>, String> entry : freeHostparse.entrySet()) {
                List<String> key = entry.getKey();
                String value = entry.getValue();
                if (key != null) {
                    Iterator<String> it = key.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            String next = it.next();
                            if (uri2.contains(next) && value != null) {
                                str2 = uri2.replaceFirst(next, value);
                                break;
                            }
                        }
                    }
                }
            }
            return Uri.parse(str2);
        }
        return uri;
    }
}

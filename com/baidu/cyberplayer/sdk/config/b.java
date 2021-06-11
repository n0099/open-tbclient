package com.baidu.cyberplayer.sdk.config;

import android.text.TextUtils;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
/* loaded from: classes2.dex */
public class b {
    public static Map<String, String> a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            FileReader fileReader = new FileReader(str);
            Properties properties = new Properties();
            properties.load(fileReader);
            HashMap hashMap = new HashMap();
            try {
                for (Map.Entry entry : properties.entrySet()) {
                    hashMap.put((String) entry.getKey(), (String) entry.getValue());
                }
                fileReader.close();
            } catch (FileNotFoundException | IOException unused) {
            }
            return hashMap;
        } catch (FileNotFoundException | IOException unused2) {
            return null;
        }
    }
}

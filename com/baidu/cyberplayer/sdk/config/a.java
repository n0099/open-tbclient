package com.baidu.cyberplayer.sdk.config;

import android.text.TextUtils;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
/* loaded from: classes7.dex */
public class a {
    public static Map<String, String> a(String str) {
        HashMap hashMap = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            FileReader fileReader = new FileReader(str);
            Properties properties = new Properties();
            properties.load(fileReader);
            if (properties != null) {
                HashMap hashMap2 = new HashMap();
                try {
                    for (Map.Entry entry : properties.entrySet()) {
                        hashMap2.put((String) entry.getKey(), (String) entry.getValue());
                    }
                    hashMap = hashMap2;
                } catch (FileNotFoundException e) {
                    return hashMap2;
                } catch (IOException e2) {
                    return hashMap2;
                }
            }
            fileReader.close();
            return hashMap;
        } catch (FileNotFoundException e3) {
            return hashMap;
        } catch (IOException e4) {
            return hashMap;
        }
    }
}

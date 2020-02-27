package com.baidu.swan.a;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import java.util.HashMap;
/* loaded from: classes11.dex */
public class b {
    public static HashMap<String, String> a(com.baidu.swan.a.a.a aVar) {
        if (aVar == null) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("version_code", String.valueOf(aVar.getVersionCode()));
        hashMap.put(SharedPrefConfig.VERSION_NAME, aVar.getVersionName());
        hashMap.put("abi_type", com.baidu.swan.a.b.a.ajk());
        return hashMap;
    }
}

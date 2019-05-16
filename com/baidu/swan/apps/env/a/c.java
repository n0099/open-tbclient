package com.baidu.swan.apps.env.a;

import android.support.annotation.Nullable;
import android.util.Log;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes2.dex */
public class c implements a {
    @Override // com.baidu.swan.apps.env.a.a
    @Nullable
    public List<String> t(@Nullable List<String> list) {
        if (list == null) {
            return null;
        }
        List<com.baidu.swan.apps.database.a> BP = com.baidu.swan.apps.database.favorite.a.BP();
        if (BP.size() != 0) {
            HashSet hashSet = new HashSet();
            for (com.baidu.swan.apps.database.a aVar : BP) {
                hashSet.add(aVar.appId);
            }
            list.removeAll(hashSet);
            if (DEBUG) {
                Log.d("IDiskCleanStrategy", "共" + hashSet.size() + "条收藏，尝试过滤");
                return list;
            }
            return list;
        }
        return list;
    }
}

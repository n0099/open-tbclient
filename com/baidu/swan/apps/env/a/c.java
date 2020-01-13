package com.baidu.swan.apps.env.a;

import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.swan.apps.favordata.SwanFavorDataManager;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes10.dex */
public class c implements a {
    @Override // com.baidu.swan.apps.env.a.a
    @Nullable
    public List<String> S(@Nullable List<String> list) {
        if (list == null) {
            return null;
        }
        List<SwanFavorItemData> PQ = SwanFavorDataManager.PP().PQ();
        if (PQ.size() != 0) {
            HashSet hashSet = new HashSet();
            for (SwanFavorItemData swanFavorItemData : PQ) {
                hashSet.add(swanFavorItemData.getAppKey());
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

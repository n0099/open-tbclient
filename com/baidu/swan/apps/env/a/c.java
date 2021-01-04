package com.baidu.swan.apps.env.a;

import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.favordata.SwanFavorDataManager;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes9.dex */
public class c implements a {
    @Override // com.baidu.swan.apps.env.a.a
    @Nullable
    public List<String> aL(@Nullable List<String> list) {
        if (list == null) {
            return null;
        }
        List<SwanFavorItemData> ayk = SwanFavorDataManager.ayj().ayk();
        if (ayk.size() != 0) {
            HashSet hashSet = new HashSet();
            for (SwanFavorItemData swanFavorItemData : ayk) {
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

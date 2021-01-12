package com.baidu.swan.apps.env.a;

import android.util.Log;
import androidx.annotation.Nullable;
import java.util.List;
/* loaded from: classes8.dex */
public class b implements a {
    private int cXq;

    public b(int i) {
        this.cXq = i;
    }

    @Override // com.baidu.swan.apps.env.a.a
    @Nullable
    public List<String> aL(@Nullable List<String> list) {
        if (list == null || list.size() == 0 || this.cXq < 0) {
            return null;
        }
        if (list.size() < this.cXq) {
            if (DEBUG) {
                Log.d("IDiskCleanStrategy", "数量未达到上限，无需删除");
                return null;
            }
            return null;
        }
        int size = list.size() - this.cXq;
        int size2 = list.size() - size;
        int size3 = list.size();
        if (DEBUG) {
            Log.d("IDiskCleanStrategy", "过滤后的列表有" + list.size() + "个小程序，上限" + this.cXq + "个，删除最早的" + size + "个");
        }
        return list.subList(size2, size3);
    }
}

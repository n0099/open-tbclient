package com.baidu.swan.apps.env.a;

import android.support.annotation.Nullable;
import android.util.Log;
import java.util.List;
/* loaded from: classes2.dex */
public class b implements a {
    private int aPB;

    public b(int i) {
        this.aPB = i;
    }

    @Override // com.baidu.swan.apps.env.a.a
    @Nullable
    public List<String> S(@Nullable List<String> list) {
        if (list == null || list.size() == 0 || this.aPB < 0) {
            return null;
        }
        if (list.size() < this.aPB) {
            if (DEBUG) {
                Log.d("IDiskCleanStrategy", "数量未达到上限，无需删除");
                return null;
            }
            return null;
        }
        int size = list.size() - this.aPB;
        int size2 = list.size() - size;
        int size3 = list.size();
        if (DEBUG) {
            Log.d("IDiskCleanStrategy", "过滤后的列表有" + list.size() + "个小程序，上限" + this.aPB + "个，删除最早的" + size + "个");
        }
        return list.subList(size2, size3);
    }
}

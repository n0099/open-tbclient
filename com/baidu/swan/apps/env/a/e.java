package com.baidu.swan.apps.env.a;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
/* loaded from: classes2.dex */
public class e implements a {
    private Set<String> aPC;

    public e(@Nullable Set<String> set) {
        this.aPC = set;
    }

    @Override // com.baidu.swan.apps.env.a.a
    @Nullable
    public List<String> S(@Nullable List<String> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!TextUtils.isEmpty(next)) {
                if (TextUtils.equals(next, "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u")) {
                    if (DEBUG) {
                        Log.d("IDiskCleanStrategy", "过滤「智能小程序」");
                    }
                    it.remove();
                } else if (this.aPC != null && this.aPC.contains(next)) {
                    if (DEBUG) {
                        Log.d("IDiskCleanStrategy", "过滤指定id: " + next);
                    }
                    it.remove();
                }
            }
        }
        return list;
    }
}

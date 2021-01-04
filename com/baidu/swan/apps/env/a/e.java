package com.baidu.swan.apps.env.a;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
/* loaded from: classes9.dex */
public class e implements a {
    private Set<String> dcf;

    public e(@Nullable Set<String> set) {
        this.dcf = set;
    }

    @Override // com.baidu.swan.apps.env.a.a
    @Nullable
    public List<String> aL(@Nullable List<String> list) {
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
                } else if (this.dcf != null && this.dcf.contains(next)) {
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

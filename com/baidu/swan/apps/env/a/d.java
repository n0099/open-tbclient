package com.baidu.swan.apps.env.a;

import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.util.List;
import java.util.Set;
/* loaded from: classes7.dex */
public class d implements a {
    @Override // com.baidu.swan.apps.env.a.a
    @Nullable
    public List<String> af(@Nullable List<String> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        Set<String> a = com.baidu.swan.apps.database.a.b.a(AppRuntime.getAppContext().getContentResolver());
        if (a.size() != 0) {
            list.removeAll(a);
            if (DEBUG) {
                Log.d("IDiskCleanStrategy", "共" + a.size() + "个历史，尝试过滤");
                return list;
            }
            return list;
        }
        return list;
    }
}

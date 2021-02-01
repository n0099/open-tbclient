package com.baidu.swan.apps.env.a;

import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.util.List;
import java.util.Set;
/* loaded from: classes9.dex */
public class d implements a {
    @Override // com.baidu.swan.apps.env.a.a
    @Nullable
    public List<String> aG(@Nullable List<String> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        Set<String> a2 = com.baidu.swan.apps.database.a.b.a(AppRuntime.getAppContext().getContentResolver());
        if (a2.size() != 0) {
            list.removeAll(a2);
            if (DEBUG) {
                Log.d("IDiskCleanStrategy", "共" + a2.size() + "个历史，尝试过滤");
                return list;
            }
            return list;
        }
        return list;
    }
}

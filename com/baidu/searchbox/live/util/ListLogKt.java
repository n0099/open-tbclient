package com.baidu.searchbox.live.util;

import android.util.Log;
import com.baidu.live.arch.runtime.MiniShellRuntime;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u001f\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"", "tag", "log", "", "(Ljava/lang/String;Ljava/lang/String;)V", "lib-live-mini-shell_release"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class ListLogKt {
    public static final void log(String str, String str2) {
        if (MiniShellRuntime.INSTANCE.isDebug()) {
            Log.d(str, str2);
        }
    }

    public static /* synthetic */ void log$default(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "live_sdk";
        }
        log(str, str2);
    }
}

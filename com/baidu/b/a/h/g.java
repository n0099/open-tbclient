package com.baidu.b.a.h;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes2.dex */
public class g {
    private static volatile g aaC;
    private Context mContext;

    private g(Context context) {
        this.mContext = context;
    }

    public static g sn() {
        if (aaC == null) {
            synchronized (g.class) {
                aaC = new g(AppRuntime.getApplication());
            }
        }
        return aaC;
    }

    public void b(int i, String str, String str2) {
        if (!com.baidu.b.a.h.a.b.bl(this.mContext).so().c(i, str, str2)) {
            Log.e("DynamicFileStatisticManager", "Host Cannot Handle the addFetchStatistic2 Callback");
        }
    }

    public void a(int i, String str, String str2, String str3, long j, String str4, String str5, int i2, int i3) {
        if (!com.baidu.b.a.h.a.b.bl(this.mContext).so().b(i, str, str2, str3, j, str4, str5, i2, i3)) {
            Log.e("DynamicFileStatisticManager", "Host Cannot Handle the addDownloadStatistic2 Callback");
        }
    }
}

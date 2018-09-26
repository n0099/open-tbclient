package com.baidu.sapi2.passhost.hostsdk.service;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.sapi2.base.debug.Log;
import com.baidu.sapi2.passhost.pluginsdk.service.ISafeService;
import com.baidu.sofire.ac.FH;
/* loaded from: classes.dex */
public class SafeService implements ISafeService {
    private static final String a = "SafeService";

    /* loaded from: classes.dex */
    private static class a {
        public static SafeService a = new SafeService();

        private a() {
        }
    }

    public static SafeService getInstance() {
        return a.a;
    }

    public boolean init(Context context, String str, String str2, int... iArr) {
        try {
            FH.init(context, str, str2, iArr);
            return true;
        } catch (Throwable th) {
            Log.e(a, "init()", th.toString());
            return false;
        }
    }

    private SafeService() {
    }

    public String getZidAndCheckSafe(Context context, String str, int i) {
        String gzfi = FH.gzfi(context, str, i);
        return TextUtils.isEmpty(gzfi) ? "NoZidYet" : gzfi;
    }
}

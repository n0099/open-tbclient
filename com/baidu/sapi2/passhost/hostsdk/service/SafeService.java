package com.baidu.sapi2.passhost.hostsdk.service;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
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

    public void init(Context context, String str, String str2, int... iArr) {
        try {
            FH.init(context, str, str2, iArr);
        } catch (Throwable th) {
            Log.e(a, "init()", th.toString());
        }
    }

    private SafeService() {
    }

    @Override // com.baidu.sapi2.passhost.pluginsdk.service.ISafeService
    public Pair<Integer, Object> callSync(int i, String str, Class<?>[] clsArr, Object... objArr) {
        Log.d(a, "callSync()", Integer.valueOf(i), str);
        try {
            return FH.callSync(i, str, new Class[]{String.class, Integer.TYPE}, objArr);
        } catch (NoClassDefFoundError e) {
            return new Pair<>(-1, null);
        }
    }

    @Override // com.baidu.sapi2.passhost.pluginsdk.service.ISafeService
    public String getCurZid(Context context) {
        try {
            String gz = FH.gz(context);
            return TextUtils.isEmpty(gz) ? "NoZidYet" : gz;
        } catch (NoClassDefFoundError e) {
            return "NotImportSofireSdk";
        }
    }

    public String getZidAndCheckSafe(Context context, String str, int i) {
        try {
            String gzfi = FH.gzfi(context, str, i);
            return TextUtils.isEmpty(gzfi) ? "NoZidYet" : gzfi;
        } catch (NoClassDefFoundError e) {
            return "NotImportSofireSdk";
        }
    }
}

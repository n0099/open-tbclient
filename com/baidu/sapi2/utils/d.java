package com.baidu.sapi2.utils;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.sofire.ac.FH;
/* loaded from: classes6.dex */
public class d {
    private static final String a = "SafeService";
    public static final int b = 120;
    public static final int c = 122;
    public static final int d = 1;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class a {
        public static d a = new d();

        private a() {
        }
    }

    public static d a() {
        return a.a;
    }

    private d() {
    }

    public boolean a(Context context, String str, String str2, int... iArr) {
        try {
            FH.init(context, str, str2, iArr);
            return true;
        } catch (Throwable th) {
            Log.e(a, "init()", th.toString());
            return false;
        }
    }

    public String a(Context context, String str, int i) {
        String gzfi = FH.gzfi(context, str, i);
        return TextUtils.isEmpty(gzfi) ? "NoZidYet" : gzfi;
    }

    public String a(Context context, String str, String str2, int i) {
        return FH.gt(context, str, str2, i, null);
    }
}

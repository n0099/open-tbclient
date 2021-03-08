package com.baidu.sapi2.utils;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.sofire.ac.FH;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final String f3444a = "SafeService";
    public static final int b = 120;
    public static final int c = 122;
    public static final int d = 1;

    /* loaded from: classes3.dex */
    private static class b {

        /* renamed from: a  reason: collision with root package name */
        public static c f3445a = new c();

        private b() {
        }
    }

    public static c a() {
        return b.f3445a;
    }

    private c() {
    }

    public boolean a(Context context, String str, String str2, int... iArr) {
        try {
            FH.init(context, str, str2, iArr);
            return true;
        } catch (Throwable th) {
            Log.e(f3444a, "init()", th.toString());
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

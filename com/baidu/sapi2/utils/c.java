package com.baidu.sapi2.utils;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.sofire.ac.FH;
/* loaded from: classes15.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5101a = "SafeService";

    /* renamed from: b  reason: collision with root package name */
    public static final int f5102b = 120;
    public static final int c = 122;
    public static final int d = 1;

    /* loaded from: classes15.dex */
    private static class b {

        /* renamed from: a  reason: collision with root package name */
        public static c f5103a = new c();

        private b() {
        }
    }

    public static c a() {
        return b.f5103a;
    }

    private c() {
    }

    public boolean a(Context context, String str, String str2, int... iArr) {
        try {
            FH.init(context, str, str2, iArr);
            return true;
        } catch (Throwable th) {
            Log.e(f5101a, "init()", th.toString());
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

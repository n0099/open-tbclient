package com.baidu.sapi2.utils;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.sofire.ac.FH;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final String f11450a = "SafeService";

    /* renamed from: b  reason: collision with root package name */
    public static final int f11451b = 120;

    /* renamed from: c  reason: collision with root package name */
    public static final int f11452c = 122;

    /* renamed from: d  reason: collision with root package name */
    public static final int f11453d = 1;

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static d f11454a = new d();
    }

    public static d a() {
        return b.f11454a;
    }

    public d() {
    }

    public boolean a(Context context, String str, String str2, int... iArr) {
        try {
            FH.init(context, str, str2, iArr);
            return true;
        } catch (Throwable th) {
            Log.e(f11450a, "init()", th.toString());
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

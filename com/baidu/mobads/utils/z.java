package com.baidu.mobads.utils;

import android.content.Context;
import android.telephony.TelephonyManager;
/* loaded from: classes2.dex */
public class z extends com.baidu.mobads.f.a<Object> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f8581a;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ t f8582c;

    public z(t tVar, Context context) {
        this.f8582c = tVar;
        this.f8581a = context;
    }

    @Override // com.baidu.mobads.f.a
    public Object a() {
        String str;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) this.f8581a.getSystemService("phone");
            this.f8582c.t = telephonyManager.getClass().getDeclaredMethod("getImei", Integer.TYPE).invoke(telephonyManager, 1).toString();
            t.a(this.f8582c);
        } catch (Throwable unused) {
        }
        str = this.f8582c.t;
        return str;
    }
}

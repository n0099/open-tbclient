package com.baidu.mobads.utils;

import android.content.Context;
import android.telephony.TelephonyManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class z extends com.baidu.mobads.f.a<Object> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f2500a;
    final /* synthetic */ t c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(t tVar, Context context) {
        this.c = tVar;
        this.f2500a = context;
    }

    @Override // com.baidu.mobads.f.a
    public Object a() {
        String str;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) this.f2500a.getSystemService("phone");
            this.c.t = telephonyManager.getClass().getDeclaredMethod("getImei", Integer.TYPE).invoke(telephonyManager, 1).toString();
            t.a(this.c);
        } catch (Throwable th) {
        }
        str = this.c.t;
        return str;
    }
}

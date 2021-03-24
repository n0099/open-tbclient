package com.alipay.sdk.util;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.alipay.android.app.IAlixPay;
/* loaded from: classes.dex */
public class f implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e f1977a;

    public f(e eVar) {
        this.f1977a = eVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Object obj;
        Object obj2;
        obj = this.f1977a.f1973e;
        synchronized (obj) {
            this.f1977a.f1972d = IAlixPay.Stub.asInterface(iBinder);
            obj2 = this.f1977a.f1973e;
            obj2.notify();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.f1977a.f1972d = null;
    }
}

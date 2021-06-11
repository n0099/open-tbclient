package com.alipay.sdk.app;
/* loaded from: classes.dex */
public class H5AuthActivity extends H5PayActivity {
    @Override // com.alipay.sdk.app.H5PayActivity
    public void a() {
        Object obj = AuthTask.f1747a;
        synchronized (obj) {
            try {
                obj.notify();
            } catch (Exception unused) {
            }
        }
    }
}

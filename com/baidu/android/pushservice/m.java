package com.baidu.android.pushservice;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PushSDK f587a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(PushSDK pushSDK) {
        this.f587a = pushSDK;
    }

    @Override // java.lang.Runnable
    public void run() {
        Object obj;
        obj = PushSDK.mPushConnLock;
        synchronized (obj) {
            if (PushSDK.mPushConnection != null) {
                PushSDK.mPushConnection.b();
            }
        }
    }
}

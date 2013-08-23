package com.baidu.loginshare;
/* loaded from: classes.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private ILoginShareListener f791a = null;

    synchronized void a() {
        this.f791a = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(ILoginShareListener iLoginShareListener) {
        this.f791a = iLoginShareListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(Token token) {
        if (this.f791a != null) {
            this.f791a.onLoginShareEvent(token);
        }
    }
}

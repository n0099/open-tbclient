package com.baidu.loginshare;
/* loaded from: classes.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private ILoginShareListener f932a = null;

    synchronized void a() {
        this.f932a = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(ILoginShareListener iLoginShareListener) {
        this.f932a = iLoginShareListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(Token token) {
        if (this.f932a != null) {
            this.f932a.onLoginShareEvent(token);
        }
    }
}

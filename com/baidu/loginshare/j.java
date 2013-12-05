package com.baidu.loginshare;
/* loaded from: classes.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private ILoginShareListener f952a = null;

    synchronized void a() {
        this.f952a = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(ILoginShareListener iLoginShareListener) {
        this.f952a = iLoginShareListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(Token token) {
        if (this.f952a != null) {
            this.f952a.onLoginShareEvent(token);
        }
    }
}

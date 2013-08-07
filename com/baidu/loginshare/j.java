package com.baidu.loginshare;
/* loaded from: classes.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private ILoginShareListener f768a = null;

    synchronized void a() {
        this.f768a = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(ILoginShareListener iLoginShareListener) {
        this.f768a = iLoginShareListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(Token token) {
        if (this.f768a != null) {
            this.f768a.onLoginShareEvent(token);
        }
    }
}

package com.baidu.loginshare;
/* loaded from: classes.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private ILoginShareListener f946a = null;

    synchronized void a() {
        this.f946a = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(ILoginShareListener iLoginShareListener) {
        this.f946a = iLoginShareListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(Token token) {
        if (this.f946a != null) {
            this.f946a.onLoginShareEvent(token);
        }
    }
}

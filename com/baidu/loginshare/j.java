package com.baidu.loginshare;
/* loaded from: classes.dex */
public class j {
    private ILoginShareListener a = null;

    synchronized void a() {
        this.a = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(ILoginShareListener iLoginShareListener) {
        this.a = iLoginShareListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(Token token) {
        if (this.a != null) {
            this.a.onLoginShareEvent(token);
        }
    }
}

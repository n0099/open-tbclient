package com.baidu.loginshare;
/* loaded from: classes.dex */
public final class e {
    private ILoginShareListener a = null;

    private synchronized void a() {
        this.a = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void a(ILoginShareListener iLoginShareListener) {
        this.a = iLoginShareListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void a(Token token) {
        if (this.a != null) {
            this.a.onLoginShareEvent(token);
        }
    }
}

package aegon.chrome.net.impl;

import aegon.chrome.net.impl.CronetUrlRequestContext;
/* loaded from: classes.dex */
public final /* synthetic */ class CronetUrlRequestContext$1$$Lambda$1 implements Runnable {
    public final CronetUrlRequestContext.AnonymousClass1 arg$1;

    public CronetUrlRequestContext$1$$Lambda$1(CronetUrlRequestContext.AnonymousClass1 anonymousClass1) {
        this.arg$1 = anonymousClass1;
    }

    public static Runnable lambdaFactory$(CronetUrlRequestContext.AnonymousClass1 anonymousClass1) {
        return new CronetUrlRequestContext$1$$Lambda$1(anonymousClass1);
    }

    @Override // java.lang.Runnable
    public void run() {
        CronetUrlRequestContext.AnonymousClass1.lambda$run$0(this.arg$1);
    }
}

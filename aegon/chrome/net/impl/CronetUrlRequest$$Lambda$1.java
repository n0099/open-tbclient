package aegon.chrome.net.impl;
/* loaded from: classes3.dex */
final /* synthetic */ class CronetUrlRequest$$Lambda$1 implements SafeNativeFunctionCaller$Supplier {
    private final CronetUrlRequest arg$1;

    private CronetUrlRequest$$Lambda$1(CronetUrlRequest cronetUrlRequest) {
        this.arg$1 = cronetUrlRequest;
    }

    public static SafeNativeFunctionCaller$Supplier lambdaFactory$(CronetUrlRequest cronetUrlRequest) {
        return new CronetUrlRequest$$Lambda$1(cronetUrlRequest);
    }

    @Override // aegon.chrome.net.impl.SafeNativeFunctionCaller$Supplier
    public Object get() {
        return CronetUrlRequest.lambda$start$0(this.arg$1);
    }
}

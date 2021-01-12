package aegon.chrome.net.impl;
/* loaded from: classes4.dex */
public final /* synthetic */ class CronetUrlRequestContext$$Lambda$1 implements SafeNativeFunctionCaller$Supplier {
    private final CronetEngineBuilderImpl arg$1;

    private CronetUrlRequestContext$$Lambda$1(CronetEngineBuilderImpl cronetEngineBuilderImpl) {
        this.arg$1 = cronetEngineBuilderImpl;
    }

    public static SafeNativeFunctionCaller$Supplier lambdaFactory$(CronetEngineBuilderImpl cronetEngineBuilderImpl) {
        return new CronetUrlRequestContext$$Lambda$1(cronetEngineBuilderImpl);
    }

    @Override // aegon.chrome.net.impl.SafeNativeFunctionCaller$Supplier
    public Object get() {
        return CronetUrlRequestContext.lambda$new$0(this.arg$1);
    }
}

package aegon.chrome.net;
/* loaded from: classes4.dex */
final /* synthetic */ class AndroidTelephonyManagerBridge$$Lambda$1 implements Runnable {
    private final AndroidTelephonyManagerBridge arg$1;

    private AndroidTelephonyManagerBridge$$Lambda$1(AndroidTelephonyManagerBridge androidTelephonyManagerBridge) {
        this.arg$1 = androidTelephonyManagerBridge;
    }

    public static Runnable lambdaFactory$(AndroidTelephonyManagerBridge androidTelephonyManagerBridge) {
        return new AndroidTelephonyManagerBridge$$Lambda$1(androidTelephonyManagerBridge);
    }

    @Override // java.lang.Runnable
    public void run() {
        AndroidTelephonyManagerBridge.lambda$create$0(this.arg$1);
    }
}

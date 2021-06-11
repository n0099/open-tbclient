package aegon.chrome.net;
/* loaded from: classes.dex */
public final /* synthetic */ class AndroidTelephonyManagerBridge$$Lambda$1 implements Runnable {
    public final AndroidTelephonyManagerBridge arg$1;

    public AndroidTelephonyManagerBridge$$Lambda$1(AndroidTelephonyManagerBridge androidTelephonyManagerBridge) {
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

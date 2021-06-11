package aegon.chrome.net;
/* loaded from: classes.dex */
public final /* synthetic */ class ProxyChangeListener$$Lambda$1 implements Runnable {
    public final ProxyChangeListener arg$1;

    public ProxyChangeListener$$Lambda$1(ProxyChangeListener proxyChangeListener) {
        this.arg$1 = proxyChangeListener;
    }

    public static Runnable lambdaFactory$(ProxyChangeListener proxyChangeListener) {
        return new ProxyChangeListener$$Lambda$1(proxyChangeListener);
    }

    @Override // java.lang.Runnable
    public void run() {
        ProxyChangeListener.lambda$updateProxyConfigFromConnectivityManager$0(this.arg$1);
    }
}

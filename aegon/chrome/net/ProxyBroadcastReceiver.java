package aegon.chrome.net;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes5.dex */
public final class ProxyBroadcastReceiver extends BroadcastReceiver {
    public final ProxyChangeListener mListener;

    public ProxyBroadcastReceiver(ProxyChangeListener proxyChangeListener) {
        this.mListener = proxyChangeListener;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.PROXY_CHANGE")) {
            this.mListener.updateProxyConfigFromConnectivityManager();
        }
    }
}

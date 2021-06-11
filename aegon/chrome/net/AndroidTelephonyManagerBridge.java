package aegon.chrome.net;

import aegon.chrome.base.ContextUtils;
import aegon.chrome.base.ThreadUtils;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.TelephonyManager;
import androidx.annotation.AnyThread;
import androidx.annotation.MainThread;
@AnyThread
/* loaded from: classes.dex */
public class AndroidTelephonyManagerBridge {
    public static volatile AndroidTelephonyManagerBridge sInstance;
    public Listener mListener;
    public volatile String mNetworkCountryIso;
    public volatile String mNetworkOperator;
    public volatile String mSimOperator;

    /* loaded from: classes.dex */
    public class Listener extends PhoneStateListener {
        public ServiceState mServiceState;

        public /* synthetic */ Listener(AnonymousClass1 anonymousClass1) {
            AndroidTelephonyManagerBridge.this = r1;
        }

        @Override // android.telephony.PhoneStateListener
        public void onServiceStateChanged(ServiceState serviceState) {
            ServiceState serviceState2 = this.mServiceState;
            if (serviceState2 == null || !serviceState2.equals(serviceState)) {
                this.mServiceState = serviceState;
                AndroidTelephonyManagerBridge.this.update(AndroidTelephonyManagerBridge.getTelephonyManager());
            }
        }
    }

    public static AndroidTelephonyManagerBridge create() {
        AndroidTelephonyManagerBridge androidTelephonyManagerBridge = new AndroidTelephonyManagerBridge();
        Runnable lambdaFactory$ = AndroidTelephonyManagerBridge$$Lambda$1.lambdaFactory$(androidTelephonyManagerBridge);
        if (ThreadUtils.runningOnUiThread()) {
            lambdaFactory$.run();
        } else {
            ThreadUtils.getUiThreadHandler().post(lambdaFactory$);
        }
        return androidTelephonyManagerBridge;
    }

    public static AndroidTelephonyManagerBridge getInstance() {
        AndroidTelephonyManagerBridge androidTelephonyManagerBridge = sInstance;
        if (androidTelephonyManagerBridge == null) {
            synchronized (AndroidTelephonyManagerBridge.class) {
                androidTelephonyManagerBridge = sInstance;
                if (androidTelephonyManagerBridge == null) {
                    androidTelephonyManagerBridge = create();
                    sInstance = androidTelephonyManagerBridge;
                }
            }
        }
        return androidTelephonyManagerBridge;
    }

    public static TelephonyManager getTelephonyManager() {
        return (TelephonyManager) ContextUtils.sApplicationContext.getSystemService("phone");
    }

    public static /* synthetic */ void lambda$create$0(AndroidTelephonyManagerBridge androidTelephonyManagerBridge) {
        TelephonyManager telephonyManager = getTelephonyManager();
        if (telephonyManager != null) {
            androidTelephonyManagerBridge.listenTelephonyServiceState(telephonyManager);
        }
    }

    @MainThread
    public final void listenTelephonyServiceState(TelephonyManager telephonyManager) {
        ThreadUtils.assertOnUiThread();
        Listener listener = new Listener(null);
        this.mListener = listener;
        telephonyManager.listen(listener, 1);
    }

    public final void update(TelephonyManager telephonyManager) {
        if (telephonyManager == null) {
            return;
        }
        this.mNetworkCountryIso = telephonyManager.getNetworkCountryIso();
        this.mNetworkOperator = telephonyManager.getNetworkOperator();
        this.mSimOperator = telephonyManager.getSimOperator();
    }
}

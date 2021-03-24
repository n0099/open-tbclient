package aegon.chrome.net;

import aegon.chrome.base.ApplicationStatus;
import aegon.chrome.base.ContextUtils;
import aegon.chrome.base.ThreadUtils;
import aegon.chrome.base.annotations.CalledByNative;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
/* loaded from: classes.dex */
public class AndroidCellularSignalStrength {
    public static final AndroidCellularSignalStrength sInstance = new AndroidCellularSignalStrength();
    public volatile int mSignalLevel = Integer.MIN_VALUE;

    /* loaded from: classes.dex */
    public class CellStateListener extends PhoneStateListener implements ApplicationStatus.ApplicationStateListener {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        public final TelephonyManager mTelephonyManager;

        public CellStateListener() {
            boolean z = ThreadUtils.sThreadAssertsDisabled;
            TelephonyManager telephonyManager = (TelephonyManager) ContextUtils.sApplicationContext.getSystemService("phone");
            this.mTelephonyManager = telephonyManager;
            if (telephonyManager.getSimState() != 5) {
                return;
            }
            ApplicationStatus.registerApplicationStateListener(this);
            this.mTelephonyManager.listen(this, 256);
        }

        @Override // android.telephony.PhoneStateListener
        @TargetApi(23)
        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            try {
                AndroidCellularSignalStrength.this.mSignalLevel = signalStrength.getLevel();
            } catch (SecurityException unused) {
                AndroidCellularSignalStrength.this.mSignalLevel = Integer.MIN_VALUE;
            }
        }
    }

    public AndroidCellularSignalStrength() {
        if (Build.VERSION.SDK_INT < 23) {
            return;
        }
        HandlerThread handlerThread = new HandlerThread("AndroidCellularSignalStrength");
        handlerThread.start();
        new Handler(handlerThread.getLooper()).post(new Runnable() { // from class: aegon.chrome.net.AndroidCellularSignalStrength.1
            @Override // java.lang.Runnable
            public void run() {
                new CellStateListener();
            }
        });
    }

    @CalledByNative
    @TargetApi(23)
    public static int getSignalStrengthLevel() {
        return sInstance.mSignalLevel;
    }
}

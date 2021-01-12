package aegon.chrome.base;

import aegon.chrome.base.annotations.CalledByNative;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
/* loaded from: classes4.dex */
public class PowerMonitor {
    public static final /* synthetic */ boolean $assertionsDisabled = !PowerMonitor.class.desiredAssertionStatus();
    public static PowerMonitor sInstance;
    public boolean mIsBatteryPower;

    @CalledByNative
    public static boolean isBatteryPower() {
        if (sInstance == null) {
            ThreadUtils.assertOnUiThread();
            if (sInstance == null) {
                Context context = ContextUtils.sApplicationContext;
                sInstance = new PowerMonitor();
                Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
                if (registerReceiver != null) {
                    onBatteryChargingChanged(registerReceiver);
                }
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
                intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
                context.registerReceiver(new BroadcastReceiver() { // from class: aegon.chrome.base.PowerMonitor.1
                    @Override // android.content.BroadcastReceiver
                    public void onReceive(Context context2, Intent intent) {
                        PowerMonitor.onBatteryChargingChanged(intent);
                    }
                }, intentFilter);
            }
        }
        return sInstance.mIsBatteryPower;
    }

    public static native void nativeOnBatteryChargingChanged();

    public static void onBatteryChargingChanged(Intent intent) {
        boolean z = true;
        if (!$assertionsDisabled && sInstance == null) {
            throw new AssertionError();
        }
        int intExtra = intent.getIntExtra("plugged", -1);
        sInstance.mIsBatteryPower = (intExtra == 2 || intExtra == 1) ? false : false;
        nativeOnBatteryChargingChanged();
    }
}

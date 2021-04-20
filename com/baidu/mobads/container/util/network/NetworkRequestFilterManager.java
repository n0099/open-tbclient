package com.baidu.mobads.container.util.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.baidu.mobads.container.util.CommonUtils;
import com.baidu.mobads.container.util.RemoteXAdLogger;
import com.baidu.mobads.container.util.SystemUtils;
import java.io.File;
/* loaded from: classes2.dex */
public class NetworkRequestFilterManager {
    public static final String TAG = "NetworkRequestFilterManager";
    public static final String USB_STATE = "android.hardware.usb.action.USB_STATE";
    public static volatile NetworkRequestFilterManager sInstance;
    public Context mContext;
    public boolean mIsAdbDebugConnected;
    public boolean mIsRootChecked;
    public boolean mIsRooted;
    public RemoteXAdLogger mLogger = RemoteXAdLogger.getInstance();
    public BroadcastReceiver mUsbStateChangeReceiver = new BroadcastReceiver() { // from class: com.baidu.mobads.container.util.network.NetworkRequestFilterManager.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            boolean z;
            boolean z2;
            RemoteXAdLogger remoteXAdLogger = NetworkRequestFilterManager.this.mLogger;
            String str = NetworkRequestFilterManager.TAG;
            remoteXAdLogger.d(str, "onReceive: " + intent.getAction());
            boolean z3 = false;
            if (intent.getExtras() != null) {
                z2 = intent.getExtras().getBoolean("connected");
                z = intent.getExtras().getBoolean("adb");
            } else {
                z = false;
                z2 = false;
            }
            NetworkRequestFilterManager networkRequestFilterManager = NetworkRequestFilterManager.this;
            if (networkRequestFilterManager.isAdbDebugEnable(context) && z2 && z) {
                z3 = true;
            }
            networkRequestFilterManager.mIsAdbDebugConnected = z3;
        }
    };

    public NetworkRequestFilterManager(Context context) {
        this.mContext = context.getApplicationContext();
        detectUsbWithBroadcast();
    }

    private void detectUsbWithBroadcast() {
        this.mLogger.d(TAG, "listenUsb: register");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_ATTACHED");
        intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_DETACHED");
        intentFilter.addAction("android.hardware.usb.action.USB_ACCESSORY_ATTACHED");
        intentFilter.addAction("android.hardware.usb.action.USB_ACCESSORY_DETACHED");
        intentFilter.addAction(USB_STATE);
        this.mContext.registerReceiver(this.mUsbStateChangeReceiver, intentFilter);
        this.mLogger.d(TAG, "listenUsb: registered");
    }

    public static NetworkRequestFilterManager getInstance(Context context) {
        if (sInstance == null) {
            synchronized (NetworkRequestFilterManager.class) {
                if (sInstance == null && context != null) {
                    sInstance = new NetworkRequestFilterManager(context);
                }
            }
        }
        return sInstance;
    }

    private String getSuPath() {
        for (String str : System.getenv("PATH").split(":")) {
            String str2 = str + "/su";
            if (new File(str2).exists()) {
                this.mLogger.d(TAG, "path:" + str2 + " is exists");
                return str2;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isAdbDebugEnable(Context context) {
        try {
            return SystemUtils.isAdbEnable(context);
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean isAdbDebugConnected() {
        return this.mIsAdbDebugConnected;
    }

    public boolean isProxyRunning() {
        if (CommonUtils.isWifi(this.mContext)) {
            return !TextUtils.isEmpty(System.getProperty("http.proxyHost"));
        }
        return false;
    }

    public boolean isRooted() {
        if (this.mIsRootChecked) {
            return this.mIsRooted;
        }
        boolean z = getSuPath() != null;
        this.mIsRooted = z;
        this.mIsRootChecked = true;
        return z;
    }
}

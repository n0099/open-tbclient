package com.baidu.searchbox.player.event;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import androidx.annotation.NonNull;
import com.baidu.searchbox.player.BDPlayerConfig;
import com.baidu.searchbox.player.helper.NetUtils;
import com.baidu.searchbox.player.utils.BdBatteryUtils;
import com.baidu.searchbox.player.utils.BdVideoLog;
import com.baidu.searchbox.ui.animview.praise.NetworkMonitor;
/* loaded from: classes4.dex */
public class VideoReceiver extends BroadcastReceiver {
    public static final String ACTION_VOLUME_CHANGED = "android.media.VOLUME_CHANGED_ACTION";
    public static final String TAG = "BdVideoReceiver";
    public boolean mHeadsetConnected;
    public final VideoReceiverListener mListener;
    public NetUtils.NetStatus mLastStatus = NetUtils.NetStatus.NET_DOWN;
    public int mLastVolume = -1;
    public boolean mLastIsCharging = false;

    /* loaded from: classes4.dex */
    public interface VideoReceiverListener {
        void onBatteryChanged(int i);

        void onBatteryChargingChanged(boolean z);

        void onBluetoothHeadsetChanged(boolean z);

        void onConfigurationChanged();

        void onConnectChanged(NetUtils.NetStatus netStatus, NetUtils.NetStatus netStatus2);

        void onHeadsetPlug(boolean z);

        void onScreenStatusChanged(boolean z);

        void onVolumeChanged(int i);
    }

    public VideoReceiver(@NonNull VideoReceiverListener videoReceiverListener) {
        this.mListener = videoReceiverListener;
    }

    private void onVolumeChanged(@NonNull Context context) {
        AudioManager audioManager = (AudioManager) context.getApplicationContext().getSystemService("audio");
        if (audioManager == null) {
            return;
        }
        int i = this.mLastVolume;
        try {
            i = audioManager.getStreamVolume(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (i != this.mLastVolume) {
            this.mLastVolume = i;
            this.mListener.onVolumeChanged(i);
        }
    }

    private void onConnectChanged() {
        BdVideoLog.d("connectivity action");
        if (isInitialStickyBroadcast()) {
            BdVideoLog.d("NetChanged: StickBroadcast");
            return;
        }
        NetUtils.NetStatus netStatus = NetUtils.getNetStatus();
        BdVideoLog.d("onConnectChanged(), Net status " + netStatus);
        this.mListener.onConnectChanged(this.mLastStatus, netStatus);
        this.mLastStatus = netStatus;
    }

    public boolean isBatteryCharging() {
        return this.mLastIsCharging;
    }

    public void unregisterReceiver() {
        BDPlayerConfig.getAppContext().unregisterReceiver(this);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action;
        char c;
        if (intent == null || this.mListener == null || (action = intent.getAction()) == null) {
            return;
        }
        boolean z = true;
        switch (action.hashCode()) {
            case -2128145023:
                if (action.equals("android.intent.action.SCREEN_OFF")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -1940635523:
                if (action.equals("android.media.VOLUME_CHANGED_ACTION")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case -1676458352:
                if (action.equals("android.intent.action.HEADSET_PLUG")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case -1538406691:
                if (action.equals("android.intent.action.BATTERY_CHANGED")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case -1454123155:
                if (action.equals("android.intent.action.SCREEN_ON")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -1172645946:
                if (action.equals(NetworkMonitor.NET_CHANGE_ACTION)) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -549244379:
                if (action.equals("android.media.AUDIO_BECOMING_NOISY")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case -403228793:
                if (action.equals("android.intent.action.CLOSE_SYSTEM_DIALOGS")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 158859398:
                if (action.equals("android.intent.action.CONFIGURATION_CHANGED")) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case 545516589:
                if (action.equals("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                onConnectChanged();
                return;
            case 1:
                BdVideoLog.d("screen off");
                this.mListener.onScreenStatusChanged(true);
                return;
            case 2:
                BdVideoLog.d("screen on");
                this.mListener.onScreenStatusChanged(false);
                return;
            case 3:
                BdVideoLog.d("ACTION_CLOSE_SYSTEM_DIALOGS");
                return;
            case 4:
                if (intent.hasExtra("state")) {
                    BdVideoLog.d("headset " + intent.getIntExtra("state", 0));
                    if (this.mHeadsetConnected && intent.getIntExtra("state", 0) == 0) {
                        BdVideoLog.d("headset plugout");
                        this.mHeadsetConnected = false;
                    } else if (!this.mHeadsetConnected && intent.getIntExtra("state", 0) == 1) {
                        this.mHeadsetConnected = true;
                    }
                    this.mListener.onHeadsetPlug(this.mHeadsetConnected);
                    return;
                }
                return;
            case 5:
                BdVideoLog.d("headset quick ACTION_AUDIO_BECOMING_NOISY");
                this.mListener.onHeadsetPlug(false);
                return;
            case 6:
                int intExtra = intent.getIntExtra("android.bluetooth.profile.extra.STATE", 0);
                if (intExtra == 2) {
                    this.mListener.onBluetoothHeadsetChanged(true);
                    return;
                } else if (intExtra == 0) {
                    this.mListener.onBluetoothHeadsetChanged(false);
                    return;
                } else {
                    return;
                }
            case 7:
                int intExtra2 = (intent.getIntExtra("level", 0) * 100) / intent.getIntExtra("scale", 1);
                BdBatteryUtils.batter_level = intExtra2;
                this.mListener.onBatteryChanged(intExtra2);
                int intExtra3 = intent.getIntExtra("status", -1);
                if (intExtra3 != 2 && intExtra3 != 5) {
                    z = false;
                }
                if (this.mLastIsCharging != z) {
                    this.mLastIsCharging = z;
                    this.mListener.onBatteryChargingChanged(z);
                    return;
                }
                return;
            case '\b':
                onVolumeChanged(context);
                return;
            case '\t':
                this.mListener.onConfigurationChanged();
                return;
            default:
                return;
        }
    }

    public void registerReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(NetworkMonitor.NET_CHANGE_ACTION);
        intentFilter.addAction("android.intent.action.DATE_CHANGED");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        intentFilter.addAction("android.intent.action.DEVICE_STORAGE_LOW");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
        intentFilter.addAction("android.intent.action.HEADSET_PLUG");
        intentFilter.addAction("android.media.AUDIO_BECOMING_NOISY");
        intentFilter.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
        intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
        intentFilter.addAction("android.intent.action.CONFIGURATION_CHANGED");
        Intent registerReceiver = BDPlayerConfig.getAppContext().registerReceiver(this, intentFilter);
        this.mLastStatus = NetUtils.getNetStatus();
        boolean z = false;
        if (registerReceiver.getIntExtra("plugged", 0) != 0) {
            z = true;
        }
        this.mLastIsCharging = z;
    }
}

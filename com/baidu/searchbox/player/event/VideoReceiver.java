package com.baidu.searchbox.player.event;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.BDPlayerConfig;
import com.baidu.searchbox.player.helper.NetUtils;
import com.baidu.searchbox.player.utils.BdBatteryUtils;
import com.baidu.searchbox.player.utils.BdVideoLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class VideoReceiver extends BroadcastReceiver {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ACTION_VOLUME_CHANGED = "android.media.VOLUME_CHANGED_ACTION";
    public static final String TAG = "BdVideoReceiver";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mHeadsetConnected;
    public NetUtils.NetStatus mLastStatus;
    public int mLastVolume;
    public final VideoReceiverListener mListener;

    /* loaded from: classes2.dex */
    public interface VideoReceiverListener {
        void onBatteryChanged(int i);

        void onBluetoothHeadsetChanged(boolean z);

        void onConfigurationChanged();

        void onConnectChanged(NetUtils.NetStatus netStatus, NetUtils.NetStatus netStatus2);

        void onHeadsetPlug(boolean z);

        void onScreenStatusChanged(boolean z);

        void onVolumeChanged(int i);
    }

    public VideoReceiver(@NonNull VideoReceiverListener videoReceiverListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {videoReceiverListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mLastStatus = NetUtils.NetStatus.NET_DOWN;
        this.mLastVolume = -1;
        this.mListener = videoReceiverListener;
    }

    private void onConnectChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
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
    }

    private void onVolumeChanged(@NonNull Context context) {
        AudioManager audioManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, this, context) == null) || (audioManager = (AudioManager) context.getApplicationContext().getSystemService("audio")) == null) {
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

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) || intent == null || this.mListener == null || (action = intent.getAction()) == null) {
            return;
        }
        char c = 65535;
        switch (action.hashCode()) {
            case -2128145023:
                if (action.equals("android.intent.action.SCREEN_OFF")) {
                    c = 1;
                    break;
                }
                break;
            case -1940635523:
                if (action.equals("android.media.VOLUME_CHANGED_ACTION")) {
                    c = '\b';
                    break;
                }
                break;
            case -1676458352:
                if (action.equals("android.intent.action.HEADSET_PLUG")) {
                    c = 4;
                    break;
                }
                break;
            case -1538406691:
                if (action.equals("android.intent.action.BATTERY_CHANGED")) {
                    c = 7;
                    break;
                }
                break;
            case -1454123155:
                if (action.equals("android.intent.action.SCREEN_ON")) {
                    c = 2;
                    break;
                }
                break;
            case -1172645946:
                if (action.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                    c = 0;
                    break;
                }
                break;
            case -549244379:
                if (action.equals("android.media.AUDIO_BECOMING_NOISY")) {
                    c = 5;
                    break;
                }
                break;
            case -403228793:
                if (action.equals("android.intent.action.CLOSE_SYSTEM_DIALOGS")) {
                    c = 3;
                    break;
                }
                break;
            case 158859398:
                if (action.equals("android.intent.action.CONFIGURATION_CHANGED")) {
                    c = '\t';
                    break;
                }
                break;
            case 545516589:
                if (action.equals("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED")) {
                    c = 6;
                    break;
                }
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
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
            BDPlayerConfig.getAppContext().registerReceiver(this, intentFilter);
            this.mLastStatus = NetUtils.getNetStatus();
        }
    }

    public void unregisterReceiver() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            BDPlayerConfig.getAppContext().unregisterReceiver(this);
        }
    }
}

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
import com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes7.dex */
public class VideoReceiver extends BroadcastReceiver {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ACTION_VOLUME_CHANGED = "android.media.VOLUME_CHANGED_ACTION";
    public static String TAG = "BdVideoReceiver";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mHeadsetConnected;
    public NetUtils.NetStatus mLastStatus;
    public int mLastVolume;
    public VideoReceiverListener mListener;

    /* loaded from: classes7.dex */
    public interface VideoReceiverListener {
        void onBatteryChanged(int i2);

        void onBluetoothHeadsetChanged(boolean z);

        void onConnectChanged(NetUtils.NetStatus netStatus, NetUtils.NetStatus netStatus2);

        void onHeadsetPlug(boolean z);

        void onScreenStatusChanged(boolean z);

        void onVolumeChanged(int i2);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(158919002, "Lcom/baidu/searchbox/player/event/VideoReceiver;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(158919002, "Lcom/baidu/searchbox/player/event/VideoReceiver;");
        }
    }

    public VideoReceiver(@NonNull VideoReceiverListener videoReceiverListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {videoReceiverListener};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mLastStatus = NetUtils.NetStatus.NET_DOWN;
        this.mLastVolume = -1;
        this.mListener = videoReceiverListener;
    }

    private void onConnectChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            BdVideoLog.d(TAG, "connectivity action");
            if (isInitialStickyBroadcast()) {
                BdVideoLog.d(TAG, "NetChanged: StickBroadcast");
                return;
            }
            NetUtils.NetStatus netStatus = NetUtils.getNetStatus();
            String str = TAG;
            BdVideoLog.d(str, "net status " + netStatus);
            this.mListener.onConnectChanged(this.mLastStatus, netStatus);
            this.mLastStatus = netStatus;
        }
    }

    private void onVolumeChanged(@NonNull Context context) {
        AudioManager audioManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, this, context) == null) || (audioManager = (AudioManager) context.getApplicationContext().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND)) == null) {
            return;
        }
        int i2 = this.mLastVolume;
        try {
            i2 = audioManager.getStreamVolume(3);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (i2 != this.mLastVolume) {
            this.mLastVolume = i2;
            this.mListener.onVolumeChanged(i2);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) || intent == null || this.mListener == null || (action = intent.getAction()) == null) {
            return;
        }
        char c2 = 65535;
        switch (action.hashCode()) {
            case -2128145023:
                if (action.equals("android.intent.action.SCREEN_OFF")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1940635523:
                if (action.equals(ACTION_VOLUME_CHANGED)) {
                    c2 = '\b';
                    break;
                }
                break;
            case -1676458352:
                if (action.equals("android.intent.action.HEADSET_PLUG")) {
                    c2 = 4;
                    break;
                }
                break;
            case -1538406691:
                if (action.equals("android.intent.action.BATTERY_CHANGED")) {
                    c2 = 7;
                    break;
                }
                break;
            case -1454123155:
                if (action.equals("android.intent.action.SCREEN_ON")) {
                    c2 = 2;
                    break;
                }
                break;
            case -1172645946:
                if (action.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                    c2 = 0;
                    break;
                }
                break;
            case -549244379:
                if (action.equals("android.media.AUDIO_BECOMING_NOISY")) {
                    c2 = 5;
                    break;
                }
                break;
            case -403228793:
                if (action.equals("android.intent.action.CLOSE_SYSTEM_DIALOGS")) {
                    c2 = 3;
                    break;
                }
                break;
            case 545516589:
                if (action.equals("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED")) {
                    c2 = 6;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                onConnectChanged();
                return;
            case 1:
                BdVideoLog.d(TAG, "screen off");
                this.mListener.onScreenStatusChanged(true);
                return;
            case 2:
                BdVideoLog.d(TAG, "screen on");
                this.mListener.onScreenStatusChanged(false);
                return;
            case 3:
                BdVideoLog.d(TAG, "ACTION_CLOSE_SYSTEM_DIALOGS");
                return;
            case 4:
                if (intent.hasExtra("state")) {
                    String str = TAG;
                    BdVideoLog.d(str, "headset " + intent.getIntExtra("state", 0));
                    if (this.mHeadsetConnected && intent.getIntExtra("state", 0) == 0) {
                        BdVideoLog.d(TAG, "headset plugout");
                        this.mHeadsetConnected = false;
                    } else if (!this.mHeadsetConnected && intent.getIntExtra("state", 0) == 1) {
                        this.mHeadsetConnected = true;
                    }
                    this.mListener.onHeadsetPlug(this.mHeadsetConnected);
                    return;
                }
                return;
            case 5:
                BdVideoLog.d(TAG, "headset quick ACTION_AUDIO_BECOMING_NOISY");
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
                int intExtra2 = (intent.getIntExtra(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL, 0) * 100) / intent.getIntExtra("scale", 1);
                BdBatteryUtils.batter_level = intExtra2;
                this.mListener.onBatteryChanged(intExtra2);
                return;
            case '\b':
                onVolumeChanged(context);
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
            intentFilter.addAction(ACTION_VOLUME_CHANGED);
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

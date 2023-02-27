package com.baidu.searchbox.player.event;

import com.baidu.searchbox.player.event.VideoReceiver;
import com.baidu.searchbox.player.helper.NetUtils;
/* loaded from: classes2.dex */
public class SystemEventTrigger extends AbsEventTrigger implements VideoReceiver.VideoReceiverListener {
    public final VideoReceiver mVideoReceiver = new VideoReceiver(this);

    @Override // com.baidu.searchbox.player.event.VideoReceiver.VideoReceiverListener
    public void onConfigurationChanged() {
        triggerEvent(SystemEvent.obtainEvent(SystemEvent.ACTION_CONFIGURATION_CHANGED));
    }

    public void registerReceiver() {
        try {
            this.mVideoReceiver.registerReceiver();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void unregisterReceiver() {
        try {
            this.mVideoReceiver.unregisterReceiver();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.searchbox.player.event.VideoReceiver.VideoReceiverListener
    public void onBatteryChanged(int i) {
        VideoEvent obtainEvent = SystemEvent.obtainEvent(SystemEvent.ACTION_BATTERY_CHANGED);
        obtainEvent.setLogLevel(1);
        obtainEvent.putExtra(4, Integer.valueOf(i));
        triggerEvent(obtainEvent);
    }

    @Override // com.baidu.searchbox.player.event.VideoReceiver.VideoReceiverListener
    public void onBluetoothHeadsetChanged(boolean z) {
        VideoEvent obtainEvent = SystemEvent.obtainEvent(SystemEvent.ACTION_BLUETOOTH_HEADSET);
        obtainEvent.putExtra(6, Boolean.valueOf(z));
        triggerEvent(obtainEvent);
    }

    @Override // com.baidu.searchbox.player.event.VideoReceiver.VideoReceiverListener
    public void onHeadsetPlug(boolean z) {
        VideoEvent obtainEvent = SystemEvent.obtainEvent(SystemEvent.ACTION_HEADSET_PLUG);
        obtainEvent.putExtra(3, Boolean.valueOf(z));
        triggerEvent(obtainEvent);
    }

    @Override // com.baidu.searchbox.player.event.VideoReceiver.VideoReceiverListener
    public void onScreenStatusChanged(boolean z) {
        String str;
        if (z) {
            str = SystemEvent.ACTION_SCREEN_OFF;
        } else {
            str = SystemEvent.ACTION_SCREEN_ON;
        }
        VideoEvent obtainEvent = SystemEvent.obtainEvent(str);
        obtainEvent.putExtra(2, Boolean.valueOf(z));
        triggerEvent(obtainEvent);
    }

    @Override // com.baidu.searchbox.player.event.VideoReceiver.VideoReceiverListener
    public void onVolumeChanged(int i) {
        VideoEvent obtainEvent = SystemEvent.obtainEvent(SystemEvent.ACTION_VOLUME_CHANGED);
        obtainEvent.putExtra(5, Integer.valueOf(i));
        triggerEvent(obtainEvent);
    }

    @Override // com.baidu.searchbox.player.event.VideoReceiver.VideoReceiverListener
    public void onConnectChanged(NetUtils.NetStatus netStatus, NetUtils.NetStatus netStatus2) {
        VideoEvent obtainEvent = SystemEvent.obtainEvent(SystemEvent.ACTION_CONNECT_CHANGED);
        obtainEvent.putExtra(1, netStatus2);
        triggerEvent(obtainEvent);
    }
}

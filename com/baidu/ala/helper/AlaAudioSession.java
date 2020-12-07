package com.baidu.ala.helper;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
/* loaded from: classes9.dex */
public class AlaAudioSession {
    private static final String TAG = AlaAudioSession.class.getSimpleName();
    private Context mContext;
    private boolean isListen = false;
    private AudioManager mAudioManager = null;
    private int bluetoothOp = 0;
    private int bluetoothState = -1;
    private BroadcastReceiver onReceive = new BroadcastReceiver() { // from class: com.baidu.ala.helper.AlaAudioSession.2
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            Log.e(AlaAudioSession.TAG, "onReceive -> action = " + action);
            if ("android.bluetooth.adapter.action.STATE_CHANGED" == action) {
                if (intent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1) == 10) {
                    AlaAudioSession.this.onBlueToothDisconnect();
                }
            } else if ("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED" == action) {
                int intExtra = intent.getIntExtra("android.bluetooth.profile.extra.STATE", -1);
                if (intExtra == 2) {
                    AlaAudioSession.this.onBlueToothConnect();
                } else if (intExtra == 0) {
                    AlaAudioSession.this.onBlueToothDisconnect();
                }
            } else if ("android.intent.action.HEADSET_PLUG" == action && intent.hasExtra("state")) {
                if (intent.getIntExtra("state", -1) == 0) {
                    if (!AlaAudioSession.this.isHeadsetOn(context)) {
                        AlaAudioSession.this.mAudioManager.setSpeakerphoneOn(true);
                    }
                } else if (intent.getIntExtra("state", -1) == 1) {
                    AlaAudioSession.this.mAudioManager.setSpeakerphoneOn(false);
                }
            }
        }
    };

    public AlaAudioSession(Context context) {
        this.mContext = context;
        initAudioManager();
    }

    public void startRTC() {
        updateAudioMode(true);
    }

    public void stopRTC() {
        updateAudioMode(false);
    }

    public void startListen() {
        checkAudioDevices();
        registerListener();
    }

    public void stopListen() {
        unRegisterListener();
    }

    public void onDestroy() {
        updateAudioMode(false);
        unRegisterListener();
    }

    private void initAudioManager() {
        if (this.mContext != null) {
            try {
                if (this.mAudioManager == null) {
                    this.mAudioManager = (AudioManager) this.mContext.getSystemService("audio");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void checkAudioDevices() {
        if (isHeadsetOn(this.mContext)) {
            this.mAudioManager.setSpeakerphoneOn(false);
        } else {
            this.mAudioManager.setSpeakerphoneOn(true);
        }
    }

    private void updateAudioMode(boolean z) {
        try {
            if (z) {
                this.mAudioManager.setMode(3);
            } else {
                this.mAudioManager.setMode(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isHeadsetOn(Context context) {
        AudioDeviceInfo[] devices;
        initAudioManager();
        if (this.mAudioManager == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 23) {
            return this.mAudioManager.isWiredHeadsetOn() || this.mAudioManager.isBluetoothScoOn() || this.mAudioManager.isBluetoothA2dpOn();
        }
        for (AudioDeviceInfo audioDeviceInfo : this.mAudioManager.getDevices(2)) {
            if (audioDeviceInfo.getType() == 3 || audioDeviceInfo.getType() == 4 || audioDeviceInfo.getType() == 8 || audioDeviceInfo.getType() == 7 || audioDeviceInfo.getType() == 11) {
                return true;
            }
        }
        return false;
    }

    private void registerListener() {
        initAudioManager();
        if (!this.isListen) {
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
                intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
                intentFilter.addAction("android.intent.action.HEADSET_PLUG");
                if (this.mAudioManager.isBluetoothScoAvailableOffCall()) {
                    setBluetoothOn(true);
                }
                this.mContext.registerReceiver(this.onReceive, intentFilter);
                this.isListen = true;
                Log.e(TAG, "registerListener ");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void unRegisterListener() {
        if (this.mContext != null && this.isListen) {
            this.isListen = false;
            this.mContext.unregisterReceiver(this.onReceive);
            Log.e(TAG, "unRegisterListener ");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBluetoothOn(boolean z) {
        initAudioManager();
        try {
            if (z) {
                if (this.bluetoothState != 1) {
                    this.bluetoothState = 1;
                    this.mAudioManager.startBluetoothSco();
                    this.mAudioManager.setBluetoothScoOn(true);
                }
            } else if (this.bluetoothState != 0) {
                this.bluetoothState = 0;
                this.mAudioManager.stopBluetoothSco();
                this.mAudioManager.setBluetoothScoOn(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onBlueToothDisconnect() {
        this.bluetoothOp++;
        setBluetoothOn(false);
        if (!this.mAudioManager.isWiredHeadsetOn()) {
            this.mAudioManager.setSpeakerphoneOn(true);
        }
        Log.e(TAG, "onBlueToothDisconnect ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onBlueToothConnect() {
        this.bluetoothOp++;
        final int i = this.bluetoothOp;
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.baidu.ala.helper.AlaAudioSession.1
            @Override // java.lang.Runnable
            public void run() {
                if (i == AlaAudioSession.this.bluetoothOp) {
                    AlaAudioSession.this.setBluetoothOn(true);
                    AlaAudioSession.this.mAudioManager.setSpeakerphoneOn(false);
                }
            }
        }, 1500L);
        Log.e(TAG, "onBlueToothConnect ");
    }
}

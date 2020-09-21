package com.baidu.rtc.utils;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
/* loaded from: classes15.dex */
public class AudioRouteMonitor extends BroadcastReceiver {
    private int mBluetoothOpSeq;
    private a mCallback;
    private Context mContext;

    /* loaded from: classes15.dex */
    public interface a {
        void gq(int i);

        void gr(int i);
    }

    public AudioRouteMonitor(a aVar) {
        this.mCallback = null;
        this.mCallback = aVar;
    }

    public int init(Context context) {
        this.mContext = context;
        if (this.mContext == null) {
            return -1;
        }
        this.mBluetoothOpSeq = 0;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.HEADSET_PLUG");
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        intentFilter.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
        this.mContext.registerReceiver(this, intentFilter);
        try {
            if (BluetoothAdapter.getDefaultAdapter().getProfileConnectionState(1) == 2) {
                this.mCallback.gr(1);
            } else {
                this.mCallback.gr(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (((AudioManager) this.mContext.getSystemService("audio")).isWiredHeadsetOn()) {
            this.mCallback.gq(1);
        } else {
            this.mCallback.gq(0);
        }
        return 0;
    }

    public int uninit() {
        if (this.mContext == null) {
            return -1;
        }
        this.mContext.unregisterReceiver(this);
        this.mContext = null;
        return 0;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if ("android.intent.action.HEADSET_PLUG".equals(action)) {
            if (intent.hasExtra("state")) {
                this.mCallback.gq(intent.getIntExtra("state", 0));
            }
        } else if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(action)) {
            if (intent.getIntExtra("android.bluetooth.adapter.extra.STATE", Integer.MIN_VALUE) == 10) {
                this.mBluetoothOpSeq++;
                this.mCallback.gr(0);
            }
        } else if ("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED".equals(action)) {
            int intExtra = intent.getIntExtra("android.bluetooth.profile.extra.STATE", Integer.MIN_VALUE);
            if (intExtra == 2) {
                this.mBluetoothOpSeq++;
                final int i = this.mBluetoothOpSeq;
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.baidu.rtc.utils.AudioRouteMonitor.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            Thread.sleep(1000L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if (AudioRouteMonitor.this.mBluetoothOpSeq == i) {
                            AudioRouteMonitor.this.mCallback.gr(1);
                        }
                    }
                }, 1000L);
            } else if (intExtra == 0) {
                this.mBluetoothOpSeq++;
                this.mCallback.gr(0);
            }
        }
    }

    public static boolean isBluetoothHeadsetConnected() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        return defaultAdapter != null && defaultAdapter.isEnabled() && defaultAdapter.getProfileConnectionState(1) == 2;
    }
}

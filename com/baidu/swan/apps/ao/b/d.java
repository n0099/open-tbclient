package com.baidu.swan.apps.ao.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes9.dex */
public class d {
    private static d bRL;
    private boolean bRN;
    private AudioManager mAudioManager;
    private final ConcurrentHashMap<String, a> bRM = new ConcurrentHashMap<>();
    private BroadcastReceiver bRO = new BroadcastReceiver() { // from class: com.baidu.swan.apps.ao.b.d.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int i;
            if ("android.media.VOLUME_CHANGED_ACTION".equals(intent.getAction()) && intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) == 3) {
                if (d.this.mAudioManager == null) {
                    d.this.mAudioManager = (AudioManager) com.baidu.swan.apps.w.a.Rk().getSystemService("audio");
                }
                for (Map.Entry entry : d.this.bRM.entrySet()) {
                    if (d.this.mAudioManager != null) {
                        i = d.this.mAudioManager.getStreamVolume(3);
                    } else {
                        i = 0;
                    }
                    ((a) entry.getValue()).gB(i);
                }
            }
        }
    };

    /* loaded from: classes9.dex */
    public interface a {
        void gB(int i);
    }

    private d() {
    }

    public static d acY() {
        if (bRL == null) {
            synchronized (d.class) {
                if (bRL == null) {
                    bRL = new d();
                }
            }
        }
        return bRL;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@NonNull String str, @NonNull a aVar) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this) {
                this.bRM.put(str, aVar);
                if (!this.bRN) {
                    registerReceiver();
                }
                if (com.baidu.swan.apps.b.DEBUG) {
                    Log.d("SystemVolumeManager", "Id = " + str + " listener added, listeners count: " + this.bRM.size());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean ma(@NonNull String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this) {
                a remove = this.bRM.remove(str);
                if (this.bRM.size() == 0 && this.bRN) {
                    unregisterReceiver();
                }
                if (com.baidu.swan.apps.b.DEBUG && remove != null) {
                    Log.d("SystemVolumeManager", "Id = " + str + " listener removed, listeners count: " + this.bRM.size());
                }
                r0 = remove != null;
            }
        }
        return r0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int acZ() {
        if (this.mAudioManager == null) {
            this.mAudioManager = (AudioManager) com.baidu.swan.apps.w.a.Rk().getSystemService("audio");
        }
        if (this.mAudioManager != null) {
            return this.mAudioManager.getStreamMaxVolume(3);
        }
        return 100;
    }

    private void registerReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
        com.baidu.swan.apps.w.a.Rk().registerReceiver(this.bRO, intentFilter);
        this.bRN = true;
    }

    private void unregisterReceiver() {
        try {
            com.baidu.swan.apps.w.a.Rk().unregisterReceiver(this.bRO);
            this.bRN = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void release() {
        if (bRL != null) {
            bRL.Nf();
        }
    }

    private void Nf() {
        synchronized (this) {
            this.bRM.clear();
            this.mAudioManager = null;
            this.bRN = false;
        }
        bRL = null;
    }
}

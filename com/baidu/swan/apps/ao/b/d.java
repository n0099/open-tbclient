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
/* loaded from: classes11.dex */
public class d {
    private static d bWz;
    private boolean bWB;
    private AudioManager mAudioManager;
    private final ConcurrentHashMap<String, a> bWA = new ConcurrentHashMap<>();
    private BroadcastReceiver bWC = new BroadcastReceiver() { // from class: com.baidu.swan.apps.ao.b.d.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int i;
            if ("android.media.VOLUME_CHANGED_ACTION".equals(intent.getAction()) && intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) == 3) {
                if (d.this.mAudioManager == null) {
                    d.this.mAudioManager = (AudioManager) com.baidu.swan.apps.w.a.TU().getSystemService("audio");
                }
                for (Map.Entry entry : d.this.bWA.entrySet()) {
                    if (d.this.mAudioManager != null) {
                        i = d.this.mAudioManager.getStreamVolume(3);
                    } else {
                        i = 0;
                    }
                    ((a) entry.getValue()).gT(i);
                }
            }
        }
    };

    /* loaded from: classes11.dex */
    public interface a {
        void gT(int i);
    }

    private d() {
    }

    public static d afJ() {
        if (bWz == null) {
            synchronized (d.class) {
                if (bWz == null) {
                    bWz = new d();
                }
            }
        }
        return bWz;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@NonNull String str, @NonNull a aVar) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this) {
                this.bWA.put(str, aVar);
                if (!this.bWB) {
                    registerReceiver();
                }
                if (com.baidu.swan.apps.b.DEBUG) {
                    Log.d("SystemVolumeManager", "Id = " + str + " listener added, listeners count: " + this.bWA.size());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean ms(@NonNull String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this) {
                a remove = this.bWA.remove(str);
                if (this.bWA.size() == 0 && this.bWB) {
                    unregisterReceiver();
                }
                if (com.baidu.swan.apps.b.DEBUG && remove != null) {
                    Log.d("SystemVolumeManager", "Id = " + str + " listener removed, listeners count: " + this.bWA.size());
                }
                r0 = remove != null;
            }
        }
        return r0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int afK() {
        if (this.mAudioManager == null) {
            this.mAudioManager = (AudioManager) com.baidu.swan.apps.w.a.TU().getSystemService("audio");
        }
        if (this.mAudioManager != null) {
            return this.mAudioManager.getStreamMaxVolume(3);
        }
        return 100;
    }

    private void registerReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
        com.baidu.swan.apps.w.a.TU().registerReceiver(this.bWC, intentFilter);
        this.bWB = true;
    }

    private void unregisterReceiver() {
        try {
            com.baidu.swan.apps.w.a.TU().unregisterReceiver(this.bWC);
            this.bWB = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void release() {
        if (bWz != null) {
            bWz.PP();
        }
    }

    private void PP() {
        synchronized (this) {
            this.bWA.clear();
            this.mAudioManager = null;
            this.bWB = false;
        }
        bWz = null;
    }
}

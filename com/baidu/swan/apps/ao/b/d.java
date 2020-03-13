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
    private static d bWB;
    private boolean bWD;
    private AudioManager mAudioManager;
    private final ConcurrentHashMap<String, a> bWC = new ConcurrentHashMap<>();
    private BroadcastReceiver bWE = new BroadcastReceiver() { // from class: com.baidu.swan.apps.ao.b.d.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int i;
            if ("android.media.VOLUME_CHANGED_ACTION".equals(intent.getAction()) && intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) == 3) {
                if (d.this.mAudioManager == null) {
                    d.this.mAudioManager = (AudioManager) com.baidu.swan.apps.w.a.TW().getSystemService("audio");
                }
                for (Map.Entry entry : d.this.bWC.entrySet()) {
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

    public static d afL() {
        if (bWB == null) {
            synchronized (d.class) {
                if (bWB == null) {
                    bWB = new d();
                }
            }
        }
        return bWB;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@NonNull String str, @NonNull a aVar) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this) {
                this.bWC.put(str, aVar);
                if (!this.bWD) {
                    registerReceiver();
                }
                if (com.baidu.swan.apps.b.DEBUG) {
                    Log.d("SystemVolumeManager", "Id = " + str + " listener added, listeners count: " + this.bWC.size());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean ms(@NonNull String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this) {
                a remove = this.bWC.remove(str);
                if (this.bWC.size() == 0 && this.bWD) {
                    unregisterReceiver();
                }
                if (com.baidu.swan.apps.b.DEBUG && remove != null) {
                    Log.d("SystemVolumeManager", "Id = " + str + " listener removed, listeners count: " + this.bWC.size());
                }
                r0 = remove != null;
            }
        }
        return r0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int afM() {
        if (this.mAudioManager == null) {
            this.mAudioManager = (AudioManager) com.baidu.swan.apps.w.a.TW().getSystemService("audio");
        }
        if (this.mAudioManager != null) {
            return this.mAudioManager.getStreamMaxVolume(3);
        }
        return 100;
    }

    private void registerReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
        com.baidu.swan.apps.w.a.TW().registerReceiver(this.bWE, intentFilter);
        this.bWD = true;
    }

    private void unregisterReceiver() {
        try {
            com.baidu.swan.apps.w.a.TW().unregisterReceiver(this.bWE);
            this.bWD = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void release() {
        if (bWB != null) {
            bWB.PR();
        }
    }

    private void PR() {
        synchronized (this) {
            this.bWC.clear();
            this.mAudioManager = null;
            this.bWD = false;
        }
        bWB = null;
    }
}

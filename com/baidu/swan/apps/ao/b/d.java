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
    private static d bWM;
    private boolean bWO;
    private AudioManager mAudioManager;
    private final ConcurrentHashMap<String, a> bWN = new ConcurrentHashMap<>();
    private BroadcastReceiver bWP = new BroadcastReceiver() { // from class: com.baidu.swan.apps.ao.b.d.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int i;
            if ("android.media.VOLUME_CHANGED_ACTION".equals(intent.getAction()) && intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) == 3) {
                if (d.this.mAudioManager == null) {
                    d.this.mAudioManager = (AudioManager) com.baidu.swan.apps.w.a.TZ().getSystemService("audio");
                }
                for (Map.Entry entry : d.this.bWN.entrySet()) {
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

    public static d afO() {
        if (bWM == null) {
            synchronized (d.class) {
                if (bWM == null) {
                    bWM = new d();
                }
            }
        }
        return bWM;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@NonNull String str, @NonNull a aVar) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this) {
                this.bWN.put(str, aVar);
                if (!this.bWO) {
                    registerReceiver();
                }
                if (com.baidu.swan.apps.b.DEBUG) {
                    Log.d("SystemVolumeManager", "Id = " + str + " listener added, listeners count: " + this.bWN.size());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean mr(@NonNull String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this) {
                a remove = this.bWN.remove(str);
                if (this.bWN.size() == 0 && this.bWO) {
                    unregisterReceiver();
                }
                if (com.baidu.swan.apps.b.DEBUG && remove != null) {
                    Log.d("SystemVolumeManager", "Id = " + str + " listener removed, listeners count: " + this.bWN.size());
                }
                r0 = remove != null;
            }
        }
        return r0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int afP() {
        if (this.mAudioManager == null) {
            this.mAudioManager = (AudioManager) com.baidu.swan.apps.w.a.TZ().getSystemService("audio");
        }
        if (this.mAudioManager != null) {
            return this.mAudioManager.getStreamMaxVolume(3);
        }
        return 100;
    }

    private void registerReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
        com.baidu.swan.apps.w.a.TZ().registerReceiver(this.bWP, intentFilter);
        this.bWO = true;
    }

    private void unregisterReceiver() {
        try {
            com.baidu.swan.apps.w.a.TZ().unregisterReceiver(this.bWP);
            this.bWO = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void release() {
        if (bWM != null) {
            bWM.PU();
        }
    }

    private void PU() {
        synchronized (this) {
            this.bWN.clear();
            this.mAudioManager = null;
            this.bWO = false;
        }
        bWM = null;
    }
}

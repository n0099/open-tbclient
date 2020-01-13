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
/* loaded from: classes10.dex */
public class d {
    private static d bSv;
    private boolean bSx;
    private AudioManager mAudioManager;
    private final ConcurrentHashMap<String, a> bSw = new ConcurrentHashMap<>();
    private BroadcastReceiver bSy = new BroadcastReceiver() { // from class: com.baidu.swan.apps.ao.b.d.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int i;
            if ("android.media.VOLUME_CHANGED_ACTION".equals(intent.getAction()) && intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) == 3) {
                if (d.this.mAudioManager == null) {
                    d.this.mAudioManager = (AudioManager) com.baidu.swan.apps.w.a.RG().getSystemService("audio");
                }
                for (Map.Entry entry : d.this.bSw.entrySet()) {
                    if (d.this.mAudioManager != null) {
                        i = d.this.mAudioManager.getStreamVolume(3);
                    } else {
                        i = 0;
                    }
                    ((a) entry.getValue()).gC(i);
                }
            }
        }
    };

    /* loaded from: classes10.dex */
    public interface a {
        void gC(int i);
    }

    private d() {
    }

    public static d adv() {
        if (bSv == null) {
            synchronized (d.class) {
                if (bSv == null) {
                    bSv = new d();
                }
            }
        }
        return bSv;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@NonNull String str, @NonNull a aVar) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this) {
                this.bSw.put(str, aVar);
                if (!this.bSx) {
                    registerReceiver();
                }
                if (com.baidu.swan.apps.b.DEBUG) {
                    Log.d("SystemVolumeManager", "Id = " + str + " listener added, listeners count: " + this.bSw.size());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean md(@NonNull String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this) {
                a remove = this.bSw.remove(str);
                if (this.bSw.size() == 0 && this.bSx) {
                    unregisterReceiver();
                }
                if (com.baidu.swan.apps.b.DEBUG && remove != null) {
                    Log.d("SystemVolumeManager", "Id = " + str + " listener removed, listeners count: " + this.bSw.size());
                }
                r0 = remove != null;
            }
        }
        return r0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int adw() {
        if (this.mAudioManager == null) {
            this.mAudioManager = (AudioManager) com.baidu.swan.apps.w.a.RG().getSystemService("audio");
        }
        if (this.mAudioManager != null) {
            return this.mAudioManager.getStreamMaxVolume(3);
        }
        return 100;
    }

    private void registerReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
        com.baidu.swan.apps.w.a.RG().registerReceiver(this.bSy, intentFilter);
        this.bSx = true;
    }

    private void unregisterReceiver() {
        try {
            com.baidu.swan.apps.w.a.RG().unregisterReceiver(this.bSy);
            this.bSx = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void release() {
        if (bSv != null) {
            bSv.NB();
        }
    }

    private void NB() {
        synchronized (this) {
            this.bSw.clear();
            this.mAudioManager = null;
            this.bSx = false;
        }
        bSv = null;
    }
}

package com.baidu.swan.apps.am.b;

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
    private static d cMu;
    private boolean cMw;
    private AudioManager mAudioManager;
    private final ConcurrentHashMap<String, a> cMv = new ConcurrentHashMap<>();
    private BroadcastReceiver cMx = new BroadcastReceiver() { // from class: com.baidu.swan.apps.am.b.d.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int i;
            if ("android.media.VOLUME_CHANGED_ACTION".equals(intent.getAction()) && intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) == 3) {
                if (d.this.mAudioManager == null) {
                    d.this.mAudioManager = (AudioManager) com.baidu.swan.apps.u.a.afX().getSystemService("audio");
                }
                for (Map.Entry entry : d.this.cMv.entrySet()) {
                    if (d.this.mAudioManager != null) {
                        i = d.this.mAudioManager.getStreamVolume(3);
                    } else {
                        i = 0;
                    }
                    ((a) entry.getValue()).hG(i);
                }
            }
        }
    };

    /* loaded from: classes11.dex */
    public interface a {
        void hG(int i);
    }

    private d() {
    }

    public static d atr() {
        if (cMu == null) {
            synchronized (d.class) {
                if (cMu == null) {
                    cMu = new d();
                }
            }
        }
        return cMu;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@NonNull String str, @NonNull a aVar) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this) {
                this.cMv.put(str, aVar);
                if (!this.cMw) {
                    registerReceiver();
                }
                if (com.baidu.swan.apps.b.DEBUG) {
                    Log.d("SystemVolumeManager", "Id = " + str + " listener added, listeners count: " + this.cMv.size());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean pt(@NonNull String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this) {
                a remove = this.cMv.remove(str);
                if (this.cMv.size() == 0 && this.cMw) {
                    unregisterReceiver();
                }
                if (com.baidu.swan.apps.b.DEBUG && remove != null) {
                    Log.d("SystemVolumeManager", "Id = " + str + " listener removed, listeners count: " + this.cMv.size());
                }
                r0 = remove != null;
            }
        }
        return r0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int ats() {
        if (this.mAudioManager == null) {
            this.mAudioManager = (AudioManager) com.baidu.swan.apps.u.a.afX().getSystemService("audio");
        }
        if (this.mAudioManager != null) {
            return this.mAudioManager.getStreamMaxVolume(3);
        }
        return 100;
    }

    private void registerReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
        com.baidu.swan.apps.u.a.afX().registerReceiver(this.cMx, intentFilter);
        this.cMw = true;
    }

    private void unregisterReceiver() {
        try {
            com.baidu.swan.apps.u.a.afX().unregisterReceiver(this.cMx);
            this.cMw = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void release() {
        if (cMu != null) {
            cMu.atp();
        }
    }

    private void atp() {
        synchronized (this) {
            this.cMv.clear();
            this.mAudioManager = null;
            this.cMw = false;
        }
        cMu = null;
    }
}

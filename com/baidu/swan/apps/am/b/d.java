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
/* loaded from: classes7.dex */
public class d {
    private static d cPP;
    private boolean cPR;
    private AudioManager mAudioManager;
    private final ConcurrentHashMap<String, a> cPQ = new ConcurrentHashMap<>();
    private BroadcastReceiver cPS = new BroadcastReceiver() { // from class: com.baidu.swan.apps.am.b.d.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int i;
            if ("android.media.VOLUME_CHANGED_ACTION".equals(intent.getAction()) && intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) == 3) {
                if (d.this.mAudioManager == null) {
                    d.this.mAudioManager = (AudioManager) com.baidu.swan.apps.t.a.ahj().getSystemService("audio");
                }
                for (Map.Entry entry : d.this.cPQ.entrySet()) {
                    if (d.this.mAudioManager != null) {
                        i = d.this.mAudioManager.getStreamVolume(3);
                    } else {
                        i = 0;
                    }
                    ((a) entry.getValue()).hP(i);
                }
            }
        }
    };

    /* loaded from: classes7.dex */
    public interface a {
        void hP(int i);
    }

    private d() {
    }

    public static d avs() {
        if (cPP == null) {
            synchronized (d.class) {
                if (cPP == null) {
                    cPP = new d();
                }
            }
        }
        return cPP;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@NonNull String str, @NonNull a aVar) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this) {
                this.cPQ.put(str, aVar);
                if (!this.cPR) {
                    registerReceiver();
                }
                if (com.baidu.swan.apps.b.DEBUG) {
                    Log.d("SystemVolumeManager", "Id = " + str + " listener added, listeners count: " + this.cPQ.size());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean qe(@NonNull String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this) {
                a remove = this.cPQ.remove(str);
                if (this.cPQ.size() == 0 && this.cPR) {
                    unregisterReceiver();
                }
                if (com.baidu.swan.apps.b.DEBUG && remove != null) {
                    Log.d("SystemVolumeManager", "Id = " + str + " listener removed, listeners count: " + this.cPQ.size());
                }
                r0 = remove != null;
            }
        }
        return r0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int avt() {
        if (this.mAudioManager == null) {
            this.mAudioManager = (AudioManager) com.baidu.swan.apps.t.a.ahj().getSystemService("audio");
        }
        if (this.mAudioManager != null) {
            return this.mAudioManager.getStreamMaxVolume(3);
        }
        return 100;
    }

    private void registerReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
        com.baidu.swan.apps.t.a.ahj().registerReceiver(this.cPS, intentFilter);
        this.cPR = true;
    }

    private void unregisterReceiver() {
        try {
            com.baidu.swan.apps.t.a.ahj().unregisterReceiver(this.cPS);
            this.cPR = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void release() {
        if (cPP != null) {
            cPP.avq();
        }
    }

    private void avq() {
        synchronized (this) {
            this.cPQ.clear();
            this.mAudioManager = null;
            this.cPR = false;
        }
        cPP = null;
    }
}

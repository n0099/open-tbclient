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
    private static d cvD;
    private boolean cvF;
    private AudioManager mAudioManager;
    private final ConcurrentHashMap<String, a> cvE = new ConcurrentHashMap<>();
    private BroadcastReceiver cvG = new BroadcastReceiver() { // from class: com.baidu.swan.apps.ao.b.d.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int i;
            if ("android.media.VOLUME_CHANGED_ACTION".equals(intent.getAction()) && intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) == 3) {
                if (d.this.mAudioManager == null) {
                    d.this.mAudioManager = (AudioManager) com.baidu.swan.apps.w.a.abO().getSystemService("audio");
                }
                for (Map.Entry entry : d.this.cvE.entrySet()) {
                    if (d.this.mAudioManager != null) {
                        i = d.this.mAudioManager.getStreamVolume(3);
                    } else {
                        i = 0;
                    }
                    ((a) entry.getValue()).ha(i);
                }
            }
        }
    };

    /* loaded from: classes11.dex */
    public interface a {
        void ha(int i);
    }

    private d() {
    }

    public static d anT() {
        if (cvD == null) {
            synchronized (d.class) {
                if (cvD == null) {
                    cvD = new d();
                }
            }
        }
        return cvD;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@NonNull String str, @NonNull a aVar) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this) {
                this.cvE.put(str, aVar);
                if (!this.cvF) {
                    registerReceiver();
                }
                if (com.baidu.swan.apps.b.DEBUG) {
                    Log.d("SystemVolumeManager", "Id = " + str + " listener added, listeners count: " + this.cvE.size());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean nE(@NonNull String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this) {
                a remove = this.cvE.remove(str);
                if (this.cvE.size() == 0 && this.cvF) {
                    unregisterReceiver();
                }
                if (com.baidu.swan.apps.b.DEBUG && remove != null) {
                    Log.d("SystemVolumeManager", "Id = " + str + " listener removed, listeners count: " + this.cvE.size());
                }
                r0 = remove != null;
            }
        }
        return r0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int anU() {
        if (this.mAudioManager == null) {
            this.mAudioManager = (AudioManager) com.baidu.swan.apps.w.a.abO().getSystemService("audio");
        }
        if (this.mAudioManager != null) {
            return this.mAudioManager.getStreamMaxVolume(3);
        }
        return 100;
    }

    private void registerReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
        com.baidu.swan.apps.w.a.abO().registerReceiver(this.cvG, intentFilter);
        this.cvF = true;
    }

    private void unregisterReceiver() {
        try {
            com.baidu.swan.apps.w.a.abO().unregisterReceiver(this.cvG);
            this.cvF = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void release() {
        if (cvD != null) {
            cvD.XJ();
        }
    }

    private void XJ() {
        synchronized (this) {
            this.cvE.clear();
            this.mAudioManager = null;
            this.cvF = false;
        }
        cvD = null;
    }
}

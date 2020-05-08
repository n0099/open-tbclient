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
    private static d cvJ;
    private boolean cvL;
    private AudioManager mAudioManager;
    private final ConcurrentHashMap<String, a> cvK = new ConcurrentHashMap<>();
    private BroadcastReceiver cvM = new BroadcastReceiver() { // from class: com.baidu.swan.apps.ao.b.d.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int i;
            if ("android.media.VOLUME_CHANGED_ACTION".equals(intent.getAction()) && intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) == 3) {
                if (d.this.mAudioManager == null) {
                    d.this.mAudioManager = (AudioManager) com.baidu.swan.apps.w.a.abN().getSystemService("audio");
                }
                for (Map.Entry entry : d.this.cvK.entrySet()) {
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

    public static d anS() {
        if (cvJ == null) {
            synchronized (d.class) {
                if (cvJ == null) {
                    cvJ = new d();
                }
            }
        }
        return cvJ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@NonNull String str, @NonNull a aVar) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this) {
                this.cvK.put(str, aVar);
                if (!this.cvL) {
                    registerReceiver();
                }
                if (com.baidu.swan.apps.b.DEBUG) {
                    Log.d("SystemVolumeManager", "Id = " + str + " listener added, listeners count: " + this.cvK.size());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean nE(@NonNull String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this) {
                a remove = this.cvK.remove(str);
                if (this.cvK.size() == 0 && this.cvL) {
                    unregisterReceiver();
                }
                if (com.baidu.swan.apps.b.DEBUG && remove != null) {
                    Log.d("SystemVolumeManager", "Id = " + str + " listener removed, listeners count: " + this.cvK.size());
                }
                r0 = remove != null;
            }
        }
        return r0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int anT() {
        if (this.mAudioManager == null) {
            this.mAudioManager = (AudioManager) com.baidu.swan.apps.w.a.abN().getSystemService("audio");
        }
        if (this.mAudioManager != null) {
            return this.mAudioManager.getStreamMaxVolume(3);
        }
        return 100;
    }

    private void registerReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
        com.baidu.swan.apps.w.a.abN().registerReceiver(this.cvM, intentFilter);
        this.cvL = true;
    }

    private void unregisterReceiver() {
        try {
            com.baidu.swan.apps.w.a.abN().unregisterReceiver(this.cvM);
            this.cvL = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void release() {
        if (cvJ != null) {
            cvJ.XI();
        }
    }

    private void XI() {
        synchronized (this) {
            this.cvK.clear();
            this.mAudioManager = null;
            this.cvL = false;
        }
        cvJ = null;
    }
}

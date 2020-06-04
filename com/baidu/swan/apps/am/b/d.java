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
    private static d cHK;
    private boolean cHM;
    private AudioManager mAudioManager;
    private final ConcurrentHashMap<String, a> cHL = new ConcurrentHashMap<>();
    private BroadcastReceiver cHN = new BroadcastReceiver() { // from class: com.baidu.swan.apps.am.b.d.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int i;
            if ("android.media.VOLUME_CHANGED_ACTION".equals(intent.getAction()) && intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) == 3) {
                if (d.this.mAudioManager == null) {
                    d.this.mAudioManager = (AudioManager) com.baidu.swan.apps.u.a.aeR().getSystemService("audio");
                }
                for (Map.Entry entry : d.this.cHL.entrySet()) {
                    if (d.this.mAudioManager != null) {
                        i = d.this.mAudioManager.getStreamVolume(3);
                    } else {
                        i = 0;
                    }
                    ((a) entry.getValue()).hv(i);
                }
            }
        }
    };

    /* loaded from: classes11.dex */
    public interface a {
        void hv(int i);
    }

    private d() {
    }

    public static d ask() {
        if (cHK == null) {
            synchronized (d.class) {
                if (cHK == null) {
                    cHK = new d();
                }
            }
        }
        return cHK;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@NonNull String str, @NonNull a aVar) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this) {
                this.cHL.put(str, aVar);
                if (!this.cHM) {
                    registerReceiver();
                }
                if (com.baidu.swan.apps.b.DEBUG) {
                    Log.d("SystemVolumeManager", "Id = " + str + " listener added, listeners count: " + this.cHL.size());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean pl(@NonNull String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this) {
                a remove = this.cHL.remove(str);
                if (this.cHL.size() == 0 && this.cHM) {
                    unregisterReceiver();
                }
                if (com.baidu.swan.apps.b.DEBUG && remove != null) {
                    Log.d("SystemVolumeManager", "Id = " + str + " listener removed, listeners count: " + this.cHL.size());
                }
                r0 = remove != null;
            }
        }
        return r0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int asl() {
        if (this.mAudioManager == null) {
            this.mAudioManager = (AudioManager) com.baidu.swan.apps.u.a.aeR().getSystemService("audio");
        }
        if (this.mAudioManager != null) {
            return this.mAudioManager.getStreamMaxVolume(3);
        }
        return 100;
    }

    private void registerReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
        com.baidu.swan.apps.u.a.aeR().registerReceiver(this.cHN, intentFilter);
        this.cHM = true;
    }

    private void unregisterReceiver() {
        try {
            com.baidu.swan.apps.u.a.aeR().unregisterReceiver(this.cHN);
            this.cHM = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void release() {
        if (cHK != null) {
            cHK.asi();
        }
    }

    private void asi() {
        synchronized (this) {
            this.cHL.clear();
            this.mAudioManager = null;
            this.cHM = false;
        }
        cHK = null;
    }
}

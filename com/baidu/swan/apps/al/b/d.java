package com.baidu.swan.apps.al.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.player.event.VideoReceiver;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes8.dex */
public class d {
    private static d cYV;
    private boolean cYX;
    private AudioManager mAudioManager;
    private final ConcurrentHashMap<String, a> cYW = new ConcurrentHashMap<>();
    private BroadcastReceiver cYY = new BroadcastReceiver() { // from class: com.baidu.swan.apps.al.b.d.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int i;
            if (VideoReceiver.ACTION_VOLUME_CHANGED.equals(intent.getAction()) && intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) == 3) {
                if (d.this.mAudioManager == null) {
                    d.this.mAudioManager = (AudioManager) com.baidu.swan.apps.t.a.aoJ().getSystemService("audio");
                }
                for (Map.Entry entry : d.this.cYW.entrySet()) {
                    if (d.this.mAudioManager != null) {
                        i = d.this.mAudioManager.getStreamVolume(3);
                    } else {
                        i = 0;
                    }
                    ((a) entry.getValue()).jY(i);
                }
            }
        }
    };

    /* loaded from: classes8.dex */
    public interface a {
        void jY(int i);
    }

    private d() {
    }

    public static d aDB() {
        if (cYV == null) {
            synchronized (d.class) {
                if (cYV == null) {
                    cYV = new d();
                }
            }
        }
        return cYV;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@NonNull String str, @NonNull a aVar) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this) {
                this.cYW.put(str, aVar);
                if (!this.cYX) {
                    registerReceiver();
                }
                if (com.baidu.swan.apps.b.DEBUG) {
                    Log.d("SystemVolumeManager", "Id = " + str + " listener added, listeners count: " + this.cYW.size());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean sf(@NonNull String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this) {
                a remove = this.cYW.remove(str);
                if (this.cYW.size() == 0 && this.cYX) {
                    unregisterReceiver();
                }
                if (com.baidu.swan.apps.b.DEBUG && remove != null) {
                    Log.d("SystemVolumeManager", "Id = " + str + " listener removed, listeners count: " + this.cYW.size());
                }
                r0 = remove != null;
            }
        }
        return r0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int aDC() {
        if (this.mAudioManager == null) {
            this.mAudioManager = (AudioManager) com.baidu.swan.apps.t.a.aoJ().getSystemService("audio");
        }
        if (this.mAudioManager != null) {
            return this.mAudioManager.getStreamMaxVolume(3);
        }
        return 100;
    }

    private void registerReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(VideoReceiver.ACTION_VOLUME_CHANGED);
        com.baidu.swan.apps.t.a.aoJ().registerReceiver(this.cYY, intentFilter);
        this.cYX = true;
    }

    private void unregisterReceiver() {
        try {
            com.baidu.swan.apps.t.a.aoJ().unregisterReceiver(this.cYY);
            this.cYX = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void release() {
        if (cYV != null) {
            cYV.aDz();
        }
    }

    private void aDz() {
        synchronized (this) {
            this.cYW.clear();
            this.mAudioManager = null;
            this.cYX = false;
        }
        cYV = null;
    }
}

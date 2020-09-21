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
/* loaded from: classes3.dex */
public class d {
    private static d daX;
    private boolean daZ;
    private AudioManager mAudioManager;
    private final ConcurrentHashMap<String, a> daY = new ConcurrentHashMap<>();
    private BroadcastReceiver dba = new BroadcastReceiver() { // from class: com.baidu.swan.apps.al.b.d.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int i;
            if (VideoReceiver.ACTION_VOLUME_CHANGED.equals(intent.getAction()) && intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) == 3) {
                if (d.this.mAudioManager == null) {
                    d.this.mAudioManager = (AudioManager) com.baidu.swan.apps.t.a.apu().getSystemService("audio");
                }
                for (Map.Entry entry : d.this.daY.entrySet()) {
                    if (d.this.mAudioManager != null) {
                        i = d.this.mAudioManager.getStreamVolume(3);
                    } else {
                        i = 0;
                    }
                    ((a) entry.getValue()).kj(i);
                }
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void kj(int i);
    }

    private d() {
    }

    public static d aEl() {
        if (daX == null) {
            synchronized (d.class) {
                if (daX == null) {
                    daX = new d();
                }
            }
        }
        return daX;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@NonNull String str, @NonNull a aVar) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this) {
                this.daY.put(str, aVar);
                if (!this.daZ) {
                    registerReceiver();
                }
                if (com.baidu.swan.apps.b.DEBUG) {
                    Log.d("SystemVolumeManager", "Id = " + str + " listener added, listeners count: " + this.daY.size());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean sz(@NonNull String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this) {
                a remove = this.daY.remove(str);
                if (this.daY.size() == 0 && this.daZ) {
                    unregisterReceiver();
                }
                if (com.baidu.swan.apps.b.DEBUG && remove != null) {
                    Log.d("SystemVolumeManager", "Id = " + str + " listener removed, listeners count: " + this.daY.size());
                }
                r0 = remove != null;
            }
        }
        return r0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int aEm() {
        if (this.mAudioManager == null) {
            this.mAudioManager = (AudioManager) com.baidu.swan.apps.t.a.apu().getSystemService("audio");
        }
        if (this.mAudioManager != null) {
            return this.mAudioManager.getStreamMaxVolume(3);
        }
        return 100;
    }

    private void registerReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(VideoReceiver.ACTION_VOLUME_CHANGED);
        com.baidu.swan.apps.t.a.apu().registerReceiver(this.dba, intentFilter);
        this.daZ = true;
    }

    private void unregisterReceiver() {
        try {
            com.baidu.swan.apps.t.a.apu().unregisterReceiver(this.dba);
            this.daZ = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void release() {
        if (daX != null) {
            daX.aEj();
        }
    }

    private void aEj() {
        synchronized (this) {
            this.daY.clear();
            this.mAudioManager = null;
            this.daZ = false;
        }
        daX = null;
    }
}

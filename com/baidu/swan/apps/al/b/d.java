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
import org.webrtc.MediaStreamTrack;
/* loaded from: classes10.dex */
public class d {
    private static d dBz;
    private boolean dBB;
    private AudioManager mAudioManager;
    private final ConcurrentHashMap<String, a> dBA = new ConcurrentHashMap<>();
    private BroadcastReceiver dBC = new BroadcastReceiver() { // from class: com.baidu.swan.apps.al.b.d.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int i;
            if (VideoReceiver.ACTION_VOLUME_CHANGED.equals(intent.getAction()) && intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) == 3) {
                if (d.this.mAudioManager == null) {
                    d.this.mAudioManager = (AudioManager) com.baidu.swan.apps.t.a.awA().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
                }
                for (Map.Entry entry : d.this.dBA.entrySet()) {
                    if (d.this.mAudioManager != null) {
                        i = d.this.mAudioManager.getStreamVolume(3);
                    } else {
                        i = 0;
                    }
                    ((a) entry.getValue()).lb(i);
                }
            }
        }
    };

    /* loaded from: classes10.dex */
    public interface a {
        void lb(int i);
    }

    private d() {
    }

    public static d aLo() {
        if (dBz == null) {
            synchronized (d.class) {
                if (dBz == null) {
                    dBz = new d();
                }
            }
        }
        return dBz;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@NonNull String str, @NonNull a aVar) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this) {
                this.dBA.put(str, aVar);
                if (!this.dBB) {
                    registerReceiver();
                }
                if (com.baidu.swan.apps.b.DEBUG) {
                    Log.d("SystemVolumeManager", "Id = " + str + " listener added, listeners count: " + this.dBA.size());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean tS(@NonNull String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this) {
                a remove = this.dBA.remove(str);
                if (this.dBA.size() == 0 && this.dBB) {
                    unregisterReceiver();
                }
                if (com.baidu.swan.apps.b.DEBUG && remove != null) {
                    Log.d("SystemVolumeManager", "Id = " + str + " listener removed, listeners count: " + this.dBA.size());
                }
                r0 = remove != null;
            }
        }
        return r0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int aLp() {
        if (this.mAudioManager == null) {
            this.mAudioManager = (AudioManager) com.baidu.swan.apps.t.a.awA().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        }
        if (this.mAudioManager != null) {
            return this.mAudioManager.getStreamMaxVolume(3);
        }
        return 100;
    }

    private void registerReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(VideoReceiver.ACTION_VOLUME_CHANGED);
        com.baidu.swan.apps.t.a.awA().registerReceiver(this.dBC, intentFilter);
        this.dBB = true;
    }

    private void unregisterReceiver() {
        try {
            com.baidu.swan.apps.t.a.awA().unregisterReceiver(this.dBC);
            this.dBB = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void release() {
        if (dBz != null) {
            dBz.aLm();
        }
    }

    private void aLm() {
        synchronized (this) {
            this.dBA.clear();
            this.mAudioManager = null;
            this.dBB = false;
        }
        dBz = null;
    }
}

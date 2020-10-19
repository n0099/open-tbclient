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
    private static d dnf;
    private boolean dnh;
    private AudioManager mAudioManager;
    private final ConcurrentHashMap<String, a> dng = new ConcurrentHashMap<>();
    private BroadcastReceiver dni = new BroadcastReceiver() { // from class: com.baidu.swan.apps.al.b.d.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int i;
            if (VideoReceiver.ACTION_VOLUME_CHANGED.equals(intent.getAction()) && intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) == 3) {
                if (d.this.mAudioManager == null) {
                    d.this.mAudioManager = (AudioManager) com.baidu.swan.apps.t.a.asf().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
                }
                for (Map.Entry entry : d.this.dng.entrySet()) {
                    if (d.this.mAudioManager != null) {
                        i = d.this.mAudioManager.getStreamVolume(3);
                    } else {
                        i = 0;
                    }
                    ((a) entry.getValue()).kG(i);
                }
            }
        }
    };

    /* loaded from: classes10.dex */
    public interface a {
        void kG(int i);
    }

    private d() {
    }

    public static d aGU() {
        if (dnf == null) {
            synchronized (d.class) {
                if (dnf == null) {
                    dnf = new d();
                }
            }
        }
        return dnf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@NonNull String str, @NonNull a aVar) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this) {
                this.dng.put(str, aVar);
                if (!this.dnh) {
                    registerReceiver();
                }
                if (com.baidu.swan.apps.b.DEBUG) {
                    Log.d("SystemVolumeManager", "Id = " + str + " listener added, listeners count: " + this.dng.size());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean tl(@NonNull String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this) {
                a remove = this.dng.remove(str);
                if (this.dng.size() == 0 && this.dnh) {
                    unregisterReceiver();
                }
                if (com.baidu.swan.apps.b.DEBUG && remove != null) {
                    Log.d("SystemVolumeManager", "Id = " + str + " listener removed, listeners count: " + this.dng.size());
                }
                r0 = remove != null;
            }
        }
        return r0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int aGV() {
        if (this.mAudioManager == null) {
            this.mAudioManager = (AudioManager) com.baidu.swan.apps.t.a.asf().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        }
        if (this.mAudioManager != null) {
            return this.mAudioManager.getStreamMaxVolume(3);
        }
        return 100;
    }

    private void registerReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(VideoReceiver.ACTION_VOLUME_CHANGED);
        com.baidu.swan.apps.t.a.asf().registerReceiver(this.dni, intentFilter);
        this.dnh = true;
    }

    private void unregisterReceiver() {
        try {
            com.baidu.swan.apps.t.a.asf().unregisterReceiver(this.dni);
            this.dnh = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void release() {
        if (dnf != null) {
            dnf.aGS();
        }
    }

    private void aGS() {
        synchronized (this) {
            this.dng.clear();
            this.mAudioManager = null;
            this.dnh = false;
        }
        dnf = null;
    }
}

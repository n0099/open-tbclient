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
    private static d dvH;
    private boolean dvJ;
    private AudioManager mAudioManager;
    private final ConcurrentHashMap<String, a> dvI = new ConcurrentHashMap<>();
    private BroadcastReceiver dvK = new BroadcastReceiver() { // from class: com.baidu.swan.apps.al.b.d.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int i;
            if (VideoReceiver.ACTION_VOLUME_CHANGED.equals(intent.getAction()) && intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) == 3) {
                if (d.this.mAudioManager == null) {
                    d.this.mAudioManager = (AudioManager) com.baidu.swan.apps.t.a.aua().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
                }
                for (Map.Entry entry : d.this.dvI.entrySet()) {
                    if (d.this.mAudioManager != null) {
                        i = d.this.mAudioManager.getStreamVolume(3);
                    } else {
                        i = 0;
                    }
                    ((a) entry.getValue()).kR(i);
                }
            }
        }
    };

    /* loaded from: classes10.dex */
    public interface a {
        void kR(int i);
    }

    private d() {
    }

    public static d aIO() {
        if (dvH == null) {
            synchronized (d.class) {
                if (dvH == null) {
                    dvH = new d();
                }
            }
        }
        return dvH;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@NonNull String str, @NonNull a aVar) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this) {
                this.dvI.put(str, aVar);
                if (!this.dvJ) {
                    registerReceiver();
                }
                if (com.baidu.swan.apps.b.DEBUG) {
                    Log.d("SystemVolumeManager", "Id = " + str + " listener added, listeners count: " + this.dvI.size());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean tE(@NonNull String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this) {
                a remove = this.dvI.remove(str);
                if (this.dvI.size() == 0 && this.dvJ) {
                    unregisterReceiver();
                }
                if (com.baidu.swan.apps.b.DEBUG && remove != null) {
                    Log.d("SystemVolumeManager", "Id = " + str + " listener removed, listeners count: " + this.dvI.size());
                }
                r0 = remove != null;
            }
        }
        return r0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int aIP() {
        if (this.mAudioManager == null) {
            this.mAudioManager = (AudioManager) com.baidu.swan.apps.t.a.aua().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        }
        if (this.mAudioManager != null) {
            return this.mAudioManager.getStreamMaxVolume(3);
        }
        return 100;
    }

    private void registerReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(VideoReceiver.ACTION_VOLUME_CHANGED);
        com.baidu.swan.apps.t.a.aua().registerReceiver(this.dvK, intentFilter);
        this.dvJ = true;
    }

    private void unregisterReceiver() {
        try {
            com.baidu.swan.apps.t.a.aua().unregisterReceiver(this.dvK);
            this.dvJ = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void release() {
        if (dvH != null) {
            dvH.aIM();
        }
    }

    private void aIM() {
        synchronized (this) {
            this.dvI.clear();
            this.mAudioManager = null;
            this.dvJ = false;
        }
        dvH = null;
    }
}

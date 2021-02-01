package com.baidu.swan.apps.ak.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.player.event.VideoReceiver;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes9.dex */
public class d {
    private static d dMN;
    private final ConcurrentHashMap<String, a> dMO = new ConcurrentHashMap<>();
    private BroadcastReceiver dMP = new BroadcastReceiver() { // from class: com.baidu.swan.apps.ak.b.d.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int i;
            if (VideoReceiver.ACTION_VOLUME_CHANGED.equals(intent.getAction()) && intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) == 3) {
                if (d.this.mAudioManager == null) {
                    d.this.mAudioManager = (AudioManager) com.baidu.swan.apps.t.a.awW().getSystemService("audio");
                }
                for (Map.Entry entry : d.this.dMO.entrySet()) {
                    if (d.this.mAudioManager != null) {
                        i = d.this.mAudioManager.getStreamVolume(3);
                    } else {
                        i = 0;
                    }
                    ((a) entry.getValue()).jX(i);
                }
            }
        }
    };
    private AudioManager mAudioManager;
    private boolean mIsRegistered;

    /* loaded from: classes9.dex */
    public interface a {
        void jX(int i);
    }

    private d() {
    }

    public static d aMD() {
        if (dMN == null) {
            synchronized (d.class) {
                if (dMN == null) {
                    dMN = new d();
                }
            }
        }
        return dMN;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@NonNull String str, @NonNull a aVar) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this) {
                this.dMO.put(str, aVar);
                if (!this.mIsRegistered) {
                    registerReceiver();
                }
                if (com.baidu.swan.apps.b.DEBUG) {
                    Log.d("SystemVolumeManager", "Id = " + str + " listener added, listeners count: " + this.dMO.size());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean tz(@NonNull String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this) {
                a remove = this.dMO.remove(str);
                if (this.dMO.size() == 0 && this.mIsRegistered) {
                    unregisterReceiver();
                }
                if (com.baidu.swan.apps.b.DEBUG && remove != null) {
                    Log.d("SystemVolumeManager", "Id = " + str + " listener removed, listeners count: " + this.dMO.size());
                }
                r0 = remove != null;
            }
        }
        return r0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int aME() {
        if (this.mAudioManager == null) {
            this.mAudioManager = (AudioManager) com.baidu.swan.apps.t.a.awW().getSystemService("audio");
        }
        if (this.mAudioManager != null) {
            return this.mAudioManager.getStreamMaxVolume(3);
        }
        return 100;
    }

    private void registerReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(VideoReceiver.ACTION_VOLUME_CHANGED);
        com.baidu.swan.apps.t.a.awW().registerReceiver(this.dMP, intentFilter);
        this.mIsRegistered = true;
    }

    private void unregisterReceiver() {
        try {
            com.baidu.swan.apps.t.a.awW().unregisterReceiver(this.dMP);
            this.mIsRegistered = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void release() {
        if (dMN != null) {
            dMN.aMB();
        }
    }

    private void aMB() {
        synchronized (this) {
            this.dMO.clear();
            this.mAudioManager = null;
            this.mIsRegistered = false;
        }
        dMN = null;
    }
}

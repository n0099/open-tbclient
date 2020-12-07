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
/* loaded from: classes25.dex */
public class d {
    private static d dGR;
    private final ConcurrentHashMap<String, a> dGS = new ConcurrentHashMap<>();
    private BroadcastReceiver dGT = new BroadcastReceiver() { // from class: com.baidu.swan.apps.al.b.d.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int i;
            if (VideoReceiver.ACTION_VOLUME_CHANGED.equals(intent.getAction()) && intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) == 3) {
                if (d.this.mAudioManager == null) {
                    d.this.mAudioManager = (AudioManager) com.baidu.swan.apps.t.a.aza().getSystemService("audio");
                }
                for (Map.Entry entry : d.this.dGS.entrySet()) {
                    if (d.this.mAudioManager != null) {
                        i = d.this.mAudioManager.getStreamVolume(3);
                    } else {
                        i = 0;
                    }
                    ((a) entry.getValue()).lv(i);
                }
            }
        }
    };
    private AudioManager mAudioManager;
    private boolean mIsRegistered;

    /* loaded from: classes25.dex */
    public interface a {
        void lv(int i);
    }

    private d() {
    }

    public static d aNN() {
        if (dGR == null) {
            synchronized (d.class) {
                if (dGR == null) {
                    dGR = new d();
                }
            }
        }
        return dGR;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@NonNull String str, @NonNull a aVar) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this) {
                this.dGS.put(str, aVar);
                if (!this.mIsRegistered) {
                    registerReceiver();
                }
                if (com.baidu.swan.apps.b.DEBUG) {
                    Log.d("SystemVolumeManager", "Id = " + str + " listener added, listeners count: " + this.dGS.size());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean uu(@NonNull String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this) {
                a remove = this.dGS.remove(str);
                if (this.dGS.size() == 0 && this.mIsRegistered) {
                    unregisterReceiver();
                }
                if (com.baidu.swan.apps.b.DEBUG && remove != null) {
                    Log.d("SystemVolumeManager", "Id = " + str + " listener removed, listeners count: " + this.dGS.size());
                }
                r0 = remove != null;
            }
        }
        return r0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int aNO() {
        if (this.mAudioManager == null) {
            this.mAudioManager = (AudioManager) com.baidu.swan.apps.t.a.aza().getSystemService("audio");
        }
        if (this.mAudioManager != null) {
            return this.mAudioManager.getStreamMaxVolume(3);
        }
        return 100;
    }

    private void registerReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(VideoReceiver.ACTION_VOLUME_CHANGED);
        com.baidu.swan.apps.t.a.aza().registerReceiver(this.dGT, intentFilter);
        this.mIsRegistered = true;
    }

    private void unregisterReceiver() {
        try {
            com.baidu.swan.apps.t.a.aza().unregisterReceiver(this.dGT);
            this.mIsRegistered = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void release() {
        if (dGR != null) {
            dGR.aNL();
        }
    }

    private void aNL() {
        synchronized (this) {
            this.dGS.clear();
            this.mAudioManager = null;
            this.mIsRegistered = false;
        }
        dGR = null;
    }
}

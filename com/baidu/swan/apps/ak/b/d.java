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
    private static d dPv;
    private final ConcurrentHashMap<String, a> dPw = new ConcurrentHashMap<>();
    private BroadcastReceiver dPx = new BroadcastReceiver() { // from class: com.baidu.swan.apps.ak.b.d.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int i;
            if (VideoReceiver.ACTION_VOLUME_CHANGED.equals(intent.getAction()) && intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) == 3) {
                if (d.this.mAudioManager == null) {
                    d.this.mAudioManager = (AudioManager) com.baidu.swan.apps.t.a.aAr().getSystemService("audio");
                }
                for (Map.Entry entry : d.this.dPw.entrySet()) {
                    if (d.this.mAudioManager != null) {
                        i = d.this.mAudioManager.getStreamVolume(3);
                    } else {
                        i = 0;
                    }
                    ((a) entry.getValue()).lA(i);
                }
            }
        }
    };
    private AudioManager mAudioManager;
    private boolean mIsRegistered;

    /* loaded from: classes9.dex */
    public interface a {
        void lA(int i);
    }

    private d() {
    }

    public static d aQd() {
        if (dPv == null) {
            synchronized (d.class) {
                if (dPv == null) {
                    dPv = new d();
                }
            }
        }
        return dPv;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@NonNull String str, @NonNull a aVar) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this) {
                this.dPw.put(str, aVar);
                if (!this.mIsRegistered) {
                    registerReceiver();
                }
                if (com.baidu.swan.apps.b.DEBUG) {
                    Log.d("SystemVolumeManager", "Id = " + str + " listener added, listeners count: " + this.dPw.size());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean ur(@NonNull String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this) {
                a remove = this.dPw.remove(str);
                if (this.dPw.size() == 0 && this.mIsRegistered) {
                    unregisterReceiver();
                }
                if (com.baidu.swan.apps.b.DEBUG && remove != null) {
                    Log.d("SystemVolumeManager", "Id = " + str + " listener removed, listeners count: " + this.dPw.size());
                }
                r0 = remove != null;
            }
        }
        return r0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int aQe() {
        if (this.mAudioManager == null) {
            this.mAudioManager = (AudioManager) com.baidu.swan.apps.t.a.aAr().getSystemService("audio");
        }
        if (this.mAudioManager != null) {
            return this.mAudioManager.getStreamMaxVolume(3);
        }
        return 100;
    }

    private void registerReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(VideoReceiver.ACTION_VOLUME_CHANGED);
        com.baidu.swan.apps.t.a.aAr().registerReceiver(this.dPx, intentFilter);
        this.mIsRegistered = true;
    }

    private void unregisterReceiver() {
        try {
            com.baidu.swan.apps.t.a.aAr().unregisterReceiver(this.dPx);
            this.mIsRegistered = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void release() {
        if (dPv != null) {
            dPv.aQb();
        }
    }

    private void aQb() {
        synchronized (this) {
            this.dPw.clear();
            this.mAudioManager = null;
            this.mIsRegistered = false;
        }
        dPv = null;
    }
}

package com.baidu.swan.games.audio.b;

import android.media.MediaMetadataRetriever;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.swan.games.audio.b.a;
import com.baidu.swan.games.audio.f;
import com.baidu.swan.nalib.audio.SwanAudioPlayer;
import java.net.MalformedURLException;
import java.util.HashMap;
/* loaded from: classes25.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile b dWC;
    private HandlerThread dWG;
    private SwanAudioPlayer dWH;
    private Handler mHandler;
    private HashMap<String, Long> dWE = new HashMap<>();
    private String dWF = f.aVk();
    private com.baidu.swan.games.audio.a.b dWD = new com.baidu.swan.games.audio.a.b(this.dWF);

    static {
        com.baidu.swan.games.utils.so.d.bam();
    }

    private b() {
        aVr();
        aVs().post(new Runnable() { // from class: com.baidu.swan.games.audio.b.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.dWH = SwanAudioPlayer.getInstance();
                SwanAudioPlayer.settingNativeAudioParameters(AppRuntime.getApplication());
            }
        });
    }

    public static b aVq() {
        if (dWC == null) {
            synchronized (b.class) {
                if (dWC == null) {
                    dWC = new b();
                }
            }
        }
        return dWC;
    }

    private void aVr() {
        if (this.dWG == null) {
            this.dWG = new HandlerThread("audio_thread");
            this.dWG.start();
            this.mHandler = new Handler(this.dWG.getLooper());
        }
    }

    public Handler aVs() {
        return this.mHandler;
    }

    public void a(String str, com.baidu.swan.games.audio.a.a aVar) {
        this.dWD.a(str, aVar);
    }

    public String wR(String str) throws MalformedURLException {
        return this.dWF + f.wM(str);
    }

    public synchronized c al(String str, boolean z) {
        if (DEBUG) {
            Log.e("AudioPlayerManager", "create media player src = " + str);
        }
        return new d();
    }

    public long wS(String str) {
        if (this.dWE.containsKey(str)) {
            return this.dWE.get(str).longValue();
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(str);
                long parseLong = Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
                mediaMetadataRetriever.release();
                this.dWE.put(str, Long.valueOf(parseLong));
                return parseLong;
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
                mediaMetadataRetriever.release();
                return 0L;
            }
        } finally {
            mediaMetadataRetriever.release();
        }
    }

    public void pauseAll() {
        if (this.dWH != null) {
            aVs().postDelayed(new Runnable() { // from class: com.baidu.swan.games.audio.b.b.2
                @Override // java.lang.Runnable
                public void run() {
                    b.this.dWH.pauseAll();
                }
            }, 50L);
        }
    }

    public void onResume() {
        if (this.dWH != null) {
            aVs().post(new Runnable() { // from class: com.baidu.swan.games.audio.b.b.3
                @Override // java.lang.Runnable
                public void run() {
                    b.this.dWH.resume();
                }
            });
        }
    }

    public boolean aVt() {
        if (this.dWH != null) {
            this.dWH.isAudioPlayer();
            return false;
        }
        return false;
    }

    public void a(JsArrayBuffer jsArrayBuffer, a.InterfaceC0536a interfaceC0536a) {
        a.aVp().a(jsArrayBuffer, interfaceC0536a);
    }
}

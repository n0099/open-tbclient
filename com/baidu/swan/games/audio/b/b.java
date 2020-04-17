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
/* loaded from: classes11.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile b cJy;
    private HandlerThread cJC;
    private SwanAudioPlayer cJD;
    private Handler mHandler;
    private HashMap<String, Long> cJA = new HashMap<>();
    private String cJB = f.atM();
    private com.baidu.swan.games.audio.a.b cJz = new com.baidu.swan.games.audio.a.b(this.cJB);

    static {
        com.baidu.swan.games.utils.so.d.ayx();
    }

    private b() {
        atT();
        atU().post(new Runnable() { // from class: com.baidu.swan.games.audio.b.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.cJD = SwanAudioPlayer.getInstance();
                SwanAudioPlayer.settingNativeAudioParameters(AppRuntime.getApplication());
            }
        });
    }

    public static b atS() {
        if (cJy == null) {
            synchronized (b.class) {
                if (cJy == null) {
                    cJy = new b();
                }
            }
        }
        return cJy;
    }

    private void atT() {
        if (this.cJC == null) {
            this.cJC = new HandlerThread("audio_thread");
            this.cJC.start();
            this.mHandler = new Handler(this.cJC.getLooper());
        }
    }

    public Handler atU() {
        return this.mHandler;
    }

    public void a(String str, com.baidu.swan.games.audio.a.a aVar) {
        this.cJz.a(str, aVar);
    }

    public String pE(String str) throws MalformedURLException {
        return this.cJB + f.pz(str);
    }

    public synchronized c L(String str, boolean z) {
        if (DEBUG) {
            Log.e("AudioPlayerManager", "create media player src = " + str);
        }
        return new d();
    }

    public long pF(String str) {
        if (this.cJA.containsKey(str)) {
            return this.cJA.get(str).longValue();
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(str);
                long parseLong = Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
                mediaMetadataRetriever.release();
                this.cJA.put(str, Long.valueOf(parseLong));
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
        if (this.cJD != null) {
            atU().postDelayed(new Runnable() { // from class: com.baidu.swan.games.audio.b.b.2
                @Override // java.lang.Runnable
                public void run() {
                    b.this.cJD.pauseAll();
                }
            }, 50L);
        }
    }

    public void onResume() {
        if (this.cJD != null) {
            atU().post(new Runnable() { // from class: com.baidu.swan.games.audio.b.b.3
                @Override // java.lang.Runnable
                public void run() {
                    b.this.cJD.resume();
                }
            });
        }
    }

    public boolean atV() {
        if (this.cJD != null) {
            this.cJD.isAudioPlayer();
            return false;
        }
        return false;
    }

    public void a(JsArrayBuffer jsArrayBuffer, a.InterfaceC0360a interfaceC0360a) {
        a.atR().a(jsArrayBuffer, interfaceC0360a);
    }
}

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
    private static volatile b cJE;
    private HandlerThread cJI;
    private SwanAudioPlayer cJJ;
    private Handler mHandler;
    private HashMap<String, Long> cJG = new HashMap<>();
    private String cJH = f.atM();
    private com.baidu.swan.games.audio.a.b cJF = new com.baidu.swan.games.audio.a.b(this.cJH);

    static {
        com.baidu.swan.games.utils.so.d.ayx();
    }

    private b() {
        atT();
        atU().post(new Runnable() { // from class: com.baidu.swan.games.audio.b.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.cJJ = SwanAudioPlayer.getInstance();
                SwanAudioPlayer.settingNativeAudioParameters(AppRuntime.getApplication());
            }
        });
    }

    public static b atS() {
        if (cJE == null) {
            synchronized (b.class) {
                if (cJE == null) {
                    cJE = new b();
                }
            }
        }
        return cJE;
    }

    private void atT() {
        if (this.cJI == null) {
            this.cJI = new HandlerThread("audio_thread");
            this.cJI.start();
            this.mHandler = new Handler(this.cJI.getLooper());
        }
    }

    public Handler atU() {
        return this.mHandler;
    }

    public void a(String str, com.baidu.swan.games.audio.a.a aVar) {
        this.cJF.a(str, aVar);
    }

    public String pE(String str) throws MalformedURLException {
        return this.cJH + f.pz(str);
    }

    public synchronized c L(String str, boolean z) {
        if (DEBUG) {
            Log.e("AudioPlayerManager", "create media player src = " + str);
        }
        return new d();
    }

    public long pF(String str) {
        if (this.cJG.containsKey(str)) {
            return this.cJG.get(str).longValue();
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(str);
                long parseLong = Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
                mediaMetadataRetriever.release();
                this.cJG.put(str, Long.valueOf(parseLong));
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
        if (this.cJJ != null) {
            atU().postDelayed(new Runnable() { // from class: com.baidu.swan.games.audio.b.b.2
                @Override // java.lang.Runnable
                public void run() {
                    b.this.cJJ.pauseAll();
                }
            }, 50L);
        }
    }

    public void onResume() {
        if (this.cJJ != null) {
            atU().post(new Runnable() { // from class: com.baidu.swan.games.audio.b.b.3
                @Override // java.lang.Runnable
                public void run() {
                    b.this.cJJ.resume();
                }
            });
        }
    }

    public boolean atV() {
        if (this.cJJ != null) {
            this.cJJ.isAudioPlayer();
            return false;
        }
        return false;
    }

    public void a(JsArrayBuffer jsArrayBuffer, a.InterfaceC0381a interfaceC0381a) {
        a.atR().a(jsArrayBuffer, interfaceC0381a);
    }
}

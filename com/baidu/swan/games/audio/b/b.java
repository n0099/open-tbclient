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
/* loaded from: classes7.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile b deG;
    private HandlerThread deK;
    private SwanAudioPlayer deL;
    private Handler mHandler;
    private HashMap<String, Long> deI = new HashMap<>();
    private String deJ = f.aCk();
    private com.baidu.swan.games.audio.a.b deH = new com.baidu.swan.games.audio.a.b(this.deJ);

    static {
        com.baidu.swan.games.utils.so.d.aHj();
    }

    private b() {
        aCr();
        aCs().post(new Runnable() { // from class: com.baidu.swan.games.audio.b.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.deL = SwanAudioPlayer.getInstance();
                SwanAudioPlayer.settingNativeAudioParameters(AppRuntime.getApplication());
            }
        });
    }

    public static b aCq() {
        if (deG == null) {
            synchronized (b.class) {
                if (deG == null) {
                    deG = new b();
                }
            }
        }
        return deG;
    }

    private void aCr() {
        if (this.deK == null) {
            this.deK = new HandlerThread("audio_thread");
            this.deK.start();
            this.mHandler = new Handler(this.deK.getLooper());
        }
    }

    public Handler aCs() {
        return this.mHandler;
    }

    public void a(String str, com.baidu.swan.games.audio.a.a aVar) {
        this.deH.a(str, aVar);
    }

    public String sk(String str) throws MalformedURLException {
        return this.deJ + f.sf(str);
    }

    public synchronized c Z(String str, boolean z) {
        if (DEBUG) {
            Log.e("AudioPlayerManager", "create media player src = " + str);
        }
        return new d();
    }

    public long sl(String str) {
        if (this.deI.containsKey(str)) {
            return this.deI.get(str).longValue();
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(str);
                long parseLong = Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
                mediaMetadataRetriever.release();
                this.deI.put(str, Long.valueOf(parseLong));
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
        if (this.deL != null) {
            aCs().postDelayed(new Runnable() { // from class: com.baidu.swan.games.audio.b.b.2
                @Override // java.lang.Runnable
                public void run() {
                    b.this.deL.pauseAll();
                }
            }, 50L);
        }
    }

    public void onResume() {
        if (this.deL != null) {
            aCs().post(new Runnable() { // from class: com.baidu.swan.games.audio.b.b.3
                @Override // java.lang.Runnable
                public void run() {
                    b.this.deL.resume();
                }
            });
        }
    }

    public boolean aCt() {
        if (this.deL != null) {
            this.deL.isAudioPlayer();
            return false;
        }
        return false;
    }

    public void a(JsArrayBuffer jsArrayBuffer, a.InterfaceC0440a interfaceC0440a) {
        a.aCp().a(jsArrayBuffer, interfaceC0440a);
    }
}

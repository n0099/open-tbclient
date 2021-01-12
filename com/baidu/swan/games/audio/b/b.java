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
/* loaded from: classes8.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile b eaN;
    private HandlerThread eaR;
    private SwanAudioPlayer eaS;
    private Handler mHandler;
    private HashMap<String, Long> eaP = new HashMap<>();
    private String eaQ = f.aTL();
    private com.baidu.swan.games.audio.a.b eaO = new com.baidu.swan.games.audio.a.b(this.eaQ);

    static {
        com.baidu.swan.games.utils.so.d.aYN();
    }

    private b() {
        aTS();
        aTT().post(new Runnable() { // from class: com.baidu.swan.games.audio.b.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.eaS = SwanAudioPlayer.getInstance();
                SwanAudioPlayer.settingNativeAudioParameters(AppRuntime.getApplication());
            }
        });
    }

    public static b aTR() {
        if (eaN == null) {
            synchronized (b.class) {
                if (eaN == null) {
                    eaN = new b();
                }
            }
        }
        return eaN;
    }

    private void aTS() {
        if (this.eaR == null) {
            this.eaR = new HandlerThread("audio_thread");
            this.eaR.start();
            this.mHandler = new Handler(this.eaR.getLooper());
        }
    }

    public Handler aTT() {
        return this.mHandler;
    }

    public void a(String str, com.baidu.swan.games.audio.a.a aVar) {
        this.eaO.a(str, aVar);
    }

    public String vF(String str) throws MalformedURLException {
        return this.eaQ + f.vA(str);
    }

    public synchronized c al(String str, boolean z) {
        if (DEBUG) {
            Log.e("AudioPlayerManager", "create media player src = " + str);
        }
        return new d();
    }

    public long vG(String str) {
        if (this.eaP.containsKey(str)) {
            return this.eaP.get(str).longValue();
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(str);
                long parseLong = Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
                mediaMetadataRetriever.release();
                this.eaP.put(str, Long.valueOf(parseLong));
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
        if (this.eaS != null) {
            aTT().postDelayed(new Runnable() { // from class: com.baidu.swan.games.audio.b.b.2
                @Override // java.lang.Runnable
                public void run() {
                    b.this.eaS.pauseAll();
                }
            }, 50L);
        }
    }

    public void onResume() {
        if (this.eaS != null) {
            aTT().post(new Runnable() { // from class: com.baidu.swan.games.audio.b.b.3
                @Override // java.lang.Runnable
                public void run() {
                    b.this.eaS.resume();
                }
            });
        }
    }

    public boolean aTU() {
        if (this.eaS != null) {
            this.eaS.isAudioPlayer();
            return false;
        }
        return false;
    }

    public void a(JsArrayBuffer jsArrayBuffer, a.InterfaceC0512a interfaceC0512a) {
        a.aTQ().a(jsArrayBuffer, interfaceC0512a);
    }
}

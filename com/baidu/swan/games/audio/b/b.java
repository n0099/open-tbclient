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
    private static volatile b cUl;
    private HandlerThread cUp;
    private SwanAudioPlayer cUq;
    private Handler mHandler;
    private HashMap<String, Long> cUn = new HashMap<>();
    private String cUo = f.axz();
    private com.baidu.swan.games.audio.a.b cUm = new com.baidu.swan.games.audio.a.b(this.cUo);

    static {
        com.baidu.swan.games.utils.so.d.aCp();
    }

    private b() {
        axG();
        axH().post(new Runnable() { // from class: com.baidu.swan.games.audio.b.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.cUq = SwanAudioPlayer.getInstance();
                SwanAudioPlayer.settingNativeAudioParameters(AppRuntime.getApplication());
            }
        });
    }

    public static b axF() {
        if (cUl == null) {
            synchronized (b.class) {
                if (cUl == null) {
                    cUl = new b();
                }
            }
        }
        return cUl;
    }

    private void axG() {
        if (this.cUp == null) {
            this.cUp = new HandlerThread("audio_thread");
            this.cUp.start();
            this.mHandler = new Handler(this.cUp.getLooper());
        }
    }

    public Handler axH() {
        return this.mHandler;
    }

    public void a(String str, com.baidu.swan.games.audio.a.a aVar) {
        this.cUm.a(str, aVar);
    }

    public String re(String str) throws MalformedURLException {
        return this.cUo + f.qZ(str);
    }

    public synchronized c Y(String str, boolean z) {
        if (DEBUG) {
            Log.e("AudioPlayerManager", "create media player src = " + str);
        }
        return new d();
    }

    public long rf(String str) {
        if (this.cUn.containsKey(str)) {
            return this.cUn.get(str).longValue();
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(str);
                long parseLong = Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
                mediaMetadataRetriever.release();
                this.cUn.put(str, Long.valueOf(parseLong));
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
        if (this.cUq != null) {
            axH().postDelayed(new Runnable() { // from class: com.baidu.swan.games.audio.b.b.2
                @Override // java.lang.Runnable
                public void run() {
                    b.this.cUq.pauseAll();
                }
            }, 50L);
        }
    }

    public void onResume() {
        if (this.cUq != null) {
            axH().post(new Runnable() { // from class: com.baidu.swan.games.audio.b.b.3
                @Override // java.lang.Runnable
                public void run() {
                    b.this.cUq.resume();
                }
            });
        }
    }

    public boolean axI() {
        if (this.cUq != null) {
            this.cUq.isAudioPlayer();
            return false;
        }
        return false;
    }

    public void a(JsArrayBuffer jsArrayBuffer, a.InterfaceC0421a interfaceC0421a) {
        a.axE().a(jsArrayBuffer, interfaceC0421a);
    }
}

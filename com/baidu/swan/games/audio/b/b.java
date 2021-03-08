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
    private static volatile b eev;
    private SwanAudioPlayer eeA;
    private HandlerThread eez;
    private Handler mHandler;
    private HashMap<String, Long> eex = new HashMap<>();
    private String eey = f.aUa();
    private com.baidu.swan.games.audio.a.b eew = new com.baidu.swan.games.audio.a.b(this.eey);

    static {
        com.baidu.swan.games.utils.so.d.aZc();
    }

    private b() {
        aUh();
        aUi().post(new Runnable() { // from class: com.baidu.swan.games.audio.b.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.eeA = SwanAudioPlayer.getInstance();
                SwanAudioPlayer.settingNativeAudioParameters(AppRuntime.getApplication());
            }
        });
    }

    public static b aUg() {
        if (eev == null) {
            synchronized (b.class) {
                if (eev == null) {
                    eev = new b();
                }
            }
        }
        return eev;
    }

    private void aUh() {
        if (this.eez == null) {
            this.eez = new HandlerThread("audio_thread");
            this.eez.start();
            this.mHandler = new Handler(this.eez.getLooper());
        }
    }

    public Handler aUi() {
        return this.mHandler;
    }

    public void a(String str, com.baidu.swan.games.audio.a.a aVar) {
        this.eew.a(str, aVar);
    }

    public String wf(String str) throws MalformedURLException {
        return this.eey + f.wa(str);
    }

    public synchronized c ak(String str, boolean z) {
        if (DEBUG) {
            Log.e("AudioPlayerManager", "create media player src = " + str);
        }
        return new d();
    }

    public long wg(String str) {
        if (this.eex.containsKey(str)) {
            return this.eex.get(str).longValue();
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(str);
                long parseLong = Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
                mediaMetadataRetriever.release();
                this.eex.put(str, Long.valueOf(parseLong));
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
        if (this.eeA != null) {
            aUi().postDelayed(new Runnable() { // from class: com.baidu.swan.games.audio.b.b.2
                @Override // java.lang.Runnable
                public void run() {
                    b.this.eeA.pauseAll();
                }
            }, 50L);
        }
    }

    public void onResume() {
        if (this.eeA != null) {
            aUi().post(new Runnable() { // from class: com.baidu.swan.games.audio.b.b.3
                @Override // java.lang.Runnable
                public void run() {
                    b.this.eeA.resume();
                }
            });
        }
    }

    public boolean aUj() {
        if (this.eeA != null) {
            this.eeA.isAudioPlayer();
            return false;
        }
        return false;
    }

    public void a(JsArrayBuffer jsArrayBuffer, a.InterfaceC0515a interfaceC0515a) {
        a.aUf().a(jsArrayBuffer, interfaceC0515a);
    }
}

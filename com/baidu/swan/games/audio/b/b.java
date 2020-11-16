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
    private static volatile b dPE;
    private HandlerThread dPI;
    private SwanAudioPlayer dPJ;
    private Handler mHandler;
    private HashMap<String, Long> dPG = new HashMap<>();
    private String dPH = f.aSf();
    private com.baidu.swan.games.audio.a.b dPF = new com.baidu.swan.games.audio.a.b(this.dPH);

    static {
        com.baidu.swan.games.utils.so.d.aXh();
    }

    private b() {
        aSm();
        aSn().post(new Runnable() { // from class: com.baidu.swan.games.audio.b.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.dPJ = SwanAudioPlayer.getInstance();
                SwanAudioPlayer.settingNativeAudioParameters(AppRuntime.getApplication());
            }
        });
    }

    public static b aSl() {
        if (dPE == null) {
            synchronized (b.class) {
                if (dPE == null) {
                    dPE = new b();
                }
            }
        }
        return dPE;
    }

    private void aSm() {
        if (this.dPI == null) {
            this.dPI = new HandlerThread("audio_thread");
            this.dPI.start();
            this.mHandler = new Handler(this.dPI.getLooper());
        }
    }

    public Handler aSn() {
        return this.mHandler;
    }

    public void a(String str, com.baidu.swan.games.audio.a.a aVar) {
        this.dPF.a(str, aVar);
    }

    public String wk(String str) throws MalformedURLException {
        return this.dPH + f.wf(str);
    }

    public synchronized c ak(String str, boolean z) {
        if (DEBUG) {
            Log.e("AudioPlayerManager", "create media player src = " + str);
        }
        return new d();
    }

    public long wl(String str) {
        if (this.dPG.containsKey(str)) {
            return this.dPG.get(str).longValue();
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(str);
                long parseLong = Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
                mediaMetadataRetriever.release();
                this.dPG.put(str, Long.valueOf(parseLong));
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
        if (this.dPJ != null) {
            aSn().postDelayed(new Runnable() { // from class: com.baidu.swan.games.audio.b.b.2
                @Override // java.lang.Runnable
                public void run() {
                    b.this.dPJ.pauseAll();
                }
            }, 50L);
        }
    }

    public void onResume() {
        if (this.dPJ != null) {
            aSn().post(new Runnable() { // from class: com.baidu.swan.games.audio.b.b.3
                @Override // java.lang.Runnable
                public void run() {
                    b.this.dPJ.resume();
                }
            });
        }
    }

    public boolean aSo() {
        if (this.dPJ != null) {
            this.dPJ.isAudioPlayer();
            return false;
        }
        return false;
    }

    public void a(JsArrayBuffer jsArrayBuffer, a.InterfaceC0524a interfaceC0524a) {
        a.aSk().a(jsArrayBuffer, interfaceC0524a);
    }
}

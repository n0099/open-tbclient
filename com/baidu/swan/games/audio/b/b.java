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
/* loaded from: classes9.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile b efz;
    private HandlerThread efD;
    private SwanAudioPlayer efE;
    private Handler mHandler;
    private HashMap<String, Long> efB = new HashMap<>();
    private String efC = f.aXF();
    private com.baidu.swan.games.audio.a.b efA = new com.baidu.swan.games.audio.a.b(this.efC);

    static {
        com.baidu.swan.games.utils.so.d.bcH();
    }

    private b() {
        aXM();
        aXN().post(new Runnable() { // from class: com.baidu.swan.games.audio.b.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.efE = SwanAudioPlayer.getInstance();
                SwanAudioPlayer.settingNativeAudioParameters(AppRuntime.getApplication());
            }
        });
    }

    public static b aXL() {
        if (efz == null) {
            synchronized (b.class) {
                if (efz == null) {
                    efz = new b();
                }
            }
        }
        return efz;
    }

    private void aXM() {
        if (this.efD == null) {
            this.efD = new HandlerThread("audio_thread");
            this.efD.start();
            this.mHandler = new Handler(this.efD.getLooper());
        }
    }

    public Handler aXN() {
        return this.mHandler;
    }

    public void a(String str, com.baidu.swan.games.audio.a.a aVar) {
        this.efA.a(str, aVar);
    }

    public String wQ(String str) throws MalformedURLException {
        return this.efC + f.wL(str);
    }

    public synchronized c al(String str, boolean z) {
        if (DEBUG) {
            Log.e("AudioPlayerManager", "create media player src = " + str);
        }
        return new d();
    }

    public long wR(String str) {
        if (this.efB.containsKey(str)) {
            return this.efB.get(str).longValue();
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(str);
                long parseLong = Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
                mediaMetadataRetriever.release();
                this.efB.put(str, Long.valueOf(parseLong));
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
        if (this.efE != null) {
            aXN().postDelayed(new Runnable() { // from class: com.baidu.swan.games.audio.b.b.2
                @Override // java.lang.Runnable
                public void run() {
                    b.this.efE.pauseAll();
                }
            }, 50L);
        }
    }

    public void onResume() {
        if (this.efE != null) {
            aXN().post(new Runnable() { // from class: com.baidu.swan.games.audio.b.b.3
                @Override // java.lang.Runnable
                public void run() {
                    b.this.efE.resume();
                }
            });
        }
    }

    public boolean aXO() {
        if (this.efE != null) {
            this.efE.isAudioPlayer();
            return false;
        }
        return false;
    }

    public void a(JsArrayBuffer jsArrayBuffer, a.InterfaceC0529a interfaceC0529a) {
        a.aXK().a(jsArrayBuffer, interfaceC0529a);
    }
}

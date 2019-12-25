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
    private static volatile b cfZ;
    private SwanAudioPlayer cgd;
    private HandlerThread mAudioThread;
    private Handler mHandler;
    private HashMap<String, Long> cgb = new HashMap<>();
    private String cgc = f.aiM();
    private com.baidu.swan.games.audio.a.b cga = new com.baidu.swan.games.audio.a.b(this.cgc);

    static {
        com.baidu.swan.games.utils.so.d.anz();
    }

    private b() {
        aiT();
        aiU().post(new Runnable() { // from class: com.baidu.swan.games.audio.b.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.cgd = SwanAudioPlayer.getInstance();
                SwanAudioPlayer.settingNativeAudioParameters(AppRuntime.getApplication());
            }
        });
    }

    public static b aiS() {
        if (cfZ == null) {
            synchronized (b.class) {
                if (cfZ == null) {
                    cfZ = new b();
                }
            }
        }
        return cfZ;
    }

    private void aiT() {
        if (this.mAudioThread == null) {
            this.mAudioThread = new HandlerThread("audio_thread");
            this.mAudioThread.start();
            this.mHandler = new Handler(this.mAudioThread.getLooper());
        }
    }

    public Handler aiU() {
        return this.mHandler;
    }

    public void a(String str, com.baidu.swan.games.audio.a.a aVar) {
        this.cga.a(str, aVar);
    }

    public String nY(String str) throws MalformedURLException {
        return this.cgc + f.nT(str);
    }

    public synchronized c G(String str, boolean z) {
        if (DEBUG) {
            Log.e("AudioPlayerManager", "create media player src = " + str);
        }
        return new d();
    }

    public long nZ(String str) {
        if (this.cgb.containsKey(str)) {
            return this.cgb.get(str).longValue();
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(str);
                long parseLong = Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
                mediaMetadataRetriever.release();
                this.cgb.put(str, Long.valueOf(parseLong));
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
        if (this.cgd != null) {
            aiU().postDelayed(new Runnable() { // from class: com.baidu.swan.games.audio.b.b.2
                @Override // java.lang.Runnable
                public void run() {
                    b.this.cgd.pauseAll();
                }
            }, 50L);
        }
    }

    public void onResume() {
        if (this.cgd != null) {
            aiU().post(new Runnable() { // from class: com.baidu.swan.games.audio.b.b.3
                @Override // java.lang.Runnable
                public void run() {
                    b.this.cgd.resume();
                }
            });
        }
    }

    public boolean aiV() {
        if (this.cgd != null) {
            this.cgd.isAudioPlayer();
            return false;
        }
        return false;
    }

    public void a(JsArrayBuffer jsArrayBuffer, a.InterfaceC0318a interfaceC0318a) {
        a.aiR().a(jsArrayBuffer, interfaceC0318a);
    }
}

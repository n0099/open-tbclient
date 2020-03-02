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
    private static volatile b ckr;
    private SwanAudioPlayer ckv;
    private HandlerThread mAudioThread;
    private Handler mHandler;
    private HashMap<String, Long> ckt = new HashMap<>();
    private String cku = f.alv();
    private com.baidu.swan.games.audio.a.b cks = new com.baidu.swan.games.audio.a.b(this.cku);

    static {
        com.baidu.swan.games.utils.so.d.aqi();
    }

    private b() {
        alC();
        alD().post(new Runnable() { // from class: com.baidu.swan.games.audio.b.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.ckv = SwanAudioPlayer.getInstance();
                SwanAudioPlayer.settingNativeAudioParameters(AppRuntime.getApplication());
            }
        });
    }

    public static b alB() {
        if (ckr == null) {
            synchronized (b.class) {
                if (ckr == null) {
                    ckr = new b();
                }
            }
        }
        return ckr;
    }

    private void alC() {
        if (this.mAudioThread == null) {
            this.mAudioThread = new HandlerThread("audio_thread");
            this.mAudioThread.start();
            this.mHandler = new Handler(this.mAudioThread.getLooper());
        }
    }

    public Handler alD() {
        return this.mHandler;
    }

    public void a(String str, com.baidu.swan.games.audio.a.a aVar) {
        this.cks.a(str, aVar);
    }

    public String os(String str) throws MalformedURLException {
        return this.cku + f.om(str);
    }

    public synchronized c G(String str, boolean z) {
        if (DEBUG) {
            Log.e("AudioPlayerManager", "create media player src = " + str);
        }
        return new d();
    }

    public long ot(String str) {
        if (this.ckt.containsKey(str)) {
            return this.ckt.get(str).longValue();
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(str);
                long parseLong = Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
                mediaMetadataRetriever.release();
                this.ckt.put(str, Long.valueOf(parseLong));
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
        if (this.ckv != null) {
            alD().postDelayed(new Runnable() { // from class: com.baidu.swan.games.audio.b.b.2
                @Override // java.lang.Runnable
                public void run() {
                    b.this.ckv.pauseAll();
                }
            }, 50L);
        }
    }

    public void onResume() {
        if (this.ckv != null) {
            alD().post(new Runnable() { // from class: com.baidu.swan.games.audio.b.b.3
                @Override // java.lang.Runnable
                public void run() {
                    b.this.ckv.resume();
                }
            });
        }
    }

    public boolean alE() {
        if (this.ckv != null) {
            this.ckv.isAudioPlayer();
            return false;
        }
        return false;
    }

    public void a(JsArrayBuffer jsArrayBuffer, a.InterfaceC0330a interfaceC0330a) {
        a.alA().a(jsArrayBuffer, interfaceC0330a);
    }
}

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
    private static volatile b cks;
    private SwanAudioPlayer ckw;
    private HandlerThread mAudioThread;
    private Handler mHandler;
    private HashMap<String, Long> cku = new HashMap<>();
    private String ckv = f.alv();
    private com.baidu.swan.games.audio.a.b ckt = new com.baidu.swan.games.audio.a.b(this.ckv);

    static {
        com.baidu.swan.games.utils.so.d.aqi();
    }

    private b() {
        alC();
        alD().post(new Runnable() { // from class: com.baidu.swan.games.audio.b.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.ckw = SwanAudioPlayer.getInstance();
                SwanAudioPlayer.settingNativeAudioParameters(AppRuntime.getApplication());
            }
        });
    }

    public static b alB() {
        if (cks == null) {
            synchronized (b.class) {
                if (cks == null) {
                    cks = new b();
                }
            }
        }
        return cks;
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
        this.ckt.a(str, aVar);
    }

    public String os(String str) throws MalformedURLException {
        return this.ckv + f.om(str);
    }

    public synchronized c G(String str, boolean z) {
        if (DEBUG) {
            Log.e("AudioPlayerManager", "create media player src = " + str);
        }
        return new d();
    }

    public long ot(String str) {
        if (this.cku.containsKey(str)) {
            return this.cku.get(str).longValue();
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(str);
                long parseLong = Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
                mediaMetadataRetriever.release();
                this.cku.put(str, Long.valueOf(parseLong));
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
        if (this.ckw != null) {
            alD().postDelayed(new Runnable() { // from class: com.baidu.swan.games.audio.b.b.2
                @Override // java.lang.Runnable
                public void run() {
                    b.this.ckw.pauseAll();
                }
            }, 50L);
        }
    }

    public void onResume() {
        if (this.ckw != null) {
            alD().post(new Runnable() { // from class: com.baidu.swan.games.audio.b.b.3
                @Override // java.lang.Runnable
                public void run() {
                    b.this.ckw.resume();
                }
            });
        }
    }

    public boolean alE() {
        if (this.ckw != null) {
            this.ckw.isAudioPlayer();
            return false;
        }
        return false;
    }

    public void a(JsArrayBuffer jsArrayBuffer, a.InterfaceC0330a interfaceC0330a) {
        a.alA().a(jsArrayBuffer, interfaceC0330a);
    }
}

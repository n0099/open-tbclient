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
    private static volatile b ckD;
    private SwanAudioPlayer ckH;
    private HandlerThread mAudioThread;
    private Handler mHandler;
    private HashMap<String, Long> ckF = new HashMap<>();
    private String ckG = f.aly();
    private com.baidu.swan.games.audio.a.b ckE = new com.baidu.swan.games.audio.a.b(this.ckG);

    static {
        com.baidu.swan.games.utils.so.d.aql();
    }

    private b() {
        alF();
        alG().post(new Runnable() { // from class: com.baidu.swan.games.audio.b.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.ckH = SwanAudioPlayer.getInstance();
                SwanAudioPlayer.settingNativeAudioParameters(AppRuntime.getApplication());
            }
        });
    }

    public static b alE() {
        if (ckD == null) {
            synchronized (b.class) {
                if (ckD == null) {
                    ckD = new b();
                }
            }
        }
        return ckD;
    }

    private void alF() {
        if (this.mAudioThread == null) {
            this.mAudioThread = new HandlerThread("audio_thread");
            this.mAudioThread.start();
            this.mHandler = new Handler(this.mAudioThread.getLooper());
        }
    }

    public Handler alG() {
        return this.mHandler;
    }

    public void a(String str, com.baidu.swan.games.audio.a.a aVar) {
        this.ckE.a(str, aVar);
    }

    public String or(String str) throws MalformedURLException {
        return this.ckG + f.ol(str);
    }

    public synchronized c G(String str, boolean z) {
        if (DEBUG) {
            Log.e("AudioPlayerManager", "create media player src = " + str);
        }
        return new d();
    }

    public long os(String str) {
        if (this.ckF.containsKey(str)) {
            return this.ckF.get(str).longValue();
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(str);
                long parseLong = Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
                mediaMetadataRetriever.release();
                this.ckF.put(str, Long.valueOf(parseLong));
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
        if (this.ckH != null) {
            alG().postDelayed(new Runnable() { // from class: com.baidu.swan.games.audio.b.b.2
                @Override // java.lang.Runnable
                public void run() {
                    b.this.ckH.pauseAll();
                }
            }, 50L);
        }
    }

    public void onResume() {
        if (this.ckH != null) {
            alG().post(new Runnable() { // from class: com.baidu.swan.games.audio.b.b.3
                @Override // java.lang.Runnable
                public void run() {
                    b.this.ckH.resume();
                }
            });
        }
    }

    public boolean alH() {
        if (this.ckH != null) {
            this.ckH.isAudioPlayer();
            return false;
        }
        return false;
    }

    public void a(JsArrayBuffer jsArrayBuffer, a.InterfaceC0330a interfaceC0330a) {
        a.alD().a(jsArrayBuffer, interfaceC0330a);
    }
}

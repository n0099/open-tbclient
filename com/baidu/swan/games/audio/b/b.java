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
/* loaded from: classes3.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile b dqT;
    private HandlerThread dqX;
    private SwanAudioPlayer dqY;
    private Handler mHandler;
    private HashMap<String, Long> dqV = new HashMap<>();
    private String dqW = f.aLK();
    private com.baidu.swan.games.audio.a.b dqU = new com.baidu.swan.games.audio.a.b(this.dqW);

    static {
        com.baidu.swan.games.utils.so.d.aQM();
    }

    private b() {
        aLR();
        aLS().post(new Runnable() { // from class: com.baidu.swan.games.audio.b.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.dqY = SwanAudioPlayer.getInstance();
                SwanAudioPlayer.settingNativeAudioParameters(AppRuntime.getApplication());
            }
        });
    }

    public static b aLQ() {
        if (dqT == null) {
            synchronized (b.class) {
                if (dqT == null) {
                    dqT = new b();
                }
            }
        }
        return dqT;
    }

    private void aLR() {
        if (this.dqX == null) {
            this.dqX = new HandlerThread("audio_thread");
            this.dqX.start();
            this.mHandler = new Handler(this.dqX.getLooper());
        }
    }

    public Handler aLS() {
        return this.mHandler;
    }

    public void a(String str, com.baidu.swan.games.audio.a.a aVar) {
        this.dqU.a(str, aVar);
    }

    public String uW(String str) throws MalformedURLException {
        return this.dqW + f.uR(str);
    }

    public synchronized c ae(String str, boolean z) {
        if (DEBUG) {
            Log.e("AudioPlayerManager", "create media player src = " + str);
        }
        return new d();
    }

    public long uX(String str) {
        if (this.dqV.containsKey(str)) {
            return this.dqV.get(str).longValue();
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(str);
                long parseLong = Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
                mediaMetadataRetriever.release();
                this.dqV.put(str, Long.valueOf(parseLong));
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
        if (this.dqY != null) {
            aLS().postDelayed(new Runnable() { // from class: com.baidu.swan.games.audio.b.b.2
                @Override // java.lang.Runnable
                public void run() {
                    b.this.dqY.pauseAll();
                }
            }, 50L);
        }
    }

    public void onResume() {
        if (this.dqY != null) {
            aLS().post(new Runnable() { // from class: com.baidu.swan.games.audio.b.b.3
                @Override // java.lang.Runnable
                public void run() {
                    b.this.dqY.resume();
                }
            });
        }
    }

    public boolean aLT() {
        if (this.dqY != null) {
            this.dqY.isAudioPlayer();
            return false;
        }
        return false;
    }

    public void a(JsArrayBuffer jsArrayBuffer, a.InterfaceC0483a interfaceC0483a) {
        a.aLP().a(jsArrayBuffer, interfaceC0483a);
    }
}

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
/* loaded from: classes10.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile b dCX;
    private HandlerThread dDb;
    private SwanAudioPlayer dDc;
    private Handler mHandler;
    private HashMap<String, Long> dCZ = new HashMap<>();
    private String dDa = f.aOt();
    private com.baidu.swan.games.audio.a.b dCY = new com.baidu.swan.games.audio.a.b(this.dDa);

    static {
        com.baidu.swan.games.utils.so.d.aTv();
    }

    private b() {
        aOA();
        aOB().post(new Runnable() { // from class: com.baidu.swan.games.audio.b.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.dDc = SwanAudioPlayer.getInstance();
                SwanAudioPlayer.settingNativeAudioParameters(AppRuntime.getApplication());
            }
        });
    }

    public static b aOz() {
        if (dCX == null) {
            synchronized (b.class) {
                if (dCX == null) {
                    dCX = new b();
                }
            }
        }
        return dCX;
    }

    private void aOA() {
        if (this.dDb == null) {
            this.dDb = new HandlerThread("audio_thread");
            this.dDb.start();
            this.mHandler = new Handler(this.dDb.getLooper());
        }
    }

    public Handler aOB() {
        return this.mHandler;
    }

    public void a(String str, com.baidu.swan.games.audio.a.a aVar) {
        this.dCY.a(str, aVar);
    }

    public String vI(String str) throws MalformedURLException {
        return this.dDa + f.vD(str);
    }

    public synchronized c ai(String str, boolean z) {
        if (DEBUG) {
            Log.e("AudioPlayerManager", "create media player src = " + str);
        }
        return new d();
    }

    public long vJ(String str) {
        if (this.dCZ.containsKey(str)) {
            return this.dCZ.get(str).longValue();
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(str);
                long parseLong = Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
                mediaMetadataRetriever.release();
                this.dCZ.put(str, Long.valueOf(parseLong));
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
        if (this.dDc != null) {
            aOB().postDelayed(new Runnable() { // from class: com.baidu.swan.games.audio.b.b.2
                @Override // java.lang.Runnable
                public void run() {
                    b.this.dDc.pauseAll();
                }
            }, 50L);
        }
    }

    public void onResume() {
        if (this.dDc != null) {
            aOB().post(new Runnable() { // from class: com.baidu.swan.games.audio.b.b.3
                @Override // java.lang.Runnable
                public void run() {
                    b.this.dDc.resume();
                }
            });
        }
    }

    public boolean aOC() {
        if (this.dDc != null) {
            this.dDc.isAudioPlayer();
            return false;
        }
        return false;
    }

    public void a(JsArrayBuffer jsArrayBuffer, a.InterfaceC0500a interfaceC0500a) {
        a.aOy().a(jsArrayBuffer, interfaceC0500a);
    }
}

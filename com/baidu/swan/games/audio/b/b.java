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
    private static volatile b ecU;
    private HandlerThread ecY;
    private SwanAudioPlayer ecZ;
    private Handler mHandler;
    private HashMap<String, Long> ecW = new HashMap<>();
    private String ecX = f.aTX();
    private com.baidu.swan.games.audio.a.b ecV = new com.baidu.swan.games.audio.a.b(this.ecX);

    static {
        com.baidu.swan.games.utils.so.d.aYZ();
    }

    private b() {
        aUe();
        aUf().post(new Runnable() { // from class: com.baidu.swan.games.audio.b.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.ecZ = SwanAudioPlayer.getInstance();
                SwanAudioPlayer.settingNativeAudioParameters(AppRuntime.getApplication());
            }
        });
    }

    public static b aUd() {
        if (ecU == null) {
            synchronized (b.class) {
                if (ecU == null) {
                    ecU = new b();
                }
            }
        }
        return ecU;
    }

    private void aUe() {
        if (this.ecY == null) {
            this.ecY = new HandlerThread("audio_thread");
            this.ecY.start();
            this.mHandler = new Handler(this.ecY.getLooper());
        }
    }

    public Handler aUf() {
        return this.mHandler;
    }

    public void a(String str, com.baidu.swan.games.audio.a.a aVar) {
        this.ecV.a(str, aVar);
    }

    public String vY(String str) throws MalformedURLException {
        return this.ecX + f.vT(str);
    }

    public synchronized c ak(String str, boolean z) {
        if (DEBUG) {
            Log.e("AudioPlayerManager", "create media player src = " + str);
        }
        return new d();
    }

    public long vZ(String str) {
        if (this.ecW.containsKey(str)) {
            return this.ecW.get(str).longValue();
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(str);
                long parseLong = Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
                mediaMetadataRetriever.release();
                this.ecW.put(str, Long.valueOf(parseLong));
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
        if (this.ecZ != null) {
            aUf().postDelayed(new Runnable() { // from class: com.baidu.swan.games.audio.b.b.2
                @Override // java.lang.Runnable
                public void run() {
                    b.this.ecZ.pauseAll();
                }
            }, 50L);
        }
    }

    public void onResume() {
        if (this.ecZ != null) {
            aUf().post(new Runnable() { // from class: com.baidu.swan.games.audio.b.b.3
                @Override // java.lang.Runnable
                public void run() {
                    b.this.ecZ.resume();
                }
            });
        }
    }

    public boolean aUg() {
        if (this.ecZ != null) {
            this.ecZ.isAudioPlayer();
            return false;
        }
        return false;
    }

    public void a(JsArrayBuffer jsArrayBuffer, a.InterfaceC0509a interfaceC0509a) {
        a.aUc().a(jsArrayBuffer, interfaceC0509a);
    }
}

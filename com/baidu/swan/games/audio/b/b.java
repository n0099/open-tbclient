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
    private static volatile b cYV;
    private HandlerThread cYZ;
    private SwanAudioPlayer cZa;
    private Handler mHandler;
    private HashMap<String, Long> cYX = new HashMap<>();
    private String cYY = f.ayF();
    private com.baidu.swan.games.audio.a.b cYW = new com.baidu.swan.games.audio.a.b(this.cYY);

    static {
        com.baidu.swan.games.utils.so.d.aDv();
    }

    private b() {
        ayM();
        ayN().post(new Runnable() { // from class: com.baidu.swan.games.audio.b.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.cZa = SwanAudioPlayer.getInstance();
                SwanAudioPlayer.settingNativeAudioParameters(AppRuntime.getApplication());
            }
        });
    }

    public static b ayL() {
        if (cYV == null) {
            synchronized (b.class) {
                if (cYV == null) {
                    cYV = new b();
                }
            }
        }
        return cYV;
    }

    private void ayM() {
        if (this.cYZ == null) {
            this.cYZ = new HandlerThread("audio_thread");
            this.cYZ.start();
            this.mHandler = new Handler(this.cYZ.getLooper());
        }
    }

    public Handler ayN() {
        return this.mHandler;
    }

    public void a(String str, com.baidu.swan.games.audio.a.a aVar) {
        this.cYW.a(str, aVar);
    }

    public String rm(String str) throws MalformedURLException {
        return this.cYY + f.rh(str);
    }

    public synchronized c aa(String str, boolean z) {
        if (DEBUG) {
            Log.e("AudioPlayerManager", "create media player src = " + str);
        }
        return new d();
    }

    public long rn(String str) {
        if (this.cYX.containsKey(str)) {
            return this.cYX.get(str).longValue();
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(str);
                long parseLong = Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
                mediaMetadataRetriever.release();
                this.cYX.put(str, Long.valueOf(parseLong));
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
        if (this.cZa != null) {
            ayN().postDelayed(new Runnable() { // from class: com.baidu.swan.games.audio.b.b.2
                @Override // java.lang.Runnable
                public void run() {
                    b.this.cZa.pauseAll();
                }
            }, 50L);
        }
    }

    public void onResume() {
        if (this.cZa != null) {
            ayN().post(new Runnable() { // from class: com.baidu.swan.games.audio.b.b.3
                @Override // java.lang.Runnable
                public void run() {
                    b.this.cZa.resume();
                }
            });
        }
    }

    public boolean ayO() {
        if (this.cZa != null) {
            this.cZa.isAudioPlayer();
            return false;
        }
        return false;
    }

    public void a(JsArrayBuffer jsArrayBuffer, a.InterfaceC0427a interfaceC0427a) {
        a.ayK().a(jsArrayBuffer, interfaceC0427a);
    }
}

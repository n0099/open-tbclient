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
    private static volatile b dLu;
    private HandlerThread dLy;
    private SwanAudioPlayer dLz;
    private Handler mHandler;
    private HashMap<String, Long> dLw = new HashMap<>();
    private String dLx = f.aQn();
    private com.baidu.swan.games.audio.a.b dLv = new com.baidu.swan.games.audio.a.b(this.dLx);

    static {
        com.baidu.swan.games.utils.so.d.aVp();
    }

    private b() {
        aQu();
        aQv().post(new Runnable() { // from class: com.baidu.swan.games.audio.b.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.dLz = SwanAudioPlayer.getInstance();
                SwanAudioPlayer.settingNativeAudioParameters(AppRuntime.getApplication());
            }
        });
    }

    public static b aQt() {
        if (dLu == null) {
            synchronized (b.class) {
                if (dLu == null) {
                    dLu = new b();
                }
            }
        }
        return dLu;
    }

    private void aQu() {
        if (this.dLy == null) {
            this.dLy = new HandlerThread("audio_thread");
            this.dLy.start();
            this.mHandler = new Handler(this.dLy.getLooper());
        }
    }

    public Handler aQv() {
        return this.mHandler;
    }

    public void a(String str, com.baidu.swan.games.audio.a.a aVar) {
        this.dLv.a(str, aVar);
    }

    public String wb(String str) throws MalformedURLException {
        return this.dLx + f.vW(str);
    }

    public synchronized c ak(String str, boolean z) {
        if (DEBUG) {
            Log.e("AudioPlayerManager", "create media player src = " + str);
        }
        return new d();
    }

    public long wc(String str) {
        if (this.dLw.containsKey(str)) {
            return this.dLw.get(str).longValue();
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(str);
                long parseLong = Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
                mediaMetadataRetriever.release();
                this.dLw.put(str, Long.valueOf(parseLong));
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
        if (this.dLz != null) {
            aQv().postDelayed(new Runnable() { // from class: com.baidu.swan.games.audio.b.b.2
                @Override // java.lang.Runnable
                public void run() {
                    b.this.dLz.pauseAll();
                }
            }, 50L);
        }
    }

    public void onResume() {
        if (this.dLz != null) {
            aQv().post(new Runnable() { // from class: com.baidu.swan.games.audio.b.b.3
                @Override // java.lang.Runnable
                public void run() {
                    b.this.dLz.resume();
                }
            });
        }
    }

    public boolean aQw() {
        if (this.dLz != null) {
            this.dLz.isAudioPlayer();
            return false;
        }
        return false;
    }

    public void a(JsArrayBuffer jsArrayBuffer, a.InterfaceC0514a interfaceC0514a) {
        a.aQs().a(jsArrayBuffer, interfaceC0514a);
    }
}

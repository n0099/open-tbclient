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
    private static volatile b dRm;
    private HandlerThread dRq;
    private SwanAudioPlayer dRr;
    private Handler mHandler;
    private HashMap<String, Long> dRo = new HashMap<>();
    private String dRp = f.aSN();
    private com.baidu.swan.games.audio.a.b dRn = new com.baidu.swan.games.audio.a.b(this.dRp);

    static {
        com.baidu.swan.games.utils.so.d.aXP();
    }

    private b() {
        aSU();
        aSV().post(new Runnable() { // from class: com.baidu.swan.games.audio.b.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.dRr = SwanAudioPlayer.getInstance();
                SwanAudioPlayer.settingNativeAudioParameters(AppRuntime.getApplication());
            }
        });
    }

    public static b aST() {
        if (dRm == null) {
            synchronized (b.class) {
                if (dRm == null) {
                    dRm = new b();
                }
            }
        }
        return dRm;
    }

    private void aSU() {
        if (this.dRq == null) {
            this.dRq = new HandlerThread("audio_thread");
            this.dRq.start();
            this.mHandler = new Handler(this.dRq.getLooper());
        }
    }

    public Handler aSV() {
        return this.mHandler;
    }

    public void a(String str, com.baidu.swan.games.audio.a.a aVar) {
        this.dRn.a(str, aVar);
    }

    public String wp(String str) throws MalformedURLException {
        return this.dRp + f.wk(str);
    }

    public synchronized c ak(String str, boolean z) {
        if (DEBUG) {
            Log.e("AudioPlayerManager", "create media player src = " + str);
        }
        return new d();
    }

    public long wq(String str) {
        if (this.dRo.containsKey(str)) {
            return this.dRo.get(str).longValue();
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(str);
                long parseLong = Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
                mediaMetadataRetriever.release();
                this.dRo.put(str, Long.valueOf(parseLong));
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
        if (this.dRr != null) {
            aSV().postDelayed(new Runnable() { // from class: com.baidu.swan.games.audio.b.b.2
                @Override // java.lang.Runnable
                public void run() {
                    b.this.dRr.pauseAll();
                }
            }, 50L);
        }
    }

    public void onResume() {
        if (this.dRr != null) {
            aSV().post(new Runnable() { // from class: com.baidu.swan.games.audio.b.b.3
                @Override // java.lang.Runnable
                public void run() {
                    b.this.dRr.resume();
                }
            });
        }
    }

    public boolean aSW() {
        if (this.dRr != null) {
            this.dRr.isAudioPlayer();
            return false;
        }
        return false;
    }

    public void a(JsArrayBuffer jsArrayBuffer, a.InterfaceC0526a interfaceC0526a) {
        a.aSS().a(jsArrayBuffer, interfaceC0526a);
    }
}

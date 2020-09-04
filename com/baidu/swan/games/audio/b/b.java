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
/* loaded from: classes8.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile b doS;
    private HandlerThread doW;
    private SwanAudioPlayer doX;
    private Handler mHandler;
    private HashMap<String, Long> doU = new HashMap<>();
    private String doV = f.aKZ();
    private com.baidu.swan.games.audio.a.b doT = new com.baidu.swan.games.audio.a.b(this.doV);

    static {
        com.baidu.swan.games.utils.so.d.aQb();
    }

    private b() {
        aLg();
        aLh().post(new Runnable() { // from class: com.baidu.swan.games.audio.b.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.doX = SwanAudioPlayer.getInstance();
                SwanAudioPlayer.settingNativeAudioParameters(AppRuntime.getApplication());
            }
        });
    }

    public static b aLf() {
        if (doS == null) {
            synchronized (b.class) {
                if (doS == null) {
                    doS = new b();
                }
            }
        }
        return doS;
    }

    private void aLg() {
        if (this.doW == null) {
            this.doW = new HandlerThread("audio_thread");
            this.doW.start();
            this.mHandler = new Handler(this.doW.getLooper());
        }
    }

    public Handler aLh() {
        return this.mHandler;
    }

    public void a(String str, com.baidu.swan.games.audio.a.a aVar) {
        this.doT.a(str, aVar);
    }

    public String uD(String str) throws MalformedURLException {
        return this.doV + f.uy(str);
    }

    public synchronized c ae(String str, boolean z) {
        if (DEBUG) {
            Log.e("AudioPlayerManager", "create media player src = " + str);
        }
        return new d();
    }

    public long uE(String str) {
        if (this.doU.containsKey(str)) {
            return this.doU.get(str).longValue();
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(str);
                long parseLong = Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
                mediaMetadataRetriever.release();
                this.doU.put(str, Long.valueOf(parseLong));
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
        if (this.doX != null) {
            aLh().postDelayed(new Runnable() { // from class: com.baidu.swan.games.audio.b.b.2
                @Override // java.lang.Runnable
                public void run() {
                    b.this.doX.pauseAll();
                }
            }, 50L);
        }
    }

    public void onResume() {
        if (this.doX != null) {
            aLh().post(new Runnable() { // from class: com.baidu.swan.games.audio.b.b.3
                @Override // java.lang.Runnable
                public void run() {
                    b.this.doX.resume();
                }
            });
        }
    }

    public boolean aLi() {
        if (this.doX != null) {
            this.doX.isAudioPlayer();
            return false;
        }
        return false;
    }

    public void a(JsArrayBuffer jsArrayBuffer, a.InterfaceC0488a interfaceC0488a) {
        a.aLe().a(jsArrayBuffer, interfaceC0488a);
    }
}

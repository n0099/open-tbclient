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
    private static volatile b doO;
    private HandlerThread doS;
    private SwanAudioPlayer doT;
    private Handler mHandler;
    private HashMap<String, Long> doQ = new HashMap<>();
    private String doR = f.aKZ();
    private com.baidu.swan.games.audio.a.b doP = new com.baidu.swan.games.audio.a.b(this.doR);

    static {
        com.baidu.swan.games.utils.so.d.aQb();
    }

    private b() {
        aLg();
        aLh().post(new Runnable() { // from class: com.baidu.swan.games.audio.b.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.doT = SwanAudioPlayer.getInstance();
                SwanAudioPlayer.settingNativeAudioParameters(AppRuntime.getApplication());
            }
        });
    }

    public static b aLf() {
        if (doO == null) {
            synchronized (b.class) {
                if (doO == null) {
                    doO = new b();
                }
            }
        }
        return doO;
    }

    private void aLg() {
        if (this.doS == null) {
            this.doS = new HandlerThread("audio_thread");
            this.doS.start();
            this.mHandler = new Handler(this.doS.getLooper());
        }
    }

    public Handler aLh() {
        return this.mHandler;
    }

    public void a(String str, com.baidu.swan.games.audio.a.a aVar) {
        this.doP.a(str, aVar);
    }

    public String uC(String str) throws MalformedURLException {
        return this.doR + f.ux(str);
    }

    public synchronized c ae(String str, boolean z) {
        if (DEBUG) {
            Log.e("AudioPlayerManager", "create media player src = " + str);
        }
        return new d();
    }

    public long uD(String str) {
        if (this.doQ.containsKey(str)) {
            return this.doQ.get(str).longValue();
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(str);
                long parseLong = Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
                mediaMetadataRetriever.release();
                this.doQ.put(str, Long.valueOf(parseLong));
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
        if (this.doT != null) {
            aLh().postDelayed(new Runnable() { // from class: com.baidu.swan.games.audio.b.b.2
                @Override // java.lang.Runnable
                public void run() {
                    b.this.doT.pauseAll();
                }
            }, 50L);
        }
    }

    public void onResume() {
        if (this.doT != null) {
            aLh().post(new Runnable() { // from class: com.baidu.swan.games.audio.b.b.3
                @Override // java.lang.Runnable
                public void run() {
                    b.this.doT.resume();
                }
            });
        }
    }

    public boolean aLi() {
        if (this.doT != null) {
            this.doT.isAudioPlayer();
            return false;
        }
        return false;
    }

    public void a(JsArrayBuffer jsArrayBuffer, a.InterfaceC0488a interfaceC0488a) {
        a.aLe().a(jsArrayBuffer, interfaceC0488a);
    }
}

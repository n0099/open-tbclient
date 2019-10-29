package com.baidu.swan.games.audio.b;

import android.media.AudioManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import com.baidu.swan.games.audio.AudioPlayer;
import com.baidu.swan.games.audio.f;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile b byA;
    private HandlerThread mAudioThread;
    private Handler mHandler;
    private HashMap<String, Long> byC = new HashMap<>();
    private String byD = f.VR();
    private com.baidu.swan.games.audio.a.b byB = new com.baidu.swan.games.audio.a.b(this.byD);

    private b() {
        VY();
    }

    public static b VX() {
        if (byA == null) {
            synchronized (AudioManager.class) {
                if (byA == null) {
                    byA = new b();
                }
            }
        }
        return byA;
    }

    private void VY() {
        if (this.mAudioThread == null) {
            this.mAudioThread = new HandlerThread("audio_thread");
            this.mAudioThread.start();
            this.mHandler = new Handler(this.mAudioThread.getLooper());
        }
    }

    public Handler VZ() {
        return this.mHandler;
    }

    public void a(String str, com.baidu.swan.games.audio.a.a aVar) {
        this.byB.a(str, aVar);
    }

    public String jx(String str) throws MalformedURLException {
        return this.byD + f.jt(str);
    }

    public synchronized c B(String str, boolean z) {
        if (DEBUG) {
            Log.e("AudioPlayerManager", "create media player src = " + str);
        }
        return new a();
    }

    public static boolean Wa() {
        ArrayList<com.baidu.swan.apps.media.a> LO = com.baidu.swan.apps.media.b.LO();
        if (LO != null && LO.size() > 0) {
            int size = LO.size();
            for (int i = 0; i < size; i++) {
                try {
                    com.baidu.swan.apps.media.a aVar = LO.get(i);
                    if ((aVar instanceof AudioPlayer) && !((AudioPlayer) aVar).VL().isPaused()) {
                        return true;
                    }
                } catch (Exception e) {
                }
            }
        }
        return false;
    }
}

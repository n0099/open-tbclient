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
    private static volatile b bxJ;
    private HandlerThread mAudioThread;
    private Handler mHandler;
    private HashMap<String, Long> bxL = new HashMap<>();
    private String bxM = f.VP();
    private com.baidu.swan.games.audio.a.b bxK = new com.baidu.swan.games.audio.a.b(this.bxM);

    private b() {
        VW();
    }

    public static b VV() {
        if (bxJ == null) {
            synchronized (AudioManager.class) {
                if (bxJ == null) {
                    bxJ = new b();
                }
            }
        }
        return bxJ;
    }

    private void VW() {
        if (this.mAudioThread == null) {
            this.mAudioThread = new HandlerThread("audio_thread");
            this.mAudioThread.start();
            this.mHandler = new Handler(this.mAudioThread.getLooper());
        }
    }

    public Handler VX() {
        return this.mHandler;
    }

    public void a(String str, com.baidu.swan.games.audio.a.a aVar) {
        this.bxK.a(str, aVar);
    }

    public String jx(String str) throws MalformedURLException {
        return this.bxM + f.jt(str);
    }

    public synchronized c B(String str, boolean z) {
        if (DEBUG) {
            Log.e("AudioPlayerManager", "create media player src = " + str);
        }
        return new a();
    }

    public static boolean VY() {
        ArrayList<com.baidu.swan.apps.media.a> LP = com.baidu.swan.apps.media.b.LP();
        if (LP != null && LP.size() > 0) {
            int size = LP.size();
            for (int i = 0; i < size; i++) {
                try {
                    com.baidu.swan.apps.media.a aVar = LP.get(i);
                    if ((aVar instanceof AudioPlayer) && !((AudioPlayer) aVar).VJ().isPaused()) {
                        return true;
                    }
                } catch (Exception e) {
                }
            }
        }
        return false;
    }
}

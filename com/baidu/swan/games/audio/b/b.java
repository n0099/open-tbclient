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
    private static volatile b bfH;
    private HandlerThread mAudioThread;
    private Handler mHandler;
    private HashMap<String, Long> bfJ = new HashMap<>();
    private String bfK = f.Rb();
    private com.baidu.swan.games.audio.a.b bfI = new com.baidu.swan.games.audio.a.b(this.bfK);

    private b() {
        createAudioThread();
    }

    public static b Rh() {
        if (bfH == null) {
            synchronized (AudioManager.class) {
                if (bfH == null) {
                    bfH = new b();
                }
            }
        }
        return bfH;
    }

    private void createAudioThread() {
        if (this.mAudioThread == null) {
            this.mAudioThread = new HandlerThread("audio_thread");
            this.mAudioThread.start();
            this.mHandler = new Handler(this.mAudioThread.getLooper());
        }
    }

    public Handler Ri() {
        return this.mHandler;
    }

    public void a(String str, com.baidu.swan.games.audio.a.a aVar) {
        this.bfI.a(str, aVar);
    }

    public String iU(String str) throws MalformedURLException {
        return this.bfK + f.iQ(str);
    }

    public synchronized c y(String str, boolean z) {
        if (DEBUG) {
            Log.e("AudioPlayerManager", "create media player src = " + str);
        }
        return new a();
    }

    public static boolean Rj() {
        ArrayList<com.baidu.swan.apps.media.a> GU = com.baidu.swan.apps.media.b.GU();
        if (GU != null && GU.size() > 0) {
            int size = GU.size();
            for (int i = 0; i < size; i++) {
                try {
                    com.baidu.swan.apps.media.a aVar = GU.get(i);
                    if ((aVar instanceof AudioPlayer) && !((AudioPlayer) aVar).QV().isPaused()) {
                        return true;
                    }
                } catch (Exception e) {
                }
            }
        }
        return false;
    }
}

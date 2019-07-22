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
    private static volatile b bfj;
    private HandlerThread mAudioThread;
    private Handler mHandler;
    private HashMap<String, Long> bfl = new HashMap<>();
    private String bfm = f.QX();
    private com.baidu.swan.games.audio.a.b bfk = new com.baidu.swan.games.audio.a.b(this.bfm);

    private b() {
        createAudioThread();
    }

    public static b Rd() {
        if (bfj == null) {
            synchronized (AudioManager.class) {
                if (bfj == null) {
                    bfj = new b();
                }
            }
        }
        return bfj;
    }

    private void createAudioThread() {
        if (this.mAudioThread == null) {
            this.mAudioThread = new HandlerThread("audio_thread");
            this.mAudioThread.start();
            this.mHandler = new Handler(this.mAudioThread.getLooper());
        }
    }

    public Handler Re() {
        return this.mHandler;
    }

    public void a(String str, com.baidu.swan.games.audio.a.a aVar) {
        this.bfk.a(str, aVar);
    }

    public String iS(String str) throws MalformedURLException {
        return this.bfm + f.iO(str);
    }

    public synchronized c y(String str, boolean z) {
        if (DEBUG) {
            Log.e("AudioPlayerManager", "create media player src = " + str);
        }
        return new a();
    }

    public static boolean Rf() {
        ArrayList<com.baidu.swan.apps.media.a> GQ = com.baidu.swan.apps.media.b.GQ();
        if (GQ != null && GQ.size() > 0) {
            int size = GQ.size();
            for (int i = 0; i < size; i++) {
                try {
                    com.baidu.swan.apps.media.a aVar = GQ.get(i);
                    if ((aVar instanceof AudioPlayer) && !((AudioPlayer) aVar).QR().isPaused()) {
                        return true;
                    }
                } catch (Exception e) {
                }
            }
        }
        return false;
    }
}

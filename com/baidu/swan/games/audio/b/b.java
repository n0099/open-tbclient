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
    private static volatile b bew;
    private HandlerThread mAudioThread;
    private Handler mHandler;
    private HashMap<String, Long> bey = new HashMap<>();
    private String bez = f.Qf();
    private com.baidu.swan.games.audio.a.b bex = new com.baidu.swan.games.audio.a.b(this.bez);

    private b() {
        createAudioThread();
    }

    public static b Ql() {
        if (bew == null) {
            synchronized (AudioManager.class) {
                if (bew == null) {
                    bew = new b();
                }
            }
        }
        return bew;
    }

    private void createAudioThread() {
        if (this.mAudioThread == null) {
            this.mAudioThread = new HandlerThread("audio_thread");
            this.mAudioThread.start();
            this.mHandler = new Handler(this.mAudioThread.getLooper());
        }
    }

    public Handler Qm() {
        return this.mHandler;
    }

    public void a(String str, com.baidu.swan.games.audio.a.a aVar) {
        this.bex.a(str, aVar);
    }

    public String iL(String str) throws MalformedURLException {
        return this.bez + f.iH(str);
    }

    public synchronized c x(String str, boolean z) {
        if (DEBUG) {
            Log.e("AudioPlayerManager", "create media player src = " + str);
        }
        return new a();
    }

    public static boolean Qn() {
        ArrayList<com.baidu.swan.apps.media.a> Gg = com.baidu.swan.apps.media.b.Gg();
        if (Gg != null && Gg.size() > 0) {
            int size = Gg.size();
            for (int i = 0; i < size; i++) {
                try {
                    com.baidu.swan.apps.media.a aVar = Gg.get(i);
                    if ((aVar instanceof AudioPlayer) && !((AudioPlayer) aVar).PZ().isPaused()) {
                        return true;
                    }
                } catch (Exception e) {
                }
            }
        }
        return false;
    }
}

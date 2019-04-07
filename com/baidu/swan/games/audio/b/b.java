package com.baidu.swan.games.audio.b;

import android.media.AudioManager;
import android.media.MediaMetadataRetriever;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import com.baidu.swan.games.audio.AudioPlayer;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile b bap;
    private d bas;
    private HandlerThread mAudioThread;
    private Handler mHandler;
    private HashMap<String, Long> bat = new HashMap<>();
    private String bau = com.baidu.swan.games.audio.e.Nl();
    private com.baidu.swan.games.audio.a.b baq = new com.baidu.swan.games.audio.a.b(this.bau);

    private b() {
        createAudioThread();
    }

    public static b Nr() {
        if (bap == null) {
            synchronized (AudioManager.class) {
                if (bap == null) {
                    bap = new b();
                }
            }
        }
        return bap;
    }

    private void createAudioThread() {
        if (this.mAudioThread == null) {
            this.mAudioThread = new HandlerThread("audio_thread");
            this.mAudioThread.start();
            this.mHandler = new Handler(this.mAudioThread.getLooper());
        }
    }

    public Handler Ns() {
        return this.mHandler;
    }

    public void a(String str, com.baidu.swan.games.audio.a.a aVar) {
        this.baq.a(str, aVar);
    }

    public String hZ(String str) throws MalformedURLException {
        return this.bau + com.baidu.swan.games.audio.e.hW(str);
    }

    public synchronized e ia(String str) {
        e aVar;
        long ib = ib(str);
        if (3000 >= ib) {
            if (this.bas == null) {
                this.bas = new d();
            } else if (this.bas.Nw()) {
                this.bas.release();
                this.bas = null;
                this.bas = new d();
            }
            if (DEBUG) {
                Log.e("AudioPlayerManager", "create sound pool src = " + str);
            }
            aVar = this.bas.P(ib);
        } else {
            if (DEBUG) {
                Log.e("AudioPlayerManager", "create media player src = " + str);
            }
            aVar = new a();
        }
        return aVar;
    }

    private long ib(String str) {
        if (this.bat.containsKey(str)) {
            return this.bat.get(str).longValue();
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(str);
                long parseLong = Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
                mediaMetadataRetriever.release();
                this.bat.put(str, Long.valueOf(parseLong));
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

    public static boolean Nt() {
        ArrayList<com.baidu.swan.apps.media.a> Ek = com.baidu.swan.apps.media.b.Ek();
        if (Ek != null && Ek.size() > 0) {
            int size = Ek.size();
            for (int i = 0; i < size; i++) {
                com.baidu.swan.apps.media.a aVar = Ek.get(i);
                if ((aVar instanceof AudioPlayer) && !((AudioPlayer) aVar).Nh().isPaused()) {
                    return true;
                }
            }
        }
        return false;
    }
}

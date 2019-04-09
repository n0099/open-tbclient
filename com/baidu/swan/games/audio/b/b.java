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
    private static volatile b baq;
    private d bat;
    private HandlerThread mAudioThread;
    private Handler mHandler;
    private HashMap<String, Long> bau = new HashMap<>();
    private String bav = com.baidu.swan.games.audio.e.Nl();
    private com.baidu.swan.games.audio.a.b bas = new com.baidu.swan.games.audio.a.b(this.bav);

    private b() {
        createAudioThread();
    }

    public static b Nr() {
        if (baq == null) {
            synchronized (AudioManager.class) {
                if (baq == null) {
                    baq = new b();
                }
            }
        }
        return baq;
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
        this.bas.a(str, aVar);
    }

    public String hZ(String str) throws MalformedURLException {
        return this.bav + com.baidu.swan.games.audio.e.hW(str);
    }

    public synchronized e ia(String str) {
        e aVar;
        long ib = ib(str);
        if (3000 >= ib) {
            if (this.bat == null) {
                this.bat = new d();
            } else if (this.bat.Nw()) {
                this.bat.release();
                this.bat = null;
                this.bat = new d();
            }
            if (DEBUG) {
                Log.e("AudioPlayerManager", "create sound pool src = " + str);
            }
            aVar = this.bat.P(ib);
        } else {
            if (DEBUG) {
                Log.e("AudioPlayerManager", "create media player src = " + str);
            }
            aVar = new a();
        }
        return aVar;
    }

    private long ib(String str) {
        if (this.bau.containsKey(str)) {
            return this.bau.get(str).longValue();
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(str);
                long parseLong = Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
                mediaMetadataRetriever.release();
                this.bau.put(str, Long.valueOf(parseLong));
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

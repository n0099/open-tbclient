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
    private static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    private static volatile b bal;
    private d ban;
    private HandlerThread mAudioThread;
    private Handler mHandler;
    private HashMap<String, Long> bao = new HashMap<>();
    private String bap = com.baidu.swan.games.audio.e.Nn();
    private com.baidu.swan.games.audio.a.b bam = new com.baidu.swan.games.audio.a.b(this.bap);

    private b() {
        createAudioThread();
    }

    public static b Nt() {
        if (bal == null) {
            synchronized (AudioManager.class) {
                if (bal == null) {
                    bal = new b();
                }
            }
        }
        return bal;
    }

    private void createAudioThread() {
        if (this.mAudioThread == null) {
            this.mAudioThread = new HandlerThread("audio_thread");
            this.mAudioThread.start();
            this.mHandler = new Handler(this.mAudioThread.getLooper());
        }
    }

    public Handler Nu() {
        return this.mHandler;
    }

    public void a(String str, com.baidu.swan.games.audio.a.a aVar) {
        this.bam.a(str, aVar);
    }

    public String hY(String str) throws MalformedURLException {
        return this.bap + com.baidu.swan.games.audio.e.hV(str);
    }

    public synchronized e hZ(String str) {
        e aVar;
        long ia = ia(str);
        if (3000 >= ia) {
            if (this.ban == null) {
                this.ban = new d();
            } else if (this.ban.Ny()) {
                this.ban.release();
                this.ban = null;
                this.ban = new d();
            }
            if (DEBUG) {
                Log.e("AudioPlayerManager", "create sound pool src = " + str);
            }
            aVar = this.ban.P(ia);
        } else {
            if (DEBUG) {
                Log.e("AudioPlayerManager", "create media player src = " + str);
            }
            aVar = new a();
        }
        return aVar;
    }

    private long ia(String str) {
        if (this.bao.containsKey(str)) {
            return this.bao.get(str).longValue();
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(str);
                long parseLong = Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
                mediaMetadataRetriever.release();
                this.bao.put(str, Long.valueOf(parseLong));
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

    public static boolean Nv() {
        ArrayList<com.baidu.swan.apps.media.a> Em = com.baidu.swan.apps.media.b.Em();
        if (Em != null && Em.size() > 0) {
            int size = Em.size();
            for (int i = 0; i < size; i++) {
                com.baidu.swan.apps.media.a aVar = Em.get(i);
                if ((aVar instanceof AudioPlayer) && !((AudioPlayer) aVar).Nj().isPaused()) {
                    return true;
                }
            }
        }
        return false;
    }
}

package com.baidu.swan.games.audio.b;

import android.media.MediaPlayer;
import android.os.Handler;
import com.baidu.swan.nalib.audio.SwanAudioPlayer;
import java.io.File;
/* loaded from: classes9.dex */
public class d implements c {
    private int eck;
    private MediaPlayer.OnPreparedListener edc;
    private MediaPlayer.OnCompletionListener edd;
    private MediaPlayer.OnErrorListener ede;
    private MediaPlayer.OnSeekCompleteListener edf;
    private com.baidu.swan.nalib.audio.c edg;
    private boolean mLoop;
    private String mSrc;
    private float mVolume;
    private SwanAudioPlayer edb = SwanAudioPlayer.getInstance();
    private Handler edh = b.aUd().aUf();

    @Override // com.baidu.swan.games.audio.a
    public void play() {
        this.edh.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.1
            @Override // java.lang.Runnable
            public void run() {
                if (2 != d.this.edb.getState(d.this.eck)) {
                    d.this.edb.play(d.this.eck, d.this.mVolume, d.this.mLoop);
                }
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void pause() {
        this.edh.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.2
            @Override // java.lang.Runnable
            public void run() {
                d.this.edb.pause(d.this.eck);
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void seek(final float f) {
        this.edh.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.this.edb.seek(d.this.eck, (int) f);
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void stop() {
        this.edh.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.4
            @Override // java.lang.Runnable
            public void run() {
                d.this.edb.stop(d.this.eck);
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void destroy() {
        this.edb.release(this.eck);
        stop();
    }

    @Override // com.baidu.swan.games.audio.a
    public int getDuration() {
        return this.edb.getDuration(this.eck);
    }

    @Override // com.baidu.swan.games.audio.a
    public int getCurrentTime() {
        return this.edb.getPosition(this.eck);
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setSrc(final String str) throws Exception {
        this.edh.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.5
            @Override // java.lang.Runnable
            public void run() {
                d.this.mSrc = str;
                File file = new File(str);
                if (file.exists() && !file.isDirectory()) {
                    d.this.eck = d.this.edb.setDataSource(str, (int) file.length());
                    d.this.edb.setOnPreparedListener(d.this.eck, new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.games.audio.b.d.5.1
                        @Override // android.media.MediaPlayer.OnPreparedListener
                        public void onPrepared(MediaPlayer mediaPlayer) {
                            if (d.this.edc != null) {
                                d.this.edc.onPrepared(mediaPlayer);
                            }
                        }
                    });
                    d.this.edb.setOnCompletionListener(d.this.eck, new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.games.audio.b.d.5.2
                        @Override // android.media.MediaPlayer.OnCompletionListener
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            if (d.this.edd != null) {
                                d.this.edd.onCompletion(mediaPlayer);
                            }
                        }
                    });
                    d.this.edb.setOnSeekCompleteListener(d.this.eck, new MediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.swan.games.audio.b.d.5.3
                        @Override // android.media.MediaPlayer.OnSeekCompleteListener
                        public void onSeekComplete(MediaPlayer mediaPlayer) {
                            if (d.this.edf != null) {
                                d.this.edf.onSeekComplete(mediaPlayer);
                            }
                        }
                    });
                    d.this.edb.setOnErrorListener(d.this.eck, new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.games.audio.b.d.5.4
                        @Override // android.media.MediaPlayer.OnErrorListener
                        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                            if (d.this.ede != null) {
                                return d.this.ede.onError(mediaPlayer, i, i2);
                            }
                            return false;
                        }
                    });
                    d.this.edb.setOnPauseListener(d.this.eck, new com.baidu.swan.nalib.audio.c() { // from class: com.baidu.swan.games.audio.b.d.5.5
                        @Override // com.baidu.swan.nalib.audio.c
                        public void onPause() {
                            if (d.this.edg != null) {
                                d.this.edg.onPause();
                            }
                        }
                    });
                    d.this.edb.prepare(d.this.eck);
                }
            }
        });
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void hZ(final boolean z) {
        this.edh.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.6
            @Override // java.lang.Runnable
            public void run() {
                if (2 == d.this.edb.getState(d.this.eck)) {
                    d.this.edb.setLoop(d.this.eck, z);
                }
                d.this.mLoop = z;
            }
        });
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setVolume(final float f) {
        this.edh.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.7
            @Override // java.lang.Runnable
            public void run() {
                if (2 == d.this.edb.getState(d.this.eck)) {
                    d.this.edb.setVolume(d.this.eck, f);
                }
                d.this.mVolume = f;
            }
        });
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.edc = onPreparedListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.edd = onCompletionListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.ede = onErrorListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void a(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.edf = onSeekCompleteListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void a(MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void a(com.baidu.swan.nalib.audio.c cVar) {
        this.edg = cVar;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public boolean aUh() {
        return false;
    }
}

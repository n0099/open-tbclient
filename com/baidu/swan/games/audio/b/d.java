package com.baidu.swan.games.audio.b;

import android.media.MediaPlayer;
import android.os.Handler;
import com.baidu.swan.nalib.audio.SwanAudioPlayer;
import java.io.File;
/* loaded from: classes3.dex */
public class d implements c {
    private int dqj;
    private MediaPlayer.OnPreparedListener drb;
    private MediaPlayer.OnCompletionListener drc;
    private MediaPlayer.OnErrorListener drd;
    private MediaPlayer.OnSeekCompleteListener dre;
    private com.baidu.swan.nalib.audio.c drf;
    private boolean mLoop;
    private String mSrc;
    private float mVolume;
    private SwanAudioPlayer dra = SwanAudioPlayer.getInstance();
    private Handler drg = b.aLQ().aLS();

    @Override // com.baidu.swan.games.audio.a
    public void play() {
        this.drg.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.1
            @Override // java.lang.Runnable
            public void run() {
                if (2 != d.this.dra.getState(d.this.dqj)) {
                    d.this.dra.play(d.this.dqj, d.this.mVolume, d.this.mLoop);
                }
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void pause() {
        this.drg.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.2
            @Override // java.lang.Runnable
            public void run() {
                d.this.dra.pause(d.this.dqj);
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void seek(final float f) {
        this.drg.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.this.dra.seek(d.this.dqj, (int) f);
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void stop() {
        this.drg.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.4
            @Override // java.lang.Runnable
            public void run() {
                d.this.dra.stop(d.this.dqj);
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void destroy() {
        this.dra.release(this.dqj);
        stop();
    }

    @Override // com.baidu.swan.games.audio.a
    public int getDuration() {
        return this.dra.getDuration(this.dqj);
    }

    @Override // com.baidu.swan.games.audio.a
    public int getCurrentTime() {
        return this.dra.getPosition(this.dqj);
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setSrc(final String str) throws Exception {
        this.drg.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.5
            @Override // java.lang.Runnable
            public void run() {
                d.this.mSrc = str;
                File file = new File(str);
                if (file.exists() && !file.isDirectory()) {
                    d.this.dqj = d.this.dra.setDataSource(str, (int) file.length());
                    d.this.dra.setOnPreparedListener(d.this.dqj, new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.games.audio.b.d.5.1
                        @Override // android.media.MediaPlayer.OnPreparedListener
                        public void onPrepared(MediaPlayer mediaPlayer) {
                            if (d.this.drb != null) {
                                d.this.drb.onPrepared(mediaPlayer);
                            }
                        }
                    });
                    d.this.dra.setOnCompletionListener(d.this.dqj, new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.games.audio.b.d.5.2
                        @Override // android.media.MediaPlayer.OnCompletionListener
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            if (d.this.drc != null) {
                                d.this.drc.onCompletion(mediaPlayer);
                            }
                        }
                    });
                    d.this.dra.setOnSeekCompleteListener(d.this.dqj, new MediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.swan.games.audio.b.d.5.3
                        @Override // android.media.MediaPlayer.OnSeekCompleteListener
                        public void onSeekComplete(MediaPlayer mediaPlayer) {
                            if (d.this.dre != null) {
                                d.this.dre.onSeekComplete(mediaPlayer);
                            }
                        }
                    });
                    d.this.dra.setOnErrorListener(d.this.dqj, new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.games.audio.b.d.5.4
                        @Override // android.media.MediaPlayer.OnErrorListener
                        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                            if (d.this.drd != null) {
                                return d.this.drd.onError(mediaPlayer, i, i2);
                            }
                            return false;
                        }
                    });
                    d.this.dra.setOnPauseListener(d.this.dqj, new com.baidu.swan.nalib.audio.c() { // from class: com.baidu.swan.games.audio.b.d.5.5
                        @Override // com.baidu.swan.nalib.audio.c
                        public void onPause() {
                            if (d.this.drf != null) {
                                d.this.drf.onPause();
                            }
                        }
                    });
                    d.this.dra.prepare(d.this.dqj);
                }
            }
        });
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void gz(final boolean z) {
        this.drg.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.6
            @Override // java.lang.Runnable
            public void run() {
                if (2 == d.this.dra.getState(d.this.dqj)) {
                    d.this.dra.setLoop(d.this.dqj, z);
                }
                d.this.mLoop = z;
            }
        });
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setVolume(final float f) {
        this.drg.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.7
            @Override // java.lang.Runnable
            public void run() {
                if (2 == d.this.dra.getState(d.this.dqj)) {
                    d.this.dra.setVolume(d.this.dqj, f);
                }
                d.this.mVolume = f;
            }
        });
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.drb = onPreparedListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.drc = onCompletionListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.drd = onErrorListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void a(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.dre = onSeekCompleteListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void a(MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void a(com.baidu.swan.nalib.audio.c cVar) {
        this.drf = cVar;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public boolean aLU() {
        return false;
    }
}

package com.baidu.swan.games.audio.b;

import android.media.MediaPlayer;
import android.os.Handler;
import com.baidu.swan.nalib.audio.SwanAudioPlayer;
import java.io.File;
/* loaded from: classes8.dex */
public class d implements c {
    private MediaPlayer.OnPreparedListener eaV;
    private MediaPlayer.OnCompletionListener eaW;
    private MediaPlayer.OnErrorListener eaX;
    private MediaPlayer.OnSeekCompleteListener eaY;
    private com.baidu.swan.nalib.audio.c eaZ;
    private int ead;
    private boolean mLoop;
    private String mSrc;
    private float mVolume;
    private SwanAudioPlayer eaU = SwanAudioPlayer.getInstance();
    private Handler eba = b.aTR().aTT();

    @Override // com.baidu.swan.games.audio.a
    public void play() {
        this.eba.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.1
            @Override // java.lang.Runnable
            public void run() {
                if (2 != d.this.eaU.getState(d.this.ead)) {
                    d.this.eaU.play(d.this.ead, d.this.mVolume, d.this.mLoop);
                }
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void pause() {
        this.eba.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.2
            @Override // java.lang.Runnable
            public void run() {
                d.this.eaU.pause(d.this.ead);
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void seek(final float f) {
        this.eba.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.this.eaU.seek(d.this.ead, (int) f);
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void stop() {
        this.eba.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.4
            @Override // java.lang.Runnable
            public void run() {
                d.this.eaU.stop(d.this.ead);
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void destroy() {
        this.eaU.release(this.ead);
        stop();
    }

    @Override // com.baidu.swan.games.audio.a
    public int getDuration() {
        return this.eaU.getDuration(this.ead);
    }

    @Override // com.baidu.swan.games.audio.a
    public int getCurrentTime() {
        return this.eaU.getPosition(this.ead);
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setSrc(final String str) throws Exception {
        this.eba.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.5
            @Override // java.lang.Runnable
            public void run() {
                d.this.mSrc = str;
                File file = new File(str);
                if (file.exists() && !file.isDirectory()) {
                    d.this.ead = d.this.eaU.setDataSource(str, (int) file.length());
                    d.this.eaU.setOnPreparedListener(d.this.ead, new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.games.audio.b.d.5.1
                        @Override // android.media.MediaPlayer.OnPreparedListener
                        public void onPrepared(MediaPlayer mediaPlayer) {
                            if (d.this.eaV != null) {
                                d.this.eaV.onPrepared(mediaPlayer);
                            }
                        }
                    });
                    d.this.eaU.setOnCompletionListener(d.this.ead, new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.games.audio.b.d.5.2
                        @Override // android.media.MediaPlayer.OnCompletionListener
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            if (d.this.eaW != null) {
                                d.this.eaW.onCompletion(mediaPlayer);
                            }
                        }
                    });
                    d.this.eaU.setOnSeekCompleteListener(d.this.ead, new MediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.swan.games.audio.b.d.5.3
                        @Override // android.media.MediaPlayer.OnSeekCompleteListener
                        public void onSeekComplete(MediaPlayer mediaPlayer) {
                            if (d.this.eaY != null) {
                                d.this.eaY.onSeekComplete(mediaPlayer);
                            }
                        }
                    });
                    d.this.eaU.setOnErrorListener(d.this.ead, new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.games.audio.b.d.5.4
                        @Override // android.media.MediaPlayer.OnErrorListener
                        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                            if (d.this.eaX != null) {
                                return d.this.eaX.onError(mediaPlayer, i, i2);
                            }
                            return false;
                        }
                    });
                    d.this.eaU.setOnPauseListener(d.this.ead, new com.baidu.swan.nalib.audio.c() { // from class: com.baidu.swan.games.audio.b.d.5.5
                        @Override // com.baidu.swan.nalib.audio.c
                        public void onPause() {
                            if (d.this.eaZ != null) {
                                d.this.eaZ.onPause();
                            }
                        }
                    });
                    d.this.eaU.prepare(d.this.ead);
                }
            }
        });
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void hX(final boolean z) {
        this.eba.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.6
            @Override // java.lang.Runnable
            public void run() {
                if (2 == d.this.eaU.getState(d.this.ead)) {
                    d.this.eaU.setLoop(d.this.ead, z);
                }
                d.this.mLoop = z;
            }
        });
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setVolume(final float f) {
        this.eba.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.7
            @Override // java.lang.Runnable
            public void run() {
                if (2 == d.this.eaU.getState(d.this.ead)) {
                    d.this.eaU.setVolume(d.this.ead, f);
                }
                d.this.mVolume = f;
            }
        });
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.eaV = onPreparedListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.eaW = onCompletionListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.eaX = onErrorListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void a(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.eaY = onSeekCompleteListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void a(MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void a(com.baidu.swan.nalib.audio.c cVar) {
        this.eaZ = cVar;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public boolean aTV() {
        return false;
    }
}

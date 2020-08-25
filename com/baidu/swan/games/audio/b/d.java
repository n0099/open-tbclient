package com.baidu.swan.games.audio.b;

import android.media.MediaPlayer;
import android.os.Handler;
import com.baidu.swan.nalib.audio.SwanAudioPlayer;
import java.io.File;
/* loaded from: classes8.dex */
public class d implements c {
    private MediaPlayer.OnPreparedListener doW;
    private MediaPlayer.OnCompletionListener doX;
    private MediaPlayer.OnErrorListener doY;
    private MediaPlayer.OnSeekCompleteListener doZ;
    private int doe;
    private com.baidu.swan.nalib.audio.c dpa;
    private boolean mLoop;
    private String mSrc;
    private float mVolume;
    private SwanAudioPlayer doV = SwanAudioPlayer.getInstance();
    private Handler dpb = b.aLf().aLh();

    @Override // com.baidu.swan.games.audio.a
    public void play() {
        this.dpb.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.1
            @Override // java.lang.Runnable
            public void run() {
                if (2 != d.this.doV.getState(d.this.doe)) {
                    d.this.doV.play(d.this.doe, d.this.mVolume, d.this.mLoop);
                }
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void pause() {
        this.dpb.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.2
            @Override // java.lang.Runnable
            public void run() {
                d.this.doV.pause(d.this.doe);
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void seek(final float f) {
        this.dpb.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.this.doV.seek(d.this.doe, (int) f);
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void stop() {
        this.dpb.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.4
            @Override // java.lang.Runnable
            public void run() {
                d.this.doV.stop(d.this.doe);
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void destroy() {
        this.doV.release(this.doe);
        stop();
    }

    @Override // com.baidu.swan.games.audio.a
    public int getDuration() {
        return this.doV.getDuration(this.doe);
    }

    @Override // com.baidu.swan.games.audio.a
    public int getCurrentTime() {
        return this.doV.getPosition(this.doe);
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setSrc(final String str) throws Exception {
        this.dpb.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.5
            @Override // java.lang.Runnable
            public void run() {
                d.this.mSrc = str;
                File file = new File(str);
                if (file.exists() && !file.isDirectory()) {
                    d.this.doe = d.this.doV.setDataSource(str, (int) file.length());
                    d.this.doV.setOnPreparedListener(d.this.doe, new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.games.audio.b.d.5.1
                        @Override // android.media.MediaPlayer.OnPreparedListener
                        public void onPrepared(MediaPlayer mediaPlayer) {
                            if (d.this.doW != null) {
                                d.this.doW.onPrepared(mediaPlayer);
                            }
                        }
                    });
                    d.this.doV.setOnCompletionListener(d.this.doe, new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.games.audio.b.d.5.2
                        @Override // android.media.MediaPlayer.OnCompletionListener
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            if (d.this.doX != null) {
                                d.this.doX.onCompletion(mediaPlayer);
                            }
                        }
                    });
                    d.this.doV.setOnSeekCompleteListener(d.this.doe, new MediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.swan.games.audio.b.d.5.3
                        @Override // android.media.MediaPlayer.OnSeekCompleteListener
                        public void onSeekComplete(MediaPlayer mediaPlayer) {
                            if (d.this.doZ != null) {
                                d.this.doZ.onSeekComplete(mediaPlayer);
                            }
                        }
                    });
                    d.this.doV.setOnErrorListener(d.this.doe, new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.games.audio.b.d.5.4
                        @Override // android.media.MediaPlayer.OnErrorListener
                        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                            if (d.this.doY != null) {
                                return d.this.doY.onError(mediaPlayer, i, i2);
                            }
                            return false;
                        }
                    });
                    d.this.doV.setOnPauseListener(d.this.doe, new com.baidu.swan.nalib.audio.c() { // from class: com.baidu.swan.games.audio.b.d.5.5
                        @Override // com.baidu.swan.nalib.audio.c
                        public void onPause() {
                            if (d.this.dpa != null) {
                                d.this.dpa.onPause();
                            }
                        }
                    });
                    d.this.doV.prepare(d.this.doe);
                }
            }
        });
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void gA(final boolean z) {
        this.dpb.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.6
            @Override // java.lang.Runnable
            public void run() {
                if (2 == d.this.doV.getState(d.this.doe)) {
                    d.this.doV.setLoop(d.this.doe, z);
                }
                d.this.mLoop = z;
            }
        });
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setVolume(final float f) {
        this.dpb.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.7
            @Override // java.lang.Runnable
            public void run() {
                if (2 == d.this.doV.getState(d.this.doe)) {
                    d.this.doV.setVolume(d.this.doe, f);
                }
                d.this.mVolume = f;
            }
        });
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.doW = onPreparedListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.doX = onCompletionListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.doY = onErrorListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void a(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.doZ = onSeekCompleteListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void a(MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void a(com.baidu.swan.nalib.audio.c cVar) {
        this.dpa = cVar;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public boolean aLj() {
        return false;
    }
}

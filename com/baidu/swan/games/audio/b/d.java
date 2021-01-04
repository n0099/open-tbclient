package com.baidu.swan.games.audio.b;

import android.media.MediaPlayer;
import android.os.Handler;
import com.baidu.swan.nalib.audio.SwanAudioPlayer;
import java.io.File;
/* loaded from: classes9.dex */
public class d implements c {
    private int eeP;
    private MediaPlayer.OnPreparedListener efH;
    private MediaPlayer.OnCompletionListener efI;
    private MediaPlayer.OnErrorListener efJ;
    private MediaPlayer.OnSeekCompleteListener efK;
    private com.baidu.swan.nalib.audio.c efL;
    private boolean mLoop;
    private String mSrc;
    private float mVolume;
    private SwanAudioPlayer efG = SwanAudioPlayer.getInstance();
    private Handler efM = b.aXK().aXM();

    @Override // com.baidu.swan.games.audio.a
    public void play() {
        this.efM.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.1
            @Override // java.lang.Runnable
            public void run() {
                if (2 != d.this.efG.getState(d.this.eeP)) {
                    d.this.efG.play(d.this.eeP, d.this.mVolume, d.this.mLoop);
                }
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void pause() {
        this.efM.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.2
            @Override // java.lang.Runnable
            public void run() {
                d.this.efG.pause(d.this.eeP);
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void seek(final float f) {
        this.efM.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.this.efG.seek(d.this.eeP, (int) f);
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void stop() {
        this.efM.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.4
            @Override // java.lang.Runnable
            public void run() {
                d.this.efG.stop(d.this.eeP);
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void destroy() {
        this.efG.release(this.eeP);
        stop();
    }

    @Override // com.baidu.swan.games.audio.a
    public int getDuration() {
        return this.efG.getDuration(this.eeP);
    }

    @Override // com.baidu.swan.games.audio.a
    public int getCurrentTime() {
        return this.efG.getPosition(this.eeP);
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setSrc(final String str) throws Exception {
        this.efM.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.5
            @Override // java.lang.Runnable
            public void run() {
                d.this.mSrc = str;
                File file = new File(str);
                if (file.exists() && !file.isDirectory()) {
                    d.this.eeP = d.this.efG.setDataSource(str, (int) file.length());
                    d.this.efG.setOnPreparedListener(d.this.eeP, new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.games.audio.b.d.5.1
                        @Override // android.media.MediaPlayer.OnPreparedListener
                        public void onPrepared(MediaPlayer mediaPlayer) {
                            if (d.this.efH != null) {
                                d.this.efH.onPrepared(mediaPlayer);
                            }
                        }
                    });
                    d.this.efG.setOnCompletionListener(d.this.eeP, new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.games.audio.b.d.5.2
                        @Override // android.media.MediaPlayer.OnCompletionListener
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            if (d.this.efI != null) {
                                d.this.efI.onCompletion(mediaPlayer);
                            }
                        }
                    });
                    d.this.efG.setOnSeekCompleteListener(d.this.eeP, new MediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.swan.games.audio.b.d.5.3
                        @Override // android.media.MediaPlayer.OnSeekCompleteListener
                        public void onSeekComplete(MediaPlayer mediaPlayer) {
                            if (d.this.efK != null) {
                                d.this.efK.onSeekComplete(mediaPlayer);
                            }
                        }
                    });
                    d.this.efG.setOnErrorListener(d.this.eeP, new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.games.audio.b.d.5.4
                        @Override // android.media.MediaPlayer.OnErrorListener
                        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                            if (d.this.efJ != null) {
                                return d.this.efJ.onError(mediaPlayer, i, i2);
                            }
                            return false;
                        }
                    });
                    d.this.efG.setOnPauseListener(d.this.eeP, new com.baidu.swan.nalib.audio.c() { // from class: com.baidu.swan.games.audio.b.d.5.5
                        @Override // com.baidu.swan.nalib.audio.c
                        public void onPause() {
                            if (d.this.efL != null) {
                                d.this.efL.onPause();
                            }
                        }
                    });
                    d.this.efG.prepare(d.this.eeP);
                }
            }
        });
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void ib(final boolean z) {
        this.efM.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.6
            @Override // java.lang.Runnable
            public void run() {
                if (2 == d.this.efG.getState(d.this.eeP)) {
                    d.this.efG.setLoop(d.this.eeP, z);
                }
                d.this.mLoop = z;
            }
        });
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setVolume(final float f) {
        this.efM.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.7
            @Override // java.lang.Runnable
            public void run() {
                if (2 == d.this.efG.getState(d.this.eeP)) {
                    d.this.efG.setVolume(d.this.eeP, f);
                }
                d.this.mVolume = f;
            }
        });
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.efH = onPreparedListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.efI = onCompletionListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.efJ = onErrorListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void a(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.efK = onSeekCompleteListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void a(MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void a(com.baidu.swan.nalib.audio.c cVar) {
        this.efL = cVar;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public boolean aXO() {
        return false;
    }
}

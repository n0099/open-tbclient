package com.baidu.swan.games.audio.b;

import android.media.MediaPlayer;
import android.os.Handler;
import com.baidu.swan.nalib.audio.SwanAudioPlayer;
import java.io.File;
/* loaded from: classes11.dex */
public class d implements c {
    private int cIO;
    private MediaPlayer.OnPreparedListener cJG;
    private MediaPlayer.OnCompletionListener cJH;
    private MediaPlayer.OnErrorListener cJI;
    private MediaPlayer.OnSeekCompleteListener cJJ;
    private com.baidu.swan.nalib.audio.c cJK;
    private boolean mLoop;
    private String mSrc;
    private float mVolume;
    private SwanAudioPlayer cJF = SwanAudioPlayer.getInstance();
    private Handler cJL = b.atS().atU();

    @Override // com.baidu.swan.games.audio.a
    public void play() {
        this.cJL.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.1
            @Override // java.lang.Runnable
            public void run() {
                if (2 != d.this.cJF.getState(d.this.cIO)) {
                    d.this.cJF.play(d.this.cIO, d.this.mVolume, d.this.mLoop);
                }
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void pause() {
        this.cJL.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.2
            @Override // java.lang.Runnable
            public void run() {
                d.this.cJF.pause(d.this.cIO);
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void seek(final float f) {
        this.cJL.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.this.cJF.seek(d.this.cIO, (int) f);
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void stop() {
        this.cJL.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.4
            @Override // java.lang.Runnable
            public void run() {
                d.this.cJF.stop(d.this.cIO);
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void destroy() {
        this.cJF.release(this.cIO);
        stop();
    }

    @Override // com.baidu.swan.games.audio.a
    public int getDuration() {
        return this.cJF.getDuration(this.cIO);
    }

    @Override // com.baidu.swan.games.audio.a
    public int getCurrentTime() {
        return this.cJF.getPosition(this.cIO);
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setSrc(final String str) throws Exception {
        this.cJL.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.5
            @Override // java.lang.Runnable
            public void run() {
                d.this.mSrc = str;
                File file = new File(str);
                if (file.exists() && !file.isDirectory()) {
                    d.this.cIO = d.this.cJF.setDataSource(str, (int) file.length());
                    d.this.cJF.setOnPreparedListener(d.this.cIO, new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.games.audio.b.d.5.1
                        @Override // android.media.MediaPlayer.OnPreparedListener
                        public void onPrepared(MediaPlayer mediaPlayer) {
                            if (d.this.cJG != null) {
                                d.this.cJG.onPrepared(mediaPlayer);
                            }
                        }
                    });
                    d.this.cJF.setOnCompletionListener(d.this.cIO, new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.games.audio.b.d.5.2
                        @Override // android.media.MediaPlayer.OnCompletionListener
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            if (d.this.cJH != null) {
                                d.this.cJH.onCompletion(mediaPlayer);
                            }
                        }
                    });
                    d.this.cJF.setOnSeekCompleteListener(d.this.cIO, new MediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.swan.games.audio.b.d.5.3
                        @Override // android.media.MediaPlayer.OnSeekCompleteListener
                        public void onSeekComplete(MediaPlayer mediaPlayer) {
                            if (d.this.cJJ != null) {
                                d.this.cJJ.onSeekComplete(mediaPlayer);
                            }
                        }
                    });
                    d.this.cJF.setOnErrorListener(d.this.cIO, new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.games.audio.b.d.5.4
                        @Override // android.media.MediaPlayer.OnErrorListener
                        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                            if (d.this.cJI != null) {
                                return d.this.cJI.onError(mediaPlayer, i, i2);
                            }
                            return false;
                        }
                    });
                    d.this.cJF.setOnPauseListener(d.this.cIO, new com.baidu.swan.nalib.audio.c() { // from class: com.baidu.swan.games.audio.b.d.5.5
                        @Override // com.baidu.swan.nalib.audio.c
                        public void onPause() {
                            if (d.this.cJK != null) {
                                d.this.cJK.onPause();
                            }
                        }
                    });
                    d.this.cJF.prepare(d.this.cIO);
                }
            }
        });
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void fx(final boolean z) {
        this.cJL.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.6
            @Override // java.lang.Runnable
            public void run() {
                if (2 == d.this.cJF.getState(d.this.cIO)) {
                    d.this.cJF.setLoop(d.this.cIO, z);
                }
                d.this.mLoop = z;
            }
        });
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setVolume(final float f) {
        this.cJL.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.7
            @Override // java.lang.Runnable
            public void run() {
                if (2 == d.this.cJF.getState(d.this.cIO)) {
                    d.this.cJF.setVolume(d.this.cIO, f);
                }
                d.this.mVolume = f;
            }
        });
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.cJG = onPreparedListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.cJH = onCompletionListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.cJI = onErrorListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void a(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.cJJ = onSeekCompleteListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void a(MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void a(com.baidu.swan.nalib.audio.c cVar) {
        this.cJK = cVar;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public boolean atW() {
        return false;
    }
}

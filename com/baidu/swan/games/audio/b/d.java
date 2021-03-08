package com.baidu.swan.games.audio.b;

import android.media.MediaPlayer;
import android.os.Handler;
import com.baidu.swan.nalib.audio.SwanAudioPlayer;
import java.io.File;
/* loaded from: classes8.dex */
public class d implements c {
    private int edL;
    private MediaPlayer.OnPreparedListener eeD;
    private MediaPlayer.OnCompletionListener eeE;
    private MediaPlayer.OnErrorListener eeF;
    private MediaPlayer.OnSeekCompleteListener eeG;
    private com.baidu.swan.nalib.audio.c eeH;
    private boolean mLoop;
    private String mSrc;
    private float mVolume;
    private SwanAudioPlayer eeC = SwanAudioPlayer.getInstance();
    private Handler eeI = b.aUg().aUi();

    @Override // com.baidu.swan.games.audio.a
    public void play() {
        this.eeI.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.1
            @Override // java.lang.Runnable
            public void run() {
                if (2 != d.this.eeC.getState(d.this.edL)) {
                    d.this.eeC.play(d.this.edL, d.this.mVolume, d.this.mLoop);
                }
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void pause() {
        this.eeI.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.2
            @Override // java.lang.Runnable
            public void run() {
                d.this.eeC.pause(d.this.edL);
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void seek(final float f) {
        this.eeI.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.this.eeC.seek(d.this.edL, (int) f);
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void stop() {
        this.eeI.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.4
            @Override // java.lang.Runnable
            public void run() {
                d.this.eeC.stop(d.this.edL);
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void destroy() {
        this.eeC.release(this.edL);
        stop();
    }

    @Override // com.baidu.swan.games.audio.a
    public int getDuration() {
        return this.eeC.getDuration(this.edL);
    }

    @Override // com.baidu.swan.games.audio.a
    public int getCurrentTime() {
        return this.eeC.getPosition(this.edL);
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setSrc(final String str) throws Exception {
        this.eeI.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.5
            @Override // java.lang.Runnable
            public void run() {
                d.this.mSrc = str;
                File file = new File(str);
                if (file.exists() && !file.isDirectory()) {
                    d.this.edL = d.this.eeC.setDataSource(str, (int) file.length());
                    d.this.eeC.setOnPreparedListener(d.this.edL, new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.games.audio.b.d.5.1
                        @Override // android.media.MediaPlayer.OnPreparedListener
                        public void onPrepared(MediaPlayer mediaPlayer) {
                            if (d.this.eeD != null) {
                                d.this.eeD.onPrepared(mediaPlayer);
                            }
                        }
                    });
                    d.this.eeC.setOnCompletionListener(d.this.edL, new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.games.audio.b.d.5.2
                        @Override // android.media.MediaPlayer.OnCompletionListener
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            if (d.this.eeE != null) {
                                d.this.eeE.onCompletion(mediaPlayer);
                            }
                        }
                    });
                    d.this.eeC.setOnSeekCompleteListener(d.this.edL, new MediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.swan.games.audio.b.d.5.3
                        @Override // android.media.MediaPlayer.OnSeekCompleteListener
                        public void onSeekComplete(MediaPlayer mediaPlayer) {
                            if (d.this.eeG != null) {
                                d.this.eeG.onSeekComplete(mediaPlayer);
                            }
                        }
                    });
                    d.this.eeC.setOnErrorListener(d.this.edL, new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.games.audio.b.d.5.4
                        @Override // android.media.MediaPlayer.OnErrorListener
                        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                            if (d.this.eeF != null) {
                                return d.this.eeF.onError(mediaPlayer, i, i2);
                            }
                            return false;
                        }
                    });
                    d.this.eeC.setOnPauseListener(d.this.edL, new com.baidu.swan.nalib.audio.c() { // from class: com.baidu.swan.games.audio.b.d.5.5
                        @Override // com.baidu.swan.nalib.audio.c
                        public void onPause() {
                            if (d.this.eeH != null) {
                                d.this.eeH.onPause();
                            }
                        }
                    });
                    d.this.eeC.prepare(d.this.edL);
                }
            }
        });
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void hZ(final boolean z) {
        this.eeI.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.6
            @Override // java.lang.Runnable
            public void run() {
                if (2 == d.this.eeC.getState(d.this.edL)) {
                    d.this.eeC.setLoop(d.this.edL, z);
                }
                d.this.mLoop = z;
            }
        });
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setVolume(final float f) {
        this.eeI.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.7
            @Override // java.lang.Runnable
            public void run() {
                if (2 == d.this.eeC.getState(d.this.edL)) {
                    d.this.eeC.setVolume(d.this.edL, f);
                }
                d.this.mVolume = f;
            }
        });
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.eeD = onPreparedListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.eeE = onCompletionListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.eeF = onErrorListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void a(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.eeG = onSeekCompleteListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void a(MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void a(com.baidu.swan.nalib.audio.c cVar) {
        this.eeH = cVar;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public boolean aUk() {
        return false;
    }
}

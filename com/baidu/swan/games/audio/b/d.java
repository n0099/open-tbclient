package com.baidu.swan.games.audio.b;

import android.media.MediaPlayer;
import android.os.Handler;
import com.baidu.swan.nalib.audio.SwanAudioPlayer;
import java.io.File;
/* loaded from: classes10.dex */
public class d implements c {
    private int dKK;
    private MediaPlayer.OnPreparedListener dLC;
    private MediaPlayer.OnCompletionListener dLD;
    private MediaPlayer.OnErrorListener dLE;
    private MediaPlayer.OnSeekCompleteListener dLF;
    private com.baidu.swan.nalib.audio.c dLG;
    private boolean mLoop;
    private String mSrc;
    private float mVolume;
    private SwanAudioPlayer dLB = SwanAudioPlayer.getInstance();
    private Handler dLH = b.aQt().aQv();

    @Override // com.baidu.swan.games.audio.a
    public void play() {
        this.dLH.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.1
            @Override // java.lang.Runnable
            public void run() {
                if (2 != d.this.dLB.getState(d.this.dKK)) {
                    d.this.dLB.play(d.this.dKK, d.this.mVolume, d.this.mLoop);
                }
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void pause() {
        this.dLH.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.2
            @Override // java.lang.Runnable
            public void run() {
                d.this.dLB.pause(d.this.dKK);
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void seek(final float f) {
        this.dLH.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.this.dLB.seek(d.this.dKK, (int) f);
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void stop() {
        this.dLH.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.4
            @Override // java.lang.Runnable
            public void run() {
                d.this.dLB.stop(d.this.dKK);
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void destroy() {
        this.dLB.release(this.dKK);
        stop();
    }

    @Override // com.baidu.swan.games.audio.a
    public int getDuration() {
        return this.dLB.getDuration(this.dKK);
    }

    @Override // com.baidu.swan.games.audio.a
    public int getCurrentTime() {
        return this.dLB.getPosition(this.dKK);
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setSrc(final String str) throws Exception {
        this.dLH.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.5
            @Override // java.lang.Runnable
            public void run() {
                d.this.mSrc = str;
                File file = new File(str);
                if (file.exists() && !file.isDirectory()) {
                    d.this.dKK = d.this.dLB.setDataSource(str, (int) file.length());
                    d.this.dLB.setOnPreparedListener(d.this.dKK, new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.games.audio.b.d.5.1
                        @Override // android.media.MediaPlayer.OnPreparedListener
                        public void onPrepared(MediaPlayer mediaPlayer) {
                            if (d.this.dLC != null) {
                                d.this.dLC.onPrepared(mediaPlayer);
                            }
                        }
                    });
                    d.this.dLB.setOnCompletionListener(d.this.dKK, new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.games.audio.b.d.5.2
                        @Override // android.media.MediaPlayer.OnCompletionListener
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            if (d.this.dLD != null) {
                                d.this.dLD.onCompletion(mediaPlayer);
                            }
                        }
                    });
                    d.this.dLB.setOnSeekCompleteListener(d.this.dKK, new MediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.swan.games.audio.b.d.5.3
                        @Override // android.media.MediaPlayer.OnSeekCompleteListener
                        public void onSeekComplete(MediaPlayer mediaPlayer) {
                            if (d.this.dLF != null) {
                                d.this.dLF.onSeekComplete(mediaPlayer);
                            }
                        }
                    });
                    d.this.dLB.setOnErrorListener(d.this.dKK, new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.games.audio.b.d.5.4
                        @Override // android.media.MediaPlayer.OnErrorListener
                        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                            if (d.this.dLE != null) {
                                return d.this.dLE.onError(mediaPlayer, i, i2);
                            }
                            return false;
                        }
                    });
                    d.this.dLB.setOnPauseListener(d.this.dKK, new com.baidu.swan.nalib.audio.c() { // from class: com.baidu.swan.games.audio.b.d.5.5
                        @Override // com.baidu.swan.nalib.audio.c
                        public void onPause() {
                            if (d.this.dLG != null) {
                                d.this.dLG.onPause();
                            }
                        }
                    });
                    d.this.dLB.prepare(d.this.dKK);
                }
            }
        });
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void hi(final boolean z) {
        this.dLH.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.6
            @Override // java.lang.Runnable
            public void run() {
                if (2 == d.this.dLB.getState(d.this.dKK)) {
                    d.this.dLB.setLoop(d.this.dKK, z);
                }
                d.this.mLoop = z;
            }
        });
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setVolume(final float f) {
        this.dLH.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.7
            @Override // java.lang.Runnable
            public void run() {
                if (2 == d.this.dLB.getState(d.this.dKK)) {
                    d.this.dLB.setVolume(d.this.dKK, f);
                }
                d.this.mVolume = f;
            }
        });
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.dLC = onPreparedListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.dLD = onCompletionListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.dLE = onErrorListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void a(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.dLF = onSeekCompleteListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void a(MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void a(com.baidu.swan.nalib.audio.c cVar) {
        this.dLG = cVar;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public boolean aQx() {
        return false;
    }
}

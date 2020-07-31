package com.baidu.swan.games.audio.b;

import android.media.MediaPlayer;
import android.os.Handler;
import com.baidu.swan.nalib.audio.SwanAudioPlayer;
import java.io.File;
/* loaded from: classes7.dex */
public class d implements c {
    private int ddV;
    private MediaPlayer.OnPreparedListener deO;
    private MediaPlayer.OnCompletionListener deP;
    private MediaPlayer.OnErrorListener deQ;
    private MediaPlayer.OnSeekCompleteListener deR;
    private com.baidu.swan.nalib.audio.c deS;
    private boolean mLoop;
    private String mSrc;
    private float mVolume;
    private SwanAudioPlayer deN = SwanAudioPlayer.getInstance();
    private Handler deT = b.aCq().aCs();

    @Override // com.baidu.swan.games.audio.a
    public void play() {
        this.deT.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.1
            @Override // java.lang.Runnable
            public void run() {
                if (2 != d.this.deN.getState(d.this.ddV)) {
                    d.this.deN.play(d.this.ddV, d.this.mVolume, d.this.mLoop);
                }
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void pause() {
        this.deT.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.2
            @Override // java.lang.Runnable
            public void run() {
                d.this.deN.pause(d.this.ddV);
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void seek(final float f) {
        this.deT.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.this.deN.seek(d.this.ddV, (int) f);
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void stop() {
        this.deT.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.4
            @Override // java.lang.Runnable
            public void run() {
                d.this.deN.stop(d.this.ddV);
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void destroy() {
        this.deN.release(this.ddV);
        stop();
    }

    @Override // com.baidu.swan.games.audio.a
    public int getDuration() {
        return this.deN.getDuration(this.ddV);
    }

    @Override // com.baidu.swan.games.audio.a
    public int getCurrentTime() {
        return this.deN.getPosition(this.ddV);
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setSrc(final String str) throws Exception {
        this.deT.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.5
            @Override // java.lang.Runnable
            public void run() {
                d.this.mSrc = str;
                File file = new File(str);
                if (file.exists() && !file.isDirectory()) {
                    d.this.ddV = d.this.deN.setDataSource(str, (int) file.length());
                    d.this.deN.setOnPreparedListener(d.this.ddV, new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.games.audio.b.d.5.1
                        @Override // android.media.MediaPlayer.OnPreparedListener
                        public void onPrepared(MediaPlayer mediaPlayer) {
                            if (d.this.deO != null) {
                                d.this.deO.onPrepared(mediaPlayer);
                            }
                        }
                    });
                    d.this.deN.setOnCompletionListener(d.this.ddV, new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.games.audio.b.d.5.2
                        @Override // android.media.MediaPlayer.OnCompletionListener
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            if (d.this.deP != null) {
                                d.this.deP.onCompletion(mediaPlayer);
                            }
                        }
                    });
                    d.this.deN.setOnSeekCompleteListener(d.this.ddV, new MediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.swan.games.audio.b.d.5.3
                        @Override // android.media.MediaPlayer.OnSeekCompleteListener
                        public void onSeekComplete(MediaPlayer mediaPlayer) {
                            if (d.this.deR != null) {
                                d.this.deR.onSeekComplete(mediaPlayer);
                            }
                        }
                    });
                    d.this.deN.setOnErrorListener(d.this.ddV, new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.games.audio.b.d.5.4
                        @Override // android.media.MediaPlayer.OnErrorListener
                        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                            if (d.this.deQ != null) {
                                return d.this.deQ.onError(mediaPlayer, i, i2);
                            }
                            return false;
                        }
                    });
                    d.this.deN.setOnPauseListener(d.this.ddV, new com.baidu.swan.nalib.audio.c() { // from class: com.baidu.swan.games.audio.b.d.5.5
                        @Override // com.baidu.swan.nalib.audio.c
                        public void onPause() {
                            if (d.this.deS != null) {
                                d.this.deS.onPause();
                            }
                        }
                    });
                    d.this.deN.prepare(d.this.ddV);
                }
            }
        });
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void ge(final boolean z) {
        this.deT.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.6
            @Override // java.lang.Runnable
            public void run() {
                if (2 == d.this.deN.getState(d.this.ddV)) {
                    d.this.deN.setLoop(d.this.ddV, z);
                }
                d.this.mLoop = z;
            }
        });
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setVolume(final float f) {
        this.deT.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.7
            @Override // java.lang.Runnable
            public void run() {
                if (2 == d.this.deN.getState(d.this.ddV)) {
                    d.this.deN.setVolume(d.this.ddV, f);
                }
                d.this.mVolume = f;
            }
        });
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.deO = onPreparedListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.deP = onCompletionListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.deQ = onErrorListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void a(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.deR = onSeekCompleteListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void a(MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void a(com.baidu.swan.nalib.audio.c cVar) {
        this.deS = cVar;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public boolean aCu() {
        return false;
    }
}

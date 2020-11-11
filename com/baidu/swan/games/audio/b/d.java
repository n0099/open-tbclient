package com.baidu.swan.games.audio.b;

import android.media.MediaPlayer;
import android.os.Handler;
import com.baidu.swan.nalib.audio.SwanAudioPlayer;
import java.io.File;
/* loaded from: classes10.dex */
public class d implements c {
    private int dQC;
    private MediaPlayer.OnPreparedListener dRu;
    private MediaPlayer.OnCompletionListener dRv;
    private MediaPlayer.OnErrorListener dRw;
    private MediaPlayer.OnSeekCompleteListener dRx;
    private com.baidu.swan.nalib.audio.c dRy;
    private boolean mLoop;
    private String mSrc;
    private float mVolume;
    private SwanAudioPlayer dRt = SwanAudioPlayer.getInstance();
    private Handler dRz = b.aST().aSV();

    @Override // com.baidu.swan.games.audio.a
    public void play() {
        this.dRz.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.1
            @Override // java.lang.Runnable
            public void run() {
                if (2 != d.this.dRt.getState(d.this.dQC)) {
                    d.this.dRt.play(d.this.dQC, d.this.mVolume, d.this.mLoop);
                }
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void pause() {
        this.dRz.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.2
            @Override // java.lang.Runnable
            public void run() {
                d.this.dRt.pause(d.this.dQC);
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void seek(final float f) {
        this.dRz.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.this.dRt.seek(d.this.dQC, (int) f);
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void stop() {
        this.dRz.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.4
            @Override // java.lang.Runnable
            public void run() {
                d.this.dRt.stop(d.this.dQC);
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void destroy() {
        this.dRt.release(this.dQC);
        stop();
    }

    @Override // com.baidu.swan.games.audio.a
    public int getDuration() {
        return this.dRt.getDuration(this.dQC);
    }

    @Override // com.baidu.swan.games.audio.a
    public int getCurrentTime() {
        return this.dRt.getPosition(this.dQC);
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setSrc(final String str) throws Exception {
        this.dRz.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.5
            @Override // java.lang.Runnable
            public void run() {
                d.this.mSrc = str;
                File file = new File(str);
                if (file.exists() && !file.isDirectory()) {
                    d.this.dQC = d.this.dRt.setDataSource(str, (int) file.length());
                    d.this.dRt.setOnPreparedListener(d.this.dQC, new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.games.audio.b.d.5.1
                        @Override // android.media.MediaPlayer.OnPreparedListener
                        public void onPrepared(MediaPlayer mediaPlayer) {
                            if (d.this.dRu != null) {
                                d.this.dRu.onPrepared(mediaPlayer);
                            }
                        }
                    });
                    d.this.dRt.setOnCompletionListener(d.this.dQC, new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.games.audio.b.d.5.2
                        @Override // android.media.MediaPlayer.OnCompletionListener
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            if (d.this.dRv != null) {
                                d.this.dRv.onCompletion(mediaPlayer);
                            }
                        }
                    });
                    d.this.dRt.setOnSeekCompleteListener(d.this.dQC, new MediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.swan.games.audio.b.d.5.3
                        @Override // android.media.MediaPlayer.OnSeekCompleteListener
                        public void onSeekComplete(MediaPlayer mediaPlayer) {
                            if (d.this.dRx != null) {
                                d.this.dRx.onSeekComplete(mediaPlayer);
                            }
                        }
                    });
                    d.this.dRt.setOnErrorListener(d.this.dQC, new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.games.audio.b.d.5.4
                        @Override // android.media.MediaPlayer.OnErrorListener
                        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                            if (d.this.dRw != null) {
                                return d.this.dRw.onError(mediaPlayer, i, i2);
                            }
                            return false;
                        }
                    });
                    d.this.dRt.setOnPauseListener(d.this.dQC, new com.baidu.swan.nalib.audio.c() { // from class: com.baidu.swan.games.audio.b.d.5.5
                        @Override // com.baidu.swan.nalib.audio.c
                        public void onPause() {
                            if (d.this.dRy != null) {
                                d.this.dRy.onPause();
                            }
                        }
                    });
                    d.this.dRt.prepare(d.this.dQC);
                }
            }
        });
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void hr(final boolean z) {
        this.dRz.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.6
            @Override // java.lang.Runnable
            public void run() {
                if (2 == d.this.dRt.getState(d.this.dQC)) {
                    d.this.dRt.setLoop(d.this.dQC, z);
                }
                d.this.mLoop = z;
            }
        });
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setVolume(final float f) {
        this.dRz.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.7
            @Override // java.lang.Runnable
            public void run() {
                if (2 == d.this.dRt.getState(d.this.dQC)) {
                    d.this.dRt.setVolume(d.this.dQC, f);
                }
                d.this.mVolume = f;
            }
        });
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.dRu = onPreparedListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.dRv = onCompletionListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.dRw = onErrorListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void a(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.dRx = onSeekCompleteListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void a(MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void a(com.baidu.swan.nalib.audio.c cVar) {
        this.dRy = cVar;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public boolean aSX() {
        return false;
    }
}

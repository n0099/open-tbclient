package com.baidu.swan.games.audio.b;

import android.media.MediaPlayer;
import android.os.Handler;
import com.baidu.swan.nalib.audio.SwanAudioPlayer;
import java.io.File;
/* loaded from: classes11.dex */
public class d implements c {
    private int cTB;
    private MediaPlayer.OnPreparedListener cUt;
    private MediaPlayer.OnCompletionListener cUu;
    private MediaPlayer.OnErrorListener cUv;
    private MediaPlayer.OnSeekCompleteListener cUw;
    private com.baidu.swan.nalib.audio.c cUx;
    private boolean mLoop;
    private String mSrc;
    private float mVolume;
    private SwanAudioPlayer cUs = SwanAudioPlayer.getInstance();
    private Handler cUy = b.axF().axH();

    @Override // com.baidu.swan.games.audio.a
    public void play() {
        this.cUy.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.1
            @Override // java.lang.Runnable
            public void run() {
                if (2 != d.this.cUs.getState(d.this.cTB)) {
                    d.this.cUs.play(d.this.cTB, d.this.mVolume, d.this.mLoop);
                }
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void pause() {
        this.cUy.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.2
            @Override // java.lang.Runnable
            public void run() {
                d.this.cUs.pause(d.this.cTB);
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void seek(final float f) {
        this.cUy.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.this.cUs.seek(d.this.cTB, (int) f);
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void stop() {
        this.cUy.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.4
            @Override // java.lang.Runnable
            public void run() {
                d.this.cUs.stop(d.this.cTB);
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void destroy() {
        this.cUs.release(this.cTB);
        stop();
    }

    @Override // com.baidu.swan.games.audio.a
    public int getDuration() {
        return this.cUs.getDuration(this.cTB);
    }

    @Override // com.baidu.swan.games.audio.a
    public int getCurrentTime() {
        return this.cUs.getPosition(this.cTB);
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setSrc(final String str) throws Exception {
        this.cUy.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.5
            @Override // java.lang.Runnable
            public void run() {
                d.this.mSrc = str;
                File file = new File(str);
                if (file.exists() && !file.isDirectory()) {
                    d.this.cTB = d.this.cUs.setDataSource(str, (int) file.length());
                    d.this.cUs.setOnPreparedListener(d.this.cTB, new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.games.audio.b.d.5.1
                        @Override // android.media.MediaPlayer.OnPreparedListener
                        public void onPrepared(MediaPlayer mediaPlayer) {
                            if (d.this.cUt != null) {
                                d.this.cUt.onPrepared(mediaPlayer);
                            }
                        }
                    });
                    d.this.cUs.setOnCompletionListener(d.this.cTB, new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.games.audio.b.d.5.2
                        @Override // android.media.MediaPlayer.OnCompletionListener
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            if (d.this.cUu != null) {
                                d.this.cUu.onCompletion(mediaPlayer);
                            }
                        }
                    });
                    d.this.cUs.setOnSeekCompleteListener(d.this.cTB, new MediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.swan.games.audio.b.d.5.3
                        @Override // android.media.MediaPlayer.OnSeekCompleteListener
                        public void onSeekComplete(MediaPlayer mediaPlayer) {
                            if (d.this.cUw != null) {
                                d.this.cUw.onSeekComplete(mediaPlayer);
                            }
                        }
                    });
                    d.this.cUs.setOnErrorListener(d.this.cTB, new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.games.audio.b.d.5.4
                        @Override // android.media.MediaPlayer.OnErrorListener
                        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                            if (d.this.cUv != null) {
                                return d.this.cUv.onError(mediaPlayer, i, i2);
                            }
                            return false;
                        }
                    });
                    d.this.cUs.setOnPauseListener(d.this.cTB, new com.baidu.swan.nalib.audio.c() { // from class: com.baidu.swan.games.audio.b.d.5.5
                        @Override // com.baidu.swan.nalib.audio.c
                        public void onPause() {
                            if (d.this.cUx != null) {
                                d.this.cUx.onPause();
                            }
                        }
                    });
                    d.this.cUs.prepare(d.this.cTB);
                }
            }
        });
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void fI(final boolean z) {
        this.cUy.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.6
            @Override // java.lang.Runnable
            public void run() {
                if (2 == d.this.cUs.getState(d.this.cTB)) {
                    d.this.cUs.setLoop(d.this.cTB, z);
                }
                d.this.mLoop = z;
            }
        });
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setVolume(final float f) {
        this.cUy.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.7
            @Override // java.lang.Runnable
            public void run() {
                if (2 == d.this.cUs.getState(d.this.cTB)) {
                    d.this.cUs.setVolume(d.this.cTB, f);
                }
                d.this.mVolume = f;
            }
        });
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.cUt = onPreparedListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.cUu = onCompletionListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.cUv = onErrorListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void a(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.cUw = onSeekCompleteListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void a(MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void a(com.baidu.swan.nalib.audio.c cVar) {
        this.cUx = cVar;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public boolean axJ() {
        return false;
    }
}

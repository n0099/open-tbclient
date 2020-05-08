package com.baidu.swan.games.audio.b;

import android.media.MediaPlayer;
import android.os.Handler;
import com.baidu.swan.nalib.audio.SwanAudioPlayer;
import java.io.File;
/* loaded from: classes11.dex */
public class d implements c {
    private int cIU;
    private MediaPlayer.OnPreparedListener cJM;
    private MediaPlayer.OnCompletionListener cJN;
    private MediaPlayer.OnErrorListener cJO;
    private MediaPlayer.OnSeekCompleteListener cJP;
    private com.baidu.swan.nalib.audio.c cJQ;
    private boolean mLoop;
    private String mSrc;
    private float mVolume;
    private SwanAudioPlayer cJL = SwanAudioPlayer.getInstance();
    private Handler cJR = b.atS().atU();

    @Override // com.baidu.swan.games.audio.a
    public void play() {
        this.cJR.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.1
            @Override // java.lang.Runnable
            public void run() {
                if (2 != d.this.cJL.getState(d.this.cIU)) {
                    d.this.cJL.play(d.this.cIU, d.this.mVolume, d.this.mLoop);
                }
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void pause() {
        this.cJR.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.2
            @Override // java.lang.Runnable
            public void run() {
                d.this.cJL.pause(d.this.cIU);
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void seek(final float f) {
        this.cJR.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.this.cJL.seek(d.this.cIU, (int) f);
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void stop() {
        this.cJR.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.4
            @Override // java.lang.Runnable
            public void run() {
                d.this.cJL.stop(d.this.cIU);
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void destroy() {
        this.cJL.release(this.cIU);
        stop();
    }

    @Override // com.baidu.swan.games.audio.a
    public int getDuration() {
        return this.cJL.getDuration(this.cIU);
    }

    @Override // com.baidu.swan.games.audio.a
    public int getCurrentTime() {
        return this.cJL.getPosition(this.cIU);
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setSrc(final String str) throws Exception {
        this.cJR.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.5
            @Override // java.lang.Runnable
            public void run() {
                d.this.mSrc = str;
                File file = new File(str);
                if (file.exists() && !file.isDirectory()) {
                    d.this.cIU = d.this.cJL.setDataSource(str, (int) file.length());
                    d.this.cJL.setOnPreparedListener(d.this.cIU, new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.games.audio.b.d.5.1
                        @Override // android.media.MediaPlayer.OnPreparedListener
                        public void onPrepared(MediaPlayer mediaPlayer) {
                            if (d.this.cJM != null) {
                                d.this.cJM.onPrepared(mediaPlayer);
                            }
                        }
                    });
                    d.this.cJL.setOnCompletionListener(d.this.cIU, new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.games.audio.b.d.5.2
                        @Override // android.media.MediaPlayer.OnCompletionListener
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            if (d.this.cJN != null) {
                                d.this.cJN.onCompletion(mediaPlayer);
                            }
                        }
                    });
                    d.this.cJL.setOnSeekCompleteListener(d.this.cIU, new MediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.swan.games.audio.b.d.5.3
                        @Override // android.media.MediaPlayer.OnSeekCompleteListener
                        public void onSeekComplete(MediaPlayer mediaPlayer) {
                            if (d.this.cJP != null) {
                                d.this.cJP.onSeekComplete(mediaPlayer);
                            }
                        }
                    });
                    d.this.cJL.setOnErrorListener(d.this.cIU, new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.games.audio.b.d.5.4
                        @Override // android.media.MediaPlayer.OnErrorListener
                        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                            if (d.this.cJO != null) {
                                return d.this.cJO.onError(mediaPlayer, i, i2);
                            }
                            return false;
                        }
                    });
                    d.this.cJL.setOnPauseListener(d.this.cIU, new com.baidu.swan.nalib.audio.c() { // from class: com.baidu.swan.games.audio.b.d.5.5
                        @Override // com.baidu.swan.nalib.audio.c
                        public void onPause() {
                            if (d.this.cJQ != null) {
                                d.this.cJQ.onPause();
                            }
                        }
                    });
                    d.this.cJL.prepare(d.this.cIU);
                }
            }
        });
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void fx(final boolean z) {
        this.cJR.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.6
            @Override // java.lang.Runnable
            public void run() {
                if (2 == d.this.cJL.getState(d.this.cIU)) {
                    d.this.cJL.setLoop(d.this.cIU, z);
                }
                d.this.mLoop = z;
            }
        });
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setVolume(final float f) {
        this.cJR.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.7
            @Override // java.lang.Runnable
            public void run() {
                if (2 == d.this.cJL.getState(d.this.cIU)) {
                    d.this.cJL.setVolume(d.this.cIU, f);
                }
                d.this.mVolume = f;
            }
        });
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.cJM = onPreparedListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.cJN = onCompletionListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.cJO = onErrorListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void a(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.cJP = onSeekCompleteListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void a(MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void a(com.baidu.swan.nalib.audio.c cVar) {
        this.cJQ = cVar;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public boolean atW() {
        return false;
    }
}

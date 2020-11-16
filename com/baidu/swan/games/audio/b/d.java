package com.baidu.swan.games.audio.b;

import android.media.MediaPlayer;
import android.os.Handler;
import com.baidu.swan.nalib.audio.SwanAudioPlayer;
import java.io.File;
/* loaded from: classes7.dex */
public class d implements c {
    private int dOU;
    private MediaPlayer.OnPreparedListener dPM;
    private MediaPlayer.OnCompletionListener dPN;
    private MediaPlayer.OnErrorListener dPO;
    private MediaPlayer.OnSeekCompleteListener dPP;
    private com.baidu.swan.nalib.audio.c dPQ;
    private boolean mLoop;
    private String mSrc;
    private float mVolume;
    private SwanAudioPlayer dPL = SwanAudioPlayer.getInstance();
    private Handler dPR = b.aSl().aSn();

    @Override // com.baidu.swan.games.audio.a
    public void play() {
        this.dPR.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.1
            @Override // java.lang.Runnable
            public void run() {
                if (2 != d.this.dPL.getState(d.this.dOU)) {
                    d.this.dPL.play(d.this.dOU, d.this.mVolume, d.this.mLoop);
                }
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void pause() {
        this.dPR.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.2
            @Override // java.lang.Runnable
            public void run() {
                d.this.dPL.pause(d.this.dOU);
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void seek(final float f) {
        this.dPR.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.this.dPL.seek(d.this.dOU, (int) f);
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void stop() {
        this.dPR.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.4
            @Override // java.lang.Runnable
            public void run() {
                d.this.dPL.stop(d.this.dOU);
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void destroy() {
        this.dPL.release(this.dOU);
        stop();
    }

    @Override // com.baidu.swan.games.audio.a
    public int getDuration() {
        return this.dPL.getDuration(this.dOU);
    }

    @Override // com.baidu.swan.games.audio.a
    public int getCurrentTime() {
        return this.dPL.getPosition(this.dOU);
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setSrc(final String str) throws Exception {
        this.dPR.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.5
            @Override // java.lang.Runnable
            public void run() {
                d.this.mSrc = str;
                File file = new File(str);
                if (file.exists() && !file.isDirectory()) {
                    d.this.dOU = d.this.dPL.setDataSource(str, (int) file.length());
                    d.this.dPL.setOnPreparedListener(d.this.dOU, new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.games.audio.b.d.5.1
                        @Override // android.media.MediaPlayer.OnPreparedListener
                        public void onPrepared(MediaPlayer mediaPlayer) {
                            if (d.this.dPM != null) {
                                d.this.dPM.onPrepared(mediaPlayer);
                            }
                        }
                    });
                    d.this.dPL.setOnCompletionListener(d.this.dOU, new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.games.audio.b.d.5.2
                        @Override // android.media.MediaPlayer.OnCompletionListener
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            if (d.this.dPN != null) {
                                d.this.dPN.onCompletion(mediaPlayer);
                            }
                        }
                    });
                    d.this.dPL.setOnSeekCompleteListener(d.this.dOU, new MediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.swan.games.audio.b.d.5.3
                        @Override // android.media.MediaPlayer.OnSeekCompleteListener
                        public void onSeekComplete(MediaPlayer mediaPlayer) {
                            if (d.this.dPP != null) {
                                d.this.dPP.onSeekComplete(mediaPlayer);
                            }
                        }
                    });
                    d.this.dPL.setOnErrorListener(d.this.dOU, new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.games.audio.b.d.5.4
                        @Override // android.media.MediaPlayer.OnErrorListener
                        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                            if (d.this.dPO != null) {
                                return d.this.dPO.onError(mediaPlayer, i, i2);
                            }
                            return false;
                        }
                    });
                    d.this.dPL.setOnPauseListener(d.this.dOU, new com.baidu.swan.nalib.audio.c() { // from class: com.baidu.swan.games.audio.b.d.5.5
                        @Override // com.baidu.swan.nalib.audio.c
                        public void onPause() {
                            if (d.this.dPQ != null) {
                                d.this.dPQ.onPause();
                            }
                        }
                    });
                    d.this.dPL.prepare(d.this.dOU);
                }
            }
        });
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void hu(final boolean z) {
        this.dPR.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.6
            @Override // java.lang.Runnable
            public void run() {
                if (2 == d.this.dPL.getState(d.this.dOU)) {
                    d.this.dPL.setLoop(d.this.dOU, z);
                }
                d.this.mLoop = z;
            }
        });
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setVolume(final float f) {
        this.dPR.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.7
            @Override // java.lang.Runnable
            public void run() {
                if (2 == d.this.dPL.getState(d.this.dOU)) {
                    d.this.dPL.setVolume(d.this.dOU, f);
                }
                d.this.mVolume = f;
            }
        });
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.dPM = onPreparedListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.dPN = onCompletionListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.dPO = onErrorListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void a(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.dPP = onSeekCompleteListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void a(MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void a(com.baidu.swan.nalib.audio.c cVar) {
        this.dPQ = cVar;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public boolean aSp() {
        return false;
    }
}

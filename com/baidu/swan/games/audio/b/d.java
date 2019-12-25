package com.baidu.swan.games.audio.b;

import android.media.MediaPlayer;
import android.os.Handler;
import com.baidu.swan.nalib.audio.SwanAudioPlayer;
import java.io.File;
/* loaded from: classes9.dex */
public class d implements c {
    private boolean bvL;
    private int cfp;
    private MediaPlayer.OnPreparedListener cgg;
    private MediaPlayer.OnCompletionListener cgh;
    private MediaPlayer.OnErrorListener cgi;
    private MediaPlayer.OnSeekCompleteListener cgj;
    private com.baidu.swan.nalib.audio.c cgk;
    private String mSrc;
    private float mVolume;
    private SwanAudioPlayer cgf = SwanAudioPlayer.getInstance();
    private Handler mAudioHandler = b.aiS().aiU();

    @Override // com.baidu.swan.games.audio.a
    public void play() {
        this.mAudioHandler.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.1
            @Override // java.lang.Runnable
            public void run() {
                if (2 != d.this.cgf.getState(d.this.cfp)) {
                    d.this.cgf.play(d.this.cfp, d.this.mVolume, d.this.bvL);
                }
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void pause() {
        this.mAudioHandler.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.2
            @Override // java.lang.Runnable
            public void run() {
                d.this.cgf.pause(d.this.cfp);
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void seek(final float f) {
        this.mAudioHandler.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.this.cgf.seek(d.this.cfp, (int) f);
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void stop() {
        this.mAudioHandler.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.4
            @Override // java.lang.Runnable
            public void run() {
                d.this.cgf.stop(d.this.cfp);
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void destroy() {
        this.cgf.release(this.cfp);
        stop();
    }

    @Override // com.baidu.swan.games.audio.a
    public int getDuration() {
        return this.cgf.getDuration(this.cfp);
    }

    @Override // com.baidu.swan.games.audio.a
    public int getCurrentTime() {
        return this.cgf.getPosition(this.cfp);
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setSrc(final String str) throws Exception {
        this.mAudioHandler.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.5
            @Override // java.lang.Runnable
            public void run() {
                d.this.mSrc = str;
                File file = new File(str);
                if (file.exists() && !file.isDirectory()) {
                    d.this.cfp = d.this.cgf.setDataSource(str, (int) file.length());
                    d.this.cgf.setOnPreparedListener(d.this.cfp, new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.games.audio.b.d.5.1
                        @Override // android.media.MediaPlayer.OnPreparedListener
                        public void onPrepared(MediaPlayer mediaPlayer) {
                            if (d.this.cgg != null) {
                                d.this.cgg.onPrepared(mediaPlayer);
                            }
                        }
                    });
                    d.this.cgf.setOnCompletionListener(d.this.cfp, new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.games.audio.b.d.5.2
                        @Override // android.media.MediaPlayer.OnCompletionListener
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            if (d.this.cgh != null) {
                                d.this.cgh.onCompletion(mediaPlayer);
                            }
                        }
                    });
                    d.this.cgf.setOnSeekCompleteListener(d.this.cfp, new MediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.swan.games.audio.b.d.5.3
                        @Override // android.media.MediaPlayer.OnSeekCompleteListener
                        public void onSeekComplete(MediaPlayer mediaPlayer) {
                            if (d.this.cgj != null) {
                                d.this.cgj.onSeekComplete(mediaPlayer);
                            }
                        }
                    });
                    d.this.cgf.setOnErrorListener(d.this.cfp, new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.games.audio.b.d.5.4
                        @Override // android.media.MediaPlayer.OnErrorListener
                        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                            if (d.this.cgi != null) {
                                return d.this.cgi.onError(mediaPlayer, i, i2);
                            }
                            return false;
                        }
                    });
                    d.this.cgf.setOnPauseListener(d.this.cfp, new com.baidu.swan.nalib.audio.c() { // from class: com.baidu.swan.games.audio.b.d.5.5
                        @Override // com.baidu.swan.nalib.audio.c
                        public void onPause() {
                            if (d.this.cgk != null) {
                                d.this.cgk.onPause();
                            }
                        }
                    });
                    d.this.cgf.prepare(d.this.cfp);
                }
            }
        });
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void en(final boolean z) {
        this.mAudioHandler.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.6
            @Override // java.lang.Runnable
            public void run() {
                if (2 == d.this.cgf.getState(d.this.cfp)) {
                    d.this.cgf.setLoop(d.this.cfp, z);
                }
                d.this.bvL = z;
            }
        });
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setVolume(final float f) {
        this.mAudioHandler.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.7
            @Override // java.lang.Runnable
            public void run() {
                if (2 == d.this.cgf.getState(d.this.cfp)) {
                    d.this.cgf.setVolume(d.this.cfp, f);
                }
                d.this.mVolume = f;
            }
        });
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.cgg = onPreparedListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.cgh = onCompletionListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.cgi = onErrorListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void a(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.cgj = onSeekCompleteListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void a(MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void a(com.baidu.swan.nalib.audio.c cVar) {
        this.cgk = cVar;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public boolean aiW() {
        return false;
    }
}

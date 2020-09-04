package com.baidu.swan.games.audio.b;

import android.media.MediaPlayer;
import android.os.Handler;
import com.baidu.swan.nalib.audio.SwanAudioPlayer;
import java.io.File;
/* loaded from: classes8.dex */
public class d implements c {
    private int doi;
    private MediaPlayer.OnPreparedListener dpa;
    private MediaPlayer.OnCompletionListener dpb;
    private MediaPlayer.OnErrorListener dpc;
    private MediaPlayer.OnSeekCompleteListener dpd;
    private com.baidu.swan.nalib.audio.c dpe;
    private boolean mLoop;
    private String mSrc;
    private float mVolume;
    private SwanAudioPlayer doZ = SwanAudioPlayer.getInstance();
    private Handler dpf = b.aLf().aLh();

    @Override // com.baidu.swan.games.audio.a
    public void play() {
        this.dpf.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.1
            @Override // java.lang.Runnable
            public void run() {
                if (2 != d.this.doZ.getState(d.this.doi)) {
                    d.this.doZ.play(d.this.doi, d.this.mVolume, d.this.mLoop);
                }
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void pause() {
        this.dpf.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.2
            @Override // java.lang.Runnable
            public void run() {
                d.this.doZ.pause(d.this.doi);
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void seek(final float f) {
        this.dpf.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.this.doZ.seek(d.this.doi, (int) f);
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void stop() {
        this.dpf.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.4
            @Override // java.lang.Runnable
            public void run() {
                d.this.doZ.stop(d.this.doi);
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void destroy() {
        this.doZ.release(this.doi);
        stop();
    }

    @Override // com.baidu.swan.games.audio.a
    public int getDuration() {
        return this.doZ.getDuration(this.doi);
    }

    @Override // com.baidu.swan.games.audio.a
    public int getCurrentTime() {
        return this.doZ.getPosition(this.doi);
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setSrc(final String str) throws Exception {
        this.dpf.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.5
            @Override // java.lang.Runnable
            public void run() {
                d.this.mSrc = str;
                File file = new File(str);
                if (file.exists() && !file.isDirectory()) {
                    d.this.doi = d.this.doZ.setDataSource(str, (int) file.length());
                    d.this.doZ.setOnPreparedListener(d.this.doi, new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.games.audio.b.d.5.1
                        @Override // android.media.MediaPlayer.OnPreparedListener
                        public void onPrepared(MediaPlayer mediaPlayer) {
                            if (d.this.dpa != null) {
                                d.this.dpa.onPrepared(mediaPlayer);
                            }
                        }
                    });
                    d.this.doZ.setOnCompletionListener(d.this.doi, new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.games.audio.b.d.5.2
                        @Override // android.media.MediaPlayer.OnCompletionListener
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            if (d.this.dpb != null) {
                                d.this.dpb.onCompletion(mediaPlayer);
                            }
                        }
                    });
                    d.this.doZ.setOnSeekCompleteListener(d.this.doi, new MediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.swan.games.audio.b.d.5.3
                        @Override // android.media.MediaPlayer.OnSeekCompleteListener
                        public void onSeekComplete(MediaPlayer mediaPlayer) {
                            if (d.this.dpd != null) {
                                d.this.dpd.onSeekComplete(mediaPlayer);
                            }
                        }
                    });
                    d.this.doZ.setOnErrorListener(d.this.doi, new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.games.audio.b.d.5.4
                        @Override // android.media.MediaPlayer.OnErrorListener
                        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                            if (d.this.dpc != null) {
                                return d.this.dpc.onError(mediaPlayer, i, i2);
                            }
                            return false;
                        }
                    });
                    d.this.doZ.setOnPauseListener(d.this.doi, new com.baidu.swan.nalib.audio.c() { // from class: com.baidu.swan.games.audio.b.d.5.5
                        @Override // com.baidu.swan.nalib.audio.c
                        public void onPause() {
                            if (d.this.dpe != null) {
                                d.this.dpe.onPause();
                            }
                        }
                    });
                    d.this.doZ.prepare(d.this.doi);
                }
            }
        });
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void gB(final boolean z) {
        this.dpf.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.6
            @Override // java.lang.Runnable
            public void run() {
                if (2 == d.this.doZ.getState(d.this.doi)) {
                    d.this.doZ.setLoop(d.this.doi, z);
                }
                d.this.mLoop = z;
            }
        });
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setVolume(final float f) {
        this.dpf.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.7
            @Override // java.lang.Runnable
            public void run() {
                if (2 == d.this.doZ.getState(d.this.doi)) {
                    d.this.doZ.setVolume(d.this.doi, f);
                }
                d.this.mVolume = f;
            }
        });
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.dpa = onPreparedListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.dpb = onCompletionListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.dpc = onErrorListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void a(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.dpd = onSeekCompleteListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void a(MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void a(com.baidu.swan.nalib.audio.c cVar) {
        this.dpe = cVar;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public boolean aLj() {
        return false;
    }
}

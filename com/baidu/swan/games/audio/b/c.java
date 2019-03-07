package com.baidu.swan.games.audio.b;

import android.media.MediaPlayer;
import java.io.IOException;
/* loaded from: classes2.dex */
public class c implements e {
    private float azD;
    private MediaPlayer.OnPreparedListener bah;
    private d baq;
    private int bas = 0;
    private int bat = -1;
    private boolean bau = true;
    private MediaPlayer.OnCompletionListener bav;
    private MediaPlayer.OnErrorListener baw;
    private long mDuration;
    private String mSrc;
    private long mStartPlayTime;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(d dVar, long j) {
        this.baq = dVar;
        this.mDuration = j;
    }

    @Override // com.baidu.swan.games.audio.b.e
    public void setSrc(String str) throws IOException {
        this.bau = false;
        this.mSrc = str;
        load();
    }

    @Override // com.baidu.swan.games.audio.b.e
    public void ct(boolean z) {
        this.bas = z ? -1 : 0;
    }

    @Override // com.baidu.swan.games.audio.b.e
    public void setVolume(float f) {
        this.azD = f;
    }

    public int Nw() {
        return this.bat;
    }

    public String Nx() {
        return this.mSrc;
    }

    public void I(int i, int i2) {
        if (this.baw != null) {
            this.baw.onError(null, i, i2);
        }
    }

    @Override // com.baidu.swan.games.audio.b.e
    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.bah = onPreparedListener;
    }

    @Override // com.baidu.swan.games.audio.b.e
    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.bav = onCompletionListener;
    }

    @Override // com.baidu.swan.games.audio.b.e
    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
    }

    @Override // com.baidu.swan.games.audio.b.e
    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.baw = onErrorListener;
    }

    @Override // com.baidu.swan.games.audio.b.e
    public void setOnSeekCompleteListener(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
    }

    @Override // com.baidu.swan.games.audio.b.e
    public void setOnBufferingUpdateListener(MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
    }

    @Override // com.baidu.swan.games.audio.b.e
    public boolean Nr() {
        return false;
    }

    @Override // com.baidu.swan.games.audio.a
    public void play() {
        if (-1 != this.bat) {
            this.baq.stop(this.bat);
        }
        this.bat = this.baq.play(this.baq.ic(this.mSrc), this.azD, this.azD, 1, this.bas, 1.0f);
        this.mStartPlayTime = System.currentTimeMillis();
        this.bau = false;
        if (this.bah != null) {
            this.bah.onPrepared(null);
        }
    }

    private void load() {
        this.bat = this.baq.load(this.mSrc, 1);
        this.baq.a(this.bat, this);
    }

    @Override // com.baidu.swan.games.audio.a
    public void pause() {
        if (this.bat != 0 || this.baq.ib(this.mSrc)) {
            this.baq.pause(this.bat);
        }
        this.bau = true;
    }

    @Override // com.baidu.swan.games.audio.a
    public void seek(int i) {
    }

    @Override // com.baidu.swan.games.audio.a
    public void stop() {
        if (this.bat != 0 || this.baq.ib(this.mSrc)) {
            this.baq.stop(this.bat);
        }
        this.bau = true;
    }

    @Override // com.baidu.swan.games.audio.a
    public void destroy() {
    }

    @Override // com.baidu.swan.games.audio.a
    public int getDuration() {
        return (int) this.mDuration;
    }

    @Override // com.baidu.swan.games.audio.a
    public int getCurrentTime() {
        long currentTimeMillis = System.currentTimeMillis() - this.mStartPlayTime;
        if (currentTimeMillis > this.mDuration) {
            if (this.bas == 0) {
                this.bau = true;
                if (this.bav != null) {
                    this.bav.onCompletion(null);
                }
            } else {
                currentTimeMillis %= this.mDuration;
            }
        }
        return (int) currentTimeMillis;
    }

    @Override // com.baidu.swan.games.audio.a
    public boolean isPaused() {
        return this.bau;
    }
}

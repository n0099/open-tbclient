package com.baidu.swan.games.audio.b;

import android.media.MediaPlayer;
import java.io.IOException;
/* loaded from: classes2.dex */
public class c implements e {
    private float azE;
    private MediaPlayer.OnPreparedListener bai;
    private d bas;
    private int bat = 0;
    private int bau = -1;
    private boolean bav = true;
    private MediaPlayer.OnCompletionListener baw;
    private MediaPlayer.OnErrorListener bax;
    private long mDuration;
    private String mSrc;
    private long mStartPlayTime;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(d dVar, long j) {
        this.bas = dVar;
        this.mDuration = j;
    }

    @Override // com.baidu.swan.games.audio.b.e
    public void setSrc(String str) throws IOException {
        this.bav = false;
        this.mSrc = str;
        load();
    }

    @Override // com.baidu.swan.games.audio.b.e
    public void ct(boolean z) {
        this.bat = z ? -1 : 0;
    }

    @Override // com.baidu.swan.games.audio.b.e
    public void setVolume(float f) {
        this.azE = f;
    }

    public int Nw() {
        return this.bau;
    }

    public String Nx() {
        return this.mSrc;
    }

    public void I(int i, int i2) {
        if (this.bax != null) {
            this.bax.onError(null, i, i2);
        }
    }

    @Override // com.baidu.swan.games.audio.b.e
    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.bai = onPreparedListener;
    }

    @Override // com.baidu.swan.games.audio.b.e
    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.baw = onCompletionListener;
    }

    @Override // com.baidu.swan.games.audio.b.e
    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
    }

    @Override // com.baidu.swan.games.audio.b.e
    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.bax = onErrorListener;
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
        if (-1 != this.bau) {
            this.bas.stop(this.bau);
        }
        this.bau = this.bas.play(this.bas.ic(this.mSrc), this.azE, this.azE, 1, this.bat, 1.0f);
        this.mStartPlayTime = System.currentTimeMillis();
        this.bav = false;
        if (this.bai != null) {
            this.bai.onPrepared(null);
        }
    }

    private void load() {
        this.bau = this.bas.load(this.mSrc, 1);
        this.bas.a(this.bau, this);
    }

    @Override // com.baidu.swan.games.audio.a
    public void pause() {
        if (this.bau != 0 || this.bas.ib(this.mSrc)) {
            this.bas.pause(this.bau);
        }
        this.bav = true;
    }

    @Override // com.baidu.swan.games.audio.a
    public void seek(int i) {
    }

    @Override // com.baidu.swan.games.audio.a
    public void stop() {
        if (this.bau != 0 || this.bas.ib(this.mSrc)) {
            this.bas.stop(this.bau);
        }
        this.bav = true;
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
            if (this.bat == 0) {
                this.bav = true;
                if (this.baw != null) {
                    this.baw.onCompletion(null);
                }
            } else {
                currentTimeMillis %= this.mDuration;
            }
        }
        return (int) currentTimeMillis;
    }

    @Override // com.baidu.swan.games.audio.a
    public boolean isPaused() {
        return this.bav;
    }
}

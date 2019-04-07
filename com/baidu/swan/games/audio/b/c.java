package com.baidu.swan.games.audio.b;

import android.media.MediaPlayer;
import java.io.IOException;
/* loaded from: classes2.dex */
public class c implements e {
    private float azH;
    private MediaPlayer.OnErrorListener baA;
    private MediaPlayer.OnPreparedListener bal;
    private d bav;
    private int baw = 0;
    private int bax = -1;
    private boolean bay = true;
    private MediaPlayer.OnCompletionListener baz;
    private long mDuration;
    private String mSrc;
    private long mStartPlayTime;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(d dVar, long j) {
        this.bav = dVar;
        this.mDuration = j;
    }

    @Override // com.baidu.swan.games.audio.b.e
    public void setSrc(String str) throws IOException {
        this.bay = false;
        this.mSrc = str;
        load();
    }

    @Override // com.baidu.swan.games.audio.b.e
    public void ct(boolean z) {
        this.baw = z ? -1 : 0;
    }

    @Override // com.baidu.swan.games.audio.b.e
    public void setVolume(float f) {
        this.azH = f;
    }

    public int Nu() {
        return this.bax;
    }

    public String Nv() {
        return this.mSrc;
    }

    public void I(int i, int i2) {
        if (this.baA != null) {
            this.baA.onError(null, i, i2);
        }
    }

    @Override // com.baidu.swan.games.audio.b.e
    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.bal = onPreparedListener;
    }

    @Override // com.baidu.swan.games.audio.b.e
    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.baz = onCompletionListener;
    }

    @Override // com.baidu.swan.games.audio.b.e
    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
    }

    @Override // com.baidu.swan.games.audio.b.e
    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.baA = onErrorListener;
    }

    @Override // com.baidu.swan.games.audio.b.e
    public void setOnSeekCompleteListener(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
    }

    @Override // com.baidu.swan.games.audio.b.e
    public void setOnBufferingUpdateListener(MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
    }

    @Override // com.baidu.swan.games.audio.b.e
    public boolean Np() {
        return false;
    }

    @Override // com.baidu.swan.games.audio.a
    public void play() {
        if (-1 != this.bax) {
            this.bav.stop(this.bax);
        }
        this.bax = this.bav.play(this.bav.ie(this.mSrc), this.azH, this.azH, 1, this.baw, 1.0f);
        this.mStartPlayTime = System.currentTimeMillis();
        this.bay = false;
        if (this.bal != null) {
            this.bal.onPrepared(null);
        }
    }

    private void load() {
        this.bax = this.bav.load(this.mSrc, 1);
        this.bav.a(this.bax, this);
    }

    @Override // com.baidu.swan.games.audio.a
    public void pause() {
        if (this.bax != 0 || this.bav.ic(this.mSrc)) {
            this.bav.pause(this.bax);
        }
        this.bay = true;
    }

    @Override // com.baidu.swan.games.audio.a
    public void seek(int i) {
    }

    @Override // com.baidu.swan.games.audio.a
    public void stop() {
        if (this.bax != 0 || this.bav.ic(this.mSrc)) {
            this.bav.stop(this.bax);
        }
        this.bay = true;
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
            if (this.baw == 0) {
                this.bay = true;
                if (this.baz != null) {
                    this.baz.onCompletion(null);
                }
            } else {
                currentTimeMillis %= this.mDuration;
            }
        }
        return (int) currentTimeMillis;
    }

    @Override // com.baidu.swan.games.audio.a
    public boolean isPaused() {
        return this.bay;
    }
}

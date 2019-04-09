package com.baidu.swan.games.audio.b;

import android.media.MediaPlayer;
import java.io.IOException;
/* loaded from: classes2.dex */
public class c implements e {
    private float azI;
    private MediaPlayer.OnCompletionListener baA;
    private MediaPlayer.OnErrorListener baB;
    private MediaPlayer.OnPreparedListener bam;
    private d baw;
    private int bax = 0;
    private int bay = -1;
    private boolean baz = true;
    private long mDuration;
    private String mSrc;
    private long mStartPlayTime;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(d dVar, long j) {
        this.baw = dVar;
        this.mDuration = j;
    }

    @Override // com.baidu.swan.games.audio.b.e
    public void setSrc(String str) throws IOException {
        this.baz = false;
        this.mSrc = str;
        load();
    }

    @Override // com.baidu.swan.games.audio.b.e
    public void ct(boolean z) {
        this.bax = z ? -1 : 0;
    }

    @Override // com.baidu.swan.games.audio.b.e
    public void setVolume(float f) {
        this.azI = f;
    }

    public int Nu() {
        return this.bay;
    }

    public String Nv() {
        return this.mSrc;
    }

    public void I(int i, int i2) {
        if (this.baB != null) {
            this.baB.onError(null, i, i2);
        }
    }

    @Override // com.baidu.swan.games.audio.b.e
    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.bam = onPreparedListener;
    }

    @Override // com.baidu.swan.games.audio.b.e
    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.baA = onCompletionListener;
    }

    @Override // com.baidu.swan.games.audio.b.e
    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
    }

    @Override // com.baidu.swan.games.audio.b.e
    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.baB = onErrorListener;
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
        if (-1 != this.bay) {
            this.baw.stop(this.bay);
        }
        this.bay = this.baw.play(this.baw.ie(this.mSrc), this.azI, this.azI, 1, this.bax, 1.0f);
        this.mStartPlayTime = System.currentTimeMillis();
        this.baz = false;
        if (this.bam != null) {
            this.bam.onPrepared(null);
        }
    }

    private void load() {
        this.bay = this.baw.load(this.mSrc, 1);
        this.baw.a(this.bay, this);
    }

    @Override // com.baidu.swan.games.audio.a
    public void pause() {
        if (this.bay != 0 || this.baw.ic(this.mSrc)) {
            this.baw.pause(this.bay);
        }
        this.baz = true;
    }

    @Override // com.baidu.swan.games.audio.a
    public void seek(int i) {
    }

    @Override // com.baidu.swan.games.audio.a
    public void stop() {
        if (this.bay != 0 || this.baw.ic(this.mSrc)) {
            this.baw.stop(this.bay);
        }
        this.baz = true;
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
            if (this.bax == 0) {
                this.baz = true;
                if (this.baA != null) {
                    this.baA.onCompletion(null);
                }
            } else {
                currentTimeMillis %= this.mDuration;
            }
        }
        return (int) currentTimeMillis;
    }

    @Override // com.baidu.swan.games.audio.a
    public boolean isPaused() {
        return this.baz;
    }
}

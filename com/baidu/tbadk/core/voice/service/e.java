package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.h;
import java.io.IOException;
/* loaded from: classes.dex */
public class e extends MediaPlayer implements c {
    private static Object dLU = new Object();
    private static e dLV = null;
    private boolean dLW = false;
    private boolean dLX = true;
    private int errorNo = -1;

    private e() {
    }

    public static e aRr() {
        if (dLV == null) {
            synchronized (dLU) {
                if (dLV == null) {
                    dLV = new e();
                }
            }
        }
        return dLV;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean vy(String str) {
        this.errorNo = -1;
        if (!this.dLW) {
            this.dLX = true;
            reset();
            try {
                setDataSource(str);
                setStreamType(h.NL);
                try {
                    prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                    this.errorNo = 2;
                    return false;
                } catch (IllegalStateException e2) {
                    this.errorNo = 1;
                    return false;
                }
            } catch (IOException e3) {
                this.errorNo = 2;
                return false;
            } catch (IllegalArgumentException e4) {
                this.errorNo = 0;
                return false;
            } catch (IllegalStateException e5) {
                this.errorNo = 1;
                return false;
            }
        }
        this.dLW = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void aRo() {
        start();
        this.dLX = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void aRk() {
        if (!this.dLX) {
            stop();
            this.dLX = true;
            this.dLW = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void aRp() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void aRq() {
        reset();
        this.dLW = false;
        this.dLX = true;
        this.errorNo = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public int mt() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean isPrepared() {
        return this.dLW;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void seek(int i) {
        lW(i);
    }

    public void lW(int i) {
        try {
            seekTo(i);
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public int getErrorNo() {
        return this.errorNo;
    }
}

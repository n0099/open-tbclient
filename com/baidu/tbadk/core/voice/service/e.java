package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.h;
import java.io.IOException;
/* loaded from: classes.dex */
public class e extends MediaPlayer implements c {
    private boolean beB = false;
    private boolean beC = true;
    private int errorNo = -1;
    private static Object bez = new Object();
    private static e beA = null;

    private e() {
    }

    public static e EL() {
        if (beA == null) {
            synchronized (bez) {
                if (beA == null) {
                    beA = new e();
                }
            }
        }
        return beA;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean eM(String str) {
        this.errorNo = -1;
        if (!this.beB) {
            this.beC = true;
            reset();
            try {
                setDataSource(str);
                setStreamType(h.anr);
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
        this.beB = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void EH() {
        start();
        this.beC = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void ED() {
        if (!this.beC) {
            stop();
            this.beC = true;
            this.beB = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void EI() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void EJ() {
        reset();
        this.beB = false;
        this.beC = true;
        this.errorNo = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public int pl() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean EK() {
        return this.beB;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void gN(int i) {
        gP(i);
    }

    public void gP(int i) {
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

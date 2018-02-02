package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.h;
import java.io.IOException;
/* loaded from: classes.dex */
public class e extends MediaPlayer implements c {
    private static Object beN = new Object();
    private static e beO = null;
    private boolean beP = false;
    private boolean beQ = true;
    private int errorNo = -1;

    private e() {
    }

    public static e EE() {
        if (beO == null) {
            synchronized (beN) {
                if (beO == null) {
                    beO = new e();
                }
            }
        }
        return beO;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean eU(String str) {
        this.errorNo = -1;
        if (!this.beP) {
            this.beQ = true;
            reset();
            try {
                setDataSource(str);
                setStreamType(h.ant);
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
        this.beP = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void EA() {
        start();
        this.beQ = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void Ew() {
        if (!this.beQ) {
            stop();
            this.beQ = true;
            this.beP = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void EB() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void EC() {
        reset();
        this.beP = false;
        this.beQ = true;
        this.errorNo = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public int pm() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean ED() {
        return this.beP;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void gK(int i) {
        gM(i);
    }

    public void gM(int i) {
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

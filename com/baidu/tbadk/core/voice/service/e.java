package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.h;
import java.io.IOException;
/* loaded from: classes.dex */
public class e extends MediaPlayer implements c {
    private static Object bgx = new Object();
    private static e bgy = null;
    private boolean bgz = false;
    private boolean bgA = true;
    private int errorNo = -1;

    private e() {
    }

    public static e EZ() {
        if (bgy == null) {
            synchronized (bgx) {
                if (bgy == null) {
                    bgy = new e();
                }
            }
        }
        return bgy;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean ff(String str) {
        this.errorNo = -1;
        if (!this.bgz) {
            this.bgA = true;
            reset();
            try {
                setDataSource(str);
                setStreamType(h.anm);
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
        this.bgz = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void EV() {
        start();
        this.bgA = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void ER() {
        if (!this.bgA) {
            stop();
            this.bgA = true;
            this.bgz = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void EW() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void EX() {
        reset();
        this.bgz = false;
        this.bgA = true;
        this.errorNo = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public int pm() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean EY() {
        return this.bgz;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void gM(int i) {
        gO(i);
    }

    public void gO(int i) {
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

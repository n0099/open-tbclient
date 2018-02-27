package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.h;
import java.io.IOException;
/* loaded from: classes.dex */
public class e extends MediaPlayer implements c {
    private static Object bgu = new Object();
    private static e bgv = null;
    private boolean bgw = false;
    private boolean bgx = true;
    private int errorNo = -1;

    private e() {
    }

    public static e EY() {
        if (bgv == null) {
            synchronized (bgu) {
                if (bgv == null) {
                    bgv = new e();
                }
            }
        }
        return bgv;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean ff(String str) {
        this.errorNo = -1;
        if (!this.bgw) {
            this.bgx = true;
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
        this.bgw = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void EU() {
        start();
        this.bgx = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void EQ() {
        if (!this.bgx) {
            stop();
            this.bgx = true;
            this.bgw = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void EV() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void EW() {
        reset();
        this.bgw = false;
        this.bgx = true;
        this.errorNo = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public int pm() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean EX() {
        return this.bgw;
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

package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.l;
import java.io.IOException;
/* loaded from: classes.dex */
public class k extends MediaPlayer implements h {
    private static Object ajM = new Object();
    private static k ajN = null;
    private boolean ajO = false;
    private boolean ajP = true;
    private int errorNo = -1;

    private k() {
    }

    public static k xu() {
        if (ajN == null) {
            synchronized (ajM) {
                if (ajN == null) {
                    ajN = new k();
                }
            }
        }
        return ajN;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public boolean ei(String str) {
        this.errorNo = -1;
        if (!this.ajO) {
            this.ajP = true;
            reset();
            try {
                setDataSource(str);
                setStreamType(l.sW);
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
        this.ajO = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void xq() {
        start();
        this.ajP = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void xl() {
        if (!this.ajP) {
            stop();
            this.ajP = true;
            this.ajO = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void xr() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void xs() {
        reset();
        this.ajO = false;
        this.ajP = true;
        this.errorNo = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public int gQ() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public boolean xt() {
        return this.ajO;
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public void dx(int i) {
        dz(i);
    }

    public void dz(int i) {
        try {
            seekTo(i);
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.h
    public int getErrorNo() {
        return this.errorNo;
    }
}

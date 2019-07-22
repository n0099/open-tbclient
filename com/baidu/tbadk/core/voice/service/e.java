package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.h;
import java.io.IOException;
/* loaded from: classes.dex */
public class e extends MediaPlayer implements c {
    private static Object ceV = new Object();
    private static e ceW = null;
    private boolean ceX = false;
    private boolean ceY = true;
    private int errorNo = -1;

    private e() {
    }

    public static e alH() {
        if (ceW == null) {
            synchronized (ceV) {
                if (ceW == null) {
                    ceW = new e();
                }
            }
        }
        return ceW;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean pb(String str) {
        this.errorNo = -1;
        if (!this.ceX) {
            this.ceY = true;
            reset();
            try {
                setDataSource(str);
                setStreamType(h.ES);
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
        this.ceX = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void alD() {
        start();
        this.ceY = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void alz() {
        if (!this.ceY) {
            stop();
            this.ceY = true;
            this.ceX = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void alE() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void alF() {
        reset();
        this.ceX = false;
        this.ceY = true;
        this.errorNo = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public int kF() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean alG() {
        return this.ceX;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void seek(int i) {
        jp(i);
    }

    public void jp(int i) {
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

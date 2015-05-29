package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import java.io.IOException;
/* loaded from: classes.dex */
public class l extends MediaPlayer implements i {
    private static Object abf = new Object();
    private static l abg = null;
    private boolean abh = false;
    private boolean abi = true;
    private int abj = -1;

    private l() {
    }

    public static l uU() {
        if (abg == null) {
            synchronized (abf) {
                if (abg == null) {
                    abg = new l();
                }
            }
        }
        return abg;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean dy(String str) {
        this.abj = -1;
        if (!this.abh) {
            this.abi = true;
            reset();
            try {
                setDataSource(str);
                setStreamType(com.baidu.adp.lib.voice.l.zy);
                try {
                    prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                    this.abj = 2;
                    return false;
                } catch (IllegalStateException e2) {
                    this.abj = 1;
                    return false;
                }
            } catch (IOException e3) {
                this.abj = 2;
                return false;
            } catch (IllegalArgumentException e4) {
                this.abj = 0;
                return false;
            } catch (IllegalStateException e5) {
                this.abj = 1;
                return false;
            }
        }
        this.abh = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public void uQ() {
        start();
        this.abi = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public void uK() {
        if (!this.abi) {
            stop();
            this.abi = true;
            this.abh = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public void uR() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public void uS() {
        reset();
        this.abh = false;
        this.abi = true;
        this.abj = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public int jy() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean uT() {
        return this.abh;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public void seek(int i) {
        cC(i);
    }

    public void cC(int i) {
        try {
            seekTo(i);
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public int getErrorNo() {
        return this.abj;
    }
}

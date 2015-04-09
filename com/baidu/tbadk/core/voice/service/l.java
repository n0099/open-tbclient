package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import java.io.IOException;
/* loaded from: classes.dex */
public class l extends MediaPlayer implements i {
    private static Object aae = new Object();
    private static l aaf = null;
    private boolean aag = false;
    private boolean aah = true;
    private int aai = -1;

    private l() {
    }

    public static l ul() {
        if (aaf == null) {
            synchronized (aae) {
                if (aaf == null) {
                    aaf = new l();
                }
            }
        }
        return aaf;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean dh(String str) {
        this.aai = -1;
        if (!this.aag) {
            this.aah = true;
            reset();
            try {
                setDataSource(str);
                setStreamType(com.baidu.adp.lib.voice.l.zJ);
                try {
                    prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                    this.aai = 2;
                    return false;
                } catch (IllegalStateException e2) {
                    this.aai = 1;
                    return false;
                }
            } catch (IOException e3) {
                this.aai = 2;
                return false;
            } catch (IllegalArgumentException e4) {
                this.aai = 0;
                return false;
            } catch (IllegalStateException e5) {
                this.aai = 1;
                return false;
            }
        }
        this.aag = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public void uh() {
        start();
        this.aah = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public void ub() {
        if (!this.aah) {
            stop();
            this.aah = true;
            this.aag = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public void ui() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public void uj() {
        reset();
        this.aag = false;
        this.aah = true;
        this.aai = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public int jh() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean uk() {
        return this.aag;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public void seek(int i) {
        cx(i);
    }

    public void cx(int i) {
        try {
            seekTo(i);
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public int getErrorNo() {
        return this.aai;
    }
}

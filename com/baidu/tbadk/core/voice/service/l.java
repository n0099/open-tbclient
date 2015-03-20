package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import java.io.IOException;
/* loaded from: classes.dex */
public class l extends MediaPlayer implements i {
    private static Object aac = new Object();
    private static l aad = null;
    private boolean aae = false;
    private boolean aaf = true;
    private int aag = -1;

    private l() {
    }

    public static l ul() {
        if (aad == null) {
            synchronized (aac) {
                if (aad == null) {
                    aad = new l();
                }
            }
        }
        return aad;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean dh(String str) {
        this.aag = -1;
        if (!this.aae) {
            this.aaf = true;
            reset();
            try {
                setDataSource(str);
                setStreamType(com.baidu.adp.lib.voice.l.zJ);
                try {
                    prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                    this.aag = 2;
                    return false;
                } catch (IllegalStateException e2) {
                    this.aag = 1;
                    return false;
                }
            } catch (IOException e3) {
                this.aag = 2;
                return false;
            } catch (IllegalArgumentException e4) {
                this.aag = 0;
                return false;
            } catch (IllegalStateException e5) {
                this.aag = 1;
                return false;
            }
        }
        this.aae = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public void uh() {
        start();
        this.aaf = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public void ub() {
        if (!this.aaf) {
            stop();
            this.aaf = true;
            this.aae = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public void ui() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public void uj() {
        reset();
        this.aae = false;
        this.aaf = true;
        this.aag = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public int jh() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean uk() {
        return this.aae;
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
        return this.aag;
    }
}

package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.h;
import java.io.IOException;
/* loaded from: classes.dex */
public class e extends MediaPlayer implements c {
    private static Object cfc = new Object();
    private static e cfd = null;
    private boolean cfe = false;
    private boolean cff = true;
    private int errorNo = -1;

    private e() {
    }

    public static e alJ() {
        if (cfd == null) {
            synchronized (cfc) {
                if (cfd == null) {
                    cfd = new e();
                }
            }
        }
        return cfd;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean pb(String str) {
        this.errorNo = -1;
        if (!this.cfe) {
            this.cff = true;
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
        this.cfe = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void alF() {
        start();
        this.cff = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void alB() {
        if (!this.cff) {
            stop();
            this.cff = true;
            this.cfe = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void alG() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void alH() {
        reset();
        this.cfe = false;
        this.cff = true;
        this.errorNo = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public int kF() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean alI() {
        return this.cfe;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void seek(int i) {
        jq(i);
    }

    public void jq(int i) {
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

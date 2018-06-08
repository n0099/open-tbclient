package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.h;
import java.io.IOException;
/* loaded from: classes.dex */
public class e extends MediaPlayer implements c {
    private static Object aAh = new Object();
    private static e aAi = null;
    private boolean aAj = false;
    private boolean aAk = true;
    private int errorNo = -1;

    private e() {
    }

    public static e Bm() {
        if (aAi == null) {
            synchronized (aAh) {
                if (aAi == null) {
                    aAi = new e();
                }
            }
        }
        return aAi;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean fv(String str) {
        this.errorNo = -1;
        if (!this.aAj) {
            this.aAk = true;
            reset();
            try {
                setDataSource(str);
                setStreamType(h.DW);
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
        this.aAj = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void Bi() {
        start();
        this.aAk = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void Bf() {
        if (!this.aAk) {
            stop();
            this.aAk = true;
            this.aAj = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void Bj() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void Bk() {
        reset();
        this.aAj = false;
        this.aAk = true;
        this.errorNo = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public int kg() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean Bl() {
        return this.aAj;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void dN(int i) {
        dP(i);
    }

    public void dP(int i) {
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

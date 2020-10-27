package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.h;
import java.io.IOException;
/* loaded from: classes.dex */
public class e extends MediaPlayer implements c {
    private static Object eWe = new Object();
    private static e eWf = null;
    private boolean eWg = false;
    private boolean eWh = true;
    private int errorNo = -1;

    private e() {
    }

    public static e brF() {
        if (eWf == null) {
            synchronized (eWe) {
                if (eWf == null) {
                    eWf = new e();
                }
            }
        }
        return eWf;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean Ct(String str) {
        this.errorNo = -1;
        if (!this.eWg) {
            this.eWh = true;
            reset();
            try {
                setDataSource(str);
                setStreamType(h.PR);
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
        this.eWg = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void brC() {
        start();
        this.eWh = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void bry() {
        if (!this.eWh) {
            stop();
            this.eWh = true;
            this.eWg = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void brD() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void brE() {
        reset();
        this.eWg = false;
        this.eWh = true;
        this.errorNo = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public int os() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean isPrepared() {
        return this.eWg;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void seek(int i) {
        qs(i);
    }

    public void qs(int i) {
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

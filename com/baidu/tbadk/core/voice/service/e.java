package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.h;
import java.io.IOException;
/* loaded from: classes.dex */
public class e extends MediaPlayer implements c {
    private static Object aNt = new Object();
    private static e aNu = null;
    private boolean aNv = false;
    private boolean aNw = true;
    private int errorNo = -1;

    private e() {
    }

    public static e Gm() {
        if (aNu == null) {
            synchronized (aNt) {
                if (aNu == null) {
                    aNu = new e();
                }
            }
        }
        return aNu;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean gO(String str) {
        this.errorNo = -1;
        if (!this.aNv) {
            this.aNw = true;
            reset();
            try {
                setDataSource(str);
                setStreamType(h.Hc);
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
        this.aNv = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void Gi() {
        start();
        this.aNw = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void Ge() {
        if (!this.aNw) {
            stop();
            this.aNw = true;
            this.aNv = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void Gj() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void Gk() {
        reset();
        this.aNv = false;
        this.aNw = true;
        this.errorNo = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public int lv() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean Gl() {
        return this.aNv;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void seek(int i) {
        eQ(i);
    }

    public void eQ(int i) {
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

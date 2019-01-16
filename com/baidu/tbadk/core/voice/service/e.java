package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.h;
import java.io.IOException;
/* loaded from: classes.dex */
public class e extends MediaPlayer implements c {
    private static Object aNs = new Object();
    private static e aNt = null;
    private boolean aNu = false;
    private boolean aNv = true;
    private int errorNo = -1;

    private e() {
    }

    public static e Gm() {
        if (aNt == null) {
            synchronized (aNs) {
                if (aNt == null) {
                    aNt = new e();
                }
            }
        }
        return aNt;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean gO(String str) {
        this.errorNo = -1;
        if (!this.aNu) {
            this.aNv = true;
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
        this.aNu = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void Gi() {
        start();
        this.aNv = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void Ge() {
        if (!this.aNv) {
            stop();
            this.aNv = true;
            this.aNu = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void Gj() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public void Gk() {
        reset();
        this.aNu = false;
        this.aNv = true;
        this.errorNo = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public int lv() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.c
    public boolean Gl() {
        return this.aNu;
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

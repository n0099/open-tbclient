package com.baidu.tbadk.core.voice.service;

import android.media.MediaPlayer;
import com.baidu.adp.lib.voice.q;
import java.io.IOException;
/* loaded from: classes.dex */
public class l extends MediaPlayer implements i {
    private static Object Pa = new Object();
    private static l Pb = null;
    private boolean Pc = false;
    private boolean Pd = true;
    private int Pe = -1;

    private l() {
    }

    public static l ri() {
        if (Pb == null) {
            synchronized (Pa) {
                if (Pb == null) {
                    Pb = new l();
                }
            }
        }
        return Pb;
    }

    public void setStreamType(int i) {
        setAudioStreamType(i);
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean db(String str) {
        this.Pe = -1;
        if (!this.Pc) {
            this.Pd = true;
            reset();
            try {
                setDataSource(str);
                setStreamType(q.oH);
                try {
                    prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                    this.Pe = 2;
                    return false;
                } catch (IllegalStateException e2) {
                    this.Pe = 1;
                    return false;
                }
            } catch (IOException e3) {
                this.Pe = 2;
                return false;
            } catch (IllegalArgumentException e4) {
                this.Pe = 0;
                return false;
            } catch (IllegalStateException e5) {
                this.Pe = 1;
                return false;
            }
        }
        this.Pc = true;
        return true;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public void re() {
        start();
        this.Pd = false;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public void qY() {
        if (!this.Pd) {
            stop();
            this.Pd = true;
            this.Pc = false;
        }
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public void rf() {
        pause();
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public void rg() {
        reset();
        this.Pc = false;
        this.Pd = true;
        this.Pe = -1;
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public int fE() {
        return getCurrentPosition();
    }

    @Override // com.baidu.tbadk.core.voice.service.i
    public boolean rh() {
        return this.Pc;
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
        return this.Pe;
    }
}

package com.baidu.ar.face.detector;

import android.os.SystemClock;
import com.baidu.ar.face.algo.FaceAlgoData;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public abstract class a {
    public long mf;
    public FaceAlgoData ob;
    public i oc;
    public k od;
    public ByteBuffer oe;
    public long of;
    public long og;
    public long oh;
    public boolean oi;
    public String oj = "";
    public long timestamp;

    public a() {
    }

    public a(ByteBuffer byteBuffer) {
        this.oe = byteBuffer;
    }

    public void a(FaceAlgoData faceAlgoData) {
        this.ob = faceAlgoData;
    }

    public void a(i iVar) {
        this.oc = iVar;
    }

    public long cY() {
        return this.mf;
    }

    public void dE() {
        this.of = SystemClock.elapsedRealtime();
    }

    public abstract void dF();

    public void dG() {
        this.og = SystemClock.elapsedRealtime() - this.of;
    }

    public void dH() {
        if ("additional_thread".equals(this.oj)) {
            com.baidu.ar.b.a.as().a(11, true);
        }
        dE();
        dF();
        dG();
        if ("additional_thread".equals(this.oj)) {
            com.baidu.ar.b.a.as().a(11, false);
        }
    }

    public i dI() {
        return this.oc;
    }

    public void dJ() {
        this.od = this.oc.ed();
    }

    public void g(long j) {
        this.mf = j;
    }
}

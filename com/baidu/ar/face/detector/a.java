package com.baidu.ar.face.detector;

import android.os.SystemClock;
import com.baidu.ar.face.algo.FaceAlgoData;
import java.nio.ByteBuffer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public abstract class a {
    protected long mf;
    protected FaceAlgoData ob;
    protected i oc;
    protected k od;
    protected ByteBuffer oe;
    protected long of;
    protected long og;
    protected long oh;
    protected boolean oi;
    protected String oj = "";
    protected long timestamp;

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

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dE() {
        this.of = SystemClock.elapsedRealtime();
    }

    abstract void dF();

    /* JADX INFO: Access modifiers changed from: package-private */
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

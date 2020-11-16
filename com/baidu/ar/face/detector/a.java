package com.baidu.ar.face.detector;

import android.os.SystemClock;
import com.baidu.ar.face.algo.FaceAlgoData;
import java.nio.ByteBuffer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes12.dex */
public abstract class a {
    protected long lQ;
    protected FaceAlgoData nL;
    protected i nM;
    protected k nN;
    protected ByteBuffer nO;
    protected long nP;
    protected long nQ;
    protected long nR;
    protected boolean nS;
    protected String nT = "";
    protected long timestamp;

    public a() {
    }

    public a(ByteBuffer byteBuffer) {
        this.nO = byteBuffer;
    }

    public void a(FaceAlgoData faceAlgoData) {
        this.nL = faceAlgoData;
    }

    public void a(i iVar) {
        this.nM = iVar;
    }

    public long cZ() {
        return this.lQ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dF() {
        this.nP = SystemClock.elapsedRealtime();
    }

    abstract void dG();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dH() {
        this.nQ = SystemClock.elapsedRealtime() - this.nP;
    }

    public void dI() {
        if ("additional_thread".equals(this.nT)) {
            com.baidu.ar.b.a.ar().a(11, true);
        }
        dF();
        dG();
        dH();
        if ("additional_thread".equals(this.nT)) {
            com.baidu.ar.b.a.ar().a(11, false);
        }
    }

    public i dJ() {
        return this.nM;
    }

    public void dK() {
        this.nN = this.nM.ee();
    }

    public void i(long j) {
        this.lQ = j;
    }
}

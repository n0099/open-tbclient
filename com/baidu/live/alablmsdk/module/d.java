package com.baidu.live.alablmsdk.module;

import android.text.TextUtils;
import com.baidu.live.alablmsdk.module.state.BLMConnectionState;
import com.baidu.live.alablmsdk.module.state.BLMRtcState;
import com.baidu.live.alablmsdk.module.state.BLMSignalState;
import com.baidu.live.alablmsdk.module.state.BLMStateType;
/* loaded from: classes11.dex */
public class d {
    public c aCP;
    public com.baidu.live.alablmsdk.a.a.b aCQ;
    private boolean aCR = false;
    private BLMConnectionState aCS = BLMConnectionState.DEFAULT;
    private BLMSignalState aCT = BLMSignalState.DEFAULT;
    private BLMRtcState aCU = BLMRtcState.DEFAULT;

    public void b(BLMSignalState bLMSignalState) {
        com.baidu.live.alablmsdk.a.b.a.aj(" updateSignalState mSignalState=" + this.aCT, "");
        this.aCT = bLMSignalState;
        Ck();
    }

    public BLMSignalState Cb() {
        return this.aCT;
    }

    public void b(BLMRtcState bLMRtcState) {
        com.baidu.live.alablmsdk.a.b.a.aj(" updateRtcState mRtcState=" + this.aCU, "");
        this.aCU = bLMRtcState;
        Ck();
    }

    public BLMRtcState Ci() {
        return this.aCU;
    }

    public long Cj() {
        if (this.aCP != null) {
            return this.aCP.aCG;
        }
        return 0L;
    }

    private void Ck() {
        com.baidu.live.alablmsdk.a.b.a.aj(" updateTransaction mSignalState=" + this.aCT + " , mRtcState=" + this.aCU, this.aCP != null ? this.aCP.toString() : "");
        if (this.aCT != BLMSignalState.DEFAULT || this.aCU != BLMRtcState.DEFAULT) {
            this.aCR = true;
        } else {
            this.aCR = false;
        }
        com.baidu.live.alablmsdk.a.b.a.aj(" updateTransaction hasStartTransaction=" + this.aCR, "");
    }

    public boolean Cl() {
        return this.aCR;
    }

    public void b(d dVar, BLMStateType bLMStateType) {
        if (dVar != null && dVar.aCP != null && this.aCP != null && this.aCP.aCG == dVar.aCP.aCG) {
            if (bLMStateType == BLMStateType.SIGNAL) {
                b(dVar.Cb());
            } else if (bLMStateType == BLMStateType.RTC) {
                b(dVar.Ci());
            }
        }
    }

    public void a(d dVar) {
        if (dVar != null && dVar.aCP != null && this.aCP != null && this.aCP.aCG == dVar.aCP.aCG && !TextUtils.isEmpty(dVar.aCP.order)) {
            this.aCP.order = dVar.aCP.order;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" user imuk=");
        if (this.aCP != null) {
            sb.append(this.aCP.aCG);
        }
        sb.append(" , hasStartTransaction ").append(this.aCR);
        if (this.aCT != null) {
            sb.append(" signal state ").append(this.aCT.toString());
        }
        if (this.aCU != null) {
            sb.append(" rtc state ").append(this.aCU.toString());
        }
        return sb.toString();
    }

    public void release() {
        if (this.aCQ != null) {
            this.aCQ.Bn();
            this.aCQ = null;
        }
    }
}

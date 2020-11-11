package com.baidu.live.alablmsdk.module;

import android.text.TextUtils;
import com.baidu.live.alablmsdk.module.state.BLMConnectionState;
import com.baidu.live.alablmsdk.module.state.BLMRtcState;
import com.baidu.live.alablmsdk.module.state.BLMSignalState;
import com.baidu.live.alablmsdk.module.state.BLMStateType;
/* loaded from: classes4.dex */
public class d {
    public c aBD;
    public com.baidu.live.alablmsdk.a.a.b aBE;
    private boolean aBF = false;
    private BLMConnectionState aBG = BLMConnectionState.DEFAULT;
    private BLMSignalState aBH = BLMSignalState.DEFAULT;
    private BLMRtcState aBI = BLMRtcState.DEFAULT;

    public void b(BLMSignalState bLMSignalState) {
        com.baidu.live.alablmsdk.a.b.ah(" updateSignalState mSignalState=" + this.aBH, "");
        this.aBH = bLMSignalState;
        BU();
    }

    public BLMSignalState BR() {
        return this.aBH;
    }

    public void b(BLMRtcState bLMRtcState) {
        com.baidu.live.alablmsdk.a.b.ah(" updateRtcState mRtcState=" + this.aBI, "");
        this.aBI = bLMRtcState;
        BU();
    }

    public BLMRtcState BS() {
        return this.aBI;
    }

    public long BT() {
        if (this.aBD != null) {
            return this.aBD.aBv;
        }
        return 0L;
    }

    private void BU() {
        com.baidu.live.alablmsdk.a.b.ah(" updateTransaction mSignalState=" + this.aBH + " , mRtcState=" + this.aBI, this.aBD != null ? this.aBD.toString() : "");
        if (this.aBH != BLMSignalState.DEFAULT || this.aBI != BLMRtcState.DEFAULT) {
            this.aBF = true;
        } else {
            this.aBF = false;
        }
        com.baidu.live.alablmsdk.a.b.ah(" updateTransaction hasStartTransaction=" + this.aBF, "");
    }

    public boolean BV() {
        return this.aBF;
    }

    public void b(d dVar, BLMStateType bLMStateType) {
        if (dVar != null && dVar.aBD != null && this.aBD != null && this.aBD.aBv == dVar.aBD.aBv) {
            if (bLMStateType == BLMStateType.SIGNAL) {
                b(dVar.BR());
            } else if (bLMStateType == BLMStateType.RTC) {
                b(dVar.BS());
            }
        }
    }

    public void a(d dVar) {
        if (dVar != null && dVar.aBD != null && this.aBD != null && this.aBD.aBv == dVar.aBD.aBv && !TextUtils.isEmpty(dVar.aBD.order)) {
            this.aBD.order = dVar.aBD.order;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" user imuk=");
        if (this.aBD != null) {
            sb.append(this.aBD.aBv);
        }
        sb.append(" , hasStartTransaction ").append(this.aBF);
        if (this.aBH != null) {
            sb.append(" signal state ").append(this.aBH.toString());
        }
        if (this.aBI != null) {
            sb.append(" rtc state ").append(this.aBI.toString());
        }
        return sb.toString();
    }

    public void release() {
        if (this.aBE != null) {
            this.aBE.Bl();
            this.aBE = null;
        }
    }
}

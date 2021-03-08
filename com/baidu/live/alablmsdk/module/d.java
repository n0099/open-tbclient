package com.baidu.live.alablmsdk.module;

import android.text.TextUtils;
import com.baidu.live.alablmsdk.module.state.BLMConnectionState;
import com.baidu.live.alablmsdk.module.state.BLMRtcState;
import com.baidu.live.alablmsdk.module.state.BLMSignalState;
import com.baidu.live.alablmsdk.module.state.BLMStateType;
/* loaded from: classes10.dex */
public class d {
    public c azT;
    public com.baidu.live.alablmsdk.a.a.b azU;
    private boolean azV = false;
    private BLMConnectionState azW = BLMConnectionState.DEFAULT;
    private BLMSignalState azX = BLMSignalState.DEFAULT;
    private BLMRtcState azY = BLMRtcState.DEFAULT;

    public void b(BLMSignalState bLMSignalState) {
        com.baidu.live.alablmsdk.a.b.a.ag(" updateSignalState mSignalState=" + this.azX, "");
        this.azX = bLMSignalState;
        yG();
    }

    public BLMSignalState yw() {
        return this.azX;
    }

    public void b(BLMRtcState bLMRtcState) {
        com.baidu.live.alablmsdk.a.b.a.ag(" updateRtcState mRtcState=" + this.azY, "");
        this.azY = bLMRtcState;
        yG();
    }

    public BLMRtcState yE() {
        return this.azY;
    }

    public long yF() {
        if (this.azT != null) {
            return this.azT.azK;
        }
        return 0L;
    }

    private void yG() {
        com.baidu.live.alablmsdk.a.b.a.ag(" updateTransaction mSignalState=" + this.azX + " , mRtcState=" + this.azY, this.azT != null ? this.azT.toString() : "");
        if (this.azX != BLMSignalState.DEFAULT || this.azY != BLMRtcState.DEFAULT) {
            this.azV = true;
        } else {
            this.azV = false;
        }
        com.baidu.live.alablmsdk.a.b.a.ag(" updateTransaction hasStartTransaction=" + this.azV, "");
    }

    public boolean yH() {
        return this.azV;
    }

    public void b(d dVar, BLMStateType bLMStateType) {
        if (dVar != null && dVar.azT != null && this.azT != null && this.azT.azK == dVar.azT.azK) {
            if (bLMStateType == BLMStateType.SIGNAL) {
                b(dVar.yw());
            } else if (bLMStateType == BLMStateType.RTC) {
                b(dVar.yE());
            }
        }
    }

    public void a(d dVar) {
        if (dVar != null && dVar.azT != null && this.azT != null && this.azT.azK == dVar.azT.azK && !TextUtils.isEmpty(dVar.azT.order)) {
            this.azT.order = dVar.azT.order;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" user imuk=");
        if (this.azT != null) {
            sb.append(this.azT.azK);
        }
        sb.append(" , hasStartTransaction ").append(this.azV);
        if (this.azX != null) {
            sb.append(" signal state ").append(this.azX.toString());
        }
        if (this.azY != null) {
            sb.append(" rtc state ").append(this.azY.toString());
        }
        return sb.toString();
    }

    public void release() {
        if (this.azU != null) {
            this.azU.xv();
            this.azU = null;
        }
    }
}

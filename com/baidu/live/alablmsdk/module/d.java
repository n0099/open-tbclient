package com.baidu.live.alablmsdk.module;

import android.text.TextUtils;
import com.baidu.live.alablmsdk.module.state.BLMConnectionState;
import com.baidu.live.alablmsdk.module.state.BLMRtcState;
import com.baidu.live.alablmsdk.module.state.BLMSignalState;
import com.baidu.live.alablmsdk.module.state.BLMStateType;
/* loaded from: classes4.dex */
public class d {
    public c azS;
    public com.baidu.live.alablmsdk.a.a.b azT;
    private boolean azU = false;
    private BLMConnectionState azV = BLMConnectionState.DEFAULT;
    private BLMSignalState azW = BLMSignalState.DEFAULT;
    private BLMRtcState azX = BLMRtcState.DEFAULT;

    public void b(BLMSignalState bLMSignalState) {
        com.baidu.live.alablmsdk.a.b.ag(" updateSignalState mSignalState=" + this.azW, "");
        this.azW = bLMSignalState;
        Bl();
    }

    public BLMSignalState Bi() {
        return this.azW;
    }

    public void b(BLMRtcState bLMRtcState) {
        com.baidu.live.alablmsdk.a.b.ag(" updateRtcState mRtcState=" + this.azX, "");
        this.azX = bLMRtcState;
        Bl();
    }

    public BLMRtcState Bj() {
        return this.azX;
    }

    public long Bk() {
        if (this.azS != null) {
            return this.azS.azK;
        }
        return 0L;
    }

    private void Bl() {
        com.baidu.live.alablmsdk.a.b.ag(" updateTransaction mSignalState=" + this.azW + " , mRtcState=" + this.azX, this.azS != null ? this.azS.toString() : "");
        if (this.azW != BLMSignalState.DEFAULT || this.azX != BLMRtcState.DEFAULT) {
            this.azU = true;
        } else {
            this.azU = false;
        }
        com.baidu.live.alablmsdk.a.b.ag(" updateTransaction hasStartTransaction=" + this.azU, "");
    }

    public boolean Bm() {
        return this.azU;
    }

    public void b(d dVar, BLMStateType bLMStateType) {
        if (dVar != null && dVar.azS != null && this.azS != null && this.azS.azK == dVar.azS.azK) {
            if (bLMStateType == BLMStateType.SIGNAL) {
                b(dVar.Bi());
            } else if (bLMStateType == BLMStateType.RTC) {
                b(dVar.Bj());
            }
        }
    }

    public void a(d dVar) {
        if (dVar != null && dVar.azS != null && this.azS != null && this.azS.azK == dVar.azS.azK && !TextUtils.isEmpty(dVar.azS.order)) {
            this.azS.order = dVar.azS.order;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" user imuk=");
        if (this.azS != null) {
            sb.append(this.azS.azK);
        }
        sb.append(" , hasStartTransaction ").append(this.azU);
        if (this.azW != null) {
            sb.append(" signal state ").append(this.azW.toString());
        }
        if (this.azX != null) {
            sb.append(" rtc state ").append(this.azX.toString());
        }
        return sb.toString();
    }

    public void release() {
        if (this.azT != null) {
            this.azT.AC();
            this.azT = null;
        }
    }
}

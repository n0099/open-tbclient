package com.baidu.live.alablmsdk.module;

import android.text.TextUtils;
import com.baidu.live.alablmsdk.module.state.BLMConnectionState;
import com.baidu.live.alablmsdk.module.state.BLMRtcState;
import com.baidu.live.alablmsdk.module.state.BLMSignalState;
import com.baidu.live.alablmsdk.module.state.BLMStateType;
/* loaded from: classes4.dex */
public class d {
    private boolean aCA = false;
    private BLMConnectionState aCB = BLMConnectionState.DEFAULT;
    private BLMSignalState aCC = BLMSignalState.DEFAULT;
    private BLMRtcState aCD = BLMRtcState.DEFAULT;
    public c aCy;
    public com.baidu.live.alablmsdk.a.a.b aCz;

    public void b(BLMSignalState bLMSignalState) {
        com.baidu.live.alablmsdk.a.b.a.ak(" updateSignalState mSignalState=" + this.aCC, "");
        this.aCC = bLMSignalState;
        CT();
    }

    public BLMSignalState CK() {
        return this.aCC;
    }

    public void b(BLMRtcState bLMRtcState) {
        com.baidu.live.alablmsdk.a.b.a.ak(" updateRtcState mRtcState=" + this.aCD, "");
        this.aCD = bLMRtcState;
        CT();
    }

    public BLMRtcState CR() {
        return this.aCD;
    }

    public long CS() {
        if (this.aCy != null) {
            return this.aCy.aCp;
        }
        return 0L;
    }

    private void CT() {
        com.baidu.live.alablmsdk.a.b.a.ak(" updateTransaction mSignalState=" + this.aCC + " , mRtcState=" + this.aCD, this.aCy != null ? this.aCy.toString() : "");
        if (this.aCC != BLMSignalState.DEFAULT || this.aCD != BLMRtcState.DEFAULT) {
            this.aCA = true;
        } else {
            this.aCA = false;
        }
        com.baidu.live.alablmsdk.a.b.a.ak(" updateTransaction hasStartTransaction=" + this.aCA, "");
    }

    public boolean CU() {
        return this.aCA;
    }

    public void b(d dVar, BLMStateType bLMStateType) {
        if (dVar != null && dVar.aCy != null && this.aCy != null && this.aCy.aCp == dVar.aCy.aCp) {
            if (bLMStateType == BLMStateType.SIGNAL) {
                b(dVar.CK());
            } else if (bLMStateType == BLMStateType.RTC) {
                b(dVar.CR());
            }
        }
    }

    public void a(d dVar) {
        if (dVar != null && dVar.aCy != null && this.aCy != null && this.aCy.aCp == dVar.aCy.aCp && !TextUtils.isEmpty(dVar.aCy.order)) {
            this.aCy.order = dVar.aCy.order;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" user imuk=");
        if (this.aCy != null) {
            sb.append(this.aCy.aCp);
        }
        sb.append(" , hasStartTransaction ").append(this.aCA);
        if (this.aCC != null) {
            sb.append(" signal state ").append(this.aCC.toString());
        }
        if (this.aCD != null) {
            sb.append(" rtc state ").append(this.aCD.toString());
        }
        return sb.toString();
    }

    public void release() {
        if (this.aCz != null) {
            this.aCz.BW();
            this.aCz = null;
        }
    }
}

package com.baidu.live.alablmsdk.module;

import android.text.TextUtils;
import com.baidu.live.alablmsdk.module.state.BLMConnectionState;
import com.baidu.live.alablmsdk.module.state.BLMRtcState;
import com.baidu.live.alablmsdk.module.state.BLMSignalState;
import com.baidu.live.alablmsdk.module.state.BLMStateType;
/* loaded from: classes10.dex */
public class d {
    public c ayc;
    public com.baidu.live.alablmsdk.a.a.b ayd;
    private boolean aye = false;
    private BLMConnectionState ayf = BLMConnectionState.DEFAULT;
    private BLMSignalState ayg = BLMSignalState.DEFAULT;
    private BLMRtcState ayh = BLMRtcState.DEFAULT;

    public void b(BLMSignalState bLMSignalState) {
        com.baidu.live.alablmsdk.a.b.a.ai(" updateSignalState mSignalState=" + this.ayg, "");
        this.ayg = bLMSignalState;
        yp();
    }

    public BLMSignalState yg() {
        return this.ayg;
    }

    public void b(BLMRtcState bLMRtcState) {
        com.baidu.live.alablmsdk.a.b.a.ai(" updateRtcState mRtcState=" + this.ayh, "");
        this.ayh = bLMRtcState;
        yp();
    }

    public BLMRtcState yn() {
        return this.ayh;
    }

    public long yo() {
        if (this.ayc != null) {
            return this.ayc.axT;
        }
        return 0L;
    }

    private void yp() {
        com.baidu.live.alablmsdk.a.b.a.ai(" updateTransaction mSignalState=" + this.ayg + " , mRtcState=" + this.ayh, this.ayc != null ? this.ayc.toString() : "");
        if (this.ayg != BLMSignalState.DEFAULT || this.ayh != BLMRtcState.DEFAULT) {
            this.aye = true;
        } else {
            this.aye = false;
        }
        com.baidu.live.alablmsdk.a.b.a.ai(" updateTransaction hasStartTransaction=" + this.aye, "");
    }

    public boolean yq() {
        return this.aye;
    }

    public void b(d dVar, BLMStateType bLMStateType) {
        if (dVar != null && dVar.ayc != null && this.ayc != null && this.ayc.axT == dVar.ayc.axT) {
            if (bLMStateType == BLMStateType.SIGNAL) {
                b(dVar.yg());
            } else if (bLMStateType == BLMStateType.RTC) {
                b(dVar.yn());
            }
        }
    }

    public void a(d dVar) {
        if (dVar != null && dVar.ayc != null && this.ayc != null && this.ayc.axT == dVar.ayc.axT && !TextUtils.isEmpty(dVar.ayc.order)) {
            this.ayc.order = dVar.ayc.order;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" user imuk=");
        if (this.ayc != null) {
            sb.append(this.ayc.axT);
        }
        sb.append(" , hasStartTransaction ").append(this.aye);
        if (this.ayg != null) {
            sb.append(" signal state ").append(this.ayg.toString());
        }
        if (this.ayh != null) {
            sb.append(" rtc state ").append(this.ayh.toString());
        }
        return sb.toString();
    }

    public void release() {
        if (this.ayd != null) {
            this.ayd.xs();
            this.ayd = null;
        }
    }
}

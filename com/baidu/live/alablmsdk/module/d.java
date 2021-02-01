package com.baidu.live.alablmsdk.module;

import android.text.TextUtils;
import com.baidu.live.alablmsdk.module.state.BLMConnectionState;
import com.baidu.live.alablmsdk.module.state.BLMRtcState;
import com.baidu.live.alablmsdk.module.state.BLMSignalState;
import com.baidu.live.alablmsdk.module.state.BLMStateType;
/* loaded from: classes11.dex */
public class d {
    public c ayt;
    public com.baidu.live.alablmsdk.a.a.b ayu;
    private boolean ayv = false;
    private BLMConnectionState ayw = BLMConnectionState.DEFAULT;
    private BLMSignalState ayx = BLMSignalState.DEFAULT;
    private BLMRtcState ayy = BLMRtcState.DEFAULT;

    public void b(BLMSignalState bLMSignalState) {
        com.baidu.live.alablmsdk.a.b.a.ag(" updateSignalState mSignalState=" + this.ayx, "");
        this.ayx = bLMSignalState;
        yD();
    }

    public BLMSignalState yt() {
        return this.ayx;
    }

    public void b(BLMRtcState bLMRtcState) {
        com.baidu.live.alablmsdk.a.b.a.ag(" updateRtcState mRtcState=" + this.ayy, "");
        this.ayy = bLMRtcState;
        yD();
    }

    public BLMRtcState yB() {
        return this.ayy;
    }

    public long yC() {
        if (this.ayt != null) {
            return this.ayt.ayk;
        }
        return 0L;
    }

    private void yD() {
        com.baidu.live.alablmsdk.a.b.a.ag(" updateTransaction mSignalState=" + this.ayx + " , mRtcState=" + this.ayy, this.ayt != null ? this.ayt.toString() : "");
        if (this.ayx != BLMSignalState.DEFAULT || this.ayy != BLMRtcState.DEFAULT) {
            this.ayv = true;
        } else {
            this.ayv = false;
        }
        com.baidu.live.alablmsdk.a.b.a.ag(" updateTransaction hasStartTransaction=" + this.ayv, "");
    }

    public boolean yE() {
        return this.ayv;
    }

    public void b(d dVar, BLMStateType bLMStateType) {
        if (dVar != null && dVar.ayt != null && this.ayt != null && this.ayt.ayk == dVar.ayt.ayk) {
            if (bLMStateType == BLMStateType.SIGNAL) {
                b(dVar.yt());
            } else if (bLMStateType == BLMStateType.RTC) {
                b(dVar.yB());
            }
        }
    }

    public void a(d dVar) {
        if (dVar != null && dVar.ayt != null && this.ayt != null && this.ayt.ayk == dVar.ayt.ayk && !TextUtils.isEmpty(dVar.ayt.order)) {
            this.ayt.order = dVar.ayt.order;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" user imuk=");
        if (this.ayt != null) {
            sb.append(this.ayt.ayk);
        }
        sb.append(" , hasStartTransaction ").append(this.ayv);
        if (this.ayx != null) {
            sb.append(" signal state ").append(this.ayx.toString());
        }
        if (this.ayy != null) {
            sb.append(" rtc state ").append(this.ayy.toString());
        }
        return sb.toString();
    }

    public void release() {
        if (this.ayu != null) {
            this.ayu.xs();
            this.ayu = null;
        }
    }
}

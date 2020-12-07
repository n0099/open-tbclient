package com.baidu.platform.comapi.walknavi.fsm;

import com.baidu.platform.comapi.walknavi.b;
import com.baidu.tieba.R;
/* loaded from: classes26.dex */
public class RGStateSeg extends RGState {
    @Override // com.baidu.platform.comapi.walknavi.fsm.RGState
    protected void onActionUI() {
        b.a().T().c(R.drawable.aiapps_loading);
        if (b.a().M() != 4) {
            b.a().T().a(false);
        }
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGState
    protected void onActionNaviEngine() {
        b.a().G().a(true);
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGState
    protected void onActionLayers() {
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGState
    protected void onActionMapStatus() {
        b.a().T().o();
        b.a().J().b(true);
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGState
    public void excute() {
        super.excute();
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGState
    public void exit() {
        super.exit();
    }
}

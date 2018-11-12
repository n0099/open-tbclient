package com.baidu.platform.comapi.walknavi.fsm;

import com.baidu.platform.comapi.walknavi.b;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class RGStateSeg extends RGState {
    @Override // com.baidu.platform.comapi.walknavi.fsm.RGState
    protected void onActionUI() {
        b.a().L().c(R.drawable.aiapps_no_recommend);
        if (b.a().E() != 4) {
            b.a().L().a(false);
        }
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGState
    protected void onActionNaviEngine() {
        b.a().y().a(true);
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGState
    protected void onActionLayers() {
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGState
    protected void onActionMapStatus() {
        b.a().L().o();
        b.a().B().b(true);
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

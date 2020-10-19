package com.baidu.platform.comapi.walknavi.fsm;

import com.baidu.platform.comapi.walknavi.b;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class RGStateBrowseMap extends RGState {
    @Override // com.baidu.platform.comapi.walknavi.fsm.RGState
    protected void onActionUI() {
        b.a().T().l();
        b.a().T().c(R.drawable.aiapps_loading);
        if (com.baidu.platform.comapi.wnplatform.a.a().f()) {
            if (b.a().M() != 4) {
                b.a().T().a(false);
            }
        } else if (com.baidu.platform.comapi.wnplatform.a.a().g()) {
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
        if (b.a().M() != 4) {
            b.a().T().b(30000);
        }
        b.a().J().b(true);
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGState
    public void excute() {
        super.excute();
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGState
    public void exit() {
        WGuideFSM.saveZoomLevel();
        super.exit();
    }
}

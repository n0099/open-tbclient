package com.baidu.platform.comapi.walknavi.fsm;

import com.baidu.platform.comapi.walknavi.b;
/* loaded from: classes2.dex */
public class RGStateBrowseMap extends RGState {
    @Override // com.baidu.platform.comapi.walknavi.fsm.RGState
    public void excute() {
        super.excute();
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGState
    public void exit() {
        WGuideFSM.saveZoomLevel();
        super.exit();
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGState
    public void onActionLayers() {
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGState
    public void onActionMapStatus() {
        b.a().Q().o();
        if (b.a().J() != 4) {
            b.a().Q().b(30000);
        }
        b.a().G().b(true);
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGState
    public void onActionNaviEngine() {
        b.a().D().a(true);
    }

    @Override // com.baidu.platform.comapi.walknavi.fsm.RGState
    public void onActionUI() {
        b.a().Q().l();
        b.a().Q().c(2130837751);
        if (com.baidu.platform.comapi.wnplatform.a.a().f()) {
            if (b.a().J() != 4) {
                b.a().Q().a(false);
            }
        } else if (com.baidu.platform.comapi.wnplatform.a.a().g()) {
            b.a().Q().a(false);
        }
    }
}

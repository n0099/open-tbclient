package com.baidu.platform.comapi.walknavi.fsm;

import com.baidu.platform.comapi.walknavi.b;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class RGStateBrowseMap extends RGState {
    @Override // com.baidu.platform.comapi.walknavi.fsm.RGState
    protected void onActionUI() {
        b.a().L().l();
        b.a().L().c(R.drawable.aiapps_night_mode_toast_icon);
        if (com.baidu.platform.comapi.wnplatform.a.a().b() == 0) {
            if (b.a().E() != 4) {
                b.a().L().a(false);
            }
        } else if (com.baidu.platform.comapi.wnplatform.a.a().b() == 1) {
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
        if (b.a().E() != 4) {
            b.a().L().b(30000);
        }
        b.a().B().b(true);
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

package com.baidu.live.talentshow.components.preview;

import android.content.Context;
import android.view.View;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.bo;
import com.baidu.live.data.x;
import com.baidu.live.sdk.a;
import com.baidu.live.talentshow.a.c;
import com.baidu.live.talentshow.components.preview.LiveBCAudiencePreviewLayer;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
/* loaded from: classes10.dex */
public class b {
    private x aBr;
    private LiveBCAudiencePreviewLayer bzK;
    private c bzL;
    private com.baidu.live.talentshow.a.a bzM;
    private a bzN;
    private LiveBCAudiencePreviewLayer.a bzO = new LiveBCAudiencePreviewLayer.a() { // from class: com.baidu.live.talentshow.components.preview.b.1
        @Override // com.baidu.live.talentshow.components.preview.LiveBCAudiencePreviewLayer.a
        public void Qu() {
            b.this.bzL.w(b.this.bzK.getRenderViewParent());
            b.this.bzL.startPreview();
        }

        @Override // com.baidu.live.talentshow.components.preview.LiveBCAudiencePreviewLayer.a
        public void Qv() {
            b.this.bzL.QV();
            b.this.bzL.QW();
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.live.talentshow.components.preview.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!UtilHelper.isFastDoubleClick()) {
                if (view != b.this.bzK.getBtnClose()) {
                    if (view == b.this.bzK.getChatOptBtn()) {
                        if (b.this.bzN != null) {
                            b.this.bzN.Qe();
                            return;
                        }
                        return;
                    } else if (view == b.this.bzK.getBeautyBtn()) {
                        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", UbcStatConstant.Value.VALUE_BC_CHAT_DUO_PRE_BEAUTY_CLICK).setContentExt(null, UbcStatConstant.SubPage.POPUP, null));
                        b.this.Qp();
                        return;
                    } else {
                        return;
                    }
                }
                b.this.Qt();
                UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", UbcStatConstant.Value.VALUE_BC_CHAT_DUO_PRE_POP_SEC).setContentExt(null, UbcStatConstant.SubPage.POPUP, null));
            }
        }
    };
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void a(c cVar) {
        this.bzL = cVar;
    }

    public void setLiveShowData(x xVar) {
        this.aBr = xVar;
    }

    public void a(a aVar) {
        this.bzN = aVar;
    }

    public void n(Context context, boolean z) {
        if (this.bzK == null) {
            this.bzK = new LiveBCAudiencePreviewLayer(context);
            this.bzK.setNeedHideAnim(true);
            this.bzK.setNeedShowAnim(true);
            this.bzK.setCanceledOnTouchOutside(true);
            this.bzK.setOutOnClickListener(this.mClickListener);
            this.bzK.setLayerVisibleListener(this.bzO);
        }
        this.bzK.Qw();
        if (UtilHelper.getRealScreenOrientation(context) != 2) {
            com.baidu.live.core.layer.b.As().d(this.bzK);
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", UbcStatConstant.Value.VALUE_BC_CHAT_DUO_PRE_POP_SHOW).setContentExt(null, UbcStatConstant.SubPage.POPUP, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qp() {
        if (bo.c(com.baidu.live.af.a.OJ().bxp)) {
            this.mPageContext.showToast(a.h.sdk_filter_beauty_grey_tip);
        } else if (this.bzL.QS() != null) {
            if (this.bzM == null) {
                this.bzM = new com.baidu.live.talentshow.a.a(this.mPageContext, this.bzK.getRootView(), this.bzL.QS());
            }
            this.bzM.setLiveShowData(this.aBr);
            this.bzM.QN();
            BdUtilHelper.hideSoftKeyPad(this.mPageContext.getPageActivity(), this.bzK);
        }
    }

    public void Qq() {
        if (this.bzK != null) {
            this.bzK.Qq();
        }
    }

    public void Qr() {
        if (this.bzK != null) {
            this.bzK.Qr();
        }
    }

    public boolean Qs() {
        return (this.bzK == null || this.bzK.getParent() == null) ? false : true;
    }

    public void Qt() {
        com.baidu.live.core.layer.b.As().e(this.bzK);
    }

    public void onDestroy() {
        if (this.bzM != null) {
            this.bzM.onDestroy();
        }
        if (this.bzL != null) {
            this.bzL.onDestroy();
        }
        if (this.bzK != null && this.bzK.getParent() != null) {
            com.baidu.live.core.layer.b.As().e(this.bzK);
        }
    }
}

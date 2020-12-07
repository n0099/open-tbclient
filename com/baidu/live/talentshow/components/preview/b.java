package com.baidu.live.talentshow.components.preview;

import android.content.Context;
import android.view.View;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.bm;
import com.baidu.live.data.w;
import com.baidu.live.sdk.a;
import com.baidu.live.talentshow.a.c;
import com.baidu.live.talentshow.components.preview.LiveBCAudiencePreviewLayer;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
/* loaded from: classes4.dex */
public class b {
    private w aFN;
    private LiveBCAudiencePreviewLayer bzJ;
    private c bzK;
    private com.baidu.live.talentshow.a.a bzL;
    private a bzM;
    private LiveBCAudiencePreviewLayer.a bzN = new LiveBCAudiencePreviewLayer.a() { // from class: com.baidu.live.talentshow.components.preview.b.1
        @Override // com.baidu.live.talentshow.components.preview.LiveBCAudiencePreviewLayer.a
        public void Tk() {
            b.this.bzK.t(b.this.bzJ.getRenderViewParent());
            b.this.bzK.startPreview();
        }

        @Override // com.baidu.live.talentshow.components.preview.LiveBCAudiencePreviewLayer.a
        public void Tl() {
            b.this.bzK.TL();
            b.this.bzK.TM();
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.live.talentshow.components.preview.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!UtilHelper.isFastDoubleClick()) {
                if (view != b.this.bzJ.getBtnClose()) {
                    if (view == b.this.bzJ.getChatOptBtn()) {
                        if (b.this.bzM != null) {
                            b.this.bzM.SS();
                            return;
                        }
                        return;
                    } else if (view == b.this.bzJ.getBeautyBtn()) {
                        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", UbcStatConstant.Value.VALUE_BC_CHAT_DUO_PRE_BEAUTY_CLICK).setContentExt(null, "popup", null));
                        b.this.Tf();
                        return;
                    } else {
                        return;
                    }
                }
                b.this.Tj();
                UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", UbcStatConstant.Value.VALUE_BC_CHAT_DUO_PRE_POP_SEC).setContentExt(null, "popup", null));
            }
        }
    };
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void a(c cVar) {
        this.bzK = cVar;
    }

    public void setLiveShowData(w wVar) {
        this.aFN = wVar;
    }

    public void a(a aVar) {
        this.bzM = aVar;
    }

    public void n(Context context, boolean z) {
        if (this.bzJ == null) {
            this.bzJ = new LiveBCAudiencePreviewLayer(context);
            this.bzJ.setNeedHideAnim(true);
            this.bzJ.setNeedShowAnim(true);
            this.bzJ.setCanceledOnTouchOutside(true);
            this.bzJ.setOutOnClickListener(this.mClickListener);
            this.bzJ.setLayerVisibleListener(this.bzN);
        }
        this.bzJ.Tm();
        if (UtilHelper.getRealScreenOrientation(context) != 2) {
            com.baidu.live.core.layer.b.EY().d(this.bzJ);
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", UbcStatConstant.Value.VALUE_BC_CHAT_DUO_PRE_POP_SHOW).setContentExt(null, "popup", null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tf() {
        if (bm.c(com.baidu.live.ae.a.RB().bxq)) {
            this.mPageContext.showToast(a.h.sdk_filter_beauty_grey_tip);
        } else if (this.bzK.TI() != null) {
            if (this.bzL == null) {
                this.bzL = new com.baidu.live.talentshow.a.a(this.mPageContext, this.bzJ.getRootView(), this.bzK.TI());
            }
            this.bzL.setLiveShowData(this.aFN);
            this.bzL.TD();
            BdUtilHelper.hideSoftKeyPad(this.mPageContext.getPageActivity(), this.bzJ);
        }
    }

    public void Tg() {
        if (this.bzJ != null) {
            this.bzJ.Tg();
        }
    }

    public void Th() {
        if (this.bzJ != null) {
            this.bzJ.Th();
        }
    }

    public boolean Ti() {
        return (this.bzJ == null || this.bzJ.getParent() == null) ? false : true;
    }

    public void Tj() {
        com.baidu.live.core.layer.b.EY().e(this.bzJ);
    }

    public void onDestroy() {
        if (this.bzL != null) {
            this.bzL.onDestroy();
        }
        if (this.bzK != null) {
            this.bzK.onDestroy();
        }
        if (this.bzJ != null && this.bzJ.getParent() != null) {
            com.baidu.live.core.layer.b.EY().e(this.bzJ);
        }
    }
}

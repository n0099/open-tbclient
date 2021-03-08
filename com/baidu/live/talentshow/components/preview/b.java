package com.baidu.live.talentshow.components.preview;

import android.content.Context;
import android.view.View;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.ab;
import com.baidu.live.data.bt;
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
    private ab aED;
    private LiveBCAudiencePreviewLayer bEQ;
    private c bER;
    private com.baidu.live.talentshow.a.a bES;
    private a bET;
    private LiveBCAudiencePreviewLayer.a bEU = new LiveBCAudiencePreviewLayer.a() { // from class: com.baidu.live.talentshow.components.preview.b.1
        @Override // com.baidu.live.talentshow.components.preview.LiveBCAudiencePreviewLayer.a
        public void Sh() {
            b.this.bER.u(b.this.bEQ.getRenderViewParent());
            b.this.bER.startPreview();
        }

        @Override // com.baidu.live.talentshow.components.preview.LiveBCAudiencePreviewLayer.a
        public void Si() {
            b.this.bER.SI();
            b.this.bER.stopPreview();
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.live.talentshow.components.preview.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!UtilHelper.isFastDoubleClick()) {
                if (view != b.this.bEQ.getBtnClose()) {
                    if (view == b.this.bEQ.getChatOptBtn()) {
                        if (b.this.bET != null) {
                            b.this.bET.RR();
                            return;
                        }
                        return;
                    } else if (view == b.this.bEQ.getBeautyBtn()) {
                        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", UbcStatConstant.Value.VALUE_BC_CHAT_DUO_PRE_BEAUTY_CLICK).setContentExt(null, UbcStatConstant.SubPage.POPUP, null));
                        b.this.Sc();
                        return;
                    } else {
                        return;
                    }
                }
                b.this.Sg();
                UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", UbcStatConstant.Value.VALUE_BC_CHAT_DUO_PRE_POP_SEC).setContentExt(null, UbcStatConstant.SubPage.POPUP, null));
            }
        }
    };
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void a(c cVar) {
        this.bER = cVar;
    }

    public void setLiveShowData(ab abVar) {
        this.aED = abVar;
    }

    public void a(a aVar) {
        this.bET = aVar;
    }

    public void o(Context context, boolean z) {
        if (this.bEQ == null) {
            this.bEQ = new LiveBCAudiencePreviewLayer(context);
            this.bEQ.setNeedHideAnim(true);
            this.bEQ.setNeedShowAnim(true);
            this.bEQ.setCanceledOnTouchOutside(true);
            this.bEQ.setOutOnClickListener(this.mClickListener);
            this.bEQ.setLayerVisibleListener(this.bEU);
        }
        this.bEQ.Sj();
        if (UtilHelper.getRealScreenOrientation(context) != 2) {
            com.baidu.live.core.layer.b.Bf().d(this.bEQ);
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", UbcStatConstant.Value.VALUE_BC_CHAT_DUO_PRE_POP_SHOW).setContentExt(null, UbcStatConstant.SubPage.POPUP, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sc() {
        if (bt.c(com.baidu.live.ae.a.Qm().bCs)) {
            this.mPageContext.showToast(a.h.sdk_filter_beauty_grey_tip);
        } else if (this.bER.SF() != null) {
            if (this.bES == null) {
                this.bES = new com.baidu.live.talentshow.a.a(this.mPageContext, this.bEQ.getRootView(), this.bER.SF());
            }
            this.bES.setLiveShowData(this.aED);
            this.bES.SA();
            BdUtilHelper.hideSoftKeyPad(this.mPageContext.getPageActivity(), this.bEQ);
        }
    }

    public void Sd() {
        if (this.bEQ != null) {
            this.bEQ.Sd();
        }
    }

    public void Se() {
        if (this.bEQ != null) {
            this.bEQ.Se();
        }
    }

    public boolean Sf() {
        return (this.bEQ == null || this.bEQ.getParent() == null) ? false : true;
    }

    public void Sg() {
        com.baidu.live.core.layer.b.Bf().e(this.bEQ);
    }

    public void onDestroy() {
        if (this.bES != null) {
            this.bES.onDestroy();
        }
        if (this.bER != null) {
            this.bER.onDestroy();
        }
        if (this.bEQ != null && this.bEQ.getParent() != null) {
            com.baidu.live.core.layer.b.Bf().e(this.bEQ);
        }
    }
}

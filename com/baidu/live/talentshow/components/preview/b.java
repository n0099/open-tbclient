package com.baidu.live.talentshow.components.preview;

import android.content.Context;
import android.view.View;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.bl;
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
    private w aDh;
    private c buA;
    private com.baidu.live.talentshow.a.a buB;
    private a buC;
    private LiveBCAudiencePreviewLayer buz;
    private TbPageContext mPageContext;
    private LiveBCAudiencePreviewLayer.a buD = new LiveBCAudiencePreviewLayer.a() { // from class: com.baidu.live.talentshow.components.preview.b.1
        @Override // com.baidu.live.talentshow.components.preview.LiveBCAudiencePreviewLayer.a
        public void QM() {
            b.this.buA.t(b.this.buz.getRenderViewParent());
            b.this.buA.startPreview();
        }

        @Override // com.baidu.live.talentshow.components.preview.LiveBCAudiencePreviewLayer.a
        public void QN() {
            b.this.buA.Rn();
            b.this.buA.Ro();
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.live.talentshow.components.preview.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!UtilHelper.isFastDoubleClick()) {
                if (view != b.this.buz.getBtnClose()) {
                    if (view == b.this.buz.getChatOptBtn()) {
                        if (b.this.buC != null) {
                            b.this.buC.Qu();
                            return;
                        }
                        return;
                    } else if (view == b.this.buz.getBeautyBtn()) {
                        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", UbcStatConstant.Value.VALUE_BC_CHAT_DUO_PRE_BEAUTY_CLICK).setContentExt(null, "popup", null));
                        b.this.QH();
                        return;
                    } else {
                        return;
                    }
                }
                b.this.QL();
                UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", UbcStatConstant.Value.VALUE_BC_CHAT_DUO_PRE_POP_SEC).setContentExt(null, "popup", null));
            }
        }
    };

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void a(c cVar) {
        this.buA = cVar;
    }

    public void setLiveShowData(w wVar) {
        this.aDh = wVar;
    }

    public void a(a aVar) {
        this.buC = aVar;
    }

    public void i(Context context, boolean z) {
        if (this.buz == null) {
            this.buz = new LiveBCAudiencePreviewLayer(context);
            this.buz.setNeedHideAnim(true);
            this.buz.setNeedShowAnim(true);
            this.buz.setCanceledOnTouchOutside(true);
            this.buz.setOutOnClickListener(this.mClickListener);
            this.buz.setLayerVisibleListener(this.buD);
        }
        this.buz.QO();
        if (UtilHelper.getRealScreenOrientation(context) != 2) {
            com.baidu.live.core.layer.b.Do().d(this.buz);
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", UbcStatConstant.Value.VALUE_BC_CHAT_DUO_PRE_POP_SHOW).setContentExt(null, "popup", null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QH() {
        if (bl.c(com.baidu.live.aa.a.Ph().bsh)) {
            this.mPageContext.showToast(a.h.sdk_filter_beauty_grey_tip);
        } else if (this.buA.Rk() != null) {
            if (this.buB == null) {
                this.buB = new com.baidu.live.talentshow.a.a(this.mPageContext, this.buz.getRootView(), this.buA.Rk());
            }
            this.buB.setLiveShowData(this.aDh);
            this.buB.Rf();
            BdUtilHelper.hideSoftKeyPad(this.mPageContext.getPageActivity(), this.buz);
        }
    }

    public void QI() {
        if (this.buz != null) {
            this.buz.QI();
        }
    }

    public void QJ() {
        if (this.buz != null) {
            this.buz.QJ();
        }
    }

    public boolean QK() {
        return (this.buz == null || this.buz.getParent() == null) ? false : true;
    }

    public void QL() {
        com.baidu.live.core.layer.b.Do().e(this.buz);
    }

    public void onDestroy() {
        if (this.buB != null) {
            this.buB.onDestroy();
        }
        if (this.buA != null) {
            this.buA.onDestroy();
        }
        if (this.buz != null && this.buz.getParent() != null) {
            com.baidu.live.core.layer.b.Do().e(this.buz);
        }
    }
}

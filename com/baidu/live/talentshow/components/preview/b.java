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
/* loaded from: classes11.dex */
public class b {
    private ab aDd;
    private LiveBCAudiencePreviewLayer bDq;
    private c bDr;
    private com.baidu.live.talentshow.a.a bDs;
    private a bDt;
    private LiveBCAudiencePreviewLayer.a bDu = new LiveBCAudiencePreviewLayer.a() { // from class: com.baidu.live.talentshow.components.preview.b.1
        @Override // com.baidu.live.talentshow.components.preview.LiveBCAudiencePreviewLayer.a
        public void Se() {
            b.this.bDr.u(b.this.bDq.getRenderViewParent());
            b.this.bDr.startPreview();
        }

        @Override // com.baidu.live.talentshow.components.preview.LiveBCAudiencePreviewLayer.a
        public void Sf() {
            b.this.bDr.SF();
            b.this.bDr.stopPreview();
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.live.talentshow.components.preview.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!UtilHelper.isFastDoubleClick()) {
                if (view != b.this.bDq.getBtnClose()) {
                    if (view == b.this.bDq.getChatOptBtn()) {
                        if (b.this.bDt != null) {
                            b.this.bDt.RO();
                            return;
                        }
                        return;
                    } else if (view == b.this.bDq.getBeautyBtn()) {
                        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", UbcStatConstant.Value.VALUE_BC_CHAT_DUO_PRE_BEAUTY_CLICK).setContentExt(null, UbcStatConstant.SubPage.POPUP, null));
                        b.this.RZ();
                        return;
                    } else {
                        return;
                    }
                }
                b.this.Sd();
                UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", UbcStatConstant.Value.VALUE_BC_CHAT_DUO_PRE_POP_SEC).setContentExt(null, UbcStatConstant.SubPage.POPUP, null));
            }
        }
    };
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void a(c cVar) {
        this.bDr = cVar;
    }

    public void setLiveShowData(ab abVar) {
        this.aDd = abVar;
    }

    public void a(a aVar) {
        this.bDt = aVar;
    }

    public void o(Context context, boolean z) {
        if (this.bDq == null) {
            this.bDq = new LiveBCAudiencePreviewLayer(context);
            this.bDq.setNeedHideAnim(true);
            this.bDq.setNeedShowAnim(true);
            this.bDq.setCanceledOnTouchOutside(true);
            this.bDq.setOutOnClickListener(this.mClickListener);
            this.bDq.setLayerVisibleListener(this.bDu);
        }
        this.bDq.Sg();
        if (UtilHelper.getRealScreenOrientation(context) != 2) {
            com.baidu.live.core.layer.b.Bc().d(this.bDq);
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", UbcStatConstant.Value.VALUE_BC_CHAT_DUO_PRE_POP_SHOW).setContentExt(null, UbcStatConstant.SubPage.POPUP, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void RZ() {
        if (bt.c(com.baidu.live.ae.a.Qj().bAS)) {
            this.mPageContext.showToast(a.h.sdk_filter_beauty_grey_tip);
        } else if (this.bDr.SC() != null) {
            if (this.bDs == null) {
                this.bDs = new com.baidu.live.talentshow.a.a(this.mPageContext, this.bDq.getRootView(), this.bDr.SC());
            }
            this.bDs.setLiveShowData(this.aDd);
            this.bDs.Sx();
            BdUtilHelper.hideSoftKeyPad(this.mPageContext.getPageActivity(), this.bDq);
        }
    }

    public void Sa() {
        if (this.bDq != null) {
            this.bDq.Sa();
        }
    }

    public void Sb() {
        if (this.bDq != null) {
            this.bDq.Sb();
        }
    }

    public boolean Sc() {
        return (this.bDq == null || this.bDq.getParent() == null) ? false : true;
    }

    public void Sd() {
        com.baidu.live.core.layer.b.Bc().e(this.bDq);
    }

    public void onDestroy() {
        if (this.bDs != null) {
            this.bDs.onDestroy();
        }
        if (this.bDr != null) {
            this.bDr.onDestroy();
        }
        if (this.bDq != null && this.bDq.getParent() != null) {
            com.baidu.live.core.layer.b.Bc().e(this.bDq);
        }
    }
}

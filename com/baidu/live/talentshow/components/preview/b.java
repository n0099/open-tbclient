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
    private w aES;
    private LiveBCAudiencePreviewLayer bwk;
    private c bwl;
    private com.baidu.live.talentshow.a.a bwm;
    private a bwn;
    private LiveBCAudiencePreviewLayer.a bwo = new LiveBCAudiencePreviewLayer.a() { // from class: com.baidu.live.talentshow.components.preview.b.1
        @Override // com.baidu.live.talentshow.components.preview.LiveBCAudiencePreviewLayer.a
        public void Rv() {
            b.this.bwl.x(b.this.bwk.getRenderViewParent());
            b.this.bwl.startPreview();
        }

        @Override // com.baidu.live.talentshow.components.preview.LiveBCAudiencePreviewLayer.a
        public void Rw() {
            b.this.bwl.RW();
            b.this.bwl.RX();
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.live.talentshow.components.preview.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!UtilHelper.isFastDoubleClick()) {
                if (view != b.this.bwk.getBtnClose()) {
                    if (view == b.this.bwk.getChatOptBtn()) {
                        if (b.this.bwn != null) {
                            b.this.bwn.Rd();
                            return;
                        }
                        return;
                    } else if (view == b.this.bwk.getBeautyBtn()) {
                        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", UbcStatConstant.Value.VALUE_BC_CHAT_DUO_PRE_BEAUTY_CLICK).setContentExt(null, "popup", null));
                        b.this.Rq();
                        return;
                    } else {
                        return;
                    }
                }
                b.this.Ru();
                UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", UbcStatConstant.Value.VALUE_BC_CHAT_DUO_PRE_POP_SEC).setContentExt(null, "popup", null));
            }
        }
    };
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void a(c cVar) {
        this.bwl = cVar;
    }

    public void setLiveShowData(w wVar) {
        this.aES = wVar;
    }

    public void a(a aVar) {
        this.bwn = aVar;
    }

    public void j(Context context, boolean z) {
        if (this.bwk == null) {
            this.bwk = new LiveBCAudiencePreviewLayer(context);
            this.bwk.setNeedHideAnim(true);
            this.bwk.setNeedShowAnim(true);
            this.bwk.setCanceledOnTouchOutside(true);
            this.bwk.setOutOnClickListener(this.mClickListener);
            this.bwk.setLayerVisibleListener(this.bwo);
        }
        this.bwk.Rx();
        if (UtilHelper.getRealScreenOrientation(context) != 2) {
            com.baidu.live.core.layer.b.DX().d(this.bwk);
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", UbcStatConstant.Value.VALUE_BC_CHAT_DUO_PRE_POP_SHOW).setContentExt(null, "popup", null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rq() {
        if (bl.c(com.baidu.live.aa.a.PQ().btT)) {
            this.mPageContext.showToast(a.h.sdk_filter_beauty_grey_tip);
        } else if (this.bwl.RT() != null) {
            if (this.bwm == null) {
                this.bwm = new com.baidu.live.talentshow.a.a(this.mPageContext, this.bwk.getRootView(), this.bwl.RT());
            }
            this.bwm.setLiveShowData(this.aES);
            this.bwm.RO();
            BdUtilHelper.hideSoftKeyPad(this.mPageContext.getPageActivity(), this.bwk);
        }
    }

    public void Rr() {
        if (this.bwk != null) {
            this.bwk.Rr();
        }
    }

    public void Rs() {
        if (this.bwk != null) {
            this.bwk.Rs();
        }
    }

    public boolean Rt() {
        return (this.bwk == null || this.bwk.getParent() == null) ? false : true;
    }

    public void Ru() {
        com.baidu.live.core.layer.b.DX().e(this.bwk);
    }

    public void onDestroy() {
        if (this.bwm != null) {
            this.bwm.onDestroy();
        }
        if (this.bwl != null) {
            this.bwl.onDestroy();
        }
        if (this.bwk != null && this.bwk.getParent() != null) {
            com.baidu.live.core.layer.b.DX().e(this.bwk);
        }
    }
}

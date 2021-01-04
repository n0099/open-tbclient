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
/* loaded from: classes11.dex */
public class b {
    private x aGe;
    private LiveBCAudiencePreviewLayer bEw;
    private c bEx;
    private com.baidu.live.talentshow.a.a bEy;
    private a bEz;
    private TbPageContext mPageContext;
    private LiveBCAudiencePreviewLayer.a bEA = new LiveBCAudiencePreviewLayer.a() { // from class: com.baidu.live.talentshow.components.preview.b.1
        @Override // com.baidu.live.talentshow.components.preview.LiveBCAudiencePreviewLayer.a
        public void Up() {
            b.this.bEx.w(b.this.bEw.getRenderViewParent());
            b.this.bEx.startPreview();
        }

        @Override // com.baidu.live.talentshow.components.preview.LiveBCAudiencePreviewLayer.a
        public void Uq() {
            b.this.bEx.UQ();
            b.this.bEx.UR();
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.live.talentshow.components.preview.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!UtilHelper.isFastDoubleClick()) {
                if (view != b.this.bEw.getBtnClose()) {
                    if (view == b.this.bEw.getChatOptBtn()) {
                        if (b.this.bEz != null) {
                            b.this.bEz.TZ();
                            return;
                        }
                        return;
                    } else if (view == b.this.bEw.getBeautyBtn()) {
                        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", UbcStatConstant.Value.VALUE_BC_CHAT_DUO_PRE_BEAUTY_CLICK).setContentExt(null, "popup", null));
                        b.this.Uk();
                        return;
                    } else {
                        return;
                    }
                }
                b.this.Uo();
                UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", UbcStatConstant.Value.VALUE_BC_CHAT_DUO_PRE_POP_SEC).setContentExt(null, "popup", null));
            }
        }
    };

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void a(c cVar) {
        this.bEx = cVar;
    }

    public void setLiveShowData(x xVar) {
        this.aGe = xVar;
    }

    public void a(a aVar) {
        this.bEz = aVar;
    }

    public void n(Context context, boolean z) {
        if (this.bEw == null) {
            this.bEw = new LiveBCAudiencePreviewLayer(context);
            this.bEw.setNeedHideAnim(true);
            this.bEw.setNeedShowAnim(true);
            this.bEw.setCanceledOnTouchOutside(true);
            this.bEw.setOutOnClickListener(this.mClickListener);
            this.bEw.setLayerVisibleListener(this.bEA);
        }
        this.bEw.Ur();
        if (UtilHelper.getRealScreenOrientation(context) != 2) {
            com.baidu.live.core.layer.b.En().d(this.bEw);
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", UbcStatConstant.Value.VALUE_BC_CHAT_DUO_PRE_POP_SHOW).setContentExt(null, "popup", null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Uk() {
        if (bo.c(com.baidu.live.af.a.SE().bCb)) {
            this.mPageContext.showToast(a.h.sdk_filter_beauty_grey_tip);
        } else if (this.bEx.UN() != null) {
            if (this.bEy == null) {
                this.bEy = new com.baidu.live.talentshow.a.a(this.mPageContext, this.bEw.getRootView(), this.bEx.UN());
            }
            this.bEy.setLiveShowData(this.aGe);
            this.bEy.UI();
            BdUtilHelper.hideSoftKeyPad(this.mPageContext.getPageActivity(), this.bEw);
        }
    }

    public void Ul() {
        if (this.bEw != null) {
            this.bEw.Ul();
        }
    }

    public void Um() {
        if (this.bEw != null) {
            this.bEw.Um();
        }
    }

    public boolean Un() {
        return (this.bEw == null || this.bEw.getParent() == null) ? false : true;
    }

    public void Uo() {
        com.baidu.live.core.layer.b.En().e(this.bEw);
    }

    public void onDestroy() {
        if (this.bEy != null) {
            this.bEy.onDestroy();
        }
        if (this.bEx != null) {
            this.bEx.onDestroy();
        }
        if (this.bEw != null && this.bEw.getParent() != null) {
            com.baidu.live.core.layer.b.En().e(this.bEw);
        }
    }
}

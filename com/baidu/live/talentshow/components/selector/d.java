package com.baidu.live.talentshow.components.selector;

import android.content.Context;
import android.view.View;
import com.baidu.live.talentshow.components.selector.LiveBCMasterChatSelectorLayer;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.UtilHelper;
import java.util.List;
/* loaded from: classes4.dex */
public class d implements View.OnClickListener {
    private LiveBCMasterChatSelectorLayer bwW;
    private List<com.baidu.live.talentshow.b.d> bwX;
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
        if (this.bwW == null) {
            this.bwW = new LiveBCMasterChatSelectorLayer(context);
            this.bwW.setNeedHideAnim(true);
            this.bwW.setNeedShowAnim(true);
            this.bwW.setCanceledOnTouchOutside(true);
            this.bwW.c(this);
        }
    }

    public void a(LiveBCMasterChatSelectorLayer.b bVar) {
        if (bVar != null) {
            this.bwW.setOnConfirmListener(bVar);
        }
    }

    public void a(LiveBCMasterChatSelectorLayer.a aVar) {
        if (aVar != null) {
            this.bwW.setOnPanelStateChangeListener(aVar);
        }
    }

    private void cA(boolean z) {
        if (UtilHelper.getRealScreenOrientation(this.mContext) != 2 && this.bwW != null) {
            if (z) {
                this.bwW.Ry();
            } else {
                this.bwW.showLoading();
            }
            if (!this.bwW.RA()) {
                com.baidu.live.core.layer.b.DX().d(this.bwW);
            }
        }
    }

    public void QH() {
        cA(false);
    }

    public void RG() {
        cA(true);
    }

    public void ac(List<com.baidu.live.talentshow.b.d> list) {
        this.bwX = list;
        if (this.bwW != null && list != null) {
            this.bwW.setData(list);
        }
    }

    public List<com.baidu.live.talentshow.b.d> RH() {
        return this.bwX;
    }

    public String aI(long j) {
        return (this.bwX == null || ListUtils.isEmpty(this.bwX)) ? "" : a(this.bwX, j);
    }

    private String a(List<com.baidu.live.talentshow.b.d> list, long j) {
        String str = j + "";
        for (com.baidu.live.talentshow.b.d dVar : list) {
            if (dVar.bye.equals(str)) {
                return dVar.nickName;
            }
        }
        return "";
    }

    public void RI() {
        if (this.bwW != null && this.bwW.RA()) {
            com.baidu.live.core.layer.b.DX().e(this.bwW);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bwW.getParentLayout()) {
            RI();
        }
    }
}

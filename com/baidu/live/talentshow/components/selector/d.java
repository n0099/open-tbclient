package com.baidu.live.talentshow.components.selector;

import android.content.Context;
import android.view.View;
import com.baidu.live.talentshow.components.selector.LiveBCMasterChatSelectorLayer;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.UtilHelper;
import java.util.List;
/* loaded from: classes10.dex */
public class d implements View.OnClickListener {
    private LiveBCMasterChatSelectorLayer bAw;
    private List<com.baidu.live.talentshow.b.d> bAx;
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
        if (this.bAw == null) {
            this.bAw = new LiveBCMasterChatSelectorLayer(context);
            this.bAw.setNeedHideAnim(true);
            this.bAw.setNeedShowAnim(true);
            this.bAw.setCanceledOnTouchOutside(true);
            this.bAw.d(this);
        }
    }

    public void a(LiveBCMasterChatSelectorLayer.b bVar) {
        if (bVar != null) {
            this.bAw.setOnConfirmListener(bVar);
        }
    }

    public void a(LiveBCMasterChatSelectorLayer.a aVar) {
        if (aVar != null) {
            this.bAw.setOnPanelStateChangeListener(aVar);
        }
    }

    private void cP(boolean z) {
        if (UtilHelper.getRealScreenOrientation(this.mContext) != 2 && this.bAw != null) {
            if (z) {
                this.bAw.Qx();
            } else {
                this.bAw.showLoading();
            }
            if (!this.bAw.Qz()) {
                com.baidu.live.core.layer.b.As().d(this.bAw);
            }
        }
    }

    public void PF() {
        cP(false);
    }

    public void QF() {
        cP(true);
    }

    public void af(List<com.baidu.live.talentshow.b.d> list) {
        this.bAx = list;
        if (this.bAw != null && list != null) {
            this.bAw.setData(list);
        }
    }

    public List<com.baidu.live.talentshow.b.d> QG() {
        return this.bAx;
    }

    public String bg(long j) {
        return (this.bAx == null || ListUtils.isEmpty(this.bAx)) ? "" : b(this.bAx, j);
    }

    private String b(List<com.baidu.live.talentshow.b.d> list, long j) {
        String str = j + "";
        for (com.baidu.live.talentshow.b.d dVar : list) {
            if (dVar.bBF.equals(str)) {
                return dVar.nickName;
            }
        }
        return "";
    }

    public void QH() {
        if (this.bAw != null && this.bAw.Qz()) {
            com.baidu.live.core.layer.b.As().e(this.bAw);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bAw.getParentLayout()) {
            QH();
        }
    }
}

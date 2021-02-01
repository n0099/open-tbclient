package com.baidu.live.talentshow.components.selector;

import android.content.Context;
import android.view.View;
import com.baidu.live.talentshow.components.selector.LiveBCMasterChatSelectorLayer;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.UtilHelper;
import java.util.List;
/* loaded from: classes11.dex */
public class d implements View.OnClickListener {
    private LiveBCMasterChatSelectorLayer bEc;
    private List<com.baidu.live.talentshow.b.d> bEd;
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
        if (this.bEc == null) {
            this.bEc = new LiveBCMasterChatSelectorLayer(context);
            this.bEc.setNeedHideAnim(true);
            this.bEc.setNeedShowAnim(true);
            this.bEc.setCanceledOnTouchOutside(true);
            this.bEc.d(this);
        }
    }

    public void a(LiveBCMasterChatSelectorLayer.b bVar) {
        if (bVar != null) {
            this.bEc.setOnConfirmListener(bVar);
        }
    }

    public void a(LiveBCMasterChatSelectorLayer.a aVar) {
        if (aVar != null) {
            this.bEc.setOnPanelStateChangeListener(aVar);
        }
    }

    private void cX(boolean z) {
        if (UtilHelper.getRealScreenOrientation(this.mContext) != 2 && this.bEc != null) {
            if (z) {
                this.bEc.Sh();
            } else {
                this.bEc.showLoading();
            }
            if (!this.bEc.Sj()) {
                com.baidu.live.core.layer.b.Bc().d(this.bEc);
            }
        }
    }

    public void Rp() {
        cX(false);
    }

    public void Sp() {
        cX(true);
    }

    public void ag(List<com.baidu.live.talentshow.b.d> list) {
        this.bEd = list;
        if (this.bEc != null && list != null) {
            this.bEc.setData(list);
        }
    }

    public List<com.baidu.live.talentshow.b.d> Sq() {
        return this.bEd;
    }

    public String bk(long j) {
        return (this.bEd == null || ListUtils.isEmpty(this.bEd)) ? "" : b(this.bEd, j);
    }

    private String b(List<com.baidu.live.talentshow.b.d> list, long j) {
        String str = j + "";
        for (com.baidu.live.talentshow.b.d dVar : list) {
            if (dVar.bFl.equals(str)) {
                return dVar.nickName;
            }
        }
        return "";
    }

    public void Sr() {
        if (this.bEc != null && this.bEc.Sj()) {
            com.baidu.live.core.layer.b.Bc().e(this.bEc);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bEc.getParentLayout()) {
            Sr();
        }
    }
}

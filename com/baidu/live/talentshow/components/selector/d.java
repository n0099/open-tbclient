package com.baidu.live.talentshow.components.selector;

import android.content.Context;
import android.view.View;
import com.baidu.live.talentshow.components.selector.LiveBCMasterChatSelectorLayer;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.UtilHelper;
import java.util.List;
/* loaded from: classes10.dex */
public class d implements View.OnClickListener {
    private LiveBCMasterChatSelectorLayer bFC;
    private List<com.baidu.live.talentshow.b.d> bFD;
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
        if (this.bFC == null) {
            this.bFC = new LiveBCMasterChatSelectorLayer(context);
            this.bFC.setNeedHideAnim(true);
            this.bFC.setNeedShowAnim(true);
            this.bFC.setCanceledOnTouchOutside(true);
            this.bFC.d(this);
        }
    }

    public void a(LiveBCMasterChatSelectorLayer.b bVar) {
        if (bVar != null) {
            this.bFC.setOnConfirmListener(bVar);
        }
    }

    public void a(LiveBCMasterChatSelectorLayer.a aVar) {
        if (aVar != null) {
            this.bFC.setOnPanelStateChangeListener(aVar);
        }
    }

    private void cX(boolean z) {
        if (UtilHelper.getRealScreenOrientation(this.mContext) != 2 && this.bFC != null) {
            if (z) {
                this.bFC.Sk();
            } else {
                this.bFC.showLoading();
            }
            if (!this.bFC.Sm()) {
                com.baidu.live.core.layer.b.Bf().d(this.bFC);
            }
        }
    }

    public void Rs() {
        cX(false);
    }

    public void Ss() {
        cX(true);
    }

    public void ag(List<com.baidu.live.talentshow.b.d> list) {
        this.bFD = list;
        if (this.bFC != null && list != null) {
            this.bFC.setData(list);
        }
    }

    public List<com.baidu.live.talentshow.b.d> St() {
        return this.bFD;
    }

    public String bk(long j) {
        return (this.bFD == null || ListUtils.isEmpty(this.bFD)) ? "" : b(this.bFD, j);
    }

    private String b(List<com.baidu.live.talentshow.b.d> list, long j) {
        String str = j + "";
        for (com.baidu.live.talentshow.b.d dVar : list) {
            if (dVar.bGL.equals(str)) {
                return dVar.nickName;
            }
        }
        return "";
    }

    public void Su() {
        if (this.bFC != null && this.bFC.Sm()) {
            com.baidu.live.core.layer.b.Bf().e(this.bFC);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bFC.getParentLayout()) {
            Su();
        }
    }
}

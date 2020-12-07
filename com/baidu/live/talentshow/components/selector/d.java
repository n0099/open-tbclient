package com.baidu.live.talentshow.components.selector;

import android.content.Context;
import android.view.View;
import com.baidu.live.talentshow.components.selector.LiveBCMasterChatSelectorLayer;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.UtilHelper;
import java.util.List;
/* loaded from: classes4.dex */
public class d implements View.OnClickListener {
    private LiveBCMasterChatSelectorLayer bAv;
    private List<com.baidu.live.talentshow.b.d> bAw;
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
        if (this.bAv == null) {
            this.bAv = new LiveBCMasterChatSelectorLayer(context);
            this.bAv.setNeedHideAnim(true);
            this.bAv.setNeedShowAnim(true);
            this.bAv.setCanceledOnTouchOutside(true);
            this.bAv.c(this);
        }
    }

    public void a(LiveBCMasterChatSelectorLayer.b bVar) {
        if (bVar != null) {
            this.bAv.setOnConfirmListener(bVar);
        }
    }

    public void a(LiveBCMasterChatSelectorLayer.a aVar) {
        if (aVar != null) {
            this.bAv.setOnPanelStateChangeListener(aVar);
        }
    }

    private void cQ(boolean z) {
        if (UtilHelper.getRealScreenOrientation(this.mContext) != 2 && this.bAv != null) {
            if (z) {
                this.bAv.Tn();
            } else {
                this.bAv.showLoading();
            }
            if (!this.bAv.Tp()) {
                com.baidu.live.core.layer.b.EY().d(this.bAv);
            }
        }
    }

    public void Sw() {
        cQ(false);
    }

    public void Tv() {
        cQ(true);
    }

    public void ae(List<com.baidu.live.talentshow.b.d> list) {
        this.bAw = list;
        if (this.bAv != null && list != null) {
            this.bAv.setData(list);
        }
    }

    public List<com.baidu.live.talentshow.b.d> Tw() {
        return this.bAw;
    }

    public String bg(long j) {
        return (this.bAw == null || ListUtils.isEmpty(this.bAw)) ? "" : a(this.bAw, j);
    }

    private String a(List<com.baidu.live.talentshow.b.d> list, long j) {
        String str = j + "";
        for (com.baidu.live.talentshow.b.d dVar : list) {
            if (dVar.bBD.equals(str)) {
                return dVar.nickName;
            }
        }
        return "";
    }

    public void Tx() {
        if (this.bAv != null && this.bAv.Tp()) {
            com.baidu.live.core.layer.b.EY().e(this.bAv);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bAv.getParentLayout()) {
            Tx();
        }
    }
}

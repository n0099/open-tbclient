package com.baidu.live.talentshow.components.selector;

import android.content.Context;
import android.view.View;
import com.baidu.live.talentshow.components.selector.LiveBCMasterChatSelectorLayer;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.UtilHelper;
import java.util.List;
/* loaded from: classes11.dex */
public class d implements View.OnClickListener {
    private LiveBCMasterChatSelectorLayer bFi;
    private List<com.baidu.live.talentshow.b.d> bFj;
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
        if (this.bFi == null) {
            this.bFi = new LiveBCMasterChatSelectorLayer(context);
            this.bFi.setNeedHideAnim(true);
            this.bFi.setNeedShowAnim(true);
            this.bFi.setCanceledOnTouchOutside(true);
            this.bFi.d(this);
        }
    }

    public void a(LiveBCMasterChatSelectorLayer.b bVar) {
        if (bVar != null) {
            this.bFi.setOnConfirmListener(bVar);
        }
    }

    public void a(LiveBCMasterChatSelectorLayer.a aVar) {
        if (aVar != null) {
            this.bFi.setOnPanelStateChangeListener(aVar);
        }
    }

    private void cT(boolean z) {
        if (UtilHelper.getRealScreenOrientation(this.mContext) != 2 && this.bFi != null) {
            if (z) {
                this.bFi.Us();
            } else {
                this.bFi.showLoading();
            }
            if (!this.bFi.Uu()) {
                com.baidu.live.core.layer.b.En().d(this.bFi);
            }
        }
    }

    public void TA() {
        cT(false);
    }

    public void UA() {
        cT(true);
    }

    public void af(List<com.baidu.live.talentshow.b.d> list) {
        this.bFj = list;
        if (this.bFi != null && list != null) {
            this.bFi.setData(list);
        }
    }

    public List<com.baidu.live.talentshow.b.d> UB() {
        return this.bFj;
    }

    public String bg(long j) {
        return (this.bFj == null || ListUtils.isEmpty(this.bFj)) ? "" : b(this.bFj, j);
    }

    private String b(List<com.baidu.live.talentshow.b.d> list, long j) {
        String str = j + "";
        for (com.baidu.live.talentshow.b.d dVar : list) {
            if (dVar.bGr.equals(str)) {
                return dVar.nickName;
            }
        }
        return "";
    }

    public void UC() {
        if (this.bFi != null && this.bFi.Uu()) {
            com.baidu.live.core.layer.b.En().e(this.bFi);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bFi.getParentLayout()) {
            UC();
        }
    }
}

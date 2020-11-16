package com.baidu.live.talentshow.components.selector;

import android.content.Context;
import android.view.View;
import com.baidu.live.talentshow.components.selector.LiveBCMasterChatSelectorLayer;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.UtilHelper;
import java.util.List;
/* loaded from: classes4.dex */
public class d implements View.OnClickListener {
    private LiveBCMasterChatSelectorLayer bvl;
    private List<com.baidu.live.talentshow.b.d> bvm;
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
        if (this.bvl == null) {
            this.bvl = new LiveBCMasterChatSelectorLayer(context);
            this.bvl.setNeedHideAnim(true);
            this.bvl.setNeedShowAnim(true);
            this.bvl.setCanceledOnTouchOutside(true);
            this.bvl.c(this);
        }
    }

    public void a(LiveBCMasterChatSelectorLayer.b bVar) {
        if (bVar != null) {
            this.bvl.setOnConfirmListener(bVar);
        }
    }

    public void a(LiveBCMasterChatSelectorLayer.a aVar) {
        if (aVar != null) {
            this.bvl.setOnPanelStateChangeListener(aVar);
        }
    }

    private void cC(boolean z) {
        if (UtilHelper.getRealScreenOrientation(this.mContext) != 2 && this.bvl != null) {
            if (z) {
                this.bvl.QP();
            } else {
                this.bvl.showLoading();
            }
            if (!this.bvl.QR()) {
                com.baidu.live.core.layer.b.Do().d(this.bvl);
            }
        }
    }

    public void PY() {
        cC(false);
    }

    public void QX() {
        cC(true);
    }

    public void ac(List<com.baidu.live.talentshow.b.d> list) {
        this.bvm = list;
        if (this.bvl != null && list != null) {
            this.bvl.setData(list);
        }
    }

    public List<com.baidu.live.talentshow.b.d> QY() {
        return this.bvm;
    }

    public String aI(long j) {
        return (this.bvm == null || ListUtils.isEmpty(this.bvm)) ? "" : a(this.bvm, j);
    }

    private String a(List<com.baidu.live.talentshow.b.d> list, long j) {
        String str = j + "";
        for (com.baidu.live.talentshow.b.d dVar : list) {
            if (dVar.bwt.equals(str)) {
                return dVar.nickName;
            }
        }
        return "";
    }

    public void QZ() {
        if (this.bvl != null && this.bvl.QR()) {
            com.baidu.live.core.layer.b.Do().e(this.bvl);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bvl.getParentLayout()) {
            QZ();
        }
    }
}

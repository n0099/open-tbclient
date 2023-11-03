package com.baidu.searchbox.security.action;

import com.baidu.pyramid.annotation.Inject;
import com.baidu.tieba.nf1;
import com.baidu.tieba.pf1;
import java.util.List;
/* loaded from: classes4.dex */
public class WarmConfirmActionComponent {
    @Inject(force = false)
    public pf1<IWarmConfirmAction> mOnConfirmActionList;

    public void initmOnConfirmActionList() {
        nf1 b = nf1.b();
        this.mOnConfirmActionList = b;
        b.a(new IWarmConfirmAction_WarmConfirmActionComponent_ListProvider());
    }

    public WarmConfirmActionComponent() {
        initmOnConfirmActionList();
    }

    public List<IWarmConfirmAction> getWarmConfirmActionList() {
        pf1<IWarmConfirmAction> pf1Var = this.mOnConfirmActionList;
        if (pf1Var != null) {
            return pf1Var.getList();
        }
        return null;
    }
}

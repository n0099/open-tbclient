package com.baidu.searchbox.security.action;

import com.baidu.pyramid.annotation.Inject;
import com.baidu.tieba.of1;
import com.baidu.tieba.qf1;
import java.util.List;
/* loaded from: classes4.dex */
public class WarmConfirmActionComponent {
    @Inject(force = false)
    public qf1<IWarmConfirmAction> mOnConfirmActionList;

    public void initmOnConfirmActionList() {
        of1 b = of1.b();
        this.mOnConfirmActionList = b;
        b.a(new IWarmConfirmAction_WarmConfirmActionComponent_ListProvider());
    }

    public WarmConfirmActionComponent() {
        initmOnConfirmActionList();
    }

    public List<IWarmConfirmAction> getWarmConfirmActionList() {
        qf1<IWarmConfirmAction> qf1Var = this.mOnConfirmActionList;
        if (qf1Var != null) {
            return qf1Var.getList();
        }
        return null;
    }
}

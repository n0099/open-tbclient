package com.baidu.searchbox.security.action;

import com.baidu.pyramid.annotation.Inject;
import com.baidu.tieba.vj1;
import com.baidu.tieba.xj1;
import java.util.List;
/* loaded from: classes4.dex */
public class WarmConfirmActionComponent {
    @Inject(force = false)
    public xj1<IWarmConfirmAction> mOnConfirmActionList;

    public void initmOnConfirmActionList() {
        vj1 b = vj1.b();
        this.mOnConfirmActionList = b;
        b.a(new IWarmConfirmAction_WarmConfirmActionComponent_ListProvider());
    }

    public WarmConfirmActionComponent() {
        initmOnConfirmActionList();
    }

    public List<IWarmConfirmAction> getWarmConfirmActionList() {
        xj1<IWarmConfirmAction> xj1Var = this.mOnConfirmActionList;
        if (xj1Var != null) {
            return xj1Var.getList();
        }
        return null;
    }
}

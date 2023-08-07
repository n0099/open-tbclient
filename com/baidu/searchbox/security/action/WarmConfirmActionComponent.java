package com.baidu.searchbox.security.action;

import com.baidu.pyramid.annotation.Inject;
import com.baidu.tieba.ek1;
import com.baidu.tieba.gk1;
import java.util.List;
/* loaded from: classes4.dex */
public class WarmConfirmActionComponent {
    @Inject(force = false)
    public gk1<IWarmConfirmAction> mOnConfirmActionList;

    public void initmOnConfirmActionList() {
        ek1 b = ek1.b();
        this.mOnConfirmActionList = b;
        b.a(new IWarmConfirmAction_WarmConfirmActionComponent_ListProvider());
    }

    public WarmConfirmActionComponent() {
        initmOnConfirmActionList();
    }

    public List<IWarmConfirmAction> getWarmConfirmActionList() {
        gk1<IWarmConfirmAction> gk1Var = this.mOnConfirmActionList;
        if (gk1Var != null) {
            return gk1Var.getList();
        }
        return null;
    }
}

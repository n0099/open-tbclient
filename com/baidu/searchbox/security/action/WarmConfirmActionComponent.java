package com.baidu.searchbox.security.action;

import com.baidu.pyramid.annotation.Inject;
import com.baidu.tieba.jk1;
import com.baidu.tieba.lk1;
import java.util.List;
/* loaded from: classes4.dex */
public class WarmConfirmActionComponent {
    @Inject(force = false)
    public lk1<IWarmConfirmAction> mOnConfirmActionList;

    public void initmOnConfirmActionList() {
        jk1 b = jk1.b();
        this.mOnConfirmActionList = b;
        b.a(new IWarmConfirmAction_WarmConfirmActionComponent_ListProvider());
    }

    public WarmConfirmActionComponent() {
        initmOnConfirmActionList();
    }

    public List<IWarmConfirmAction> getWarmConfirmActionList() {
        lk1<IWarmConfirmAction> lk1Var = this.mOnConfirmActionList;
        if (lk1Var != null) {
            return lk1Var.getList();
        }
        return null;
    }
}

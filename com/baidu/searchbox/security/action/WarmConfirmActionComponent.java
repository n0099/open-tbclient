package com.baidu.searchbox.security.action;

import com.baidu.pyramid.annotation.Inject;
import com.baidu.tieba.nk1;
import com.baidu.tieba.pk1;
import java.util.List;
/* loaded from: classes4.dex */
public class WarmConfirmActionComponent {
    @Inject(force = false)
    public pk1<IWarmConfirmAction> mOnConfirmActionList;

    public void initmOnConfirmActionList() {
        nk1 b = nk1.b();
        this.mOnConfirmActionList = b;
        b.a(new IWarmConfirmAction_WarmConfirmActionComponent_ListProvider());
    }

    public WarmConfirmActionComponent() {
        initmOnConfirmActionList();
    }

    public List<IWarmConfirmAction> getWarmConfirmActionList() {
        pk1<IWarmConfirmAction> pk1Var = this.mOnConfirmActionList;
        if (pk1Var != null) {
            return pk1Var.getList();
        }
        return null;
    }
}

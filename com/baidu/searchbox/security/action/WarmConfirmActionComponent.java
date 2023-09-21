package com.baidu.searchbox.security.action;

import com.baidu.pyramid.annotation.Inject;
import com.baidu.tieba.mk1;
import com.baidu.tieba.ok1;
import java.util.List;
/* loaded from: classes4.dex */
public class WarmConfirmActionComponent {
    @Inject(force = false)
    public ok1<IWarmConfirmAction> mOnConfirmActionList;

    public void initmOnConfirmActionList() {
        mk1 b = mk1.b();
        this.mOnConfirmActionList = b;
        b.a(new IWarmConfirmAction_WarmConfirmActionComponent_ListProvider());
    }

    public WarmConfirmActionComponent() {
        initmOnConfirmActionList();
    }

    public List<IWarmConfirmAction> getWarmConfirmActionList() {
        ok1<IWarmConfirmAction> ok1Var = this.mOnConfirmActionList;
        if (ok1Var != null) {
            return ok1Var.getList();
        }
        return null;
    }
}

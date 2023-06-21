package com.baidu.searchbox.security.action;

import com.baidu.pyramid.annotation.Inject;
import com.baidu.tieba.fl1;
import com.baidu.tieba.hl1;
import java.util.List;
/* loaded from: classes4.dex */
public class WarmConfirmActionComponent {
    @Inject(force = false)
    public hl1<IWarmConfirmAction> mOnConfirmActionList;

    public void initmOnConfirmActionList() {
        fl1 b = fl1.b();
        this.mOnConfirmActionList = b;
        b.a(new IWarmConfirmAction_WarmConfirmActionComponent_ListProvider());
    }

    public WarmConfirmActionComponent() {
        initmOnConfirmActionList();
    }

    public List<IWarmConfirmAction> getWarmConfirmActionList() {
        hl1<IWarmConfirmAction> hl1Var = this.mOnConfirmActionList;
        if (hl1Var != null) {
            return hl1Var.getList();
        }
        return null;
    }
}

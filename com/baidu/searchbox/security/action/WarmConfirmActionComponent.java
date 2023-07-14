package com.baidu.searchbox.security.action;

import com.baidu.pyramid.annotation.Inject;
import com.baidu.tieba.bl1;
import com.baidu.tieba.dl1;
import java.util.List;
/* loaded from: classes4.dex */
public class WarmConfirmActionComponent {
    @Inject(force = false)
    public dl1<IWarmConfirmAction> mOnConfirmActionList;

    public void initmOnConfirmActionList() {
        bl1 b = bl1.b();
        this.mOnConfirmActionList = b;
        b.a(new IWarmConfirmAction_WarmConfirmActionComponent_ListProvider());
    }

    public WarmConfirmActionComponent() {
        initmOnConfirmActionList();
    }

    public List<IWarmConfirmAction> getWarmConfirmActionList() {
        dl1<IWarmConfirmAction> dl1Var = this.mOnConfirmActionList;
        if (dl1Var != null) {
            return dl1Var.getList();
        }
        return null;
    }
}

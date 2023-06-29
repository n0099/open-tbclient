package com.baidu.searchbox.security.action;

import com.baidu.pyramid.annotation.Inject;
import com.baidu.tieba.il1;
import com.baidu.tieba.kl1;
import java.util.List;
/* loaded from: classes4.dex */
public class WarmConfirmActionComponent {
    @Inject(force = false)
    public kl1<IWarmConfirmAction> mOnConfirmActionList;

    public void initmOnConfirmActionList() {
        il1 b = il1.b();
        this.mOnConfirmActionList = b;
        b.a(new IWarmConfirmAction_WarmConfirmActionComponent_ListProvider());
    }

    public WarmConfirmActionComponent() {
        initmOnConfirmActionList();
    }

    public List<IWarmConfirmAction> getWarmConfirmActionList() {
        kl1<IWarmConfirmAction> kl1Var = this.mOnConfirmActionList;
        if (kl1Var != null) {
            return kl1Var.getList();
        }
        return null;
    }
}

package com.baidu.searchbox.security.action;

import com.baidu.pyramid.annotation.Inject;
import com.baidu.tieba.rf1;
import com.baidu.tieba.tf1;
import java.util.List;
/* loaded from: classes4.dex */
public class WarmConfirmActionComponent {
    @Inject(force = false)
    public tf1<IWarmConfirmAction> mOnConfirmActionList;

    public void initmOnConfirmActionList() {
        rf1 b = rf1.b();
        this.mOnConfirmActionList = b;
        b.a(new IWarmConfirmAction_WarmConfirmActionComponent_ListProvider());
    }

    public WarmConfirmActionComponent() {
        initmOnConfirmActionList();
    }

    public List<IWarmConfirmAction> getWarmConfirmActionList() {
        tf1<IWarmConfirmAction> tf1Var = this.mOnConfirmActionList;
        if (tf1Var != null) {
            return tf1Var.getList();
        }
        return null;
    }
}

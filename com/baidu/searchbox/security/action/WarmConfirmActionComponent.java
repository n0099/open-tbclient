package com.baidu.searchbox.security.action;

import com.baidu.pyramid.annotation.Inject;
import com.baidu.tieba.el1;
import com.baidu.tieba.gl1;
import java.util.List;
/* loaded from: classes4.dex */
public class WarmConfirmActionComponent {
    @Inject(force = false)
    public gl1<IWarmConfirmAction> mOnConfirmActionList;

    public void initmOnConfirmActionList() {
        el1 b = el1.b();
        this.mOnConfirmActionList = b;
        b.a(new IWarmConfirmAction_WarmConfirmActionComponent_ListProvider());
    }

    public WarmConfirmActionComponent() {
        initmOnConfirmActionList();
    }

    public List<IWarmConfirmAction> getWarmConfirmActionList() {
        gl1<IWarmConfirmAction> gl1Var = this.mOnConfirmActionList;
        if (gl1Var != null) {
            return gl1Var.getList();
        }
        return null;
    }
}

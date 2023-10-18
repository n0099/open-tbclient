package com.baidu.searchbox.security.action;

import com.baidu.pyramid.annotation.Inject;
import com.baidu.tieba.we1;
import com.baidu.tieba.ye1;
import java.util.List;
/* loaded from: classes4.dex */
public class WarmConfirmActionComponent {
    @Inject(force = false)
    public ye1<IWarmConfirmAction> mOnConfirmActionList;

    public void initmOnConfirmActionList() {
        we1 b = we1.b();
        this.mOnConfirmActionList = b;
        b.a(new IWarmConfirmAction_WarmConfirmActionComponent_ListProvider());
    }

    public WarmConfirmActionComponent() {
        initmOnConfirmActionList();
    }

    public List<IWarmConfirmAction> getWarmConfirmActionList() {
        ye1<IWarmConfirmAction> ye1Var = this.mOnConfirmActionList;
        if (ye1Var != null) {
            return ye1Var.getList();
        }
        return null;
    }
}

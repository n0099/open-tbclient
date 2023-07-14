package com.baidu.searchbox.unitedscheme.intercept;

import com.baidu.tieba.op2;
import com.baidu.tieba.t94;
import com.baidu.tieba.wf3;
import com.baidu.tieba.xf3;
import com.baidu.tieba.yf3;
import com.baidu.tieba.zk1;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class UnitedSchemeBaseInterceptor_UnitedSchemePriorRuntime_ListProvider implements zk1 {
    @Override // com.baidu.tieba.zk1
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new op2());
        arrayList.add(new wf3());
        arrayList.add(new xf3());
        arrayList.add(new yf3());
        arrayList.add(new t94());
        return arrayList;
    }
}

package com.baidu.searchbox.unitedscheme.intercept;

import com.baidu.tieba.ij2;
import com.baidu.tieba.n34;
import com.baidu.tieba.q93;
import com.baidu.tieba.r93;
import com.baidu.tieba.s93;
import com.baidu.tieba.ue1;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class UnitedSchemeBaseInterceptor_UnitedSchemePriorRuntime_ListProvider implements ue1 {
    @Override // com.baidu.tieba.ue1
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ij2());
        arrayList.add(new q93());
        arrayList.add(new r93());
        arrayList.add(new s93());
        arrayList.add(new n34());
        return arrayList;
    }
}

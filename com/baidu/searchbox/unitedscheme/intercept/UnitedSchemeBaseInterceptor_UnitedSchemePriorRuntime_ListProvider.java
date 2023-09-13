package com.baidu.searchbox.unitedscheme.intercept;

import com.baidu.tieba.ap2;
import com.baidu.tieba.f94;
import com.baidu.tieba.if3;
import com.baidu.tieba.jf3;
import com.baidu.tieba.kf3;
import com.baidu.tieba.lk1;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class UnitedSchemeBaseInterceptor_UnitedSchemePriorRuntime_ListProvider implements lk1 {
    @Override // com.baidu.tieba.lk1
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ap2());
        arrayList.add(new if3());
        arrayList.add(new jf3());
        arrayList.add(new kf3());
        arrayList.add(new f94());
        return arrayList;
    }
}

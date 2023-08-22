package com.baidu.searchbox.unitedscheme.intercept;

import com.baidu.tieba.b94;
import com.baidu.tieba.ef3;
import com.baidu.tieba.ff3;
import com.baidu.tieba.gf3;
import com.baidu.tieba.hk1;
import com.baidu.tieba.wo2;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class UnitedSchemeBaseInterceptor_UnitedSchemePriorRuntime_ListProvider implements hk1 {
    @Override // com.baidu.tieba.hk1
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new wo2());
        arrayList.add(new ef3());
        arrayList.add(new ff3());
        arrayList.add(new gf3());
        arrayList.add(new b94());
        return arrayList;
    }
}

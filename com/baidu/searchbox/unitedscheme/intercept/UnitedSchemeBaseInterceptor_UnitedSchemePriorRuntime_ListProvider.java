package com.baidu.searchbox.unitedscheme.intercept;

import com.baidu.tieba.e44;
import com.baidu.tieba.ha3;
import com.baidu.tieba.ia3;
import com.baidu.tieba.ja3;
import com.baidu.tieba.lf1;
import com.baidu.tieba.zj2;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class UnitedSchemeBaseInterceptor_UnitedSchemePriorRuntime_ListProvider implements lf1 {
    @Override // com.baidu.tieba.lf1
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new zj2());
        arrayList.add(new ha3());
        arrayList.add(new ia3());
        arrayList.add(new ja3());
        arrayList.add(new e44());
        return arrayList;
    }
}

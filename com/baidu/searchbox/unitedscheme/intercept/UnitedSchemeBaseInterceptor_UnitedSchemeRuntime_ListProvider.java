package com.baidu.searchbox.unitedscheme.intercept;

import com.baidu.tieba.bj1;
import com.baidu.tieba.ol2;
import com.baidu.tieba.t54;
import com.baidu.tieba.wb3;
import com.baidu.tieba.xb3;
import com.baidu.tieba.yb3;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class UnitedSchemeBaseInterceptor_UnitedSchemeRuntime_ListProvider implements bj1 {
    @Override // com.baidu.tieba.bj1
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ol2());
        arrayList.add(new wb3());
        arrayList.add(new xb3());
        arrayList.add(new yb3());
        arrayList.add(new t54());
        return arrayList;
    }
}

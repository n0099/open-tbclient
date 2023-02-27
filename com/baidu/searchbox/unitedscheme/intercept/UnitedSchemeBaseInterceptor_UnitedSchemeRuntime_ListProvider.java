package com.baidu.searchbox.unitedscheme.intercept;

import com.baidu.tieba.fn2;
import com.baidu.tieba.jk1;
import com.baidu.tieba.k74;
import com.baidu.tieba.nd3;
import com.baidu.tieba.od3;
import com.baidu.tieba.pd3;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class UnitedSchemeBaseInterceptor_UnitedSchemeRuntime_ListProvider implements jk1 {
    @Override // com.baidu.tieba.jk1
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new fn2());
        arrayList.add(new nd3());
        arrayList.add(new od3());
        arrayList.add(new pd3());
        arrayList.add(new k74());
        return arrayList;
    }
}

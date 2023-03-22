package com.baidu.searchbox.unitedscheme.intercept;

import com.baidu.tieba.ml2;
import com.baidu.tieba.r54;
import com.baidu.tieba.ub3;
import com.baidu.tieba.vb3;
import com.baidu.tieba.wb3;
import com.baidu.tieba.zi1;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class UnitedSchemeBaseInterceptor_UnitedSchemeRuntime_ListProvider implements zi1 {
    @Override // com.baidu.tieba.zi1
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ml2());
        arrayList.add(new ub3());
        arrayList.add(new vb3());
        arrayList.add(new wb3());
        arrayList.add(new r54());
        return arrayList;
    }
}

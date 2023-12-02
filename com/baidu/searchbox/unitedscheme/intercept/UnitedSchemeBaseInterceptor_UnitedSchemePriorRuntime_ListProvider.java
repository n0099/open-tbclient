package com.baidu.searchbox.unitedscheme.intercept;

import com.baidu.tieba.dk2;
import com.baidu.tieba.i44;
import com.baidu.tieba.la3;
import com.baidu.tieba.ma3;
import com.baidu.tieba.na3;
import com.baidu.tieba.pf1;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class UnitedSchemeBaseInterceptor_UnitedSchemePriorRuntime_ListProvider implements pf1 {
    @Override // com.baidu.tieba.pf1
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new dk2());
        arrayList.add(new la3());
        arrayList.add(new ma3());
        arrayList.add(new na3());
        arrayList.add(new i44());
        return arrayList;
    }
}

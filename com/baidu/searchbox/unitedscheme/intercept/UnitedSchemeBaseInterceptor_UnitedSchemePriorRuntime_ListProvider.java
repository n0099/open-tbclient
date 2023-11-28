package com.baidu.searchbox.unitedscheme.intercept;

import com.baidu.tieba.ak2;
import com.baidu.tieba.f44;
import com.baidu.tieba.ia3;
import com.baidu.tieba.ja3;
import com.baidu.tieba.ka3;
import com.baidu.tieba.mf1;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class UnitedSchemeBaseInterceptor_UnitedSchemePriorRuntime_ListProvider implements mf1 {
    @Override // com.baidu.tieba.mf1
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ak2());
        arrayList.add(new ia3());
        arrayList.add(new ja3());
        arrayList.add(new ka3());
        arrayList.add(new f44());
        return arrayList;
    }
}

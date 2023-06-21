package com.baidu.searchbox.unitedscheme.intercept;

import com.baidu.tieba.ag3;
import com.baidu.tieba.bg3;
import com.baidu.tieba.cg3;
import com.baidu.tieba.dl1;
import com.baidu.tieba.sp2;
import com.baidu.tieba.x94;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class UnitedSchemeBaseInterceptor_UnitedSchemePriorRuntime_ListProvider implements dl1 {
    @Override // com.baidu.tieba.dl1
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new sp2());
        arrayList.add(new ag3());
        arrayList.add(new bg3());
        arrayList.add(new cg3());
        arrayList.add(new x94());
        return arrayList;
    }
}

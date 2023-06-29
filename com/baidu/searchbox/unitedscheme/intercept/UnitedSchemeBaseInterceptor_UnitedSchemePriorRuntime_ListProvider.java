package com.baidu.searchbox.unitedscheme.intercept;

import com.baidu.tieba.aa4;
import com.baidu.tieba.dg3;
import com.baidu.tieba.eg3;
import com.baidu.tieba.fg3;
import com.baidu.tieba.gl1;
import com.baidu.tieba.vp2;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class UnitedSchemeBaseInterceptor_UnitedSchemePriorRuntime_ListProvider implements gl1 {
    @Override // com.baidu.tieba.gl1
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new vp2());
        arrayList.add(new dg3());
        arrayList.add(new eg3());
        arrayList.add(new fg3());
        arrayList.add(new aa4());
        return arrayList;
    }
}

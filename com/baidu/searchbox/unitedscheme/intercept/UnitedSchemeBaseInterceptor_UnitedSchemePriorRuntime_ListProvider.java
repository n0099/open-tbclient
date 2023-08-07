package com.baidu.searchbox.unitedscheme.intercept;

import com.baidu.tieba.af3;
import com.baidu.tieba.bf3;
import com.baidu.tieba.ck1;
import com.baidu.tieba.ro2;
import com.baidu.tieba.w84;
import com.baidu.tieba.ze3;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class UnitedSchemeBaseInterceptor_UnitedSchemePriorRuntime_ListProvider implements ck1 {
    @Override // com.baidu.tieba.ck1
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ro2());
        arrayList.add(new ze3());
        arrayList.add(new af3());
        arrayList.add(new bf3());
        arrayList.add(new w84());
        return arrayList;
    }
}

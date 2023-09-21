package com.baidu.searchbox.unitedscheme.intercept;

import com.baidu.tieba.e94;
import com.baidu.tieba.hf3;
import com.baidu.tieba.if3;
import com.baidu.tieba.jf3;
import com.baidu.tieba.kk1;
import com.baidu.tieba.zo2;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class UnitedSchemeBaseInterceptor_UnitedSchemePriorRuntime_ListProvider implements kk1 {
    @Override // com.baidu.tieba.kk1
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new zo2());
        arrayList.add(new hf3());
        arrayList.add(new if3());
        arrayList.add(new jf3());
        arrayList.add(new e94());
        return arrayList;
    }
}

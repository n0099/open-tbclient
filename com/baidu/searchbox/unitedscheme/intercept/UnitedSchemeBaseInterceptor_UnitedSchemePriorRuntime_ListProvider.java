package com.baidu.searchbox.unitedscheme.intercept;

import com.baidu.tieba.ag3;
import com.baidu.tieba.bg3;
import com.baidu.tieba.cl1;
import com.baidu.tieba.rp2;
import com.baidu.tieba.w94;
import com.baidu.tieba.zf3;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class UnitedSchemeBaseInterceptor_UnitedSchemePriorRuntime_ListProvider implements cl1 {
    @Override // com.baidu.tieba.cl1
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new rp2());
        arrayList.add(new zf3());
        arrayList.add(new ag3());
        arrayList.add(new bg3());
        arrayList.add(new w94());
        return arrayList;
    }
}

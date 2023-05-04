package com.baidu.searchbox.unitedscheme.intercept;

import com.baidu.tieba.ac3;
import com.baidu.tieba.dj1;
import com.baidu.tieba.ql2;
import com.baidu.tieba.v54;
import com.baidu.tieba.yb3;
import com.baidu.tieba.zb3;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class UnitedSchemeBaseInterceptor_UnitedSchemeRuntime_ListProvider implements dj1 {
    @Override // com.baidu.tieba.dj1
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ql2());
        arrayList.add(new yb3());
        arrayList.add(new zb3());
        arrayList.add(new ac3());
        arrayList.add(new v54());
        return arrayList;
    }
}

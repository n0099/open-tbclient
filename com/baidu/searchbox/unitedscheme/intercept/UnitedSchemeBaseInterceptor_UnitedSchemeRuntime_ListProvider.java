package com.baidu.searchbox.unitedscheme.intercept;

import com.baidu.tieba.aj1;
import com.baidu.tieba.nl2;
import com.baidu.tieba.s54;
import com.baidu.tieba.vb3;
import com.baidu.tieba.wb3;
import com.baidu.tieba.xb3;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class UnitedSchemeBaseInterceptor_UnitedSchemeRuntime_ListProvider implements aj1 {
    @Override // com.baidu.tieba.aj1
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new nl2());
        arrayList.add(new vb3());
        arrayList.add(new wb3());
        arrayList.add(new xb3());
        arrayList.add(new s54());
        return arrayList;
    }
}

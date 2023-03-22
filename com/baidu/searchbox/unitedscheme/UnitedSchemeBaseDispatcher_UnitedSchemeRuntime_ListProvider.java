package com.baidu.searchbox.unitedscheme;

import com.baidu.tieba.o83;
import com.baidu.tieba.p83;
import com.baidu.tieba.vu3;
import com.baidu.tieba.zi1;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class UnitedSchemeBaseDispatcher_UnitedSchemeRuntime_ListProvider implements zi1 {
    @Override // com.baidu.tieba.zi1
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new o83());
        arrayList.add(new p83());
        arrayList.add(new vu3());
        return arrayList;
    }
}

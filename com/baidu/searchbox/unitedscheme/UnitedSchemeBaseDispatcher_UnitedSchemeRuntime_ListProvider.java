package com.baidu.searchbox.unitedscheme;

import com.baidu.tieba.bj1;
import com.baidu.tieba.q83;
import com.baidu.tieba.r83;
import com.baidu.tieba.xu3;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class UnitedSchemeBaseDispatcher_UnitedSchemeRuntime_ListProvider implements bj1 {
    @Override // com.baidu.tieba.bj1
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new q83());
        arrayList.add(new r83());
        arrayList.add(new xu3());
        return arrayList;
    }
}

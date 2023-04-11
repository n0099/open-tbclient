package com.baidu.searchbox.unitedscheme;

import com.baidu.tieba.aj1;
import com.baidu.tieba.p83;
import com.baidu.tieba.q83;
import com.baidu.tieba.wu3;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class UnitedSchemeBaseDispatcher_UnitedSchemeRuntime_ListProvider implements aj1 {
    @Override // com.baidu.tieba.aj1
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new p83());
        arrayList.add(new q83());
        arrayList.add(new wu3());
        return arrayList;
    }
}

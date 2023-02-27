package com.baidu.searchbox.unitedscheme;

import com.baidu.tieba.ha3;
import com.baidu.tieba.ia3;
import com.baidu.tieba.jk1;
import com.baidu.tieba.ow3;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class UnitedSchemeBaseDispatcher_UnitedSchemeRuntime_ListProvider implements jk1 {
    @Override // com.baidu.tieba.jk1
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ha3());
        arrayList.add(new ia3());
        arrayList.add(new ow3());
        return arrayList;
    }
}

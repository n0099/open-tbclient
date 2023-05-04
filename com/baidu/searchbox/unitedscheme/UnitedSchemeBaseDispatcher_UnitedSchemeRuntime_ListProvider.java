package com.baidu.searchbox.unitedscheme;

import com.baidu.tieba.dj1;
import com.baidu.tieba.s83;
import com.baidu.tieba.t83;
import com.baidu.tieba.zu3;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class UnitedSchemeBaseDispatcher_UnitedSchemeRuntime_ListProvider implements dj1 {
    @Override // com.baidu.tieba.dj1
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new s83());
        arrayList.add(new t83());
        arrayList.add(new zu3());
        return arrayList;
    }
}

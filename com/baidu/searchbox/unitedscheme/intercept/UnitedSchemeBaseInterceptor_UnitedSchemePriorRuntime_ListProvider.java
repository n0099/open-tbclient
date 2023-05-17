package com.baidu.searchbox.unitedscheme.intercept;

import com.baidu.tieba.e74;
import com.baidu.tieba.hd3;
import com.baidu.tieba.id3;
import com.baidu.tieba.jd3;
import com.baidu.tieba.tj1;
import com.baidu.tieba.zm2;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class UnitedSchemeBaseInterceptor_UnitedSchemePriorRuntime_ListProvider implements tj1 {
    @Override // com.baidu.tieba.tj1
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new zm2());
        arrayList.add(new hd3());
        arrayList.add(new id3());
        arrayList.add(new jd3());
        arrayList.add(new e74());
        return arrayList;
    }
}

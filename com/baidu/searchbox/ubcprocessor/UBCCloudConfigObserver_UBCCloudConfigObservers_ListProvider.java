package com.baidu.searchbox.ubcprocessor;

import com.baidu.tieba.pf1;
import com.baidu.tieba.rzb;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class UBCCloudConfigObserver_UBCCloudConfigObservers_ListProvider implements pf1 {
    @Override // com.baidu.tieba.pf1
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new rzb());
        return arrayList;
    }
}

package com.baidu.searchbox.ubcprocessor;

import com.baidu.tieba.lf1;
import com.baidu.tieba.wub;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class UBCCloudConfigObserver_UBCCloudConfigObservers_ListProvider implements lf1 {
    @Override // com.baidu.tieba.lf1
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new wub());
        return arrayList;
    }
}

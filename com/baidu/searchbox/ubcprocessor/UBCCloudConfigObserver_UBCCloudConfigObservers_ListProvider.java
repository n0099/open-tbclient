package com.baidu.searchbox.ubcprocessor;

import com.baidu.tieba.aj1;
import com.baidu.tieba.cka;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class UBCCloudConfigObserver_UBCCloudConfigObservers_ListProvider implements aj1 {
    @Override // com.baidu.tieba.aj1
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new cka());
        return arrayList;
    }
}

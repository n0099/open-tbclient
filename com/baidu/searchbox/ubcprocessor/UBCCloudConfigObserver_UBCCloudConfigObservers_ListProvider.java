package com.baidu.searchbox.ubcprocessor;

import com.baidu.tieba.bj1;
import com.baidu.tieba.kka;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class UBCCloudConfigObserver_UBCCloudConfigObservers_ListProvider implements bj1 {
    @Override // com.baidu.tieba.bj1
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new kka());
        return arrayList;
    }
}

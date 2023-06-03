package com.baidu.searchbox.ubcprocessor;

import com.baidu.tieba.cl1;
import com.baidu.tieba.sxa;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class UBCCloudConfigObserver_UBCCloudConfigObservers_ListProvider implements cl1 {
    @Override // com.baidu.tieba.cl1
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new sxa());
        return arrayList;
    }
}

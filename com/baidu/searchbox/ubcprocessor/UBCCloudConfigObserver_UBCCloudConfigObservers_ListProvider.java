package com.baidu.searchbox.ubcprocessor;

import com.baidu.tieba.dl1;
import com.baidu.tieba.qza;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class UBCCloudConfigObserver_UBCCloudConfigObservers_ListProvider implements dl1 {
    @Override // com.baidu.tieba.dl1
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new qza());
        return arrayList;
    }
}

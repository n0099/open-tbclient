package com.baidu.searchbox.ubcprocessor;

import com.baidu.tieba.edb;
import com.baidu.tieba.zk1;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class UBCCloudConfigObserver_UBCCloudConfigObservers_ListProvider implements zk1 {
    @Override // com.baidu.tieba.zk1
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new edb());
        return arrayList;
    }
}

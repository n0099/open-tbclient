package com.baidu.searchbox.ubcprocessor;

import com.baidu.tieba.ck1;
import com.baidu.tieba.hcb;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class UBCCloudConfigObserver_UBCCloudConfigObservers_ListProvider implements ck1 {
    @Override // com.baidu.tieba.ck1
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new hcb());
        return arrayList;
    }
}

package com.baidu.searchbox.ubcprocessor;

import com.baidu.tieba.fqa;
import com.baidu.tieba.tj1;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class UBCCloudConfigObserver_UBCCloudConfigObservers_ListProvider implements tj1 {
    @Override // com.baidu.tieba.tj1
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new fqa());
        return arrayList;
    }
}

package com.baidu.searchbox.ubcprocessor;

import com.baidu.tieba.dj1;
import com.baidu.tieba.goa;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class UBCCloudConfigObserver_UBCCloudConfigObservers_ListProvider implements dj1 {
    @Override // com.baidu.tieba.dj1
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new goa());
        return arrayList;
    }
}

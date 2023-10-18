package com.baidu.searchbox.ubcprocessor;

import com.baidu.tieba.ue1;
import com.baidu.tieba.uhb;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class UBCCloudConfigObserver_UBCCloudConfigObservers_ListProvider implements ue1 {
    @Override // com.baidu.tieba.ue1
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new uhb());
        return arrayList;
    }
}

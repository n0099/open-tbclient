package com.baidu.searchbox.ubcprocessor;

import com.baidu.tieba.mf1;
import com.baidu.tieba.szb;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class UBCCloudConfigObserver_UBCCloudConfigObservers_ListProvider implements mf1 {
    @Override // com.baidu.tieba.mf1
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new szb());
        return arrayList;
    }
}

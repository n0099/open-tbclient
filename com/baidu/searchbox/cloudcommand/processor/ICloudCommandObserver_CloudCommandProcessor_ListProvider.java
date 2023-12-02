package com.baidu.searchbox.cloudcommand.processor;

import com.baidu.searchbox.retrieve.connect.cloudcommand.FetchCloudCommandReceiver;
import com.baidu.tieba.pf1;
import com.baidu.tieba.zpa;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class ICloudCommandObserver_CloudCommandProcessor_ListProvider implements pf1 {
    @Override // com.baidu.tieba.pf1
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new FetchCloudCommandReceiver());
        arrayList.add(new zpa());
        return arrayList;
    }
}

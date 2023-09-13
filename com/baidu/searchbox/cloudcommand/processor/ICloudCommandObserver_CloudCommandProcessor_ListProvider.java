package com.baidu.searchbox.cloudcommand.processor;

import com.baidu.searchbox.retrieve.connect.cloudcommand.FetchCloudCommandReceiver;
import com.baidu.tieba.bba;
import com.baidu.tieba.lk1;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class ICloudCommandObserver_CloudCommandProcessor_ListProvider implements lk1 {
    @Override // com.baidu.tieba.lk1
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new FetchCloudCommandReceiver());
        arrayList.add(new bba());
        return arrayList;
    }
}

package com.baidu.searchbox.cloudcommand.processor;

import com.baidu.searchbox.retrieve.connect.cloudcommand.FetchCloudCommandReceiver;
import com.baidu.tieba.j19;
import com.baidu.tieba.jk1;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class ICloudCommandObserver_CloudCommandProcessor_ListProvider implements jk1 {
    @Override // com.baidu.tieba.jk1
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new FetchCloudCommandReceiver());
        arrayList.add(new j19());
        return arrayList;
    }
}

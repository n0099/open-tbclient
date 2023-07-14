package com.baidu.searchbox.cloudcommand.processor;

import com.baidu.searchbox.retrieve.connect.cloudcommand.FetchCloudCommandReceiver;
import com.baidu.tieba.i6a;
import com.baidu.tieba.zk1;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class ICloudCommandObserver_CloudCommandProcessor_ListProvider implements zk1 {
    @Override // com.baidu.tieba.zk1
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new FetchCloudCommandReceiver());
        arrayList.add(new i6a());
        return arrayList;
    }
}

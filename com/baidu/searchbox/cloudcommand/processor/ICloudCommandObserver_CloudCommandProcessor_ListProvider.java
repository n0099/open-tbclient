package com.baidu.searchbox.cloudcommand.processor;

import com.baidu.searchbox.retrieve.connect.cloudcommand.FetchCloudCommandReceiver;
import com.baidu.tieba.hk1;
import com.baidu.tieba.i9a;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class ICloudCommandObserver_CloudCommandProcessor_ListProvider implements hk1 {
    @Override // com.baidu.tieba.hk1
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new FetchCloudCommandReceiver());
        arrayList.add(new i9a());
        return arrayList;
    }
}

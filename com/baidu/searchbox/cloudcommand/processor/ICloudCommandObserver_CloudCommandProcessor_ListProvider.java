package com.baidu.searchbox.cloudcommand.processor;

import com.baidu.searchbox.retrieve.connect.cloudcommand.FetchCloudCommandReceiver;
import com.baidu.tieba.ue1;
import com.baidu.tieba.x7a;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class ICloudCommandObserver_CloudCommandProcessor_ListProvider implements ue1 {
    @Override // com.baidu.tieba.ue1
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new FetchCloudCommandReceiver());
        arrayList.add(new x7a());
        return arrayList;
    }
}

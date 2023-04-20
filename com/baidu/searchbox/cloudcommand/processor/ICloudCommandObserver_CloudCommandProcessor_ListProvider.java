package com.baidu.searchbox.cloudcommand.processor;

import com.baidu.searchbox.retrieve.connect.cloudcommand.FetchCloudCommandReceiver;
import com.baidu.tieba.bj1;
import com.baidu.tieba.og9;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class ICloudCommandObserver_CloudCommandProcessor_ListProvider implements bj1 {
    @Override // com.baidu.tieba.bj1
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new FetchCloudCommandReceiver());
        arrayList.add(new og9());
        return arrayList;
    }
}

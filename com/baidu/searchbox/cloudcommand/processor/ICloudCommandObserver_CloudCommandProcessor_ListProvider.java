package com.baidu.searchbox.cloudcommand.processor;

import com.baidu.searchbox.retrieve.connect.cloudcommand.FetchCloudCommandReceiver;
import com.baidu.tieba.aj1;
import com.baidu.tieba.gg9;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class ICloudCommandObserver_CloudCommandProcessor_ListProvider implements aj1 {
    @Override // com.baidu.tieba.aj1
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new FetchCloudCommandReceiver());
        arrayList.add(new gg9());
        return arrayList;
    }
}

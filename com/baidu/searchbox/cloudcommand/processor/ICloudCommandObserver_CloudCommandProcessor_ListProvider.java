package com.baidu.searchbox.cloudcommand.processor;

import com.baidu.searchbox.retrieve.connect.cloudcommand.FetchCloudCommandReceiver;
import com.baidu.tieba.dj1;
import com.baidu.tieba.nj9;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class ICloudCommandObserver_CloudCommandProcessor_ListProvider implements dj1 {
    @Override // com.baidu.tieba.dj1
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new FetchCloudCommandReceiver());
        arrayList.add(new nj9());
        return arrayList;
    }
}

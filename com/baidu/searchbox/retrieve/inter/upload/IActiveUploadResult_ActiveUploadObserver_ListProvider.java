package com.baidu.searchbox.retrieve.inter.upload;

import com.baidu.searchbox.retrieve.debug.provider.DebugActiveUploadResult;
import com.baidu.tieba.s0b;
import com.baidu.tieba.zk1;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class IActiveUploadResult_ActiveUploadObserver_ListProvider implements zk1 {
    @Override // com.baidu.tieba.zk1
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new DebugActiveUploadResult());
        arrayList.add(new s0b());
        return arrayList;
    }
}

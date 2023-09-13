package com.baidu.searchbox.retrieve.inter.upload;

import com.baidu.searchbox.retrieve.debug.provider.DebugActiveUploadResult;
import com.baidu.tieba.lk1;
import com.baidu.tieba.v8b;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class IActiveUploadResult_ActiveUploadObserver_ListProvider implements lk1 {
    @Override // com.baidu.tieba.lk1
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new DebugActiveUploadResult());
        arrayList.add(new v8b());
        return arrayList;
    }
}

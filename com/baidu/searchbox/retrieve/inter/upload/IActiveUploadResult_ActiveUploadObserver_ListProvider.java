package com.baidu.searchbox.retrieve.inter.upload;

import com.baidu.searchbox.retrieve.debug.provider.DebugActiveUploadResult;
import com.baidu.tieba.uy9;
import com.baidu.tieba.zi1;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class IActiveUploadResult_ActiveUploadObserver_ListProvider implements zi1 {
    @Override // com.baidu.tieba.zi1
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new DebugActiveUploadResult());
        arrayList.add(new uy9());
        return arrayList;
    }
}

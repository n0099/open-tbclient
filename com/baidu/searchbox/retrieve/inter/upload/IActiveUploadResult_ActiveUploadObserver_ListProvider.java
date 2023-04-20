package com.baidu.searchbox.retrieve.inter.upload;

import com.baidu.searchbox.retrieve.debug.provider.DebugActiveUploadResult;
import com.baidu.tieba.bj1;
import com.baidu.tieba.t8a;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class IActiveUploadResult_ActiveUploadObserver_ListProvider implements bj1 {
    @Override // com.baidu.tieba.bj1
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new DebugActiveUploadResult());
        arrayList.add(new t8a());
        return arrayList;
    }
}

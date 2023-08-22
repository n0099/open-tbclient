package com.baidu.searchbox.retrieve.inter.upload;

import com.baidu.searchbox.retrieve.debug.provider.DebugActiveUploadResult;
import com.baidu.tieba.hk1;
import com.baidu.tieba.l6b;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class IActiveUploadResult_ActiveUploadObserver_ListProvider implements hk1 {
    @Override // com.baidu.tieba.hk1
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new DebugActiveUploadResult());
        arrayList.add(new l6b());
        return arrayList;
    }
}

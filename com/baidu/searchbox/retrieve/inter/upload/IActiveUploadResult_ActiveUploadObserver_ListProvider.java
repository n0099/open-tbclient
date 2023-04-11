package com.baidu.searchbox.retrieve.inter.upload;

import com.baidu.searchbox.retrieve.debug.provider.DebugActiveUploadResult;
import com.baidu.tieba.aj1;
import com.baidu.tieba.l8a;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class IActiveUploadResult_ActiveUploadObserver_ListProvider implements aj1 {
    @Override // com.baidu.tieba.aj1
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new DebugActiveUploadResult());
        arrayList.add(new l8a());
        return arrayList;
    }
}

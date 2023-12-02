package com.baidu.searchbox.retrieve.inter.upload;

import com.baidu.searchbox.retrieve.debug.provider.DebugActiveUploadResult;
import com.baidu.tieba.fnb;
import com.baidu.tieba.pf1;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class IActiveUploadResult_ActiveUploadObserver_ListProvider implements pf1 {
    @Override // com.baidu.tieba.pf1
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new DebugActiveUploadResult());
        arrayList.add(new fnb());
        return arrayList;
    }
}

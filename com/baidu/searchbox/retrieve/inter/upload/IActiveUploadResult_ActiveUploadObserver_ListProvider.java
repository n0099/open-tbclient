package com.baidu.searchbox.retrieve.inter.upload;

import com.baidu.searchbox.retrieve.debug.provider.DebugActiveUploadResult;
import com.baidu.tieba.jk1;
import com.baidu.tieba.ls9;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class IActiveUploadResult_ActiveUploadObserver_ListProvider implements jk1 {
    @Override // com.baidu.tieba.jk1
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new DebugActiveUploadResult());
        arrayList.add(new ls9());
        return arrayList;
    }
}

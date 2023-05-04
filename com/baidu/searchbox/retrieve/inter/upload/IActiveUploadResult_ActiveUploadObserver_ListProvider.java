package com.baidu.searchbox.retrieve.inter.upload;

import com.baidu.searchbox.retrieve.debug.provider.DebugActiveUploadResult;
import com.baidu.tieba.dj1;
import com.baidu.tieba.pca;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class IActiveUploadResult_ActiveUploadObserver_ListProvider implements dj1 {
    @Override // com.baidu.tieba.dj1
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new DebugActiveUploadResult());
        arrayList.add(new pca());
        return arrayList;
    }
}

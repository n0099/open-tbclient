package com.baidu.searchbox.retrieve.inter.upload;

import com.baidu.searchbox.retrieve.debug.provider.DebugActiveUploadResult;
import com.baidu.tieba.gl1;
import com.baidu.tieba.ura;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class IActiveUploadResult_ActiveUploadObserver_ListProvider implements gl1 {
    @Override // com.baidu.tieba.gl1
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new DebugActiveUploadResult());
        arrayList.add(new ura());
        return arrayList;
    }
}

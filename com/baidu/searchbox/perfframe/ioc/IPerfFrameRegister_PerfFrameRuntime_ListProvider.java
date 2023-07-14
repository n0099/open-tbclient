package com.baidu.searchbox.perfframe.ioc;

import com.baidu.searchbox.perfframe.ubc.UbcPerfFrameRegister;
import com.baidu.tieba.zk1;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class IPerfFrameRegister_PerfFrameRuntime_ListProvider implements zk1 {
    @Override // com.baidu.tieba.zk1
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new UbcPerfFrameRegister());
        return arrayList;
    }
}

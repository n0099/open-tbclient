package com.baidu.searchbox.perfframe.ioc;

import com.baidu.searchbox.perfframe.ubc.UbcPerfFrameRegister;
import com.baidu.tieba.aj1;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class IPerfFrameRegister_PerfFrameRuntime_ListProvider implements aj1 {
    @Override // com.baidu.tieba.aj1
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new UbcPerfFrameRegister());
        return arrayList;
    }
}

package com.baidu.searchbox.perfframe.ioc;

import com.baidu.pyramid.a.a;
import com.baidu.searchbox.perfframe.ubc.UbcPerfFrameRegister;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class IPerfFrameRegister_PerfFrameRuntime_ListProvider implements a {
    @Override // com.baidu.pyramid.a.a
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new UbcPerfFrameRegister());
        return arrayList;
    }
}

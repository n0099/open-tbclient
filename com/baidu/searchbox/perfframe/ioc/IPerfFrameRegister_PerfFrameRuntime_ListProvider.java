package com.baidu.searchbox.perfframe.ioc;

import com.baidu.searchbox.perfframe.ubc.UbcPerfFrameRegister;
import d.a.c0.a.a;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class IPerfFrameRegister_PerfFrameRuntime_ListProvider implements a {
    @Override // d.a.c0.a.a
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new UbcPerfFrameRegister());
        return arrayList;
    }
}

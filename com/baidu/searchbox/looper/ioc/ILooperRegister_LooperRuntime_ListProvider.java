package com.baidu.searchbox.looper.ioc;

import com.baidu.searchbox.ruka.ubc.UBCLooperRegister;
import d.a.c0.a.a;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class ILooperRegister_LooperRuntime_ListProvider implements a {
    @Override // d.a.c0.a.a
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new UBCLooperRegister());
        return arrayList;
    }
}

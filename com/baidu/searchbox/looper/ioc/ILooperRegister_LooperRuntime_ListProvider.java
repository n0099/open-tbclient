package com.baidu.searchbox.looper.ioc;

import com.baidu.pyramid.a.a;
import com.baidu.searchbox.ruka.ubc.UBCLooperRegister;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class ILooperRegister_LooperRuntime_ListProvider implements a {
    @Override // com.baidu.pyramid.a.a
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new UBCLooperRegister());
        return arrayList;
    }
}

package com.baidu.searchbox.anr.ioc;

import com.baidu.searchbox.anr.ubc.UbcANRRegister;
import com.baidu.searchbox.anr.upload.ANRBOSRegister;
import d.b.c0.a.a;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class IANRRegister_ANRRuntime_ListProvider implements a {
    @Override // d.b.c0.a.a
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new UbcANRRegister());
        arrayList.add(new ANRBOSRegister());
        return arrayList;
    }
}

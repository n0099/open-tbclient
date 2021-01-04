package com.baidu.searchbox.anr.ioc;

import com.baidu.pyramid.a.a;
import com.baidu.searchbox.anr.ubc.UbcANRRegister;
import com.baidu.searchbox.anr.upload.ANRBOSRegister;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class IANRRegister_ANRRuntime_ListProvider implements a {
    @Override // com.baidu.pyramid.a.a
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new UbcANRRegister());
        arrayList.add(new ANRBOSRegister());
        return arrayList;
    }
}

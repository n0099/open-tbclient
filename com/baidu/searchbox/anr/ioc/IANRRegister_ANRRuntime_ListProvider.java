package com.baidu.searchbox.anr.ioc;

import com.baidu.searchbox.anr.ubc.UbcANRRegister;
import com.baidu.searchbox.anr.upload.ANRBOSRegister;
import com.baidu.tieba.lk1;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class IANRRegister_ANRRuntime_ListProvider implements lk1 {
    @Override // com.baidu.tieba.lk1
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new UbcANRRegister());
        arrayList.add(new ANRBOSRegister());
        return arrayList;
    }
}

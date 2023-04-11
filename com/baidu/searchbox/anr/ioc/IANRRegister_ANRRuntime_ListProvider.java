package com.baidu.searchbox.anr.ioc;

import com.baidu.searchbox.anr.ubc.UbcANRRegister;
import com.baidu.searchbox.anr.upload.ANRBOSRegister;
import com.baidu.tieba.aj1;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class IANRRegister_ANRRuntime_ListProvider implements aj1 {
    @Override // com.baidu.tieba.aj1
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new UbcANRRegister());
        arrayList.add(new ANRBOSRegister());
        return arrayList;
    }
}

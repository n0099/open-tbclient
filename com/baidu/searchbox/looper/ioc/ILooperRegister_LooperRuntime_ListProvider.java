package com.baidu.searchbox.looper.ioc;

import com.baidu.searchbox.ruka.ubc.UBCLooperRegister;
import com.baidu.tieba.pf1;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class ILooperRegister_LooperRuntime_ListProvider implements pf1 {
    @Override // com.baidu.tieba.pf1
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new UBCLooperRegister());
        return arrayList;
    }
}

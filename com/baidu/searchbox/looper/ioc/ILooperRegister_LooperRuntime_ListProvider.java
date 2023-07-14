package com.baidu.searchbox.looper.ioc;

import com.baidu.searchbox.ruka.ubc.UBCLooperRegister;
import com.baidu.tieba.zk1;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class ILooperRegister_LooperRuntime_ListProvider implements zk1 {
    @Override // com.baidu.tieba.zk1
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new UBCLooperRegister());
        return arrayList;
    }
}

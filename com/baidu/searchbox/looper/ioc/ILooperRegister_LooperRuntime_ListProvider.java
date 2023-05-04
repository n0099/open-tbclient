package com.baidu.searchbox.looper.ioc;

import com.baidu.searchbox.ruka.ubc.UBCLooperRegister;
import com.baidu.tieba.dj1;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class ILooperRegister_LooperRuntime_ListProvider implements dj1 {
    @Override // com.baidu.tieba.dj1
    public Object get() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new UBCLooperRegister());
        return arrayList;
    }
}

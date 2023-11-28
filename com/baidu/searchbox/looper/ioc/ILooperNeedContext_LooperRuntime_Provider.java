package com.baidu.searchbox.looper.ioc;

import com.baidu.tieba.jpa;
import com.baidu.tieba.mf1;
/* loaded from: classes4.dex */
public class ILooperNeedContext_LooperRuntime_Provider implements mf1 {
    @Override // com.baidu.tieba.mf1
    public Object get() {
        return new jpa();
    }
}

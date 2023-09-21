package com.baidu.searchbox.abtest.ioc;

import com.baidu.searchbox.abtest.ABTestClientSampleImpl;
import com.baidu.tieba.kk1;
/* loaded from: classes3.dex */
public class ICSPDataService_CSPDataComponent_Provider implements kk1 {
    @Override // com.baidu.tieba.kk1
    public Object get() {
        return new ABTestClientSampleImpl();
    }
}

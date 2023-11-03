package com.baidu.searchbox.abtest.ioc;

import com.baidu.searchbox.abtest.ABTestClientSampleImpl;
import com.baidu.tieba.lf1;
/* loaded from: classes3.dex */
public class ICSPDataService_CSPDataComponent_Provider implements lf1 {
    @Override // com.baidu.tieba.lf1
    public Object get() {
        return new ABTestClientSampleImpl();
    }
}

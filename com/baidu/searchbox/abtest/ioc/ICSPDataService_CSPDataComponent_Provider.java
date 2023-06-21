package com.baidu.searchbox.abtest.ioc;

import com.baidu.searchbox.abtest.ABTestClientSampleImpl;
import com.baidu.tieba.dl1;
/* loaded from: classes3.dex */
public class ICSPDataService_CSPDataComponent_Provider implements dl1 {
    @Override // com.baidu.tieba.dl1
    public Object get() {
        return new ABTestClientSampleImpl();
    }
}

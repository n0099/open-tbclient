package com.baidu.searchbox.abtest.ioc;

import com.baidu.searchbox.abtest.ABTestClientSampleImpl;
import com.baidu.tieba.zk1;
/* loaded from: classes3.dex */
public class ICSPDataService_CSPDataComponent_Provider implements zk1 {
    @Override // com.baidu.tieba.zk1
    public Object get() {
        return new ABTestClientSampleImpl();
    }
}

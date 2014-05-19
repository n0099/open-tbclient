package com.baidu.tbadk.b;

import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.relogin.ReloginManager;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.framework.a.d {
    public b(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.g
    public HttpMessage a(HttpMessage httpMessage) {
        ReloginManager.a().b(httpMessage);
        return httpMessage;
    }
}

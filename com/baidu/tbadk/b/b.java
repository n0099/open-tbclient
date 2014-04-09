package com.baidu.tbadk.b;

import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.relogin.ReloginManager;
/* loaded from: classes.dex */
public final class b extends com.baidu.adp.framework.b.d {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.d] */
    /* JADX DEBUG: Return type fixed from 'com.baidu.adp.framework.message.d' to match base method */
    @Override // com.baidu.adp.framework.b.g
    public final /* synthetic */ HttpMessage a(HttpMessage httpMessage) {
        HttpMessage httpMessage2 = httpMessage;
        ReloginManager.a().b(httpMessage2);
        return httpMessage2;
    }

    public b(int i) {
        super(0);
    }
}

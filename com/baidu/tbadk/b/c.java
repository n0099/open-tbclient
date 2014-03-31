package com.baidu.tbadk.b;

import com.baidu.adp.framework.b.d;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.tbadk.core.relogin.ReloginManager;
/* loaded from: classes.dex */
public final class c extends d {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.d, com.baidu.adp.framework.task.b] */
    /* JADX DEBUG: Return type fixed from 'com.baidu.adp.framework.message.d' to match base method */
    @Override // com.baidu.adp.framework.b.f
    public final /* synthetic */ HttpMessage a(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        HttpMessage httpMessage2 = httpMessage;
        HttpMessageTask httpMessageTask2 = httpMessageTask;
        if (httpMessageTask2 == null || !(httpMessageTask2 instanceof com.baidu.tbadk.c.b)) {
            return httpMessage2;
        }
        com.baidu.tbadk.c.b bVar = (com.baidu.tbadk.c.b) httpMessageTask2;
        if (ReloginManager.a().b() && bVar.s()) {
            ReloginManager.a().a(httpMessage2);
            return null;
        }
        return httpMessage2;
    }

    public c(int i) {
        super(0);
    }
}

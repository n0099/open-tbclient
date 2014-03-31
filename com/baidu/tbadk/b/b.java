package com.baidu.tbadk.b;

import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
/* loaded from: classes.dex */
public final class b extends com.baidu.adp.framework.b.c {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    /* JADX DEBUG: Return type fixed from 'com.baidu.adp.framework.message.f' to match base method */
    @Override // com.baidu.adp.framework.b.g
    public final /* synthetic */ HttpResponsedMessage a(HttpResponsedMessage httpResponsedMessage) {
        HttpResponsedMessage httpResponsedMessage2 = httpResponsedMessage;
        if (httpResponsedMessage2 instanceof JsonHttpResponsedMessage) {
            ReloginManager a = ReloginManager.a();
            if (((JsonHttpResponsedMessage) httpResponsedMessage2).e() == 1) {
                a.a((HttpMessage) httpResponsedMessage2.h());
            }
        }
        return httpResponsedMessage2;
    }

    public b(int i) {
        super(0);
    }
}

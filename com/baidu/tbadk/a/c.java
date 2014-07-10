package com.baidu.tbadk.a;

import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.framework.a.c {
    public c(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.g
    public HttpResponsedMessage a(HttpResponsedMessage httpResponsedMessage) {
        if (httpResponsedMessage instanceof JsonHttpResponsedMessage) {
            ReloginManager a = ReloginManager.a();
            if (((JsonHttpResponsedMessage) httpResponsedMessage).getError() == 1) {
                a.a((HttpMessage) httpResponsedMessage.getOrginalMessage());
            }
        }
        return httpResponsedMessage;
    }
}

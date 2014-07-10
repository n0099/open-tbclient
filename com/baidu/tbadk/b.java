package com.baidu.tbadk;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.message.http.ResponseLocationJsonHttpMessage;
/* loaded from: classes.dex */
class b extends HttpMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        if (httpResponsedMessage.isSuccess() && httpResponsedMessage.getError() == 0 && (httpResponsedMessage instanceof ResponseLocationJsonHttpMessage)) {
            TbadkApplication.m252getInst().setLocationShared(((ResponseLocationJsonHttpMessage) httpResponsedMessage).isLocationShared);
        }
    }
}

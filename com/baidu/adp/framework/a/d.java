package com.baidu.adp.framework.a;

import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
/* loaded from: classes.dex */
public class d extends a<HttpMessage, HttpMessageTask> {
    public d(com.baidu.adp.framework.c cVar) {
        super(cVar);
    }

    public boolean a(int i) {
        f.removeAllTask(i);
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a
    public void a(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        new f(this, httpMessage, httpMessageTask).execute(new HttpMessage[0]);
    }
}

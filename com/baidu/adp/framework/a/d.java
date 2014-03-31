package com.baidu.adp.framework.a;

import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public final class d extends a<HttpMessage, HttpMessageTask> {
    public d(com.baidu.adp.framework.c cVar) {
        super(cVar);
    }

    public final LinkedList<HttpMessage> a(int i) {
        return a(f.removeAllTask(i));
    }

    @Override // com.baidu.adp.framework.a
    public final LinkedList<HttpMessage> a(int i, int i2) {
        return a(f.removeAllTask(i2, String.valueOf(i)));
    }

    private static LinkedList<HttpMessage> a(LinkedList<BdAsyncTask<?, ?, ?>> linkedList) {
        HttpMessage a;
        LinkedList<HttpMessage> linkedList2 = new LinkedList<>();
        Iterator<BdAsyncTask<?, ?, ?>> it = linkedList.iterator();
        while (it.hasNext()) {
            BdAsyncTask<?, ?, ?> next = it.next();
            if (next != null && (next instanceof f) && (a = ((f) next).a()) != null) {
                linkedList2.add(a);
            }
        }
        return linkedList2;
    }

    @Override // com.baidu.adp.framework.a
    public final LinkedList<HttpMessage> b(int i, int i2) {
        LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask = BdAsyncTask.searchAllTask(i2, String.valueOf(i));
        LinkedList<HttpMessage> linkedList = new LinkedList<>();
        Iterator<BdAsyncTask<?, ?, ?>> it = searchAllTask.iterator();
        while (it.hasNext()) {
            BdAsyncTask<?, ?, ?> next = it.next();
            if (next instanceof f) {
                linkedList.add(((f) next).a());
            }
        }
        return linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a
    public final void a(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        new f(this, httpMessage, httpMessageTask).execute(new HttpMessage[0]);
    }
}

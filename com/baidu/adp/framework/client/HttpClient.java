package com.baidu.adp.framework.client;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.TbErrInfo;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class HttpClient extends a<HttpMessage, HttpMessageTask> {
    public HttpClient(MessageManager messageManager) {
        super(messageManager);
    }

    public void a(BdUniqueId bdUniqueId) {
        d.removeAllTask(bdUniqueId);
    }

    @Override // com.baidu.adp.framework.a
    public void a(int i, BdUniqueId bdUniqueId) {
        d.removeAllTask(bdUniqueId, String.valueOf(i));
    }

    public LinkedList<HttpMessage> b(BdUniqueId bdUniqueId) {
        LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask = BdAsyncTask.searchAllTask(bdUniqueId);
        LinkedList linkedList = new LinkedList();
        Iterator<BdAsyncTask<?, ?, ?>> it = searchAllTask.iterator();
        while (it.hasNext()) {
            BdAsyncTask<?, ?, ?> next = it.next();
            if (next instanceof d) {
                linkedList.add(((d) next).a());
            }
        }
        return a(searchAllTask);
    }

    public LinkedList<HttpMessage> a(LinkedList<BdAsyncTask<?, ?, ?>> linkedList) {
        HttpMessage a;
        LinkedList<HttpMessage> linkedList2 = new LinkedList<>();
        Iterator<BdAsyncTask<?, ?, ?>> it = linkedList.iterator();
        while (it.hasNext()) {
            BdAsyncTask<?, ?, ?> next = it.next();
            if (next != null && (next instanceof d) && (a = ((d) next).a()) != null) {
                linkedList2.add(a);
            }
        }
        return linkedList2;
    }

    @Override // com.baidu.adp.framework.a
    public LinkedList<HttpMessage> b(int i, BdUniqueId bdUniqueId) {
        LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask = BdAsyncTask.searchAllTask(bdUniqueId, String.valueOf(i));
        LinkedList<HttpMessage> linkedList = new LinkedList<>();
        Iterator<BdAsyncTask<?, ?, ?>> it = searchAllTask.iterator();
        while (it.hasNext()) {
            BdAsyncTask<?, ?, ?> next = it.next();
            if (next instanceof d) {
                linkedList.add(((d) next).a());
            }
        }
        return linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a
    public void a(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        new d(this, httpMessage, httpMessageTask).execute(new HttpMessage[0]);
    }

    /* loaded from: classes.dex */
    class ErrorHttpResponsedMessage extends HttpResponsedMessage {
        public ErrorHttpResponsedMessage(int i, HttpMessage httpMessage) {
            super(i);
            setError(TbErrInfo.ERR_IMG_SEND);
            setOrginalMessage(httpMessage);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.message.b
        public void decodeInBackGround(int i, byte[] bArr) {
        }
    }
}

package com.baidu.adp.framework.client;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.network.http.d;
import com.baidu.adp.lib.network.http.f;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.TbErrInfo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class HttpClient extends com.baidu.adp.framework.client.a<HttpMessage, HttpMessageTask> {
    public HttpClient(MessageManager messageManager) {
        super(messageManager);
    }

    public void removeMessage(BdUniqueId bdUniqueId) {
        a.removeAllTask(bdUniqueId);
    }

    @Override // com.baidu.adp.framework.b
    public void removeMessage(int i, BdUniqueId bdUniqueId) {
        a.removeAllTask(bdUniqueId, String.valueOf(i));
    }

    public LinkedList<HttpMessage> a(BdUniqueId bdUniqueId) {
        return a((String) null, bdUniqueId);
    }

    @Override // com.baidu.adp.framework.b
    public LinkedList<HttpMessage> findMessage(int i, BdUniqueId bdUniqueId) {
        return a(String.valueOf(i), bdUniqueId);
    }

    public LinkedList<HttpMessage> a(String str, BdUniqueId bdUniqueId) {
        LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask = BdAsyncTask.searchAllTask(bdUniqueId, str);
        LinkedList<HttpMessage> linkedList = new LinkedList<>();
        Iterator<BdAsyncTask<?, ?, ?>> it = searchAllTask.iterator();
        while (it.hasNext()) {
            BdAsyncTask<?, ?, ?> next = it.next();
            if (next instanceof a) {
                linkedList.add(((a) next).bj());
            }
        }
        return linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.b
    public void a(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        new a(httpMessage, httpMessageTask).execute(new HttpMessage[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<HttpMessage, ResponsedMessage<?>, HttpResponsedMessage> {
        private HttpMessage gR;
        private HttpMessageTask gS;
        private final f gT;
        private volatile d gU = null;

        public HttpMessage bj() {
            return this.gR;
        }

        public a(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            this.gR = null;
            this.gS = null;
            setPriority(httpMessageTask.getPriority());
            if (httpMessageTask.getIsImm()) {
                setPriority(4);
            }
            setTag(httpMessage.getTag());
            setParallel(httpMessageTask.getParallel());
            setKey(String.valueOf(httpMessageTask.getCmd()));
            this.gR = httpMessage;
            this.gS = httpMessageTask;
            this.gT = new f();
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:38:0x0239 */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:64:0x0072 */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0122  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0141  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x01f4 A[Catch: Exception -> 0x0383, TRY_LEAVE, TryCatch #4 {Exception -> 0x0383, blocks: (B:26:0x01ee, B:28:0x01f4), top: B:70:0x01ee }] */
        /* JADX WARN: Removed duplicated region for block: B:50:0x02ae  */
        /* JADX WARN: Type inference failed for: r9v0 */
        /* JADX WARN: Type inference failed for: r9v1 */
        /* JADX WARN: Type inference failed for: r9v3 */
        /* JADX WARN: Type inference failed for: r9v5, types: [long] */
        /* JADX WARN: Type inference failed for: r9v7 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x023d -> B:10:0x00c1). Please submit an issue!!! */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public HttpResponsedMessage doInBackground(HttpMessage... httpMessageArr) {
            boolean z;
            d dVar;
            HttpResponsedMessage newInstance;
            List<Map.Entry<String, Object>> encodeInBackGround = this.gR.encodeInBackGround();
            long currentTimeMillis = System.currentTimeMillis();
            this.gT.en().setUrl(this.gS.getUrl());
            this.gT.en().setMethod(this.gS.getMethod());
            this.gT.en().d(this.gR.getHeaders());
            this.gT.en().d(encodeInBackGround);
            int timeOut = this.gS.getTimeOut().getTimeOut();
            int timeOut2 = this.gS.getConnectTimeOut().getTimeOut();
            int retry = this.gS.getRetry();
            d dVar2 = null;
            ?? r9 = 0;
            r9 = 0;
            boolean z2 = false;
            try {
                this.gU = new d(this.gT);
            } catch (Exception e) {
                e = e;
            }
            if (this.gS.getDownloadTask() != null && this.gS.getDownloadTask().co() != null) {
                try {
                    z = this.gU.a(this.gS.getDownloadTask().co(), new c(this), retry, timeOut, timeOut2, this.gS.getDownloadTask().cp());
                    dVar = 1;
                } catch (Exception e2) {
                    e = e2;
                    dVar2 = 1;
                    BdLog.detailException(e);
                    z2 = r9;
                    z = z2;
                    dVar = dVar2;
                    long startTime = this.gR.getStartTime();
                    long ei = this.gU.ei();
                    long ej = this.gU.ej();
                    long ec = this.gU.ec();
                    long ek = this.gU.ek();
                    long el = this.gU.el();
                    long j = currentTimeMillis - startTime;
                    long j2 = ei - currentTimeMillis;
                    long j3 = ej - ei;
                    dVar2 = this.gU;
                    int em = dVar2.em();
                    long j4 = ek - ej;
                    r9 = ec - ej;
                    long j5 = ek - ec;
                    long j6 = el - ek;
                    newInstance = this.gS.getResponsedClass().getConstructor(new Class[0]).newInstance(new Object[0]);
                    if (dVar == null) {
                    }
                    newInstance.setOrginalMessage(this.gR);
                    if (dVar == null) {
                    }
                    newInstance.logStatInBackground(this.gR.getCmd(), this.gT);
                    newInstance.setStartTime(System.currentTimeMillis());
                    publishProgress(newInstance);
                    if (newInstance.isSuccess()) {
                    }
                    return null;
                }
            } else if (this.gS.getMethod() == HttpMessageTask.HTTP_METHOD.GET) {
                this.gU.d(retry, timeOut, timeOut2);
                z = false;
                dVar = null;
            } else {
                if (this.gS.getMethod() == HttpMessageTask.HTTP_METHOD.POST) {
                    this.gU.f(retry, timeOut, timeOut2);
                    z = false;
                    dVar = null;
                }
                z = z2;
                dVar = dVar2;
            }
            long startTime2 = this.gR.getStartTime();
            long ei2 = this.gU.ei();
            long ej2 = this.gU.ej();
            long ec2 = this.gU.ec();
            long ek2 = this.gU.ek();
            long el2 = this.gU.el();
            long j7 = currentTimeMillis - startTime2;
            long j22 = ei2 - currentTimeMillis;
            long j32 = ej2 - ei2;
            dVar2 = this.gU;
            int em2 = dVar2.em();
            long j42 = ek2 - ej2;
            r9 = ec2 - ej2;
            long j52 = ek2 - ec2;
            long j62 = el2 - ek2;
            try {
                newInstance = this.gS.getResponsedClass().getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Exception e3) {
                try {
                    newInstance = this.gS.getResponsedClass().getConstructor(Integer.TYPE).newInstance(Integer.valueOf(this.gR.getCmd()));
                } catch (Exception e4) {
                    if (BdLog.isDebugMode()) {
                        BdLog.detailException("responsedMessage create error reason = " + e4.toString(), e4);
                    }
                    return new ErrorHttpResponsedMessage(this.gR.getCmd(), this.gR);
                }
            }
            if (dVar == null) {
                if (z) {
                    newInstance.setStatusCode(200, "");
                } else {
                    newInstance.setStatusCode(400, "");
                }
                newInstance.setContentLength(this.gT.eo().contentLength);
            } else {
                String str = "";
                if (this.gT.ep().size() > 0) {
                    String str2 = this.gT.ep().get(this.gT.ep().size() - 1).od;
                    this.gR.setEncodedBinarySize(this.gT.ep().get(this.gT.ep().size() - 1).nW);
                    str = str2;
                }
                newInstance.setStatusCode(this.gT.eo().responseCode, str);
                newInstance.setHeader(this.gT.eo().oz);
                newInstance.setContentEncoding(this.gT.eo().contentEncoding);
                newInstance.setContentLength(this.gT.eo().contentLength);
                newInstance.setContentType(this.gT.eo().contentType);
                newInstance.setDownSize(this.gT.eo().oB);
                if (!newInstance.isSuccess()) {
                    newInstance.setError(newInstance.getStatusCode());
                }
            }
            newInstance.setOrginalMessage(this.gR);
            if (dVar == null) {
                if (newInstance.isSuccess()) {
                    try {
                        newInstance.decodeInBackGround(this.gR.getCmd(), this.gT.eo().oA);
                        long currentTimeMillis2 = System.currentTimeMillis();
                        newInstance.performanceData.jj = j7;
                        newInstance.performanceData.ju = j32;
                        newInstance.performanceData.jt = em2;
                        newInstance.performanceData.jk = j22;
                        newInstance.performanceData.jl = j42;
                        newInstance.performanceData.jm = r9;
                        newInstance.performanceData.jn = j52;
                        newInstance.performanceData.jo = j62;
                        newInstance.performanceData.jp = currentTimeMillis2 - el2;
                        newInstance.setCostTime(currentTimeMillis2 - currentTimeMillis);
                        newInstance.beforeDispatchInBackGround(this.gR.getCmd(), this.gT.eo().oA);
                    } catch (Exception e5) {
                        newInstance.setError(TbErrInfo.ERR_IMG_URL_IS_NULL);
                        newInstance.setErrorString(BdBaseApplication.getInst().getContext().getString(R.string.error_unkown_try_again));
                        BdLog.detailException(e5);
                    }
                }
                if (this.gR.getExtra() instanceof NetMessage) {
                    NetMessage netMessage = (NetMessage) this.gR.getExtra();
                    newInstance.performanceData.jr = netMessage.getSocketErrNo();
                    newInstance.performanceData.js = netMessage.getSocketCostTime();
                }
            }
            newInstance.logStatInBackground(this.gR.getCmd(), this.gT);
            newInstance.setStartTime(System.currentTimeMillis());
            publishProgress(newInstance);
            try {
                if (newInstance.isSuccess()) {
                    newInstance.afterDispatchInBackGround(this.gR.getCmd(), this.gT.eo().oA);
                }
            } catch (Exception e6) {
                BdLog.e(e6.getMessage());
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.gU != null) {
                this.gU.cancel();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(ResponsedMessage<?>... responsedMessageArr) {
            if (responsedMessageArr != null && responsedMessageArr.length > 0) {
                HttpClient.this.gN.dispatchResponsedMessage(responsedMessageArr[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class ErrorHttpResponsedMessage extends HttpResponsedMessage {
        public ErrorHttpResponsedMessage(int i, HttpMessage httpMessage) {
            super(i);
            setError(TbErrInfo.ERR_IMG_SEND);
            setOrginalMessage(httpMessage);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.message.a
        public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        }
    }
}

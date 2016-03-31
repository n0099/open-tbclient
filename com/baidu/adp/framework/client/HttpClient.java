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
                linkedList.add(((a) next).dY());
            }
        }
        return linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.b
    /* renamed from: a */
    public void sendMessage(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        new a(httpMessage, httpMessageTask).execute(new HttpMessage[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<HttpMessage, ResponsedMessage<?>, HttpResponsedMessage> {
        private HttpMessage ol;
        private HttpMessageTask om;
        private final f oo;
        private volatile d oq = null;

        public HttpMessage dY() {
            return this.ol;
        }

        public a(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            this.ol = null;
            this.om = null;
            setPriority(httpMessageTask.getPriority());
            if (httpMessageTask.getIsImm()) {
                setPriority(4);
            }
            setTag(httpMessage.getTag());
            setParallel(httpMessageTask.getParallel());
            setKey(String.valueOf(httpMessageTask.getCmd()));
            this.ol = httpMessage;
            this.om = httpMessageTask;
            this.oo = new f();
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
            List<Map.Entry<String, Object>> encodeInBackGround = this.ol.encodeInBackGround();
            long currentTimeMillis = System.currentTimeMillis();
            this.oo.hg().setUrl(this.om.getUrl());
            this.oo.hg().setMethod(this.om.getMethod());
            this.oo.hg().d(this.ol.getHeaders());
            this.oo.hg().d(encodeInBackGround);
            int timeOut = this.om.getTimeOut().getTimeOut();
            int timeOut2 = this.om.getConnectTimeOut().getTimeOut();
            int retry = this.om.getRetry();
            d dVar2 = null;
            ?? r9 = 0;
            r9 = 0;
            boolean z2 = false;
            try {
                this.oq = new d(this.oo);
            } catch (Exception e) {
                e = e;
            }
            if (this.om.getDownloadTask() != null && this.om.getDownloadTask().fg() != null) {
                try {
                    z = this.oq.a(this.om.getDownloadTask().fg(), new c(this), retry, timeOut, timeOut2, this.om.getDownloadTask().fh());
                    dVar = 1;
                } catch (Exception e2) {
                    e = e2;
                    dVar2 = 1;
                    BdLog.detailException(e);
                    z2 = r9;
                    z = z2;
                    dVar = dVar2;
                    long startTime = this.ol.getStartTime();
                    long hb = this.oq.hb();
                    long hc = this.oq.hc();
                    long gV = this.oq.gV();
                    long hd = this.oq.hd();
                    long he = this.oq.he();
                    long j = currentTimeMillis - startTime;
                    long j2 = hb - currentTimeMillis;
                    long j3 = hc - hb;
                    dVar2 = this.oq;
                    int hf = dVar2.hf();
                    long j4 = hd - hc;
                    r9 = gV - hc;
                    long j5 = hd - gV;
                    long j6 = he - hd;
                    newInstance = this.om.getResponsedClass().getConstructor(new Class[0]).newInstance(new Object[0]);
                    if (dVar == null) {
                    }
                    newInstance.setOrginalMessage(this.ol);
                    if (dVar == null) {
                    }
                    newInstance.logStatInBackground(this.ol.getCmd(), this.oo);
                    newInstance.setStartTime(System.currentTimeMillis());
                    publishProgress(newInstance);
                    if (newInstance.isSuccess()) {
                    }
                    return null;
                }
            } else if (this.om.getMethod() == HttpMessageTask.HTTP_METHOD.GET) {
                this.oq.e(retry, timeOut, timeOut2);
                z = false;
                dVar = null;
            } else {
                if (this.om.getMethod() == HttpMessageTask.HTTP_METHOD.POST) {
                    this.oq.g(retry, timeOut, timeOut2);
                    z = false;
                    dVar = null;
                }
                z = z2;
                dVar = dVar2;
            }
            long startTime2 = this.ol.getStartTime();
            long hb2 = this.oq.hb();
            long hc2 = this.oq.hc();
            long gV2 = this.oq.gV();
            long hd2 = this.oq.hd();
            long he2 = this.oq.he();
            long j7 = currentTimeMillis - startTime2;
            long j22 = hb2 - currentTimeMillis;
            long j32 = hc2 - hb2;
            dVar2 = this.oq;
            int hf2 = dVar2.hf();
            long j42 = hd2 - hc2;
            r9 = gV2 - hc2;
            long j52 = hd2 - gV2;
            long j62 = he2 - hd2;
            try {
                newInstance = this.om.getResponsedClass().getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Exception e3) {
                try {
                    newInstance = this.om.getResponsedClass().getConstructor(Integer.TYPE).newInstance(Integer.valueOf(this.ol.getCmd()));
                } catch (Exception e4) {
                    if (BdLog.isDebugMode()) {
                        BdLog.detailException("responsedMessage create error reason = " + e4.toString(), e4);
                    }
                    return new ErrorHttpResponsedMessage(this.ol.getCmd(), this.ol);
                }
            }
            if (dVar == null) {
                if (z) {
                    newInstance.setStatusCode(200, "");
                } else {
                    newInstance.setStatusCode(400, "");
                }
                newInstance.setContentLength(this.oo.hh().contentLength);
            } else {
                String str = "";
                if (this.oo.hi().size() > 0) {
                    String str2 = this.oo.hi().get(this.oo.hi().size() - 1).vw;
                    this.ol.setEncodedBinarySize(this.oo.hi().get(this.oo.hi().size() - 1).vp);
                    str = str2;
                }
                newInstance.setStatusCode(this.oo.hh().responseCode, str);
                newInstance.setHeader(this.oo.hh().vM);
                newInstance.setContentEncoding(this.oo.hh().contentEncoding);
                newInstance.setContentLength(this.oo.hh().contentLength);
                newInstance.setContentType(this.oo.hh().contentType);
                newInstance.setDownSize(this.oo.hh().vO);
                if (!newInstance.isSuccess()) {
                    newInstance.setError(newInstance.getStatusCode());
                }
            }
            newInstance.setOrginalMessage(this.ol);
            if (dVar == null) {
                if (newInstance.isSuccess()) {
                    try {
                        newInstance.decodeInBackGround(this.ol.getCmd(), this.oo.hh().vN);
                        long currentTimeMillis2 = System.currentTimeMillis();
                        newInstance.performanceData.qH = j7;
                        newInstance.performanceData.qS = j32;
                        newInstance.performanceData.qR = hf2;
                        newInstance.performanceData.qI = j22;
                        newInstance.performanceData.qJ = j42;
                        newInstance.performanceData.qK = r9;
                        newInstance.performanceData.qL = j52;
                        newInstance.performanceData.qM = j62;
                        newInstance.performanceData.qN = currentTimeMillis2 - he2;
                        newInstance.setCostTime(currentTimeMillis2 - currentTimeMillis);
                        newInstance.beforeDispatchInBackGround(this.ol.getCmd(), this.oo.hh().vN);
                    } catch (Exception e5) {
                        newInstance.setError(TbErrInfo.ERR_IMG_URL_IS_NULL);
                        newInstance.setErrorString(BdBaseApplication.getInst().getContext().getString(R.string.error_unkown_try_again));
                        BdLog.detailException(e5);
                    }
                }
                if (this.ol.getExtra() instanceof NetMessage) {
                    NetMessage netMessage = (NetMessage) this.ol.getExtra();
                    newInstance.performanceData.qP = netMessage.getSocketErrNo();
                    newInstance.performanceData.qQ = netMessage.getSocketCostTime();
                }
            }
            newInstance.logStatInBackground(this.ol.getCmd(), this.oo);
            newInstance.setStartTime(System.currentTimeMillis());
            publishProgress(newInstance);
            try {
                if (newInstance.isSuccess()) {
                    newInstance.afterDispatchInBackGround(this.ol.getCmd(), this.oo.hh().vN);
                }
            } catch (Exception e6) {
                BdLog.e(e6.getMessage());
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.oq != null) {
                this.oq.cancel();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(ResponsedMessage<?>... responsedMessageArr) {
            if (responsedMessageArr != null && responsedMessageArr.length > 0) {
                HttpClient.this.og.dispatchResponsedMessage(responsedMessageArr[0]);
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
        public void decodeInBackGround(int i, byte[] bArr) {
        }
    }
}

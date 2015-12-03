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
import com.baidu.adp.lib.network.http.e;
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
                linkedList.add(((a) next).dV());
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
        private HttpMessage oh;
        private HttpMessageTask oi;
        private final e oj;
        private volatile com.baidu.adp.lib.network.http.c ol = null;

        public HttpMessage dV() {
            return this.oh;
        }

        public a(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            this.oh = null;
            this.oi = null;
            setPriority(httpMessageTask.getPriority());
            if (httpMessageTask.getIsImm()) {
                setPriority(4);
            }
            setTag(httpMessage.getTag());
            setParallel(httpMessageTask.getParallel());
            setKey(String.valueOf(httpMessageTask.getCmd()));
            this.oh = httpMessage;
            this.oi = httpMessageTask;
            this.oj = new e();
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:38:0x01f6 */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:70:0x0072 */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0104  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0167 A[Catch: Exception -> 0x0323, TryCatch #5 {Exception -> 0x0323, blocks: (B:21:0x0129, B:23:0x0167, B:24:0x0179), top: B:72:0x0129 }] */
        /* JADX WARN: Removed duplicated region for block: B:28:0x01b1 A[Catch: Exception -> 0x033f, TRY_LEAVE, TryCatch #1 {Exception -> 0x033f, blocks: (B:26:0x01ab, B:28:0x01b1), top: B:64:0x01ab }] */
        /* JADX WARN: Removed duplicated region for block: B:50:0x0269  */
        /* JADX WARN: Type inference failed for: r9v0 */
        /* JADX WARN: Type inference failed for: r9v1 */
        /* JADX WARN: Type inference failed for: r9v3 */
        /* JADX WARN: Type inference failed for: r9v4, types: [long] */
        /* JADX WARN: Type inference failed for: r9v6 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x01fa -> B:10:0x00c1). Please submit an issue!!! */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public HttpResponsedMessage doInBackground(HttpMessage... httpMessageArr) {
            boolean z;
            com.baidu.adp.lib.network.http.c cVar;
            long gR;
            long j;
            long j2;
            long j3;
            long j4;
            HttpResponsedMessage newInstance;
            List<Map.Entry<String, Object>> encodeInBackGround = this.oh.encodeInBackGround();
            long currentTimeMillis = System.currentTimeMillis();
            this.oj.gS().setUrl(this.oi.getUrl());
            this.oj.gS().setMethod(this.oi.getMethod());
            this.oj.gS().d(this.oh.getHeaders());
            this.oj.gS().d(encodeInBackGround);
            int timeOut = this.oi.getTimeOut().getTimeOut();
            int timeOut2 = this.oi.getConnectTimeOut().getTimeOut();
            int retry = this.oi.getRetry();
            com.baidu.adp.lib.network.http.c cVar2 = null;
            ?? r9 = 0;
            r9 = 0;
            boolean z2 = false;
            try {
                this.ol = new com.baidu.adp.lib.network.http.c(this.oj);
            } catch (Exception e) {
                e = e;
            }
            if (this.oi.getDownloadTask() != null && this.oi.getDownloadTask().eY() != null) {
                try {
                    z = this.ol.a(this.oi.getDownloadTask().eY(), new c(this), retry, timeOut, timeOut2, this.oi.getDownloadTask().eZ());
                    cVar = 1;
                } catch (Exception e2) {
                    e = e2;
                    cVar2 = 1;
                    BdLog.detailException(e);
                    z2 = r9;
                    z = z2;
                    cVar = cVar2;
                    long startTime = this.oh.getStartTime();
                    long gP = this.ol.gP();
                    r9 = this.ol.gQ();
                    cVar2 = this.ol;
                    gR = cVar2.gR();
                    j = currentTimeMillis - startTime;
                    j2 = gP - currentTimeMillis;
                    j3 = r9 - gP;
                    j4 = gR - r9;
                    newInstance = this.oi.getResponsedClass().getConstructor(new Class[0]).newInstance(new Object[0]);
                    if (cVar == null) {
                    }
                    newInstance.setOrginalMessage(this.oh);
                    if (cVar == null) {
                        try {
                            newInstance.decodeInBackGround(this.oh.getCmd(), this.oj.gT().vl);
                            long currentTimeMillis2 = System.currentTimeMillis();
                            long j5 = currentTimeMillis2 - currentTimeMillis;
                            newInstance.performanceData.qx = j;
                            newInstance.performanceData.qy = j2;
                            newInstance.performanceData.qz = j3;
                            newInstance.performanceData.qA = j4;
                            newInstance.performanceData.qB = currentTimeMillis2 - gR;
                            if (this.oh.getExtra() instanceof NetMessage) {
                            }
                            newInstance.setCostTime(j5);
                            newInstance.beforeDispatchInBackGround(this.oh.getCmd(), this.oj.gT().vl);
                        } catch (Exception e3) {
                            newInstance.setError(TbErrInfo.ERR_IMG_URL_IS_NULL);
                            newInstance.setErrorString(BdBaseApplication.getInst().getContext().getString(R.string.error_unkown_try_again));
                            BdLog.detailException(e3);
                        }
                    }
                    newInstance.logStatInBackground(this.oh.getCmd(), this.oj);
                    publishProgress(newInstance);
                    if (newInstance.isSuccess()) {
                    }
                    return null;
                }
            } else if (this.oi.getMethod() == HttpMessageTask.HTTP_METHOD.GET) {
                this.ol.e(retry, timeOut, timeOut2);
                z = false;
                cVar = null;
            } else {
                if (this.oi.getMethod() == HttpMessageTask.HTTP_METHOD.POST) {
                    this.ol.g(retry, timeOut, timeOut2);
                    z = false;
                    cVar = null;
                }
                z = z2;
                cVar = cVar2;
            }
            long startTime2 = this.oh.getStartTime();
            long gP2 = this.ol.gP();
            r9 = this.ol.gQ();
            cVar2 = this.ol;
            gR = cVar2.gR();
            j = currentTimeMillis - startTime2;
            j2 = gP2 - currentTimeMillis;
            j3 = r9 - gP2;
            j4 = gR - r9;
            try {
                newInstance = this.oi.getResponsedClass().getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Exception e4) {
                try {
                    newInstance = this.oi.getResponsedClass().getConstructor(Integer.TYPE).newInstance(Integer.valueOf(this.oh.getCmd()));
                } catch (Exception e5) {
                    if (BdLog.isDebugMode()) {
                        BdLog.detailException("responsedMessage create error reason = " + e5.toString(), e5);
                    }
                    return new ErrorHttpResponsedMessage(this.oh.getCmd(), this.oh);
                }
            }
            if (cVar == null) {
                if (z) {
                    newInstance.setStatusCode(200, "");
                } else {
                    newInstance.setStatusCode(400, "");
                }
                newInstance.setContentLength(this.oj.gT().contentLength);
            } else {
                String str = "";
                if (this.oj.gU().size() > 0) {
                    String str2 = this.oj.gU().get(this.oj.gU().size() - 1).uX;
                    this.oh.setEncodedBinarySize(this.oj.gU().get(this.oj.gU().size() - 1).uQ);
                    str = str2;
                }
                newInstance.setStatusCode(this.oj.gT().responseCode, str);
                newInstance.setHeader(this.oj.gT().vk);
                newInstance.setContentEncoding(this.oj.gT().contentEncoding);
                newInstance.setContentLength(this.oj.gT().contentLength);
                newInstance.setContentType(this.oj.gT().contentType);
                newInstance.setDownSize(this.oj.gT().vm);
                if (!newInstance.isSuccess()) {
                    newInstance.setError(newInstance.getStatusCode());
                }
            }
            newInstance.setOrginalMessage(this.oh);
            if (cVar == null && newInstance.isSuccess()) {
                newInstance.decodeInBackGround(this.oh.getCmd(), this.oj.gT().vl);
                long currentTimeMillis22 = System.currentTimeMillis();
                long j52 = currentTimeMillis22 - currentTimeMillis;
                newInstance.performanceData.qx = j;
                newInstance.performanceData.qy = j2;
                newInstance.performanceData.qz = j3;
                newInstance.performanceData.qA = j4;
                newInstance.performanceData.qB = currentTimeMillis22 - gR;
                if (this.oh.getExtra() instanceof NetMessage) {
                    newInstance.performanceData.qC = ((NetMessage) this.oh.getExtra()).getSocketErrNo();
                }
                newInstance.setCostTime(j52);
                newInstance.beforeDispatchInBackGround(this.oh.getCmd(), this.oj.gT().vl);
            }
            newInstance.logStatInBackground(this.oh.getCmd(), this.oj);
            publishProgress(newInstance);
            try {
                if (newInstance.isSuccess()) {
                    newInstance.afterDispatchInBackGround(this.oh.getCmd(), this.oj.gT().vl);
                }
            } catch (Exception e6) {
                BdLog.e(e6.getMessage());
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.ol != null) {
                this.ol.cancel();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(ResponsedMessage<?>... responsedMessageArr) {
            if (responsedMessageArr != null && responsedMessageArr.length > 0) {
                HttpClient.this.od.dispatchResponsedMessage(responsedMessageArr[0]);
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

package com.baidu.live.adp.framework.client;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.R;
import com.baidu.live.adp.base.BdBaseApplication;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.framework.message.NetMessage;
import com.baidu.live.adp.framework.message.ResponsedMessage;
import com.baidu.live.adp.framework.task.HttpMessageTask;
import com.baidu.live.adp.lib.asynctask.BdAsyncTask;
import com.baidu.live.adp.lib.network.http.BdNetWorkManager;
import com.baidu.live.adp.lib.network.http.interfaces.DownLoadCallback;
import com.baidu.live.adp.lib.network.http.interfaces.INetWork;
import com.baidu.live.adp.lib.network.http.interfaces.NetResponse;
import com.baidu.live.adp.lib.util.BdLog;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class HttpClient extends Client<HttpMessage, HttpMessageTask> {
    public HttpClient(MessageManager messageManager) {
        super(messageManager);
    }

    @Override // com.baidu.live.adp.framework.IMessageProcess
    public void removeMessage(BdUniqueId bdUniqueId) {
        HTTPAsyncTask.removeAllTask(bdUniqueId);
    }

    @Override // com.baidu.live.adp.framework.IMessageProcess
    public void removeMessage(int i, BdUniqueId bdUniqueId) {
        HTTPAsyncTask.removeAllTask(bdUniqueId, String.valueOf(i));
    }

    @Override // com.baidu.live.adp.framework.IMessageProcess
    public void removeWaitingMessage(BdUniqueId bdUniqueId) {
        HTTPAsyncTask.removeAllWaitingTask(bdUniqueId);
    }

    @Override // com.baidu.live.adp.framework.IMessageProcess
    public void removeWaitingMessage(int i, BdUniqueId bdUniqueId) {
        HTTPAsyncTask.removeAllWaitingTask(bdUniqueId, String.valueOf(i));
    }

    @Override // com.baidu.live.adp.framework.IMessageProcess
    public LinkedList<HttpMessage> findMessage(BdUniqueId bdUniqueId) {
        return findMessage((String) null, bdUniqueId);
    }

    @Override // com.baidu.live.adp.framework.IMessageProcess
    public LinkedList<HttpMessage> findMessage(int i, BdUniqueId bdUniqueId) {
        return findMessage(String.valueOf(i), bdUniqueId);
    }

    public LinkedList<HttpMessage> findMessage(String str, BdUniqueId bdUniqueId) {
        LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask = BdAsyncTask.searchAllTask(bdUniqueId, str);
        LinkedList<HttpMessage> linkedList = new LinkedList<>();
        Iterator<BdAsyncTask<?, ?, ?>> it = searchAllTask.iterator();
        while (it.hasNext()) {
            BdAsyncTask<?, ?, ?> next = it.next();
            if (next instanceof HTTPAsyncTask) {
                linkedList.add(((HTTPAsyncTask) next).getMessage());
            }
        }
        return linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.adp.framework.client.Client, com.baidu.live.adp.framework.IMessageProcess
    public void sendMessage(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        new HTTPAsyncTask(httpMessage, httpMessageTask).execute(new HttpMessage[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class HTTPAsyncTask extends BdAsyncTask<HttpMessage, ResponsedMessage<?>, HttpResponsedMessage> {
        private HttpMessageTask mMessageTask;
        private HttpMessage mRequestMsg;
        private volatile INetWork netWork = null;

        public HttpMessage getMessage() {
            return this.mRequestMsg;
        }

        public HTTPAsyncTask(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
            this.mRequestMsg = null;
            this.mMessageTask = null;
            setPriority(httpMessageTask.getPriority());
            if (httpMessageTask.getIsImm()) {
                setPriority(4);
            }
            setTag(httpMessage.getTag());
            setParallel(httpMessageTask.getParallel());
            setKey(String.valueOf(httpMessageTask.getCmd()));
            this.mRequestMsg = httpMessage;
            this.mMessageTask = httpMessageTask;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
        public HttpResponsedMessage doInBackground(HttpMessage... httpMessageArr) {
            NetResponse netResponse;
            HttpResponsedMessage newInstance;
            NetResponse post;
            List<Map.Entry<String, Object>> encodeInBackGround = this.mRequestMsg.encodeInBackGround();
            this.netWork = BdNetWorkManager.getInstance().buildNetWork();
            this.netWork.setUrl(this.mMessageTask.getUrl());
            this.netWork.setHeaderData(this.mRequestMsg.getHeaders());
            int timeOutAuto = this.mMessageTask.getTimeOut().getTimeOutAuto();
            int timeOutAuto2 = this.mMessageTask.getConnectTimeOut().getTimeOutAuto();
            int retry = this.mMessageTask.getRetry();
            this.netWork.setConnectTimeout(timeOutAuto2);
            this.netWork.setReadTimeout(timeOutAuto);
            this.netWork.setRetryCount(retry);
            try {
                if (this.mMessageTask.getDownloadTask() != null && this.mMessageTask.getDownloadTask().getDownloadPath() != null) {
                    this.netWork.download("netDownLoad", this.mMessageTask.getDownloadTask().getDownloadPath(), new DownLoadCallback() { // from class: com.baidu.live.adp.framework.client.HttpClient.HTTPAsyncTask.1
                        @Override // com.baidu.live.adp.lib.network.http.interfaces.DownLoadCallback
                        public void onFileUpdateProgress(Object obj, long j, long j2) {
                        }

                        @Override // com.baidu.live.adp.lib.network.http.interfaces.DownLoadCallback
                        public void onFileDownloaded(Object obj, int i) {
                        }
                    });
                    post = null;
                } else if (this.mMessageTask.getMethod() == HttpMessageTask.HTTP_METHOD.GET) {
                    post = this.netWork.get(encodeInBackGround);
                } else {
                    post = this.mMessageTask.getMethod() == HttpMessageTask.HTTP_METHOD.POST ? this.netWork.post(encodeInBackGround) : null;
                }
                netResponse = post;
            } catch (Exception e) {
                BdLog.detailException(e);
                netResponse = null;
            }
            try {
                newInstance = this.mMessageTask.getResponsedClass().getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Exception e2) {
                try {
                    newInstance = this.mMessageTask.getResponsedClass().getConstructor(Integer.TYPE).newInstance(Integer.valueOf(this.mRequestMsg.getCmd()));
                } catch (Exception e3) {
                    if (BdLog.isDebugMode()) {
                        BdLog.detailException("responsedMessage create error reason = " + e3.toString(), e3);
                    }
                    return new ErrorHttpResponsedMessage(this.mRequestMsg.getCmd(), this.mRequestMsg);
                }
            }
            if (netResponse == null) {
                return null;
            }
            if (netResponse.netErrorCode != 0 && netResponse.responseCode == 0) {
                netResponse.responseCode = 400;
            }
            newInstance.setStatusCode(netResponse.responseCode, BdBaseApplication.getInst().getResources().getString(R.string.sdk_neterror));
            newInstance.setError(netResponse.netErrorCode);
            newInstance.setHeader(netResponse.headers);
            newInstance.setContentEncoding(netResponse.contentEncoding);
            newInstance.setContentLength(netResponse.contentLength);
            newInstance.setContentType(netResponse.contentType);
            newInstance.setDownSize(netResponse.downSize);
            if (!newInstance.isSuccess()) {
                newInstance.setError(newInstance.getStatusCode());
            }
            newInstance.setOrginalMessage(this.mRequestMsg);
            if (newInstance.isSuccess() && netResponse != null) {
                try {
                    newInstance.decodeInBackGround(this.mRequestMsg.getCmd(), netResponse.retBytes);
                    newInstance.beforeDispatchInBackGround(this.mRequestMsg.getCmd(), netResponse.retBytes);
                } catch (Exception e4) {
                    newInstance.setError(-1003);
                    newInstance.setErrorString(BdBaseApplication.getInst().getContext().getString(R.string.sdk_error_unkown_try_again));
                    BdLog.detailException(e4);
                }
            }
            if (this.mRequestMsg.getExtra() instanceof NetMessage) {
                NetMessage netMessage = (NetMessage) this.mRequestMsg.getExtra();
                newInstance.performanceData.mSocketErrNo = netMessage.getSocketErrNo();
                newInstance.performanceData.mSocketCostTime = netMessage.getSocketCostTime();
            }
            publishProgress(newInstance);
            try {
                if (!newInstance.isSuccess() || netResponse == null) {
                    return null;
                }
                newInstance.afterDispatchInBackGround(this.mRequestMsg.getCmd(), netResponse.retBytes);
                return null;
            } catch (Exception e5) {
                BdLog.e(e5.getMessage());
                return null;
            }
        }

        @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
            if (this.netWork != null) {
                this.netWork.cancel();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.live.adp.lib.asynctask.BdAsyncTask
        public void onProgressUpdate(ResponsedMessage<?>... responsedMessageArr) {
            if (responsedMessageArr != null && responsedMessageArr.length > 0) {
                HttpClient.this.mMessageManager.dispatchResponsedMessage(responsedMessageArr[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class ErrorHttpResponsedMessage extends HttpResponsedMessage {
        public ErrorHttpResponsedMessage(int i, HttpMessage httpMessage) {
            super(i);
            setError(-1002);
            setOrginalMessage(httpMessage);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.message.IDecode
        public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        }
    }

    @Override // com.baidu.live.adp.framework.IMessageProcess
    public boolean haveMessage(BdUniqueId bdUniqueId) {
        return getMessageNum(bdUniqueId) > 0;
    }

    @Override // com.baidu.live.adp.framework.IMessageProcess
    public boolean haveMessage(int i, BdUniqueId bdUniqueId) {
        return getMessageNum(i, bdUniqueId) > 0;
    }

    @Override // com.baidu.live.adp.framework.IMessageProcess
    public int getMessageNum(BdUniqueId bdUniqueId) {
        return getMessageNum(0, bdUniqueId);
    }

    @Override // com.baidu.live.adp.framework.IMessageProcess
    public int getMessageNum(int i, BdUniqueId bdUniqueId) {
        String str = null;
        if (i != 0) {
            str = String.valueOf(i);
        }
        return HTTPAsyncTask.getTaskNum(str, bdUniqueId);
    }
}

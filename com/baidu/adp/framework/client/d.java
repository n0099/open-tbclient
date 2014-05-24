package com.baidu.adp.framework.client;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.client.HttpClient;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.h;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.TbErrInfo;
import java.util.List;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends BdAsyncTask<HttpMessage, HttpResponsedMessage, HttpResponsedMessage> {
    final /* synthetic */ HttpClient a;
    private HttpMessage b;
    private HttpMessageTask c;
    private final com.baidu.adp.lib.network.http.e d;

    public HttpMessage a() {
        return this.b;
    }

    public d(HttpClient httpClient, HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        this.a = httpClient;
        this.b = null;
        this.c = null;
        setPriority(httpMessageTask.getPriority());
        if (httpMessageTask.getIsImm()) {
            setPriority(4);
        }
        setTag(httpMessage.getTag());
        setParallel(httpMessageTask.getParallel());
        setKey(String.valueOf(httpMessageTask.getCmd()));
        this.b = httpMessage;
        this.c = httpMessageTask;
        this.d = new com.baidu.adp.lib.network.http.e();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0146 -> B:29:0x006a). Please submit an issue!!! */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public HttpResponsedMessage doInBackground(HttpMessage... httpMessageArr) {
        List<Map.Entry<String, Object>> encodeInBackGround = this.b.encodeInBackGround();
        this.d.a().a(this.c.getUrl());
        this.d.a().a(this.c.getMethod());
        this.d.a().a(this.b.getHeaders());
        this.d.a().a(encodeInBackGround);
        int a = this.c.getTimeOut().a();
        int a2 = this.c.getConnectTimeOut().a();
        int retry = this.c.getRetry();
        try {
            com.baidu.adp.lib.network.http.c cVar = new com.baidu.adp.lib.network.http.c(this.d);
            if (this.c.getMethod() == HttpMessageTask.HTTP_METHOD.GET) {
                cVar.a(retry, a, a2);
            } else if (this.c.getMethod() == HttpMessageTask.HTTP_METHOD.POST) {
                cVar.b(retry, a, a2);
            }
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        try {
            HttpResponsedMessage newInstance = this.c.getResponsedClass().getConstructor(Integer.TYPE).newInstance(Integer.valueOf(this.b.getCmd()));
            newInstance.setOrginalMessage(this.b);
            String str = "";
            if (this.d.c().size() > 0) {
                str = this.d.c().get(this.d.c().size() - 1).h;
            }
            newInstance.setStatusCode(this.d.b().b, str);
            newInstance.setHeader(this.d.b().f);
            newInstance.setContentEncoding(this.d.b().c);
            newInstance.setContentLength(this.d.b().e);
            newInstance.setContentType(this.d.b().d);
            newInstance.setDownSize(this.d.b().h);
            if (newInstance.isSuccess()) {
                try {
                    newInstance.decodeInBackGround(this.b.getCmd(), this.d.b().g);
                    newInstance.processInBackGround(this.b.getCmd(), this.d.b().g);
                } catch (Exception e2) {
                    newInstance.setError(TbErrInfo.ERR_IMG_URL_IS_NULL);
                    newInstance.setErrorString(BdBaseApplication.getInst().getString(com.baidu.adp.f.error_unkown_try_again));
                    BdLog.detailException(e2);
                }
            } else {
                newInstance.setError(newInstance.getStatusCode());
            }
            newInstance.logStatInBackground(this.b.getCmd(), this.d);
            return newInstance;
        } catch (Exception e3) {
            if (BdLog.isDebugMode()) {
                BdLog.detailException("responsedMessage create error reason = " + e3.toString(), e3);
            }
            HttpClient.ErrorHttpResponsedMessage errorHttpResponsedMessage = new HttpClient.ErrorHttpResponsedMessage(this.b.getCmd(), this.b);
            b();
            return errorHttpResponsedMessage;
        }
    }

    private void b() {
        String b = this.d.a().b("sid");
        if (this.d.c().size() > 0) {
            com.baidu.adp.lib.network.http.d dVar = this.d.c().get(this.d.c().size() - 1);
            h.a().b(this.d.a().b(), b, "", dVar.b, dVar.a, dVar.f, dVar.c, dVar.d, dVar.e, TbErrInfo.ERR_IMG_CACHE, "init " + this.c.getResponsedClass() + " error", new Object[0]);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.d != null) {
            this.d.b().a = true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(HttpResponsedMessage httpResponsedMessage) {
        this.a.a.dispatchResponsedMessage(httpResponsedMessage);
    }
}

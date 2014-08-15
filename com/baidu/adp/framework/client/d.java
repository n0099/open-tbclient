package com.baidu.adp.framework.client;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.f;
import com.baidu.adp.framework.client.HttpClient;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.network.http.e;
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
    private final e d;
    private volatile com.baidu.adp.lib.network.http.c e = null;

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
        this.d = new e();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0187 -> B:37:0x0074). Please submit an issue!!! */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public HttpResponsedMessage doInBackground(HttpMessage... httpMessageArr) {
        List<Map.Entry<String, Object>> encodeInBackGround = this.b.encodeInBackGround();
        long currentTimeMillis = System.currentTimeMillis();
        this.d.a().a(this.c.getUrl());
        this.d.a().a(this.c.getMethod());
        this.d.a().a(this.b.getHeaders());
        this.d.a().a(encodeInBackGround);
        int a = this.c.getTimeOut().a();
        int a2 = this.c.getConnectTimeOut().a();
        int retry = this.c.getRetry();
        try {
            this.e = new com.baidu.adp.lib.network.http.c(this.d);
            if (this.c.getMethod() == HttpMessageTask.HTTP_METHOD.GET) {
                this.e.a(retry, a, a2);
            } else if (this.c.getMethod() == HttpMessageTask.HTTP_METHOD.POST) {
                this.e.b(retry, a, a2);
            }
        } catch (Exception e) {
            BdLog.detailException(e);
        }
        try {
            HttpResponsedMessage newInstance = this.c.getResponsedClass().getConstructor(Integer.TYPE).newInstance(Integer.valueOf(this.b.getCmd()));
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
            if (!newInstance.isSuccess()) {
                newInstance.setError(newInstance.getStatusCode());
            }
            newInstance.setOrginalMessage(this.b);
            if (newInstance.isSuccess()) {
                try {
                    newInstance.decodeInBackGround(this.b.getCmd(), this.d.b().g);
                    newInstance.setCostTime(System.currentTimeMillis() - currentTimeMillis);
                    newInstance.beforeDispatchInBackGround(this.b.getCmd(), this.d.b().g);
                } catch (Exception e2) {
                    newInstance.setError(TbErrInfo.ERR_IMG_URL_IS_NULL);
                    newInstance.setErrorString(BdBaseApplication.getInst().getString(f.error_unkown_try_again));
                    BdLog.detailException(e2);
                }
            }
            newInstance.logStatInBackground(this.b.getCmd(), this.d);
            publishProgress(newInstance);
            try {
                if (newInstance.isSuccess()) {
                    newInstance.afterDispatchInBackGround(this.b.getCmd(), this.d.b().g);
                }
            } catch (Exception e3) {
                BdLog.e(e3.getMessage());
            }
            return null;
        } catch (Exception e4) {
            if (BdLog.isDebugMode()) {
                BdLog.detailException("responsedMessage create error reason = " + e4.toString(), e4);
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
            com.baidu.adp.lib.stats.f.c().b(this.d.a().b(), b, "", dVar.b, dVar.a, dVar.f, dVar.c, dVar.d, dVar.e, TbErrInfo.ERR_IMG_CACHE, "init " + this.c.getResponsedClass() + " error", new Object[0]);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.e != null) {
            this.e.a();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onProgressUpdate(HttpResponsedMessage... httpResponsedMessageArr) {
        if (httpResponsedMessageArr != null && httpResponsedMessageArr.length > 0) {
            this.a.a.dispatchResponsedMessage(httpResponsedMessageArr[0]);
        }
    }
}

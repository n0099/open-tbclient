package com.baidu.live.n;

import android.text.TextUtils;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class b extends BdBaseModel {
    private a aRh;
    private HttpMessageListener aRi;
    private HttpMessageListener aRj;
    private HttpMessageListener aRk;
    private HttpMessageListener aRl;
    private TbPageContext mPageContext;

    /* loaded from: classes3.dex */
    public interface a {
        void DY();
    }

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.aRi = new HttpMessageListener(1021031) { // from class: com.baidu.live.n.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021031) {
                    int statusCode = httpResponsedMessage.getStatusCode();
                    if (httpResponsedMessage.getOrginalMessage() instanceof com.baidu.live.n.a) {
                        if (statusCode != 200 || !(httpResponsedMessage instanceof JsonHttpResponsedMessage)) {
                            b.this.mPageContext.showToast(httpResponsedMessage.getErrorString());
                        } else if (httpResponsedMessage.getError() == 0) {
                            b.this.mPageContext.showToast(a.i.sdk_person_operation_success);
                        } else {
                            b.this.mPageContext.showToast(httpResponsedMessage.getErrorString());
                        }
                    }
                }
            }
        };
        this.aRj = new HttpMessageListener(1021058) { // from class: com.baidu.live.n.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021058) {
                    if (httpResponsedMessage.getStatusCode() != 200 || !(httpResponsedMessage instanceof JsonHttpResponsedMessage)) {
                        b.this.mPageContext.showToast(httpResponsedMessage.getErrorString());
                    } else if (httpResponsedMessage.getError() == 0) {
                        b.this.mPageContext.showToast(a.i.sdk_person_operation_success);
                    } else {
                        b.this.mPageContext.showToast(httpResponsedMessage.getErrorString());
                    }
                }
            }
        };
        this.aRk = new HttpMessageListener(1021059) { // from class: com.baidu.live.n.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021059) {
                    if (httpResponsedMessage.getStatusCode() != 200 || !(httpResponsedMessage instanceof JsonHttpResponsedMessage)) {
                        b.this.mPageContext.showToast(httpResponsedMessage.getErrorString());
                    } else if (httpResponsedMessage.getError() == 0) {
                        b.this.mPageContext.showToast(a.i.sdk_person_operation_success);
                    } else {
                        b.this.mPageContext.showToast(httpResponsedMessage.getErrorString());
                    }
                }
            }
        };
        this.aRl = new HttpMessageListener(1021060) { // from class: com.baidu.live.n.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021060) {
                    if (httpResponsedMessage.getStatusCode() != 200 || !(httpResponsedMessage instanceof JsonHttpResponsedMessage)) {
                        b.this.mPageContext.showToast(httpResponsedMessage.getErrorString());
                    } else if (httpResponsedMessage.getError() == 0) {
                        b.this.mPageContext.showToast(a.i.sdk_person_operation_success);
                        if (b.this.aRh != null) {
                            b.this.aRh.DY();
                        }
                    } else {
                        b.this.mPageContext.showToast(httpResponsedMessage.getErrorString());
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.aRi.setSelfListener(true);
        this.aRj.setSelfListener(true);
        this.aRk.setSelfListener(true);
        this.aRl.setSelfListener(true);
        registerListener(this.aRi);
        registerListener(this.aRj);
        registerListener(this.aRk);
        registerListener(this.aRl);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021031, com.baidu.live.a.ank);
        tbHttpMessageTask.setResponsedClass(JsonHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        TbHttpMessageTask tbHttpMessageTask2 = new TbHttpMessageTask(1021058, com.baidu.live.a.anm);
        tbHttpMessageTask2.setResponsedClass(JsonHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask2);
        TbHttpMessageTask tbHttpMessageTask3 = new TbHttpMessageTask(1021059, com.baidu.live.a.ann);
        tbHttpMessageTask3.setResponsedClass(JsonHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask3);
        TbHttpMessageTask tbHttpMessageTask4 = new TbHttpMessageTask(1021060, com.baidu.live.a.ano);
        tbHttpMessageTask4.setResponsedClass(JsonHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask4);
    }

    public void l(String str, String str2, String str3) {
        b(str, str2, str3, 1);
    }

    public void m(String str, String str2, String str3) {
        b(str, str2, str3, 2);
    }

    public void n(String str, String str2, String str3) {
        b(str, str2, str3, 8);
    }

    public void o(String str, String str2, String str3) {
        b(str, str2, str3, 9);
    }

    private void b(String str, String str2, String str3, int i) {
        if (!BdNetTypeUtil.isNetWorkAvailable() || TextUtils.isEmpty(str)) {
            this.mPageContext.showToast(this.mPageContext.getResources().getString(a.i.sdk_no_network));
            return;
        }
        com.baidu.live.n.a aVar = new com.baidu.live.n.a(i);
        aVar.addParam("block_user_id", str);
        aVar.addParam("block_group_id", str2);
        aVar.addParam("live_id", str3);
        aVar.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        this.mPageContext.sendMessage(aVar);
    }

    public void ag(String str, String str2) {
        if (!BdNetTypeUtil.isNetWorkAvailable() || TextUtils.isEmpty(str)) {
            this.mPageContext.showToast(this.mPageContext.getResources().getString(a.i.sdk_no_network));
            return;
        }
        HttpMessage httpMessage = new HttpMessage(1021058);
        httpMessage.addParam("admin_id", str);
        httpMessage.addParam("live_id", str2);
        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        this.mPageContext.sendMessage(httpMessage);
    }

    public void ah(String str, String str2) {
        if (!BdNetTypeUtil.isNetWorkAvailable() || TextUtils.isEmpty(str)) {
            this.mPageContext.showToast(this.mPageContext.getResources().getString(a.i.sdk_no_network));
            return;
        }
        HttpMessage httpMessage = new HttpMessage(1021059);
        httpMessage.addParam("admin_id", str);
        httpMessage.addParam("live_id", str2);
        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        this.mPageContext.sendMessage(httpMessage);
    }

    public void ai(String str, String str2) {
        if (!BdNetTypeUtil.isNetWorkAvailable() || TextUtils.isEmpty(str)) {
            this.mPageContext.showToast(this.mPageContext.getResources().getString(a.i.sdk_no_network));
            return;
        }
        HttpMessage httpMessage = new HttpMessage(1021060);
        httpMessage.addParam("anchor_id", str);
        httpMessage.addParam("live_id", str2);
        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        this.mPageContext.sendMessage(httpMessage);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return false;
    }

    public void a(a aVar) {
        this.aRh = aVar;
    }
}

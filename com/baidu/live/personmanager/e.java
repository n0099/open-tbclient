package com.baidu.live.personmanager;

import android.text.TextUtils;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
/* loaded from: classes10.dex */
public class e extends BdBaseModel {
    private b btM;
    private a btN;
    private HttpMessageListener btO;
    private HttpMessageListener btP;
    private HttpMessageListener btQ;
    private HttpMessageListener btR;
    private HttpMessageListener btS;
    private TbPageContext mPageContext;

    /* loaded from: classes10.dex */
    public interface a {
        void NE();

        void onFail(String str);
    }

    /* loaded from: classes10.dex */
    public interface b {
        void NF();
    }

    public e(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.btO = new HttpMessageListener(1021031) { // from class: com.baidu.live.personmanager.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021031) {
                    int statusCode = httpResponsedMessage.getStatusCode();
                    if (httpResponsedMessage.getOrginalMessage() instanceof c) {
                        if (statusCode != 200 || !(httpResponsedMessage instanceof JsonHttpResponsedMessage)) {
                            e.this.mPageContext.showToast(httpResponsedMessage.getErrorString());
                        } else if (httpResponsedMessage.getError() == 0) {
                            e.this.mPageContext.showToast(a.h.sdk_person_operation_success);
                        } else {
                            e.this.mPageContext.showToast(httpResponsedMessage.getErrorString());
                        }
                    }
                }
            }
        };
        this.btP = new HttpMessageListener(1021058) { // from class: com.baidu.live.personmanager.e.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021058) {
                    if (httpResponsedMessage.getStatusCode() != 200 || !(httpResponsedMessage instanceof JsonHttpResponsedMessage)) {
                        e.this.mPageContext.showToast(httpResponsedMessage.getErrorString());
                    } else if (httpResponsedMessage.getError() == 0) {
                        e.this.mPageContext.showToast(a.h.sdk_person_operation_success);
                    } else {
                        e.this.mPageContext.showToast(httpResponsedMessage.getErrorString());
                    }
                }
            }
        };
        this.btQ = new HttpMessageListener(1021059) { // from class: com.baidu.live.personmanager.e.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021059) {
                    if (httpResponsedMessage.getStatusCode() != 200 || !(httpResponsedMessage instanceof JsonHttpResponsedMessage)) {
                        e.this.mPageContext.showToast(httpResponsedMessage.getErrorString());
                    } else if (httpResponsedMessage.getError() == 0) {
                        e.this.mPageContext.showToast(a.h.sdk_person_operation_success);
                    } else {
                        e.this.mPageContext.showToast(httpResponsedMessage.getErrorString());
                    }
                }
            }
        };
        this.btR = new HttpMessageListener(1021060) { // from class: com.baidu.live.personmanager.e.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021060) {
                    if (httpResponsedMessage.getStatusCode() != 200 || !(httpResponsedMessage instanceof JsonHttpResponsedMessage)) {
                        e.this.mPageContext.showToast(httpResponsedMessage.getErrorString());
                    } else if (httpResponsedMessage.getError() == 0) {
                        e.this.mPageContext.showToast(a.h.sdk_person_operation_success);
                        if (e.this.btM != null) {
                            e.this.btM.NF();
                        }
                    } else {
                        e.this.mPageContext.showToast(httpResponsedMessage.getErrorString());
                    }
                }
            }
        };
        this.btS = new HttpMessageListener(1021030) { // from class: com.baidu.live.personmanager.e.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021030 && e.this.btN != null) {
                    if (httpResponsedMessage.getStatusCode() != 200 || !(httpResponsedMessage instanceof JsonHttpResponsedMessage)) {
                        e.this.btN.onFail(httpResponsedMessage.getErrorString());
                    } else if (httpResponsedMessage.getError() == 0) {
                        e.this.btN.NE();
                    } else {
                        e.this.btN.onFail(httpResponsedMessage.getErrorString());
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.btO.setSelfListener(true);
        this.btP.setSelfListener(true);
        this.btQ.setSelfListener(true);
        this.btR.setSelfListener(true);
        this.btS.setSelfListener(true);
        registerListener(this.btS);
        registerListener(this.btO);
        registerListener(this.btP);
        registerListener(this.btQ);
        registerListener(this.btR);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021031, com.baidu.live.b.awa);
        tbHttpMessageTask.setResponsedClass(JsonHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        TbHttpMessageTask tbHttpMessageTask2 = new TbHttpMessageTask(1021058, com.baidu.live.b.awb);
        tbHttpMessageTask2.setResponsedClass(JsonHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask2);
        TbHttpMessageTask tbHttpMessageTask3 = new TbHttpMessageTask(1021059, com.baidu.live.b.awc);
        tbHttpMessageTask3.setResponsedClass(JsonHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask3);
        TbHttpMessageTask tbHttpMessageTask4 = new TbHttpMessageTask(1021060, com.baidu.live.b.awe);
        tbHttpMessageTask4.setResponsedClass(JsonHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask4);
        TbHttpMessageTask tbHttpMessageTask5 = new TbHttpMessageTask(1021030, com.baidu.live.b.avZ);
        tbHttpMessageTask5.setResponsedClass(JsonHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask5);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0038, code lost:
        if (java.lang.Long.parseLong(r7) <= 0) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void aF(String str, String str2) {
        boolean z = true;
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            if (this.btN != null) {
                this.btN.onFail(this.mPageContext.getResources().getString(a.h.sdk_no_network));
                return;
            }
            return;
        }
        boolean z2 = false;
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, "null")) {
            z2 = true;
        }
        if (!z2) {
            try {
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        z = z2;
        if (z) {
            if (this.btN != null) {
                this.btN.onFail(this.mPageContext.getResources().getString(a.h.ala_report_failed));
                return;
            }
            return;
        }
        HttpMessage httpMessage = new HttpMessage(1021030);
        httpMessage.addParam("target_user_id", str);
        httpMessage.addParam("tipoff_reason", str2);
        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        this.mPageContext.sendMessage(httpMessage);
    }

    public void c(String str, String str2, String str3, int i) {
        a(str, str2, str3, 1, i);
    }

    public void d(String str, String str2, String str3, int i) {
        a(str, str2, str3, 2, i);
    }

    public void e(String str, String str2, String str3, int i) {
        a(str, str2, str3, 8, i);
    }

    public void f(String str, String str2, String str3, int i) {
        a(str, str2, str3, 9, i);
    }

    private void a(String str, String str2, String str3, int i, int i2) {
        if (!BdNetTypeUtil.isNetWorkAvailable() || TextUtils.isEmpty(str)) {
            this.mPageContext.showToast(this.mPageContext.getResources().getString(a.h.sdk_no_network));
            return;
        }
        c cVar = new c(i);
        cVar.addParam("block_user_id", str);
        cVar.addParam("block_group_id", str2);
        cVar.addParam("live_id", str3);
        cVar.addParam("check_mysterious_man", i2);
        cVar.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        this.mPageContext.sendMessage(cVar);
    }

    public void b(String str, String str2, int i) {
        if (!BdNetTypeUtil.isNetWorkAvailable() || TextUtils.isEmpty(str)) {
            this.mPageContext.showToast(this.mPageContext.getResources().getString(a.h.sdk_no_network));
            return;
        }
        HttpMessage httpMessage = new HttpMessage(1021058);
        httpMessage.addParam("admin_id", str);
        httpMessage.addParam("live_id", str2);
        httpMessage.addParam("check_mysterious_man", i);
        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        this.mPageContext.sendMessage(httpMessage);
    }

    public void c(String str, String str2, int i) {
        if (!BdNetTypeUtil.isNetWorkAvailable() || TextUtils.isEmpty(str)) {
            this.mPageContext.showToast(this.mPageContext.getResources().getString(a.h.sdk_no_network));
            return;
        }
        HttpMessage httpMessage = new HttpMessage(1021059);
        httpMessage.addParam("admin_id", str);
        httpMessage.addParam("live_id", str2);
        httpMessage.addParam("check_mysterious_man", i);
        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        this.mPageContext.sendMessage(httpMessage);
    }

    public void d(String str, String str2, int i) {
        if (!BdNetTypeUtil.isNetWorkAvailable() || TextUtils.isEmpty(str)) {
            this.mPageContext.showToast(this.mPageContext.getResources().getString(a.h.sdk_no_network));
            return;
        }
        HttpMessage httpMessage = new HttpMessage(1021060);
        httpMessage.addParam("anchor_id", str);
        httpMessage.addParam("live_id", str2);
        httpMessage.addParam("check_mysterious_man", i);
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

    public void onDestroy() {
        cancelMessage();
        MessageManager.getInstance().unRegisterTask(1021031);
        MessageManager.getInstance().unRegisterTask(1021058);
        MessageManager.getInstance().unRegisterTask(1021059);
        MessageManager.getInstance().unRegisterTask(1021060);
        MessageManager.getInstance().unRegisterTask(1021030);
    }

    public void a(b bVar) {
        this.btM = bVar;
    }

    public void a(a aVar) {
        this.btN = aVar;
    }
}

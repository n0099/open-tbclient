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
/* loaded from: classes4.dex */
public class b extends BdBaseModel {
    private HttpMessageListener bjA;
    private HttpMessageListener bjB;
    private HttpMessageListener bjC;
    private HttpMessageListener bjD;
    private HttpMessageListener bjE;
    private InterfaceC0184b bjy;
    private a bjz;
    private TbPageContext mPageContext;

    /* loaded from: classes4.dex */
    public interface a {
        void MI();

        void onFail(String str);
    }

    /* renamed from: com.baidu.live.personmanager.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0184b {
        void MJ();
    }

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.bjA = new HttpMessageListener(1021031) { // from class: com.baidu.live.personmanager.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021031) {
                    int statusCode = httpResponsedMessage.getStatusCode();
                    if (httpResponsedMessage.getOrginalMessage() instanceof com.baidu.live.personmanager.a) {
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
        this.bjB = new HttpMessageListener(1021058) { // from class: com.baidu.live.personmanager.b.2
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
        this.bjC = new HttpMessageListener(1021059) { // from class: com.baidu.live.personmanager.b.3
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
        this.bjD = new HttpMessageListener(1021060) { // from class: com.baidu.live.personmanager.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021060) {
                    if (httpResponsedMessage.getStatusCode() != 200 || !(httpResponsedMessage instanceof JsonHttpResponsedMessage)) {
                        b.this.mPageContext.showToast(httpResponsedMessage.getErrorString());
                    } else if (httpResponsedMessage.getError() == 0) {
                        b.this.mPageContext.showToast(a.i.sdk_person_operation_success);
                        if (b.this.bjy != null) {
                            b.this.bjy.MJ();
                        }
                    } else {
                        b.this.mPageContext.showToast(httpResponsedMessage.getErrorString());
                    }
                }
            }
        };
        this.bjE = new HttpMessageListener(1021030) { // from class: com.baidu.live.personmanager.b.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021030 && b.this.bjz != null) {
                    if (httpResponsedMessage.getStatusCode() != 200 || !(httpResponsedMessage instanceof JsonHttpResponsedMessage)) {
                        b.this.bjz.onFail(httpResponsedMessage.getErrorString());
                    } else if (httpResponsedMessage.getError() == 0) {
                        b.this.bjz.MI();
                    } else {
                        b.this.bjz.onFail(httpResponsedMessage.getErrorString());
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.bjA.setSelfListener(true);
        this.bjB.setSelfListener(true);
        this.bjC.setSelfListener(true);
        this.bjD.setSelfListener(true);
        this.bjE.setSelfListener(true);
        registerListener(this.bjE);
        registerListener(this.bjA);
        registerListener(this.bjB);
        registerListener(this.bjC);
        registerListener(this.bjD);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021031, com.baidu.live.a.ayY);
        tbHttpMessageTask.setResponsedClass(JsonHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        TbHttpMessageTask tbHttpMessageTask2 = new TbHttpMessageTask(1021058, com.baidu.live.a.aza);
        tbHttpMessageTask2.setResponsedClass(JsonHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask2);
        TbHttpMessageTask tbHttpMessageTask3 = new TbHttpMessageTask(1021059, com.baidu.live.a.azb);
        tbHttpMessageTask3.setResponsedClass(JsonHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask3);
        TbHttpMessageTask tbHttpMessageTask4 = new TbHttpMessageTask(1021060, com.baidu.live.a.azc);
        tbHttpMessageTask4.setResponsedClass(JsonHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask4);
        TbHttpMessageTask tbHttpMessageTask5 = new TbHttpMessageTask(1021030, com.baidu.live.a.ayX);
        tbHttpMessageTask5.setResponsedClass(JsonHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask5);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0038, code lost:
        if (java.lang.Long.parseLong(r7) <= 0) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void az(String str, String str2) {
        boolean z = true;
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            if (this.bjz != null) {
                this.bjz.onFail(this.mPageContext.getResources().getString(a.i.sdk_no_network));
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
            if (this.bjz != null) {
                this.bjz.onFail(this.mPageContext.getResources().getString(a.i.ala_report_failed));
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

    public void p(String str, String str2, String str3) {
        b(str, str2, str3, 1);
    }

    public void q(String str, String str2, String str3) {
        b(str, str2, str3, 2);
    }

    public void r(String str, String str2, String str3) {
        b(str, str2, str3, 8);
    }

    public void s(String str, String str2, String str3) {
        b(str, str2, str3, 9);
    }

    private void b(String str, String str2, String str3, int i) {
        if (!BdNetTypeUtil.isNetWorkAvailable() || TextUtils.isEmpty(str)) {
            this.mPageContext.showToast(this.mPageContext.getResources().getString(a.i.sdk_no_network));
            return;
        }
        com.baidu.live.personmanager.a aVar = new com.baidu.live.personmanager.a(i);
        aVar.addParam("block_user_id", str);
        aVar.addParam("block_group_id", str2);
        aVar.addParam("live_id", str3);
        aVar.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        this.mPageContext.sendMessage(aVar);
    }

    public void aA(String str, String str2) {
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

    public void aB(String str, String str2) {
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

    public void aC(String str, String str2) {
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

    public void onDestroy() {
        cancelMessage();
        MessageManager.getInstance().unRegisterTask(1021031);
        MessageManager.getInstance().unRegisterTask(1021058);
        MessageManager.getInstance().unRegisterTask(1021059);
        MessageManager.getInstance().unRegisterTask(1021060);
        MessageManager.getInstance().unRegisterTask(1021030);
    }

    public void a(InterfaceC0184b interfaceC0184b) {
        this.bjy = interfaceC0184b;
    }

    public void a(a aVar) {
        this.bjz = aVar;
    }
}

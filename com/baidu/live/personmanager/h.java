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
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
/* loaded from: classes10.dex */
public class h extends BdBaseModel {
    private HttpMessageListener byT;
    private HttpMessageListener byU;
    private HttpMessageListener byV;
    private a bza;
    private TbPageContext mPageContext;

    /* loaded from: classes10.dex */
    public interface a {
    }

    public h(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.byT = new HttpMessageListener(1031049) { // from class: com.baidu.live.personmanager.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1031049 && httpResponsedMessage.getOrginalMessage().getTag() == h.this.getUniqueId()) {
                    int statusCode = httpResponsedMessage.getStatusCode();
                    if (httpResponsedMessage instanceof YuyinPersonManagerResponseMessage) {
                        if (statusCode != 200 || !(httpResponsedMessage instanceof YuyinPersonManagerResponseMessage)) {
                            h.this.mPageContext.showToast(((YuyinPersonManagerResponseMessage) httpResponsedMessage).getUserMsg());
                        } else if (httpResponsedMessage.getError() == 0) {
                            h.this.mPageContext.showToast(a.h.sdk_person_operation_success);
                        } else {
                            h.this.mPageContext.showToast(((YuyinPersonManagerResponseMessage) httpResponsedMessage).getUserMsg());
                        }
                    }
                }
            }
        };
        this.byU = new HttpMessageListener(1031050) { // from class: com.baidu.live.personmanager.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1031050 && httpResponsedMessage.getOrginalMessage().getTag() == h.this.getUniqueId()) {
                    if (httpResponsedMessage.getStatusCode() != 200 || !(httpResponsedMessage instanceof YuyinPersonManagerResponseMessage)) {
                        h.this.mPageContext.showToast(((YuyinPersonManagerResponseMessage) httpResponsedMessage).getUserMsg());
                    } else if (httpResponsedMessage.getError() == 0) {
                        h.this.mPageContext.showToast(a.h.sdk_person_operation_success);
                    } else {
                        h.this.mPageContext.showToast(((YuyinPersonManagerResponseMessage) httpResponsedMessage).getUserMsg());
                    }
                }
            }
        };
        this.byV = new HttpMessageListener(1031051) { // from class: com.baidu.live.personmanager.h.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1031051 && httpResponsedMessage.getOrginalMessage().getTag() == h.this.getUniqueId()) {
                    if (httpResponsedMessage.getStatusCode() != 200 || !(httpResponsedMessage instanceof YuyinPersonManagerResponseMessage)) {
                        h.this.mPageContext.showToast(((YuyinPersonManagerResponseMessage) httpResponsedMessage).getUserMsg());
                    } else if (httpResponsedMessage.getError() == 0) {
                        h.this.mPageContext.showToast(a.h.sdk_person_operation_success);
                    } else {
                        h.this.mPageContext.showToast(((YuyinPersonManagerResponseMessage) httpResponsedMessage).getUserMsg());
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        registerListener(this.byT);
        registerListener(this.byU);
        registerListener(this.byV);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031049, com.baidu.live.a.axp);
        tbHttpMessageTask.setResponsedClass(YuyinPersonManagerResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        TbHttpMessageTask tbHttpMessageTask2 = new TbHttpMessageTask(1031050, com.baidu.live.a.axq);
        tbHttpMessageTask2.setResponsedClass(YuyinPersonManagerResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask2);
        TbHttpMessageTask tbHttpMessageTask3 = new TbHttpMessageTask(1031051, com.baidu.live.a.axr);
        tbHttpMessageTask3.setResponsedClass(YuyinPersonManagerResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask3);
    }

    public void x(String str, String str2, String str3) {
        g(str, str2, str3, 1);
    }

    public void y(String str, String str2, String str3) {
        g(str, str2, str3, 3);
    }

    public void z(String str, String str2, String str3) {
        g(str, str2, str3, 8);
    }

    public void A(String str, String str2, String str3) {
        g(str, str2, str3, 9);
    }

    private void g(String str, String str2, String str3, int i) {
        if (!BdNetTypeUtil.isNetWorkAvailable() || TextUtils.isEmpty(str)) {
            this.mPageContext.showToast(this.mPageContext.getResources().getString(a.h.sdk_no_network));
            return;
        }
        g gVar = new g(i);
        gVar.addParam("block_user_uk", ExtraParamsManager.getEncryptionUserId(str));
        gVar.addParam("block_group_id", str2);
        gVar.addParam("live_id", str3);
        gVar.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        this.mPageContext.sendMessage(gVar);
    }

    public void B(String str, String str2, String str3) {
        if (!BdNetTypeUtil.isNetWorkAvailable() || TextUtils.isEmpty(str)) {
            this.mPageContext.showToast(this.mPageContext.getResources().getString(a.h.sdk_no_network));
            return;
        }
        HttpMessage httpMessage = new HttpMessage(1031050);
        httpMessage.addParam("uk", ExtraParamsManager.getEncryptionUserId(str));
        httpMessage.addParam("room_id", str2);
        httpMessage.addParam("group_id", str3);
        this.mPageContext.sendMessage(httpMessage);
    }

    public void C(String str, String str2, String str3) {
        if (!BdNetTypeUtil.isNetWorkAvailable() || TextUtils.isEmpty(str)) {
            this.mPageContext.showToast(this.mPageContext.getResources().getString(a.h.sdk_no_network));
            return;
        }
        HttpMessage httpMessage = new HttpMessage(1031051);
        httpMessage.addParam("uk", ExtraParamsManager.getEncryptionUserId(str));
        httpMessage.addParam("room_id", str2);
        httpMessage.addParam("group_id", str3);
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
        this.bza = aVar;
    }
}

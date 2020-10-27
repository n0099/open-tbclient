package com.baidu.live.m;

import android.text.TextUtils;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.widget.bdswitchview.BdSwitchView;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
/* loaded from: classes4.dex */
public class d extends BdBaseModel {
    private a bnm;
    private String bnn;
    private TbHttpMessageTask bno;
    private String bnp;
    private TbHttpMessageTask bnq;
    private HttpMessageListener bnr;
    private HttpMessageListener bns;
    private BdSwitchView.SwitchState mState;

    /* loaded from: classes4.dex */
    public interface a {
        void a(BdSwitchView.SwitchState switchState, int i);

        void cR(String str);
    }

    public d(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.bnr = new HttpMessageListener(1021028) { // from class: com.baidu.live.m.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021028 && d.this.bnm != null) {
                    if (httpResponsedMessage.getStatusCode() != 200 || !(httpResponsedMessage instanceof JsonHttpResponsedMessage)) {
                        d.this.bnm.cR(httpResponsedMessage.getErrorString());
                    } else if (httpResponsedMessage.getError() == 0) {
                        d.this.bnm.a(d.this.mState, 1);
                    } else {
                        d.this.bnm.cR(httpResponsedMessage.getErrorString());
                    }
                }
            }
        };
        this.bns = new HttpMessageListener(1021032) { // from class: com.baidu.live.m.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021032 && d.this.bnm != null) {
                    if (httpResponsedMessage.getStatusCode() != 200 || !(httpResponsedMessage instanceof JsonHttpResponsedMessage)) {
                        d.this.bnm.cR(httpResponsedMessage.getErrorString());
                    } else if (httpResponsedMessage.getError() == 0) {
                        d.this.bnm.a(d.this.mState, 2);
                    } else {
                        d.this.bnm.cR(httpResponsedMessage.getErrorString());
                    }
                }
            }
        };
        NR();
        this.bnr.setTag(getUniqueId());
        this.bns.setTag(getUniqueId());
        registerListener(this.bnr);
        registerListener(this.bns);
    }

    private void NR() {
        this.bnn = TbConfig.SERVER_ADDRESS + "ala/relation/switchPush";
        this.bno = new TbHttpMessageTask(1021028, this.bnn);
        this.bno.setResponsedClass(JsonHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(this.bno);
        this.bnp = TbConfig.SERVER_ADDRESS + "ala/relation/globalSwitchPush";
        this.bnq = new TbHttpMessageTask(1021032, this.bnp);
        this.bnq.setResponsedClass(JsonHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(this.bnq);
    }

    public boolean a(BdSwitchView.SwitchState switchState, String str, int i) {
        this.mState = switchState;
        if (BdNetTypeUtil.isNetworkAvailableForImmediately()) {
            HttpMessage httpMessage = null;
            if (i == 1) {
                httpMessage = new HttpMessage(1021028);
            } else if (i == 2) {
                httpMessage = new HttpMessage(1021032);
            }
            if (switchState == BdSwitchView.SwitchState.ON) {
                httpMessage.addParam("switch", 1);
            } else if (switchState != BdSwitchView.SwitchState.OFF) {
                return false;
            } else {
                httpMessage.addParam("switch", 2);
            }
            httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
            if (!TextUtils.isEmpty(str)) {
                httpMessage.addParam("to_user_id", str);
            }
            sendMessage(httpMessage);
            return true;
        }
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }
}

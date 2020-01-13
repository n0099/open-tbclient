package com.baidu.live.j;

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
/* loaded from: classes2.dex */
public class d extends BdBaseModel {
    private a asP;
    private String asQ;
    private TbHttpMessageTask asR;
    private String asS;
    private TbHttpMessageTask asT;
    private HttpMessageListener asU;
    private HttpMessageListener asV;
    private BdSwitchView.SwitchState mState;

    /* loaded from: classes2.dex */
    public interface a {
        void a(BdSwitchView.SwitchState switchState, int i);

        void br(String str);
    }

    public d(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.asU = new HttpMessageListener(1021028) { // from class: com.baidu.live.j.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021028 && d.this.asP != null) {
                    if (httpResponsedMessage.getStatusCode() != 200 || !(httpResponsedMessage instanceof JsonHttpResponsedMessage)) {
                        d.this.asP.br(httpResponsedMessage.getErrorString());
                    } else if (httpResponsedMessage.getError() == 0) {
                        d.this.asP.a(d.this.mState, 1);
                    } else {
                        d.this.asP.br(httpResponsedMessage.getErrorString());
                    }
                }
            }
        };
        this.asV = new HttpMessageListener(1021032) { // from class: com.baidu.live.j.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021032 && d.this.asP != null) {
                    if (httpResponsedMessage.getStatusCode() != 200 || !(httpResponsedMessage instanceof JsonHttpResponsedMessage)) {
                        d.this.asP.br(httpResponsedMessage.getErrorString());
                    } else if (httpResponsedMessage.getError() == 0) {
                        d.this.asP.a(d.this.mState, 2);
                    } else {
                        d.this.asP.br(httpResponsedMessage.getErrorString());
                    }
                }
            }
        };
        wG();
        this.asU.setTag(getUniqueId());
        this.asV.setTag(getUniqueId());
        registerListener(this.asU);
        registerListener(this.asV);
    }

    private void wG() {
        this.asQ = TbConfig.SERVER_ADDRESS + "ala/relation/switchPush";
        this.asR = new TbHttpMessageTask(1021028, this.asQ);
        this.asR.setResponsedClass(JsonHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(this.asR);
        this.asS = TbConfig.SERVER_ADDRESS + "ala/relation/globalSwitchPush";
        this.asT = new TbHttpMessageTask(1021032, this.asS);
        this.asT.setResponsedClass(JsonHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(this.asT);
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

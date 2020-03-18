package com.baidu.live.k;

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
/* loaded from: classes3.dex */
public class d extends BdBaseModel {
    private a axl;
    private String axm;
    private TbHttpMessageTask axn;
    private String axo;
    private TbHttpMessageTask axp;
    private HttpMessageListener axq;
    private HttpMessageListener axr;
    private BdSwitchView.SwitchState mState;

    /* loaded from: classes3.dex */
    public interface a {
        void a(BdSwitchView.SwitchState switchState, int i);

        void bt(String str);
    }

    public d(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.axq = new HttpMessageListener(1021028) { // from class: com.baidu.live.k.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021028 && d.this.axl != null) {
                    if (httpResponsedMessage.getStatusCode() != 200 || !(httpResponsedMessage instanceof JsonHttpResponsedMessage)) {
                        d.this.axl.bt(httpResponsedMessage.getErrorString());
                    } else if (httpResponsedMessage.getError() == 0) {
                        d.this.axl.a(d.this.mState, 1);
                    } else {
                        d.this.axl.bt(httpResponsedMessage.getErrorString());
                    }
                }
            }
        };
        this.axr = new HttpMessageListener(1021032) { // from class: com.baidu.live.k.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021032 && d.this.axl != null) {
                    if (httpResponsedMessage.getStatusCode() != 200 || !(httpResponsedMessage instanceof JsonHttpResponsedMessage)) {
                        d.this.axl.bt(httpResponsedMessage.getErrorString());
                    } else if (httpResponsedMessage.getError() == 0) {
                        d.this.axl.a(d.this.mState, 2);
                    } else {
                        d.this.axl.bt(httpResponsedMessage.getErrorString());
                    }
                }
            }
        };
        zd();
        this.axq.setTag(getUniqueId());
        this.axr.setTag(getUniqueId());
        registerListener(this.axq);
        registerListener(this.axr);
    }

    private void zd() {
        this.axm = TbConfig.SERVER_ADDRESS + "ala/relation/switchPush";
        this.axn = new TbHttpMessageTask(1021028, this.axm);
        this.axn.setResponsedClass(JsonHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(this.axn);
        this.axo = TbConfig.SERVER_ADDRESS + "ala/relation/globalSwitchPush";
        this.axp = new TbHttpMessageTask(1021032, this.axo);
        this.axp.setResponsedClass(JsonHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(this.axp);
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

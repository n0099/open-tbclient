package com.baidu.live.o;

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
    private a bsc;
    private String bsd;
    private TbHttpMessageTask bse;
    private String bsf;
    private TbHttpMessageTask bsg;
    private HttpMessageListener bsh;
    private HttpMessageListener bsi;
    private BdSwitchView.SwitchState mState;

    /* loaded from: classes4.dex */
    public interface a {
        void a(BdSwitchView.SwitchState switchState, int i);

        void cW(String str);
    }

    public d(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.bsh = new HttpMessageListener(1021028) { // from class: com.baidu.live.o.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021028 && d.this.bsc != null) {
                    if (httpResponsedMessage.getStatusCode() != 200 || !(httpResponsedMessage instanceof JsonHttpResponsedMessage)) {
                        d.this.bsc.cW(httpResponsedMessage.getErrorString());
                    } else if (httpResponsedMessage.getError() == 0) {
                        d.this.bsc.a(d.this.mState, 1);
                    } else {
                        d.this.bsc.cW(httpResponsedMessage.getErrorString());
                    }
                }
            }
        };
        this.bsi = new HttpMessageListener(1021032) { // from class: com.baidu.live.o.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021032 && d.this.bsc != null) {
                    if (httpResponsedMessage.getStatusCode() != 200 || !(httpResponsedMessage instanceof JsonHttpResponsedMessage)) {
                        d.this.bsc.cW(httpResponsedMessage.getErrorString());
                    } else if (httpResponsedMessage.getError() == 0) {
                        d.this.bsc.a(d.this.mState, 2);
                    } else {
                        d.this.bsc.cW(httpResponsedMessage.getErrorString());
                    }
                }
            }
        };
        Qb();
        this.bsh.setTag(getUniqueId());
        this.bsi.setTag(getUniqueId());
        registerListener(this.bsh);
        registerListener(this.bsi);
    }

    private void Qb() {
        this.bsd = TbConfig.SERVER_ADDRESS + "ala/relation/switchPush";
        this.bse = new TbHttpMessageTask(1021028, this.bsd);
        this.bse.setResponsedClass(JsonHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(this.bse);
        this.bsf = TbConfig.SERVER_ADDRESS + "ala/relation/globalSwitchPush";
        this.bsg = new TbHttpMessageTask(1021032, this.bsf);
        this.bsg.setResponsedClass(JsonHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(this.bsg);
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

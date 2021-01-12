package com.baidu.live.p;

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
/* loaded from: classes10.dex */
public class e extends BdBaseModel {
    private a brZ;
    private String bsa;
    private TbHttpMessageTask bsb;
    private String bsc;
    private TbHttpMessageTask bsd;
    private HttpMessageListener bse;
    private HttpMessageListener bsf;
    private BdSwitchView.SwitchState mState;

    /* loaded from: classes10.dex */
    public interface a {
        void a(BdSwitchView.SwitchState switchState, int i);

        void cP(String str);
    }

    public e(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.bse = new HttpMessageListener(1021028) { // from class: com.baidu.live.p.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021028 && e.this.brZ != null) {
                    if (httpResponsedMessage.getStatusCode() != 200 || !(httpResponsedMessage instanceof JsonHttpResponsedMessage)) {
                        e.this.brZ.cP(httpResponsedMessage.getErrorString());
                    } else if (httpResponsedMessage.getError() == 0) {
                        e.this.brZ.a(e.this.mState, 1);
                    } else {
                        e.this.brZ.cP(httpResponsedMessage.getErrorString());
                    }
                }
            }
        };
        this.bsf = new HttpMessageListener(1021032) { // from class: com.baidu.live.p.e.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021032 && e.this.brZ != null) {
                    if (httpResponsedMessage.getStatusCode() != 200 || !(httpResponsedMessage instanceof JsonHttpResponsedMessage)) {
                        e.this.brZ.cP(httpResponsedMessage.getErrorString());
                    } else if (httpResponsedMessage.getError() == 0) {
                        e.this.brZ.a(e.this.mState, 2);
                    } else {
                        e.this.brZ.cP(httpResponsedMessage.getErrorString());
                    }
                }
            }
        };
        Nj();
        this.bse.setTag(getUniqueId());
        this.bsf.setTag(getUniqueId());
        registerListener(this.bse);
        registerListener(this.bsf);
    }

    private void Nj() {
        this.bsa = TbConfig.SERVER_ADDRESS + "ala/relation/switchPush";
        this.bsb = new TbHttpMessageTask(1021028, this.bsa);
        this.bsb.setResponsedClass(JsonHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(this.bsb);
        this.bsc = TbConfig.SERVER_ADDRESS + "ala/relation/globalSwitchPush";
        this.bsd = new TbHttpMessageTask(1021032, this.bsc);
        this.bsd.setResponsedClass(JsonHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(this.bsd);
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

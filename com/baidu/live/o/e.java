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
/* loaded from: classes11.dex */
public class e extends BdBaseModel {
    private a bvD;
    private String bvE;
    private TbHttpMessageTask bvF;
    private String bvG;
    private TbHttpMessageTask bvH;
    private HttpMessageListener bvI;
    private HttpMessageListener bvJ;
    private BdSwitchView.SwitchState mState;

    /* loaded from: classes11.dex */
    public interface a {
        void a(BdSwitchView.SwitchState switchState, int i);

        void cP(String str);
    }

    public e(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.bvI = new HttpMessageListener(1021028) { // from class: com.baidu.live.o.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021028 && e.this.bvD != null) {
                    if (httpResponsedMessage.getStatusCode() != 200 || !(httpResponsedMessage instanceof JsonHttpResponsedMessage)) {
                        e.this.bvD.cP(httpResponsedMessage.getErrorString());
                    } else if (httpResponsedMessage.getError() == 0) {
                        e.this.bvD.a(e.this.mState, 1);
                    } else {
                        e.this.bvD.cP(httpResponsedMessage.getErrorString());
                    }
                }
            }
        };
        this.bvJ = new HttpMessageListener(1021032) { // from class: com.baidu.live.o.e.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021032 && e.this.bvD != null) {
                    if (httpResponsedMessage.getStatusCode() != 200 || !(httpResponsedMessage instanceof JsonHttpResponsedMessage)) {
                        e.this.bvD.cP(httpResponsedMessage.getErrorString());
                    } else if (httpResponsedMessage.getError() == 0) {
                        e.this.bvD.a(e.this.mState, 2);
                    } else {
                        e.this.bvD.cP(httpResponsedMessage.getErrorString());
                    }
                }
            }
        };
        OI();
        this.bvI.setTag(getUniqueId());
        this.bvJ.setTag(getUniqueId());
        registerListener(this.bvI);
        registerListener(this.bvJ);
    }

    private void OI() {
        this.bvE = TbConfig.SERVER_ADDRESS + "ala/relation/switchPush";
        this.bvF = new TbHttpMessageTask(1021028, this.bvE);
        this.bvF.setResponsedClass(JsonHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(this.bvF);
        this.bvG = TbConfig.SERVER_ADDRESS + "ala/relation/globalSwitchPush";
        this.bvH = new TbHttpMessageTask(1021032, this.bvG);
        this.bvH.setResponsedClass(JsonHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(this.bvH);
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

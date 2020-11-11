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
    private a boF;
    private String boG;
    private TbHttpMessageTask boH;
    private String boI;
    private TbHttpMessageTask boJ;
    private HttpMessageListener boK;
    private HttpMessageListener boL;
    private BdSwitchView.SwitchState mState;

    /* loaded from: classes4.dex */
    public interface a {
        void a(BdSwitchView.SwitchState switchState, int i);

        void cR(String str);
    }

    public d(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.boK = new HttpMessageListener(1021028) { // from class: com.baidu.live.m.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021028 && d.this.boF != null) {
                    if (httpResponsedMessage.getStatusCode() != 200 || !(httpResponsedMessage instanceof JsonHttpResponsedMessage)) {
                        d.this.boF.cR(httpResponsedMessage.getErrorString());
                    } else if (httpResponsedMessage.getError() == 0) {
                        d.this.boF.a(d.this.mState, 1);
                    } else {
                        d.this.boF.cR(httpResponsedMessage.getErrorString());
                    }
                }
            }
        };
        this.boL = new HttpMessageListener(1021032) { // from class: com.baidu.live.m.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021032 && d.this.boF != null) {
                    if (httpResponsedMessage.getStatusCode() != 200 || !(httpResponsedMessage instanceof JsonHttpResponsedMessage)) {
                        d.this.boF.cR(httpResponsedMessage.getErrorString());
                    } else if (httpResponsedMessage.getError() == 0) {
                        d.this.boF.a(d.this.mState, 2);
                    } else {
                        d.this.boF.cR(httpResponsedMessage.getErrorString());
                    }
                }
            }
        };
        Or();
        this.boK.setTag(getUniqueId());
        this.boL.setTag(getUniqueId());
        registerListener(this.boK);
        registerListener(this.boL);
    }

    private void Or() {
        this.boG = TbConfig.SERVER_ADDRESS + "ala/relation/switchPush";
        this.boH = new TbHttpMessageTask(1021028, this.boG);
        this.boH.setResponsedClass(JsonHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(this.boH);
        this.boI = TbConfig.SERVER_ADDRESS + "ala/relation/globalSwitchPush";
        this.boJ = new TbHttpMessageTask(1021032, this.boI);
        this.boJ.setResponsedClass(JsonHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(this.boJ);
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

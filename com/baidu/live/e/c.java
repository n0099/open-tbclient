package com.baidu.live.e;

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
/* loaded from: classes6.dex */
public class c extends BdBaseModel {
    private HttpMessageListener akA;
    private a aku;
    private String akv;
    private TbHttpMessageTask akw;
    private String akx;
    private TbHttpMessageTask aky;
    private HttpMessageListener akz;
    private BdSwitchView.SwitchState mState;

    /* loaded from: classes6.dex */
    public interface a {
        void a(BdSwitchView.SwitchState switchState, int i);

        void bh(String str);
    }

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.akz = new HttpMessageListener(1021028) { // from class: com.baidu.live.e.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021028 && c.this.aku != null) {
                    if (httpResponsedMessage.getStatusCode() != 200 || !(httpResponsedMessage instanceof JsonHttpResponsedMessage)) {
                        c.this.aku.bh(httpResponsedMessage.getErrorString());
                    } else if (httpResponsedMessage.getError() == 0) {
                        c.this.aku.a(c.this.mState, 1);
                    } else {
                        c.this.aku.bh(httpResponsedMessage.getErrorString());
                    }
                }
            }
        };
        this.akA = new HttpMessageListener(1021032) { // from class: com.baidu.live.e.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021032 && c.this.aku != null) {
                    if (httpResponsedMessage.getStatusCode() != 200 || !(httpResponsedMessage instanceof JsonHttpResponsedMessage)) {
                        c.this.aku.bh(httpResponsedMessage.getErrorString());
                    } else if (httpResponsedMessage.getError() == 0) {
                        c.this.aku.a(c.this.mState, 2);
                    } else {
                        c.this.aku.bh(httpResponsedMessage.getErrorString());
                    }
                }
            }
        };
        ut();
        this.akz.setTag(getUniqueId());
        this.akA.setTag(getUniqueId());
        registerListener(this.akz);
        registerListener(this.akA);
    }

    private void ut() {
        this.akv = TbConfig.SERVER_ADDRESS + "ala/relation/switchPush";
        this.akw = new TbHttpMessageTask(1021028, this.akv);
        this.akw.setResponsedClass(JsonHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(this.akw);
        this.akx = TbConfig.SERVER_ADDRESS + "ala/relation/globalSwitchPush";
        this.aky = new TbHttpMessageTask(1021032, this.akx);
        this.aky.setResponsedClass(JsonHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(this.aky);
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

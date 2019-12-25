package com.baidu.live.i;

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
    private a asd;
    private String ase;
    private TbHttpMessageTask asf;
    private String asg;
    private TbHttpMessageTask ash;
    private HttpMessageListener asi;
    private HttpMessageListener asj;
    private BdSwitchView.SwitchState mState;

    /* loaded from: classes2.dex */
    public interface a {
        void a(BdSwitchView.SwitchState switchState, int i);

        void br(String str);
    }

    public d(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.asi = new HttpMessageListener(1021028) { // from class: com.baidu.live.i.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021028 && d.this.asd != null) {
                    if (httpResponsedMessage.getStatusCode() != 200 || !(httpResponsedMessage instanceof JsonHttpResponsedMessage)) {
                        d.this.asd.br(httpResponsedMessage.getErrorString());
                    } else if (httpResponsedMessage.getError() == 0) {
                        d.this.asd.a(d.this.mState, 1);
                    } else {
                        d.this.asd.br(httpResponsedMessage.getErrorString());
                    }
                }
            }
        };
        this.asj = new HttpMessageListener(1021032) { // from class: com.baidu.live.i.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021032 && d.this.asd != null) {
                    if (httpResponsedMessage.getStatusCode() != 200 || !(httpResponsedMessage instanceof JsonHttpResponsedMessage)) {
                        d.this.asd.br(httpResponsedMessage.getErrorString());
                    } else if (httpResponsedMessage.getError() == 0) {
                        d.this.asd.a(d.this.mState, 2);
                    } else {
                        d.this.asd.br(httpResponsedMessage.getErrorString());
                    }
                }
            }
        };
        wp();
        this.asi.setTag(getUniqueId());
        this.asj.setTag(getUniqueId());
        registerListener(this.asi);
        registerListener(this.asj);
    }

    private void wp() {
        this.ase = TbConfig.SERVER_ADDRESS + "ala/relation/switchPush";
        this.asf = new TbHttpMessageTask(1021028, this.ase);
        this.asf.setResponsedClass(JsonHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(this.asf);
        this.asg = TbConfig.SERVER_ADDRESS + "ala/relation/globalSwitchPush";
        this.ash = new TbHttpMessageTask(1021032, this.asg);
        this.ash.setResponsedClass(JsonHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(this.ash);
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

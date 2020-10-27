package com.baidu.live.tieba.yuyinala.d;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
/* loaded from: classes4.dex */
public class c extends BdBaseModel {
    private Context bAc;
    private a bAd;
    private HttpMessageListener bpc = new HttpMessageListener(1031041) { // from class: com.baidu.live.tieba.yuyinala.d.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1031041 && c.this.bAd != null) {
                if (httpResponsedMessage.getStatusCode() != 200 || !(httpResponsedMessage instanceof JsonHttpResponsedMessage)) {
                    c.this.bAd.onFail(httpResponsedMessage.getErrorString());
                } else if (httpResponsedMessage.getError() == 0) {
                    c.this.bAd.Ol();
                } else {
                    c.this.bAd.onFail(httpResponsedMessage.getErrorString());
                }
            }
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void Ol();

        void onFail(String str);
    }

    public c(Context context) {
        this.bAc = context;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031041, com.baidu.live.a.azK);
        tbHttpMessageTask.setResponsedClass(JsonHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        registerListener(this.bpc);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    public void onDestroy() {
        cancelMessage();
        MessageManager.getInstance().unRegisterTask(1031041);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void aQ(String str, String str2) {
        if (!BdNetTypeUtil.isNetWorkAvailable() || TextUtils.isEmpty(str)) {
            if (this.bAd != null) {
                this.bAd.onFail(this.bAc.getResources().getString(a.i.sdk_no_network));
                return;
            }
            return;
        }
        HttpMessage httpMessage = new HttpMessage(1031041);
        httpMessage.addParam("target_room_id", str);
        httpMessage.addParam("tipoff_reason", str2);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void a(a aVar) {
        this.bAd = aVar;
    }
}

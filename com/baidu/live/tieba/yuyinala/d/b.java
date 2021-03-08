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
import com.baidu.live.tieba.yuyinala.d.c;
/* loaded from: classes10.dex */
public class b extends BdBaseModel {
    private Context bOW;
    private c.a bOX;
    private HttpMessageListener byX = new HttpMessageListener(1031052) { // from class: com.baidu.live.tieba.yuyinala.d.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1031052 && b.this.bOX != null) {
                if (httpResponsedMessage.getStatusCode() != 200 || !(httpResponsedMessage instanceof JsonHttpResponsedMessage)) {
                    b.this.bOX.onFail(httpResponsedMessage.getErrorString());
                } else if (httpResponsedMessage.getError() == 0) {
                    b.this.bOX.Pj();
                } else {
                    b.this.bOX.onFail(httpResponsedMessage.getErrorString());
                }
            }
        }
    };

    public b(Context context) {
        this.bOW = context;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031052, com.baidu.live.a.axo);
        tbHttpMessageTask.setResponsedClass(JsonHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        registerListener(this.byX);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    public void onDestroy() {
        cancelMessage();
        MessageManager.getInstance().unRegisterTask(1031052);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void D(String str, String str2, String str3) {
        if (!BdNetTypeUtil.isNetWorkAvailable() || TextUtils.isEmpty(str) || TextUtils.isEmpty(str3)) {
            if (this.bOX != null) {
                this.bOX.onFail(this.bOW.getResources().getString(a.h.sdk_no_network));
                return;
            }
            return;
        }
        HttpMessage httpMessage = new HttpMessage(1031052);
        httpMessage.addParam("target_room_id", str);
        httpMessage.addParam("target_user_uk", str3);
        httpMessage.addParam("tipoff_reason", str2);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void a(c.a aVar) {
        this.bOX = aVar;
    }
}

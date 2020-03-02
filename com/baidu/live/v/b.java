package com.baidu.live.v;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.data.ak;
import com.baidu.live.message.GetLiveActivityHttpResponseMessage;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes3.dex */
public class b {
    private static volatile b axI;
    public ak awK;
    private HttpMessageListener axJ = new HttpMessageListener(1021122) { // from class: com.baidu.live.v.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021122 && (httpResponsedMessage instanceof GetLiveActivityHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    GetLiveActivityHttpResponseMessage getLiveActivityHttpResponseMessage = (GetLiveActivityHttpResponseMessage) httpResponsedMessage;
                    if (getLiveActivityHttpResponseMessage.yV() != null) {
                        b.this.awK = getLiveActivityHttpResponseMessage.yV();
                    }
                }
            }
        }
    };

    public static b zp() {
        if (axI == null) {
            synchronized (b.class) {
                if (axI == null) {
                    axI = new b();
                }
            }
        }
        return axI;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.axJ);
        this.awK = new ak();
    }

    public void d(long j, long j2, long j3, long j4) {
        HttpMessage httpMessage = new HttpMessage(1021122);
        int i = 0;
        if (TbadkCoreApplication.getInst().isHaokan()) {
            i = 1;
        } else if (TbadkCoreApplication.getInst().isQuanmin()) {
            i = 2;
        } else if (TbadkCoreApplication.getInst().isTieba()) {
            i = 3;
        } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            i = 4;
        }
        httpMessage.addParam("from", i);
        httpMessage.addParam("user_id", j);
        httpMessage.addParam("charm_user_id", j2);
        httpMessage.addParam("room_id", j3);
        httpMessage.addParam("live_id", j4);
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}

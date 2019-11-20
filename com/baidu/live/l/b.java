package com.baidu.live.l;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.data.ac;
import com.baidu.live.message.GetLiveActivityHttpResponseMessage;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes6.dex */
public class b {
    private static volatile b akB;
    public ac ajP;
    private HttpMessageListener akC = new HttpMessageListener(1021122) { // from class: com.baidu.live.l.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021122 && (httpResponsedMessage instanceof GetLiveActivityHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    GetLiveActivityHttpResponseMessage getLiveActivityHttpResponseMessage = (GetLiveActivityHttpResponseMessage) httpResponsedMessage;
                    if (getLiveActivityHttpResponseMessage.ur() != null) {
                        b.this.ajP = getLiveActivityHttpResponseMessage.ur();
                    }
                }
            }
        }
    };

    public static b uG() {
        if (akB == null) {
            synchronized (b.class) {
                if (akB == null) {
                    akB = new b();
                }
            }
        }
        return akB;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.akC);
        this.ajP = new ac();
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

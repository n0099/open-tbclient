package com.baidu.live.yyrtc;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.framework.task.HttpMessageTask;
import com.baidu.live.adp.lib.safe.SafeHandler;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
/* loaded from: classes10.dex */
public class a {
    private static volatile a cfM;
    private HttpMessageListener cfN;
    private volatile b cfO;

    private a() {
        SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.yyrtc.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.ZP();
                a.this.ZO();
            }
        });
    }

    public static a ZN() {
        if (cfM == null) {
            synchronized (a.class) {
                if (cfM == null) {
                    cfM = new a();
                }
            }
        }
        return cfM;
    }

    public void a(final String str, final String str2, b bVar) {
        this.cfO = bVar;
        SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.yyrtc.a.2
            @Override // java.lang.Runnable
            public void run() {
                c cVar = new c();
                cVar.aZ(str, str2);
                MessageManager.getInstance().sendMessage(cVar);
            }
        });
    }

    public void release() {
        unRegisterListener();
        MessageManager.getInstance().unRegisterTask(1021240);
        this.cfO = null;
        this.cfN = null;
        cfM = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZO() {
        if (this.cfN == null) {
            this.cfN = new HttpMessageListener(1021240) { // from class: com.baidu.live.yyrtc.a.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (a.this.cfO != null && (httpResponsedMessage instanceof LiveYYRtcTokenHttpResponseMessage)) {
                        LiveYYRtcTokenHttpResponseMessage liveYYRtcTokenHttpResponseMessage = (LiveYYRtcTokenHttpResponseMessage) httpResponsedMessage;
                        if (liveYYRtcTokenHttpResponseMessage.getError() != 0) {
                            a.this.cfO.ai(null, " code=" + liveYYRtcTokenHttpResponseMessage.getError() + " , msg=" + liveYYRtcTokenHttpResponseMessage.getErrorString());
                            return;
                        }
                        a.this.cfO.ai(liveYYRtcTokenHttpResponseMessage.getToken(), " get token success ");
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.cfN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZP() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021240, TbConfig.SERVER_ADDRESS + "liveconnect/rtc/genToken");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(LiveYYRtcTokenHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.cfN);
    }
}

package com.baidu.live.yyrtc;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.framework.task.HttpMessageTask;
import com.baidu.live.adp.lib.safe.SafeHandler;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
/* loaded from: classes11.dex */
public class a {
    private static volatile a cem;
    private HttpMessageListener cen;
    private volatile b ceo;

    private a() {
        SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.yyrtc.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.ZM();
                a.this.ZL();
            }
        });
    }

    public static a ZK() {
        if (cem == null) {
            synchronized (a.class) {
                if (cem == null) {
                    cem = new a();
                }
            }
        }
        return cem;
    }

    public void a(final String str, final String str2, b bVar) {
        this.ceo = bVar;
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
        this.ceo = null;
        this.cen = null;
        cem = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZL() {
        if (this.cen == null) {
            this.cen = new HttpMessageListener(1021240) { // from class: com.baidu.live.yyrtc.a.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (a.this.ceo != null && (httpResponsedMessage instanceof LiveYYRtcTokenHttpResponseMessage)) {
                        LiveYYRtcTokenHttpResponseMessage liveYYRtcTokenHttpResponseMessage = (LiveYYRtcTokenHttpResponseMessage) httpResponsedMessage;
                        if (liveYYRtcTokenHttpResponseMessage.getError() != 0) {
                            a.this.ceo.ai(null, " code=" + liveYYRtcTokenHttpResponseMessage.getError() + " , msg=" + liveYYRtcTokenHttpResponseMessage.getErrorString());
                            return;
                        }
                        a.this.ceo.ai(liveYYRtcTokenHttpResponseMessage.getToken(), " get token success ");
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.cen);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZM() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021240, TbConfig.SERVER_ADDRESS + "liveconnect/rtc/genToken");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(LiveYYRtcTokenHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.cen);
    }
}

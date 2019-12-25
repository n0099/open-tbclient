package com.baidu.live.r;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.data.ak;
import com.baidu.live.data.q;
import com.baidu.live.message.AlaSyncHttpResponseMessage;
import com.baidu.live.message.LiveSyncHttpResponseMessage;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.utils.p;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    private static volatile a asx;
    public q arE;
    private boolean asA;
    private HttpMessageListener asB = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_SYNC) { // from class: com.baidu.live.r.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021011 && (httpResponsedMessage instanceof AlaSyncHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    AlaSyncHttpResponseMessage alaSyncHttpResponseMessage = (AlaSyncHttpResponseMessage) httpResponsedMessage;
                    if (alaSyncHttpResponseMessage.wj() != null) {
                        a.this.arE = alaSyncHttpResponseMessage.wj();
                        a.this.asz = true;
                    }
                }
                if (a.this.arE != null) {
                    TbadkCoreApplication.getInst().setAlaMenuToast(a.this.arE.Wv);
                    TbadkCoreApplication.getInst().setAlaToastShowType(a.this.arE.Wu);
                }
            }
        }
    };
    private HttpMessageListener asC = new HttpMessageListener(1021132) { // from class: com.baidu.live.r.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021132 && (httpResponsedMessage instanceof LiveSyncHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    LiveSyncHttpResponseMessage liveSyncHttpResponseMessage = (LiveSyncHttpResponseMessage) httpResponsedMessage;
                    if (liveSyncHttpResponseMessage.wo() != null) {
                        a.this.asy = liveSyncHttpResponseMessage.wo();
                        a.this.asA = true;
                    }
                }
            }
        }
    };
    CustomMessageTask.CustomRunnable asD = new CustomMessageTask.CustomRunnable() { // from class: com.baidu.live.r.a.3
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<String> run(CustomMessage customMessage) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (a.this.arE != null && !TextUtils.isEmpty(a.this.arE.Yx) && !TextUtils.isEmpty(a.this.arE.Yw) && a.this.arE.Yv == 1) {
                    jSONObject.putOpt("photo_url", a.this.arE.Yx);
                    jSONObject.putOpt("resource_url", a.this.arE.Yw);
                }
                if (a.this.asy != null && a.this.asy.aaE != null && a.this.asy.aaE.pQ() && (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin())) {
                    jSONObject.putOpt("general_exchange_homepage_url", a.this.asy.aaE.pR());
                }
                return new CustomResponsedMessage<>(CmdConfigCustom.CMS_TBEAN_RESOURCE_URL_AND_PHOTO, jSONObject.toString());
            } catch (JSONException e) {
                return null;
            }
        }
    };
    public ak asy;
    private boolean asz;

    public static a wA() {
        if (asx == null) {
            synchronized (a.class) {
                if (asx == null) {
                    asx = new a();
                }
            }
        }
        return asx;
    }

    private a() {
        MessageManager.getInstance().registerListener(this.asB);
        MessageManager.getInstance().registerListener(this.asC);
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMS_TBEAN_RESOURCE_URL_AND_PHOTO, this.asD);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        this.arE = new q(true);
        this.asy = new ak();
    }

    public void wB() {
        this.asz = false;
        this.asA = false;
    }

    public void a(BdUniqueId bdUniqueId) {
        if (!this.asz) {
            HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_SYNC);
            String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
            if (activeVersion != null) {
                if (activeVersion.length() < 1) {
                    activeVersion = "0";
                }
                httpMessage.addParam("_active", activeVersion);
            }
            if (this.arE.Xq != null && !this.arE.Xq.isEmpty()) {
                httpMessage.addParam("_client_id", this.arE.Xq);
            } else {
                httpMessage.addParam("_client_id", "0");
            }
            if (bdUniqueId != null) {
                httpMessage.setTag(bdUniqueId);
            }
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void wC() {
        if (!this.asA) {
            HttpMessage httpMessage = new HttpMessage(1021132);
            String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
            if (activeVersion != null) {
                if (activeVersion.length() < 1) {
                    activeVersion = "0";
                }
                httpMessage.addParam("_active", activeVersion);
            }
            httpMessage.addParam("device_type", Build.VERSION.SDK_INT);
            httpMessage.addParam("scene_from", p.yu());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public boolean wD() {
        ak akVar = wA().asy;
        return (akVar == null || akVar.aaK == null || !akVar.aaK.acm || akVar.aaH == null || akVar.aaH.abz == null || TextUtils.isEmpty(akVar.aaH.abz.abG)) ? false : true;
    }
}

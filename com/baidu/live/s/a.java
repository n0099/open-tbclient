package com.baidu.live.s;

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
import com.baidu.live.data.ao;
import com.baidu.live.data.s;
import com.baidu.live.message.AlaSyncHttpResponseMessage;
import com.baidu.live.message.LiveSyncHttpResponseMessage;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.utils.q;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    private static volatile a atj;
    public s asq;
    public ao atk;
    private boolean atl;
    private boolean atm;
    private HttpMessageListener atn = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_SYNC) { // from class: com.baidu.live.s.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021011 && (httpResponsedMessage instanceof AlaSyncHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    AlaSyncHttpResponseMessage alaSyncHttpResponseMessage = (AlaSyncHttpResponseMessage) httpResponsedMessage;
                    if (alaSyncHttpResponseMessage.wA() != null) {
                        a.this.asq = alaSyncHttpResponseMessage.wA();
                        a.this.atl = true;
                    }
                }
                if (a.this.asq != null) {
                    TbadkCoreApplication.getInst().setAlaMenuToast(a.this.asq.WO);
                    TbadkCoreApplication.getInst().setAlaToastShowType(a.this.asq.WN);
                }
            }
        }
    };
    private HttpMessageListener ato = new HttpMessageListener(1021132) { // from class: com.baidu.live.s.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021132 && (httpResponsedMessage instanceof LiveSyncHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    LiveSyncHttpResponseMessage liveSyncHttpResponseMessage = (LiveSyncHttpResponseMessage) httpResponsedMessage;
                    if (liveSyncHttpResponseMessage.wF() != null) {
                        a.this.atk = liveSyncHttpResponseMessage.wF();
                        a.this.atm = true;
                    }
                }
            }
        }
    };
    CustomMessageTask.CustomRunnable atp = new CustomMessageTask.CustomRunnable() { // from class: com.baidu.live.s.a.3
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<String> run(CustomMessage customMessage) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (a.this.asq != null && !TextUtils.isEmpty(a.this.asq.YJ) && !TextUtils.isEmpty(a.this.asq.YI) && a.this.asq.YH == 1) {
                    jSONObject.putOpt("photo_url", a.this.asq.YJ);
                    jSONObject.putOpt("resource_url", a.this.asq.YI);
                }
                if (a.this.atk != null && a.this.atk.aaR != null && a.this.atk.aaR.pV() && (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin())) {
                    jSONObject.putOpt("general_exchange_homepage_url", a.this.atk.aaR.pW());
                }
                return new CustomResponsedMessage<>(CmdConfigCustom.CMS_TBEAN_RESOURCE_URL_AND_PHOTO, jSONObject.toString());
            } catch (JSONException e) {
                return null;
            }
        }
    };

    public static a wR() {
        if (atj == null) {
            synchronized (a.class) {
                if (atj == null) {
                    atj = new a();
                }
            }
        }
        return atj;
    }

    private a() {
        MessageManager.getInstance().registerListener(this.atn);
        MessageManager.getInstance().registerListener(this.ato);
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMS_TBEAN_RESOURCE_URL_AND_PHOTO, this.atp);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        this.asq = new s(true);
        this.atk = new ao();
    }

    public void wS() {
        this.atl = false;
        this.atm = false;
    }

    public void b(BdUniqueId bdUniqueId) {
        if (!this.atl) {
            HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_SYNC);
            String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
            if (activeVersion != null) {
                if (activeVersion.length() < 1) {
                    activeVersion = "0";
                }
                httpMessage.addParam("_active", activeVersion);
            }
            if (this.asq.XJ != null && !this.asq.XJ.isEmpty()) {
                httpMessage.addParam("_client_id", this.asq.XJ);
            } else {
                httpMessage.addParam("_client_id", "0");
            }
            if (bdUniqueId != null) {
                httpMessage.setTag(bdUniqueId);
            }
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void wT() {
        if (!this.atm) {
            HttpMessage httpMessage = new HttpMessage(1021132);
            String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
            if (activeVersion != null) {
                if (activeVersion.length() < 1) {
                    activeVersion = "0";
                }
                httpMessage.addParam("_active", activeVersion);
            }
            httpMessage.addParam("device_type", Build.VERSION.SDK_INT);
            httpMessage.addParam("scene_from", q.yN());
            httpMessage.addParam("device_type", Build.VERSION.SDK_INT);
            httpMessage.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void c(BdUniqueId bdUniqueId) {
        if (!this.atm) {
            HttpMessage httpMessage = new HttpMessage(1021132);
            String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
            if (activeVersion != null) {
                if (activeVersion.length() < 1) {
                    activeVersion = "0";
                }
                httpMessage.addParam("_active", activeVersion);
            }
            httpMessage.addParam("device_type", Build.VERSION.SDK_INT);
            httpMessage.addParam("scene_from", q.yN());
            httpMessage.addParam("device_type", Build.VERSION.SDK_INT);
            httpMessage.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            httpMessage.setTag(bdUniqueId);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public boolean wU() {
        ao aoVar = wR().atk;
        return (aoVar == null || aoVar.aaX == null || !aoVar.aaX.acz || aoVar.aaU == null || aoVar.aaU.abK == null || TextUtils.isEmpty(aoVar.aaU.abK.abR)) ? false : true;
    }
}

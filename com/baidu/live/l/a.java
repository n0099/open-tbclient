package com.baidu.live.l;

import android.text.TextUtils;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.data.af;
import com.baidu.live.data.o;
import com.baidu.live.message.AlaSyncHttpResponseMessage;
import com.baidu.live.message.LiveSyncHttpResponseMessage;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    private static volatile a akt;
    public o ajF;
    public af aku;
    private boolean akv;
    private boolean akw;
    private HttpMessageListener akx = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_SYNC) { // from class: com.baidu.live.l.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021011 && (httpResponsedMessage instanceof AlaSyncHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    AlaSyncHttpResponseMessage alaSyncHttpResponseMessage = (AlaSyncHttpResponseMessage) httpResponsedMessage;
                    if (alaSyncHttpResponseMessage.uo() != null) {
                        a.this.ajF = alaSyncHttpResponseMessage.uo();
                        a.this.akv = true;
                    }
                }
                if (a.this.ajF != null) {
                    TbadkCoreApplication.getInst().setAlaMenuToast(a.this.ajF.PD);
                    TbadkCoreApplication.getInst().setAlaToastShowType(a.this.ajF.Pz);
                }
            }
        }
    };
    private HttpMessageListener aky = new HttpMessageListener(1021132) { // from class: com.baidu.live.l.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021132 && (httpResponsedMessage instanceof LiveSyncHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    LiveSyncHttpResponseMessage liveSyncHttpResponseMessage = (LiveSyncHttpResponseMessage) httpResponsedMessage;
                    if (liveSyncHttpResponseMessage.ut() != null) {
                        a.this.aku = liveSyncHttpResponseMessage.ut();
                        a.this.akw = true;
                    }
                }
            }
        }
    };
    CustomMessageTask.CustomRunnable akz = new CustomMessageTask.CustomRunnable() { // from class: com.baidu.live.l.a.3
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<String> run(CustomMessage customMessage) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (a.this.ajF != null && !TextUtils.isEmpty(a.this.ajF.RI) && !TextUtils.isEmpty(a.this.ajF.RH) && a.this.ajF.RG == 1) {
                    jSONObject.putOpt("photo_url", a.this.ajF.RI);
                    jSONObject.putOpt("resource_url", a.this.ajF.RH);
                }
                if (a.this.aku != null && a.this.aku.TI != null && a.this.aku.TI.oy() && (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin())) {
                    jSONObject.putOpt("general_exchange_homepage_url", a.this.aku.TI.oz());
                }
                return new CustomResponsedMessage<>(CmdConfigCustom.CMS_TBEAN_RESOURCE_URL_AND_PHOTO, jSONObject.toString());
            } catch (JSONException e) {
                return null;
            }
        }
    };

    public static a uB() {
        if (akt == null) {
            synchronized (a.class) {
                if (akt == null) {
                    akt = new a();
                }
            }
        }
        return akt;
    }

    private a() {
        MessageManager.getInstance().registerListener(this.akx);
        MessageManager.getInstance().registerListener(this.aky);
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMS_TBEAN_RESOURCE_URL_AND_PHOTO, this.akz);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        this.ajF = new o(true);
        this.aku = new af();
    }

    public void uC() {
        this.akv = false;
        this.akw = false;
    }

    public void uD() {
        if (!this.akv) {
            HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_SYNC);
            String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
            if (activeVersion != null) {
                if (activeVersion.length() < 1) {
                    activeVersion = "0";
                }
                httpMessage.addParam("_active", activeVersion);
            }
            if (this.ajF.QB != null && !this.ajF.QB.isEmpty()) {
                httpMessage.addParam("_client_id", this.ajF.QB);
            } else {
                httpMessage.addParam("_client_id", "0");
            }
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void uE() {
        if (!this.akw) {
            HttpMessage httpMessage = new HttpMessage(1021132);
            String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
            if (activeVersion != null) {
                if (activeVersion.length() < 1) {
                    activeVersion = "0";
                }
                httpMessage.addParam("_active", activeVersion);
            }
            httpMessage.addParam("scene_from", com.baidu.live.utils.o.wu());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public boolean uF() {
        af afVar = uB().aku;
        return (afVar == null || afVar.TO == null || !afVar.TO.UU || afVar.TK == null || afVar.TK.Ur == null || TextUtils.isEmpty(afVar.TK.Ur.Uw)) ? false : true;
    }
}

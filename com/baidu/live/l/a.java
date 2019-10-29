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
    private static volatile a akL;
    public o ajX;
    public af akM;
    private boolean akN;
    private boolean akO;
    private HttpMessageListener akP = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_SYNC) { // from class: com.baidu.live.l.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021011 && (httpResponsedMessage instanceof AlaSyncHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    AlaSyncHttpResponseMessage alaSyncHttpResponseMessage = (AlaSyncHttpResponseMessage) httpResponsedMessage;
                    if (alaSyncHttpResponseMessage.un() != null) {
                        a.this.ajX = alaSyncHttpResponseMessage.un();
                        a.this.akN = true;
                    }
                }
                if (a.this.ajX != null) {
                    TbadkCoreApplication.getInst().setAlaMenuToast(a.this.ajX.Qg);
                    TbadkCoreApplication.getInst().setAlaToastShowType(a.this.ajX.Qf);
                }
            }
        }
    };
    private HttpMessageListener akQ = new HttpMessageListener(1021132) { // from class: com.baidu.live.l.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021132 && (httpResponsedMessage instanceof LiveSyncHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    LiveSyncHttpResponseMessage liveSyncHttpResponseMessage = (LiveSyncHttpResponseMessage) httpResponsedMessage;
                    if (liveSyncHttpResponseMessage.us() != null) {
                        a.this.akM = liveSyncHttpResponseMessage.us();
                        a.this.akO = true;
                    }
                }
            }
        }
    };
    CustomMessageTask.CustomRunnable akR = new CustomMessageTask.CustomRunnable() { // from class: com.baidu.live.l.a.3
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<String> run(CustomMessage customMessage) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (a.this.ajX != null && !TextUtils.isEmpty(a.this.ajX.Sl) && !TextUtils.isEmpty(a.this.ajX.Sk) && a.this.ajX.Sj == 1) {
                    jSONObject.putOpt("photo_url", a.this.ajX.Sl);
                    jSONObject.putOpt("resource_url", a.this.ajX.Sk);
                }
                if (a.this.akM != null && a.this.akM.Uc != null && a.this.akM.Uc.oy() && (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin())) {
                    jSONObject.putOpt("general_exchange_homepage_url", a.this.akM.Uc.oz());
                }
                return new CustomResponsedMessage<>(CmdConfigCustom.CMS_TBEAN_RESOURCE_URL_AND_PHOTO, jSONObject.toString());
            } catch (JSONException e) {
                return null;
            }
        }
    };

    public static a uA() {
        if (akL == null) {
            synchronized (a.class) {
                if (akL == null) {
                    akL = new a();
                }
            }
        }
        return akL;
    }

    private a() {
        MessageManager.getInstance().registerListener(this.akP);
        MessageManager.getInstance().registerListener(this.akQ);
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMS_TBEAN_RESOURCE_URL_AND_PHOTO, this.akR);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        this.ajX = new o(true);
        this.akM = new af();
    }

    public void uB() {
        this.akN = false;
        this.akO = false;
    }

    public void uC() {
        if (!this.akN) {
            HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_SYNC);
            String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
            if (activeVersion != null) {
                if (activeVersion.length() < 1) {
                    activeVersion = "0";
                }
                httpMessage.addParam("_active", activeVersion);
            }
            if (this.ajX.Rc != null && !this.ajX.Rc.isEmpty()) {
                httpMessage.addParam("_client_id", this.ajX.Rc);
            } else {
                httpMessage.addParam("_client_id", "0");
            }
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void uD() {
        if (!this.akO) {
            HttpMessage httpMessage = new HttpMessage(1021132);
            String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
            if (activeVersion != null) {
                if (activeVersion.length() < 1) {
                    activeVersion = "0";
                }
                httpMessage.addParam("_active", activeVersion);
            }
            httpMessage.addParam("scene_from", com.baidu.live.utils.o.wt());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public boolean uE() {
        af afVar = uA().akM;
        return (afVar == null || afVar.Uh == null || !afVar.Uh.Vn || afVar.Ue == null || afVar.Ue.UM == null || TextUtils.isEmpty(afVar.Ue.UM.US)) ? false : true;
    }
}

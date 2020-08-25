package com.baidu.live.w;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.data.ab;
import com.baidu.live.data.be;
import com.baidu.live.message.AlaSyncHttpResponseMessage;
import com.baidu.live.message.LiveSyncHttpResponseMessage;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.utils.p;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    private static volatile a bjZ;
    public ab beH;
    public be bka;
    private boolean bkb;
    private boolean bkc;
    private HttpMessageListener syncListener = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_SYNC) { // from class: com.baidu.live.w.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021011 && (httpResponsedMessage instanceof AlaSyncHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    AlaSyncHttpResponseMessage alaSyncHttpResponseMessage = (AlaSyncHttpResponseMessage) httpResponsedMessage;
                    if (alaSyncHttpResponseMessage.LH() != null) {
                        a.this.beH = alaSyncHttpResponseMessage.LH();
                        a.this.bkb = true;
                    }
                }
                if (a.this.beH != null) {
                    TbadkCoreApplication.getInst().setAlaMenuToast(a.this.beH.aEJ);
                    TbadkCoreApplication.getInst().setAlaToastShowType(a.this.beH.aEI);
                }
            }
        }
    };
    private HttpMessageListener bkd = new HttpMessageListener(1021132) { // from class: com.baidu.live.w.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021132 && (httpResponsedMessage instanceof LiveSyncHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    LiveSyncHttpResponseMessage liveSyncHttpResponseMessage = (LiveSyncHttpResponseMessage) httpResponsedMessage;
                    if (liveSyncHttpResponseMessage.LM() != null) {
                        a.this.bka = liveSyncHttpResponseMessage.LM();
                        a.this.bkc = true;
                    }
                }
            }
        }
    };
    CustomMessageTask.CustomRunnable bke = new CustomMessageTask.CustomRunnable() { // from class: com.baidu.live.w.a.3
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<String> run(CustomMessage customMessage) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (a.this.beH != null && !TextUtils.isEmpty(a.this.beH.aGS) && !TextUtils.isEmpty(a.this.beH.aGR) && a.this.beH.aGQ == 1) {
                    jSONObject.putOpt("photo_url", a.this.beH.aGS);
                    jSONObject.putOpt("resource_url", a.this.beH.aGR);
                }
                if (a.this.bka != null && a.this.bka.aJv != null && a.this.bka.aJv.CU() && (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin())) {
                    jSONObject.putOpt("general_exchange_homepage_url", a.this.bka.aJv.CV());
                }
                return new CustomResponsedMessage<>(CmdConfigCustom.CMS_TBEAN_RESOURCE_URL_AND_PHOTO, jSONObject.toString());
            } catch (JSONException e) {
                return null;
            }
        }
    };

    public static a Nk() {
        if (bjZ == null) {
            synchronized (a.class) {
                if (bjZ == null) {
                    bjZ = new a();
                }
            }
        }
        return bjZ;
    }

    private a() {
        MessageManager.getInstance().registerListener(this.syncListener);
        MessageManager.getInstance().registerListener(this.bkd);
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMS_TBEAN_RESOURCE_URL_AND_PHOTO, this.bke);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        this.beH = new ab(true);
        this.bka = new be();
        String string = com.baidu.live.c.AD().getString("key_live_sync_data", "");
        if (!TextUtils.isEmpty(string)) {
            this.bka.parserJson(string);
        }
    }

    public void Nl() {
        this.bkb = false;
        this.bkc = false;
    }

    public void c(BdUniqueId bdUniqueId) {
        if (!this.bkb) {
            HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_SYNC);
            String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
            if (activeVersion != null) {
                if (activeVersion.length() < 1) {
                    activeVersion = "0";
                }
                httpMessage.addParam("_active", activeVersion);
            }
            if (this.beH.aFM != null && !this.beH.aFM.isEmpty()) {
                httpMessage.addParam("_client_id", this.beH.aFM);
            } else {
                httpMessage.addParam("_client_id", "0");
            }
            if (bdUniqueId != null) {
                httpMessage.setTag(bdUniqueId);
            }
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void Nm() {
        if (!this.bkc) {
            HttpMessage httpMessage = new HttpMessage(1021132);
            String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
            if (activeVersion != null) {
                if (activeVersion.length() < 1) {
                    activeVersion = "0";
                }
                httpMessage.addParam("_active", activeVersion);
            }
            httpMessage.addParam(HttpConstants.DEVICE_TYPE, Build.VERSION.SDK_INT);
            httpMessage.addParam("scene_from", p.EZ());
            httpMessage.addParam(HttpConstants.DEVICE_TYPE, Build.VERSION.SDK_INT);
            httpMessage.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void d(BdUniqueId bdUniqueId) {
        if (!this.bkc) {
            HttpMessage httpMessage = new HttpMessage(1021132);
            String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
            if (activeVersion != null) {
                if (activeVersion.length() < 1) {
                    activeVersion = "0";
                }
                httpMessage.addParam("_active", activeVersion);
            }
            httpMessage.addParam(HttpConstants.DEVICE_TYPE, Build.VERSION.SDK_INT);
            httpMessage.addParam("scene_from", p.EZ());
            httpMessage.addParam(HttpConstants.DEVICE_TYPE, Build.VERSION.SDK_INT);
            httpMessage.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            httpMessage.setTag(bdUniqueId);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public boolean Nn() {
        be beVar = Nk().bka;
        return (beVar == null || beVar.aJB == null || !beVar.aJB.aLq || beVar.aJy == null || beVar.aJy.aKu == null || TextUtils.isEmpty(beVar.aJy.aKu.aKB)) ? false : true;
    }
}

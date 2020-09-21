package com.baidu.live.x;

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
import com.baidu.live.data.ag;
import com.baidu.live.data.bj;
import com.baidu.live.message.AlaSyncHttpResponseMessage;
import com.baidu.live.message.LiveSyncHttpResponseMessage;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.utils.p;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    private static volatile a bmV;
    public ag bhy;
    public bj bmW;
    private boolean bmX;
    private boolean bmY;
    private HttpMessageListener syncListener = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_SYNC) { // from class: com.baidu.live.x.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021011 && (httpResponsedMessage instanceof AlaSyncHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    AlaSyncHttpResponseMessage alaSyncHttpResponseMessage = (AlaSyncHttpResponseMessage) httpResponsedMessage;
                    if (alaSyncHttpResponseMessage.Mi() != null) {
                        a.this.bhy = alaSyncHttpResponseMessage.Mi();
                        a.this.bmX = true;
                    }
                }
                if (a.this.bhy != null) {
                    TbadkCoreApplication.getInst().setAlaMenuToast(a.this.bhy.aFY);
                    TbadkCoreApplication.getInst().setAlaToastShowType(a.this.bhy.aFX);
                }
            }
        }
    };
    private HttpMessageListener bmZ = new HttpMessageListener(1021132) { // from class: com.baidu.live.x.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021132 && (httpResponsedMessage instanceof LiveSyncHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    LiveSyncHttpResponseMessage liveSyncHttpResponseMessage = (LiveSyncHttpResponseMessage) httpResponsedMessage;
                    if (liveSyncHttpResponseMessage.Mn() != null) {
                        a.this.bmW = liveSyncHttpResponseMessage.Mn();
                        a.this.bmY = true;
                    }
                }
            }
        }
    };
    CustomMessageTask.CustomRunnable bna = new CustomMessageTask.CustomRunnable() { // from class: com.baidu.live.x.a.3
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<String> run(CustomMessage customMessage) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (a.this.bhy != null && !TextUtils.isEmpty(a.this.bhy.aIj) && !TextUtils.isEmpty(a.this.bhy.aIi) && a.this.bhy.aIh == 1) {
                    jSONObject.putOpt("photo_url", a.this.bhy.aIj);
                    jSONObject.putOpt("resource_url", a.this.bhy.aIi);
                }
                if (a.this.bmW != null && a.this.bmW.aKN != null && a.this.bmW.aKN.Dk() && (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin())) {
                    jSONObject.putOpt("general_exchange_homepage_url", a.this.bmW.aKN.Dl());
                }
                return new CustomResponsedMessage<>(CmdConfigCustom.CMS_TBEAN_RESOURCE_URL_AND_PHOTO, jSONObject.toString());
            } catch (JSONException e) {
                return null;
            }
        }
    };

    public static a NN() {
        if (bmV == null) {
            synchronized (a.class) {
                if (bmV == null) {
                    bmV = new a();
                }
            }
        }
        return bmV;
    }

    private a() {
        MessageManager.getInstance().registerListener(this.syncListener);
        MessageManager.getInstance().registerListener(this.bmZ);
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMS_TBEAN_RESOURCE_URL_AND_PHOTO, this.bna);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        this.bhy = new ag(true);
        this.bmW = new bj();
        String string = com.baidu.live.c.AR().getString("key_live_sync_data", "");
        if (!TextUtils.isEmpty(string)) {
            this.bmW.parserJson(string);
        }
    }

    public void NO() {
        this.bmX = false;
        this.bmY = false;
    }

    public void c(BdUniqueId bdUniqueId) {
        if (!this.bmX) {
            HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_SYNC);
            String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
            if (activeVersion != null) {
                if (activeVersion.length() < 1) {
                    activeVersion = "0";
                }
                httpMessage.addParam("_active", activeVersion);
            }
            if (this.bhy.aHd != null && !this.bhy.aHd.isEmpty()) {
                httpMessage.addParam("_client_id", this.bhy.aHd);
            } else {
                httpMessage.addParam("_client_id", "0");
            }
            if (bdUniqueId != null) {
                httpMessage.setTag(bdUniqueId);
            }
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void NP() {
        if (!this.bmY) {
            HttpMessage httpMessage = new HttpMessage(1021132);
            String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
            if (activeVersion != null) {
                if (activeVersion.length() < 1) {
                    activeVersion = "0";
                }
                httpMessage.addParam("_active", activeVersion);
            }
            httpMessage.addParam(HttpConstants.DEVICE_TYPE, Build.VERSION.SDK_INT);
            httpMessage.addParam("scene_from", p.Fz());
            httpMessage.addParam(HttpConstants.DEVICE_TYPE, Build.VERSION.SDK_INT);
            httpMessage.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void d(BdUniqueId bdUniqueId) {
        if (!this.bmY) {
            HttpMessage httpMessage = new HttpMessage(1021132);
            String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
            if (activeVersion != null) {
                if (activeVersion.length() < 1) {
                    activeVersion = "0";
                }
                httpMessage.addParam("_active", activeVersion);
            }
            httpMessage.addParam(HttpConstants.DEVICE_TYPE, Build.VERSION.SDK_INT);
            httpMessage.addParam("scene_from", p.Fz());
            httpMessage.addParam(HttpConstants.DEVICE_TYPE, Build.VERSION.SDK_INT);
            httpMessage.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            httpMessage.setTag(bdUniqueId);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public boolean NQ() {
        bj bjVar = NN().bmW;
        return (bjVar == null || bjVar.aKT == null || !bjVar.aKT.aNa || bjVar.aKQ == null || bjVar.aKQ.aMb == null || TextUtils.isEmpty(bjVar.aKQ.aMb.aMi)) ? false : true;
    }
}

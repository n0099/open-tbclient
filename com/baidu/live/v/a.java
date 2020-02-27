package com.baidu.live.v;

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
import com.baidu.live.data.ap;
import com.baidu.live.data.t;
import com.baidu.live.message.AlaSyncHttpResponseMessage;
import com.baidu.live.message.LiveSyncHttpResponseMessage;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.utils.q;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    private static volatile a axA;
    public t awA;
    public ap axB;
    private boolean axC;
    private boolean axD;
    private HttpMessageListener syncListener = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_SYNC) { // from class: com.baidu.live.v.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021011 && (httpResponsedMessage instanceof AlaSyncHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    AlaSyncHttpResponseMessage alaSyncHttpResponseMessage = (AlaSyncHttpResponseMessage) httpResponsedMessage;
                    if (alaSyncHttpResponseMessage.yR() != null) {
                        a.this.awA = alaSyncHttpResponseMessage.yR();
                        a.this.axC = true;
                    }
                }
                if (a.this.awA != null) {
                    TbadkCoreApplication.getInst().setAlaMenuToast(a.this.awA.YA);
                    TbadkCoreApplication.getInst().setAlaToastShowType(a.this.awA.Yz);
                }
            }
        }
    };
    private HttpMessageListener axE = new HttpMessageListener(1021132) { // from class: com.baidu.live.v.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021132 && (httpResponsedMessage instanceof LiveSyncHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    LiveSyncHttpResponseMessage liveSyncHttpResponseMessage = (LiveSyncHttpResponseMessage) httpResponsedMessage;
                    if (liveSyncHttpResponseMessage.yW() != null) {
                        a.this.axB = liveSyncHttpResponseMessage.yW();
                        a.this.axD = true;
                    }
                }
            }
        }
    };
    CustomMessageTask.CustomRunnable axF = new CustomMessageTask.CustomRunnable() { // from class: com.baidu.live.v.a.3
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<String> run(CustomMessage customMessage) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (a.this.awA != null && !TextUtils.isEmpty(a.this.awA.aaB) && !TextUtils.isEmpty(a.this.awA.aaA) && a.this.awA.aaz == 1) {
                    jSONObject.putOpt("photo_url", a.this.awA.aaB);
                    jSONObject.putOpt("resource_url", a.this.awA.aaA);
                }
                if (a.this.axB != null && a.this.axB.acP != null && a.this.axB.acP.qG() && (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin())) {
                    jSONObject.putOpt("general_exchange_homepage_url", a.this.axB.acP.qH());
                }
                return new CustomResponsedMessage<>(CmdConfigCustom.CMS_TBEAN_RESOURCE_URL_AND_PHOTO, jSONObject.toString());
            } catch (JSONException e) {
                return null;
            }
        }
    };

    public static a zj() {
        if (axA == null) {
            synchronized (a.class) {
                if (axA == null) {
                    axA = new a();
                }
            }
        }
        return axA;
    }

    private a() {
        MessageManager.getInstance().registerListener(this.syncListener);
        MessageManager.getInstance().registerListener(this.axE);
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMS_TBEAN_RESOURCE_URL_AND_PHOTO, this.axF);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        this.awA = new t(true);
        this.axB = new ap();
        String string = com.baidu.live.c.pr().getString("key_live_sync_data", "");
        if (!TextUtils.isEmpty(string)) {
            this.axB.parserJson(string);
        }
    }

    public void zk() {
        this.axC = false;
        this.axD = false;
    }

    public void b(BdUniqueId bdUniqueId) {
        if (!this.axC) {
            HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_SYNC);
            String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
            if (activeVersion != null) {
                if (activeVersion.length() < 1) {
                    activeVersion = "0";
                }
                httpMessage.addParam("_active", activeVersion);
            }
            if (this.awA.ZA != null && !this.awA.ZA.isEmpty()) {
                httpMessage.addParam("_client_id", this.awA.ZA);
            } else {
                httpMessage.addParam("_client_id", "0");
            }
            if (bdUniqueId != null) {
                httpMessage.setTag(bdUniqueId);
            }
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void zl() {
        if (!this.axD) {
            HttpMessage httpMessage = new HttpMessage(1021132);
            String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
            if (activeVersion != null) {
                if (activeVersion.length() < 1) {
                    activeVersion = "0";
                }
                httpMessage.addParam("_active", activeVersion);
            }
            httpMessage.addParam("device_type", Build.VERSION.SDK_INT);
            httpMessage.addParam("scene_from", q.sI());
            httpMessage.addParam("device_type", Build.VERSION.SDK_INT);
            httpMessage.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void c(BdUniqueId bdUniqueId) {
        if (!this.axD) {
            HttpMessage httpMessage = new HttpMessage(1021132);
            String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
            if (activeVersion != null) {
                if (activeVersion.length() < 1) {
                    activeVersion = "0";
                }
                httpMessage.addParam("_active", activeVersion);
            }
            httpMessage.addParam("device_type", Build.VERSION.SDK_INT);
            httpMessage.addParam("scene_from", q.sI());
            httpMessage.addParam("device_type", Build.VERSION.SDK_INT);
            httpMessage.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            httpMessage.setTag(bdUniqueId);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public boolean zm() {
        ap apVar = zj().axB;
        return (apVar == null || apVar.acV == null || !apVar.acV.aeA || apVar.acS == null || apVar.acS.adP == null || TextUtils.isEmpty(apVar.acS.adP.adW)) ? false : true;
    }
}

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
    private static volatile a axQ;
    public t awM;
    public ap axR;
    private boolean axS;
    private boolean axT;
    private HttpMessageListener syncListener = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_SYNC) { // from class: com.baidu.live.v.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021011 && (httpResponsedMessage instanceof AlaSyncHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    AlaSyncHttpResponseMessage alaSyncHttpResponseMessage = (AlaSyncHttpResponseMessage) httpResponsedMessage;
                    if (alaSyncHttpResponseMessage.yX() != null) {
                        a.this.awM = alaSyncHttpResponseMessage.yX();
                        a.this.axS = true;
                    }
                }
                if (a.this.awM != null) {
                    TbadkCoreApplication.getInst().setAlaMenuToast(a.this.awM.YK);
                    TbadkCoreApplication.getInst().setAlaToastShowType(a.this.awM.YJ);
                }
            }
        }
    };
    private HttpMessageListener axU = new HttpMessageListener(1021132) { // from class: com.baidu.live.v.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021132 && (httpResponsedMessage instanceof LiveSyncHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    LiveSyncHttpResponseMessage liveSyncHttpResponseMessage = (LiveSyncHttpResponseMessage) httpResponsedMessage;
                    if (liveSyncHttpResponseMessage.zc() != null) {
                        a.this.axR = liveSyncHttpResponseMessage.zc();
                        a.this.axT = true;
                    }
                }
            }
        }
    };
    CustomMessageTask.CustomRunnable axV = new CustomMessageTask.CustomRunnable() { // from class: com.baidu.live.v.a.3
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<String> run(CustomMessage customMessage) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (a.this.awM != null && !TextUtils.isEmpty(a.this.awM.aaL) && !TextUtils.isEmpty(a.this.awM.aaK) && a.this.awM.aaJ == 1) {
                    jSONObject.putOpt("photo_url", a.this.awM.aaL);
                    jSONObject.putOpt("resource_url", a.this.awM.aaK);
                }
                if (a.this.axR != null && a.this.axR.acZ != null && a.this.axR.acZ.qL() && (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin())) {
                    jSONObject.putOpt("general_exchange_homepage_url", a.this.axR.acZ.qM());
                }
                return new CustomResponsedMessage<>(CmdConfigCustom.CMS_TBEAN_RESOURCE_URL_AND_PHOTO, jSONObject.toString());
            } catch (JSONException e) {
                return null;
            }
        }
    };

    public static a zs() {
        if (axQ == null) {
            synchronized (a.class) {
                if (axQ == null) {
                    axQ = new a();
                }
            }
        }
        return axQ;
    }

    private a() {
        MessageManager.getInstance().registerListener(this.syncListener);
        MessageManager.getInstance().registerListener(this.axU);
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMS_TBEAN_RESOURCE_URL_AND_PHOTO, this.axV);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        this.awM = new t(true);
        this.axR = new ap();
        String string = com.baidu.live.c.pw().getString("key_live_sync_data", "");
        if (!TextUtils.isEmpty(string)) {
            this.axR.parserJson(string);
        }
    }

    public void zt() {
        this.axS = false;
        this.axT = false;
    }

    public void b(BdUniqueId bdUniqueId) {
        if (!this.axS) {
            HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_SYNC);
            String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
            if (activeVersion != null) {
                if (activeVersion.length() < 1) {
                    activeVersion = "0";
                }
                httpMessage.addParam("_active", activeVersion);
            }
            if (this.awM.ZK != null && !this.awM.ZK.isEmpty()) {
                httpMessage.addParam("_client_id", this.awM.ZK);
            } else {
                httpMessage.addParam("_client_id", "0");
            }
            if (bdUniqueId != null) {
                httpMessage.setTag(bdUniqueId);
            }
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void zu() {
        if (!this.axT) {
            HttpMessage httpMessage = new HttpMessage(1021132);
            String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
            if (activeVersion != null) {
                if (activeVersion.length() < 1) {
                    activeVersion = "0";
                }
                httpMessage.addParam("_active", activeVersion);
            }
            httpMessage.addParam("device_type", Build.VERSION.SDK_INT);
            httpMessage.addParam("scene_from", q.sN());
            httpMessage.addParam("device_type", Build.VERSION.SDK_INT);
            httpMessage.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void c(BdUniqueId bdUniqueId) {
        if (!this.axT) {
            HttpMessage httpMessage = new HttpMessage(1021132);
            String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
            if (activeVersion != null) {
                if (activeVersion.length() < 1) {
                    activeVersion = "0";
                }
                httpMessage.addParam("_active", activeVersion);
            }
            httpMessage.addParam("device_type", Build.VERSION.SDK_INT);
            httpMessage.addParam("scene_from", q.sN());
            httpMessage.addParam("device_type", Build.VERSION.SDK_INT);
            httpMessage.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            httpMessage.setTag(bdUniqueId);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public boolean zv() {
        ap apVar = zs().axR;
        return (apVar == null || apVar.adg == null || !apVar.adg.aeK || apVar.adc == null || apVar.adc.adZ == null || TextUtils.isEmpty(apVar.adc.adZ.aeg)) ? false : true;
    }
}

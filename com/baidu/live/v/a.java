package com.baidu.live.v;

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
import com.baidu.live.data.ax;
import com.baidu.live.data.y;
import com.baidu.live.message.AlaSyncHttpResponseMessage;
import com.baidu.live.message.LiveSyncHttpResponseMessage;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.utils.q;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    private static volatile a aYO;
    public y aWF;
    public ax aYP;
    private boolean aYQ;
    private boolean aYR;
    private HttpMessageListener syncListener = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_SYNC) { // from class: com.baidu.live.v.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021011 && (httpResponsedMessage instanceof AlaSyncHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    AlaSyncHttpResponseMessage alaSyncHttpResponseMessage = (AlaSyncHttpResponseMessage) httpResponsedMessage;
                    if (alaSyncHttpResponseMessage.Fo() != null) {
                        a.this.aWF = alaSyncHttpResponseMessage.Fo();
                        a.this.aYQ = true;
                    }
                }
                if (a.this.aWF != null) {
                    TbadkCoreApplication.getInst().setAlaMenuToast(a.this.aWF.awe);
                    TbadkCoreApplication.getInst().setAlaToastShowType(a.this.aWF.awd);
                }
            }
        }
    };
    private HttpMessageListener aYS = new HttpMessageListener(1021132) { // from class: com.baidu.live.v.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021132 && (httpResponsedMessage instanceof LiveSyncHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    LiveSyncHttpResponseMessage liveSyncHttpResponseMessage = (LiveSyncHttpResponseMessage) httpResponsedMessage;
                    if (liveSyncHttpResponseMessage.Fu() != null) {
                        a.this.aYP = liveSyncHttpResponseMessage.Fu();
                        a.this.aYR = true;
                    }
                }
            }
        }
    };
    CustomMessageTask.CustomRunnable aYT = new CustomMessageTask.CustomRunnable() { // from class: com.baidu.live.v.a.3
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<String> run(CustomMessage customMessage) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (a.this.aWF != null && !TextUtils.isEmpty(a.this.aWF.ayg) && !TextUtils.isEmpty(a.this.aWF.ayf) && a.this.aWF.aye == 1) {
                    jSONObject.putOpt("photo_url", a.this.aWF.ayg);
                    jSONObject.putOpt("resource_url", a.this.aWF.ayf);
                }
                if (a.this.aYP != null && a.this.aYP.aAF != null && a.this.aYP.aAF.wq() && (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin())) {
                    jSONObject.putOpt("general_exchange_homepage_url", a.this.aYP.aAF.wr());
                }
                return new CustomResponsedMessage<>(CmdConfigCustom.CMS_TBEAN_RESOURCE_URL_AND_PHOTO, jSONObject.toString());
            } catch (JSONException e) {
                return null;
            }
        }
    };

    public static a Ge() {
        if (aYO == null) {
            synchronized (a.class) {
                if (aYO == null) {
                    aYO = new a();
                }
            }
        }
        return aYO;
    }

    private a() {
        MessageManager.getInstance().registerListener(this.syncListener);
        MessageManager.getInstance().registerListener(this.aYS);
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMS_TBEAN_RESOURCE_URL_AND_PHOTO, this.aYT);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        this.aWF = new y(true);
        this.aYP = new ax();
        String string = com.baidu.live.c.uN().getString("key_live_sync_data", "");
        if (!TextUtils.isEmpty(string)) {
            this.aYP.parserJson(string);
        }
    }

    public void Gf() {
        this.aYQ = false;
        this.aYR = false;
    }

    public void b(BdUniqueId bdUniqueId) {
        if (!this.aYQ) {
            HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_SYNC);
            String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
            if (activeVersion != null) {
                if (activeVersion.length() < 1) {
                    activeVersion = "0";
                }
                httpMessage.addParam("_active", activeVersion);
            }
            if (this.aWF.axg != null && !this.aWF.axg.isEmpty()) {
                httpMessage.addParam("_client_id", this.aWF.axg);
            } else {
                httpMessage.addParam("_client_id", "0");
            }
            if (bdUniqueId != null) {
                httpMessage.setTag(bdUniqueId);
            }
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void Gg() {
        if (!this.aYR) {
            HttpMessage httpMessage = new HttpMessage(1021132);
            String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
            if (activeVersion != null) {
                if (activeVersion.length() < 1) {
                    activeVersion = "0";
                }
                httpMessage.addParam("_active", activeVersion);
            }
            httpMessage.addParam(HttpConstants.DEVICE_TYPE, Build.VERSION.SDK_INT);
            httpMessage.addParam("scene_from", q.yu());
            httpMessage.addParam(HttpConstants.DEVICE_TYPE, Build.VERSION.SDK_INT);
            httpMessage.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void c(BdUniqueId bdUniqueId) {
        if (!this.aYR) {
            HttpMessage httpMessage = new HttpMessage(1021132);
            String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
            if (activeVersion != null) {
                if (activeVersion.length() < 1) {
                    activeVersion = "0";
                }
                httpMessage.addParam("_active", activeVersion);
            }
            httpMessage.addParam(HttpConstants.DEVICE_TYPE, Build.VERSION.SDK_INT);
            httpMessage.addParam("scene_from", q.yu());
            httpMessage.addParam(HttpConstants.DEVICE_TYPE, Build.VERSION.SDK_INT);
            httpMessage.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            httpMessage.setTag(bdUniqueId);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public boolean Gh() {
        ax axVar = Ge().aYP;
        return (axVar == null || axVar.aAL == null || !axVar.aAL.aCv || axVar.aAI == null || axVar.aAI.aBF == null || TextUtils.isEmpty(axVar.aAI.aBF.aBM)) ? false : true;
    }
}

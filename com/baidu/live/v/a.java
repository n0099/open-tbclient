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
import com.baidu.live.data.bb;
import com.baidu.live.data.z;
import com.baidu.live.message.AlaSyncHttpResponseMessage;
import com.baidu.live.message.LiveSyncHttpResponseMessage;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.utils.p;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    private static volatile a bdU;
    public z aZp;
    public bb bdV;
    private boolean bdW;
    private boolean bdX;
    private HttpMessageListener syncListener = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_SYNC) { // from class: com.baidu.live.v.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021011 && (httpResponsedMessage instanceof AlaSyncHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    AlaSyncHttpResponseMessage alaSyncHttpResponseMessage = (AlaSyncHttpResponseMessage) httpResponsedMessage;
                    if (alaSyncHttpResponseMessage.FZ() != null) {
                        a.this.aZp = alaSyncHttpResponseMessage.FZ();
                        a.this.bdW = true;
                    }
                }
                if (a.this.aZp != null) {
                    TbadkCoreApplication.getInst().setAlaMenuToast(a.this.aZp.aym);
                    TbadkCoreApplication.getInst().setAlaToastShowType(a.this.aZp.ayl);
                }
            }
        }
    };
    private HttpMessageListener bdY = new HttpMessageListener(1021132) { // from class: com.baidu.live.v.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021132 && (httpResponsedMessage instanceof LiveSyncHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    LiveSyncHttpResponseMessage liveSyncHttpResponseMessage = (LiveSyncHttpResponseMessage) httpResponsedMessage;
                    if (liveSyncHttpResponseMessage.Ge() != null) {
                        a.this.bdV = liveSyncHttpResponseMessage.Ge();
                        a.this.bdX = true;
                    }
                }
            }
        }
    };
    CustomMessageTask.CustomRunnable bdZ = new CustomMessageTask.CustomRunnable() { // from class: com.baidu.live.v.a.3
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<String> run(CustomMessage customMessage) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (a.this.aZp != null && !TextUtils.isEmpty(a.this.aZp.aAv) && !TextUtils.isEmpty(a.this.aZp.aAu) && a.this.aZp.aAt == 1) {
                    jSONObject.putOpt("photo_url", a.this.aZp.aAv);
                    jSONObject.putOpt("resource_url", a.this.aZp.aAu);
                }
                if (a.this.bdV != null && a.this.bdV.aCQ != null && a.this.bdV.aCQ.wO() && (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin())) {
                    jSONObject.putOpt("general_exchange_homepage_url", a.this.bdV.aCQ.wP());
                }
                return new CustomResponsedMessage<>(CmdConfigCustom.CMS_TBEAN_RESOURCE_URL_AND_PHOTO, jSONObject.toString());
            } catch (JSONException e) {
                return null;
            }
        }
    };

    public static a Hm() {
        if (bdU == null) {
            synchronized (a.class) {
                if (bdU == null) {
                    bdU = new a();
                }
            }
        }
        return bdU;
    }

    private a() {
        MessageManager.getInstance().registerListener(this.syncListener);
        MessageManager.getInstance().registerListener(this.bdY);
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMS_TBEAN_RESOURCE_URL_AND_PHOTO, this.bdZ);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        this.aZp = new z(true);
        this.bdV = new bb();
        String string = com.baidu.live.c.vf().getString("key_live_sync_data", "");
        if (!TextUtils.isEmpty(string)) {
            this.bdV.parserJson(string);
        }
    }

    public void Hn() {
        this.bdW = false;
        this.bdX = false;
    }

    public void c(BdUniqueId bdUniqueId) {
        if (!this.bdW) {
            HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_SYNC);
            String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
            if (activeVersion != null) {
                if (activeVersion.length() < 1) {
                    activeVersion = "0";
                }
                httpMessage.addParam("_active", activeVersion);
            }
            if (this.aZp.azp != null && !this.aZp.azp.isEmpty()) {
                httpMessage.addParam("_client_id", this.aZp.azp);
            } else {
                httpMessage.addParam("_client_id", "0");
            }
            if (bdUniqueId != null) {
                httpMessage.setTag(bdUniqueId);
            }
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void Ho() {
        if (!this.bdX) {
            HttpMessage httpMessage = new HttpMessage(1021132);
            String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
            if (activeVersion != null) {
                if (activeVersion.length() < 1) {
                    activeVersion = "0";
                }
                httpMessage.addParam("_active", activeVersion);
            }
            httpMessage.addParam(HttpConstants.DEVICE_TYPE, Build.VERSION.SDK_INT);
            httpMessage.addParam("scene_from", p.yU());
            httpMessage.addParam(HttpConstants.DEVICE_TYPE, Build.VERSION.SDK_INT);
            httpMessage.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void d(BdUniqueId bdUniqueId) {
        if (!this.bdX) {
            HttpMessage httpMessage = new HttpMessage(1021132);
            String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
            if (activeVersion != null) {
                if (activeVersion.length() < 1) {
                    activeVersion = "0";
                }
                httpMessage.addParam("_active", activeVersion);
            }
            httpMessage.addParam(HttpConstants.DEVICE_TYPE, Build.VERSION.SDK_INT);
            httpMessage.addParam("scene_from", p.yU());
            httpMessage.addParam(HttpConstants.DEVICE_TYPE, Build.VERSION.SDK_INT);
            httpMessage.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            httpMessage.setTag(bdUniqueId);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public boolean Hp() {
        bb bbVar = Hm().bdV;
        return (bbVar == null || bbVar.aCW == null || !bbVar.aCW.aEM || bbVar.aCT == null || bbVar.aCT.aDQ == null || TextUtils.isEmpty(bbVar.aCT.aDQ.aDX)) ? false : true;
    }
}

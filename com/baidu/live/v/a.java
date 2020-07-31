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
import com.baidu.live.data.bc;
import com.baidu.live.data.z;
import com.baidu.live.message.AlaSyncHttpResponseMessage;
import com.baidu.live.message.LiveSyncHttpResponseMessage;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.utils.p;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    private static volatile a ben;
    public z aZn;
    public bc beo;
    private boolean bep;
    private boolean beq;
    private HttpMessageListener syncListener = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_SYNC) { // from class: com.baidu.live.v.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021011 && (httpResponsedMessage instanceof AlaSyncHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    AlaSyncHttpResponseMessage alaSyncHttpResponseMessage = (AlaSyncHttpResponseMessage) httpResponsedMessage;
                    if (alaSyncHttpResponseMessage.FT() != null) {
                        a.this.aZn = alaSyncHttpResponseMessage.FT();
                        a.this.bep = true;
                    }
                }
                if (a.this.aZn != null) {
                    TbadkCoreApplication.getInst().setAlaMenuToast(a.this.aZn.azz);
                    TbadkCoreApplication.getInst().setAlaToastShowType(a.this.aZn.azy);
                }
            }
        }
    };
    private HttpMessageListener ber = new HttpMessageListener(1021132) { // from class: com.baidu.live.v.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021132 && (httpResponsedMessage instanceof LiveSyncHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    LiveSyncHttpResponseMessage liveSyncHttpResponseMessage = (LiveSyncHttpResponseMessage) httpResponsedMessage;
                    if (liveSyncHttpResponseMessage.FY() != null) {
                        a.this.beo = liveSyncHttpResponseMessage.FY();
                        a.this.beq = true;
                    }
                }
            }
        }
    };
    CustomMessageTask.CustomRunnable bes = new CustomMessageTask.CustomRunnable() { // from class: com.baidu.live.v.a.3
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<String> run(CustomMessage customMessage) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (a.this.aZn != null && !TextUtils.isEmpty(a.this.aZn.aBI) && !TextUtils.isEmpty(a.this.aZn.aBH) && a.this.aZn.aBG == 1) {
                    jSONObject.putOpt("photo_url", a.this.aZn.aBI);
                    jSONObject.putOpt("resource_url", a.this.aZn.aBH);
                }
                if (a.this.beo != null && a.this.beo.aEl != null && a.this.beo.aEl.xr() && (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin())) {
                    jSONObject.putOpt("general_exchange_homepage_url", a.this.beo.aEl.xs());
                }
                return new CustomResponsedMessage<>(CmdConfigCustom.CMS_TBEAN_RESOURCE_URL_AND_PHOTO, jSONObject.toString());
            } catch (JSONException e) {
                return null;
            }
        }
    };

    public static a Hs() {
        if (ben == null) {
            synchronized (a.class) {
                if (ben == null) {
                    ben = new a();
                }
            }
        }
        return ben;
    }

    private a() {
        MessageManager.getInstance().registerListener(this.syncListener);
        MessageManager.getInstance().registerListener(this.ber);
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMS_TBEAN_RESOURCE_URL_AND_PHOTO, this.bes);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        this.aZn = new z(true);
        this.beo = new bc();
        String string = com.baidu.live.c.vf().getString("key_live_sync_data", "");
        if (!TextUtils.isEmpty(string)) {
            this.beo.parserJson(string);
        }
    }

    public void Ht() {
        this.bep = false;
        this.beq = false;
    }

    public void c(BdUniqueId bdUniqueId) {
        if (!this.bep) {
            HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_SYNC);
            String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
            if (activeVersion != null) {
                if (activeVersion.length() < 1) {
                    activeVersion = "0";
                }
                httpMessage.addParam("_active", activeVersion);
            }
            if (this.aZn.aAC != null && !this.aZn.aAC.isEmpty()) {
                httpMessage.addParam("_client_id", this.aZn.aAC);
            } else {
                httpMessage.addParam("_client_id", "0");
            }
            if (bdUniqueId != null) {
                httpMessage.setTag(bdUniqueId);
            }
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void Hu() {
        if (!this.beq) {
            HttpMessage httpMessage = new HttpMessage(1021132);
            String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
            if (activeVersion != null) {
                if (activeVersion.length() < 1) {
                    activeVersion = "0";
                }
                httpMessage.addParam("_active", activeVersion);
            }
            httpMessage.addParam(HttpConstants.DEVICE_TYPE, Build.VERSION.SDK_INT);
            httpMessage.addParam("scene_from", p.zw());
            httpMessage.addParam(HttpConstants.DEVICE_TYPE, Build.VERSION.SDK_INT);
            httpMessage.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void d(BdUniqueId bdUniqueId) {
        if (!this.beq) {
            HttpMessage httpMessage = new HttpMessage(1021132);
            String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
            if (activeVersion != null) {
                if (activeVersion.length() < 1) {
                    activeVersion = "0";
                }
                httpMessage.addParam("_active", activeVersion);
            }
            httpMessage.addParam(HttpConstants.DEVICE_TYPE, Build.VERSION.SDK_INT);
            httpMessage.addParam("scene_from", p.zw());
            httpMessage.addParam(HttpConstants.DEVICE_TYPE, Build.VERSION.SDK_INT);
            httpMessage.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            httpMessage.setTag(bdUniqueId);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public boolean Hv() {
        bc bcVar = Hs().beo;
        return (bcVar == null || bcVar.aEr == null || !bcVar.aEr.aGg || bcVar.aEo == null || bcVar.aEo.aFk == null || TextUtils.isEmpty(bcVar.aEo.aFk.aFr)) ? false : true;
    }
}

package com.baidu.live.af;

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
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.an;
import com.baidu.live.data.bq;
import com.baidu.live.message.AlaSyncHttpResponseMessage;
import com.baidu.live.message.LiveSyncHttpResponseMessage;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.utils.q;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    private static volatile a bxo;
    public an bru;
    public bq bxp;
    private boolean bxq;
    private boolean bxr;
    private HttpMessageListener syncListener = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_SYNC) { // from class: com.baidu.live.af.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021011 && (httpResponsedMessage instanceof AlaSyncHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    AlaSyncHttpResponseMessage alaSyncHttpResponseMessage = (AlaSyncHttpResponseMessage) httpResponsedMessage;
                    if (alaSyncHttpResponseMessage.MV() != null) {
                        a.this.bru = alaSyncHttpResponseMessage.MV();
                        a.this.bxq = true;
                    }
                }
                if (a.this.bru != null) {
                    TbadkCoreApplication.getInst().setAlaMenuToast(a.this.bru.aHD);
                    TbadkCoreApplication.getInst().setAlaToastShowType(a.this.bru.aHC);
                }
            }
        }
    };
    private HttpMessageListener bxs = new HttpMessageListener(1021132) { // from class: com.baidu.live.af.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021132 && (httpResponsedMessage instanceof LiveSyncHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    LiveSyncHttpResponseMessage liveSyncHttpResponseMessage = (LiveSyncHttpResponseMessage) httpResponsedMessage;
                    if (liveSyncHttpResponseMessage.Na() != null) {
                        a.this.bxp = liveSyncHttpResponseMessage.Na();
                        a.this.bxr = true;
                    }
                }
            }
        }
    };
    CustomMessageTask.CustomRunnable bxt = new CustomMessageTask.CustomRunnable() { // from class: com.baidu.live.af.a.3
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<String> run(CustomMessage customMessage) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (a.this.bru != null && !TextUtils.isEmpty(a.this.bru.aJS) && !TextUtils.isEmpty(a.this.bru.aJR) && a.this.bru.aJQ == 1) {
                    jSONObject.putOpt("photo_url", a.this.bru.aJS);
                    jSONObject.putOpt("resource_url", a.this.bru.aJR);
                }
                if (a.this.bxp != null && a.this.bxp.aML != null && a.this.bxp.aML.Bk() && (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo())) {
                    jSONObject.putOpt("general_exchange_homepage_url", a.this.bxp.aML.Bl());
                }
                return new CustomResponsedMessage<>(CmdConfigCustom.CMS_TBEAN_RESOURCE_URL_AND_PHOTO, jSONObject.toString());
            } catch (JSONException e) {
                return null;
            }
        }
    };

    public static a OJ() {
        if (bxo == null) {
            synchronized (a.class) {
                if (bxo == null) {
                    bxo = new a();
                }
            }
        }
        return bxo;
    }

    private a() {
        this.syncListener.setPriority(Integer.MIN_VALUE);
        MessageManager.getInstance().registerListener(this.syncListener);
        this.bxs.setPriority(Integer.MIN_VALUE);
        MessageManager.getInstance().registerListener(this.bxs);
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMS_TBEAN_RESOURCE_URL_AND_PHOTO, this.bxt);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        this.bru = new an(true);
        this.bxp = new bq();
        String string = com.baidu.live.d.xf().getString("key_live_sync_data", "");
        if (!TextUtils.isEmpty(string)) {
            this.bxp.parserJson(string);
        }
    }

    public boolean OK() {
        return this.bxq && this.bxr;
    }

    public void OL() {
        this.bxq = false;
        this.bxr = false;
    }

    public void d(BdUniqueId bdUniqueId) {
        if (!this.bxq) {
            HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_SYNC);
            String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
            if (activeVersion != null) {
                if (activeVersion.length() < 1) {
                    activeVersion = "0";
                }
                httpMessage.addParam("_active", activeVersion);
            }
            if (this.bru.aIK != null && !this.bru.aIK.isEmpty()) {
                httpMessage.addParam("_client_id", this.bru.aIK);
            } else {
                httpMessage.addParam("_client_id", "0");
            }
            if (bdUniqueId != null) {
                httpMessage.setTag(bdUniqueId);
            }
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void OM() {
        if (!this.bxr) {
            HttpMessage httpMessage = new HttpMessage(1021132);
            String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
            if (activeVersion != null) {
                if (activeVersion.length() < 1) {
                    activeVersion = "0";
                }
                httpMessage.addParam("_active", activeVersion);
            }
            httpMessage.addParam(HttpConstants.DEVICE_TYPE, Build.VERSION.SDK_INT);
            httpMessage.addParam("scene_from", q.Ef());
            httpMessage.addParam(HttpConstants.DEVICE_TYPE, Build.VERSION.SDK_INT);
            httpMessage.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void e(BdUniqueId bdUniqueId) {
        if (!this.bxr) {
            HttpMessage httpMessage = new HttpMessage(1021132);
            String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
            if (activeVersion != null) {
                if (activeVersion.length() < 1) {
                    activeVersion = "0";
                }
                httpMessage.addParam("_active", activeVersion);
            }
            httpMessage.addParam(HttpConstants.DEVICE_TYPE, Build.VERSION.SDK_INT);
            httpMessage.addParam("scene_from", q.Ef());
            httpMessage.addParam(HttpConstants.DEVICE_TYPE, Build.VERSION.SDK_INT);
            httpMessage.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            httpMessage.setTag(bdUniqueId);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public boolean ON() {
        bq bqVar = OJ().bxp;
        return (bqVar == null || bqVar.aMR == null || !bqVar.aMR.aPt || bqVar.aMO == null || bqVar.aMO.aOr == null || TextUtils.isEmpty(bqVar.aMO.aOr.aOB)) ? false : true;
    }

    public boolean OO() {
        bq bqVar = OJ().bxp;
        return (bqVar == null || bqVar.aMR == null || !bqVar.aMR.aPt || bqVar.aMO == null || bqVar.aMO.aOr == null || StringUtils.isNull(bqVar.aMO.aOr.aOC, true)) ? false : true;
    }

    public int OP() {
        if (this.bru == null || this.bru.aKz == null) {
            return 7;
        }
        return this.bru.aKz.aNL;
    }

    public String OQ() {
        return (this.bru == null || this.bru.aKz == null || TextUtils.isEmpty(this.bru.aKz.aNN)) ? "更多直播" : this.bru.aKz.aNN;
    }

    public String OR() {
        return (this.bru == null || this.bru.aKz == null || TextUtils.isEmpty(this.bru.aKz.aNO)) ? "更多推荐" : this.bru.aKz.aNO;
    }

    public int OS() {
        if (this.bru == null || this.bru.aKz == null) {
            return 0;
        }
        return this.bru.aKz.aNM;
    }

    public int OT() {
        if (this.bru == null || this.bru.aKz == null) {
            return 0;
        }
        return this.bru.aKz.showStyle;
    }
}

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
/* loaded from: classes11.dex */
public class a {
    private static volatile a bCa;
    public bq bCb;
    private boolean bCc;
    private boolean bCd;
    public an bwi;
    private HttpMessageListener syncListener = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_SYNC) { // from class: com.baidu.live.af.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021011 && (httpResponsedMessage instanceof AlaSyncHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    AlaSyncHttpResponseMessage alaSyncHttpResponseMessage = (AlaSyncHttpResponseMessage) httpResponsedMessage;
                    if (alaSyncHttpResponseMessage.QQ() != null) {
                        a.this.bwi = alaSyncHttpResponseMessage.QQ();
                        a.this.bCc = true;
                    }
                }
                if (a.this.bwi != null) {
                    TbadkCoreApplication.getInst().setAlaMenuToast(a.this.bwi.aMq);
                    TbadkCoreApplication.getInst().setAlaToastShowType(a.this.bwi.aMp);
                }
            }
        }
    };
    private HttpMessageListener bCe = new HttpMessageListener(1021132) { // from class: com.baidu.live.af.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021132 && (httpResponsedMessage instanceof LiveSyncHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    LiveSyncHttpResponseMessage liveSyncHttpResponseMessage = (LiveSyncHttpResponseMessage) httpResponsedMessage;
                    if (liveSyncHttpResponseMessage.QV() != null) {
                        a.this.bCb = liveSyncHttpResponseMessage.QV();
                        a.this.bCd = true;
                    }
                }
            }
        }
    };
    CustomMessageTask.CustomRunnable bCf = new CustomMessageTask.CustomRunnable() { // from class: com.baidu.live.af.a.3
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<String> run(CustomMessage customMessage) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (a.this.bwi != null && !TextUtils.isEmpty(a.this.bwi.aOF) && !TextUtils.isEmpty(a.this.bwi.aOE) && a.this.bwi.aOD == 1) {
                    jSONObject.putOpt("photo_url", a.this.bwi.aOF);
                    jSONObject.putOpt("resource_url", a.this.bwi.aOE);
                }
                if (a.this.bCb != null && a.this.bCb.aRy != null && a.this.bCb.aRy.Ff() && (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo())) {
                    jSONObject.putOpt("general_exchange_homepage_url", a.this.bCb.aRy.Fg());
                }
                return new CustomResponsedMessage<>(CmdConfigCustom.CMS_TBEAN_RESOURCE_URL_AND_PHOTO, jSONObject.toString());
            } catch (JSONException e) {
                return null;
            }
        }
    };

    public static a SE() {
        if (bCa == null) {
            synchronized (a.class) {
                if (bCa == null) {
                    bCa = new a();
                }
            }
        }
        return bCa;
    }

    private a() {
        this.syncListener.setPriority(Integer.MIN_VALUE);
        MessageManager.getInstance().registerListener(this.syncListener);
        this.bCe.setPriority(Integer.MIN_VALUE);
        MessageManager.getInstance().registerListener(this.bCe);
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMS_TBEAN_RESOURCE_URL_AND_PHOTO, this.bCf);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        this.bwi = new an(true);
        this.bCb = new bq();
        String string = com.baidu.live.d.Ba().getString("key_live_sync_data", "");
        if (!TextUtils.isEmpty(string)) {
            this.bCb.parserJson(string);
        }
    }

    public boolean SF() {
        return this.bCc && this.bCd;
    }

    public void SG() {
        this.bCc = false;
        this.bCd = false;
    }

    public void d(BdUniqueId bdUniqueId) {
        if (!this.bCc) {
            HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_SYNC);
            String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
            if (activeVersion != null) {
                if (activeVersion.length() < 1) {
                    activeVersion = "0";
                }
                httpMessage.addParam("_active", activeVersion);
            }
            if (this.bwi.aNx != null && !this.bwi.aNx.isEmpty()) {
                httpMessage.addParam("_client_id", this.bwi.aNx);
            } else {
                httpMessage.addParam("_client_id", "0");
            }
            if (bdUniqueId != null) {
                httpMessage.setTag(bdUniqueId);
            }
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void SH() {
        if (!this.bCd) {
            HttpMessage httpMessage = new HttpMessage(1021132);
            String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
            if (activeVersion != null) {
                if (activeVersion.length() < 1) {
                    activeVersion = "0";
                }
                httpMessage.addParam("_active", activeVersion);
            }
            httpMessage.addParam(HttpConstants.DEVICE_TYPE, Build.VERSION.SDK_INT);
            httpMessage.addParam("scene_from", q.Ia());
            httpMessage.addParam(HttpConstants.DEVICE_TYPE, Build.VERSION.SDK_INT);
            httpMessage.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void e(BdUniqueId bdUniqueId) {
        if (!this.bCd) {
            HttpMessage httpMessage = new HttpMessage(1021132);
            String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
            if (activeVersion != null) {
                if (activeVersion.length() < 1) {
                    activeVersion = "0";
                }
                httpMessage.addParam("_active", activeVersion);
            }
            httpMessage.addParam(HttpConstants.DEVICE_TYPE, Build.VERSION.SDK_INT);
            httpMessage.addParam("scene_from", q.Ia());
            httpMessage.addParam(HttpConstants.DEVICE_TYPE, Build.VERSION.SDK_INT);
            httpMessage.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            httpMessage.setTag(bdUniqueId);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public boolean SI() {
        bq bqVar = SE().bCb;
        return (bqVar == null || bqVar.aRE == null || !bqVar.aRE.aUg || bqVar.aRB == null || bqVar.aRB.aTe == null || TextUtils.isEmpty(bqVar.aRB.aTe.aTo)) ? false : true;
    }

    public boolean SJ() {
        bq bqVar = SE().bCb;
        return (bqVar == null || bqVar.aRE == null || !bqVar.aRE.aUg || bqVar.aRB == null || bqVar.aRB.aTe == null || StringUtils.isNull(bqVar.aRB.aTe.aTp, true)) ? false : true;
    }

    public int SK() {
        if (this.bwi == null || this.bwi.aPm == null) {
            return 7;
        }
        return this.bwi.aPm.aSy;
    }

    public String SL() {
        return (this.bwi == null || this.bwi.aPm == null || TextUtils.isEmpty(this.bwi.aPm.aSA)) ? "更多直播" : this.bwi.aPm.aSA;
    }

    public String SM() {
        return (this.bwi == null || this.bwi.aPm == null || TextUtils.isEmpty(this.bwi.aPm.aSB)) ? "更多推荐" : this.bwi.aPm.aSB;
    }

    public int SN() {
        if (this.bwi == null || this.bwi.aPm == null) {
            return 0;
        }
        return this.bwi.aPm.aSz;
    }

    public int SO() {
        if (this.bwi == null || this.bwi.aPm == null) {
            return 0;
        }
        return this.bwi.aPm.showStyle;
    }
}

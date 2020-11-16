package com.baidu.live.aa;

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
import com.baidu.live.data.ak;
import com.baidu.live.data.bn;
import com.baidu.live.message.AlaSyncHttpResponseMessage;
import com.baidu.live.message.LiveSyncHttpResponseMessage;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.utils.p;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    private static volatile a bsg;
    public ak bms;
    public bn bsh;
    private boolean bsi;
    private boolean bsj;
    private HttpMessageListener syncListener = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_SYNC) { // from class: com.baidu.live.aa.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021011 && (httpResponsedMessage instanceof AlaSyncHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    AlaSyncHttpResponseMessage alaSyncHttpResponseMessage = (AlaSyncHttpResponseMessage) httpResponsedMessage;
                    if (alaSyncHttpResponseMessage.Ny() != null) {
                        a.this.bms = alaSyncHttpResponseMessage.Ny();
                        a.this.bsi = true;
                    }
                }
                if (a.this.bms != null) {
                    TbadkCoreApplication.getInst().setAlaMenuToast(a.this.bms.aIT);
                    TbadkCoreApplication.getInst().setAlaToastShowType(a.this.bms.aIS);
                }
            }
        }
    };
    private HttpMessageListener bsk = new HttpMessageListener(1021132) { // from class: com.baidu.live.aa.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021132 && (httpResponsedMessage instanceof LiveSyncHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    LiveSyncHttpResponseMessage liveSyncHttpResponseMessage = (LiveSyncHttpResponseMessage) httpResponsedMessage;
                    if (liveSyncHttpResponseMessage.ND() != null) {
                        a.this.bsh = liveSyncHttpResponseMessage.ND();
                        a.this.bsj = true;
                    }
                }
            }
        }
    };
    CustomMessageTask.CustomRunnable bsl = new CustomMessageTask.CustomRunnable() { // from class: com.baidu.live.aa.a.3
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<String> run(CustomMessage customMessage) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (a.this.bms != null && !TextUtils.isEmpty(a.this.bms.aLg) && !TextUtils.isEmpty(a.this.bms.aLf) && a.this.bms.aLe == 1) {
                    jSONObject.putOpt("photo_url", a.this.bms.aLg);
                    jSONObject.putOpt("resource_url", a.this.bms.aLf);
                }
                if (a.this.bsh != null && a.this.bsh.aNJ != null && a.this.bsh.aNJ.Ee() && (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo())) {
                    jSONObject.putOpt("general_exchange_homepage_url", a.this.bsh.aNJ.Ef());
                }
                return new CustomResponsedMessage<>(CmdConfigCustom.CMS_TBEAN_RESOURCE_URL_AND_PHOTO, jSONObject.toString());
            } catch (JSONException e) {
                return null;
            }
        }
    };

    public static a Ph() {
        if (bsg == null) {
            synchronized (a.class) {
                if (bsg == null) {
                    bsg = new a();
                }
            }
        }
        return bsg;
    }

    private a() {
        this.syncListener.setPriority(Integer.MIN_VALUE);
        MessageManager.getInstance().registerListener(this.syncListener);
        this.bsk.setPriority(Integer.MIN_VALUE);
        MessageManager.getInstance().registerListener(this.bsk);
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMS_TBEAN_RESOURCE_URL_AND_PHOTO, this.bsl);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        this.bms = new ak(true);
        this.bsh = new bn();
        String string = com.baidu.live.d.Aq().getString("key_live_sync_data", "");
        if (!TextUtils.isEmpty(string)) {
            this.bsh.parserJson(string);
        }
    }

    public boolean Pi() {
        return this.bsi && this.bsj;
    }

    public void Pj() {
        this.bsi = false;
        this.bsj = false;
    }

    public void d(BdUniqueId bdUniqueId) {
        if (!this.bsi) {
            HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_SYNC);
            String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
            if (activeVersion != null) {
                if (activeVersion.length() < 1) {
                    activeVersion = "0";
                }
                httpMessage.addParam("_active", activeVersion);
            }
            if (this.bms.aJY != null && !this.bms.aJY.isEmpty()) {
                httpMessage.addParam("_client_id", this.bms.aJY);
            } else {
                httpMessage.addParam("_client_id", "0");
            }
            if (bdUniqueId != null) {
                httpMessage.setTag(bdUniqueId);
            }
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void Pk() {
        if (!this.bsj) {
            HttpMessage httpMessage = new HttpMessage(1021132);
            String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
            if (activeVersion != null) {
                if (activeVersion.length() < 1) {
                    activeVersion = "0";
                }
                httpMessage.addParam("_active", activeVersion);
            }
            httpMessage.addParam(HttpConstants.DEVICE_TYPE, Build.VERSION.SDK_INT);
            httpMessage.addParam("scene_from", p.GI());
            httpMessage.addParam(HttpConstants.DEVICE_TYPE, Build.VERSION.SDK_INT);
            httpMessage.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void e(BdUniqueId bdUniqueId) {
        if (!this.bsj) {
            HttpMessage httpMessage = new HttpMessage(1021132);
            String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
            if (activeVersion != null) {
                if (activeVersion.length() < 1) {
                    activeVersion = "0";
                }
                httpMessage.addParam("_active", activeVersion);
            }
            httpMessage.addParam(HttpConstants.DEVICE_TYPE, Build.VERSION.SDK_INT);
            httpMessage.addParam("scene_from", p.GI());
            httpMessage.addParam(HttpConstants.DEVICE_TYPE, Build.VERSION.SDK_INT);
            httpMessage.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            httpMessage.setTag(bdUniqueId);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public boolean Pl() {
        bn bnVar = Ph().bsh;
        return (bnVar == null || bnVar.aNP == null || !bnVar.aNP.aQg || bnVar.aNM == null || bnVar.aNM.aPh == null || TextUtils.isEmpty(bnVar.aNM.aPh.aPo)) ? false : true;
    }

    public boolean Pm() {
        bn bnVar = Ph().bsh;
        return (bnVar == null || bnVar.aNP == null || !bnVar.aNP.aQg || bnVar.aNM == null || bnVar.aNM.aPh == null || StringUtils.isNull(bnVar.aNM.aPh.aPp, true)) ? false : true;
    }

    public int Pn() {
        if (this.bms == null || this.bms.aLK == null) {
            return 7;
        }
        return this.bms.aLK.aOH;
    }

    public String Po() {
        return (this.bms == null || this.bms.aLK == null || TextUtils.isEmpty(this.bms.aLK.aOJ)) ? "更多直播" : this.bms.aLK.aOJ;
    }

    public String Pp() {
        return (this.bms == null || this.bms.aLK == null || TextUtils.isEmpty(this.bms.aLK.aOK)) ? "更多推荐" : this.bms.aLK.aOK;
    }

    public int Pq() {
        if (this.bms == null || this.bms.aLK == null) {
            return 0;
        }
        return this.bms.aLK.aOI;
    }
}

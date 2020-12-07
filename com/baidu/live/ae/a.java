package com.baidu.live.ae;

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
import com.baidu.live.data.al;
import com.baidu.live.data.bo;
import com.baidu.live.message.AlaSyncHttpResponseMessage;
import com.baidu.live.message.LiveSyncHttpResponseMessage;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.utils.p;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    private static volatile a bxp;
    public al brA;
    public bo bxq;
    private boolean bxr;
    private boolean bxs;
    private HttpMessageListener syncListener = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_SYNC) { // from class: com.baidu.live.ae.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021011 && (httpResponsedMessage instanceof AlaSyncHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    AlaSyncHttpResponseMessage alaSyncHttpResponseMessage = (AlaSyncHttpResponseMessage) httpResponsedMessage;
                    if (alaSyncHttpResponseMessage.PR() != null) {
                        a.this.brA = alaSyncHttpResponseMessage.PR();
                        a.this.bxr = true;
                    }
                }
                if (a.this.brA != null) {
                    TbadkCoreApplication.getInst().setAlaMenuToast(a.this.brA.aLM);
                    TbadkCoreApplication.getInst().setAlaToastShowType(a.this.brA.aLL);
                }
            }
        }
    };
    private HttpMessageListener bxt = new HttpMessageListener(1021132) { // from class: com.baidu.live.ae.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021132 && (httpResponsedMessage instanceof LiveSyncHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    LiveSyncHttpResponseMessage liveSyncHttpResponseMessage = (LiveSyncHttpResponseMessage) httpResponsedMessage;
                    if (liveSyncHttpResponseMessage.PW() != null) {
                        a.this.bxq = liveSyncHttpResponseMessage.PW();
                        a.this.bxs = true;
                    }
                }
            }
        }
    };
    CustomMessageTask.CustomRunnable bxu = new CustomMessageTask.CustomRunnable() { // from class: com.baidu.live.ae.a.3
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<String> run(CustomMessage customMessage) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (a.this.brA != null && !TextUtils.isEmpty(a.this.brA.aOb) && !TextUtils.isEmpty(a.this.brA.aOa) && a.this.brA.aNZ == 1) {
                    jSONObject.putOpt("photo_url", a.this.brA.aOb);
                    jSONObject.putOpt("resource_url", a.this.brA.aOa);
                }
                if (a.this.bxq != null && a.this.bxq.aQJ != null && a.this.bxq.aQJ.FP() && (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo())) {
                    jSONObject.putOpt("general_exchange_homepage_url", a.this.bxq.aQJ.FQ());
                }
                return new CustomResponsedMessage<>(CmdConfigCustom.CMS_TBEAN_RESOURCE_URL_AND_PHOTO, jSONObject.toString());
            } catch (JSONException e) {
                return null;
            }
        }
    };

    public static a RB() {
        if (bxp == null) {
            synchronized (a.class) {
                if (bxp == null) {
                    bxp = new a();
                }
            }
        }
        return bxp;
    }

    private a() {
        this.syncListener.setPriority(Integer.MIN_VALUE);
        MessageManager.getInstance().registerListener(this.syncListener);
        this.bxt.setPriority(Integer.MIN_VALUE);
        MessageManager.getInstance().registerListener(this.bxt);
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMS_TBEAN_RESOURCE_URL_AND_PHOTO, this.bxu);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        this.brA = new al(true);
        this.bxq = new bo();
        String string = com.baidu.live.d.BM().getString("key_live_sync_data", "");
        if (!TextUtils.isEmpty(string)) {
            this.bxq.parserJson(string);
        }
    }

    public boolean RC() {
        return this.bxr && this.bxs;
    }

    public void RD() {
        this.bxr = false;
        this.bxs = false;
    }

    public void d(BdUniqueId bdUniqueId) {
        if (!this.bxr) {
            HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_SYNC);
            String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
            if (activeVersion != null) {
                if (activeVersion.length() < 1) {
                    activeVersion = "0";
                }
                httpMessage.addParam("_active", activeVersion);
            }
            if (this.brA.aMT != null && !this.brA.aMT.isEmpty()) {
                httpMessage.addParam("_client_id", this.brA.aMT);
            } else {
                httpMessage.addParam("_client_id", "0");
            }
            if (bdUniqueId != null) {
                httpMessage.setTag(bdUniqueId);
            }
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void RE() {
        if (!this.bxs) {
            HttpMessage httpMessage = new HttpMessage(1021132);
            String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
            if (activeVersion != null) {
                if (activeVersion.length() < 1) {
                    activeVersion = "0";
                }
                httpMessage.addParam("_active", activeVersion);
            }
            httpMessage.addParam(HttpConstants.DEVICE_TYPE, Build.VERSION.SDK_INT);
            httpMessage.addParam("scene_from", p.Iz());
            httpMessage.addParam(HttpConstants.DEVICE_TYPE, Build.VERSION.SDK_INT);
            httpMessage.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void e(BdUniqueId bdUniqueId) {
        if (!this.bxs) {
            HttpMessage httpMessage = new HttpMessage(1021132);
            String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
            if (activeVersion != null) {
                if (activeVersion.length() < 1) {
                    activeVersion = "0";
                }
                httpMessage.addParam("_active", activeVersion);
            }
            httpMessage.addParam(HttpConstants.DEVICE_TYPE, Build.VERSION.SDK_INT);
            httpMessage.addParam("scene_from", p.Iz());
            httpMessage.addParam(HttpConstants.DEVICE_TYPE, Build.VERSION.SDK_INT);
            httpMessage.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            httpMessage.setTag(bdUniqueId);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public boolean RF() {
        bo boVar = RB().bxq;
        return (boVar == null || boVar.aQP == null || !boVar.aQP.aTi || boVar.aQM == null || boVar.aQM.aSj == null || TextUtils.isEmpty(boVar.aQM.aSj.aSq)) ? false : true;
    }

    public boolean RG() {
        bo boVar = RB().bxq;
        return (boVar == null || boVar.aQP == null || !boVar.aQP.aTi || boVar.aQM == null || boVar.aQM.aSj == null || StringUtils.isNull(boVar.aQM.aSj.aSr, true)) ? false : true;
    }

    public int RH() {
        if (this.brA == null || this.brA.aOF == null) {
            return 7;
        }
        return this.brA.aOF.aRJ;
    }

    public String RI() {
        return (this.brA == null || this.brA.aOF == null || TextUtils.isEmpty(this.brA.aOF.aRL)) ? "更多直播" : this.brA.aOF.aRL;
    }

    public String RJ() {
        return (this.brA == null || this.brA.aOF == null || TextUtils.isEmpty(this.brA.aOF.aRM)) ? "更多推荐" : this.brA.aOF.aRM;
    }

    public int RK() {
        if (this.brA == null || this.brA.aOF == null) {
            return 0;
        }
        return this.brA.aOF.aRK;
    }
}

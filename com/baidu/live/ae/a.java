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
import com.baidu.live.data.ar;
import com.baidu.live.data.bv;
import com.baidu.live.message.AlaSyncHttpResponseMessage;
import com.baidu.live.message.LiveSyncHttpResponseMessage;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.utils.q;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    private static volatile a bAR;
    public bv bAS;
    private boolean bAT;
    private boolean bAU;
    public ar buX;
    private HttpMessageListener syncListener = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_SYNC) { // from class: com.baidu.live.ae.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021011 && (httpResponsedMessage instanceof AlaSyncHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    AlaSyncHttpResponseMessage alaSyncHttpResponseMessage = (AlaSyncHttpResponseMessage) httpResponsedMessage;
                    if (alaSyncHttpResponseMessage.Ot() != null) {
                        a.this.buX = alaSyncHttpResponseMessage.Ot();
                        a.this.bAT = true;
                    }
                }
                if (a.this.buX != null) {
                    TbadkCoreApplication.getInst().setAlaMenuToast(a.this.buX.aKh);
                    TbadkCoreApplication.getInst().setAlaToastShowType(a.this.buX.aKg);
                }
            }
        }
    };
    private HttpMessageListener bAV = new HttpMessageListener(1021132) { // from class: com.baidu.live.ae.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021132 && (httpResponsedMessage instanceof LiveSyncHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    LiveSyncHttpResponseMessage liveSyncHttpResponseMessage = (LiveSyncHttpResponseMessage) httpResponsedMessage;
                    if (liveSyncHttpResponseMessage.Oy() != null) {
                        a.this.bAS = liveSyncHttpResponseMessage.Oy();
                        a.this.bAU = true;
                    }
                }
            }
        }
    };
    CustomMessageTask.CustomRunnable bAW = new CustomMessageTask.CustomRunnable() { // from class: com.baidu.live.ae.a.3
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<String> run(CustomMessage customMessage) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (a.this.buX != null && !TextUtils.isEmpty(a.this.buX.aMD) && !TextUtils.isEmpty(a.this.buX.aMC) && a.this.buX.aMB == 1) {
                    jSONObject.putOpt("photo_url", a.this.buX.aMD);
                    jSONObject.putOpt("resource_url", a.this.buX.aMC);
                }
                if (a.this.bAS != null && a.this.bAS.aPJ != null && a.this.bAS.aPJ.Cx() && (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo())) {
                    jSONObject.putOpt("general_exchange_homepage_url", a.this.bAS.aPJ.Cy());
                }
                return new CustomResponsedMessage<>(CmdConfigCustom.CMS_TBEAN_RESOURCE_URL_AND_PHOTO, jSONObject.toString());
            } catch (JSONException e) {
                return null;
            }
        }
    };

    public static a Qj() {
        if (bAR == null) {
            synchronized (a.class) {
                if (bAR == null) {
                    bAR = new a();
                }
            }
        }
        return bAR;
    }

    private a() {
        this.syncListener.setPriority(Integer.MIN_VALUE);
        MessageManager.getInstance().registerListener(this.syncListener);
        this.bAV.setPriority(Integer.MIN_VALUE);
        MessageManager.getInstance().registerListener(this.bAV);
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMS_TBEAN_RESOURCE_URL_AND_PHOTO, this.bAW);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        this.buX = new ar(true);
        this.bAS = new bv();
        String string = com.baidu.live.d.xc().getString("key_live_sync_data", "");
        if (!TextUtils.isEmpty(string)) {
            this.bAS.parserJson(string);
        }
    }

    public boolean Qk() {
        return this.bAT && this.bAU;
    }

    public void Ql() {
        this.bAT = false;
    }

    public void Qm() {
        this.bAT = false;
        this.bAU = false;
    }

    public void d(BdUniqueId bdUniqueId) {
        if (!this.bAT) {
            HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_SYNC);
            String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
            if (activeVersion != null) {
                if (activeVersion.length() < 1) {
                    activeVersion = "0";
                }
                httpMessage.addParam("_active", activeVersion);
            }
            if (this.buX.aLu != null && !this.buX.aLu.isEmpty()) {
                httpMessage.addParam("_client_id", this.buX.aLu);
            } else {
                httpMessage.addParam("_client_id", "0");
            }
            if (bdUniqueId != null) {
                httpMessage.setTag(bdUniqueId);
            }
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void Qn() {
        if (!this.bAU) {
            HttpMessage httpMessage = new HttpMessage(1021132);
            String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
            if (activeVersion != null) {
                if (activeVersion.length() < 1) {
                    activeVersion = "0";
                }
                httpMessage.addParam("_active", activeVersion);
            }
            httpMessage.addParam(HttpConstants.DEVICE_TYPE, Build.VERSION.SDK_INT);
            httpMessage.addParam("scene_from", q.Fv());
            httpMessage.addParam(HttpConstants.DEVICE_TYPE, Build.VERSION.SDK_INT);
            httpMessage.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void e(BdUniqueId bdUniqueId) {
        if (!this.bAU) {
            HttpMessage httpMessage = new HttpMessage(1021132);
            String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
            if (activeVersion != null) {
                if (activeVersion.length() < 1) {
                    activeVersion = "0";
                }
                httpMessage.addParam("_active", activeVersion);
            }
            httpMessage.addParam(HttpConstants.DEVICE_TYPE, Build.VERSION.SDK_INT);
            httpMessage.addParam("scene_from", q.Fv());
            httpMessage.addParam(HttpConstants.DEVICE_TYPE, Build.VERSION.SDK_INT);
            httpMessage.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            httpMessage.setTag(bdUniqueId);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public boolean Qo() {
        bv bvVar = Qj().bAS;
        return (bvVar == null || bvVar.aPP == null || !bvVar.aPP.aSv || bvVar.aPM == null || bvVar.aPM.aRu == null || TextUtils.isEmpty(bvVar.aPM.aRu.aRD)) ? false : true;
    }

    public boolean Qp() {
        bv bvVar = Qj().bAS;
        return (bvVar == null || bvVar.aPP == null || !bvVar.aPP.aSv || bvVar.aPM == null || bvVar.aPM.aRu == null || StringUtils.isNull(bvVar.aPM.aRu.aRE, true)) ? false : true;
    }

    public int Qq() {
        if (this.buX == null || this.buX.aNm == null) {
            return 7;
        }
        return this.buX.aNm.aQM;
    }

    public String Qr() {
        return (this.buX == null || this.buX.aNm == null || TextUtils.isEmpty(this.buX.aNm.aQO)) ? "更多直播" : this.buX.aNm.aQO;
    }

    public String Qs() {
        return (this.buX == null || this.buX.aNm == null || TextUtils.isEmpty(this.buX.aNm.aQP)) ? "更多推荐" : this.buX.aNm.aQP;
    }

    public int Qt() {
        if (this.buX == null || this.buX.aNm == null) {
            return 0;
        }
        return this.buX.aNm.aQN;
    }

    public int Qu() {
        if (this.buX == null || this.buX.aNm == null) {
            return 0;
        }
        return this.buX.aNm.showStyle;
    }
}

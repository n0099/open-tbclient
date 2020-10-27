package com.baidu.live.z;

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
import com.baidu.live.data.aj;
import com.baidu.live.data.bm;
import com.baidu.live.message.AlaSyncHttpResponseMessage;
import com.baidu.live.message.LiveSyncHttpResponseMessage;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.utils.p;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    private static volatile a bsx;
    public aj bmJ;
    private boolean bsA;
    public bm bsy;
    private boolean bsz;
    private HttpMessageListener syncListener = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_SYNC) { // from class: com.baidu.live.z.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021011 && (httpResponsedMessage instanceof AlaSyncHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    AlaSyncHttpResponseMessage alaSyncHttpResponseMessage = (AlaSyncHttpResponseMessage) httpResponsedMessage;
                    if (alaSyncHttpResponseMessage.NH() != null) {
                        a.this.bmJ = alaSyncHttpResponseMessage.NH();
                        a.this.bsz = true;
                    }
                }
                if (a.this.bmJ != null) {
                    TbadkCoreApplication.getInst().setAlaMenuToast(a.this.bmJ.aJE);
                    TbadkCoreApplication.getInst().setAlaToastShowType(a.this.bmJ.aJD);
                }
            }
        }
    };
    private HttpMessageListener bsB = new HttpMessageListener(1021132) { // from class: com.baidu.live.z.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021132 && (httpResponsedMessage instanceof LiveSyncHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    LiveSyncHttpResponseMessage liveSyncHttpResponseMessage = (LiveSyncHttpResponseMessage) httpResponsedMessage;
                    if (liveSyncHttpResponseMessage.NM() != null) {
                        a.this.bsy = liveSyncHttpResponseMessage.NM();
                        a.this.bsA = true;
                    }
                }
            }
        }
    };
    CustomMessageTask.CustomRunnable bsC = new CustomMessageTask.CustomRunnable() { // from class: com.baidu.live.z.a.3
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<String> run(CustomMessage customMessage) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (a.this.bmJ != null && !TextUtils.isEmpty(a.this.bmJ.aLR) && !TextUtils.isEmpty(a.this.bmJ.aLQ) && a.this.bmJ.aLP == 1) {
                    jSONObject.putOpt("photo_url", a.this.bmJ.aLR);
                    jSONObject.putOpt("resource_url", a.this.bmJ.aLQ);
                }
                if (a.this.bsy != null && a.this.bsy.aOx != null && a.this.bsy.aOx.Eq() && (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo())) {
                    jSONObject.putOpt("general_exchange_homepage_url", a.this.bsy.aOx.Er());
                }
                return new CustomResponsedMessage<>(CmdConfigCustom.CMS_TBEAN_RESOURCE_URL_AND_PHOTO, jSONObject.toString());
            } catch (JSONException e) {
                return null;
            }
        }
    };

    public static a Pq() {
        if (bsx == null) {
            synchronized (a.class) {
                if (bsx == null) {
                    bsx = new a();
                }
            }
        }
        return bsx;
    }

    private a() {
        MessageManager.getInstance().registerListener(this.syncListener);
        MessageManager.getInstance().registerListener(this.bsB);
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMS_TBEAN_RESOURCE_URL_AND_PHOTO, this.bsC);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        this.bmJ = new aj(true);
        this.bsy = new bm();
        String string = com.baidu.live.d.AZ().getString("key_live_sync_data", "");
        if (!TextUtils.isEmpty(string)) {
            this.bsy.parserJson(string);
        }
    }

    public void Pr() {
        this.bsz = false;
        this.bsA = false;
    }

    public void d(BdUniqueId bdUniqueId) {
        if (!this.bsz) {
            HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_SYNC);
            String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
            if (activeVersion != null) {
                if (activeVersion.length() < 1) {
                    activeVersion = "0";
                }
                httpMessage.addParam("_active", activeVersion);
            }
            if (this.bmJ.aKJ != null && !this.bmJ.aKJ.isEmpty()) {
                httpMessage.addParam("_client_id", this.bmJ.aKJ);
            } else {
                httpMessage.addParam("_client_id", "0");
            }
            if (bdUniqueId != null) {
                httpMessage.setTag(bdUniqueId);
            }
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void Ps() {
        if (!this.bsA) {
            HttpMessage httpMessage = new HttpMessage(1021132);
            String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
            if (activeVersion != null) {
                if (activeVersion.length() < 1) {
                    activeVersion = "0";
                }
                httpMessage.addParam("_active", activeVersion);
            }
            httpMessage.addParam(HttpConstants.DEVICE_TYPE, Build.VERSION.SDK_INT);
            httpMessage.addParam("scene_from", p.GQ());
            httpMessage.addParam(HttpConstants.DEVICE_TYPE, Build.VERSION.SDK_INT);
            httpMessage.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void e(BdUniqueId bdUniqueId) {
        if (!this.bsA) {
            HttpMessage httpMessage = new HttpMessage(1021132);
            String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
            if (activeVersion != null) {
                if (activeVersion.length() < 1) {
                    activeVersion = "0";
                }
                httpMessage.addParam("_active", activeVersion);
            }
            httpMessage.addParam(HttpConstants.DEVICE_TYPE, Build.VERSION.SDK_INT);
            httpMessage.addParam("scene_from", p.GQ());
            httpMessage.addParam(HttpConstants.DEVICE_TYPE, Build.VERSION.SDK_INT);
            httpMessage.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            httpMessage.setTag(bdUniqueId);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public boolean Pt() {
        bm bmVar = Pq().bsy;
        return (bmVar == null || bmVar.aOD == null || !bmVar.aOD.aQP || bmVar.aOA == null || bmVar.aOA.aPQ == null || TextUtils.isEmpty(bmVar.aOA.aPQ.aPX)) ? false : true;
    }

    public boolean Pu() {
        bm bmVar = Pq().bsy;
        return (bmVar == null || bmVar.aOD == null || !bmVar.aOD.aQP || bmVar.aOA == null || bmVar.aOA.aPQ == null || StringUtils.isNull(bmVar.aOA.aPQ.aPY, true)) ? false : true;
    }

    public int Pv() {
        if (this.bmJ == null || this.bmJ.aMv == null) {
            return 7;
        }
        return this.bmJ.aMv.aPv;
    }

    public String Pw() {
        return (this.bmJ == null || this.bmJ.aMv == null || TextUtils.isEmpty(this.bmJ.aMv.aPx)) ? "更多直播" : this.bmJ.aMv.aPx;
    }

    public String Px() {
        return (this.bmJ == null || this.bmJ.aMv == null || TextUtils.isEmpty(this.bmJ.aMv.aPy)) ? "更多推荐" : this.bmJ.aMv.aPy;
    }

    public int Py() {
        if (this.bmJ == null || this.bmJ.aMv == null) {
            return 0;
        }
        return this.bmJ.aMv.aPw;
    }
}

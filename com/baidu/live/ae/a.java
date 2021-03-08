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
/* loaded from: classes10.dex */
public class a {
    private static volatile a bCr;
    public bv bCs;
    private boolean bCt;
    private boolean bCu;
    public ar bwx;
    private HttpMessageListener syncListener = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_SYNC) { // from class: com.baidu.live.ae.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021011 && (httpResponsedMessage instanceof AlaSyncHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    AlaSyncHttpResponseMessage alaSyncHttpResponseMessage = (AlaSyncHttpResponseMessage) httpResponsedMessage;
                    if (alaSyncHttpResponseMessage.Ow() != null) {
                        a.this.bwx = alaSyncHttpResponseMessage.Ow();
                        a.this.bCt = true;
                    }
                }
                if (a.this.bwx != null) {
                    TbadkCoreApplication.getInst().setAlaMenuToast(a.this.bwx.aLH);
                    TbadkCoreApplication.getInst().setAlaToastShowType(a.this.bwx.aLG);
                }
            }
        }
    };
    private HttpMessageListener bCv = new HttpMessageListener(1021132) { // from class: com.baidu.live.ae.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021132 && (httpResponsedMessage instanceof LiveSyncHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    LiveSyncHttpResponseMessage liveSyncHttpResponseMessage = (LiveSyncHttpResponseMessage) httpResponsedMessage;
                    if (liveSyncHttpResponseMessage.OB() != null) {
                        a.this.bCs = liveSyncHttpResponseMessage.OB();
                        a.this.bCu = true;
                    }
                }
            }
        }
    };
    CustomMessageTask.CustomRunnable bCw = new CustomMessageTask.CustomRunnable() { // from class: com.baidu.live.ae.a.3
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<String> run(CustomMessage customMessage) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (a.this.bwx != null && !TextUtils.isEmpty(a.this.bwx.aOd) && !TextUtils.isEmpty(a.this.bwx.aOc) && a.this.bwx.aOb == 1) {
                    jSONObject.putOpt("photo_url", a.this.bwx.aOd);
                    jSONObject.putOpt("resource_url", a.this.bwx.aOc);
                }
                if (a.this.bCs != null && a.this.bCs.aRj != null && a.this.bCs.aRj.CA() && (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo())) {
                    jSONObject.putOpt("general_exchange_homepage_url", a.this.bCs.aRj.CB());
                }
                return new CustomResponsedMessage<>(CmdConfigCustom.CMS_TBEAN_RESOURCE_URL_AND_PHOTO, jSONObject.toString());
            } catch (JSONException e) {
                return null;
            }
        }
    };

    public static a Qm() {
        if (bCr == null) {
            synchronized (a.class) {
                if (bCr == null) {
                    bCr = new a();
                }
            }
        }
        return bCr;
    }

    private a() {
        this.syncListener.setPriority(Integer.MIN_VALUE);
        MessageManager.getInstance().registerListener(this.syncListener);
        this.bCv.setPriority(Integer.MIN_VALUE);
        MessageManager.getInstance().registerListener(this.bCv);
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMS_TBEAN_RESOURCE_URL_AND_PHOTO, this.bCw);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        this.bwx = new ar(true);
        this.bCs = new bv();
        String string = com.baidu.live.d.xf().getString("key_live_sync_data", "");
        if (!TextUtils.isEmpty(string)) {
            this.bCs.parserJson(string);
        }
    }

    public boolean Qn() {
        return this.bCt && this.bCu;
    }

    public void Qo() {
        this.bCt = false;
    }

    public void Qp() {
        this.bCt = false;
        this.bCu = false;
    }

    public void d(BdUniqueId bdUniqueId) {
        if (!this.bCt) {
            HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_SYNC);
            String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
            if (activeVersion != null) {
                if (activeVersion.length() < 1) {
                    activeVersion = "0";
                }
                httpMessage.addParam("_active", activeVersion);
            }
            if (this.bwx.aMU != null && !this.bwx.aMU.isEmpty()) {
                httpMessage.addParam("_client_id", this.bwx.aMU);
            } else {
                httpMessage.addParam("_client_id", "0");
            }
            if (bdUniqueId != null) {
                httpMessage.setTag(bdUniqueId);
            }
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void Qq() {
        if (!this.bCu) {
            HttpMessage httpMessage = new HttpMessage(1021132);
            String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
            if (activeVersion != null) {
                if (activeVersion.length() < 1) {
                    activeVersion = "0";
                }
                httpMessage.addParam("_active", activeVersion);
            }
            httpMessage.addParam(HttpConstants.DEVICE_TYPE, Build.VERSION.SDK_INT);
            httpMessage.addParam("scene_from", q.Fy());
            httpMessage.addParam(HttpConstants.DEVICE_TYPE, Build.VERSION.SDK_INT);
            httpMessage.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void e(BdUniqueId bdUniqueId) {
        if (!this.bCu) {
            HttpMessage httpMessage = new HttpMessage(1021132);
            String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
            if (activeVersion != null) {
                if (activeVersion.length() < 1) {
                    activeVersion = "0";
                }
                httpMessage.addParam("_active", activeVersion);
            }
            httpMessage.addParam(HttpConstants.DEVICE_TYPE, Build.VERSION.SDK_INT);
            httpMessage.addParam("scene_from", q.Fy());
            httpMessage.addParam(HttpConstants.DEVICE_TYPE, Build.VERSION.SDK_INT);
            httpMessage.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            httpMessage.setTag(bdUniqueId);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public boolean Qr() {
        bv bvVar = Qm().bCs;
        return (bvVar == null || bvVar.aRp == null || !bvVar.aRp.aTV || bvVar.aRm == null || bvVar.aRm.aSU == null || TextUtils.isEmpty(bvVar.aRm.aSU.aTd)) ? false : true;
    }

    public boolean Qs() {
        bv bvVar = Qm().bCs;
        return (bvVar == null || bvVar.aRp == null || !bvVar.aRp.aTV || bvVar.aRm == null || bvVar.aRm.aSU == null || StringUtils.isNull(bvVar.aRm.aSU.aTe, true)) ? false : true;
    }

    public int Qt() {
        if (this.bwx == null || this.bwx.aOM == null) {
            return 7;
        }
        return this.bwx.aOM.aSm;
    }

    public String Qu() {
        return (this.bwx == null || this.bwx.aOM == null || TextUtils.isEmpty(this.bwx.aOM.aSo)) ? "更多直播" : this.bwx.aOM.aSo;
    }

    public String Qv() {
        return (this.bwx == null || this.bwx.aOM == null || TextUtils.isEmpty(this.bwx.aOM.aSp)) ? "更多推荐" : this.bwx.aOM.aSp;
    }

    public int Qw() {
        if (this.bwx == null || this.bwx.aOM == null) {
            return 0;
        }
        return this.bwx.aOM.aSn;
    }

    public int Qx() {
        if (this.bwx == null || this.bwx.aOM == null) {
            return 0;
        }
        return this.bwx.aOM.showStyle;
    }
}

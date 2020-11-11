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
    private static volatile a btS;
    public ak bod;
    public bn btT;
    private boolean btU;
    private boolean btV;
    private HttpMessageListener syncListener = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_SYNC) { // from class: com.baidu.live.aa.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021011 && (httpResponsedMessage instanceof AlaSyncHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    AlaSyncHttpResponseMessage alaSyncHttpResponseMessage = (AlaSyncHttpResponseMessage) httpResponsedMessage;
                    if (alaSyncHttpResponseMessage.Oh() != null) {
                        a.this.bod = alaSyncHttpResponseMessage.Oh();
                        a.this.btU = true;
                    }
                }
                if (a.this.bod != null) {
                    TbadkCoreApplication.getInst().setAlaMenuToast(a.this.bod.aKE);
                    TbadkCoreApplication.getInst().setAlaToastShowType(a.this.bod.aKD);
                }
            }
        }
    };
    private HttpMessageListener btW = new HttpMessageListener(1021132) { // from class: com.baidu.live.aa.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021132 && (httpResponsedMessage instanceof LiveSyncHttpResponseMessage)) {
                if (httpResponsedMessage.getError() == 0) {
                    LiveSyncHttpResponseMessage liveSyncHttpResponseMessage = (LiveSyncHttpResponseMessage) httpResponsedMessage;
                    if (liveSyncHttpResponseMessage.Om() != null) {
                        a.this.btT = liveSyncHttpResponseMessage.Om();
                        a.this.btV = true;
                    }
                }
            }
        }
    };
    CustomMessageTask.CustomRunnable btX = new CustomMessageTask.CustomRunnable() { // from class: com.baidu.live.aa.a.3
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<String> run(CustomMessage customMessage) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (a.this.bod != null && !TextUtils.isEmpty(a.this.bod.aMR) && !TextUtils.isEmpty(a.this.bod.aMQ) && a.this.bod.aMP == 1) {
                    jSONObject.putOpt("photo_url", a.this.bod.aMR);
                    jSONObject.putOpt("resource_url", a.this.bod.aMQ);
                }
                if (a.this.btT != null && a.this.btT.aPu != null && a.this.btT.aPu.EN() && (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo())) {
                    jSONObject.putOpt("general_exchange_homepage_url", a.this.btT.aPu.EO());
                }
                return new CustomResponsedMessage<>(CmdConfigCustom.CMS_TBEAN_RESOURCE_URL_AND_PHOTO, jSONObject.toString());
            } catch (JSONException e) {
                return null;
            }
        }
    };

    public static a PQ() {
        if (btS == null) {
            synchronized (a.class) {
                if (btS == null) {
                    btS = new a();
                }
            }
        }
        return btS;
    }

    private a() {
        this.syncListener.setPriority(Integer.MIN_VALUE);
        MessageManager.getInstance().registerListener(this.syncListener);
        this.btW.setPriority(Integer.MIN_VALUE);
        MessageManager.getInstance().registerListener(this.btW);
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMS_TBEAN_RESOURCE_URL_AND_PHOTO, this.btX);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        this.bod = new ak(true);
        this.btT = new bn();
        String string = com.baidu.live.d.AZ().getString("key_live_sync_data", "");
        if (!TextUtils.isEmpty(string)) {
            this.btT.parserJson(string);
        }
    }

    public boolean PR() {
        return this.btU && this.btV;
    }

    public void PS() {
        this.btU = false;
        this.btV = false;
    }

    public void d(BdUniqueId bdUniqueId) {
        if (!this.btU) {
            HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_SYNC);
            String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
            if (activeVersion != null) {
                if (activeVersion.length() < 1) {
                    activeVersion = "0";
                }
                httpMessage.addParam("_active", activeVersion);
            }
            if (this.bod.aLJ != null && !this.bod.aLJ.isEmpty()) {
                httpMessage.addParam("_client_id", this.bod.aLJ);
            } else {
                httpMessage.addParam("_client_id", "0");
            }
            if (bdUniqueId != null) {
                httpMessage.setTag(bdUniqueId);
            }
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void PT() {
        if (!this.btV) {
            HttpMessage httpMessage = new HttpMessage(1021132);
            String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
            if (activeVersion != null) {
                if (activeVersion.length() < 1) {
                    activeVersion = "0";
                }
                httpMessage.addParam("_active", activeVersion);
            }
            httpMessage.addParam(HttpConstants.DEVICE_TYPE, Build.VERSION.SDK_INT);
            httpMessage.addParam("scene_from", p.Hr());
            httpMessage.addParam(HttpConstants.DEVICE_TYPE, Build.VERSION.SDK_INT);
            httpMessage.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void e(BdUniqueId bdUniqueId) {
        if (!this.btV) {
            HttpMessage httpMessage = new HttpMessage(1021132);
            String activeVersion = TbadkCoreApplication.getInst().getActiveVersion();
            if (activeVersion != null) {
                if (activeVersion.length() < 1) {
                    activeVersion = "0";
                }
                httpMessage.addParam("_active", activeVersion);
            }
            httpMessage.addParam(HttpConstants.DEVICE_TYPE, Build.VERSION.SDK_INT);
            httpMessage.addParam("scene_from", p.Hr());
            httpMessage.addParam(HttpConstants.DEVICE_TYPE, Build.VERSION.SDK_INT);
            httpMessage.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            httpMessage.setTag(bdUniqueId);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public boolean PU() {
        bn bnVar = PQ().btT;
        return (bnVar == null || bnVar.aPA == null || !bnVar.aPA.aRR || bnVar.aPx == null || bnVar.aPx.aQS == null || TextUtils.isEmpty(bnVar.aPx.aQS.aQZ)) ? false : true;
    }

    public boolean PV() {
        bn bnVar = PQ().btT;
        return (bnVar == null || bnVar.aPA == null || !bnVar.aPA.aRR || bnVar.aPx == null || bnVar.aPx.aQS == null || StringUtils.isNull(bnVar.aPx.aQS.aRa, true)) ? false : true;
    }

    public int PW() {
        if (this.bod == null || this.bod.aNv == null) {
            return 7;
        }
        return this.bod.aNv.aQs;
    }

    public String PX() {
        return (this.bod == null || this.bod.aNv == null || TextUtils.isEmpty(this.bod.aNv.aQu)) ? "更多直播" : this.bod.aNv.aQu;
    }

    public String PY() {
        return (this.bod == null || this.bod.aNv == null || TextUtils.isEmpty(this.bod.aNv.aQv)) ? "更多推荐" : this.bod.aNv.aQv;
    }

    public int PZ() {
        if (this.bod == null || this.bod.aNv == null) {
            return 0;
        }
        return this.bod.aNv.aQt;
    }
}

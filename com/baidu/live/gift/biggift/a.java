package com.baidu.live.gift.biggift;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.stats.AlaStatManager;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.gift.a.c;
import com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout;
import com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView;
import com.baidu.live.gift.dynamicGift.AlaDynamicVideoGiftLayout;
import com.baidu.live.gift.g;
import com.baidu.live.gift.j;
import com.baidu.live.gift.v;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.ubc.UbcDebugItem;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import java.util.ArrayList;
import java.util.Collections;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    private j aYB;
    private boolean aYD;
    private int aYE;
    private AlaDynamicVideoGiftLayout aYF;
    private AlaDynamicGiftLayout aYG;
    private AlaDynamicGiftSmallGiftStyleView aYH;
    private int aYI;
    private int aYJ;
    private Context mContext;
    private boolean aXd = false;
    private b aYK = new b() { // from class: com.baidu.live.gift.biggift.a.1
        @Override // com.baidu.live.gift.biggift.b
        public void l(com.baidu.live.gift.a.c cVar) {
            a.this.aYD = true;
            cVar.aQ(System.currentTimeMillis());
        }

        @Override // com.baidu.live.gift.biggift.b
        public void eq(int i) {
        }

        @Override // com.baidu.live.gift.biggift.b
        public void m(com.baidu.live.gift.a.c cVar) {
            a.this.i(cVar);
            a.this.aYD = false;
            a.this.aYB.HL();
            a.this.IN();
        }
    };
    private ArrayList<com.baidu.live.gift.a.c> aYC = new ArrayList<>();

    public a(Context context, j jVar) {
        this.aYE = 0;
        this.mContext = context;
        this.aYB = jVar;
        this.aYE = 0;
    }

    public void h(com.baidu.live.gift.a.c cVar) {
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            long j = cVar.bcU;
            cVar.bcU = 1L;
            for (int i = 0; i < j; i++) {
                com.baidu.live.gift.a.c clone = cVar.clone();
                if (clone != null) {
                    if (cVar.priority == 11) {
                        this.aYC.add(0, clone);
                    } else {
                        this.aYC.add(clone);
                    }
                    if (clone.bcX) {
                        LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_ENTER_LIST, clone.chatMCastId, clone.ensureMCastId, clone.giftId, "");
                    }
                }
            }
            try {
                IK();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void IK() {
        if (this.aYC != null) {
            int i = com.baidu.live.ae.a.RB().brA != null ? com.baidu.live.ae.a.RB().brA.aOn : 0;
            if (i > 0 && this.aYC.size() > i) {
                Collections.sort(this.aYC, new c.a());
                int max = Math.max((int) (i * 0.7f), 1);
                ArrayList arrayList = new ArrayList(this.aYC.subList(0, max));
                while (true) {
                    int i2 = max;
                    if (i2 < this.aYC.size()) {
                        if (this.aYC.get(i2) == null || !this.aYC.get(i2).bda) {
                            max = i2 + 1;
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 1));
                            break;
                        }
                    } else {
                        break;
                    }
                }
                this.aYC.clear();
                this.aYC.addAll(arrayList);
            }
        }
    }

    public void IL() {
        if (!IQ()) {
            IN();
        }
    }

    public void IM() {
        if (this.aYD) {
            if (this.aYF != null) {
                this.aYF.stopAnim();
            }
            if (this.aYG != null) {
                this.aYG.stopAnim();
            }
            if (this.aYH != null) {
                this.aYH.stopAnim();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(com.baidu.live.gift.a.c cVar) {
        if (cVar != null && cVar.bcX) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(LogConfig.LOG_GIFT_ID, cVar.giftId);
                jSONObject.put("gift_count", cVar.bcU);
                jSONObject.put("sender_uk", EncryptionHelper.getEncryptionUserId(cVar.userId));
                jSONObject.put("show_stime", cVar.JI());
                jSONObject.put("show_ctime", System.currentTimeMillis());
                if (cVar.bde) {
                    jSONObject.put("from_recovery", 1);
                }
            } catch (JSONException e) {
                BdLog.e(e);
            }
            UbcStatisticManager.getInstance().debugException(new UbcDebugItem("author_liveroom", UbcStatConstant.DebugContentValue.GIFT, jSONObject), "gift_show");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IN() {
        if (this.aYC.isEmpty()) {
            this.aYB.HJ();
            IP();
            return;
        }
        com.baidu.live.gift.a.c IO = IO();
        if (IO == null) {
            IN();
        } else {
            j(IO);
        }
    }

    private com.baidu.live.gift.a.c IO() {
        if (this.aYC.isEmpty()) {
            return null;
        }
        return this.aYC.remove(0);
    }

    private void IP() {
        this.aYB.HL();
    }

    private void j(com.baidu.live.gift.a.c cVar) {
        com.baidu.live.gift.c hP;
        if (cVar != null) {
            boolean z = UtilHelper.getRealScreenOrientation(this.mContext) == 2;
            if (cVar.bda && !b(cVar, z)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 1));
                IN();
            } else if (z && cVar.bdb) {
                IN();
            } else if (this.aXd && z && !cVar.bcM) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913138, cVar));
                IN();
            } else {
                try {
                    if ((cVar.bcN != null && com.baidu.live.gift.c.b.Kv().hm(cVar.bcN.GX())) || cVar.bda) {
                        if (cVar.bda) {
                            hP = com.baidu.live.entereffect.a.Gi().gK(cVar.giftId).aUF;
                        } else {
                            hP = com.baidu.live.gift.c.b.Kv().hP(cVar.giftId);
                        }
                        if (a(hP, cVar)) {
                            if (cVar.bda) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 0));
                                com.baidu.live.entereffect.a.Gi().gL(cVar.giftId);
                            } else if (hP != null && hP.aVv != null && hP.aVv.aVt != null) {
                                v.gP(hP.aVv.aVt.zipName);
                            }
                            b(hP, cVar);
                        } else if (b(hP)) {
                            if (cVar.bda) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 0));
                                com.baidu.live.entereffect.a.Gi().gL(cVar.giftId);
                            } else if (hP != null && hP.aVv != null && hP.aVv.aVt != null) {
                                v.gP(hP.aVv.aVt.zipName);
                            }
                            c(hP, cVar);
                        } else {
                            if (cVar.bda || cVar.bdb || cVar.bdc) {
                                IN();
                                if (cVar.bda) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 1));
                                }
                            } else {
                                k(cVar);
                            }
                            a(hP);
                        }
                        if (cVar.bcX) {
                            LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW, cVar.chatMCastId, cVar.ensureMCastId, cVar.giftId, "");
                        }
                    } else if (cVar.bcX) {
                        LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW_FAIL, cVar.chatMCastId, cVar.ensureMCastId, cVar.giftId, "不在大礼物列表");
                    }
                } catch (OutOfMemoryError e) {
                    log(BdStatsConstant.StatsType.ERROR, "showbiggift", TiebaInitialize.LogFields.REASON, "oom");
                    TbadkCoreApplication.getInst().onAppMemoryLow();
                    System.gc();
                    if (cVar.bcX) {
                        LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW_FAIL, cVar.chatMCastId, cVar.ensureMCastId, cVar.giftId, "OOM");
                    }
                    if (this.aYE < 1) {
                        this.aYE++;
                        j(cVar);
                    } else {
                        IN();
                    }
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2913019));
            }
        }
    }

    private void a(com.baidu.live.gift.c cVar) {
        if (cVar != null && cVar.aVv != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("cartoon_id", cVar.aVv.giftId);
                String str = "portrait";
                if (cVar.aVv.aVt != null && cVar.aVv.aVt.isLandScape()) {
                    str = "landscape";
                }
                jSONObject.put("status", str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "cartoon_lacking").setContentExt(null, null, jSONObject));
        }
    }

    private boolean b(com.baidu.live.gift.a.c cVar, boolean z) {
        com.baidu.live.entereffect.a.a gK;
        com.baidu.live.gift.c cVar2;
        if (z || (gK = com.baidu.live.entereffect.a.Gi().gK(cVar.giftId)) == null || (cVar2 = gK.aUF) == null) {
            return false;
        }
        return (TextUtils.isEmpty(cVar2.videoPath) && ListUtils.isEmpty(cVar2.unZipFilesPathList)) ? false : true;
    }

    private boolean a(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2) {
        boolean z = (!com.baidu.live.alphavideo.a.Dl().Dm() || cVar == null || cVar.aVv == null) ? false : true;
        return cVar2.bda ? z && !TextUtils.isEmpty(cVar.GE()) : z && cVar.aVv.GD() && !TextUtils.isEmpty(cVar.GE());
    }

    private boolean b(com.baidu.live.gift.c cVar) {
        return (cVar == null || ListUtils.isEmpty(cVar.getDynamicGiftPicPathList())) ? false : true;
    }

    private void c(com.baidu.live.gift.a.c cVar, boolean z) {
        if (cVar != null) {
            g gVar = cVar.bcN;
            if (!cVar.bda && !cVar.bdb) {
                if (cVar.bcX || cVar.bcM) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt(LogConfig.LOG_GIFT_ID, gVar.GX());
                        jSONObject.putOpt("gift_name", gVar.GY());
                        jSONObject.putOpt(LogConfig.LOG_GIFT_VALUE, gVar.getPrice());
                        jSONObject.putOpt("gift_num", Long.valueOf(cVar.bcU));
                        jSONObject.putOpt("is_down", Integer.valueOf(z ? 1 : 0));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", cVar.bcX ? "author_liveroom" : "liveroom", "giftplay_show").setContentExt(null, "popup", jSONObject));
                }
            }
        }
    }

    private void b(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2) {
        if (this.aYF == null) {
            this.aYF = new AlaDynamicVideoGiftLayout(this.mContext);
        }
        ViewGroup.LayoutParams layoutParams = this.aYF.getLayoutParams();
        if (!(layoutParams instanceof RelativeLayout.LayoutParams)) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        }
        this.aYB.a(this.aYF, (RelativeLayout.LayoutParams) layoutParams);
        this.aYF.setHost(this.aYB.aVr);
        this.aYF.setEnterEffectRelativeBottomMargin(this.aYJ);
        this.aYF.setData(cVar, cVar2);
        this.aYF.setBigGiftCallBack(this.aYK);
        this.aYF.startAnim();
        c(cVar2, true);
    }

    private void c(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2) {
        if (this.aYG == null) {
            this.aYG = new AlaDynamicGiftLayout(this.mContext);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aYG.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        }
        this.aYB.a(this.aYG, layoutParams);
        this.aYG.setHost(this.aYB.aVr);
        this.aYG.setData(cVar, cVar2);
        this.aYG.setBigGiftCallBack(this.aYK);
        this.aYG.startAnim();
        c(cVar2, true);
    }

    private void k(com.baidu.live.gift.a.c cVar) {
        if (this.aYH == null) {
            this.aYH = new AlaDynamicGiftSmallGiftStyleView(this.mContext);
        }
        this.aYB.M(this.aYH);
        this.aYH.eN(this.aYI);
        this.aYH.setData(cVar);
        this.aYH.setBigGiftCallBack(this.aYK);
        this.aYH.startAnim();
        c(cVar, false);
    }

    public boolean IQ() {
        return this.aYD;
    }

    public void IR() {
        boolean z = false;
        if (2 == UtilHelper.getRealScreenOrientation(this.mContext)) {
            z = true;
        }
        if (this.aYF != null) {
            this.aYF.IR();
        }
        if (this.aYG != null) {
            this.aYG.bZ(z);
        }
        if (this.aYH != null) {
            this.aYH.bZ(z);
        }
    }

    public void onDestroy() {
        this.aYE = 0;
        this.aYC.clear();
        this.aYD = false;
        if (this.aYF != null) {
            this.aYF.onDestroy();
        }
        if (this.aYG != null) {
            this.aYG.onDestroy();
        }
        if (this.aYH != null) {
            this.aYH.onDestroy();
        }
        this.mContext = null;
    }

    protected void log(Object... objArr) {
        AlaStatManager.getInstance().newDebug("alaGift", 0L, null, objArr);
    }

    public void bC(boolean z) {
        this.aXd = z;
    }

    public void eo(int i) {
        this.aYI = i;
    }

    public void ep(int i) {
        this.aYJ = i;
    }
}

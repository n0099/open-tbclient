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
import com.baidu.live.utils.l;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    private j aYC;
    private boolean aYE;
    private int aYF;
    private AlaDynamicVideoGiftLayout aYG;
    private AlaDynamicGiftLayout aYH;
    private AlaDynamicGiftSmallGiftStyleView aYI;
    private int aYJ;
    private int aYK;
    private Context mContext;
    private boolean aXa = false;
    private b aYL = new b() { // from class: com.baidu.live.gift.biggift.a.1
        @Override // com.baidu.live.gift.biggift.b
        public void m(com.baidu.live.gift.a.c cVar) {
            a.this.aYE = true;
            cVar.aS(System.currentTimeMillis());
        }

        @Override // com.baidu.live.gift.biggift.b
        public void cN(int i) {
        }

        @Override // com.baidu.live.gift.biggift.b
        public void a(int i, String str, com.baidu.live.gift.a.c cVar) {
            l.a(i, str, cVar.giftId, cVar.userId, cVar.msgId, cVar.bcW);
        }

        @Override // com.baidu.live.gift.biggift.b
        public void n(com.baidu.live.gift.a.c cVar) {
            a.this.j(cVar);
            a.this.aYE = false;
            a.this.aYC.EH();
            a.this.FJ();
        }
    };
    private ArrayList<com.baidu.live.gift.a.c> aYD = new ArrayList<>();

    public a(Context context, j jVar) {
        this.aYF = 0;
        this.mContext = context;
        this.aYC = jVar;
        this.aYF = 0;
    }

    public void h(com.baidu.live.gift.a.c cVar) {
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            long j = cVar.bcT;
            cVar.bcT = 1L;
            for (int i = 0; i < j; i++) {
                com.baidu.live.gift.a.c clone = cVar.clone();
                if (clone != null) {
                    if (cVar.priority == 11) {
                        this.aYD.add(0, clone);
                    } else {
                        this.aYD.add(clone);
                    }
                    if (clone.bcW) {
                        LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_ENTER_LIST, clone.chatMCastId, clone.ensureMCastId, clone.giftId, "");
                    }
                }
            }
            try {
                FH();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void FH() {
        if (this.aYD != null) {
            int i = com.baidu.live.ae.a.Qj().buX != null ? com.baidu.live.ae.a.Qj().buX.aMU : 0;
            if (i > 0 && this.aYD.size() > i) {
                Collections.sort(this.aYD, new c.a());
                int max = Math.max((int) (i * 0.7f), 1);
                ArrayList arrayList = new ArrayList(this.aYD.subList(0, max));
                while (true) {
                    int i2 = max;
                    if (i2 < this.aYD.size()) {
                        if (this.aYD.get(i2) == null || !this.aYD.get(i2).bcZ) {
                            max = i2 + 1;
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 1));
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (this.aYD.removeAll(arrayList)) {
                    Iterator<com.baidu.live.gift.a.c> it = this.aYD.iterator();
                    while (it.hasNext()) {
                        com.baidu.live.gift.a.c next = it.next();
                        l.a(next.giftId, next.userId, next.msgId, next.bcW);
                    }
                }
                this.aYD.clear();
                this.aYD.addAll(arrayList);
            }
        }
    }

    public int getCacheSize() {
        if (this.aYD != null) {
            return this.aYD.size();
        }
        return 0;
    }

    public void clearCache() {
        if (this.aYD != null) {
            this.aYD.clear();
        }
    }

    public void i(com.baidu.live.gift.a.c cVar) {
        if (FM()) {
            l.c(cVar.giftId, cVar.userId, cVar.msgId, cVar.bcW);
        } else {
            FJ();
        }
    }

    public void FI() {
        if (this.aYE) {
            if (this.aYG != null) {
                this.aYG.stopAnim();
            }
            if (this.aYH != null) {
                this.aYH.stopAnim();
            }
            if (this.aYI != null) {
                this.aYI.stopAnim();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(com.baidu.live.gift.a.c cVar) {
        if (cVar != null && cVar.bcW) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(LogConfig.LOG_GIFT_ID, cVar.giftId);
                jSONObject.put("gift_count", cVar.bcT);
                jSONObject.put("sender_uk", EncryptionHelper.getEncryptionUserId(cVar.userId));
                jSONObject.put("show_stime", cVar.GF());
                jSONObject.put("show_ctime", System.currentTimeMillis());
                if (cVar.bdd) {
                    jSONObject.put("from_recovery", 1);
                }
            } catch (JSONException e) {
                BdLog.e(e);
            }
            UbcStatisticManager.getInstance().debugException(new UbcDebugItem("author_liveroom", UbcStatConstant.DebugContentValue.GIFT, jSONObject), UbcStatConstant.ContentType.UBC_TYPE_GIFT_SHOW);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FJ() {
        if (this.aYD.isEmpty()) {
            this.aYC.EF();
            FL();
            return;
        }
        com.baidu.live.gift.a.c FK = FK();
        if (FK == null) {
            FJ();
        } else {
            k(FK);
        }
    }

    private com.baidu.live.gift.a.c FK() {
        if (this.aYD.isEmpty()) {
            return null;
        }
        return this.aYD.remove(0);
    }

    private void FL() {
        this.aYC.EH();
    }

    private void k(com.baidu.live.gift.a.c cVar) {
        com.baidu.live.gift.c gM;
        if (cVar != null) {
            boolean z = UtilHelper.getRealScreenOrientation(this.mContext) == 2;
            if (cVar.bcZ && !b(cVar, z)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 1));
                FJ();
            } else if (z && cVar.bda) {
                FJ();
            } else if (this.aXa && z && !cVar.bcN) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913138, cVar));
                l.b(cVar.giftId, cVar.userId, cVar.msgId, cVar.bcW);
                FJ();
            } else {
                try {
                    if ((cVar.bcO != null && com.baidu.live.gift.c.b.Hr().gg(cVar.bcO.DR())) || cVar.bcZ) {
                        if (cVar.bcZ) {
                            gM = com.baidu.live.entereffect.a.CV().fD(cVar.giftId).aUp;
                        } else {
                            gM = com.baidu.live.gift.c.b.Hr().gM(cVar.giftId);
                        }
                        if (a(gM, cVar)) {
                            if (cVar.bcZ) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 0));
                                com.baidu.live.entereffect.a.CV().fE(cVar.giftId);
                            } else if (gM != null && gM.aVs != null && gM.aVs.aVp != null) {
                                v.D(gM.aVs.aVp.zipName, gM.aVs.aVr);
                            }
                            b(gM, cVar);
                        } else if (b(gM)) {
                            if (cVar.bcZ) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 0));
                                com.baidu.live.entereffect.a.CV().fE(cVar.giftId);
                            } else if (gM != null && gM.aVs != null && gM.aVs.aVp != null) {
                                v.D(gM.aVs.aVp.zipName, gM.aVs.aVr);
                            }
                            c(gM, cVar);
                        } else {
                            if (cVar.bcZ || cVar.bda || cVar.bdb) {
                                FJ();
                                if (cVar.bcZ) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 1));
                                }
                            } else {
                                l(cVar);
                                l.b(cVar.giftId, cVar.userId, cVar.msgId, cVar.bcW);
                            }
                            a(gM);
                        }
                        if (cVar.bcW) {
                            LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW, cVar.chatMCastId, cVar.ensureMCastId, cVar.giftId, "");
                        }
                    } else {
                        if (cVar.bcW) {
                            LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW_FAIL, cVar.chatMCastId, cVar.ensureMCastId, cVar.giftId, "不在大礼物列表");
                        }
                        l.d(cVar.giftId, cVar.userId, cVar.msgId, cVar.bcW);
                    }
                } catch (OutOfMemoryError e) {
                    log(BdStatsConstant.StatsType.ERROR, "showbiggift", TiebaInitialize.LogFields.REASON, "oom");
                    TbadkCoreApplication.getInst().onAppMemoryLow();
                    System.gc();
                    if (cVar.bcW) {
                        LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW_FAIL, cVar.chatMCastId, cVar.ensureMCastId, cVar.giftId, "OOM");
                    }
                    if (this.aYF < 1) {
                        this.aYF++;
                        k(cVar);
                    } else {
                        FJ();
                    }
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2913019));
            }
        }
    }

    private void a(com.baidu.live.gift.c cVar) {
        if (cVar != null && cVar.aVs != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("cartoon_id", cVar.aVs.giftId);
                String str = "portrait";
                if (cVar.aVs.aVp != null && cVar.aVs.aVp.isLandScape()) {
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
        com.baidu.live.entereffect.a.a fD;
        com.baidu.live.gift.c cVar2;
        if (z || (fD = com.baidu.live.entereffect.a.CV().fD(cVar.giftId)) == null || (cVar2 = fD.aUp) == null) {
            return false;
        }
        return (TextUtils.isEmpty(cVar2.videoPath) && ListUtils.isEmpty(cVar2.unZipFilesPathList)) ? false : true;
    }

    private boolean a(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2) {
        boolean z = (!com.baidu.live.alphavideo.a.zo().zp() || cVar == null || cVar.aVs == null) ? false : true;
        return cVar2.bcZ ? z && !TextUtils.isEmpty(cVar.Dy()) : z && cVar.aVs.Dv() && !TextUtils.isEmpty(cVar.Dy());
    }

    private boolean b(com.baidu.live.gift.c cVar) {
        return (cVar == null || ListUtils.isEmpty(cVar.getDynamicGiftPicPathList())) ? false : true;
    }

    private void c(com.baidu.live.gift.a.c cVar, boolean z) {
        if (cVar != null) {
            g gVar = cVar.bcO;
            if (!cVar.bcZ && !cVar.bda) {
                if (cVar.bcW || cVar.bcN) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt(LogConfig.LOG_GIFT_ID, gVar.DR());
                        jSONObject.putOpt("gift_name", gVar.DS());
                        jSONObject.putOpt(LogConfig.LOG_GIFT_VALUE, gVar.getPrice());
                        jSONObject.putOpt("gift_num", Long.valueOf(cVar.bcT));
                        jSONObject.putOpt("is_down", Integer.valueOf(z ? 1 : 0));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", cVar.bcW ? "author_liveroom" : "liveroom", "giftplay_show").setContentExt(null, UbcStatConstant.SubPage.POPUP, jSONObject));
                }
            }
        }
    }

    private void b(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2) {
        if (this.aYG == null) {
            this.aYG = new AlaDynamicVideoGiftLayout(this.mContext);
        }
        ViewGroup.LayoutParams layoutParams = this.aYG.getLayoutParams();
        if (!(layoutParams instanceof RelativeLayout.LayoutParams)) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        }
        this.aYC.a(this.aYG, (RelativeLayout.LayoutParams) layoutParams);
        this.aYG.setHost(this.aYC.aVn);
        this.aYG.setEnterEffectRelativeBottomMargin(this.aYK);
        this.aYG.setData(cVar, cVar2);
        this.aYG.setBigGiftCallBack(this.aYL);
        this.aYG.startAnim();
        c(cVar2, true);
    }

    private void c(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2) {
        if (this.aYH == null) {
            this.aYH = new AlaDynamicGiftLayout(this.mContext);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aYH.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        }
        this.aYC.a(this.aYH, layoutParams);
        this.aYH.setHost(this.aYC.aVn);
        this.aYH.setData(cVar, cVar2);
        this.aYH.setBigGiftCallBack(this.aYL);
        this.aYH.startAnim();
        c(cVar2, true);
    }

    private void l(com.baidu.live.gift.a.c cVar) {
        if (this.aYI == null) {
            this.aYI = new AlaDynamicGiftSmallGiftStyleView(this.mContext);
        }
        this.aYC.M(this.aYI);
        this.aYI.dk(this.aYJ);
        this.aYI.setData(cVar);
        this.aYI.setBigGiftCallBack(this.aYL);
        this.aYI.startAnim();
        c(cVar, false);
    }

    public boolean FM() {
        return this.aYE;
    }

    public void FN() {
        boolean z = false;
        if (2 == UtilHelper.getRealScreenOrientation(this.mContext)) {
            z = true;
        }
        if (this.aYG != null) {
            this.aYG.FN();
        }
        if (this.aYH != null) {
            this.aYH.bY(z);
        }
        if (this.aYI != null) {
            this.aYI.bY(z);
        }
    }

    public void onDestroy() {
        this.aYF = 0;
        this.aYD.clear();
        this.aYE = false;
        if (this.aYG != null) {
            this.aYG.onDestroy();
        }
        if (this.aYH != null) {
            this.aYH.onDestroy();
        }
        if (this.aYI != null) {
            this.aYI.onDestroy();
        }
        this.mContext = null;
    }

    protected void log(Object... objArr) {
        AlaStatManager.getInstance().newDebug("alaGift", 0L, null, objArr);
    }

    public void bB(boolean z) {
        this.aXa = z;
    }

    public void cL(int i) {
        this.aYJ = i;
    }

    public void cM(int i) {
        this.aYK = i;
    }
}

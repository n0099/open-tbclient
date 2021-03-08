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
/* loaded from: classes10.dex */
public class a {
    private j bac;
    private boolean bae;
    private int baf;
    private AlaDynamicVideoGiftLayout bag;
    private AlaDynamicGiftLayout bah;
    private AlaDynamicGiftSmallGiftStyleView bai;
    private int baj;
    private int bak;
    private Context mContext;
    private boolean aYA = false;
    private b bal = new b() { // from class: com.baidu.live.gift.biggift.a.1
        @Override // com.baidu.live.gift.biggift.b
        public void m(com.baidu.live.gift.a.c cVar) {
            a.this.bae = true;
            cVar.aS(System.currentTimeMillis());
        }

        @Override // com.baidu.live.gift.biggift.b
        public void cO(int i) {
        }

        @Override // com.baidu.live.gift.biggift.b
        public void a(int i, String str, com.baidu.live.gift.a.c cVar) {
            l.a(i, str, cVar.giftId, cVar.userId, cVar.msgId, cVar.bey);
        }

        @Override // com.baidu.live.gift.biggift.b
        public void n(com.baidu.live.gift.a.c cVar) {
            a.this.j(cVar);
            a.this.bae = false;
            a.this.bac.EK();
            a.this.FM();
        }
    };
    private ArrayList<com.baidu.live.gift.a.c> bad = new ArrayList<>();

    public a(Context context, j jVar) {
        this.baf = 0;
        this.mContext = context;
        this.bac = jVar;
        this.baf = 0;
    }

    public void h(com.baidu.live.gift.a.c cVar) {
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            long j = cVar.bev;
            cVar.bev = 1L;
            for (int i = 0; i < j; i++) {
                com.baidu.live.gift.a.c clone = cVar.clone();
                if (clone != null) {
                    if (cVar.priority == 11) {
                        this.bad.add(0, clone);
                    } else {
                        this.bad.add(clone);
                    }
                    if (clone.bey) {
                        LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_ENTER_LIST, clone.chatMCastId, clone.ensureMCastId, clone.giftId, "");
                    }
                }
            }
            try {
                FK();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void FK() {
        if (this.bad != null) {
            int i = com.baidu.live.ae.a.Qm().bwx != null ? com.baidu.live.ae.a.Qm().bwx.aOu : 0;
            if (i > 0 && this.bad.size() > i) {
                Collections.sort(this.bad, new c.a());
                int max = Math.max((int) (i * 0.7f), 1);
                ArrayList arrayList = new ArrayList(this.bad.subList(0, max));
                while (true) {
                    int i2 = max;
                    if (i2 < this.bad.size()) {
                        if (this.bad.get(i2) == null || !this.bad.get(i2).beB) {
                            max = i2 + 1;
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 1));
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (this.bad.removeAll(arrayList)) {
                    Iterator<com.baidu.live.gift.a.c> it = this.bad.iterator();
                    while (it.hasNext()) {
                        com.baidu.live.gift.a.c next = it.next();
                        l.a(next.giftId, next.userId, next.msgId, next.bey);
                    }
                }
                this.bad.clear();
                this.bad.addAll(arrayList);
            }
        }
    }

    public int getCacheSize() {
        if (this.bad != null) {
            return this.bad.size();
        }
        return 0;
    }

    public void clearCache() {
        if (this.bad != null) {
            this.bad.clear();
        }
    }

    public void i(com.baidu.live.gift.a.c cVar) {
        if (FP()) {
            l.c(cVar.giftId, cVar.userId, cVar.msgId, cVar.bey);
        } else {
            FM();
        }
    }

    public void FL() {
        if (this.bae) {
            if (this.bag != null) {
                this.bag.stopAnim();
            }
            if (this.bah != null) {
                this.bah.stopAnim();
            }
            if (this.bai != null) {
                this.bai.stopAnim();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(com.baidu.live.gift.a.c cVar) {
        if (cVar != null && cVar.bey) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(LogConfig.LOG_GIFT_ID, cVar.giftId);
                jSONObject.put("gift_count", cVar.bev);
                jSONObject.put("sender_uk", EncryptionHelper.getEncryptionUserId(cVar.userId));
                jSONObject.put("show_stime", cVar.GI());
                jSONObject.put("show_ctime", System.currentTimeMillis());
                if (cVar.beF) {
                    jSONObject.put("from_recovery", 1);
                }
            } catch (JSONException e) {
                BdLog.e(e);
            }
            UbcStatisticManager.getInstance().debugException(new UbcDebugItem("author_liveroom", UbcStatConstant.DebugContentValue.GIFT, jSONObject), UbcStatConstant.ContentType.UBC_TYPE_GIFT_SHOW);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FM() {
        if (this.bad.isEmpty()) {
            this.bac.EI();
            FO();
            return;
        }
        com.baidu.live.gift.a.c FN = FN();
        if (FN == null) {
            FM();
        } else {
            k(FN);
        }
    }

    private com.baidu.live.gift.a.c FN() {
        if (this.bad.isEmpty()) {
            return null;
        }
        return this.bad.remove(0);
    }

    private void FO() {
        this.bac.EK();
    }

    private void k(com.baidu.live.gift.a.c cVar) {
        com.baidu.live.gift.c gS;
        if (cVar != null) {
            boolean z = UtilHelper.getRealScreenOrientation(this.mContext) == 2;
            if (cVar.beB && !b(cVar, z)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 1));
                FM();
            } else if (z && cVar.beC) {
                FM();
            } else if (this.aYA && z && !cVar.beo) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913138, cVar));
                l.b(cVar.giftId, cVar.userId, cVar.msgId, cVar.bey);
                FM();
            } else {
                try {
                    if ((cVar.bep != null && com.baidu.live.gift.c.b.Hu().gm(cVar.bep.DU())) || cVar.beB) {
                        if (cVar.beB) {
                            gS = com.baidu.live.entereffect.a.CY().fJ(cVar.giftId).aVP;
                        } else {
                            gS = com.baidu.live.gift.c.b.Hu().gS(cVar.giftId);
                        }
                        if (a(gS, cVar)) {
                            if (cVar.beB) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 0));
                                com.baidu.live.entereffect.a.CY().fK(cVar.giftId);
                            } else if (gS != null && gS.aWS != null && gS.aWS.aWP != null) {
                                v.D(gS.aWS.aWP.zipName, gS.aWS.aWR);
                            }
                            b(gS, cVar);
                        } else if (b(gS)) {
                            if (cVar.beB) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 0));
                                com.baidu.live.entereffect.a.CY().fK(cVar.giftId);
                            } else if (gS != null && gS.aWS != null && gS.aWS.aWP != null) {
                                v.D(gS.aWS.aWP.zipName, gS.aWS.aWR);
                            }
                            c(gS, cVar);
                        } else {
                            if (cVar.beB || cVar.beC || cVar.beD) {
                                FM();
                                if (cVar.beB) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 1));
                                }
                            } else {
                                l(cVar);
                                l.b(cVar.giftId, cVar.userId, cVar.msgId, cVar.bey);
                            }
                            a(gS);
                        }
                        if (cVar.bey) {
                            LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW, cVar.chatMCastId, cVar.ensureMCastId, cVar.giftId, "");
                        }
                    } else {
                        if (cVar.bey) {
                            LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW_FAIL, cVar.chatMCastId, cVar.ensureMCastId, cVar.giftId, "不在大礼物列表");
                        }
                        l.d(cVar.giftId, cVar.userId, cVar.msgId, cVar.bey);
                    }
                } catch (OutOfMemoryError e) {
                    log(BdStatsConstant.StatsType.ERROR, "showbiggift", TiebaInitialize.LogFields.REASON, "oom");
                    TbadkCoreApplication.getInst().onAppMemoryLow();
                    System.gc();
                    if (cVar.bey) {
                        LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW_FAIL, cVar.chatMCastId, cVar.ensureMCastId, cVar.giftId, "OOM");
                    }
                    if (this.baf < 1) {
                        this.baf++;
                        k(cVar);
                    } else {
                        FM();
                    }
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2913019));
            }
        }
    }

    private void a(com.baidu.live.gift.c cVar) {
        if (cVar != null && cVar.aWS != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("cartoon_id", cVar.aWS.giftId);
                String str = "portrait";
                if (cVar.aWS.aWP != null && cVar.aWS.aWP.isLandScape()) {
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
        com.baidu.live.entereffect.a.a fJ;
        com.baidu.live.gift.c cVar2;
        if (z || (fJ = com.baidu.live.entereffect.a.CY().fJ(cVar.giftId)) == null || (cVar2 = fJ.aVP) == null) {
            return false;
        }
        return (TextUtils.isEmpty(cVar2.videoPath) && ListUtils.isEmpty(cVar2.unZipFilesPathList)) ? false : true;
    }

    private boolean a(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2) {
        boolean z = (!com.baidu.live.alphavideo.a.zr().zs() || cVar == null || cVar.aWS == null) ? false : true;
        return cVar2.beB ? z && !TextUtils.isEmpty(cVar.DB()) : z && cVar.aWS.Dy() && !TextUtils.isEmpty(cVar.DB());
    }

    private boolean b(com.baidu.live.gift.c cVar) {
        return (cVar == null || ListUtils.isEmpty(cVar.getDynamicGiftPicPathList())) ? false : true;
    }

    private void c(com.baidu.live.gift.a.c cVar, boolean z) {
        if (cVar != null) {
            g gVar = cVar.bep;
            if (!cVar.beB && !cVar.beC) {
                if (cVar.bey || cVar.beo) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt(LogConfig.LOG_GIFT_ID, gVar.DU());
                        jSONObject.putOpt("gift_name", gVar.DV());
                        jSONObject.putOpt(LogConfig.LOG_GIFT_VALUE, gVar.getPrice());
                        jSONObject.putOpt("gift_num", Long.valueOf(cVar.bev));
                        jSONObject.putOpt("is_down", Integer.valueOf(z ? 1 : 0));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", cVar.bey ? "author_liveroom" : "liveroom", "giftplay_show").setContentExt(null, UbcStatConstant.SubPage.POPUP, jSONObject));
                }
            }
        }
    }

    private void b(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2) {
        if (this.bag == null) {
            this.bag = new AlaDynamicVideoGiftLayout(this.mContext);
        }
        ViewGroup.LayoutParams layoutParams = this.bag.getLayoutParams();
        if (!(layoutParams instanceof RelativeLayout.LayoutParams)) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        }
        this.bac.a(this.bag, (RelativeLayout.LayoutParams) layoutParams);
        this.bag.setHost(this.bac.aWN);
        this.bag.setEnterEffectRelativeBottomMargin(this.bak);
        this.bag.setData(cVar, cVar2);
        this.bag.setBigGiftCallBack(this.bal);
        this.bag.startAnim();
        c(cVar2, true);
    }

    private void c(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2) {
        if (this.bah == null) {
            this.bah = new AlaDynamicGiftLayout(this.mContext);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bah.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        }
        this.bac.a(this.bah, layoutParams);
        this.bah.setHost(this.bac.aWN);
        this.bah.setData(cVar, cVar2);
        this.bah.setBigGiftCallBack(this.bal);
        this.bah.startAnim();
        c(cVar2, true);
    }

    private void l(com.baidu.live.gift.a.c cVar) {
        if (this.bai == null) {
            this.bai = new AlaDynamicGiftSmallGiftStyleView(this.mContext);
        }
        this.bac.M(this.bai);
        this.bai.dl(this.baj);
        this.bai.setData(cVar);
        this.bai.setBigGiftCallBack(this.bal);
        this.bai.startAnim();
        c(cVar, false);
    }

    public boolean FP() {
        return this.bae;
    }

    public void FQ() {
        boolean z = false;
        if (2 == UtilHelper.getRealScreenOrientation(this.mContext)) {
            z = true;
        }
        if (this.bag != null) {
            this.bag.FQ();
        }
        if (this.bah != null) {
            this.bah.bY(z);
        }
        if (this.bai != null) {
            this.bai.bY(z);
        }
    }

    public void onDestroy() {
        this.baf = 0;
        this.bad.clear();
        this.bae = false;
        if (this.bag != null) {
            this.bag.onDestroy();
        }
        if (this.bah != null) {
            this.bah.onDestroy();
        }
        if (this.bai != null) {
            this.bai.onDestroy();
        }
        this.mContext = null;
    }

    protected void log(Object... objArr) {
        AlaStatManager.getInstance().newDebug("alaGift", 0L, null, objArr);
    }

    public void bB(boolean z) {
        this.aYA = z;
    }

    public void cM(int i) {
        this.baj = i;
    }

    public void cN(int i) {
        this.bak = i;
    }
}

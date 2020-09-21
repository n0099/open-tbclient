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
import com.baidu.live.gift.k;
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
import com.baidu.platform.comapi.map.MapController;
import java.util.ArrayList;
import java.util.Collections;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    private k aRd;
    private boolean aRf;
    private int aRg;
    private AlaDynamicVideoGiftLayout aRh;
    private AlaDynamicGiftLayout aRi;
    private AlaDynamicGiftSmallGiftStyleView aRj;
    private int aRk;
    private int aRl;
    private Context mContext;
    private boolean aQk = false;
    private b aRm = new b() { // from class: com.baidu.live.gift.biggift.a.1
        @Override // com.baidu.live.gift.biggift.b
        public void l(com.baidu.live.gift.a.c cVar) {
            a.this.aRf = true;
            cVar.ad(System.currentTimeMillis());
        }

        @Override // com.baidu.live.gift.biggift.b
        public void dU(int i) {
        }

        @Override // com.baidu.live.gift.biggift.b
        public void m(com.baidu.live.gift.a.c cVar) {
            a.this.i(cVar);
            a.this.aRf = false;
            a.this.aRd.ET();
            a.this.FM();
        }
    };
    private ArrayList<com.baidu.live.gift.a.c> aRe = new ArrayList<>();

    public a(Context context, k kVar) {
        this.aRg = 0;
        this.mContext = context;
        this.aRd = kVar;
        this.aRg = 0;
    }

    public void h(com.baidu.live.gift.a.c cVar) {
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            long j = cVar.aVi;
            cVar.aVi = 1L;
            for (int i = 0; i < j; i++) {
                com.baidu.live.gift.a.c clone = cVar.clone();
                if (clone != null) {
                    if (cVar.priority == 11) {
                        this.aRe.add(0, clone);
                    } else {
                        this.aRe.add(clone);
                    }
                    if (clone.aVk) {
                        LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_ENTER_LIST, clone.aEU, clone.aEV, clone.giftId, "");
                    }
                }
            }
            try {
                FJ();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void FJ() {
        if (this.aRe != null) {
            int i = com.baidu.live.x.a.NN().bhy != null ? com.baidu.live.x.a.NN().bhy.aIv : 0;
            if (i > 0 && this.aRe.size() >= i) {
                Collections.sort(this.aRe, new c.a());
                int max = Math.max((int) (i * 0.7f), 1);
                ArrayList arrayList = new ArrayList(this.aRe.subList(0, max));
                while (true) {
                    int i2 = max;
                    if (i2 < this.aRe.size()) {
                        if (this.aRe.get(i2) == null || !this.aRe.get(i2).aVn) {
                            max = i2 + 1;
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 1));
                            break;
                        }
                    } else {
                        break;
                    }
                }
                this.aRe.clear();
                this.aRe.addAll(arrayList);
            }
        }
    }

    public void FK() {
        if (!FP()) {
            FM();
        }
    }

    public void FL() {
        if (this.aRf) {
            if (this.aRh != null) {
                this.aRh.stopAnim();
            }
            if (this.aRi != null) {
                this.aRi.stopAnim();
            }
            if (this.aRj != null) {
                this.aRj.stopAnim();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(com.baidu.live.gift.a.c cVar) {
        if (cVar != null && cVar.aVk) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(LogConfig.LOG_GIFT_ID, cVar.giftId);
                jSONObject.put("gift_count", cVar.aVi);
                jSONObject.put("sender_uk", EncryptionHelper.getEncryptionUserId(cVar.userId));
                jSONObject.put("show_stime", cVar.GI());
                jSONObject.put("show_ctime", System.currentTimeMillis());
                if (cVar.aVp) {
                    jSONObject.put("from_recovery", 1);
                }
            } catch (JSONException e) {
                BdLog.e(e);
            }
            UbcStatisticManager.getInstance().debugException(new UbcDebugItem(UbcStatConstant.Page.AUTHOR_LIVE_ROOM, UbcStatConstant.DebugContentValue.GIFT, jSONObject), "gift_show");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FM() {
        if (this.aRe.isEmpty()) {
            this.aRd.ER();
            FO();
            return;
        }
        com.baidu.live.gift.a.c FN = FN();
        if (FN == null) {
            FM();
        } else {
            j(FN);
        }
    }

    private com.baidu.live.gift.a.c FN() {
        if (this.aRe.isEmpty()) {
            return null;
        }
        return this.aRe.remove(0);
    }

    private void FO() {
        this.aRd.ET();
    }

    private void j(com.baidu.live.gift.a.c cVar) {
        com.baidu.live.gift.c gU;
        if (cVar != null) {
            boolean z = UtilHelper.getRealScreenOrientation(this.mContext) == 2;
            if (cVar.aVn && !b(cVar, z)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 1));
                FM();
            } else if (z && cVar.aVo) {
                FM();
            } else if (this.aQk && z && !cVar.aVc) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913138, cVar));
                FM();
            } else {
                try {
                    if ((cVar.aVd != null && com.baidu.live.gift.b.b.Hn().gv(cVar.aVd.Eh())) || cVar.aVn) {
                        if (cVar.aVn) {
                            gU = com.baidu.live.entereffect.a.Dw().ga(cVar.giftId).aNV;
                        } else {
                            gU = com.baidu.live.gift.b.b.Hn().gU(cVar.giftId);
                        }
                        if (a(gU, cVar)) {
                            b(gU, cVar);
                            if (cVar.aVn) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 0));
                            }
                        } else if (a(gU)) {
                            c(gU, cVar);
                            if (cVar.aVn) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 0));
                            }
                        } else if (cVar.aVn || cVar.aVo) {
                            FM();
                            if (cVar.aVn) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 1));
                            }
                        } else {
                            k(cVar);
                        }
                        if (cVar.aVk) {
                            LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW, cVar.aEU, cVar.aEV, cVar.giftId, "");
                        }
                    } else if (cVar.aVk) {
                        LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW_FAIL, cVar.aEU, cVar.aEV, cVar.giftId, "不在大礼物列表");
                    }
                } catch (OutOfMemoryError e) {
                    log(BdStatsConstant.StatsType.ERROR, "showbiggift", TiebaInitialize.LogFields.REASON, "oom");
                    TbadkCoreApplication.getInst().onAppMemoryLow();
                    System.gc();
                    if (cVar.aVk) {
                        LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW_FAIL, cVar.aEU, cVar.aEV, cVar.giftId, "OOM");
                    }
                    if (this.aRg < 1) {
                        this.aRg++;
                        j(cVar);
                    } else {
                        FM();
                    }
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2913019));
            }
        }
    }

    private boolean b(com.baidu.live.gift.a.c cVar, boolean z) {
        com.baidu.live.entereffect.a.a ga;
        com.baidu.live.gift.c cVar2;
        if (z || (ga = com.baidu.live.entereffect.a.Dw().ga(cVar.giftId)) == null || (cVar2 = ga.aNV) == null) {
            return false;
        }
        return (TextUtils.isEmpty(cVar2.videoPath) && ListUtils.isEmpty(cVar2.unZipFilesPathList)) ? false : true;
    }

    private boolean a(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2) {
        boolean z = (!com.baidu.live.alphavideo.a.AW().AX() || cVar == null || cVar.aOF == null) ? false : true;
        return cVar2.aVn ? z && !TextUtils.isEmpty(cVar.DQ()) : z && cVar.aOF.DO() && !TextUtils.isEmpty(cVar.DQ());
    }

    private boolean a(com.baidu.live.gift.c cVar) {
        return (cVar == null || ListUtils.isEmpty(cVar.getDynamicGiftPicPathList())) ? false : true;
    }

    private void c(com.baidu.live.gift.a.c cVar, boolean z) {
        if (cVar != null) {
            g gVar = cVar.aVd;
            if (!cVar.aVn && !cVar.aVo) {
                if (cVar.aVk || cVar.aVc) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt(LogConfig.LOG_GIFT_ID, gVar.Eh());
                        jSONObject.putOpt("gift_name", gVar.Ei());
                        jSONObject.putOpt(LogConfig.LOG_GIFT_VALUE, gVar.getPrice());
                        jSONObject.putOpt("gift_num", Long.valueOf(cVar.aVi));
                        jSONObject.putOpt("is_down", Integer.valueOf(z ? 1 : 0));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", cVar.aVk ? UbcStatConstant.Page.AUTHOR_LIVE_ROOM : "liveroom", "giftplay_show").setContentExt(null, MapController.POPUP_LAYER_TAG, jSONObject));
                }
            }
        }
    }

    private void b(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2) {
        if (this.aRh == null) {
            this.aRh = new AlaDynamicVideoGiftLayout(this.mContext);
        }
        ViewGroup.LayoutParams layoutParams = this.aRh.getLayoutParams();
        if (!(layoutParams instanceof RelativeLayout.LayoutParams)) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        }
        this.aRd.a(this.aRh, (RelativeLayout.LayoutParams) layoutParams);
        this.aRh.setHost(this.aRd.aOB);
        this.aRh.setEnterEffectRelativeBottomMargin(this.aRl);
        this.aRh.setData(cVar, cVar2);
        this.aRh.setBigGiftCallBack(this.aRm);
        this.aRh.startAnim();
        c(cVar2, true);
    }

    private void c(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2) {
        if (this.aRi == null) {
            this.aRi = new AlaDynamicGiftLayout(this.mContext);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aRi.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        }
        this.aRd.a(this.aRi, layoutParams);
        this.aRi.setHost(this.aRd.aOB);
        this.aRi.setData(cVar, cVar2);
        this.aRi.setBigGiftCallBack(this.aRm);
        this.aRi.startAnim();
        c(cVar2, true);
    }

    private void k(com.baidu.live.gift.a.c cVar) {
        if (this.aRj == null) {
            this.aRj = new AlaDynamicGiftSmallGiftStyleView(this.mContext);
        }
        this.aRd.M(this.aRj);
        this.aRj.eq(this.aRk);
        this.aRj.setData(cVar);
        this.aRj.setBigGiftCallBack(this.aRm);
        this.aRj.startAnim();
        c(cVar, false);
    }

    public boolean FP() {
        return this.aRf;
    }

    public void FQ() {
        boolean z = false;
        if (2 == UtilHelper.getRealScreenOrientation(this.mContext)) {
            z = true;
        }
        if (this.aRh != null) {
            this.aRh.FQ();
        }
        if (this.aRi != null) {
            this.aRi.bH(z);
        }
        if (this.aRj != null) {
            this.aRj.bH(z);
        }
    }

    public void onDestroy() {
        this.aRg = 0;
        this.aRe.clear();
        this.aRf = false;
        if (this.aRh != null) {
            this.aRh.onDestroy();
        }
        if (this.aRi != null) {
            this.aRi.onDestroy();
        }
        if (this.aRj != null) {
            this.aRj.onDestroy();
        }
        this.mContext = null;
    }

    protected void log(Object... objArr) {
        AlaStatManager.getInstance().newDebug("alaGift", 0L, null, objArr);
    }

    public void bk(boolean z) {
        this.aQk = z;
    }

    public void dS(int i) {
        this.aRk = i;
    }

    public void dT(int i) {
        this.aRl = i;
    }
}

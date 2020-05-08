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
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.gift.a.c;
import com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout;
import com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView;
import com.baidu.live.gift.dynamicGift.AlaDynamicVideoGiftLayout;
import com.baidu.live.gift.k;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.log.LogManager;
import java.util.ArrayList;
import java.util.Collections;
/* loaded from: classes3.dex */
public class a {
    private k aAD;
    private boolean aAF;
    private int aAG;
    private AlaDynamicVideoGiftLayout aAH;
    private AlaDynamicGiftLayout aAI;
    private AlaDynamicGiftSmallGiftStyleView aAJ;
    private Context mContext;
    private boolean azP = false;
    private b aAK = new b() { // from class: com.baidu.live.gift.biggift.a.1
        @Override // com.baidu.live.gift.biggift.b
        public void onStart() {
            a.this.aAF = true;
        }

        @Override // com.baidu.live.gift.biggift.b
        public void bG(int i) {
        }

        @Override // com.baidu.live.gift.biggift.b
        public void onEnd() {
            a.this.aAF = false;
            a.this.aAD.wG();
            a.this.xt();
        }
    };
    private ArrayList<com.baidu.live.gift.a.c> aAE = new ArrayList<>();

    public a(Context context, k kVar) {
        this.aAG = 0;
        this.mContext = context;
        this.aAD = kVar;
        this.aAG = 0;
    }

    public void h(com.baidu.live.gift.a.c cVar) {
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            long j = cVar.aEh;
            cVar.aEh = 1L;
            for (int i = 0; i < j; i++) {
                com.baidu.live.gift.a.c clone = cVar.clone();
                if (clone != null) {
                    if (cVar.priority == 11) {
                        this.aAE.add(0, clone);
                    } else {
                        this.aAE.add(clone);
                    }
                    if (clone.aEj) {
                        LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_ENTER_LIST, clone.aqw, clone.aqx, clone.giftId, "");
                    }
                }
            }
            try {
                xq();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void xq() {
        if (this.aAE != null) {
            int i = com.baidu.live.v.a.En().aQu != null ? com.baidu.live.v.a.En().aQu.att : 0;
            if (i > 0 && this.aAE.size() >= i) {
                Collections.sort(this.aAE, new c.a());
                int max = Math.max((int) (i * 0.7f), 1);
                ArrayList arrayList = new ArrayList(this.aAE.subList(0, max));
                while (true) {
                    int i2 = max;
                    if (i2 < this.aAE.size()) {
                        if (this.aAE.get(i2) == null || !this.aAE.get(i2).aEm) {
                            max = i2 + 1;
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 1));
                            break;
                        }
                    } else {
                        break;
                    }
                }
                this.aAE.clear();
                this.aAE.addAll(arrayList);
            }
        }
    }

    public void xr() {
        if (!xw()) {
            xt();
        }
    }

    public void xs() {
        if (this.aAF) {
            if (this.aAH != null) {
                this.aAH.stopAnim();
            }
            if (this.aAI != null) {
                this.aAI.stopAnim();
            }
            if (this.aAJ != null) {
                this.aAJ.stopAnim();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xt() {
        if (this.aAE.isEmpty()) {
            this.aAD.wE();
            xv();
            return;
        }
        com.baidu.live.gift.a.c xu = xu();
        if (xu == null) {
            xt();
        } else {
            i(xu);
        }
    }

    private com.baidu.live.gift.a.c xu() {
        if (this.aAE.isEmpty()) {
            return null;
        }
        return this.aAE.remove(0);
    }

    private void xv() {
        this.aAD.wG();
    }

    private void i(com.baidu.live.gift.a.c cVar) {
        if (cVar != null) {
            if (cVar.aEm) {
                j(cVar);
                return;
            }
            boolean z = UtilHelper.getRealScreenOrientation(this.mContext) == 2;
            if (this.azP && z && !cVar.aEc) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913138, cVar));
                xt();
                return;
            }
            try {
                if (cVar.aEd != null && com.baidu.live.gift.b.b.yS().ee(cVar.aEd.vU())) {
                    com.baidu.live.gift.c ey = com.baidu.live.gift.b.b.yS().ey(cVar.giftId);
                    if (com.baidu.live.alphavideo.a.tK().tL() && ey != null && ey.ays != null && ey.ays.vB() && !TextUtils.isEmpty(ey.vE())) {
                        a(ey, cVar);
                    } else if (ey != null && !ListUtils.isEmpty(ey.getDynamicGiftPicPathList())) {
                        if (this.aAI == null) {
                            this.aAI = new AlaDynamicGiftLayout(this.mContext);
                        }
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aAI.getLayoutParams();
                        if (layoutParams == null) {
                            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                        }
                        this.aAD.a(this.aAI, layoutParams);
                        this.aAI.setData(ey, cVar);
                        this.aAI.setBigGiftCallBack(this.aAK);
                        this.aAI.startAnim();
                    } else {
                        if (this.aAJ == null) {
                            this.aAJ = new AlaDynamicGiftSmallGiftStyleView(this.mContext);
                        }
                        this.aAD.M(this.aAJ);
                        this.aAJ.setData(cVar);
                        this.aAJ.setBigGiftCallBack(this.aAK);
                        this.aAJ.startAnim();
                    }
                    if (cVar.aEj) {
                        LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW, cVar.aqw, cVar.aqx, cVar.giftId, "");
                    }
                } else if (cVar.aEj) {
                    LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW_FAIL, cVar.aqw, cVar.aqx, cVar.giftId, "不在大礼物列表");
                }
            } catch (OutOfMemoryError e) {
                log(BdStatsConstant.StatsType.ERROR, "showbiggift", TiebaInitialize.LogFields.REASON, "oom");
                TbadkCoreApplication.getInst().onAppMemoryLow();
                System.gc();
                if (cVar.aEj) {
                    LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW_FAIL, cVar.aqw, cVar.aqx, cVar.giftId, "OOM");
                }
                if (this.aAG < 1) {
                    this.aAG++;
                    i(cVar);
                } else {
                    xt();
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2913019));
        }
    }

    private void a(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2) {
        if (this.aAH == null) {
            this.aAH = new AlaDynamicVideoGiftLayout(this.mContext);
        }
        ViewGroup.LayoutParams layoutParams = this.aAH.getLayoutParams();
        if (!(layoutParams instanceof RelativeLayout.LayoutParams)) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        }
        this.aAD.a(this.aAH, (RelativeLayout.LayoutParams) layoutParams);
        this.aAH.setData(cVar, cVar2);
        this.aAH.setBigGiftCallBack(this.aAK);
        this.aAH.startAnim();
    }

    private void j(com.baidu.live.gift.a.c cVar) {
        com.baidu.live.entereffect.a.a dR = com.baidu.live.entereffect.a.vn().dR(cVar.giftId);
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 1));
            xt();
        } else if (dR == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 1));
            xt();
        } else {
            com.baidu.live.gift.c cVar2 = dR.axN;
            if (cVar2 == null || ListUtils.isEmpty(cVar2.unZipFilesPathList)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 1));
                xt();
                return;
            }
            try {
                if (this.aAI == null) {
                    this.aAI = new AlaDynamicGiftLayout(this.mContext);
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aAI.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                }
                this.aAD.a(this.aAI, layoutParams);
                this.aAI.setData(cVar2, cVar);
                this.aAI.setBigGiftCallBack(this.aAK);
                this.aAI.startAnim();
                MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 0));
            } catch (OutOfMemoryError e) {
                log(BdStatsConstant.StatsType.ERROR, "showbiggift", TiebaInitialize.LogFields.REASON, "oom");
                TbadkCoreApplication.getInst().onAppMemoryLow();
                System.gc();
                if (this.aAG < 1) {
                    this.aAG++;
                    i(cVar);
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 1));
                    xt();
                    return;
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2913019));
        }
    }

    public boolean xw() {
        return this.aAF;
    }

    public void xx() {
        boolean z = false;
        if (2 == UtilHelper.getRealScreenOrientation(this.mContext)) {
            z = true;
        }
        if (this.aAH != null) {
            this.aAH.xx();
        }
        if (this.aAI != null) {
            this.aAI.bq(z);
        }
        if (this.aAJ != null) {
            this.aAJ.bq(z);
        }
    }

    public void onDestroy() {
        this.aAG = 0;
        this.aAE.clear();
        this.aAF = false;
        if (this.aAH != null) {
            this.aAH.onDestroy();
        }
        if (this.aAI != null) {
            this.aAI.onDestroy();
        }
        if (this.aAJ != null) {
            this.aAJ.onDestroy();
        }
        this.mContext = null;
    }

    protected void log(Object... objArr) {
        AlaStatManager.getInstance().newDebug("alaGift", 0L, null, objArr);
    }

    public void aX(boolean z) {
        this.azP = z;
    }
}

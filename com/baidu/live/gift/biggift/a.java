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
    private int aAA;
    private AlaDynamicVideoGiftLayout aAB;
    private AlaDynamicGiftLayout aAC;
    private AlaDynamicGiftSmallGiftStyleView aAD;
    private k aAx;
    private boolean aAz;
    private Context mContext;
    private boolean azJ = false;
    private b aAE = new b() { // from class: com.baidu.live.gift.biggift.a.1
        @Override // com.baidu.live.gift.biggift.b
        public void onStart() {
            a.this.aAz = true;
        }

        @Override // com.baidu.live.gift.biggift.b
        public void bG(int i) {
        }

        @Override // com.baidu.live.gift.biggift.b
        public void onEnd() {
            a.this.aAz = false;
            a.this.aAx.wH();
            a.this.xu();
        }
    };
    private ArrayList<com.baidu.live.gift.a.c> aAy = new ArrayList<>();

    public a(Context context, k kVar) {
        this.aAA = 0;
        this.mContext = context;
        this.aAx = kVar;
        this.aAA = 0;
    }

    public void h(com.baidu.live.gift.a.c cVar) {
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            long j = cVar.aEb;
            cVar.aEb = 1L;
            for (int i = 0; i < j; i++) {
                com.baidu.live.gift.a.c clone = cVar.clone();
                if (clone != null) {
                    if (cVar.priority == 11) {
                        this.aAy.add(0, clone);
                    } else {
                        this.aAy.add(clone);
                    }
                    if (clone.aEd) {
                        LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_ENTER_LIST, clone.aqq, clone.aqr, clone.giftId, "");
                    }
                }
            }
            try {
                xr();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void xr() {
        if (this.aAy != null) {
            int i = com.baidu.live.v.a.Eo().aQp != null ? com.baidu.live.v.a.Eo().aQp.atn : 0;
            if (i > 0 && this.aAy.size() >= i) {
                Collections.sort(this.aAy, new c.a());
                int max = Math.max((int) (i * 0.7f), 1);
                ArrayList arrayList = new ArrayList(this.aAy.subList(0, max));
                while (true) {
                    int i2 = max;
                    if (i2 < this.aAy.size()) {
                        if (this.aAy.get(i2) == null || !this.aAy.get(i2).aEg) {
                            max = i2 + 1;
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 1));
                            break;
                        }
                    } else {
                        break;
                    }
                }
                this.aAy.clear();
                this.aAy.addAll(arrayList);
            }
        }
    }

    public void xs() {
        if (!xx()) {
            xu();
        }
    }

    public void xt() {
        if (this.aAz) {
            if (this.aAB != null) {
                this.aAB.stopAnim();
            }
            if (this.aAC != null) {
                this.aAC.stopAnim();
            }
            if (this.aAD != null) {
                this.aAD.stopAnim();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xu() {
        if (this.aAy.isEmpty()) {
            this.aAx.wF();
            xw();
            return;
        }
        com.baidu.live.gift.a.c xv = xv();
        if (xv == null) {
            xu();
        } else {
            i(xv);
        }
    }

    private com.baidu.live.gift.a.c xv() {
        if (this.aAy.isEmpty()) {
            return null;
        }
        return this.aAy.remove(0);
    }

    private void xw() {
        this.aAx.wH();
    }

    private void i(com.baidu.live.gift.a.c cVar) {
        if (cVar != null) {
            if (cVar.aEg) {
                j(cVar);
                return;
            }
            boolean z = UtilHelper.getRealScreenOrientation(this.mContext) == 2;
            if (this.azJ && z && !cVar.aDW) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913138, cVar));
                xu();
                return;
            }
            try {
                if (cVar.aDX != null && com.baidu.live.gift.b.b.yT().ee(cVar.aDX.vV())) {
                    com.baidu.live.gift.c ey = com.baidu.live.gift.b.b.yT().ey(cVar.giftId);
                    if (com.baidu.live.alphavideo.a.tL().tM() && ey != null && ey.aym != null && ey.aym.vC() && !TextUtils.isEmpty(ey.vF())) {
                        a(ey, cVar);
                    } else if (ey != null && !ListUtils.isEmpty(ey.getDynamicGiftPicPathList())) {
                        if (this.aAC == null) {
                            this.aAC = new AlaDynamicGiftLayout(this.mContext);
                        }
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aAC.getLayoutParams();
                        if (layoutParams == null) {
                            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                        }
                        this.aAx.a(this.aAC, layoutParams);
                        this.aAC.setData(ey, cVar);
                        this.aAC.setBigGiftCallBack(this.aAE);
                        this.aAC.startAnim();
                    } else {
                        if (this.aAD == null) {
                            this.aAD = new AlaDynamicGiftSmallGiftStyleView(this.mContext);
                        }
                        this.aAx.M(this.aAD);
                        this.aAD.setData(cVar);
                        this.aAD.setBigGiftCallBack(this.aAE);
                        this.aAD.startAnim();
                    }
                    if (cVar.aEd) {
                        LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW, cVar.aqq, cVar.aqr, cVar.giftId, "");
                    }
                } else if (cVar.aEd) {
                    LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW_FAIL, cVar.aqq, cVar.aqr, cVar.giftId, "不在大礼物列表");
                }
            } catch (OutOfMemoryError e) {
                log(BdStatsConstant.StatsType.ERROR, "showbiggift", TiebaInitialize.LogFields.REASON, "oom");
                TbadkCoreApplication.getInst().onAppMemoryLow();
                System.gc();
                if (cVar.aEd) {
                    LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW_FAIL, cVar.aqq, cVar.aqr, cVar.giftId, "OOM");
                }
                if (this.aAA < 1) {
                    this.aAA++;
                    i(cVar);
                } else {
                    xu();
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2913019));
        }
    }

    private void a(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2) {
        if (this.aAB == null) {
            this.aAB = new AlaDynamicVideoGiftLayout(this.mContext);
        }
        ViewGroup.LayoutParams layoutParams = this.aAB.getLayoutParams();
        if (!(layoutParams instanceof RelativeLayout.LayoutParams)) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        }
        this.aAx.a(this.aAB, (RelativeLayout.LayoutParams) layoutParams);
        this.aAB.setData(cVar, cVar2);
        this.aAB.setBigGiftCallBack(this.aAE);
        this.aAB.startAnim();
    }

    private void j(com.baidu.live.gift.a.c cVar) {
        com.baidu.live.entereffect.a.a dR = com.baidu.live.entereffect.a.vo().dR(cVar.giftId);
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 1));
            xu();
        } else if (dR == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 1));
            xu();
        } else {
            com.baidu.live.gift.c cVar2 = dR.axH;
            if (cVar2 == null || ListUtils.isEmpty(cVar2.unZipFilesPathList)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 1));
                xu();
                return;
            }
            try {
                if (this.aAC == null) {
                    this.aAC = new AlaDynamicGiftLayout(this.mContext);
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aAC.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                }
                this.aAx.a(this.aAC, layoutParams);
                this.aAC.setData(cVar2, cVar);
                this.aAC.setBigGiftCallBack(this.aAE);
                this.aAC.startAnim();
                MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 0));
            } catch (OutOfMemoryError e) {
                log(BdStatsConstant.StatsType.ERROR, "showbiggift", TiebaInitialize.LogFields.REASON, "oom");
                TbadkCoreApplication.getInst().onAppMemoryLow();
                System.gc();
                if (this.aAA < 1) {
                    this.aAA++;
                    i(cVar);
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 1));
                    xu();
                    return;
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2913019));
        }
    }

    public boolean xx() {
        return this.aAz;
    }

    public void xy() {
        boolean z = false;
        if (2 == UtilHelper.getRealScreenOrientation(this.mContext)) {
            z = true;
        }
        if (this.aAB != null) {
            this.aAB.xy();
        }
        if (this.aAC != null) {
            this.aAC.bq(z);
        }
        if (this.aAD != null) {
            this.aAD.bq(z);
        }
    }

    public void onDestroy() {
        this.aAA = 0;
        this.aAy.clear();
        this.aAz = false;
        if (this.aAB != null) {
            this.aAB.onDestroy();
        }
        if (this.aAC != null) {
            this.aAC.onDestroy();
        }
        if (this.aAD != null) {
            this.aAD.onDestroy();
        }
        this.mContext = null;
    }

    protected void log(Object... objArr) {
        AlaStatManager.getInstance().newDebug("alaGift", 0L, null, objArr);
    }

    public void aX(boolean z) {
        this.azJ = z;
    }
}

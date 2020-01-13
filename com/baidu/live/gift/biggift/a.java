package com.baidu.live.gift.biggift;

import android.content.Context;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.stats.BdStatisticsManager;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.gift.a.c;
import com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout;
import com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView;
import com.baidu.live.gift.k;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.UtilHelper;
import java.util.ArrayList;
import java.util.Collections;
/* loaded from: classes2.dex */
public class a {
    private k afL;
    private boolean afN;
    private int afO;
    private AlaDynamicGiftLayout afP;
    private AlaDynamicGiftSmallGiftStyleView afQ;
    private Context mContext;
    private boolean aeY = false;
    private b afR = new b() { // from class: com.baidu.live.gift.biggift.a.1
        @Override // com.baidu.live.gift.biggift.b
        public void onStart() {
            a.this.afN = true;
        }

        @Override // com.baidu.live.gift.biggift.b
        public void bm(int i) {
        }

        @Override // com.baidu.live.gift.biggift.b
        public void onEnd() {
            a.this.afN = false;
            a.this.afL.ri();
            a.this.rL();
        }
    };
    private ArrayList<com.baidu.live.gift.a.c> afM = new ArrayList<>();

    public a(Context context, k kVar) {
        this.afO = 0;
        this.mContext = context;
        this.afL = kVar;
        this.afO = 0;
    }

    public void f(com.baidu.live.gift.a.c cVar) {
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            long j = cVar.ajs;
            cVar.ajs = 1L;
            for (int i = 0; i < j; i++) {
                com.baidu.live.gift.a.c clone = cVar.clone();
                if (clone != null) {
                    if (cVar.priority == 11) {
                        this.afM.add(0, clone);
                    } else {
                        this.afM.add(clone);
                    }
                }
            }
            try {
                rI();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void rI() {
        if (this.afM != null) {
            int i = com.baidu.live.s.a.wR().asq != null ? com.baidu.live.s.a.wR().asq.YW : 0;
            if (i > 0 && this.afM.size() >= i) {
                Collections.sort(this.afM, new c.a());
                int max = Math.max((int) (i * 0.7f), 1);
                ArrayList arrayList = new ArrayList(this.afM.subList(0, max));
                while (true) {
                    int i2 = max;
                    if (i2 < this.afM.size()) {
                        if (this.afM.get(i2) == null || !this.afM.get(i2).ajx) {
                            max = i2 + 1;
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 1));
                            break;
                        }
                    } else {
                        break;
                    }
                }
                this.afM.clear();
                this.afM.addAll(arrayList);
            }
        }
    }

    public void rJ() {
        if (!rO()) {
            rL();
        }
    }

    public void rK() {
        if (this.afN) {
            if (this.afP != null) {
                this.afP.stopAnim();
            }
            if (this.afQ != null) {
                this.afQ.stopAnim();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rL() {
        if (this.afM.isEmpty()) {
            this.afL.rg();
            rN();
            return;
        }
        com.baidu.live.gift.a.c rM = rM();
        if (rM == null) {
            rL();
        } else {
            g(rM);
        }
    }

    private com.baidu.live.gift.a.c rM() {
        if (this.afM.isEmpty()) {
            return null;
        }
        return this.afM.remove(0);
    }

    private void rN() {
        this.afL.ri();
    }

    private void g(com.baidu.live.gift.a.c cVar) {
        if (cVar != null) {
            if (cVar.ajx) {
                h(cVar);
                return;
            }
            boolean z = UtilHelper.getRealScreenOrientation(this.mContext) == 2;
            if (this.aeY && z && !cVar.ajn) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913138, cVar));
                rL();
                return;
            }
            try {
                if (cVar.ajo != null && com.baidu.live.gift.b.b.ta().de(cVar.ajo.qE())) {
                    com.baidu.live.gift.c dw = com.baidu.live.gift.b.b.ta().dw(cVar.giftId);
                    if (dw != null && !ListUtils.isEmpty(dw.getDynamicGiftPicPathList())) {
                        if (this.afP == null) {
                            this.afP = new AlaDynamicGiftLayout(this.mContext);
                        }
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.afP.getLayoutParams();
                        if (layoutParams == null) {
                            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                        }
                        this.afL.a(this.afP, layoutParams);
                        this.afP.setData(dw, cVar);
                        this.afP.setBigGiftCallBack(this.afR);
                        this.afP.startAnim();
                    } else {
                        if (this.afQ == null) {
                            this.afQ = new AlaDynamicGiftSmallGiftStyleView(this.mContext);
                        }
                        this.afL.K(this.afQ);
                        this.afQ.setData(cVar);
                        this.afQ.setBigGiftCallBack(this.afR);
                        this.afQ.startAnim();
                    }
                }
            } catch (OutOfMemoryError e) {
                log(BdStatsConstant.StatsType.ERROR, "showbiggift", TiebaInitialize.LogFields.REASON, "oom");
                TbadkCoreApplication.getInst().onAppMemoryLow();
                System.gc();
                if (this.afO < 1) {
                    this.afO++;
                    g(cVar);
                } else {
                    rL();
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2913019));
        }
    }

    private void h(com.baidu.live.gift.a.c cVar) {
        com.baidu.live.entereffect.a.a cR = com.baidu.live.entereffect.a.qg().cR(cVar.giftId);
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 1));
            rL();
        } else if (cR == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 1));
            rL();
        } else {
            com.baidu.live.gift.c cVar2 = cR.ade;
            if (cVar2 == null || ListUtils.isEmpty(cVar2.unZipFilesPathList)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 1));
                rL();
                return;
            }
            try {
                if (this.afP == null) {
                    this.afP = new AlaDynamicGiftLayout(this.mContext);
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.afP.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                }
                this.afL.a(this.afP, layoutParams);
                this.afP.setData(cVar2, cVar);
                this.afP.setBigGiftCallBack(this.afR);
                this.afP.startAnim();
                MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 0));
            } catch (OutOfMemoryError e) {
                log(BdStatsConstant.StatsType.ERROR, "showbiggift", TiebaInitialize.LogFields.REASON, "oom");
                TbadkCoreApplication.getInst().onAppMemoryLow();
                System.gc();
                if (this.afO < 1) {
                    this.afO++;
                    g(cVar);
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 1));
                    rL();
                    return;
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2913019));
        }
    }

    public boolean rO() {
        return this.afN;
    }

    public void rP() {
        boolean z = false;
        if (2 == UtilHelper.getRealScreenOrientation(this.mContext)) {
            z = true;
        }
        if (this.afP != null) {
            this.afP.aL(z);
        }
        if (this.afQ != null) {
            this.afQ.aL(z);
        }
    }

    public void onDestroy() {
        this.afO = 0;
        this.afM.clear();
        this.afN = false;
        if (this.afP != null) {
            this.afP.onDestroy();
        }
        if (this.afQ != null) {
            this.afQ.onDestroy();
        }
        this.mContext = null;
    }

    protected void log(Object... objArr) {
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            BdStatisticsManager.getInstance().newDebug("alaGift", 0L, null, objArr);
        }
    }

    public void aw(boolean z) {
        this.aeY = z;
    }
}

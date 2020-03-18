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
    private k aie;
    private boolean aig;
    private int aih;
    private AlaDynamicVideoGiftLayout aii;
    private AlaDynamicGiftLayout aij;
    private AlaDynamicGiftSmallGiftStyleView aik;
    private Context mContext;
    private boolean ahp = false;
    private b ail = new b() { // from class: com.baidu.live.gift.biggift.a.1
        @Override // com.baidu.live.gift.biggift.b
        public void onStart() {
            a.this.aig = true;
        }

        @Override // com.baidu.live.gift.biggift.b
        public void bt(int i) {
        }

        @Override // com.baidu.live.gift.biggift.b
        public void onEnd() {
            a.this.aig = false;
            a.this.aie.so();
            a.this.tb();
        }
    };
    private ArrayList<com.baidu.live.gift.a.c> aif = new ArrayList<>();

    public a(Context context, k kVar) {
        this.aih = 0;
        this.mContext = context;
        this.aie = kVar;
        this.aih = 0;
    }

    public void f(com.baidu.live.gift.a.c cVar) {
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            long j = cVar.alL;
            cVar.alL = 1L;
            for (int i = 0; i < j; i++) {
                com.baidu.live.gift.a.c clone = cVar.clone();
                if (clone != null) {
                    if (cVar.priority == 11) {
                        this.aif.add(0, clone);
                    } else {
                        this.aif.add(clone);
                    }
                    if (clone.alN) {
                        LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_ENTER_LIST, clone.Yh, clone.Yi, clone.giftId, "");
                    }
                }
            }
            try {
                sY();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void sY() {
        if (this.aif != null) {
            int i = com.baidu.live.v.a.zs().awM != null ? com.baidu.live.v.a.zs().awM.aaY : 0;
            if (i > 0 && this.aif.size() >= i) {
                Collections.sort(this.aif, new c.a());
                int max = Math.max((int) (i * 0.7f), 1);
                ArrayList arrayList = new ArrayList(this.aif.subList(0, max));
                while (true) {
                    int i2 = max;
                    if (i2 < this.aif.size()) {
                        if (this.aif.get(i2) == null || !this.aif.get(i2).alQ) {
                            max = i2 + 1;
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 1));
                            break;
                        }
                    } else {
                        break;
                    }
                }
                this.aif.clear();
                this.aif.addAll(arrayList);
            }
        }
    }

    public void sZ() {
        if (!te()) {
            tb();
        }
    }

    public void ta() {
        if (this.aig) {
            if (this.aii != null) {
                this.aii.stopAnim();
            }
            if (this.aij != null) {
                this.aij.stopAnim();
            }
            if (this.aik != null) {
                this.aik.stopAnim();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tb() {
        if (this.aif.isEmpty()) {
            this.aie.sm();
            td();
            return;
        }
        com.baidu.live.gift.a.c tc = tc();
        if (tc == null) {
            tb();
        } else {
            g(tc);
        }
    }

    private com.baidu.live.gift.a.c tc() {
        if (this.aif.isEmpty()) {
            return null;
        }
        return this.aif.remove(0);
    }

    private void td() {
        this.aie.so();
    }

    private void g(com.baidu.live.gift.a.c cVar) {
        if (cVar != null) {
            if (cVar.alQ) {
                h(cVar);
                return;
            }
            boolean z = UtilHelper.getRealScreenOrientation(this.mContext) == 2;
            if (this.ahp && z && !cVar.alG) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913138, cVar));
                tb();
                return;
            }
            try {
                if (cVar.alH != null && com.baidu.live.gift.b.b.uz().dn(cVar.alH.rC())) {
                    com.baidu.live.gift.c dG = com.baidu.live.gift.b.b.uz().dG(cVar.giftId);
                    if (com.baidu.live.alphavideo.a.pA().pB() && dG != null && dG.afV != null && dG.afV.rk() && !TextUtils.isEmpty(dG.rn())) {
                        a(dG, cVar);
                    } else if (dG != null && !ListUtils.isEmpty(dG.getDynamicGiftPicPathList())) {
                        if (this.aij == null) {
                            this.aij = new AlaDynamicGiftLayout(this.mContext);
                        }
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aij.getLayoutParams();
                        if (layoutParams == null) {
                            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                        }
                        this.aie.a(this.aij, layoutParams);
                        this.aij.setData(dG, cVar);
                        this.aij.setBigGiftCallBack(this.ail);
                        this.aij.startAnim();
                    } else {
                        if (this.aik == null) {
                            this.aik = new AlaDynamicGiftSmallGiftStyleView(this.mContext);
                        }
                        this.aie.K(this.aik);
                        this.aik.setData(cVar);
                        this.aik.setBigGiftCallBack(this.ail);
                        this.aik.startAnim();
                    }
                    if (cVar.alN) {
                        LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW, cVar.Yh, cVar.Yi, cVar.giftId, "");
                    }
                } else if (cVar.alN) {
                    LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW_FAIL, cVar.Yh, cVar.Yi, cVar.giftId, "不在大礼物列表");
                }
            } catch (OutOfMemoryError e) {
                log(BdStatsConstant.StatsType.ERROR, "showbiggift", TiebaInitialize.LogFields.REASON, "oom");
                TbadkCoreApplication.getInst().onAppMemoryLow();
                System.gc();
                if (cVar.alN) {
                    LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW_FAIL, cVar.Yh, cVar.Yi, cVar.giftId, "OOM");
                }
                if (this.aih < 1) {
                    this.aih++;
                    g(cVar);
                } else {
                    tb();
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2913019));
        }
    }

    private void a(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2) {
        if (this.aii == null) {
            this.aii = new AlaDynamicVideoGiftLayout(this.mContext);
        }
        ViewGroup.LayoutParams layoutParams = this.aii.getLayoutParams();
        if (!(layoutParams instanceof RelativeLayout.LayoutParams)) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        }
        this.aie.a(this.aii, (RelativeLayout.LayoutParams) layoutParams);
        this.aii.setData(cVar, cVar2);
        this.aii.setBigGiftCallBack(this.ail);
        this.aii.startAnim();
    }

    private void h(com.baidu.live.gift.a.c cVar) {
        com.baidu.live.entereffect.a.a cZ = com.baidu.live.entereffect.a.qW().cZ(cVar.giftId);
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 1));
            tb();
        } else if (cZ == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 1));
            tb();
        } else {
            com.baidu.live.gift.c cVar2 = cZ.afq;
            if (cVar2 == null || ListUtils.isEmpty(cVar2.unZipFilesPathList)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 1));
                tb();
                return;
            }
            try {
                if (this.aij == null) {
                    this.aij = new AlaDynamicGiftLayout(this.mContext);
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aij.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                }
                this.aie.a(this.aij, layoutParams);
                this.aij.setData(cVar2, cVar);
                this.aij.setBigGiftCallBack(this.ail);
                this.aij.startAnim();
                MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 0));
            } catch (OutOfMemoryError e) {
                log(BdStatsConstant.StatsType.ERROR, "showbiggift", TiebaInitialize.LogFields.REASON, "oom");
                TbadkCoreApplication.getInst().onAppMemoryLow();
                System.gc();
                if (this.aih < 1) {
                    this.aih++;
                    g(cVar);
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 1));
                    tb();
                    return;
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2913019));
        }
    }

    public boolean te() {
        return this.aig;
    }

    public void tf() {
        boolean z = false;
        if (2 == UtilHelper.getRealScreenOrientation(this.mContext)) {
            z = true;
        }
        if (this.aii != null) {
            this.aii.tf();
        }
        if (this.aij != null) {
            this.aij.aO(z);
        }
        if (this.aik != null) {
            this.aik.aO(z);
        }
    }

    public void onDestroy() {
        this.aih = 0;
        this.aif.clear();
        this.aig = false;
        if (this.aii != null) {
            this.aii.onDestroy();
        }
        if (this.aij != null) {
            this.aij.onDestroy();
        }
        if (this.aik != null) {
            this.aik.onDestroy();
        }
        this.mContext = null;
    }

    protected void log(Object... objArr) {
        AlaStatManager.getInstance().newDebug("alaGift", 0L, null, objArr);
    }

    public void az(boolean z) {
        this.ahp = z;
    }
}

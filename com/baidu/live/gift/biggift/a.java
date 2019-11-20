package com.baidu.live.gift.biggift;

import android.content.Context;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.stats.BdStatisticsManager;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.gift.a.d;
import com.baidu.live.gift.dynamicGift.AlaDynamicGiftLayout;
import com.baidu.live.gift.dynamicGift.AlaDynamicGiftSmallGiftStyleView;
import com.baidu.live.gift.j;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.UtilHelper;
import java.util.ArrayList;
import java.util.Collections;
/* loaded from: classes6.dex */
public class a {
    private j Xr;
    private boolean Xt;
    private int Xu;
    private AlaDynamicGiftLayout Xv;
    private AlaDynamicGiftSmallGiftStyleView Xw;
    private Context mContext;
    private boolean WL = false;
    private b Xx = new b() { // from class: com.baidu.live.gift.biggift.a.1
        @Override // com.baidu.live.gift.biggift.b
        public void onStart() {
            a.this.Xt = true;
        }

        @Override // com.baidu.live.gift.biggift.b
        public void ba(int i) {
        }

        @Override // com.baidu.live.gift.biggift.b
        public void onEnd() {
            a.this.Xt = false;
            a.this.Xr.pz();
            a.this.pW();
        }
    };
    private ArrayList<d> Xs = new ArrayList<>();

    public a(Context context, j jVar) {
        this.Xu = 0;
        this.mContext = context;
        this.Xr = jVar;
        this.Xu = 0;
    }

    public void f(d dVar) {
        if (dVar != null && !StringUtils.isNull(dVar.userId) && !StringUtils.isNull(dVar.giftId)) {
            for (int i = 0; i < dVar.aaE; i++) {
                if (dVar.priority == 11) {
                    this.Xs.add(0, dVar);
                } else {
                    this.Xs.add(dVar);
                }
            }
            try {
                pT();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void pT() {
        if (this.Xs != null) {
            int i = com.baidu.live.l.a.uB().ajF != null ? com.baidu.live.l.a.uB().ajF.RY : 0;
            if (i > 0 && this.Xs.size() >= i) {
                Collections.sort(this.Xs, new d.a());
                int max = Math.max((int) (i * 0.7f), 1);
                ArrayList arrayList = new ArrayList(this.Xs.subList(0, max));
                while (true) {
                    int i2 = max;
                    if (i2 < this.Xs.size()) {
                        if (this.Xs.get(i2) == null || !this.Xs.get(i2).aaJ) {
                            max = i2 + 1;
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 1));
                            break;
                        }
                    } else {
                        break;
                    }
                }
                this.Xs.clear();
                this.Xs.addAll(arrayList);
            }
        }
    }

    public void pU() {
        if (!pZ()) {
            pW();
        }
    }

    public void pV() {
        if (this.Xt) {
            if (this.Xv != null) {
                this.Xv.stopAnim();
            }
            if (this.Xw != null) {
                this.Xw.stopAnim();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pW() {
        if (this.Xs.isEmpty()) {
            this.Xr.px();
            pY();
            return;
        }
        d pX = pX();
        if (pX == null) {
            pW();
        } else {
            g(pX);
        }
    }

    private d pX() {
        if (this.Xs.isEmpty()) {
            return null;
        }
        return this.Xs.remove(0);
    }

    private void pY() {
        this.Xr.pz();
    }

    private void g(d dVar) {
        if (dVar != null) {
            if (dVar.aaJ) {
                h(dVar);
                return;
            }
            boolean z = UtilHelper.getRealScreenOrientation(this.mContext) == 2;
            if (this.WL && z && !dVar.aay) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913138, dVar));
                pW();
                return;
            }
            try {
                if (dVar.aaz != null && com.baidu.live.gift.b.b.rd().ck(dVar.aaz.pc())) {
                    com.baidu.live.gift.c cC = com.baidu.live.gift.b.b.rd().cC(dVar.giftId);
                    if (cC != null && !ListUtils.isEmpty(cC.getDynamicGiftPicPathList())) {
                        if (this.Xv == null) {
                            this.Xv = new AlaDynamicGiftLayout(this.mContext);
                        }
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Xv.getLayoutParams();
                        if (layoutParams == null) {
                            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                        }
                        this.Xr.a(this.Xv, layoutParams);
                        this.Xv.setData(cC, dVar);
                        this.Xv.setBigGiftCallBack(this.Xx);
                        this.Xv.startAnim();
                    } else {
                        if (this.Xw == null) {
                            this.Xw = new AlaDynamicGiftSmallGiftStyleView(this.mContext);
                        }
                        this.Xr.J(this.Xw);
                        this.Xw.setData(dVar);
                        this.Xw.setBigGiftCallBack(this.Xx);
                        this.Xw.startAnim();
                    }
                }
            } catch (OutOfMemoryError e) {
                log(BdStatsConstant.StatsType.ERROR, "showbiggift", TiebaInitialize.LogFields.REASON, "oom");
                TbadkCoreApplication.getInst().onAppMemoryLow();
                System.gc();
                if (this.Xu < 1) {
                    this.Xu++;
                    g(dVar);
                } else {
                    pW();
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2913019));
        }
    }

    private void h(d dVar) {
        com.baidu.live.entereffect.a.a bY = com.baidu.live.entereffect.a.oF().bY(dVar.giftId);
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 1));
            pW();
        } else if (bY == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 1));
            pW();
        } else {
            com.baidu.live.gift.c cVar = bY.Vn;
            if (cVar == null || ListUtils.isEmpty(cVar.unZipFilesPathList)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 1));
                pW();
                return;
            }
            try {
                if (this.Xv == null) {
                    this.Xv = new AlaDynamicGiftLayout(this.mContext);
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Xv.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                }
                this.Xr.a(this.Xv, layoutParams);
                this.Xv.setData(cVar, dVar);
                this.Xv.setBigGiftCallBack(this.Xx);
                this.Xv.startAnim();
                MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 0));
            } catch (OutOfMemoryError e) {
                log(BdStatsConstant.StatsType.ERROR, "showbiggift", TiebaInitialize.LogFields.REASON, "oom");
                TbadkCoreApplication.getInst().onAppMemoryLow();
                System.gc();
                if (this.Xu < 1) {
                    this.Xu++;
                    g(dVar);
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 1));
                    pW();
                    return;
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2913019));
        }
    }

    public boolean pZ() {
        return this.Xt;
    }

    public void qa() {
        boolean z = false;
        if (2 == UtilHelper.getRealScreenOrientation(this.mContext)) {
            z = true;
        }
        if (this.Xv != null) {
            this.Xv.at(z);
        }
        if (this.Xw != null) {
            this.Xw.at(z);
        }
    }

    public void onDestroy() {
        this.Xu = 0;
        this.Xs.clear();
        this.Xt = false;
        if (this.Xv != null) {
            this.Xv.onDestroy();
        }
        if (this.Xw != null) {
            this.Xw.onDestroy();
        }
        this.mContext = null;
    }

    protected void log(Object... objArr) {
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            BdStatisticsManager.getInstance().newDebug("alaGift", 0L, null, objArr);
        }
    }

    public void aj(boolean z) {
        this.WL = z;
    }
}

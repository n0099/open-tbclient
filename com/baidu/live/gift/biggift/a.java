package com.baidu.live.gift.biggift;

import android.content.Context;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
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
/* loaded from: classes6.dex */
public class a {
    private j XJ;
    private boolean XL;
    private int XM;
    private AlaDynamicGiftLayout XN;
    private AlaDynamicGiftSmallGiftStyleView XO;
    private Context mContext;
    private b XP = new b() { // from class: com.baidu.live.gift.biggift.a.1
        @Override // com.baidu.live.gift.biggift.b
        public void onStart() {
            a.this.XL = true;
        }

        @Override // com.baidu.live.gift.biggift.b
        public void ba(int i) {
        }

        @Override // com.baidu.live.gift.biggift.b
        public void onEnd() {
            a.this.XL = false;
            a.this.XJ.pz();
            a.this.pV();
        }
    };
    private ArrayList<d> XK = new ArrayList<>();

    public a(Context context, j jVar) {
        this.XM = 0;
        this.mContext = context;
        this.XJ = jVar;
        this.XM = 0;
    }

    public void f(d dVar) {
        if (dVar != null && !StringUtils.isNull(dVar.userId) && !StringUtils.isNull(dVar.giftId)) {
            for (int i = 0; i < dVar.aaW; i++) {
                if (dVar.priority == 11) {
                    this.XK.add(0, dVar);
                } else {
                    this.XK.add(dVar);
                }
            }
        }
    }

    public void pT() {
        if (!pY()) {
            pV();
        }
    }

    public void pU() {
        if (this.XL) {
            if (this.XN != null) {
                this.XN.stopAnim();
            }
            if (this.XO != null) {
                this.XO.stopAnim();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pV() {
        if (this.XK.isEmpty()) {
            this.XJ.px();
            pX();
            return;
        }
        d pW = pW();
        if (pW == null) {
            pV();
        } else {
            g(pW);
        }
    }

    private d pW() {
        if (this.XK.isEmpty()) {
            return null;
        }
        return this.XK.remove(0);
    }

    private void pX() {
        this.XJ.pz();
    }

    private void g(d dVar) {
        if (dVar != null) {
            if (dVar.abb) {
                h(dVar);
                return;
            }
            try {
                if (dVar.aaR != null && com.baidu.live.gift.b.b.rc().ck(dVar.aaR.pc())) {
                    com.baidu.live.gift.c cC = com.baidu.live.gift.b.b.rc().cC(dVar.giftId);
                    if (cC != null && !ListUtils.isEmpty(cC.getDynamicGiftPicPathList())) {
                        if (this.XN == null) {
                            this.XN = new AlaDynamicGiftLayout(this.mContext);
                        }
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.XN.getLayoutParams();
                        if (layoutParams == null) {
                            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                        }
                        this.XJ.a(this.XN, layoutParams);
                        this.XN.setData(cC, dVar);
                        this.XN.setBigGiftCallBack(this.XP);
                        this.XN.startAnim();
                    } else {
                        if (this.XO == null) {
                            this.XO = new AlaDynamicGiftSmallGiftStyleView(this.mContext);
                        }
                        this.XJ.J(this.XO);
                        this.XO.setData(dVar);
                        this.XO.setBigGiftCallBack(this.XP);
                        this.XO.startAnim();
                    }
                }
            } catch (OutOfMemoryError e) {
                log(BdStatsConstant.StatsType.ERROR, "showbiggift", TiebaInitialize.LogFields.REASON, "oom");
                TbadkCoreApplication.getInst().onAppMemoryLow();
                System.gc();
                if (this.XM < 1) {
                    this.XM++;
                    g(dVar);
                } else {
                    pV();
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2913019));
        }
    }

    private void h(d dVar) {
        com.baidu.live.entereffect.a.a bY = com.baidu.live.entereffect.a.oF().bY(dVar.giftId);
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            pV();
        } else if (bY == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 1));
            pV();
        } else {
            com.baidu.live.gift.c cVar = bY.VG;
            if (cVar == null || ListUtils.isEmpty(cVar.unZipFilesPathList)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 1));
                pV();
                return;
            }
            try {
                if (this.XN == null) {
                    this.XN = new AlaDynamicGiftLayout(this.mContext);
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.XN.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                }
                this.XJ.a(this.XN, layoutParams);
                this.XN.setData(cVar, dVar);
                this.XN.setBigGiftCallBack(this.XP);
                this.XN.startAnim();
                MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 0));
            } catch (OutOfMemoryError e) {
                log(BdStatsConstant.StatsType.ERROR, "showbiggift", TiebaInitialize.LogFields.REASON, "oom");
                TbadkCoreApplication.getInst().onAppMemoryLow();
                System.gc();
                if (this.XM < 1) {
                    this.XM++;
                    g(dVar);
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 1));
                    pV();
                    return;
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2913019));
        }
    }

    public boolean pY() {
        return this.XL;
    }

    public void pZ() {
        boolean z = false;
        if (2 == UtilHelper.getRealScreenOrientation(this.mContext)) {
            z = true;
        }
        if (this.XN != null) {
            this.XN.at(z);
        }
        if (this.XO != null) {
            this.XO.at(z);
        }
    }

    public void onDestroy() {
        this.XM = 0;
        this.XK.clear();
        this.XL = false;
        if (this.XN != null) {
            this.XN.onDestroy();
        }
        if (this.XO != null) {
            this.XO.onDestroy();
        }
        this.mContext = null;
    }

    protected void log(Object... objArr) {
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            BdStatisticsManager.getInstance().newDebug("alaGift", 0L, null, objArr);
        }
    }
}

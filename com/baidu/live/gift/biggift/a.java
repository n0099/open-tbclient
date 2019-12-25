package com.baidu.live.gift.biggift;

import android.content.Context;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.stats.BdStatisticsManager;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.gift.a.b;
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
    private k afc;
    private boolean afe;
    private int aff;
    private AlaDynamicGiftLayout afg;
    private AlaDynamicGiftSmallGiftStyleView afh;
    private Context mContext;
    private boolean aep = false;
    private b afi = new b() { // from class: com.baidu.live.gift.biggift.a.1
        @Override // com.baidu.live.gift.biggift.b
        public void onStart() {
            a.this.afe = true;
        }

        @Override // com.baidu.live.gift.biggift.b
        public void bm(int i) {
        }

        @Override // com.baidu.live.gift.biggift.b
        public void onEnd() {
            a.this.afe = false;
            a.this.afc.qW();
            a.this.ry();
        }
    };
    private ArrayList<com.baidu.live.gift.a.b> afd = new ArrayList<>();

    public a(Context context, k kVar) {
        this.aff = 0;
        this.mContext = context;
        this.afc = kVar;
        this.aff = 0;
    }

    public void f(com.baidu.live.gift.a.b bVar) {
        if (bVar != null && !StringUtils.isNull(bVar.userId) && !StringUtils.isNull(bVar.giftId)) {
            long j = bVar.aiH;
            bVar.aiH = 1L;
            for (int i = 0; i < j; i++) {
                com.baidu.live.gift.a.b clone = bVar.clone();
                if (clone != null) {
                    if (bVar.priority == 11) {
                        this.afd.add(0, clone);
                    } else {
                        this.afd.add(clone);
                    }
                }
            }
            try {
                rv();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void rv() {
        if (this.afd != null) {
            int i = com.baidu.live.r.a.wA().arE != null ? com.baidu.live.r.a.wA().arE.YK : 0;
            if (i > 0 && this.afd.size() >= i) {
                Collections.sort(this.afd, new b.a());
                int max = Math.max((int) (i * 0.7f), 1);
                ArrayList arrayList = new ArrayList(this.afd.subList(0, max));
                while (true) {
                    int i2 = max;
                    if (i2 < this.afd.size()) {
                        if (this.afd.get(i2) == null || !this.afd.get(i2).aiM) {
                            max = i2 + 1;
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 1));
                            break;
                        }
                    } else {
                        break;
                    }
                }
                this.afd.clear();
                this.afd.addAll(arrayList);
            }
        }
    }

    public void rw() {
        if (!rB()) {
            ry();
        }
    }

    public void rx() {
        if (this.afe) {
            if (this.afg != null) {
                this.afg.stopAnim();
            }
            if (this.afh != null) {
                this.afh.stopAnim();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ry() {
        if (this.afd.isEmpty()) {
            this.afc.qU();
            rA();
            return;
        }
        com.baidu.live.gift.a.b rz = rz();
        if (rz == null) {
            ry();
        } else {
            g(rz);
        }
    }

    private com.baidu.live.gift.a.b rz() {
        if (this.afd.isEmpty()) {
            return null;
        }
        return this.afd.remove(0);
    }

    private void rA() {
        this.afc.qW();
    }

    private void g(com.baidu.live.gift.a.b bVar) {
        if (bVar != null) {
            if (bVar.aiM) {
                h(bVar);
                return;
            }
            boolean z = UtilHelper.getRealScreenOrientation(this.mContext) == 2;
            if (this.aep && z && !bVar.aiB) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913138, bVar));
                ry();
                return;
            }
            try {
                if (bVar.aiC != null && com.baidu.live.gift.b.b.sK().dc(bVar.aiC.qx())) {
                    com.baidu.live.gift.c du = com.baidu.live.gift.b.b.sK().du(bVar.giftId);
                    if (du != null && !ListUtils.isEmpty(du.getDynamicGiftPicPathList())) {
                        if (this.afg == null) {
                            this.afg = new AlaDynamicGiftLayout(this.mContext);
                        }
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.afg.getLayoutParams();
                        if (layoutParams == null) {
                            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                        }
                        this.afc.a(this.afg, layoutParams);
                        this.afg.setData(du, bVar);
                        this.afg.setBigGiftCallBack(this.afi);
                        this.afg.startAnim();
                    } else {
                        if (this.afh == null) {
                            this.afh = new AlaDynamicGiftSmallGiftStyleView(this.mContext);
                        }
                        this.afc.K(this.afh);
                        this.afh.setData(bVar);
                        this.afh.setBigGiftCallBack(this.afi);
                        this.afh.startAnim();
                    }
                }
            } catch (OutOfMemoryError e) {
                log(BdStatsConstant.StatsType.ERROR, "showbiggift", TiebaInitialize.LogFields.REASON, "oom");
                TbadkCoreApplication.getInst().onAppMemoryLow();
                System.gc();
                if (this.aff < 1) {
                    this.aff++;
                    g(bVar);
                } else {
                    ry();
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2913019));
        }
    }

    private void h(com.baidu.live.gift.a.b bVar) {
        com.baidu.live.entereffect.a.a cP = com.baidu.live.entereffect.a.pZ().cP(bVar.giftId);
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 1));
            ry();
        } else if (cP == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 1));
            ry();
        } else {
            com.baidu.live.gift.c cVar = cP.acO;
            if (cVar == null || ListUtils.isEmpty(cVar.unZipFilesPathList)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 1));
                ry();
                return;
            }
            try {
                if (this.afg == null) {
                    this.afg = new AlaDynamicGiftLayout(this.mContext);
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.afg.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                }
                this.afc.a(this.afg, layoutParams);
                this.afg.setData(cVar, bVar);
                this.afg.setBigGiftCallBack(this.afi);
                this.afg.startAnim();
                MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 0));
            } catch (OutOfMemoryError e) {
                log(BdStatsConstant.StatsType.ERROR, "showbiggift", TiebaInitialize.LogFields.REASON, "oom");
                TbadkCoreApplication.getInst().onAppMemoryLow();
                System.gc();
                if (this.aff < 1) {
                    this.aff++;
                    g(bVar);
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 1));
                    ry();
                    return;
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2913019));
        }
    }

    public boolean rB() {
        return this.afe;
    }

    public void rC() {
        boolean z = false;
        if (2 == UtilHelper.getRealScreenOrientation(this.mContext)) {
            z = true;
        }
        if (this.afg != null) {
            this.afg.aJ(z);
        }
        if (this.afh != null) {
            this.afh.aJ(z);
        }
    }

    public void onDestroy() {
        this.aff = 0;
        this.afd.clear();
        this.afe = false;
        if (this.afg != null) {
            this.afg.onDestroy();
        }
        if (this.afh != null) {
            this.afh.onDestroy();
        }
        this.mContext = null;
    }

    protected void log(Object... objArr) {
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            BdStatisticsManager.getInstance().newDebug("alaGift", 0L, null, objArr);
        }
    }

    public void aw(boolean z) {
        this.aep = z;
    }
}

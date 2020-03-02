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
    private k ahT;
    private boolean ahV;
    private int ahW;
    private AlaDynamicVideoGiftLayout ahX;
    private AlaDynamicGiftLayout ahY;
    private AlaDynamicGiftSmallGiftStyleView ahZ;
    private Context mContext;
    private boolean ahf = false;
    private b aia = new b() { // from class: com.baidu.live.gift.biggift.a.1
        @Override // com.baidu.live.gift.biggift.b
        public void onStart() {
            a.this.ahV = true;
        }

        @Override // com.baidu.live.gift.biggift.b
        public void bt(int i) {
        }

        @Override // com.baidu.live.gift.biggift.b
        public void onEnd() {
            a.this.ahV = false;
            a.this.ahT.sj();
            a.this.sW();
        }
    };
    private ArrayList<com.baidu.live.gift.a.c> ahU = new ArrayList<>();

    public a(Context context, k kVar) {
        this.ahW = 0;
        this.mContext = context;
        this.ahT = kVar;
        this.ahW = 0;
    }

    public void f(com.baidu.live.gift.a.c cVar) {
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            long j = cVar.alA;
            cVar.alA = 1L;
            for (int i = 0; i < j; i++) {
                com.baidu.live.gift.a.c clone = cVar.clone();
                if (clone != null) {
                    if (cVar.priority == 11) {
                        this.ahU.add(0, clone);
                    } else {
                        this.ahU.add(clone);
                    }
                    if (clone.alC) {
                        LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_ENTER_LIST, clone.XX, clone.XY, clone.giftId, "");
                    }
                }
            }
            try {
                sT();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void sT() {
        if (this.ahU != null) {
            int i = com.baidu.live.v.a.zl().awB != null ? com.baidu.live.v.a.zl().awB.aaO : 0;
            if (i > 0 && this.ahU.size() >= i) {
                Collections.sort(this.ahU, new c.a());
                int max = Math.max((int) (i * 0.7f), 1);
                ArrayList arrayList = new ArrayList(this.ahU.subList(0, max));
                while (true) {
                    int i2 = max;
                    if (i2 < this.ahU.size()) {
                        if (this.ahU.get(i2) == null || !this.ahU.get(i2).alF) {
                            max = i2 + 1;
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 1));
                            break;
                        }
                    } else {
                        break;
                    }
                }
                this.ahU.clear();
                this.ahU.addAll(arrayList);
            }
        }
    }

    public void sU() {
        if (!sZ()) {
            sW();
        }
    }

    public void sV() {
        if (this.ahV) {
            if (this.ahX != null) {
                this.ahX.stopAnim();
            }
            if (this.ahY != null) {
                this.ahY.stopAnim();
            }
            if (this.ahZ != null) {
                this.ahZ.stopAnim();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sW() {
        if (this.ahU.isEmpty()) {
            this.ahT.sh();
            sY();
            return;
        }
        com.baidu.live.gift.a.c sX = sX();
        if (sX == null) {
            sW();
        } else {
            g(sX);
        }
    }

    private com.baidu.live.gift.a.c sX() {
        if (this.ahU.isEmpty()) {
            return null;
        }
        return this.ahU.remove(0);
    }

    private void sY() {
        this.ahT.sj();
    }

    private void g(com.baidu.live.gift.a.c cVar) {
        if (cVar != null) {
            if (cVar.alF) {
                h(cVar);
                return;
            }
            boolean z = UtilHelper.getRealScreenOrientation(this.mContext) == 2;
            if (this.ahf && z && !cVar.alv) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913138, cVar));
                sW();
                return;
            }
            try {
                if (cVar.alw != null && com.baidu.live.gift.b.b.uu().mo19do(cVar.alw.rx())) {
                    com.baidu.live.gift.c dH = com.baidu.live.gift.b.b.uu().dH(cVar.giftId);
                    if (com.baidu.live.alphavideo.a.pv().pw() && dH != null && dH.afL != null && dH.afL.rf() && !TextUtils.isEmpty(dH.ri())) {
                        a(dH, cVar);
                    } else if (dH != null && !ListUtils.isEmpty(dH.getDynamicGiftPicPathList())) {
                        if (this.ahY == null) {
                            this.ahY = new AlaDynamicGiftLayout(this.mContext);
                        }
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ahY.getLayoutParams();
                        if (layoutParams == null) {
                            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                        }
                        this.ahT.a(this.ahY, layoutParams);
                        this.ahY.setData(dH, cVar);
                        this.ahY.setBigGiftCallBack(this.aia);
                        this.ahY.startAnim();
                    } else {
                        if (this.ahZ == null) {
                            this.ahZ = new AlaDynamicGiftSmallGiftStyleView(this.mContext);
                        }
                        this.ahT.K(this.ahZ);
                        this.ahZ.setData(cVar);
                        this.ahZ.setBigGiftCallBack(this.aia);
                        this.ahZ.startAnim();
                    }
                    if (cVar.alC) {
                        LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW, cVar.XX, cVar.XY, cVar.giftId, "");
                    }
                } else if (cVar.alC) {
                    LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW_FAIL, cVar.XX, cVar.XY, cVar.giftId, "不在大礼物列表");
                }
            } catch (OutOfMemoryError e) {
                log(BdStatsConstant.StatsType.ERROR, "showbiggift", TiebaInitialize.LogFields.REASON, "oom");
                TbadkCoreApplication.getInst().onAppMemoryLow();
                System.gc();
                if (cVar.alC) {
                    LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW_FAIL, cVar.XX, cVar.XY, cVar.giftId, "OOM");
                }
                if (this.ahW < 1) {
                    this.ahW++;
                    g(cVar);
                } else {
                    sW();
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2913019));
        }
    }

    private void a(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2) {
        if (this.ahX == null) {
            this.ahX = new AlaDynamicVideoGiftLayout(this.mContext);
        }
        ViewGroup.LayoutParams layoutParams = this.ahX.getLayoutParams();
        if (!(layoutParams instanceof RelativeLayout.LayoutParams)) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        }
        this.ahT.a(this.ahX, (RelativeLayout.LayoutParams) layoutParams);
        this.ahX.setData(cVar, cVar2);
        this.ahX.setBigGiftCallBack(this.aia);
        this.ahX.startAnim();
    }

    private void h(com.baidu.live.gift.a.c cVar) {
        com.baidu.live.entereffect.a.a da = com.baidu.live.entereffect.a.qR().da(cVar.giftId);
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 1));
            sW();
        } else if (da == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 1));
            sW();
        } else {
            com.baidu.live.gift.c cVar2 = da.afg;
            if (cVar2 == null || ListUtils.isEmpty(cVar2.unZipFilesPathList)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 1));
                sW();
                return;
            }
            try {
                if (this.ahY == null) {
                    this.ahY = new AlaDynamicGiftLayout(this.mContext);
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ahY.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                }
                this.ahT.a(this.ahY, layoutParams);
                this.ahY.setData(cVar2, cVar);
                this.ahY.setBigGiftCallBack(this.aia);
                this.ahY.startAnim();
                MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 0));
            } catch (OutOfMemoryError e) {
                log(BdStatsConstant.StatsType.ERROR, "showbiggift", TiebaInitialize.LogFields.REASON, "oom");
                TbadkCoreApplication.getInst().onAppMemoryLow();
                System.gc();
                if (this.ahW < 1) {
                    this.ahW++;
                    g(cVar);
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 1));
                    sW();
                    return;
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2913019));
        }
    }

    public boolean sZ() {
        return this.ahV;
    }

    public void ta() {
        boolean z = false;
        if (2 == UtilHelper.getRealScreenOrientation(this.mContext)) {
            z = true;
        }
        if (this.ahX != null) {
            this.ahX.ta();
        }
        if (this.ahY != null) {
            this.ahY.aO(z);
        }
        if (this.ahZ != null) {
            this.ahZ.aO(z);
        }
    }

    public void onDestroy() {
        this.ahW = 0;
        this.ahU.clear();
        this.ahV = false;
        if (this.ahX != null) {
            this.ahX.onDestroy();
        }
        if (this.ahY != null) {
            this.ahY.onDestroy();
        }
        if (this.ahZ != null) {
            this.ahZ.onDestroy();
        }
        this.mContext = null;
    }

    protected void log(Object... objArr) {
        AlaStatManager.getInstance().newDebug("alaGift", 0L, null, objArr);
    }

    public void az(boolean z) {
        this.ahf = z;
    }
}

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
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import java.util.ArrayList;
import java.util.Collections;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    private k aPb;
    private boolean aPd;
    private int aPe;
    private AlaDynamicVideoGiftLayout aPf;
    private AlaDynamicGiftLayout aPg;
    private AlaDynamicGiftSmallGiftStyleView aPh;
    private int aPi;
    private int aPj;
    private Context mContext;
    private boolean aOl = false;
    private b aPk = new b() { // from class: com.baidu.live.gift.biggift.a.1
        @Override // com.baidu.live.gift.biggift.b
        public void l(com.baidu.live.gift.a.c cVar) {
            a.this.aPd = true;
            cVar.ae(System.currentTimeMillis());
        }

        @Override // com.baidu.live.gift.biggift.b
        public void dQ(int i) {
        }

        @Override // com.baidu.live.gift.biggift.b
        public void m(com.baidu.live.gift.a.c cVar) {
            a.this.i(cVar);
            a.this.aPd = false;
            a.this.aPb.EC();
            a.this.Fm();
        }
    };
    private ArrayList<com.baidu.live.gift.a.c> aPc = new ArrayList<>();

    public a(Context context, k kVar) {
        this.aPe = 0;
        this.mContext = context;
        this.aPb = kVar;
        this.aPe = 0;
    }

    public void h(com.baidu.live.gift.a.c cVar) {
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            long j = cVar.aSW;
            cVar.aSW = 1L;
            for (int i = 0; i < j; i++) {
                com.baidu.live.gift.a.c clone = cVar.clone();
                if (clone != null) {
                    if (cVar.priority == 11) {
                        this.aPc.add(0, clone);
                    } else {
                        this.aPc.add(clone);
                    }
                    if (clone.aSY) {
                        LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_ENTER_LIST, clone.aDY, clone.aDZ, clone.giftId, "");
                    }
                }
            }
            try {
                Fj();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void Fj() {
        if (this.aPc != null) {
            int i = com.baidu.live.w.a.Nk().beJ != null ? com.baidu.live.w.a.Nk().beJ.aHf : 0;
            if (i > 0 && this.aPc.size() >= i) {
                Collections.sort(this.aPc, new c.a());
                int max = Math.max((int) (i * 0.7f), 1);
                ArrayList arrayList = new ArrayList(this.aPc.subList(0, max));
                while (true) {
                    int i2 = max;
                    if (i2 < this.aPc.size()) {
                        if (this.aPc.get(i2) == null || !this.aPc.get(i2).aTb) {
                            max = i2 + 1;
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 1));
                            break;
                        }
                    } else {
                        break;
                    }
                }
                this.aPc.clear();
                this.aPc.addAll(arrayList);
            }
        }
    }

    public void Fk() {
        if (!Fp()) {
            Fm();
        }
    }

    public void Fl() {
        if (this.aPd) {
            if (this.aPf != null) {
                this.aPf.stopAnim();
            }
            if (this.aPg != null) {
                this.aPg.stopAnim();
            }
            if (this.aPh != null) {
                this.aPh.stopAnim();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(com.baidu.live.gift.a.c cVar) {
        if (cVar != null && cVar.aSY) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(LogConfig.LOG_GIFT_ID, cVar.giftId);
                jSONObject.put("gift_count", cVar.aSW);
                jSONObject.put("sender_uk", EncryptionHelper.getEncryptionUserId(cVar.userId));
                jSONObject.put("show_stime", cVar.Gi());
                jSONObject.put("show_ctime", System.currentTimeMillis());
                if (cVar.aTd) {
                    jSONObject.put("from_recovery", 1);
                }
            } catch (JSONException e) {
                BdLog.e(e);
            }
            UbcStatisticManager.getInstance().debugException(new UbcDebugItem(UbcStatConstant.Page.AUTHOR_LIVE_ROOM, UbcStatConstant.DebugContentValue.GIFT, jSONObject), "gift_show");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fm() {
        if (this.aPc.isEmpty()) {
            this.aPb.EA();
            Fo();
            return;
        }
        com.baidu.live.gift.a.c Fn = Fn();
        if (Fn == null) {
            Fm();
        } else {
            j(Fn);
        }
    }

    private com.baidu.live.gift.a.c Fn() {
        if (this.aPc.isEmpty()) {
            return null;
        }
        return this.aPc.remove(0);
    }

    private void Fo() {
        this.aPb.EC();
    }

    private void j(com.baidu.live.gift.a.c cVar) {
        com.baidu.live.gift.c gJ;
        if (cVar != null) {
            boolean z = UtilHelper.getRealScreenOrientation(this.mContext) == 2;
            if (cVar.aTb && !b(cVar, z)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 1));
                Fm();
            } else if (z && cVar.aTc) {
                Fm();
            } else if (this.aOl && z && !cVar.aSR) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913138, cVar));
                Fm();
            } else {
                try {
                    if ((cVar.aSS != null && com.baidu.live.gift.b.b.GM().gl(cVar.aSS.DR())) || cVar.aTb) {
                        if (cVar.aTb) {
                            gJ = com.baidu.live.entereffect.a.Dg().fV(cVar.giftId).aMd;
                        } else {
                            gJ = com.baidu.live.gift.b.b.GM().gJ(cVar.giftId);
                        }
                        if (a(gJ, cVar)) {
                            b(gJ, cVar);
                            if (cVar.aTb) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 0));
                            }
                        } else if (a(gJ)) {
                            c(gJ, cVar);
                            if (cVar.aTb) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 0));
                            }
                        } else if (cVar.aTb || cVar.aTc) {
                            Fm();
                            if (cVar.aTb) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 1));
                            }
                        } else {
                            k(cVar);
                        }
                        if (cVar.aSY) {
                            LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW, cVar.aDY, cVar.aDZ, cVar.giftId, "");
                        }
                    } else if (cVar.aSY) {
                        LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW_FAIL, cVar.aDY, cVar.aDZ, cVar.giftId, "不在大礼物列表");
                    }
                } catch (OutOfMemoryError e) {
                    log(BdStatsConstant.StatsType.ERROR, "showbiggift", TiebaInitialize.LogFields.REASON, "oom");
                    TbadkCoreApplication.getInst().onAppMemoryLow();
                    System.gc();
                    if (cVar.aSY) {
                        LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW_FAIL, cVar.aDY, cVar.aDZ, cVar.giftId, "OOM");
                    }
                    if (this.aPe < 1) {
                        this.aPe++;
                        j(cVar);
                    } else {
                        Fm();
                    }
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2913019));
            }
        }
    }

    private boolean b(com.baidu.live.gift.a.c cVar, boolean z) {
        com.baidu.live.entereffect.a.a fV;
        com.baidu.live.gift.c cVar2;
        if (z || (fV = com.baidu.live.entereffect.a.Dg().fV(cVar.giftId)) == null || (cVar2 = fV.aMd) == null) {
            return false;
        }
        return (TextUtils.isEmpty(cVar2.videoPath) && ListUtils.isEmpty(cVar2.unZipFilesPathList)) ? false : true;
    }

    private boolean a(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2) {
        boolean z = (!com.baidu.live.alphavideo.a.AH().AI() || cVar == null || cVar.aMN == null) ? false : true;
        return cVar2.aTb ? z && !TextUtils.isEmpty(cVar.DA()) : z && cVar.aMN.Dx() && !TextUtils.isEmpty(cVar.DA());
    }

    private boolean a(com.baidu.live.gift.c cVar) {
        return (cVar == null || ListUtils.isEmpty(cVar.getDynamicGiftPicPathList())) ? false : true;
    }

    private void b(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2) {
        if (this.aPf == null) {
            this.aPf = new AlaDynamicVideoGiftLayout(this.mContext);
        }
        ViewGroup.LayoutParams layoutParams = this.aPf.getLayoutParams();
        if (!(layoutParams instanceof RelativeLayout.LayoutParams)) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        }
        this.aPb.a(this.aPf, (RelativeLayout.LayoutParams) layoutParams);
        this.aPf.setHost(this.aPb.aMJ);
        this.aPf.setEnterEffectRelativeBottomMargin(this.aPj);
        this.aPf.setData(cVar, cVar2);
        this.aPf.setBigGiftCallBack(this.aPk);
        this.aPf.startAnim();
    }

    private void c(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2) {
        if (this.aPg == null) {
            this.aPg = new AlaDynamicGiftLayout(this.mContext);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aPg.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        }
        this.aPb.a(this.aPg, layoutParams);
        this.aPg.setHost(this.aPb.aMJ);
        this.aPg.setData(cVar, cVar2);
        this.aPg.setBigGiftCallBack(this.aPk);
        this.aPg.startAnim();
    }

    private void k(com.baidu.live.gift.a.c cVar) {
        if (this.aPh == null) {
            this.aPh = new AlaDynamicGiftSmallGiftStyleView(this.mContext);
        }
        this.aPb.M(this.aPh);
        this.aPh.em(this.aPi);
        this.aPh.setData(cVar);
        this.aPh.setBigGiftCallBack(this.aPk);
        this.aPh.startAnim();
    }

    public boolean Fp() {
        return this.aPd;
    }

    public void Fq() {
        boolean z = false;
        if (2 == UtilHelper.getRealScreenOrientation(this.mContext)) {
            z = true;
        }
        if (this.aPf != null) {
            this.aPf.Fq();
        }
        if (this.aPg != null) {
            this.aPg.bG(z);
        }
        if (this.aPh != null) {
            this.aPh.bG(z);
        }
    }

    public void onDestroy() {
        this.aPe = 0;
        this.aPc.clear();
        this.aPd = false;
        if (this.aPf != null) {
            this.aPf.onDestroy();
        }
        if (this.aPg != null) {
            this.aPg.onDestroy();
        }
        if (this.aPh != null) {
            this.aPh.onDestroy();
        }
        this.mContext = null;
    }

    protected void log(Object... objArr) {
        AlaStatManager.getInstance().newDebug("alaGift", 0L, null, objArr);
    }

    public void bj(boolean z) {
        this.aOl = z;
    }

    public void dO(int i) {
        this.aPi = i;
    }

    public void dP(int i) {
        this.aPj = i;
    }
}

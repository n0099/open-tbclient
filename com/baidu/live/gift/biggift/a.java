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
    private k aOZ;
    private boolean aPb;
    private int aPc;
    private AlaDynamicVideoGiftLayout aPd;
    private AlaDynamicGiftLayout aPe;
    private AlaDynamicGiftSmallGiftStyleView aPf;
    private int aPg;
    private int aPh;
    private Context mContext;
    private boolean aOj = false;
    private b aPi = new b() { // from class: com.baidu.live.gift.biggift.a.1
        @Override // com.baidu.live.gift.biggift.b
        public void l(com.baidu.live.gift.a.c cVar) {
            a.this.aPb = true;
            cVar.ae(System.currentTimeMillis());
        }

        @Override // com.baidu.live.gift.biggift.b
        public void dQ(int i) {
        }

        @Override // com.baidu.live.gift.biggift.b
        public void m(com.baidu.live.gift.a.c cVar) {
            a.this.i(cVar);
            a.this.aPb = false;
            a.this.aOZ.EC();
            a.this.Fm();
        }
    };
    private ArrayList<com.baidu.live.gift.a.c> aPa = new ArrayList<>();

    public a(Context context, k kVar) {
        this.aPc = 0;
        this.mContext = context;
        this.aOZ = kVar;
        this.aPc = 0;
    }

    public void h(com.baidu.live.gift.a.c cVar) {
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            long j = cVar.aSU;
            cVar.aSU = 1L;
            for (int i = 0; i < j; i++) {
                com.baidu.live.gift.a.c clone = cVar.clone();
                if (clone != null) {
                    if (cVar.priority == 11) {
                        this.aPa.add(0, clone);
                    } else {
                        this.aPa.add(clone);
                    }
                    if (clone.aSW) {
                        LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_ENTER_LIST, clone.aDW, clone.aDX, clone.giftId, "");
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
        if (this.aPa != null) {
            int i = com.baidu.live.w.a.Nk().beH != null ? com.baidu.live.w.a.Nk().beH.aHd : 0;
            if (i > 0 && this.aPa.size() >= i) {
                Collections.sort(this.aPa, new c.a());
                int max = Math.max((int) (i * 0.7f), 1);
                ArrayList arrayList = new ArrayList(this.aPa.subList(0, max));
                while (true) {
                    int i2 = max;
                    if (i2 < this.aPa.size()) {
                        if (this.aPa.get(i2) == null || !this.aPa.get(i2).aSZ) {
                            max = i2 + 1;
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 1));
                            break;
                        }
                    } else {
                        break;
                    }
                }
                this.aPa.clear();
                this.aPa.addAll(arrayList);
            }
        }
    }

    public void Fk() {
        if (!Fp()) {
            Fm();
        }
    }

    public void Fl() {
        if (this.aPb) {
            if (this.aPd != null) {
                this.aPd.stopAnim();
            }
            if (this.aPe != null) {
                this.aPe.stopAnim();
            }
            if (this.aPf != null) {
                this.aPf.stopAnim();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(com.baidu.live.gift.a.c cVar) {
        if (cVar != null && cVar.aSW) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(LogConfig.LOG_GIFT_ID, cVar.giftId);
                jSONObject.put("gift_count", cVar.aSU);
                jSONObject.put("sender_uk", EncryptionHelper.getEncryptionUserId(cVar.userId));
                jSONObject.put("show_stime", cVar.Gi());
                jSONObject.put("show_ctime", System.currentTimeMillis());
                if (cVar.aTb) {
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
        if (this.aPa.isEmpty()) {
            this.aOZ.EA();
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
        if (this.aPa.isEmpty()) {
            return null;
        }
        return this.aPa.remove(0);
    }

    private void Fo() {
        this.aOZ.EC();
    }

    private void j(com.baidu.live.gift.a.c cVar) {
        com.baidu.live.gift.c gI;
        if (cVar != null) {
            boolean z = UtilHelper.getRealScreenOrientation(this.mContext) == 2;
            if (cVar.aSZ && !b(cVar, z)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 1));
                Fm();
            } else if (z && cVar.aTa) {
                Fm();
            } else if (this.aOj && z && !cVar.aSP) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913138, cVar));
                Fm();
            } else {
                try {
                    if ((cVar.aSQ != null && com.baidu.live.gift.b.b.GM().gk(cVar.aSQ.DR())) || cVar.aSZ) {
                        if (cVar.aSZ) {
                            gI = com.baidu.live.entereffect.a.Dg().fU(cVar.giftId).aMb;
                        } else {
                            gI = com.baidu.live.gift.b.b.GM().gI(cVar.giftId);
                        }
                        if (a(gI, cVar)) {
                            b(gI, cVar);
                            if (cVar.aSZ) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 0));
                            }
                        } else if (a(gI)) {
                            c(gI, cVar);
                            if (cVar.aSZ) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 0));
                            }
                        } else if (cVar.aSZ || cVar.aTa) {
                            Fm();
                            if (cVar.aSZ) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 1));
                            }
                        } else {
                            k(cVar);
                        }
                        if (cVar.aSW) {
                            LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW, cVar.aDW, cVar.aDX, cVar.giftId, "");
                        }
                    } else if (cVar.aSW) {
                        LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW_FAIL, cVar.aDW, cVar.aDX, cVar.giftId, "不在大礼物列表");
                    }
                } catch (OutOfMemoryError e) {
                    log(BdStatsConstant.StatsType.ERROR, "showbiggift", TiebaInitialize.LogFields.REASON, "oom");
                    TbadkCoreApplication.getInst().onAppMemoryLow();
                    System.gc();
                    if (cVar.aSW) {
                        LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW_FAIL, cVar.aDW, cVar.aDX, cVar.giftId, "OOM");
                    }
                    if (this.aPc < 1) {
                        this.aPc++;
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
        com.baidu.live.entereffect.a.a fU;
        com.baidu.live.gift.c cVar2;
        if (z || (fU = com.baidu.live.entereffect.a.Dg().fU(cVar.giftId)) == null || (cVar2 = fU.aMb) == null) {
            return false;
        }
        return (TextUtils.isEmpty(cVar2.videoPath) && ListUtils.isEmpty(cVar2.unZipFilesPathList)) ? false : true;
    }

    private boolean a(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2) {
        boolean z = (!com.baidu.live.alphavideo.a.AH().AI() || cVar == null || cVar.aML == null) ? false : true;
        return cVar2.aSZ ? z && !TextUtils.isEmpty(cVar.DA()) : z && cVar.aML.Dx() && !TextUtils.isEmpty(cVar.DA());
    }

    private boolean a(com.baidu.live.gift.c cVar) {
        return (cVar == null || ListUtils.isEmpty(cVar.getDynamicGiftPicPathList())) ? false : true;
    }

    private void b(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2) {
        if (this.aPd == null) {
            this.aPd = new AlaDynamicVideoGiftLayout(this.mContext);
        }
        ViewGroup.LayoutParams layoutParams = this.aPd.getLayoutParams();
        if (!(layoutParams instanceof RelativeLayout.LayoutParams)) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        }
        this.aOZ.a(this.aPd, (RelativeLayout.LayoutParams) layoutParams);
        this.aPd.setHost(this.aOZ.aMH);
        this.aPd.setEnterEffectRelativeBottomMargin(this.aPh);
        this.aPd.setData(cVar, cVar2);
        this.aPd.setBigGiftCallBack(this.aPi);
        this.aPd.startAnim();
    }

    private void c(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2) {
        if (this.aPe == null) {
            this.aPe = new AlaDynamicGiftLayout(this.mContext);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aPe.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        }
        this.aOZ.a(this.aPe, layoutParams);
        this.aPe.setHost(this.aOZ.aMH);
        this.aPe.setData(cVar, cVar2);
        this.aPe.setBigGiftCallBack(this.aPi);
        this.aPe.startAnim();
    }

    private void k(com.baidu.live.gift.a.c cVar) {
        if (this.aPf == null) {
            this.aPf = new AlaDynamicGiftSmallGiftStyleView(this.mContext);
        }
        this.aOZ.M(this.aPf);
        this.aPf.em(this.aPg);
        this.aPf.setData(cVar);
        this.aPf.setBigGiftCallBack(this.aPi);
        this.aPf.startAnim();
    }

    public boolean Fp() {
        return this.aPb;
    }

    public void Fq() {
        boolean z = false;
        if (2 == UtilHelper.getRealScreenOrientation(this.mContext)) {
            z = true;
        }
        if (this.aPd != null) {
            this.aPd.Fq();
        }
        if (this.aPe != null) {
            this.aPe.bG(z);
        }
        if (this.aPf != null) {
            this.aPf.bG(z);
        }
    }

    public void onDestroy() {
        this.aPc = 0;
        this.aPa.clear();
        this.aPb = false;
        if (this.aPd != null) {
            this.aPd.onDestroy();
        }
        if (this.aPe != null) {
            this.aPe.onDestroy();
        }
        if (this.aPf != null) {
            this.aPf.onDestroy();
        }
        this.mContext = null;
    }

    protected void log(Object... objArr) {
        AlaStatManager.getInstance().newDebug("alaGift", 0L, null, objArr);
    }

    public void bj(boolean z) {
        this.aOj = z;
    }

    public void dO(int i) {
        this.aPg = i;
    }

    public void dP(int i) {
        this.aPh = i;
    }
}

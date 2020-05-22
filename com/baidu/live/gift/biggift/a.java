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
/* loaded from: classes3.dex */
public class a {
    private k aFW;
    private boolean aFY;
    private int aFZ;
    private AlaDynamicVideoGiftLayout aGa;
    private AlaDynamicGiftLayout aGb;
    private AlaDynamicGiftSmallGiftStyleView aGc;
    private Context mContext;
    private boolean aFh = false;
    private b aGd = new b() { // from class: com.baidu.live.gift.biggift.a.1
        @Override // com.baidu.live.gift.biggift.b
        public void l(com.baidu.live.gift.a.c cVar) {
            a.this.aFY = true;
            cVar.ad(System.currentTimeMillis());
        }

        @Override // com.baidu.live.gift.biggift.b
        public void bN(int i) {
        }

        @Override // com.baidu.live.gift.biggift.b
        public void m(com.baidu.live.gift.a.c cVar) {
            a.this.i(cVar);
            a.this.aFY = false;
            a.this.aFW.xX();
            a.this.yH();
        }
    };
    private ArrayList<com.baidu.live.gift.a.c> aFX = new ArrayList<>();

    public a(Context context, k kVar) {
        this.aFZ = 0;
        this.mContext = context;
        this.aFW = kVar;
        this.aFZ = 0;
    }

    public void h(com.baidu.live.gift.a.c cVar) {
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            long j = cVar.aJG;
            cVar.aJG = 1L;
            for (int i = 0; i < j; i++) {
                com.baidu.live.gift.a.c clone = cVar.clone();
                if (clone != null) {
                    if (cVar.priority == 11) {
                        this.aFX.add(0, clone);
                    } else {
                        this.aFX.add(clone);
                    }
                    if (clone.aJI) {
                        LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_ENTER_LIST, clone.avv, clone.avw, clone.giftId, "");
                    }
                }
            }
            try {
                yE();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void yE() {
        if (this.aFX != null) {
            int i = com.baidu.live.v.a.Ge().aWF != null ? com.baidu.live.v.a.Ge().aWF.ayr : 0;
            if (i > 0 && this.aFX.size() >= i) {
                Collections.sort(this.aFX, new c.a());
                int max = Math.max((int) (i * 0.7f), 1);
                ArrayList arrayList = new ArrayList(this.aFX.subList(0, max));
                while (true) {
                    int i2 = max;
                    if (i2 < this.aFX.size()) {
                        if (this.aFX.get(i2) == null || !this.aFX.get(i2).aJL) {
                            max = i2 + 1;
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 1));
                            break;
                        }
                    } else {
                        break;
                    }
                }
                this.aFX.clear();
                this.aFX.addAll(arrayList);
            }
        }
    }

    public void yF() {
        if (!yK()) {
            yH();
        }
    }

    public void yG() {
        if (this.aFY) {
            if (this.aGa != null) {
                this.aGa.stopAnim();
            }
            if (this.aGb != null) {
                this.aGb.stopAnim();
            }
            if (this.aGc != null) {
                this.aGc.stopAnim();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(com.baidu.live.gift.a.c cVar) {
        if (cVar != null && cVar.aJI) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(LogConfig.LOG_GIFT_ID, cVar.giftId);
                jSONObject.put("gift_count", cVar.aJG);
                jSONObject.put("sender_uk", EncryptionHelper.getEncryptionUserId(cVar.userId));
                jSONObject.put("show_stime", cVar.zD());
                jSONObject.put("show_ctime", System.currentTimeMillis());
                if (cVar.aJN) {
                    jSONObject.put("from_recovery", 1);
                }
            } catch (JSONException e) {
                BdLog.e(e);
            }
            UbcStatisticManager.getInstance().debugException(new UbcDebugItem(UbcStatConstant.Page.AUTHOR_LIVE_ROOM, UbcStatConstant.DebugContentValue.GIFT, jSONObject), "gift_show");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yH() {
        if (this.aFX.isEmpty()) {
            this.aFW.xV();
            yJ();
            return;
        }
        com.baidu.live.gift.a.c yI = yI();
        if (yI == null) {
            yH();
        } else {
            j(yI);
        }
    }

    private com.baidu.live.gift.a.c yI() {
        if (this.aFX.isEmpty()) {
            return null;
        }
        return this.aFX.remove(0);
    }

    private void yJ() {
        this.aFW.xX();
    }

    private void j(com.baidu.live.gift.a.c cVar) {
        com.baidu.live.gift.c fi;
        if (cVar != null) {
            boolean z = UtilHelper.getRealScreenOrientation(this.mContext) == 2;
            if (cVar.aJL && !b(cVar, z)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 1));
                yH();
            } else if (z && cVar.aJM) {
                yH();
            } else if (this.aFh && z && !cVar.aJB) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913138, cVar));
                yH();
            } else {
                try {
                    if ((cVar.aJC != null && com.baidu.live.gift.b.b.Ah().eL(cVar.aJC.xl())) || cVar.aJL) {
                        if (cVar.aJL) {
                            fi = com.baidu.live.entereffect.a.wD().ew(cVar.giftId).aDe;
                        } else {
                            fi = com.baidu.live.gift.b.b.Ah().fi(cVar.giftId);
                        }
                        if (a(fi, cVar)) {
                            b(fi, cVar);
                            if (cVar.aJL) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 0));
                            }
                        } else if (a(fi)) {
                            c(fi, cVar);
                            if (cVar.aJL) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 0));
                            }
                        } else if (cVar.aJL || cVar.aJM) {
                            yH();
                            if (cVar.aJL) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 1));
                            }
                        } else {
                            k(cVar);
                        }
                        if (cVar.aJI) {
                            LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW, cVar.avv, cVar.avw, cVar.giftId, "");
                        }
                    } else if (cVar.aJI) {
                        LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW_FAIL, cVar.avv, cVar.avw, cVar.giftId, "不在大礼物列表");
                    }
                } catch (OutOfMemoryError e) {
                    log(BdStatsConstant.StatsType.ERROR, "showbiggift", TiebaInitialize.LogFields.REASON, "oom");
                    TbadkCoreApplication.getInst().onAppMemoryLow();
                    System.gc();
                    if (cVar.aJI) {
                        LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW_FAIL, cVar.avv, cVar.avw, cVar.giftId, "OOM");
                    }
                    if (this.aFZ < 1) {
                        this.aFZ++;
                        j(cVar);
                    } else {
                        yH();
                    }
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2913019));
            }
        }
    }

    private boolean b(com.baidu.live.gift.a.c cVar, boolean z) {
        com.baidu.live.entereffect.a.a ew;
        com.baidu.live.gift.c cVar2;
        if (z || (ew = com.baidu.live.entereffect.a.wD().ew(cVar.giftId)) == null || (cVar2 = ew.aDe) == null) {
            return false;
        }
        return (TextUtils.isEmpty(cVar2.videoPath) && ListUtils.isEmpty(cVar2.unZipFilesPathList)) ? false : true;
    }

    private boolean a(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2) {
        boolean z = (!com.baidu.live.alphavideo.a.uR().uS() || cVar == null || cVar.aDK == null) ? false : true;
        return cVar2.aJL ? z && !TextUtils.isEmpty(cVar.wU()) : z && cVar.aDK.wR() && !TextUtils.isEmpty(cVar.wU());
    }

    private boolean a(com.baidu.live.gift.c cVar) {
        return (cVar == null || ListUtils.isEmpty(cVar.getDynamicGiftPicPathList())) ? false : true;
    }

    private void b(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2) {
        if (this.aGa == null) {
            this.aGa = new AlaDynamicVideoGiftLayout(this.mContext);
        }
        ViewGroup.LayoutParams layoutParams = this.aGa.getLayoutParams();
        if (!(layoutParams instanceof RelativeLayout.LayoutParams)) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        }
        this.aFW.a(this.aGa, (RelativeLayout.LayoutParams) layoutParams);
        this.aGa.setHost(this.aFW.aDG);
        this.aGa.setData(cVar, cVar2);
        this.aGa.setBigGiftCallBack(this.aGd);
        this.aGa.startAnim();
    }

    private void c(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2) {
        if (this.aGb == null) {
            this.aGb = new AlaDynamicGiftLayout(this.mContext);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aGb.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        }
        this.aFW.a(this.aGb, layoutParams);
        this.aGb.setData(cVar, cVar2);
        this.aGb.setBigGiftCallBack(this.aGd);
        this.aGb.startAnim();
    }

    private void k(com.baidu.live.gift.a.c cVar) {
        if (this.aGc == null) {
            this.aGc = new AlaDynamicGiftSmallGiftStyleView(this.mContext);
        }
        this.aFW.L(this.aGc);
        this.aGc.setData(cVar);
        this.aGc.setBigGiftCallBack(this.aGd);
        this.aGc.startAnim();
    }

    public boolean yK() {
        return this.aFY;
    }

    public void yL() {
        boolean z = false;
        if (2 == UtilHelper.getRealScreenOrientation(this.mContext)) {
            z = true;
        }
        if (this.aGa != null) {
            this.aGa.yL();
        }
        if (this.aGb != null) {
            this.aGb.by(z);
        }
        if (this.aGc != null) {
            this.aGc.by(z);
        }
    }

    public void onDestroy() {
        this.aFZ = 0;
        this.aFX.clear();
        this.aFY = false;
        if (this.aGa != null) {
            this.aGa.onDestroy();
        }
        if (this.aGb != null) {
            this.aGb.onDestroy();
        }
        if (this.aGc != null) {
            this.aGc.onDestroy();
        }
        this.mContext = null;
    }

    protected void log(Object... objArr) {
        AlaStatManager.getInstance().newDebug("alaGift", 0L, null, objArr);
    }

    public void bc(boolean z) {
        this.aFh = z;
    }
}

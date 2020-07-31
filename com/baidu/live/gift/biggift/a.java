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
/* loaded from: classes4.dex */
public class a {
    private k aJO;
    private boolean aJQ;
    private int aJR;
    private AlaDynamicVideoGiftLayout aJS;
    private AlaDynamicGiftLayout aJT;
    private AlaDynamicGiftSmallGiftStyleView aJU;
    private Context mContext;
    private boolean aIY = false;
    private b aJV = new b() { // from class: com.baidu.live.gift.biggift.a.1
        @Override // com.baidu.live.gift.biggift.b
        public void l(com.baidu.live.gift.a.c cVar) {
            a.this.aJQ = true;
            cVar.ad(System.currentTimeMillis());
        }

        @Override // com.baidu.live.gift.biggift.b
        public void cb(int i) {
        }

        @Override // com.baidu.live.gift.biggift.b
        public void m(com.baidu.live.gift.a.c cVar) {
            a.this.i(cVar);
            a.this.aJQ = false;
            a.this.aJO.yZ();
            a.this.zJ();
        }
    };
    private ArrayList<com.baidu.live.gift.a.c> aJP = new ArrayList<>();

    public a(Context context, k kVar) {
        this.aJR = 0;
        this.mContext = context;
        this.aJO = kVar;
        this.aJR = 0;
    }

    public void h(com.baidu.live.gift.a.c cVar) {
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            long j = cVar.aNH;
            cVar.aNH = 1L;
            for (int i = 0; i < j; i++) {
                com.baidu.live.gift.a.c clone = cVar.clone();
                if (clone != null) {
                    if (cVar.priority == 11) {
                        this.aJP.add(0, clone);
                    } else {
                        this.aJP.add(clone);
                    }
                    if (clone.aNJ) {
                        LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_ENTER_LIST, clone.ayO, clone.ayP, clone.giftId, "");
                    }
                }
            }
            try {
                zG();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void zG() {
        if (this.aJP != null) {
            int i = com.baidu.live.v.a.Hs().aZn != null ? com.baidu.live.v.a.Hs().aZn.aBT : 0;
            if (i > 0 && this.aJP.size() >= i) {
                Collections.sort(this.aJP, new c.a());
                int max = Math.max((int) (i * 0.7f), 1);
                ArrayList arrayList = new ArrayList(this.aJP.subList(0, max));
                while (true) {
                    int i2 = max;
                    if (i2 < this.aJP.size()) {
                        if (this.aJP.get(i2) == null || !this.aJP.get(i2).aNM) {
                            max = i2 + 1;
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 1));
                            break;
                        }
                    } else {
                        break;
                    }
                }
                this.aJP.clear();
                this.aJP.addAll(arrayList);
            }
        }
    }

    public void zH() {
        if (!zM()) {
            zJ();
        }
    }

    public void zI() {
        if (this.aJQ) {
            if (this.aJS != null) {
                this.aJS.stopAnim();
            }
            if (this.aJT != null) {
                this.aJT.stopAnim();
            }
            if (this.aJU != null) {
                this.aJU.stopAnim();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(com.baidu.live.gift.a.c cVar) {
        if (cVar != null && cVar.aNJ) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(LogConfig.LOG_GIFT_ID, cVar.giftId);
                jSONObject.put("gift_count", cVar.aNH);
                jSONObject.put("sender_uk", EncryptionHelper.getEncryptionUserId(cVar.userId));
                jSONObject.put("show_stime", cVar.AF());
                jSONObject.put("show_ctime", System.currentTimeMillis());
                if (cVar.aNO) {
                    jSONObject.put("from_recovery", 1);
                }
            } catch (JSONException e) {
                BdLog.e(e);
            }
            UbcStatisticManager.getInstance().debugException(new UbcDebugItem(UbcStatConstant.Page.AUTHOR_LIVE_ROOM, UbcStatConstant.DebugContentValue.GIFT, jSONObject), "gift_show");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zJ() {
        if (this.aJP.isEmpty()) {
            this.aJO.yX();
            zL();
            return;
        }
        com.baidu.live.gift.a.c zK = zK();
        if (zK == null) {
            zJ();
        } else {
            j(zK);
        }
    }

    private com.baidu.live.gift.a.c zK() {
        if (this.aJP.isEmpty()) {
            return null;
        }
        return this.aJP.remove(0);
    }

    private void zL() {
        this.aJO.yZ();
    }

    private void j(com.baidu.live.gift.a.c cVar) {
        com.baidu.live.gift.c fn;
        if (cVar != null) {
            boolean z = UtilHelper.getRealScreenOrientation(this.mContext) == 2;
            if (cVar.aNM && !b(cVar, z)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 1));
                zJ();
            } else if (z && cVar.aNN) {
                zJ();
            } else if (this.aIY && z && !cVar.aNC) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913138, cVar));
                zJ();
            } else {
                try {
                    if ((cVar.aND != null && com.baidu.live.gift.b.b.Bj().eQ(cVar.aND.yo())) || cVar.aNM) {
                        if (cVar.aNM) {
                            fn = com.baidu.live.entereffect.a.xD().eA(cVar.giftId).aGR;
                        } else {
                            fn = com.baidu.live.gift.b.b.Bj().fn(cVar.giftId);
                        }
                        if (a(fn, cVar)) {
                            b(fn, cVar);
                            if (cVar.aNM) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 0));
                            }
                        } else if (a(fn)) {
                            c(fn, cVar);
                            if (cVar.aNM) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 0));
                            }
                        } else if (cVar.aNM || cVar.aNN) {
                            zJ();
                            if (cVar.aNM) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 1));
                            }
                        } else {
                            k(cVar);
                        }
                        if (cVar.aNJ) {
                            LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW, cVar.ayO, cVar.ayP, cVar.giftId, "");
                        }
                    } else if (cVar.aNJ) {
                        LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW_FAIL, cVar.ayO, cVar.ayP, cVar.giftId, "不在大礼物列表");
                    }
                } catch (OutOfMemoryError e) {
                    log(BdStatsConstant.StatsType.ERROR, "showbiggift", TiebaInitialize.LogFields.REASON, "oom");
                    TbadkCoreApplication.getInst().onAppMemoryLow();
                    System.gc();
                    if (cVar.aNJ) {
                        LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW_FAIL, cVar.ayO, cVar.ayP, cVar.giftId, "OOM");
                    }
                    if (this.aJR < 1) {
                        this.aJR++;
                        j(cVar);
                    } else {
                        zJ();
                    }
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2913019));
            }
        }
    }

    private boolean b(com.baidu.live.gift.a.c cVar, boolean z) {
        com.baidu.live.entereffect.a.a eA;
        com.baidu.live.gift.c cVar2;
        if (z || (eA = com.baidu.live.entereffect.a.xD().eA(cVar.giftId)) == null || (cVar2 = eA.aGR) == null) {
            return false;
        }
        return (TextUtils.isEmpty(cVar2.videoPath) && ListUtils.isEmpty(cVar2.unZipFilesPathList)) ? false : true;
    }

    private boolean a(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2) {
        boolean z = (!com.baidu.live.alphavideo.a.vj().vk() || cVar == null || cVar.aHB == null) ? false : true;
        return cVar2.aNM ? z && !TextUtils.isEmpty(cVar.xX()) : z && cVar.aHB.xU() && !TextUtils.isEmpty(cVar.xX());
    }

    private boolean a(com.baidu.live.gift.c cVar) {
        return (cVar == null || ListUtils.isEmpty(cVar.getDynamicGiftPicPathList())) ? false : true;
    }

    private void b(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2) {
        if (this.aJS == null) {
            this.aJS = new AlaDynamicVideoGiftLayout(this.mContext);
        }
        ViewGroup.LayoutParams layoutParams = this.aJS.getLayoutParams();
        if (!(layoutParams instanceof RelativeLayout.LayoutParams)) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        }
        this.aJO.a(this.aJS, (RelativeLayout.LayoutParams) layoutParams);
        this.aJS.setHost(this.aJO.aHx);
        this.aJS.setData(cVar, cVar2);
        this.aJS.setBigGiftCallBack(this.aJV);
        this.aJS.startAnim();
    }

    private void c(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2) {
        if (this.aJT == null) {
            this.aJT = new AlaDynamicGiftLayout(this.mContext);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aJT.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        }
        this.aJO.a(this.aJT, layoutParams);
        this.aJT.setData(cVar, cVar2);
        this.aJT.setBigGiftCallBack(this.aJV);
        this.aJT.startAnim();
    }

    private void k(com.baidu.live.gift.a.c cVar) {
        if (this.aJU == null) {
            this.aJU = new AlaDynamicGiftSmallGiftStyleView(this.mContext);
        }
        this.aJO.M(this.aJU);
        this.aJU.setData(cVar);
        this.aJU.setBigGiftCallBack(this.aJV);
        this.aJU.startAnim();
    }

    public boolean zM() {
        return this.aJQ;
    }

    public void zN() {
        boolean z = false;
        if (2 == UtilHelper.getRealScreenOrientation(this.mContext)) {
            z = true;
        }
        if (this.aJS != null) {
            this.aJS.zN();
        }
        if (this.aJT != null) {
            this.aJT.bB(z);
        }
        if (this.aJU != null) {
            this.aJU.bB(z);
        }
    }

    public void onDestroy() {
        this.aJR = 0;
        this.aJP.clear();
        this.aJQ = false;
        if (this.aJS != null) {
            this.aJS.onDestroy();
        }
        if (this.aJT != null) {
            this.aJT.onDestroy();
        }
        if (this.aJU != null) {
            this.aJU.onDestroy();
        }
        this.mContext = null;
    }

    protected void log(Object... objArr) {
        AlaStatManager.getInstance().newDebug("alaGift", 0L, null, objArr);
    }

    public void bf(boolean z) {
        this.aIY = z;
    }
}

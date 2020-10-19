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
import com.baidu.live.gift.g;
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
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.platform.comapi.map.MapController;
import java.util.ArrayList;
import java.util.Collections;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    private k aUo;
    private boolean aUq;
    private int aUr;
    private AlaDynamicVideoGiftLayout aUs;
    private AlaDynamicGiftLayout aUt;
    private AlaDynamicGiftSmallGiftStyleView aUu;
    private int aUv;
    private int aUw;
    private Context mContext;
    private boolean aTv = false;
    private b aUx = new b() { // from class: com.baidu.live.gift.biggift.a.1
        @Override // com.baidu.live.gift.biggift.b
        public void l(com.baidu.live.gift.a.c cVar) {
            a.this.aUq = true;
            cVar.af(System.currentTimeMillis());
        }

        @Override // com.baidu.live.gift.biggift.b
        public void dZ(int i) {
        }

        @Override // com.baidu.live.gift.biggift.b
        public void m(com.baidu.live.gift.a.c cVar) {
            a.this.i(cVar);
            a.this.aUq = false;
            a.this.aUo.FP();
            a.this.GI();
        }
    };
    private ArrayList<com.baidu.live.gift.a.c> aUp = new ArrayList<>();

    public a(Context context, k kVar) {
        this.aUr = 0;
        this.mContext = context;
        this.aUo = kVar;
        this.aUr = 0;
    }

    public void h(com.baidu.live.gift.a.c cVar) {
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            long j = cVar.aYt;
            cVar.aYt = 1L;
            for (int i = 0; i < j; i++) {
                com.baidu.live.gift.a.c clone = cVar.clone();
                if (clone != null) {
                    if (cVar.priority == 11) {
                        this.aUp.add(0, clone);
                    } else {
                        this.aUp.add(clone);
                    }
                    if (clone.aYv) {
                        LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_ENTER_LIST, clone.aHY, clone.aHZ, clone.giftId, "");
                    }
                }
            }
            try {
                GF();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void GF() {
        if (this.aUp != null) {
            int i = com.baidu.live.x.a.OS().blo != null ? com.baidu.live.x.a.OS().blo.aLz : 0;
            if (i > 0 && this.aUp.size() >= i) {
                Collections.sort(this.aUp, new c.a());
                int max = Math.max((int) (i * 0.7f), 1);
                ArrayList arrayList = new ArrayList(this.aUp.subList(0, max));
                while (true) {
                    int i2 = max;
                    if (i2 < this.aUp.size()) {
                        if (this.aUp.get(i2) == null || !this.aUp.get(i2).aYy) {
                            max = i2 + 1;
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 1));
                            break;
                        }
                    } else {
                        break;
                    }
                }
                this.aUp.clear();
                this.aUp.addAll(arrayList);
            }
        }
    }

    public void GG() {
        if (!GL()) {
            GI();
        }
    }

    public void GH() {
        if (this.aUq) {
            if (this.aUs != null) {
                this.aUs.stopAnim();
            }
            if (this.aUt != null) {
                this.aUt.stopAnim();
            }
            if (this.aUu != null) {
                this.aUu.stopAnim();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(com.baidu.live.gift.a.c cVar) {
        if (cVar != null && cVar.aYv) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(LogConfig.LOG_GIFT_ID, cVar.giftId);
                jSONObject.put("gift_count", cVar.aYt);
                jSONObject.put("sender_uk", EncryptionHelper.getEncryptionUserId(cVar.userId));
                jSONObject.put("show_stime", cVar.HE());
                jSONObject.put("show_ctime", System.currentTimeMillis());
                if (cVar.aYA) {
                    jSONObject.put("from_recovery", 1);
                }
            } catch (JSONException e) {
                BdLog.e(e);
            }
            UbcStatisticManager.getInstance().debugException(new UbcDebugItem(UbcStatConstant.Page.AUTHOR_LIVE_ROOM, UbcStatConstant.DebugContentValue.GIFT, jSONObject), "gift_show");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GI() {
        if (this.aUp.isEmpty()) {
            this.aUo.FN();
            GK();
            return;
        }
        com.baidu.live.gift.a.c GJ = GJ();
        if (GJ == null) {
            GI();
        } else {
            j(GJ);
        }
    }

    private com.baidu.live.gift.a.c GJ() {
        if (this.aUp.isEmpty()) {
            return null;
        }
        return this.aUp.remove(0);
    }

    private void GK() {
        this.aUo.FP();
    }

    private void j(com.baidu.live.gift.a.c cVar) {
        com.baidu.live.gift.c hf;
        if (cVar != null) {
            boolean z = UtilHelper.getRealScreenOrientation(this.mContext) == 2;
            if (cVar.aYy && !b(cVar, z)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 1));
                GI();
            } else if (z && cVar.aYz) {
                GI();
            } else if (this.aTv && z && !cVar.aYn) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913138, cVar));
                GI();
            } else {
                try {
                    if ((cVar.aYo != null && com.baidu.live.gift.b.b.Ik().gJ(cVar.aYo.Fd())) || cVar.aYy) {
                        if (cVar.aYy) {
                            hf = com.baidu.live.entereffect.a.Et().go(cVar.giftId).aRg;
                        } else {
                            hf = com.baidu.live.gift.b.b.Ik().hf(cVar.giftId);
                        }
                        if (a(hf, cVar)) {
                            b(hf, cVar);
                            if (cVar.aYy) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 0));
                            }
                        } else if (a(hf)) {
                            c(hf, cVar);
                            if (cVar.aYy) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 0));
                            }
                        } else if (cVar.aYy || cVar.aYz) {
                            GI();
                            if (cVar.aYy) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 1));
                            }
                        } else {
                            k(cVar);
                        }
                        if (cVar.aYv) {
                            LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW, cVar.aHY, cVar.aHZ, cVar.giftId, "");
                        }
                    } else if (cVar.aYv) {
                        LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW_FAIL, cVar.aHY, cVar.aHZ, cVar.giftId, "不在大礼物列表");
                    }
                } catch (OutOfMemoryError e) {
                    log(BdStatsConstant.StatsType.ERROR, "showbiggift", TiebaInitialize.LogFields.REASON, "oom");
                    TbadkCoreApplication.getInst().onAppMemoryLow();
                    System.gc();
                    if (cVar.aYv) {
                        LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW_FAIL, cVar.aHY, cVar.aHZ, cVar.giftId, "OOM");
                    }
                    if (this.aUr < 1) {
                        this.aUr++;
                        j(cVar);
                    } else {
                        GI();
                    }
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2913019));
            }
        }
    }

    private boolean b(com.baidu.live.gift.a.c cVar, boolean z) {
        com.baidu.live.entereffect.a.a go;
        com.baidu.live.gift.c cVar2;
        if (z || (go = com.baidu.live.entereffect.a.Et().go(cVar.giftId)) == null || (cVar2 = go.aRg) == null) {
            return false;
        }
        return (TextUtils.isEmpty(cVar2.videoPath) && ListUtils.isEmpty(cVar2.unZipFilesPathList)) ? false : true;
    }

    private boolean a(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2) {
        boolean z = (!com.baidu.live.alphavideo.a.BT().BU() || cVar == null || cVar.aRQ == null) ? false : true;
        return cVar2.aYy ? z && !TextUtils.isEmpty(cVar.EM()) : z && cVar.aRQ.EL() && !TextUtils.isEmpty(cVar.EM());
    }

    private boolean a(com.baidu.live.gift.c cVar) {
        return (cVar == null || ListUtils.isEmpty(cVar.getDynamicGiftPicPathList())) ? false : true;
    }

    private void c(com.baidu.live.gift.a.c cVar, boolean z) {
        if (cVar != null) {
            g gVar = cVar.aYo;
            if (!cVar.aYy && !cVar.aYz) {
                if (cVar.aYv || cVar.aYn) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt(LogConfig.LOG_GIFT_ID, gVar.Fd());
                        jSONObject.putOpt("gift_name", gVar.Fe());
                        jSONObject.putOpt(LogConfig.LOG_GIFT_VALUE, gVar.getPrice());
                        jSONObject.putOpt("gift_num", Long.valueOf(cVar.aYt));
                        jSONObject.putOpt("is_down", Integer.valueOf(z ? 1 : 0));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", cVar.aYv ? UbcStatConstant.Page.AUTHOR_LIVE_ROOM : "liveroom", "giftplay_show").setContentExt(null, MapController.POPUP_LAYER_TAG, jSONObject));
                }
            }
        }
    }

    private void b(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2) {
        if (this.aUs == null) {
            this.aUs = new AlaDynamicVideoGiftLayout(this.mContext);
        }
        ViewGroup.LayoutParams layoutParams = this.aUs.getLayoutParams();
        if (!(layoutParams instanceof RelativeLayout.LayoutParams)) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        }
        this.aUo.a(this.aUs, (RelativeLayout.LayoutParams) layoutParams);
        this.aUs.setHost(this.aUo.aRM);
        this.aUs.setEnterEffectRelativeBottomMargin(this.aUw);
        this.aUs.setData(cVar, cVar2);
        this.aUs.setBigGiftCallBack(this.aUx);
        this.aUs.startAnim();
        c(cVar2, true);
    }

    private void c(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2) {
        if (this.aUt == null) {
            this.aUt = new AlaDynamicGiftLayout(this.mContext);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aUt.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        }
        this.aUo.a(this.aUt, layoutParams);
        this.aUt.setHost(this.aUo.aRM);
        this.aUt.setData(cVar, cVar2);
        this.aUt.setBigGiftCallBack(this.aUx);
        this.aUt.startAnim();
        c(cVar2, true);
    }

    private void k(com.baidu.live.gift.a.c cVar) {
        if (this.aUu == null) {
            this.aUu = new AlaDynamicGiftSmallGiftStyleView(this.mContext);
        }
        this.aUo.M(this.aUu);
        this.aUu.ev(this.aUv);
        this.aUu.setData(cVar);
        this.aUu.setBigGiftCallBack(this.aUx);
        this.aUu.startAnim();
        c(cVar, false);
    }

    public boolean GL() {
        return this.aUq;
    }

    public void GM() {
        boolean z = false;
        if (2 == UtilHelper.getRealScreenOrientation(this.mContext)) {
            z = true;
        }
        if (this.aUs != null) {
            this.aUs.GM();
        }
        if (this.aUt != null) {
            this.aUt.bL(z);
        }
        if (this.aUu != null) {
            this.aUu.bL(z);
        }
    }

    public void onDestroy() {
        this.aUr = 0;
        this.aUp.clear();
        this.aUq = false;
        if (this.aUs != null) {
            this.aUs.onDestroy();
        }
        if (this.aUt != null) {
            this.aUt.onDestroy();
        }
        if (this.aUu != null) {
            this.aUu.onDestroy();
        }
        this.mContext = null;
    }

    protected void log(Object... objArr) {
        AlaStatManager.getInstance().newDebug("alaGift", 0L, null, objArr);
    }

    public void bo(boolean z) {
        this.aTv = z;
    }

    public void dX(int i) {
        this.aUv = i;
    }

    public void dY(int i) {
        this.aUw = i;
    }
}

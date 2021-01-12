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
import com.baidu.live.gift.j;
import com.baidu.live.gift.v;
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
import com.baidu.live.utils.l;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    private AlaDynamicGiftSmallGiftStyleView aVA;
    private int aVB;
    private int aVC;
    private j aVu;
    private boolean aVw;
    private int aVx;
    private AlaDynamicVideoGiftLayout aVy;
    private AlaDynamicGiftLayout aVz;
    private Context mContext;
    private boolean aTV = false;
    private b aVD = new b() { // from class: com.baidu.live.gift.biggift.a.1
        @Override // com.baidu.live.gift.biggift.b
        public void m(com.baidu.live.gift.a.c cVar) {
            a.this.aVw = true;
            cVar.aP(System.currentTimeMillis());
        }

        @Override // com.baidu.live.gift.biggift.b
        public void cI(int i) {
        }

        @Override // com.baidu.live.gift.biggift.b
        public void a(int i, String str, com.baidu.live.gift.a.c cVar) {
            l.a(i, str, cVar.giftId, cVar.userId, cVar.msgId, cVar.aZP);
        }

        @Override // com.baidu.live.gift.biggift.b
        public void n(com.baidu.live.gift.a.c cVar) {
            a.this.j(cVar);
            a.this.aVw = false;
            a.this.aVu.Dr();
            a.this.Et();
        }
    };
    private ArrayList<com.baidu.live.gift.a.c> aVv = new ArrayList<>();

    public a(Context context, j jVar) {
        this.aVx = 0;
        this.mContext = context;
        this.aVu = jVar;
        this.aVx = 0;
    }

    public void h(com.baidu.live.gift.a.c cVar) {
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            long j = cVar.aZM;
            cVar.aZM = 1L;
            for (int i = 0; i < j; i++) {
                com.baidu.live.gift.a.c clone = cVar.clone();
                if (clone != null) {
                    if (cVar.priority == 11) {
                        this.aVv.add(0, clone);
                    } else {
                        this.aVv.add(clone);
                    }
                    if (clone.aZP) {
                        LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_ENTER_LIST, clone.chatMCastId, clone.ensureMCastId, clone.giftId, "");
                    }
                }
            }
            try {
                Er();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void Er() {
        if (this.aVv != null) {
            int i = com.baidu.live.af.a.OJ().bru != null ? com.baidu.live.af.a.OJ().bru.aKh : 0;
            if (i > 0 && this.aVv.size() > i) {
                Collections.sort(this.aVv, new c.a());
                int max = Math.max((int) (i * 0.7f), 1);
                ArrayList arrayList = new ArrayList(this.aVv.subList(0, max));
                while (true) {
                    int i2 = max;
                    if (i2 < this.aVv.size()) {
                        if (this.aVv.get(i2) == null || !this.aVv.get(i2).aZS) {
                            max = i2 + 1;
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 1));
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (this.aVv.removeAll(arrayList)) {
                    Iterator<com.baidu.live.gift.a.c> it = this.aVv.iterator();
                    while (it.hasNext()) {
                        com.baidu.live.gift.a.c next = it.next();
                        l.a(next.giftId, next.userId, next.msgId, next.aZP);
                    }
                }
                this.aVv.clear();
                this.aVv.addAll(arrayList);
            }
        }
    }

    public void i(com.baidu.live.gift.a.c cVar) {
        if (Ew()) {
            l.c(cVar.giftId, cVar.userId, cVar.msgId, cVar.aZP);
        } else {
            Et();
        }
    }

    public void Es() {
        if (this.aVw) {
            if (this.aVy != null) {
                this.aVy.stopAnim();
            }
            if (this.aVz != null) {
                this.aVz.stopAnim();
            }
            if (this.aVA != null) {
                this.aVA.stopAnim();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(com.baidu.live.gift.a.c cVar) {
        if (cVar != null && cVar.aZP) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(LogConfig.LOG_GIFT_ID, cVar.giftId);
                jSONObject.put("gift_count", cVar.aZM);
                jSONObject.put("sender_uk", EncryptionHelper.getEncryptionUserId(cVar.userId));
                jSONObject.put("show_stime", cVar.Fp());
                jSONObject.put("show_ctime", System.currentTimeMillis());
                if (cVar.aZW) {
                    jSONObject.put("from_recovery", 1);
                }
            } catch (JSONException e) {
                BdLog.e(e);
            }
            UbcStatisticManager.getInstance().debugException(new UbcDebugItem("author_liveroom", UbcStatConstant.DebugContentValue.GIFT, jSONObject), UbcStatConstant.ContentType.UBC_TYPE_GIFT_SHOW);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Et() {
        if (this.aVv.isEmpty()) {
            this.aVu.Dp();
            Ev();
            return;
        }
        com.baidu.live.gift.a.c Eu = Eu();
        if (Eu == null) {
            Et();
        } else {
            k(Eu);
        }
    }

    private com.baidu.live.gift.a.c Eu() {
        if (this.aVv.isEmpty()) {
            return null;
        }
        return this.aVv.remove(0);
    }

    private void Ev() {
        this.aVu.Dr();
    }

    private void k(com.baidu.live.gift.a.c cVar) {
        com.baidu.live.gift.c go;
        if (cVar != null) {
            boolean z = UtilHelper.getRealScreenOrientation(this.mContext) == 2;
            if (cVar.aZS && !b(cVar, z)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 1));
                Et();
            } else if (z && cVar.aZT) {
                Et();
            } else if (this.aTV && z && !cVar.aZG) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913138, cVar));
                l.b(cVar.giftId, cVar.userId, cVar.msgId, cVar.aZP);
                Et();
            } else {
                try {
                    if ((cVar.aZH != null && com.baidu.live.gift.c.b.Gb().fL(cVar.aZH.CC())) || cVar.aZS) {
                        if (cVar.aZS) {
                            go = com.baidu.live.entereffect.a.BG().fi(cVar.giftId).aRk;
                        } else {
                            go = com.baidu.live.gift.c.b.Gb().go(cVar.giftId);
                        }
                        if (a(go, cVar)) {
                            if (cVar.aZS) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 0));
                                com.baidu.live.entereffect.a.BG().fj(cVar.giftId);
                            } else if (go != null && go.aSo != null && go.aSo.aSl != null) {
                                v.fn(go.aSo.aSl.zipName);
                            }
                            b(go, cVar);
                        } else if (b(go)) {
                            if (cVar.aZS) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 0));
                                com.baidu.live.entereffect.a.BG().fj(cVar.giftId);
                            } else if (go != null && go.aSo != null && go.aSo.aSl != null) {
                                v.fn(go.aSo.aSl.zipName);
                            }
                            c(go, cVar);
                        } else {
                            if (cVar.aZS || cVar.aZT || cVar.aZU) {
                                Et();
                                if (cVar.aZS) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 1));
                                }
                            } else {
                                l(cVar);
                                l.b(cVar.giftId, cVar.userId, cVar.msgId, cVar.aZP);
                            }
                            a(go);
                        }
                        if (cVar.aZP) {
                            LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW, cVar.chatMCastId, cVar.ensureMCastId, cVar.giftId, "");
                        }
                    } else {
                        if (cVar.aZP) {
                            LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW_FAIL, cVar.chatMCastId, cVar.ensureMCastId, cVar.giftId, "不在大礼物列表");
                        }
                        l.d(cVar.giftId, cVar.userId, cVar.msgId, cVar.aZP);
                    }
                } catch (OutOfMemoryError e) {
                    log(BdStatsConstant.StatsType.ERROR, "showbiggift", TiebaInitialize.LogFields.REASON, "oom");
                    TbadkCoreApplication.getInst().onAppMemoryLow();
                    System.gc();
                    if (cVar.aZP) {
                        LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW_FAIL, cVar.chatMCastId, cVar.ensureMCastId, cVar.giftId, "OOM");
                    }
                    if (this.aVx < 1) {
                        this.aVx++;
                        k(cVar);
                    } else {
                        Et();
                    }
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2913019));
            }
        }
    }

    private void a(com.baidu.live.gift.c cVar) {
        if (cVar != null && cVar.aSo != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("cartoon_id", cVar.aSo.giftId);
                String str = "portrait";
                if (cVar.aSo.aSl != null && cVar.aSo.aSl.isLandScape()) {
                    str = "landscape";
                }
                jSONObject.put("status", str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "cartoon_lacking").setContentExt(null, null, jSONObject));
        }
    }

    private boolean b(com.baidu.live.gift.a.c cVar, boolean z) {
        com.baidu.live.entereffect.a.a fi;
        com.baidu.live.gift.c cVar2;
        if (z || (fi = com.baidu.live.entereffect.a.BG().fi(cVar.giftId)) == null || (cVar2 = fi.aRk) == null) {
            return false;
        }
        return (TextUtils.isEmpty(cVar2.videoPath) && ListUtils.isEmpty(cVar2.unZipFilesPathList)) ? false : true;
    }

    private boolean a(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2) {
        boolean z = (!com.baidu.live.alphavideo.a.yH().yI() || cVar == null || cVar.aSo == null) ? false : true;
        return cVar2.aZS ? z && !TextUtils.isEmpty(cVar.Cj()) : z && cVar.aSo.Cg() && !TextUtils.isEmpty(cVar.Cj());
    }

    private boolean b(com.baidu.live.gift.c cVar) {
        return (cVar == null || ListUtils.isEmpty(cVar.getDynamicGiftPicPathList())) ? false : true;
    }

    private void c(com.baidu.live.gift.a.c cVar, boolean z) {
        if (cVar != null) {
            g gVar = cVar.aZH;
            if (!cVar.aZS && !cVar.aZT) {
                if (cVar.aZP || cVar.aZG) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt(LogConfig.LOG_GIFT_ID, gVar.CC());
                        jSONObject.putOpt("gift_name", gVar.CD());
                        jSONObject.putOpt(LogConfig.LOG_GIFT_VALUE, gVar.getPrice());
                        jSONObject.putOpt("gift_num", Long.valueOf(cVar.aZM));
                        jSONObject.putOpt("is_down", Integer.valueOf(z ? 1 : 0));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", cVar.aZP ? "author_liveroom" : "liveroom", "giftplay_show").setContentExt(null, UbcStatConstant.SubPage.POPUP, jSONObject));
                }
            }
        }
    }

    private void b(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2) {
        if (this.aVy == null) {
            this.aVy = new AlaDynamicVideoGiftLayout(this.mContext);
        }
        ViewGroup.LayoutParams layoutParams = this.aVy.getLayoutParams();
        if (!(layoutParams instanceof RelativeLayout.LayoutParams)) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        }
        this.aVu.a(this.aVy, (RelativeLayout.LayoutParams) layoutParams);
        this.aVy.setHost(this.aVu.aSj);
        this.aVy.setEnterEffectRelativeBottomMargin(this.aVC);
        this.aVy.setData(cVar, cVar2);
        this.aVy.setBigGiftCallBack(this.aVD);
        this.aVy.startAnim();
        c(cVar2, true);
    }

    private void c(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2) {
        if (this.aVz == null) {
            this.aVz = new AlaDynamicGiftLayout(this.mContext);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aVz.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        }
        this.aVu.a(this.aVz, layoutParams);
        this.aVz.setHost(this.aVu.aSj);
        this.aVz.setData(cVar, cVar2);
        this.aVz.setBigGiftCallBack(this.aVD);
        this.aVz.startAnim();
        c(cVar2, true);
    }

    private void l(com.baidu.live.gift.a.c cVar) {
        if (this.aVA == null) {
            this.aVA = new AlaDynamicGiftSmallGiftStyleView(this.mContext);
        }
        this.aVu.M(this.aVA);
        this.aVA.df(this.aVB);
        this.aVA.setData(cVar);
        this.aVA.setBigGiftCallBack(this.aVD);
        this.aVA.startAnim();
        c(cVar, false);
    }

    public boolean Ew() {
        return this.aVw;
    }

    public void Ex() {
        boolean z = false;
        if (2 == UtilHelper.getRealScreenOrientation(this.mContext)) {
            z = true;
        }
        if (this.aVy != null) {
            this.aVy.Ex();
        }
        if (this.aVz != null) {
            this.aVz.bT(z);
        }
        if (this.aVA != null) {
            this.aVA.bT(z);
        }
    }

    public void onDestroy() {
        this.aVx = 0;
        this.aVv.clear();
        this.aVw = false;
        if (this.aVy != null) {
            this.aVy.onDestroy();
        }
        if (this.aVz != null) {
            this.aVz.onDestroy();
        }
        if (this.aVA != null) {
            this.aVA.onDestroy();
        }
        this.mContext = null;
    }

    protected void log(Object... objArr) {
        AlaStatManager.getInstance().newDebug("alaGift", 0L, null, objArr);
    }

    public void bw(boolean z) {
        this.aTV = z;
    }

    public void cG(int i) {
        this.aVB = i;
    }

    public void cH(int i) {
        this.aVC = i;
    }
}

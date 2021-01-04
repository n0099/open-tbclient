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
/* loaded from: classes11.dex */
public class a {
    private j bah;
    private boolean baj;
    private int bak;
    private AlaDynamicVideoGiftLayout bal;
    private AlaDynamicGiftLayout bam;
    private AlaDynamicGiftSmallGiftStyleView ban;
    private int bao;
    private int bap;
    private Context mContext;
    private boolean aYI = false;
    private b baq = new b() { // from class: com.baidu.live.gift.biggift.a.1
        @Override // com.baidu.live.gift.biggift.b
        public void m(com.baidu.live.gift.a.c cVar) {
            a.this.baj = true;
            cVar.aP(System.currentTimeMillis());
        }

        @Override // com.baidu.live.gift.biggift.b
        public void eo(int i) {
        }

        @Override // com.baidu.live.gift.biggift.b
        public void a(int i, String str, com.baidu.live.gift.a.c cVar) {
            l.a(i, str, cVar.giftId, cVar.userId, cVar.msgId, cVar.beF);
        }

        @Override // com.baidu.live.gift.biggift.b
        public void n(com.baidu.live.gift.a.c cVar) {
            a.this.j(cVar);
            a.this.baj = false;
            a.this.bah.Hm();
            a.this.Io();
        }
    };
    private ArrayList<com.baidu.live.gift.a.c> bai = new ArrayList<>();

    public a(Context context, j jVar) {
        this.bak = 0;
        this.mContext = context;
        this.bah = jVar;
        this.bak = 0;
    }

    public void h(com.baidu.live.gift.a.c cVar) {
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            long j = cVar.beC;
            cVar.beC = 1L;
            for (int i = 0; i < j; i++) {
                com.baidu.live.gift.a.c clone = cVar.clone();
                if (clone != null) {
                    if (cVar.priority == 11) {
                        this.bai.add(0, clone);
                    } else {
                        this.bai.add(clone);
                    }
                    if (clone.beF) {
                        LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_ENTER_LIST, clone.chatMCastId, clone.ensureMCastId, clone.giftId, "");
                    }
                }
            }
            try {
                Im();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void Im() {
        if (this.bai != null) {
            int i = com.baidu.live.af.a.SE().bwi != null ? com.baidu.live.af.a.SE().bwi.aOU : 0;
            if (i > 0 && this.bai.size() > i) {
                Collections.sort(this.bai, new c.a());
                int max = Math.max((int) (i * 0.7f), 1);
                ArrayList arrayList = new ArrayList(this.bai.subList(0, max));
                while (true) {
                    int i2 = max;
                    if (i2 < this.bai.size()) {
                        if (this.bai.get(i2) == null || !this.bai.get(i2).beI) {
                            max = i2 + 1;
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 1));
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (this.bai.removeAll(arrayList)) {
                    Iterator<com.baidu.live.gift.a.c> it = this.bai.iterator();
                    while (it.hasNext()) {
                        com.baidu.live.gift.a.c next = it.next();
                        l.a(next.giftId, next.userId, next.msgId, next.beF);
                    }
                }
                this.bai.clear();
                this.bai.addAll(arrayList);
            }
        }
    }

    public void i(com.baidu.live.gift.a.c cVar) {
        if (Ir()) {
            l.c(cVar.giftId, cVar.userId, cVar.msgId, cVar.beF);
        } else {
            Io();
        }
    }

    public void In() {
        if (this.baj) {
            if (this.bal != null) {
                this.bal.stopAnim();
            }
            if (this.bam != null) {
                this.bam.stopAnim();
            }
            if (this.ban != null) {
                this.ban.stopAnim();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(com.baidu.live.gift.a.c cVar) {
        if (cVar != null && cVar.beF) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(LogConfig.LOG_GIFT_ID, cVar.giftId);
                jSONObject.put("gift_count", cVar.beC);
                jSONObject.put("sender_uk", EncryptionHelper.getEncryptionUserId(cVar.userId));
                jSONObject.put("show_stime", cVar.Jk());
                jSONObject.put("show_ctime", System.currentTimeMillis());
                if (cVar.beM) {
                    jSONObject.put("from_recovery", 1);
                }
            } catch (JSONException e) {
                BdLog.e(e);
            }
            UbcStatisticManager.getInstance().debugException(new UbcDebugItem("author_liveroom", UbcStatConstant.DebugContentValue.GIFT, jSONObject), UbcStatConstant.ContentType.UBC_TYPE_GIFT_SHOW);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Io() {
        if (this.bai.isEmpty()) {
            this.bah.Hk();
            Iq();
            return;
        }
        com.baidu.live.gift.a.c Ip = Ip();
        if (Ip == null) {
            Io();
        } else {
            k(Ip);
        }
    }

    private com.baidu.live.gift.a.c Ip() {
        if (this.bai.isEmpty()) {
            return null;
        }
        return this.bai.remove(0);
    }

    private void Iq() {
        this.bah.Hm();
    }

    private void k(com.baidu.live.gift.a.c cVar) {
        com.baidu.live.gift.c hA;
        if (cVar != null) {
            boolean z = UtilHelper.getRealScreenOrientation(this.mContext) == 2;
            if (cVar.beI && !b(cVar, z)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 1));
                Io();
            } else if (z && cVar.beJ) {
                Io();
            } else if (this.aYI && z && !cVar.bew) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913138, cVar));
                l.b(cVar.giftId, cVar.userId, cVar.msgId, cVar.beF);
                Io();
            } else {
                try {
                    if ((cVar.bex != null && com.baidu.live.gift.c.b.JW().gX(cVar.bex.Gx())) || cVar.beI) {
                        if (cVar.beI) {
                            hA = com.baidu.live.entereffect.a.FB().gu(cVar.giftId).aVX;
                        } else {
                            hA = com.baidu.live.gift.c.b.JW().hA(cVar.giftId);
                        }
                        if (a(hA, cVar)) {
                            if (cVar.beI) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 0));
                                com.baidu.live.entereffect.a.FB().gv(cVar.giftId);
                            } else if (hA != null && hA.aXb != null && hA.aXb.aWY != null) {
                                v.gz(hA.aXb.aWY.zipName);
                            }
                            b(hA, cVar);
                        } else if (b(hA)) {
                            if (cVar.beI) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 0));
                                com.baidu.live.entereffect.a.FB().gv(cVar.giftId);
                            } else if (hA != null && hA.aXb != null && hA.aXb.aWY != null) {
                                v.gz(hA.aXb.aWY.zipName);
                            }
                            c(hA, cVar);
                        } else {
                            if (cVar.beI || cVar.beJ || cVar.beK) {
                                Io();
                                if (cVar.beI) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 1));
                                }
                            } else {
                                l(cVar);
                                l.b(cVar.giftId, cVar.userId, cVar.msgId, cVar.beF);
                            }
                            a(hA);
                        }
                        if (cVar.beF) {
                            LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW, cVar.chatMCastId, cVar.ensureMCastId, cVar.giftId, "");
                        }
                    } else {
                        if (cVar.beF) {
                            LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW_FAIL, cVar.chatMCastId, cVar.ensureMCastId, cVar.giftId, "不在大礼物列表");
                        }
                        l.d(cVar.giftId, cVar.userId, cVar.msgId, cVar.beF);
                    }
                } catch (OutOfMemoryError e) {
                    log(BdStatsConstant.StatsType.ERROR, "showbiggift", TiebaInitialize.LogFields.REASON, "oom");
                    TbadkCoreApplication.getInst().onAppMemoryLow();
                    System.gc();
                    if (cVar.beF) {
                        LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW_FAIL, cVar.chatMCastId, cVar.ensureMCastId, cVar.giftId, "OOM");
                    }
                    if (this.bak < 1) {
                        this.bak++;
                        k(cVar);
                    } else {
                        Io();
                    }
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2913019));
            }
        }
    }

    private void a(com.baidu.live.gift.c cVar) {
        if (cVar != null && cVar.aXb != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("cartoon_id", cVar.aXb.giftId);
                String str = "portrait";
                if (cVar.aXb.aWY != null && cVar.aXb.aWY.isLandScape()) {
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
        com.baidu.live.entereffect.a.a gu;
        com.baidu.live.gift.c cVar2;
        if (z || (gu = com.baidu.live.entereffect.a.FB().gu(cVar.giftId)) == null || (cVar2 = gu.aVX) == null) {
            return false;
        }
        return (TextUtils.isEmpty(cVar2.videoPath) && ListUtils.isEmpty(cVar2.unZipFilesPathList)) ? false : true;
    }

    private boolean a(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2) {
        boolean z = (!com.baidu.live.alphavideo.a.CC().CD() || cVar == null || cVar.aXb == null) ? false : true;
        return cVar2.beI ? z && !TextUtils.isEmpty(cVar.Ge()) : z && cVar.aXb.Gb() && !TextUtils.isEmpty(cVar.Ge());
    }

    private boolean b(com.baidu.live.gift.c cVar) {
        return (cVar == null || ListUtils.isEmpty(cVar.getDynamicGiftPicPathList())) ? false : true;
    }

    private void c(com.baidu.live.gift.a.c cVar, boolean z) {
        if (cVar != null) {
            g gVar = cVar.bex;
            if (!cVar.beI && !cVar.beJ) {
                if (cVar.beF || cVar.bew) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt(LogConfig.LOG_GIFT_ID, gVar.Gx());
                        jSONObject.putOpt("gift_name", gVar.Gy());
                        jSONObject.putOpt(LogConfig.LOG_GIFT_VALUE, gVar.getPrice());
                        jSONObject.putOpt("gift_num", Long.valueOf(cVar.beC));
                        jSONObject.putOpt("is_down", Integer.valueOf(z ? 1 : 0));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", cVar.beF ? "author_liveroom" : "liveroom", "giftplay_show").setContentExt(null, "popup", jSONObject));
                }
            }
        }
    }

    private void b(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2) {
        if (this.bal == null) {
            this.bal = new AlaDynamicVideoGiftLayout(this.mContext);
        }
        ViewGroup.LayoutParams layoutParams = this.bal.getLayoutParams();
        if (!(layoutParams instanceof RelativeLayout.LayoutParams)) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        }
        this.bah.a(this.bal, (RelativeLayout.LayoutParams) layoutParams);
        this.bal.setHost(this.bah.aWW);
        this.bal.setEnterEffectRelativeBottomMargin(this.bap);
        this.bal.setData(cVar, cVar2);
        this.bal.setBigGiftCallBack(this.baq);
        this.bal.startAnim();
        c(cVar2, true);
    }

    private void c(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2) {
        if (this.bam == null) {
            this.bam = new AlaDynamicGiftLayout(this.mContext);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bam.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        }
        this.bah.a(this.bam, layoutParams);
        this.bam.setHost(this.bah.aWW);
        this.bam.setData(cVar, cVar2);
        this.bam.setBigGiftCallBack(this.baq);
        this.bam.startAnim();
        c(cVar2, true);
    }

    private void l(com.baidu.live.gift.a.c cVar) {
        if (this.ban == null) {
            this.ban = new AlaDynamicGiftSmallGiftStyleView(this.mContext);
        }
        this.bah.M(this.ban);
        this.ban.eL(this.bao);
        this.ban.setData(cVar);
        this.ban.setBigGiftCallBack(this.baq);
        this.ban.startAnim();
        c(cVar, false);
    }

    public boolean Ir() {
        return this.baj;
    }

    public void Is() {
        boolean z = false;
        if (2 == UtilHelper.getRealScreenOrientation(this.mContext)) {
            z = true;
        }
        if (this.bal != null) {
            this.bal.Is();
        }
        if (this.bam != null) {
            this.bam.bX(z);
        }
        if (this.ban != null) {
            this.ban.bX(z);
        }
    }

    public void onDestroy() {
        this.bak = 0;
        this.bai.clear();
        this.baj = false;
        if (this.bal != null) {
            this.bal.onDestroy();
        }
        if (this.bam != null) {
            this.bam.onDestroy();
        }
        if (this.ban != null) {
            this.ban.onDestroy();
        }
        this.mContext = null;
    }

    protected void log(Object... objArr) {
        AlaStatManager.getInstance().newDebug("alaGift", 0L, null, objArr);
    }

    public void bA(boolean z) {
        this.aYI = z;
    }

    public void em(int i) {
        this.bao = i;
    }

    public void en(int i) {
        this.bap = i;
    }
}

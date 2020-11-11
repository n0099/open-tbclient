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
import com.baidu.live.gift.u;
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
import java.util.ArrayList;
import java.util.Collections;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    private j aXb;
    private boolean aXd;
    private int aXe;
    private AlaDynamicVideoGiftLayout aXf;
    private AlaDynamicGiftLayout aXg;
    private AlaDynamicGiftSmallGiftStyleView aXh;
    private int aXi;
    private int aXj;
    private Context mContext;
    private boolean aVJ = false;
    private b aXk = new b() { // from class: com.baidu.live.gift.biggift.a.1
        @Override // com.baidu.live.gift.biggift.b
        public void l(com.baidu.live.gift.a.c cVar) {
            a.this.aXd = true;
            cVar.as(System.currentTimeMillis());
        }

        @Override // com.baidu.live.gift.biggift.b
        public void ea(int i) {
        }

        @Override // com.baidu.live.gift.biggift.b
        public void m(com.baidu.live.gift.a.c cVar) {
            a.this.i(cVar);
            a.this.aXd = false;
            a.this.aXb.GF();
            a.this.HF();
        }
    };
    private ArrayList<com.baidu.live.gift.a.c> aXc = new ArrayList<>();

    public a(Context context, j jVar) {
        this.aXe = 0;
        this.mContext = context;
        this.aXb = jVar;
        this.aXe = 0;
    }

    public void h(com.baidu.live.gift.a.c cVar) {
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            long j = cVar.bbi;
            cVar.bbi = 1L;
            for (int i = 0; i < j; i++) {
                com.baidu.live.gift.a.c clone = cVar.clone();
                if (clone != null) {
                    if (cVar.priority == 11) {
                        this.aXc.add(0, clone);
                    } else {
                        this.aXc.add(clone);
                    }
                    if (clone.bbk) {
                        LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_ENTER_LIST, clone.chatMCastId, clone.ensureMCastId, clone.giftId, "");
                    }
                }
            }
            try {
                HC();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void HC() {
        if (this.aXc != null) {
            int i = com.baidu.live.aa.a.PQ().bod != null ? com.baidu.live.aa.a.PQ().bod.aNd : 0;
            if (i > 0 && this.aXc.size() >= i) {
                Collections.sort(this.aXc, new c.a());
                int max = Math.max((int) (i * 0.7f), 1);
                ArrayList arrayList = new ArrayList(this.aXc.subList(0, max));
                while (true) {
                    int i2 = max;
                    if (i2 < this.aXc.size()) {
                        if (this.aXc.get(i2) == null || !this.aXc.get(i2).bbn) {
                            max = i2 + 1;
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 1));
                            break;
                        }
                    } else {
                        break;
                    }
                }
                this.aXc.clear();
                this.aXc.addAll(arrayList);
            }
        }
    }

    public void HD() {
        if (!HI()) {
            HF();
        }
    }

    public void HE() {
        if (this.aXd) {
            if (this.aXf != null) {
                this.aXf.stopAnim();
            }
            if (this.aXg != null) {
                this.aXg.stopAnim();
            }
            if (this.aXh != null) {
                this.aXh.stopAnim();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(com.baidu.live.gift.a.c cVar) {
        if (cVar != null && cVar.bbk) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(LogConfig.LOG_GIFT_ID, cVar.giftId);
                jSONObject.put("gift_count", cVar.bbi);
                jSONObject.put("sender_uk", EncryptionHelper.getEncryptionUserId(cVar.userId));
                jSONObject.put("show_stime", cVar.IA());
                jSONObject.put("show_ctime", System.currentTimeMillis());
                if (cVar.bbr) {
                    jSONObject.put("from_recovery", 1);
                }
            } catch (JSONException e) {
                BdLog.e(e);
            }
            UbcStatisticManager.getInstance().debugException(new UbcDebugItem(UbcStatConstant.Page.AUTHOR_LIVE_ROOM, UbcStatConstant.DebugContentValue.GIFT, jSONObject), "gift_show");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HF() {
        if (this.aXc.isEmpty()) {
            this.aXb.GD();
            HH();
            return;
        }
        com.baidu.live.gift.a.c HG = HG();
        if (HG == null) {
            HF();
        } else {
            j(HG);
        }
    }

    private com.baidu.live.gift.a.c HG() {
        if (this.aXc.isEmpty()) {
            return null;
        }
        return this.aXc.remove(0);
    }

    private void HH() {
        this.aXb.GF();
    }

    private void j(com.baidu.live.gift.a.c cVar) {
        com.baidu.live.gift.c hx;
        if (cVar != null) {
            boolean z = UtilHelper.getRealScreenOrientation(this.mContext) == 2;
            if (cVar.bbn && !b(cVar, z)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 1));
                HF();
            } else if (z && cVar.bbo) {
                HF();
            } else if (this.aVJ && z && !cVar.bbb) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913138, cVar));
                HF();
            } else {
                try {
                    if ((cVar.bbc != null && com.baidu.live.gift.b.b.Je().gX(cVar.bbc.FT())) || cVar.bbn) {
                        if (cVar.bbn) {
                            hx = com.baidu.live.entereffect.a.Fg().gv(cVar.giftId).aTo;
                        } else {
                            hx = com.baidu.live.gift.b.b.Je().hx(cVar.giftId);
                        }
                        if (a(hx, cVar)) {
                            if (cVar.bbn) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 0));
                                com.baidu.live.entereffect.a.Fg().gw(cVar.giftId);
                            } else if (hx != null && hx.aUe != null && hx.aUe.aUc != null) {
                                u.gA(hx.aUe.aUc.zipName);
                            }
                            b(hx, cVar);
                        } else if (b(hx)) {
                            if (cVar.bbn) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 0));
                                com.baidu.live.entereffect.a.Fg().gw(cVar.giftId);
                            } else if (hx != null && hx.aUe != null && hx.aUe.aUc != null) {
                                u.gA(hx.aUe.aUc.zipName);
                            }
                            c(hx, cVar);
                        } else {
                            if (cVar.bbn || cVar.bbo || cVar.bbp) {
                                HF();
                                if (cVar.bbn) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 1));
                                }
                            } else {
                                k(cVar);
                            }
                            a(hx);
                        }
                        if (cVar.bbk) {
                            LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW, cVar.chatMCastId, cVar.ensureMCastId, cVar.giftId, "");
                        }
                    } else if (cVar.bbk) {
                        LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW_FAIL, cVar.chatMCastId, cVar.ensureMCastId, cVar.giftId, "不在大礼物列表");
                    }
                } catch (OutOfMemoryError e) {
                    log(BdStatsConstant.StatsType.ERROR, "showbiggift", TiebaInitialize.LogFields.REASON, "oom");
                    TbadkCoreApplication.getInst().onAppMemoryLow();
                    System.gc();
                    if (cVar.bbk) {
                        LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW_FAIL, cVar.chatMCastId, cVar.ensureMCastId, cVar.giftId, "OOM");
                    }
                    if (this.aXe < 1) {
                        this.aXe++;
                        j(cVar);
                    } else {
                        HF();
                    }
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2913019));
            }
        }
    }

    private void a(com.baidu.live.gift.c cVar) {
        if (cVar != null && cVar.aUe != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("cartoon_id", cVar.aUe.giftId);
                String str = "portrait";
                if (cVar.aUe.aUc != null && cVar.aUe.aUc.isLandScape()) {
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
        com.baidu.live.entereffect.a.a gv;
        com.baidu.live.gift.c cVar2;
        if (z || (gv = com.baidu.live.entereffect.a.Fg().gv(cVar.giftId)) == null || (cVar2 = gv.aTo) == null) {
            return false;
        }
        return (TextUtils.isEmpty(cVar2.videoPath) && ListUtils.isEmpty(cVar2.unZipFilesPathList)) ? false : true;
    }

    private boolean a(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2) {
        boolean z = (!com.baidu.live.alphavideo.a.Cl().Cm() || cVar == null || cVar.aUe == null) ? false : true;
        return cVar2.bbn ? z && !TextUtils.isEmpty(cVar.FC()) : z && cVar.aUe.FB() && !TextUtils.isEmpty(cVar.FC());
    }

    private boolean b(com.baidu.live.gift.c cVar) {
        return (cVar == null || ListUtils.isEmpty(cVar.getDynamicGiftPicPathList())) ? false : true;
    }

    private void c(com.baidu.live.gift.a.c cVar, boolean z) {
        if (cVar != null) {
            g gVar = cVar.bbc;
            if (!cVar.bbn && !cVar.bbo) {
                if (cVar.bbk || cVar.bbb) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt(LogConfig.LOG_GIFT_ID, gVar.FT());
                        jSONObject.putOpt("gift_name", gVar.FU());
                        jSONObject.putOpt(LogConfig.LOG_GIFT_VALUE, gVar.getPrice());
                        jSONObject.putOpt("gift_num", Long.valueOf(cVar.bbi));
                        jSONObject.putOpt("is_down", Integer.valueOf(z ? 1 : 0));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", cVar.bbk ? UbcStatConstant.Page.AUTHOR_LIVE_ROOM : "liveroom", "giftplay_show").setContentExt(null, "popup", jSONObject));
                }
            }
        }
    }

    private void b(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2) {
        if (this.aXf == null) {
            this.aXf = new AlaDynamicVideoGiftLayout(this.mContext);
        }
        ViewGroup.LayoutParams layoutParams = this.aXf.getLayoutParams();
        if (!(layoutParams instanceof RelativeLayout.LayoutParams)) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        }
        this.aXb.a(this.aXf, (RelativeLayout.LayoutParams) layoutParams);
        this.aXf.setHost(this.aXb.aUa);
        this.aXf.setEnterEffectRelativeBottomMargin(this.aXj);
        this.aXf.setData(cVar, cVar2);
        this.aXf.setBigGiftCallBack(this.aXk);
        this.aXf.startAnim();
        c(cVar2, true);
    }

    private void c(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2) {
        if (this.aXg == null) {
            this.aXg = new AlaDynamicGiftLayout(this.mContext);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aXg.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        }
        this.aXb.a(this.aXg, layoutParams);
        this.aXg.setHost(this.aXb.aUa);
        this.aXg.setData(cVar, cVar2);
        this.aXg.setBigGiftCallBack(this.aXk);
        this.aXg.startAnim();
        c(cVar2, true);
    }

    private void k(com.baidu.live.gift.a.c cVar) {
        if (this.aXh == null) {
            this.aXh = new AlaDynamicGiftSmallGiftStyleView(this.mContext);
        }
        this.aXb.M(this.aXh);
        this.aXh.ew(this.aXi);
        this.aXh.setData(cVar);
        this.aXh.setBigGiftCallBack(this.aXk);
        this.aXh.startAnim();
        c(cVar, false);
    }

    public boolean HI() {
        return this.aXd;
    }

    public void HJ() {
        boolean z = false;
        if (2 == UtilHelper.getRealScreenOrientation(this.mContext)) {
            z = true;
        }
        if (this.aXf != null) {
            this.aXf.HJ();
        }
        if (this.aXg != null) {
            this.aXg.bO(z);
        }
        if (this.aXh != null) {
            this.aXh.bO(z);
        }
    }

    public void onDestroy() {
        this.aXe = 0;
        this.aXc.clear();
        this.aXd = false;
        if (this.aXf != null) {
            this.aXf.onDestroy();
        }
        if (this.aXg != null) {
            this.aXg.onDestroy();
        }
        if (this.aXh != null) {
            this.aXh.onDestroy();
        }
        this.mContext = null;
    }

    protected void log(Object... objArr) {
        AlaStatManager.getInstance().newDebug("alaGift", 0L, null, objArr);
    }

    public void br(boolean z) {
        this.aVJ = z;
    }

    public void dY(int i) {
        this.aXi = i;
    }

    public void dZ(int i) {
        this.aXj = i;
    }
}

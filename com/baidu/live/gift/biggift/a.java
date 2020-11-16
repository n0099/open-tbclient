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
    private j aVq;
    private boolean aVs;
    private int aVt;
    private AlaDynamicVideoGiftLayout aVu;
    private AlaDynamicGiftLayout aVv;
    private AlaDynamicGiftSmallGiftStyleView aVw;
    private int aVx;
    private int aVy;
    private Context mContext;
    private boolean aTY = false;
    private b aVz = new b() { // from class: com.baidu.live.gift.biggift.a.1
        @Override // com.baidu.live.gift.biggift.b
        public void l(com.baidu.live.gift.a.c cVar) {
            a.this.aVs = true;
            cVar.as(System.currentTimeMillis());
        }

        @Override // com.baidu.live.gift.biggift.b
        public void dW(int i) {
        }

        @Override // com.baidu.live.gift.biggift.b
        public void m(com.baidu.live.gift.a.c cVar) {
            a.this.i(cVar);
            a.this.aVs = false;
            a.this.aVq.FW();
            a.this.GW();
        }
    };
    private ArrayList<com.baidu.live.gift.a.c> aVr = new ArrayList<>();

    public a(Context context, j jVar) {
        this.aVt = 0;
        this.mContext = context;
        this.aVq = jVar;
        this.aVt = 0;
    }

    public void h(com.baidu.live.gift.a.c cVar) {
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            long j = cVar.aZw;
            cVar.aZw = 1L;
            for (int i = 0; i < j; i++) {
                com.baidu.live.gift.a.c clone = cVar.clone();
                if (clone != null) {
                    if (cVar.priority == 11) {
                        this.aVr.add(0, clone);
                    } else {
                        this.aVr.add(clone);
                    }
                    if (clone.aZy) {
                        LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_ENTER_LIST, clone.chatMCastId, clone.ensureMCastId, clone.giftId, "");
                    }
                }
            }
            try {
                GT();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void GT() {
        if (this.aVr != null) {
            int i = com.baidu.live.aa.a.Ph().bms != null ? com.baidu.live.aa.a.Ph().bms.aLs : 0;
            if (i > 0 && this.aVr.size() >= i) {
                Collections.sort(this.aVr, new c.a());
                int max = Math.max((int) (i * 0.7f), 1);
                ArrayList arrayList = new ArrayList(this.aVr.subList(0, max));
                while (true) {
                    int i2 = max;
                    if (i2 < this.aVr.size()) {
                        if (this.aVr.get(i2) == null || !this.aVr.get(i2).aZB) {
                            max = i2 + 1;
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 1));
                            break;
                        }
                    } else {
                        break;
                    }
                }
                this.aVr.clear();
                this.aVr.addAll(arrayList);
            }
        }
    }

    public void GU() {
        if (!GZ()) {
            GW();
        }
    }

    public void GV() {
        if (this.aVs) {
            if (this.aVu != null) {
                this.aVu.stopAnim();
            }
            if (this.aVv != null) {
                this.aVv.stopAnim();
            }
            if (this.aVw != null) {
                this.aVw.stopAnim();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(com.baidu.live.gift.a.c cVar) {
        if (cVar != null && cVar.aZy) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(LogConfig.LOG_GIFT_ID, cVar.giftId);
                jSONObject.put("gift_count", cVar.aZw);
                jSONObject.put("sender_uk", EncryptionHelper.getEncryptionUserId(cVar.userId));
                jSONObject.put("show_stime", cVar.HR());
                jSONObject.put("show_ctime", System.currentTimeMillis());
                if (cVar.aZF) {
                    jSONObject.put("from_recovery", 1);
                }
            } catch (JSONException e) {
                BdLog.e(e);
            }
            UbcStatisticManager.getInstance().debugException(new UbcDebugItem(UbcStatConstant.Page.AUTHOR_LIVE_ROOM, UbcStatConstant.DebugContentValue.GIFT, jSONObject), "gift_show");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GW() {
        if (this.aVr.isEmpty()) {
            this.aVq.FU();
            GY();
            return;
        }
        com.baidu.live.gift.a.c GX = GX();
        if (GX == null) {
            GW();
        } else {
            j(GX);
        }
    }

    private com.baidu.live.gift.a.c GX() {
        if (this.aVr.isEmpty()) {
            return null;
        }
        return this.aVr.remove(0);
    }

    private void GY() {
        this.aVq.FW();
    }

    private void j(com.baidu.live.gift.a.c cVar) {
        com.baidu.live.gift.c hr;
        if (cVar != null) {
            boolean z = UtilHelper.getRealScreenOrientation(this.mContext) == 2;
            if (cVar.aZB && !b(cVar, z)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 1));
                GW();
            } else if (z && cVar.aZC) {
                GW();
            } else if (this.aTY && z && !cVar.aZp) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913138, cVar));
                GW();
            } else {
                try {
                    if ((cVar.aZq != null && com.baidu.live.gift.b.b.Iv().gR(cVar.aZq.Fk())) || cVar.aZB) {
                        if (cVar.aZB) {
                            hr = com.baidu.live.entereffect.a.Ex().go(cVar.giftId).aRD;
                        } else {
                            hr = com.baidu.live.gift.b.b.Iv().hr(cVar.giftId);
                        }
                        if (a(hr, cVar)) {
                            if (cVar.aZB) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 0));
                                com.baidu.live.entereffect.a.Ex().gp(cVar.giftId);
                            } else if (hr != null && hr.aSt != null && hr.aSt.aSr != null) {
                                u.gu(hr.aSt.aSr.zipName);
                            }
                            b(hr, cVar);
                        } else if (b(hr)) {
                            if (cVar.aZB) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 0));
                                com.baidu.live.entereffect.a.Ex().gp(cVar.giftId);
                            } else if (hr != null && hr.aSt != null && hr.aSt.aSr != null) {
                                u.gu(hr.aSt.aSr.zipName);
                            }
                            c(hr, cVar);
                        } else {
                            if (cVar.aZB || cVar.aZC || cVar.aZD) {
                                GW();
                                if (cVar.aZB) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 1));
                                }
                            } else {
                                k(cVar);
                            }
                            a(hr);
                        }
                        if (cVar.aZy) {
                            LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW, cVar.chatMCastId, cVar.ensureMCastId, cVar.giftId, "");
                        }
                    } else if (cVar.aZy) {
                        LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW_FAIL, cVar.chatMCastId, cVar.ensureMCastId, cVar.giftId, "不在大礼物列表");
                    }
                } catch (OutOfMemoryError e) {
                    log(BdStatsConstant.StatsType.ERROR, "showbiggift", TiebaInitialize.LogFields.REASON, "oom");
                    TbadkCoreApplication.getInst().onAppMemoryLow();
                    System.gc();
                    if (cVar.aZy) {
                        LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW_FAIL, cVar.chatMCastId, cVar.ensureMCastId, cVar.giftId, "OOM");
                    }
                    if (this.aVt < 1) {
                        this.aVt++;
                        j(cVar);
                    } else {
                        GW();
                    }
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2913019));
            }
        }
    }

    private void a(com.baidu.live.gift.c cVar) {
        if (cVar != null && cVar.aSt != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("cartoon_id", cVar.aSt.giftId);
                String str = "portrait";
                if (cVar.aSt.aSr != null && cVar.aSt.aSr.isLandScape()) {
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
        com.baidu.live.entereffect.a.a go;
        com.baidu.live.gift.c cVar2;
        if (z || (go = com.baidu.live.entereffect.a.Ex().go(cVar.giftId)) == null || (cVar2 = go.aRD) == null) {
            return false;
        }
        return (TextUtils.isEmpty(cVar2.videoPath) && ListUtils.isEmpty(cVar2.unZipFilesPathList)) ? false : true;
    }

    private boolean a(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2) {
        boolean z = (!com.baidu.live.alphavideo.a.BC().BD() || cVar == null || cVar.aSt == null) ? false : true;
        return cVar2.aZB ? z && !TextUtils.isEmpty(cVar.ET()) : z && cVar.aSt.ES() && !TextUtils.isEmpty(cVar.ET());
    }

    private boolean b(com.baidu.live.gift.c cVar) {
        return (cVar == null || ListUtils.isEmpty(cVar.getDynamicGiftPicPathList())) ? false : true;
    }

    private void c(com.baidu.live.gift.a.c cVar, boolean z) {
        if (cVar != null) {
            g gVar = cVar.aZq;
            if (!cVar.aZB && !cVar.aZC) {
                if (cVar.aZy || cVar.aZp) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt(LogConfig.LOG_GIFT_ID, gVar.Fk());
                        jSONObject.putOpt("gift_name", gVar.Fl());
                        jSONObject.putOpt(LogConfig.LOG_GIFT_VALUE, gVar.getPrice());
                        jSONObject.putOpt("gift_num", Long.valueOf(cVar.aZw));
                        jSONObject.putOpt("is_down", Integer.valueOf(z ? 1 : 0));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", cVar.aZy ? UbcStatConstant.Page.AUTHOR_LIVE_ROOM : "liveroom", "giftplay_show").setContentExt(null, "popup", jSONObject));
                }
            }
        }
    }

    private void b(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2) {
        if (this.aVu == null) {
            this.aVu = new AlaDynamicVideoGiftLayout(this.mContext);
        }
        ViewGroup.LayoutParams layoutParams = this.aVu.getLayoutParams();
        if (!(layoutParams instanceof RelativeLayout.LayoutParams)) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        }
        this.aVq.a(this.aVu, (RelativeLayout.LayoutParams) layoutParams);
        this.aVu.setHost(this.aVq.aSp);
        this.aVu.setEnterEffectRelativeBottomMargin(this.aVy);
        this.aVu.setData(cVar, cVar2);
        this.aVu.setBigGiftCallBack(this.aVz);
        this.aVu.startAnim();
        c(cVar2, true);
    }

    private void c(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2) {
        if (this.aVv == null) {
            this.aVv = new AlaDynamicGiftLayout(this.mContext);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aVv.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        }
        this.aVq.a(this.aVv, layoutParams);
        this.aVv.setHost(this.aVq.aSp);
        this.aVv.setData(cVar, cVar2);
        this.aVv.setBigGiftCallBack(this.aVz);
        this.aVv.startAnim();
        c(cVar2, true);
    }

    private void k(com.baidu.live.gift.a.c cVar) {
        if (this.aVw == null) {
            this.aVw = new AlaDynamicGiftSmallGiftStyleView(this.mContext);
        }
        this.aVq.M(this.aVw);
        this.aVw.es(this.aVx);
        this.aVw.setData(cVar);
        this.aVw.setBigGiftCallBack(this.aVz);
        this.aVw.startAnim();
        c(cVar, false);
    }

    public boolean GZ() {
        return this.aVs;
    }

    public void Ha() {
        boolean z = false;
        if (2 == UtilHelper.getRealScreenOrientation(this.mContext)) {
            z = true;
        }
        if (this.aVu != null) {
            this.aVu.Ha();
        }
        if (this.aVv != null) {
            this.aVv.bQ(z);
        }
        if (this.aVw != null) {
            this.aVw.bQ(z);
        }
    }

    public void onDestroy() {
        this.aVt = 0;
        this.aVr.clear();
        this.aVs = false;
        if (this.aVu != null) {
            this.aVu.onDestroy();
        }
        if (this.aVv != null) {
            this.aVv.onDestroy();
        }
        if (this.aVw != null) {
            this.aVw.onDestroy();
        }
        this.mContext = null;
    }

    protected void log(Object... objArr) {
        AlaStatManager.getInstance().newDebug("alaGift", 0L, null, objArr);
    }

    public void bt(boolean z) {
        this.aTY = z;
    }

    public void dU(int i) {
        this.aVx = i;
    }

    public void dV(int i) {
        this.aVy = i;
    }
}

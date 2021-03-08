package com.baidu.live.yuyingift.biggift;

import android.app.Activity;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.stats.AlaStatManager;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.gift.v;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.util.ViewCommonUtil;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.ubc.UbcDebugItem;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.yuyingift.a.c;
import com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftLayout;
import com.baidu.live.yuyingift.dynamicgift.AlaDynamicVideoGiftLayout;
import java.util.ArrayList;
import java.util.Collections;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    private int availableHeight;
    private boolean bZA;
    private com.baidu.live.yuyingift.a bZx;
    private AlaDynamicVideoGiftLayout bZy;
    private AlaDynamicGiftLayout bZz;
    private ArrayList<com.baidu.live.yuyingift.a.c> bad;
    private boolean bae;
    private int baf;
    private ViewTreeObserver.OnGlobalLayoutListener bcd;
    private Activity mContext;
    private boolean aYA = false;
    private b bZB = new b() { // from class: com.baidu.live.yuyingift.biggift.a.2
        @Override // com.baidu.live.yuyingift.biggift.b
        public void k(com.baidu.live.yuyingift.a.c cVar) {
            a.this.bae = true;
            cVar.aS(System.currentTimeMillis());
        }

        @Override // com.baidu.live.yuyingift.biggift.b
        public void cO(int i) {
        }

        @Override // com.baidu.live.yuyingift.biggift.b
        public void l(com.baidu.live.yuyingift.a.c cVar) {
            a.this.i(cVar);
            a.this.bae = false;
            a.this.bZx.EK();
            a.this.FM();
        }
    };

    public a(Activity activity, com.baidu.live.yuyingift.a aVar) {
        this.baf = 0;
        this.mContext = activity;
        this.bZx = aVar;
        this.bad = new ArrayList<>();
        this.baf = 0;
        if (activity != null) {
            this.mContext = activity;
            this.bZx = aVar;
            this.bad = new ArrayList<>();
            this.baf = 0;
            this.bcd = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.live.yuyingift.biggift.a.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (a.this.mContext != null) {
                        Rect rect = new Rect();
                        a.this.mContext.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                        int statusBarHeight = BdUtilHelper.getStatusBarHeight(a.this.mContext);
                        int[] screenFullSize = ViewCommonUtil.getScreenFullSize(a.this.mContext);
                        boolean z = a.this.availableHeight != rect.bottom;
                        a.this.availableHeight = rect.bottom;
                        if (screenFullSize[1] - rect.bottom > screenFullSize[1] / 4 && z) {
                            a.this.dJ(true);
                        } else if (screenFullSize[1] - rect.height() <= statusBarHeight) {
                            a.this.dJ(false);
                        }
                    }
                }
            };
            this.mContext.getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.bcd);
        }
    }

    public void h(com.baidu.live.yuyingift.a.c cVar) {
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            long j = cVar.bev;
            for (int i = 0; i < j; i++) {
                com.baidu.live.yuyingift.a.c clone = cVar.clone();
                if (clone != null) {
                    if (cVar.priority == 11) {
                        this.bad.add(0, clone);
                    } else {
                        this.bad.add(clone);
                    }
                    if (clone.bey) {
                        LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_ENTER_LIST, clone.chatMCastId, clone.ensureMCastId, clone.giftId, "");
                    }
                }
            }
            try {
                FK();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void FK() {
        if (this.bad != null) {
            int i = com.baidu.live.ae.a.Qm().bwx != null ? com.baidu.live.ae.a.Qm().bwx.aOv : 0;
            if (i > 0 && this.bad.size() >= i) {
                Collections.sort(this.bad, new c.a());
                int max = Math.max((int) (i * 0.7f), 1);
                ArrayList arrayList = new ArrayList(this.bad.subList(0, max));
                while (true) {
                    int i2 = max;
                    if (i2 < this.bad.size()) {
                        if (this.bad.get(i2) == null || !this.bad.get(i2).beB) {
                            max = i2 + 1;
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2501062, 1));
                            break;
                        }
                    } else {
                        break;
                    }
                }
                this.bad.clear();
                this.bad.addAll(arrayList);
            }
        }
    }

    public void YC() {
        if (!FP()) {
            FM();
        }
    }

    public void FL() {
        if (this.bae) {
            if (this.bZy != null) {
                this.bZy.stopAnim();
            }
            if (this.bZz != null) {
                this.bZz.stopAnim();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(com.baidu.live.yuyingift.a.c cVar) {
        if (cVar != null && cVar.bey) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(LogConfig.LOG_GIFT_ID, cVar.giftId);
                jSONObject.put("gift_count", cVar.bev);
                jSONObject.put("sender_uk", EncryptionHelper.getEncryptionUserId(cVar.userId));
                jSONObject.put("show_stime", cVar.GI());
                jSONObject.put("show_ctime", System.currentTimeMillis());
                if (cVar.beF) {
                    jSONObject.put("from_recovery", 1);
                }
            } catch (JSONException e) {
                BdLog.e(e);
            }
            UbcStatisticManager.getInstance().debugException(new UbcDebugItem("author_liveroom", UbcStatConstant.DebugContentValue.GIFT, jSONObject), UbcStatConstant.ContentType.UBC_TYPE_GIFT_SHOW);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FM() {
        if (this.bad.isEmpty()) {
            this.bZx.EI();
            FO();
            return;
        }
        com.baidu.live.yuyingift.a.c YD = YD();
        if (YD == null) {
            FM();
        } else {
            j(YD);
        }
    }

    private com.baidu.live.yuyingift.a.c YD() {
        if (this.bad.isEmpty()) {
            return null;
        }
        return this.bad.remove(0);
    }

    private void FO() {
        this.bZx.EK();
    }

    private void j(com.baidu.live.yuyingift.a.c cVar) {
        com.baidu.live.gift.c gS;
        if (cVar != null) {
            boolean z = UtilHelper.getRealScreenOrientation(this.mContext) == 2;
            if (cVar.beB && !b(cVar, z)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2501062, 1));
                FM();
            } else if (z && cVar.beC) {
                FM();
            } else if (this.aYA && z && !cVar.beo) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501064, cVar));
                FM();
            } else {
                try {
                    if ((cVar.bep != null && com.baidu.live.yuyingift.b.b.Za().gm(cVar.bep.DU())) || cVar.beB) {
                        if (cVar.beB) {
                            gS = com.baidu.live.entereffect.a.CY().fJ(cVar.giftId).aVP;
                        } else {
                            gS = com.baidu.live.yuyingift.b.b.Za().gS(cVar.giftId);
                        }
                        if (a(gS, cVar)) {
                            if (cVar.beB) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2501062, 0));
                                com.baidu.live.entereffect.a.CY().fK(cVar.giftId);
                            } else if (gS != null && gS.aWS != null && gS.aWS.aWP != null) {
                                v.D(gS.aWS.aWP.zipName, gS.aWS.aWR);
                            }
                            b(gS, cVar);
                        } else if (b(gS)) {
                            if (cVar.beB) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2501062, 0));
                                com.baidu.live.entereffect.a.CY().fK(cVar.giftId);
                            } else if (gS != null && gS.aWS != null && gS.aWS.aWP != null) {
                                v.D(gS.aWS.aWP.zipName, gS.aWS.aWR);
                            }
                            c(gS, cVar);
                        } else if (cVar.beB || cVar.beC) {
                            FM();
                            if (cVar.beB) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2501062, 1));
                            }
                        }
                        if (cVar.bey) {
                            LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW, cVar.chatMCastId, cVar.ensureMCastId, cVar.giftId, "");
                        }
                    } else if (cVar.bey) {
                        LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW_FAIL, cVar.chatMCastId, cVar.ensureMCastId, cVar.giftId, "不在大礼物列表");
                    }
                } catch (OutOfMemoryError e) {
                    log(BdStatsConstant.StatsType.ERROR, "showbiggift", TiebaInitialize.LogFields.REASON, "oom");
                    TbadkCoreApplication.getInst().onAppMemoryLow();
                    System.gc();
                    if (cVar.bey) {
                        LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW_FAIL, cVar.chatMCastId, cVar.ensureMCastId, cVar.giftId, "OOM");
                    }
                    if (this.baf < 1) {
                        this.baf++;
                        j(cVar);
                    } else {
                        FM();
                    }
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2913019));
            }
        }
    }

    private boolean b(com.baidu.live.yuyingift.a.c cVar, boolean z) {
        com.baidu.live.entereffect.a.a fJ;
        com.baidu.live.gift.c cVar2;
        if (z || (fJ = com.baidu.live.entereffect.a.CY().fJ(cVar.giftId)) == null || (cVar2 = fJ.aVP) == null) {
            return false;
        }
        return (TextUtils.isEmpty(cVar2.videoPath) && ListUtils.isEmpty(cVar2.unZipFilesPathList)) ? false : true;
    }

    private boolean a(com.baidu.live.gift.c cVar, com.baidu.live.yuyingift.a.c cVar2) {
        boolean z = (!com.baidu.live.alphavideo.a.zr().zs() || cVar == null || cVar.aWS == null) ? false : true;
        return cVar2.beB ? z && !TextUtils.isEmpty(cVar.DB()) : z && cVar.aWS.Dy() && !TextUtils.isEmpty(cVar.DB());
    }

    private boolean b(com.baidu.live.gift.c cVar) {
        return (cVar == null || ListUtils.isEmpty(cVar.getDynamicGiftPicPathList())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dJ(boolean z) {
        if (this.bZA != z) {
            this.bZA = z;
            if (this.bZy != null) {
                this.bZy.setIsKeyBoadVis(this.bZA);
            } else if (this.bZz != null) {
                this.bZz.setIsKeyBoadVis(this.bZA);
            }
        }
    }

    private void b(com.baidu.live.gift.c cVar, com.baidu.live.yuyingift.a.c cVar2) {
        if (this.bZy == null) {
            this.bZy = new AlaDynamicVideoGiftLayout(this.mContext);
            this.bZy.setZ(com.baidu.live.yuyingift.a.bZs);
        }
        this.bZy.setIsKeyBoadVis(this.bZA);
        ViewGroup.LayoutParams layoutParams = this.bZy.getLayoutParams();
        if (!(layoutParams instanceof RelativeLayout.LayoutParams)) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        }
        this.bZx.a(this.bZy, (RelativeLayout.LayoutParams) layoutParams);
        this.bZy.setHost(this.bZx.aWN);
        this.bZy.setData(cVar, cVar2);
        this.bZy.setBigGiftCallBack(this.bZB);
        this.bZy.startAnim();
    }

    private void c(com.baidu.live.gift.c cVar, com.baidu.live.yuyingift.a.c cVar2) {
        if (this.bZz == null) {
            this.bZz = new AlaDynamicGiftLayout(this.mContext);
            this.bZz.setZ(com.baidu.live.yuyingift.a.bZs);
        }
        this.bZz.setIsKeyBoadVis(this.bZA);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bZz.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        }
        this.bZx.a(this.bZz, layoutParams);
        this.bZz.setData(cVar, cVar2);
        this.bZz.setBigGiftCallBack(this.bZB);
        this.bZz.startAnim();
    }

    public boolean FP() {
        return this.bae;
    }

    public void FQ() {
        boolean z = false;
        if (2 == UtilHelper.getRealScreenOrientation(this.mContext)) {
            z = true;
        }
        if (this.bZy != null) {
            this.bZy.FQ();
        }
        if (this.bZz != null) {
            this.bZz.bY(z);
        }
    }

    public void onDestroy() {
        this.baf = 0;
        this.bad.clear();
        this.bae = false;
        if (this.bZy != null) {
            this.bZy.onDestroy();
        }
        if (this.bZz != null) {
            this.bZz.onDestroy();
        }
        if (this.mContext != null) {
            this.mContext.getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.bcd);
        }
        this.mContext = null;
    }

    protected void log(Object... objArr) {
        AlaStatManager.getInstance().newDebug("alaGift", 0L, null, objArr);
    }

    public void bB(boolean z) {
        this.aYA = z;
    }
}

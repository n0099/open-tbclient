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
/* loaded from: classes11.dex */
public class a {
    private ArrayList<com.baidu.live.yuyingift.a.c> aYD;
    private boolean aYE;
    private int aYF;
    private int availableHeight;
    private com.baidu.live.yuyingift.a bXX;
    private AlaDynamicVideoGiftLayout bXY;
    private AlaDynamicGiftLayout bXZ;
    private boolean bYa;
    private ViewTreeObserver.OnGlobalLayoutListener baD;
    private Activity mContext;
    private boolean aXa = false;
    private b bYb = new b() { // from class: com.baidu.live.yuyingift.biggift.a.2
        @Override // com.baidu.live.yuyingift.biggift.b
        public void k(com.baidu.live.yuyingift.a.c cVar) {
            a.this.aYE = true;
            cVar.aS(System.currentTimeMillis());
        }

        @Override // com.baidu.live.yuyingift.biggift.b
        public void cN(int i) {
        }

        @Override // com.baidu.live.yuyingift.biggift.b
        public void l(com.baidu.live.yuyingift.a.c cVar) {
            a.this.i(cVar);
            a.this.aYE = false;
            a.this.bXX.EH();
            a.this.FJ();
        }
    };

    public a(Activity activity, com.baidu.live.yuyingift.a aVar) {
        this.aYF = 0;
        this.mContext = activity;
        this.bXX = aVar;
        this.aYD = new ArrayList<>();
        this.aYF = 0;
        if (activity != null) {
            this.mContext = activity;
            this.bXX = aVar;
            this.aYD = new ArrayList<>();
            this.aYF = 0;
            this.baD = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.live.yuyingift.biggift.a.1
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
            this.mContext.getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.baD);
        }
    }

    public void h(com.baidu.live.yuyingift.a.c cVar) {
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            long j = cVar.bcT;
            for (int i = 0; i < j; i++) {
                com.baidu.live.yuyingift.a.c clone = cVar.clone();
                if (clone != null) {
                    if (cVar.priority == 11) {
                        this.aYD.add(0, clone);
                    } else {
                        this.aYD.add(clone);
                    }
                    if (clone.bcW) {
                        LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_ENTER_LIST, clone.chatMCastId, clone.ensureMCastId, clone.giftId, "");
                    }
                }
            }
            try {
                FH();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void FH() {
        if (this.aYD != null) {
            int i = com.baidu.live.ae.a.Qj().buX != null ? com.baidu.live.ae.a.Qj().buX.aMV : 0;
            if (i > 0 && this.aYD.size() >= i) {
                Collections.sort(this.aYD, new c.a());
                int max = Math.max((int) (i * 0.7f), 1);
                ArrayList arrayList = new ArrayList(this.aYD.subList(0, max));
                while (true) {
                    int i2 = max;
                    if (i2 < this.aYD.size()) {
                        if (this.aYD.get(i2) == null || !this.aYD.get(i2).bcZ) {
                            max = i2 + 1;
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2501062, 1));
                            break;
                        }
                    } else {
                        break;
                    }
                }
                this.aYD.clear();
                this.aYD.addAll(arrayList);
            }
        }
    }

    public void Yz() {
        if (!FM()) {
            FJ();
        }
    }

    public void FI() {
        if (this.aYE) {
            if (this.bXY != null) {
                this.bXY.stopAnim();
            }
            if (this.bXZ != null) {
                this.bXZ.stopAnim();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(com.baidu.live.yuyingift.a.c cVar) {
        if (cVar != null && cVar.bcW) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(LogConfig.LOG_GIFT_ID, cVar.giftId);
                jSONObject.put("gift_count", cVar.bcT);
                jSONObject.put("sender_uk", EncryptionHelper.getEncryptionUserId(cVar.userId));
                jSONObject.put("show_stime", cVar.GF());
                jSONObject.put("show_ctime", System.currentTimeMillis());
                if (cVar.bdd) {
                    jSONObject.put("from_recovery", 1);
                }
            } catch (JSONException e) {
                BdLog.e(e);
            }
            UbcStatisticManager.getInstance().debugException(new UbcDebugItem("author_liveroom", UbcStatConstant.DebugContentValue.GIFT, jSONObject), UbcStatConstant.ContentType.UBC_TYPE_GIFT_SHOW);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FJ() {
        if (this.aYD.isEmpty()) {
            this.bXX.EF();
            FL();
            return;
        }
        com.baidu.live.yuyingift.a.c YA = YA();
        if (YA == null) {
            FJ();
        } else {
            j(YA);
        }
    }

    private com.baidu.live.yuyingift.a.c YA() {
        if (this.aYD.isEmpty()) {
            return null;
        }
        return this.aYD.remove(0);
    }

    private void FL() {
        this.bXX.EH();
    }

    private void j(com.baidu.live.yuyingift.a.c cVar) {
        com.baidu.live.gift.c gM;
        if (cVar != null) {
            boolean z = UtilHelper.getRealScreenOrientation(this.mContext) == 2;
            if (cVar.bcZ && !b(cVar, z)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2501062, 1));
                FJ();
            } else if (z && cVar.bda) {
                FJ();
            } else if (this.aXa && z && !cVar.bcN) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501064, cVar));
                FJ();
            } else {
                try {
                    if ((cVar.bcO != null && com.baidu.live.yuyingift.b.b.YX().gg(cVar.bcO.DR())) || cVar.bcZ) {
                        if (cVar.bcZ) {
                            gM = com.baidu.live.entereffect.a.CV().fD(cVar.giftId).aUp;
                        } else {
                            gM = com.baidu.live.yuyingift.b.b.YX().gM(cVar.giftId);
                        }
                        if (a(gM, cVar)) {
                            if (cVar.bcZ) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2501062, 0));
                                com.baidu.live.entereffect.a.CV().fE(cVar.giftId);
                            } else if (gM != null && gM.aVs != null && gM.aVs.aVp != null) {
                                v.D(gM.aVs.aVp.zipName, gM.aVs.aVr);
                            }
                            b(gM, cVar);
                        } else if (b(gM)) {
                            if (cVar.bcZ) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2501062, 0));
                                com.baidu.live.entereffect.a.CV().fE(cVar.giftId);
                            } else if (gM != null && gM.aVs != null && gM.aVs.aVp != null) {
                                v.D(gM.aVs.aVp.zipName, gM.aVs.aVr);
                            }
                            c(gM, cVar);
                        } else if (cVar.bcZ || cVar.bda) {
                            FJ();
                            if (cVar.bcZ) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2501062, 1));
                            }
                        }
                        if (cVar.bcW) {
                            LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW, cVar.chatMCastId, cVar.ensureMCastId, cVar.giftId, "");
                        }
                    } else if (cVar.bcW) {
                        LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW_FAIL, cVar.chatMCastId, cVar.ensureMCastId, cVar.giftId, "不在大礼物列表");
                    }
                } catch (OutOfMemoryError e) {
                    log(BdStatsConstant.StatsType.ERROR, "showbiggift", TiebaInitialize.LogFields.REASON, "oom");
                    TbadkCoreApplication.getInst().onAppMemoryLow();
                    System.gc();
                    if (cVar.bcW) {
                        LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW_FAIL, cVar.chatMCastId, cVar.ensureMCastId, cVar.giftId, "OOM");
                    }
                    if (this.aYF < 1) {
                        this.aYF++;
                        j(cVar);
                    } else {
                        FJ();
                    }
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2913019));
            }
        }
    }

    private boolean b(com.baidu.live.yuyingift.a.c cVar, boolean z) {
        com.baidu.live.entereffect.a.a fD;
        com.baidu.live.gift.c cVar2;
        if (z || (fD = com.baidu.live.entereffect.a.CV().fD(cVar.giftId)) == null || (cVar2 = fD.aUp) == null) {
            return false;
        }
        return (TextUtils.isEmpty(cVar2.videoPath) && ListUtils.isEmpty(cVar2.unZipFilesPathList)) ? false : true;
    }

    private boolean a(com.baidu.live.gift.c cVar, com.baidu.live.yuyingift.a.c cVar2) {
        boolean z = (!com.baidu.live.alphavideo.a.zo().zp() || cVar == null || cVar.aVs == null) ? false : true;
        return cVar2.bcZ ? z && !TextUtils.isEmpty(cVar.Dy()) : z && cVar.aVs.Dv() && !TextUtils.isEmpty(cVar.Dy());
    }

    private boolean b(com.baidu.live.gift.c cVar) {
        return (cVar == null || ListUtils.isEmpty(cVar.getDynamicGiftPicPathList())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dJ(boolean z) {
        if (this.bYa != z) {
            this.bYa = z;
            if (this.bXY != null) {
                this.bXY.setIsKeyBoadVis(this.bYa);
            } else if (this.bXZ != null) {
                this.bXZ.setIsKeyBoadVis(this.bYa);
            }
        }
    }

    private void b(com.baidu.live.gift.c cVar, com.baidu.live.yuyingift.a.c cVar2) {
        if (this.bXY == null) {
            this.bXY = new AlaDynamicVideoGiftLayout(this.mContext);
            this.bXY.setZ(com.baidu.live.yuyingift.a.bXS);
        }
        this.bXY.setIsKeyBoadVis(this.bYa);
        ViewGroup.LayoutParams layoutParams = this.bXY.getLayoutParams();
        if (!(layoutParams instanceof RelativeLayout.LayoutParams)) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        }
        this.bXX.a(this.bXY, (RelativeLayout.LayoutParams) layoutParams);
        this.bXY.setHost(this.bXX.aVn);
        this.bXY.setData(cVar, cVar2);
        this.bXY.setBigGiftCallBack(this.bYb);
        this.bXY.startAnim();
    }

    private void c(com.baidu.live.gift.c cVar, com.baidu.live.yuyingift.a.c cVar2) {
        if (this.bXZ == null) {
            this.bXZ = new AlaDynamicGiftLayout(this.mContext);
            this.bXZ.setZ(com.baidu.live.yuyingift.a.bXS);
        }
        this.bXZ.setIsKeyBoadVis(this.bYa);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bXZ.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        }
        this.bXX.a(this.bXZ, layoutParams);
        this.bXZ.setData(cVar, cVar2);
        this.bXZ.setBigGiftCallBack(this.bYb);
        this.bXZ.startAnim();
    }

    public boolean FM() {
        return this.aYE;
    }

    public void FN() {
        boolean z = false;
        if (2 == UtilHelper.getRealScreenOrientation(this.mContext)) {
            z = true;
        }
        if (this.bXY != null) {
            this.bXY.FN();
        }
        if (this.bXZ != null) {
            this.bXZ.bY(z);
        }
    }

    public void onDestroy() {
        this.aYF = 0;
        this.aYD.clear();
        this.aYE = false;
        if (this.bXY != null) {
            this.bXY.onDestroy();
        }
        if (this.bXZ != null) {
            this.bXZ.onDestroy();
        }
        if (this.mContext != null) {
            this.mContext.getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.baD);
        }
        this.mContext = null;
    }

    protected void log(Object... objArr) {
        AlaStatManager.getInstance().newDebug("alaGift", 0L, null, objArr);
    }

    public void bB(boolean z) {
        this.aXa = z;
    }
}

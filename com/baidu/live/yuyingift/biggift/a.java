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
    private ArrayList<com.baidu.live.yuyingift.a.c> aVv;
    private boolean aVw;
    private int aVx;
    private ViewTreeObserver.OnGlobalLayoutListener aXw;
    private int availableHeight;
    private com.baidu.live.yuyingift.a bTY;
    private AlaDynamicVideoGiftLayout bTZ;
    private AlaDynamicGiftLayout bUa;
    private boolean bUb;
    private Activity mContext;
    private boolean aTV = false;
    private b bUc = new b() { // from class: com.baidu.live.yuyingift.biggift.a.2
        @Override // com.baidu.live.yuyingift.biggift.b
        public void k(com.baidu.live.yuyingift.a.c cVar) {
            a.this.aVw = true;
            cVar.aP(System.currentTimeMillis());
        }

        @Override // com.baidu.live.yuyingift.biggift.b
        public void cI(int i) {
        }

        @Override // com.baidu.live.yuyingift.biggift.b
        public void l(com.baidu.live.yuyingift.a.c cVar) {
            a.this.i(cVar);
            a.this.aVw = false;
            a.this.bTY.Dr();
            a.this.Et();
        }
    };

    public a(Activity activity, com.baidu.live.yuyingift.a aVar) {
        this.aVx = 0;
        this.mContext = activity;
        this.bTY = aVar;
        this.aVv = new ArrayList<>();
        this.aVx = 0;
        if (activity != null) {
            this.mContext = activity;
            this.bTY = aVar;
            this.aVv = new ArrayList<>();
            this.aVx = 0;
            this.aXw = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.live.yuyingift.biggift.a.1
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
                            a.this.dB(true);
                        } else if (screenFullSize[1] - rect.height() <= statusBarHeight) {
                            a.this.dB(false);
                        }
                    }
                }
            };
            this.mContext.getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.aXw);
        }
    }

    public void h(com.baidu.live.yuyingift.a.c cVar) {
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            long j = cVar.aZM;
            for (int i = 0; i < j; i++) {
                com.baidu.live.yuyingift.a.c clone = cVar.clone();
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
            int i = com.baidu.live.af.a.OJ().bru != null ? com.baidu.live.af.a.OJ().bru.aKi : 0;
            if (i > 0 && this.aVv.size() >= i) {
                Collections.sort(this.aVv, new c.a());
                int max = Math.max((int) (i * 0.7f), 1);
                ArrayList arrayList = new ArrayList(this.aVv.subList(0, max));
                while (true) {
                    int i2 = max;
                    if (i2 < this.aVv.size()) {
                        if (this.aVv.get(i2) == null || !this.aVv.get(i2).aZS) {
                            max = i2 + 1;
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2501062, 1));
                            break;
                        }
                    } else {
                        break;
                    }
                }
                this.aVv.clear();
                this.aVv.addAll(arrayList);
            }
        }
    }

    public void WJ() {
        if (!Ew()) {
            Et();
        }
    }

    public void Es() {
        if (this.aVw) {
            if (this.bTZ != null) {
                this.bTZ.stopAnim();
            }
            if (this.bUa != null) {
                this.bUa.stopAnim();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(com.baidu.live.yuyingift.a.c cVar) {
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
            this.bTY.Dp();
            Ev();
            return;
        }
        com.baidu.live.yuyingift.a.c WK = WK();
        if (WK == null) {
            Et();
        } else {
            j(WK);
        }
    }

    private com.baidu.live.yuyingift.a.c WK() {
        if (this.aVv.isEmpty()) {
            return null;
        }
        return this.aVv.remove(0);
    }

    private void Ev() {
        this.bTY.Dr();
    }

    private void j(com.baidu.live.yuyingift.a.c cVar) {
        com.baidu.live.gift.c go;
        if (cVar != null) {
            boolean z = UtilHelper.getRealScreenOrientation(this.mContext) == 2;
            if (cVar.aZS && !b(cVar, z)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2501062, 1));
                Et();
            } else if (z && cVar.aZT) {
                Et();
            } else if (this.aTV && z && !cVar.aZG) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501064, cVar));
                Et();
            } else {
                try {
                    if ((cVar.aZH != null && com.baidu.live.yuyingift.b.b.Xh().fL(cVar.aZH.CC())) || cVar.aZS) {
                        if (cVar.aZS) {
                            go = com.baidu.live.entereffect.a.BG().fi(cVar.giftId).aRk;
                        } else {
                            go = com.baidu.live.yuyingift.b.b.Xh().go(cVar.giftId);
                        }
                        if (a(go, cVar)) {
                            if (cVar.aZS) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2501062, 0));
                                com.baidu.live.entereffect.a.BG().fj(cVar.giftId);
                            } else if (go != null && go.aSo != null && go.aSo.aSl != null) {
                                v.fn(go.aSo.aSl.zipName);
                            }
                            b(go, cVar);
                        } else if (b(go)) {
                            if (cVar.aZS) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2501062, 0));
                                com.baidu.live.entereffect.a.BG().fj(cVar.giftId);
                            } else if (go != null && go.aSo != null && go.aSo.aSl != null) {
                                v.fn(go.aSo.aSl.zipName);
                            }
                            c(go, cVar);
                        } else if (cVar.aZS || cVar.aZT) {
                            Et();
                            if (cVar.aZS) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2501062, 1));
                            }
                        }
                        if (cVar.aZP) {
                            LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW, cVar.chatMCastId, cVar.ensureMCastId, cVar.giftId, "");
                        }
                    } else if (cVar.aZP) {
                        LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW_FAIL, cVar.chatMCastId, cVar.ensureMCastId, cVar.giftId, "不在大礼物列表");
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
                        j(cVar);
                    } else {
                        Et();
                    }
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2913019));
            }
        }
    }

    private boolean b(com.baidu.live.yuyingift.a.c cVar, boolean z) {
        com.baidu.live.entereffect.a.a fi;
        com.baidu.live.gift.c cVar2;
        if (z || (fi = com.baidu.live.entereffect.a.BG().fi(cVar.giftId)) == null || (cVar2 = fi.aRk) == null) {
            return false;
        }
        return (TextUtils.isEmpty(cVar2.videoPath) && ListUtils.isEmpty(cVar2.unZipFilesPathList)) ? false : true;
    }

    private boolean a(com.baidu.live.gift.c cVar, com.baidu.live.yuyingift.a.c cVar2) {
        boolean z = (!com.baidu.live.alphavideo.a.yH().yI() || cVar == null || cVar.aSo == null) ? false : true;
        return cVar2.aZS ? z && !TextUtils.isEmpty(cVar.Cj()) : z && cVar.aSo.Cg() && !TextUtils.isEmpty(cVar.Cj());
    }

    private boolean b(com.baidu.live.gift.c cVar) {
        return (cVar == null || ListUtils.isEmpty(cVar.getDynamicGiftPicPathList())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dB(boolean z) {
        if (this.bUb != z) {
            this.bUb = z;
            if (this.bTZ != null) {
                this.bTZ.setIsKeyBoadVis(this.bUb);
            } else if (this.bUa != null) {
                this.bUa.setIsKeyBoadVis(this.bUb);
            }
        }
    }

    private void b(com.baidu.live.gift.c cVar, com.baidu.live.yuyingift.a.c cVar2) {
        if (this.bTZ == null) {
            this.bTZ = new AlaDynamicVideoGiftLayout(this.mContext);
            this.bTZ.setZ(com.baidu.live.yuyingift.a.bTT);
        }
        this.bTZ.setIsKeyBoadVis(this.bUb);
        ViewGroup.LayoutParams layoutParams = this.bTZ.getLayoutParams();
        if (!(layoutParams instanceof RelativeLayout.LayoutParams)) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        }
        this.bTY.a(this.bTZ, (RelativeLayout.LayoutParams) layoutParams);
        this.bTZ.setHost(this.bTY.aSj);
        this.bTZ.setData(cVar, cVar2);
        this.bTZ.setBigGiftCallBack(this.bUc);
        this.bTZ.startAnim();
    }

    private void c(com.baidu.live.gift.c cVar, com.baidu.live.yuyingift.a.c cVar2) {
        if (this.bUa == null) {
            this.bUa = new AlaDynamicGiftLayout(this.mContext);
            this.bUa.setZ(com.baidu.live.yuyingift.a.bTT);
        }
        this.bUa.setIsKeyBoadVis(this.bUb);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bUa.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        }
        this.bTY.a(this.bUa, layoutParams);
        this.bUa.setData(cVar, cVar2);
        this.bUa.setBigGiftCallBack(this.bUc);
        this.bUa.startAnim();
    }

    public boolean Ew() {
        return this.aVw;
    }

    public void Ex() {
        boolean z = false;
        if (2 == UtilHelper.getRealScreenOrientation(this.mContext)) {
            z = true;
        }
        if (this.bTZ != null) {
            this.bTZ.Ex();
        }
        if (this.bUa != null) {
            this.bUa.bT(z);
        }
    }

    public void onDestroy() {
        this.aVx = 0;
        this.aVv.clear();
        this.aVw = false;
        if (this.bTZ != null) {
            this.bTZ.onDestroy();
        }
        if (this.bUa != null) {
            this.bUa.onDestroy();
        }
        if (this.mContext != null) {
            this.mContext.getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.aXw);
        }
        this.mContext = null;
    }

    protected void log(Object... objArr) {
        AlaStatManager.getInstance().newDebug("alaGift", 0L, null, objArr);
    }

    public void bw(boolean z) {
        this.aTV = z;
    }
}

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
    private int availableHeight;
    private com.baidu.live.yuyingift.a bYK;
    private AlaDynamicVideoGiftLayout bYL;
    private AlaDynamicGiftLayout bYM;
    private boolean bYN;
    private ArrayList<com.baidu.live.yuyingift.a.c> bai;
    private boolean baj;
    private int bak;
    private ViewTreeObserver.OnGlobalLayoutListener bck;
    private Activity mContext;
    private boolean aYI = false;
    private b bYO = new b() { // from class: com.baidu.live.yuyingift.biggift.a.2
        @Override // com.baidu.live.yuyingift.biggift.b
        public void k(com.baidu.live.yuyingift.a.c cVar) {
            a.this.baj = true;
            cVar.aP(System.currentTimeMillis());
        }

        @Override // com.baidu.live.yuyingift.biggift.b
        public void eo(int i) {
        }

        @Override // com.baidu.live.yuyingift.biggift.b
        public void l(com.baidu.live.yuyingift.a.c cVar) {
            a.this.i(cVar);
            a.this.baj = false;
            a.this.bYK.Hm();
            a.this.Io();
        }
    };

    public a(Activity activity, com.baidu.live.yuyingift.a aVar) {
        this.bak = 0;
        this.mContext = activity;
        this.bYK = aVar;
        this.bai = new ArrayList<>();
        this.bak = 0;
        if (activity != null) {
            this.mContext = activity;
            this.bYK = aVar;
            this.bai = new ArrayList<>();
            this.bak = 0;
            this.bck = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.live.yuyingift.biggift.a.1
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
                            a.this.dF(true);
                        } else if (screenFullSize[1] - rect.height() <= statusBarHeight) {
                            a.this.dF(false);
                        }
                    }
                }
            };
            this.mContext.getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.bck);
        }
    }

    public void h(com.baidu.live.yuyingift.a.c cVar) {
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            long j = cVar.beC;
            for (int i = 0; i < j; i++) {
                com.baidu.live.yuyingift.a.c clone = cVar.clone();
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
            int i = com.baidu.live.af.a.SE().bwi != null ? com.baidu.live.af.a.SE().bwi.aOV : 0;
            if (i > 0 && this.bai.size() >= i) {
                Collections.sort(this.bai, new c.a());
                int max = Math.max((int) (i * 0.7f), 1);
                ArrayList arrayList = new ArrayList(this.bai.subList(0, max));
                while (true) {
                    int i2 = max;
                    if (i2 < this.bai.size()) {
                        if (this.bai.get(i2) == null || !this.bai.get(i2).beI) {
                            max = i2 + 1;
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2501062, 1));
                            break;
                        }
                    } else {
                        break;
                    }
                }
                this.bai.clear();
                this.bai.addAll(arrayList);
            }
        }
    }

    public void aaC() {
        if (!Ir()) {
            Io();
        }
    }

    public void In() {
        if (this.baj) {
            if (this.bYL != null) {
                this.bYL.stopAnim();
            }
            if (this.bYM != null) {
                this.bYM.stopAnim();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(com.baidu.live.yuyingift.a.c cVar) {
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
            this.bYK.Hk();
            Iq();
            return;
        }
        com.baidu.live.yuyingift.a.c aaD = aaD();
        if (aaD == null) {
            Io();
        } else {
            j(aaD);
        }
    }

    private com.baidu.live.yuyingift.a.c aaD() {
        if (this.bai.isEmpty()) {
            return null;
        }
        return this.bai.remove(0);
    }

    private void Iq() {
        this.bYK.Hm();
    }

    private void j(com.baidu.live.yuyingift.a.c cVar) {
        com.baidu.live.gift.c hA;
        if (cVar != null) {
            boolean z = UtilHelper.getRealScreenOrientation(this.mContext) == 2;
            if (cVar.beI && !b(cVar, z)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2501062, 1));
                Io();
            } else if (z && cVar.beJ) {
                Io();
            } else if (this.aYI && z && !cVar.bew) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501064, cVar));
                Io();
            } else {
                try {
                    if ((cVar.bex != null && com.baidu.live.yuyingift.b.b.aba().gX(cVar.bex.Gx())) || cVar.beI) {
                        if (cVar.beI) {
                            hA = com.baidu.live.entereffect.a.FB().gu(cVar.giftId).aVX;
                        } else {
                            hA = com.baidu.live.yuyingift.b.b.aba().hA(cVar.giftId);
                        }
                        if (a(hA, cVar)) {
                            if (cVar.beI) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2501062, 0));
                                com.baidu.live.entereffect.a.FB().gv(cVar.giftId);
                            } else if (hA != null && hA.aXb != null && hA.aXb.aWY != null) {
                                v.gz(hA.aXb.aWY.zipName);
                            }
                            b(hA, cVar);
                        } else if (b(hA)) {
                            if (cVar.beI) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2501062, 0));
                                com.baidu.live.entereffect.a.FB().gv(cVar.giftId);
                            } else if (hA != null && hA.aXb != null && hA.aXb.aWY != null) {
                                v.gz(hA.aXb.aWY.zipName);
                            }
                            c(hA, cVar);
                        } else if (cVar.beI || cVar.beJ) {
                            Io();
                            if (cVar.beI) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2501062, 1));
                            }
                        }
                        if (cVar.beF) {
                            LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW, cVar.chatMCastId, cVar.ensureMCastId, cVar.giftId, "");
                        }
                    } else if (cVar.beF) {
                        LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW_FAIL, cVar.chatMCastId, cVar.ensureMCastId, cVar.giftId, "不在大礼物列表");
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
                        j(cVar);
                    } else {
                        Io();
                    }
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2913019));
            }
        }
    }

    private boolean b(com.baidu.live.yuyingift.a.c cVar, boolean z) {
        com.baidu.live.entereffect.a.a gu;
        com.baidu.live.gift.c cVar2;
        if (z || (gu = com.baidu.live.entereffect.a.FB().gu(cVar.giftId)) == null || (cVar2 = gu.aVX) == null) {
            return false;
        }
        return (TextUtils.isEmpty(cVar2.videoPath) && ListUtils.isEmpty(cVar2.unZipFilesPathList)) ? false : true;
    }

    private boolean a(com.baidu.live.gift.c cVar, com.baidu.live.yuyingift.a.c cVar2) {
        boolean z = (!com.baidu.live.alphavideo.a.CC().CD() || cVar == null || cVar.aXb == null) ? false : true;
        return cVar2.beI ? z && !TextUtils.isEmpty(cVar.Ge()) : z && cVar.aXb.Gb() && !TextUtils.isEmpty(cVar.Ge());
    }

    private boolean b(com.baidu.live.gift.c cVar) {
        return (cVar == null || ListUtils.isEmpty(cVar.getDynamicGiftPicPathList())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dF(boolean z) {
        if (this.bYN != z) {
            this.bYN = z;
            if (this.bYL != null) {
                this.bYL.setIsKeyBoadVis(this.bYN);
            } else if (this.bYM != null) {
                this.bYM.setIsKeyBoadVis(this.bYN);
            }
        }
    }

    private void b(com.baidu.live.gift.c cVar, com.baidu.live.yuyingift.a.c cVar2) {
        if (this.bYL == null) {
            this.bYL = new AlaDynamicVideoGiftLayout(this.mContext);
            this.bYL.setZ(com.baidu.live.yuyingift.a.bYF);
        }
        this.bYL.setIsKeyBoadVis(this.bYN);
        ViewGroup.LayoutParams layoutParams = this.bYL.getLayoutParams();
        if (!(layoutParams instanceof RelativeLayout.LayoutParams)) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        }
        this.bYK.a(this.bYL, (RelativeLayout.LayoutParams) layoutParams);
        this.bYL.setHost(this.bYK.aWW);
        this.bYL.setData(cVar, cVar2);
        this.bYL.setBigGiftCallBack(this.bYO);
        this.bYL.startAnim();
    }

    private void c(com.baidu.live.gift.c cVar, com.baidu.live.yuyingift.a.c cVar2) {
        if (this.bYM == null) {
            this.bYM = new AlaDynamicGiftLayout(this.mContext);
            this.bYM.setZ(com.baidu.live.yuyingift.a.bYF);
        }
        this.bYM.setIsKeyBoadVis(this.bYN);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bYM.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        }
        this.bYK.a(this.bYM, layoutParams);
        this.bYM.setData(cVar, cVar2);
        this.bYM.setBigGiftCallBack(this.bYO);
        this.bYM.startAnim();
    }

    public boolean Ir() {
        return this.baj;
    }

    public void Is() {
        boolean z = false;
        if (2 == UtilHelper.getRealScreenOrientation(this.mContext)) {
            z = true;
        }
        if (this.bYL != null) {
            this.bYL.Is();
        }
        if (this.bYM != null) {
            this.bYM.bX(z);
        }
    }

    public void onDestroy() {
        this.bak = 0;
        this.bai.clear();
        this.baj = false;
        if (this.bYL != null) {
            this.bYL.onDestroy();
        }
        if (this.bYM != null) {
            this.bYM.onDestroy();
        }
        if (this.mContext != null) {
            this.mContext.getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.bck);
        }
        this.mContext = null;
    }

    protected void log(Object... objArr) {
        AlaStatManager.getInstance().newDebug("alaGift", 0L, null, objArr);
    }

    public void bA(boolean z) {
        this.aYI = z;
    }
}

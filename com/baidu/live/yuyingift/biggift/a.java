package com.baidu.live.yuyingift.biggift;

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
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.yuyingift.a.c;
import com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftLayout;
import com.baidu.live.yuyingift.dynamicgift.AlaDynamicGiftSmallGiftStyleView;
import com.baidu.live.yuyingift.dynamicgift.AlaDynamicVideoGiftLayout;
import java.util.ArrayList;
import java.util.Collections;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    private boolean aVL;
    private int aVM;
    private com.baidu.live.yuyingift.a bJY;
    private AlaDynamicVideoGiftLayout bJZ;
    private AlaDynamicGiftLayout bKa;
    private AlaDynamicGiftSmallGiftStyleView bKb;
    private Context mContext;
    private boolean aUr = false;
    private b bKc = new b() { // from class: com.baidu.live.yuyingift.biggift.a.1
        @Override // com.baidu.live.yuyingift.biggift.b
        public void l(com.baidu.live.yuyingift.a.c cVar) {
            a.this.aVL = true;
            cVar.ag(System.currentTimeMillis());
        }

        @Override // com.baidu.live.yuyingift.biggift.b
        public void ea(int i) {
        }

        @Override // com.baidu.live.yuyingift.biggift.b
        public void m(com.baidu.live.yuyingift.a.c cVar) {
            a.this.i(cVar);
            a.this.aVL = false;
            a.this.bJY.Ge();
            a.this.He();
        }
    };
    private ArrayList<com.baidu.live.yuyingift.a.c> aVK = new ArrayList<>();

    public a(Context context, com.baidu.live.yuyingift.a aVar) {
        this.aVM = 0;
        this.mContext = context;
        this.bJY = aVar;
        this.aVM = 0;
    }

    public void h(com.baidu.live.yuyingift.a.c cVar) {
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            long j = cVar.aZP;
            for (int i = 0; i < j; i++) {
                com.baidu.live.yuyingift.a.c clone = cVar.clone();
                if (clone != null) {
                    if (cVar.priority == 11) {
                        this.aVK.add(0, clone);
                    } else {
                        this.aVK.add(clone);
                    }
                    if (clone.aZR) {
                        LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_ENTER_LIST, clone.chatMCastId, clone.ensureMCastId, clone.giftId, "");
                    }
                }
            }
            try {
                Hb();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void Hb() {
        if (this.aVK != null) {
            int i = com.baidu.live.z.a.Pq().bmJ != null ? com.baidu.live.z.a.Pq().bmJ.aMe : 0;
            if (i > 0 && this.aVK.size() >= i) {
                Collections.sort(this.aVK, new c.a());
                int max = Math.max((int) (i * 0.7f), 1);
                ArrayList arrayList = new ArrayList(this.aVK.subList(0, max));
                while (true) {
                    int i2 = max;
                    if (i2 < this.aVK.size()) {
                        if (this.aVK.get(i2) == null || !this.aVK.get(i2).aZU) {
                            max = i2 + 1;
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2501062, 1));
                            break;
                        }
                    } else {
                        break;
                    }
                }
                this.aVK.clear();
                this.aVK.addAll(arrayList);
            }
        }
    }

    public void Hc() {
        if (!Hh()) {
            He();
        }
    }

    public void Hd() {
        if (this.aVL) {
            if (this.bJZ != null) {
                this.bJZ.stopAnim();
            }
            if (this.bKa != null) {
                this.bKa.stopAnim();
            }
            if (this.bKb != null) {
                this.bKb.stopAnim();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(com.baidu.live.yuyingift.a.c cVar) {
        if (cVar != null && cVar.aZR) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(LogConfig.LOG_GIFT_ID, cVar.giftId);
                jSONObject.put("gift_count", cVar.aZP);
                jSONObject.put("sender_uk", EncryptionHelper.getEncryptionUserId(cVar.userId));
                jSONObject.put("show_stime", cVar.HZ());
                jSONObject.put("show_ctime", System.currentTimeMillis());
                if (cVar.aZY) {
                    jSONObject.put("from_recovery", 1);
                }
            } catch (JSONException e) {
                BdLog.e(e);
            }
            UbcStatisticManager.getInstance().debugException(new UbcDebugItem(UbcStatConstant.Page.AUTHOR_LIVE_ROOM, UbcStatConstant.DebugContentValue.GIFT, jSONObject), "gift_show");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void He() {
        if (this.aVK.isEmpty()) {
            this.bJY.Gc();
            Hg();
            return;
        }
        com.baidu.live.yuyingift.a.c UY = UY();
        if (UY == null) {
            He();
        } else {
            j(UY);
        }
    }

    private com.baidu.live.yuyingift.a.c UY() {
        if (this.aVK.isEmpty()) {
            return null;
        }
        return this.aVK.remove(0);
    }

    private void Hg() {
        this.bJY.Ge();
    }

    private void j(com.baidu.live.yuyingift.a.c cVar) {
        com.baidu.live.gift.c hq;
        if (cVar != null) {
            boolean z = UtilHelper.getRealScreenOrientation(this.mContext) == 2;
            if (cVar.aZU && !b(cVar, z)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2501062, 1));
                He();
            } else if (z && cVar.aZV) {
                He();
            } else if (this.aUr && z && !cVar.aZI) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501064, cVar));
                He();
            } else {
                try {
                    if ((cVar.aZJ != null && com.baidu.live.yuyingift.b.b.Vf().gS(cVar.aZJ.Fs())) || cVar.aZU) {
                        if (cVar.aZU) {
                            hq = com.baidu.live.entereffect.a.EF().gp(cVar.giftId).aRW;
                        } else {
                            hq = com.baidu.live.yuyingift.b.b.Vf().hq(cVar.giftId);
                        }
                        if (a(hq, cVar)) {
                            if (cVar.aZU) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2501062, 0));
                                com.baidu.live.entereffect.a.EF().gq(cVar.giftId);
                            } else if (hq != null && hq.aSL != null && hq.aSL.aSJ != null) {
                                v.gv(hq.aSL.aSJ.zipName);
                            }
                            b(hq, cVar);
                        } else if (b(hq)) {
                            if (cVar.aZU) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2501062, 0));
                                com.baidu.live.entereffect.a.EF().gq(cVar.giftId);
                            } else if (hq != null && hq.aSL != null && hq.aSL.aSJ != null) {
                                v.gv(hq.aSL.aSJ.zipName);
                            }
                            c(hq, cVar);
                        } else if (cVar.aZU || cVar.aZV) {
                            He();
                            if (cVar.aZU) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2501062, 1));
                            }
                        } else {
                            k(cVar);
                        }
                        if (cVar.aZR) {
                            LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW, cVar.chatMCastId, cVar.ensureMCastId, cVar.giftId, "");
                        }
                    } else if (cVar.aZR) {
                        LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW_FAIL, cVar.chatMCastId, cVar.ensureMCastId, cVar.giftId, "不在大礼物列表");
                    }
                } catch (OutOfMemoryError e) {
                    log(BdStatsConstant.StatsType.ERROR, "showbiggift", TiebaInitialize.LogFields.REASON, "oom");
                    TbadkCoreApplication.getInst().onAppMemoryLow();
                    System.gc();
                    if (cVar.aZR) {
                        LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW_FAIL, cVar.chatMCastId, cVar.ensureMCastId, cVar.giftId, "OOM");
                    }
                    if (this.aVM < 1) {
                        this.aVM++;
                        j(cVar);
                    } else {
                        He();
                    }
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2913019));
            }
        }
    }

    private boolean b(com.baidu.live.yuyingift.a.c cVar, boolean z) {
        com.baidu.live.entereffect.a.a gp;
        com.baidu.live.gift.c cVar2;
        if (z || (gp = com.baidu.live.entereffect.a.EF().gp(cVar.giftId)) == null || (cVar2 = gp.aRW) == null) {
            return false;
        }
        return (TextUtils.isEmpty(cVar2.videoPath) && ListUtils.isEmpty(cVar2.unZipFilesPathList)) ? false : true;
    }

    private boolean a(com.baidu.live.gift.c cVar, com.baidu.live.yuyingift.a.c cVar2) {
        boolean z = (!com.baidu.live.alphavideo.a.BT().BU() || cVar == null || cVar.aSL == null) ? false : true;
        return cVar2.aZU ? z && !TextUtils.isEmpty(cVar.Fb()) : z && cVar.aSL.Fa() && !TextUtils.isEmpty(cVar.Fb());
    }

    private boolean b(com.baidu.live.gift.c cVar) {
        return (cVar == null || ListUtils.isEmpty(cVar.getDynamicGiftPicPathList())) ? false : true;
    }

    private void b(com.baidu.live.gift.c cVar, com.baidu.live.yuyingift.a.c cVar2) {
        if (this.bJZ == null) {
            this.bJZ = new AlaDynamicVideoGiftLayout(this.mContext);
        }
        ViewGroup.LayoutParams layoutParams = this.bJZ.getLayoutParams();
        if (!(layoutParams instanceof RelativeLayout.LayoutParams)) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        }
        this.bJY.a(this.bJZ, (RelativeLayout.LayoutParams) layoutParams);
        this.bJZ.setHost(this.bJY.aSH);
        this.bJZ.setData(cVar, cVar2);
        this.bJZ.setBigGiftCallBack(this.bKc);
        this.bJZ.startAnim();
    }

    private void c(com.baidu.live.gift.c cVar, com.baidu.live.yuyingift.a.c cVar2) {
        if (this.bKa == null) {
            this.bKa = new AlaDynamicGiftLayout(this.mContext);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bKa.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        }
        this.bJY.a(this.bKa, layoutParams);
        this.bKa.setData(cVar, cVar2);
        this.bKa.setBigGiftCallBack(this.bKc);
        this.bKa.startAnim();
    }

    private void k(com.baidu.live.yuyingift.a.c cVar) {
        if (this.bKb == null) {
            this.bKb = new AlaDynamicGiftSmallGiftStyleView(this.mContext);
        }
        this.bJY.M(this.bKb);
        this.bKb.setData(cVar);
        this.bKb.setBigGiftCallBack(this.bKc);
        this.bKb.startAnim();
    }

    public boolean Hh() {
        return this.aVL;
    }

    public void Hi() {
        boolean z = false;
        if (2 == UtilHelper.getRealScreenOrientation(this.mContext)) {
            z = true;
        }
        if (this.bJZ != null) {
            this.bJZ.Hi();
        }
        if (this.bKa != null) {
            this.bKa.bN(z);
        }
        if (this.bKb != null) {
            this.bKb.bN(z);
        }
    }

    public void onDestroy() {
        this.aVM = 0;
        this.aVK.clear();
        this.aVL = false;
        if (this.bJZ != null) {
            this.bJZ.onDestroy();
        }
        if (this.bKa != null) {
            this.bKa.onDestroy();
        }
        if (this.bKb != null) {
            this.bKb.onDestroy();
        }
        this.mContext = null;
    }

    protected void log(Object... objArr) {
        AlaStatManager.getInstance().newDebug("alaGift", 0L, null, objArr);
    }

    public void bq(boolean z) {
        this.aUr = z;
    }
}

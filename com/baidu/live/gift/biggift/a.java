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
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import java.util.ArrayList;
import java.util.Collections;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    private k aIs;
    private boolean aIu;
    private int aIv;
    private AlaDynamicVideoGiftLayout aIw;
    private AlaDynamicGiftLayout aIx;
    private AlaDynamicGiftSmallGiftStyleView aIy;
    private Context mContext;
    private boolean aHD = false;
    private b aIz = new b() { // from class: com.baidu.live.gift.biggift.a.1
        @Override // com.baidu.live.gift.biggift.b
        public void l(com.baidu.live.gift.a.c cVar) {
            a.this.aIu = true;
            cVar.ad(System.currentTimeMillis());
        }

        @Override // com.baidu.live.gift.biggift.b
        public void bV(int i) {
        }

        @Override // com.baidu.live.gift.biggift.b
        public void m(com.baidu.live.gift.a.c cVar) {
            a.this.i(cVar);
            a.this.aIu = false;
            a.this.aIs.yx();
            a.this.zh();
        }
    };
    private ArrayList<com.baidu.live.gift.a.c> aIt = new ArrayList<>();

    public a(Context context, k kVar) {
        this.aIv = 0;
        this.mContext = context;
        this.aIs = kVar;
        this.aIv = 0;
    }

    public void h(com.baidu.live.gift.a.c cVar) {
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            long j = cVar.aMm;
            cVar.aMm = 1L;
            for (int i = 0; i < j; i++) {
                com.baidu.live.gift.a.c clone = cVar.clone();
                if (clone != null) {
                    if (cVar.priority == 11) {
                        this.aIt.add(0, clone);
                    } else {
                        this.aIt.add(clone);
                    }
                    if (clone.aMo) {
                        LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_ENTER_LIST, clone.axB, clone.axC, clone.giftId, "");
                    }
                }
            }
            try {
                ze();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void ze() {
        if (this.aIt != null) {
            int i = com.baidu.live.v.a.Hm().aZp != null ? com.baidu.live.v.a.Hm().aZp.aAG : 0;
            if (i > 0 && this.aIt.size() >= i) {
                Collections.sort(this.aIt, new c.a());
                int max = Math.max((int) (i * 0.7f), 1);
                ArrayList arrayList = new ArrayList(this.aIt.subList(0, max));
                while (true) {
                    int i2 = max;
                    if (i2 < this.aIt.size()) {
                        if (this.aIt.get(i2) == null || !this.aIt.get(i2).aMr) {
                            max = i2 + 1;
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 1));
                            break;
                        }
                    } else {
                        break;
                    }
                }
                this.aIt.clear();
                this.aIt.addAll(arrayList);
            }
        }
    }

    public void zf() {
        if (!zk()) {
            zh();
        }
    }

    public void zg() {
        if (this.aIu) {
            if (this.aIw != null) {
                this.aIw.stopAnim();
            }
            if (this.aIx != null) {
                this.aIx.stopAnim();
            }
            if (this.aIy != null) {
                this.aIy.stopAnim();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(com.baidu.live.gift.a.c cVar) {
        if (cVar != null && cVar.aMo) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(LogConfig.LOG_GIFT_ID, cVar.giftId);
                jSONObject.put("gift_count", cVar.aMm);
                jSONObject.put("sender_uk", EncryptionHelper.getEncryptionUserId(cVar.userId));
                jSONObject.put("show_stime", cVar.Ad());
                jSONObject.put("show_ctime", System.currentTimeMillis());
                if (cVar.aMt) {
                    jSONObject.put("from_recovery", 1);
                }
            } catch (JSONException e) {
                BdLog.e(e);
            }
            UbcStatisticManager.getInstance().debugException(new UbcDebugItem(UbcStatConstant.Page.AUTHOR_LIVE_ROOM, UbcStatConstant.DebugContentValue.GIFT, jSONObject), "gift_show");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zh() {
        if (this.aIt.isEmpty()) {
            this.aIs.yv();
            zj();
            return;
        }
        com.baidu.live.gift.a.c zi = zi();
        if (zi == null) {
            zh();
        } else {
            j(zi);
        }
    }

    private com.baidu.live.gift.a.c zi() {
        if (this.aIt.isEmpty()) {
            return null;
        }
        return this.aIt.remove(0);
    }

    private void zj() {
        this.aIs.yx();
    }

    private void j(com.baidu.live.gift.a.c cVar) {
        com.baidu.live.gift.c fo;
        if (cVar != null) {
            boolean z = UtilHelper.getRealScreenOrientation(this.mContext) == 2;
            if (cVar.aMr && !b(cVar, z)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 1));
                zh();
            } else if (z && cVar.aMs) {
                zh();
            } else if (this.aHD && z && !cVar.aMh) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913138, cVar));
                zh();
            } else {
                try {
                    if ((cVar.aMi != null && com.baidu.live.gift.b.b.AH().eR(cVar.aMi.xM())) || cVar.aMr) {
                        if (cVar.aMr) {
                            fo = com.baidu.live.entereffect.a.xa().eB(cVar.giftId).aFw;
                        } else {
                            fo = com.baidu.live.gift.b.b.AH().fo(cVar.giftId);
                        }
                        if (a(fo, cVar)) {
                            b(fo, cVar);
                            if (cVar.aMr) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 0));
                            }
                        } else if (a(fo)) {
                            c(fo, cVar);
                            if (cVar.aMr) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 0));
                            }
                        } else if (cVar.aMr || cVar.aMs) {
                            zh();
                            if (cVar.aMr) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2913109, 1));
                            }
                        } else {
                            k(cVar);
                        }
                        if (cVar.aMo) {
                            LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW, cVar.axB, cVar.axC, cVar.giftId, "");
                        }
                    } else if (cVar.aMo) {
                        LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW_FAIL, cVar.axB, cVar.axC, cVar.giftId, "不在大礼物列表");
                    }
                } catch (OutOfMemoryError e) {
                    log(BdStatsConstant.StatsType.ERROR, "showbiggift", TiebaInitialize.LogFields.REASON, "oom");
                    TbadkCoreApplication.getInst().onAppMemoryLow();
                    System.gc();
                    if (cVar.aMo) {
                        LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_SHOW_FAIL, cVar.axB, cVar.axC, cVar.giftId, "OOM");
                    }
                    if (this.aIv < 1) {
                        this.aIv++;
                        j(cVar);
                    } else {
                        zh();
                    }
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2913019));
            }
        }
    }

    private boolean b(com.baidu.live.gift.a.c cVar, boolean z) {
        com.baidu.live.entereffect.a.a eB;
        com.baidu.live.gift.c cVar2;
        if (z || (eB = com.baidu.live.entereffect.a.xa().eB(cVar.giftId)) == null || (cVar2 = eB.aFw) == null) {
            return false;
        }
        return (TextUtils.isEmpty(cVar2.videoPath) && ListUtils.isEmpty(cVar2.unZipFilesPathList)) ? false : true;
    }

    private boolean a(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2) {
        boolean z = (!com.baidu.live.alphavideo.a.vj().vk() || cVar == null || cVar.aGg == null) ? false : true;
        return cVar2.aMr ? z && !TextUtils.isEmpty(cVar.xv()) : z && cVar.aGg.xs() && !TextUtils.isEmpty(cVar.xv());
    }

    private boolean a(com.baidu.live.gift.c cVar) {
        return (cVar == null || ListUtils.isEmpty(cVar.getDynamicGiftPicPathList())) ? false : true;
    }

    private void b(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2) {
        if (this.aIw == null) {
            this.aIw = new AlaDynamicVideoGiftLayout(this.mContext);
        }
        ViewGroup.LayoutParams layoutParams = this.aIw.getLayoutParams();
        if (!(layoutParams instanceof RelativeLayout.LayoutParams)) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        }
        this.aIs.a(this.aIw, (RelativeLayout.LayoutParams) layoutParams);
        this.aIw.setHost(this.aIs.aGc);
        this.aIw.setData(cVar, cVar2);
        this.aIw.setBigGiftCallBack(this.aIz);
        this.aIw.startAnim();
    }

    private void c(com.baidu.live.gift.c cVar, com.baidu.live.gift.a.c cVar2) {
        if (this.aIx == null) {
            this.aIx = new AlaDynamicGiftLayout(this.mContext);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aIx.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        }
        this.aIs.a(this.aIx, layoutParams);
        this.aIx.setData(cVar, cVar2);
        this.aIx.setBigGiftCallBack(this.aIz);
        this.aIx.startAnim();
    }

    private void k(com.baidu.live.gift.a.c cVar) {
        if (this.aIy == null) {
            this.aIy = new AlaDynamicGiftSmallGiftStyleView(this.mContext);
        }
        this.aIs.J(this.aIy);
        this.aIy.setData(cVar);
        this.aIy.setBigGiftCallBack(this.aIz);
        this.aIy.startAnim();
    }

    public boolean zk() {
        return this.aIu;
    }

    public void zl() {
        boolean z = false;
        if (2 == UtilHelper.getRealScreenOrientation(this.mContext)) {
            z = true;
        }
        if (this.aIw != null) {
            this.aIw.zl();
        }
        if (this.aIx != null) {
            this.aIx.by(z);
        }
        if (this.aIy != null) {
            this.aIy.by(z);
        }
    }

    public void onDestroy() {
        this.aIv = 0;
        this.aIt.clear();
        this.aIu = false;
        if (this.aIw != null) {
            this.aIw.onDestroy();
        }
        if (this.aIx != null) {
            this.aIx.onDestroy();
        }
        if (this.aIy != null) {
            this.aIy.onDestroy();
        }
        this.mContext = null;
    }

    protected void log(Object... objArr) {
        AlaStatManager.getInstance().newDebug("alaGift", 0L, null, objArr);
    }

    public void bc(boolean z) {
        this.aHD = z;
    }
}

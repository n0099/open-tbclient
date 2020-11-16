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
    private boolean aVs;
    private int aVt;
    private com.baidu.live.yuyingift.a bNU;
    private AlaDynamicVideoGiftLayout bNV;
    private AlaDynamicGiftLayout bNW;
    private AlaDynamicGiftSmallGiftStyleView bNX;
    private Context mContext;
    private boolean aTY = false;
    private b bNY = new b() { // from class: com.baidu.live.yuyingift.biggift.a.1
        @Override // com.baidu.live.yuyingift.biggift.b
        public void l(com.baidu.live.yuyingift.a.c cVar) {
            a.this.aVs = true;
            cVar.as(System.currentTimeMillis());
        }

        @Override // com.baidu.live.yuyingift.biggift.b
        public void dW(int i) {
        }

        @Override // com.baidu.live.yuyingift.biggift.b
        public void m(com.baidu.live.yuyingift.a.c cVar) {
            a.this.i(cVar);
            a.this.aVs = false;
            a.this.bNU.FW();
            a.this.GW();
        }
    };
    private ArrayList<com.baidu.live.yuyingift.a.c> aVr = new ArrayList<>();

    public a(Context context, com.baidu.live.yuyingift.a aVar) {
        this.aVt = 0;
        this.mContext = context;
        this.bNU = aVar;
        this.aVt = 0;
    }

    public void h(com.baidu.live.yuyingift.a.c cVar) {
        if (cVar != null && !StringUtils.isNull(cVar.userId) && !StringUtils.isNull(cVar.giftId)) {
            long j = cVar.aZw;
            for (int i = 0; i < j; i++) {
                com.baidu.live.yuyingift.a.c clone = cVar.clone();
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
            int i = com.baidu.live.aa.a.Ph().bms != null ? com.baidu.live.aa.a.Ph().bms.aLt : 0;
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
                            MessageManager.getInstance().sendMessage(new CustomMessage(2501062, 1));
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
            if (this.bNV != null) {
                this.bNV.stopAnim();
            }
            if (this.bNW != null) {
                this.bNW.stopAnim();
            }
            if (this.bNX != null) {
                this.bNX.stopAnim();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(com.baidu.live.yuyingift.a.c cVar) {
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
            this.bNU.FU();
            GY();
            return;
        }
        com.baidu.live.yuyingift.a.c WO = WO();
        if (WO == null) {
            GW();
        } else {
            j(WO);
        }
    }

    private com.baidu.live.yuyingift.a.c WO() {
        if (this.aVr.isEmpty()) {
            return null;
        }
        return this.aVr.remove(0);
    }

    private void GY() {
        this.bNU.FW();
    }

    private void j(com.baidu.live.yuyingift.a.c cVar) {
        com.baidu.live.gift.c hr;
        if (cVar != null) {
            boolean z = UtilHelper.getRealScreenOrientation(this.mContext) == 2;
            if (cVar.aZB && !b(cVar, z)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2501062, 1));
                GW();
            } else if (z && cVar.aZC) {
                GW();
            } else if (this.aTY && z && !cVar.aZp) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501064, cVar));
                GW();
            } else {
                try {
                    if ((cVar.aZq != null && com.baidu.live.yuyingift.b.b.WV().gR(cVar.aZq.Fk())) || cVar.aZB) {
                        if (cVar.aZB) {
                            hr = com.baidu.live.entereffect.a.Ex().go(cVar.giftId).aRD;
                        } else {
                            hr = com.baidu.live.yuyingift.b.b.WV().hr(cVar.giftId);
                        }
                        if (a(hr, cVar)) {
                            if (cVar.aZB) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2501062, 0));
                                com.baidu.live.entereffect.a.Ex().gp(cVar.giftId);
                            } else if (hr != null && hr.aSt != null && hr.aSt.aSr != null) {
                                u.gu(hr.aSt.aSr.zipName);
                            }
                            b(hr, cVar);
                        } else if (b(hr)) {
                            if (cVar.aZB) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2501062, 0));
                                com.baidu.live.entereffect.a.Ex().gp(cVar.giftId);
                            } else if (hr != null && hr.aSt != null && hr.aSt.aSr != null) {
                                u.gu(hr.aSt.aSr.zipName);
                            }
                            c(hr, cVar);
                        } else if (cVar.aZB || cVar.aZC) {
                            GW();
                            if (cVar.aZB) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2501062, 1));
                            }
                        } else {
                            k(cVar);
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

    private boolean b(com.baidu.live.yuyingift.a.c cVar, boolean z) {
        com.baidu.live.entereffect.a.a go;
        com.baidu.live.gift.c cVar2;
        if (z || (go = com.baidu.live.entereffect.a.Ex().go(cVar.giftId)) == null || (cVar2 = go.aRD) == null) {
            return false;
        }
        return (TextUtils.isEmpty(cVar2.videoPath) && ListUtils.isEmpty(cVar2.unZipFilesPathList)) ? false : true;
    }

    private boolean a(com.baidu.live.gift.c cVar, com.baidu.live.yuyingift.a.c cVar2) {
        boolean z = (!com.baidu.live.alphavideo.a.BC().BD() || cVar == null || cVar.aSt == null) ? false : true;
        return cVar2.aZB ? z && !TextUtils.isEmpty(cVar.ET()) : z && cVar.aSt.ES() && !TextUtils.isEmpty(cVar.ET());
    }

    private boolean b(com.baidu.live.gift.c cVar) {
        return (cVar == null || ListUtils.isEmpty(cVar.getDynamicGiftPicPathList())) ? false : true;
    }

    private void b(com.baidu.live.gift.c cVar, com.baidu.live.yuyingift.a.c cVar2) {
        if (this.bNV == null) {
            this.bNV = new AlaDynamicVideoGiftLayout(this.mContext);
        }
        ViewGroup.LayoutParams layoutParams = this.bNV.getLayoutParams();
        if (!(layoutParams instanceof RelativeLayout.LayoutParams)) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        }
        this.bNU.a(this.bNV, (RelativeLayout.LayoutParams) layoutParams);
        this.bNV.setHost(this.bNU.aSp);
        this.bNV.setData(cVar, cVar2);
        this.bNV.setBigGiftCallBack(this.bNY);
        this.bNV.startAnim();
    }

    private void c(com.baidu.live.gift.c cVar, com.baidu.live.yuyingift.a.c cVar2) {
        if (this.bNW == null) {
            this.bNW = new AlaDynamicGiftLayout(this.mContext);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bNW.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        }
        this.bNU.a(this.bNW, layoutParams);
        this.bNW.setData(cVar, cVar2);
        this.bNW.setBigGiftCallBack(this.bNY);
        this.bNW.startAnim();
    }

    private void k(com.baidu.live.yuyingift.a.c cVar) {
        if (this.bNX == null) {
            this.bNX = new AlaDynamicGiftSmallGiftStyleView(this.mContext);
        }
        this.bNU.M(this.bNX);
        this.bNX.setData(cVar);
        this.bNX.setBigGiftCallBack(this.bNY);
        this.bNX.startAnim();
    }

    public boolean GZ() {
        return this.aVs;
    }

    public void Ha() {
        boolean z = false;
        if (2 == UtilHelper.getRealScreenOrientation(this.mContext)) {
            z = true;
        }
        if (this.bNV != null) {
            this.bNV.Ha();
        }
        if (this.bNW != null) {
            this.bNW.bQ(z);
        }
        if (this.bNX != null) {
            this.bNX.bQ(z);
        }
    }

    public void onDestroy() {
        this.aVt = 0;
        this.aVr.clear();
        this.aVs = false;
        if (this.bNV != null) {
            this.bNV.onDestroy();
        }
        if (this.bNW != null) {
            this.bNW.onDestroy();
        }
        if (this.bNX != null) {
            this.bNX.onDestroy();
        }
        this.mContext = null;
    }

    protected void log(Object... objArr) {
        AlaStatManager.getInstance().newDebug("alaGift", 0L, null, objArr);
    }

    public void bt(boolean z) {
        this.aTY = z;
    }
}

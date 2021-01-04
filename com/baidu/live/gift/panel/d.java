package com.baidu.live.gift.panel;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.aa;
import com.baidu.live.data.i;
import com.baidu.live.data.k;
import com.baidu.live.gift.container.e;
import com.baidu.live.gift.g;
import com.baidu.live.gift.h;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d extends c {
    private CustomMessageListener bdN;
    private com.baidu.live.gift.container.e bix;
    private CustomMessageListener biy;
    private long biv = 0;
    private long biw = 0;
    private e.a bcF = new e.a() { // from class: com.baidu.live.gift.panel.d.3
        @Override // com.baidu.live.gift.container.e.a
        public void b(int i, String str, boolean z, ArrayList<h> arrayList, ArrayList<i> arrayList2, ArrayList<k> arrayList3, aa aaVar) {
            if (i != 0 && !StringUtils.isNull(str)) {
                BdUtilHelper.showToast(TbadkCoreApplication.getInst(), str);
            }
            d.this.bir.a(z, arrayList, arrayList2, arrayList3, i == 0, i);
            d.this.bir.b(aaVar);
        }
    };

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInflate(View view, Bundle bundle) {
        super.onInflate(view, bundle);
        this.bir.setType(0);
        this.bir.bda.setText("赠送");
    }

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInitial() {
        super.onInitial();
        this.biv = TbadkCoreApplication.getInst().currentAccountTdouNum;
        this.biw = TbadkCoreApplication.getInst().currentAccountFlowerNum;
        KJ();
        KK();
        this.bix = new com.baidu.live.gift.container.e(getPageContext(), this.bie.beV);
        this.bix.a(this.bcF);
        this.bix.ho(this.bie.beU);
    }

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.biy);
        MessageManager.getInstance().unRegisterListener(this.bdN);
    }

    private boolean b(g gVar) {
        if (com.baidu.live.af.a.SE().bCb != null && com.baidu.live.af.a.SE().bCb.aRA != null) {
            String str = com.baidu.live.af.a.SE().bCb.aRA.aQR;
            if (!TextUtils.isEmpty(str) && str.equals(String.valueOf(gVar.GV()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.live.gift.panel.c
    protected boolean KG() {
        g Jc = this.bir.Jc();
        if (Jc == null) {
            BdUtilHelper.showToast(TbadkCoreApplication.getInst(), "请先选择一个礼物");
            return false;
        }
        int Jd = this.bir.Jd();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("gift_num", Integer.valueOf(Jd));
            jSONObject.putOpt(LogConfig.LOG_GIFT_ID, Jc.Gx());
            jSONObject.putOpt("gift_name", Jc.Gy());
            jSONObject.putOpt(LogConfig.LOG_GIFT_VALUE, Jc.getPrice());
            jSONObject.putOpt("gift_type", Integer.valueOf(Jc.GV()));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "giftsend_clk").setContentExt(null, "popup", jSONObject));
        if (b(Jc) && !this.bcJ) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913179));
            return false;
        }
        int i = this.bie.bbl;
        if (Jc.Ha()) {
            if (Jc.GV() == 6 && i < 3) {
                return false;
            }
            if (Jc.GV() == 7 && i < 7) {
                return false;
            }
            if (Jc.GV() == 8 && i < 13) {
                return false;
            }
            if (Jc.GV() == 9 && i < 22) {
                return false;
            }
            if (Jc.GV() == 10 && i < 29) {
                return false;
            }
            if (Jc.GV() == 11 && i < 39) {
                return false;
            }
            if (Jc.GV() == 12 && i < 47) {
                return false;
            }
        }
        if (a(Jc, Jd)) {
            if (Jc.GG()) {
                if (this.biv <= 0 || this.biv < JavaTypesHelper.toLong(Jc.getPrice(), 0L) * Jd) {
                    KC();
                    return false;
                }
                Jc.aXM = this.bis != null ? this.bis.IF() : null;
                if (Jc.aXM == null) {
                    return false;
                }
                this.biv -= JavaTypesHelper.toLong(Jc.getPrice(), 0L) * Jd;
                this.bir.aN(this.biv);
                Jc.aXM.aYS = Jc.GC();
                com.baidu.live.gift.c.b.JW().b(Jc, Jd, this.bie.mUserId, this.bie.mUserName, this.bie.mLiveId, this.bie.mRoomId, this.bie.mAppId, this.bie.beS, this.bie.otherParams, 0L);
                closeActivity();
            } else if (Jc.GJ()) {
                if (this.biw <= 0 || this.biw < JavaTypesHelper.toLong(Jc.getPrice(), 0L) * Jd) {
                    BdUtilHelper.showToast(getPageContext().getPageActivity(), getPageContext().getResources().getString(a.h.ala_free_gift_flower_no_enough), 1000);
                    return false;
                }
                this.biw -= JavaTypesHelper.toLong(Jc.getPrice(), 0L) * Jd;
                this.bir.aO(this.biw);
                com.baidu.live.gift.c.b.JW().b(Jc, Jd, this.bie.mUserId, this.bie.mUserName, this.bie.mLiveId, this.bie.mRoomId, this.bie.mAppId, this.bie.beS, this.bie.otherParams, 0L);
            } else if (this.biv <= 0 || this.biv < JavaTypesHelper.toLong(Jc.getPrice(), 0L) * Jd) {
                KC();
                return false;
            } else {
                this.biv -= JavaTypesHelper.toLong(Jc.getPrice(), 0L) * Jd;
                this.bir.aN(this.biv);
                com.baidu.live.gift.c.b.JW().b(Jc, Jd, this.bie.mUserId, this.bie.mUserName, this.bie.mLiveId, this.bie.mRoomId, this.bie.mAppId, this.bie.beS, this.bie.otherParams, 0L);
            }
        }
        return true;
    }

    @Override // com.baidu.live.gift.panel.c
    protected void KH() {
        this.bix.hp(this.bie.beU);
    }

    private void KJ() {
        this.biy = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA) { // from class: com.baidu.live.gift.panel.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (d.this.bir != null) {
                    d.this.biv = TbadkCoreApplication.getInst().currentAccountTdouNum;
                    d.this.biw = TbadkCoreApplication.getInst().currentAccountFlowerNum;
                    d.this.bir.aN(TbadkCoreApplication.getInst().currentAccountTdouNum);
                    d.this.bir.aO(TbadkCoreApplication.getInst().currentAccountFlowerNum);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.biy);
    }

    private void KK() {
        this.bdN = new CustomMessageListener(2913120) { // from class: com.baidu.live.gift.panel.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                d.this.bcJ = true;
            }
        };
        MessageManager.getInstance().registerListener(this.bdN);
    }
}

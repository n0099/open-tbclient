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
import com.baidu.live.data.ae;
import com.baidu.live.data.i;
import com.baidu.live.data.l;
import com.baidu.live.gift.container.e;
import com.baidu.live.gift.g;
import com.baidu.live.gift.h;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d extends c {
    private CustomMessageListener bch;
    private com.baidu.live.gift.container.e bgO;
    private CustomMessageListener bgP;
    private long bgM = 0;
    private long bgN = 0;
    private e.a baY = new e.a() { // from class: com.baidu.live.gift.panel.d.3
        @Override // com.baidu.live.gift.container.e.a
        public void b(int i, String str, boolean z, ArrayList<h> arrayList, ArrayList<i> arrayList2, ArrayList<l> arrayList3, ae aeVar) {
            if (i != 0 && !StringUtils.isNull(str)) {
                BdUtilHelper.showToast(TbadkCoreApplication.getInst(), str);
            }
            d.this.bgI.a(z, arrayList, arrayList2, arrayList3, i == 0, i);
            d.this.bgI.b(aeVar);
        }
    };

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInflate(View view, Bundle bundle) {
        super.onInflate(view, bundle);
        this.bgI.setType(0);
        this.bgI.bbt.setText("赠送");
    }

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInitial() {
        super.onInitial();
        this.bgM = TbadkCoreApplication.getInst().currentAccountTdouNum;
        this.bgN = TbadkCoreApplication.getInst().currentAccountFlowerNum;
        Ie();
        If();
        this.bgO = new com.baidu.live.gift.container.e(getPageContext(), this.bgw.bdm);
        this.bgO.a(this.baY);
        this.bgO.gA(this.bgw.bdl);
    }

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.bgP);
        MessageManager.getInstance().unRegisterListener(this.bch);
    }

    private boolean b(g gVar) {
        if (com.baidu.live.ae.a.Qj().bAS != null && com.baidu.live.ae.a.Qj().bAS.aPL != null) {
            String str = com.baidu.live.ae.a.Qj().bAS.aPL.aPc;
            if (!TextUtils.isEmpty(str) && str.equals(String.valueOf(gVar.Eq()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.live.gift.panel.c
    protected boolean Ib() {
        g Gx = this.bgI.Gx();
        if (Gx == null) {
            BdUtilHelper.showToast(TbadkCoreApplication.getInst(), "请先选择一个礼物");
            return false;
        }
        int Gy = this.bgI.Gy();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("gift_num", Integer.valueOf(Gy));
            jSONObject.putOpt(LogConfig.LOG_GIFT_ID, Gx.DR());
            jSONObject.putOpt("gift_name", Gx.DS());
            jSONObject.putOpt(LogConfig.LOG_GIFT_VALUE, Gx.getPrice());
            jSONObject.putOpt("gift_type", Integer.valueOf(Gx.Eq()));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "giftsend_clk").setContentExt(null, UbcStatConstant.SubPage.POPUP, jSONObject));
        if (b(Gx) && !this.bbc) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913179));
            return false;
        }
        int i = this.bgw.aZD;
        if (Gx.Ev()) {
            if (Gx.Eq() == 6 && i < 3) {
                return false;
            }
            if (Gx.Eq() == 7 && i < 7) {
                return false;
            }
            if (Gx.Eq() == 8 && i < 13) {
                return false;
            }
            if (Gx.Eq() == 9 && i < 22) {
                return false;
            }
            if (Gx.Eq() == 10 && i < 29) {
                return false;
            }
            if (Gx.Eq() == 11 && i < 39) {
                return false;
            }
            if (Gx.Eq() == 12 && i < 47) {
                return false;
            }
        }
        if (a(Gx, Gy)) {
            if (Gx.Eb()) {
                if (this.bgM <= 0 || this.bgM < JavaTypesHelper.toLong(Gx.getPrice(), 0L) * Gy) {
                    HX();
                    return false;
                }
                Gx.aWe = this.bgJ != null ? this.bgJ.Ga() : null;
                if (Gx.aWe == null) {
                    return false;
                }
                this.bgM -= JavaTypesHelper.toLong(Gx.getPrice(), 0L) * Gy;
                this.bgI.aQ(this.bgM);
                Gx.aWe.aXk = Gx.DX();
                com.baidu.live.gift.c.b.Hr().b(Gx, Gy, this.bgw.mUserId, this.bgw.mUserName, this.bgw.mLiveId, this.bgw.mRoomId, this.bgw.mAppId, this.bgw.bdj, this.bgw.otherParams, 0L);
                closeActivity();
            } else if (Gx.Ee()) {
                if (this.bgN <= 0 || this.bgN < JavaTypesHelper.toLong(Gx.getPrice(), 0L) * Gy) {
                    BdUtilHelper.showToast(getPageContext().getPageActivity(), getPageContext().getResources().getString(a.h.ala_free_gift_flower_no_enough), 1000);
                    return false;
                }
                this.bgN -= JavaTypesHelper.toLong(Gx.getPrice(), 0L) * Gy;
                this.bgI.aR(this.bgN);
                com.baidu.live.gift.c.b.Hr().b(Gx, Gy, this.bgw.mUserId, this.bgw.mUserName, this.bgw.mLiveId, this.bgw.mRoomId, this.bgw.mAppId, this.bgw.bdj, this.bgw.otherParams, 0L);
            } else if (this.bgM <= 0 || this.bgM < JavaTypesHelper.toLong(Gx.getPrice(), 0L) * Gy) {
                HX();
                return false;
            } else {
                this.bgM -= JavaTypesHelper.toLong(Gx.getPrice(), 0L) * Gy;
                this.bgI.aQ(this.bgM);
                com.baidu.live.gift.c.b.Hr().b(Gx, Gy, this.bgw.mUserId, this.bgw.mUserName, this.bgw.mLiveId, this.bgw.mRoomId, this.bgw.mAppId, this.bgw.bdj, this.bgw.otherParams, 0L);
            }
        }
        return true;
    }

    @Override // com.baidu.live.gift.panel.c
    protected void Ic() {
        this.bgO.gB(this.bgw.bdl);
    }

    private void Ie() {
        this.bgP = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA) { // from class: com.baidu.live.gift.panel.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (d.this.bgI != null) {
                    d.this.bgM = TbadkCoreApplication.getInst().currentAccountTdouNum;
                    d.this.bgN = TbadkCoreApplication.getInst().currentAccountFlowerNum;
                    d.this.bgI.aQ(TbadkCoreApplication.getInst().currentAccountTdouNum);
                    d.this.bgI.aR(TbadkCoreApplication.getInst().currentAccountFlowerNum);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bgP);
    }

    private void If() {
        this.bch = new CustomMessageListener(2913120) { // from class: com.baidu.live.gift.panel.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                d.this.bbc = true;
            }
        };
        MessageManager.getInstance().registerListener(this.bch);
    }
}

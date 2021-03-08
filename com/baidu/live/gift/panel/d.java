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
/* loaded from: classes10.dex */
public class d extends c {
    private CustomMessageListener bdH;
    private com.baidu.live.gift.container.e biq;
    private CustomMessageListener bir;
    private long bio = 0;
    private long bip = 0;
    private e.a bcy = new e.a() { // from class: com.baidu.live.gift.panel.d.3
        @Override // com.baidu.live.gift.container.e.a
        public void b(int i, String str, boolean z, ArrayList<h> arrayList, ArrayList<i> arrayList2, ArrayList<l> arrayList3, ae aeVar) {
            if (i != 0 && !StringUtils.isNull(str)) {
                BdUtilHelper.showToast(TbadkCoreApplication.getInst(), str);
            }
            d.this.bik.a(z, arrayList, arrayList2, arrayList3, i == 0, i);
            d.this.bik.b(aeVar);
        }
    };

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInflate(View view, Bundle bundle) {
        super.onInflate(view, bundle);
        this.bik.setType(0);
        this.bik.bcT.setText("赠送");
    }

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInitial() {
        super.onInitial();
        this.bio = TbadkCoreApplication.getInst().currentAccountTdouNum;
        this.bip = TbadkCoreApplication.getInst().currentAccountFlowerNum;
        Ih();
        Ii();
        this.biq = new com.baidu.live.gift.container.e(getPageContext(), this.bhW.beO);
        this.biq.a(this.bcy);
        this.biq.gG(this.bhW.beN);
    }

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.bir);
        MessageManager.getInstance().unRegisterListener(this.bdH);
    }

    private boolean b(g gVar) {
        if (com.baidu.live.ae.a.Qm().bCs != null && com.baidu.live.ae.a.Qm().bCs.aRl != null) {
            String str = com.baidu.live.ae.a.Qm().bCs.aRl.aQC;
            if (!TextUtils.isEmpty(str) && str.equals(String.valueOf(gVar.Et()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.live.gift.panel.c
    protected boolean Ie() {
        g GA = this.bik.GA();
        if (GA == null) {
            BdUtilHelper.showToast(TbadkCoreApplication.getInst(), "请先选择一个礼物");
            return false;
        }
        int GB = this.bik.GB();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("gift_num", Integer.valueOf(GB));
            jSONObject.putOpt(LogConfig.LOG_GIFT_ID, GA.DU());
            jSONObject.putOpt("gift_name", GA.DV());
            jSONObject.putOpt(LogConfig.LOG_GIFT_VALUE, GA.getPrice());
            jSONObject.putOpt("gift_type", Integer.valueOf(GA.Et()));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "giftsend_clk").setContentExt(null, UbcStatConstant.SubPage.POPUP, jSONObject));
        if (b(GA) && !this.bcC) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913179));
            return false;
        }
        int i = this.bhW.bbe;
        if (GA.Ey()) {
            if (GA.Et() == 6 && i < 3) {
                return false;
            }
            if (GA.Et() == 7 && i < 7) {
                return false;
            }
            if (GA.Et() == 8 && i < 13) {
                return false;
            }
            if (GA.Et() == 9 && i < 22) {
                return false;
            }
            if (GA.Et() == 10 && i < 29) {
                return false;
            }
            if (GA.Et() == 11 && i < 39) {
                return false;
            }
            if (GA.Et() == 12 && i < 47) {
                return false;
            }
        }
        if (a(GA, GB)) {
            if (GA.Ee()) {
                if (this.bio <= 0 || this.bio < JavaTypesHelper.toLong(GA.getPrice(), 0L) * GB) {
                    Ia();
                    return false;
                }
                GA.aXE = this.bil != null ? this.bil.Gd() : null;
                if (GA.aXE == null) {
                    return false;
                }
                this.bio -= JavaTypesHelper.toLong(GA.getPrice(), 0L) * GB;
                this.bik.aQ(this.bio);
                GA.aXE.aYK = GA.Ea();
                com.baidu.live.gift.c.b.Hu().b(GA, GB, this.bhW.mUserId, this.bhW.mUserName, this.bhW.mLiveId, this.bhW.mRoomId, this.bhW.mAppId, this.bhW.beL, this.bhW.otherParams, 0L);
                closeActivity();
            } else if (GA.Eh()) {
                if (this.bip <= 0 || this.bip < JavaTypesHelper.toLong(GA.getPrice(), 0L) * GB) {
                    BdUtilHelper.showToast(getPageContext().getPageActivity(), getPageContext().getResources().getString(a.h.ala_free_gift_flower_no_enough), 1000);
                    return false;
                }
                this.bip -= JavaTypesHelper.toLong(GA.getPrice(), 0L) * GB;
                this.bik.aR(this.bip);
                com.baidu.live.gift.c.b.Hu().b(GA, GB, this.bhW.mUserId, this.bhW.mUserName, this.bhW.mLiveId, this.bhW.mRoomId, this.bhW.mAppId, this.bhW.beL, this.bhW.otherParams, 0L);
            } else if (this.bio <= 0 || this.bio < JavaTypesHelper.toLong(GA.getPrice(), 0L) * GB) {
                Ia();
                return false;
            } else {
                this.bio -= JavaTypesHelper.toLong(GA.getPrice(), 0L) * GB;
                this.bik.aQ(this.bio);
                com.baidu.live.gift.c.b.Hu().b(GA, GB, this.bhW.mUserId, this.bhW.mUserName, this.bhW.mLiveId, this.bhW.mRoomId, this.bhW.mAppId, this.bhW.beL, this.bhW.otherParams, 0L);
            }
        }
        return true;
    }

    @Override // com.baidu.live.gift.panel.c
    protected void If() {
        this.biq.gH(this.bhW.beN);
    }

    private void Ih() {
        this.bir = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA) { // from class: com.baidu.live.gift.panel.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (d.this.bik != null) {
                    d.this.bio = TbadkCoreApplication.getInst().currentAccountTdouNum;
                    d.this.bip = TbadkCoreApplication.getInst().currentAccountFlowerNum;
                    d.this.bik.aQ(TbadkCoreApplication.getInst().currentAccountTdouNum);
                    d.this.bik.aR(TbadkCoreApplication.getInst().currentAccountFlowerNum);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bir);
    }

    private void Ii() {
        this.bdH = new CustomMessageListener(2913120) { // from class: com.baidu.live.gift.panel.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                d.this.bcC = true;
            }
        };
        MessageManager.getInstance().registerListener(this.bdH);
    }
}

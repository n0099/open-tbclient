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
import com.baidu.live.data.j;
import com.baidu.live.data.y;
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
/* loaded from: classes4.dex */
public class d extends c {
    private CustomMessageListener aYJ;
    private com.baidu.live.gift.container.e bcO;
    private CustomMessageListener bcP;
    private long bcM = 0;
    private long bcN = 0;
    private e.a aXG = new e.a() { // from class: com.baidu.live.gift.panel.d.3
        @Override // com.baidu.live.gift.container.e.a
        public void b(int i, String str, boolean z, ArrayList<h> arrayList, ArrayList<com.baidu.live.data.h> arrayList2, ArrayList<j> arrayList3, y yVar) {
            if (i != 0 && !StringUtils.isNull(str)) {
                BdUtilHelper.showToast(TbadkCoreApplication.getInst(), str);
            }
            d.this.bcI.a(z, arrayList, arrayList2, arrayList3, i == 0, i);
            d.this.bcI.b(yVar);
        }
    };

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInflate(View view, Bundle bundle) {
        super.onInflate(view, bundle);
        this.bcI.setType(0);
        this.bcI.aXY.setText("赠送");
    }

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInitial() {
        super.onInitial();
        this.bcM = TbadkCoreApplication.getInst().currentAccountTdouNum;
        this.bcN = TbadkCoreApplication.getInst().currentAccountFlowerNum;
        Jj();
        Jk();
        this.bcO = new com.baidu.live.gift.container.e(getPageContext(), this.bcu.aZK);
        this.bcO.a(this.aXG);
        this.bcO.hi(this.bcu.aZJ);
    }

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.bcP);
        MessageManager.getInstance().unRegisterListener(this.aYJ);
    }

    @Override // com.baidu.live.gift.panel.c
    protected boolean Jf() {
        return true;
    }

    private boolean b(g gVar) {
        if (com.baidu.live.aa.a.Ph().bsh != null && com.baidu.live.aa.a.Ph().bsh.aNL != null) {
            String str = com.baidu.live.aa.a.Ph().bsh.aNL.aNd;
            if (!TextUtils.isEmpty(str) && str.equals(String.valueOf(gVar.FG()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.live.gift.panel.c
    protected boolean Jg() {
        g HJ = this.bcI.HJ();
        if (HJ == null) {
            return false;
        }
        if (b(HJ) && !this.aXK) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913179));
            return false;
        }
        int i = this.bcu.aWo;
        if (HJ.FK()) {
            if (HJ.FG() == 6 && i < 3) {
                return false;
            }
            if (HJ.FG() == 7 && i < 7) {
                return false;
            }
            if (HJ.FG() == 8 && i < 13) {
                return false;
            }
            if (HJ.FG() == 9 && i < 22) {
                return false;
            }
            if (HJ.FG() == 10 && i < 29) {
                return false;
            }
            if (HJ.FG() == 11 && i < 39) {
                return false;
            }
            if (HJ.FG() == 12 && i < 47) {
                return false;
            }
        }
        int HK = this.bcI.HK();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("gift_num", Integer.valueOf(HK));
            jSONObject.putOpt(LogConfig.LOG_GIFT_ID, HJ.Fk());
            jSONObject.putOpt("gift_name", HJ.Fl());
            jSONObject.putOpt(LogConfig.LOG_GIFT_VALUE, HJ.getPrice());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "display", "liveroom", "giftsend_clk").setContentExt(null, "popup", jSONObject));
        if (a(HJ, HK)) {
            if (HJ.Fr()) {
                if (this.bcM <= 0 || this.bcM < JavaTypesHelper.toLong(HJ.getPrice(), 0L) * HK) {
                    Jb();
                    return false;
                }
                HJ.aTc = this.bcJ != null ? this.bcJ.Hm() : null;
                if (HJ.aTc == null) {
                    return false;
                }
                HJ.aTc.aUi = HJ.Fo();
                com.baidu.live.gift.b.b.Iv().a(HJ, HK, this.bcu.mUserId, this.bcu.mUserName, this.bcu.mLiveId, this.bcu.mRoomId, this.bcu.mAppId, this.bcu.aZH, this.bcu.otherParams, 0L);
                this.bcM -= JavaTypesHelper.toLong(HJ.getPrice(), 0L) * HK;
                this.bcI.aq(this.bcM);
                closeActivity();
            } else if (HJ.Fu()) {
                if (this.bcN <= 0 || this.bcN < JavaTypesHelper.toLong(HJ.getPrice(), 0L) * HK) {
                    BdUtilHelper.showToast(getPageContext().getPageActivity(), getPageContext().getResources().getString(a.h.ala_free_gift_flower_no_enough), 1000);
                    return false;
                }
                com.baidu.live.gift.b.b.Iv().a(HJ, HK, this.bcu.mUserId, this.bcu.mUserName, this.bcu.mLiveId, this.bcu.mRoomId, this.bcu.mAppId, this.bcu.aZH, this.bcu.otherParams, 0L);
                this.bcN -= JavaTypesHelper.toLong(HJ.getPrice(), 0L) * HK;
                this.bcI.ar(this.bcN);
            } else if (this.bcM <= 0 || this.bcM < JavaTypesHelper.toLong(HJ.getPrice(), 0L) * HK) {
                Jb();
                return false;
            } else {
                com.baidu.live.gift.b.b.Iv().a(HJ, HK, this.bcu.mUserId, this.bcu.mUserName, this.bcu.mLiveId, this.bcu.mRoomId, this.bcu.mAppId, this.bcu.aZH, this.bcu.otherParams, 0L);
                this.bcM -= JavaTypesHelper.toLong(HJ.getPrice(), 0L) * HK;
                this.bcI.aq(this.bcM);
            }
        }
        return true;
    }

    @Override // com.baidu.live.gift.panel.c
    protected void Jh() {
        this.bcO.hj(this.bcu.aZJ);
    }

    private void Jj() {
        this.bcP = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA) { // from class: com.baidu.live.gift.panel.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (d.this.bcI != null) {
                    d.this.bcM = TbadkCoreApplication.getInst().currentAccountTdouNum;
                    d.this.bcN = TbadkCoreApplication.getInst().currentAccountFlowerNum;
                    d.this.bcI.aq(TbadkCoreApplication.getInst().currentAccountTdouNum);
                    d.this.bcI.ar(TbadkCoreApplication.getInst().currentAccountFlowerNum);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bcP);
    }

    private void Jk() {
        this.aYJ = new CustomMessageListener(2913120) { // from class: com.baidu.live.gift.panel.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                d.this.aXK = true;
            }
        };
        MessageManager.getInstance().registerListener(this.aYJ);
    }
}

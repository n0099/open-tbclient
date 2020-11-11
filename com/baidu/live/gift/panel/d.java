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
    private CustomMessageListener bav;
    private com.baidu.live.gift.container.e beB;
    private CustomMessageListener beC;
    private long bez = 0;
    private long beA = 0;
    private e.a aZr = new e.a() { // from class: com.baidu.live.gift.panel.d.3
        @Override // com.baidu.live.gift.container.e.a
        public void b(int i, String str, boolean z, ArrayList<h> arrayList, ArrayList<com.baidu.live.data.h> arrayList2, ArrayList<j> arrayList3, y yVar) {
            if (i != 0 && !StringUtils.isNull(str)) {
                BdUtilHelper.showToast(TbadkCoreApplication.getInst(), str);
            }
            d.this.bev.a(z, arrayList, arrayList2, arrayList3, i == 0, i);
            d.this.bev.b(yVar);
        }
    };

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInflate(View view, Bundle bundle) {
        super.onInflate(view, bundle);
        this.bev.setType(0);
        this.bev.aZJ.setText("赠送");
    }

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInitial() {
        super.onInitial();
        this.bez = TbadkCoreApplication.getInst().currentAccountTdouNum;
        this.beA = TbadkCoreApplication.getInst().currentAccountFlowerNum;
        JS();
        JT();
        this.beB = new com.baidu.live.gift.container.e(getPageContext(), this.bef.bbw);
        this.beB.a(this.aZr);
        this.beB.ho(this.bef.bbv);
    }

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.beC);
        MessageManager.getInstance().unRegisterListener(this.bav);
    }

    @Override // com.baidu.live.gift.panel.c
    protected boolean JO() {
        return true;
    }

    private boolean b(g gVar) {
        if (com.baidu.live.aa.a.PQ().btT != null && com.baidu.live.aa.a.PQ().btT.aPw != null) {
            String str = com.baidu.live.aa.a.PQ().btT.aPw.aOO;
            if (!TextUtils.isEmpty(str) && str.equals(String.valueOf(gVar.Gp()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.live.gift.panel.c
    protected boolean JP() {
        g Is = this.bev.Is();
        if (Is == null) {
            return false;
        }
        if (b(Is) && !this.aZv) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913179));
            return false;
        }
        int i = this.bef.aXZ;
        if (Is.Gt()) {
            if (Is.Gp() == 6 && i < 3) {
                return false;
            }
            if (Is.Gp() == 7 && i < 7) {
                return false;
            }
            if (Is.Gp() == 8 && i < 13) {
                return false;
            }
            if (Is.Gp() == 9 && i < 22) {
                return false;
            }
            if (Is.Gp() == 10 && i < 29) {
                return false;
            }
            if (Is.Gp() == 11 && i < 39) {
                return false;
            }
            if (Is.Gp() == 12 && i < 47) {
                return false;
            }
        }
        int It = this.bev.It();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("gift_num", Integer.valueOf(It));
            jSONObject.putOpt(LogConfig.LOG_GIFT_ID, Is.FT());
            jSONObject.putOpt("gift_name", Is.FU());
            jSONObject.putOpt(LogConfig.LOG_GIFT_VALUE, Is.getPrice());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "display", "liveroom", "giftsend_clk").setContentExt(null, "popup", jSONObject));
        if (a(Is, It)) {
            if (Is.Ga()) {
                if (this.bez <= 0 || this.bez < JavaTypesHelper.toLong(Is.getPrice(), 0L) * It) {
                    JK();
                    return false;
                }
                Is.aUN = this.bew != null ? this.bew.HV() : null;
                if (Is.aUN == null) {
                    return false;
                }
                Is.aUN.aVT = Is.FX();
                com.baidu.live.gift.b.b.Je().a(Is, It, this.bef.mUserId, this.bef.mUserName, this.bef.mLiveId, this.bef.mRoomId, this.bef.mAppId, this.bef.bbt, this.bef.otherParams, 0L);
                this.bez -= JavaTypesHelper.toLong(Is.getPrice(), 0L) * It;
                this.bev.aq(this.bez);
                closeActivity();
            } else if (Is.Gd()) {
                if (this.beA <= 0 || this.beA < JavaTypesHelper.toLong(Is.getPrice(), 0L) * It) {
                    BdUtilHelper.showToast(getPageContext().getPageActivity(), getPageContext().getResources().getString(a.h.ala_free_gift_flower_no_enough), 1000);
                    return false;
                }
                com.baidu.live.gift.b.b.Je().a(Is, It, this.bef.mUserId, this.bef.mUserName, this.bef.mLiveId, this.bef.mRoomId, this.bef.mAppId, this.bef.bbt, this.bef.otherParams, 0L);
                this.beA -= JavaTypesHelper.toLong(Is.getPrice(), 0L) * It;
                this.bev.ar(this.beA);
            } else if (this.bez <= 0 || this.bez < JavaTypesHelper.toLong(Is.getPrice(), 0L) * It) {
                JK();
                return false;
            } else {
                com.baidu.live.gift.b.b.Je().a(Is, It, this.bef.mUserId, this.bef.mUserName, this.bef.mLiveId, this.bef.mRoomId, this.bef.mAppId, this.bef.bbt, this.bef.otherParams, 0L);
                this.bez -= JavaTypesHelper.toLong(Is.getPrice(), 0L) * It;
                this.bev.aq(this.bez);
            }
        }
        return true;
    }

    @Override // com.baidu.live.gift.panel.c
    protected void JQ() {
        this.beB.hp(this.bef.bbv);
    }

    private void JS() {
        this.beC = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA) { // from class: com.baidu.live.gift.panel.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (d.this.bev != null) {
                    d.this.bez = TbadkCoreApplication.getInst().currentAccountTdouNum;
                    d.this.beA = TbadkCoreApplication.getInst().currentAccountFlowerNum;
                    d.this.bev.aq(TbadkCoreApplication.getInst().currentAccountTdouNum);
                    d.this.bev.ar(TbadkCoreApplication.getInst().currentAccountFlowerNum);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.beC);
    }

    private void JT() {
        this.bav = new CustomMessageListener(2913120) { // from class: com.baidu.live.gift.panel.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                d.this.aZv = true;
            }
        };
        MessageManager.getInstance().registerListener(this.bav);
    }
}

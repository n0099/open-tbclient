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
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class d extends c {
    private CustomMessageListener aYZ;
    private com.baidu.live.gift.container.e bdE;
    private CustomMessageListener bdF;
    private long bdC = 0;
    private long bdD = 0;
    private e.a aXR = new e.a() { // from class: com.baidu.live.gift.panel.d.3
        @Override // com.baidu.live.gift.container.e.a
        public void b(int i, String str, boolean z, ArrayList<h> arrayList, ArrayList<i> arrayList2, ArrayList<k> arrayList3, aa aaVar) {
            if (i != 0 && !StringUtils.isNull(str)) {
                BdUtilHelper.showToast(TbadkCoreApplication.getInst(), str);
            }
            d.this.bdy.a(z, arrayList, arrayList2, arrayList3, i == 0, i);
            d.this.bdy.b(aaVar);
        }
    };

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInflate(View view, Bundle bundle) {
        super.onInflate(view, bundle);
        this.bdy.setType(0);
        this.bdy.aYm.setText("赠送");
    }

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInitial() {
        super.onInitial();
        this.bdC = TbadkCoreApplication.getInst().currentAccountTdouNum;
        this.bdD = TbadkCoreApplication.getInst().currentAccountFlowerNum;
        GO();
        GP();
        this.bdE = new com.baidu.live.gift.container.e(getPageContext(), this.bdm.baf);
        this.bdE.a(this.aXR);
        this.bdE.gc(this.bdm.bae);
    }

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.bdF);
        MessageManager.getInstance().unRegisterListener(this.aYZ);
    }

    private boolean b(g gVar) {
        if (com.baidu.live.af.a.OJ().bxp != null && com.baidu.live.af.a.OJ().bxp.aMN != null) {
            String str = com.baidu.live.af.a.OJ().bxp.aMN.aMe;
            if (!TextUtils.isEmpty(str) && str.equals(String.valueOf(gVar.Da()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.live.gift.panel.c
    protected boolean GL() {
        g Fh = this.bdy.Fh();
        if (Fh == null) {
            BdUtilHelper.showToast(TbadkCoreApplication.getInst(), "请先选择一个礼物");
            return false;
        }
        int Fi = this.bdy.Fi();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("gift_num", Integer.valueOf(Fi));
            jSONObject.putOpt(LogConfig.LOG_GIFT_ID, Fh.CC());
            jSONObject.putOpt("gift_name", Fh.CD());
            jSONObject.putOpt(LogConfig.LOG_GIFT_VALUE, Fh.getPrice());
            jSONObject.putOpt("gift_type", Integer.valueOf(Fh.Da()));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "giftsend_clk").setContentExt(null, UbcStatConstant.SubPage.POPUP, jSONObject));
        if (b(Fh) && !this.aXV) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913179));
            return false;
        }
        int i = this.bdm.aWx;
        if (Fh.Df()) {
            if (Fh.Da() == 6 && i < 3) {
                return false;
            }
            if (Fh.Da() == 7 && i < 7) {
                return false;
            }
            if (Fh.Da() == 8 && i < 13) {
                return false;
            }
            if (Fh.Da() == 9 && i < 22) {
                return false;
            }
            if (Fh.Da() == 10 && i < 29) {
                return false;
            }
            if (Fh.Da() == 11 && i < 39) {
                return false;
            }
            if (Fh.Da() == 12 && i < 47) {
                return false;
            }
        }
        if (a(Fh, Fi)) {
            if (Fh.CL()) {
                if (this.bdC <= 0 || this.bdC < JavaTypesHelper.toLong(Fh.getPrice(), 0L) * Fi) {
                    GH();
                    return false;
                }
                Fh.aSZ = this.bdz != null ? this.bdz.EK() : null;
                if (Fh.aSZ == null) {
                    return false;
                }
                this.bdC -= JavaTypesHelper.toLong(Fh.getPrice(), 0L) * Fi;
                this.bdy.aN(this.bdC);
                Fh.aSZ.aUf = Fh.CH();
                com.baidu.live.gift.c.b.Gb().b(Fh, Fi, this.bdm.mUserId, this.bdm.mUserName, this.bdm.mLiveId, this.bdm.mRoomId, this.bdm.mAppId, this.bdm.bac, this.bdm.otherParams, 0L);
                closeActivity();
            } else if (Fh.CO()) {
                if (this.bdD <= 0 || this.bdD < JavaTypesHelper.toLong(Fh.getPrice(), 0L) * Fi) {
                    BdUtilHelper.showToast(getPageContext().getPageActivity(), getPageContext().getResources().getString(a.h.ala_free_gift_flower_no_enough), 1000);
                    return false;
                }
                this.bdD -= JavaTypesHelper.toLong(Fh.getPrice(), 0L) * Fi;
                this.bdy.aO(this.bdD);
                com.baidu.live.gift.c.b.Gb().b(Fh, Fi, this.bdm.mUserId, this.bdm.mUserName, this.bdm.mLiveId, this.bdm.mRoomId, this.bdm.mAppId, this.bdm.bac, this.bdm.otherParams, 0L);
            } else if (this.bdC <= 0 || this.bdC < JavaTypesHelper.toLong(Fh.getPrice(), 0L) * Fi) {
                GH();
                return false;
            } else {
                this.bdC -= JavaTypesHelper.toLong(Fh.getPrice(), 0L) * Fi;
                this.bdy.aN(this.bdC);
                com.baidu.live.gift.c.b.Gb().b(Fh, Fi, this.bdm.mUserId, this.bdm.mUserName, this.bdm.mLiveId, this.bdm.mRoomId, this.bdm.mAppId, this.bdm.bac, this.bdm.otherParams, 0L);
            }
        }
        return true;
    }

    @Override // com.baidu.live.gift.panel.c
    protected void GM() {
        this.bdE.gd(this.bdm.bae);
    }

    private void GO() {
        this.bdF = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA) { // from class: com.baidu.live.gift.panel.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (d.this.bdy != null) {
                    d.this.bdC = TbadkCoreApplication.getInst().currentAccountTdouNum;
                    d.this.bdD = TbadkCoreApplication.getInst().currentAccountFlowerNum;
                    d.this.bdy.aN(TbadkCoreApplication.getInst().currentAccountTdouNum);
                    d.this.bdy.aO(TbadkCoreApplication.getInst().currentAccountFlowerNum);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bdF);
    }

    private void GP() {
        this.aYZ = new CustomMessageListener(2913120) { // from class: com.baidu.live.gift.panel.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                d.this.aXV = true;
            }
        };
        MessageManager.getInstance().registerListener(this.aYZ);
    }
}

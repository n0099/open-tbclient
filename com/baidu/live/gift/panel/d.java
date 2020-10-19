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
import com.baidu.live.data.g;
import com.baidu.live.data.w;
import com.baidu.live.gift.container.e;
import com.baidu.live.gift.i;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.platform.comapi.map.MapController;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d extends c {
    private CustomMessageListener aXH;
    private com.baidu.live.gift.container.e bbS;
    private CustomMessageListener bbT;
    private long bbQ = 0;
    private long bbR = 0;
    private e.a aWE = new e.a() { // from class: com.baidu.live.gift.panel.d.3
        @Override // com.baidu.live.gift.container.e.a
        public void b(int i, String str, boolean z, ArrayList<i> arrayList, ArrayList<g> arrayList2, ArrayList<com.baidu.live.data.i> arrayList3, w wVar) {
            if (i != 0 && !StringUtils.isNull(str)) {
                BdUtilHelper.showToast(TbadkCoreApplication.getInst(), str);
            }
            d.this.bbM.a(z, arrayList, arrayList2, arrayList3, i == 0, i);
            d.this.bbM.b(wVar);
        }
    };

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInflate(View view, Bundle bundle) {
        super.onInflate(view, bundle);
        this.bbM.setType(0);
        this.bbM.aWW.setText("赠送");
    }

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInitial() {
        super.onInitial();
        this.bbQ = TbadkCoreApplication.getInst().currentAccountTdouNum;
        this.bbR = TbadkCoreApplication.getInst().currentAccountFlowerNum;
        IY();
        IZ();
        this.bbS = new com.baidu.live.gift.container.e(getPageContext(), this.bby.aYG);
        this.bbS.a(this.aWE);
        this.bbS.gW(this.bby.aYF);
    }

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.bbT);
        MessageManager.getInstance().unRegisterListener(this.aXH);
    }

    @Override // com.baidu.live.gift.panel.c
    protected boolean IU() {
        return true;
    }

    private boolean b(com.baidu.live.gift.g gVar) {
        if (com.baidu.live.x.a.OS().bqJ != null && com.baidu.live.x.a.OS().bqJ.aNU != null) {
            String str = com.baidu.live.x.a.OS().bqJ.aNU.aNg;
            if (!TextUtils.isEmpty(str) && str.equals(String.valueOf(gVar.Fz()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.live.gift.panel.c
    protected boolean IV() {
        com.baidu.live.gift.g Hw = this.bbM.Hw();
        if (Hw == null) {
            return false;
        }
        if (b(Hw) && !this.aWI) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913179));
            return false;
        }
        int i = this.bby.aVm;
        if (Hw.FD()) {
            if (Hw.Fz() == 6 && i < 3) {
                return false;
            }
            if (Hw.Fz() == 7 && i < 7) {
                return false;
            }
            if (Hw.Fz() == 8 && i < 13) {
                return false;
            }
            if (Hw.Fz() == 9 && i < 22) {
                return false;
            }
            if (Hw.Fz() == 10 && i < 29) {
                return false;
            }
            if (Hw.Fz() == 11 && i < 39) {
                return false;
            }
            if (Hw.Fz() == 12 && i < 47) {
                return false;
            }
        }
        int Hx = this.bbM.Hx();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("gift_num", Integer.valueOf(Hx));
            jSONObject.putOpt(LogConfig.LOG_GIFT_ID, Hw.Fd());
            jSONObject.putOpt("gift_name", Hw.Fe());
            jSONObject.putOpt(LogConfig.LOG_GIFT_VALUE, Hw.getPrice());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "display", "liveroom", "giftsend_clk").setContentExt(null, MapController.POPUP_LAYER_TAG, jSONObject));
        if (a(Hw, Hx)) {
            if (Hw.Fk()) {
                if (this.bbQ <= 0 || this.bbQ < JavaTypesHelper.toLong(Hw.getPrice(), 0L) * Hx) {
                    IQ();
                    return false;
                }
                Hw.aSz = this.bbN != null ? this.bbN.GY() : null;
                if (Hw.aSz == null) {
                    return false;
                }
                Hw.aSz.aTF = Hw.Fh();
                com.baidu.live.gift.b.b.Ik().a(Hw, Hx, this.bby.mUserId, this.bby.mUserName, this.bby.mLiveId, this.bby.mRoomId, this.bby.mAppId, this.bby.aYD, this.bby.otherParams, 0L);
                this.bbQ -= JavaTypesHelper.toLong(Hw.getPrice(), 0L) * Hx;
                this.bbM.ad(this.bbQ);
                closeActivity();
            } else if (Hw.Fn()) {
                if (this.bbR <= 0 || this.bbR < JavaTypesHelper.toLong(Hw.getPrice(), 0L) * Hx) {
                    BdUtilHelper.showToast(getPageContext().getPageActivity(), getPageContext().getResources().getString(a.i.ala_free_gift_flower_no_enough), 1000);
                    return false;
                }
                com.baidu.live.gift.b.b.Ik().a(Hw, Hx, this.bby.mUserId, this.bby.mUserName, this.bby.mLiveId, this.bby.mRoomId, this.bby.mAppId, this.bby.aYD, this.bby.otherParams, 0L);
                this.bbR -= JavaTypesHelper.toLong(Hw.getPrice(), 0L) * Hx;
                this.bbM.ae(this.bbR);
            } else if (this.bbQ <= 0 || this.bbQ < JavaTypesHelper.toLong(Hw.getPrice(), 0L) * Hx) {
                IQ();
                return false;
            } else {
                com.baidu.live.gift.b.b.Ik().a(Hw, Hx, this.bby.mUserId, this.bby.mUserName, this.bby.mLiveId, this.bby.mRoomId, this.bby.mAppId, this.bby.aYD, this.bby.otherParams, 0L);
                this.bbQ -= JavaTypesHelper.toLong(Hw.getPrice(), 0L) * Hx;
                this.bbM.ad(this.bbQ);
            }
        }
        return true;
    }

    @Override // com.baidu.live.gift.panel.c
    protected void IW() {
        this.bbS.gX(this.bby.aYF);
    }

    private void IY() {
        this.bbT = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA) { // from class: com.baidu.live.gift.panel.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (d.this.bbM != null) {
                    d.this.bbQ = TbadkCoreApplication.getInst().currentAccountTdouNum;
                    d.this.bbR = TbadkCoreApplication.getInst().currentAccountFlowerNum;
                    d.this.bbM.ad(TbadkCoreApplication.getInst().currentAccountTdouNum);
                    d.this.bbM.ae(TbadkCoreApplication.getInst().currentAccountFlowerNum);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bbT);
    }

    private void IZ() {
        this.aXH = new CustomMessageListener(2913120) { // from class: com.baidu.live.gift.panel.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                d.this.aWI = true;
            }
        };
        MessageManager.getInstance().registerListener(this.aXH);
    }
}

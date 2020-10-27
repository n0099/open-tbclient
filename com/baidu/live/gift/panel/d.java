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
import com.baidu.live.data.h;
import com.baidu.live.data.j;
import com.baidu.live.data.y;
import com.baidu.live.gift.container.e;
import com.baidu.live.gift.g;
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
    private CustomMessageListener aZc;
    private com.baidu.live.gift.container.e bdg;
    private CustomMessageListener bdh;
    private long bde = 0;
    private long bdf = 0;
    private e.a aXZ = new e.a() { // from class: com.baidu.live.gift.panel.d.3
        @Override // com.baidu.live.gift.container.e.a
        public void b(int i, String str, boolean z, ArrayList<i> arrayList, ArrayList<h> arrayList2, ArrayList<j> arrayList3, y yVar) {
            if (i != 0 && !StringUtils.isNull(str)) {
                BdUtilHelper.showToast(TbadkCoreApplication.getInst(), str);
            }
            d.this.bda.a(z, arrayList, arrayList2, arrayList3, i == 0, i);
            d.this.bda.b(yVar);
        }
    };

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInflate(View view, Bundle bundle) {
        super.onInflate(view, bundle);
        this.bda.setType(0);
        this.bda.aYr.setText("赠送");
    }

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInitial() {
        super.onInitial();
        this.bde = TbadkCoreApplication.getInst().currentAccountTdouNum;
        this.bdf = TbadkCoreApplication.getInst().currentAccountFlowerNum;
        Jr();
        Js();
        this.bdg = new com.baidu.live.gift.container.e(getPageContext(), this.bcM.bad);
        this.bdg.a(this.aXZ);
        this.bdg.hh(this.bcM.bac);
    }

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.bdh);
        MessageManager.getInstance().unRegisterListener(this.aZc);
    }

    @Override // com.baidu.live.gift.panel.c
    protected boolean Jn() {
        return true;
    }

    private boolean b(g gVar) {
        if (com.baidu.live.z.a.Pq().bsy != null && com.baidu.live.z.a.Pq().bsy.aOz != null) {
            String str = com.baidu.live.z.a.Pq().bsy.aOz.aNL;
            if (!TextUtils.isEmpty(str) && str.equals(String.valueOf(gVar.FO()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.live.gift.panel.c
    protected boolean Jo() {
        g HR = this.bda.HR();
        if (HR == null) {
            return false;
        }
        if (b(HR) && !this.aYd) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913179));
            return false;
        }
        int i = this.bcM.aWH;
        if (HR.FS()) {
            if (HR.FO() == 6 && i < 3) {
                return false;
            }
            if (HR.FO() == 7 && i < 7) {
                return false;
            }
            if (HR.FO() == 8 && i < 13) {
                return false;
            }
            if (HR.FO() == 9 && i < 22) {
                return false;
            }
            if (HR.FO() == 10 && i < 29) {
                return false;
            }
            if (HR.FO() == 11 && i < 39) {
                return false;
            }
            if (HR.FO() == 12 && i < 47) {
                return false;
            }
        }
        int HS = this.bda.HS();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("gift_num", Integer.valueOf(HS));
            jSONObject.putOpt(LogConfig.LOG_GIFT_ID, HR.Fs());
            jSONObject.putOpt("gift_name", HR.Ft());
            jSONObject.putOpt(LogConfig.LOG_GIFT_VALUE, HR.getPrice());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "display", "liveroom", "giftsend_clk").setContentExt(null, MapController.POPUP_LAYER_TAG, jSONObject));
        if (a(HR, HS)) {
            if (HR.Fz()) {
                if (this.bde <= 0 || this.bde < JavaTypesHelper.toLong(HR.getPrice(), 0L) * HS) {
                    Jj();
                    return false;
                }
                HR.aTv = this.bdb != null ? this.bdb.Hu() : null;
                if (HR.aTv == null) {
                    return false;
                }
                HR.aTv.aUB = HR.Fw();
                com.baidu.live.gift.b.b.ID().a(HR, HS, this.bcM.mUserId, this.bcM.mUserName, this.bcM.mLiveId, this.bcM.mRoomId, this.bcM.mAppId, this.bcM.baa, this.bcM.otherParams, 0L);
                this.bde -= JavaTypesHelper.toLong(HR.getPrice(), 0L) * HS;
                this.bda.ae(this.bde);
                closeActivity();
            } else if (HR.FC()) {
                if (this.bdf <= 0 || this.bdf < JavaTypesHelper.toLong(HR.getPrice(), 0L) * HS) {
                    BdUtilHelper.showToast(getPageContext().getPageActivity(), getPageContext().getResources().getString(a.i.ala_free_gift_flower_no_enough), 1000);
                    return false;
                }
                com.baidu.live.gift.b.b.ID().a(HR, HS, this.bcM.mUserId, this.bcM.mUserName, this.bcM.mLiveId, this.bcM.mRoomId, this.bcM.mAppId, this.bcM.baa, this.bcM.otherParams, 0L);
                this.bdf -= JavaTypesHelper.toLong(HR.getPrice(), 0L) * HS;
                this.bda.af(this.bdf);
            } else if (this.bde <= 0 || this.bde < JavaTypesHelper.toLong(HR.getPrice(), 0L) * HS) {
                Jj();
                return false;
            } else {
                com.baidu.live.gift.b.b.ID().a(HR, HS, this.bcM.mUserId, this.bcM.mUserName, this.bcM.mLiveId, this.bcM.mRoomId, this.bcM.mAppId, this.bcM.baa, this.bcM.otherParams, 0L);
                this.bde -= JavaTypesHelper.toLong(HR.getPrice(), 0L) * HS;
                this.bda.ae(this.bde);
            }
        }
        return true;
    }

    @Override // com.baidu.live.gift.panel.c
    protected void Jp() {
        this.bdg.hi(this.bcM.bac);
    }

    private void Jr() {
        this.bdh = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA) { // from class: com.baidu.live.gift.panel.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (d.this.bda != null) {
                    d.this.bde = TbadkCoreApplication.getInst().currentAccountTdouNum;
                    d.this.bdf = TbadkCoreApplication.getInst().currentAccountFlowerNum;
                    d.this.bda.ae(TbadkCoreApplication.getInst().currentAccountTdouNum);
                    d.this.bda.af(TbadkCoreApplication.getInst().currentAccountFlowerNum);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bdh);
    }

    private void Js() {
        this.aZc = new CustomMessageListener(2913120) { // from class: com.baidu.live.gift.panel.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                d.this.aYd = true;
            }
        };
        MessageManager.getInstance().registerListener(this.aZc);
    }
}

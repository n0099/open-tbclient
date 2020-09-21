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
    private CustomMessageListener aUw;
    private com.baidu.live.gift.container.e aYy;
    private CustomMessageListener aYz;
    private long aYw = 0;
    private long aYx = 0;
    private e.a aTt = new e.a() { // from class: com.baidu.live.gift.panel.d.3
        @Override // com.baidu.live.gift.container.e.a
        public void b(int i, String str, boolean z, ArrayList<i> arrayList, ArrayList<g> arrayList2, ArrayList<com.baidu.live.data.i> arrayList3, w wVar) {
            if (i != 0 && !StringUtils.isNull(str)) {
                BdUtilHelper.showToast(TbadkCoreApplication.getInst(), str);
            }
            d.this.aYs.a(z, arrayList, arrayList2, arrayList3, i == 0, i);
            d.this.aYs.b(wVar);
        }
    };

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInflate(View view, Bundle bundle) {
        super.onInflate(view, bundle);
        this.aYs.setType(0);
        this.aYs.aTL.setText("赠送");
    }

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInitial() {
        super.onInitial();
        this.aYw = TbadkCoreApplication.getInst().currentAccountTdouNum;
        this.aYx = TbadkCoreApplication.getInst().currentAccountFlowerNum;
        Ib();
        Ic();
        this.aYy = new com.baidu.live.gift.container.e(getPageContext(), this.aYe.aVv);
        this.aYy.a(this.aTt);
        this.aYy.gI(this.aYe.aVu);
    }

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.aYz);
        MessageManager.getInstance().unRegisterListener(this.aUw);
    }

    @Override // com.baidu.live.gift.panel.c
    protected boolean HX() {
        return true;
    }

    private boolean b(com.baidu.live.gift.g gVar) {
        if (com.baidu.live.x.a.NN().bmW != null && com.baidu.live.x.a.NN().bmW.aKP != null) {
            String str = com.baidu.live.x.a.NN().bmW.aKP.aKb;
            if (!TextUtils.isEmpty(str) && str.equals(String.valueOf(gVar.ED()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.live.gift.panel.c
    protected boolean HY() {
        com.baidu.live.gift.g GA = this.aYs.GA();
        if (GA == null) {
            return false;
        }
        if (b(GA) && !this.aTx) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913179));
            return false;
        }
        int i = this.aYe.aSb;
        if (GA.EH()) {
            if (GA.ED() == 6 && i < 3) {
                return false;
            }
            if (GA.ED() == 7 && i < 7) {
                return false;
            }
            if (GA.ED() == 8 && i < 13) {
                return false;
            }
            if (GA.ED() == 9 && i < 22) {
                return false;
            }
            if (GA.ED() == 10 && i < 29) {
                return false;
            }
            if (GA.ED() == 11 && i < 39) {
                return false;
            }
            if (GA.ED() == 12 && i < 47) {
                return false;
            }
        }
        int GB = this.aYs.GB();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("gift_num", Integer.valueOf(GB));
            jSONObject.putOpt(LogConfig.LOG_GIFT_ID, GA.Eh());
            jSONObject.putOpt("gift_name", GA.Ei());
            jSONObject.putOpt(LogConfig.LOG_GIFT_VALUE, GA.getPrice());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "display", "liveroom", "giftsend_clk").setContentExt(null, MapController.POPUP_LAYER_TAG, jSONObject));
        if (a(GA, GB)) {
            if (GA.Eo()) {
                if (this.aYw <= 0 || this.aYw < JavaTypesHelper.toLong(GA.getPrice(), 0L) * GB) {
                    HT();
                    return false;
                }
                GA.aPo = this.aYt != null ? this.aYt.Gc() : null;
                if (GA.aPo == null) {
                    return false;
                }
                GA.aPo.aQu = GA.El();
                com.baidu.live.gift.b.b.Hn().a(GA, GB, this.aYe.mUserId, this.aYe.mUserName, this.aYe.mLiveId, this.aYe.mRoomId, this.aYe.mAppId, this.aYe.aVs, this.aYe.otherParams, 0L);
                this.aYw -= JavaTypesHelper.toLong(GA.getPrice(), 0L) * GB;
                this.aYs.ab(this.aYw);
                closeActivity();
            } else if (GA.Er()) {
                if (this.aYx <= 0 || this.aYx < JavaTypesHelper.toLong(GA.getPrice(), 0L) * GB) {
                    BdUtilHelper.showToast(getPageContext().getPageActivity(), getPageContext().getResources().getString(a.i.ala_free_gift_flower_no_enough), 1000);
                    return false;
                }
                com.baidu.live.gift.b.b.Hn().a(GA, GB, this.aYe.mUserId, this.aYe.mUserName, this.aYe.mLiveId, this.aYe.mRoomId, this.aYe.mAppId, this.aYe.aVs, this.aYe.otherParams, 0L);
                this.aYx -= JavaTypesHelper.toLong(GA.getPrice(), 0L) * GB;
                this.aYs.ac(this.aYx);
            } else if (this.aYw <= 0 || this.aYw < JavaTypesHelper.toLong(GA.getPrice(), 0L) * GB) {
                HT();
                return false;
            } else {
                com.baidu.live.gift.b.b.Hn().a(GA, GB, this.aYe.mUserId, this.aYe.mUserName, this.aYe.mLiveId, this.aYe.mRoomId, this.aYe.mAppId, this.aYe.aVs, this.aYe.otherParams, 0L);
                this.aYw -= JavaTypesHelper.toLong(GA.getPrice(), 0L) * GB;
                this.aYs.ab(this.aYw);
            }
        }
        return true;
    }

    @Override // com.baidu.live.gift.panel.c
    protected void HZ() {
        this.aYy.gJ(this.aYe.aVu);
    }

    private void Ib() {
        this.aYz = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA) { // from class: com.baidu.live.gift.panel.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (d.this.aYs != null) {
                    d.this.aYw = TbadkCoreApplication.getInst().currentAccountTdouNum;
                    d.this.aYx = TbadkCoreApplication.getInst().currentAccountFlowerNum;
                    d.this.aYs.ab(TbadkCoreApplication.getInst().currentAccountTdouNum);
                    d.this.aYs.ac(TbadkCoreApplication.getInst().currentAccountFlowerNum);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aYz);
    }

    private void Ic() {
        this.aUw = new CustomMessageListener(2913120) { // from class: com.baidu.live.gift.panel.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                d.this.aTx = true;
            }
        };
        MessageManager.getInstance().registerListener(this.aUw);
    }
}

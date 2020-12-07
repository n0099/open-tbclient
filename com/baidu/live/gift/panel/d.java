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
import com.baidu.live.data.z;
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
    private CustomMessageListener bcf;
    private com.baidu.live.gift.container.e bgO;
    private CustomMessageListener bgP;
    private long bgM = 0;
    private long bgN = 0;
    private e.a baY = new e.a() { // from class: com.baidu.live.gift.panel.d.3
        @Override // com.baidu.live.gift.container.e.a
        public void b(int i, String str, boolean z, ArrayList<h> arrayList, ArrayList<com.baidu.live.data.h> arrayList2, ArrayList<j> arrayList3, z zVar) {
            if (i != 0 && !StringUtils.isNull(str)) {
                BdUtilHelper.showToast(TbadkCoreApplication.getInst(), str);
            }
            d.this.bgI.a(z, arrayList, arrayList2, arrayList3, i == 0, i);
            d.this.bgI.b(zVar);
        }
    };

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInflate(View view, Bundle bundle) {
        super.onInflate(view, bundle);
        this.bgI.setType(0);
        this.bgI.bbs.setText("赠送");
    }

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    protected void onInitial() {
        super.onInitial();
        this.bgM = TbadkCoreApplication.getInst().currentAccountTdouNum;
        this.bgN = TbadkCoreApplication.getInst().currentAccountFlowerNum;
        Lk();
        Ll();
        this.bgO = new com.baidu.live.gift.container.e(getPageContext(), this.bgw.bdk);
        this.bgO.a(this.baY);
        this.bgO.hD(this.bgw.bdj);
    }

    @Override // com.baidu.live.gift.panel.c, com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.bgP);
        MessageManager.getInstance().unRegisterListener(this.bcf);
    }

    @Override // com.baidu.live.gift.panel.c
    protected boolean Lg() {
        return true;
    }

    private boolean b(g gVar) {
        if (com.baidu.live.ae.a.RB().bxq != null && com.baidu.live.ae.a.RB().bxq.aQL != null) {
            String str = com.baidu.live.ae.a.RB().bxq.aQL.aQc;
            if (!TextUtils.isEmpty(str) && str.equals(String.valueOf(gVar.Hu()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.live.gift.panel.c
    protected boolean Lh() {
        g JA = this.bgI.JA();
        if (JA == null) {
            return false;
        }
        if (b(JA) && !this.bbc) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913179));
            return false;
        }
        int i = this.bgw.aZE;
        if (JA.Hz()) {
            if (JA.Hu() == 6 && i < 3) {
                return false;
            }
            if (JA.Hu() == 7 && i < 7) {
                return false;
            }
            if (JA.Hu() == 8 && i < 13) {
                return false;
            }
            if (JA.Hu() == 9 && i < 22) {
                return false;
            }
            if (JA.Hu() == 10 && i < 29) {
                return false;
            }
            if (JA.Hu() == 11 && i < 39) {
                return false;
            }
            if (JA.Hu() == 12 && i < 47) {
                return false;
            }
        }
        int JB = this.bgI.JB();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("gift_num", Integer.valueOf(JB));
            jSONObject.putOpt(LogConfig.LOG_GIFT_ID, JA.GX());
            jSONObject.putOpt("gift_name", JA.GY());
            jSONObject.putOpt(LogConfig.LOG_GIFT_VALUE, JA.getPrice());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "giftsend_clk").setContentExt(null, "popup", jSONObject));
        if (a(JA, JB)) {
            if (JA.Hf()) {
                if (this.bgM <= 0 || this.bgM < JavaTypesHelper.toLong(JA.getPrice(), 0L) * JB) {
                    Lc();
                    return false;
                }
                JA.aWg = this.bgJ != null ? this.bgJ.Jd() : null;
                if (JA.aWg == null) {
                    return false;
                }
                JA.aWg.aXn = JA.Hb();
                com.baidu.live.gift.c.b.Kv().b(JA, JB, this.bgw.mUserId, this.bgw.mUserName, this.bgw.mLiveId, this.bgw.mRoomId, this.bgw.mAppId, this.bgw.bdh, this.bgw.otherParams, 0L);
                this.bgM -= JavaTypesHelper.toLong(JA.getPrice(), 0L) * JB;
                this.bgI.aO(this.bgM);
                closeActivity();
            } else if (JA.Hi()) {
                if (this.bgN <= 0 || this.bgN < JavaTypesHelper.toLong(JA.getPrice(), 0L) * JB) {
                    BdUtilHelper.showToast(getPageContext().getPageActivity(), getPageContext().getResources().getString(a.h.ala_free_gift_flower_no_enough), 1000);
                    return false;
                }
                com.baidu.live.gift.c.b.Kv().b(JA, JB, this.bgw.mUserId, this.bgw.mUserName, this.bgw.mLiveId, this.bgw.mRoomId, this.bgw.mAppId, this.bgw.bdh, this.bgw.otherParams, 0L);
                this.bgN -= JavaTypesHelper.toLong(JA.getPrice(), 0L) * JB;
                this.bgI.aP(this.bgN);
            } else if (this.bgM <= 0 || this.bgM < JavaTypesHelper.toLong(JA.getPrice(), 0L) * JB) {
                Lc();
                return false;
            } else {
                com.baidu.live.gift.c.b.Kv().b(JA, JB, this.bgw.mUserId, this.bgw.mUserName, this.bgw.mLiveId, this.bgw.mRoomId, this.bgw.mAppId, this.bgw.bdh, this.bgw.otherParams, 0L);
                this.bgM -= JavaTypesHelper.toLong(JA.getPrice(), 0L) * JB;
                this.bgI.aO(this.bgM);
            }
        }
        return true;
    }

    @Override // com.baidu.live.gift.panel.c
    protected void Li() {
        this.bgO.hE(this.bgw.bdj);
    }

    private void Lk() {
        this.bgP = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA) { // from class: com.baidu.live.gift.panel.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (d.this.bgI != null) {
                    d.this.bgM = TbadkCoreApplication.getInst().currentAccountTdouNum;
                    d.this.bgN = TbadkCoreApplication.getInst().currentAccountFlowerNum;
                    d.this.bgI.aO(TbadkCoreApplication.getInst().currentAccountTdouNum);
                    d.this.bgI.aP(TbadkCoreApplication.getInst().currentAccountFlowerNum);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bgP);
    }

    private void Ll() {
        this.bcf = new CustomMessageListener(2913120) { // from class: com.baidu.live.gift.panel.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                d.this.bbc = true;
            }
        };
        MessageManager.getInstance().registerListener(this.bcf);
    }
}

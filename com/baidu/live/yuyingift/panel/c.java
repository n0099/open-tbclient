package com.baidu.live.yuyingift.panel;

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
import com.baidu.live.gift.g;
import com.baidu.live.gift.h;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.utils.r;
import com.baidu.live.yuyingift.container.e;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class c extends b {
    private com.baidu.live.yuyingift.container.e bVe;
    private CustomMessageListener bcf;
    private CustomMessageListener bgP;
    private long bgM = 0;
    private long bgN = 0;
    private e.a bTL = new e.a() { // from class: com.baidu.live.yuyingift.panel.c.3
        @Override // com.baidu.live.yuyingift.container.e.a
        public void b(int i, String str, boolean z, ArrayList<h> arrayList, ArrayList<com.baidu.live.data.h> arrayList2, ArrayList<j> arrayList3, z zVar) {
            if (i != 0 && !StringUtils.isNull(str)) {
                BdUtilHelper.showToast(TbadkCoreApplication.getInst(), str);
            }
            c.this.bVb.a(z, arrayList, arrayList2, arrayList3, i == 0, i);
            c.this.bVb.b(zVar);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.yuyingift.panel.b, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInflate(View view, Bundle bundle) {
        super.onInflate(view, bundle);
        this.bVb.setType(0);
        this.bVb.bTQ.setText("赠送");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.yuyingift.panel.b, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInitial() {
        super.onInitial();
        this.bgM = TbadkCoreApplication.getInst().currentAccountTdouNum;
        this.bgN = TbadkCoreApplication.getInst().currentAccountFlowerNum;
        Lk();
        Ll();
        this.bVe = new com.baidu.live.yuyingift.container.e(getPageContext(), this.bUT.bdk);
        this.bVe.a(this.bTL);
        this.bVe.hD(this.bUT.bdj);
    }

    @Override // com.baidu.live.yuyingift.panel.b, com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.bgP);
        MessageManager.getInstance().unRegisterListener(this.bcf);
    }

    @Override // com.baidu.live.yuyingift.panel.b
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

    @Override // com.baidu.live.yuyingift.panel.b
    protected boolean Lh() {
        g JA = this.bVb.JA();
        if (JA == null) {
            return false;
        }
        if (b(JA) && !this.bbc) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913179));
            return false;
        }
        int i = this.bUT.aZE;
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
        int JB = this.bVb.JB();
        if (a(JA, JB)) {
            long j = JavaTypesHelper.toLong(JA.getPrice(), 0L) * JB * ZC();
            if (JA.Hf()) {
                if (this.bgM <= 0 || this.bgM < j) {
                    Lc();
                    return false;
                }
                JA.aWg = this.bVc != null ? this.bVc.Jd() : null;
                if (JA.aWg == null) {
                    return false;
                }
                JA.aWg.aXn = JA.Hb();
                com.baidu.live.yuyingift.b.b.Zu().a(JA, JB, this.bUT.mUserId, this.bUT.mUserName, this.bUT.mLiveId, this.bUT.mRoomId, this.bUT.mAppId, this.bUT.bdh, this.bUT.otherParams, 0L, r.aj(ZB().bVX));
                this.bgM -= j;
                this.bVb.aO(this.bgM);
                closeActivity();
            } else if (JA.Hi()) {
                if (this.bgN <= 0 || this.bgN < j) {
                    BdUtilHelper.showToast(getPageContext().getPageActivity(), getPageContext().getResources().getString(a.h.ala_free_gift_flower_no_enough), 1000);
                    return false;
                }
                com.baidu.live.yuyingift.b.b.Zu().a(JA, JB, this.bUT.mUserId, this.bUT.mUserName, this.bUT.mLiveId, this.bUT.mRoomId, this.bUT.mAppId, this.bUT.bdh, this.bUT.otherParams, 0L, r.aj(ZB().bVX));
                this.bgN -= j;
                this.bVb.aP(this.bgN);
            } else if (this.bgM <= 0 || this.bgM < j) {
                Lc();
                return false;
            } else {
                com.baidu.live.yuyingift.b.b.Zu().a(JA, JB, this.bUT.mUserId, this.bUT.mUserName, this.bUT.mLiveId, this.bUT.mRoomId, this.bUT.mAppId, this.bUT.bdh, this.bUT.otherParams, 0L, r.aj(ZB().bVX));
                this.bgM -= j;
                this.bVb.aO(this.bgM);
            }
        }
        return true;
    }

    @Override // com.baidu.live.yuyingift.panel.b
    protected void Li() {
        this.bVe.hE(this.bUT.bdj);
    }

    private void Lk() {
        this.bgP = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA) { // from class: com.baidu.live.yuyingift.panel.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (c.this.bVb != null) {
                    c.this.bgM = TbadkCoreApplication.getInst().currentAccountTdouNum;
                    c.this.bgN = TbadkCoreApplication.getInst().currentAccountFlowerNum;
                    c.this.bVb.aO(TbadkCoreApplication.getInst().currentAccountTdouNum);
                    c.this.bVb.aP(TbadkCoreApplication.getInst().currentAccountFlowerNum);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bgP);
    }

    private void Ll() {
        this.bcf = new CustomMessageListener(2913120) { // from class: com.baidu.live.yuyingift.panel.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                c.this.bbc = true;
            }
        };
        MessageManager.getInstance().registerListener(this.bcf);
    }
}

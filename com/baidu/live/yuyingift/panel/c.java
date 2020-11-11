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
import com.baidu.live.data.y;
import com.baidu.live.gift.g;
import com.baidu.live.gift.h;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.utils.r;
import com.baidu.live.yuyingift.container.e;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class c extends b {
    private com.baidu.live.yuyingift.container.e bRE;
    private CustomMessageListener bav;
    private CustomMessageListener beC;
    private long bez = 0;
    private long beA = 0;
    private e.a bQl = new e.a() { // from class: com.baidu.live.yuyingift.panel.c.3
        @Override // com.baidu.live.yuyingift.container.e.a
        public void b(int i, String str, boolean z, ArrayList<h> arrayList, ArrayList<com.baidu.live.data.h> arrayList2, ArrayList<j> arrayList3, y yVar) {
            if (i != 0 && !StringUtils.isNull(str)) {
                BdUtilHelper.showToast(TbadkCoreApplication.getInst(), str);
            }
            c.this.bRB.a(z, arrayList, arrayList2, arrayList3, i == 0, i);
            c.this.bRB.b(yVar);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.yuyingift.panel.b, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInflate(View view, Bundle bundle) {
        super.onInflate(view, bundle);
        this.bRB.setType(0);
        this.bRB.bQq.setText("赠送");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.yuyingift.panel.b, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInitial() {
        super.onInitial();
        this.bez = TbadkCoreApplication.getInst().currentAccountTdouNum;
        this.beA = TbadkCoreApplication.getInst().currentAccountFlowerNum;
        JS();
        JT();
        this.bRE = new com.baidu.live.yuyingift.container.e(getPageContext(), this.bRt.bbw);
        this.bRE.a(this.bQl);
        this.bRE.ho(this.bRt.bbv);
    }

    @Override // com.baidu.live.yuyingift.panel.b, com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.beC);
        MessageManager.getInstance().unRegisterListener(this.bav);
    }

    @Override // com.baidu.live.yuyingift.panel.b
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

    @Override // com.baidu.live.yuyingift.panel.b
    protected boolean JP() {
        g Is = this.bRB.Is();
        if (Is == null) {
            return false;
        }
        if (b(Is) && !this.aZv) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913179));
            return false;
        }
        int i = this.bRt.aXZ;
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
        int It = this.bRB.It();
        if (a(Is, It)) {
            long j = JavaTypesHelper.toLong(Is.getPrice(), 0L) * It * XM();
            if (Is.Ga()) {
                if (this.bez <= 0 || this.bez < j) {
                    JK();
                    return false;
                }
                Is.aUN = this.bRC != null ? this.bRC.HV() : null;
                if (Is.aUN == null) {
                    return false;
                }
                Is.aUN.aVT = Is.FX();
                com.baidu.live.yuyingift.b.b.XE().a(Is, It, this.bRt.mUserId, this.bRt.mUserName, this.bRt.mLiveId, this.bRt.mRoomId, this.bRt.mAppId, this.bRt.bbt, this.bRt.otherParams, 0L, r.ah(XL().bSx));
                this.bez -= j;
                this.bRB.aq(this.bez);
                closeActivity();
            } else if (Is.Gd()) {
                if (this.beA <= 0 || this.beA < j) {
                    BdUtilHelper.showToast(getPageContext().getPageActivity(), getPageContext().getResources().getString(a.h.ala_free_gift_flower_no_enough), 1000);
                    return false;
                }
                com.baidu.live.yuyingift.b.b.XE().a(Is, It, this.bRt.mUserId, this.bRt.mUserName, this.bRt.mLiveId, this.bRt.mRoomId, this.bRt.mAppId, this.bRt.bbt, this.bRt.otherParams, 0L, r.ah(XL().bSx));
                this.beA -= j;
                this.bRB.ar(this.beA);
            } else if (this.bez <= 0 || this.bez < j) {
                JK();
                return false;
            } else {
                com.baidu.live.yuyingift.b.b.XE().a(Is, It, this.bRt.mUserId, this.bRt.mUserName, this.bRt.mLiveId, this.bRt.mRoomId, this.bRt.mAppId, this.bRt.bbt, this.bRt.otherParams, 0L, r.ah(XL().bSx));
                this.bez -= j;
                this.bRB.aq(this.bez);
            }
        }
        return true;
    }

    @Override // com.baidu.live.yuyingift.panel.b
    protected void JQ() {
        this.bRE.hp(this.bRt.bbv);
    }

    private void JS() {
        this.beC = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA) { // from class: com.baidu.live.yuyingift.panel.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (c.this.bRB != null) {
                    c.this.bez = TbadkCoreApplication.getInst().currentAccountTdouNum;
                    c.this.beA = TbadkCoreApplication.getInst().currentAccountFlowerNum;
                    c.this.bRB.aq(TbadkCoreApplication.getInst().currentAccountTdouNum);
                    c.this.bRB.ar(TbadkCoreApplication.getInst().currentAccountFlowerNum);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.beC);
    }

    private void JT() {
        this.bav = new CustomMessageListener(2913120) { // from class: com.baidu.live.yuyingift.panel.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                c.this.aZv = true;
            }
        };
        MessageManager.getInstance().registerListener(this.bav);
    }
}

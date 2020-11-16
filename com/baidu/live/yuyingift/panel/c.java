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
    private CustomMessageListener aYJ;
    private com.baidu.live.yuyingift.container.e bPU;
    private CustomMessageListener bcP;
    private long bcM = 0;
    private long bcN = 0;
    private e.a bOB = new e.a() { // from class: com.baidu.live.yuyingift.panel.c.3
        @Override // com.baidu.live.yuyingift.container.e.a
        public void b(int i, String str, boolean z, ArrayList<h> arrayList, ArrayList<com.baidu.live.data.h> arrayList2, ArrayList<j> arrayList3, y yVar) {
            if (i != 0 && !StringUtils.isNull(str)) {
                BdUtilHelper.showToast(TbadkCoreApplication.getInst(), str);
            }
            c.this.bPR.a(z, arrayList, arrayList2, arrayList3, i == 0, i);
            c.this.bPR.b(yVar);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.yuyingift.panel.b, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInflate(View view, Bundle bundle) {
        super.onInflate(view, bundle);
        this.bPR.setType(0);
        this.bPR.bOG.setText("赠送");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.yuyingift.panel.b, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInitial() {
        super.onInitial();
        this.bcM = TbadkCoreApplication.getInst().currentAccountTdouNum;
        this.bcN = TbadkCoreApplication.getInst().currentAccountFlowerNum;
        Jj();
        Jk();
        this.bPU = new com.baidu.live.yuyingift.container.e(getPageContext(), this.bPJ.aZK);
        this.bPU.a(this.bOB);
        this.bPU.hi(this.bPJ.aZJ);
    }

    @Override // com.baidu.live.yuyingift.panel.b, com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.bcP);
        MessageManager.getInstance().unRegisterListener(this.aYJ);
    }

    @Override // com.baidu.live.yuyingift.panel.b
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

    @Override // com.baidu.live.yuyingift.panel.b
    protected boolean Jg() {
        g HJ = this.bPR.HJ();
        if (HJ == null) {
            return false;
        }
        if (b(HJ) && !this.aXK) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913179));
            return false;
        }
        int i = this.bPJ.aWo;
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
        int HK = this.bPR.HK();
        if (a(HJ, HK)) {
            long j = JavaTypesHelper.toLong(HJ.getPrice(), 0L) * HK * Xd();
            if (HJ.Fr()) {
                if (this.bcM <= 0 || this.bcM < j) {
                    Jb();
                    return false;
                }
                HJ.aTc = this.bPS != null ? this.bPS.Hm() : null;
                if (HJ.aTc == null) {
                    return false;
                }
                HJ.aTc.aUi = HJ.Fo();
                com.baidu.live.yuyingift.b.b.WV().a(HJ, HK, this.bPJ.mUserId, this.bPJ.mUserName, this.bPJ.mLiveId, this.bPJ.mRoomId, this.bPJ.mAppId, this.bPJ.aZH, this.bPJ.otherParams, 0L, r.ah(Xc().bQN));
                this.bcM -= j;
                this.bPR.aq(this.bcM);
                closeActivity();
            } else if (HJ.Fu()) {
                if (this.bcN <= 0 || this.bcN < j) {
                    BdUtilHelper.showToast(getPageContext().getPageActivity(), getPageContext().getResources().getString(a.h.ala_free_gift_flower_no_enough), 1000);
                    return false;
                }
                com.baidu.live.yuyingift.b.b.WV().a(HJ, HK, this.bPJ.mUserId, this.bPJ.mUserName, this.bPJ.mLiveId, this.bPJ.mRoomId, this.bPJ.mAppId, this.bPJ.aZH, this.bPJ.otherParams, 0L, r.ah(Xc().bQN));
                this.bcN -= j;
                this.bPR.ar(this.bcN);
            } else if (this.bcM <= 0 || this.bcM < j) {
                Jb();
                return false;
            } else {
                com.baidu.live.yuyingift.b.b.WV().a(HJ, HK, this.bPJ.mUserId, this.bPJ.mUserName, this.bPJ.mLiveId, this.bPJ.mRoomId, this.bPJ.mAppId, this.bPJ.aZH, this.bPJ.otherParams, 0L, r.ah(Xc().bQN));
                this.bcM -= j;
                this.bPR.aq(this.bcM);
            }
        }
        return true;
    }

    @Override // com.baidu.live.yuyingift.panel.b
    protected void Jh() {
        this.bPU.hj(this.bPJ.aZJ);
    }

    private void Jj() {
        this.bcP = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA) { // from class: com.baidu.live.yuyingift.panel.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (c.this.bPR != null) {
                    c.this.bcM = TbadkCoreApplication.getInst().currentAccountTdouNum;
                    c.this.bcN = TbadkCoreApplication.getInst().currentAccountFlowerNum;
                    c.this.bPR.aq(TbadkCoreApplication.getInst().currentAccountTdouNum);
                    c.this.bPR.ar(TbadkCoreApplication.getInst().currentAccountFlowerNum);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bcP);
    }

    private void Jk() {
        this.aYJ = new CustomMessageListener(2913120) { // from class: com.baidu.live.yuyingift.panel.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                c.this.aXK = true;
            }
        };
        MessageManager.getInstance().registerListener(this.aYJ);
    }
}

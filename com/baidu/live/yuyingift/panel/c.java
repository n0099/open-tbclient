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
import com.baidu.live.data.aa;
import com.baidu.live.data.i;
import com.baidu.live.data.k;
import com.baidu.live.gift.g;
import com.baidu.live.gift.h;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.utils.s;
import com.baidu.live.yuyingift.container.e;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class c extends b {
    private CustomMessageListener bdN;
    private CustomMessageListener biy;
    private com.baidu.live.yuyingift.container.e cbd;
    private long biv = 0;
    private long biw = 0;
    private e.a bZx = new e.a() { // from class: com.baidu.live.yuyingift.panel.c.3
        @Override // com.baidu.live.yuyingift.container.e.a
        public void b(int i, String str, boolean z, ArrayList<h> arrayList, ArrayList<i> arrayList2, ArrayList<k> arrayList3, aa aaVar) {
            if (i != 0 && !StringUtils.isNull(str)) {
                BdUtilHelper.showToast(TbadkCoreApplication.getInst(), str);
            }
            c.this.caX.a(z, arrayList, arrayList2, arrayList3, i == 0, i);
            c.this.caX.b(aaVar);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.yuyingift.panel.b, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInflate(View view, Bundle bundle) {
        super.onInflate(view, bundle);
        this.caX.setType(0);
        this.caX.bZC.setText("赠送");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.yuyingift.panel.b, com.baidu.live.tbadk.core.fragment.LazyLoadFragment
    public void onInitial() {
        super.onInitial();
        this.biv = TbadkCoreApplication.getInst().currentAccountTdouNum;
        this.biw = TbadkCoreApplication.getInst().currentAccountFlowerNum;
        KJ();
        KK();
        this.cbd = new com.baidu.live.yuyingift.container.e(getPageContext(), this.caO.beV);
        this.cbd.a(this.bZx);
        this.cbd.ho(this.caO.beU);
    }

    @Override // com.baidu.live.yuyingift.panel.b, com.baidu.live.tbadk.core.fragment.LazyLoadFragment, com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.biy);
        MessageManager.getInstance().unRegisterListener(this.bdN);
    }

    @Override // com.baidu.live.yuyingift.panel.b
    protected boolean abh() {
        return true;
    }

    private boolean b(g gVar) {
        if (com.baidu.live.af.a.SE().bCb != null && com.baidu.live.af.a.SE().bCb.aRA != null) {
            String str = com.baidu.live.af.a.SE().bCb.aRA.aQR;
            if (!TextUtils.isEmpty(str) && str.equals(String.valueOf(gVar.GV()))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.live.yuyingift.panel.b
    protected boolean l(long j, int i) {
        g Jc = this.caX.Jc();
        if (Jc == null) {
            return false;
        }
        if (b(Jc) && !this.bcJ) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913179));
            return false;
        }
        int i2 = this.caO.bbl;
        if (Jc.Ha()) {
            if (Jc.GV() == 6 && i2 < 3) {
                return false;
            }
            if (Jc.GV() == 7 && i2 < 7) {
                return false;
            }
            if (Jc.GV() == 8 && i2 < 13) {
                return false;
            }
            if (Jc.GV() == 9 && i2 < 22) {
                return false;
            }
            if (Jc.GV() == 10 && i2 < 29) {
                return false;
            }
            if (Jc.GV() == 11 && i2 < 39) {
                return false;
            }
            if (Jc.GV() == 12 && i2 < 47) {
                return false;
            }
        }
        int Jd = this.caX.Jd();
        if (a(Jc, Jd)) {
            long j2 = JavaTypesHelper.toLong(Jc.getPrice(), 0L) * Jd * abf();
            if (Jc.GG()) {
                if (this.biv <= 0 || this.biv < j2) {
                    KC();
                    return false;
                }
                Jc.aXM = this.caY != null ? this.caY.IF() : null;
                if (Jc.aXM == null) {
                    return false;
                }
                Jc.aXM.aYS = Jc.GC();
                com.baidu.live.yuyingift.b.b.aaZ().a(Jc, Jd, this.caO.mUserId, this.caO.mUserName, this.caO.mLiveId, this.caO.mRoomId, this.caO.mAppId, this.caO.beS, this.caO.otherParams, 0L, s.ak(abe().ccd), this.cbb, this.cba);
                this.biv -= j2;
                this.caX.aN(this.biv);
                closeActivity();
            } else if (Jc.GJ()) {
                if (this.biw <= 0 || this.biw < j2) {
                    BdUtilHelper.showToast(getPageContext().getPageActivity(), getPageContext().getResources().getString(a.h.ala_free_gift_flower_no_enough), 1000);
                    return false;
                }
                com.baidu.live.yuyingift.b.b.aaZ().a(Jc, Jd, this.caO.mUserId, this.caO.mUserName, this.caO.mLiveId, this.caO.mRoomId, this.caO.mAppId, this.caO.beS, this.caO.otherParams, 0L, s.ak(abe().ccd), this.cbb, this.cba);
                this.biw -= j2;
                this.caX.aO(this.biw);
            } else if (this.biv <= 0 || this.biv < j2) {
                KC();
                return false;
            } else {
                com.baidu.live.yuyingift.b.b.aaZ().a(Jc, Jd, this.caO.mUserId, this.caO.mUserName, this.caO.mLiveId, this.caO.mRoomId, this.caO.mAppId, this.caO.beS, this.caO.otherParams, 0L, s.ak(abe().ccd), this.cbb, this.cba);
                this.biv -= j2;
                this.caX.aN(this.biv);
            }
        }
        return true;
    }

    @Override // com.baidu.live.yuyingift.panel.b
    protected void KH() {
        this.cbd.hp(this.caO.beU);
    }

    private void KJ() {
        this.biy = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA) { // from class: com.baidu.live.yuyingift.panel.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (c.this.caX != null) {
                    c.this.biv = TbadkCoreApplication.getInst().currentAccountTdouNum;
                    c.this.biw = TbadkCoreApplication.getInst().currentAccountFlowerNum;
                    c.this.caX.aN(TbadkCoreApplication.getInst().currentAccountTdouNum);
                    c.this.caX.aO(TbadkCoreApplication.getInst().currentAccountFlowerNum);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.biy);
    }

    private void KK() {
        this.bdN = new CustomMessageListener(2913120) { // from class: com.baidu.live.yuyingift.panel.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                c.this.bcJ = true;
            }
        };
        MessageManager.getInstance().registerListener(this.bdN);
    }
}

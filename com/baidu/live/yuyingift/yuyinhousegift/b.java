package com.baidu.live.yuyingift.yuyinhousegift;

import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.yuyingift.yuyinhousegift.a;
import com.baidu.live.yuyingift.yuyinhousegift.c;
import com.baidu.live.yuyingift.yuyinhousegift.view.YuyinAlaRoomBaseGiftView;
import com.baidu.live.yuyingift.yuyinhousegift.view.YuyinAlaRoomComboGiftView;
import com.baidu.live.yuyingift.yuyinhousegift.view.YuyinAlaRoomNormalGiftView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class b {
    protected com.baidu.live.yuyingift.a ccm;
    private a ccn;
    private c cco;
    private List<com.baidu.live.yuyingift.a.c> ccp;
    private com.baidu.live.yuyingift.a.c ccq;
    private com.baidu.live.yuyingift.a.c ccr;
    private boolean cct;

    public b(Context context, com.baidu.live.yuyingift.a aVar) {
        this.ccm = aVar;
        this.ccn = new a(context);
        this.cco = new c(context);
        this.ccn.a(new a.InterfaceC0247a() { // from class: com.baidu.live.yuyingift.yuyinhousegift.b.1
            @Override // com.baidu.live.yuyingift.yuyinhousegift.a.InterfaceC0247a
            public void a(YuyinAlaRoomComboGiftView yuyinAlaRoomComboGiftView) {
                b.this.a(yuyinAlaRoomComboGiftView);
            }

            @Override // com.baidu.live.yuyingift.yuyinhousegift.a.InterfaceC0247a
            public void abv() {
                b.this.abw();
            }

            @Override // com.baidu.live.yuyingift.yuyinhousegift.a.InterfaceC0247a
            public void b(YuyinAlaRoomComboGiftView yuyinAlaRoomComboGiftView) {
                b.this.b(yuyinAlaRoomComboGiftView);
            }
        });
        this.cco.a(new c.a() { // from class: com.baidu.live.yuyingift.yuyinhousegift.b.2
            @Override // com.baidu.live.yuyingift.yuyinhousegift.c.a
            public void a(YuyinAlaRoomNormalGiftView yuyinAlaRoomNormalGiftView) {
                b.this.a(yuyinAlaRoomNormalGiftView);
            }

            @Override // com.baidu.live.yuyingift.yuyinhousegift.c.a
            public void abv() {
                b.this.abw();
            }

            @Override // com.baidu.live.yuyingift.yuyinhousegift.c.a
            public void b(YuyinAlaRoomNormalGiftView yuyinAlaRoomNormalGiftView) {
                b.this.b(yuyinAlaRoomNormalGiftView);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009));
                com.baidu.live.yuyingift.b.g(b.this.ccq);
            }
        });
        initData();
    }

    public void dL(boolean z) {
        this.cct = z;
        if (!z && this.ccr != null) {
            com.baidu.live.yuyingift.b.g(this.ccr);
            this.ccr = null;
        }
    }

    private void initData() {
        this.ccp = new ArrayList();
    }

    private boolean a(com.baidu.live.yuyingift.a.c cVar, com.baidu.live.yuyingift.a.c cVar2, boolean z) {
        boolean z2 = false;
        if (cVar != null && cVar2 != null) {
            if (TextUtils.equals(cVar.giftId, cVar2.giftId) && TextUtils.equals(cVar.userId, cVar2.userId) && TextUtils.equals(cVar.boI, cVar2.boI)) {
                z2 = true;
            }
            if (z2 && z) {
                com.baidu.live.yuyingift.b.a(this.ccq, cVar2);
            }
        }
        return z2;
    }

    private boolean b(com.baidu.live.yuyingift.a.c cVar, com.baidu.live.yuyingift.a.c cVar2, boolean z) {
        return cVar != null && cVar2 != null && a(cVar, cVar2, z) && cVar.bZN && cVar2.bZN && cVar.aZQ == cVar2.aZQ && cVar2.bZO > 0;
    }

    private boolean v(com.baidu.live.yuyingift.a.c cVar) {
        return cVar != null && TextUtils.equals(cVar.userId, TbadkCoreApplication.getCurrentAccount());
    }

    public void h(com.baidu.live.yuyingift.a.c cVar) {
        if (cVar != null) {
            if (v(cVar)) {
                if (w(cVar) && this.cct) {
                    if (this.ccr == null) {
                        this.ccr = cVar;
                    } else if (b(this.ccr, cVar, false)) {
                        com.baidu.live.yuyingift.b.a(this.ccr, cVar);
                    }
                }
            } else if (cVar.bZP) {
                com.baidu.live.yuyingift.b.g(cVar);
                return;
            }
            this.ccp.add(cVar);
            abw();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abw() {
        if (!ListUtils.isEmpty(this.ccp)) {
            if (w(aby())) {
                if (this.ccn.isRunning()) {
                    while (b(this.ccn.getLastShowGift(), aby(), false)) {
                        this.ccn.q(abx());
                    }
                } else if (!this.cco.isRunning()) {
                    if (aby().bZO > 0) {
                        this.ccn.p(abx());
                    } else {
                        this.ccn.r(abx());
                    }
                }
            } else if (this.cco.isRunning()) {
                while (a(this.cco.getLastShowGift(), aby(), true)) {
                    this.cco.q(abx());
                }
            } else if (!this.ccn.isRunning()) {
                this.ccq = abx();
                this.cco.r(this.ccq);
            }
        }
    }

    private boolean w(com.baidu.live.yuyingift.a.c cVar) {
        if (cVar != null) {
            return cVar.bZN;
        }
        return false;
    }

    protected void a(YuyinAlaRoomBaseGiftView yuyinAlaRoomBaseGiftView) {
        if (yuyinAlaRoomBaseGiftView != null) {
            yuyinAlaRoomBaseGiftView.setZ(com.baidu.live.yuyingift.a.bYE);
            try {
                this.ccm.a(yuyinAlaRoomBaseGiftView, new RelativeLayout.LayoutParams(-1, -1));
            } catch (Exception e) {
            }
        }
    }

    protected void b(YuyinAlaRoomBaseGiftView yuyinAlaRoomBaseGiftView) {
        try {
            if (this.ccm != null) {
                this.ccm.an(yuyinAlaRoomBaseGiftView);
            }
        } catch (Exception e) {
        }
    }

    private com.baidu.live.yuyingift.a.c abx() {
        if (this.ccp == null || this.ccp.isEmpty()) {
            return null;
        }
        return this.ccp.remove(0);
    }

    private com.baidu.live.yuyingift.a.c aby() {
        if (this.ccp == null || this.ccp.isEmpty()) {
            return null;
        }
        return this.ccp.get(0);
    }

    public void onDestory() {
        if (this.ccp != null) {
            this.ccp.clear();
        }
        if (this.ccn != null) {
            this.ccn.onDestory();
        }
        if (this.cco != null) {
            this.cco.onDestory();
        }
    }
}

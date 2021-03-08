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
/* loaded from: classes10.dex */
public class b {
    protected com.baidu.live.yuyingift.a cdd;
    private a cde;
    private c cdf;
    private List<com.baidu.live.yuyingift.a.c> cdg;
    private com.baidu.live.yuyingift.a.c cdh;
    private com.baidu.live.yuyingift.a.c cdi;
    private boolean cdj;

    public b(Context context, com.baidu.live.yuyingift.a aVar) {
        this.cdd = aVar;
        this.cde = new a(context);
        this.cdf = new c(context);
        this.cde.a(new a.InterfaceC0245a() { // from class: com.baidu.live.yuyingift.yuyinhousegift.b.1
            @Override // com.baidu.live.yuyingift.yuyinhousegift.a.InterfaceC0245a
            public void a(YuyinAlaRoomComboGiftView yuyinAlaRoomComboGiftView) {
                b.this.a(yuyinAlaRoomComboGiftView);
            }

            @Override // com.baidu.live.yuyingift.yuyinhousegift.a.InterfaceC0245a
            public void Zv() {
                b.this.Zw();
            }

            @Override // com.baidu.live.yuyingift.yuyinhousegift.a.InterfaceC0245a
            public void b(YuyinAlaRoomComboGiftView yuyinAlaRoomComboGiftView) {
                b.this.b(yuyinAlaRoomComboGiftView);
            }
        });
        this.cdf.a(new c.a() { // from class: com.baidu.live.yuyingift.yuyinhousegift.b.2
            @Override // com.baidu.live.yuyingift.yuyinhousegift.c.a
            public void a(YuyinAlaRoomNormalGiftView yuyinAlaRoomNormalGiftView) {
                b.this.a(yuyinAlaRoomNormalGiftView);
            }

            @Override // com.baidu.live.yuyingift.yuyinhousegift.c.a
            public void Zv() {
                b.this.Zw();
            }

            @Override // com.baidu.live.yuyingift.yuyinhousegift.c.a
            public void b(YuyinAlaRoomNormalGiftView yuyinAlaRoomNormalGiftView) {
                b.this.b(yuyinAlaRoomNormalGiftView);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009));
                com.baidu.live.yuyingift.b.g(b.this.cdh);
            }
        });
        initData();
    }

    public void dP(boolean z) {
        this.cdj = z;
        if (!z && this.cdi != null) {
            com.baidu.live.yuyingift.b.g(this.cdi);
            this.cdi = null;
        }
    }

    private void initData() {
        this.cdg = new ArrayList();
    }

    private boolean a(com.baidu.live.yuyingift.a.c cVar, com.baidu.live.yuyingift.a.c cVar2, boolean z) {
        boolean z2 = false;
        if (cVar != null && cVar2 != null) {
            if (TextUtils.equals(cVar.giftId, cVar2.giftId) && TextUtils.equals(cVar.userId, cVar2.userId) && TextUtils.equals(cVar.boO, cVar2.boO)) {
                z2 = true;
            }
            if (z2 && z) {
                com.baidu.live.yuyingift.b.a(this.cdh, cVar2);
            }
        }
        return z2;
    }

    private boolean b(com.baidu.live.yuyingift.a.c cVar, com.baidu.live.yuyingift.a.c cVar2, boolean z) {
        return cVar != null && cVar2 != null && a(cVar, cVar2, z) && cVar.caD && cVar2.caD && cVar.aZL == cVar2.aZL && cVar2.caE > 0;
    }

    private boolean v(com.baidu.live.yuyingift.a.c cVar) {
        return cVar != null && TextUtils.equals(cVar.userId, TbadkCoreApplication.getCurrentAccount());
    }

    public void h(com.baidu.live.yuyingift.a.c cVar) {
        if (cVar != null) {
            if (v(cVar)) {
                if (w(cVar) && this.cdj) {
                    if (this.cdi == null) {
                        this.cdi = cVar;
                    } else if (b(this.cdi, cVar, false)) {
                        com.baidu.live.yuyingift.b.a(this.cdi, cVar);
                    }
                }
            } else if (cVar.caF) {
                com.baidu.live.yuyingift.b.g(cVar);
                return;
            }
            this.cdg.add(cVar);
            Zw();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zw() {
        if (!ListUtils.isEmpty(this.cdg)) {
            if (w(Zy())) {
                if (this.cde.isRunning()) {
                    while (b(this.cde.getLastShowGift(), Zy(), false)) {
                        this.cde.q(Zx());
                    }
                } else if (!this.cdf.isRunning()) {
                    if (Zy().caE > 0) {
                        this.cde.p(Zx());
                    } else {
                        this.cde.r(Zx());
                    }
                }
            } else if (this.cdf.isRunning()) {
                while (a(this.cdf.getLastShowGift(), Zy(), true)) {
                    this.cdf.q(Zx());
                }
            } else if (!this.cde.isRunning()) {
                this.cdh = Zx();
                this.cdf.r(this.cdh);
            }
        }
    }

    private boolean w(com.baidu.live.yuyingift.a.c cVar) {
        if (cVar != null) {
            return cVar.caD;
        }
        return false;
    }

    protected void a(YuyinAlaRoomBaseGiftView yuyinAlaRoomBaseGiftView) {
        if (yuyinAlaRoomBaseGiftView != null) {
            yuyinAlaRoomBaseGiftView.setZ(com.baidu.live.yuyingift.a.bZr);
            try {
                this.cdd.a(yuyinAlaRoomBaseGiftView, new RelativeLayout.LayoutParams(-1, -1));
            } catch (Exception e) {
            }
        }
    }

    protected void b(YuyinAlaRoomBaseGiftView yuyinAlaRoomBaseGiftView) {
        try {
            if (this.cdd != null) {
                this.cdd.ak(yuyinAlaRoomBaseGiftView);
            }
        } catch (Exception e) {
        }
    }

    private com.baidu.live.yuyingift.a.c Zx() {
        if (this.cdg == null || this.cdg.isEmpty()) {
            return null;
        }
        return this.cdg.remove(0);
    }

    private com.baidu.live.yuyingift.a.c Zy() {
        if (this.cdg == null || this.cdg.isEmpty()) {
            return null;
        }
        return this.cdg.get(0);
    }

    public void onDestory() {
        if (this.cdg != null) {
            this.cdg.clear();
        }
        if (this.cde != null) {
            this.cde.onDestory();
        }
        if (this.cdf != null) {
            this.cdf.onDestory();
        }
    }
}

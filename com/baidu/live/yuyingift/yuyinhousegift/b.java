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
    private a bXA;
    private c bXB;
    private List<com.baidu.live.yuyingift.a.c> bXC;
    private com.baidu.live.yuyingift.a.c bXD;
    private com.baidu.live.yuyingift.a.c bXE;
    private boolean bXF;
    protected com.baidu.live.yuyingift.a bXz;

    public b(Context context, com.baidu.live.yuyingift.a aVar) {
        this.bXz = aVar;
        this.bXA = new a(context);
        this.bXB = new c(context);
        this.bXA.a(new a.InterfaceC0238a() { // from class: com.baidu.live.yuyingift.yuyinhousegift.b.1
            @Override // com.baidu.live.yuyingift.yuyinhousegift.a.InterfaceC0238a
            public void a(YuyinAlaRoomComboGiftView yuyinAlaRoomComboGiftView) {
                b.this.a(yuyinAlaRoomComboGiftView);
            }

            @Override // com.baidu.live.yuyingift.yuyinhousegift.a.InterfaceC0238a
            public void XC() {
                b.this.XD();
            }

            @Override // com.baidu.live.yuyingift.yuyinhousegift.a.InterfaceC0238a
            public void b(YuyinAlaRoomComboGiftView yuyinAlaRoomComboGiftView) {
                b.this.b(yuyinAlaRoomComboGiftView);
            }
        });
        this.bXB.a(new c.a() { // from class: com.baidu.live.yuyingift.yuyinhousegift.b.2
            @Override // com.baidu.live.yuyingift.yuyinhousegift.c.a
            public void a(YuyinAlaRoomNormalGiftView yuyinAlaRoomNormalGiftView) {
                b.this.a(yuyinAlaRoomNormalGiftView);
            }

            @Override // com.baidu.live.yuyingift.yuyinhousegift.c.a
            public void XC() {
                b.this.XD();
            }

            @Override // com.baidu.live.yuyingift.yuyinhousegift.c.a
            public void b(YuyinAlaRoomNormalGiftView yuyinAlaRoomNormalGiftView) {
                b.this.b(yuyinAlaRoomNormalGiftView);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009));
                com.baidu.live.yuyingift.b.g(b.this.bXD);
            }
        });
        initData();
    }

    public void dH(boolean z) {
        this.bXF = z;
        if (!z && this.bXE != null) {
            com.baidu.live.yuyingift.b.g(this.bXE);
            this.bXE = null;
        }
    }

    private void initData() {
        this.bXC = new ArrayList();
    }

    private boolean a(com.baidu.live.yuyingift.a.c cVar, com.baidu.live.yuyingift.a.c cVar2, boolean z) {
        boolean z2 = false;
        if (cVar != null && cVar2 != null) {
            if (TextUtils.equals(cVar.giftId, cVar2.giftId) && TextUtils.equals(cVar.userId, cVar2.userId) && TextUtils.equals(cVar.bjV, cVar2.bjV)) {
                z2 = true;
            }
            if (z2 && z) {
                com.baidu.live.yuyingift.b.a(this.bXD, cVar2);
            }
        }
        return z2;
    }

    private boolean b(com.baidu.live.yuyingift.a.c cVar, com.baidu.live.yuyingift.a.c cVar2, boolean z) {
        return cVar != null && cVar2 != null && a(cVar, cVar2, z) && cVar.bVb && cVar2.bVb && cVar.aVd == cVar2.aVd && cVar2.bVc > 0;
    }

    private boolean v(com.baidu.live.yuyingift.a.c cVar) {
        return cVar != null && TextUtils.equals(cVar.userId, TbadkCoreApplication.getCurrentAccount());
    }

    public void h(com.baidu.live.yuyingift.a.c cVar) {
        if (cVar != null) {
            if (v(cVar)) {
                if (w(cVar) && this.bXF) {
                    if (this.bXE == null) {
                        this.bXE = cVar;
                    } else if (b(this.bXE, cVar, false)) {
                        com.baidu.live.yuyingift.b.a(this.bXE, cVar);
                    }
                }
            } else if (cVar.bVd) {
                com.baidu.live.yuyingift.b.g(cVar);
                return;
            }
            this.bXC.add(cVar);
            XD();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XD() {
        if (!ListUtils.isEmpty(this.bXC)) {
            if (w(XF())) {
                if (this.bXA.isRunning()) {
                    while (b(this.bXA.getLastShowGift(), XF(), false)) {
                        this.bXA.q(XE());
                    }
                } else if (!this.bXB.isRunning()) {
                    if (XF().bVc > 0) {
                        this.bXA.p(XE());
                    } else {
                        this.bXA.r(XE());
                    }
                }
            } else if (this.bXB.isRunning()) {
                while (a(this.bXB.getLastShowGift(), XF(), true)) {
                    this.bXB.q(XE());
                }
            } else if (!this.bXA.isRunning()) {
                this.bXD = XE();
                this.bXB.r(this.bXD);
            }
        }
    }

    private boolean w(com.baidu.live.yuyingift.a.c cVar) {
        if (cVar != null) {
            return cVar.bVb;
        }
        return false;
    }

    protected void a(YuyinAlaRoomBaseGiftView yuyinAlaRoomBaseGiftView) {
        if (yuyinAlaRoomBaseGiftView != null) {
            yuyinAlaRoomBaseGiftView.setZ(com.baidu.live.yuyingift.a.bTS);
            try {
                this.bXz.a(yuyinAlaRoomBaseGiftView, new RelativeLayout.LayoutParams(-1, -1));
            } catch (Exception e) {
            }
        }
    }

    protected void b(YuyinAlaRoomBaseGiftView yuyinAlaRoomBaseGiftView) {
        try {
            if (this.bXz != null) {
                this.bXz.an(yuyinAlaRoomBaseGiftView);
            }
        } catch (Exception e) {
        }
    }

    private com.baidu.live.yuyingift.a.c XE() {
        if (this.bXC == null || this.bXC.isEmpty()) {
            return null;
        }
        return this.bXC.remove(0);
    }

    private com.baidu.live.yuyingift.a.c XF() {
        if (this.bXC == null || this.bXC.isEmpty()) {
            return null;
        }
        return this.bXC.get(0);
    }

    public void onDestory() {
        if (this.bXC != null) {
            this.bXC.clear();
        }
        if (this.bXA != null) {
            this.bXA.onDestory();
        }
        if (this.bXB != null) {
            this.bXB.onDestory();
        }
    }
}

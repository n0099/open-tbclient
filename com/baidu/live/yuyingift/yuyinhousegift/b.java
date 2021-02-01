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
    protected com.baidu.live.yuyingift.a cbC;
    private a cbD;
    private c cbE;
    private List<com.baidu.live.yuyingift.a.c> cbF;
    private com.baidu.live.yuyingift.a.c cbG;
    private com.baidu.live.yuyingift.a.c cbH;
    private boolean cbI;

    public b(Context context, com.baidu.live.yuyingift.a aVar) {
        this.cbC = aVar;
        this.cbD = new a(context);
        this.cbE = new c(context);
        this.cbD.a(new a.InterfaceC0239a() { // from class: com.baidu.live.yuyingift.yuyinhousegift.b.1
            @Override // com.baidu.live.yuyingift.yuyinhousegift.a.InterfaceC0239a
            public void a(YuyinAlaRoomComboGiftView yuyinAlaRoomComboGiftView) {
                b.this.a(yuyinAlaRoomComboGiftView);
            }

            @Override // com.baidu.live.yuyingift.yuyinhousegift.a.InterfaceC0239a
            public void Zs() {
                b.this.Zt();
            }

            @Override // com.baidu.live.yuyingift.yuyinhousegift.a.InterfaceC0239a
            public void b(YuyinAlaRoomComboGiftView yuyinAlaRoomComboGiftView) {
                b.this.b(yuyinAlaRoomComboGiftView);
            }
        });
        this.cbE.a(new c.a() { // from class: com.baidu.live.yuyingift.yuyinhousegift.b.2
            @Override // com.baidu.live.yuyingift.yuyinhousegift.c.a
            public void a(YuyinAlaRoomNormalGiftView yuyinAlaRoomNormalGiftView) {
                b.this.a(yuyinAlaRoomNormalGiftView);
            }

            @Override // com.baidu.live.yuyingift.yuyinhousegift.c.a
            public void Zs() {
                b.this.Zt();
            }

            @Override // com.baidu.live.yuyingift.yuyinhousegift.c.a
            public void b(YuyinAlaRoomNormalGiftView yuyinAlaRoomNormalGiftView) {
                b.this.b(yuyinAlaRoomNormalGiftView);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009));
                com.baidu.live.yuyingift.b.g(b.this.cbG);
            }
        });
        initData();
    }

    public void dP(boolean z) {
        this.cbI = z;
        if (!z && this.cbH != null) {
            com.baidu.live.yuyingift.b.g(this.cbH);
            this.cbH = null;
        }
    }

    private void initData() {
        this.cbF = new ArrayList();
    }

    private boolean a(com.baidu.live.yuyingift.a.c cVar, com.baidu.live.yuyingift.a.c cVar2, boolean z) {
        boolean z2 = false;
        if (cVar != null && cVar2 != null) {
            if (TextUtils.equals(cVar.giftId, cVar2.giftId) && TextUtils.equals(cVar.userId, cVar2.userId) && TextUtils.equals(cVar.bno, cVar2.bno)) {
                z2 = true;
            }
            if (z2 && z) {
                com.baidu.live.yuyingift.b.a(this.cbG, cVar2);
            }
        }
        return z2;
    }

    private boolean b(com.baidu.live.yuyingift.a.c cVar, com.baidu.live.yuyingift.a.c cVar2, boolean z) {
        return cVar != null && cVar2 != null && a(cVar, cVar2, z) && cVar.bZd && cVar2.bZd && cVar.aYl == cVar2.aYl && cVar2.bZe > 0;
    }

    private boolean v(com.baidu.live.yuyingift.a.c cVar) {
        return cVar != null && TextUtils.equals(cVar.userId, TbadkCoreApplication.getCurrentAccount());
    }

    public void h(com.baidu.live.yuyingift.a.c cVar) {
        if (cVar != null) {
            if (v(cVar)) {
                if (w(cVar) && this.cbI) {
                    if (this.cbH == null) {
                        this.cbH = cVar;
                    } else if (b(this.cbH, cVar, false)) {
                        com.baidu.live.yuyingift.b.a(this.cbH, cVar);
                    }
                }
            } else if (cVar.bZf) {
                com.baidu.live.yuyingift.b.g(cVar);
                return;
            }
            this.cbF.add(cVar);
            Zt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zt() {
        if (!ListUtils.isEmpty(this.cbF)) {
            if (w(Zv())) {
                if (this.cbD.isRunning()) {
                    while (b(this.cbD.getLastShowGift(), Zv(), false)) {
                        this.cbD.q(Zu());
                    }
                } else if (!this.cbE.isRunning()) {
                    if (Zv().bZe > 0) {
                        this.cbD.p(Zu());
                    } else {
                        this.cbD.r(Zu());
                    }
                }
            } else if (this.cbE.isRunning()) {
                while (a(this.cbE.getLastShowGift(), Zv(), true)) {
                    this.cbE.q(Zu());
                }
            } else if (!this.cbD.isRunning()) {
                this.cbG = Zu();
                this.cbE.r(this.cbG);
            }
        }
    }

    private boolean w(com.baidu.live.yuyingift.a.c cVar) {
        if (cVar != null) {
            return cVar.bZd;
        }
        return false;
    }

    protected void a(YuyinAlaRoomBaseGiftView yuyinAlaRoomBaseGiftView) {
        if (yuyinAlaRoomBaseGiftView != null) {
            yuyinAlaRoomBaseGiftView.setZ(com.baidu.live.yuyingift.a.bXR);
            try {
                this.cbC.a(yuyinAlaRoomBaseGiftView, new RelativeLayout.LayoutParams(-1, -1));
            } catch (Exception e) {
            }
        }
    }

    protected void b(YuyinAlaRoomBaseGiftView yuyinAlaRoomBaseGiftView) {
        try {
            if (this.cbC != null) {
                this.cbC.ak(yuyinAlaRoomBaseGiftView);
            }
        } catch (Exception e) {
        }
    }

    private com.baidu.live.yuyingift.a.c Zu() {
        if (this.cbF == null || this.cbF.isEmpty()) {
            return null;
        }
        return this.cbF.remove(0);
    }

    private com.baidu.live.yuyingift.a.c Zv() {
        if (this.cbF == null || this.cbF.isEmpty()) {
            return null;
        }
        return this.cbF.get(0);
    }

    public void onDestory() {
        if (this.cbF != null) {
            this.cbF.clear();
        }
        if (this.cbD != null) {
            this.cbD.onDestory();
        }
        if (this.cbE != null) {
            this.cbE.onDestory();
        }
    }
}

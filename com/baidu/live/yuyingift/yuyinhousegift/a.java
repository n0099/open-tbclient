package com.baidu.live.yuyingift.yuyinhousegift;

import android.content.Context;
import com.baidu.live.yuyingift.yuyinhousegift.view.YuyinAlaRoomComboGiftView;
/* loaded from: classes11.dex */
public class a extends d {
    private YuyinAlaRoomComboGiftView ccj;
    private InterfaceC0247a cck;

    /* renamed from: com.baidu.live.yuyingift.yuyinhousegift.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0247a {
        void a(YuyinAlaRoomComboGiftView yuyinAlaRoomComboGiftView);

        void abv();

        void b(YuyinAlaRoomComboGiftView yuyinAlaRoomComboGiftView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Context context) {
        super(context);
        init();
    }

    private void init() {
        this.ccj = new YuyinAlaRoomComboGiftView(this.mContext);
        this.ccj.setAnimCallback(new YuyinAlaRoomComboGiftView.a() { // from class: com.baidu.live.yuyingift.yuyinhousegift.a.1
            @Override // com.baidu.live.yuyingift.yuyinhousegift.view.YuyinAlaRoomComboGiftView.a
            public void s(com.baidu.live.yuyingift.a.c cVar) {
                if (a.this.cck != null) {
                    a.this.cck.a(a.this.ccj);
                }
            }

            @Override // com.baidu.live.yuyingift.yuyinhousegift.view.YuyinAlaRoomComboGiftView.a
            public void t(com.baidu.live.yuyingift.a.c cVar) {
                if (a.this.cck != null) {
                    a.this.cck.abv();
                }
            }

            @Override // com.baidu.live.yuyingift.yuyinhousegift.view.YuyinAlaRoomComboGiftView.a
            public void u(com.baidu.live.yuyingift.a.c cVar) {
                if (a.this.cck != null) {
                    a.this.cck.b(a.this.ccj);
                }
                if (a.this.cck != null) {
                    a.this.cck.abv();
                }
            }
        });
    }

    public void p(com.baidu.live.yuyingift.a.c cVar) {
        if (this.ccj != null) {
            this.ccj.b(cVar, x(cVar), false);
        }
    }

    public void q(com.baidu.live.yuyingift.a.c cVar) {
        if (this.ccj != null) {
            this.ccj.q(cVar);
        }
    }

    public com.baidu.live.yuyingift.a.c getLastShowGift() {
        if (this.ccj != null) {
            return this.ccj.getLastShowGift();
        }
        return null;
    }

    public boolean isRunning() {
        return this.ccj != null && this.ccj.abC();
    }

    public void r(com.baidu.live.yuyingift.a.c cVar) {
        if (this.ccj != null) {
            this.ccj.b(cVar, x(cVar), true);
        }
    }

    public void a(InterfaceC0247a interfaceC0247a) {
        this.cck = interfaceC0247a;
    }

    public void onDestory() {
        if (this.ccj != null) {
            this.ccj.onDestory();
        }
    }
}

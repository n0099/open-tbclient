package com.baidu.live.yuyingift.yuyinhousegift;

import android.content.Context;
import com.baidu.live.yuyingift.yuyinhousegift.view.YuyinAlaRoomComboGiftView;
/* loaded from: classes10.dex */
public class a extends d {
    private YuyinAlaRoomComboGiftView bXw;
    private InterfaceC0238a bXx;

    /* renamed from: com.baidu.live.yuyingift.yuyinhousegift.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0238a {
        void XC();

        void a(YuyinAlaRoomComboGiftView yuyinAlaRoomComboGiftView);

        void b(YuyinAlaRoomComboGiftView yuyinAlaRoomComboGiftView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Context context) {
        super(context);
        init();
    }

    private void init() {
        this.bXw = new YuyinAlaRoomComboGiftView(this.mContext);
        this.bXw.setAnimCallback(new YuyinAlaRoomComboGiftView.a() { // from class: com.baidu.live.yuyingift.yuyinhousegift.a.1
            @Override // com.baidu.live.yuyingift.yuyinhousegift.view.YuyinAlaRoomComboGiftView.a
            public void s(com.baidu.live.yuyingift.a.c cVar) {
                if (a.this.bXx != null) {
                    a.this.bXx.a(a.this.bXw);
                }
            }

            @Override // com.baidu.live.yuyingift.yuyinhousegift.view.YuyinAlaRoomComboGiftView.a
            public void t(com.baidu.live.yuyingift.a.c cVar) {
                if (a.this.bXx != null) {
                    a.this.bXx.XC();
                }
            }

            @Override // com.baidu.live.yuyingift.yuyinhousegift.view.YuyinAlaRoomComboGiftView.a
            public void u(com.baidu.live.yuyingift.a.c cVar) {
                if (a.this.bXx != null) {
                    a.this.bXx.b(a.this.bXw);
                }
                if (a.this.bXx != null) {
                    a.this.bXx.XC();
                }
            }
        });
    }

    public void p(com.baidu.live.yuyingift.a.c cVar) {
        if (this.bXw != null) {
            this.bXw.b(cVar, x(cVar), false);
        }
    }

    public void q(com.baidu.live.yuyingift.a.c cVar) {
        if (this.bXw != null) {
            this.bXw.q(cVar);
        }
    }

    public com.baidu.live.yuyingift.a.c getLastShowGift() {
        if (this.bXw != null) {
            return this.bXw.getLastShowGift();
        }
        return null;
    }

    public boolean isRunning() {
        return this.bXw != null && this.bXw.XJ();
    }

    public void r(com.baidu.live.yuyingift.a.c cVar) {
        if (this.bXw != null) {
            this.bXw.b(cVar, x(cVar), true);
        }
    }

    public void a(InterfaceC0238a interfaceC0238a) {
        this.bXx = interfaceC0238a;
    }

    public void onDestory() {
        if (this.bXw != null) {
            this.bXw.onDestory();
        }
    }
}

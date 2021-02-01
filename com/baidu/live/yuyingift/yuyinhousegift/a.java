package com.baidu.live.yuyingift.yuyinhousegift;

import android.content.Context;
import com.baidu.live.yuyingift.yuyinhousegift.view.YuyinAlaRoomComboGiftView;
/* loaded from: classes11.dex */
public class a extends d {
    private InterfaceC0239a cbA;
    private YuyinAlaRoomComboGiftView cbz;

    /* renamed from: com.baidu.live.yuyingift.yuyinhousegift.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0239a {
        void Zs();

        void a(YuyinAlaRoomComboGiftView yuyinAlaRoomComboGiftView);

        void b(YuyinAlaRoomComboGiftView yuyinAlaRoomComboGiftView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Context context) {
        super(context);
        init();
    }

    private void init() {
        this.cbz = new YuyinAlaRoomComboGiftView(this.mContext);
        this.cbz.setAnimCallback(new YuyinAlaRoomComboGiftView.a() { // from class: com.baidu.live.yuyingift.yuyinhousegift.a.1
            @Override // com.baidu.live.yuyingift.yuyinhousegift.view.YuyinAlaRoomComboGiftView.a
            public void s(com.baidu.live.yuyingift.a.c cVar) {
                if (a.this.cbA != null) {
                    a.this.cbA.a(a.this.cbz);
                }
            }

            @Override // com.baidu.live.yuyingift.yuyinhousegift.view.YuyinAlaRoomComboGiftView.a
            public void t(com.baidu.live.yuyingift.a.c cVar) {
                if (a.this.cbA != null) {
                    a.this.cbA.Zs();
                }
            }

            @Override // com.baidu.live.yuyingift.yuyinhousegift.view.YuyinAlaRoomComboGiftView.a
            public void u(com.baidu.live.yuyingift.a.c cVar) {
                if (a.this.cbA != null) {
                    a.this.cbA.b(a.this.cbz);
                }
                if (a.this.cbA != null) {
                    a.this.cbA.Zs();
                }
            }
        });
    }

    public void p(com.baidu.live.yuyingift.a.c cVar) {
        if (this.cbz != null) {
            this.cbz.b(cVar, x(cVar), false);
        }
    }

    public void q(com.baidu.live.yuyingift.a.c cVar) {
        if (this.cbz != null) {
            this.cbz.q(cVar);
        }
    }

    public com.baidu.live.yuyingift.a.c getLastShowGift() {
        if (this.cbz != null) {
            return this.cbz.getLastShowGift();
        }
        return null;
    }

    public boolean isRunning() {
        return this.cbz != null && this.cbz.Zz();
    }

    public void r(com.baidu.live.yuyingift.a.c cVar) {
        if (this.cbz != null) {
            this.cbz.b(cVar, x(cVar), true);
        }
    }

    public void a(InterfaceC0239a interfaceC0239a) {
        this.cbA = interfaceC0239a;
    }

    public void onDestory() {
        if (this.cbz != null) {
            this.cbz.onDestory();
        }
    }
}

package com.baidu.live.yuyingift.yuyinhousegift;

import android.content.Context;
import com.baidu.live.yuyingift.yuyinhousegift.view.YuyinAlaRoomNormalGiftView;
/* loaded from: classes10.dex */
public class c extends d {
    private YuyinAlaRoomNormalGiftView cdl;
    protected a cdm;

    /* loaded from: classes10.dex */
    public interface a {
        void Zv();

        void a(YuyinAlaRoomNormalGiftView yuyinAlaRoomNormalGiftView);

        void b(YuyinAlaRoomNormalGiftView yuyinAlaRoomNormalGiftView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c(Context context) {
        super(context);
        init();
    }

    public void q(com.baidu.live.yuyingift.a.c cVar) {
        if (this.cdl != null) {
            this.cdl.q(cVar);
        }
    }

    public com.baidu.live.yuyingift.a.c getLastShowGift() {
        return this.cdl.getLastShowGift();
    }

    public boolean isRunning() {
        return this.cdl != null && this.cdl.ZC();
    }

    public void r(com.baidu.live.yuyingift.a.c cVar) {
        if (this.cdl != null) {
            this.cdl.b(cVar, x(cVar), true);
        }
    }

    private void init() {
        this.cdl = new YuyinAlaRoomNormalGiftView(this.mContext);
        this.cdl.setAnimCallback(new YuyinAlaRoomNormalGiftView.a() { // from class: com.baidu.live.yuyingift.yuyinhousegift.c.1
            @Override // com.baidu.live.yuyingift.yuyinhousegift.view.YuyinAlaRoomNormalGiftView.a
            public void s(com.baidu.live.yuyingift.a.c cVar) {
                if (c.this.cdm != null) {
                    c.this.cdm.a(c.this.cdl);
                }
            }

            @Override // com.baidu.live.yuyingift.yuyinhousegift.view.YuyinAlaRoomNormalGiftView.a
            public void t(com.baidu.live.yuyingift.a.c cVar) {
                if (c.this.cdm != null) {
                    c.this.cdm.Zv();
                }
            }

            @Override // com.baidu.live.yuyingift.yuyinhousegift.view.YuyinAlaRoomNormalGiftView.a
            public void u(com.baidu.live.yuyingift.a.c cVar) {
                if (c.this.cdm != null) {
                    c.this.cdm.b(c.this.cdl);
                    c.this.cdm.Zv();
                }
            }
        });
    }

    public void a(a aVar) {
        this.cdm = aVar;
    }

    public void onDestory() {
        if (this.cdl != null) {
            this.cdl.onDestory();
        }
    }
}

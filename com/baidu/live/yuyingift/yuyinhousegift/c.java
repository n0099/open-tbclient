package com.baidu.live.yuyingift.yuyinhousegift;

import android.content.Context;
import com.baidu.live.yuyingift.yuyinhousegift.view.YuyinAlaRoomNormalGiftView;
/* loaded from: classes11.dex */
public class c extends d {
    private YuyinAlaRoomNormalGiftView ccv;
    protected a ccw;

    /* loaded from: classes11.dex */
    public interface a {
        void a(YuyinAlaRoomNormalGiftView yuyinAlaRoomNormalGiftView);

        void abv();

        void b(YuyinAlaRoomNormalGiftView yuyinAlaRoomNormalGiftView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c(Context context) {
        super(context);
        init();
    }

    public void q(com.baidu.live.yuyingift.a.c cVar) {
        if (this.ccv != null) {
            this.ccv.q(cVar);
        }
    }

    public com.baidu.live.yuyingift.a.c getLastShowGift() {
        return this.ccv.getLastShowGift();
    }

    public boolean isRunning() {
        return this.ccv != null && this.ccv.abC();
    }

    public void r(com.baidu.live.yuyingift.a.c cVar) {
        if (this.ccv != null) {
            this.ccv.b(cVar, x(cVar), true);
        }
    }

    private void init() {
        this.ccv = new YuyinAlaRoomNormalGiftView(this.mContext);
        this.ccv.setAnimCallback(new YuyinAlaRoomNormalGiftView.a() { // from class: com.baidu.live.yuyingift.yuyinhousegift.c.1
            @Override // com.baidu.live.yuyingift.yuyinhousegift.view.YuyinAlaRoomNormalGiftView.a
            public void s(com.baidu.live.yuyingift.a.c cVar) {
                if (c.this.ccw != null) {
                    c.this.ccw.a(c.this.ccv);
                }
            }

            @Override // com.baidu.live.yuyingift.yuyinhousegift.view.YuyinAlaRoomNormalGiftView.a
            public void t(com.baidu.live.yuyingift.a.c cVar) {
                if (c.this.ccw != null) {
                    c.this.ccw.abv();
                }
            }

            @Override // com.baidu.live.yuyingift.yuyinhousegift.view.YuyinAlaRoomNormalGiftView.a
            public void u(com.baidu.live.yuyingift.a.c cVar) {
                if (c.this.ccw != null) {
                    c.this.ccw.b(c.this.ccv);
                    c.this.ccw.abv();
                }
            }
        });
    }

    public void a(a aVar) {
        this.ccw = aVar;
    }

    public void onDestory() {
        if (this.ccv != null) {
            this.ccv.onDestory();
        }
    }
}

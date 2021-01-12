package com.baidu.live.yuyingift.yuyinhousegift;

import android.content.Context;
import com.baidu.live.yuyingift.yuyinhousegift.view.YuyinAlaRoomNormalGiftView;
/* loaded from: classes10.dex */
public class c extends d {
    private YuyinAlaRoomNormalGiftView bXH;
    protected a bXI;

    /* loaded from: classes10.dex */
    public interface a {
        void XC();

        void a(YuyinAlaRoomNormalGiftView yuyinAlaRoomNormalGiftView);

        void b(YuyinAlaRoomNormalGiftView yuyinAlaRoomNormalGiftView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c(Context context) {
        super(context);
        init();
    }

    public void q(com.baidu.live.yuyingift.a.c cVar) {
        if (this.bXH != null) {
            this.bXH.q(cVar);
        }
    }

    public com.baidu.live.yuyingift.a.c getLastShowGift() {
        return this.bXH.getLastShowGift();
    }

    public boolean isRunning() {
        return this.bXH != null && this.bXH.XJ();
    }

    public void r(com.baidu.live.yuyingift.a.c cVar) {
        if (this.bXH != null) {
            this.bXH.b(cVar, x(cVar), true);
        }
    }

    private void init() {
        this.bXH = new YuyinAlaRoomNormalGiftView(this.mContext);
        this.bXH.setAnimCallback(new YuyinAlaRoomNormalGiftView.a() { // from class: com.baidu.live.yuyingift.yuyinhousegift.c.1
            @Override // com.baidu.live.yuyingift.yuyinhousegift.view.YuyinAlaRoomNormalGiftView.a
            public void s(com.baidu.live.yuyingift.a.c cVar) {
                if (c.this.bXI != null) {
                    c.this.bXI.a(c.this.bXH);
                }
            }

            @Override // com.baidu.live.yuyingift.yuyinhousegift.view.YuyinAlaRoomNormalGiftView.a
            public void t(com.baidu.live.yuyingift.a.c cVar) {
                if (c.this.bXI != null) {
                    c.this.bXI.XC();
                }
            }

            @Override // com.baidu.live.yuyingift.yuyinhousegift.view.YuyinAlaRoomNormalGiftView.a
            public void u(com.baidu.live.yuyingift.a.c cVar) {
                if (c.this.bXI != null) {
                    c.this.bXI.b(c.this.bXH);
                    c.this.bXI.XC();
                }
            }
        });
    }

    public void a(a aVar) {
        this.bXI = aVar;
    }

    public void onDestory() {
        if (this.bXH != null) {
            this.bXH.onDestory();
        }
    }
}

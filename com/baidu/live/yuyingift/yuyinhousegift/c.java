package com.baidu.live.yuyingift.yuyinhousegift;

import android.content.Context;
import com.baidu.live.yuyingift.yuyinhousegift.view.YuyinAlaRoomNormalGiftView;
/* loaded from: classes11.dex */
public class c extends d {
    private YuyinAlaRoomNormalGiftView cbK;
    protected a cbL;

    /* loaded from: classes11.dex */
    public interface a {
        void Zs();

        void a(YuyinAlaRoomNormalGiftView yuyinAlaRoomNormalGiftView);

        void b(YuyinAlaRoomNormalGiftView yuyinAlaRoomNormalGiftView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c(Context context) {
        super(context);
        init();
    }

    public void q(com.baidu.live.yuyingift.a.c cVar) {
        if (this.cbK != null) {
            this.cbK.q(cVar);
        }
    }

    public com.baidu.live.yuyingift.a.c getLastShowGift() {
        return this.cbK.getLastShowGift();
    }

    public boolean isRunning() {
        return this.cbK != null && this.cbK.Zz();
    }

    public void r(com.baidu.live.yuyingift.a.c cVar) {
        if (this.cbK != null) {
            this.cbK.b(cVar, x(cVar), true);
        }
    }

    private void init() {
        this.cbK = new YuyinAlaRoomNormalGiftView(this.mContext);
        this.cbK.setAnimCallback(new YuyinAlaRoomNormalGiftView.a() { // from class: com.baidu.live.yuyingift.yuyinhousegift.c.1
            @Override // com.baidu.live.yuyingift.yuyinhousegift.view.YuyinAlaRoomNormalGiftView.a
            public void s(com.baidu.live.yuyingift.a.c cVar) {
                if (c.this.cbL != null) {
                    c.this.cbL.a(c.this.cbK);
                }
            }

            @Override // com.baidu.live.yuyingift.yuyinhousegift.view.YuyinAlaRoomNormalGiftView.a
            public void t(com.baidu.live.yuyingift.a.c cVar) {
                if (c.this.cbL != null) {
                    c.this.cbL.Zs();
                }
            }

            @Override // com.baidu.live.yuyingift.yuyinhousegift.view.YuyinAlaRoomNormalGiftView.a
            public void u(com.baidu.live.yuyingift.a.c cVar) {
                if (c.this.cbL != null) {
                    c.this.cbL.b(c.this.cbK);
                    c.this.cbL.Zs();
                }
            }
        });
    }

    public void a(a aVar) {
        this.cbL = aVar;
    }

    public void onDestory() {
        if (this.cbK != null) {
            this.cbK.onDestory();
        }
    }
}

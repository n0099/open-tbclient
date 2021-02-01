package com.baidu.live.yuyingift.yuyinhousegift.view;

import android.content.Context;
import com.baidu.live.yuyingift.a.c;
/* loaded from: classes11.dex */
public class YuyinAlaRoomNormalGiftView extends YuyinAlaRoomBaseGiftView {
    protected a ccl;

    /* loaded from: classes11.dex */
    public interface a {
        void s(c cVar);

        void t(c cVar);

        void u(c cVar);
    }

    public YuyinAlaRoomNormalGiftView(Context context) {
        super(context);
    }

    @Override // com.baidu.live.yuyingift.yuyinhousegift.view.YuyinAlaRoomBaseGiftView
    protected void ZA() {
        if (this.ccl != null) {
            this.ccl.s(this.bZu);
        }
    }

    @Override // com.baidu.live.yuyingift.yuyinhousegift.view.YuyinAlaRoomBaseGiftView
    protected void ZB() {
        if (this.ccl != null) {
            this.ccl.t(getLastShowGift());
        }
    }

    public void setAnimCallback(a aVar) {
        this.ccl = aVar;
    }

    @Override // com.baidu.live.yuyingift.yuyinhousegift.view.YuyinAlaRoomBaseGiftView
    protected void ZC() {
        if (this.ccl != null) {
            this.ccl.u(getLastShowGift());
        }
    }
}

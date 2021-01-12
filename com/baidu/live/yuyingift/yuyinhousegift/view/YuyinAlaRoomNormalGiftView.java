package com.baidu.live.yuyingift.yuyinhousegift.view;

import android.content.Context;
import com.baidu.live.yuyingift.a.c;
/* loaded from: classes10.dex */
public class YuyinAlaRoomNormalGiftView extends YuyinAlaRoomBaseGiftView {
    protected a bYi;

    /* loaded from: classes10.dex */
    public interface a {
        void s(c cVar);

        void t(c cVar);

        void u(c cVar);
    }

    public YuyinAlaRoomNormalGiftView(Context context) {
        super(context);
    }

    @Override // com.baidu.live.yuyingift.yuyinhousegift.view.YuyinAlaRoomBaseGiftView
    protected void XK() {
        if (this.bYi != null) {
            this.bYi.s(this.bVs);
        }
    }

    @Override // com.baidu.live.yuyingift.yuyinhousegift.view.YuyinAlaRoomBaseGiftView
    protected void XL() {
        if (this.bYi != null) {
            this.bYi.t(getLastShowGift());
        }
    }

    public void setAnimCallback(a aVar) {
        this.bYi = aVar;
    }

    @Override // com.baidu.live.yuyingift.yuyinhousegift.view.YuyinAlaRoomBaseGiftView
    protected void XM() {
        if (this.bYi != null) {
            this.bYi.u(getLastShowGift());
        }
    }
}

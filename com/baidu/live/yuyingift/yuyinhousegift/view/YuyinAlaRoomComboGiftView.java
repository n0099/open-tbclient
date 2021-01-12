package com.baidu.live.yuyingift.yuyinhousegift.view;

import android.content.Context;
import com.baidu.live.yuyingift.a.c;
/* loaded from: classes10.dex */
public class YuyinAlaRoomComboGiftView extends YuyinAlaRoomBaseGiftView {
    protected a bYh;

    /* loaded from: classes10.dex */
    public interface a {
        void s(c cVar);

        void t(c cVar);

        void u(c cVar);
    }

    public YuyinAlaRoomComboGiftView(Context context) {
        super(context);
    }

    @Override // com.baidu.live.yuyingift.yuyinhousegift.view.YuyinAlaRoomBaseGiftView
    protected void XM() {
        if (this.bYh != null) {
            this.bYh.u(getLastShowGift());
        }
    }

    @Override // com.baidu.live.yuyingift.yuyinhousegift.view.YuyinAlaRoomBaseGiftView
    protected void XK() {
        if (this.bYh != null) {
            this.bYh.s(getLastShowGift());
        }
    }

    @Override // com.baidu.live.yuyingift.yuyinhousegift.view.YuyinAlaRoomBaseGiftView
    protected void XL() {
        if (this.bYh != null) {
            this.bYh.t(getLastShowGift());
        }
    }

    public void setAnimCallback(a aVar) {
        this.bYh = aVar;
    }
}

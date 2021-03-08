package com.baidu.live.yuyingift.yuyinhousegift.view;

import android.content.Context;
import com.baidu.live.yuyingift.a.c;
/* loaded from: classes10.dex */
public class YuyinAlaRoomComboGiftView extends YuyinAlaRoomBaseGiftView {
    protected a cdN;

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
    protected void ZF() {
        if (this.cdN != null) {
            this.cdN.u(getLastShowGift());
        }
    }

    @Override // com.baidu.live.yuyingift.yuyinhousegift.view.YuyinAlaRoomBaseGiftView
    protected void ZD() {
        if (this.cdN != null) {
            this.cdN.s(getLastShowGift());
        }
    }

    @Override // com.baidu.live.yuyingift.yuyinhousegift.view.YuyinAlaRoomBaseGiftView
    protected void ZE() {
        if (this.cdN != null) {
            this.cdN.t(getLastShowGift());
        }
    }

    public void setAnimCallback(a aVar) {
        this.cdN = aVar;
    }
}

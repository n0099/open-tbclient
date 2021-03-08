package com.baidu.live.yuyingift.yuyinhousegift.view;

import android.content.Context;
import com.baidu.live.yuyingift.a.c;
/* loaded from: classes10.dex */
public class YuyinAlaRoomNormalGiftView extends YuyinAlaRoomBaseGiftView {
    protected a cdO;

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
    protected void ZD() {
        if (this.cdO != null) {
            this.cdO.s(this.caU);
        }
    }

    @Override // com.baidu.live.yuyingift.yuyinhousegift.view.YuyinAlaRoomBaseGiftView
    protected void ZE() {
        if (this.cdO != null) {
            this.cdO.t(getLastShowGift());
        }
    }

    public void setAnimCallback(a aVar) {
        this.cdO = aVar;
    }

    @Override // com.baidu.live.yuyingift.yuyinhousegift.view.YuyinAlaRoomBaseGiftView
    protected void ZF() {
        if (this.cdO != null) {
            this.cdO.u(getLastShowGift());
        }
    }
}

package com.baidu.live.yuyingift.yuyinhousegift.view;

import android.content.Context;
import com.baidu.live.yuyingift.a.c;
/* loaded from: classes11.dex */
public class YuyinAlaRoomNormalGiftView extends YuyinAlaRoomBaseGiftView {
    protected a ccW;

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
    protected void abD() {
        if (this.ccW != null) {
            this.ccW.s(this.cae);
        }
    }

    @Override // com.baidu.live.yuyingift.yuyinhousegift.view.YuyinAlaRoomBaseGiftView
    protected void abE() {
        if (this.ccW != null) {
            this.ccW.t(getLastShowGift());
        }
    }

    public void setAnimCallback(a aVar) {
        this.ccW = aVar;
    }

    @Override // com.baidu.live.yuyingift.yuyinhousegift.view.YuyinAlaRoomBaseGiftView
    protected void abF() {
        if (this.ccW != null) {
            this.ccW.u(getLastShowGift());
        }
    }
}

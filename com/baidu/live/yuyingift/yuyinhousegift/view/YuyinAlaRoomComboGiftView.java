package com.baidu.live.yuyingift.yuyinhousegift.view;

import android.content.Context;
import com.baidu.live.yuyingift.a.c;
/* loaded from: classes11.dex */
public class YuyinAlaRoomComboGiftView extends YuyinAlaRoomBaseGiftView {
    protected a ccV;

    /* loaded from: classes11.dex */
    public interface a {
        void s(c cVar);

        void t(c cVar);

        void u(c cVar);
    }

    public YuyinAlaRoomComboGiftView(Context context) {
        super(context);
    }

    @Override // com.baidu.live.yuyingift.yuyinhousegift.view.YuyinAlaRoomBaseGiftView
    protected void abE() {
        if (this.ccV != null) {
            this.ccV.u(getLastShowGift());
        }
    }

    @Override // com.baidu.live.yuyingift.yuyinhousegift.view.YuyinAlaRoomBaseGiftView
    protected void abC() {
        if (this.ccV != null) {
            this.ccV.s(getLastShowGift());
        }
    }

    @Override // com.baidu.live.yuyingift.yuyinhousegift.view.YuyinAlaRoomBaseGiftView
    protected void abD() {
        if (this.ccV != null) {
            this.ccV.t(getLastShowGift());
        }
    }

    public void setAnimCallback(a aVar) {
        this.ccV = aVar;
    }
}

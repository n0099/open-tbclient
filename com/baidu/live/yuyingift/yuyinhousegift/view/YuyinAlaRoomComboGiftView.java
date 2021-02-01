package com.baidu.live.yuyingift.yuyinhousegift.view;

import android.content.Context;
import com.baidu.live.yuyingift.a.c;
/* loaded from: classes11.dex */
public class YuyinAlaRoomComboGiftView extends YuyinAlaRoomBaseGiftView {
    protected a cck;

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
    protected void ZC() {
        if (this.cck != null) {
            this.cck.u(getLastShowGift());
        }
    }

    @Override // com.baidu.live.yuyingift.yuyinhousegift.view.YuyinAlaRoomBaseGiftView
    protected void ZA() {
        if (this.cck != null) {
            this.cck.s(getLastShowGift());
        }
    }

    @Override // com.baidu.live.yuyingift.yuyinhousegift.view.YuyinAlaRoomBaseGiftView
    protected void ZB() {
        if (this.cck != null) {
            this.cck.t(getLastShowGift());
        }
    }

    public void setAnimCallback(a aVar) {
        this.cck = aVar;
    }
}

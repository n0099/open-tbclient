package com.baidu.swan.apps.res.ui.wheelview3d.d;

import android.os.Handler;
import android.os.Message;
import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
/* loaded from: classes11.dex */
public final class b extends Handler {
    private final WheelView3d cCU;

    public b(WheelView3d wheelView3d) {
        this.cCU = wheelView3d;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1000:
                this.cCU.invalidate();
                return;
            case 2000:
                this.cCU.a(WheelView3d.ACTION.FLING);
                return;
            case 3000:
                this.cCU.onItemSelected();
                return;
            default:
                return;
        }
    }
}

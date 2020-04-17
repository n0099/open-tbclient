package com.baidu.swan.apps.res.ui.wheelview3d.d;

import android.os.Handler;
import android.os.Message;
import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
/* loaded from: classes11.dex */
public final class b extends Handler {
    private final WheelView3d cmB;

    public b(WheelView3d wheelView3d) {
        this.cmB = wheelView3d;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1000:
                this.cmB.invalidate();
                return;
            case 2000:
                this.cmB.a(WheelView3d.ACTION.FLING);
                return;
            case 3000:
                this.cmB.onItemSelected();
                return;
            default:
                return;
        }
    }
}

package com.baidu.swan.apps.res.ui.wheelview3d.d;

import android.os.Handler;
import android.os.Message;
import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
/* loaded from: classes9.dex */
public final class b extends Handler {
    private final WheelView3d dDu;

    public b(WheelView3d wheelView3d) {
        this.dDu = wheelView3d;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1000:
                this.dDu.invalidate();
                return;
            case 2000:
                this.dDu.a(WheelView3d.ACTION.FLING);
                return;
            case 3000:
                this.dDu.aLf();
                return;
            default:
                return;
        }
    }
}

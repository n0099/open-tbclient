package com.baidu.swan.apps.res.ui.wheelview3d.d;

import android.os.Handler;
import android.os.Message;
import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
/* loaded from: classes25.dex */
public final class b extends Handler {
    private final WheelView3d dwF;

    public b(WheelView3d wheelView3d) {
        this.dwF = wheelView3d;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1000:
                this.dwF.invalidate();
                return;
            case 2000:
                this.dwF.a(WheelView3d.ACTION.FLING);
                return;
            case 3000:
                this.dwF.onItemSelected();
                return;
            default:
                return;
        }
    }
}

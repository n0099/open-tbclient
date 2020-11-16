package com.baidu.swan.apps.res.ui.wheelview3d.d;

import android.os.Handler;
import android.os.Message;
import com.baidu.swan.apps.res.ui.wheelview3d.WheelView3d;
/* loaded from: classes7.dex */
public final class b extends Handler {
    private final WheelView3d dpE;

    public b(WheelView3d wheelView3d) {
        this.dpE = wheelView3d;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1000:
                this.dpE.invalidate();
                return;
            case 2000:
                this.dpE.a(WheelView3d.ACTION.FLING);
                return;
            case 3000:
                this.dpE.onItemSelected();
                return;
            default:
                return;
        }
    }
}

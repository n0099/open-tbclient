package com.baidu.searchbox.ui.wheelview3d.timer;

import android.os.Handler;
import android.os.Message;
import com.baidu.searchbox.ui.wheelview3d.WheelView3d;
/* loaded from: classes19.dex */
public final class MessageHandler extends Handler {
    public static final int WHAT_INVALIDATE_LOOP_VIEW = 1000;
    public static final int WHAT_ITEM_SELECTED = 3000;
    public static final int WHAT_SMOOTH_SCROLL = 2000;
    private final WheelView3d wheelView;

    public MessageHandler(WheelView3d wheelView3d) {
        this.wheelView = wheelView3d;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1000:
                this.wheelView.invalidate();
                return;
            case 2000:
                this.wheelView.smoothScroll(WheelView3d.ACTION.FLING);
                return;
            case 3000:
                this.wheelView.onItemSelected();
                return;
            default:
                return;
        }
    }
}

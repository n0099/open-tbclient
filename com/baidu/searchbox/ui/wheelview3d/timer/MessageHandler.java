package com.baidu.searchbox.ui.wheelview3d.timer;

import android.os.Handler;
import android.os.Message;
import com.baidu.searchbox.ui.wheelview3d.WheelView3d;
/* loaded from: classes4.dex */
public final class MessageHandler extends Handler {
    public static final int WHAT_INVALIDATE_LOOP_VIEW = 1000;
    public static final int WHAT_ITEM_SELECTED = 3000;
    public static final int WHAT_SMOOTH_SCROLL = 2000;
    public final WheelView3d wheelView;

    public MessageHandler(WheelView3d wheelView3d) {
        this.wheelView = wheelView3d;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i = message.what;
        if (i != 1000) {
            if (i != 2000) {
                if (i == 3000) {
                    this.wheelView.onItemSelected();
                    return;
                }
                return;
            }
            this.wheelView.smoothScroll(WheelView3d.ACTION.FLING);
            return;
        }
        this.wheelView.invalidate();
    }
}

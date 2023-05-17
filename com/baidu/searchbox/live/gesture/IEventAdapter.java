package com.baidu.searchbox.live.gesture;

import com.baidu.searchbox.live.gesture.HorizonMotionEventCaptureView;
/* loaded from: classes3.dex */
public interface IEventAdapter {
    boolean isEnable();

    void onEvent(HorizonMotionEventCaptureView.CaptureEvent captureEvent);
}

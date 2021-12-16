package c.a.q0.y.l.b.c;

import android.view.MotionEvent;
import com.baidu.swan.videoplayer.media.video.view.MediaGestureMode;
/* loaded from: classes6.dex */
public interface b {
    boolean onBrightnessChange(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3);

    boolean onDoubleTap(MotionEvent motionEvent);

    boolean onDown(MotionEvent motionEvent);

    boolean onFastForward(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3);

    boolean onSingleTap(MotionEvent motionEvent);

    boolean onTouchUp(MotionEvent motionEvent, MediaGestureMode mediaGestureMode);

    boolean onVolumeChange(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3);
}

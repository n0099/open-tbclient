package com.baidu.searchbox.floating;

import android.app.Notification;
import com.baidu.searchbox.floating.animator.FloatViewAnimator;
import com.baidu.searchbox.floating.config.ScaleMode;
import com.baidu.searchbox.floating.listener.FloatViewListener;
import kotlin.Pair;
import kotlin.e;
@e
/* loaded from: classes15.dex */
public interface IFloating {
    void addFloatListener(FloatViewListener floatViewListener);

    void dismiss(boolean z);

    boolean hasFloatingView();

    boolean nextScale();

    void onCreate();

    void onDestroy();

    void reverse(boolean z);

    void setAnimator(FloatViewAnimator floatViewAnimator);

    void setBlockOffset(int i, int i2, int i3, int i4);

    void setDefaultSize(int i, int i2);

    void setDragEnable(boolean z);

    void setLocation(int i, int i2);

    void setScaleMode(Pair<? extends ScaleMode, ? extends ScaleMode> pair);

    void startForeground(Notification notification);

    @e
    /* loaded from: classes15.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void dismiss$default(IFloating iFloating, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: dismiss");
            }
            if ((i & 1) != 0) {
                z = false;
            }
            iFloating.dismiss(z);
        }
    }
}

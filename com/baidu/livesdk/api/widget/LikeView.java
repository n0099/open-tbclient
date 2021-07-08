package com.baidu.livesdk.api.widget;

import android.app.Activity;
import android.view.View;
/* loaded from: classes2.dex */
public interface LikeView {

    /* loaded from: classes2.dex */
    public interface LikeViewListener {
        void onView(int i2, View view);
    }

    /* loaded from: classes2.dex */
    public interface ViewLocationListener {
        void onLocation(int i2, int i3);
    }

    void addLikeAnimation(View view, int i2);

    void getLikeRippleView(Activity activity, LikeViewListener likeViewListener);

    void getLikeView(Activity activity, LikeViewListener likeViewListener);

    void release();

    void startRipple(View view);
}

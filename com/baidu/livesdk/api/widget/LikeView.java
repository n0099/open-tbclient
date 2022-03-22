package com.baidu.livesdk.api.widget;

import android.app.Activity;
import android.view.View;
/* loaded from: classes4.dex */
public interface LikeView {

    /* loaded from: classes4.dex */
    public interface LikeViewListener {
        void onView(int i, View view);
    }

    /* loaded from: classes4.dex */
    public interface ViewLocationListener {
        void onLocation(int i, int i2);
    }

    void addLikeAnimation(View view, int i);

    void getLikeRippleView(Activity activity, LikeViewListener likeViewListener);

    void getLikeView(Activity activity, LikeViewListener likeViewListener);

    void release();

    void startRipple(View view);
}

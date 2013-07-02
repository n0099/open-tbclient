package com.baidu.cyberplayer.sdk.internal;

import android.view.View;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public interface IVideoViewControllerBridge {
    void enableControllerBar(boolean z);

    RelativeLayout getVideoViewController();

    void hide();

    boolean isShowing();

    void setPreNextListener(View.OnClickListener onClickListener, View.OnClickListener onClickListener2);

    void show();
}

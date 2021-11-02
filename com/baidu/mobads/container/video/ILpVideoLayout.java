package com.baidu.mobads.container.video;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.mobads.container.video.ICustomVideoView;
/* loaded from: classes7.dex */
public interface ILpVideoLayout {
    void addView(View view, ViewGroup.LayoutParams layoutParams);

    boolean closeFullScreen();

    void pause();

    void play();

    void resume();

    void setActivity(Activity activity);

    void setVideoPlayCallback(ICustomVideoView.VideoPlayCallbackImpl videoPlayCallbackImpl);

    void setVideoURI(String str);

    void stopAndRelease();
}

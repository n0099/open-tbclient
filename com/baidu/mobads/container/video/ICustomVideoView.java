package com.baidu.mobads.container.video;

import android.media.MediaPlayer;
/* loaded from: classes5.dex */
public interface ICustomVideoView {

    /* loaded from: classes5.dex */
    public interface VideoPlayCallbackImpl {
        void onClickAd();

        void onCloseVideo(int i2);

        void onCompletion(MediaPlayer mediaPlayer);

        void onError(MediaPlayer mediaPlayer, int i2, int i3);

        void onFullScreen(int i2);

        void onReturnButtonClicked();

        void onStart();
    }
}

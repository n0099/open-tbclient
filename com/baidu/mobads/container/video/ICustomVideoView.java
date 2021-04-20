package com.baidu.mobads.container.video;

import android.media.MediaPlayer;
/* loaded from: classes2.dex */
public interface ICustomVideoView {

    /* loaded from: classes2.dex */
    public interface VideoPlayCallbackImpl {
        void onClickAd();

        void onCloseVideo(int i);

        void onCompletion(MediaPlayer mediaPlayer);

        void onError(MediaPlayer mediaPlayer, int i, int i2);

        void onFullScreen(int i);

        void onReturnButtonClicked();

        void onStart();
    }
}

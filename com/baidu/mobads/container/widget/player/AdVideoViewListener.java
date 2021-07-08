package com.baidu.mobads.container.widget.player;
/* loaded from: classes2.dex */
public interface AdVideoViewListener {

    /* loaded from: classes2.dex */
    public interface DestroyedListener {
        void onDestroyed();
    }

    /* loaded from: classes2.dex */
    public interface PreparedListener {
        void onPrepared();
    }

    void playCompletion();

    void playFailure();

    void playPause();

    void playResume();

    void renderingStart();
}

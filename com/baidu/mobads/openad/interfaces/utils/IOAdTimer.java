package com.baidu.mobads.openad.interfaces.utils;
/* loaded from: classes20.dex */
public interface IOAdTimer {

    /* loaded from: classes20.dex */
    public interface EventHandler {
        void onTimer(int i);

        void onTimerComplete();
    }

    int getCurrentCount();

    int getRepeatCount();

    void pause();

    void reset();

    void resume();

    void setEventHandler(EventHandler eventHandler);

    void start();

    void stop();
}

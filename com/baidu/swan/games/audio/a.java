package com.baidu.swan.games.audio;
/* loaded from: classes2.dex */
public interface a {
    void destroy();

    int getCurrentTime();

    int getDuration();

    boolean isPaused();

    void pause();

    void play();

    void seek(int i);

    void stop();
}

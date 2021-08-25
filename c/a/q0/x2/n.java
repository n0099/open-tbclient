package c.a.q0.x2;

import android.view.View;
/* loaded from: classes4.dex */
public interface n {
    void autoPlay(int i2);

    boolean canPlay();

    long getCurrentPosition();

    int getPlayStatus();

    String getPlayUrl();

    View getVideoContainer();

    boolean isPlayStarted();

    boolean isPlaying();

    void release();

    void startPlay();

    void stopPlay();
}

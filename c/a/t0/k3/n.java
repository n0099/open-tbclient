package c.a.t0.k3;

import android.view.View;
/* loaded from: classes7.dex */
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

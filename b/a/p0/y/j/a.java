package b.a.p0.y.j;

import com.baidu.swan.videoplayer.SwanVideoView;
/* loaded from: classes4.dex */
public interface a {
    void a(boolean z);

    void b(SwanVideoView swanVideoView);

    void c(boolean z);

    void onBufferingUpdate(int i2);

    void onEnd();

    void onError(int i2, int i3, String str);

    void onPause();

    void onPrepared();

    void onResume();

    void onSeekEnd();

    void onStart();

    void onVideoSizeChanged(int i2, int i3);
}

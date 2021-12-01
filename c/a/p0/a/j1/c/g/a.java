package c.a.p0.a.j1.c.g;

import com.baidu.swan.apps.media.audio.service.BgMusicPlayState;
/* loaded from: classes.dex */
public interface a {
    void onGetCurrentSong(String str);

    void onGetDownloadProgress(int i2);

    void onGetDuration(int i2);

    void onGetPosition(int i2, int i3);

    void onInvokeFailed();

    void onStateChanged(BgMusicPlayState bgMusicPlayState);
}

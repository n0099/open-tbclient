package c.a.n0.a.z0.c.g;

import com.baidu.swan.apps.media.audio.service.BgMusicPlayState;
/* loaded from: classes.dex */
public interface a {
    void onGetCurrentSong(String str);

    void onGetDownloadProgress(int i);

    void onGetDuration(int i);

    void onGetPosition(int i, int i2);

    void onInvokeFailed();

    void onStateChanged(BgMusicPlayState bgMusicPlayState);
}

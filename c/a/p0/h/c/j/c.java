package c.a.p0.h.c.j;

import android.media.MediaPlayer;
/* loaded from: classes3.dex */
public interface c extends c.a.p0.h.c.a {
    void a(boolean z);

    void d(String str) throws Exception;

    void f(c.a.p0.l.a.c cVar);

    void g(MediaPlayer.OnInfoListener onInfoListener);

    void h(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener);

    void j(MediaPlayer.OnPreparedListener onPreparedListener);

    void k(MediaPlayer.OnErrorListener onErrorListener);

    void n(MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener);

    void q(MediaPlayer.OnCompletionListener onCompletionListener);

    boolean s();

    void setVolume(float f2);
}

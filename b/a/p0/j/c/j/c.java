package b.a.p0.j.c.j;

import android.media.MediaPlayer;
/* loaded from: classes4.dex */
public interface c extends b.a.p0.j.c.a {
    void a(boolean z);

    void d(String str) throws Exception;

    void f(b.a.p0.o.a.c cVar);

    void g(MediaPlayer.OnInfoListener onInfoListener);

    void h(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener);

    void j(MediaPlayer.OnPreparedListener onPreparedListener);

    void k(MediaPlayer.OnErrorListener onErrorListener);

    void n(MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener);

    void q(MediaPlayer.OnCompletionListener onCompletionListener);

    boolean s();

    void setVolume(float f2);
}

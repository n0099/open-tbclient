package b.a.p0.h.c.j;

import android.media.MediaPlayer;
/* loaded from: classes4.dex */
public interface c extends b.a.p0.h.c.a {
    void a(boolean z);

    void c(String str) throws Exception;

    void e(b.a.p0.l.a.c cVar);

    void f(MediaPlayer.OnInfoListener onInfoListener);

    void g(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener);

    void i(MediaPlayer.OnPreparedListener onPreparedListener);

    void j(MediaPlayer.OnErrorListener onErrorListener);

    void m(MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener);

    void p(MediaPlayer.OnCompletionListener onCompletionListener);

    boolean r();

    void setVolume(float f2);
}

package c.a.p0.a.c1.d;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public interface k {

    /* loaded from: classes.dex */
    public interface a {
        void b(k kVar);
    }

    /* loaded from: classes.dex */
    public interface b {
        boolean f(k kVar, int i2, int i3);
    }

    /* loaded from: classes.dex */
    public interface c {
        void c(k kVar);
    }

    /* loaded from: classes.dex */
    public interface d {
        void e(k kVar);
    }

    /* loaded from: classes.dex */
    public interface e {
        void a(k kVar);
    }

    /* loaded from: classes.dex */
    public interface f {
        void d(k kVar);
    }

    void a(FrameLayout frameLayout);

    void b();

    void c();

    void d(boolean z);

    k e(Context context, @NonNull c.a.p0.a.j1.g.c cVar);

    void f();

    void g(a aVar);

    int getCurrentPosition();

    int getDuration();

    void h(c.a.p0.a.j1.g.c cVar, boolean z);

    void i(String str);

    boolean isEnd();

    boolean isPlaying();

    void j(e eVar);

    void k(f fVar);

    void l(boolean z, int i2);

    void m(d dVar);

    void mute(boolean z);

    void n(c.a.p0.a.j1.g.c cVar);

    void o(c.a.p0.a.j1.g.c cVar);

    boolean onBackPressed();

    void p(b bVar);

    void pause();

    int q(String str);

    void r(c cVar);

    void resume();

    void seekTo(int i2);

    void stop();
}

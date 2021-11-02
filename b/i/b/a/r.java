package b.i.b.a;

import b.i.b.a.g;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import java.io.IOException;
/* loaded from: classes6.dex */
public interface r extends g.a {
    boolean b();

    int e();

    boolean f();

    void g(t tVar, Format[] formatArr, b.i.b.a.d0.o oVar, long j, boolean z, long j2) throws ExoPlaybackException;

    int getState();

    b.i.b.a.d0.o getStream();

    void i();

    boolean isReady();

    boolean j();

    void k(long j, long j2) throws ExoPlaybackException;

    void l(long j) throws ExoPlaybackException;

    b.i.b.a.i0.h m();

    void n();

    void o() throws IOException;

    s p();

    void s(Format[] formatArr, b.i.b.a.d0.o oVar, long j) throws ExoPlaybackException;

    void setIndex(int i2);

    void start() throws ExoPlaybackException;

    void stop() throws ExoPlaybackException;
}

package c.i.b.a;

import c.i.b.a.g;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import java.io.IOException;
/* loaded from: classes7.dex */
public interface r extends g.a {
    boolean b();

    int e();

    boolean f();

    void g(t tVar, Format[] formatArr, c.i.b.a.d0.o oVar, long j2, boolean z, long j3) throws ExoPlaybackException;

    int getState();

    c.i.b.a.d0.o getStream();

    void i();

    boolean isReady();

    boolean j();

    void k(long j2, long j3) throws ExoPlaybackException;

    void l(long j2) throws ExoPlaybackException;

    c.i.b.a.i0.h m();

    void n();

    void o() throws IOException;

    s p();

    void s(Format[] formatArr, c.i.b.a.d0.o oVar, long j2) throws ExoPlaybackException;

    void setIndex(int i2);

    void start() throws ExoPlaybackException;

    void stop() throws ExoPlaybackException;
}

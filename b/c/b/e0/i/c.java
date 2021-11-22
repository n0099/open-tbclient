package b.c.b.e0.i;

import b.c.b.b0;
import b.c.b.c0;
import b.c.b.z;
import java.io.IOException;
import okio.Sink;
/* loaded from: classes6.dex */
public interface c {
    c0 a(b0 b0Var) throws IOException;

    void b(z zVar) throws IOException;

    Sink c(z zVar, long j);

    void cancel();

    void finishRequest() throws IOException;

    void flushRequest() throws IOException;

    b0.a readResponseHeaders(boolean z) throws IOException;
}

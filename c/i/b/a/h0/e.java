package c.i.b.a.h0;

import android.net.Uri;
import java.io.IOException;
/* loaded from: classes9.dex */
public interface e {

    /* loaded from: classes9.dex */
    public interface a {
        e a();
    }

    long a(g gVar) throws IOException;

    void close() throws IOException;

    Uri getUri();

    int read(byte[] bArr, int i2, int i3) throws IOException;
}

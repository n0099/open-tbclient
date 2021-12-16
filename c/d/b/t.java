package c.d.b;

import java.io.IOException;
import javax.annotation.Nullable;
/* loaded from: classes9.dex */
public interface t {

    /* loaded from: classes9.dex */
    public interface a {
        b0 a(z zVar) throws IOException;

        int connectTimeoutMillis();

        @Nullable
        i connection();

        int readTimeoutMillis();

        z request();

        int writeTimeoutMillis();
    }

    b0 a(a aVar) throws IOException;
}

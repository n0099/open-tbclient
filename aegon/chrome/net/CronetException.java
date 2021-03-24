package aegon.chrome.net;

import java.io.IOException;
/* loaded from: classes.dex */
public abstract class CronetException extends IOException {
    public CronetException(String str, Throwable th) {
        super(str, th);
    }
}

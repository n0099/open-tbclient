package c.a.t0.h2;

import android.os.Environment;
import java.io.File;
/* loaded from: classes7.dex */
public interface f {
    public static final String a = File.separator;

    /* renamed from: b  reason: collision with root package name */
    public static final String f18556b = Environment.getExternalStorageDirectory() + a + "tieba";

    /* renamed from: c  reason: collision with root package name */
    public static final String f18557c = f18556b + a + ".tieba_post_monitor";

    /* renamed from: d  reason: collision with root package name */
    public static final String f18558d = f18557c + a + "v1";

    /* renamed from: e  reason: collision with root package name */
    public static final String f18559e;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(f18558d);
        sb.append(a);
        f18559e = sb.toString();
    }
}

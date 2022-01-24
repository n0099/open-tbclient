package c.a.t0.i2;

import android.os.Environment;
import java.io.File;
/* loaded from: classes7.dex */
public interface f {
    public static final String a = File.separator;

    /* renamed from: b  reason: collision with root package name */
    public static final String f18408b = Environment.getExternalStorageDirectory() + a + "tieba";

    /* renamed from: c  reason: collision with root package name */
    public static final String f18409c = f18408b + a + ".tieba_post_monitor";

    /* renamed from: d  reason: collision with root package name */
    public static final String f18410d = f18409c + a + "v1";

    /* renamed from: e  reason: collision with root package name */
    public static final String f18411e;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(f18410d);
        sb.append(a);
        f18411e = sb.toString();
    }
}

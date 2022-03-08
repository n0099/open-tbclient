package c.a.r0.j2;

import android.os.Environment;
import java.io.File;
/* loaded from: classes2.dex */
public interface f {
    public static final String a = File.separator;

    /* renamed from: b  reason: collision with root package name */
    public static final String f18290b = Environment.getExternalStorageDirectory() + a + "tieba";

    /* renamed from: c  reason: collision with root package name */
    public static final String f18291c = f18290b + a + ".tieba_post_monitor";

    /* renamed from: d  reason: collision with root package name */
    public static final String f18292d = f18291c + a + "v1";

    /* renamed from: e  reason: collision with root package name */
    public static final String f18293e;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(f18292d);
        sb.append(a);
        f18293e = sb.toString();
    }
}

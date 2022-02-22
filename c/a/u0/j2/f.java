package c.a.u0.j2;

import android.os.Environment;
import java.io.File;
/* loaded from: classes8.dex */
public interface f {
    public static final String a = File.separator;

    /* renamed from: b  reason: collision with root package name */
    public static final String f18853b = Environment.getExternalStorageDirectory() + a + "tieba";

    /* renamed from: c  reason: collision with root package name */
    public static final String f18854c = f18853b + a + ".tieba_post_monitor";

    /* renamed from: d  reason: collision with root package name */
    public static final String f18855d = f18854c + a + "v1";

    /* renamed from: e  reason: collision with root package name */
    public static final String f18856e;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(f18855d);
        sb.append(a);
        f18856e = sb.toString();
    }
}

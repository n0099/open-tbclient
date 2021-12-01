package c.a.r0.g2;

import android.os.Environment;
import java.io.File;
/* loaded from: classes5.dex */
public interface f {
    public static final String a = File.separator;

    /* renamed from: b  reason: collision with root package name */
    public static final String f17386b = Environment.getExternalStorageDirectory() + a + "tieba";

    /* renamed from: c  reason: collision with root package name */
    public static final String f17387c = f17386b + a + ".tieba_post_monitor";

    /* renamed from: d  reason: collision with root package name */
    public static final String f17388d = f17387c + a + "v1";

    /* renamed from: e  reason: collision with root package name */
    public static final String f17389e;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(f17388d);
        sb.append(a);
        f17389e = sb.toString();
    }
}

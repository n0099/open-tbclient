package c.a.p0.l2;

import android.os.Environment;
import java.io.File;
/* loaded from: classes2.dex */
public interface f {
    public static final String a = File.separator;

    /* renamed from: b  reason: collision with root package name */
    public static final String f16081b = Environment.getExternalStorageDirectory() + a + "tieba";

    /* renamed from: c  reason: collision with root package name */
    public static final String f16082c = f16081b + a + ".tieba_post_monitor";

    /* renamed from: d  reason: collision with root package name */
    public static final String f16083d = f16082c + a + "v1";

    /* renamed from: e  reason: collision with root package name */
    public static final String f16084e;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(f16083d);
        sb.append(a);
        f16084e = sb.toString();
    }
}

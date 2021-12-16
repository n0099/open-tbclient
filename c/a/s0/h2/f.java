package c.a.s0.h2;

import android.os.Environment;
import java.io.File;
/* loaded from: classes7.dex */
public interface f {
    public static final String a = File.separator;

    /* renamed from: b  reason: collision with root package name */
    public static final String f18052b = Environment.getExternalStorageDirectory() + a + "tieba";

    /* renamed from: c  reason: collision with root package name */
    public static final String f18053c = f18052b + a + ".tieba_post_monitor";

    /* renamed from: d  reason: collision with root package name */
    public static final String f18054d = f18053c + a + "v1";

    /* renamed from: e  reason: collision with root package name */
    public static final String f18055e;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(f18054d);
        sb.append(a);
        f18055e = sb.toString();
    }
}

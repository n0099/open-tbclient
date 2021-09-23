package c.a.r0.z1;

import android.os.Environment;
import java.io.File;
/* loaded from: classes4.dex */
public interface f {

    /* renamed from: a  reason: collision with root package name */
    public static final String f29731a = File.separator;

    /* renamed from: b  reason: collision with root package name */
    public static final String f29732b = Environment.getExternalStorageDirectory() + f29731a + "tieba";

    /* renamed from: c  reason: collision with root package name */
    public static final String f29733c = f29732b + f29731a + ".tieba_post_monitor";

    /* renamed from: d  reason: collision with root package name */
    public static final String f29734d = f29733c + f29731a + "v1";

    /* renamed from: e  reason: collision with root package name */
    public static final String f29735e;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(f29734d);
        sb.append(f29731a);
        f29735e = sb.toString();
    }
}

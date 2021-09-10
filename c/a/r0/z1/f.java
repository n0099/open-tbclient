package c.a.r0.z1;

import android.os.Environment;
import java.io.File;
/* loaded from: classes4.dex */
public interface f {

    /* renamed from: a  reason: collision with root package name */
    public static final String f29711a = File.separator;

    /* renamed from: b  reason: collision with root package name */
    public static final String f29712b = Environment.getExternalStorageDirectory() + f29711a + "tieba";

    /* renamed from: c  reason: collision with root package name */
    public static final String f29713c = f29712b + f29711a + ".tieba_post_monitor";

    /* renamed from: d  reason: collision with root package name */
    public static final String f29714d = f29713c + f29711a + "v1";

    /* renamed from: e  reason: collision with root package name */
    public static final String f29715e;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(f29714d);
        sb.append(f29711a);
        f29715e = sb.toString();
    }
}

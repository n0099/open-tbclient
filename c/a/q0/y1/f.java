package c.a.q0.y1;

import android.os.Environment;
import java.io.File;
/* loaded from: classes4.dex */
public interface f {

    /* renamed from: a  reason: collision with root package name */
    public static final String f29102a = File.separator;

    /* renamed from: b  reason: collision with root package name */
    public static final String f29103b = Environment.getExternalStorageDirectory() + f29102a + "tieba";

    /* renamed from: c  reason: collision with root package name */
    public static final String f29104c = f29103b + f29102a + ".tieba_post_monitor";

    /* renamed from: d  reason: collision with root package name */
    public static final String f29105d = f29104c + f29102a + "v1";

    /* renamed from: e  reason: collision with root package name */
    public static final String f29106e;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(f29105d);
        sb.append(f29102a);
        f29106e = sb.toString();
    }
}

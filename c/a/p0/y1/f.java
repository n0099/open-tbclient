package c.a.p0.y1;

import android.os.Environment;
import java.io.File;
/* loaded from: classes4.dex */
public interface f {

    /* renamed from: a  reason: collision with root package name */
    public static final String f28763a = File.separator;

    /* renamed from: b  reason: collision with root package name */
    public static final String f28764b = Environment.getExternalStorageDirectory() + f28763a + "tieba";

    /* renamed from: c  reason: collision with root package name */
    public static final String f28765c = f28764b + f28763a + ".tieba_post_monitor";

    /* renamed from: d  reason: collision with root package name */
    public static final String f28766d = f28765c + f28763a + "v1";

    /* renamed from: e  reason: collision with root package name */
    public static final String f28767e;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(f28766d);
        sb.append(f28763a);
        f28767e = sb.toString();
    }
}

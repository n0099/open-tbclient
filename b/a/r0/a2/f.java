package b.a.r0.a2;

import android.os.Environment;
import java.io.File;
/* loaded from: classes4.dex */
public interface f {

    /* renamed from: a  reason: collision with root package name */
    public static final String f15512a = File.separator;

    /* renamed from: b  reason: collision with root package name */
    public static final String f15513b = Environment.getExternalStorageDirectory() + f15512a + "tieba";

    /* renamed from: c  reason: collision with root package name */
    public static final String f15514c = f15513b + f15512a + ".tieba_post_monitor";

    /* renamed from: d  reason: collision with root package name */
    public static final String f15515d = f15514c + f15512a + "v1";

    /* renamed from: e  reason: collision with root package name */
    public static final String f15516e;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(f15515d);
        sb.append(f15512a);
        f15516e = sb.toString();
    }
}

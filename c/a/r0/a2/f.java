package c.a.r0.a2;

import android.os.Environment;
import java.io.File;
/* loaded from: classes3.dex */
public interface f {

    /* renamed from: a  reason: collision with root package name */
    public static final String f15604a = File.separator;

    /* renamed from: b  reason: collision with root package name */
    public static final String f15605b = Environment.getExternalStorageDirectory() + f15604a + "tieba";

    /* renamed from: c  reason: collision with root package name */
    public static final String f15606c = f15605b + f15604a + ".tieba_post_monitor";

    /* renamed from: d  reason: collision with root package name */
    public static final String f15607d = f15606c + f15604a + "v1";

    /* renamed from: e  reason: collision with root package name */
    public static final String f15608e;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(f15607d);
        sb.append(f15604a);
        f15608e = sb.toString();
    }
}

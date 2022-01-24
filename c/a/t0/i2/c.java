package c.a.t0.i2;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.File;
/* loaded from: classes7.dex */
public interface c {
    public static final String a = File.separator;

    /* renamed from: b  reason: collision with root package name */
    public static final String f18402b = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();

    /* renamed from: c  reason: collision with root package name */
    public static final String f18403c = f18402b + a + ".tieba_video_monitor";

    /* renamed from: d  reason: collision with root package name */
    public static final String f18404d = f18403c + a + "v1";

    /* renamed from: e  reason: collision with root package name */
    public static final String f18405e;

    /* renamed from: f  reason: collision with root package name */
    public static final String f18406f;

    /* renamed from: g  reason: collision with root package name */
    public static final String f18407g;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(f18404d);
        sb.append(a);
        f18405e = sb.toString();
        f18406f = f18402b + a + ".tieba_video_monitor_log";
        f18407g = f18406f + a + "v1";
        StringBuilder sb2 = new StringBuilder();
        sb2.append(f18407g);
        sb2.append(a);
        sb2.toString();
    }
}

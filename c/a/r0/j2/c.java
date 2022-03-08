package c.a.r0.j2;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.File;
/* loaded from: classes2.dex */
public interface c {
    public static final String a = File.separator;

    /* renamed from: b  reason: collision with root package name */
    public static final String f18284b = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();

    /* renamed from: c  reason: collision with root package name */
    public static final String f18285c = f18284b + a + ".tieba_video_monitor";

    /* renamed from: d  reason: collision with root package name */
    public static final String f18286d = f18285c + a + "v1";

    /* renamed from: e  reason: collision with root package name */
    public static final String f18287e;

    /* renamed from: f  reason: collision with root package name */
    public static final String f18288f;

    /* renamed from: g  reason: collision with root package name */
    public static final String f18289g;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(f18286d);
        sb.append(a);
        f18287e = sb.toString();
        f18288f = f18284b + a + ".tieba_video_monitor_log";
        f18289g = f18288f + a + "v1";
        StringBuilder sb2 = new StringBuilder();
        sb2.append(f18289g);
        sb2.append(a);
        sb2.toString();
    }
}

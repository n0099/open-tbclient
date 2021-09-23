package c.a.r0.z1;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.File;
/* loaded from: classes4.dex */
public interface c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f29724a = File.separator;

    /* renamed from: b  reason: collision with root package name */
    public static final String f29725b = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();

    /* renamed from: c  reason: collision with root package name */
    public static final String f29726c = f29725b + f29724a + ".tieba_video_monitor";

    /* renamed from: d  reason: collision with root package name */
    public static final String f29727d = f29726c + f29724a + "v1";

    /* renamed from: e  reason: collision with root package name */
    public static final String f29728e;

    /* renamed from: f  reason: collision with root package name */
    public static final String f29729f;

    /* renamed from: g  reason: collision with root package name */
    public static final String f29730g;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(f29727d);
        sb.append(f29724a);
        f29728e = sb.toString();
        f29729f = f29725b + f29724a + ".tieba_video_monitor_log";
        f29730g = f29729f + f29724a + "v1";
        StringBuilder sb2 = new StringBuilder();
        sb2.append(f29730g);
        sb2.append(f29724a);
        sb2.toString();
    }
}

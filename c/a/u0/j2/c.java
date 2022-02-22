package c.a.u0.j2;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.File;
/* loaded from: classes8.dex */
public interface c {
    public static final String a = File.separator;

    /* renamed from: b  reason: collision with root package name */
    public static final String f18847b = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();

    /* renamed from: c  reason: collision with root package name */
    public static final String f18848c = f18847b + a + ".tieba_video_monitor";

    /* renamed from: d  reason: collision with root package name */
    public static final String f18849d = f18848c + a + "v1";

    /* renamed from: e  reason: collision with root package name */
    public static final String f18850e;

    /* renamed from: f  reason: collision with root package name */
    public static final String f18851f;

    /* renamed from: g  reason: collision with root package name */
    public static final String f18852g;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(f18849d);
        sb.append(a);
        f18850e = sb.toString();
        f18851f = f18847b + a + ".tieba_video_monitor_log";
        f18852g = f18851f + a + "v1";
        StringBuilder sb2 = new StringBuilder();
        sb2.append(f18852g);
        sb2.append(a);
        sb2.toString();
    }
}

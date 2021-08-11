package c.a.p0.y1;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.File;
/* loaded from: classes4.dex */
public interface c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f28756a = File.separator;

    /* renamed from: b  reason: collision with root package name */
    public static final String f28757b = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();

    /* renamed from: c  reason: collision with root package name */
    public static final String f28758c = f28757b + f28756a + ".tieba_video_monitor";

    /* renamed from: d  reason: collision with root package name */
    public static final String f28759d = f28758c + f28756a + "v1";

    /* renamed from: e  reason: collision with root package name */
    public static final String f28760e;

    /* renamed from: f  reason: collision with root package name */
    public static final String f28761f;

    /* renamed from: g  reason: collision with root package name */
    public static final String f28762g;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(f28759d);
        sb.append(f28756a);
        f28760e = sb.toString();
        f28761f = f28757b + f28756a + ".tieba_video_monitor_log";
        f28762g = f28761f + f28756a + "v1";
        StringBuilder sb2 = new StringBuilder();
        sb2.append(f28762g);
        sb2.append(f28756a);
        sb2.toString();
    }
}

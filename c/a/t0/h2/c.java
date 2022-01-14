package c.a.t0.h2;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.File;
/* loaded from: classes7.dex */
public interface c {
    public static final String a = File.separator;

    /* renamed from: b  reason: collision with root package name */
    public static final String f18087b = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();

    /* renamed from: c  reason: collision with root package name */
    public static final String f18088c = f18087b + a + ".tieba_video_monitor";

    /* renamed from: d  reason: collision with root package name */
    public static final String f18089d = f18088c + a + "v1";

    /* renamed from: e  reason: collision with root package name */
    public static final String f18090e;

    /* renamed from: f  reason: collision with root package name */
    public static final String f18091f;

    /* renamed from: g  reason: collision with root package name */
    public static final String f18092g;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(f18089d);
        sb.append(a);
        f18090e = sb.toString();
        f18091f = f18087b + a + ".tieba_video_monitor_log";
        f18092g = f18091f + a + "v1";
        StringBuilder sb2 = new StringBuilder();
        sb2.append(f18092g);
        sb2.append(a);
        sb2.toString();
    }
}

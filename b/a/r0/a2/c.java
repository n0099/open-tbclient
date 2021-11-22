package b.a.r0.a2;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.File;
/* loaded from: classes4.dex */
public interface c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f15505a = File.separator;

    /* renamed from: b  reason: collision with root package name */
    public static final String f15506b = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();

    /* renamed from: c  reason: collision with root package name */
    public static final String f15507c = f15506b + f15505a + ".tieba_video_monitor";

    /* renamed from: d  reason: collision with root package name */
    public static final String f15508d = f15507c + f15505a + "v1";

    /* renamed from: e  reason: collision with root package name */
    public static final String f15509e;

    /* renamed from: f  reason: collision with root package name */
    public static final String f15510f;

    /* renamed from: g  reason: collision with root package name */
    public static final String f15511g;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(f15508d);
        sb.append(f15505a);
        f15509e = sb.toString();
        f15510f = f15506b + f15505a + ".tieba_video_monitor_log";
        f15511g = f15510f + f15505a + "v1";
        StringBuilder sb2 = new StringBuilder();
        sb2.append(f15511g);
        sb2.append(f15505a);
        sb2.toString();
    }
}

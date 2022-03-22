package c.a.p0.l2;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.File;
/* loaded from: classes2.dex */
public interface c {
    public static final String a = File.separator;

    /* renamed from: b  reason: collision with root package name */
    public static final String f16075b = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();

    /* renamed from: c  reason: collision with root package name */
    public static final String f16076c = f16075b + a + ".tieba_video_monitor";

    /* renamed from: d  reason: collision with root package name */
    public static final String f16077d = f16076c + a + "v1";

    /* renamed from: e  reason: collision with root package name */
    public static final String f16078e;

    /* renamed from: f  reason: collision with root package name */
    public static final String f16079f;

    /* renamed from: g  reason: collision with root package name */
    public static final String f16080g;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(f16077d);
        sb.append(a);
        f16078e = sb.toString();
        f16079f = f16075b + a + ".tieba_video_monitor_log";
        f16080g = f16079f + a + "v1";
        StringBuilder sb2 = new StringBuilder();
        sb2.append(f16080g);
        sb2.append(a);
        sb2.toString();
    }
}

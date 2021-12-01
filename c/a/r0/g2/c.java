package c.a.r0.g2;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.File;
/* loaded from: classes5.dex */
public interface c {
    public static final String a = File.separator;

    /* renamed from: b  reason: collision with root package name */
    public static final String f17380b = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();

    /* renamed from: c  reason: collision with root package name */
    public static final String f17381c = f17380b + a + ".tieba_video_monitor";

    /* renamed from: d  reason: collision with root package name */
    public static final String f17382d = f17381c + a + "v1";

    /* renamed from: e  reason: collision with root package name */
    public static final String f17383e;

    /* renamed from: f  reason: collision with root package name */
    public static final String f17384f;

    /* renamed from: g  reason: collision with root package name */
    public static final String f17385g;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(f17382d);
        sb.append(a);
        f17383e = sb.toString();
        f17384f = f17380b + a + ".tieba_video_monitor_log";
        f17385g = f17384f + a + "v1";
        StringBuilder sb2 = new StringBuilder();
        sb2.append(f17385g);
        sb2.append(a);
        sb2.toString();
    }
}

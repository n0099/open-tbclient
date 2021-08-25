package c.a.q0.y1;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.File;
/* loaded from: classes4.dex */
public interface c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f29095a = File.separator;

    /* renamed from: b  reason: collision with root package name */
    public static final String f29096b = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();

    /* renamed from: c  reason: collision with root package name */
    public static final String f29097c = f29096b + f29095a + ".tieba_video_monitor";

    /* renamed from: d  reason: collision with root package name */
    public static final String f29098d = f29097c + f29095a + "v1";

    /* renamed from: e  reason: collision with root package name */
    public static final String f29099e;

    /* renamed from: f  reason: collision with root package name */
    public static final String f29100f;

    /* renamed from: g  reason: collision with root package name */
    public static final String f29101g;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(f29098d);
        sb.append(f29095a);
        f29099e = sb.toString();
        f29100f = f29096b + f29095a + ".tieba_video_monitor_log";
        f29101g = f29100f + f29095a + "v1";
        StringBuilder sb2 = new StringBuilder();
        sb2.append(f29101g);
        sb2.append(f29095a);
        sb2.toString();
    }
}

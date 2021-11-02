package b.a.r0.a2;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.File;
/* loaded from: classes4.dex */
public interface c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f14673a = File.separator;

    /* renamed from: b  reason: collision with root package name */
    public static final String f14674b = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();

    /* renamed from: c  reason: collision with root package name */
    public static final String f14675c = f14674b + f14673a + ".tieba_video_monitor";

    /* renamed from: d  reason: collision with root package name */
    public static final String f14676d = f14675c + f14673a + "v1";

    /* renamed from: e  reason: collision with root package name */
    public static final String f14677e;

    /* renamed from: f  reason: collision with root package name */
    public static final String f14678f;

    /* renamed from: g  reason: collision with root package name */
    public static final String f14679g;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(f14676d);
        sb.append(f14673a);
        f14677e = sb.toString();
        f14678f = f14674b + f14673a + ".tieba_video_monitor_log";
        f14679g = f14678f + f14673a + "v1";
        StringBuilder sb2 = new StringBuilder();
        sb2.append(f14679g);
        sb2.append(f14673a);
        sb2.toString();
    }
}

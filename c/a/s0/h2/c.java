package c.a.s0.h2;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.File;
/* loaded from: classes7.dex */
public interface c {
    public static final String a = File.separator;

    /* renamed from: b  reason: collision with root package name */
    public static final String f18046b = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();

    /* renamed from: c  reason: collision with root package name */
    public static final String f18047c = f18046b + a + ".tieba_video_monitor";

    /* renamed from: d  reason: collision with root package name */
    public static final String f18048d = f18047c + a + "v1";

    /* renamed from: e  reason: collision with root package name */
    public static final String f18049e;

    /* renamed from: f  reason: collision with root package name */
    public static final String f18050f;

    /* renamed from: g  reason: collision with root package name */
    public static final String f18051g;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(f18048d);
        sb.append(a);
        f18049e = sb.toString();
        f18050f = f18046b + a + ".tieba_video_monitor_log";
        f18051g = f18050f + a + "v1";
        StringBuilder sb2 = new StringBuilder();
        sb2.append(f18051g);
        sb2.append(a);
        sb2.toString();
    }
}

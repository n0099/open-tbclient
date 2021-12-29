package c.a.t0.h2;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.File;
/* loaded from: classes7.dex */
public interface c {
    public static final String a = File.separator;

    /* renamed from: b  reason: collision with root package name */
    public static final String f18550b = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();

    /* renamed from: c  reason: collision with root package name */
    public static final String f18551c = f18550b + a + ".tieba_video_monitor";

    /* renamed from: d  reason: collision with root package name */
    public static final String f18552d = f18551c + a + "v1";

    /* renamed from: e  reason: collision with root package name */
    public static final String f18553e;

    /* renamed from: f  reason: collision with root package name */
    public static final String f18554f;

    /* renamed from: g  reason: collision with root package name */
    public static final String f18555g;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(f18552d);
        sb.append(a);
        f18553e = sb.toString();
        f18554f = f18550b + a + ".tieba_video_monitor_log";
        f18555g = f18554f + a + "v1";
        StringBuilder sb2 = new StringBuilder();
        sb2.append(f18555g);
        sb2.append(a);
        sb2.toString();
    }
}

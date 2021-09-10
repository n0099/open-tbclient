package c.a.r0.z1;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.File;
/* loaded from: classes4.dex */
public interface c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f29704a = File.separator;

    /* renamed from: b  reason: collision with root package name */
    public static final String f29705b = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();

    /* renamed from: c  reason: collision with root package name */
    public static final String f29706c = f29705b + f29704a + ".tieba_video_monitor";

    /* renamed from: d  reason: collision with root package name */
    public static final String f29707d = f29706c + f29704a + "v1";

    /* renamed from: e  reason: collision with root package name */
    public static final String f29708e;

    /* renamed from: f  reason: collision with root package name */
    public static final String f29709f;

    /* renamed from: g  reason: collision with root package name */
    public static final String f29710g;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(f29707d);
        sb.append(f29704a);
        f29708e = sb.toString();
        f29709f = f29705b + f29704a + ".tieba_video_monitor_log";
        f29710g = f29709f + f29704a + "v1";
        StringBuilder sb2 = new StringBuilder();
        sb2.append(f29710g);
        sb2.append(f29704a);
        sb2.toString();
    }
}

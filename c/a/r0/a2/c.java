package c.a.r0.a2;

import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.File;
/* loaded from: classes3.dex */
public interface c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f15597a = File.separator;

    /* renamed from: b  reason: collision with root package name */
    public static final String f15598b = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();

    /* renamed from: c  reason: collision with root package name */
    public static final String f15599c = f15598b + f15597a + ".tieba_video_monitor";

    /* renamed from: d  reason: collision with root package name */
    public static final String f15600d = f15599c + f15597a + "v1";

    /* renamed from: e  reason: collision with root package name */
    public static final String f15601e;

    /* renamed from: f  reason: collision with root package name */
    public static final String f15602f;

    /* renamed from: g  reason: collision with root package name */
    public static final String f15603g;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(f15600d);
        sb.append(f15597a);
        f15601e = sb.toString();
        f15602f = f15598b + f15597a + ".tieba_video_monitor_log";
        f15603g = f15602f + f15597a + "v1";
        StringBuilder sb2 = new StringBuilder();
        sb2.append(f15603g);
        sb2.append(f15597a);
        sb2.toString();
    }
}

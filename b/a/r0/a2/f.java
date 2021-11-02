package b.a.r0.a2;

import android.os.Environment;
import java.io.File;
/* loaded from: classes4.dex */
public interface f {

    /* renamed from: a  reason: collision with root package name */
    public static final String f14680a = File.separator;

    /* renamed from: b  reason: collision with root package name */
    public static final String f14681b = Environment.getExternalStorageDirectory() + f14680a + "tieba";

    /* renamed from: c  reason: collision with root package name */
    public static final String f14682c = f14681b + f14680a + ".tieba_post_monitor";

    /* renamed from: d  reason: collision with root package name */
    public static final String f14683d = f14682c + f14680a + "v1";

    /* renamed from: e  reason: collision with root package name */
    public static final String f14684e;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(f14683d);
        sb.append(f14680a);
        f14684e = sb.toString();
    }
}

package c.a.p0.a0.a.g;

import c.a.o0.k.d;
import c.a.o0.r.e;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.advert.sdk.data.AdLoadState;
/* loaded from: classes2.dex */
public interface b {
    public static final boolean a;

    static {
        a = TbadkCoreApplication.getInst().isDebugMode() || e.h();
    }

    void a();

    boolean b();

    String c();

    AdLoadState d();

    void destroy();

    void e(d dVar);

    String f();

    void show();
}

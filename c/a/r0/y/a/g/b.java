package c.a.r0.y.a.g;

import c.a.q0.k.d;
import c.a.q0.r.e;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.advert.sdk.data.AdLoadState;
/* loaded from: classes3.dex */
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

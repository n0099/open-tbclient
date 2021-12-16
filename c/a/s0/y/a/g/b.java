package c.a.s0.y.a.g;

import c.a.r0.l.d;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.advert.sdk.data.AdLoadState;
/* loaded from: classes8.dex */
public interface b {
    public static final boolean a;

    static {
        a = TbadkCoreApplication.getInst().isDebugMode();
    }

    void a();

    AdLoadState b();

    void c(d dVar);

    String d();

    void destroy();

    void show();
}

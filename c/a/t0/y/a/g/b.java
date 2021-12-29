package c.a.t0.y.a.g;

import c.a.s0.l.d;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.advert.sdk.data.AdLoadState;
/* loaded from: classes8.dex */
public interface b {
    public static final boolean a;

    static {
        a = TbadkCoreApplication.getInst().isDebugMode();
    }

    void a();

    boolean b();

    AdLoadState c();

    void d(d dVar);

    void destroy();

    String e();

    void show();
}

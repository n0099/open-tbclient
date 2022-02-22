package c.a.t0.j0.d;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.t0.s.r.b1;
import c.a.t0.s.r.e2;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.tbadk.TbPageContext;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public interface a {
    @NonNull
    public static final ServiceReference a = new ServiceReference("HotTopic", "HotTopicRequest");

    /* renamed from: c.a.t0.j0.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0874a {
        void a();

        void b(@NonNull List<e2> list, @Nullable Map<String, Object> map);
    }

    a a(@NonNull TbPageContext tbPageContext, long j2, @NonNull String str);

    void b(int i2, b1 b1Var, long j2);

    void c(@Nullable InterfaceC0874a interfaceC0874a);
}

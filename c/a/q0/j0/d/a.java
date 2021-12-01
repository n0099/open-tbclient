package c.a.q0.j0.d;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.q0.s.q.b1;
import c.a.q0.s.q.d2;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.tbadk.TbPageContext;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public interface a {
    @NonNull
    public static final ServiceReference a = new ServiceReference("HotTopic", "HotTopicRequest");

    /* renamed from: c.a.q0.j0.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0785a {
        void a();

        void b(@NonNull List<d2> list, @Nullable Map<String, Object> map);
    }

    a a(@NonNull TbPageContext tbPageContext, long j2, @NonNull String str);

    void b(int i2, b1 b1Var, long j2);

    void c(@Nullable InterfaceC0785a interfaceC0785a);
}

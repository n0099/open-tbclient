package c.a.s0.j0.d;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.s0.s.q.b1;
import c.a.s0.s.q.e2;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.tbadk.TbPageContext;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public interface a {
    @NonNull
    public static final ServiceReference a = new ServiceReference("HotTopic", "HotTopicRequest");

    /* renamed from: c.a.s0.j0.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0863a {
        void a();

        void b(@NonNull List<e2> list, @Nullable Map<String, Object> map);
    }

    a a(@NonNull TbPageContext tbPageContext, long j2, @NonNull String str);

    void b(int i2, b1 b1Var, long j2);

    void c(@Nullable InterfaceC0863a interfaceC0863a);
}

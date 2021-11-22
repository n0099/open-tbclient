package b.a.q0.i0.d;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.a.q0.s.q.b1;
import b.a.q0.s.q.d2;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.tbadk.TbPageContext;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public interface a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public static final ServiceReference f13389a = new ServiceReference("HotTopic", "HotTopicRequest");

    /* renamed from: b.a.q0.i0.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0701a {
        void a();

        void b(@NonNull List<d2> list, @Nullable Map<String, Object> map);
    }

    a a(@NonNull TbPageContext tbPageContext, long j, @NonNull String str);

    void b(int i2, b1 b1Var, long j);

    void c(@Nullable InterfaceC0701a interfaceC0701a);
}

package c.a.q0.i0.c;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.q0.s.q.b1;
import c.a.q0.s.q.d2;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.tbadk.TbPageContext;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public interface a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public static final ServiceReference f13498a = new ServiceReference("HotTopic", "HotTopicRequest");

    /* renamed from: c.a.q0.i0.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0670a {
        void a();

        void b(@NonNull List<d2> list, @Nullable Map<String, Object> map);
    }

    a a(@NonNull TbPageContext tbPageContext, long j2, @NonNull String str);

    void b(int i2, b1 b1Var, long j2);

    void c(@Nullable InterfaceC0670a interfaceC0670a);
}

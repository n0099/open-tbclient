package c.a.o0.i0.d;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.o0.r.r.z0;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ThreadData;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public interface a {
    @NonNull
    public static final ServiceReference a = new ServiceReference("HotTopic", "HotTopicRequest");

    /* renamed from: c.a.o0.i0.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0813a {
        void a();

        void b(@NonNull List<ThreadData> list, @Nullable Map<String, Object> map);
    }

    a a(@NonNull TbPageContext tbPageContext, long j, @NonNull String str);

    void b(int i, z0 z0Var, long j);

    void c(@Nullable InterfaceC0813a interfaceC0813a);
}

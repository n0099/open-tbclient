package c.a.r0.g1.h.l;

import c.a.e.l.e.n;
import c.a.q0.d1.j0;
import c.a.q0.d1.m0;
import c.a.r0.g1.h.j.i;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.ThreadInfo;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static long f18401b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f18402a;

    /* loaded from: classes3.dex */
    public static class a extends j0<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ThreadInfo f18403a;

        public a(ThreadInfo threadInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {threadInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18403a = threadInfo;
        }

        @Override // c.a.q0.d1.j0
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                String[] split = c.a.q0.s.d0.b.j().p("read_progress_" + TbadkCoreApplication.getCurrentAccount(), "").split(",");
                if (split.length != 2) {
                    return null;
                }
                String str = split[0];
                long g2 = c.a.e.e.m.b.g(split[1], 0L);
                if (g2 != 0 && !StringUtils.isNull(str)) {
                    c.a.q0.s.d0.b.j().x("read_progress_" + TbadkCoreApplication.getCurrentAccount(), this.f18403a.tid + "," + g2);
                }
                return null;
            }
            return invokeV.objValue;
        }
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void d(long j2, int i2, List<ThreadInfo> list, List<n> list2) {
        ThreadInfo threadInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{Long.valueOf(j2), Integer.valueOf(i2), list, list2}) == null) || j2 != f18401b || ListUtils.isEmpty(list) || ListUtils.isEmpty(list2)) {
            return;
        }
        if (i2 == 0) {
            for (int i3 = 0; i3 < list2.size(); i3++) {
                if (list2.get(i3) instanceof b) {
                    list2.remove(i3);
                    return;
                }
            }
            return;
        }
        int i4 = i2 + 1;
        if (ListUtils.getCount(list) <= i4 || (threadInfo = list.get(i4)) == null || threadInfo.tid.longValue() == 0) {
            return;
        }
        f18401b = threadInfo.tid.longValue();
        m0.b(new a(threadInfo), null);
    }

    public void a(List<n> list) {
        c.a.r0.a0.d0.b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, list) == null) && TbadkCoreApplication.isLogin()) {
            if (this.f18402a == null) {
                c.a.q0.s.d0.b j2 = c.a.q0.s.d0.b.j();
                this.f18402a = j2.p("read_progress_" + TbadkCoreApplication.getCurrentAccount(), "");
            }
            if (StringUtils.isNull(this.f18402a)) {
                return;
            }
            String[] split = this.f18402a.split(",");
            if (split.length != 2) {
                return;
            }
            String str = split[0];
            long g2 = c.a.e.e.m.b.g(split[1], 0L);
            if (g2 == 0 || StringUtils.isNull(str) || ListUtils.isEmpty(list)) {
                return;
            }
            for (int i2 = 0; i2 < list.size(); i2++) {
                if ((list.get(i2) instanceof c.a.r0.a0.d0.b) && (bVar = (c.a.r0.a0.d0.b) list.get(i2)) != null && !StringUtils.isNull(bVar.l) && bVar.l.equals(str)) {
                    b bVar2 = new b();
                    bVar2.f18399e = g2;
                    bVar2.f18400f = false;
                    list.add(i2, bVar2);
                    return;
                }
            }
        }
    }

    public void b(ThreadInfo threadInfo) {
        Long l;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadInfo) == null) || !i.f18360a || threadInfo == null || threadInfo == null || (l = threadInfo.tid) == null || l.longValue() == 0) {
            return;
        }
        this.f18402a = null;
        f18401b = threadInfo.tid.longValue();
        c.a.q0.s.d0.b.j().x("read_progress_" + TbadkCoreApplication.getCurrentAccount(), threadInfo.tid + "," + System.currentTimeMillis());
    }

    public void c(boolean z, List<ThreadInfo> list) {
        ThreadInfo threadInfo;
        Long l;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(Constants.METHOD_SEND_USER_MSG, this, z, list) == null) || !TbadkCoreApplication.isLogin() || ListUtils.isEmpty(list) || !z || (threadInfo = (ThreadInfo) ListUtils.getItem(list, 0)) == null || (l = threadInfo.tid) == null || l.longValue() == 0) {
            return;
        }
        this.f18402a = null;
        f18401b = threadInfo.tid.longValue();
        c.a.q0.s.d0.b.j().x("read_progress_" + TbadkCoreApplication.getCurrentAccount(), threadInfo.tid + "," + System.currentTimeMillis());
    }
}

package c.a.r0;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.q0.j0.d.a;
import c.a.q0.s.q.b1;
import c.a.q0.s.q.d2;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.newdetail.HotTopicDetailModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class e implements c.a.i0.b.b.b<c.a.q0.j0.d.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public static final class b implements c.a.q0.j0.d.a, HotTopicDetailModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public HotTopicDetailModel f16640b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        public a.InterfaceC0785a f16641c;

        public b() {
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

        @Override // c.a.q0.j0.d.a
        public c.a.q0.j0.d.a a(@NonNull TbPageContext tbPageContext, long j2, @NonNull String str) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{tbPageContext, Long.valueOf(j2), str})) == null) {
                HotTopicDetailModel hotTopicDetailModel = new HotTopicDetailModel(tbPageContext);
                this.f16640b = hotTopicDetailModel;
                hotTopicDetailModel.L(j2, str);
                this.f16640b.K(this);
                return this;
            }
            return (c.a.q0.j0.d.a) invokeCommon.objValue;
        }

        @Override // c.a.q0.j0.d.a
        public void b(int i2, b1 b1Var, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), b1Var, Long.valueOf(j2)}) == null) {
                this.f16640b.y(i2, b1Var, j2);
            }
        }

        @Override // c.a.q0.j0.d.a
        public void c(@Nullable a.InterfaceC0785a interfaceC0785a) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, interfaceC0785a) == null) {
                this.f16641c = interfaceC0785a;
            }
        }

        @Override // com.baidu.tieba.newdetail.HotTopicDetailModel.d
        public void netLoadMoreCallback(int i2, @Nullable c.a.r0.p1.l.d dVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048579, this, i2, dVar) == null) || this.f16641c == null) {
                return;
            }
            if (dVar != null) {
                ArrayList arrayList = new ArrayList();
                for (c.a.r0.g0.f0.b bVar : dVar.c4) {
                    if (bVar instanceof c.a.r0.g0.f0.b) {
                        d2 threadData = bVar.getThreadData();
                        if (!TextUtils.equals(threadData.v1(), "0")) {
                            arrayList.add(threadData);
                        }
                    }
                }
                this.f16641c.b(arrayList, dVar.V4());
            }
            this.f16641c.a();
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    public e() {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.i0.b.b.b
    /* renamed from: a */
    public c.a.q0.j0.d.a getService() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new b(null) : (c.a.q0.j0.d.a) invokeV.objValue;
    }
}

package c.a.p0;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.o0.i0.d.a;
import c.a.o0.r.r.z0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tieba.newdetail.HotTopicDetailModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class e implements c.a.g0.b.b.b<c.a.o0.i0.d.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public static final class b implements c.a.o0.i0.d.a, HotTopicDetailModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public HotTopicDetailModel f13706b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        public a.InterfaceC0813a f13707c;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.o0.i0.d.a
        public c.a.o0.i0.d.a a(@NonNull TbPageContext tbPageContext, long j, @NonNull String str) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{tbPageContext, Long.valueOf(j), str})) == null) {
                HotTopicDetailModel hotTopicDetailModel = new HotTopicDetailModel(tbPageContext);
                this.f13706b = hotTopicDetailModel;
                hotTopicDetailModel.N(j, str);
                this.f13706b.M(this);
                return this;
            }
            return (c.a.o0.i0.d.a) invokeCommon.objValue;
        }

        @Override // c.a.o0.i0.d.a
        public void b(int i, z0 z0Var, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), z0Var, Long.valueOf(j)}) == null) {
                this.f13706b.A(i, z0Var, j);
            }
        }

        @Override // c.a.o0.i0.d.a
        public void c(@Nullable a.InterfaceC0813a interfaceC0813a) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, interfaceC0813a) == null) {
                this.f13707c = interfaceC0813a;
            }
        }

        @Override // com.baidu.tieba.newdetail.HotTopicDetailModel.d
        public void netLoadMoreCallback(int i, @Nullable c.a.p0.s1.b.d dVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048579, this, i, dVar) == null) || this.f13707c == null) {
                return;
            }
            if (dVar != null) {
                ArrayList arrayList = new ArrayList();
                for (c.a.p0.h0.e0.b bVar : dVar.a) {
                    if (bVar instanceof c.a.p0.h0.e0.b) {
                        ThreadData threadData = bVar.getThreadData();
                        if (!TextUtils.equals(threadData.getTid(), "0")) {
                            arrayList.add(threadData);
                        }
                    }
                }
                this.f13707c.b(arrayList, dVar.i());
            }
            this.f13707c.a();
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.g0.b.b.b
    /* renamed from: a */
    public c.a.o0.i0.d.a getService() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new b(null) : (c.a.o0.i0.d.a) invokeV.objValue;
    }
}

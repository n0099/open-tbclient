package b.a.r0;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.a.q0.i0.c.a;
import b.a.q0.s.q.b1;
import b.a.q0.s.q.d2;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.newdetail.HotTopicDetailModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class e implements b.a.h0.b.b.b<b.a.q0.i0.c.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public static final class b implements b.a.q0.i0.c.a, HotTopicDetailModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public HotTopicDetailModel f16214b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        public a.InterfaceC0665a f16215c;

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

        @Override // b.a.q0.i0.c.a
        public b.a.q0.i0.c.a a(@NonNull TbPageContext tbPageContext, long j, @NonNull String str) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{tbPageContext, Long.valueOf(j), str})) == null) {
                HotTopicDetailModel hotTopicDetailModel = new HotTopicDetailModel(tbPageContext);
                this.f16214b = hotTopicDetailModel;
                hotTopicDetailModel.L(j, str);
                this.f16214b.K(this);
                return this;
            }
            return (b.a.q0.i0.c.a) invokeCommon.objValue;
        }

        @Override // b.a.q0.i0.c.a
        public void b(int i2, b1 b1Var, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), b1Var, Long.valueOf(j)}) == null) {
                this.f16214b.y(i2, b1Var, j);
            }
        }

        @Override // b.a.q0.i0.c.a
        public void c(@Nullable a.InterfaceC0665a interfaceC0665a) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, interfaceC0665a) == null) {
                this.f16215c = interfaceC0665a;
            }
        }

        @Override // com.baidu.tieba.newdetail.HotTopicDetailModel.d
        public void netLoadMoreCallback(int i2, @Nullable b.a.r0.j1.l.d dVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048579, this, i2, dVar) == null) || this.f16215c == null) {
                return;
            }
            if (dVar != null) {
                ArrayList arrayList = new ArrayList();
                for (b.a.r0.b0.e0.b bVar : dVar.X3) {
                    if (bVar instanceof b.a.r0.b0.e0.b) {
                        d2 threadData = bVar.getThreadData();
                        if (!TextUtils.equals(threadData.s1(), "0")) {
                            arrayList.add(threadData);
                        }
                    }
                }
                this.f16215c.b(arrayList, dVar.R4());
            }
            this.f16215c.a();
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
    @Override // b.a.h0.b.b.b
    /* renamed from: a */
    public b.a.q0.i0.c.a getService() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new b(null) : (b.a.q0.i0.c.a) invokeV.objValue;
    }
}

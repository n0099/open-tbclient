package c.a.r0.w1.s;

import android.text.TextUtils;
import c.a.d.f.d.l;
import c.a.q0.d1.i0;
import c.a.q0.d1.l0;
import c.a.q0.d1.q;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.lego.model.LegoPageModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.io.IOException;
import tbclient.Lego.DataRes;
/* loaded from: classes7.dex */
public class c implements c.a.r0.w1.s.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LegoPageModel a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.r0.w1.s.b f25203b;

    /* renamed from: c  reason: collision with root package name */
    public LegoPageModel.b f25204c;

    /* loaded from: classes7.dex */
    public class a implements LegoPageModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // com.baidu.tieba.lego.model.LegoPageModel.b
        public void a(long j2, String str, DataRes dataRes, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), str, dataRes, Boolean.valueOf(z)}) == null) || this.a.f25203b == null) {
                return;
            }
            this.a.f25203b.c(j2, str, dataRes, z);
        }

        @Override // com.baidu.tieba.lego.model.LegoPageModel.b
        public void b(long j2, String str, int i2, String str2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j2), str, Integer.valueOf(i2), str2}) == null) || this.a.f25203b == null) {
                return;
            }
            this.a.f25203b.b(j2, str, str2, i2);
        }

        @Override // com.baidu.tieba.lego.model.LegoPageModel.b
        public void c(long j2, String str, DataRes dataRes, boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j2), str, dataRes, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || this.a.f25203b == null) {
                return;
            }
            this.a.f25203b.a(true, dataRes, !z, j2, str, i2);
        }
    }

    /* loaded from: classes7.dex */
    public class b extends i0<DataRes> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f25205b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f25206c;

        public b(c cVar, l lVar, long j2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, lVar, Long.valueOf(j2), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lVar;
            this.f25205b = j2;
            this.f25206c = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.d1.i0
        /* renamed from: a */
        public DataRes doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                l lVar = this.a;
                StringBuilder sb = new StringBuilder();
                sb.append(this.f25205b);
                sb.append("_");
                sb.append(TextUtils.isEmpty(this.f25206c) ? "" : this.f25206c);
                byte[] bArr = (byte[]) lVar.get(sb.toString());
                if (bArr != null && bArr.length != 0) {
                    try {
                        return (DataRes) new Wire(new Class[0]).parseFrom(bArr, DataRes.class);
                    } catch (IOException unused) {
                    }
                }
                return null;
            }
            return (DataRes) invokeV.objValue;
        }
    }

    /* renamed from: c.a.r0.w1.s.c$c  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1438c implements q<DataRes> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f25207b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f25208c;

        public C1438c(c cVar, long j2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Long.valueOf(j2), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25208c = cVar;
            this.a = j2;
            this.f25207b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.d1.q
        /* renamed from: a */
        public void onReturnDataInUI(DataRes dataRes) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dataRes) == null) {
                this.f25208c.f(this.a, this.f25207b, dataRes);
            }
        }
    }

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f25204c = new a(this);
        LegoPageModel legoPageModel = new LegoPageModel(tbPageContext, bdUniqueId);
        this.a = legoPageModel;
        legoPageModel.z(this.f25204c);
    }

    @Override // c.a.r0.w1.s.a
    public void a(long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048576, this, j2, str) == null) {
            c.a.q0.s.r.a.f();
            l0.b(new b(this, c.a.q0.s.r.a.d("tb.lego_update"), j2, str), new C1438c(this, j2, str));
        }
    }

    @Override // c.a.r0.w1.s.a
    public void b(c.a.r0.w1.s.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.f25203b = bVar;
        }
    }

    @Override // c.a.r0.w1.s.a
    public void c(int i2, long j2, String str, int i3, String str2) {
        LegoPageModel legoPageModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), str, Integer.valueOf(i3), str2}) == null) || (legoPageModel = this.a) == null) {
            return;
        }
        legoPageModel.x(i2, j2, str, i3, str2);
    }

    public final void f(long j2, String str, DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j2), str, dataRes}) == null) || j2 < 0) {
            return;
        }
        c.a.r0.w1.s.b bVar = this.f25203b;
        if (bVar != null) {
            bVar.a(false, dataRes, false, j2, str, 1);
        }
        this.a.x(2, j2, str, 1, "");
    }
}

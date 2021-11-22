package b.a.r0.q1.s;

import android.text.TextUtils;
import b.a.e.f.d.l;
import b.a.q0.c1.i0;
import b.a.q0.c1.l0;
import b.a.q0.c1.q;
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
/* loaded from: classes5.dex */
public class c implements b.a.r0.q1.s.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public LegoPageModel f24291a;

    /* renamed from: b  reason: collision with root package name */
    public b.a.r0.q1.s.b f24292b;

    /* renamed from: c  reason: collision with root package name */
    public LegoPageModel.b f24293c;

    /* loaded from: classes5.dex */
    public class a implements LegoPageModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f24294a;

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
            this.f24294a = cVar;
        }

        @Override // com.baidu.tieba.lego.model.LegoPageModel.b
        public void a(long j, String str, DataRes dataRes, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), str, dataRes, Boolean.valueOf(z)}) == null) || this.f24294a.f24292b == null) {
                return;
            }
            this.f24294a.f24292b.c(j, str, dataRes, z);
        }

        @Override // com.baidu.tieba.lego.model.LegoPageModel.b
        public void b(long j, String str, int i2, String str2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), str, Integer.valueOf(i2), str2}) == null) || this.f24294a.f24292b == null) {
                return;
            }
            this.f24294a.f24292b.b(j, str, str2, i2);
        }

        @Override // com.baidu.tieba.lego.model.LegoPageModel.b
        public void c(long j, String str, DataRes dataRes, boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), str, dataRes, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || this.f24294a.f24292b == null) {
                return;
            }
            this.f24294a.f24292b.a(true, dataRes, !z, j, str, i2);
        }
    }

    /* loaded from: classes5.dex */
    public class b extends i0<DataRes> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l f24295a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f24296b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f24297c;

        public b(c cVar, l lVar, long j, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, lVar, Long.valueOf(j), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24295a = lVar;
            this.f24296b = j;
            this.f24297c = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.q0.c1.i0
        /* renamed from: a */
        public DataRes doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                l lVar = this.f24295a;
                StringBuilder sb = new StringBuilder();
                sb.append(this.f24296b);
                sb.append("_");
                sb.append(TextUtils.isEmpty(this.f24297c) ? "" : this.f24297c);
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

    /* renamed from: b.a.r0.q1.s.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1179c implements q<DataRes> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f24298a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f24299b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f24300c;

        public C1179c(c cVar, long j, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Long.valueOf(j), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24300c = cVar;
            this.f24298a = j;
            this.f24299b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.q0.c1.q
        /* renamed from: a */
        public void onReturnDataInUI(DataRes dataRes) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dataRes) == null) {
                this.f24300c.f(this.f24298a, this.f24299b, dataRes);
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
        this.f24293c = new a(this);
        LegoPageModel legoPageModel = new LegoPageModel(tbPageContext, bdUniqueId);
        this.f24291a = legoPageModel;
        legoPageModel.z(this.f24293c);
    }

    @Override // b.a.r0.q1.s.a
    public void a(long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048576, this, j, str) == null) {
            b.a.q0.s.r.a.f();
            l0.b(new b(this, b.a.q0.s.r.a.d("tb.lego_update"), j, str), new C1179c(this, j, str));
        }
    }

    @Override // b.a.r0.q1.s.a
    public void b(b.a.r0.q1.s.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.f24292b = bVar;
        }
    }

    @Override // b.a.r0.q1.s.a
    public void c(int i2, long j, String str, int i3, String str2) {
        LegoPageModel legoPageModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j), str, Integer.valueOf(i3), str2}) == null) || (legoPageModel = this.f24291a) == null) {
            return;
        }
        legoPageModel.x(i2, j, str, i3, str2);
    }

    public final void f(long j, String str, DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j), str, dataRes}) == null) || j < 0) {
            return;
        }
        b.a.r0.q1.s.b bVar = this.f24292b;
        if (bVar != null) {
            bVar.a(false, dataRes, false, j, str, 1);
        }
        this.f24291a.x(2, j, str, 1, "");
    }
}

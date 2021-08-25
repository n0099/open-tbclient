package c.a.q0.o1.s;

import android.text.TextUtils;
import c.a.e.e.d.l;
import c.a.p0.b1.h0;
import c.a.p0.b1.k0;
import c.a.p0.b1.n;
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
/* loaded from: classes3.dex */
public class c implements c.a.q0.o1.s.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public LegoPageModel f23104a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.q0.o1.s.b f23105b;

    /* renamed from: c  reason: collision with root package name */
    public LegoPageModel.b f23106c;

    /* loaded from: classes3.dex */
    public class a implements LegoPageModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f23107a;

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
            this.f23107a = cVar;
        }

        @Override // com.baidu.tieba.lego.model.LegoPageModel.b
        public void a(long j2, String str, DataRes dataRes, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), str, dataRes, Boolean.valueOf(z)}) == null) || this.f23107a.f23105b == null) {
                return;
            }
            this.f23107a.f23105b.c(j2, str, dataRes, z);
        }

        @Override // com.baidu.tieba.lego.model.LegoPageModel.b
        public void b(long j2, String str, int i2, String str2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j2), str, Integer.valueOf(i2), str2}) == null) || this.f23107a.f23105b == null) {
                return;
            }
            this.f23107a.f23105b.b(j2, str, str2, i2);
        }

        @Override // com.baidu.tieba.lego.model.LegoPageModel.b
        public void c(long j2, String str, DataRes dataRes, boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j2), str, dataRes, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || this.f23107a.f23105b == null) {
                return;
            }
            this.f23107a.f23105b.a(true, dataRes, !z, j2, str, i2);
        }
    }

    /* loaded from: classes3.dex */
    public class b extends h0<DataRes> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l f23108a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f23109b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f23110c;

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
            this.f23108a = lVar;
            this.f23109b = j2;
            this.f23110c = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.b1.h0
        /* renamed from: a */
        public DataRes doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                l lVar = this.f23108a;
                StringBuilder sb = new StringBuilder();
                sb.append(this.f23109b);
                sb.append("_");
                sb.append(TextUtils.isEmpty(this.f23110c) ? "" : this.f23110c);
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

    /* renamed from: c.a.q0.o1.s.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1070c implements n<DataRes> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f23111a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f23112b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f23113c;

        public C1070c(c cVar, long j2, String str) {
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
            this.f23113c = cVar;
            this.f23111a = j2;
            this.f23112b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.b1.n
        /* renamed from: a */
        public void onReturnDataInUI(DataRes dataRes) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dataRes) == null) {
                this.f23113c.f(this.f23111a, this.f23112b, dataRes);
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
        this.f23106c = new a(this);
        LegoPageModel legoPageModel = new LegoPageModel(tbPageContext, bdUniqueId);
        this.f23104a = legoPageModel;
        legoPageModel.z(this.f23106c);
    }

    @Override // c.a.q0.o1.s.a
    public void a(long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048576, this, j2, str) == null) {
            c.a.p0.s.r.a.f();
            k0.b(new b(this, c.a.p0.s.r.a.d("tb.lego_update"), j2, str), new C1070c(this, j2, str));
        }
    }

    @Override // c.a.q0.o1.s.a
    public void b(c.a.q0.o1.s.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.f23105b = bVar;
        }
    }

    @Override // c.a.q0.o1.s.a
    public void c(int i2, long j2, String str, int i3, String str2) {
        LegoPageModel legoPageModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), str, Integer.valueOf(i3), str2}) == null) || (legoPageModel = this.f23104a) == null) {
            return;
        }
        legoPageModel.x(i2, j2, str, i3, str2);
    }

    public final void f(long j2, String str, DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j2), str, dataRes}) == null) || j2 < 0) {
            return;
        }
        c.a.q0.o1.s.b bVar = this.f23105b;
        if (bVar != null) {
            bVar.a(false, dataRes, false, j2, str, 1);
        }
        this.f23104a.x(2, j2, str, 1, "");
    }
}

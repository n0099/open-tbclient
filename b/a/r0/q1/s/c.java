package b.a.r0.q1.s;

import android.text.TextUtils;
import b.a.e.e.d.l;
import b.a.q0.d1.i0;
import b.a.q0.d1.l0;
import b.a.q0.d1.q;
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
    public LegoPageModel f22770a;

    /* renamed from: b  reason: collision with root package name */
    public b.a.r0.q1.s.b f22771b;

    /* renamed from: c  reason: collision with root package name */
    public LegoPageModel.b f22772c;

    /* loaded from: classes5.dex */
    public class a implements LegoPageModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f22773a;

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
            this.f22773a = cVar;
        }

        @Override // com.baidu.tieba.lego.model.LegoPageModel.b
        public void a(long j, String str, DataRes dataRes, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), str, dataRes, Boolean.valueOf(z)}) == null) || this.f22773a.f22771b == null) {
                return;
            }
            this.f22773a.f22771b.c(j, str, dataRes, z);
        }

        @Override // com.baidu.tieba.lego.model.LegoPageModel.b
        public void b(long j, String str, int i2, String str2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), str, Integer.valueOf(i2), str2}) == null) || this.f22773a.f22771b == null) {
                return;
            }
            this.f22773a.f22771b.b(j, str, str2, i2);
        }

        @Override // com.baidu.tieba.lego.model.LegoPageModel.b
        public void c(long j, String str, DataRes dataRes, boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), str, dataRes, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || this.f22773a.f22771b == null) {
                return;
            }
            this.f22773a.f22771b.a(true, dataRes, !z, j, str, i2);
        }
    }

    /* loaded from: classes5.dex */
    public class b extends i0<DataRes> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l f22774a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f22775b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f22776c;

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
            this.f22774a = lVar;
            this.f22775b = j;
            this.f22776c = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.q0.d1.i0
        /* renamed from: a */
        public DataRes doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                l lVar = this.f22774a;
                StringBuilder sb = new StringBuilder();
                sb.append(this.f22775b);
                sb.append("_");
                sb.append(TextUtils.isEmpty(this.f22776c) ? "" : this.f22776c);
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
    public class C1112c implements q<DataRes> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f22777a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f22778b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f22779c;

        public C1112c(c cVar, long j, String str) {
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
            this.f22779c = cVar;
            this.f22777a = j;
            this.f22778b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.q0.d1.q
        /* renamed from: a */
        public void onReturnDataInUI(DataRes dataRes) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dataRes) == null) {
                this.f22779c.f(this.f22777a, this.f22778b, dataRes);
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
        this.f22772c = new a(this);
        LegoPageModel legoPageModel = new LegoPageModel(tbPageContext, bdUniqueId);
        this.f22770a = legoPageModel;
        legoPageModel.z(this.f22772c);
    }

    @Override // b.a.r0.q1.s.a
    public void a(long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048576, this, j, str) == null) {
            b.a.q0.s.r.a.f();
            l0.b(new b(this, b.a.q0.s.r.a.d("tb.lego_update"), j, str), new C1112c(this, j, str));
        }
    }

    @Override // b.a.r0.q1.s.a
    public void b(b.a.r0.q1.s.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.f22771b = bVar;
        }
    }

    @Override // b.a.r0.q1.s.a
    public void c(int i2, long j, String str, int i3, String str2) {
        LegoPageModel legoPageModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j), str, Integer.valueOf(i3), str2}) == null) || (legoPageModel = this.f22770a) == null) {
            return;
        }
        legoPageModel.x(i2, j, str, i3, str2);
    }

    public final void f(long j, String str, DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j), str, dataRes}) == null) || j < 0) {
            return;
        }
        b.a.r0.q1.s.b bVar = this.f22771b;
        if (bVar != null) {
            bVar.a(false, dataRes, false, j, str, 1);
        }
        this.f22770a.x(2, j, str, 1, "");
    }
}

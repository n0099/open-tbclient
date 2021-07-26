package a.a.a.a.v.g.g;

import a.a.a.a.s.e;
import a.a.a.a.s.h;
import androidx.core.app.NotificationCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes.dex */
public abstract class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final a.a.a.a.v.g.d f1442a;

    /* renamed from: b  reason: collision with root package name */
    public final String f1443b;

    /* renamed from: c  reason: collision with root package name */
    public final int f1444c;

    /* renamed from: d  reason: collision with root package name */
    public final String f1445d;

    /* loaded from: classes.dex */
    public class a extends HashMap<String, Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Object[] f1446a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f1447b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d f1448c;

        public a(d dVar, Object[] objArr, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr2 = {dVar, objArr, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1448c = dVar;
            this.f1446a = objArr;
            this.f1447b = str;
            Object[] objArr3 = this.f1446a;
            if (objArr3 != null && objArr3.length > 0) {
                if (objArr3.length % 2 != 0) {
                    throw new IllegalArgumentException("Length of argument 'appends' must be even.");
                }
                int i4 = 0;
                while (true) {
                    Object[] objArr4 = this.f1446a;
                    if (i4 >= objArr4.length) {
                        break;
                    }
                    put(objArr4[i4].toString(), this.f1446a[i4 + 1]);
                    i4 += 2;
                }
            }
            put("st", this.f1447b);
            put("sid", this.f1448c.f1443b);
            put("sidv", Integer.valueOf(this.f1448c.f1444c));
            put("ldr_i", Integer.valueOf(a.a.a.a.v.b.a(this.f1448c.f1443b)));
            put("type", this.f1448c.f1445d);
        }
    }

    /* loaded from: classes.dex */
    public static class b extends d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, h.a aVar) {
            super(str, a.a.a.a.s.c.a(str, aVar), "n");
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (String) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c extends d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(e eVar) {
            super(eVar.f1340b, eVar.f1343e, "p");
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (String) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* renamed from: a.a.a.a.v.g.g.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0006d extends d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public long f1449e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0006d(a.a.a.a.s.d dVar) {
            super(dVar.f1332b, dVar.f1334d, "s");
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (String) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public void a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                a("ldr_ld_err", "layer", Integer.valueOf(i2), NotificationCompat.CATEGORY_ERROR, Integer.valueOf(i3));
            }
        }

        public void a(int i2, String str, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3)}) == null) {
                a("ldr_sld_st", "layer", Integer.valueOf(i2), "stype", str, "sst", Integer.valueOf(i3));
            }
        }

        @Override // a.a.a.a.v.g.g.d
        public void a(String str, Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, objArr) == null) {
                Object[] objArr2 = new Object[objArr.length + 2];
                objArr2[0] = "lid";
                objArr2[1] = Long.valueOf(this.f1449e);
                System.arraycopy(objArr, 0, objArr2, 2, objArr.length);
                super.a(str, objArr2);
            }
        }

        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
                this.f1449e = System.currentTimeMillis();
                a();
                a("ldr_ld_start", "irpt", Integer.valueOf(z ? 1 : 0));
            }
        }

        @Override // a.a.a.a.v.g.g.d
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                throw new UnsupportedOperationException();
            }
        }
    }

    public d(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1442a = a.a.a.a.v.g.d.a();
        this.f1443b = str;
        this.f1445d = str2;
        this.f1444c = i2;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int a2 = a.a.a.a.v.b.a(this.f1443b);
            String str = this.f1443b;
            a.a.a.a.v.b.a("key_sid_c_pre_" + str, a2 + 1);
        }
    }

    public void a(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, objArr) == null) {
            this.f1442a.a("ad_ldr", new a(this, objArr, str));
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            a();
            a("ldr_ld_start", new Object[0]);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            a("ldr_sh_start", new Object[0]);
        }
    }
}

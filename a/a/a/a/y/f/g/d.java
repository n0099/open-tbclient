package a.a.a.a.y.f.g;

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
    public final a.a.a.a.y.f.d f1410a;

    /* renamed from: b  reason: collision with root package name */
    public final String f1411b;

    /* renamed from: c  reason: collision with root package name */
    public final String f1412c;

    /* loaded from: classes.dex */
    public class a extends HashMap<String, Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Object[] f1413a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f1414b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d f1415c;

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
            this.f1415c = dVar;
            this.f1413a = objArr;
            this.f1414b = str;
            Object[] objArr3 = this.f1413a;
            if (objArr3 != null && objArr3.length > 0) {
                if (objArr3.length % 2 != 0) {
                    throw new IllegalArgumentException("Length of argument 'appends' must be even.");
                }
                int i4 = 0;
                while (true) {
                    Object[] objArr4 = this.f1413a;
                    if (i4 >= objArr4.length) {
                        break;
                    }
                    put(objArr4[i4].toString(), this.f1413a[i4 + 1]);
                    i4 += 2;
                }
            }
            put("st", this.f1414b);
            put("sid", this.f1415c.f1411b);
            put("ldr_i", Integer.valueOf(a.a.a.a.y.b.a(this.f1415c.f1411b)));
            put("type", this.f1415c.f1412c);
        }
    }

    /* loaded from: classes.dex */
    public static class b extends d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str) {
            super(str, "n");
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (String) objArr2[1]);
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
        public c(String str) {
            super(str, "p");
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* renamed from: a.a.a.a.y.f.g.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0006d extends d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: d  reason: collision with root package name */
        public long f1416d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0006d(String str) {
            super(str, "s");
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (String) objArr2[1]);
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

        @Override // a.a.a.a.y.f.g.d
        public void a(String str, Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, objArr) == null) {
                Object[] objArr2 = new Object[objArr.length + 2];
                objArr2[0] = "lid";
                objArr2[1] = Long.valueOf(this.f1416d);
                System.arraycopy(objArr, 0, objArr2, 2, objArr.length);
                super.a(str, objArr2);
            }
        }

        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
                this.f1416d = System.currentTimeMillis();
                a();
                a("ldr_ld_start", "irpt", Integer.valueOf(z ? 1 : 0));
            }
        }

        @Override // a.a.a.a.y.f.g.d
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                throw new UnsupportedOperationException();
            }
        }
    }

    public d(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1410a = a.a.a.a.y.f.d.a();
        this.f1411b = str;
        this.f1412c = str2;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int a2 = a.a.a.a.y.b.a(this.f1411b);
            String str = this.f1411b;
            a.a.a.a.y.b.a("key_sid_c_pre_" + str, a2 + 1);
        }
    }

    public void a(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, objArr) == null) {
            this.f1410a.a("ad_ldr", new a(this, objArr, str));
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

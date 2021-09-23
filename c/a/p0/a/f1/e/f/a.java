package c.a.p0.a.f1.e.f;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import c.a.p0.a.j2.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ConcurrentModificationException;
/* loaded from: classes.dex */
public interface a {

    /* renamed from: a  reason: collision with root package name */
    public static final c.a.p0.a.f1.e.f.b<Boolean> f5700a = new d(Boolean.FALSE);

    /* renamed from: b  reason: collision with root package name */
    public static final c.a.p0.a.f1.e.f.b<Integer> f5701b = new e(0);

    /* renamed from: c  reason: collision with root package name */
    public static final c.a.p0.a.f1.e.f.b<Long> f5702c = new f(0L);

    /* renamed from: d  reason: collision with root package name */
    public static final c.a.p0.a.f1.e.f.b<Float> f5703d = new g(Float.valueOf(0.0f));

    /* renamed from: e  reason: collision with root package name */
    public static final c.a.p0.a.f1.e.f.b<String> f5704e = new h();

    /* renamed from: f  reason: collision with root package name */
    public static final c.a.p0.a.f1.e.f.b<String[]> f5705f = new C0186a();

    /* renamed from: g  reason: collision with root package name */
    public static final c.a.p0.a.f1.e.f.b<Bundle> f5706g = new b();

    /* renamed from: h  reason: collision with root package name */
    public static final c.a.p0.a.f1.e.f.b<Parcelable> f5707h = new c();

    /* renamed from: c.a.p0.a.f1.e.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0186a extends c.a.p0.a.f1.e.f.b<String[]> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0186a() {
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
        @Override // c.a.p0.a.f1.e.f.b
        /* renamed from: f */
        public String[] c(Bundle bundle, String str, String[] strArr) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, bundle, str, strArr)) == null) ? bundle.getStringArray(str) : (String[]) invokeLLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.f1.e.f.b
        /* renamed from: g */
        public void e(Bundle bundle, String str, String[] strArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, bundle, str, strArr) == null) {
                bundle.putStringArray(str, strArr);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b extends c.a.p0.a.f1.e.f.b<Bundle> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.f1.e.f.b
        /* renamed from: f */
        public Bundle c(Bundle bundle, String str, Bundle bundle2) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, bundle, str, bundle2)) == null) ? bundle.getBundle(str) : (Bundle) invokeLLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.f1.e.f.b
        /* renamed from: g */
        public void e(Bundle bundle, String str, Bundle bundle2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, bundle, str, bundle2) == null) {
                bundle.putBundle(str, bundle2);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c extends c.a.p0.a.f1.e.f.b<Parcelable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.f1.e.f.b
        /* renamed from: f */
        public Parcelable c(Bundle bundle, String str, Parcelable parcelable) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, bundle, str, parcelable)) == null) ? bundle.getParcelable(str) : (Parcelable) invokeLLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.f1.e.f.b
        /* renamed from: g */
        public void e(Bundle bundle, String str, Parcelable parcelable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, bundle, str, parcelable) == null) {
                bundle.putParcelable(str, parcelable);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class d extends c.a.p0.a.f1.e.f.b<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Boolean bool) {
            super(bool);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bool};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.f1.e.f.b
        /* renamed from: f */
        public Boolean c(Bundle bundle, String str, Boolean bool) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, bundle, str, bool)) == null) ? Boolean.valueOf(bundle.getBoolean(str, bool.booleanValue())) : (Boolean) invokeLLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.f1.e.f.b
        /* renamed from: g */
        public void e(Bundle bundle, String str, Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, bundle, str, bool) == null) {
                bundle.putBoolean(str, bool.booleanValue());
            }
        }
    }

    /* loaded from: classes.dex */
    public static class e extends c.a.p0.a.f1.e.f.b<Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Integer num) {
            super(num);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {num};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.f1.e.f.b
        /* renamed from: f */
        public Integer c(Bundle bundle, String str, Integer num) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, bundle, str, num)) == null) ? Integer.valueOf(bundle.getInt(str, num.intValue())) : (Integer) invokeLLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.f1.e.f.b
        /* renamed from: g */
        public void e(Bundle bundle, String str, Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, bundle, str, num) == null) {
                try {
                    bundle.putInt(str, num.intValue());
                } catch (ConcurrentModificationException e2) {
                    c.b bVar = new c.b(10011);
                    bVar.h(c.a.p0.a.a2.e.i() == null ? "null appKey" : c.a.p0.a.a2.e.i().D());
                    bVar.k(str);
                    bVar.i(Log.getStackTraceString(e2));
                    bVar.m();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class f extends c.a.p0.a.f1.e.f.b<Long> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(Long l) {
            super(l);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.f1.e.f.b
        /* renamed from: f */
        public Long c(Bundle bundle, String str, Long l) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, bundle, str, l)) == null) ? Long.valueOf(bundle.getLong(str, l.longValue())) : (Long) invokeLLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.f1.e.f.b
        /* renamed from: g */
        public void e(Bundle bundle, String str, Long l) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, bundle, str, l) == null) {
                bundle.putLong(str, l.longValue());
            }
        }
    }

    /* loaded from: classes.dex */
    public static class g extends c.a.p0.a.f1.e.f.b<Float> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(Float f2) {
            super(f2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.f1.e.f.b
        /* renamed from: f */
        public Float c(Bundle bundle, String str, Float f2) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, bundle, str, f2)) == null) ? Float.valueOf(bundle.getFloat(str, f2.floatValue())) : (Float) invokeLLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.f1.e.f.b
        /* renamed from: g */
        public void e(Bundle bundle, String str, Float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, bundle, str, f2) == null) {
                bundle.putFloat(str, f2.floatValue());
            }
        }
    }

    /* loaded from: classes.dex */
    public static class h extends c.a.p0.a.f1.e.f.b<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public h() {
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
        @Override // c.a.p0.a.f1.e.f.b
        /* renamed from: f */
        public String c(Bundle bundle, String str, String str2) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, bundle, str, str2)) == null) ? bundle.getString(str, str2) : (String) invokeLLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.f1.e.f.b
        /* renamed from: g */
        public void e(Bundle bundle, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, bundle, str, str2) == null) {
                bundle.putString(str, str2);
            }
        }
    }
}

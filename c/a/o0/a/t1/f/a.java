package c.a.o0.a.t1.f;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.o0.a.a2.n.e;
import c.a.o0.a.a2.n.f;
import c.a.o0.a.b1.c;
import c.a.o0.a.b1.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a implements Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final e<a> l;
    public static final f<a> m;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f8677e;

    /* renamed from: f  reason: collision with root package name */
    public String f8678f;

    /* renamed from: g  reason: collision with root package name */
    public long f8679g;

    /* renamed from: h  reason: collision with root package name */
    public String f8680h;

    /* renamed from: i  reason: collision with root package name */
    public int f8681i;

    /* renamed from: j  reason: collision with root package name */
    public String f8682j;
    public String k;

    /* renamed from: c.a.o0.a.t1.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0379a extends e<a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0379a() {
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
        @Override // c.a.o0.a.a2.n.e
        /* renamed from: c */
        public a b(@NonNull c cVar) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                a aVar = new a();
                aVar.f8677e = cVar.r();
                aVar.f8678f = cVar.r();
                aVar.f8679g = cVar.readLong();
                aVar.f8680h = cVar.r();
                aVar.f8681i = cVar.readInt();
                aVar.f8682j = cVar.r();
                aVar.k = cVar.r();
                return aVar;
            }
            return (a) invokeL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class b extends f<a> {
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
        @Override // c.a.o0.a.a2.n.f
        /* renamed from: c */
        public void b(@NonNull a aVar, @NonNull d dVar) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, dVar) == null) {
                dVar.f(aVar.f8677e);
                dVar.f(aVar.f8678f);
                dVar.writeLong(aVar.f8679g);
                dVar.f(aVar.f8680h);
                dVar.writeInt(aVar.f8681i);
                dVar.f(aVar.f8682j);
                dVar.f(aVar.k);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1248472417, "Lc/a/o0/a/t1/f/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1248472417, "Lc/a/o0/a/t1/f/a;");
                return;
            }
        }
        l = new C0379a();
        m = new b();
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f8679g = -1L;
        this.f8681i = 4;
    }

    public Object clone() throws CloneNotSupportedException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? super.clone() : invokeV.objValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? !TextUtils.isEmpty(this.f8680h) && (this.f8679g >= 0 || !TextUtils.isEmpty(this.f8678f)) : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return "SwanPluginModel{pluginAlias='" + this.f8677e + ExtendedMessageFormat.QUOTE + ", pluginVersionName='" + this.f8678f + ExtendedMessageFormat.QUOTE + ", pluginVersionCode='" + this.f8679g + ExtendedMessageFormat.QUOTE + ", pluginName='" + this.f8680h + ExtendedMessageFormat.QUOTE + ", pluginCategory=" + this.f8681i + ", pluginPath='" + this.f8682j + ExtendedMessageFormat.QUOTE + ", pluginPagesConfigFileName='" + this.k + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }

    public a(JSONObject jSONObject, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f8679g = -1L;
        this.f8681i = 4;
        if (jSONObject == null) {
            return;
        }
        this.f8678f = jSONObject.optString("version");
        this.f8679g = jSONObject.optLong("version_code", -1L);
        this.f8680h = jSONObject.optString("provider");
        this.f8682j = jSONObject.optString("path");
        this.k = jSONObject.optString("config");
        this.f8681i = i2;
    }
}

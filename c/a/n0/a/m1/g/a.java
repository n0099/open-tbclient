package c.a.n0.a.m1.g;

import androidx.annotation.NonNull;
import c.a.n0.a.r0.d;
import c.a.n0.a.t1.n.e;
import c.a.n0.a.t1.n.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.updateprocessor.UpdateCloudControlProcessor;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.component.TKBase;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends c.a.n0.a.m1.g.b implements Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final e<a> k;
    public static final f<a> l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public boolean f5473g;

    /* renamed from: h  reason: collision with root package name */
    public long f5474h;
    public long i;
    public int j;

    /* renamed from: c.a.n0.a.m1.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0377a extends e<a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0377a() {
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
        @Override // c.a.n0.a.t1.n.e
        /* renamed from: b */
        public a a(@NonNull c.a.n0.a.r0.c cVar) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                a aVar = new a();
                aVar.a = cVar.g();
                aVar.f5475b = cVar.g();
                aVar.f5476c = cVar.readLong();
                aVar.f5477d = cVar.readInt();
                aVar.f5478e = cVar.g();
                aVar.f5479f = cVar.g();
                aVar.f5473g = cVar.readBoolean();
                aVar.f5474h = cVar.readLong();
                aVar.i = cVar.readLong();
                aVar.j = cVar.readInt();
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.t1.n.f
        /* renamed from: b */
        public void a(@NonNull a aVar, @NonNull d dVar) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, dVar) == null) {
                dVar.f(aVar.a);
                dVar.f(aVar.f5475b);
                dVar.writeLong(aVar.f5476c);
                dVar.writeInt(aVar.f5477d);
                dVar.f(aVar.f5478e);
                dVar.f(aVar.f5479f);
                dVar.writeBoolean(aVar.f5473g);
                dVar.writeLong(aVar.f5474h);
                dVar.writeLong(aVar.i);
                dVar.writeInt(aVar.j);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(999883480, "Lc/a/n0/a/m1/g/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(999883480, "Lc/a/n0/a/m1/g/a;");
                return;
            }
        }
        k = new C0377a();
        l = new b();
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f5473g = false;
        this.j = 1;
    }

    public Object clone() throws CloneNotSupportedException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? super.clone() : invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "SwanDependentModel{inline=" + this.f5473g + ", minVersionCode=" + this.f5474h + ", maxVersionCode=" + this.i + ", requireType=" + this.j + ", libName='" + this.a + "', versionName='" + this.f5475b + "', versionCode=" + this.f5476c + ", category=" + this.f5477d + ", libPath='" + this.f5478e + "', libConfig='" + this.f5479f + "'}";
        }
        return (String) invokeV.objValue;
    }

    public a(JSONObject jSONObject, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject, str};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f5473g = false;
        this.j = 1;
        if (jSONObject == null) {
            return;
        }
        this.a = str;
        this.f5477d = 6;
        this.f5475b = jSONObject.optString("version");
        this.f5476c = jSONObject.optLong("version_code", -1L);
        this.f5478e = jSONObject.optString("path");
        this.f5473g = jSONObject.optBoolean(TKBase.DISPLAY_INLINE, false);
        this.f5474h = jSONObject.optLong("min_version_code");
        this.i = jSONObject.optLong("max_version_code");
        this.f5479f = jSONObject.optString(UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME);
        this.j = jSONObject.optInt("require_type");
    }
}

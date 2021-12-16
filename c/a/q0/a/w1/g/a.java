package c.a.q0.a.w1.g;

import androidx.annotation.NonNull;
import c.a.q0.a.b1.d;
import c.a.q0.a.d2.n.e;
import c.a.q0.a.d2.n.f;
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
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends c.a.q0.a.w1.g.b implements Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final e<a> o;
    public static final f<a> p;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: k  reason: collision with root package name */
    public boolean f9021k;
    public long l;
    public long m;
    public int n;

    /* renamed from: c.a.q0.a.w1.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0553a extends e<a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0553a() {
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
        @Override // c.a.q0.a.d2.n.e
        /* renamed from: b */
        public a a(@NonNull c.a.q0.a.b1.c cVar) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                a aVar = new a();
                aVar.f9022e = cVar.g();
                aVar.f9023f = cVar.g();
                aVar.f9024g = cVar.readLong();
                aVar.f9025h = cVar.readInt();
                aVar.f9026i = cVar.g();
                aVar.f9027j = cVar.g();
                aVar.f9021k = cVar.readBoolean();
                aVar.l = cVar.readLong();
                aVar.m = cVar.readLong();
                aVar.n = cVar.readInt();
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
        @Override // c.a.q0.a.d2.n.f
        /* renamed from: b */
        public void a(@NonNull a aVar, @NonNull d dVar) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, dVar) == null) {
                dVar.f(aVar.f9022e);
                dVar.f(aVar.f9023f);
                dVar.writeLong(aVar.f9024g);
                dVar.writeInt(aVar.f9025h);
                dVar.f(aVar.f9026i);
                dVar.f(aVar.f9027j);
                dVar.writeBoolean(aVar.f9021k);
                dVar.writeLong(aVar.l);
                dVar.writeLong(aVar.m);
                dVar.writeInt(aVar.n);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1672233855, "Lc/a/q0/a/w1/g/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1672233855, "Lc/a/q0/a/w1/g/a;");
                return;
            }
        }
        o = new C0553a();
        p = new b();
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
        this.f9021k = false;
        this.n = 1;
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
            return "SwanDependentModel{inline=" + this.f9021k + ", minVersionCode=" + this.l + ", maxVersionCode=" + this.m + ", requireType=" + this.n + ", libName='" + this.f9022e + ExtendedMessageFormat.QUOTE + ", versionName='" + this.f9023f + ExtendedMessageFormat.QUOTE + ", versionCode=" + this.f9024g + ", category=" + this.f9025h + ", libPath='" + this.f9026i + ExtendedMessageFormat.QUOTE + ", libConfig='" + this.f9027j + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f9021k = false;
        this.n = 1;
        if (jSONObject == null) {
            return;
        }
        this.f9022e = str;
        this.f9025h = 6;
        this.f9023f = jSONObject.optString("version");
        this.f9024g = jSONObject.optLong("version_code", -1L);
        this.f9026i = jSONObject.optString("path");
        this.f9021k = jSONObject.optBoolean(TKBase.DISPLAY_INLINE, false);
        this.l = jSONObject.optLong("min_version_code");
        this.m = jSONObject.optLong("max_version_code");
        this.f9027j = jSONObject.optString(UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME);
        this.n = jSONObject.optInt("require_type");
    }
}

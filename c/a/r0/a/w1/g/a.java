package c.a.r0.a.w1.g;

import androidx.annotation.NonNull;
import c.a.r0.a.b1.d;
import c.a.r0.a.d2.n.e;
import c.a.r0.a.d2.n.f;
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
public class a extends c.a.r0.a.w1.g.b implements Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final e<a> o;
    public static final f<a> p;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean k;
    public long l;
    public long m;
    public int n;

    /* renamed from: c.a.r0.a.w1.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0621a extends e<a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0621a() {
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
        @Override // c.a.r0.a.d2.n.e
        /* renamed from: b */
        public a a(@NonNull c.a.r0.a.b1.c cVar) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                a aVar = new a();
                aVar.f9687e = cVar.g();
                aVar.f9688f = cVar.g();
                aVar.f9689g = cVar.readLong();
                aVar.f9690h = cVar.readInt();
                aVar.f9691i = cVar.g();
                aVar.f9692j = cVar.g();
                aVar.k = cVar.readBoolean();
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
        @Override // c.a.r0.a.d2.n.f
        /* renamed from: b */
        public void a(@NonNull a aVar, @NonNull d dVar) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, dVar) == null) {
                dVar.f(aVar.f9687e);
                dVar.f(aVar.f9688f);
                dVar.writeLong(aVar.f9689g);
                dVar.writeInt(aVar.f9690h);
                dVar.f(aVar.f9691i);
                dVar.f(aVar.f9692j);
                dVar.writeBoolean(aVar.k);
                dVar.writeLong(aVar.l);
                dVar.writeLong(aVar.m);
                dVar.writeInt(aVar.n);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1801316574, "Lc/a/r0/a/w1/g/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1801316574, "Lc/a/r0/a/w1/g/a;");
                return;
            }
        }
        o = new C0621a();
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
        this.k = false;
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
            return "SwanDependentModel{inline=" + this.k + ", minVersionCode=" + this.l + ", maxVersionCode=" + this.m + ", requireType=" + this.n + ", libName='" + this.f9687e + ExtendedMessageFormat.QUOTE + ", versionName='" + this.f9688f + ExtendedMessageFormat.QUOTE + ", versionCode=" + this.f9689g + ", category=" + this.f9690h + ", libPath='" + this.f9691i + ExtendedMessageFormat.QUOTE + ", libConfig='" + this.f9692j + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
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
        this.k = false;
        this.n = 1;
        if (jSONObject == null) {
            return;
        }
        this.f9687e = str;
        this.f9690h = 6;
        this.f9688f = jSONObject.optString("version");
        this.f9689g = jSONObject.optLong("version_code", -1L);
        this.f9691i = jSONObject.optString("path");
        this.k = jSONObject.optBoolean(TKBase.DISPLAY_INLINE, false);
        this.l = jSONObject.optLong("min_version_code");
        this.m = jSONObject.optLong("max_version_code");
        this.f9692j = jSONObject.optString(UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME);
        this.n = jSONObject.optInt("require_type");
    }
}

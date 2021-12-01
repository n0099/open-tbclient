package c.a.p0.a.w1.g;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.p0.a.b1.d;
import c.a.p0.a.d2.n.e;
import c.a.p0.a.d2.n.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.updateprocessor.UpdateCloudControlProcessor;
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
public class c extends c.a.p0.a.w1.g.b implements Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final e<c> l;
    public static final f<c> m;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: k  reason: collision with root package name */
    public String f8719k;

    /* loaded from: classes.dex */
    public static class a extends e<c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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
        @Override // c.a.p0.a.d2.n.e
        /* renamed from: b */
        public c a(@NonNull c.a.p0.a.b1.c cVar) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                c cVar2 = new c();
                cVar2.f8719k = cVar.g();
                cVar2.f8714f = cVar.g();
                cVar2.f8715g = cVar.readLong();
                cVar2.f8713e = cVar.g();
                cVar2.f8716h = cVar.readInt();
                cVar2.f8717i = cVar.g();
                cVar2.f8718j = cVar.g();
                return cVar2;
            }
            return (c) invokeL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class b extends f<c> {
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
        @Override // c.a.p0.a.d2.n.f
        /* renamed from: b */
        public void a(@NonNull c cVar, @NonNull d dVar) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, dVar) == null) {
                dVar.f(cVar.f8719k);
                dVar.f(cVar.f8714f);
                dVar.writeLong(cVar.f8715g);
                dVar.f(cVar.f8713e);
                dVar.writeInt(cVar.f8716h);
                dVar.f(cVar.f8717i);
                dVar.f(cVar.f8718j);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1543151198, "Lc/a/p0/a/w1/g/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1543151198, "Lc/a/p0/a/w1/g/c;");
                return;
            }
        }
        l = new a();
        m = new b();
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? !TextUtils.isEmpty(this.f8713e) && (this.f8715g >= 0 || !TextUtils.isEmpty(this.f8714f)) : invokeV.booleanValue;
    }

    public Object clone() throws CloneNotSupportedException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? super.clone() : invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return "SwanPluginModel{pluginAlias='" + this.f8719k + ExtendedMessageFormat.QUOTE + ", versionName='" + this.f8714f + ExtendedMessageFormat.QUOTE + ", versionCode='" + this.f8715g + ExtendedMessageFormat.QUOTE + ", libName='" + this.f8713e + ExtendedMessageFormat.QUOTE + ", category=" + this.f8716h + ", libPath='" + this.f8717i + ExtendedMessageFormat.QUOTE + ", libConfig='" + this.f8718j + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }

    public c(JSONObject jSONObject, int i2) {
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
        if (jSONObject == null) {
            return;
        }
        this.f8714f = jSONObject.optString("version");
        this.f8715g = jSONObject.optLong("version_code", -1L);
        this.f8713e = jSONObject.optString("provider");
        this.f8717i = jSONObject.optString("path");
        this.f8718j = jSONObject.optString(UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME);
        this.f8716h = i2;
    }
}

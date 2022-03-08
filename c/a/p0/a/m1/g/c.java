package c.a.p0.a.m1.g;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.p0.a.r0.d;
import c.a.p0.a.t1.n.e;
import c.a.p0.a.t1.n.f;
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
public class c extends c.a.p0.a.m1.g.b implements Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final e<c> l;
    public static final f<c> m;
    public transient /* synthetic */ FieldHolder $fh;
    public String k;

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
        @Override // c.a.p0.a.t1.n.e
        /* renamed from: b */
        public c a(@NonNull c.a.p0.a.r0.c cVar) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                c cVar2 = new c();
                cVar2.k = cVar.g();
                cVar2.f6516f = cVar.g();
                cVar2.f6517g = cVar.readLong();
                cVar2.f6515e = cVar.g();
                cVar2.f6518h = cVar.readInt();
                cVar2.f6519i = cVar.g();
                cVar2.f6520j = cVar.g();
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
        @Override // c.a.p0.a.t1.n.f
        /* renamed from: b */
        public void a(@NonNull c cVar, @NonNull d dVar) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, dVar) == null) {
                dVar.f(cVar.k);
                dVar.f(cVar.f6516f);
                dVar.writeLong(cVar.f6517g);
                dVar.f(cVar.f6515e);
                dVar.writeInt(cVar.f6518h);
                dVar.f(cVar.f6519i);
                dVar.f(cVar.f6520j);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1258048980, "Lc/a/p0/a/m1/g/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1258048980, "Lc/a/p0/a/m1/g/c;");
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? !TextUtils.isEmpty(this.f6515e) && (this.f6517g >= 0 || !TextUtils.isEmpty(this.f6516f)) : invokeV.booleanValue;
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
            return "SwanPluginModel{pluginAlias='" + this.k + ExtendedMessageFormat.QUOTE + ", versionName='" + this.f6516f + ExtendedMessageFormat.QUOTE + ", versionCode='" + this.f6517g + ExtendedMessageFormat.QUOTE + ", libName='" + this.f6515e + ExtendedMessageFormat.QUOTE + ", category=" + this.f6518h + ", libPath='" + this.f6519i + ExtendedMessageFormat.QUOTE + ", libConfig='" + this.f6520j + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
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
        this.f6516f = jSONObject.optString("version");
        this.f6517g = jSONObject.optLong("version_code", -1L);
        this.f6515e = jSONObject.optString("provider");
        this.f6519i = jSONObject.optString("path");
        this.f6520j = jSONObject.optString(UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME);
        this.f6518h = i2;
    }
}

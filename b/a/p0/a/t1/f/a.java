package b.a.p0.a.t1.f;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import b.a.p0.a.a2.n.e;
import b.a.p0.a.a2.n.f;
import b.a.p0.a.b1.c;
import b.a.p0.a.b1.d;
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
public class a implements Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final e<a> l;
    public static final f<a> m;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f7979e;

    /* renamed from: f  reason: collision with root package name */
    public String f7980f;

    /* renamed from: g  reason: collision with root package name */
    public long f7981g;

    /* renamed from: h  reason: collision with root package name */
    public String f7982h;

    /* renamed from: i  reason: collision with root package name */
    public int f7983i;
    public String j;
    public String k;

    /* renamed from: b.a.p0.a.t1.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0376a extends e<a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0376a() {
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
        @Override // b.a.p0.a.a2.n.e
        /* renamed from: b */
        public a a(@NonNull c cVar) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                a aVar = new a();
                aVar.f7979e = cVar.g();
                aVar.f7980f = cVar.g();
                aVar.f7981g = cVar.readLong();
                aVar.f7982h = cVar.g();
                aVar.f7983i = cVar.readInt();
                aVar.j = cVar.g();
                aVar.k = cVar.g();
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
        @Override // b.a.p0.a.a2.n.f
        /* renamed from: b */
        public void a(@NonNull a aVar, @NonNull d dVar) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, dVar) == null) {
                dVar.f(aVar.f7979e);
                dVar.f(aVar.f7980f);
                dVar.writeLong(aVar.f7981g);
                dVar.f(aVar.f7982h);
                dVar.writeInt(aVar.f7983i);
                dVar.f(aVar.j);
                dVar.f(aVar.k);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-608855521, "Lb/a/p0/a/t1/f/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-608855521, "Lb/a/p0/a/t1/f/a;");
                return;
            }
        }
        l = new C0376a();
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
        this.f7981g = -1L;
        this.f7983i = 4;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? !TextUtils.isEmpty(this.f7982h) && (this.f7981g >= 0 || !TextUtils.isEmpty(this.f7980f)) : invokeV.booleanValue;
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
            return "SwanPluginModel{pluginAlias='" + this.f7979e + ExtendedMessageFormat.QUOTE + ", pluginVersionName='" + this.f7980f + ExtendedMessageFormat.QUOTE + ", pluginVersionCode='" + this.f7981g + ExtendedMessageFormat.QUOTE + ", pluginName='" + this.f7982h + ExtendedMessageFormat.QUOTE + ", pluginCategory=" + this.f7983i + ", pluginPath='" + this.j + ExtendedMessageFormat.QUOTE + ", pluginPagesConfigFileName='" + this.k + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
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
        this.f7981g = -1L;
        this.f7983i = 4;
        if (jSONObject == null) {
            return;
        }
        this.f7980f = jSONObject.optString("version");
        this.f7981g = jSONObject.optLong("version_code", -1L);
        this.f7982h = jSONObject.optString("provider");
        this.j = jSONObject.optString("path");
        this.k = jSONObject.optString(UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME);
        this.f7983i = i2;
    }
}

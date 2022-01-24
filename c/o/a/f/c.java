package c.o.a.f;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes9.dex */
public class c extends c.o.a.f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, Object> a;

    /* renamed from: b  reason: collision with root package name */
    public final a f30280b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f30281c;

    /* loaded from: classes9.dex */
    public class a implements g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Object a;

        /* renamed from: b  reason: collision with root package name */
        public String f30282b;

        /* renamed from: c  reason: collision with root package name */
        public String f30283c;

        /* renamed from: d  reason: collision with root package name */
        public Object f30284d;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.o.a.f.g
        public void error(String str, String str2, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, obj) == null) {
                this.f30282b = str;
                this.f30283c = str2;
                this.f30284d = obj;
            }
        }

        @Override // c.o.a.f.g
        public void success(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                this.a = obj;
            }
        }
    }

    public c(Map<String, Object> map, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {map, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f30280b = new a(this);
        this.a = map;
        this.f30281c = z;
    }

    @Override // c.o.a.f.f
    public <T> T a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? (T) this.a.get(str) : (T) invokeL.objValue;
    }

    @Override // c.o.a.f.b, c.o.a.f.f
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f30281c : invokeV.booleanValue;
    }

    @Override // c.o.a.f.a
    public g i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f30280b : (g) invokeV.objValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (String) this.a.get("method") : (String) invokeV.objValue;
    }

    public Map<String, Object> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            hashMap2.put("code", this.f30280b.f30282b);
            hashMap2.put("message", this.f30280b.f30283c);
            hashMap2.put("data", this.f30280b.f30284d);
            hashMap.put("error", hashMap2);
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }

    public Map<String, Object> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("result", this.f30280b.a);
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }

    public void m(MethodChannel.Result result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, result) == null) {
            a aVar = this.f30280b;
            result.error(aVar.f30282b, aVar.f30283c, aVar.f30284d);
        }
    }

    public void n(List<Map<String, Object>> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, list) == null) || d()) {
            return;
        }
        list.add(k());
    }

    public void o(List<Map<String, Object>> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) || d()) {
            return;
        }
        list.add(l());
    }
}

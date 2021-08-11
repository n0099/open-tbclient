package c.b.c.b;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.tea.crash.c;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes4.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Map<c, List<b>> f31300a;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, String> f31301b;

    /* renamed from: c  reason: collision with root package name */
    public final List<i> f31302c;

    /* renamed from: d  reason: collision with root package name */
    public final List<i> f31303d;

    /* renamed from: e  reason: collision with root package name */
    public k f31304e;

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31300a = new HashMap();
        this.f31301b = new HashMap();
        new CopyOnWriteArrayList();
        this.f31302c = new CopyOnWriteArrayList();
        new CopyOnWriteArrayList();
        this.f31303d = new CopyOnWriteArrayList();
        this.f31304e = null;
    }

    @Nullable
    public List<b> a(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) ? this.f31300a.get(cVar) : (List) invokeL.objValue;
    }

    public Map<String, String> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f31301b : (Map) invokeV.objValue;
    }

    public void c(k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, kVar) == null) {
            this.f31304e = kVar;
        }
    }

    public void d(Map<? extends String, ? extends String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, map) == null) {
            this.f31301b.putAll(map);
        }
    }

    @NonNull
    public List<i> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f31302c : (List) invokeV.objValue;
    }

    @NonNull
    public List<i> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f31303d : (List) invokeV.objValue;
    }

    @Nullable
    public k g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f31304e : (k) invokeV.objValue;
    }
}

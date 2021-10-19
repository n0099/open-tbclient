package c.a.r0.k2.o.j;

import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.t.c.f;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.PbPage.FloatingIconItem;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FloatingIconItem f20889a;

    /* renamed from: b  reason: collision with root package name */
    public f f20890b;

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

    @Nullable
    public String a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            if (z) {
                FloatingIconItem floatingIconItem = this.f20889a;
                if (floatingIconItem != null) {
                    return floatingIconItem.icon_url;
                }
                return null;
            }
            f fVar = this.f20890b;
            if (fVar != null) {
                return fVar.h();
            }
            return null;
        }
        return (String) invokeZ.objValue;
    }

    public String b(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            if (z) {
                FloatingIconItem floatingIconItem = this.f20889a;
                if (floatingIconItem != null) {
                    return floatingIconItem.package_name;
                }
                return null;
            }
            f fVar = this.f20890b;
            if (fVar != null) {
                return fVar.i();
            }
            return null;
        }
        return (String) invokeZ.objValue;
    }

    public String c(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
            if (z) {
                FloatingIconItem floatingIconItem = this.f20889a;
                if (floatingIconItem != null) {
                    return floatingIconItem.scheme;
                }
                return null;
            }
            f fVar = this.f20890b;
            if (fVar != null) {
                return fVar.j();
            }
            return null;
        }
        return (String) invokeZ.objValue;
    }

    @Nullable
    public String d(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
            if (z) {
                FloatingIconItem floatingIconItem = this.f20889a;
                if (floatingIconItem != null) {
                    return floatingIconItem.url;
                }
                return null;
            }
            f fVar = this.f20890b;
            if (fVar != null) {
                return fVar.k();
            }
            return null;
        }
        return (String) invokeZ.objValue;
    }

    public String e(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
            if (z) {
                FloatingIconItem floatingIconItem = this.f20889a;
                if (floatingIconItem != null) {
                    return floatingIconItem.click_statistics_url;
                }
                return null;
            }
            f fVar = this.f20890b;
            if (fVar != null) {
                return fVar.g();
            }
            return null;
        }
        return (String) invokeZ.objValue;
    }

    public String f(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
            if (z) {
                FloatingIconItem floatingIconItem = this.f20889a;
                if (floatingIconItem != null) {
                    return floatingIconItem.view_statistics_url;
                }
                return null;
            }
            f fVar = this.f20890b;
            if (fVar != null) {
                return fVar.l();
            }
            return null;
        }
        return (String) invokeZ.objValue;
    }

    public boolean g(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
            if (z) {
                FloatingIconItem floatingIconItem = this.f20889a;
                return (floatingIconItem == null || StringUtils.isNull(floatingIconItem.icon_url) || StringUtils.isNull(this.f20889a.url)) ? false : true;
            }
            f fVar = this.f20890b;
            return (fVar == null || StringUtils.isNull(fVar.h()) || StringUtils.isNull(this.f20890b.k())) ? false : true;
        }
        return invokeZ.booleanValue;
    }

    public void h(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, fVar) == null) {
            this.f20890b = fVar;
        }
    }

    public void i(FloatingIconItem floatingIconItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, floatingIconItem) == null) {
            this.f20889a = floatingIconItem;
        }
    }
}

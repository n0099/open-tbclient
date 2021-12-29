package c.a.r0.a.y1.c;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Message a;

    /* renamed from: b  reason: collision with root package name */
    public final Set<SwanAppProcessInfo> f9926b;

    /* renamed from: c  reason: collision with root package name */
    public final Set<String> f9927c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f9928d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f9929e;

    /* renamed from: f  reason: collision with root package name */
    public long f9930f;

    public c(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {message};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f9926b = new HashSet();
        this.f9927c = new HashSet();
        this.f9928d = false;
        this.f9929e = false;
        this.f9930f = 0L;
        this.a = message == null ? Message.obtain() : message;
    }

    public c a(int... iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, iArr)) == null) {
            if (iArr != null) {
                for (int i2 : iArr) {
                    if (SwanAppProcessInfo.checkProcessId(i2)) {
                        b(SwanAppProcessInfo.indexOf(i2));
                    }
                }
            }
            return this;
        }
        return (c) invokeL.objValue;
    }

    public c b(SwanAppProcessInfo... swanAppProcessInfoArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, swanAppProcessInfoArr)) == null) {
            if (swanAppProcessInfoArr != null) {
                this.f9926b.addAll(Arrays.asList(swanAppProcessInfoArr));
            }
            return this;
        }
        return (c) invokeL.objValue;
    }

    public c c(String... strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, strArr)) == null) {
            if (strArr != null) {
                this.f9927c.addAll(Arrays.asList(strArr));
            }
            return this;
        }
        return (c) invokeL.objValue;
    }

    public c d() {
        InterceptResult invokeV;
        SwanAppProcessInfo[] indices;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            for (SwanAppProcessInfo swanAppProcessInfo : SwanAppProcessInfo.indices()) {
                if (swanAppProcessInfo.isSwanAppProcess()) {
                    b(swanAppProcessInfo);
                }
            }
            return this;
        }
        return (c) invokeV.objValue;
    }

    public c e(int... iArr) {
        InterceptResult invokeL;
        SwanAppProcessInfo[] indices;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, iArr)) == null) {
            for (SwanAppProcessInfo swanAppProcessInfo : SwanAppProcessInfo.indices()) {
                if (swanAppProcessInfo.isSwanAppProcess() && !g(iArr, swanAppProcessInfo.index)) {
                    b(swanAppProcessInfo);
                }
            }
            return this;
        }
        return (c) invokeL.objValue;
    }

    public c f(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
            this.f9928d = z;
            return this;
        }
        return (c) invokeZ.objValue;
    }

    public final boolean g(int[] iArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, iArr, i2)) == null) {
            if (iArr != null) {
                for (int i3 : iArr) {
                    if (i3 == i2) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    @NonNull
    public Message h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.a.obj == null) {
                o(new Bundle());
            }
            return this.a;
        }
        return (Message) invokeV.objValue;
    }

    public long i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            long j2 = this.f9930f;
            if (j2 < 0) {
                return 0L;
            }
            return j2;
        }
        return invokeV.longValue;
    }

    public c j(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048585, this, j2)) == null) {
            if (j2 < 0) {
                j2 = 0;
            }
            this.f9930f = j2;
            return this;
        }
        return (c) invokeJ.objValue;
    }

    public Set<String> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? new HashSet(this.f9927c) : (Set) invokeV.objValue;
    }

    public Set<SwanAppProcessInfo> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? new HashSet(this.f9926b) : (Set) invokeV.objValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f9928d : invokeV.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f9929e : invokeV.booleanValue;
    }

    public c o(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, obj)) == null) {
            this.a.obj = obj;
            return this;
        }
        return (c) invokeL.objValue;
    }

    public c p(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048591, this, z)) == null) {
            this.f9929e = z;
            return this;
        }
        return (c) invokeZ.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c(int i2, Object obj) {
        this(Message.obtain(null, i2, obj));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), obj};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                this((Message) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c(int i2) {
        this(Message.obtain((Handler) null, i2));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                this((Message) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }
}

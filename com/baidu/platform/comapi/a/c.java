package com.baidu.platform.comapi.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.platform.comapi.util.SysOSUtil;
import com.baidu.platform.comjni.base.logstatistics.NALogStatistics;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NALogStatistics a;
    public ArrayList<b> b;

    /* loaded from: classes2.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final c a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(143871633, "Lcom/baidu/platform/comapi/a/c$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(143871633, "Lcom/baidu/platform/comapi/a/c$a;");
                    return;
                }
            }
            a = new c(null);
        }
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = new ArrayList<>();
        b();
    }

    public static c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return a.a;
        }
        return (c) invokeV.objValue;
    }

    private boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            if (this.a == null) {
                this.a = new NALogStatistics();
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public /* synthetic */ c(d dVar) {
        this();
    }

    public boolean a(int i, int i2, String str, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, str2})) == null) {
            if (this.a != null) {
                if (com.baidu.platform.comapi.b.e() || com.baidu.platform.comapi.b.g()) {
                    a(new com.baidu.platform.comapi.a.a(i, i2, str, str2));
                }
                return this.a.a(i, i2, SysOSUtil.getInstance().getNetType(), str, str2);
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public boolean a(com.baidu.platform.comapi.a.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
            ArrayList<b> arrayList = this.b;
            if (arrayList != null && !arrayList.isEmpty()) {
                Iterator<b> it = this.b.iterator();
                while (it.hasNext()) {
                    it.next().a(aVar);
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}

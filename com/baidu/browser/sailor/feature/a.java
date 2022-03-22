package com.baidu.browser.sailor.feature;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "BdSailorFeature";
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, c.a.k.b.a.a> mClientsMap;
    public Context mContext;
    public Enum<EnumC1741a> mStatus;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* renamed from: com.baidu.browser.sailor.feature.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class EnumC1741a {
        public static /* synthetic */ Interceptable $ic;
        public static final EnumC1741a a;

        /* renamed from: b  reason: collision with root package name */
        public static final EnumC1741a f24986b;

        /* renamed from: c  reason: collision with root package name */
        public static final /* synthetic */ EnumC1741a[] f24987c;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(442310140, "Lcom/baidu/browser/sailor/feature/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(442310140, "Lcom/baidu/browser/sailor/feature/a$a;");
                    return;
                }
            }
            a = new EnumC1741a("ENABLE", 0);
            EnumC1741a enumC1741a = new EnumC1741a("DISABLE", 1);
            f24986b = enumC1741a;
            f24987c = new EnumC1741a[]{a, enumC1741a};
        }

        public EnumC1741a(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static EnumC1741a valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (EnumC1741a) Enum.valueOf(EnumC1741a.class, str) : (EnumC1741a) invokeL.objValue;
        }

        public static EnumC1741a[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (EnumC1741a[]) f24987c.clone() : (EnumC1741a[]) invokeV.objValue;
        }
    }

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mClientsMap = new HashMap();
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mContext = null;
            try {
                this.mClientsMap.clear();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void disable() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.mStatus = EnumC1741a.f24986b;
        }
    }

    public void enable() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.mStatus = EnumC1741a.a;
        }
    }

    public c.a.k.b.a.a getListenerFromActivity(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? this.mClientsMap.get(str) : (c.a.k.b.a.a) invokeL.objValue;
    }

    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? TAG : (String) invokeV.objValue;
    }

    public boolean isEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mStatus == EnumC1741a.a : invokeV.booleanValue;
    }

    public void regActivityResultCallback(String str, c.a.k.b.a.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, str, aVar) == null) || this.mClientsMap.containsKey(str)) {
            return;
        }
        this.mClientsMap.put(str, aVar);
    }

    public void unregActivityResultCallback(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, str) == null) && this.mClientsMap.containsKey(str)) {
            this.mClientsMap.remove(str);
        }
    }
}

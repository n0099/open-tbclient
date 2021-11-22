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
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "BdSailorFeature";
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, b.a.k.b.a.a> mClientsMap;
    public Context mContext;
    public Enum<EnumC1634a> mStatus;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* renamed from: com.baidu.browser.sailor.feature.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class EnumC1634a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final EnumC1634a f37426a;

        /* renamed from: b  reason: collision with root package name */
        public static final EnumC1634a f37427b;

        /* renamed from: c  reason: collision with root package name */
        public static final /* synthetic */ EnumC1634a[] f37428c;
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
            f37426a = new EnumC1634a("ENABLE", 0);
            EnumC1634a enumC1634a = new EnumC1634a("DISABLE", 1);
            f37427b = enumC1634a;
            f37428c = new EnumC1634a[]{f37426a, enumC1634a};
        }

        public EnumC1634a(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static EnumC1634a valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (EnumC1634a) Enum.valueOf(EnumC1634a.class, str) : (EnumC1634a) invokeL.objValue;
        }

        public static EnumC1634a[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (EnumC1634a[]) f37428c.clone() : (EnumC1634a[]) invokeV.objValue;
        }
    }

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            this.mStatus = EnumC1634a.f37427b;
        }
    }

    public void enable() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.mStatus = EnumC1634a.f37426a;
        }
    }

    public b.a.k.b.a.a getListenerFromActivity(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? this.mClientsMap.get(str) : (b.a.k.b.a.a) invokeL.objValue;
    }

    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? TAG : (String) invokeV.objValue;
    }

    public boolean isEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mStatus == EnumC1634a.f37426a : invokeV.booleanValue;
    }

    public void regActivityResultCallback(String str, b.a.k.b.a.a aVar) {
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

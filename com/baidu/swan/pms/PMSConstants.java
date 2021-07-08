package com.baidu.swan.pms;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class PMSConstants {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class CloudSwitch {
        public static final /* synthetic */ CloudSwitch[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final CloudSwitch DISPLAY;
        public static final CloudSwitch NO_DISPLAY;
        public transient /* synthetic */ FieldHolder $fh;
        public int value;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(960119636, "Lcom/baidu/swan/pms/PMSConstants$CloudSwitch;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(960119636, "Lcom/baidu/swan/pms/PMSConstants$CloudSwitch;");
                    return;
                }
            }
            NO_DISPLAY = new CloudSwitch("NO_DISPLAY", 0, 0);
            CloudSwitch cloudSwitch = new CloudSwitch("DISPLAY", 1, 1);
            DISPLAY = cloudSwitch;
            $VALUES = new CloudSwitch[]{NO_DISPLAY, cloudSwitch};
        }

        public CloudSwitch(String str, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.value = i3;
        }

        public static CloudSwitch valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (CloudSwitch) Enum.valueOf(CloudSwitch.class, str) : (CloudSwitch) invokeL.objValue;
        }

        public static CloudSwitch[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (CloudSwitch[]) $VALUES.clone() : (CloudSwitch[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class CustomerService {
        public static final /* synthetic */ CustomerService[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final CustomerService CUSTOMER_SERVICE;
        public static final CustomerService NO_CUSTOMER_SERVICE;
        public transient /* synthetic */ FieldHolder $fh;
        public int type;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(437015782, "Lcom/baidu/swan/pms/PMSConstants$CustomerService;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(437015782, "Lcom/baidu/swan/pms/PMSConstants$CustomerService;");
                    return;
                }
            }
            NO_CUSTOMER_SERVICE = new CustomerService("NO_CUSTOMER_SERVICE", 0, 0);
            CustomerService customerService = new CustomerService("CUSTOMER_SERVICE", 1, 1);
            CUSTOMER_SERVICE = customerService;
            $VALUES = new CustomerService[]{NO_CUSTOMER_SERVICE, customerService};
        }

        public CustomerService(String str, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.type = i3;
        }

        public static CustomerService valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (CustomerService) Enum.valueOf(CustomerService.class, str) : (CustomerService) invokeL.objValue;
        }

        public static CustomerService[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (CustomerService[]) $VALUES.clone() : (CustomerService[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class PayProtected {
        public static final /* synthetic */ PayProtected[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final PayProtected NO_PAY_PROTECTED;
        public static final PayProtected PAY_PROTECTED;
        public transient /* synthetic */ FieldHolder $fh;
        public int type;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(173411731, "Lcom/baidu/swan/pms/PMSConstants$PayProtected;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(173411731, "Lcom/baidu/swan/pms/PMSConstants$PayProtected;");
                    return;
                }
            }
            NO_PAY_PROTECTED = new PayProtected("NO_PAY_PROTECTED", 0, 0);
            PayProtected payProtected = new PayProtected("PAY_PROTECTED", 1, 1);
            PAY_PROTECTED = payProtected;
            $VALUES = new PayProtected[]{NO_PAY_PROTECTED, payProtected};
        }

        public PayProtected(String str, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.type = i3;
        }

        public static PayProtected valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (PayProtected) Enum.valueOf(PayProtected.class, str) : (PayProtected) invokeL.objValue;
        }

        public static PayProtected[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (PayProtected[]) $VALUES.clone() : (PayProtected[]) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static String a(int i2, String str) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(65536, null, i2, str)) == null) {
                if (i2 != 1020) {
                    switch (i2) {
                        case 1001:
                            return "system error";
                        case 1002:
                            return "the request is prohibited";
                        case 1003:
                            return "invalid common params";
                        case 1004:
                            return "invalid query params";
                        default:
                            switch (i2) {
                                case 1010:
                                    return "the current package is the latest";
                                case 1011:
                                    return "the app is not exist";
                                case 1012:
                                    return "the package is not exist";
                                case 1013:
                                    return "please upgrade SDK version";
                                case 1014:
                                    return "the framework is not available";
                                case 1015:
                                    return "the host app is not support this app";
                                default:
                                    return "";
                            }
                    }
                }
                return str;
            }
            return (String) invokeIL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
                return 1;
            }
            return invokeV.intValue;
        }
    }

    public static boolean a(d.a.n0.n.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, aVar)) == null) {
            if (aVar == null || !aVar.f()) {
                if (aVar != null) {
                    aVar.I("swan_bdtls_pms_encrypt", false);
                    return false;
                }
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}

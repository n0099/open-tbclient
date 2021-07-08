package com.baidu.sapi2.openbduss;

import android.text.TextUtils;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
import java.util.Map;
/* loaded from: classes2.dex */
public class PASSMethodCallTransfer implements NoProguard {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static abstract class DynamicCallbak {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int ERROR_CODE_NOT_FIND_CALL_METHOD = -1002;
        public static final int ERROR_CODE_NOT_LOGIN = -1001;
        public static final int ERROR_CODE_PARAMS_ERROR = -1003;
        public static final String ERROR_MSG_NOT_FIND_CALL_METHOD = "未找到反射方法";
        public static final String ERROR_MSG_NOT_LOGIN = "未登录";
        public static final String ERROR_MSG_PARAMS_ERROR = "参数错误";
        public transient /* synthetic */ FieldHolder $fh;

        public DynamicCallbak() {
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

        public abstract void onFailure(int i2, String str);
    }

    /* loaded from: classes2.dex */
    public static class ParamsWap {
        public static /* synthetic */ Interceptable $ic = null;
        public static String BDUSS = "2";
        public static String UID = "1";
        public transient /* synthetic */ FieldHolder $fh;
        public Map<String, String> attributes;
        public Object param;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-885740628, "Lcom/baidu/sapi2/openbduss/PASSMethodCallTransfer$ParamsWap;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-885740628, "Lcom/baidu/sapi2/openbduss/PASSMethodCallTransfer$ParamsWap;");
            }
        }

        public ParamsWap() {
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
    }

    public PASSMethodCallTransfer() {
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

    private Object[] buildParams(Object[] objArr, SapiAccount sapiAccount) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, objArr, sapiAccount)) == null) {
            Object[] objArr2 = new Object[objArr.length];
            int length = objArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                Object obj = objArr[i2];
                if (!(obj instanceof ParamsWap)) {
                    objArr2[i2] = obj;
                } else {
                    ParamsWap paramsWap = (ParamsWap) obj;
                    Map<String, String> map = paramsWap.attributes;
                    if (map == null) {
                        objArr2[i2] = paramsWap.param;
                    } else {
                        for (String str : map.keySet()) {
                            Object obj2 = null;
                            if (ParamsWap.UID.equals(str)) {
                                obj2 = setObjectValue(paramsWap.param, paramsWap.attributes.get(str), sapiAccount.uid);
                            } else if (ParamsWap.BDUSS.equals(str)) {
                                obj2 = setObjectValue(paramsWap.param, paramsWap.attributes.get(str), sapiAccount.bduss);
                            }
                            objArr2[i2] = obj2;
                        }
                    }
                }
            }
            return objArr2;
        }
        return (Object[]) invokeLL.objValue;
    }

    private Object setObjectValue(Object obj, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, this, obj, str, str2)) == null) {
            if (obj == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return obj;
            }
            if (obj instanceof String) {
                return str2;
            }
            if (obj instanceof Map) {
                ((Map) obj).put(str, str2);
                return obj;
            } else if (obj.getClass().isArray()) {
                ((Object[]) obj)[Integer.valueOf(str).intValue()] = str2;
                return obj;
            } else {
                try {
                    Field field = obj.getClass().getField(str);
                    field.setAccessible(true);
                    field.set(str, str2);
                    return obj;
                } catch (Exception e2) {
                    Log.e(e2);
                    return obj;
                }
            }
        }
        return invokeLLL.objValue;
    }

    public Object dynamicCallMethod(Object obj, Object[] objArr, String str, DynamicCallbak dynamicCallbak, Class<?>... clsArr) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048576, this, obj, objArr, str, dynamicCallbak, clsArr)) == null) {
            SapiUtils.notNull(dynamicCallbak, "DynamicCallbak can't be null");
            SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
            if (currentAccount == null) {
                dynamicCallbak.onFailure(-1001, "未登录");
                return null;
            } else if (obj != null && !TextUtils.isEmpty(str) && clsArr != null) {
                Object[] buildParams = buildParams(objArr, currentAccount);
                boolean z = obj instanceof Class;
                Class<?> cls = z ? (Class) obj : obj.getClass();
                if (z) {
                    obj = null;
                }
                try {
                    return cls.getDeclaredMethod(str, clsArr).invoke(obj, buildParams);
                } catch (Exception e2) {
                    Log.e(e2);
                    dynamicCallbak.onFailure(-1002, DynamicCallbak.ERROR_MSG_NOT_FIND_CALL_METHOD);
                    return null;
                }
            } else {
                dynamicCallbak.onFailure(-1003, DynamicCallbak.ERROR_MSG_PARAMS_ERROR);
                return null;
            }
        }
        return invokeLLLLL.objValue;
    }
}

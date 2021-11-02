package com.baidu.mobads.container.util.oaid;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.container.dex.SkyReflectionUtil;
import com.baidu.mobads.container.download.activate.XSharedPreferences;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobads.container.util.SDKLogTypeConstants;
import com.baidu.mobads.container.util.SendLogUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
/* loaded from: classes7.dex */
public class UniqueIdUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String SPFILE_NAME = "mobads_uniqueidentifier";
    public static final String SPKEY_OAID = "oaid";
    public static final String SPKEY_OAID_VALID_PERIOD = "oaid_period";
    public static final String SPVAL_OAID_EMPTY = "";
    public static final long SPVAL_OAID_PERIOD = 604800000;
    public static final long SPVAL_RETRY_OAID_PERIOD = 86400000;
    public static Context mContext = null;
    public static String mMdidSdkHelper = "com.bun.miitmdid.core.MdidSdkHelper";
    public static String mMdidSdkListener = "com.bun.supplier.IIdentifierListener";
    public static String mMdidSdkMethodInit = "InitSdk";
    public static String mMdidSdkMethodOnSupport = "OnSupport";
    public static String mMdidSdkSupplier = "com.bun.supplier.IdSupplier";
    public static String mNewMdidSdkListener = "com.bun.miitmdid.interfaces.IIdentifierListener";
    public static String mNewMdidSdkSupplier = "com.bun.miitmdid.interfaces.IdSupplier";
    public static long mPeriod = 0;
    public static long mRetryCount = 0;
    public static XSharedPreferences mSPOAID = null;
    public static String miitOAID = "";
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class InvocationHandlerImp implements InvocationHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String mClassName;
        public String mMethodName;

        public InvocationHandlerImp(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mClassName = str;
            this.mMethodName = str2;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, obj, method, objArr)) == null) {
                try {
                    String name = method.getName();
                    if (!TextUtils.isEmpty(name) && name.equals(this.mMethodName)) {
                        Object obj2 = objArr[1];
                        Class<?> cls = Class.forName(this.mClassName);
                        if (obj2 != null && cls != null) {
                            String str = (String) SkyReflectionUtil.invoke(cls, obj2, "getOAID", new Class[0], new Object[0]);
                            if (TextUtils.isEmpty(str)) {
                                UniqueIdUtils.sendSDKTypeLog(UniqueIdUtils.mContext, "msa-empty", "");
                            } else {
                                UniqueIdUtils.miitOAID = str;
                                UniqueIdUtils.sendSDKTypeLog(UniqueIdUtils.mContext, "msa-vaild", str);
                                UniqueIdUtils.update(604800000L, str);
                            }
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    Context context = UniqueIdUtils.mContext;
                    UniqueIdUtils.sendSDKTypeLog(context, "msa-error2" + th.getMessage(), "");
                    return null;
                }
            }
            return invokeLLL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1040367434, "Lcom/baidu/mobads/container/util/oaid/UniqueIdUtils;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1040367434, "Lcom/baidu/mobads/container/util/oaid/UniqueIdUtils;");
        }
    }

    public UniqueIdUtils() {
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

    public static void brandOAID(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, context) == null) {
            if (MiOAID.isXiaomiBrand()) {
                update(604800000L, MiOAID.getMIOAID(context.getApplicationContext()));
            }
            if (HuaWeiOAID.isHuaweiBrand()) {
                HuaWeiOAID.hwBindService(context.getApplicationContext());
            }
            if (OppoOAID.isOppoBrand()) {
                OppoOAID.getOppoOaid(context);
            }
            if (VivoOAID.isVivoBrand()) {
                VivoOAID.getVivoOaid(context);
            }
        }
    }

    public static boolean checkMdidSdk() {
        Class cls;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            try {
                cls = SkyReflectionUtil.getClassForName(mMdidSdkHelper);
            } catch (Throwable unused) {
                cls = null;
            }
            return cls != null;
        }
        return invokeV.booleanValue;
    }

    public static String getMiidOAID(Context context) throws UnsupportedEncodingException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) {
            if (Build.VERSION.SDK_INT >= 26 && context != null) {
                try {
                    if (mSPOAID == null) {
                        mSPOAID = new XSharedPreferences(context.getApplicationContext(), SPFILE_NAME);
                    }
                    if (0 == mPeriod) {
                        mPeriod = mSPOAID.getLongValue(SPKEY_OAID_VALID_PERIOD).longValue();
                    }
                    if (System.currentTimeMillis() > mPeriod) {
                        getOAIDs(context);
                    }
                    if (TextUtils.isEmpty(miitOAID)) {
                        miitOAID = mSPOAID.getValue("oaid");
                    }
                    if (TextUtils.equals("invalid", miitOAID)) {
                        miitOAID = "";
                    }
                    return miitOAID;
                } catch (Throwable unused) {
                    return "";
                }
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static void getOAIDs(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context) == null) {
            try {
                if (mRetryCount >= 2) {
                    update(86400000L, "");
                    return;
                }
                if (checkMdidSdk() && mRetryCount == 0) {
                    initMdidSdk(context.getApplicationContext());
                } else {
                    brandOAID(context);
                }
                mRetryCount++;
            } catch (Throwable unused) {
            }
        }
    }

    public static void initMdidSdk(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, context) == null) {
            sendSDKTypeLog(context, "msa-start", "");
            if (context == null) {
                return;
            }
            mContext = context;
            try {
                Class classForName = SkyReflectionUtil.getClassForName(mNewMdidSdkListener);
                if (classForName != null) {
                    Object proxyInstance = SkyReflectionUtil.getProxyInstance(mNewMdidSdkListener, new InvocationHandlerImp(mNewMdidSdkSupplier, mMdidSdkMethodOnSupport));
                    if (proxyInstance != null) {
                        SkyReflectionUtil.invokeMethod(mMdidSdkHelper, null, mMdidSdkMethodInit, new Class[]{Context.class, Boolean.TYPE, classForName}, context, Boolean.TRUE, proxyInstance);
                    }
                } else {
                    Class classForName2 = SkyReflectionUtil.getClassForName(mMdidSdkListener);
                    Object proxyInstance2 = SkyReflectionUtil.getProxyInstance(mMdidSdkListener, new InvocationHandlerImp(mMdidSdkSupplier, mMdidSdkMethodOnSupport));
                    if (proxyInstance2 != null) {
                        SkyReflectionUtil.invokeMethod(mMdidSdkHelper, null, mMdidSdkMethodInit, new Class[]{Context.class, Boolean.TYPE, classForName2}, context, Boolean.TRUE, proxyInstance2);
                    }
                }
            } catch (Throwable th) {
                sendSDKTypeLog(context, "msa-error" + th.getMessage(), "");
            }
        }
    }

    public static void sendSDKTypeLog(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65544, null, context, str, str2) == null) || str == null) {
            return;
        }
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            SendLogUtil.Builder.create(context).appendType(SDKLogTypeConstants.TYPE_OAID_STATUS).append("msg", str).append(IAdRequestParam.MSA, checkMdidSdk()).append("uid", str2).send();
        } catch (Throwable unused) {
        }
    }

    public static void update(long j, String str) {
        XSharedPreferences xSharedPreferences;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJL(65545, null, j, str) == null) || (xSharedPreferences = mSPOAID) == null) {
            return;
        }
        String value = xSharedPreferences.getValue("oaid");
        if ((TextUtils.isEmpty(str) || TextUtils.equals("invalid", str)) && !TextUtils.isEmpty(value) && !TextUtils.equals("invalid", value)) {
            str = value;
        }
        mSPOAID.putString("oaid", str);
        long currentTimeMillis = System.currentTimeMillis() + j;
        mSPOAID.putLong(SPKEY_OAID_VALID_PERIOD, Long.valueOf(currentTimeMillis));
        mPeriod = currentTimeMillis;
        miitOAID = str;
        mRetryCount = 0L;
    }
}

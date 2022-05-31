package com.baidu.sofire.core;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sofire.BaiduLog;
import com.baidu.sofire.MyProvider;
import com.baidu.sofire.MyService;
import com.baidu.sofire.ac.BDModuleLoadCallback;
import com.baidu.sofire.ac.Callback;
import com.baidu.sofire.ac.F;
import com.baidu.sofire.ac.U;
import com.baidu.sofire.mutiprocess.SubProcessManager;
import com.baidu.sofire.rp.service.Service;
import com.baidu.sofire.sharedpreferences.SharedPreferenceManager;
import com.baidu.sofire.utility.CommonMethods;
import com.baidu.sofire.utility.DbUtil;
import com.baidu.sofire.utility.DoubleListUtil;
import com.baidu.sofire.utility.LocalConstant;
import com.baidu.sofire.utility.PrivacyOperationUtil;
import com.baidu.sofire.utility.PrivacyPolicyUtil;
import com.baidu.sofire.utility.ProviderAccessUtil;
import com.baidu.sofire.utility.ThreadPoolManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import com.yy.gslbsdk.db.DelayTB;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class MethodImpl {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PROVIDER_RESULT_STATUS = "status";
    public static String SGZ = "";
    public static long mLastCallAddModuleCallbackTime;
    public static boolean sAlreadyNotifyAgreePolicy;
    public static int[] sHostCareKeys;
    public static boolean sInitBlockedByPolicy;
    public static boolean sInitCalled;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-224054727, "Lcom/baidu/sofire/core/MethodImpl;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-224054727, "Lcom/baidu/sofire/core/MethodImpl;");
        }
    }

    public MethodImpl() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void addModuleCallback(Context context, int i, BDModuleLoadCallback bDModuleLoadCallback, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{context, Integer.valueOf(i), bDModuleLoadCallback, Boolean.valueOf(z)}) == null) || i <= 0 || bDModuleLoadCallback == null) {
            return;
        }
        if (CommonMethods.isInitSuc(i)) {
            bDModuleLoadCallback.onSuccess(i);
        }
        if (System.currentTimeMillis() - mLastCallAddModuleCallbackTime < 10000) {
            bDModuleLoadCallback.onFailure(i, 8);
            return;
        }
        mLastCallAddModuleCallbackTime = System.currentTimeMillis();
        if (CommonMethods.isMainProcess(context.getApplicationContext()) == 1) {
            if (!PrivacyPolicyUtil.check(context.getApplicationContext())) {
                bDModuleLoadCallback.onFailure(i, 10);
                return;
            }
            U.addCallback(i, bDModuleLoadCallback);
            if (!z || U.sIsRunning) {
                return;
            }
            ThreadPoolManager.getInstance(context).executeCore(new U(context.getApplicationContext(), 7, true));
            return;
        }
        bDModuleLoadCallback.onFailure(i, 9);
    }

    public static void bc(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(65543, null, context, z) == null) && context != null && PrivacyPolicyUtil.check(context)) {
            SharedPreferenceManager.getInstance(context).setCanConn(z);
        }
    }

    public static boolean call(int i, String str, Callback callback, Class<?>[] clsArr, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{Integer.valueOf(i), str, callback, clsArr, objArr})) == null) {
            try {
                return ThreadPoolManager.getInstance(ForHostApp.hostContext).execute(new Runnable(callback, i, str, clsArr, objArr) { // from class: com.baidu.sofire.core.MethodImpl.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Object[] val$args;
                    public final /* synthetic */ Class[] val$clss;
                    public final /* synthetic */ int val$key;
                    public final /* synthetic */ String val$methodName;
                    public final /* synthetic */ Callback val$retCallback;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr2 = {callback, Integer.valueOf(i), str, clsArr, objArr};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$retCallback = callback;
                        this.val$key = i;
                        this.val$methodName = str;
                        this.val$clss = clsArr;
                        this.val$args = objArr;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            try {
                                Context context = ForHostApp.hostContext;
                                if (context == null) {
                                    for (int i2 = 0; i2 < 20; i2++) {
                                        try {
                                            Thread.sleep(50L);
                                        } catch (InterruptedException e) {
                                            CommonMethods.handleNuLException(e);
                                        }
                                        context = ForHostApp.hostContext;
                                        if (context != null) {
                                            break;
                                        }
                                    }
                                    if (context == null) {
                                        if (this.val$retCallback != null) {
                                            this.val$retCallback.onError(4);
                                            return;
                                        }
                                        return;
                                    }
                                }
                            } catch (Throwable th) {
                                CommonMethods.handleNuLException(th);
                            }
                            if (!PrivacyPolicyUtil.check(ForHostApp.hostContext)) {
                                this.val$retCallback.onError(12);
                            } else if (!CommonMethods.checkComponentStatus(ForHostApp.hostContext, false)) {
                                if (this.val$retCallback != null) {
                                    this.val$retCallback.onError(11);
                                }
                            } else {
                                String providerProcessName = CommonMethods.getProviderProcessName(ForHostApp.hostContext);
                                if (TextUtils.isEmpty(providerProcessName)) {
                                    if (CommonMethods.isRemoteCompareToCurrentProc(ForHostApp.hostContext.getPackageName())) {
                                        if (this.val$retCallback != null) {
                                            this.val$retCallback.onError(5);
                                            return;
                                        }
                                        return;
                                    }
                                    ForHostApp peekInstance = ForHostApp.peekInstance();
                                    if (peekInstance == null) {
                                        for (int i3 = 0; i3 < 20; i3++) {
                                            try {
                                                Thread.sleep(50L);
                                            } catch (InterruptedException e2) {
                                                CommonMethods.handleNuLException(e2);
                                            }
                                            peekInstance = ForHostApp.peekInstance();
                                            if (peekInstance != null) {
                                                break;
                                            }
                                        }
                                        if (peekInstance == null) {
                                            if (this.val$retCallback != null) {
                                                this.val$retCallback.onError(11);
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                    peekInstance.execEngineImpl(this.val$key, this.val$methodName, this.val$retCallback, this.val$clss, this.val$args);
                                    return;
                                } else if (CommonMethods.isRemoteCompareToCurrentProc(providerProcessName)) {
                                    MethodImpl.callRemoteMethod(ForHostApp.hostContext, this.val$key, this.val$methodName, this.val$retCallback, this.val$clss, this.val$args);
                                    return;
                                } else {
                                    ForHostApp peekInstance2 = ForHostApp.peekInstance();
                                    if (peekInstance2 == null) {
                                        for (int i4 = 0; i4 < 20; i4++) {
                                            try {
                                                Thread.sleep(50L);
                                            } catch (InterruptedException e3) {
                                                CommonMethods.handleNuLException(e3);
                                            }
                                            peekInstance2 = ForHostApp.peekInstance();
                                            if (peekInstance2 != null) {
                                                break;
                                            }
                                        }
                                        if (peekInstance2 == null) {
                                            if (this.val$retCallback != null) {
                                                this.val$retCallback.onError(11);
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                    peekInstance2.execEngineImpl(this.val$key, this.val$methodName, this.val$retCallback, this.val$clss, this.val$args);
                                    return;
                                }
                                CommonMethods.handleNuLException(th);
                            }
                        }
                    }
                }) == 1;
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    public static void callRemoteMethod(Context context, int i, String str, Callback callback, Class<?>[] clsArr, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{context, Integer.valueOf(i), str, callback, clsArr, objArr}) == null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    ThreadPoolManager.getInstance(context).execute(new Runnable(callback, context, i, str, clsArr, objArr) { // from class: com.baidu.sofire.core.MethodImpl.5
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ Object[] val$args;
                        public final /* synthetic */ Class[] val$clss;
                        public final /* synthetic */ Context val$context;
                        public final /* synthetic */ int val$key;
                        public final /* synthetic */ String val$method;
                        public final /* synthetic */ Callback val$retCallback;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr2 = {callback, context, Integer.valueOf(i), str, clsArr, objArr};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.val$retCallback = callback;
                            this.val$context = context;
                            this.val$key = i;
                            this.val$method = str;
                            this.val$clss = clsArr;
                            this.val$args = objArr;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                Callback callback2 = this.val$retCallback;
                                if (callback2 != null) {
                                    callback2.onBegin(new Object[0]);
                                }
                                Pair callRemoteMethodImpl = MethodImpl.callRemoteMethodImpl(this.val$context, this.val$key, 0, this.val$method, this.val$clss, this.val$args);
                                if (this.val$retCallback != null) {
                                    if (((Integer) callRemoteMethodImpl.first).intValue() != 0) {
                                        this.val$retCallback.onError(callRemoteMethodImpl.first);
                                    } else {
                                        this.val$retCallback.onEnd(callRemoteMethodImpl.second);
                                    }
                                }
                            }
                        }
                    });
                } else if (callback != null) {
                    callback.onError(1);
                }
            } catch (Throwable th) {
                if (callback != null) {
                    try {
                        callback.onError(3);
                    } catch (Throwable unused) {
                    }
                }
                CommonMethods.handleNuLException(th);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003a A[Catch: all -> 0x00ba, TryCatch #0 {all -> 0x00ba, blocks: (B:17:0x002d, B:19:0x003a, B:20:0x003d, B:22:0x0040, B:24:0x0048, B:26:0x0054, B:28:0x0070, B:27:0x0068, B:29:0x0073, B:30:0x0075, B:32:0x0087, B:34:0x0090, B:36:0x00a1, B:38:0x00ab, B:42:0x00b5, B:41:0x00b3), top: B:55:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0087 A[Catch: all -> 0x00ba, TryCatch #0 {all -> 0x00ba, blocks: (B:17:0x002d, B:19:0x003a, B:20:0x003d, B:22:0x0040, B:24:0x0048, B:26:0x0054, B:28:0x0070, B:27:0x0068, B:29:0x0073, B:30:0x0075, B:32:0x0087, B:34:0x0090, B:36:0x00a1, B:38:0x00ab, B:42:0x00b5, B:41:0x00b3), top: B:55:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0090 A[Catch: all -> 0x00ba, TryCatch #0 {all -> 0x00ba, blocks: (B:17:0x002d, B:19:0x003a, B:20:0x003d, B:22:0x0040, B:24:0x0048, B:26:0x0054, B:28:0x0070, B:27:0x0068, B:29:0x0073, B:30:0x0075, B:32:0x0087, B:34:0x0090, B:36:0x00a1, B:38:0x00ab, B:42:0x00b5, B:41:0x00b3), top: B:55:0x002d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Pair<Integer, Object> callRemoteMethodImpl(Context context, int i, int i2, String str, Class<?>[] clsArr, Object... objArr) {
        InterceptResult invokeCommon;
        String str2;
        Bundle callPrivateProvider;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{context, Integer.valueOf(i), Integer.valueOf(i2), str, clsArr, objArr})) != null) {
            return (Pair) invokeCommon.objValue;
        }
        int i3 = 0;
        try {
            int i4 = 1;
            if (TextUtils.isEmpty(str)) {
                return Pair.create(1, null);
            }
            try {
                if (!"gzfi".equals(str) && !"gz".equals(str)) {
                    str2 = "invokeMethod";
                    i4 = 0;
                    CallArgs callArgs = new CallArgs();
                    callArgs.pluginKey = i;
                    callArgs.pluginMethod = str;
                    callArgs.methodSync = i2;
                    if (clsArr != null) {
                        Object[] objArr2 = new Object[clsArr.length];
                        while (i3 < clsArr.length) {
                            if (clsArr[i3].isPrimitive()) {
                                String convertPrimitiveType = CommonMethods.convertPrimitiveType(clsArr[i3]);
                                if (!TextUtils.isEmpty(convertPrimitiveType)) {
                                    objArr2[i3] = convertPrimitiveType + "@@";
                                }
                            } else {
                                objArr2[i3] = clsArr[i3].getName();
                            }
                            i3++;
                        }
                        callArgs.methodClass = objArr2;
                    }
                    callArgs.methodArgs = objArr;
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("args", callArgs);
                    callPrivateProvider = ProviderAccessUtil.callPrivateProvider(context, str2, bundle);
                    if (callPrivateProvider != null) {
                        return Pair.create(3, null);
                    }
                    callPrivateProvider.setClassLoader(CallArgs.class.getClassLoader());
                    int i5 = callPrivateProvider.getInt("status");
                    CallArgs callArgs2 = i5 == 0 ? (CallArgs) callPrivateProvider.getParcelable("result") : null;
                    return Pair.create(Integer.valueOf(i5), callArgs2 == null ? null : callArgs2.result);
                }
                CallArgs callArgs3 = new CallArgs();
                callArgs3.pluginKey = i;
                callArgs3.pluginMethod = str;
                callArgs3.methodSync = i2;
                if (clsArr != null) {
                }
                callArgs3.methodArgs = objArr;
                Bundle bundle2 = new Bundle();
                bundle2.putParcelable("args", callArgs3);
                callPrivateProvider = ProviderAccessUtil.callPrivateProvider(context, str2, bundle2);
                if (callPrivateProvider != null) {
                }
            } catch (Throwable th) {
                th = th;
                i3 = i4;
                if (i3 != 0) {
                    ErrorNote.setExceptionLog(BaiduLog.getStackTraceString(th));
                }
                CommonMethods.handleNuLException(th);
                return Pair.create(3, null);
            }
            str2 = str;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static Pair<Integer, Object> callRemoteMethodSync(Context context, int i, String str, Class<?>[] clsArr, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{context, Integer.valueOf(i), str, clsArr, objArr})) == null) ? callRemoteMethodImpl(context, i, 1, str, clsArr, objArr) : (Pair) invokeCommon.objValue;
    }

    public static Pair<Integer, Object> callSync(int i, String str, Class<?>[] clsArr, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{Integer.valueOf(i), str, clsArr, objArr})) == null) {
            try {
                Context context = ForHostApp.hostContext;
                if (context == null) {
                    return new Pair<>(4, null);
                }
                if (!PrivacyPolicyUtil.check(ForHostApp.hostContext)) {
                    return new Pair<>(12, null);
                }
                if (!CommonMethods.checkComponentStatus(ForHostApp.hostContext, false)) {
                    return new Pair<>(11, null);
                }
                String providerProcessName = CommonMethods.getProviderProcessName(ForHostApp.hostContext);
                if (TextUtils.isEmpty(providerProcessName)) {
                    if (CommonMethods.isRemoteCompareToCurrentProc(ForHostApp.hostContext.getPackageName())) {
                        return new Pair<>(5, null);
                    }
                    return ForHostApp.getInstance(context).execEngineImplSync(i, str, clsArr, objArr);
                } else if (CommonMethods.isRemoteCompareToCurrentProc(providerProcessName)) {
                    return callRemoteMethodSync(ForHostApp.hostContext, i, str, clsArr, objArr);
                } else {
                    return ForHostApp.getInstance(context).execEngineImplSync(i, str, clsArr, objArr);
                }
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                return new Pair<>(3, null);
            }
        }
        return (Pair) invokeCommon.objValue;
    }

    public static Pair<Integer, Object> callSyncOpt(int i, String str, Class<?>[] clsArr, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65549, null, new Object[]{Integer.valueOf(i), str, clsArr, objArr})) == null) {
            try {
                Context context = ForHostApp.hostContext;
                if (context == null) {
                    return new Pair<>(4, null);
                }
                if (!CommonMethods.checkComponentStatus(ForHostApp.hostContext, false)) {
                    return new Pair<>(11, null);
                }
                String providerProcessName = CommonMethods.getProviderProcessName(ForHostApp.hostContext);
                if (TextUtils.isEmpty(providerProcessName)) {
                    if (CommonMethods.isRemoteCompareToCurrentProc(ForHostApp.hostContext.getPackageName())) {
                        return new Pair<>(5, null);
                    }
                    ForHostApp.getInstance(context);
                    return execEngineImplSyncOpt(i, str, clsArr, objArr);
                } else if (CommonMethods.isRemoteCompareToCurrentProc(providerProcessName)) {
                    return callRemoteMethodSync(ForHostApp.hostContext, i, str, clsArr, objArr);
                } else {
                    ForHostApp.getInstance(context);
                    return execEngineImplSyncOpt(i, str, clsArr, objArr);
                }
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                return new Pair<>(3, null);
            }
        }
        return (Pair) invokeCommon.objValue;
    }

    public static Pair<Integer, Object> execEngineImplSyncOpt(int i, String str, Class<?>[] clsArr, Object... objArr) {
        InterceptResult invokeCommon;
        PluginloaderHub peekInstance;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65550, null, new Object[]{Integer.valueOf(i), str, clsArr, objArr})) == null) {
            if (TextUtils.isEmpty(str)) {
                return new Pair<>(1, null);
            }
            try {
                peekInstance = PluginloaderHub.peekInstance();
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
            if (peekInstance == null) {
                return new Pair<>(3, null);
            }
            ApkInfo apkInfoByPackageName = peekInstance.getApkInfoByPackageName("com.baidu.sofire.x0");
            if (apkInfoByPackageName != null) {
                Class<?> loadClassWithoutParentClass = ((PluginloaderDexClassLoader) apkInfoByPackageName.classLoader).loadClassWithoutParentClass(LocalConstant.ENGINE_IMPL_CLASS_FULL_PATH);
                return new Pair<>(0, CommonMethods.callMethodOfClass(loadClassWithoutParentClass.getDeclaredMethod("getInstance", Context.class).invoke(loadClassWithoutParentClass, ForHostApp.hostContext), str, clsArr, objArr));
            }
            return new Pair<>(3, null);
        }
        return (Pair) invokeCommon.objValue;
    }

    public static Pair<Integer, String> gel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? ErrorNote.buildErrorLog() : (Pair) invokeV.objValue;
    }

    public static String gt(Context context, String str, String str2, int i, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65552, null, new Object[]{context, str, str2, Integer.valueOf(i), str3})) == null) {
            if (context != null) {
                try {
                } catch (Throwable th) {
                    CommonMethods.handleNuLException(th);
                }
                if (PrivacyPolicyUtil.check(context)) {
                    if (TextUtils.isEmpty(str)) {
                        return CommonMethods.getDefaultToken(context, 8);
                    }
                    Pair<Integer, Object> callSync = callSync(LocalConstant.X39_ID, "retrieveToken", new Class[]{String.class, String.class, Integer.TYPE, String.class}, str, str2, Integer.valueOf(i), str3);
                    if (((Integer) callSync.first).intValue() == 0) {
                        String str4 = (String) callSync.second;
                        return !TextUtils.isEmpty(str4) ? str4 : CommonMethods.getDefaultToken(context, 9);
                    }
                    if (((Integer) callSync.first).intValue() != 4 && ((Integer) callSync.first).intValue() != 3) {
                        if (((Integer) callSync.first).intValue() == 5 || ((Integer) callSync.first).intValue() == 11) {
                            return CommonMethods.getDefaultToken(context, 7);
                        }
                        return CommonMethods.getDefaultToken(context, 8);
                    }
                    String[] selectAppKeyAndSecurityKey = CommonMethods.selectAppKeyAndSecurityKey(context);
                    initDelay(context, 0, selectAppKeyAndSecurityKey[0], selectAppKeyAndSecurityKey[1], LocalConstant.X39_ID);
                    return CommonMethods.getDefaultToken(context, ((Integer) callSync.first).intValue() == 3 ? 5 : 2);
                }
                return "";
            }
            return "";
        }
        return (String) invokeCommon.objValue;
    }

    public static String gz(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, context)) == null) {
            try {
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
            if (!TextUtils.isEmpty(SGZ)) {
                return SGZ;
            }
            if (context != null && CommonMethods.checkComponentStatus(context, false)) {
                String providerProcessName = CommonMethods.getProviderProcessName(context);
                if (TextUtils.isEmpty(providerProcessName)) {
                    return CommonMethods.isRemoteCompareToCurrentProc(context.getPackageName()) ? "" : gzImpl(context);
                } else if (CommonMethods.isRemoteCompareToCurrentProc(providerProcessName)) {
                    Pair<Integer, Object> callRemoteMethodSync = callRemoteMethodSync(context, 0, "gz", null, new Object[0]);
                    if (callRemoteMethodSync != null) {
                        return ((Integer) callRemoteMethodSync.first).intValue() == 0 ? (String) callRemoteMethodSync.second : "";
                    }
                    SGZ = LocalConstant.DEFAULT_ZID;
                    return LocalConstant.DEFAULT_ZID;
                } else {
                    return gzImpl(context);
                }
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static String gzImpl(Context context) {
        InterceptResult invokeL;
        SharedPreferenceManager sharedPreferenceManager;
        String token;
        byte[] re;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, context)) == null) {
            try {
                sharedPreferenceManager = SharedPreferenceManager.getInstance(context);
                token = sharedPreferenceManager.getToken();
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
            if (!TextUtils.isEmpty(token)) {
                SGZ = token;
                return token;
            }
            String myToken = sharedPreferenceManager.getMyToken();
            if (!TextUtils.isEmpty(myToken)) {
                SGZ = myToken;
                return myToken;
            }
            String cuid = DbUtil.getCUID(context);
            if (!TextUtils.isEmpty(cuid)) {
                String[] split = cuid.split(WebChromeClient.PARAM_SEPARATOR);
                if (split != null && split.length == 2 && !TextUtils.isEmpty(split[0]) && !TextUtils.isEmpty(split[1])) {
                    if (F.getInstance().re(split[1].getBytes(), split[0].getBytes()) != null) {
                        String str = split[0] + CommonMethods.hexEncodeString(re);
                        sharedPreferenceManager.setMyToken(str);
                        SGZ = str;
                        return str;
                    }
                }
                SGZ = LocalConstant.DEFAULT_ZID;
                return LocalConstant.DEFAULT_ZID;
            }
            SGZ = LocalConstant.DEFAULT_ZID;
            return LocalConstant.DEFAULT_ZID;
        }
        return (String) invokeL.objValue;
    }

    public static String gzfi(Context context, String str, int i, String str2) {
        InterceptResult invokeLLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(65555, null, context, str, i, str2)) == null) {
            try {
            } catch (Throwable th) {
                ErrorNote.setExceptionLog(BaiduLog.getStackTraceString(th));
                CommonMethods.handleNuLException(th);
            }
            if (context == null) {
                ErrorNote.setErrorCode(1001);
                return "";
            } else if (!TextUtils.isEmpty(SGZ)) {
                if (i != 0 && PrivacyPolicyUtil.check(context)) {
                    if (TextUtils.isEmpty(str2)) {
                        call(1, "ice", null, new Class[]{String.class, Integer.TYPE}, str, Integer.valueOf(i));
                    } else {
                        call(1, "ice", null, new Class[]{String.class, Integer.TYPE, String.class}, str, Integer.valueOf(i), str2);
                    }
                }
                return SGZ;
            } else if (!CommonMethods.checkComponentStatus(context, false)) {
                ErrorNote.setErrorCode(1002);
                ErrorNote.setErrorLog(CommonMethods.buildComponentErrorLog());
                return "";
            } else {
                String providerProcessName = CommonMethods.getProviderProcessName(context);
                if (TextUtils.isEmpty(providerProcessName)) {
                    if (CommonMethods.isRemoteCompareToCurrentProc(context.getPackageName())) {
                        ErrorNote.setErrorCode(1003);
                        ErrorNote.setErrorLog(CommonMethods.buildComponentErrorLog());
                        return "";
                    }
                    return gzfiImpl(context, str, i, str2);
                } else if (CommonMethods.isRemoteCompareToCurrentProc(providerProcessName)) {
                    Pair<Integer, Object> callRemoteMethodSync = callRemoteMethodSync(context, 0, "gzfi", null, str, Integer.valueOf(i), str2);
                    if (callRemoteMethodSync != null) {
                        if (((Integer) callRemoteMethodSync.first).intValue() == 0) {
                            return (String) callRemoteMethodSync.second;
                        }
                        ErrorNote.setErrorCode(1004);
                        ErrorNote.createErrorLog(((Integer) callRemoteMethodSync.first).intValue());
                        return "";
                    }
                    ErrorNote.setErrorCode(1004);
                    ErrorNote.createErrorLog(-1001);
                    ErrorNote.setErrorCode(1005);
                    ErrorNote.createErrorLog(-1002);
                    return "";
                } else {
                    return gzfiImpl(context, str, i, str2);
                }
            }
        }
        return (String) invokeLLIL.objValue;
    }

    public static String gzfiImpl(Context context, String str, int i, String str2) {
        InterceptResult invokeLLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(65556, null, context, str, i, str2)) == null) {
            if (context == null) {
                return "";
            }
            if (i != 0) {
                if (TextUtils.isEmpty(str2) && PrivacyPolicyUtil.check(context)) {
                    call(1, "ice", null, new Class[]{String.class, Integer.TYPE}, str, Integer.valueOf(i));
                } else {
                    call(1, "ice", null, new Class[]{String.class, Integer.TYPE, String.class}, str, Integer.valueOf(i), str2);
                }
            }
            return gzImpl(context);
        }
        return (String) invokeLLIL.objValue;
    }

    public static synchronized void initDelay(Context context, int i, String str, String str2, int... iArr) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65558, null, new Object[]{context, Integer.valueOf(i), str, str2, iArr}) == null) {
            synchronized (MethodImpl.class) {
                if (iArr != null) {
                    try {
                        if (iArr.length > 1) {
                            sHostCareKeys = iArr;
                            i2 = 0;
                            initDelay(context, i, str, str2, null, i2);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (iArr != null && iArr.length == 1) {
                    i2 = iArr[0];
                    initDelay(context, i, str, str2, null, i2);
                }
                i2 = 0;
                initDelay(context, i, str, str2, null, i2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007b A[Catch: all -> 0x0098, TryCatch #2 {all -> 0x0186, blocks: (B:5:0x000f, B:8:0x0025, B:10:0x002a, B:31:0x00a0, B:33:0x00aa, B:35:0x00af, B:72:0x015b, B:74:0x0163, B:76:0x0170, B:77:0x0174, B:79:0x0182, B:11:0x002f, B:13:0x0040, B:15:0x0045, B:23:0x007f, B:25:0x008b, B:26:0x008f, B:22:0x007b, B:16:0x0057, B:18:0x005c, B:36:0x00b4, B:38:0x00cd, B:39:0x00d0, B:41:0x00d3, B:43:0x00dd, B:45:0x00e5, B:47:0x00eb, B:49:0x00f8, B:48:0x00ee, B:50:0x00fb, B:53:0x0101, B:55:0x010a, B:57:0x0113, B:59:0x0128, B:67:0x014c, B:56:0x010f, B:61:0x012f, B:63:0x013f), top: B:89:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x008b A[Catch: all -> 0x0098, TryCatch #2 {all -> 0x0186, blocks: (B:5:0x000f, B:8:0x0025, B:10:0x002a, B:31:0x00a0, B:33:0x00aa, B:35:0x00af, B:72:0x015b, B:74:0x0163, B:76:0x0170, B:77:0x0174, B:79:0x0182, B:11:0x002f, B:13:0x0040, B:15:0x0045, B:23:0x007f, B:25:0x008b, B:26:0x008f, B:22:0x007b, B:16:0x0057, B:18:0x005c, B:36:0x00b4, B:38:0x00cd, B:39:0x00d0, B:41:0x00d3, B:43:0x00dd, B:45:0x00e5, B:47:0x00eb, B:49:0x00f8, B:48:0x00ee, B:50:0x00fb, B:53:0x0101, B:55:0x010a, B:57:0x0113, B:59:0x0128, B:67:0x014c, B:56:0x010f, B:61:0x012f, B:63:0x013f), top: B:89:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008f A[Catch: all -> 0x0098, TRY_LEAVE, TryCatch #2 {all -> 0x0186, blocks: (B:5:0x000f, B:8:0x0025, B:10:0x002a, B:31:0x00a0, B:33:0x00aa, B:35:0x00af, B:72:0x015b, B:74:0x0163, B:76:0x0170, B:77:0x0174, B:79:0x0182, B:11:0x002f, B:13:0x0040, B:15:0x0045, B:23:0x007f, B:25:0x008b, B:26:0x008f, B:22:0x007b, B:16:0x0057, B:18:0x005c, B:36:0x00b4, B:38:0x00cd, B:39:0x00d0, B:41:0x00d3, B:43:0x00dd, B:45:0x00e5, B:47:0x00eb, B:49:0x00f8, B:48:0x00ee, B:50:0x00fb, B:53:0x0101, B:55:0x010a, B:57:0x0113, B:59:0x0128, B:67:0x014c, B:56:0x010f, B:61:0x012f, B:63:0x013f), top: B:89:0x000f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bundle ppcall(Context context, String str, String str2, Bundle bundle) {
        InterceptResult invokeLLLL;
        Pair<Integer, Object> callSync;
        Integer num;
        String str3;
        String gzfiImpl;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65559, null, context, str, str2, bundle)) == null) {
            Bundle bundle2 = new Bundle();
            try {
                Class[] clsArr = null;
                String str4 = null;
                if ("gzfi".equals(str)) {
                    bundle2.putBoolean(MyProvider.BUNDLE_KEY_HANDLE_FLAG, true);
                    if (bundle != null) {
                        CallArgs callArgs = new CallArgs();
                        bundle.setClassLoader(MyProvider.class.getClassLoader());
                        CallArgs callArgs2 = (CallArgs) bundle.getParcelable("args");
                        if (callArgs2 != null) {
                            if (callArgs2.methodArgs.length == 2) {
                                num = (Integer) callArgs2.methodArgs[1];
                                str4 = (String) callArgs2.methodArgs[0];
                                str3 = null;
                            } else if (callArgs2.methodArgs.length == 3) {
                                str4 = (String) callArgs2.methodArgs[0];
                                Integer num2 = (Integer) callArgs2.methodArgs[1];
                                str3 = (String) callArgs2.methodArgs[2];
                                num = num2;
                            }
                            gzfiImpl = gzfiImpl(context, str4, num != null ? 0 : num.intValue(), str3);
                            if (!TextUtils.isEmpty(gzfiImpl)) {
                                bundle2.putInt("status", 8);
                            } else {
                                callArgs.result = gzfiImpl;
                                bundle2.putParcelable("result", callArgs);
                                bundle2.putInt("status", 0);
                            }
                            return bundle2;
                        }
                        num = null;
                        str3 = null;
                        gzfiImpl = gzfiImpl(context, str4, num != null ? 0 : num.intValue(), str3);
                        if (!TextUtils.isEmpty(gzfiImpl)) {
                        }
                        return bundle2;
                    }
                } else if ("invokeMethod".equals(str)) {
                    bundle2.putBoolean(MyProvider.BUNDLE_KEY_HANDLE_FLAG, true);
                    if (bundle != null) {
                        CallArgs callArgs3 = new CallArgs();
                        bundle.setClassLoader(MyProvider.class.getClassLoader());
                        CallArgs callArgs4 = (CallArgs) bundle.getParcelable("args");
                        int i = callArgs4.pluginKey;
                        int i2 = callArgs4.methodSync;
                        String str5 = callArgs4.pluginMethod;
                        Object[] objArr = callArgs4.methodClass;
                        if (objArr != null) {
                            clsArr = new Class[objArr.length];
                            for (int i3 = 0; i3 < objArr.length; i3++) {
                                String str6 = (String) objArr[i3];
                                if (!TextUtils.isEmpty(str6) && str6.contains("@@")) {
                                    Class<?> convertBackPrimitiveType = CommonMethods.convertBackPrimitiveType(str6);
                                    if (convertBackPrimitiveType != null) {
                                        clsArr[i3] = convertBackPrimitiveType;
                                    }
                                } else {
                                    clsArr[i3] = Class.forName((String) objArr[i3]);
                                }
                            }
                        }
                        Object[] objArr2 = callArgs4.methodArgs;
                        if (i2 == 1) {
                            if (i == 1 && "xgz".equals(str5)) {
                                callSync = execEngineImplSyncOpt(i, str5, clsArr, objArr2);
                            } else {
                                callSync = callSync(i, str5, clsArr, objArr2);
                            }
                            bundle2.putInt("status", ((Integer) callSync.first).intValue());
                            if (((Integer) callSync.first).intValue() == 0) {
                                callArgs3.result = callSync.second;
                            }
                        } else if (i2 == 0) {
                            CountDownLatch countDownLatch = new CountDownLatch(1);
                            call(i, str5, new Callback(bundle2, callArgs3, countDownLatch, str5) { // from class: com.baidu.sofire.core.MethodImpl.4
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ Bundle val$bundle;
                                public final /* synthetic */ CountDownLatch val$latch;
                                public final /* synthetic */ String val$pluginMethod;
                                public final /* synthetic */ CallArgs val$reArgs;

                                {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr3 = {bundle2, callArgs3, countDownLatch, str5};
                                        interceptable2.invokeUnInit(65536, newInitContext);
                                        int i4 = newInitContext.flag;
                                        if ((i4 & 1) != 0) {
                                            int i5 = i4 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable2.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.val$bundle = bundle2;
                                    this.val$reArgs = callArgs3;
                                    this.val$latch = countDownLatch;
                                    this.val$pluginMethod = str5;
                                }

                                /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[IGET, INVOKE, MOVE_EXCEPTION, INVOKE, IGET, INVOKE, MOVE_EXCEPTION] complete} */
                                @Override // com.baidu.sofire.ac.Callback
                                public final Object onEnd(Object... objArr3) {
                                    InterceptResult invokeL;
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, objArr3)) == null) {
                                        try {
                                            this.val$bundle.putInt("status", 0);
                                            this.val$reArgs.result = objArr3[0];
                                        } finally {
                                            try {
                                                this.val$latch.countDown();
                                                return null;
                                            } catch (Throwable th) {
                                            }
                                        }
                                        this.val$latch.countDown();
                                        return null;
                                    }
                                    return invokeL.objValue;
                                }

                                /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[IGET, INVOKE, MOVE_EXCEPTION, INVOKE, IGET, INVOKE, MOVE_EXCEPTION] complete} */
                                @Override // com.baidu.sofire.ac.Callback
                                public final Object onError(Object... objArr3) {
                                    InterceptResult invokeL;
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, objArr3)) == null) {
                                        try {
                                            this.val$bundle.putInt("status", ((Integer) objArr3[0]).intValue());
                                        } finally {
                                            try {
                                                this.val$latch.countDown();
                                                return null;
                                            } catch (Throwable th) {
                                            }
                                        }
                                        this.val$latch.countDown();
                                        return null;
                                    }
                                    return invokeL.objValue;
                                }
                            }, clsArr, objArr2);
                            countDownLatch.await(Service.TRIGGER_INTERVAL, TimeUnit.MILLISECONDS);
                        }
                        bundle2.putParcelable("result", callArgs3);
                        return bundle2;
                    }
                } else if ("gz".equals(str)) {
                    bundle2.putBoolean(MyProvider.BUNDLE_KEY_HANDLE_FLAG, true);
                    String gzImpl = gzImpl(context);
                    if (TextUtils.isEmpty(gzImpl)) {
                        bundle2.putInt("status", 8);
                    } else {
                        CallArgs callArgs5 = new CallArgs();
                        callArgs5.result = gzImpl;
                        bundle2.putParcelable("result", callArgs5);
                        bundle2.putInt("status", 0);
                    }
                    return bundle2;
                } else {
                    bundle2.putInt("status", 2);
                    return bundle2;
                }
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
            bundle2.putInt("status", 10);
            return bundle2;
        }
        return (Bundle) invokeLLLL.objValue;
    }

    public static synchronized void resumeInit(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, null, context) == null) {
            synchronized (MethodImpl.class) {
                if (context == null) {
                    return;
                }
                try {
                    if (sInitBlockedByPolicy) {
                        sInitBlockedByPolicy = false;
                        ThreadPoolManager.getInstance(context).executeCore(new Runnable(context) { // from class: com.baidu.sofire.core.MethodImpl.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ Context val$context;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {context};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.val$context = context;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    try {
                                        ForHostApp forHostApp = ForHostApp.getInstance(this.val$context);
                                        if (forHostApp != null) {
                                            ForHostApp.setInitStatus(1);
                                            forHostApp.init();
                                        }
                                    } catch (Throwable th) {
                                        CommonMethods.handleNuLException(th);
                                    }
                                }
                            }
                        });
                    }
                } catch (Throwable th) {
                    CommonMethods.handleNuLException(th);
                }
            }
        }
    }

    public static synchronized void setAgreePolicy(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65561, null, context, z) == null) {
            synchronized (MethodImpl.class) {
                if (context == null) {
                    return;
                }
                try {
                    int isMainProcess = CommonMethods.isMainProcess(context);
                    if (isMainProcess == 0) {
                        Bundle bundle = new Bundle();
                        bundle.putBoolean(MyProvider.BUNDLE_AGREE_POLICY, z);
                        ProviderAccessUtil.callPrivateProvider(context, MyProvider.CALL_METHOD_SET_AGREE_POLICY, bundle);
                        return;
                    }
                    if (isMainProcess == 1) {
                        PrivacyPolicyUtil.agree(context, z);
                        if (z && !sAlreadyNotifyAgreePolicy) {
                            sAlreadyNotifyAgreePolicy = true;
                            resumeInit(context);
                        }
                    }
                } catch (Throwable th) {
                    CommonMethods.handleNuLException(th);
                }
            }
        }
    }

    public static void setDid(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65562, null, context, str) == null) || context == null) {
            return;
        }
        try {
            if (PrivacyPolicyUtil.check(context)) {
                SharedPreferenceManager.getInstance(context).setDid(str);
            }
        } catch (Throwable th) {
            CommonMethods.handleNuLException(th);
        }
    }

    public static String xgz(Context context, String str) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65563, null, context, str)) == null) {
            if (context != null) {
                try {
                } catch (Throwable th) {
                    CommonMethods.handleNuLException(th);
                    i = 501;
                }
                if (PrivacyPolicyUtil.check(context)) {
                    Pair<Integer, Object> callSyncOpt = callSyncOpt(1, "xgz", new Class[]{String.class}, str);
                    if (((Integer) callSyncOpt.first).intValue() == 0 && !TextUtils.isEmpty((String) callSyncOpt.second)) {
                        return (String) callSyncOpt.second;
                    }
                    i = ((Integer) callSyncOpt.first).intValue() == 0 ? 502 : ((Integer) callSyncOpt.first).intValue();
                    try {
                        return new JSONObject().put("rc", i).put("z", gz(context)).toString();
                    } catch (Throwable th2) {
                        CommonMethods.handleNuLException(th2);
                        return "";
                    }
                }
            }
            return "";
        }
        return (String) invokeLL.objValue;
    }

    public static synchronized void initDelay(Context context, int i, String str, String str2, BDModuleLoadCallback bDModuleLoadCallback, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65557, null, new Object[]{context, Integer.valueOf(i), str, str2, bDModuleLoadCallback, Integer.valueOf(i2)}) == null) {
            synchronized (MethodImpl.class) {
                if (context == null) {
                    return;
                }
                try {
                    if (sInitCalled) {
                        return;
                    }
                    sInitCalled = true;
                    ForHostApp.hostContext = context;
                    addModuleCallback(context, i2, bDModuleLoadCallback, false);
                    ThreadPoolManager.getInstance(context).executeCore(new Runnable(context, str, str2, i2, i) { // from class: com.baidu.sofire.core.MethodImpl.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ String val$appKey;
                        public final /* synthetic */ Context val$context;
                        public final /* synthetic */ int val$delaySeconds;
                        public final /* synthetic */ int val$key;
                        public final /* synthetic */ String val$securityKey;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {context, str, str2, Integer.valueOf(i2), Integer.valueOf(i)};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.val$context = context;
                            this.val$appKey = str;
                            this.val$securityKey = str2;
                            this.val$key = i2;
                            this.val$delaySeconds = i;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                CommonMethods.checkDebugRight(this.val$context);
                                try {
                                    PrivacyOperationUtil.loadPolicy(this.val$context);
                                    if (CommonMethods.checkComponentStatus(this.val$context, true)) {
                                        if (CommonMethods.isMainProcess(this.val$context) != 1) {
                                            Intent intent = new Intent("com.baidu.action.SOFIRE.VIEW");
                                            intent.setClass(this.val$context, MyService.class);
                                            intent.setPackage(this.val$context.getPackageName());
                                            intent.addCategory("com.baidu.category.SOFIRE");
                                            intent.addCategory("android.intent.category.DEFAULT");
                                            Bundle bundle = new Bundle();
                                            bundle.putStringArray("appkey", new String[]{this.val$appKey, this.val$securityKey});
                                            bundle.putInt("key", this.val$key);
                                            bundle.putInt(DelayTB.DELAY, this.val$delaySeconds);
                                            intent.putExtra("bundle", bundle);
                                            this.val$context.startService(intent);
                                            SubProcessManager.registerSubProcess(this.val$context);
                                            return;
                                        }
                                        MethodImpl.gz(this.val$context);
                                        ForHostApp forHostApp = ForHostApp.getInstance(this.val$context);
                                        DbUtil.checkCUID(this.val$context);
                                        DbUtil.getCUID(this.val$context);
                                        DoubleListUtil.doubleListReset(this.val$context);
                                        if (!TextUtils.isEmpty(this.val$appKey) && !TextUtils.isEmpty(this.val$securityKey)) {
                                            forHostApp.setSecurityVerifyInfoMark(this.val$appKey, this.val$securityKey);
                                        }
                                        if (this.val$delaySeconds > 0) {
                                            Thread.sleep(this.val$delaySeconds * 1000);
                                        }
                                        SharedPreferenceManager sharedPreferenceManager = SharedPreferenceManager.getInstance(this.val$context);
                                        if (this.val$key <= 0) {
                                            if (MethodImpl.sHostCareKeys != null && MethodImpl.sHostCareKeys.length > 0) {
                                                sharedPreferenceManager.setHostCarePluginKeys(MethodImpl.sHostCareKeys);
                                            }
                                        } else {
                                            sharedPreferenceManager.setHostCarePluginKeys(this.val$key);
                                        }
                                        if (!PrivacyPolicyUtil.check(this.val$context)) {
                                            boolean unused = MethodImpl.sInitBlockedByPolicy = true;
                                            return;
                                        }
                                        ForHostApp.setInitStatus(1);
                                        forHostApp.init();
                                    }
                                } catch (Throwable th) {
                                    CommonMethods.handleNuLException(th);
                                }
                            }
                        }
                    });
                } catch (Throwable th) {
                    CommonMethods.handleNuLException(th);
                }
            }
        }
    }
}

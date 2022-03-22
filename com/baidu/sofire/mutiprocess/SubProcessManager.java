package com.baidu.sofire.mutiprocess;

import android.content.Context;
import android.os.Bundle;
import android.os.Process;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.core.ForHostApp;
import com.baidu.sofire.core.PluginloaderHub;
import com.baidu.sofire.mutiprocess.IMutiProcessHandler;
import com.baidu.sofire.utility.CommonMethods;
import com.baidu.sofire.utility.ProviderAccessUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes4.dex */
public class SubProcessManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BUNDLE_KEY_BINDER_HOLDER = "bundle_key_binder_holder";
    public static final String BUNDLE_KEY_CTRL_ACTION = "bundle_key_ctrl_action";
    public static final String BUNDLE_KEY_ERROR_CODE = "bundle_key_error_code";
    public static final String BUNDLE_KEY_METHOD_NAME = "bundle_key_method_name";
    public static final String BUNDLE_KEY_PID = "bundle_key_pid";
    public static final String BUNDLE_KEY_PLUGIN_PACKAGE_NAME = "bundle_key_plugin_package_name";
    public static final String CALL_METHOD_SUB_PROCESS_PREFIX = "sub_process_";
    public static final int CTRL_ACTION_LOAD_PLUGIN = 1;
    public static final int CTRL_ACTION_UNLOAD_PLUGIN = 2;
    public static final int LOCAL_ERROR_DEFULT = -200;
    public static final int LOCAL_ERROR_ERROR_ARGS = -201;
    public static final int LOCAL_ERROR_REMOTE_EXCEPTION = -203;
    public static final int LOCAL_ERROR_SUB_PROCESS_NULL_CONTEXT = -204;
    public static final int LOCAL_ERROR_UNKNOWN_PID = -202;
    public static final String METHOD_SUFFIX_CALL_MAIN_PLUGIN = "call_main_plugin";
    public static final String METHOD_SUFFIX_REGISTER_SUB_PROCESS = "register_sub_process";
    public static final String PLUGIN_METHOD_NEW_SUB_PROCESS = "notifyNewSubProcess";
    public static final String PLUGIN_STATUS_KEY_STATUS = "status";
    public static final int PLUGIN_STATUS_LOADED = 1;
    public static final int PLUGIN_STATUS_NOT_LOADED = -1;
    public static final int PROVIDER_ERROR_UNSUPPORT_OPERATION = -300;
    public static final int REMOTE_CALL_ERROR_ARGS = -101;
    public static final int REMOTE_CALL_ERROR_CTRL_ACTION_UNDEFINED = -106;
    public static final int REMOTE_CALL_ERROR_DEFAULT = -100;
    public static final int REMOTE_CALL_ERROR_NULL_CONTEXT = -104;
    public static final int REMOTE_CALL_ERROR_NULL_FHA = -105;
    public static final int REMOTE_CALL_ERROR_NULL_PLH = -102;
    public static final int REMOTE_CALL_ERROR_RESULT_NO_BUNDLE = -103;
    public static final int REMOTE_CALL_SUCCESS = 0;
    public static Map<Integer, IMutiProcessHandler> sBinderMap;
    public static IMutiProcessHandler sMutiProcessHandler;
    public static List<String> sNeedNotifyPluginList;
    public static Context sSubProcessContext;
    public static Map<Integer, List<String>> sSubProcessPluginsMap;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1573904439, "Lcom/baidu/sofire/mutiprocess/SubProcessManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1573904439, "Lcom/baidu/sofire/mutiprocess/SubProcessManager;");
                return;
            }
        }
        sBinderMap = new HashMap();
        sSubProcessPluginsMap = new HashMap();
        sNeedNotifyPluginList = new ArrayList();
        sMutiProcessHandler = new IMutiProcessHandler.Stub() { // from class: com.baidu.sofire.mutiprocess.SubProcessManager.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.sofire.mutiprocess.IMutiProcessHandler
            public final Bundle callPlugin(Bundle bundle) throws RemoteException {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, bundle)) == null) ? SubProcessManager.callPluginImpl(bundle) : (Bundle) invokeL.objValue;
            }

            @Override // com.baidu.sofire.mutiprocess.IMutiProcessHandler
            public final Bundle doCtrlAction(Bundle bundle) throws RemoteException {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle)) == null) ? SubProcessManager.handleCtrlAction(bundle) : (Bundle) invokeL.objValue;
            }

            @Override // com.baidu.sofire.mutiprocess.IMutiProcessHandler
            public final Bundle getPluginStatus(String str) throws RemoteException {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? SubProcessManager.subProcessGetPluginStatus(str) : (Bundle) invokeL.objValue;
            }
        };
    }

    public SubProcessManager() {
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

    public static Bundle callPluginImpl(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, bundle)) == null) {
            try {
                String string = bundle.getString(BUNDLE_KEY_METHOD_NAME);
                String string2 = bundle.getString(BUNDLE_KEY_PLUGIN_PACKAGE_NAME);
                if (!TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string)) {
                    PluginloaderHub peekInstance = PluginloaderHub.peekInstance();
                    if (peekInstance == null) {
                        return createBundleWithErrorCode(-102);
                    }
                    ApkInfo apkInfoByPackageName = peekInstance.getApkInfoByPackageName(string2);
                    ForHostApp peekInstance2 = ForHostApp.peekInstance();
                    if (peekInstance2 == null) {
                        return createBundleWithErrorCode(-105);
                    }
                    Pair<Integer, Object> execEngineImplSync = peekInstance2.execEngineImplSync(apkInfoByPackageName.key, string, new Class[]{Bundle.class}, bundle);
                    if (execEngineImplSync == null) {
                        return createBundleWithErrorCode(-100);
                    }
                    if (((Integer) execEngineImplSync.first).intValue() == 0) {
                        if (execEngineImplSync.second instanceof Bundle) {
                            Bundle bundle2 = (Bundle) execEngineImplSync.second;
                            bundle2.putInt(BUNDLE_KEY_ERROR_CODE, 0);
                            return bundle2;
                        }
                        return createBundleWithErrorCode(-103);
                    }
                    return createBundleWithErrorCode(((Integer) execEngineImplSync.first).intValue());
                }
                return createBundleWithErrorCode(-101);
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                try {
                    return createBundleWithErrorCode(-100);
                } catch (Throwable th2) {
                    CommonMethods.handleNuLException(th2);
                    return null;
                }
            }
        }
        return (Bundle) invokeL.objValue;
    }

    public static Bundle createBundleWithErrorCode(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65542, null, i)) == null) {
            Bundle bundle = new Bundle();
            bundle.putInt(BUNDLE_KEY_ERROR_CODE, i);
            return bundle;
        }
        return (Bundle) invokeI.objValue;
    }

    public static Bundle handleCtrlAction(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, bundle)) == null) {
            try {
                int i = bundle.getInt(BUNDLE_KEY_CTRL_ACTION);
                if (i != 1) {
                    if (i != 2) {
                        return createBundleWithErrorCode(-106);
                    }
                    return subProcessUnloadPlugin(bundle);
                }
                return subProcessLoadPlugin(bundle);
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                return null;
            }
        }
        return (Bundle) invokeL.objValue;
    }

    public static Bundle handleProviderWork(String str, String str2, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65544, null, str, str2, bundle)) == null) {
            if (!TextUtils.isEmpty(str) && str.contains(METHOD_SUFFIX_REGISTER_SUB_PROCESS)) {
                return mainProcessRegisterBinder(bundle);
            }
            if (!TextUtils.isEmpty(str) && str.contains(METHOD_SUFFIX_CALL_MAIN_PLUGIN)) {
                return callPluginImpl(bundle);
            }
            return createBundleWithErrorCode(PROVIDER_ERROR_UNSUPPORT_OPERATION);
        }
        return (Bundle) invokeLLL.objValue;
    }

    public static int isMainProcess(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) ? CommonMethods.isMainProcess(context) : invokeL.intValue;
    }

    public static Bundle mainProcessCallGetPluginStatus(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65546, null, i, str)) == null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return createBundleWithErrorCode(-201);
                }
                if (sBinderMap == null) {
                    return createBundleWithErrorCode(-200);
                }
                IMutiProcessHandler iMutiProcessHandler = sBinderMap.get(Integer.valueOf(i));
                if (iMutiProcessHandler == null) {
                    return createBundleWithErrorCode(-202);
                }
                return iMutiProcessHandler.getPluginStatus(str);
            } catch (RemoteException e2) {
                CommonMethods.handleNuLException(e2);
                return createBundleWithErrorCode(-203);
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                return createBundleWithErrorCode(-200);
            }
        }
        return (Bundle) invokeIL.objValue;
    }

    public static Set<Integer> mainProcessGetSubProcessPids() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            try {
                if (sBinderMap == null) {
                    return null;
                }
                return sBinderMap.keySet();
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                return null;
            }
        }
        return (Set) invokeV.objValue;
    }

    public static Bundle mainProcessRegisterBinder(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, bundle)) == null) {
            try {
                bundle.setClassLoader(SubProcessManager.class.getClassLoader());
                int i = bundle.getInt(BUNDLE_KEY_PID);
                BinderHolder binderHolder = (BinderHolder) bundle.getParcelable(BUNDLE_KEY_BINDER_HOLDER);
                if (i > 0 && binderHolder != null && binderHolder.data != null) {
                    sBinderMap.put(Integer.valueOf(i), IMutiProcessHandler.Stub.asInterface(binderHolder.data));
                    if (sNeedNotifyPluginList.size() <= 0) {
                        return createBundleWithErrorCode(0);
                    }
                    ForHostApp peekInstance = ForHostApp.peekInstance();
                    PluginloaderHub peekInstance2 = PluginloaderHub.peekInstance();
                    if (peekInstance != null && peekInstance2 != null) {
                        for (String str : sNeedNotifyPluginList) {
                            ApkInfo apkInfoByPackageName = peekInstance2.getApkInfoByPackageName(str);
                            if (apkInfoByPackageName == null) {
                                return createBundleWithErrorCode(0);
                            }
                            peekInstance.execEngineImplSync(apkInfoByPackageName.key, PLUGIN_METHOD_NEW_SUB_PROCESS, new Class[]{Integer.TYPE}, Integer.valueOf(i));
                        }
                        return createBundleWithErrorCode(0);
                    }
                    return createBundleWithErrorCode(0);
                }
                return createBundleWithErrorCode(-101);
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                return null;
            }
        }
        return (Bundle) invokeL.objValue;
    }

    public static Bundle mainProcessRequestCallPlugin(int i, Bundle bundle) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65549, null, i, bundle)) == null) {
            try {
                if (bundle == null) {
                    return createBundleWithErrorCode(-201);
                }
                if (sBinderMap == null) {
                    return createBundleWithErrorCode(-200);
                }
                IMutiProcessHandler iMutiProcessHandler = sBinderMap.get(Integer.valueOf(i));
                if (iMutiProcessHandler == null) {
                    return createBundleWithErrorCode(-202);
                }
                return iMutiProcessHandler.callPlugin(bundle);
            } catch (RemoteException e2) {
                CommonMethods.handleNuLException(e2);
                return createBundleWithErrorCode(-203);
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                try {
                    return createBundleWithErrorCode(-200);
                } catch (Throwable th2) {
                    CommonMethods.handleNuLException(th2);
                    return null;
                }
            }
        }
        return (Bundle) invokeIL.objValue;
    }

    public static void mainProcessRequestUnloadPlugin(String str) {
        Set<Map.Entry<Integer, List<String>>> entrySet;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, str) == null) {
            try {
                if (sSubProcessPluginsMap == null || (entrySet = sSubProcessPluginsMap.entrySet()) == null) {
                    return;
                }
                for (Map.Entry<Integer, List<String>> entry : entrySet) {
                    List<String> value = entry.getValue();
                    if (value != null && value.contains(str)) {
                        mainProcessStartOrStopPlugin(entry.getKey().intValue(), str, false);
                    }
                }
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
        }
    }

    public static Map<Integer, Integer> mainProcessStartAllPlugin(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, str)) == null) {
            try {
                if (TextUtils.isEmpty(str) || sBinderMap == null) {
                    return null;
                }
                HashMap hashMap = new HashMap();
                for (Integer num : sBinderMap.keySet()) {
                    hashMap.put(num, Integer.valueOf(mainProcessStartOrStopPlugin(num.intValue(), str, true)));
                }
                return hashMap;
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                return null;
            }
        }
        return (Map) invokeL.objValue;
    }

    public static int mainProcessStartOrStopPlugin(int i, String str, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65552, null, new Object[]{Integer.valueOf(i), str, Boolean.valueOf(z)})) == null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return -201;
                }
                if (sBinderMap == null) {
                    return -200;
                }
                IMutiProcessHandler iMutiProcessHandler = sBinderMap.get(Integer.valueOf(i));
                if (iMutiProcessHandler == null) {
                    return -202;
                }
                Bundle bundle = new Bundle();
                bundle.putInt(BUNDLE_KEY_CTRL_ACTION, z ? 1 : 2);
                bundle.putString(BUNDLE_KEY_PLUGIN_PACKAGE_NAME, str);
                int i2 = iMutiProcessHandler.doCtrlAction(bundle).getInt(BUNDLE_KEY_ERROR_CODE, -200);
                if (i2 == 0 && sSubProcessPluginsMap != null) {
                    List<String> list = sSubProcessPluginsMap.get(Integer.valueOf(i));
                    if (list == null) {
                        list = new ArrayList<>();
                        sSubProcessPluginsMap.put(Integer.valueOf(i), list);
                    }
                    if (z && !list.contains(str)) {
                        list.add(str);
                    } else if (!z && list.contains(str)) {
                        list.remove(str);
                    }
                }
                return i2;
            } catch (RemoteException e2) {
                CommonMethods.handleNuLException(e2);
                return -203;
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                return -200;
            }
        }
        return invokeCommon.intValue;
    }

    public static void registerNeedNotifySubProcess(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65553, null, str, z) == null) {
            try {
                if (TextUtils.isEmpty(str) || sNeedNotifyPluginList == null) {
                    return;
                }
                if (z) {
                    sNeedNotifyPluginList.add(str);
                } else {
                    sNeedNotifyPluginList.remove(str);
                }
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
        }
    }

    public static void registerSubProcess(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65554, null, context) == null) || context == null) {
            return;
        }
        try {
            if (CommonMethods.checkFlagFile(context, CommonMethods.ALLOW_MUTI_PROCESS_FLAG_FILE_NAME)) {
                sSubProcessContext = context.getApplicationContext();
                Bundle bundle = new Bundle();
                bundle.putInt(BUNDLE_KEY_PID, Process.myPid());
                bundle.putParcelable(BUNDLE_KEY_BINDER_HOLDER, new BinderHolder(sMutiProcessHandler.asBinder()));
                ProviderAccessUtil.callPrivateProvider(context, "sub_process_register_sub_process", bundle);
            }
        } catch (Throwable th) {
            CommonMethods.handleNuLException(th);
        }
    }

    public static Bundle subProcessGetPluginStatus(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, str)) == null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return createBundleWithErrorCode(-101);
                }
                PluginloaderHub peekInstance = PluginloaderHub.peekInstance();
                if (peekInstance == null) {
                    return createBundleWithErrorCode(-102);
                }
                Bundle bundle = new Bundle();
                if (peekInstance.getApkInfoByPackageName(str) == null) {
                    bundle.putInt(BUNDLE_KEY_ERROR_CODE, 0);
                    bundle.putInt("status", -1);
                    return bundle;
                }
                bundle.putInt(BUNDLE_KEY_ERROR_CODE, 0);
                bundle.putInt("status", 1);
                return bundle;
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                try {
                    return createBundleWithErrorCode(-100);
                } catch (Throwable th2) {
                    CommonMethods.handleNuLException(th2);
                    return null;
                }
            }
        }
        return (Bundle) invokeL.objValue;
    }

    public static Bundle subProcessLoadPlugin(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, bundle)) == null) {
            try {
                if (sSubProcessContext == null) {
                    return createBundleWithErrorCode(-104);
                }
                String string = bundle.getString(BUNDLE_KEY_PLUGIN_PACKAGE_NAME);
                if (TextUtils.isEmpty(string)) {
                    return createBundleWithErrorCode(-101);
                }
                ForHostApp forHostApp = ForHostApp.getInstance(sSubProcessContext);
                if (forHostApp == null) {
                    return createBundleWithErrorCode(-105);
                }
                if (forHostApp.initSinglePlugin(string)) {
                    return createBundleWithErrorCode(0);
                }
                return createBundleWithErrorCode(-100);
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                return null;
            }
        }
        return (Bundle) invokeL.objValue;
    }

    public static Bundle subProcessRequestCallPlugin(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, bundle)) == null) {
            try {
                if (sSubProcessContext == null) {
                    return createBundleWithErrorCode(-204);
                }
                if (bundle == null) {
                    return createBundleWithErrorCode(-201);
                }
                return ProviderAccessUtil.callPrivateProvider(sSubProcessContext, "sub_process_call_main_plugin", bundle);
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                return createBundleWithErrorCode(-200);
            }
        }
        return (Bundle) invokeL.objValue;
    }

    public static Bundle subProcessUnloadPlugin(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, bundle)) == null) {
            try {
                if (sSubProcessContext == null) {
                    return createBundleWithErrorCode(-104);
                }
                String string = bundle.getString(BUNDLE_KEY_PLUGIN_PACKAGE_NAME);
                if (TextUtils.isEmpty(string)) {
                    return createBundleWithErrorCode(-101);
                }
                PluginloaderHub peekInstance = PluginloaderHub.peekInstance();
                if (peekInstance == null) {
                    return createBundleWithErrorCode(-102);
                }
                if (peekInstance.unloadApkSubProcess(string)) {
                    return createBundleWithErrorCode(0);
                }
                return createBundleWithErrorCode(-100);
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                return null;
            }
        }
        return (Bundle) invokeL.objValue;
    }
}

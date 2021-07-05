package com.baidu.searchbox.unitedscheme;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor;
import com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeInterceptChain;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class UnitedSchemeMainDispatcher extends UnitedSchemeBaseDispatcher {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final int SCHEME_SIZE_LIMIT = 10;
    public static final int SCHEME_TIME_LIMIT = 600000;
    public static final String TAG;
    public static final String UBC_INSIDE_INVOKE_TO_TAYGET_ID = "1327";
    public static final String UBC_OUTER_INVOKE_TO_TAYGET_ID = "138";
    public static final String UBC_SCHEME_USAGE_TAYGET_ID = "1631";
    public static List<UnitedSchemeBaseDispatcher> injectDispatcherList;
    public static List<UnitedSchemeBaseInterceptor> injectInterceptorList;
    public static HashMap<String, String> redirectSchemes;
    public static UnitedSchemeInterceptChain sInterceptChain;
    public static Queue<InvokeSchemeInfo> sLastInvokeSchemeQueue;
    public static HashMap<String, Class<? extends UnitedSchemeBaseDispatcher>> sSubDispatchers;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, UnitedSchemeBaseDispatcher> mDynamicDispatchers;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1284120314, "Lcom/baidu/searchbox/unitedscheme/UnitedSchemeMainDispatcher;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1284120314, "Lcom/baidu/searchbox/unitedscheme/UnitedSchemeMainDispatcher;");
                return;
            }
        }
        DEBUG = UnitedSchemeConstants.DEBUG;
        TAG = UnitedSchemeMainDispatcher.class.getSimpleName();
        sInterceptChain = new UnitedSchemeInterceptChain();
        sSubDispatchers = new HashMap<>();
        redirectSchemes = new HashMap<>();
        sLastInvokeSchemeQueue = new ConcurrentLinkedQueue();
        UnitedSchemeRuntime unitedSchemeRuntime = new UnitedSchemeRuntime();
        injectDispatcherList = unitedSchemeRuntime.sSubDispatchersList.getList();
        injectInterceptorList = unitedSchemeRuntime.sInterceptChainList.getList();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v4, resolved type: java.util.HashMap<java.lang.String, java.lang.Class<? extends com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher>> */
    /* JADX WARN: Multi-variable type inference failed */
    public UnitedSchemeMainDispatcher() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mDynamicDispatchers = new HashMap<>();
        synchronized (UnitedSchemeMainDispatcher.class) {
            if (injectDispatcherList != null && sSubDispatchers.isEmpty()) {
                for (UnitedSchemeBaseDispatcher unitedSchemeBaseDispatcher : injectDispatcherList) {
                    if (sSubDispatchers.get(unitedSchemeBaseDispatcher.getDispatcherName()) == null) {
                        sSubDispatchers.put(unitedSchemeBaseDispatcher.getDispatcherName(), unitedSchemeBaseDispatcher.getClass());
                        unitedSchemeBaseDispatcher.addRedirectScheme(redirectSchemes);
                    } else if (DEBUG) {
                        throw new IllegalArgumentException("duplicate schemeDispatcher name:" + unitedSchemeBaseDispatcher.getDispatcherName());
                    }
                }
            }
            if (injectInterceptorList != null && sInterceptChain.isEmpty()) {
                for (UnitedSchemeBaseInterceptor unitedSchemeBaseInterceptor : injectInterceptorList) {
                    sInterceptChain.addInterceptor(unitedSchemeBaseInterceptor);
                }
            }
        }
    }

    public static void buildSchemeEventObject(boolean z, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{Boolean.valueOf(z), str, str2}) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("url", str);
                jSONObject2.put("action", str2);
                jSONObject.put("ext", jSONObject2);
                jSONObject.put("type", z ? 0 : 1);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            SchemeRuntime.getSchemeIoc().doStatistic(UBC_SCHEME_USAGE_TAYGET_ID, jSONObject.toString());
        }
    }

    private void doUBCForOutsideAndInside(UnitedSchemeEntity unitedSchemeEntity, int i2, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(65539, this, unitedSchemeEntity, i2, callbackHandler) == null) || unitedSchemeEntity == null || unitedSchemeEntity.getUri() == null) {
            return;
        }
        doUBCForSpecifiedScheme(unitedSchemeEntity, callbackHandler);
        if (!DEBUG) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("scheme", unitedSchemeEntity.getUri().toString());
                jSONObject.put("ext", jSONObject2);
                jSONObject.put("value", String.valueOf(i2));
                if (TextUtils.equals(unitedSchemeEntity.getSource(), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE)) {
                    jSONObject.put("from", UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE);
                } else {
                    jSONObject.put("from", UnitedSchemeConstants.SCHEME_INVOKE_TYPE_OUTSIDE);
                }
                jSONObject.put("type", "scheme");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            SchemeRuntime.getSchemeIoc().doStatistic(UBC_INSIDE_INVOKE_TO_TAYGET_ID, jSONObject.toString());
        }
        if (TextUtils.equals(unitedSchemeEntity.getSource(), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE)) {
            return;
        }
        SchemeRuntime.getSchemeIoc().processSchemeFromMobsdk(unitedSchemeEntity, i2);
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("scheme", unitedSchemeEntity.getUri().toString());
            jSONObject3.put("errorcode", i2);
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        SchemeRuntime.getSchemeIoc().doStatistic(UBC_OUTER_INVOKE_TO_TAYGET_ID, jSONObject3.toString());
    }

    public static void doUBCForSpecifiedJsinterface(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65540, null, str, str2) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        ArrayList arrayList = new ArrayList(SchemeUsageStatisticsListener.getStatisticJsinterfaceList());
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (str.equals((String) arrayList.get(i2))) {
                buildSchemeEventObject(false, SchemeUsageStatisticsListener.getUrlWithoutQuery(str2), str);
            }
        }
    }

    private void doUBCForSpecifiedScheme(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, this, unitedSchemeEntity, callbackHandler) == null) {
            String allPath = unitedSchemeEntity.getAllPath();
            if (TextUtils.isEmpty(allPath)) {
                return;
            }
            ArrayList arrayList = new ArrayList(SchemeUsageStatisticsListener.getStatisticSchemeList());
            while (i2 < arrayList.size()) {
                String str = (String) arrayList.get(i2);
                if (!allPath.equals(str)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append("/");
                    i2 = allPath.startsWith(sb.toString()) ? 0 : i2 + 1;
                }
                buildSchemeEventObject(true, callbackHandler == null ? "" : SchemeUsageStatisticsListener.getUrlWithoutQuery(callbackHandler.getCurrentPageUrl()), SchemeUsageStatisticsListener.getUrlWithoutQuery(unitedSchemeEntity.getUri().toString()));
            }
        }
    }

    public static boolean exceedTimeLimit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            InvokeSchemeInfo peek = sLastInvokeSchemeQueue.peek();
            return peek != null && Math.abs(System.currentTimeMillis() - peek.invokeTime) > TTAdConstant.AD_MAX_EVENT_TIME;
        }
        return invokeV.booleanValue;
    }

    private JSONObject selectResult(UnitedSchemeEntity unitedSchemeEntity, UnitedSchemeEntity unitedSchemeEntity2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, this, unitedSchemeEntity, unitedSchemeEntity2)) == null) {
            JSONObject jSONObject = unitedSchemeEntity.result;
            if (jSONObject == null) {
                return unitedSchemeEntity2.result;
            }
            if (unitedSchemeEntity2.result == null) {
                return jSONObject;
            }
            if (jSONObject.optInt("status", -1) == 302 && unitedSchemeEntity2.result.optInt("status", -1) == 301) {
                return unitedSchemeEntity.result;
            }
            return unitedSchemeEntity2.result;
        }
        return (JSONObject) invokeLL.objValue;
    }

    private void showUpdateDialog(Context context, UnitedSchemeEntity unitedSchemeEntity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, this, context, unitedSchemeEntity) == null) {
            Uri uri = unitedSchemeEntity.getUri();
            if (!TextUtils.equals(unitedSchemeEntity.removeParam(UnitedSchemeConstants.UNITED_SCHEME_UPGRADE), "1") || unitedSchemeEntity.isOnlyVerify()) {
                return;
            }
            SchemeRuntime.getSchemeIoc().showSchemeNotSupportDialog(context);
            UnitedSchemeStatisticUtil.doUBCForUpdateDialog(uri);
        }
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public boolean checkPermission(Context context, UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, unitedSchemeEntity)) == null) ? super.checkPermission(context, unitedSchemeEntity) : invokeLL.booleanValue;
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher, com.baidu.searchbox.unitedscheme.UnitedSchemeAbsDispatcher
    public boolean dispatch(Context context, UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity)) == null) ? dispatch(context, unitedSchemeEntity, null) : invokeLL.booleanValue;
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public String getDispatcherName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? UnitedSchemeBaseDispatcher.DISPATCHER_NOT_FIRST_LEVEL : (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public Class<? extends UnitedSchemeAbsDispatcher> getSubDispatcher(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) ? sSubDispatchers.get(str) : (Class) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public boolean invoke(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, context, unitedSchemeEntity, callbackHandler)) == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302);
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public void removeDynamicDispatcher(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, str) == null) && !TextUtils.isEmpty(str) && this.mDynamicDispatchers.containsKey(str)) {
            this.mDynamicDispatchers.remove(str);
        }
    }

    public void setDynamicDispatcher(String str, UnitedSchemeBaseDispatcher unitedSchemeBaseDispatcher) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, str, unitedSchemeBaseDispatcher) == null) || TextUtils.isEmpty(str) || unitedSchemeBaseDispatcher == null) {
            return;
        }
        this.mDynamicDispatchers.put(str, unitedSchemeBaseDispatcher);
    }

    public void updateSchemeInfo(UnitedSchemeEntity unitedSchemeEntity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, unitedSchemeEntity) == null) {
            try {
                if (unitedSchemeEntity.getUri() != null) {
                    if (sLastInvokeSchemeQueue.size() >= 10 || exceedTimeLimit()) {
                        sLastInvokeSchemeQueue.poll();
                    }
                    sLastInvokeSchemeQueue.offer(new InvokeSchemeInfo(unitedSchemeEntity.getUri().toString(), System.currentTimeMillis()));
                }
            } catch (Exception e2) {
                if (DEBUG) {
                    Log.d(TAG, e2.getMessage());
                }
            }
        }
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher, com.baidu.searchbox.unitedscheme.UnitedSchemeAbsDispatcher
    public boolean dispatch(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        InterceptResult invokeLLL;
        UnitedSchemeEntity unitedSchemeEntity2;
        UnitedSchemeBaseDispatcher unitedSchemeBaseDispatcher;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, unitedSchemeEntity, callbackHandler)) == null) {
            updateSchemeInfo(unitedSchemeEntity);
            if (unitedSchemeEntity.getParam(UnitedSchemeConstants.UNITED_SCHEME_SENIOR) != null) {
                String param = unitedSchemeEntity.getParam(UnitedSchemeConstants.UNITED_SCHEME_SENIOR);
                unitedSchemeEntity2 = unitedSchemeEntity.m21clone();
                unitedSchemeEntity2.removeParam(UnitedSchemeConstants.UNITED_SCHEME_SENIOR);
                unitedSchemeEntity = new UnitedSchemeEntity(Uri.parse(param), unitedSchemeEntity.getSource());
            } else {
                unitedSchemeEntity2 = null;
            }
            String allPath = unitedSchemeEntity.getAllPath();
            if (redirectSchemes.get(allPath) != null) {
                unitedSchemeEntity.replaceAllPath(allPath, redirectSchemes.get(allPath));
            }
            if (sInterceptChain.shouldInterceptDispatch(context, unitedSchemeEntity, callbackHandler)) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, unitedSchemeEntity.result);
                JSONObject jSONObject = unitedSchemeEntity.result;
                if (jSONObject != null) {
                    doUBCForOutsideAndInside(unitedSchemeEntity, jSONObject.optInt("status", -1), callbackHandler);
                } else {
                    doUBCForOutsideAndInside(unitedSchemeEntity, 0, callbackHandler);
                }
                return true;
            }
            UnitedSchemeEntity m21clone = unitedSchemeEntity.m21clone();
            String path = m21clone.getPath(true);
            if (!TextUtils.isEmpty(path) && (unitedSchemeBaseDispatcher = this.mDynamicDispatchers.get(path)) != null) {
                boolean dispatch = unitedSchemeBaseDispatcher.dispatch(context, m21clone, callbackHandler);
                JSONObject jSONObject2 = m21clone.result;
                if (jSONObject2 != null) {
                    int optInt = jSONObject2.optInt("status", -1);
                    if (optInt != 301 && optInt != 302) {
                        doUBCForOutsideAndInside(unitedSchemeEntity, optInt, callbackHandler);
                        if (optInt != 0) {
                            UnitedSchemeUtility.callCallback(callbackHandler, m21clone, m21clone.result);
                        }
                        unitedSchemeEntity.result = m21clone.result;
                        return dispatch;
                    }
                } else if (dispatch) {
                    doUBCForOutsideAndInside(unitedSchemeEntity, dispatch ? 0 : -2, callbackHandler);
                    return true;
                }
            }
            boolean dispatch2 = super.dispatch(context, unitedSchemeEntity, callbackHandler);
            if (!dispatch2 && unitedSchemeEntity.getParam(UnitedSchemeConstants.UNITED_SCHEME_BACKUP) != null) {
                UnitedSchemeEntity unitedSchemeEntity3 = new UnitedSchemeEntity(Uri.parse(unitedSchemeEntity.getParam(UnitedSchemeConstants.UNITED_SCHEME_BACKUP)), m21clone.getSource());
                dispatch2 = dispatch(context, unitedSchemeEntity3, callbackHandler);
                unitedSchemeEntity = unitedSchemeEntity3;
            }
            JSONObject selectResult = selectResult(m21clone, unitedSchemeEntity);
            if (dispatch2 && unitedSchemeEntity.result == null) {
                doUBCForOutsideAndInside(unitedSchemeEntity, dispatch2 ? 0 : -2, callbackHandler);
            } else if (selectResult != null) {
                int optInt2 = selectResult.optInt("status", -1);
                if (optInt2 == 301 || optInt2 == 302) {
                    if (unitedSchemeEntity2 != null) {
                        return dispatch(context, unitedSchemeEntity2, callbackHandler);
                    }
                    if (unitedSchemeEntity.getParam(UnitedSchemeConstants.UNITED_SCHEME_UPGRADE) != null && unitedSchemeEntity.getParam(UnitedSchemeConstants.UNITED_SCHEME_UPGRADE).equals("1")) {
                        showUpdateDialog(context, unitedSchemeEntity);
                    }
                }
                doUBCForOutsideAndInside(unitedSchemeEntity, optInt2, callbackHandler);
                if (optInt2 > 0) {
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, selectResult);
                }
            } else {
                doUBCForOutsideAndInside(unitedSchemeEntity, dispatch2 ? 0 : -2, callbackHandler);
            }
            unitedSchemeEntity.result = selectResult;
            return dispatch2;
        }
        return invokeLLL.booleanValue;
    }
}

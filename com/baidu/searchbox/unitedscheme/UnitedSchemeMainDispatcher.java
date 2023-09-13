package com.baidu.searchbox.unitedscheme;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor;
import com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeInterceptChain;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.tieba.pk1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class UnitedSchemeMainDispatcher extends UnitedSchemeBaseDispatcher {
    public static final int SCHEME_SIZE_LIMIT = 10;
    public static final int SCHEME_TIME_LIMIT = 600000;
    public static final String UBC_INSIDE_INVOKE_TO_TAYGET_ID = "1327";
    public static final String UBC_KEY_LAUNCH_SCHEME = "launch_scheme";
    public static final String UBC_KEY_SCHEME_END = "scheme_end";
    public static final String UBC_KEY_SCHEME_START = "scheme_start";
    public static final String UBC_OUTER_INVOKE_TO_TAYGET_ID = "138";
    public static final String UBC_SCHEME_USAGE_TAYGET_ID = "1631";
    public static List<UnitedSchemeBaseDispatcher> injectDispatcherList;
    public static List<UnitedSchemeBaseInterceptor> injectInterceptorList;
    public static List<UnitedSchemeBasePriorDispatcher> injectPriorDispatcherList;
    public HashMap<String, UnitedSchemeBaseDispatcher> mDynamicDispatchers = new HashMap<>();
    public static final boolean DEBUG = UnitedSchemeConstants.DEBUG;
    public static final String TAG = UnitedSchemeMainDispatcher.class.getSimpleName();
    public static UnitedSchemeInterceptChain sInterceptChain = new UnitedSchemeInterceptChain();
    public static HashMap<String, Class<? extends UnitedSchemeBaseDispatcher>> sSubDispatchers = new HashMap<>();
    public static HashMap<String, Class<? extends UnitedSchemeBaseDispatcher>> sPriorSubDispatchers = new HashMap<>();
    public static HashMap<String, String> redirectSchemes = new HashMap<>();
    public static Queue<InvokeSchemeInfo> sLastInvokeSchemeQueue = new ConcurrentLinkedQueue();
    public static boolean hasLoadAllDispatchers = false;

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public String getDispatcherName() {
        return UnitedSchemeBaseDispatcher.DISPATCHER_NOT_FIRST_LEVEL;
    }

    static {
        UnitedSchemePriorRuntime unitedSchemePriorRuntime = new UnitedSchemePriorRuntime();
        pk1<UnitedSchemeBasePriorDispatcher> pk1Var = unitedSchemePriorRuntime.sPriorSubDispatchersList;
        if (pk1Var != null) {
            injectPriorDispatcherList = pk1Var.getList();
        }
        pk1<UnitedSchemeBaseInterceptor> pk1Var2 = unitedSchemePriorRuntime.sInterceptChainList;
        if (pk1Var2 != null) {
            injectInterceptorList = pk1Var2.getList();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v3, resolved type: java.util.HashMap<java.lang.String, java.lang.Class<? extends com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher>> */
    /* JADX WARN: Multi-variable type inference failed */
    public UnitedSchemeMainDispatcher() {
        synchronized (UnitedSchemeMainDispatcher.class) {
            if (SchemeRuntime.getFlyingScheduleIoc() != null && SchemeRuntime.getFlyingScheduleIoc().enableFlyingSchedule()) {
                if (injectPriorDispatcherList != null && sPriorSubDispatchers.isEmpty()) {
                    for (UnitedSchemeBasePriorDispatcher unitedSchemeBasePriorDispatcher : injectPriorDispatcherList) {
                        if (sPriorSubDispatchers.get(unitedSchemeBasePriorDispatcher.getDispatcherName()) == null) {
                            sPriorSubDispatchers.put(unitedSchemeBasePriorDispatcher.getDispatcherName(), unitedSchemeBasePriorDispatcher.getClass());
                            unitedSchemeBasePriorDispatcher.addRedirectScheme(redirectSchemes);
                        } else if (DEBUG) {
                            throw new IllegalArgumentException("duplicate schemeDispatcher name:" + unitedSchemeBasePriorDispatcher.getDispatcherName());
                        }
                    }
                }
            } else {
                initAllSubDispatchersMap();
            }
            if (injectInterceptorList != null && sInterceptChain.isEmpty()) {
                for (UnitedSchemeBaseInterceptor unitedSchemeBaseInterceptor : injectInterceptorList) {
                    sInterceptChain.addInterceptor(unitedSchemeBaseInterceptor);
                }
            }
        }
    }

    public static void buildSchemeEventObject(boolean z, String str, String str2) {
        int i;
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("url", str);
            jSONObject2.put("action", str2);
            jSONObject.put("ext", jSONObject2);
            if (z) {
                i = 0;
            } else {
                i = 1;
            }
            jSONObject.put("type", i);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        SchemeRuntime.getSchemeIoc().doStatistic(UBC_SCHEME_USAGE_TAYGET_ID, jSONObject.toString());
    }

    private void doUBCForOutsideAndInside(UnitedSchemeEntity unitedSchemeEntity, int i, CallbackHandler callbackHandler, IExternalTransferIoc iExternalTransferIoc) {
        if (unitedSchemeEntity != null && unitedSchemeEntity.getUri() != null) {
            doUBCForSpecifiedScheme(unitedSchemeEntity, callbackHandler);
            if (!TextUtils.equals(unitedSchemeEntity.getSource(), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE)) {
                if (DEBUG && !TextUtils.equals(unitedSchemeEntity.getSource(), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_OUTSIDE)) {
                    Toast.makeText(AppRuntime.getAppContext(), "端能力调用传入的source参数不合法！source字段只能为outside或者inside", 1).show();
                }
                SchemeRuntime.getSchemeIoc().processSchemeFromMobsdk(unitedSchemeEntity, i);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("scheme", unitedSchemeEntity.getUri().toString());
                    jSONObject.put("errorcode", i);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                SchemeRuntime.getSchemeIoc().doStatistic(UBC_OUTER_INVOKE_TO_TAYGET_ID, jSONObject.toString());
            }
            if (iExternalTransferIoc != null) {
                iExternalTransferIoc.addEvent(UBC_KEY_SCHEME_END);
            }
        }
    }

    public static void doUBCForSpecifiedJsinterface(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            ArrayList arrayList = new ArrayList(SchemeUsageStatisticsListener.getStatisticJsinterfaceList());
            for (int i = 0; i < arrayList.size(); i++) {
                if (str.equals((String) arrayList.get(i))) {
                    buildSchemeEventObject(false, SchemeUsageStatisticsListener.getUrlWithoutQuery(str2), str);
                }
            }
        }
    }

    private JSONObject selectResult(UnitedSchemeEntity unitedSchemeEntity, UnitedSchemeEntity unitedSchemeEntity2) {
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

    private void showUpdateDialog(Context context, UnitedSchemeEntity unitedSchemeEntity) {
        Uri uri = unitedSchemeEntity.getUri();
        if (TextUtils.equals(unitedSchemeEntity.removeParam("upgrade"), "1") && !unitedSchemeEntity.isOnlyVerify()) {
            SchemeRuntime.getSchemeIoc().showSchemeNotSupportDialog(context);
            UnitedSchemeStatisticUtil.doUBCForUpdateDialog(uri);
        }
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public boolean checkPermission(Context context, UnitedSchemeEntity unitedSchemeEntity) {
        return super.checkPermission(context, unitedSchemeEntity);
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher, com.baidu.searchbox.unitedscheme.UnitedSchemeAbsDispatcher
    public boolean dispatch(Context context, UnitedSchemeEntity unitedSchemeEntity) {
        return dispatch(context, unitedSchemeEntity, null);
    }

    public void setDynamicDispatcher(String str, UnitedSchemeBaseDispatcher unitedSchemeBaseDispatcher) {
        if (!TextUtils.isEmpty(str) && unitedSchemeBaseDispatcher != null) {
            this.mDynamicDispatchers.put(str, unitedSchemeBaseDispatcher);
        }
    }

    private void doUBCForSpecifiedScheme(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        String urlWithoutQuery;
        String allPath = unitedSchemeEntity.getAllPath();
        if (!TextUtils.isEmpty(allPath)) {
            ArrayList arrayList = new ArrayList(SchemeUsageStatisticsListener.getStatisticSchemeList());
            for (int i = 0; i < arrayList.size(); i++) {
                String str = (String) arrayList.get(i);
                if (!allPath.equals(str)) {
                    if (!allPath.startsWith(str + "/")) {
                    }
                }
                if (callbackHandler == null) {
                    urlWithoutQuery = "";
                } else {
                    urlWithoutQuery = SchemeUsageStatisticsListener.getUrlWithoutQuery(callbackHandler.getCurrentPageUrl());
                }
                buildSchemeEventObject(true, urlWithoutQuery, SchemeUsageStatisticsListener.getUrlWithoutQuery(unitedSchemeEntity.getUri().toString()));
            }
        }
    }

    public static boolean exceedTimeLimit() {
        InvokeSchemeInfo peek = sLastInvokeSchemeQueue.peek();
        if (peek == null || Math.abs(System.currentTimeMillis() - peek.invokeTime) <= 600000) {
            return false;
        }
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v2, resolved type: java.util.HashMap<java.lang.String, java.lang.Class<? extends com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher>> */
    /* JADX WARN: Multi-variable type inference failed */
    public static void initAllSubDispatchersMap() {
        if (sSubDispatchers.isEmpty()) {
            synchronized (UnitedSchemeMainDispatcher.class) {
                if (sSubDispatchers.isEmpty()) {
                    List<UnitedSchemeBaseDispatcher> list = new UnitedSchemeRuntime().sSubDispatchersList.getList();
                    injectDispatcherList = list;
                    if (list != null) {
                        for (UnitedSchemeBaseDispatcher unitedSchemeBaseDispatcher : list) {
                            if (sSubDispatchers.get(unitedSchemeBaseDispatcher.getDispatcherName()) == null) {
                                sSubDispatchers.put(unitedSchemeBaseDispatcher.getDispatcherName(), unitedSchemeBaseDispatcher.getClass());
                                unitedSchemeBaseDispatcher.addRedirectScheme(redirectSchemes);
                            } else if (DEBUG) {
                                throw new IllegalArgumentException("duplicate schemeDispatcher name:" + unitedSchemeBaseDispatcher.getDispatcherName());
                            }
                        }
                        if (!sSubDispatchers.isEmpty()) {
                            hasLoadAllDispatchers = true;
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher, com.baidu.searchbox.unitedscheme.UnitedSchemeAbsDispatcher
    public boolean dispatch(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        UnitedSchemeBaseDispatcher unitedSchemeBaseDispatcher;
        UnitedSchemeEntity unitedSchemeEntity2 = unitedSchemeEntity;
        IExternalTransferIoc externalTransferIoc = SchemeRuntime.getExternalTransferIoc();
        if (externalTransferIoc != null) {
            if (!TextUtils.equals(unitedSchemeEntity.getSource(), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE)) {
                externalTransferIoc.addEvent("launch_scheme", unitedSchemeEntity.getUri().toString());
            }
            externalTransferIoc.addEvent(UBC_KEY_SCHEME_START);
        }
        updateSchemeInfo(unitedSchemeEntity2);
        UnitedSchemeEntity unitedSchemeEntity3 = null;
        if (unitedSchemeEntity2.getParam(UnitedSchemeConstants.UNITED_SCHEME_SENIOR) != null) {
            String param = unitedSchemeEntity2.getParam(UnitedSchemeConstants.UNITED_SCHEME_SENIOR);
            UnitedSchemeEntity m113clone = unitedSchemeEntity.m113clone();
            m113clone.removeParam(UnitedSchemeConstants.UNITED_SCHEME_SENIOR);
            unitedSchemeEntity2 = new UnitedSchemeEntity(Uri.parse(param), unitedSchemeEntity.getSource());
            unitedSchemeEntity3 = m113clone;
        }
        String allPath = unitedSchemeEntity2.getAllPath();
        if (redirectSchemes.get(allPath) != null) {
            unitedSchemeEntity2.replaceAllPath(allPath, redirectSchemes.get(allPath));
        }
        int i = 0;
        if (sInterceptChain.shouldInterceptDispatch(context, unitedSchemeEntity2, callbackHandler)) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity2, unitedSchemeEntity2.result);
            JSONObject jSONObject = unitedSchemeEntity2.result;
            if (jSONObject != null) {
                doUBCForOutsideAndInside(unitedSchemeEntity2, jSONObject.optInt("status", -1), callbackHandler, externalTransferIoc);
            } else {
                doUBCForOutsideAndInside(unitedSchemeEntity2, 0, callbackHandler, externalTransferIoc);
            }
            return true;
        }
        UnitedSchemeEntity m113clone2 = unitedSchemeEntity2.m113clone();
        String path = m113clone2.getPath(true);
        if (!TextUtils.isEmpty(path) && (unitedSchemeBaseDispatcher = this.mDynamicDispatchers.get(path)) != null) {
            boolean dispatch = unitedSchemeBaseDispatcher.dispatch(context, m113clone2, callbackHandler);
            JSONObject jSONObject2 = m113clone2.result;
            if (jSONObject2 != null) {
                int optInt = jSONObject2.optInt("status", -1);
                if (optInt != 301 && optInt != 302) {
                    doUBCForOutsideAndInside(unitedSchemeEntity2, optInt, callbackHandler, externalTransferIoc);
                    if (optInt != 0) {
                        UnitedSchemeUtility.callCallback(callbackHandler, m113clone2, m113clone2.result);
                    }
                    unitedSchemeEntity2.result = m113clone2.result;
                    return dispatch;
                }
            } else if (dispatch) {
                if (!dispatch) {
                    i = -2;
                }
                doUBCForOutsideAndInside(unitedSchemeEntity2, i, callbackHandler, externalTransferIoc);
                return true;
            }
        }
        boolean dispatch2 = super.dispatch(context, unitedSchemeEntity2, callbackHandler);
        if (!dispatch2 && unitedSchemeEntity2.getParam("backup") != null) {
            UnitedSchemeEntity unitedSchemeEntity4 = new UnitedSchemeEntity(Uri.parse(unitedSchemeEntity2.getParam("backup")), m113clone2.getSource());
            dispatch2 = dispatch(context, unitedSchemeEntity4, callbackHandler);
            unitedSchemeEntity2 = unitedSchemeEntity4;
        }
        JSONObject selectResult = selectResult(m113clone2, unitedSchemeEntity2);
        if (dispatch2 && unitedSchemeEntity2.result == null) {
            if (!dispatch2) {
                i = -2;
            }
            doUBCForOutsideAndInside(unitedSchemeEntity2, i, callbackHandler, externalTransferIoc);
        } else if (selectResult != null) {
            int optInt2 = selectResult.optInt("status", -1);
            if (optInt2 == 301 || optInt2 == 302) {
                if (unitedSchemeEntity3 != null) {
                    return dispatch(context, unitedSchemeEntity3, callbackHandler);
                }
                if (!hasLoadAllDispatchers) {
                    initAllSubDispatchersMap();
                    return dispatch(context, unitedSchemeEntity2.m113clone(), callbackHandler);
                } else if (unitedSchemeEntity2.getParam("upgrade") != null && unitedSchemeEntity2.getParam("upgrade").equals("1")) {
                    showUpdateDialog(context, unitedSchemeEntity2);
                }
            }
            doUBCForOutsideAndInside(unitedSchemeEntity2, optInt2, callbackHandler, externalTransferIoc);
            if (optInt2 > 0) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity2, selectResult);
            }
        } else {
            if (!dispatch2) {
                i = -2;
            }
            doUBCForOutsideAndInside(unitedSchemeEntity2, i, callbackHandler, externalTransferIoc);
        }
        unitedSchemeEntity2.result = selectResult;
        return dispatch2;
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public Class<? extends UnitedSchemeAbsDispatcher> getSubDispatcher(String str) {
        if (hasLoadAllDispatchers) {
            return sSubDispatchers.get(str);
        }
        return sPriorSubDispatchers.get(str);
    }

    public void removeDynamicDispatcher(String str) {
        if (!TextUtils.isEmpty(str) && this.mDynamicDispatchers.containsKey(str)) {
            this.mDynamicDispatchers.remove(str);
        }
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public boolean invoke(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302);
        return false;
    }

    public void updateSchemeInfo(UnitedSchemeEntity unitedSchemeEntity) {
        try {
            if (unitedSchemeEntity.getUri() != null) {
                if (sLastInvokeSchemeQueue.size() >= 10 || exceedTimeLimit()) {
                    sLastInvokeSchemeQueue.poll();
                }
                sLastInvokeSchemeQueue.offer(new InvokeSchemeInfo(unitedSchemeEntity.getUri().toString(), System.currentTimeMillis()));
            }
        } catch (Exception e) {
            if (DEBUG) {
                Log.d(TAG, e.getMessage());
            }
        }
    }
}

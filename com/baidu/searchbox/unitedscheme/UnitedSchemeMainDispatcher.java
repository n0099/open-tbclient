package com.baidu.searchbox.unitedscheme;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor;
import com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeInterceptChain;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class UnitedSchemeMainDispatcher extends UnitedSchemeBaseDispatcher {
    public static final int SCHEME_SIZE_LIMIT = 10;
    public static final int SCHEME_TIME_LIMIT = 600000;
    public static final String UBC_INSIDE_INVOKE_TO_TAYGET_ID = "1327";
    public static final String UBC_OUTER_INVOKE_TO_TAYGET_ID = "138";
    public static final String UBC_SCHEME_USAGE_TAYGET_ID = "1631";
    public static List<UnitedSchemeBaseDispatcher> injectDispatcherList;
    public static List<UnitedSchemeBaseInterceptor> injectInterceptorList;
    public HashMap<String, UnitedSchemeBaseDispatcher> mDynamicDispatchers = new HashMap<>();
    public static final boolean DEBUG = UnitedSchemeConstants.DEBUG;
    public static final String TAG = UnitedSchemeMainDispatcher.class.getSimpleName();
    public static UnitedSchemeInterceptChain sInterceptChain = new UnitedSchemeInterceptChain();
    public static HashMap<String, Class<? extends UnitedSchemeBaseDispatcher>> sSubDispatchers = new HashMap<>();
    public static HashMap<String, String> redirectSchemes = new HashMap<>();
    public static Queue<InvokeSchemeInfo> sLastInvokeSchemeQueue = new ConcurrentLinkedQueue();

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public String getDispatcherName() {
        return UnitedSchemeBaseDispatcher.DISPATCHER_NOT_FIRST_LEVEL;
    }

    static {
        UnitedSchemeRuntime unitedSchemeRuntime = new UnitedSchemeRuntime();
        injectDispatcherList = unitedSchemeRuntime.sSubDispatchersList.getList();
        injectInterceptorList = unitedSchemeRuntime.sInterceptChainList.getList();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v3, resolved type: java.util.HashMap<java.lang.String, java.lang.Class<? extends com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher>> */
    /* JADX WARN: Multi-variable type inference failed */
    public UnitedSchemeMainDispatcher() {
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

    private void doUBCForOutsideAndInside(UnitedSchemeEntity unitedSchemeEntity, int i, CallbackHandler callbackHandler) {
        if (unitedSchemeEntity != null && unitedSchemeEntity.getUri() != null) {
            doUBCForSpecifiedScheme(unitedSchemeEntity, callbackHandler);
            if (!DEBUG) {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("scheme", unitedSchemeEntity.getUri().toString());
                    jSONObject.put("ext", jSONObject2);
                    jSONObject.put("value", String.valueOf(i));
                    if (TextUtils.equals(unitedSchemeEntity.getSource(), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE)) {
                        jSONObject.put("from", UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE);
                    } else {
                        jSONObject.put("from", UnitedSchemeConstants.SCHEME_INVOKE_TYPE_OUTSIDE);
                    }
                    jSONObject.put("type", "scheme");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                SchemeRuntime.getSchemeIoc().doStatistic(UBC_INSIDE_INVOKE_TO_TAYGET_ID, jSONObject.toString());
            }
            if (!TextUtils.equals(unitedSchemeEntity.getSource(), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE)) {
                SchemeRuntime.getSchemeIoc().processSchemeFromMobsdk(unitedSchemeEntity, i);
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("scheme", unitedSchemeEntity.getUri().toString());
                    jSONObject3.put("errorcode", i);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                SchemeRuntime.getSchemeIoc().doStatistic(UBC_OUTER_INVOKE_TO_TAYGET_ID, jSONObject3.toString());
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

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher, com.baidu.searchbox.unitedscheme.UnitedSchemeAbsDispatcher
    public boolean dispatch(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        UnitedSchemeEntity unitedSchemeEntity2;
        UnitedSchemeBaseDispatcher unitedSchemeBaseDispatcher;
        updateSchemeInfo(unitedSchemeEntity);
        if (unitedSchemeEntity.getParam(UnitedSchemeConstants.UNITED_SCHEME_SENIOR) != null) {
            String param = unitedSchemeEntity.getParam(UnitedSchemeConstants.UNITED_SCHEME_SENIOR);
            unitedSchemeEntity2 = unitedSchemeEntity.m44clone();
            unitedSchemeEntity2.removeParam(UnitedSchemeConstants.UNITED_SCHEME_SENIOR);
            unitedSchemeEntity = new UnitedSchemeEntity(Uri.parse(param), unitedSchemeEntity.getSource());
        } else {
            unitedSchemeEntity2 = null;
        }
        String allPath = unitedSchemeEntity.getAllPath();
        if (redirectSchemes.get(allPath) != null) {
            unitedSchemeEntity.replaceAllPath(allPath, redirectSchemes.get(allPath));
        }
        int i = 0;
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
        UnitedSchemeEntity m44clone = unitedSchemeEntity.m44clone();
        String path = m44clone.getPath(true);
        if (!TextUtils.isEmpty(path) && (unitedSchemeBaseDispatcher = this.mDynamicDispatchers.get(path)) != null) {
            boolean dispatch = unitedSchemeBaseDispatcher.dispatch(context, m44clone, callbackHandler);
            JSONObject jSONObject2 = m44clone.result;
            if (jSONObject2 != null) {
                int optInt = jSONObject2.optInt("status", -1);
                if (optInt != 301 && optInt != 302) {
                    doUBCForOutsideAndInside(unitedSchemeEntity, optInt, callbackHandler);
                    if (optInt != 0) {
                        UnitedSchemeUtility.callCallback(callbackHandler, m44clone, m44clone.result);
                    }
                    unitedSchemeEntity.result = m44clone.result;
                    return dispatch;
                }
            } else if (dispatch) {
                if (!dispatch) {
                    i = -2;
                }
                doUBCForOutsideAndInside(unitedSchemeEntity, i, callbackHandler);
                return true;
            }
        }
        boolean dispatch2 = super.dispatch(context, unitedSchemeEntity, callbackHandler);
        if (!dispatch2 && unitedSchemeEntity.getParam("backup") != null) {
            UnitedSchemeEntity unitedSchemeEntity3 = new UnitedSchemeEntity(Uri.parse(unitedSchemeEntity.getParam("backup")), m44clone.getSource());
            dispatch2 = dispatch(context, unitedSchemeEntity3, callbackHandler);
            unitedSchemeEntity = unitedSchemeEntity3;
        }
        JSONObject selectResult = selectResult(m44clone, unitedSchemeEntity);
        if (dispatch2 && unitedSchemeEntity.result == null) {
            if (!dispatch2) {
                i = -2;
            }
            doUBCForOutsideAndInside(unitedSchemeEntity, i, callbackHandler);
        } else if (selectResult != null) {
            int optInt2 = selectResult.optInt("status", -1);
            if (optInt2 == 301 || optInt2 == 302) {
                if (unitedSchemeEntity2 != null) {
                    return dispatch(context, unitedSchemeEntity2, callbackHandler);
                }
                if (unitedSchemeEntity.getParam("upgrade") != null && unitedSchemeEntity.getParam("upgrade").equals("1")) {
                    showUpdateDialog(context, unitedSchemeEntity);
                }
            }
            doUBCForOutsideAndInside(unitedSchemeEntity, optInt2, callbackHandler);
            if (optInt2 > 0) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, selectResult);
            }
        } else {
            if (!dispatch2) {
                i = -2;
            }
            doUBCForOutsideAndInside(unitedSchemeEntity, i, callbackHandler);
        }
        unitedSchemeEntity.result = selectResult;
        return dispatch2;
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public Class<? extends UnitedSchemeAbsDispatcher> getSubDispatcher(String str) {
        return sSubDispatchers.get(str);
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

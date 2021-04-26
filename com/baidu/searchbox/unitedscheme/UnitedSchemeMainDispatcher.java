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

    private void doUBCForOutsideAndInside(UnitedSchemeEntity unitedSchemeEntity, int i2, CallbackHandler callbackHandler) {
        if (unitedSchemeEntity == null || unitedSchemeEntity.getUri() == null) {
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
        if (TextUtils.isEmpty(str)) {
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

    public static boolean exceedTimeLimit() {
        InvokeSchemeInfo peek = sLastInvokeSchemeQueue.peek();
        return peek != null && Math.abs(System.currentTimeMillis() - peek.invokeTime) > 600000;
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
        if (!TextUtils.equals(unitedSchemeEntity.removeParam(UnitedSchemeConstants.UNITED_SCHEME_UPGRADE), "1") || unitedSchemeEntity.isOnlyVerify()) {
            return;
        }
        SchemeRuntime.getSchemeIoc().showSchemeNotSupportDialog(context);
        UnitedSchemeStatisticUtil.doUBCForUpdateDialog(uri);
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public boolean checkPermission(Context context, UnitedSchemeEntity unitedSchemeEntity) {
        return super.checkPermission(context, unitedSchemeEntity);
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher, com.baidu.searchbox.unitedscheme.UnitedSchemeAbsDispatcher
    public boolean dispatch(Context context, UnitedSchemeEntity unitedSchemeEntity) {
        return dispatch(context, unitedSchemeEntity, null);
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public String getDispatcherName() {
        return UnitedSchemeBaseDispatcher.DISPATCHER_NOT_FIRST_LEVEL;
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public Class<? extends UnitedSchemeAbsDispatcher> getSubDispatcher(String str) {
        return sSubDispatchers.get(str);
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public boolean invoke(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302);
        return false;
    }

    public void removeDynamicDispatcher(String str) {
        if (TextUtils.isEmpty(str) || !this.mDynamicDispatchers.containsKey(str)) {
            return;
        }
        this.mDynamicDispatchers.remove(str);
    }

    public void setDynamicDispatcher(String str, UnitedSchemeBaseDispatcher unitedSchemeBaseDispatcher) {
        if (TextUtils.isEmpty(str) || unitedSchemeBaseDispatcher == null) {
            return;
        }
        this.mDynamicDispatchers.put(str, unitedSchemeBaseDispatcher);
    }

    public void updateSchemeInfo(UnitedSchemeEntity unitedSchemeEntity) {
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

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher, com.baidu.searchbox.unitedscheme.UnitedSchemeAbsDispatcher
    public boolean dispatch(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        UnitedSchemeEntity unitedSchemeEntity2;
        UnitedSchemeBaseDispatcher unitedSchemeBaseDispatcher;
        updateSchemeInfo(unitedSchemeEntity);
        if (unitedSchemeEntity.getParam(UnitedSchemeConstants.UNITED_SCHEME_SENIOR) != null) {
            String param = unitedSchemeEntity.getParam(UnitedSchemeConstants.UNITED_SCHEME_SENIOR);
            unitedSchemeEntity2 = unitedSchemeEntity.m14clone();
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
        UnitedSchemeEntity m14clone = unitedSchemeEntity.m14clone();
        String path = m14clone.getPath(true);
        if (!TextUtils.isEmpty(path) && (unitedSchemeBaseDispatcher = this.mDynamicDispatchers.get(path)) != null) {
            boolean dispatch = unitedSchemeBaseDispatcher.dispatch(context, m14clone, callbackHandler);
            JSONObject jSONObject2 = m14clone.result;
            if (jSONObject2 != null) {
                int optInt = jSONObject2.optInt("status", -1);
                if (optInt != 301 && optInt != 302) {
                    doUBCForOutsideAndInside(unitedSchemeEntity, optInt, callbackHandler);
                    if (optInt != 0) {
                        UnitedSchemeUtility.callCallback(callbackHandler, m14clone, m14clone.result);
                    }
                    unitedSchemeEntity.result = m14clone.result;
                    return dispatch;
                }
            } else if (dispatch) {
                doUBCForOutsideAndInside(unitedSchemeEntity, dispatch ? 0 : -2, callbackHandler);
                return true;
            }
        }
        boolean dispatch2 = super.dispatch(context, unitedSchemeEntity, callbackHandler);
        if (!dispatch2 && unitedSchemeEntity.getParam(UnitedSchemeConstants.UNITED_SCHEME_BACKUP) != null) {
            UnitedSchemeEntity unitedSchemeEntity3 = new UnitedSchemeEntity(Uri.parse(unitedSchemeEntity.getParam(UnitedSchemeConstants.UNITED_SCHEME_BACKUP)), m14clone.getSource());
            dispatch2 = dispatch(context, unitedSchemeEntity3, callbackHandler);
            unitedSchemeEntity = unitedSchemeEntity3;
        }
        JSONObject selectResult = selectResult(m14clone, unitedSchemeEntity);
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
}

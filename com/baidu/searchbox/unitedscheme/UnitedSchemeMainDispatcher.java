package com.baidu.searchbox.unitedscheme;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor;
import com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeInterceptChain;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import h.d;
import h.e;
import h.j;
import h.n.f;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class UnitedSchemeMainDispatcher extends UnitedSchemeBaseDispatcher {
    public static final String CONTENT_KEY_EXT = "ext";
    public static final String CONTENT_KEY_FROM = "from";
    public static final String CONTENT_KEY_PAGE = "page";
    public static final boolean DEBUG = false;
    public static final String DISPATCHER_DEFAULT_CALLBACK = "dispatcher_default_callback";
    public static final String KEY_CALLBACK = "callback";
    public static final String KEY_NID = "nid";
    public static final int SCHEME_SIZE_LIMIT = 10;
    public static final int SCHEME_TIME_LIMIT = 600000;
    public static final String TAG = "UnitedSchemeMainDispatcher";
    public static final String UBC_INSIDE_INVOKE_TO_TAYGET_ID = "1327";
    public static final String UBC_INVOKE_SCHEME_LIST = "798";
    public static final String UBC_OUTER_INVOKE_TO_TAYGET_ID = "138";
    public static List<UnitedSchemeBaseDispatcher> injectDispatcherList;
    public static List<UnitedSchemeBaseInterceptor> injectInterceptorList;
    public HashMap<String, UnitedSchemeBaseDispatcher> mDynamicDispatchers = new HashMap<>();
    public static UnitedSchemeInterceptChain sInterceptChain = new UnitedSchemeInterceptChain();
    public static HashMap<String, Class<? extends UnitedSchemeBaseDispatcher>> sSubDispatchers = new HashMap<>();
    public static HashMap<String, String> redirectSchemes = new HashMap<>();
    public static Queue<InvokeSchemeInfo> sLastInvokeSchemeQueue = new ConcurrentLinkedQueue();

    static {
        UnitedSchemeRuntime unitedSchemeRuntime = new UnitedSchemeRuntime();
        injectDispatcherList = unitedSchemeRuntime.sSubDispatchersList.a();
        injectInterceptorList = unitedSchemeRuntime.sInterceptChainList.a();
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

    /* JADX INFO: Access modifiers changed from: private */
    public d<Object> createSchemeDispatchObservable(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final String str, final CallbackHandler callbackHandler) {
        return d.c(new d.a<Object>() { // from class: com.baidu.searchbox.unitedscheme.UnitedSchemeMainDispatcher.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // h.n.b
            public void call(final j<? super Object> jVar) {
                final UnitedSchemeEntity unitedSchemeEntity2 = new UnitedSchemeEntity(Uri.parse(str));
                UnitedSchemeEntity unitedSchemeEntity3 = unitedSchemeEntity;
                if (unitedSchemeEntity3 != null) {
                    unitedSchemeEntity2.setReferUrl(unitedSchemeEntity3.getReferUrl());
                    unitedSchemeEntity2.setPageUrl(unitedSchemeEntity.getPageUrl());
                }
                if (unitedSchemeEntity2.getParam("callback") == null) {
                    unitedSchemeEntity2.putParams("callback", UnitedSchemeMainDispatcher.DISPATCHER_DEFAULT_CALLBACK);
                }
                UnitedSchemeMainDispatcher.this.dispatch(context, unitedSchemeEntity2, new CallbackHandler() { // from class: com.baidu.searchbox.unitedscheme.UnitedSchemeMainDispatcher.4.1
                    @Override // com.baidu.searchbox.unitedscheme.CallbackHandler
                    public String getCurrentPageUrl() {
                        CallbackHandler callbackHandler2 = callbackHandler;
                        if (callbackHandler2 == null) {
                            return null;
                        }
                        return callbackHandler2.getCurrentPageUrl();
                    }

                    @Override // com.baidu.searchbox.unitedscheme.CallbackHandler
                    public void handleSchemeDispatchCallback(String str2, String str3) {
                        JSONObject jSONObject;
                        if (TextUtils.isEmpty(str3)) {
                            jSONObject = new JSONObject();
                        } else {
                            try {
                                jSONObject = new JSONObject(str3);
                            } catch (JSONException unused) {
                                jSONObject = new JSONObject();
                            }
                        }
                        int optInt = jSONObject.optInt("status", -1);
                        if (!TextUtils.equals(str2, UnitedSchemeMainDispatcher.DISPATCHER_DEFAULT_CALLBACK)) {
                            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity2, jSONObject);
                        }
                        UnitedSchemeEntity unitedSchemeEntity4 = unitedSchemeEntity2;
                        unitedSchemeEntity4.result = jSONObject;
                        jVar.onNext(unitedSchemeEntity4);
                        if (optInt == 0) {
                            jVar.onNext(new Object());
                        }
                        jVar.onCompleted();
                    }
                });
            }
        });
    }

    private void doUBCForOutsideAndInside(UnitedSchemeEntity unitedSchemeEntity, int i) {
        if (unitedSchemeEntity == null || unitedSchemeEntity.getUri() == null) {
            return;
        }
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
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        SchemeRuntime.getSchemeIoc().doStatistic(UBC_INSIDE_INVOKE_TO_TAYGET_ID, jSONObject.toString());
        if (TextUtils.equals(unitedSchemeEntity.getSource(), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE)) {
            return;
        }
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("scheme", unitedSchemeEntity.getUri().toString());
            jSONObject3.put("errorcode", i);
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        SchemeRuntime.getSchemeIoc().doStatistic(UBC_OUTER_INVOKE_TO_TAYGET_ID, jSONObject3.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doUBCForSchemeList(LinkedList<JSONObject> linkedList, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            int size = linkedList.size();
            int i = -1;
            for (int i2 = 0; i2 < size; i2++) {
                if (linkedList.get(i2).optInt("status", -1) == 0) {
                    i = i2;
                }
            }
            if (jSONObject != null) {
                if (jSONObject.has("page")) {
                    JSONArray optJSONArray = jSONObject.optJSONArray("page");
                    if (i >= 0 && optJSONArray != null && optJSONArray.length() > i) {
                        jSONObject2.put("page", optJSONArray.get(i));
                    } else {
                        jSONObject2.put("page", "");
                    }
                }
                if (jSONObject.has("from")) {
                    jSONObject2.put("from", jSONObject.get("from"));
                }
                if (jSONObject.has("nid")) {
                    String string = jSONObject.getString("nid");
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("nid", string);
                    jSONObject2.put("ext", jSONObject3);
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        SchemeRuntime.getSchemeIoc().doStatistic(UBC_INVOKE_SCHEME_LIST, jSONObject2.toString());
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

    public boolean dispatchList(Context context, UnitedSchemeEntity unitedSchemeEntity, JSONArray jSONArray, JSONObject jSONObject, CallbackHandler callbackHandler) {
        LinkedList linkedList = new LinkedList();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            try {
                linkedList.offer(jSONArray.getString(i));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return dispatchList(context, unitedSchemeEntity, linkedList, jSONObject, callbackHandler);
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
        } catch (Exception unused) {
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
                doUBCForOutsideAndInside(unitedSchemeEntity, jSONObject.optInt("status", -1));
            } else {
                doUBCForOutsideAndInside(unitedSchemeEntity, 0);
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
                    doUBCForOutsideAndInside(unitedSchemeEntity, optInt);
                    if (optInt != 0) {
                        UnitedSchemeUtility.callCallback(callbackHandler, m14clone, m14clone.result);
                    }
                    unitedSchemeEntity.result = m14clone.result;
                    return dispatch;
                }
            } else if (dispatch) {
                doUBCForOutsideAndInside(unitedSchemeEntity, dispatch ? 0 : -2);
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
            doUBCForOutsideAndInside(unitedSchemeEntity, dispatch2 ? 0 : -2);
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
            doUBCForOutsideAndInside(unitedSchemeEntity, optInt2);
            if (optInt2 > 0) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, selectResult);
            }
        } else {
            doUBCForOutsideAndInside(unitedSchemeEntity, dispatch2 ? 0 : -2);
        }
        unitedSchemeEntity.result = selectResult;
        return dispatch2;
    }

    public boolean dispatchList(final Context context, final UnitedSchemeEntity unitedSchemeEntity, List<String> list, final JSONObject jSONObject, final CallbackHandler callbackHandler) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        final LinkedList linkedList = new LinkedList();
        d.i(list).b(new f<String, d<Object>>() { // from class: com.baidu.searchbox.unitedscheme.UnitedSchemeMainDispatcher.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // h.n.f
            public d<Object> call(String str) {
                return UnitedSchemeMainDispatcher.this.createSchemeDispatchObservable(context, unitedSchemeEntity, str, callbackHandler);
            }
        }).G(new f<Object, Boolean>() { // from class: com.baidu.searchbox.unitedscheme.UnitedSchemeMainDispatcher.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // h.n.f
            public Boolean call(Object obj) {
                return Boolean.valueOf(obj instanceof UnitedSchemeEntity);
            }
        }).A(new e<Object>() { // from class: com.baidu.searchbox.unitedscheme.UnitedSchemeMainDispatcher.1
            @Override // h.e
            public void onCompleted() {
                if (linkedList.isEmpty()) {
                    return;
                }
                UnitedSchemeMainDispatcher.this.doUBCForSchemeList(linkedList, jSONObject);
            }

            @Override // h.e
            public void onError(Throwable th) {
            }

            @Override // h.e
            public void onNext(Object obj) {
                JSONObject jSONObject2 = ((UnitedSchemeEntity) obj).result;
                if (jSONObject2 != null) {
                    linkedList.add(jSONObject2);
                }
            }
        });
        return true;
    }
}

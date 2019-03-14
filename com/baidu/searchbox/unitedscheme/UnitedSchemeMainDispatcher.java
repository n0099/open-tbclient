package com.baidu.searchbox.unitedscheme;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeInterceptChain;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import rx.d;
import rx.e;
import rx.functions.f;
import rx.j;
/* loaded from: classes2.dex */
public class UnitedSchemeMainDispatcher extends UnitedSchemeBaseDispatcher {
    public static final String CONTENT_KEY_EXT = "ext";
    public static final String CONTENT_KEY_FROM = "from";
    public static final String CONTENT_KEY_PAGE = "page";
    private static final boolean DEBUG = false;
    private static final String DISPATCHER_DEFAULT_CALLBACK = "dispatcher_default_callback";
    private static final String KEY_CALLBACK = "callback";
    private static final String KEY_NID = "nid";
    public static final String UBC_INVOKE_SCHEME_LIST = "798";
    public static final String UBC_OUTER_INVOKE_TO_TAYGET_ID = "138";
    private HashMap<String, UnitedSchemeBaseDispatcher> mDynamicDispatchers = new HashMap<>();
    private static final String TAG = UnitedSchemeMainDispatcher.class.getSimpleName();
    private static UnitedSchemeInterceptChain sInterceptChain = new UnitedSchemeInterceptChain();
    private static HashMap<String, Class<? extends UnitedSchemeBaseDispatcher>> sSubDispatchers = new HashMap<>();

    static {
        SchemeRuntime.getSchemeContext().addInterceptor(sInterceptChain);
        SchemeRuntime.getSchemeContext().addDispatcher(sSubDispatchers);
    }

    public void setDynamicDispatcher(String str, UnitedSchemeBaseDispatcher unitedSchemeBaseDispatcher) {
        if (!TextUtils.isEmpty(str) && unitedSchemeBaseDispatcher != null) {
            this.mDynamicDispatchers.put(str, unitedSchemeBaseDispatcher);
        }
    }

    public void removeDynamicDispatcher(String str) {
        if (!TextUtils.isEmpty(str) && this.mDynamicDispatchers.containsKey(str)) {
            this.mDynamicDispatchers.remove(str);
        }
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher, com.baidu.searchbox.unitedscheme.UnitedSchemeAbsDispatcher
    public boolean dispatch(Context context, UnitedSchemeEntity unitedSchemeEntity) {
        return dispatch(context, unitedSchemeEntity, null);
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher, com.baidu.searchbox.unitedscheme.UnitedSchemeAbsDispatcher
    public boolean dispatch(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        UnitedSchemeBaseDispatcher unitedSchemeBaseDispatcher;
        if (sInterceptChain.shouldInterceptDispatch(context, unitedSchemeEntity, callbackHandler)) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, unitedSchemeEntity.result);
            return true;
        } else if (!checkVersion(context, unitedSchemeEntity)) {
            doUBCForOutside(unitedSchemeEntity, 101);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(101);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, unitedSchemeEntity.result);
            return true;
        } else {
            UnitedSchemeEntity m13clone = unitedSchemeEntity.m13clone();
            String path = m13clone.getPath(true);
            if (!TextUtils.isEmpty(path) && (unitedSchemeBaseDispatcher = this.mDynamicDispatchers.get(path)) != null) {
                boolean dispatch = unitedSchemeBaseDispatcher.dispatch(context, m13clone, callbackHandler);
                if (m13clone.result != null) {
                    int optInt = m13clone.result.optInt("status", -1);
                    if (optInt != 301 && optInt != 302) {
                        doUBCForOutside(unitedSchemeEntity, optInt);
                        if (optInt != 0) {
                            UnitedSchemeUtility.callCallback(callbackHandler, m13clone, m13clone.result);
                        }
                        unitedSchemeEntity.result = m13clone.result;
                        return dispatch;
                    }
                } else if (dispatch) {
                    doUBCForOutside(unitedSchemeEntity, dispatch ? 0 : -2);
                    return true;
                }
            }
            boolean dispatch2 = super.dispatch(context, unitedSchemeEntity, callbackHandler);
            JSONObject selectResult = selectResult(m13clone, unitedSchemeEntity);
            if (dispatch2 && unitedSchemeEntity.result == null) {
                doUBCForOutside(unitedSchemeEntity, dispatch2 ? 0 : -2);
            } else if (selectResult != null) {
                int optInt2 = selectResult.optInt("status", -1);
                doUBCForOutside(unitedSchemeEntity, optInt2);
                if (optInt2 > 0) {
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, selectResult);
                }
            } else {
                doUBCForOutside(unitedSchemeEntity, dispatch2 ? 0 : -2);
            }
            unitedSchemeEntity.result = selectResult;
            return dispatch2;
        }
    }

    public boolean dispatchList(Context context, UnitedSchemeEntity unitedSchemeEntity, JSONArray jSONArray, JSONObject jSONObject, CallbackHandler callbackHandler) {
        LinkedList linkedList = new LinkedList();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            try {
                linkedList.offer(jSONArray.getString(i));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return dispatchList(context, unitedSchemeEntity, linkedList, jSONObject, callbackHandler);
    }

    public boolean dispatchList(final Context context, final UnitedSchemeEntity unitedSchemeEntity, List<String> list, final JSONObject jSONObject, final CallbackHandler callbackHandler) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        final LinkedList linkedList = new LinkedList();
        d.g(list).a(new f<String, d<Object>>() { // from class: com.baidu.searchbox.unitedscheme.UnitedSchemeMainDispatcher.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            public d<Object> call(String str) {
                return UnitedSchemeMainDispatcher.this.createSchemeDispatchObservable(context, unitedSchemeEntity, str, callbackHandler);
            }
        }).e(new f<Object, Boolean>() { // from class: com.baidu.searchbox.unitedscheme.UnitedSchemeMainDispatcher.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // rx.functions.f
            public Boolean call(Object obj) {
                return Boolean.valueOf(obj instanceof UnitedSchemeEntity);
            }
        }).a(new e<Object>() { // from class: com.baidu.searchbox.unitedscheme.UnitedSchemeMainDispatcher.1
            @Override // rx.e
            public void onCompleted() {
                if (!linkedList.isEmpty()) {
                    UnitedSchemeMainDispatcher.this.doUBCForSchemeList(linkedList, jSONObject);
                }
            }

            @Override // rx.e
            public void onError(Throwable th) {
            }

            @Override // rx.e
            public void onNext(Object obj) {
                UnitedSchemeEntity unitedSchemeEntity2 = (UnitedSchemeEntity) obj;
                if (unitedSchemeEntity2.result != null) {
                    linkedList.add(unitedSchemeEntity2.result);
                }
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doUBCForSchemeList(LinkedList<JSONObject> linkedList, JSONObject jSONObject) {
        int i = -1;
        JSONObject jSONObject2 = new JSONObject();
        try {
            int size = linkedList.size();
            int i2 = 0;
            while (i2 < size) {
                int i3 = linkedList.get(i2).optInt("status", -1) == 0 ? i2 : i;
                i2++;
                i = i3;
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
                if (jSONObject.has(KEY_NID)) {
                    String string = jSONObject.getString(KEY_NID);
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put(KEY_NID, string);
                    jSONObject2.put("ext", jSONObject3);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        SchemeRuntime.getSchemeIoc().doStatistic(UBC_INVOKE_SCHEME_LIST, jSONObject2.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public d<Object> createSchemeDispatchObservable(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final String str, final CallbackHandler callbackHandler) {
        return d.a((d.a) new d.a<Object>() { // from class: com.baidu.searchbox.unitedscheme.UnitedSchemeMainDispatcher.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            public void call(final j<? super Object> jVar) {
                final UnitedSchemeEntity unitedSchemeEntity2 = new UnitedSchemeEntity(Uri.parse(str));
                if (unitedSchemeEntity != null) {
                    unitedSchemeEntity2.setReferUrl(unitedSchemeEntity.getReferUrl());
                    unitedSchemeEntity2.setPageUrl(unitedSchemeEntity.getPageUrl());
                }
                if (unitedSchemeEntity2.getParam(UnitedSchemeMainDispatcher.KEY_CALLBACK) == null) {
                    unitedSchemeEntity2.putParams(UnitedSchemeMainDispatcher.KEY_CALLBACK, UnitedSchemeMainDispatcher.DISPATCHER_DEFAULT_CALLBACK);
                }
                UnitedSchemeMainDispatcher.this.dispatch(context, unitedSchemeEntity2, new CallbackHandler() { // from class: com.baidu.searchbox.unitedscheme.UnitedSchemeMainDispatcher.4.1
                    @Override // com.baidu.searchbox.unitedscheme.CallbackHandler
                    public void handleSchemeDispatchCallback(String str2, String str3) {
                        JSONObject jSONObject;
                        if (TextUtils.isEmpty(str3)) {
                            jSONObject = new JSONObject();
                        } else {
                            try {
                                jSONObject = new JSONObject(str3);
                            } catch (JSONException e) {
                                jSONObject = new JSONObject();
                            }
                        }
                        int optInt = jSONObject.optInt("status", -1);
                        if (!TextUtils.equals(str2, UnitedSchemeMainDispatcher.DISPATCHER_DEFAULT_CALLBACK)) {
                            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity2, jSONObject);
                        }
                        unitedSchemeEntity2.result = jSONObject;
                        jVar.onNext(unitedSchemeEntity2);
                        if (optInt == 0) {
                            jVar.onNext(new Object());
                        }
                        jVar.onCompleted();
                    }

                    @Override // com.baidu.searchbox.unitedscheme.CallbackHandler
                    public String getCurrentPageUrl() {
                        if (callbackHandler == null) {
                            return null;
                        }
                        return callbackHandler.getCurrentPageUrl();
                    }
                });
            }
        });
    }

    private JSONObject selectResult(UnitedSchemeEntity unitedSchemeEntity, UnitedSchemeEntity unitedSchemeEntity2) {
        if (unitedSchemeEntity.result == null) {
            return unitedSchemeEntity2.result;
        }
        if (unitedSchemeEntity2.result == null) {
            return unitedSchemeEntity.result;
        }
        if (unitedSchemeEntity.result.optInt("status", -1) == 302 && unitedSchemeEntity2.result.optInt("status", -1) == 301) {
            return unitedSchemeEntity.result;
        }
        return unitedSchemeEntity2.result;
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

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public boolean checkPermission(Context context, UnitedSchemeEntity unitedSchemeEntity) {
        return super.checkPermission(context, unitedSchemeEntity);
    }

    private boolean checkVersion(Context context, UnitedSchemeEntity unitedSchemeEntity) {
        if (unitedSchemeEntity == null) {
            return false;
        }
        Uri uri = unitedSchemeEntity.getUri();
        int version = UnitedSchemeUtility.getVersion(uri);
        if (version < 0) {
            if (unitedSchemeEntity.isOnlyVerify()) {
                return false;
            }
            UnitedSchemeStatisticUtil.doUBCForInvalidScheme(uri, "invalid version");
            return false;
        } else if (version > 41) {
            if (!TextUtils.equals(unitedSchemeEntity.removeParam(UnitedSchemeConstants.UNITED_SCHEME_UPGRADE), "1") || unitedSchemeEntity.isOnlyVerify()) {
                return false;
            }
            SchemeRuntime.getSchemeContext().showSchemeNotSupportDialog(context);
            UnitedSchemeStatisticUtil.doUBCForUpdateDialog(uri, 41);
            return false;
        } else {
            return true;
        }
    }

    private void doUBCForOutside(UnitedSchemeEntity unitedSchemeEntity, int i) {
        if (unitedSchemeEntity != null && unitedSchemeEntity.getUri() != null && !TextUtils.equals(unitedSchemeEntity.getSource(), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("scheme", unitedSchemeEntity.getUri().toString());
                jSONObject.put("errorcode", i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            SchemeRuntime.getSchemeIoc().doStatistic(UBC_OUTER_INVOKE_TO_TAYGET_ID, jSONObject.toString());
        }
    }
}

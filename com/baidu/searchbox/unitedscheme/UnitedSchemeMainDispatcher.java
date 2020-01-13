package com.baidu.searchbox.unitedscheme;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.suspensionball.SuspensionBallEntity;
import com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor;
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
/* loaded from: classes10.dex */
public class UnitedSchemeMainDispatcher extends UnitedSchemeBaseDispatcher {
    public static final String CONTENT_KEY_EXT = "ext";
    public static final String CONTENT_KEY_FROM = "from";
    public static final String CONTENT_KEY_PAGE = "page";
    private static final String DISPATCHER_DEFAULT_CALLBACK = "dispatcher_default_callback";
    private static final String KEY_CALLBACK = "callback";
    private static final String KEY_NID = "nid";
    public static final String UBC_INVOKE_SCHEME_LIST = "798";
    public static final String UBC_OUTER_INVOKE_TO_TAYGET_ID = "138";
    private HashMap<String, UnitedSchemeBaseDispatcher> mDynamicDispatchers = new HashMap<>();
    private static final boolean DEBUG = UnitedSchemeConstants.DEBUG;
    private static final String TAG = UnitedSchemeMainDispatcher.class.getSimpleName();
    private static UnitedSchemeInterceptChain sInterceptChain = new UnitedSchemeInterceptChain();
    private static HashMap<String, Class<? extends UnitedSchemeBaseDispatcher>> sSubDispatchers = new HashMap<>();
    private static HashMap<String, String> redirectSchemes = new HashMap<>();

    /* JADX DEBUG: Multi-variable search result rejected for r3v2, resolved type: java.util.HashMap<java.lang.String, java.lang.Class<? extends com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher>> */
    /* JADX WARN: Multi-variable type inference failed */
    public UnitedSchemeMainDispatcher() {
        UnitedSchemeRuntime unitedSchemeRuntime = new UnitedSchemeRuntime();
        sSubDispatchers.clear();
        sInterceptChain.clearChain();
        redirectSchemes.clear();
        for (UnitedSchemeBaseDispatcher unitedSchemeBaseDispatcher : unitedSchemeRuntime.sSubDispatchersList.getList()) {
            if (sSubDispatchers.get(unitedSchemeBaseDispatcher.getDispatcherName()) == null) {
                sSubDispatchers.put(unitedSchemeBaseDispatcher.getDispatcherName(), unitedSchemeBaseDispatcher.getClass());
                unitedSchemeBaseDispatcher.addRedirectScheme(redirectSchemes);
            } else if (DEBUG) {
                throw new IllegalArgumentException("duplicate schemeDispatcher name:" + unitedSchemeBaseDispatcher.getDispatcherName());
            }
        }
        for (UnitedSchemeBaseInterceptor unitedSchemeBaseInterceptor : unitedSchemeRuntime.sInterceptChainList.getList()) {
            sInterceptChain.addInterceptor(unitedSchemeBaseInterceptor);
        }
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

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public String getDispatcherName() {
        return UnitedSchemeBaseDispatcher.DISPATCHER_NOT_FIRST_LEVEL;
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher, com.baidu.searchbox.unitedscheme.UnitedSchemeAbsDispatcher
    public boolean dispatch(Context context, UnitedSchemeEntity unitedSchemeEntity) {
        return dispatch(context, unitedSchemeEntity, null);
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher, com.baidu.searchbox.unitedscheme.UnitedSchemeAbsDispatcher
    public boolean dispatch(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        UnitedSchemeEntity unitedSchemeEntity2;
        UnitedSchemeBaseDispatcher unitedSchemeBaseDispatcher;
        if (unitedSchemeEntity.getParam(UnitedSchemeConstants.UNITED_SCHEME_SENIOR) == null) {
            unitedSchemeEntity2 = null;
        } else {
            String param = unitedSchemeEntity.getParam(UnitedSchemeConstants.UNITED_SCHEME_SENIOR);
            UnitedSchemeEntity m20clone = unitedSchemeEntity.m20clone();
            m20clone.removeParam(UnitedSchemeConstants.UNITED_SCHEME_SENIOR);
            unitedSchemeEntity = new UnitedSchemeEntity(Uri.parse(param), unitedSchemeEntity.getSource());
            unitedSchemeEntity2 = m20clone;
        }
        String allPath = unitedSchemeEntity.getAllPath();
        if (redirectSchemes.get(allPath) != null) {
            unitedSchemeEntity.replaceAllPath(allPath, redirectSchemes.get(allPath));
        }
        if (sInterceptChain.shouldInterceptDispatch(context, unitedSchemeEntity, callbackHandler)) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, unitedSchemeEntity.result);
            if (unitedSchemeEntity.result != null) {
                doUBCForOutside(unitedSchemeEntity, unitedSchemeEntity.result.optInt("status", -1));
            } else {
                doUBCForOutside(unitedSchemeEntity, 0);
            }
            return true;
        }
        UnitedSchemeEntity m20clone2 = unitedSchemeEntity.m20clone();
        String path = m20clone2.getPath(true);
        if (!TextUtils.isEmpty(path) && (unitedSchemeBaseDispatcher = this.mDynamicDispatchers.get(path)) != null) {
            boolean dispatch = unitedSchemeBaseDispatcher.dispatch(context, m20clone2, callbackHandler);
            if (m20clone2.result != null) {
                int optInt = m20clone2.result.optInt("status", -1);
                if (optInt != 301 && optInt != 302) {
                    doUBCForOutside(unitedSchemeEntity, optInt);
                    if (optInt != 0) {
                        UnitedSchemeUtility.callCallback(callbackHandler, m20clone2, m20clone2.result);
                    }
                    unitedSchemeEntity.result = m20clone2.result;
                    return dispatch;
                }
            } else if (dispatch) {
                doUBCForOutside(unitedSchemeEntity, dispatch ? 0 : -2);
                return true;
            }
        }
        boolean dispatch2 = super.dispatch(context, unitedSchemeEntity, callbackHandler);
        if (!dispatch2 && unitedSchemeEntity.getParam(UnitedSchemeConstants.UNITED_SCHEME_BACKUP) != null) {
            unitedSchemeEntity = new UnitedSchemeEntity(Uri.parse(unitedSchemeEntity.getParam(UnitedSchemeConstants.UNITED_SCHEME_BACKUP)), m20clone2.getSource());
            dispatch2 = dispatch(context, unitedSchemeEntity, callbackHandler);
        }
        JSONObject selectResult = selectResult(m20clone2, unitedSchemeEntity);
        if (dispatch2 && unitedSchemeEntity.result == null) {
            doUBCForOutside(unitedSchemeEntity, dispatch2 ? 0 : -2);
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
        d.l(list).a(new f<String, d<Object>>() { // from class: com.baidu.searchbox.unitedscheme.UnitedSchemeMainDispatcher.3
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
                if (jSONObject.has("nid")) {
                    String string = jSONObject.getString("nid");
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("nid", string);
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
                if (unitedSchemeEntity2.getParam("callback") == null) {
                    unitedSchemeEntity2.putParams("callback", UnitedSchemeMainDispatcher.DISPATCHER_DEFAULT_CALLBACK);
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
                                if (UnitedSchemeMainDispatcher.DEBUG) {
                                    Log.w(UnitedSchemeMainDispatcher.TAG, "JSONObject parsed error!!", e);
                                }
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

    private void showUpdateDialog(Context context, UnitedSchemeEntity unitedSchemeEntity) {
        Uri uri = unitedSchemeEntity.getUri();
        if (TextUtils.equals(unitedSchemeEntity.removeParam(UnitedSchemeConstants.UNITED_SCHEME_UPGRADE), "1") && !unitedSchemeEntity.isOnlyVerify()) {
            SchemeRuntime.getSchemeIoc().showSchemeNotSupportDialog(context);
            UnitedSchemeStatisticUtil.doUBCForUpdateDialog(uri);
        }
    }

    private void doUBCForOutside(UnitedSchemeEntity unitedSchemeEntity, int i) {
        if (unitedSchemeEntity != null && unitedSchemeEntity.getUri() != null && !TextUtils.equals(unitedSchemeEntity.getSource(), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(SuspensionBallEntity.KEY_SCHEME, unitedSchemeEntity.getUri().toString());
                jSONObject.put("errorcode", i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            SchemeRuntime.getSchemeIoc().doStatistic(UBC_OUTER_INVOKE_TO_TAYGET_ID, jSONObject.toString());
        }
    }
}

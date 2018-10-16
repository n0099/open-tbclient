package com.baidu.searchbox.ng.ai.apps.scheme;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.searchbox.ng.ai.apps.R;
import com.baidu.searchbox.ng.ai.apps.core.turbo.AiAppsCoreRuntime;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsController;
import com.baidu.searchbox.ng.ai.apps.network.AiAppNetworkUtils;
import com.baidu.searchbox.ng.ai.apps.res.ui.BdMultiPicker;
import com.baidu.searchbox.ng.ai.apps.res.widget.dialog.AiAppAlertDialog;
import com.baidu.searchbox.ng.ai.apps.res.widget.dialog.DatePickerDialog;
import com.baidu.searchbox.ng.ai.apps.res.widget.dialog.MultiPickerDialog;
import com.baidu.searchbox.ng.ai.apps.res.widget.dialog.TimePickerDialog;
import com.baidu.searchbox.ng.ai.apps.res.widget.floatlayer.FloatLayer;
import com.baidu.searchbox.ng.ai.apps.res.widget.loadingview.LoadingView;
import com.baidu.searchbox.ng.ai.apps.res.widget.toast.UniversalToast;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.runtime.config.WindowConfig;
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
import com.baidu.searchbox.ng.ai.apps.storage.PathType;
import com.baidu.searchbox.ng.ai.apps.storage.StorageUtil;
import com.baidu.searchbox.ng.ai.apps.swancore.AiAppsSwanCoreManager;
import com.baidu.searchbox.ng.ai.apps.textarea.info.TextAreaCallbackInfo;
import com.baidu.searchbox.ng.ai.apps.util.AiAppActivityUtils;
import com.baidu.searchbox.ng.ai.apps.util.AiAppDateTimeUtil;
import com.baidu.searchbox.ng.ai.apps.util.AiAppWrappedClipboardManager;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUIUtils;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUtils;
import com.baidu.searchbox.ng.ai.apps.view.decorate.AiAppsDialogDecorate;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeAbsDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.UnitedSchemeStatisticUtil;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.webkit.sdk.WebView;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes2.dex */
public class AiAppUnitedSchemeUtilsDispatcher extends UnitedSchemeBaseDispatcher {
    private static final String ACTION_DISMISS_TOAST = "dismissToast";
    private static final String ACTION_GET_CLIPBOARD_DATA = "getClipboardData";
    private static final String ACTION_GET_COMMON_SYS_INFO_SYNC = "getCommonSysInfoSync";
    private static final String ACTION_GET_NET_TYPE = "getNetworkType";
    private static final String ACTION_GET_SYSTEM_INFO = "getSystemInfo";
    private static final String ACTION_GET_SYSTEM_INFO_SYNC = "getSystemInfoSync";
    private static final String ACTION_HIDE_LOADING = "hideLoading";
    private static final String ACTION_MAKE_PHONE_CALL = "makePhoneCall";
    private static final String ACTION_OPEN_MULTI_PICKER = "openMultiPicker";
    private static final String ACTION_OPEN_PICKER = "openPicker";
    private static final String ACTION_PREVIEW_IMAGE = "previewImage";
    private static final String ACTION_SET_CLIPBOARD_DATA = "setClipboardData";
    private static final String ACTION_SHOW_ACTION_SHEET = "showActionSheet";
    private static final String ACTION_SHOW_DATE_PICKER = "showDatePickerView";
    private static final String ACTION_SHOW_LOADING = "showLoading";
    private static final String ACTION_SHOW_MODAL = "showModal";
    private static final String ACTION_SHOW_TOAST = "showToast";
    private static final String ACTION_UPDATE_MULTI_PICKER = "updateMultiPicker";
    private static final boolean DEBUG = false;
    public static final String MODULE_UTILS = "utils";
    private static final String PARAMS_CALLBACK = "callback";
    private static final String PARAMS_DEFAULT_VALUE_SOURCE = "unitedscheme";
    private static final String PARAMS_KEY = "params";
    private static final String PARAMS_KEY_CURRENT = "current";
    private static final String PARAMS_KEY_DISABLED = "disabled";
    private static final String PARAMS_KEY_END = "end";
    private static final String PARAMS_KEY_FIELDS = "fields";
    private static final String PARAMS_KEY_FROM = "from";
    public static final String PARAMS_KEY_IMG_ITEMS = "img_items";
    private static final String PARAMS_KEY_INDEX = "index";
    private static final String PARAMS_KEY_MODE = "mode";
    private static final String PARAMS_KEY_SOURCE = "source";
    private static final String PARAMS_KEY_START = "start";
    private static final String PARAMS_KEY_TYPE = "type";
    private static final String PARAMS_KEY_URL = "url";
    private static final String PARAMS_KEY_URLS = "urls";
    private static final String PARAMS_SUB_CALLBACK = "cb";
    private static final String PARAMS_VALUE_DATA_TYPE_0 = "0";
    private static final String PARAMS_VALUE_DATA_TYPE_1 = "1";
    private static final String PARAMS_VALUE_DATE = "date";
    private static final String PARAMS_VALUE_SOURCE_SWAN = "swan";
    private static final String PARAMS_VALUE_TIME = "time";
    public static final String PARAM_BOTTOM_ICON_STYLE_KEY = "bottomIconStyle";
    public static final String PARAM_BOTTOM_SHOW_ANIMATION_TYPE_KEY = "bottomShowAnimationType";
    public static final String PARAM_TOAST_BUTTON_CALLBACK_KEY = "clickCallback";
    public static final String PARAM_TOAST_BUTTON_TEXT_KEY = "buttonText";
    public static final String PARAM_TOAST_CLICKABLE_STYLE = "style";
    public static final String PARAM_TOAST_ICON_KEY = "icon";
    public static final String PARAM_TOAST_IMAGE_KEY = "image";
    public static final String PARAM_TOAST_LEFT_BUTTON_TEXT_KEY = "leftButtonText";
    public static final String PARAM_TOAST_MESSAGE_KEY = "message";
    public static final String PARAM_TOAST_PARAM_KEY = "params";
    public static final String PARAM_TOAST_RIGHT_ICON_KEY = "righticon";
    public static final String PARAM_TOAST_TIME_KEY = "time";
    public static final String PARAM_TOAST_TITLE_KEY = "title";
    public static final String PARAM_TOAST_TYPE_KEY = "type";
    private static final String TAG = "AiAppUnitedSchemeUtilsDispatcher";
    public static final String TOAST_BOTTOM_SHOW_ANIM_FADE_IN = "1";
    public static final String TOAST_BOTTOM_SHOW_ANIM_SHIFT_UP = "2";
    public static final String TOAST_BUTTON_STYLE_BG_TEXT = "2";
    public static final String TOAST_BUTTON_STYLE_BG_TEXT_10_2 = "3";
    public static final String TOAST_BUTTON_STYLE_LINE_TEXT_ICON = "1";
    public static final String TOAST_ICON_STYLE_RECT = "2";
    public static final String TOAST_ICON_STYLE_ROUND = "1";
    public static final String TOAST_TYPE_CLICKABLE = "3";
    public static final String TOAST_TYPE_CLICKABLE_DOUBLE_BTN = "4";
    public static final String TOAST_TYPE_HIGHLIGHT = "2";
    public static final String TOAST_TYPE_NORMAL = "1";
    private static final String VALUE_KEY = "value";
    private static final String VALUE_KEY_ARRAY = "array";
    private static final String VALUE_KEY_COLUMN = "column";
    private static final String VALUE_KEY_CURRENT = "current";
    private static final String VALUE_KEY_TITLE = "title";
    private static AiAppAlertDialog mMultiPickerDialog;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0050, code lost:
        if (r3.equals(com.baidu.searchbox.ng.ai.apps.scheme.AiAppUnitedSchemeUtilsDispatcher.ACTION_GET_COMMON_SYS_INFO_SYNC) != false) goto L16;
     */
    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean invoke(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        char c = 0;
        String path = unitedSchemeEntity.getPath(false);
        if (TextUtils.isEmpty(path)) {
            if (!unitedSchemeEntity.isOnlyVerify()) {
                UnitedSchemeStatisticUtil.doUBCForInvalidScheme(unitedSchemeEntity.getUri(), "no action");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        } else if (unitedSchemeEntity.isOnlyVerify()) {
            return true;
        } else {
            UnitedSchemeStatisticUtil.doUBCForSchemeInvoke(unitedSchemeEntity.getSource(), unitedSchemeEntity.getUri());
            switch (path.hashCode()) {
                case -1920105040:
                    if (path.equals(ACTION_SHOW_MODAL)) {
                        c = 11;
                        break;
                    }
                    c = 65535;
                    break;
                case -1913642710:
                    if (path.equals(ACTION_SHOW_TOAST)) {
                        c = 14;
                        break;
                    }
                    c = 65535;
                    break;
                case -1641549650:
                    if (path.equals(ACTION_GET_SYSTEM_INFO_SYNC)) {
                        c = '\b';
                        break;
                    }
                    c = 65535;
                    break;
                case -1496218978:
                    if (path.equals(ACTION_UPDATE_MULTI_PICKER)) {
                        c = 17;
                        break;
                    }
                    c = 65535;
                    break;
                case -1383206285:
                    if (path.equals(ACTION_PREVIEW_IMAGE)) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case -886619478:
                    if (path.equals(ACTION_GET_CLIPBOARD_DATA)) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case -550543988:
                    if (path.equals(ACTION_SHOW_ACTION_SHEET)) {
                        c = '\f';
                        break;
                    }
                    c = 65535;
                    break;
                case -533453131:
                    break;
                case 216239514:
                    if (path.equals(ACTION_HIDE_LOADING)) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 252099448:
                    if (path.equals(ACTION_OPEN_PICKER)) {
                        c = 15;
                        break;
                    }
                    c = 65535;
                    break;
                case 344806259:
                    if (path.equals(ACTION_GET_SYSTEM_INFO)) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                case 422312381:
                    if (path.equals(ACTION_DISMISS_TOAST)) {
                        c = '\r';
                        break;
                    }
                    c = 65535;
                    break;
                case 724809599:
                    if (path.equals(ACTION_SHOW_LOADING)) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 1321118366:
                    if (path.equals(ACTION_MAKE_PHONE_CALL)) {
                        c = '\t';
                        break;
                    }
                    c = 65535;
                    break;
                case 1576904990:
                    if (path.equals(ACTION_SET_CLIPBOARD_DATA)) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 1630368510:
                    if (path.equals(ACTION_SHOW_DATE_PICKER)) {
                        c = '\n';
                        break;
                    }
                    c = 65535;
                    break;
                case 1714085202:
                    if (path.equals(ACTION_GET_NET_TYPE)) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case 2103167613:
                    if (path.equals(ACTION_OPEN_MULTI_PICKER)) {
                        c = 16;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    return handleGetCommonSysInfoSync(context, unitedSchemeEntity, callbackHandler);
                case 1:
                    return handleShowLoading(context, unitedSchemeEntity, callbackHandler);
                case 2:
                    return handleHideLoading(context, unitedSchemeEntity, callbackHandler);
                case 3:
                    return handlePreviewImage(context, unitedSchemeEntity, callbackHandler);
                case 4:
                    return handleSetClipboardData(context, unitedSchemeEntity, callbackHandler);
                case 5:
                    return handleGetClipboardData(context, unitedSchemeEntity, callbackHandler);
                case 6:
                    return handleGetNetworkType(context, unitedSchemeEntity, callbackHandler);
                case 7:
                    return handleGetSystemInfo(context, unitedSchemeEntity, callbackHandler);
                case '\b':
                    return handleGetSystemInfoSync(context, unitedSchemeEntity, callbackHandler);
                case '\t':
                    return handleMakePhoneCall(context, unitedSchemeEntity, callbackHandler);
                case '\n':
                    return handleShowDatePicker(context, unitedSchemeEntity, callbackHandler);
                case 11:
                    return handleShowModal(context, unitedSchemeEntity, callbackHandler);
                case '\f':
                    return handleShowActionSheet(context, unitedSchemeEntity, callbackHandler);
                case '\r':
                    return handleDismissToast(context, unitedSchemeEntity, callbackHandler);
                case 14:
                    return handleShowToast(context, unitedSchemeEntity, callbackHandler);
                case 15:
                    return handleOpenSinglePicker(context, unitedSchemeEntity, callbackHandler);
                case 16:
                    return handleOpenMultiPicker(context, unitedSchemeEntity, callbackHandler);
                case 17:
                    return handleUpdateMultiPicker(context, unitedSchemeEntity, callbackHandler);
                default:
                    return handleUnknownAction(context, unitedSchemeEntity, callbackHandler);
            }
        }
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public Class<? extends UnitedSchemeAbsDispatcher> getSubDispatcher(String str) {
        return null;
    }

    private boolean handleGetCommonSysInfoSync(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        if (unitedSchemeEntity == null) {
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("imei", AiAppsRuntime.getAiAppAccountRuntime().getIMEI());
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
            return true;
        } catch (JSONException e) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "exec fail");
            return false;
        }
    }

    private boolean handleShowLoading(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        LoadingView loadingView;
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String optString = optParamsAsJo.optString("title");
        boolean optBoolean = optParamsAsJo.optBoolean("mask", false);
        if (!(context instanceof FloatLayer.Holder)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "context not support");
            return false;
        }
        FloatLayer floatLayer = ((FloatLayer.Holder) context).getFloatLayer();
        View view = floatLayer.getView();
        if (view instanceof LoadingView) {
            loadingView = (LoadingView) view;
        } else {
            loadingView = new LoadingView(context);
            floatLayer.show(loadingView);
        }
        if (!TextUtils.isEmpty(optString)) {
            loadingView.setMsg(optString);
        }
        floatLayer.setMask(optBoolean);
        unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    private boolean handleHideLoading(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        if (!(context instanceof FloatLayer.Holder)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "not support FloatLayer");
            return false;
        }
        FloatLayer floatLayer = ((FloatLayer.Holder) context).getFloatLayer();
        if (floatLayer.getView() instanceof LoadingView) {
            floatLayer.reset();
        }
        unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    private boolean handlePreviewImage(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        JSONArray optJSONArray;
        String param = unitedSchemeEntity.getParam("params");
        if (TextUtils.isEmpty(param)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(param);
            JSONObject jSONObject2 = new JSONObject();
            String optString = jSONObject.optString("source", PARAMS_DEFAULT_VALUE_SOURCE);
            String optString2 = jSONObject.optString("from");
            jSONObject2.put("source", optString);
            jSONObject2.put("from", optString2);
            String optString3 = jSONObject.optString("type", "0");
            char c = 65535;
            switch (optString3.hashCode()) {
                case 49:
                    if (optString3.equals("1")) {
                        c = 0;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    optJSONArray = jSONObject.optJSONArray(PARAMS_KEY_IMG_ITEMS);
                    if (optJSONArray == null || optJSONArray.length() == 0) {
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                        return false;
                    }
                    jSONObject2.put(PARAMS_KEY_IMG_ITEMS, optJSONArray);
                    break;
                    break;
                default:
                    optJSONArray = jSONObject.optJSONArray(PARAMS_KEY_URLS);
                    if (optJSONArray == null || optJSONArray.length() == 0) {
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                        return false;
                    }
                    if (TextUtils.equals(optString, "swan")) {
                        optJSONArray = handleSwanImgPreviewPath(optJSONArray);
                    }
                    jSONObject2.put("url", optJSONArray);
                    break;
            }
            jSONObject2.put("type", optString3);
            int indexForPreViewImage = getIndexForPreViewImage(jSONObject, optJSONArray);
            if (indexForPreViewImage < 0 || indexForPreViewImage >= optJSONArray.length()) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            jSONObject2.put("index", String.valueOf(indexForPreViewImage));
            AiAppsRuntime.getImageRuntime().launchPictureBrowser(context, jSONObject2);
            unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        } catch (JSONException e) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
    }

    private JSONArray handleSwanImgPreviewPath(JSONArray jSONArray) {
        AiApp aiApp;
        if (jSONArray != null && jSONArray.length() > 0 && (aiApp = AiApp.get()) != null && !TextUtils.isEmpty(aiApp.id) && !TextUtils.isEmpty(aiApp.getVersion())) {
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    String string = jSONArray.getString(i);
                    PathType pathType = StorageUtil.getPathType(string);
                    if (pathType == PathType.BD_FILE) {
                        string = StorageUtil.scheme2Path(string, aiApp.id);
                    } else if (pathType == PathType.RELATIVE) {
                        string = StorageUtil.relativeToPath(string, aiApp, aiApp.getVersion());
                    }
                    if (!TextUtils.isEmpty(string)) {
                        jSONArray.put(i, string);
                    }
                } catch (JSONException e) {
                }
            }
        }
        return jSONArray;
    }

    private int getIndexForPreViewImage(@NonNull JSONObject jSONObject, @NonNull JSONArray jSONArray) throws JSONException {
        int optInt = jSONObject.optInt("current", -1);
        if (optInt >= 0) {
            return optInt;
        }
        String optString = jSONObject.optString("current");
        if (TextUtils.isEmpty(optString)) {
            return 0;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            if (TextUtils.equals(optString, jSONArray.getString(i))) {
                return i;
            }
        }
        return 0;
    }

    private boolean handleSetClipboardData(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        if (unitedSchemeEntity == null) {
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty joParams");
            return false;
        }
        AiAppWrappedClipboardManager.newInstance(context).setText(optParamsAsJo.optString("data"));
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    private boolean handleGetClipboardData(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        if (unitedSchemeEntity == null) {
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("data", AiAppWrappedClipboardManager.newInstance(context).getText().toString());
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
            return true;
        } catch (JSONException e) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "JSONException");
            return false;
        }
    }

    private boolean handleGetNetworkType(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        if (unitedSchemeEntity == null) {
            return false;
        }
        String networkClass = AiAppNetworkUtils.getNetworkClass();
        if (TextUtils.isEmpty(networkClass)) {
            networkClass = "unknown";
        } else if (AiAppNetworkUtils.NETWORK_TYPE_CELL_UN_CONNECTED.equals(networkClass)) {
            networkClass = "none";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("networkType", networkClass);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
            return true;
        } catch (JSONException e) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
    }

    private boolean handleGetSystemInfo(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        if (unitedSchemeEntity == null) {
            return false;
        }
        JSONObject sysInfo = getSysInfo(context);
        if (sysInfo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty joData");
            return false;
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(sysInfo, 0));
        return true;
    }

    private JSONObject getSysInfo(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(WindowConfig.JSON_WINDOW_KEY);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        windowManager.getDefaultDisplay().getSize(new Point());
        windowManager.getDefaultDisplay().getRectSize(new Rect());
        Configuration configuration = context.getResources().getConfiguration();
        Pair<Integer, Integer> curWindowSafeSize = AiAppsController.getInstance().getCurWindowSafeSize();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("brand", Build.BOARD);
            jSONObject.put("model", Build.MODEL);
            jSONObject.put("pixelRatio", displayMetrics.density);
            jSONObject.put("screenWidth", AiAppsUIUtils.px2dp(AiAppsUIUtils.getDisplayWidth(context)));
            jSONObject.put("screenHeight", AiAppsUIUtils.px2dp(AiAppsUIUtils.getDisplayHeight(context)));
            jSONObject.put("windowWidth", (int) (((Integer) curWindowSafeSize.first).intValue() / displayMetrics.density));
            jSONObject.put("windowHeight", (int) (((Integer) curWindowSafeSize.second).intValue() / displayMetrics.density));
            jSONObject.put(IjkMediaMeta.IJKM_KEY_LANGUAGE, getLanguageTag(configuration));
            jSONObject.put("version", AiAppsUtils.getVersionName());
            jSONObject.put("system", "Android " + Build.VERSION.RELEASE);
            jSONObject.put("platform", HttpConstants.OS_TYPE_VALUE);
            jSONObject.put("fontSizeSetting", 1);
            jSONObject.put("SDKVersion", getSwanSDKVersion());
            String hostName = AiAppsRuntime.getConfigRuntime().getHostName();
            if (!TextUtils.isEmpty(hostName)) {
                jSONObject.put("host", hostName);
            }
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }

    private static String getLanguageTag(Configuration configuration) {
        if (Build.VERSION.SDK_INT < 21) {
            return configuration.locale.toString();
        }
        if (Build.VERSION.SDK_INT < 24) {
            return configuration.locale.toLanguageTag();
        }
        return configuration.getLocales().toLanguageTags();
    }

    private static String getSwanSDKVersion() {
        return AiAppsSwanCoreManager.getSwanCoreVersionString(AiAppsCoreRuntime.getInstance().getSwanCoreVersion());
    }

    private boolean handleGetSystemInfoSync(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        if (unitedSchemeEntity == null) {
            return false;
        }
        JSONObject sysInfo = getSysInfo(context);
        if (sysInfo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty joData");
            return false;
        }
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(sysInfo, 0);
        return true;
    }

    private boolean handleMakePhoneCall(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        if (unitedSchemeEntity == null) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.DIAL");
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo != null) {
            String optString = optParamsAsJo.optString("phoneNumber");
            if (!TextUtils.isEmpty(optString)) {
                intent.setData(Uri.parse(WebView.SCHEME_TEL + optString));
            }
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, AiAppActivityUtils.startActivitySafely(context, intent) ? 0 : 1001);
        return true;
    }

    private boolean handleShowDatePicker(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        String param = unitedSchemeEntity.getParam("params");
        if (TextUtils.isEmpty(param)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(param);
            String optString = jSONObject.optString(PARAMS_KEY_MODE);
            if (TextUtils.isEmpty(optString)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            char c = 65535;
            switch (optString.hashCode()) {
                case 3076014:
                    if (optString.equals(PARAMS_VALUE_DATE)) {
                        c = 1;
                        break;
                    }
                    break;
                case 3560141:
                    if (optString.equals("time")) {
                        c = 0;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    return handleTimePicker(context, unitedSchemeEntity, callbackHandler, jSONObject);
                case 1:
                    return handleDatePicker(context, unitedSchemeEntity, callbackHandler, jSONObject);
                default:
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
            }
        } catch (JSONException e) {
            e.printStackTrace();
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
    }

    private boolean handleTimePicker(Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, JSONObject jSONObject) {
        boolean optBoolean = jSONObject.optBoolean(PARAMS_KEY_DISABLED, false);
        String optString = jSONObject.optString("start");
        String optString2 = jSONObject.optString(PARAMS_KEY_END);
        String optString3 = jSONObject.optString("value");
        String optString4 = jSONObject.optString(PARAMS_KEY_FIELDS);
        if (TextUtils.isEmpty(optString)) {
            optString = "00:00";
        }
        if (TextUtils.isEmpty(optString2)) {
            optString2 = "23:59";
        }
        Date parseTime = parseTime(optString);
        Date parseTime2 = parseTime(optString2);
        Date parseTime3 = parseTime(optString3);
        if (parseTime == null || parseTime2 == null || parseTime2.before(parseTime) || parseTime3 == null || parseTime3.before(parseTime) || parseTime3.after(parseTime2)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        TimePickerDialog.Builder builder = new TimePickerDialog.Builder(context);
        if (!TextUtils.isEmpty(optString4)) {
            builder.fields(optString4);
        }
        builder.startDate(parseTime).endDate(parseTime2).selectedDate(parseTime3).disabled(optBoolean).setTitle(R.string.aiapps_picker_time_title).setPositiveButton(R.string.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.searchbox.ng.ai.apps.scheme.AiAppUnitedSchemeUtilsDispatcher.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                String format = String.format("%02d:%02d", Integer.valueOf(((TimePickerDialog) dialogInterface).getHour()), Integer.valueOf(((TimePickerDialog) dialogInterface).getMinute()));
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("value", format);
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject2, 0));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }).setNegativeButton(R.string.aiapps_cancel, new DialogInterface.OnClickListener() { // from class: com.baidu.searchbox.ng.ai.apps.scheme.AiAppUnitedSchemeUtilsDispatcher.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                dialogInterface.dismiss();
            }
        }).show();
        return true;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:26:0x0049 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:31:0x000c */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:32:0x0001 */
    private Date parseTime(String str) {
        Date date;
        NumberFormatException e;
        String[] split;
        Date date2 = null;
        date2 = null;
        date2 = null;
        try {
            if (TextUtils.isEmpty(str)) {
                date = new Date();
            } else if (!str.contains(":") || (split = str.split(":")) == null || split.length != 2) {
                date = null;
            } else {
                date = new Date();
                try {
                    int parseInt = Integer.parseInt(split[0]);
                    if (parseInt >= 0 && parseInt < 24) {
                        date.setHours(parseInt);
                    }
                    int parseInt2 = Integer.parseInt(split[1]);
                    date = date;
                    date2 = parseInt2;
                    if (parseInt2 >= 0) {
                        date = date;
                        date2 = parseInt2;
                        if (parseInt2 < 60) {
                            date.setMinutes(parseInt2);
                            date = date;
                            date2 = parseInt2;
                        }
                    }
                } catch (NumberFormatException e2) {
                    e = e2;
                    e.printStackTrace();
                    return date;
                }
            }
        } catch (NumberFormatException e3) {
            date = date2;
            e = e3;
        }
        return date;
    }

    private boolean handleDatePicker(Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, JSONObject jSONObject) {
        Date date;
        boolean optBoolean = jSONObject.optBoolean(PARAMS_KEY_DISABLED, false);
        String optString = jSONObject.optString("start");
        String optString2 = jSONObject.optString(PARAMS_KEY_END);
        String optString3 = jSONObject.optString("value");
        String optString4 = jSONObject.optString(PARAMS_KEY_FIELDS);
        if (TextUtils.isEmpty(optString)) {
            optString = "1900-01-01";
        }
        if (TextUtils.isEmpty(optString2)) {
            optString2 = "2099-12-31";
        }
        Date formatDate = AiAppDateTimeUtil.getFormatDate(optString, AiAppDateTimeUtil.DATE_FORMAT);
        Date formatDate2 = AiAppDateTimeUtil.getFormatDate(optString2, AiAppDateTimeUtil.DATE_FORMAT);
        if (formatDate == null || formatDate2 == null || formatDate2.before(formatDate)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        Date date2 = new Date();
        if (TextUtils.isEmpty(optString3) || (date = AiAppDateTimeUtil.getFormatDate(optString3, new String[]{AiAppDateTimeUtil.DATE_FORMAT, AiAppDateTimeUtil.MONTH_FORMAT, AiAppDateTimeUtil.YEAR_FORMAT})) == null) {
            date = date2;
        }
        if (date.before(formatDate)) {
            date = formatDate;
        } else if (date.after(formatDate2)) {
            date = formatDate2;
        }
        DatePickerDialog.Builder builder = new DatePickerDialog.Builder(context);
        if (!TextUtils.isEmpty(optString4)) {
            builder.fields(optString4);
        }
        builder.startDate(formatDate).endDate(formatDate2).selectedDate(date).disabled(optBoolean).setTitle(R.string.aiapps_picker_date_title).setPositiveButton(R.string.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.searchbox.ng.ai.apps.scheme.AiAppUnitedSchemeUtilsDispatcher.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                if (dialogInterface instanceof DatePickerDialog) {
                    String selectedDate = ((DatePickerDialog) dialogInterface).getSelectedDate();
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("value", selectedDate);
                        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject2, 0));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).setNegativeButton(R.string.aiapps_cancel, new DialogInterface.OnClickListener() { // from class: com.baidu.searchbox.ng.ai.apps.scheme.AiAppUnitedSchemeUtilsDispatcher.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                dialogInterface.dismiss();
            }
        }).show();
        return true;
    }

    private boolean handleShowModal(Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler) {
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            optParamsAsJo = new JSONObject();
        }
        String optString = optParamsAsJo.optString("confirmText");
        if (TextUtils.isEmpty(optString)) {
            optString = context.getString(R.string.aiapps_ok);
        }
        AiAppAlertDialog.Builder builder = new AiAppAlertDialog.Builder(context);
        builder.setTitle(optParamsAsJo.optString("title")).setMessage(optParamsAsJo.optString("content")).setDecorate(new AiAppsDialogDecorate()).setCancelable(false);
        if (optParamsAsJo.optBoolean("showCancel", true)) {
            builder.setNegativeTextColor(optParamsAsJo.optString("cancelColor"), R.color.aiapps_modal_cancel_color);
            String optString2 = optParamsAsJo.optString("cancelText");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = context.getString(R.string.aiapps_cancel);
            }
            builder.setNegativeButton(optString2, new DialogInterface.OnClickListener() { // from class: com.baidu.searchbox.ng.ai.apps.scheme.AiAppUnitedSchemeUtilsDispatcher.5
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("type", AiAppsUBCStatistic.VALUE_CANCEL);
                        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
                    } catch (JSONException e) {
                        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(201));
                    }
                }
            });
        }
        builder.setPositiveTextColor(optParamsAsJo.optString("confirmColor"), R.color.aiapps_modal_confirm_color);
        builder.setPositiveButton(optString, new DialogInterface.OnClickListener() { // from class: com.baidu.searchbox.ng.ai.apps.scheme.AiAppUnitedSchemeUtilsDispatcher.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("type", TextAreaCallbackInfo.EVENT_NAME_CONFIRM);
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
                } catch (JSONException e) {
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(201));
                }
            }
        });
        builder.show();
        return true;
    }

    private boolean handleShowActionSheet(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler) {
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        int i = -1;
        final ArrayList arrayList = new ArrayList();
        try {
            String optString = optParamsAsJo.optString("itemColor");
            if (!TextUtils.isEmpty(optString)) {
                i = Color.parseColor(optString);
            }
            JSONArray jSONArray = optParamsAsJo.getJSONArray("itemList");
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                String string = jSONArray.getString(i2);
                if (TextUtils.isEmpty(string)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                arrayList.add(string);
            }
            if (arrayList.isEmpty()) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            final int color = i < 0 ? context.getResources().getColor(R.color.aiapps_action_sheet_item_color) : i;
            AiAppAlertDialog.Builder onCancelListener = new AiAppAlertDialog.Builder(context).hideTitle(true).removeCustomPanelMargin(true).setBtnsVersible(false).setCancelable(true).setDecorate(new AiAppsDialogDecorate()).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.searchbox.ng.ai.apps.scheme.AiAppUnitedSchemeUtilsDispatcher.7
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(201, "showActionSheet:fail cancel"));
                }
            });
            View inflate = View.inflate(context, R.layout.aiapps_scheme_utils_show_action_sheet, null);
            ListView listView = (ListView) inflate.findViewById(R.id.list);
            listView.setAdapter((ListAdapter) new BaseAdapter() { // from class: com.baidu.searchbox.ng.ai.apps.scheme.AiAppUnitedSchemeUtilsDispatcher.8
                @Override // android.widget.Adapter
                public int getCount() {
                    return arrayList.size();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // android.widget.Adapter
                public String getItem(int i3) {
                    return (String) arrayList.get(i3);
                }

                @Override // android.widget.Adapter
                public long getItemId(int i3) {
                    return i3;
                }

                @Override // android.widget.Adapter
                public View getView(int i3, View view, ViewGroup viewGroup) {
                    if (view == null) {
                        view = View.inflate(context, R.layout.aiapps_scheme_utils_show_action_sheet_item, null);
                    }
                    TextView textView = (TextView) view.findViewById(R.id.text);
                    textView.setTextColor(color);
                    textView.setText(getItem(i3));
                    return view;
                }
            });
            onCancelListener.setView(inflate);
            final AiAppAlertDialog create = onCancelListener.create();
            Window window = create.getWindow();
            if (window != null) {
                window.setLayout(-2, -2);
            }
            create.setCanceledOnTouchOutside(true);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.searchbox.ng.ai.apps.scheme.AiAppUnitedSchemeUtilsDispatcher.9
                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("tapIndex", i3);
                        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
                        create.dismiss();
                    } catch (JSONException e) {
                        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(201));
                    }
                }
            });
            create.show();
            return true;
        } catch (IllegalArgumentException | JSONException e) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
    }

    private boolean handleDismissToast(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        AiAppsUtils.runOnUiThread(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.scheme.AiAppUnitedSchemeUtilsDispatcher.10
            @Override // java.lang.Runnable
            public void run() {
                UniversalToast.cancelToast();
            }
        });
        unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    private boolean handleShowToast(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler) {
        boolean z;
        HashMap<String, String> params = unitedSchemeEntity.getParams();
        if (params == null || params.size() == 0 || !params.containsKey("params") || TextUtils.isEmpty(params.get("params"))) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        try {
            final JSONObject jSONObject = new JSONObject(params.get("params"));
            final String string = jSONObject.getString("type");
            final String string2 = jSONObject.getString("message");
            String optString = jSONObject.optString("time");
            final String optString2 = jSONObject.optString(PARAM_TOAST_BUTTON_CALLBACK_KEY);
            if (TextUtils.isEmpty(string2)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                z = false;
            } else {
                if (TextUtils.isEmpty(string)) {
                    string = "1";
                }
                final int stringToInt = stringToInt(optString);
                if (stringToInt <= 0) {
                    stringToInt = 2;
                }
                AiAppsUtils.runOnUiThread(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.scheme.AiAppUnitedSchemeUtilsDispatcher.11
                    @Override // java.lang.Runnable
                    public void run() {
                        Uri uri = null;
                        String str = string;
                        char c = 65535;
                        switch (str.hashCode()) {
                            case 49:
                                if (str.equals("1")) {
                                    c = 0;
                                    break;
                                }
                                break;
                            case 50:
                                if (str.equals("2")) {
                                    c = 1;
                                    break;
                                }
                                break;
                            case 51:
                                if (str.equals("3")) {
                                    c = 2;
                                    break;
                                }
                                break;
                        }
                        switch (c) {
                            case 0:
                                UniversalToast.makeText(context, string2).setDuration(stringToInt).showToast();
                                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                                return;
                            case 1:
                                UniversalToast.makeText(context, string2).setHighlightDrawable((Drawable) null).setDuration(stringToInt).showHighlightToast();
                                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                                return;
                            case 2:
                                String optString3 = jSONObject.optString(AiAppUnitedSchemeUtilsDispatcher.PARAM_TOAST_ICON_KEY);
                                if (!TextUtils.isEmpty(optString3)) {
                                    try {
                                        uri = Uri.parse(optString3);
                                    } catch (Exception e) {
                                    }
                                }
                                int i = TextUtils.equals(jSONObject.optString(AiAppUnitedSchemeUtilsDispatcher.PARAM_BOTTOM_ICON_STYLE_KEY), "2") ? 2 : 1;
                                String optString4 = jSONObject.optString("title");
                                String optString5 = jSONObject.optString(AiAppUnitedSchemeUtilsDispatcher.PARAM_TOAST_BUTTON_TEXT_KEY);
                                String optString6 = jSONObject.optString("style");
                                int i2 = "2".equals(jSONObject.optString(AiAppUnitedSchemeUtilsDispatcher.PARAM_BOTTOM_SHOW_ANIMATION_TYPE_KEY)) ? 2 : 1;
                                if (TextUtils.isEmpty(optString2)) {
                                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                                    return;
                                } else if (TextUtils.equals(optString6, "2") || TextUtils.equals(optString6, "3")) {
                                    UniversalToast.makeText(context).setLeftGif(uri).setBottomIconStyle(i).setTitleText(optString4).setMessageText(string2).setButtonText(optString5).setButtonStyle(2).setBottomShowAnimationType(i2).setDuration(stringToInt).setToastCallback(new UniversalToast.ToastCallback() { // from class: com.baidu.searchbox.ng.ai.apps.scheme.AiAppUnitedSchemeUtilsDispatcher.11.1
                                        @Override // com.baidu.searchbox.ng.ai.apps.res.widget.toast.UniversalToast.ToastCallback
                                        public void onToastClick() {
                                            callbackHandler.handleSchemeDispatchCallback(optString2, "");
                                        }
                                    }).showIconTitleMsgBtnToast();
                                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                                    return;
                                } else {
                                    UniversalToast.makeText(context).setLeftGif(uri).setBottomIconStyle(i).setTitleText(optString4).setMessageText(string2).setButtonText(optString5).setButtonStyle(1).setBottomShowAnimationType(i2).setDuration(stringToInt).setToastCallback(new UniversalToast.ToastCallback() { // from class: com.baidu.searchbox.ng.ai.apps.scheme.AiAppUnitedSchemeUtilsDispatcher.11.2
                                        @Override // com.baidu.searchbox.ng.ai.apps.res.widget.toast.UniversalToast.ToastCallback
                                        public void onToastClick() {
                                            callbackHandler.handleSchemeDispatchCallback(optString2, "");
                                        }
                                    }).showIconTitleMsgBtnToast();
                                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                                    return;
                                }
                            default:
                                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                                return;
                        }
                    }
                });
                z = true;
            }
            return z;
        } catch (JSONException e) {
            e.printStackTrace();
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
    }

    private int stringToInt(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return (int) Float.parseFloat(str);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private boolean handleOpenSinglePicker(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        HashMap<String, String> params = unitedSchemeEntity.getParams();
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        JSONArray optJSONArray = optParamsAsJo.optJSONArray("array");
        int optInt = optParamsAsJo.optInt("current");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(optJSONArray);
        JSONArray jSONArray2 = new JSONArray();
        jSONArray2.put(optInt);
        try {
            optParamsAsJo.put("array", jSONArray);
            optParamsAsJo.put("current", jSONArray2);
            params.put("params", optParamsAsJo.toString());
            return handleOpenPicker(context, unitedSchemeEntity, callbackHandler, true);
        } catch (JSONException e) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
    }

    private boolean handleOpenMultiPicker(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        return handleOpenPicker(context, unitedSchemeEntity, callbackHandler, false);
    }

    private boolean handleOpenPicker(Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final boolean z) {
        String param = unitedSchemeEntity.getParam("params");
        if (mMultiPickerDialog != null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
        } else {
            try {
                JSONArray jSONArray = new JSONArray();
                JSONArray jSONArray2 = new JSONArray();
                String string = context.getString(R.string.aiapps_picker_default_title);
                if (!TextUtils.isEmpty(param)) {
                    JSONObject jSONObject = new JSONObject(param);
                    jSONArray = jSONObject.optJSONArray("array");
                    jSONArray2 = jSONObject.optJSONArray("current");
                    string = jSONObject.optString("title", string);
                }
                mMultiPickerDialog = new MultiPickerDialog.Builder(context).setDataArray(jSONArray).setDataIndex(jSONArray2).setSingleMode(z).setMultiSelectedListener(new BdMultiPicker.OnMultiSelectedChangedListener() { // from class: com.baidu.searchbox.ng.ai.apps.scheme.AiAppUnitedSchemeUtilsDispatcher.14
                    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.BdMultiPicker.OnMultiSelectedChangedListener
                    public void onMultiSelectedChanged(BdMultiPicker bdMultiPicker, JSONObject jSONObject2) {
                        String optString = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity).optString("cb");
                        if (!TextUtils.isEmpty(optString)) {
                            callbackHandler.handleSchemeDispatchCallback(optString, jSONObject2.toString());
                        }
                    }
                }).setTitle(string).setPositiveButton(R.string.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.searchbox.ng.ai.apps.scheme.AiAppUnitedSchemeUtilsDispatcher.13
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        AiAppAlertDialog unused = AiAppUnitedSchemeUtilsDispatcher.mMultiPickerDialog = null;
                        try {
                            JSONArray currentIndex = ((MultiPickerDialog) dialogInterface).getCurrentIndex();
                            JSONObject jSONObject2 = new JSONObject();
                            if (currentIndex != null && currentIndex.length() > 0) {
                                if (z) {
                                    jSONObject2.put("value", currentIndex.optInt(0));
                                } else {
                                    jSONObject2.put("value", currentIndex);
                                }
                            }
                            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject2, 0));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }).setNegativeButton(R.string.aiapps_cancel, new DialogInterface.OnClickListener() { // from class: com.baidu.searchbox.ng.ai.apps.scheme.AiAppUnitedSchemeUtilsDispatcher.12
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        AiAppAlertDialog unused = AiAppUnitedSchemeUtilsDispatcher.mMultiPickerDialog = null;
                        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                    }
                }).show();
            } catch (JSONException e) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            }
        }
        return false;
    }

    private boolean handleUpdateMultiPicker(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        String param = unitedSchemeEntity.getParam("params");
        if (TextUtils.isEmpty(param)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        } else if (mMultiPickerDialog == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else {
            try {
                JSONObject jSONObject = new JSONObject(param);
                int i = jSONObject.getInt(VALUE_KEY_COLUMN);
                JSONArray optJSONArray = jSONObject.optJSONArray("array");
                int i2 = jSONObject.getInt("current");
                if (optJSONArray != null) {
                    ((MultiPickerDialog) mMultiPickerDialog).updateWheel(i, optJSONArray, i2);
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                }
                return true;
            } catch (JSONException e) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
        }
    }

    private boolean handleUnknownAction(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        UnitedSchemeStatisticUtil.doUBCForInvalidScheme(unitedSchemeEntity.getUri(), "unknown action");
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302);
        return false;
    }
}

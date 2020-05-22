package com.baidu.swan.apps.scheme;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
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
import com.baidu.android.ext.manage.PopItemMethodConstant;
import com.baidu.android.util.devices.NetWorkUtils;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.baidu.searchbox.ui.animview.praise.guide.ControlShowManager;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeAbsDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.UnitedSchemeStatisticUtil;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.aq.ag;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.aq.ak;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.res.ui.BdMultiPicker;
import com.baidu.swan.apps.res.widget.b.d;
import com.baidu.swan.apps.res.widget.dialog.d;
import com.baidu.swan.apps.res.widget.dialog.e;
import com.baidu.swan.apps.res.widget.dialog.g;
import com.baidu.swan.apps.res.widget.dialog.i;
import com.baidu.swan.apps.res.widget.floatlayer.a;
import com.baidu.swan.apps.res.widget.loadingview.LoadingView;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.storage.PathType;
import com.xiaomi.mipush.sdk.Constants;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes11.dex */
public class g extends UnitedSchemeBaseDispatcher {
    private static com.baidu.swan.apps.res.widget.dialog.h bKX;

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public String getDispatcherName() {
        return "utils";
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0045, code lost:
        if (r3.equals("getCommonSysInfoSync") != false) goto L16;
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
            switch (path.hashCode()) {
                case -1920105040:
                    if (path.equals("showModal")) {
                        c = 11;
                        break;
                    }
                    c = 65535;
                    break;
                case -1913642710:
                    if (path.equals(PopItemMethodConstant.showToast)) {
                        c = 14;
                        break;
                    }
                    c = 65535;
                    break;
                case -1641549650:
                    if (path.equals("getSystemInfoSync")) {
                        c = '\b';
                        break;
                    }
                    c = 65535;
                    break;
                case -1496218978:
                    if (path.equals("updateMultiPicker")) {
                        c = 17;
                        break;
                    }
                    c = 65535;
                    break;
                case -1383206285:
                    if (path.equals("previewImage")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case -886619478:
                    if (path.equals("getClipboardData")) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case -550543988:
                    if (path.equals("showActionSheet")) {
                        c = '\f';
                        break;
                    }
                    c = 65535;
                    break;
                case -533453131:
                    break;
                case 216239514:
                    if (path.equals("hideLoading")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 252099448:
                    if (path.equals("openPicker")) {
                        c = 15;
                        break;
                    }
                    c = 65535;
                    break;
                case 344806259:
                    if (path.equals("getSystemInfo")) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                case 422312381:
                    if (path.equals("dismissToast")) {
                        c = '\r';
                        break;
                    }
                    c = 65535;
                    break;
                case 724809599:
                    if (path.equals("showLoading")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 1321118366:
                    if (path.equals("makePhoneCall")) {
                        c = '\t';
                        break;
                    }
                    c = 65535;
                    break;
                case 1576904990:
                    if (path.equals("setClipboardData")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 1630368510:
                    if (path.equals("showDatePickerView")) {
                        c = '\n';
                        break;
                    }
                    c = 65535;
                    break;
                case 1714085202:
                    if (path.equals("getNetworkType")) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case 2103167613:
                    if (path.equals("openMultiPicker")) {
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
                    return g(context, unitedSchemeEntity, callbackHandler);
                case 1:
                    return h(context, unitedSchemeEntity, callbackHandler);
                case 2:
                    return i(context, unitedSchemeEntity, callbackHandler);
                case 3:
                    return j(context, unitedSchemeEntity, callbackHandler);
                case 4:
                    return k(context, unitedSchemeEntity, callbackHandler);
                case 5:
                    return l(context, unitedSchemeEntity, callbackHandler);
                case 6:
                    return m(context, unitedSchemeEntity, callbackHandler);
                case 7:
                    return n(context, unitedSchemeEntity, callbackHandler);
                case '\b':
                    return o(context, unitedSchemeEntity, callbackHandler);
                case '\t':
                    return p(context, unitedSchemeEntity, callbackHandler);
                case '\n':
                    return q(context, unitedSchemeEntity, callbackHandler);
                case 11:
                    return r(context, unitedSchemeEntity, callbackHandler);
                case '\f':
                    return s(context, unitedSchemeEntity, callbackHandler);
                case '\r':
                    return t(context, unitedSchemeEntity, callbackHandler);
                case 14:
                    return u(context, unitedSchemeEntity, callbackHandler);
                case 15:
                    return v(context, unitedSchemeEntity, callbackHandler);
                case 16:
                    return w(context, unitedSchemeEntity, callbackHandler);
                case 17:
                    return x(context, unitedSchemeEntity, callbackHandler);
                default:
                    return y(context, unitedSchemeEntity, callbackHandler);
            }
        }
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public Class<? extends UnitedSchemeAbsDispatcher> getSubDispatcher(String str) {
        return null;
    }

    private boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        if (unitedSchemeEntity == null) {
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("imei", aj.atR());
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
            return true;
        } catch (JSONException e) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "exec fail");
            return false;
        }
    }

    private boolean h(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        LoadingView loadingView;
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String optString = optParamsAsJo.optString("title");
        boolean optBoolean = optParamsAsJo.optBoolean("mask", false);
        if (!(context instanceof a.InterfaceC0377a)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "context not support");
            return false;
        }
        com.baidu.swan.apps.res.widget.floatlayer.a QC = ((a.InterfaceC0377a) context).QC();
        View view = QC.getView();
        if (view instanceof LoadingView) {
            loadingView = (LoadingView) view;
        } else {
            loadingView = new LoadingView(context);
            QC.aq(loadingView);
        }
        if (!TextUtils.isEmpty(optString)) {
            loadingView.setMsg(optString);
        }
        QC.setMask(optBoolean);
        unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    private boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        if (!(context instanceof a.InterfaceC0377a)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "not support FloatLayer");
            return false;
        }
        com.baidu.swan.apps.res.widget.floatlayer.a QC = ((a.InterfaceC0377a) context).QC();
        if (QC.getView() instanceof LoadingView) {
            QC.reset();
        }
        unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    private boolean j(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        String param = unitedSchemeEntity.getParam("params");
        if (TextUtils.isEmpty(param)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(param);
            JSONArray optJSONArray = jSONObject.optJSONArray("urls");
            if (optJSONArray == null || optJSONArray.length() == 0) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            JSONArray q = q(optJSONArray);
            int b = b(jSONObject, q);
            if (b < 0 || b >= q.length()) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            String[] strArr = new String[q.length()];
            for (int i = 0; i < q.length(); i++) {
                strArr[i] = q.getString(i);
            }
            com.baidu.swan.apps.u.a.aff().a(context, strArr, b);
            unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        } catch (JSONException e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
    }

    private JSONArray q(JSONArray jSONArray) {
        com.baidu.swan.apps.runtime.e aoF;
        if (jSONArray != null && jSONArray.length() > 0 && (aoF = com.baidu.swan.apps.runtime.e.aoF()) != null && !TextUtils.isEmpty(aoF.id) && !TextUtils.isEmpty(aoF.getVersion())) {
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    String string = jSONArray.getString(i);
                    PathType oQ = com.baidu.swan.apps.storage.b.oQ(string);
                    if (oQ == PathType.BD_FILE) {
                        string = com.baidu.swan.apps.storage.b.bT(string, aoF.id);
                    } else if (oQ == PathType.RELATIVE) {
                        string = com.baidu.swan.apps.storage.b.a(string, aoF, aoF.getVersion());
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

    private int b(@NonNull JSONObject jSONObject, @NonNull JSONArray jSONArray) throws JSONException {
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

    private boolean k(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        if (unitedSchemeEntity == null) {
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty joParams");
            return false;
        }
        ak.cD(context).setText(optParamsAsJo.optString("data"));
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    private boolean l(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        if (unitedSchemeEntity == null) {
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (ak.cD(context).getText() != null) {
                jSONObject.put("data", ak.cD(context).getText().toString());
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
            return true;
        } catch (JSONException e) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "JSONException");
            return false;
        }
    }

    private boolean m(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        if (unitedSchemeEntity == null) {
            return false;
        }
        String networkClass = SwanAppNetworkUtils.getNetworkClass();
        if (TextUtils.isEmpty(networkClass)) {
            networkClass = "unknown";
        } else if (NetWorkUtils.NETWORK_TYPE_CELL_UN_CONNECTED.equals(networkClass)) {
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

    private boolean n(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        if (unitedSchemeEntity == null) {
            return false;
        }
        JSONObject bn = bn(context);
        if (bn == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty joData");
            return false;
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(bn, 0));
        return true;
    }

    private JSONObject bn(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        windowManager.getDefaultDisplay().getSize(new Point());
        windowManager.getDefaultDisplay().getRectSize(new Rect());
        Configuration configuration = context.getResources().getConfiguration();
        Pair<Integer, Integer> ahI = com.baidu.swan.apps.w.f.ahV().ahI();
        Pair<Integer, Integer> ahH = com.baidu.swan.apps.w.f.ahV().ahH();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Constants.PHONE_BRAND, Build.BRAND);
            jSONObject.put("model", Build.MODEL);
            jSONObject.put("pixelRatio", displayMetrics.density);
            jSONObject.put("devicePixelRatio", displayMetrics.density);
            jSONObject.put("screenWidth", ag.D(((Integer) ahI.first).intValue()));
            jSONObject.put("screenHeight", ag.D(((Integer) ahI.second).intValue()));
            jSONObject.put("windowWidth", (int) (((Integer) ahH.first).intValue() / displayMetrics.density));
            jSONObject.put("windowHeight", (int) (((Integer) ahH.second).intValue() / displayMetrics.density));
            jSONObject.put(IjkMediaMeta.IJKM_KEY_LANGUAGE, b(configuration));
            jSONObject.put("version", aj.getVersionName());
            jSONObject.put("system", "Android " + Build.VERSION.RELEASE);
            jSONObject.put("platform", "android");
            jSONObject.put("fontSizeSetting", com.baidu.swan.apps.u.a.afd().SJ());
            jSONObject.put("SDKVersion", bo(context));
            jSONObject.put("swanNativeVersion", com.baidu.swan.apps.c.getVersion());
            jSONObject.put("host", com.baidu.swan.apps.u.a.afB().getHostName());
            jSONObject.put("statusBarHeight", ag.D(ag.getStatusBarHeight()));
            jSONObject.put("navigationBarHeight", ag.D(ag.getActionBarHeight()));
            com.baidu.swan.apps.api.module.l.c.ao(jSONObject);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }

    private static String b(Configuration configuration) {
        if (Build.VERSION.SDK_INT < 21) {
            return configuration.locale.toString();
        }
        if (Build.VERSION.SDK_INT < 24) {
            return configuration.locale.toLanguageTag();
        }
        return configuration.getLocales().toLanguageTags();
    }

    private static String bo(Context context) {
        int i = 0;
        if (context instanceof SwanAppActivity) {
            i = ((SwanAppActivity) context).Qz();
        }
        if (i == 1) {
            return com.baidu.swan.apps.swancore.b.a(com.baidu.swan.games.j.a.aAd().abG(), i);
        }
        return com.baidu.swan.apps.swancore.b.a(com.baidu.swan.apps.core.turbo.d.abl().abG(), i);
    }

    private boolean o(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        if (unitedSchemeEntity == null) {
            return false;
        }
        JSONObject bn = bn(context);
        if (bn == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty joData");
            return false;
        }
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(bn, 0);
        return true;
    }

    private boolean p(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        if (unitedSchemeEntity == null) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.DIAL");
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo != null) {
            String optString = optParamsAsJo.optString("phoneNumber");
            if (!TextUtils.isEmpty(optString)) {
                intent.setData(Uri.parse("tel:" + optString));
            }
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, com.baidu.swan.apps.aq.d.startActivitySafely(context, intent) ? 0 : 1001);
        return true;
    }

    private boolean q(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        String param = unitedSchemeEntity.getParam("params");
        if (TextUtils.isEmpty(param)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(param);
            String optString = jSONObject.optString("mode");
            if (TextUtils.isEmpty(optString)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            char c = 65535;
            switch (optString.hashCode()) {
                case 3076014:
                    if (optString.equals("date")) {
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
                    return a(context, unitedSchemeEntity, callbackHandler, jSONObject);
                case 1:
                    return b(context, unitedSchemeEntity, callbackHandler, jSONObject);
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

    private boolean a(Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, JSONObject jSONObject) {
        boolean optBoolean = jSONObject.optBoolean("disabled", false);
        String optString = jSONObject.optString("start");
        String optString2 = jSONObject.optString("end");
        String optString3 = jSONObject.optString("value");
        String optString4 = jSONObject.optString("fields");
        if (TextUtils.isEmpty(optString)) {
            optString = "00:00";
        }
        if (TextUtils.isEmpty(optString2)) {
            optString2 = "23:59";
        }
        Date hw = hw(optString);
        Date hw2 = hw(optString2);
        Date hw3 = hw(optString3);
        if (hw3 == null) {
            hw3 = hw(new SimpleDateFormat("HH:mm").format(new Date()));
        }
        if (hw == null || hw2 == null || hw2.before(hw) || hw3 == null || hw3.before(hw) || hw3.after(hw2)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        i.a aVar = new i.a(context);
        if (!TextUtils.isEmpty(optString4)) {
            aVar.nr(optString4);
        }
        aVar.g(hw).h(hw2).i(hw3).fa(optBoolean).f(a.h.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.scheme.g.9
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                String format = String.format("%02d:%02d", Integer.valueOf(((com.baidu.swan.apps.res.widget.dialog.i) dialogInterface).getHour()), Integer.valueOf(((com.baidu.swan.apps.res.widget.dialog.i) dialogInterface).getMinute()));
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("value", format);
                    JSONObject wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(jSONObject2, 0);
                    if (com.baidu.swan.apps.b.DEBUG) {
                        Log.d("SwanAppUnitedSchemeUtilsDispatcher", "handleShowDatePicker params = " + wrapCallbackParams.toString());
                    }
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, wrapCallbackParams);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }).g(a.h.aiapps_cancel, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.scheme.g.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                dialogInterface.dismiss();
            }
        }).aop();
        return true;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:24:0x0047 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:31:0x000c */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:32:0x0001 */
    private Date hw(String str) {
        Date date;
        NumberFormatException e;
        Date date2 = null;
        date2 = null;
        date2 = null;
        try {
            if (TextUtils.isEmpty(str)) {
                date = new Date();
            } else {
                if (str.contains(":")) {
                    String[] split = str.split(":");
                    if (split.length == 2) {
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
                }
                date = null;
            }
        } catch (NumberFormatException e3) {
            date = date2;
            e = e3;
        }
        return date;
    }

    private boolean b(Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, JSONObject jSONObject) {
        Date date;
        boolean optBoolean = jSONObject.optBoolean("disabled", false);
        String optString = jSONObject.optString("start");
        String optString2 = jSONObject.optString("end");
        String optString3 = jSONObject.optString("value");
        String optString4 = jSONObject.optString("fields");
        if (TextUtils.isEmpty(optString)) {
            optString = "1900-01-01";
        }
        if (TextUtils.isEmpty(optString2)) {
            optString2 = "2099-12-31";
        }
        Date bZ = com.baidu.swan.apps.aq.i.bZ(optString, ControlShowManager.DAY_TIME_FORMAT);
        Date bZ2 = com.baidu.swan.apps.aq.i.bZ(optString2, ControlShowManager.DAY_TIME_FORMAT);
        if (bZ == null || bZ2 == null || bZ2.before(bZ)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        Date date2 = new Date();
        if (TextUtils.isEmpty(optString3) || (date = com.baidu.swan.apps.aq.i.e(optString3, new String[]{ControlShowManager.DAY_TIME_FORMAT, "yyyy-MM", "yyyy"})) == null) {
            date = date2;
        }
        if (date.before(bZ)) {
            date = bZ;
        } else if (date.after(bZ2)) {
            date = bZ2;
        }
        d.a aVar = new d.a(context);
        if (!TextUtils.isEmpty(optString4)) {
            aVar.np(optString4);
        }
        aVar.d(bZ).e(bZ2).f(date).eO(optBoolean).f(a.h.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.scheme.g.11
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                if (dialogInterface instanceof com.baidu.swan.apps.res.widget.dialog.d) {
                    String aoe = ((com.baidu.swan.apps.res.widget.dialog.d) dialogInterface).aoe();
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("value", aoe);
                        JSONObject wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(jSONObject2, 0);
                        if (com.baidu.swan.apps.b.DEBUG) {
                            Log.d("SwanAppUnitedSchemeUtilsDispatcher", "handleShowDatePicker params = " + wrapCallbackParams.toString());
                        }
                        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, wrapCallbackParams);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).g(a.h.aiapps_cancel, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.scheme.g.10
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                dialogInterface.dismiss();
            }
        }).aop();
        return true;
    }

    private boolean r(Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler) {
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            optParamsAsJo = new JSONObject();
        }
        String optString = optParamsAsJo.optString("confirmText");
        if (TextUtils.isEmpty(optString)) {
            optString = context.getString(a.h.aiapps_ok);
        }
        g.a aVar = new g.a(context);
        aVar.e(optParamsAsJo.optString("title")).nq(optParamsAsJo.optString("content")).a(new com.baidu.swan.apps.view.c.a());
        if (optParamsAsJo.optBoolean("showCancel", true)) {
            aVar.Q(optParamsAsJo.optString("cancelColor"), a.c.aiapps_modal_cancel_color);
            String optString2 = optParamsAsJo.optString("cancelText");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = context.getString(a.h.aiapps_cancel);
            }
            aVar.b(optString2, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.scheme.g.12
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("type", "cancel");
                        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
                    } catch (JSONException e) {
                        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(201));
                    }
                }
            });
            aVar.a(new DialogInterface.OnCancelListener() { // from class: com.baidu.swan.apps.scheme.g.13
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("type", "cancel");
                        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
                    } catch (JSONException e) {
                        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(201));
                    }
                }
            });
        }
        aVar.P(optParamsAsJo.optString("confirmColor"), a.c.aiapps_modal_confirm_color);
        aVar.a(optString, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.scheme.g.14
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("type", "confirm");
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
                } catch (JSONException e) {
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(201));
                }
            }
        });
        aVar.aon();
        return true;
    }

    private boolean s(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler) {
        int i;
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        final ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = optParamsAsJo.getJSONArray("itemList");
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                String string = jSONArray.getString(i2);
                if (TextUtils.isEmpty(string)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                arrayList.add(string);
            }
            String optString = optParamsAsJo.optString("itemColor");
            if (TextUtils.isEmpty(optString)) {
                i = -1;
            } else {
                if (optString.length() == 4 && optString.charAt(0) == '#') {
                    optString = SwanAppConfigData.nG(optString);
                }
                i = Color.parseColor(optString);
            }
        } catch (IllegalArgumentException | JSONException e) {
            i = -1;
        }
        if (arrayList.isEmpty()) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        final int color = i == -1 ? context.getResources().getColor(a.c.aiapps_action_sheet_item_color) : i;
        g.a a = new g.a(context).eR(true).eY(true).eW(true).eT(true).a(new com.baidu.swan.apps.view.c.a()).gr(context.getResources().getDimensionPixelSize(a.d.aiapps_action_sheet_bottom_divider)).gA(a.e.aiapps_action_sheet_bg).d(a.h.aiapps_cancel, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.scheme.g.16
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(201, "showActionSheet:fail cancel"));
            }
        }).a(new DialogInterface.OnCancelListener() { // from class: com.baidu.swan.apps.scheme.g.15
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(201, "showActionSheet:fail cancel"));
            }
        });
        View inflate = View.inflate(context, a.g.aiapps_scheme_utils_show_action_sheet, null);
        ListView listView = (ListView) inflate.findViewById(a.f.list);
        listView.setAdapter((ListAdapter) new BaseAdapter() { // from class: com.baidu.swan.apps.scheme.g.2
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
                    view = View.inflate(context, a.g.aiapps_scheme_utils_show_action_sheet_item, null);
                }
                TextView textView = (TextView) view.findViewById(a.f.text);
                textView.setTextColor(color);
                textView.setText(getItem(i3));
                return view;
            }
        });
        a.ao(inflate);
        a.aol();
        a.gs(l(context, arrayList.size()));
        final com.baidu.swan.apps.res.widget.dialog.g ZF = a.ZF();
        Window window = ZF.getWindow();
        if (window != null) {
            window.setGravity(80);
            window.setLayout(ag.cx(context), -2);
            window.setWindowAnimations(a.i.action_sheet_animation);
        }
        ZF.setEnableImmersion(false);
        ZF.setCanceledOnTouchOutside(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.swan.apps.scheme.g.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("tapIndex", i3);
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
                    ZF.dismiss();
                } catch (JSONException e2) {
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(201));
                }
            }
        });
        ZF.show();
        return true;
    }

    private int l(Context context, int i) {
        int cx;
        Resources resources = context.getResources();
        int dimensionPixelSize = ((resources.getDimensionPixelSize(a.d.aiapps_action_sheet_bottom_divider) + ((i + 1) * resources.getDimensionPixelSize(a.d.aiapps_action_sheet_list_item))) + i) - 1;
        return (!ag.isScreenLand() || dimensionPixelSize <= (cx = ag.cx(context) - ag.getStatusBarHeight())) ? dimensionPixelSize : cx;
    }

    private boolean t(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.scheme.g.4
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.res.widget.b.d.cancelToast();
            }
        });
        unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    private boolean u(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler) {
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
            final String optString2 = jSONObject.optString("clickCallback");
            if (TextUtils.isEmpty(string2)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                z = false;
            } else {
                if (TextUtils.isEmpty(string)) {
                    string = "1";
                }
                final int hD = hD(optString);
                if (hD <= 0) {
                    hD = 2;
                }
                aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.scheme.g.5
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
                                com.baidu.swan.apps.res.widget.b.d.a(context, string2).gG(hD).showToast();
                                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                                return;
                            case 1:
                                com.baidu.swan.apps.res.widget.b.d.a(context, string2).d((Drawable) null).gG(hD).showHighlightToast();
                                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                                return;
                            case 2:
                                String optString3 = jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                                if (!TextUtils.isEmpty(optString3)) {
                                    try {
                                        uri = Uri.parse(optString3);
                                    } catch (Exception e) {
                                    }
                                }
                                int i = TextUtils.equals(jSONObject.optString("bottomIconStyle"), "2") ? 2 : 1;
                                String optString4 = jSONObject.optString("title");
                                String optString5 = jSONObject.optString("buttonText");
                                String optString6 = jSONObject.optString("style");
                                int i2 = "2".equals(jSONObject.optString("bottomShowAnimationType")) ? 2 : 1;
                                if (TextUtils.isEmpty(optString2)) {
                                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                                    return;
                                } else if (TextUtils.equals(optString6, "2") || TextUtils.equals(optString6, "3")) {
                                    com.baidu.swan.apps.res.widget.b.d.ce(context).d(uri).gF(i).f(optString4).g(string2).h(optString5).gD(2).gE(i2).gG(hD).b(new d.a() { // from class: com.baidu.swan.apps.scheme.g.5.1
                                        @Override // com.baidu.swan.apps.res.widget.b.d.a
                                        public void onToastClick() {
                                            callbackHandler.handleSchemeDispatchCallback(optString2, "");
                                        }
                                    }).showIconTitleMsgBtnToast();
                                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                                    return;
                                } else {
                                    com.baidu.swan.apps.res.widget.b.d.ce(context).d(uri).gF(i).f(optString4).g(string2).h(optString5).gD(1).gE(i2).gG(hD).b(new d.a() { // from class: com.baidu.swan.apps.scheme.g.5.2
                                        @Override // com.baidu.swan.apps.res.widget.b.d.a
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

    private int hD(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return (int) Float.parseFloat(str);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private boolean v(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        HashMap<String, String> params = unitedSchemeEntity.getParams();
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        JSONArray optJSONArray = optParamsAsJo.optJSONArray(com.baidu.fsg.base.statistics.b.j);
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
            optParamsAsJo.put(com.baidu.fsg.base.statistics.b.j, jSONArray);
            optParamsAsJo.put("current", jSONArray2);
            params.put("params", optParamsAsJo.toString());
            return a(context, unitedSchemeEntity, callbackHandler, true);
        } catch (JSONException e) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
    }

    private boolean w(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        return a(context, unitedSchemeEntity, callbackHandler, false);
    }

    private boolean a(Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final boolean z) {
        String param = unitedSchemeEntity.getParam("params");
        if (bKX != null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
        } else {
            try {
                JSONArray jSONArray = new JSONArray();
                JSONArray jSONArray2 = new JSONArray();
                String string = context.getString(a.h.aiapps_picker_default_title);
                if (!TextUtils.isEmpty(param)) {
                    JSONObject jSONObject = new JSONObject(param);
                    jSONArray = jSONObject.optJSONArray(com.baidu.fsg.base.statistics.b.j);
                    jSONArray2 = jSONObject.optJSONArray("current");
                    jSONObject.optString("title", string);
                }
                bKX = new e.a(context).B(jSONArray).C(jSONArray2).eQ(z).a(new BdMultiPicker.a() { // from class: com.baidu.swan.apps.scheme.g.8
                    @Override // com.baidu.swan.apps.res.ui.BdMultiPicker.a
                    public void a(BdMultiPicker bdMultiPicker, JSONObject jSONObject2) {
                        String optString = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity).optString("cb");
                        if (!TextUtils.isEmpty(optString)) {
                            callbackHandler.handleSchemeDispatchCallback(optString, jSONObject2.toString());
                        }
                    }
                }).f(a.h.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.scheme.g.7
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        com.baidu.swan.apps.res.widget.dialog.h unused = g.bKX = null;
                        try {
                            JSONArray currentIndex = ((com.baidu.swan.apps.res.widget.dialog.e) dialogInterface).getCurrentIndex();
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
                }).g(a.h.aiapps_cancel, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.scheme.g.6
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        com.baidu.swan.apps.res.widget.dialog.h unused = g.bKX = null;
                        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                    }
                }).aop();
            } catch (JSONException e) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    e.printStackTrace();
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            }
        }
        return false;
    }

    private boolean x(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        String param = unitedSchemeEntity.getParam("params");
        if (TextUtils.isEmpty(param)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        } else if (bKX == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else {
            try {
                JSONObject jSONObject = new JSONObject(param);
                int i = jSONObject.getInt("column");
                JSONArray optJSONArray = jSONObject.optJSONArray(com.baidu.fsg.base.statistics.b.j);
                int i2 = jSONObject.getInt("current");
                if (optJSONArray != null) {
                    ((com.baidu.swan.apps.res.widget.dialog.e) bKX).a(i, optJSONArray, i2);
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                }
                return true;
            } catch (JSONException e) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    e.printStackTrace();
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
        }
    }

    private boolean y(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        UnitedSchemeStatisticUtil.doUBCForInvalidScheme(unitedSchemeEntity.getUri(), "unknown action");
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302);
        return false;
    }
}

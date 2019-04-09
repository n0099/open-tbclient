package com.baidu.swan.apps.scheme;

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
import com.baidu.mobstat.Config;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeAbsDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.UnitedSchemeStatisticUtil;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.an.aa;
import com.baidu.swan.apps.an.ab;
import com.baidu.swan.apps.an.x;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.res.ui.BdMultiPicker;
import com.baidu.swan.apps.res.widget.b.d;
import com.baidu.swan.apps.res.widget.dialog.c;
import com.baidu.swan.apps.res.widget.dialog.d;
import com.baidu.swan.apps.res.widget.dialog.e;
import com.baidu.swan.apps.res.widget.dialog.f;
import com.baidu.swan.apps.res.widget.floatlayer.a;
import com.baidu.swan.apps.res.widget.loadingview.LoadingView;
import com.baidu.swan.apps.storage.PathType;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.ubc.UBC;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes2.dex */
public class g extends UnitedSchemeBaseDispatcher {
    private static com.baidu.swan.apps.res.widget.dialog.e aOZ;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0050, code lost:
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
            UnitedSchemeStatisticUtil.doUBCForSchemeInvoke(unitedSchemeEntity.getSource(), unitedSchemeEntity.getUri());
            switch (path.hashCode()) {
                case -1920105040:
                    if (path.equals("showModal")) {
                        c = 11;
                        break;
                    }
                    c = 65535;
                    break;
                case -1913642710:
                    if (path.equals("showToast")) {
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
                    return b(context, unitedSchemeEntity, callbackHandler);
                case 1:
                    return c(context, unitedSchemeEntity, callbackHandler);
                case 2:
                    return d(context, unitedSchemeEntity, callbackHandler);
                case 3:
                    return e(context, unitedSchemeEntity, callbackHandler);
                case 4:
                    return f(context, unitedSchemeEntity, callbackHandler);
                case 5:
                    return g(context, unitedSchemeEntity, callbackHandler);
                case 6:
                    return h(context, unitedSchemeEntity, callbackHandler);
                case 7:
                    return i(context, unitedSchemeEntity, callbackHandler);
                case '\b':
                    return j(context, unitedSchemeEntity, callbackHandler);
                case '\t':
                    return k(context, unitedSchemeEntity, callbackHandler);
                case '\n':
                    return l(context, unitedSchemeEntity, callbackHandler);
                case 11:
                    return m(context, unitedSchemeEntity, callbackHandler);
                case '\f':
                    return n(context, unitedSchemeEntity, callbackHandler);
                case '\r':
                    return o(context, unitedSchemeEntity, callbackHandler);
                case 14:
                    return p(context, unitedSchemeEntity, callbackHandler);
                case 15:
                    return q(context, unitedSchemeEntity, callbackHandler);
                case 16:
                    return r(context, unitedSchemeEntity, callbackHandler);
                case 17:
                    return s(context, unitedSchemeEntity, callbackHandler);
                default:
                    return t(context, unitedSchemeEntity, callbackHandler);
            }
        }
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public Class<? extends UnitedSchemeAbsDispatcher> getSubDispatcher(String str) {
        return null;
    }

    private boolean b(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        if (unitedSchemeEntity == null) {
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("imei", aa.Mp());
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
            return true;
        } catch (JSONException e) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "exec fail");
            return false;
        }
    }

    private boolean c(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        LoadingView loadingView;
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String optString = optParamsAsJo.optString("title");
        boolean optBoolean = optParamsAsJo.optBoolean("mask", false);
        if (!(context instanceof a.InterfaceC0164a)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "context not support");
            return false;
        }
        com.baidu.swan.apps.res.widget.floatlayer.a uu = ((a.InterfaceC0164a) context).uu();
        View view = uu.getView();
        if (view instanceof LoadingView) {
            loadingView = (LoadingView) view;
        } else {
            loadingView = new LoadingView(context);
            uu.ae(loadingView);
        }
        if (!TextUtils.isEmpty(optString)) {
            loadingView.setMsg(optString);
        }
        uu.setMask(optBoolean);
        unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    private boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        if (!(context instanceof a.InterfaceC0164a)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "not support FloatLayer");
            return false;
        }
        com.baidu.swan.apps.res.widget.floatlayer.a uu = ((a.InterfaceC0164a) context).uu();
        if (uu.getView() instanceof LoadingView) {
            uu.reset();
        }
        unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    private boolean e(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
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
            JSONArray l = l(optJSONArray);
            int a = a(jSONObject, l);
            if (a < 0 || a >= l.length()) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            String[] strArr = new String[l.length()];
            for (int i = 0; i < l.length(); i++) {
                strArr[i] = l.getString(i);
            }
            com.baidu.swan.apps.u.a.CL().a(context, strArr, a);
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

    private JSONArray l(JSONArray jSONArray) {
        com.baidu.swan.apps.ae.b IV;
        if (jSONArray != null && jSONArray.length() > 0 && (IV = com.baidu.swan.apps.ae.b.IV()) != null && !TextUtils.isEmpty(IV.id) && !TextUtils.isEmpty(IV.getVersion())) {
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    String string = jSONArray.getString(i);
                    PathType gZ = com.baidu.swan.apps.storage.b.gZ(string);
                    if (gZ == PathType.BD_FILE) {
                        string = com.baidu.swan.apps.storage.b.aC(string, IV.id);
                    } else if (gZ == PathType.RELATIVE) {
                        string = com.baidu.swan.apps.storage.b.a(string, IV, IV.getVersion());
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

    private int a(@NonNull JSONObject jSONObject, @NonNull JSONArray jSONArray) throws JSONException {
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

    private boolean f(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        if (unitedSchemeEntity == null) {
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty joParams");
            return false;
        }
        ab.ct(context).setText(optParamsAsJo.optString("data"));
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    private boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        if (unitedSchemeEntity == null) {
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("data", ab.ct(context).getText().toString());
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
            return true;
        } catch (JSONException e) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "JSONException");
            return false;
        }
    }

    private boolean h(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        if (unitedSchemeEntity == null) {
            return false;
        }
        String Fa = SwanAppNetworkUtils.Fa();
        if (TextUtils.isEmpty(Fa)) {
            Fa = "unknown";
        } else if ("no".equals(Fa)) {
            Fa = "none";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("networkType", Fa);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
            return true;
        } catch (JSONException e) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
    }

    private boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        if (unitedSchemeEntity == null) {
            return false;
        }
        JSONObject bZ = bZ(context);
        if (bZ == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty joData");
            return false;
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(bZ, 0));
        return true;
    }

    private JSONObject bZ(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        windowManager.getDefaultDisplay().getSize(new Point());
        windowManager.getDefaultDisplay().getRectSize(new Rect());
        Configuration configuration = context.getResources().getConfiguration();
        Pair<Integer, Integer> DP = com.baidu.swan.apps.w.e.Ea().DP();
        Pair<Integer, Integer> DO = com.baidu.swan.apps.w.e.Ea().DO();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("brand", Build.BOARD);
            jSONObject.put("model", Build.MODEL);
            jSONObject.put("pixelRatio", displayMetrics.density);
            jSONObject.put("screenWidth", x.ae(((Integer) DP.first).intValue()));
            jSONObject.put("screenHeight", x.ae(((Integer) DP.second).intValue()));
            jSONObject.put("windowWidth", (int) (((Integer) DO.first).intValue() / displayMetrics.density));
            jSONObject.put("windowHeight", (int) (((Integer) DO.second).intValue() / displayMetrics.density));
            jSONObject.put(IjkMediaMeta.IJKM_KEY_LANGUAGE, a(configuration));
            jSONObject.put("version", aa.getVersionName());
            jSONObject.put("system", "Android " + Build.VERSION.RELEASE);
            jSONObject.put("platform", "android");
            jSONObject.put("fontSizeSetting", 1);
            jSONObject.put("SDKVersion", ca(context));
            jSONObject.put("host", com.baidu.swan.apps.u.a.CI().getHostName());
            jSONObject.put("statusBarHeight", x.ae(x.getStatusBarHeight()));
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }

    private static String a(Configuration configuration) {
        if (Build.VERSION.SDK_INT < 21) {
            return configuration.locale.toString();
        }
        if (Build.VERSION.SDK_INT < 24) {
            return configuration.locale.toLanguageTag();
        }
        return configuration.getLocales().toLanguageTags();
    }

    private static String ca(Context context) {
        int i = 0;
        if (context instanceof SwanAppActivity) {
            i = ((SwanAppActivity) context).us();
        }
        if (i == 1) {
            return com.baidu.swan.apps.swancore.b.a((SwanCoreVersion) null, i);
        }
        return com.baidu.swan.apps.swancore.b.a(com.baidu.swan.apps.core.i.c.Aa().Ar(), i);
    }

    private boolean j(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        if (unitedSchemeEntity == null) {
            return false;
        }
        JSONObject bZ = bZ(context);
        if (bZ == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty joData");
            return false;
        }
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(bZ, 0);
        return true;
    }

    private boolean k(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
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
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, com.baidu.swan.apps.an.b.h(context, intent) ? 0 : 1001);
        return true;
    }

    private boolean l(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
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
                    if (optString.equals(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME)) {
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
        String optString = jSONObject.optString(IntentConfig.START);
        String optString2 = jSONObject.optString("end");
        String optString3 = jSONObject.optString(UBC.CONTENT_KEY_VALUE);
        String optString4 = jSONObject.optString("fields");
        if (TextUtils.isEmpty(optString)) {
            optString = "00:00";
        }
        if (TextUtils.isEmpty(optString2)) {
            optString2 = "23:59";
        }
        Date gA = gA(optString);
        Date gA2 = gA(optString2);
        Date gA3 = gA(optString3);
        if (gA == null || gA2 == null || gA2.before(gA) || gA3 == null || gA3.before(gA) || gA3.after(gA2)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        f.a aVar = new f.a(context);
        if (!TextUtils.isEmpty(optString4)) {
            aVar.gf(optString4);
        }
        aVar.j(gA).k(gA2).l(gA3).bW(optBoolean).cm(a.h.aiapps_picker_time_title).b(a.h.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.scheme.g.7
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                String format = String.format("%02d:%02d", Integer.valueOf(((com.baidu.swan.apps.res.widget.dialog.f) dialogInterface).getHour()), Integer.valueOf(((com.baidu.swan.apps.res.widget.dialog.f) dialogInterface).getMinute()));
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put(UBC.CONTENT_KEY_VALUE, format);
                    JSONObject wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(jSONObject2, 0);
                    if (com.baidu.swan.apps.b.DEBUG) {
                        Log.d("SwanAppUnitedSchemeUtilsDispatcher", "handleShowDatePicker params = " + wrapCallbackParams.toString());
                    }
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, wrapCallbackParams);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }).c(a.h.aiapps_cancel, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.scheme.g.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                dialogInterface.dismiss();
            }
        }).Is();
        return true;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:26:0x0049 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:31:0x000c */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:32:0x0001 */
    private Date gA(String str) {
        Date date;
        NumberFormatException e;
        String[] split;
        Date date2 = null;
        date2 = null;
        date2 = null;
        try {
            if (TextUtils.isEmpty(str)) {
                date = new Date();
            } else if (!str.contains(Config.TRACE_TODAY_VISIT_SPLIT) || (split = str.split(Config.TRACE_TODAY_VISIT_SPLIT)) == null || split.length != 2) {
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

    private boolean b(Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, JSONObject jSONObject) {
        Date date;
        boolean optBoolean = jSONObject.optBoolean("disabled", false);
        String optString = jSONObject.optString(IntentConfig.START);
        String optString2 = jSONObject.optString("end");
        String optString3 = jSONObject.optString(UBC.CONTENT_KEY_VALUE);
        String optString4 = jSONObject.optString("fields");
        if (TextUtils.isEmpty(optString)) {
            optString = "1900-01-01";
        }
        if (TextUtils.isEmpty(optString2)) {
            optString2 = "2099-12-31";
        }
        Date aJ = com.baidu.swan.apps.an.e.aJ(optString, "yyyy-MM-dd");
        Date aJ2 = com.baidu.swan.apps.an.e.aJ(optString2, "yyyy-MM-dd");
        if (aJ == null || aJ2 == null || aJ2.before(aJ)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        Date date2 = new Date();
        if (TextUtils.isEmpty(optString3) || (date = com.baidu.swan.apps.an.e.d(optString3, new String[]{"yyyy-MM-dd", "yyyy-MM", "yyyy"})) == null) {
            date = date2;
        }
        if (date.before(aJ)) {
            date = aJ;
        } else if (date.after(aJ2)) {
            date = aJ2;
        }
        c.a aVar = new c.a(context);
        if (!TextUtils.isEmpty(optString4)) {
            aVar.gd(optString4);
        }
        aVar.g(aJ).h(aJ2).i(date).bM(optBoolean).cm(a.h.aiapps_picker_date_title).b(a.h.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.scheme.g.9
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                if (dialogInterface instanceof com.baidu.swan.apps.res.widget.dialog.c) {
                    String Im = ((com.baidu.swan.apps.res.widget.dialog.c) dialogInterface).Im();
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put(UBC.CONTENT_KEY_VALUE, Im);
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
        }).c(a.h.aiapps_cancel, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.scheme.g.8
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                dialogInterface.dismiss();
            }
        }).Is();
        return true;
    }

    private boolean m(Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler) {
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            optParamsAsJo = new JSONObject();
        }
        String optString = optParamsAsJo.optString("confirmText");
        if (TextUtils.isEmpty(optString)) {
            optString = context.getString(a.h.aiapps_ok);
        }
        e.a aVar = new e.a(context);
        aVar.d(optParamsAsJo.optString("title")).ge(optParamsAsJo.optString("content")).a(new com.baidu.swan.apps.view.b.a()).bR(false);
        if (optParamsAsJo.optBoolean("showCancel", true)) {
            aVar.G(optParamsAsJo.optString("cancelColor"), a.c.aiapps_modal_cancel_color);
            String optString2 = optParamsAsJo.optString("cancelText");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = context.getString(a.h.aiapps_cancel);
            }
            aVar.d(optString2, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.scheme.g.10
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
        }
        aVar.F(optParamsAsJo.optString("confirmColor"), a.c.aiapps_modal_confirm_color);
        aVar.c(optString, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.scheme.g.11
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
        aVar.Is();
        return true;
    }

    private boolean n(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler) {
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
                    optString = com.baidu.swan.apps.ae.a.c.gm(optString);
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
        e.a a = new e.a(context).bP(true).bV(true).bU(false).bR(true).a(new com.baidu.swan.apps.view.b.a()).a(new DialogInterface.OnCancelListener() { // from class: com.baidu.swan.apps.scheme.g.12
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(201, "showActionSheet:fail cancel"));
            }
        });
        View inflate = View.inflate(context, a.g.aiapps_scheme_utils_show_action_sheet, null);
        ListView listView = (ListView) inflate.findViewById(a.f.list);
        listView.setAdapter((ListAdapter) new BaseAdapter() { // from class: com.baidu.swan.apps.scheme.g.13
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
        a.ad(inflate);
        final com.baidu.swan.apps.res.widget.dialog.e zq = a.zq();
        Window window = zq.getWindow();
        if (window != null) {
            window.setLayout(-2, -2);
            window.setGravity(80);
            int Mf = x.Mf();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.y = Mf;
            window.setAttributes(attributes);
        }
        zq.setCanceledOnTouchOutside(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.swan.apps.scheme.g.14
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("tapIndex", i3);
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
                    zq.dismiss();
                } catch (JSONException e2) {
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(201));
                }
            }
        });
        zq.show();
        return true;
    }

    private boolean o(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        aa.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.scheme.g.2
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.res.widget.b.d.IO();
            }
        });
        unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    private boolean p(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler) {
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
            String optString = jSONObject.optString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
            final String optString2 = jSONObject.optString("clickCallback");
            if (TextUtils.isEmpty(string2)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                z = false;
            } else {
                if (TextUtils.isEmpty(string)) {
                    string = "1";
                }
                final int gB = gB(optString);
                if (gB <= 0) {
                    gB = 2;
                }
                aa.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.scheme.g.3
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
                                com.baidu.swan.apps.res.widget.b.d.a(context, string2).dv(gB).II();
                                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                                return;
                            case 1:
                                com.baidu.swan.apps.res.widget.b.d.a(context, string2).e((Drawable) null).dv(gB).IL();
                                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                                return;
                            case 2:
                                String optString3 = jSONObject.optString("icon");
                                if (!TextUtils.isEmpty(optString3)) {
                                    try {
                                        uri = Uri.parse(optString3);
                                    } catch (Exception e) {
                                    }
                                }
                                int i = TextUtils.equals(jSONObject.optString("bottomIconStyle"), "2") ? 2 : 1;
                                String optString4 = jSONObject.optString("title");
                                String optString5 = jSONObject.optString("buttonText");
                                String optString6 = jSONObject.optString(UnitedSchemeConstants.UNITED_SCHEME_STYLE);
                                int i2 = "2".equals(jSONObject.optString("bottomShowAnimationType")) ? 2 : 1;
                                if (TextUtils.isEmpty(optString2)) {
                                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                                    return;
                                } else if (TextUtils.equals(optString6, "2") || TextUtils.equals(optString6, "3")) {
                                    com.baidu.swan.apps.res.widget.b.d.bX(context).f(uri).du(i).e(optString4).f(string2).g(optString5).ds(2).dt(i2).dv(gB).b(new d.a() { // from class: com.baidu.swan.apps.scheme.g.3.1
                                        @Override // com.baidu.swan.apps.res.widget.b.d.a
                                        public void IP() {
                                            callbackHandler.handleSchemeDispatchCallback(optString2, "");
                                        }
                                    }).IN();
                                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                                    return;
                                } else {
                                    com.baidu.swan.apps.res.widget.b.d.bX(context).f(uri).du(i).e(optString4).f(string2).g(optString5).ds(1).dt(i2).dv(gB).b(new d.a() { // from class: com.baidu.swan.apps.scheme.g.3.2
                                        @Override // com.baidu.swan.apps.res.widget.b.d.a
                                        public void IP() {
                                            callbackHandler.handleSchemeDispatchCallback(optString2, "");
                                        }
                                    }).IN();
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

    private int gB(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return (int) Float.parseFloat(str);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private boolean q(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
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
            return a(context, unitedSchemeEntity, callbackHandler, true);
        } catch (JSONException e) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
    }

    private boolean r(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        return a(context, unitedSchemeEntity, callbackHandler, false);
    }

    private boolean a(Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final boolean z) {
        String param = unitedSchemeEntity.getParam("params");
        if (aOZ != null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
        } else {
            try {
                JSONArray jSONArray = new JSONArray();
                JSONArray jSONArray2 = new JSONArray();
                String string = context.getString(a.h.aiapps_picker_default_title);
                if (!TextUtils.isEmpty(param)) {
                    JSONObject jSONObject = new JSONObject(param);
                    jSONArray = jSONObject.optJSONArray("array");
                    jSONArray2 = jSONObject.optJSONArray("current");
                    string = jSONObject.optString("title", string);
                }
                aOZ = new d.a(context).j(jSONArray).k(jSONArray2).bO(z).a(new BdMultiPicker.b() { // from class: com.baidu.swan.apps.scheme.g.6
                    @Override // com.baidu.swan.apps.res.ui.BdMultiPicker.b
                    public void a(BdMultiPicker bdMultiPicker, JSONObject jSONObject2) {
                        String optString = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity).optString("cb");
                        if (!TextUtils.isEmpty(optString)) {
                            callbackHandler.handleSchemeDispatchCallback(optString, jSONObject2.toString());
                        }
                    }
                }).d(string).b(a.h.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.scheme.g.5
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        com.baidu.swan.apps.res.widget.dialog.e unused = g.aOZ = null;
                        try {
                            JSONArray currentIndex = ((com.baidu.swan.apps.res.widget.dialog.d) dialogInterface).getCurrentIndex();
                            JSONObject jSONObject2 = new JSONObject();
                            if (currentIndex != null && currentIndex.length() > 0) {
                                if (z) {
                                    jSONObject2.put(UBC.CONTENT_KEY_VALUE, currentIndex.optInt(0));
                                } else {
                                    jSONObject2.put(UBC.CONTENT_KEY_VALUE, currentIndex);
                                }
                            }
                            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject2, 0));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }).c(a.h.aiapps_cancel, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.scheme.g.4
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        com.baidu.swan.apps.res.widget.dialog.e unused = g.aOZ = null;
                        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                    }
                }).Is();
            } catch (JSONException e) {
                if (com.baidu.swan.apps.b.DEBUG) {
                    e.printStackTrace();
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            }
        }
        return false;
    }

    private boolean s(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        String param = unitedSchemeEntity.getParam("params");
        if (TextUtils.isEmpty(param)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        } else if (aOZ == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else {
            try {
                JSONObject jSONObject = new JSONObject(param);
                int i = jSONObject.getInt("column");
                JSONArray optJSONArray = jSONObject.optJSONArray("array");
                int i2 = jSONObject.getInt("current");
                if (optJSONArray != null) {
                    ((com.baidu.swan.apps.res.widget.dialog.d) aOZ).a(i, optJSONArray, i2);
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

    private boolean t(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        UnitedSchemeStatisticUtil.doUBCForInvalidScheme(unitedSchemeEntity.getUri(), "unknown action");
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302);
        return false;
    }
}

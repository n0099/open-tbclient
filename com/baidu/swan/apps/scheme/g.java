package com.baidu.swan.apps.scheme;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
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
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeAbsDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.UnitedSchemeStatisticUtil;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.an.ac;
import com.baidu.swan.apps.an.ad;
import com.baidu.swan.apps.an.z;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.res.ui.BdMultiPicker;
import com.baidu.swan.apps.res.widget.b.d;
import com.baidu.swan.apps.res.widget.dialog.d;
import com.baidu.swan.apps.res.widget.dialog.e;
import com.baidu.swan.apps.res.widget.dialog.g;
import com.baidu.swan.apps.res.widget.dialog.h;
import com.baidu.swan.apps.res.widget.floatlayer.a;
import com.baidu.swan.apps.res.widget.loadingview.LoadingView;
import com.baidu.swan.apps.storage.PathType;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.u.b.n;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.ubc.UBC;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes2.dex */
public class g extends UnitedSchemeBaseDispatcher {
    private static com.baidu.swan.apps.res.widget.dialog.g aRd;

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
            jSONObject.put("imei", ac.OX());
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
        if (!(context instanceof a.InterfaceC0170a)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "context not support");
            return false;
        }
        com.baidu.swan.apps.res.widget.floatlayer.a ve = ((a.InterfaceC0170a) context).ve();
        View view = ve.getView();
        if (view instanceof LoadingView) {
            loadingView = (LoadingView) view;
        } else {
            loadingView = new LoadingView(context);
            ve.ae(loadingView);
        }
        if (!TextUtils.isEmpty(optString)) {
            loadingView.setMsg(optString);
        }
        ve.setMask(optBoolean);
        unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    private boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        if (!(context instanceof a.InterfaceC0170a)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "not support FloatLayer");
            return false;
        }
        com.baidu.swan.apps.res.widget.floatlayer.a ve = ((a.InterfaceC0170a) context).ve();
        if (ve.getView() instanceof LoadingView) {
            ve.reset();
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
            JSONArray j = j(optJSONArray);
            int a = a(jSONObject, j);
            if (a < 0 || a >= j.length()) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            String[] strArr = new String[j.length()];
            for (int i = 0; i < j.length(); i++) {
                strArr[i] = j.getString(i);
            }
            com.baidu.swan.apps.u.a.DQ().a(context, strArr, a);
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

    private JSONArray j(JSONArray jSONArray) {
        com.baidu.swan.apps.ae.b Lq;
        if (jSONArray != null && jSONArray.length() > 0 && (Lq = com.baidu.swan.apps.ae.b.Lq()) != null && !TextUtils.isEmpty(Lq.id) && !TextUtils.isEmpty(Lq.getVersion())) {
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    String string = jSONArray.getString(i);
                    PathType hz = com.baidu.swan.apps.storage.b.hz(string);
                    if (hz == PathType.BD_FILE) {
                        string = com.baidu.swan.apps.storage.b.aE(string, Lq.id);
                    } else if (hz == PathType.RELATIVE) {
                        string = com.baidu.swan.apps.storage.b.a(string, Lq, Lq.getVersion());
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
        ad.bW(context).setText(optParamsAsJo.optString("data"));
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    private boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        boolean z = false;
        if (unitedSchemeEntity != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (ad.bW(context).getText() != null) {
                    jSONObject.put("data", ad.bW(context).getText().toString());
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
                    z = true;
                } else {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "NullException");
                }
            } catch (JSONException e) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "JSONException");
            }
        }
        return z;
    }

    private boolean h(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        if (unitedSchemeEntity == null) {
            return false;
        }
        String Hf = SwanAppNetworkUtils.Hf();
        if (TextUtils.isEmpty(Hf)) {
            Hf = "unknown";
        } else if ("no".equals(Hf)) {
            Hf = "none";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("networkType", Hf);
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
        JSONObject by = by(context);
        if (by == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty joData");
            return false;
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(by, 0));
        return true;
    }

    private JSONObject by(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        windowManager.getDefaultDisplay().getSize(new Point());
        windowManager.getDefaultDisplay().getRectSize(new Rect());
        Configuration configuration = context.getResources().getConfiguration();
        Pair<Integer, Integer> FK = com.baidu.swan.apps.w.e.FV().FK();
        Pair<Integer, Integer> FJ = com.baidu.swan.apps.w.e.FV().FJ();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Constants.PHONE_BRAND, Build.BRAND);
            jSONObject.put("model", Build.MODEL);
            jSONObject.put("pixelRatio", displayMetrics.density);
            jSONObject.put("devicePixelRatio", displayMetrics.density);
            jSONObject.put("screenWidth", z.af(((Integer) FK.first).intValue()));
            jSONObject.put("screenHeight", z.af(((Integer) FK.second).intValue()));
            jSONObject.put("windowWidth", (int) (((Integer) FJ.first).intValue() / displayMetrics.density));
            jSONObject.put("windowHeight", (int) (((Integer) FJ.second).intValue() / displayMetrics.density));
            jSONObject.put(IjkMediaMeta.IJKM_KEY_LANGUAGE, a(configuration));
            jSONObject.put("version", ac.getVersionName());
            jSONObject.put("system", "Android " + Build.VERSION.RELEASE);
            jSONObject.put("platform", "android");
            jSONObject.put("fontSizeSetting", 1);
            jSONObject.put("SDKVersion", bz(context));
            jSONObject.put("swanNativeVersion", com.baidu.swan.apps.c.getVersion());
            jSONObject.put("host", com.baidu.swan.apps.u.a.DN().getHostName());
            jSONObject.put("statusBarHeight", z.af(z.getStatusBarHeight()));
            jSONObject.put("navigationBarHeight", z.af(z.ON()));
            Z(jSONObject);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }

    private void Z(@NonNull JSONObject jSONObject) throws JSONException {
        com.baidu.swan.apps.ae.b Lq = com.baidu.swan.apps.ae.b.Lq();
        if (Lq != null && Lq.Lu().hf("mapp_location")) {
            n DU = com.baidu.swan.apps.u.a.DU();
            com.baidu.swan.apps.scheme.actions.e.b Ex = DU == null ? null : DU.Ex();
            if (Ex != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("city", Ex.city);
                jSONObject2.put("cityCode", Ex.cityCode);
                jSONObject2.put("country", Ex.country);
                jSONObject2.put("district", Ex.district);
                jSONObject2.put("province", Ex.province);
                jSONObject2.put("street", Ex.street);
                jSONObject2.put("streetNumber", Ex.streetNumber);
                jSONObject.put("cacheLocation", jSONObject2);
            }
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

    private static String bz(Context context) {
        int i = 0;
        if (context instanceof SwanAppActivity) {
            i = ((SwanAppActivity) context).vc();
        }
        if (i == 1) {
            return com.baidu.swan.apps.swancore.b.a((SwanCoreVersion) null, i);
        }
        return com.baidu.swan.apps.swancore.b.a(com.baidu.swan.apps.core.j.c.Bi().BA(), i);
    }

    private boolean j(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        if (unitedSchemeEntity == null) {
            return false;
        }
        JSONObject by = by(context);
        if (by == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty joData");
            return false;
        }
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(by, 0);
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
        Date gT = gT(optString);
        Date gT2 = gT(optString2);
        Date gT3 = gT(optString3);
        if (gT == null || gT2 == null || gT2.before(gT) || gT3 == null || gT3.before(gT) || gT3.after(gT2)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        h.a aVar = new h.a(context);
        if (!TextUtils.isEmpty(optString4)) {
            aVar.gx(optString4);
        }
        aVar.j(gT).k(gT2).l(gT3).ch(optBoolean).cm(a.h.aiapps_picker_time_title).b(a.h.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.scheme.g.8
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                String format = String.format("%02d:%02d", Integer.valueOf(((com.baidu.swan.apps.res.widget.dialog.h) dialogInterface).getHour()), Integer.valueOf(((com.baidu.swan.apps.res.widget.dialog.h) dialogInterface).getMinute()));
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
        }).KK();
        return true;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:26:0x0049 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:31:0x000c */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:32:0x0001 */
    private Date gT(String str) {
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
        Date aM = com.baidu.swan.apps.an.e.aM(optString, "yyyy-MM-dd");
        Date aM2 = com.baidu.swan.apps.an.e.aM(optString2, "yyyy-MM-dd");
        if (aM == null || aM2 == null || aM2.before(aM)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        Date date2 = new Date();
        if (TextUtils.isEmpty(optString3) || (date = com.baidu.swan.apps.an.e.e(optString3, new String[]{"yyyy-MM-dd", "yyyy-MM", "yyyy"})) == null) {
            date = date2;
        }
        if (date.before(aM)) {
            date = aM;
        } else if (date.after(aM2)) {
            date = aM2;
        }
        d.a aVar = new d.a(context);
        if (!TextUtils.isEmpty(optString4)) {
            aVar.gv(optString4);
        }
        aVar.g(aM).h(aM2).i(date).bW(optBoolean).cm(a.h.aiapps_picker_date_title).b(a.h.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.scheme.g.10
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                if (dialogInterface instanceof com.baidu.swan.apps.res.widget.dialog.d) {
                    String KC = ((com.baidu.swan.apps.res.widget.dialog.d) dialogInterface).KC();
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put(UBC.CONTENT_KEY_VALUE, KC);
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
        }).c(a.h.aiapps_cancel, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.scheme.g.9
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                dialogInterface.dismiss();
            }
        }).KK();
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
        g.a aVar = new g.a(context);
        aVar.d(optParamsAsJo.optString("title")).gw(optParamsAsJo.optString("content")).a(new com.baidu.swan.apps.view.b.a()).cb(false);
        if (optParamsAsJo.optBoolean("showCancel", true)) {
            aVar.D(optParamsAsJo.optString("cancelColor"), a.c.aiapps_modal_cancel_color);
            String optString2 = optParamsAsJo.optString("cancelText");
            if (TextUtils.isEmpty(optString2)) {
                optString2 = context.getString(a.h.aiapps_cancel);
            }
            aVar.d(optString2, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.scheme.g.11
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
        aVar.C(optParamsAsJo.optString("confirmColor"), a.c.aiapps_modal_confirm_color);
        aVar.c(optString, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.scheme.g.12
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
        aVar.KK();
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
                    optString = com.baidu.swan.apps.ae.a.c.gG(optString);
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
        g.a a = new g.a(context).bZ(true).cg(true).ce(true).cb(true).a(new com.baidu.swan.apps.view.b.a()).dp(context.getResources().getDimensionPixelSize(a.d.aiapps_action_sheet_bottom_divider)).dx(a.e.aiapps_action_sheet_bg).c(a.h.aiapps_cancel, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.scheme.g.14
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(201, "showActionSheet:fail cancel"));
            }
        }).a(new DialogInterface.OnCancelListener() { // from class: com.baidu.swan.apps.scheme.g.13
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(201, "showActionSheet:fail cancel"));
            }
        });
        View inflate = View.inflate(context, a.g.aiapps_scheme_utils_show_action_sheet, null);
        ListView listView = (ListView) inflate.findViewById(a.f.list);
        listView.setAdapter((ListAdapter) new BaseAdapter() { // from class: com.baidu.swan.apps.scheme.g.15
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
        a.KI();
        a.dq(l(context, arrayList.size()));
        final com.baidu.swan.apps.res.widget.dialog.g Aq = a.Aq();
        Window window = Aq.getWindow();
        if (window != null) {
            window.setGravity(80);
            window.setLayout(z.bS(context), -2);
            window.setWindowAnimations(a.i.action_sheet_animation);
        }
        Aq.bV(false);
        Aq.setCanceledOnTouchOutside(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.swan.apps.scheme.g.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("tapIndex", i3);
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
                    Aq.dismiss();
                } catch (JSONException e2) {
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(201));
                }
            }
        });
        Aq.show();
        return true;
    }

    private int l(Context context, int i) {
        int bS;
        Resources resources = context.getResources();
        int dimensionPixelSize = ((resources.getDimensionPixelSize(a.d.aiapps_action_sheet_bottom_divider) + ((i + 1) * resources.getDimensionPixelSize(a.d.aiapps_action_sheet_list_item))) + i) - 1;
        return (!z.OM() || dimensionPixelSize <= (bS = z.bS(context) - z.getStatusBarHeight())) ? dimensionPixelSize : bS;
    }

    private boolean o(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.scheme.g.3
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.res.widget.b.d.Lj();
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
                final int gU = gU(optString);
                if (gU <= 0) {
                    gU = 2;
                }
                ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.scheme.g.4
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
                                com.baidu.swan.apps.res.widget.b.d.a(context, string2).dG(gU).Ld();
                                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                                return;
                            case 1:
                                com.baidu.swan.apps.res.widget.b.d.a(context, string2).d(null).dG(gU).Lg();
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
                                    com.baidu.swan.apps.res.widget.b.d.bw(context).f(uri).dF(i).e(optString4).f(string2).g(optString5).dD(2).dE(i2).dG(gU).b(new d.a() { // from class: com.baidu.swan.apps.scheme.g.4.1
                                        @Override // com.baidu.swan.apps.res.widget.b.d.a
                                        public void Lk() {
                                            callbackHandler.handleSchemeDispatchCallback(optString2, "");
                                        }
                                    }).Li();
                                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                                    return;
                                } else {
                                    com.baidu.swan.apps.res.widget.b.d.bw(context).f(uri).dF(i).e(optString4).f(string2).g(optString5).dD(1).dE(i2).dG(gU).b(new d.a() { // from class: com.baidu.swan.apps.scheme.g.4.2
                                        @Override // com.baidu.swan.apps.res.widget.b.d.a
                                        public void Lk() {
                                            callbackHandler.handleSchemeDispatchCallback(optString2, "");
                                        }
                                    }).Li();
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

    private int gU(String str) {
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
        if (aRd != null) {
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
                aRd = new e.a(context).h(jSONArray).i(jSONArray2).bY(z).a(new BdMultiPicker.b() { // from class: com.baidu.swan.apps.scheme.g.7
                    @Override // com.baidu.swan.apps.res.ui.BdMultiPicker.b
                    public void a(BdMultiPicker bdMultiPicker, JSONObject jSONObject2) {
                        String optString = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity).optString("cb");
                        if (!TextUtils.isEmpty(optString)) {
                            callbackHandler.handleSchemeDispatchCallback(optString, jSONObject2.toString());
                        }
                    }
                }).d(string).b(a.h.aiapps_ok, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.scheme.g.6
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        com.baidu.swan.apps.res.widget.dialog.g unused = g.aRd = null;
                        try {
                            JSONArray currentIndex = ((com.baidu.swan.apps.res.widget.dialog.e) dialogInterface).getCurrentIndex();
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
                }).c(a.h.aiapps_cancel, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.scheme.g.5
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        com.baidu.swan.apps.res.widget.dialog.g unused = g.aRd = null;
                        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                    }
                }).KK();
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
        } else if (aRd == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        } else {
            try {
                JSONObject jSONObject = new JSONObject(param);
                int i = jSONObject.getInt("column");
                JSONArray optJSONArray = jSONObject.optJSONArray("array");
                int i2 = jSONObject.getInt("current");
                if (optJSONArray != null) {
                    ((com.baidu.swan.apps.res.widget.dialog.e) aRd).a(i, optJSONArray, i2);
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

package com.baidu.searchbox.command;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.baidu.android.util.android.ActivityUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.IntentConstants;
import com.baidu.searchbox.LibRouterConfig;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.common.security.JsHttpSecureStatistic;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.HostConfig;
import com.baidu.searchbox.unitedscheme.UnitedSchemeMainDispatcher;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.searchbox.util.BaiduIdentityManager;
import com.baidu.ubc.UBCManager;
import com.baidubce.auth.NTLMEngineImpl;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class CommandUtils {
    public static final String APPEND_PUBLIC_PARAMS = "1";
    public static final String APPEND_SEARCH_PARAMS = "2";
    public static final String COMMAND_MODE_ASSEMBLE = "4";
    public static final String COMMAND_MODE_BAIDU_URL = "3";
    public static final String COMMAND_MODE_BOX = "0";
    public static final String COMMAND_MODE_PLUGIN = "5";
    public static final String COMMAND_MODE_RN = "6";
    public static final String COMMAND_MODE_RN_COMBO = "7";
    public static final String COMMAND_MODE_THIRD = "1";
    public static final String COMMAND_MODE_URL = "2";
    public static final boolean DEBUG = LibRouterConfig.GLOBAL_DEBUG;
    public static final String INTENT_TARGET_COMMAND_NAME_KEY = "targetCommand";
    public static final String NEED_APPEND = "1";
    public static final String PARAMS_COMMANDS = "commands";
    public static final String PARAM_APPEND = "append";
    public static final String PARAM_APPID = "appid";
    public static final String PARAM_AP_M = "ap_m";
    public static final String PARAM_AP_V = "ap_v";
    public static final String PARAM_BROWSER_TYPE = "browser";
    public static final String PARAM_CLASS = "class";
    public static final String PARAM_CSRC = "csrc";
    public static final String PARAM_DYNA_URL_KEY = "dyna_url_key";
    public static final String PARAM_HTTP_STYLE = "http_style";
    public static final String PARAM_INTENT = "intent";
    public static final String PARAM_MIN_V = "min_v";
    public static final String PARAM_MODE = "mode";
    public static final String PARAM_NEW_WINDOW = "nw";
    public static final String PARAM_NO_BACK_WINDOW = "nobw";
    public static final String PARAM_PARAKEY = "parakey";
    public static final String PARAM_TCBOX = "tcbox";
    public static final String PARAM_UBC = "ubc";
    public static final String PARAM_URL = "url";
    public static final String PLUGIN_KEY = "pluginKey";
    public static final String RNTAG = "BundleManager";
    public static final String RN_KEY = "rn_search_box_key";
    public static final String TAG = "CommandUtils";
    public static final String TRANSITION_ANIMATION = "animation";
    public static final String VALUE_BROWSER_APPEND_LOC_PARAM = "append_loc_param";
    public static final String VALUE_BROWSER_IN_LIGHT = "light";
    public static final String VALUE_BROWSER_IN_MAIN = "main";

    public static String dynaAttachHost(boolean z, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (z) {
            return HostConfig.getXSearchboxHostForHttps() + str;
        }
        return HostConfig.getSearchboxHostForHttps() + str;
    }

    public static boolean invokeCommand(Context context, CommandEntity commandEntity) {
        return invokeCommand(context, commandEntity, false);
    }

    public static boolean isCommandAvailable(Context context, String str) {
        try {
            return isCommandAvailable(context, new JSONObject(str));
        } catch (JSONException unused) {
            return false;
        }
    }

    public static void addParaToIntent(JSONObject jSONObject, JSONArray jSONArray, Intent intent) {
        if (jSONArray != null && intent != null && intent.getAction() != null && intent.getAction().equals("com.baidu.searchbox.plugin.action.INVOKE")) {
            JSONObject optJSONObject = jSONObject.optJSONObject(PARAM_PARAKEY);
            String stringExtra = intent.getStringExtra("params");
            if (stringExtra != null && optJSONObject != null) {
                stringExtra = addParaToUrl(optJSONObject, jSONArray, stringExtra, 0);
            }
            intent.putExtra("params", stringExtra);
            if (intent.getStringExtra(IntentConstants.Plugin.EXTRA_WEBSITE_URL) != null) {
                addParaToUrl(optJSONObject, jSONArray, stringExtra, 1);
            }
            intent.putExtra(IntentConstants.Plugin.EXTRA_WEBSITE_URL, stringExtra);
            if (intent.hasExtra("intent")) {
                String stringExtra2 = intent.getStringExtra("intent");
                if (!TextUtils.isEmpty(stringExtra2)) {
                    try {
                        Intent parseUri = Intent.parseUri(stringExtra2, 1);
                        if (parseUri != null && TextUtils.equals(parseUri.getAction(), "com.baidu.appsearch.extinvoker.LAUNCH")) {
                            if (jSONArray.length() > 0) {
                                try {
                                    Object obj = jSONArray.get(0);
                                    if (obj != null) {
                                        parseUri.putExtra("query", obj.toString());
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                            intent.putExtra("intent", parseUri.toUri(1));
                        }
                    } catch (URISyntaxException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    public static String processCommandUrlParams(Context context, JSONObject jSONObject, String str) {
        String addSearchSourceParam;
        if (TextUtils.equals("1", jSONObject.optString(PARAM_APPEND)) && !str.startsWith(IntentConstants.Browser.SCHEME_SEARCH)) {
            JSONObject optJSONObject = jSONObject.optJSONObject(PARAM_AP_V);
            Context appContext = AppRuntime.getAppContext();
            if (optJSONObject != null) {
                String optString = optJSONObject.optString(PARAM_AP_M);
                if (TextUtils.equals(optString, "1")) {
                    addSearchSourceParam = BaiduIdentityManager.getInstance(appContext).processUrl(str);
                } else if (TextUtils.equals(optString, "2")) {
                    String processWebSearchUrl = BaiduIdentityManager.getInstance(appContext).processWebSearchUrl(str, true);
                    String optString2 = optJSONObject.optString("csrc");
                    if (!TextUtils.isEmpty(optString2)) {
                        addSearchSourceParam = BaiduIdentityManager.getInstance(appContext).addSearchSourceParam(processWebSearchUrl, optString2);
                    } else {
                        return processWebSearchUrl;
                    }
                } else {
                    return str;
                }
                return addSearchSourceParam;
            }
            return BaiduIdentityManager.getInstance(appContext).processUrl(str);
        }
        return str;
    }

    public static String addParaToUrl(JSONObject jSONObject, JSONArray jSONArray, String str, int i) {
        if (jSONArray != null && jSONObject != null) {
            try {
                if (jSONObject.length() > 0) {
                    int length = jSONArray.length();
                    Iterator<String> keys = jSONObject.keys();
                    int i2 = 0;
                    while (keys.hasNext()) {
                        String next = keys.next();
                        String str2 = next + "=";
                        String str3 = next + "=" + jSONArray.optString(i2);
                        for (int i3 = 0; i3 < i; i3++) {
                            str2 = URLEncoder.encode(str2, "UTF-8");
                            str3 = URLEncoder.encode(str3, "UTF-8");
                        }
                        str = str.replace(str2, str3);
                        i2++;
                        if (i2 == length) {
                            break;
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return str;
    }

    public static Intent getModeBaiduURLCommand(Context context, JSONObject jSONObject, int i, JSONArray jSONArray) throws JSONException {
        Intent parseUri;
        String string = jSONObject.getString("url");
        if (jSONObject.optJSONObject(PARAM_PARAKEY) != null && jSONArray != null && jSONArray.length() > 0) {
            string = addParaToUrl(jSONObject.getJSONObject(PARAM_PARAKEY), jSONArray, string, 0);
        }
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        String str = HostConfig.getSearchboxHostForHttps() + string;
        String optString = jSONObject.optString("intent");
        if (!TextUtils.isEmpty(optString)) {
            try {
                parseUri = Intent.parseUri(optString, i);
            } catch (URISyntaxException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
                return null;
            }
        } else {
            parseUri = new Intent();
        }
        Intent intent = parseUri;
        Context appContext = AppRuntime.getAppContext();
        intent.setAction(IntentConstants.ACTION_VIEW);
        intent.setClassName(appContext.getPackageName(), IntentConstants.ActivityClass.MAINACTIVITY_CLASS_NAME);
        intent.setData(Uri.parse(BaiduIdentityManager.getInstance(appContext).processUrl(str)));
        return intent;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0073, code lost:
        if (r5 == false) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Intent getModeThirdApp(Context context, JSONObject jSONObject, int i, JSONArray jSONArray) {
        Intent intent;
        Intent intent2 = null;
        try {
            intent = Intent.parseUri(jSONObject.getString("intent"), i);
        } catch (URISyntaxException | JSONException e) {
            if (DEBUG) {
                Log.d(TAG, e.getMessage());
            }
            intent = null;
        }
        if (intent == null) {
            return null;
        }
        PackageManager packageManager = AppRuntime.getAppContext().getPackageManager();
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
        if (queryIntentActivities.size() > 0 && jSONObject.has(PARAM_MIN_V)) {
            int optInt = jSONObject.optInt(PARAM_MIN_V);
            boolean z = false;
            for (int i2 = 0; i2 < queryIntentActivities.size(); i2++) {
                String str = queryIntentActivities.get(i2).activityInfo.packageName;
                try {
                    PackageInfo packageInfo = packageManager.getPackageInfo(str, 1);
                    if (packageInfo != null && packageInfo.versionCode >= optInt) {
                        intent.setPackage(str);
                        optInt = packageInfo.versionCode;
                        z = true;
                    }
                } catch (PackageManager.NameNotFoundException e2) {
                    if (DEBUG) {
                        Log.d(TAG, e2.getMessage());
                    }
                }
            }
        }
        intent2 = intent;
        addParaToIntent(jSONObject, jSONArray, intent2);
        return intent2;
    }

    public static String createCommand(String str, Intent intent, String str2, String str3, String str4, boolean z, String str5, String str6) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mode", str);
            if (TextUtils.equals("0", str)) {
                if (intent == null) {
                    return null;
                }
                jSONObject.put("intent", intent.toUri(1));
                if (!TextUtils.isEmpty(str3)) {
                    jSONObject.put("class", str3);
                }
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put(PARAM_MIN_V, str2);
                }
            } else if (TextUtils.equals("1", str)) {
                if (intent == null) {
                    return null;
                }
                jSONObject.put("intent", intent.toUri(1));
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put(PARAM_MIN_V, str2);
                }
            } else if (TextUtils.equals("2", str)) {
                if (TextUtils.isEmpty(str4)) {
                    return null;
                }
                jSONObject.put("url", str4);
                if (z) {
                    jSONObject.put(PARAM_APPEND, "1");
                }
                if (!TextUtils.isEmpty(str5)) {
                    jSONObject.put("browser", str5);
                }
                if (!TextUtils.isEmpty(str6)) {
                    jSONObject.put("appid", str6);
                }
            } else if (TextUtils.equals("3", str) && !TextUtils.isEmpty(str4)) {
                jSONObject.put("url", str4);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static void doUBCForCommand(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("command", str);
            jSONObject.put("ext", jSONObject2.toString());
            jSONObject.put("value", String.valueOf(i));
            jSONObject.put("from", UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE);
            jSONObject.put("type", "command");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
        if (uBCManager != null) {
            uBCManager.onEvent(UnitedSchemeMainDispatcher.UBC_INSIDE_INVOKE_TO_TAYGET_ID, jSONObject.toString());
        }
    }

    public static Intent getValidRNIntentFromCommands(Context context, JSONObject jSONObject) {
        final Context appContext;
        final ArrayList<Intent> parseCommands;
        final Intent[] intentArr = {null};
        if (jSONObject == null || (parseCommands = parseCommands((appContext = AppRuntime.getAppContext()), jSONObject.optJSONArray(PARAMS_COMMANDS), null)) == null || parseCommands.size() == 0) {
            return null;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.searchbox.command.CommandUtils.1
                @Override // java.lang.Runnable
                public void run() {
                    intentArr[0] = CommandUtils.getRNIntentFromList(parseCommands, appContext);
                    countDownLatch.countDown();
                }
            });
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        } else {
            intentArr[0] = getRNIntentFromList(parseCommands, appContext);
        }
        return intentArr[0];
    }

    public static void execCommandWrapper(Context context, CommandEntity commandEntity) {
        JSONObject jSONObject;
        String stringExtra;
        if (commandEntity != null && (jSONObject = commandEntity.mCommand) != null && jSONObject.has(PARAM_TCBOX)) {
            JSONObject jSONObject2 = null;
            try {
                jSONObject2 = commandEntity.mCommand.getJSONObject(PARAM_TCBOX);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
            if (jSONObject2 != null) {
                execTCBoxCommandWrapper(AppRuntime.getAppContext(), jSONObject2);
            }
            Intent intent = commandEntity.mIntent;
            if (intent != null && (stringExtra = intent.getStringExtra("ubc")) != null) {
                execUBCCommandWrapper(stringExtra);
            }
        }
    }

    public static void execTCBoxCommandWrapper(Context context, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        JSONArray names = jSONObject.names();
        HashMap hashMap = new HashMap();
        for (int i = 0; i < names.length(); i++) {
            try {
                String string = names.getString(i);
                if (!TextUtils.isEmpty(string)) {
                    String string2 = jSONObject.getString(string);
                    if (TextUtils.isEmpty(string2)) {
                        string2 = "";
                    }
                    hashMap.put(string, string2);
                }
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                    return;
                }
                return;
            }
        }
        RouterRuntime.getICommandIoc().sendGMVLog(hashMap);
    }

    public static void execUBCCommandWrapper(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("actionId");
            JSONObject optJSONObject = jSONObject.optJSONObject("value");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator<String> keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                linkedHashMap.put(next, optJSONObject.optString(next));
            }
            if (!TextUtils.isEmpty(optString) && !linkedHashMap.isEmpty()) {
                ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).onEvent(optString, linkedHashMap);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static Intent getModeBoxCommand(Context context, JSONObject jSONObject, int i) {
        return innerParseCommandJson(context, jSONObject, i);
    }

    public static Intent getModePluginCommand(Context context, JSONObject jSONObject, JSONArray jSONArray) {
        Intent innerParseCommandJson = innerParseCommandJson(context, jSONObject, 1);
        if (innerParseCommandJson != null) {
            innerParseCommandJson.putExtra(PLUGIN_KEY, "5");
            addParaToIntent(jSONObject, jSONArray, innerParseCommandJson);
        }
        return innerParseCommandJson;
    }

    public static Intent getModeRNCommand(Context context, JSONObject jSONObject, int i) {
        return innerParseCommandJson(context, jSONObject, i);
    }

    @DebugTrace
    public static boolean invokeCommand(Context context, String str, Bundle bundle) {
        return invokeCommand(context, str, bundle, false);
    }

    public static Intent parseCommand(Context context, String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return parseCommand(AppRuntime.getAppContext(), new JSONObject(str), i);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<Intent> parseCommands(Context context, JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return null;
        }
        Context appContext = AppRuntime.getAppContext();
        ArrayList<Intent> arrayList = new ArrayList<>();
        for (int i = 0; i < jSONArray.length(); i++) {
            Intent parseCommandEx = parseCommandEx(appContext, jSONArray.optJSONObject(i), 1, jSONArray2);
            if (parseCommandEx != null) {
                arrayList.add(parseCommandEx);
            }
        }
        return arrayList;
    }

    public static Intent getModeURLCommand(Context context, JSONObject jSONObject, int i, JSONArray jSONArray) throws JSONException {
        Intent parseUri;
        String string = jSONObject.getString("url");
        Intent intent = null;
        if (!TextUtils.isEmpty(string)) {
            if (jSONObject.optJSONObject(PARAM_PARAKEY) != null && jSONArray != null && jSONArray.length() > 0) {
                string = addParaToUrl(jSONObject.getJSONObject(PARAM_PARAKEY), jSONArray, string, 0);
            }
            String optString = jSONObject.optString("intent");
            if (!TextUtils.isEmpty(optString)) {
                try {
                    parseUri = Intent.parseUri(optString, i);
                } catch (URISyntaxException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                    return null;
                }
            } else {
                parseUri = new Intent();
            }
            intent = parseUri;
            Context appContext = AppRuntime.getAppContext();
            if (TextUtils.equals("light", jSONObject.optString("browser"))) {
                intent.setClassName(appContext.getPackageName(), IntentConstants.ActivityClass.LIGHTBROWSERACTIVITY_CLASS_NAME);
                intent.putExtra(IntentConstants.LightBrowser.START_BROWSER_URL_KEY, processCommandUrlParams(appContext, jSONObject, string));
                String optString2 = jSONObject.optString("appid");
                if (!TextUtils.isEmpty(optString2)) {
                    intent.putExtra(IntentConstants.LightBrowser.START_WALLET_APPID, optString2);
                }
            } else {
                String optString3 = jSONObject.optString("appid");
                if (!TextUtils.isEmpty(optString3)) {
                    intent.setAction(IntentConstants.ACTION_ALOADER_VIEW);
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("appid", optString3);
                        jSONObject2.put("url", string);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    intent.putExtra(IntentConstants.XSearch.XSEARCH_EXTRA_PAGEID, jSONObject2.toString());
                } else {
                    intent.setAction(IntentConstants.ACTION_VIEW);
                    intent.addFlags(NTLMEngineImpl.FLAG_REQUEST_128BIT_KEY_EXCH);
                    intent.setClassName(appContext.getPackageName(), IntentConstants.ActivityClass.LIGHTSEARCHACTIVITY_CLASS_NAME);
                    intent.setData(Uri.parse(processCommandUrlParams(appContext, jSONObject, string)));
                    intent.putExtra("doUserStickinessCollector", true);
                }
            }
            boolean optBoolean = jSONObject.optBoolean(PARAM_NEW_WINDOW);
            boolean optBoolean2 = jSONObject.optBoolean(PARAM_NO_BACK_WINDOW);
            if (optBoolean) {
                intent.putExtra(IntentConstants.Browser.EXTRA_URL_NEW_WINDOW, true);
                if (!optBoolean2) {
                    intent.putExtra(IntentConstants.Browser.EXTRA_HAS_BACK_WINDOW, true);
                }
            }
        }
        return intent;
    }

    public static Intent getRNIntentFromList(List<Intent> list, Context context) {
        for (int i = 0; i < list.size(); i++) {
            if (isRNCommand(list.get(i))) {
                String stringExtra = list.get(i).getStringExtra("rn_bundle_id");
                if (RouterRuntime.getICommandIoc().checkTargetIntentForRN(list.get(i))) {
                    Intent intent = list.get(i);
                    if (DEBUG) {
                        Log.d(RNTAG, stringExtra + " 使用RN形态成功");
                        return intent;
                    }
                    return intent;
                }
            } else if (ActivityUtils.isIntentAvailable(context, list.get(i))) {
                return list.get(i);
            }
        }
        return null;
    }

    public static Intent getValidIntentFromCommands(Context context, JSONObject jSONObject, JSONArray jSONArray) {
        Context appContext;
        ArrayList<Intent> parseCommands;
        if (jSONObject == null || (parseCommands = parseCommands((appContext = AppRuntime.getAppContext()), jSONObject.optJSONArray(PARAMS_COMMANDS), jSONArray)) == null || parseCommands.size() == 0) {
            return null;
        }
        for (int i = 0; i < parseCommands.size(); i++) {
            if (isPluginCommand(parseCommands.get(i))) {
                if (RouterRuntime.getICommandIoc().checkOpenable(appContext, parseCommands.get(i))) {
                    return parseCommands.get(i);
                }
            } else if (ActivityUtils.isIntentAvailable(appContext, parseCommands.get(i))) {
                return parseCommands.get(i);
            }
        }
        return null;
    }

    public static Intent innerParseCommandJson(Context context, JSONObject jSONObject, int i) {
        Intent intent = null;
        try {
            String string = jSONObject.getString("intent");
            String optString = jSONObject.optString(PARAM_MIN_V);
            if (!TextUtils.isEmpty(optString)) {
                String versionCode = AppConfig.AppInfo.getVersionCode();
                if (TextUtils.isEmpty(versionCode) || Integer.parseInt(versionCode) < Integer.parseInt(optString)) {
                    return null;
                }
            }
            Context appContext = AppRuntime.getAppContext();
            String optString2 = jSONObject.optString("class");
            intent = Intent.parseUri(string, i);
            if (TextUtils.isEmpty(optString2)) {
                intent.setPackage(appContext.getPackageName());
            } else {
                intent.setClassName(appContext.getPackageName(), optString2);
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("ubc");
            if (optJSONObject != null) {
                intent.putExtra("ubc", optJSONObject.toString());
            }
            String optString3 = jSONObject.optString(PARAM_DYNA_URL_KEY);
            if (!TextUtils.isEmpty(optString3)) {
                String stringExtra = intent.getStringExtra(optString3);
                if (!TextUtils.isEmpty(stringExtra)) {
                    intent.putExtra(optString3, dynaAttachHost(jSONObject.optBoolean(PARAM_HTTP_STYLE, false), stringExtra));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (DEBUG) {
                Log.e(TAG, "parseCommandJson exception:" + e.getMessage());
            }
        }
        return intent;
    }

    public static boolean invokeCommand(Context context, CommandEntity commandEntity, boolean z) {
        JSONObject jSONObject;
        Intent intent;
        List<ResolveInfo> queryIntentActivities;
        Context appContext = AppRuntime.getAppContext();
        if (commandEntity != null && (intent = commandEntity.mIntent) != null) {
            if (intent.hasExtra(PLUGIN_KEY)) {
                commandEntity.mIntent.removeExtra(PLUGIN_KEY);
            }
            if (z && (queryIntentActivities = context.getPackageManager().queryIntentActivities(commandEntity.mIntent, 64)) != null && queryIntentActivities.size() > 0) {
                if (DEBUG) {
                    Log.i(TAG, "invokeCommand onlyThisApp:" + z + ",packageName:" + queryIntentActivities.get(0).activityInfo.packageName);
                }
                boolean z2 = false;
                for (ResolveInfo resolveInfo : queryIntentActivities) {
                    if (TextUtils.equals(resolveInfo.activityInfo.packageName, AppRuntime.getAppContext().getPackageName())) {
                        if (queryIntentActivities.size() > 1) {
                            commandEntity.mIntent.setPackage(appContext.getPackageName());
                        }
                        z2 = true;
                    }
                }
                if (!z2) {
                    new JsHttpSecureStatistic().setJsType("3").setCmd(commandEntity.mIntent.toString()).setPackageName(queryIntentActivities.get(0).activityInfo.packageName).statisticCmd();
                    return false;
                }
            }
            execCommandWrapper(appContext, commandEntity);
            boolean startActivitySafely = ActivityUtils.startActivitySafely(appContext, commandEntity.mIntent, false);
            doUBCForCommand(commandEntity.mCommand.toString(), 0);
            return startActivitySafely;
        }
        Toast.makeText(appContext, (int) com.baidu.tieba.R.string.obfuscated_res_0x7f0f00ba, 0).show();
        if (commandEntity == null || (jSONObject = commandEntity.mCommand) == null) {
            return false;
        }
        doUBCForCommand(jSONObject.toString(), 1);
        return false;
    }

    @DebugTrace
    public static boolean invokeCommand(Context context, String str) {
        return invokeCommand(context, str, (Bundle) null);
    }

    public static boolean isCommandAvailable(Context context, JSONObject jSONObject) {
        Context appContext;
        Intent parseCommand;
        if (jSONObject == null || (parseCommand = parseCommand((appContext = AppRuntime.getAppContext()), jSONObject, 1)) == null) {
            return false;
        }
        if (isPluginCommand(parseCommand)) {
            return RouterRuntime.getICommandIoc().checkOpenable(appContext, parseCommand);
        }
        return ActivityUtils.isIntentAvailable(appContext, parseCommand);
    }

    @DebugTrace
    public static boolean invokeCommand(Context context, String str, Bundle bundle, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return invokeCommand(context, new JSONObject(str), null, bundle, z);
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    @DebugTrace
    public static boolean invokeCommand(Context context, String str, boolean z) {
        return invokeCommand(context, str, null, z);
    }

    public static Intent parseCommand(Context context, JSONObject jSONObject, int i) {
        return parseCommandEx(context, jSONObject, i, null);
    }

    public static boolean invokeCommand(Context context, JSONObject jSONObject, JSONArray jSONArray) {
        return invokeCommand(context, jSONObject, jSONArray, null, false);
    }

    public static boolean invokeCommand(Context context, JSONObject jSONObject, JSONArray jSONArray, Bundle bundle, boolean z) {
        Context appContext = AppRuntime.getAppContext();
        Intent parseCommandEx = parseCommandEx(context, jSONObject, 1, jSONArray);
        if (parseCommandEx != null) {
            if (bundle != null && bundle.size() > 0) {
                parseCommandEx.putExtras(bundle);
            }
            return invokeCommand(context, new CommandEntity(jSONObject.toString(), parseCommandEx), z);
        }
        Toast.makeText(appContext, (int) com.baidu.tieba.R.string.obfuscated_res_0x7f0f00ba, 0).show();
        return false;
    }

    public static boolean isPluginCommand(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(PLUGIN_KEY);
            if (!TextUtils.isEmpty(stringExtra)) {
                return TextUtils.equals("5", stringExtra);
            }
            return false;
        }
        return false;
    }

    public static boolean isRNCommand(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(RN_KEY);
            if (!TextUtils.isEmpty(stringExtra)) {
                return TextUtils.equals("6", stringExtra);
            }
            return false;
        }
        return false;
    }

    public static boolean isSearchCommand(Intent intent) {
        if (intent == null) {
            return false;
        }
        String dataString = intent.getDataString();
        if (!TextUtils.equals(intent.getAction(), IntentConstants.ACTION_VIEW) || TextUtils.isEmpty(dataString) || !dataString.startsWith(IntentConstants.Browser.SCHEME_SEARCH)) {
            return false;
        }
        return true;
    }

    public static Intent parseCommandEx(Context context, JSONObject jSONObject, int i, JSONArray jSONArray) {
        String string;
        Intent validRNIntentFromCommands;
        Intent intent = null;
        if (jSONObject == null) {
            return null;
        }
        try {
            string = jSONObject.getString("mode");
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        if (TextUtils.equals("0", string)) {
            validRNIntentFromCommands = getModeBoxCommand(context, jSONObject, i);
        } else if (TextUtils.equals("1", string)) {
            validRNIntentFromCommands = getModeThirdApp(context, jSONObject, i, jSONArray);
        } else if (TextUtils.equals("2", string)) {
            validRNIntentFromCommands = getModeURLCommand(context, jSONObject, i, jSONArray);
        } else if (TextUtils.equals("3", string)) {
            validRNIntentFromCommands = getModeBaiduURLCommand(context, jSONObject, i, jSONArray);
        } else if (TextUtils.equals("4", string)) {
            validRNIntentFromCommands = getValidIntentFromCommands(context, jSONObject, jSONArray);
        } else if (TextUtils.equals("5", string)) {
            validRNIntentFromCommands = getModePluginCommand(context, jSONObject, jSONArray);
        } else if (TextUtils.equals("6", string)) {
            validRNIntentFromCommands = getModeRNCommand(context, jSONObject, 1);
        } else {
            if (TextUtils.equals("7", string)) {
                validRNIntentFromCommands = getValidRNIntentFromCommands(context, jSONObject);
            }
            if (AppConfig.AppInfo.isModifyPkg() && intent != null && intent.getComponent() != null) {
                intent.setComponent(new ComponentName(AppConfig.AppInfo.getPackageName(), intent.getComponent().getClassName()));
            }
            return intent;
        }
        intent = validRNIntentFromCommands;
        if (AppConfig.AppInfo.isModifyPkg()) {
            intent.setComponent(new ComponentName(AppConfig.AppInfo.getPackageName(), intent.getComponent().getClassName()));
        }
        return intent;
    }
}

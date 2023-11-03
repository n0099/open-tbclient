package com.baidu.searchbox.wordscommand.request;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.sp.SharedPrefsWrapper;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.DefaultSharedPrefsWrapper;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.wordscommand.WordCommandManager;
import com.baidu.searchbox.wordscommand.bussiness.InvokeParamsManager;
import com.baidu.searchbox.wordscommand.config.WordCommandUrlConfig;
import com.baidu.searchbox.wordscommand.data.CommandContent;
import com.baidu.searchbox.wordscommand.data.CommandToken;
import com.baidu.searchbox.wordscommand.event.WordCommandEvent;
import com.baidu.searchbox.wordscommand.listener.IGetCommandContentListener;
import com.baidu.searchbox.wordscommand.listener.IGetCommonTokenListener;
import com.baidu.searchbox.wordscommand.runtime.WordCommandRuntime;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.searchbox.wordscommand.util.InvokeParamsSpUtil;
import com.baidu.searchbox.wordscommand.util.WordCommandNetRequest;
import com.baidu.tieba.b40;
import java.util.HashMap;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class WordCommandRequest {
    public static final String KEY_ALBUMSCAN = "albumscan";
    public static final String KEY_COMMAND_KEY = "key";
    public static final String KEY_COMMAND_TYPE = "is_image";
    public static final String KEY_CONTENT = "content";
    public static final String KEY_DATA = "data";
    public static final String KEY_IS_EXECUTE_WORD_COMMAND_REQUEST = "key_is_execute_word_command_request";
    public static final String KEY_IS_FIRST = "is_first";
    public static final String KEY_LAST_SCHEME = "last_scheme";
    public static final String KEY_REGEX = "regex";
    public static final String KEY_REGEX_VERSION = "regex_version";
    public static final String KEY_REGEX_ZH = "regex_zh";
    public static final String KEY_TOKEN = "token";
    public static final String KEY_VERSION = "version";
    public static final String RESPONSE_ERRORNO = "errno";
    public static final String TAG = "WordCommandRequest";
    public static final boolean DEBUG = WordCommandRuntime.DEBUG;
    public static final SharedPrefsWrapper SHARED_PREFS_WRAPPER = new SharedPrefsWrapper("");

    public static void getWordCommandConfigFromServer() {
        String wordCommandRegexUrl = WordCommandUrlConfig.getWordCommandRegexUrl();
        HashMap hashMap = new HashMap();
        hashMap.put("version", DefaultSharedPrefsWrapper.getInstance().getString(KEY_REGEX_VERSION, "0"));
        WordCommandNetRequest.makePostRequest(wordCommandRegexUrl, hashMap, new ResponseCallback<JSONObject>() { // from class: com.baidu.searchbox.wordscommand.request.WordCommandRequest.1
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onSuccess(JSONObject jSONObject, int i) {
                String optString = jSONObject.optString(WordCommandRequest.KEY_ALBUMSCAN);
                String optString2 = jSONObject.optString(WordCommandRequest.KEY_REGEX);
                String optString3 = jSONObject.optString(WordCommandRequest.KEY_REGEX_ZH);
                if (!TextUtils.isEmpty(optString2)) {
                    WordCommandManager.getInstance().setWordCommandRegex(optString2);
                }
                if (!TextUtils.isEmpty(optString3)) {
                    WordCommandManager.getInstance().setWordCommandRegexZH(optString3);
                }
                if (!TextUtils.isEmpty(optString)) {
                    WordCommandManager.getInstance().setPicWordCommandEnable(optString);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public JSONObject parseResponse(Response response, int i) throws Exception {
                ResponseBody body;
                JSONObject optJSONObject;
                if (!response.isSuccessful() || (body = response.body()) == null) {
                    return null;
                }
                String string = body.string();
                if (!TextUtils.isEmpty(string)) {
                    JSONObject jSONObject = new JSONObject(string);
                    if (jSONObject.has("errno") && jSONObject.optInt("errno") == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null && optJSONObject.length() != 0) {
                        DefaultSharedPrefsWrapper.getInstance().putString(WordCommandRequest.KEY_REGEX_VERSION, optJSONObject.optString("version"));
                        return optJSONObject.optJSONObject("data");
                    }
                }
                return null;
            }
        });
    }

    public static void getWordCommandContent(String str, String str2, final IGetCommandContentListener iGetCommandContentListener) {
        String wordCommandContentUrl = WordCommandUrlConfig.getWordCommandContentUrl();
        HashMap hashMap = new HashMap();
        hashMap.put("token", str);
        String string = InvokeParamsSpUtil.getInstance().getString("is_first", "0");
        if (TextUtils.equals(string, "1")) {
            InvokeParamsSpUtil.getInstance().putString("is_first", "0");
        }
        hashMap.put("is_first", string);
        hashMap.put(KEY_COMMAND_TYPE, str2);
        String invokeSchemeFromSp = InvokeParamsManager.getInvokeSchemeFromSp();
        if (!TextUtils.isEmpty(invokeSchemeFromSp)) {
            hashMap.put(KEY_LAST_SCHEME, invokeSchemeFromSp);
        }
        WordCommandNetRequest.makePostRequest(wordCommandContentUrl, hashMap, new ResponseCallback<CommandContent>() { // from class: com.baidu.searchbox.wordscommand.request.WordCommandRequest.3
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                if (WordCommandRequest.DEBUG) {
                    Log.d(WordCommandRequest.TAG, "WordCommandRequest getWordCommandContent() Fail, Exception: " + exc.toString());
                }
                BdEventBus.Companion.getDefault().post(new WordCommandEvent(201));
                b40.b(CommandUBCHelper.COMMAND_UBC_TIME_SERVER_ERROR);
                b40.c(CommandUBCHelper.COMMAND_UBC_ERROR_TYPE, CommandUBCHelper.COMMAND_UBC_ERROR_TYPE_SERVER);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onSuccess(CommandContent commandContent, int i) {
                if (AppConfig.isDebug()) {
                    Log.d(WordCommandRequest.TAG, "onSuccess: ");
                }
                IGetCommandContentListener iGetCommandContentListener2 = IGetCommandContentListener.this;
                if (iGetCommandContentListener2 != null) {
                    iGetCommandContentListener2.getCommandContent(commandContent);
                }
                if (commandContent == null) {
                    BdEventBus.Companion.getDefault().post(new WordCommandEvent(201));
                } else {
                    WordCommandRequest.SHARED_PREFS_WRAPPER.putBoolean(WordCommandRequest.KEY_IS_EXECUTE_WORD_COMMAND_REQUEST, true);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public CommandContent parseResponse(Response response, int i) throws Exception {
                JSONObject optJSONObject;
                if (response.isSuccessful()) {
                    ResponseBody body = response.body();
                    if (body == null) {
                        return null;
                    }
                    String string2 = body.string();
                    if (!TextUtils.isEmpty(string2)) {
                        JSONObject jSONObject = new JSONObject(string2);
                        if (!jSONObject.has("errno")) {
                            CommandUBCHelper.ubcStatistics(CommandUBCHelper.WORD_COMMAND_PARSE_DIALOG, CommandUBCHelper.COMMAND_UBC_TYPE_CODE_LOG, CommandUBCHelper.COMMAND_UBC_SOURCE_RECEIVE, "false", null);
                            return null;
                        }
                        CommandUBCHelper.ubcStatistics(CommandUBCHelper.WORD_COMMAND_PARSE_DIALOG, CommandUBCHelper.COMMAND_UBC_TYPE_CODE_LOG, CommandUBCHelper.COMMAND_UBC_SOURCE_RECEIVE, String.valueOf(jSONObject.optInt("errno")), null);
                        if (jSONObject.optInt("errno") != 0 || (optJSONObject = jSONObject.optJSONObject("data")) == null) {
                            return null;
                        }
                        return new CommandContent(optJSONObject);
                    }
                    CommandUBCHelper.ubcStatistics(CommandUBCHelper.WORD_COMMAND_PARSE_DIALOG, CommandUBCHelper.COMMAND_UBC_TYPE_CODE_LOG, CommandUBCHelper.COMMAND_UBC_SOURCE_RECEIVE, "false", null);
                } else {
                    CommandUBCHelper.ubcStatistics(CommandUBCHelper.WORD_COMMAND_PARSE_DIALOG, CommandUBCHelper.COMMAND_UBC_TYPE_CODE_LOG, CommandUBCHelper.COMMAND_UBC_SOURCE_RECEIVE, "false", null);
                }
                return null;
            }
        });
        CommandUBCHelper.ubcStatistics(CommandUBCHelper.WORD_COMMAND_PARSE_DIALOG, CommandUBCHelper.COMMAND_UBC_TYPE_CODE_LOG, CommandUBCHelper.COMMAND_UBC_SOURCE_SEND, null, null);
    }

    public static void getWordCommandToken(String str, String str2, final IGetCommonTokenListener iGetCommonTokenListener) {
        String wordCommandTokenUrl = WordCommandUrlConfig.getWordCommandTokenUrl();
        HashMap hashMap = new HashMap();
        hashMap.put("key", str);
        hashMap.put("content", str2);
        WordCommandNetRequest.makePostRequest(wordCommandTokenUrl, hashMap, new ResponseCallback<CommandToken>() { // from class: com.baidu.searchbox.wordscommand.request.WordCommandRequest.2
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                IGetCommonTokenListener iGetCommonTokenListener2 = IGetCommonTokenListener.this;
                if (iGetCommonTokenListener2 != null) {
                    iGetCommonTokenListener2.onFail(exc);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onSuccess(CommandToken commandToken, int i) {
                IGetCommonTokenListener iGetCommonTokenListener2 = IGetCommonTokenListener.this;
                if (iGetCommonTokenListener2 != null) {
                    iGetCommonTokenListener2.onSuccess(commandToken);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public CommandToken parseResponse(Response response, int i) throws Exception {
                ResponseBody body;
                JSONObject optJSONObject;
                if (!response.isSuccessful() || (body = response.body()) == null) {
                    return null;
                }
                String string = body.string();
                if (!TextUtils.isEmpty(string)) {
                    JSONObject jSONObject = new JSONObject(string);
                    if (jSONObject.optInt("errno") != 0 || (optJSONObject = jSONObject.optJSONObject("data")) == null) {
                        return null;
                    }
                    return new CommandToken(optJSONObject);
                }
                return null;
            }
        });
    }
}

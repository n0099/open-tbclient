package com.baidu.searchbox.ng.ai.apps.network;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.ar.util.IoUtils;
import com.baidu.sapi2.utils.SapiEnv;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.ng.ai.apps.network.NetworkDef;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.ng.ai.apps.storage.StorageUtil;
import com.baidu.searchbox.ng.ai.apps.util.AiAppMD5Utils;
import com.baidu.searchbox.ng.ai.apps.util.AiAppStreamUtils;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsFileUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.webkit.internal.ETAG;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSink;
import okio.Okio;
import okio.Source;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AigRequestAction extends BaseRequestAction implements NetworkDef {
    private static final String ACTION_TYPE = "/swan/aiRequest";
    private static final boolean DEBUG = false;
    private static final String MIME_TYPE_APPLICATION_JSON = "application/json";
    private static final String TAG = "aiRequestAction";

    public AigRequestAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, ACTION_TYPE);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.network.BaseRequestAction, com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final AiApp aiApp) {
        if (aiApp == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "aiApp is null");
            return false;
        }
        JSONObject paramAsJo = getParamAsJo(unitedSchemeEntity, "params");
        if (paramAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal params");
            return false;
        }
        final String param = unitedSchemeEntity.getParam("callback");
        if (TextUtils.isEmpty(param)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal callback");
            return false;
        }
        Request buildRequest = buildRequest(unitedSchemeEntity, paramAsJo, aiApp);
        if (buildRequest != null) {
            aiApp.getNetwork().call(buildRequest, new Callback() { // from class: com.baidu.searchbox.ng.ai.apps.network.AigRequestAction.1
                @Override // okhttp3.Callback
                public void onFailure(Call call, IOException iOException) {
                    callbackHandler.handleSchemeDispatchCallback(param, UnitedSchemeUtility.wrapCallbackParams(1001, "request IOException").toString());
                }

                @Override // okhttp3.Callback
                public void onResponse(Call call, Response response) throws IOException {
                    try {
                        String header = response.header("Content-Type", "");
                        if (header != null && header.contains(AigRequestAction.MIME_TYPE_APPLICATION_JSON)) {
                            try {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put(BaseRequestAction.PARAMS_STATUSCODE, response.code());
                                jSONObject.put("header", BaseRequestAction.toJo(response.headers()));
                                jSONObject.put(NetworkDef.Http.BODY, response.body().string());
                                callbackHandler.handleSchemeDispatchCallback(param, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
                                return;
                            } catch (JSONException e) {
                                callbackHandler.handleSchemeDispatchCallback(param, UnitedSchemeUtility.wrapCallbackParams(1001, "response json error").toString());
                                return;
                            }
                        }
                        AiApp aiApp2 = aiApp;
                        String createTmpFile = StorageUtil.createTmpFile(AiApp.getAiAppId(), String.valueOf(System.currentTimeMillis()), "");
                        if (TextUtils.isEmpty(createTmpFile)) {
                            callbackHandler.handleSchemeDispatchCallback(param, UnitedSchemeUtility.wrapCallbackParams(1001, "bdfile error").toString());
                            return;
                        }
                        AiApp aiApp3 = aiApp;
                        String path2Scheme = StorageUtil.path2Scheme(createTmpFile, AiApp.getAiAppId());
                        if (TextUtils.isEmpty(path2Scheme)) {
                            callbackHandler.handleSchemeDispatchCallback(param, UnitedSchemeUtility.wrapCallbackParams(1001, "bdfile error").toString());
                            return;
                        }
                        InputStream byteStream = response.body().byteStream();
                        File file = new File(createTmpFile);
                        if (file.exists()) {
                            file.delete();
                            file.createNewFile();
                        }
                        if (AiAppStreamUtils.streamToFile(byteStream, file)) {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("filePath", path2Scheme);
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put(BaseRequestAction.PARAMS_STATUSCODE, response.code());
                            jSONObject3.put("header", BaseRequestAction.toJo(response.headers()));
                            jSONObject3.put(NetworkDef.Http.BODY, jSONObject2.toString());
                            callbackHandler.handleSchemeDispatchCallback(param, UnitedSchemeUtility.wrapCallbackParams(jSONObject3, 0).toString());
                            return;
                        }
                        callbackHandler.handleSchemeDispatchCallback(param, UnitedSchemeUtility.wrapCallbackParams(1001, "bdfile error").toString());
                    } catch (Exception e2) {
                        callbackHandler.handleSchemeDispatchCallback(param, UnitedSchemeUtility.wrapCallbackParams(201, e2.getMessage()).toString());
                    }
                }
            });
            return true;
        }
        return false;
    }

    @Nullable
    private Request buildRequest(UnitedSchemeEntity unitedSchemeEntity, @Nullable JSONObject jSONObject, AiApp aiApp) {
        if (unitedSchemeEntity == null) {
            return null;
        }
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("stringMap");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("fileMap");
            String optString = jSONObject.optString(NotificationCompat.CATEGORY_SERVICE);
            String optString2 = jSONObject.optString("api");
            if (optJSONObject == null || TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, BaseRequestAction.MESSAGE_ILLEGAL_REQUEST);
                return null;
            }
            MultipartBody.Builder type = new MultipartBody.Builder().setType(MultipartBody.FORM);
            Iterator<String> keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                type.addFormDataPart(next, optJSONObject.optString(next));
            }
            if (optJSONObject2 != null) {
                Iterator<String> keys2 = optJSONObject2.keys();
                while (keys2.hasNext()) {
                    String next2 = keys2.next();
                    String scheme2Path = StorageUtil.scheme2Path(optJSONObject2.optString(next2), AiApp.getAiAppId());
                    if (!TextUtils.isEmpty(scheme2Path)) {
                        File file = new File(scheme2Path);
                        if (!file.exists() || file.length() == 0) {
                            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "upload file not exist");
                            return null;
                        } else if (file.length() > 10485760) {
                            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "upload file too large");
                            return null;
                        } else {
                            type.addFormDataPart(next2, file.getName(), new UploadFileRequestBody(file));
                        }
                    }
                }
            }
            String appKey = aiApp.getAppKey();
            long j = AntiReplayToken.create().serverTime;
            String sign = sign(optJSONObject, appKey, j, getEncodeValue(AiAppsRuntime.getAiAppAccountRuntime().getEnCuid()));
            if (sign == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "sign error");
                return null;
            }
            HttpUrl parse = HttpUrl.parse(AiAppsRuntime.getAiAppAccountRuntime().processUrl(AiAppsRuntime.getConfigRuntime().getAiAppsCommonAiUrl() + "/" + optString + optString2));
            if (parse == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "request url error");
                return null;
            }
            MultipartBody build = type.build();
            HttpUrl.Builder newBuilder = parse.newBuilder();
            newBuilder.addQueryParameter("ai_sign", sign);
            newBuilder.addQueryParameter("api_key", appKey);
            newBuilder.addQueryParameter(HttpConstants.TIMESTAMP, String.valueOf(j));
            return new Request.Builder().url(newBuilder.build()).post(build).build();
        } catch (Exception e) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "execute exceptions");
            return null;
        }
    }

    private String getEncodeValue(String str) {
        try {
            return URLEncoder.encode(str, IoUtils.UTF_8);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return str;
        }
    }

    private String sign(JSONObject jSONObject, String str, long j, String str2) {
        try {
            Iterator<String> keys = jSONObject.keys();
            ArrayList<String> arrayList = new ArrayList();
            while (keys.hasNext()) {
                arrayList.add(keys.next());
            }
            Collections.sort(arrayList);
            StringBuilder sb = new StringBuilder();
            for (String str3 : arrayList) {
                String optString = jSONObject.optString(str3);
                sb.append(URLEncoder.encode(str3));
                sb.append(ETAG.EQUAL);
                sb.append(URLEncoder.encode(optString));
                sb.append(ETAG.ITEM_SEPARATOR);
            }
            String sb2 = sb.toString();
            if (sb2.endsWith(ETAG.ITEM_SEPARATOR)) {
                sb2 = sb2.substring(0, sb2.length() - 1);
            }
            String md5 = AiAppMD5Utils.toMd5(sb2.getBytes(), false);
            byte[] copyOf = Arrays.copyOf(Base64.decode(AiAppMD5Utils.toMd5(str.getBytes(), false), 0), 24);
            byte[] copyOf2 = Arrays.copyOf(Base64.decode(AiAppMD5Utils.toMd5(String.format("%s%d", str2, Long.valueOf(j)).getBytes(), false).getBytes(), 0), 16);
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            cipher.init(1, new SecretKeySpec(copyOf, SapiEnv.SHARE_ALGORITHM), new IvParameterSpec(copyOf2));
            String str4 = new String(Base64.encode(cipher.doFinal(md5.getBytes()), 0), "UTF-8");
            return str4.endsWith("\n") ? str4.substring(0, str4.length() - 1) : str4;
        } catch (Exception e) {
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public static class UploadFileRequestBody extends RequestBody {
        private static final String DEFAULT_MIME_TYPE = "image/jpeg";
        private static final long SEGMENT_SIZE = 2048;
        private final File mUploadFile;

        public UploadFileRequestBody(File file) {
            this.mUploadFile = file;
        }

        @Override // okhttp3.RequestBody
        public long contentLength() {
            return this.mUploadFile.length();
        }

        @Override // okhttp3.RequestBody
        public MediaType contentType() {
            return MediaType.parse(getMimeType(this.mUploadFile.getPath()));
        }

        @Override // okhttp3.RequestBody
        public void writeTo(BufferedSink bufferedSink) throws IOException {
            Source source = null;
            try {
                source = Okio.source(this.mUploadFile);
                int i = 0;
                while (true) {
                    long read = source.read(bufferedSink.buffer(), 2048L);
                    if (read != -1) {
                        i = (int) (read + i);
                        bufferedSink.flush();
                    } else {
                        return;
                    }
                }
            } finally {
                AiAppsFileUtils.closeSafely(source);
            }
        }

        public static String getMimeType(String str) {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            String str2 = DEFAULT_MIME_TYPE;
            if (str == null) {
                return DEFAULT_MIME_TYPE;
            }
            try {
                mediaMetadataRetriever.setDataSource(str);
                str2 = mediaMetadataRetriever.extractMetadata(12);
                if (str2 == null) {
                    return DEFAULT_MIME_TYPE;
                }
                return str2;
            } catch (IllegalArgumentException e) {
                return str2;
            } catch (IllegalStateException e2) {
                return str2;
            } catch (RuntimeException e3) {
                return str2;
            }
        }
    }
}

package com.baidu.swan.bdprivate.c.c;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.media.MimeType;
import com.baidu.live.tbadk.core.atomdata.BuyTBeanActivityConfig;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.searchbox.websocket.WebSocketRequest;
import com.baidu.swan.apps.h.c;
import com.baidu.swan.apps.network.f;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.d.d;
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
/* loaded from: classes11.dex */
public class a extends com.baidu.swan.apps.network.a implements f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public a(j jVar) {
        super(jVar, "/swan/aiRequest");
    }

    @Override // com.baidu.swan.apps.network.a, com.baidu.swan.apps.scheme.actions.ab
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final e eVar) {
        if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "swanApp is null");
            return false;
        }
        JSONObject b = b(unitedSchemeEntity, "params");
        if (b == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal params");
            return false;
        }
        final String param = unitedSchemeEntity.getParam(BuyTBeanActivityConfig.CALLBACK);
        if (TextUtils.isEmpty(param)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal callback");
            return false;
        }
        if (DEBUG) {
            Log.d("aiRequestAction", "schema params : " + b.toString());
            Log.d("aiRequestAction", "schema cb : " + param);
        }
        Request a = a(unitedSchemeEntity, b, eVar);
        if (a != null) {
            if (DEBUG) {
                Log.d("aiRequestAction", "build request : " + a.url().toString());
            }
            eVar.acR().a(a, new Callback() { // from class: com.baidu.swan.bdprivate.c.c.a.1
                @Override // okhttp3.Callback
                public void onFailure(Call call, IOException iOException) {
                    callbackHandler.handleSchemeDispatchCallback(param, UnitedSchemeUtility.wrapCallbackParams(1001, "request IOException").toString());
                    if (a.DEBUG) {
                        Log.d("aiRequestAction", "response fail : " + UnitedSchemeUtility.wrapCallbackParams(1001, iOException.getMessage()).toString());
                    }
                }

                @Override // okhttp3.Callback
                public void onResponse(Call call, Response response) throws IOException {
                    try {
                        String header = response.header("Content-Type", "");
                        if (header != null && header.contains("application/json")) {
                            try {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("statusCode", response.code());
                                jSONObject.put(WebSocketRequest.PARAM_KEY_HEADER, com.baidu.swan.apps.network.a.a(response.headers()));
                                jSONObject.put("body", response.body().string());
                                callbackHandler.handleSchemeDispatchCallback(param, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
                                if (a.DEBUG) {
                                    Log.d("aiRequestAction", "response json : " + UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
                                    return;
                                }
                                return;
                            } catch (JSONException e) {
                                callbackHandler.handleSchemeDispatchCallback(param, UnitedSchemeUtility.wrapCallbackParams(1001, "response json error").toString());
                                return;
                            }
                        }
                        e eVar2 = eVar;
                        String H = com.baidu.swan.apps.storage.b.H(e.acH(), String.valueOf(System.currentTimeMillis()), "");
                        if (TextUtils.isEmpty(H)) {
                            callbackHandler.handleSchemeDispatchCallback(param, UnitedSchemeUtility.wrapCallbackParams(1001, "bdfile error").toString());
                            return;
                        }
                        e eVar3 = eVar;
                        String br = com.baidu.swan.apps.storage.b.br(H, e.acH());
                        if (TextUtils.isEmpty(br)) {
                            callbackHandler.handleSchemeDispatchCallback(param, UnitedSchemeUtility.wrapCallbackParams(1001, "bdfile error").toString());
                            return;
                        }
                        InputStream byteStream = response.body().byteStream();
                        File file = new File(H);
                        if (file.exists()) {
                            file.delete();
                            file.createNewFile();
                        }
                        if (com.baidu.swan.d.f.streamToFile(byteStream, file)) {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("filePath", br);
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("statusCode", response.code());
                            jSONObject3.put(WebSocketRequest.PARAM_KEY_HEADER, com.baidu.swan.apps.network.a.a(response.headers()));
                            jSONObject3.put("body", jSONObject2.toString());
                            callbackHandler.handleSchemeDispatchCallback(param, UnitedSchemeUtility.wrapCallbackParams(jSONObject3, 0).toString());
                            if (a.DEBUG) {
                                Log.d("aiRequestAction", "response file : " + UnitedSchemeUtility.wrapCallbackParams(jSONObject3, 0).toString());
                                return;
                            }
                            return;
                        }
                        callbackHandler.handleSchemeDispatchCallback(param, UnitedSchemeUtility.wrapCallbackParams(1001, "bdfile error").toString());
                    } catch (Exception e2) {
                        if (a.DEBUG) {
                            e2.printStackTrace();
                        }
                        callbackHandler.handleSchemeDispatchCallback(param, UnitedSchemeUtility.wrapCallbackParams(201, e2.getMessage()).toString());
                    }
                }
            });
            return true;
        }
        return false;
    }

    @Nullable
    private Request a(UnitedSchemeEntity unitedSchemeEntity, @Nullable JSONObject jSONObject, e eVar) {
        if (unitedSchemeEntity == null) {
            return null;
        }
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("stringMap");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("fileMap");
            String optString = jSONObject.optString("service");
            String optString2 = jSONObject.optString("api");
            if (optJSONObject == null || TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal request");
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
                    String bp = com.baidu.swan.apps.storage.b.bp(optJSONObject2.optString(next2), e.acH());
                    if (!TextUtils.isEmpty(bp)) {
                        File file = new File(bp);
                        if (!file.exists() || file.length() == 0) {
                            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "upload file not exist");
                            return null;
                        } else if (file.length() > 10485760) {
                            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "upload file too large");
                            return null;
                        } else {
                            type.addFormDataPart(next2, file.getName(), new C0319a(file));
                        }
                    }
                }
            }
            String appKey = eVar.getAppKey();
            long j = com.baidu.swan.apps.h.b.Lb().serverTime;
            String a = a(optJSONObject, appKey, j, ci(com.baidu.swan.apps.w.a.Ub().br(AppRuntime.getAppContext())));
            if (a == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "sign error");
                return null;
            }
            HttpUrl parse = HttpUrl.parse(c.processCommonParams(com.baidu.swan.apps.h.a.KZ() + "/" + optString + optString2));
            if (parse == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "request url error");
                return null;
            }
            MultipartBody build = type.build();
            HttpUrl.Builder newBuilder = parse.newBuilder();
            newBuilder.addQueryParameter("ai_sign", a);
            newBuilder.addQueryParameter(Constants.API_KEY, appKey);
            newBuilder.addQueryParameter("timestamp", String.valueOf(j));
            return new Request.Builder().url(newBuilder.build()).post(build).build();
        } catch (Exception e) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "execute exceptions");
            return null;
        }
    }

    private String ci(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return str;
        }
    }

    private String a(JSONObject jSONObject, String str, long j, String str2) {
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
            String md5 = d.toMd5(sb2.getBytes(), false);
            byte[] copyOf = Arrays.copyOf(Base64.decode(d.toMd5(str.getBytes(), false), 0), 24);
            byte[] copyOf2 = Arrays.copyOf(Base64.decode(d.toMd5(String.format("%s%d", str2, Long.valueOf(j)).getBytes(), false).getBytes(), 0), 16);
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            cipher.init(1, new SecretKeySpec(copyOf, "AES"), new IvParameterSpec(copyOf2));
            String str4 = new String(Base64.encode(cipher.doFinal(md5.getBytes()), 0), "UTF-8");
            return str4.endsWith("\n") ? str4.substring(0, str4.length() - 1) : str4;
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: com.baidu.swan.bdprivate.c.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0319a extends RequestBody {
        private final File bGf;

        public C0319a(File file) {
            this.bGf = file;
        }

        @Override // okhttp3.RequestBody
        public long contentLength() {
            return this.bGf.length();
        }

        @Override // okhttp3.RequestBody
        public MediaType contentType() {
            return MediaType.parse(getMimeType(this.bGf.getPath()));
        }

        @Override // okhttp3.RequestBody
        public void writeTo(BufferedSink bufferedSink) throws IOException {
            Source source = null;
            try {
                source = Okio.source(this.bGf);
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
                com.baidu.swan.d.c.closeSafely(source);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [497=5, 498=5, 499=5, 500=5] */
        public static String getMimeType(String str) {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            String str2 = MimeType.Image.JPEG;
            if (str != null) {
                try {
                    mediaMetadataRetriever.setDataSource(str);
                    str2 = mediaMetadataRetriever.extractMetadata(12);
                    if (str2 == null) {
                        str2 = MimeType.Image.JPEG;
                    }
                    try {
                        mediaMetadataRetriever.release();
                    } catch (Exception e) {
                        if (a.DEBUG) {
                            e.printStackTrace();
                        }
                    }
                } catch (IllegalArgumentException e2) {
                    try {
                        mediaMetadataRetriever.release();
                    } catch (Exception e3) {
                        if (a.DEBUG) {
                            e3.printStackTrace();
                        }
                    }
                } catch (IllegalStateException e4) {
                    try {
                        mediaMetadataRetriever.release();
                    } catch (Exception e5) {
                        if (a.DEBUG) {
                            e5.printStackTrace();
                        }
                    }
                } catch (RuntimeException e6) {
                    try {
                        mediaMetadataRetriever.release();
                    } catch (Exception e7) {
                        if (a.DEBUG) {
                            e7.printStackTrace();
                        }
                    }
                } catch (Throwable th) {
                    try {
                        mediaMetadataRetriever.release();
                    } catch (Exception e8) {
                        if (a.DEBUG) {
                            e8.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
            return str2;
        }
    }
}

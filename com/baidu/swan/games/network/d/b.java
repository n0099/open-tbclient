package com.baidu.swan.games.network.d;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.searchbox.websocket.WebSocketRequest;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.v.f;
import com.baidu.swan.c.d;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b extends com.baidu.swan.games.network.a {
    private long dRM;

    public b(com.baidu.swan.games.f.b bVar, com.baidu.swan.games.binding.model.c cVar) {
        super(bVar, cVar);
        this.dRM = 0L;
        this.requestType = 3;
    }

    @Override // com.baidu.swan.games.network.a
    public void start() {
        Request aTV;
        if (this.dRr != null && (aTV = aTV()) != null) {
            if (e.aEU() == null) {
                k("", -1, "request:swanApp is null");
                return;
            }
            final String httpUrl = aTV.url().toString();
            final com.baidu.swan.games.network.b aFj = e.aEU().aFj();
            aFj.a(aTV, new Callback() { // from class: com.baidu.swan.games.network.d.b.1
                /* JADX WARN: Removed duplicated region for block: B:16:0x007b  */
                @Override // okhttp3.Callback
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onResponse(Call call, Response response) {
                    try {
                        try {
                            JSEvent jSEvent = new JSEvent("headersReceived");
                            jSEvent.data = new com.baidu.swan.games.network.c.e(b.this.a(response.headers()));
                            b.this.dispatchEvent(jSEvent);
                        } catch (IOException e) {
                            e = e;
                            if (b.DEBUG) {
                            }
                            b.this.k(httpUrl, -1, e.getMessage());
                            return;
                        }
                    } catch (JSONException e2) {
                        try {
                            if (b.DEBUG) {
                                e2.printStackTrace();
                            }
                        } catch (JSONException e3) {
                            e = e3;
                            if (b.DEBUG) {
                                Log.d("UploadFileTask", Log.getStackTraceString(e));
                            }
                            b.this.k(httpUrl, -1, e.getMessage());
                            return;
                        }
                    }
                    a aVar = new a();
                    aVar.statusCode = response.code();
                    aVar.header = b.this.a(response.headers());
                    aVar.data = b.this.a(response.body());
                    if (b.DEBUG) {
                        Log.d("UploadFileTask", "onResponse = " + aVar.data);
                    }
                    b.this.onSuccess(aVar);
                }

                @Override // okhttp3.Callback
                public void onFailure(Call call, IOException iOException) {
                    aFj.cancelTag(b.this.mTaskId);
                    b.this.l(httpUrl, 0, iOException.getMessage());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object a(ResponseBody responseBody) throws IOException {
        if (responseBody == null) {
            return null;
        }
        String string = responseBody.string();
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            return new JSONObject(string);
        } catch (JSONException e) {
            return string;
        }
    }

    private Request aTV() {
        final String aTO = aTO();
        if (TextUtils.isEmpty(aTO)) {
            return null;
        }
        String optString = this.dRr.optString("filePath");
        if (TextUtils.isEmpty(optString)) {
            k(aTO, -1, "uploadFile:filePath is empty or invalid");
            return null;
        } else if (d.yU(optString)) {
            k(aTO, -1, "uploadFile:filePath is empty or invalid");
            return null;
        } else if (this.dRr.wk(WebSocketRequest.PARAM_KEY_HEADER) && this.dRr.wj(WebSocketRequest.PARAM_KEY_HEADER) != 9) {
            k(aTO, -1, "uploadFile:header is invalid");
            return null;
        } else {
            File file = getFile(aTO, optString);
            if (file != null) {
                com.baidu.swan.games.binding.model.c wr = this.dRr.wr("formData");
                Request.Builder builder = new Request.Builder();
                final long length = file.length();
                com.baidu.swan.apps.network.c cVar = new com.baidu.swan.apps.network.c(file, "multipart/form-data", new com.baidu.swan.apps.network.b.a() { // from class: com.baidu.swan.games.network.d.b.2
                    @Override // com.baidu.swan.apps.network.b.a
                    public void bz(long j) {
                        b.this.b(length, j, aTO);
                    }
                });
                MultipartBody.Builder type = new MultipartBody.Builder().setType(MultipartBody.FORM);
                a(type, wr);
                type.addFormDataPart(this.dRr.optString("name"), file.getName(), cVar);
                MultipartBody build = type.build();
                a(builder, this.dRr.wr(WebSocketRequest.PARAM_KEY_HEADER), (Map<String, String>) new HashMap(), false);
                return builder.url(aTO).tag(this.mTaskId).post(build).build();
            }
            return null;
        }
    }

    private File getFile(String str, String str2) {
        String tr = f.axo().awU().tr(str2);
        if (TextUtils.isEmpty(tr) || TextUtils.equals(str2, tr)) {
            k(str, -1, "uploadFile:filePath is empty or invalid");
            return null;
        }
        File file = new File(tr);
        if (!file.exists() || !file.isFile()) {
            k(str, -1, "request:file not exists or not file");
            return null;
        } else if (file.length() > 26214400) {
            k(str, -1, "request:file size > 25 MB");
            return null;
        } else if (TextUtils.isEmpty(this.dRr.optString("name"))) {
            k(str, -1, "uploadFile:name is invalid");
            return null;
        } else if (!this.dRr.wk("formData") || this.dRr.wj("formData") == 9) {
            return file;
        } else {
            k(str, -1, "uploadFile:formData is invalid");
            return null;
        }
    }

    public static void a(MultipartBody.Builder builder, com.baidu.swan.games.binding.model.c cVar) {
        if (builder != null && cVar != null && cVar.length() >= 1) {
            for (String str : cVar.keySet()) {
                if (!TextUtils.isEmpty(str)) {
                    String cVar2 = cVar.toString(str);
                    if (!TextUtils.isEmpty(cVar2)) {
                        builder.addFormDataPart(str, cVar2);
                    }
                }
            }
        }
    }

    @Override // com.baidu.swan.games.network.a
    public void k(String str, int i, String str2) {
        super.k(str, i, str2);
        com.baidu.swan.games.v.c.c(str, i, str2, SwanAppNetworkUtils.isNetworkConnected(null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(String str, int i, String str2) {
        if (DEBUG) {
            Log.d("UploadFileTask", "onFailure: " + str2);
        }
        k(str, i, ("Socket is closed".equalsIgnoreCase(str2) || "Canceled".equalsIgnoreCase(str2)) ? "uploadFile:fail abort" : "uploadFile:fail abort");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j, long j2, String str) {
        if (j > 0 && j2 <= j && j2 != 0) {
            int floor = (int) Math.floor((100 * j2) / j);
            if (System.currentTimeMillis() - this.dRM > 500 || floor == 100) {
                if (floor <= 100) {
                    dispatchEvent(new JSEvent("progressUpdate", new c(floor, j, j2)));
                }
                this.dRM = System.currentTimeMillis();
            }
        }
    }
}

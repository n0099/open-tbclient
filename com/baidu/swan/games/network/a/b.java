package com.baidu.swan.games.network.a;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.searchbox.websocket.WebSocketRequest;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.network.a.a;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.g;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.v.f;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
/* loaded from: classes9.dex */
public class b extends com.baidu.swan.games.network.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private long mTime;

    public b(com.baidu.swan.games.f.b bVar, com.baidu.swan.games.binding.model.c cVar) {
        super(bVar, cVar);
        this.eiR = 2;
    }

    @Override // com.baidu.swan.games.network.a
    public void start() {
        if (this.eiS != null) {
            final String aXy = aXy();
            if (!TextUtils.isEmpty(aXy)) {
                if (e.aIK() == null) {
                    onError("", -1, "request:swanApp is null");
                    return;
                }
                final com.baidu.swan.games.network.b aIZ = e.aIK().aIZ();
                String optString = this.eiS.optString("filePath");
                if (!TextUtils.isEmpty(optString)) {
                    if (com.baidu.swan.c.d.yQ(optString)) {
                        onError(aXy, -1, "downloadFile:filePath is invalid");
                        return;
                    }
                    String[] split = optString.split("/");
                    if (TextUtils.isEmpty(split[split.length - 1])) {
                        onError(aXy, -1, "downloadFile:filePath is invalid");
                        return;
                    }
                }
                final com.baidu.swan.apps.storage.b.c azR = f.aAl().azR();
                final boolean sX = azR.sX(optString);
                if (sX && azR.aMd().cX(0L)) {
                    onError(aXy, -1, "downloadFile:fail exceed max size in usr");
                    return;
                }
                HashMap hashMap = new HashMap();
                Request.Builder builder = new Request.Builder();
                a(builder, this.eiS.wo(WebSocketRequest.PARAM_KEY_HEADER), hashMap, false);
                builder.url(aXy).tag(this.mTaskId).build();
                String yP = com.baidu.swan.c.d.yP(aXy);
                this.mTime = 0L;
                d dVar = new d();
                dVar.a(new a.InterfaceC0438a() { // from class: com.baidu.swan.games.network.a.b.1
                    @Override // com.baidu.swan.apps.network.a.a.InterfaceC0438a
                    public void cA(long j) {
                        b.this.onError(aXy, -1, "downloadFile:fail exceed max file size");
                        aIZ.cancelTag(b.this.mTaskId);
                    }

                    @Override // com.baidu.swan.apps.network.a.a.InterfaceC0438a
                    public void p(long j, long j2) {
                        b.this.onError(aXy, 0, "progress callback fail()");
                        aIZ.cancelTag(b.this.mTaskId);
                    }

                    @Override // com.baidu.swan.apps.network.a.a.InterfaceC0438a
                    public void d(int i, long j, long j2) {
                        if (System.currentTimeMillis() - b.this.mTime > 500) {
                            if (j2 > Config.RAVEN_LOG_LIMIT || j > Config.RAVEN_LOG_LIMIT) {
                                b.this.onError(aXy, -1, "downloadFile:fail exceed max file size");
                                aIZ.cancelTag(b.this.mTaskId);
                            } else {
                                if (i <= 100) {
                                    a aVar = new a(i, j2, j);
                                    JSEvent jSEvent = new JSEvent("progressUpdate");
                                    jSEvent.data = aVar;
                                    b.this.dispatchEvent(jSEvent);
                                }
                                if (sX && azR.aMd().cX(j)) {
                                    b.this.onError(aXy, -1, "downloadFile:fail exceed max file size");
                                    aIZ.cancelTag(b.this.mTaskId);
                                }
                            }
                            b.this.mTime = System.currentTimeMillis();
                        }
                    }
                });
                a(builder.build(), optString, yP, aIZ, dVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Request request, final String str, final String str2, com.baidu.swan.games.network.b bVar, d dVar) {
        final String httpUrl = request.url().toString();
        final com.baidu.swan.apps.storage.b.c azR = f.aAl().azR();
        final boolean sX = azR.sX(str);
        h.ab(httpUrl, 1);
        bVar.a(request, Collections.singletonList(dVar), new Callback() { // from class: com.baidu.swan.games.network.a.b.2
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                b.this.onError(httpUrl, 0, iOException.getMessage());
                if (SwanAppNetworkUtils.isNetworkConnected(null)) {
                    h.a(0, httpUrl, 1, iOException.getMessage());
                }
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) {
                String wZ;
                String str3;
                try {
                    JSEvent jSEvent = new JSEvent("headersReceived");
                    jSEvent.data = new com.baidu.swan.games.network.c.e(b.this.a(response.headers()));
                    b.this.dispatchEvent(jSEvent);
                } catch (JSONException e) {
                    if (b.DEBUG) {
                        e.printStackTrace();
                    }
                }
                if (TextUtils.isEmpty(str)) {
                    wZ = g.a(response, str2);
                } else {
                    wZ = b.this.wZ(str);
                }
                if (!TextUtils.isEmpty(wZ)) {
                    if (b.DEBUG) {
                        Log.d("DownloadTask", "the real file path is " + wZ);
                    }
                    if (TextUtils.isEmpty(str)) {
                        str3 = azR.tp(wZ);
                    } else {
                        str3 = str;
                    }
                    if (TextUtils.isEmpty(str3)) {
                        b.this.onError(httpUrl, -1, "parse tmpFilePath from realFilePath fail");
                        return;
                    }
                    int code = response.code();
                    String message = response.message();
                    c cVar = new c();
                    cVar.statusCode = code;
                    if (TextUtils.isEmpty(str)) {
                        cVar.tempFilePath = str3;
                    } else {
                        cVar.filePath = str3;
                    }
                    InputStream byteStream = response.body().byteStream();
                    File file = new File(wZ);
                    if (file.exists()) {
                        long length = file.length();
                        file.delete();
                        if (sX) {
                            azR.aMd().cW(-length);
                        }
                    }
                    if (b.this.streamToFile(byteStream, file)) {
                        if (sX) {
                            azR.aMd().cW(file.length());
                        }
                        b.this.onSuccess(cVar);
                    } else {
                        b.this.onError(httpUrl, -1, "downloadFile:fail abort");
                    }
                    com.baidu.swan.c.d.closeSafely(byteStream);
                    com.baidu.swan.c.d.closeSafely(response);
                    if (b.DEBUG) {
                        Log.d("DownloadTask", "onResponse: respCode: " + code + ", url=" + httpUrl + ", msg=" + message);
                    }
                    h.a(code, httpUrl, 1, message);
                    return;
                }
                b.this.onError(httpUrl, -1, "downloadFile:filePath is invalid");
            }
        });
    }

    @Nullable
    protected String wZ(@NonNull String str) {
        String str2 = f.aAl().azR().to(str);
        if (str2 == null) {
            return null;
        }
        boolean endsWith = str2.endsWith(File.separator);
        File parentFile = new File(str2).getParentFile();
        boolean z = parentFile != null && parentFile.exists();
        if (endsWith || !z) {
            return null;
        }
        return str2;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:31:0x004a */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v6, types: [boolean] */
    public boolean streamToFile(InputStream inputStream, File file) {
        FileOutputStream fileOutputStream;
        if (inputStream == null || file == null) {
            return false;
        }
        File parentFile = file.getParentFile();
        if (parentFile != null && (r2 = parentFile.exists()) == 0) {
            parentFile.mkdirs();
        }
        if (file.exists()) {
            file.delete();
        }
        try {
            try {
                fileOutputStream = new FileOutputStream(file);
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read != -1) {
                            fileOutputStream.write(bArr, 0, read);
                        } else {
                            fileOutputStream.flush();
                            com.baidu.swan.c.d.closeSafely(fileOutputStream);
                            return true;
                        }
                    }
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                    com.baidu.swan.c.d.closeSafely(fileOutputStream);
                    return false;
                }
            } catch (Throwable th) {
                th = th;
                com.baidu.swan.c.d.closeSafely(r2);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            ?? r2 = 0;
            com.baidu.swan.c.d.closeSafely(r2);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.games.network.a
    public void onError(String str, int i, String str2) {
        super.onError(str, i, str2);
        com.baidu.swan.games.v.c.b(str, i, str2, SwanAppNetworkUtils.isNetworkConnected(null));
    }
}

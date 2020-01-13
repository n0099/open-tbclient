package com.baidu.swan.games.network.a;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.searchbox.websocket.WebSocketRequest;
import com.baidu.swan.apps.as.o;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.network.a.a;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.y.f;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
/* loaded from: classes10.dex */
public class b extends com.baidu.swan.games.network.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static AtomicLong bMI = new AtomicLong(System.currentTimeMillis());
    private long mTime;

    public b(com.baidu.swan.games.e.b bVar, com.baidu.swan.games.binding.model.c cVar) {
        super(bVar, cVar);
        this.cma = 2;
    }

    @Override // com.baidu.swan.games.network.a
    public void start() {
        if (this.cmb != null) {
            final String amA = amA();
            if (!TextUtils.isEmpty(amA)) {
                if (e.aap() == null) {
                    h("", -1, "request:swanApp is null");
                    return;
                }
                final com.baidu.swan.games.network.b aaC = e.aap().aaC();
                String optString = this.cmb.optString("filePath");
                if (!TextUtils.isEmpty(optString)) {
                    if (com.baidu.swan.d.c.qT(optString)) {
                        h(amA, -1, "downloadFile:filePath is invalid");
                        return;
                    }
                    String[] split = optString.split("/");
                    if (TextUtils.isEmpty(split[split.length - 1])) {
                        h(amA, -1, "downloadFile:filePath is invalid");
                        return;
                    }
                }
                final com.baidu.swan.apps.storage.b.c Uj = f.UC().Uj();
                final boolean lF = Uj.lF(optString);
                if (lF && Uj.az(0L)) {
                    h(amA, -1, "downloadFile:fail exceed max size in usr");
                    return;
                }
                HashMap hashMap = new HashMap();
                Request.Builder builder = new Request.Builder();
                a(builder, this.cmb.or(WebSocketRequest.PARAM_KEY_HEADER), hashMap, false);
                builder.url(amA).tag(this.mTaskId).build();
                String qS = com.baidu.swan.d.c.qS(amA);
                this.mTime = 0L;
                d dVar = new d();
                dVar.a(new a.InterfaceC0257a() { // from class: com.baidu.swan.games.network.a.b.1
                    @Override // com.baidu.swan.apps.network.a.a.InterfaceC0257a
                    public void ao(long j) {
                        b.this.h(amA, -1, "downloadFile:fail exceed max file size");
                        aaC.cancelTag(b.this.mTaskId);
                    }

                    @Override // com.baidu.swan.apps.network.a.a.InterfaceC0257a
                    public void j(long j, long j2) {
                        b.this.h(amA, 0, "progress callback fail()");
                        aaC.cancelTag(b.this.mTaskId);
                    }

                    @Override // com.baidu.swan.apps.network.a.a.InterfaceC0257a
                    public void b(int i, long j, long j2) {
                        if (System.currentTimeMillis() - b.this.mTime > 500) {
                            if (j2 > Config.RAVEN_LOG_LIMIT || j > Config.RAVEN_LOG_LIMIT) {
                                b.this.h(amA, -1, "downloadFile:fail exceed max file size");
                                aaC.cancelTag(b.this.mTaskId);
                            } else {
                                if (i <= 100) {
                                    a aVar = new a(i, j2, j);
                                    JSEvent jSEvent = new JSEvent("progressUpdate");
                                    jSEvent.data = aVar;
                                    b.this.dispatchEvent(jSEvent);
                                }
                                if (lF && Uj.az(j)) {
                                    b.this.h(amA, -1, "downloadFile:fail exceed max file size");
                                    aaC.cancelTag(b.this.mTaskId);
                                }
                            }
                            b.this.mTime = System.currentTimeMillis();
                        }
                    }
                });
                a(builder.build(), optString, qS, aaC, dVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Request request, final String str, final String str2, com.baidu.swan.games.network.b bVar, d dVar) {
        final String httpUrl = request.url().toString();
        final com.baidu.swan.apps.storage.b.c Uj = f.UC().Uj();
        final boolean lF = Uj.lF(str);
        com.baidu.swan.apps.statistic.f.I(httpUrl, 1);
        bVar.a(request, Collections.singletonList(dVar), new Callback() { // from class: com.baidu.swan.games.network.a.b.2
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                b.this.h(httpUrl, 0, iOException.getMessage());
                if (SwanAppNetworkUtils.isNetworkConnected(null)) {
                    com.baidu.swan.apps.statistic.f.a(0, httpUrl, 1, iOException.getMessage());
                }
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) {
                String pc;
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
                    pc = b.this.a(response, str2);
                } else {
                    pc = b.this.pc(str);
                }
                if (!TextUtils.isEmpty(pc)) {
                    if (b.DEBUG) {
                        Log.d("DownloadTask", "the real file path is " + pc);
                    }
                    if (TextUtils.isEmpty(str)) {
                        str3 = Uj.lU(pc);
                    } else {
                        str3 = str;
                    }
                    if (TextUtils.isEmpty(str3)) {
                        b.this.h(httpUrl, -1, "parse tmpFilePath from realFilePath fail");
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
                    File file = new File(pc);
                    if (file.exists()) {
                        long length = file.length();
                        file.delete();
                        if (lF) {
                            Uj.aA(-length);
                        }
                    }
                    if (b.this.streamToFile(byteStream, file)) {
                        if (lF) {
                            Uj.aA(file.length());
                        }
                        b.this.onSuccess(cVar);
                    } else {
                        b.this.h(httpUrl, -1, "downloadFile:fail abort");
                    }
                    com.baidu.swan.d.c.closeSafely(byteStream);
                    com.baidu.swan.d.c.closeSafely(response);
                    if (b.DEBUG) {
                        Log.d("DownloadTask", "onResponse: respCode: " + code + ", url=" + httpUrl + ", msg=" + message);
                    }
                    com.baidu.swan.apps.statistic.f.a(code, httpUrl, 1, message);
                    return;
                }
                b.this.h(httpUrl, -1, "downloadFile:filePath is invalid");
            }
        });
    }

    @Nullable
    protected String pc(@NonNull String str) {
        String lT = f.UC().Uj().lT(str);
        if (lT == null) {
            return null;
        }
        boolean endsWith = lT.endsWith(File.separator);
        File parentFile = new File(lT).getParentFile();
        boolean z = parentFile != null && parentFile.exists();
        if (endsWith || !z) {
            return null;
        }
        return lT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public String a(Response response, String str) {
        String header = response.header("Content-Type", null);
        String str2 = "";
        if (!TextUtils.isEmpty(header)) {
            str2 = o.bUt.containsKey(header) ? o.bUt.get(header) : str;
        }
        return f.UC().Uj().lW(String.valueOf(bMI.getAndIncrement()) + (TextUtils.isEmpty(str2) ? "" : "." + str2));
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
                            com.baidu.swan.d.c.closeSafely(fileOutputStream);
                            return true;
                        }
                    }
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                    com.baidu.swan.d.c.closeSafely(fileOutputStream);
                    return false;
                }
            } catch (Throwable th) {
                th = th;
                com.baidu.swan.d.c.closeSafely(r2);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            ?? r2 = 0;
            com.baidu.swan.d.c.closeSafely(r2);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.games.network.a
    public void h(String str, int i, String str2) {
        super.h(str, i, str2);
        com.baidu.swan.games.u.c.b(str, i, str2, SwanAppNetworkUtils.isNetworkConnected(null));
    }
}

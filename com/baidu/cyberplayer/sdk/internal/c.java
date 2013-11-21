package com.baidu.cyberplayer.sdk.internal;

import android.content.Context;
import android.os.Environment;
import com.baidu.cyberplayer.sdk.BEngineManager;
import com.baidu.cyberplayer.sdk.internal.HttpUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends com.baidu.cyberplayer.sdk.internal.a {

    /* renamed from: a  reason: collision with root package name */
    private int f897a;

    /* renamed from: a  reason: collision with other field name */
    private long f25a;

    /* renamed from: a  reason: collision with other field name */
    private Context f26a;

    /* renamed from: a  reason: collision with other field name */
    private BEngineManager.OnEngineListener f27a;

    /* renamed from: a  reason: collision with other field name */
    private String f28a;

    /* renamed from: a  reason: collision with other field name */
    private Map<String, String> f29a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f30a;
    private int b;

    /* renamed from: b  reason: collision with other field name */
    private String f31b;

    /* renamed from: b  reason: collision with other field name */
    private boolean f32b;
    private int c;

    /* renamed from: c  reason: collision with other field name */
    private String f33c;

    /* renamed from: c  reason: collision with other field name */
    private boolean f34c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;

    static /* synthetic */ int a(c cVar, int i) {
        int i2 = cVar.b + i;
        cVar.b = i2;
        return i2;
    }

    static /* synthetic */ int c(c cVar, int i) {
        int i2 = cVar.f897a + i;
        cVar.f897a = i2;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements HttpUtils.OnNetListener {

        /* renamed from: a  reason: collision with other field name */
        private FileOutputStream f35a;

        private a() {
            this.f35a = null;
        }

        @Override // com.baidu.cyberplayer.sdk.internal.HttpUtils.OnNetListener
        public boolean onResponseCode(int i) {
            if (i == 200 || i == 206) {
                a();
                if (c.this.c > 0) {
                    if (i == 206) {
                        c.a(c.this, c.this.c);
                        c.this.f32b = true;
                    } else {
                        FileUtils.remove(c.this.f31b);
                        FileUtils.createNewFile(c.this.f31b);
                    }
                }
                try {
                    this.f35a = new FileOutputStream(c.this.f31b, true);
                    return true;
                } catch (Throwable th) {
                    LogUtils.e("CyberPlayerEngineInstallerHttp", "create engine stream file failed", new Object[0]);
                    c.this.a(4);
                    return false;
                }
            } else if (i == 416) {
                c.this.b();
                LogUtils.e("CyberPlayerEngineInstallerHttp", "[Status code: 416] Failed but has recovered. Please try again.", new Object[0]);
                return false;
            } else {
                LogUtils.e("CyberPlayerEngineInstallerHttp", "Status code: " + i + " returned from server when getting data of zeus engine", new Object[0]);
                return false;
            }
        }

        @Override // com.baidu.cyberplayer.sdk.internal.HttpUtils.OnNetListener
        public boolean onReceivedHeaders(Map<String, List<String>> map) {
            if (map == null) {
                LogUtils.e("CyberPlayerEngineInstallerHttp", "Response header is empty when getting data of zeus engine", new Object[0]);
                return false;
            }
            for (String str : map.keySet()) {
                if (str != null && HttpUtils.isHeaderEqueal(str, HttpUtils.HEADER_NAME_CONTENT_LENGTH)) {
                    for (String str2 : map.get(str)) {
                        if (str2 != null) {
                            c.this.f897a = Integer.parseInt(str2);
                        }
                    }
                } else if (str != null && HttpUtils.isHeaderEqueal(str, HttpUtils.HEADER_NAME_CONTENT_MD5)) {
                    for (String str3 : map.get(str)) {
                        if (str3 != null) {
                            c.this.f = str3;
                        }
                    }
                }
            }
            if (c.this.f897a > 0) {
                if (c.this.f32b) {
                    c.c(c.this, c.this.c);
                }
                return true;
            }
            LogUtils.e("CyberPlayerEngineInstallerHttp", "receive invalid content length", new Object[0]);
            return false;
        }

        @Override // com.baidu.cyberplayer.sdk.internal.HttpUtils.OnNetListener
        public boolean onReceivedData(byte[] bArr, int i, int i2) {
            boolean z = false;
            try {
                this.f35a.write(bArr, i, i2);
                c.a(c.this, i2);
            } catch (Throwable th) {
                c.this.a(4);
            }
            if (c.this.f27a != null) {
                int onDownload = c.this.f27a.onDownload(c.this.f897a, c.this.b);
                if (2 == onDownload) {
                    c.this.b();
                    c.this.a(3);
                } else if (1 == onDownload) {
                    c.this.a(2);
                }
                return z;
            }
            z = true;
            return z;
        }

        @Override // com.baidu.cyberplayer.sdk.internal.HttpUtils.OnNetListener
        public boolean onConnStart() {
            return true;
        }

        @Override // com.baidu.cyberplayer.sdk.internal.HttpUtils.OnNetListener
        public boolean onConnShutdown() {
            a();
            return c.this.m13c();
        }

        private void a() {
            if (this.f35a != null) {
                try {
                    this.f35a.close();
                } catch (Throwable th) {
                }
                this.f35a = null;
            }
        }
    }

    public c(Context context, String str, CyberPlayerEngineManager cyberPlayerEngineManager, BEngineManager.OnEngineListener onEngineListener, boolean z, Map<String, String> map) {
        super(context, cyberPlayerEngineManager, onEngineListener, z);
        this.f30a = false;
        this.e = null;
        this.f29a = null;
        this.f = null;
        this.f897a = 0;
        this.b = 0;
        this.c = 0;
        this.f32b = false;
        this.f25a = 0L;
        this.f34c = false;
        this.g = "egyRTS3H1kI5azm6kc5f8Gjo";
        this.h = "8DXjUCnU6Xb6WXY1";
        if (context != null) {
            this.f26a = context.getApplicationContext();
        }
        this.e = str;
        this.f27a = onEngineListener;
        this.f29a = map;
        d();
        c();
    }

    @Override // com.baidu.cyberplayer.sdk.internal.a
    protected boolean a() {
        this.f897a = 0;
        this.b = 0;
        this.c = 0;
        this.f32b = false;
        return true;
    }

    private void c() {
        LineNumberReader lineNumberReader;
        if (new File(this.f28a).exists()) {
            try {
                lineNumberReader = new LineNumberReader(new FileReader(this.f28a));
                while (true) {
                    try {
                        String readLine = lineNumberReader.readLine();
                        if (readLine == null) {
                            break;
                        } else if (readLine.startsWith("version")) {
                            this.f25a = CommonUtils.versionStrToNum(readLine.substring("version".length() + 1));
                        } else if (readLine.startsWith("completed")) {
                            this.f34c = Integer.parseInt(readLine.substring("completed".length() + 1)) == 1;
                        }
                    } catch (Throwable th) {
                        th = th;
                        try {
                            th.printStackTrace();
                            if (lineNumberReader != null) {
                                try {
                                    lineNumberReader.close();
                                    return;
                                } catch (Throwable th2) {
                                    return;
                                }
                            }
                            return;
                        } catch (Throwable th3) {
                            if (lineNumberReader != null) {
                                try {
                                    lineNumberReader.close();
                                } catch (Throwable th4) {
                                }
                            }
                            throw th3;
                        }
                    }
                }
                if (lineNumberReader != null) {
                    try {
                        lineNumberReader.close();
                    } catch (Throwable th5) {
                    }
                }
            } catch (Throwable th6) {
                th = th6;
                lineNumberReader = null;
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, MOVE_EXCEPTION, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0096  */
    /* renamed from: c  reason: collision with other method in class */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean m13c() {
        FileOutputStream fileOutputStream;
        boolean z;
        File file = new File(this.f28a);
        if (file.exists()) {
            file.delete();
        }
        StringBuilder sb = new StringBuilder();
        try {
            file.createNewFile();
            fileOutputStream = new FileOutputStream(this.f28a);
            try {
                sb.append("version");
                sb.append("=");
                sb.append(this.f33c);
                sb.append("\n");
                if (this.b >= this.f897a) {
                    z = m14d();
                    try {
                        this.f34c = z;
                    } catch (Throwable th) {
                        th = th;
                        try {
                            th.printStackTrace();
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (Throwable th2) {
                                }
                            }
                            if (z) {
                            }
                        } finally {
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (Throwable th3) {
                                }
                            }
                        }
                    }
                } else {
                    this.f34c = false;
                    z = true;
                }
                sb.append("completed");
                sb.append("=");
                sb.append(this.f34c ? 1 : 0);
                byte[] bytes = sb.toString().getBytes();
                fileOutputStream.write(bytes, 0, bytes.length);
            } catch (Throwable th4) {
                th = th4;
                z = true;
            }
        } catch (Throwable th5) {
            th = th5;
            fileOutputStream = null;
            z = true;
        }
        if (z) {
            a(9);
            return false;
        }
        return true;
    }

    private void d() {
        String absolutePath;
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/baidu/cyberplayer/" + this.f26a.getPackageName();
        } else {
            absolutePath = this.f26a.getFilesDir().getAbsolutePath();
        }
        this.f31b = absolutePath + "/T5PlayerEngine.apk";
        this.f28a = absolutePath + "/meta.data";
    }

    @Override // com.baidu.cyberplayer.sdk.internal.a
    protected String a() {
        return this.f31b;
    }

    @Override // com.baidu.cyberplayer.sdk.internal.a
    protected void b() {
        this.f25a = 0L;
        FileUtils.remove(this.f31b);
        FileUtils.remove(this.f28a);
    }

    @Override // com.baidu.cyberplayer.sdk.internal.a
    protected boolean b() {
        BEngineManager.UpdateInfo a2 = a();
        if (a2 == null) {
            return false;
        }
        this.f33c = a2.version;
        return a(a2.version, a2.info);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ac A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.baidu.cyberplayer.sdk.internal.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected BEngineManager.UpdateInfo a() {
        String str;
        HttpResponse execute;
        BEngineManager.UpdateInfo updateInfo = null;
        String str2 = this.e;
        long currentTimeMillis = System.currentTimeMillis();
        HttpPost httpPost = new HttpPost(str2 + ("&ak=" + this.g + "&time=" + currentTimeMillis + "&sign=" + CommonUtils.toMd5(URLEncoder.encode(currentTimeMillis + "req_videotran" + this.h)) + "&platform=android"));
        try {
            httpPost.setEntity(new StringEntity(d.a(), "utf8"));
            BasicHttpParams basicHttpParams = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(basicHttpParams, 6000);
            HttpConnectionParams.setSoTimeout(basicHttpParams, 4000);
            execute = new DefaultHttpClient(basicHttpParams).execute(httpPost);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
            str = null;
        } catch (IOException e2) {
            e2.printStackTrace();
            str = null;
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        if (execute.getStatusLine().getStatusCode() == 200) {
            str = EntityUtils.toString(execute.getEntity(), "UTF-8");
            if (str == null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.optString("errno").equals("200")) {
                        updateInfo = new BEngineManager.UpdateInfo(jSONObject.optString("version").replace("_", "."), jSONObject.optString("geturl"));
                    } else {
                        a(1);
                    }
                } catch (JSONException e4) {
                    e4.printStackTrace();
                    a(1);
                }
            } else {
                a(5);
            }
            return updateInfo;
        }
        str = null;
        if (str == null) {
        }
        return updateInfo;
    }

    private boolean a(String str, String str2) {
        boolean z = true;
        this.d = str2;
        HttpUtils httpUtils = new HttpUtils(this.f26a, this.d, new a());
        File file = new File(this.f31b);
        if (this.f25a == CommonUtils.versionStrToNum(str) && file.exists()) {
            if (this.f34c) {
                return true;
            }
            int length = (int) file.length();
            if (length > 0) {
                this.c = length;
                httpUtils.addHeader("RANGE", "bytes=" + length + "-");
            }
        } else {
            b();
            z = FileUtils.createNewFile(this.f31b);
        }
        if (z) {
            return httpUtils.download();
        }
        return z;
    }

    /* renamed from: d  reason: collision with other method in class */
    private boolean m14d() {
        String fileMD5;
        File file = new File(this.f31b);
        if (!file.exists() || this.f == null || (fileMD5 = FileUtils.getFileMD5(file)) == null || !fileMD5.equals(this.f)) {
            return false;
        }
        return true;
    }
}

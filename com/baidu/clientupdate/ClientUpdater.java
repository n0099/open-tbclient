package com.baidu.clientupdate;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.clientupdate.a.d;
import com.baidu.clientupdate.appinfo.ClientUpdateInfo;
import com.baidu.clientupdate.appinfo.RuleInfo;
import com.baidu.clientupdate.d.j;
import com.baidu.clientupdate.download.Download;
import com.baidu.clientupdate.download.DownloadManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.util.LogUtil;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class ClientUpdater {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static ClientUpdater f4594e;
    public static Runnable l;
    public static long stime;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f4595a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f4596b;

    /* renamed from: c  reason: collision with root package name */
    public String f4597c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f4598d;

    /* renamed from: f  reason: collision with root package name */
    public IClientUpdaterCallback f4599f;

    /* renamed from: g  reason: collision with root package name */
    public IClientUpdaterCallback f4600g;

    /* renamed from: h  reason: collision with root package name */
    public double f4601h;

    /* renamed from: i  reason: collision with root package name */
    public BroadcastReceiver f4602i;
    public IntentFilter j;
    public boolean k;
    public Boolean m;
    public com.baidu.clientupdate.c.a n;
    public d o;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(470109418, "Lcom/baidu/clientupdate/ClientUpdater;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(470109418, "Lcom/baidu/clientupdate/ClientUpdater;");
        }
    }

    public ClientUpdater(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f4598d = false;
        this.k = false;
        this.m = Boolean.FALSE;
        Context applicationContext = context.getApplicationContext();
        this.f4595a = applicationContext;
        this.o = d.a(applicationContext);
        if (this.f4596b == null) {
            this.f4596b = new Handler(this.f4595a.getMainLooper());
        }
        if (l == null) {
            l = new a(this);
        }
        this.f4602i = new b(this);
        this.j = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        this.n = com.baidu.clientupdate.c.a.a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, this) == null) || this.f4596b == null) {
            return;
        }
        if (j.d(this.f4595a)) {
            LogUtil.logD("ClientUpdater", "应用位于前台，不发起自动检查更新请求;");
        } else if (j.a(this.f4595a)) {
            this.f4596b.removeCallbacks(l);
            LogUtil.logD("ClientUpdater", "延迟20秒，因为有时CONNECTIVITY_CHANGE Action会很频繁");
            this.f4596b.postDelayed(l, 20000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002f, code lost:
        if (r5 != null) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, exc) == null) {
            Log.w("ClientUpdater", exc);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("msgId", "4");
                jSONObject.put("messageDetail", exc.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            IClientUpdaterCallback iClientUpdaterCallback = this.f4598d ? this.f4599f : this.f4600g;
            iClientUpdaterCallback.onException(jSONObject);
            com.baidu.clientupdate.d.a.a(this.f4595a).c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x01b0, code lost:
        if (r0 != null) goto L36;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(HttpURLConnection httpURLConnection, InputStream inputStream, StringBuilder sb) {
        com.baidu.clientupdate.d.a a2;
        IClientUpdaterCallback iClientUpdaterCallback;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65544, this, httpURLConnection, inputStream, sb) == null) {
            if (httpURLConnection.getResponseCode() != 200) {
                String responseMessage = httpURLConnection.getResponseMessage();
                d dVar = this.o;
                String c2 = this.n.c();
                String b2 = this.n.b();
                dVar.a(c2, "0", b2, "a3", "1", (System.currentTimeMillis() / 1000) + "", "", "sendUpdateRequest", responseMessage);
                LogUtil.logD("ClientUpdater", "更新请求失败：  " + responseMessage);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("msgId", "3");
                    jSONObject.put("messageDetail", responseMessage);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                IClientUpdaterCallback iClientUpdaterCallback2 = this.f4598d ? this.f4599f : this.f4600g;
                iClientUpdaterCallback2.onError(jSONObject);
                com.baidu.clientupdate.d.a.a(this.f4595a).c();
                return;
            }
            d dVar2 = this.o;
            String c3 = this.n.c();
            String b3 = this.n.b();
            dVar2.a(c3, "0", b3, "a3", "0", (System.currentTimeMillis() / 1000) + "", "", "sendUpdateRequest", "");
            InputStream inputStream2 = httpURLConnection.getInputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream2.read(bArr);
                if (read == -1) {
                    break;
                }
                sb.append(new String(bArr, 0, read, "utf-8"));
            }
            inputStream2.close();
            LogUtil.logD("ClientUpdater", "更新请求后的返回结果: " + sb.toString());
            JSONObject jSONObject2 = new JSONObject(sb.toString());
            String optString = jSONObject2.optString("status");
            if (!TextUtils.isEmpty(optString) && Integer.valueOf(optString).intValue() == 1) {
                d dVar3 = this.o;
                String c4 = this.n.c();
                String b4 = this.n.b();
                dVar3.a(c4, "0", b4, "a4", "0", (System.currentTimeMillis() / 1000) + "", "", "haveUpdate", "");
            } else if (!TextUtils.isEmpty(optString) && Integer.valueOf(optString).intValue() == 0) {
                d dVar4 = this.o;
                String c5 = this.n.c();
                String b5 = this.n.b();
                dVar4.a(c5, "0", b5, "a4", "0", (System.currentTimeMillis() / 1000) + "", "", "notUpdate", "");
            }
            if (this.f4598d) {
                this.f4599f.onFetched(jSONObject2);
                a2 = com.baidu.clientupdate.d.a.a(this.f4595a);
                iClientUpdaterCallback = this.f4599f;
            } else {
                IClientUpdaterCallback iClientUpdaterCallback3 = this.f4600g;
                if (iClientUpdaterCallback3 == null) {
                    return;
                }
                iClientUpdaterCallback3.onFetched(jSONObject2);
                a2 = com.baidu.clientupdate.d.a.a(this.f4595a);
                iClientUpdaterCallback = this.f4600g;
            }
            a2.a(jSONObject2, iClientUpdaterCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            this.f4598d = true;
            long currentTimeMillis = System.currentTimeMillis();
            LogUtil.logD("ClientUpdater", "接收到网络状态的变化，检测上次更新时间");
            LogUtil.logD("ClientUpdater", "设置的检查更新的间隔时间： " + ((long) (this.f4601h * 3600000.0d)) + "ms");
            StringBuilder sb = new StringBuilder();
            sb.append("当前时间：");
            sb.append(currentTimeMillis);
            LogUtil.logD("ClientUpdater", sb.toString());
            LogUtil.logD("ClientUpdater", "上次检查更新时间： " + j.c(this.f4595a));
            if (currentTimeMillis - j.c(this.f4595a) <= ((long) (this.f4601h * 3600000.0d))) {
                LogUtil.logD("ClientUpdater", "离上一次更新检查的时间小于设置的时间间隔，不检查更新 ");
                return;
            }
            LogUtil.logD("ClientUpdater", "大于设置的时间间隔，当前存在网络连接时进行更新检查 ");
            if (j.a(this.f4595a)) {
                new c(this).start();
                return;
            }
            StringBuilder sb2 = new StringBuilder("当前网络不可用!");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("msgId", "2");
                jSONObject.put("messageDetail", sb2.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            this.f4599f.onError(jSONObject);
            LogUtil.logD("ClientUpdater", "当前网络不可用! ");
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, IF, INVOKE, INVOKE, IF, IF, INVOKE, INVOKE, IF, INVOKE, INVOKE, IF, IF] complete} */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00cb, code lost:
        if (r4 != null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00ce, code lost:
        if (r6 == null) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00d0, code lost:
        if (r7 == null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00d2, code lost:
        if (r1 == null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00d4, code lost:
        r0 = java.security.KeyStore.getInstance(java.security.KeyStore.getDefaultType());
        r0.load(null, null);
        r0.setCertificateEntry("ca1", r6);
        r0.setCertificateEntry("ca2", r7);
        r0.setCertificateEntry("ca3", r1);
        r1 = javax.net.ssl.TrustManagerFactory.getInstance(javax.net.ssl.TrustManagerFactory.getDefaultAlgorithm());
        r1.init(r0);
        r0 = javax.net.ssl.SSLContext.getInstance("TLS");
        r0.init(null, r1.getTrustManagers(), null);
        r1 = new java.lang.StringBuilder();
        r2 = (javax.net.ssl.HttpsURLConnection) new java.net.URL(r10.f4597c).openConnection();
        r2.setSSLSocketFactory(r0.getSocketFactory());
        r2.setConnectTimeout(5000);
        r2.setReadTimeout(5000);
        r2.connect();
        a(r2, null, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x012d, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:?, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c() {
        Certificate certificate;
        Certificate certificate2;
        Certificate certificate3;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(65549, this) != null) {
            return;
        }
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
        InputStream open = this.f4595a.getResources().getAssets().open("LCUpdate/ca-globalsign-nv-sa.pem");
        InputStream open2 = this.f4595a.getResources().getAssets().open("LCUpdate/ca-verisign-class-3-public-primary-certification-authority-en.pem");
        InputStream open3 = this.f4595a.getResources().getAssets().open("LCUpdate/ca-verisign-class-3-public-primary-certification-authority-g5-en.pem");
        try {
            try {
                certificate2 = certificateFactory.generateCertificate(open);
                try {
                    LogUtil.logD("ClientUpdater", "ca1=" + ((X509Certificate) certificate2).getSubjectDN());
                    certificate3 = certificateFactory.generateCertificate(open2);
                    try {
                        LogUtil.logD("ClientUpdater", "ca2=" + ((X509Certificate) certificate3).getSubjectDN());
                        certificate = certificateFactory.generateCertificate(open3);
                    } catch (Exception e2) {
                        e = e2;
                        certificate = null;
                    }
                } catch (Exception e3) {
                    e = e3;
                    certificate = null;
                    certificate3 = null;
                }
                try {
                    LogUtil.logD("ClientUpdater", "ca3=" + ((X509Certificate) certificate).getSubjectDN());
                } catch (Exception e4) {
                    e = e4;
                    LogUtil.logE("ClientUpdater", Log.getStackTraceString(e));
                    if (open != null) {
                        open.close();
                    }
                    if (open2 != null) {
                        open2.close();
                    }
                }
            } finally {
                if (open != null) {
                    open.close();
                }
                if (open2 != null) {
                    open2.close();
                }
                if (open3 != null) {
                    open3.close();
                }
            }
        } catch (Exception e5) {
            e = e5;
            certificate = null;
            certificate2 = null;
            certificate3 = null;
        }
    }

    public static InputStream getCAInputStream(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, str)) == null) {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setRequestMethod("GET");
                if (httpURLConnection.getResponseCode() == 200) {
                    return httpURLConnection.getInputStream();
                }
                return null;
            } catch (Exception e2) {
                e2.printStackTrace();
                LogUtil.logE("ClientUpdater", "getCAInputStream fail. ");
                return null;
            }
        }
        return (InputStream) invokeL.objValue;
    }

    public static synchronized ClientUpdater getInstance(Context context) {
        InterceptResult invokeL;
        ClientUpdater clientUpdater;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, context)) == null) {
            synchronized (ClientUpdater.class) {
                if (f4594e == null) {
                    f4594e = new ClientUpdater(context);
                }
                clientUpdater = f4594e;
            }
            return clientUpdater;
        }
        return (ClientUpdater) invokeL.objValue;
    }

    public static void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, null) == null) {
            synchronized (ClientUpdater.class) {
                if (f4594e != null) {
                    f4594e.f4600g = null;
                    f4594e.f4599f = null;
                    f4594e.n = null;
                    l = null;
                    com.baidu.clientupdate.d.a.e();
                    f4594e = null;
                }
            }
        }
    }

    public void addParamValue(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            this.n.a(str, str2);
        }
    }

    public void appLaunchedCheckUpdate(IClientUpdaterCallback iClientUpdaterCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iClientUpdaterCallback) == null) {
            this.k = true;
            checkUpdate(iClientUpdaterCallback);
        }
    }

    public void cancelAutoCheckUpdate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f4598d = false;
            if (this.m.booleanValue()) {
                this.f4595a.unregisterReceiver(this.f4602i);
            }
            this.m = Boolean.FALSE;
        }
    }

    public void cancelDownload(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            DownloadManager.getInstance(this.f4595a).cancel(j);
        }
    }

    public void checkUpdate(double d2, IClientUpdaterCallback iClientUpdaterCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Double.valueOf(d2), iClientUpdaterCallback}) == null) {
            if (d2 <= 0.0d || iClientUpdaterCallback == null) {
                d dVar = this.o;
                String c2 = this.n.c();
                String b2 = this.n.b();
                dVar.a(c2, "0", b2, "a1", "0", (System.currentTimeMillis() / 1000) + "", "", "autocheckUpdate", "intervalHour < 0 or clientUpdaterCallback=null");
                LogUtil.logE("ClientUpdater", "intervalHour < 0 或者 clientUpdaterCallback为null或者JSONObject为null");
                return;
            }
            this.f4599f = iClientUpdaterCallback;
            this.f4601h = d2;
            try {
            } catch (Exception e2) {
                d dVar2 = this.o;
                String c3 = this.n.c();
                String b3 = this.n.b();
                dVar2.a(c3, "0", b3, "a1", "1", (System.currentTimeMillis() / 1000) + "", "", "autoCheckUpdate", e2.toString());
            }
            if (!j.b(this.f4595a)) {
                StringBuilder sb = new StringBuilder("请加入权限：ACCESS_NETWORK_STATE、INTERNET、GET_TASKS");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("msgId", "1");
                jSONObject.put("messageDetail", sb.toString());
                this.f4599f.onError(jSONObject);
                return;
            }
            d dVar3 = this.o;
            String c4 = this.n.c();
            String b4 = this.n.b();
            dVar3.a(c4, "0", b4, "a1", "0", (System.currentTimeMillis() / 1000) + "", "", "autoCheckUpdate", "");
            this.f4595a.registerReceiver(this.f4602i, this.j);
            this.m = Boolean.TRUE;
        }
    }

    public void checkUpdate(IClientUpdaterCallback iClientUpdaterCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, iClientUpdaterCallback) == null) {
            stime = System.currentTimeMillis();
            if (iClientUpdaterCallback == null) {
                d dVar = this.o;
                String c2 = this.n.c();
                String b2 = this.n.b();
                dVar.a(c2, "0", b2, "a1", "1", (System.currentTimeMillis() / 1000) + "", "", "checkUpdate", "clientUpdaterCallback=null");
                LogUtil.logE("ClientUpdater", " clientUpdaterCallback为null或者JSONObject为null");
                return;
            }
            try {
                this.f4600g = iClientUpdaterCallback;
            } catch (Exception e2) {
                d dVar2 = this.o;
                String c3 = this.n.c();
                String b3 = this.n.b();
                dVar2.a(c3, "0", b3, "a1", "1", (System.currentTimeMillis() / 1000) + "", "", "checkUpdate", e2.toString());
            }
            if (!j.b(this.f4595a)) {
                StringBuilder sb = new StringBuilder("请加入权限：ACCESS_NETWORK_STATE、INTERNET");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("msgId", "1");
                jSONObject.put("messageDetail", sb.toString());
                if (this.f4600g != null) {
                    this.f4600g.onError(jSONObject);
                }
            } else if (!j.a(this.f4595a)) {
                StringBuilder sb2 = new StringBuilder("当前网络不可用!");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("msgId", "2");
                jSONObject2.put("messageDetail", sb2.toString());
                if (this.f4600g != null) {
                    this.f4600g.onError(jSONObject2);
                }
            } else {
                d dVar3 = this.o;
                String c4 = this.n.c();
                String b4 = this.n.b();
                dVar3.a(c4, "0", b4, "a1", "0", (System.currentTimeMillis() / 1000) + "", "", "checkUpdate", "");
                this.f4598d = false;
                new c(this).start();
            }
        }
    }

    public void deleteDownload(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j) == null) {
            DownloadManager.getInstance(this.f4595a).delete(j);
        }
    }

    public void launchSystemInstalller(String str, Download download) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, download) == null) {
            try {
                DownloadManager.getInstance(this.f4595a).launchSystemInstalller(str, download);
            } catch (Exception e2) {
                LogUtil.logE("ClientUpdater", e2.getMessage());
            }
        }
    }

    public ClientUpdateInfo parseClientUpdateInfo(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject)) == null) ? com.baidu.clientupdate.d.a.a(this.f4595a).a(jSONObject) : (ClientUpdateInfo) invokeL.objValue;
    }

    public RuleInfo parseRule(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, jSONObject)) == null) ? com.baidu.clientupdate.d.a.a(this.f4595a).b(jSONObject) : (RuleInfo) invokeL.objValue;
    }

    public void pauseDownload(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048586, this, j) == null) {
            DownloadManager.getInstance(this.f4595a).pause(j);
        }
    }

    public void resumeDownload(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048587, this, j) == null) {
            DownloadManager.getInstance(this.f4595a).resume(j);
        }
    }

    public void setCfrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.n.j(str);
        }
    }

    public void setContext(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, context) == null) {
            this.f4595a = context;
        }
    }

    public void setDownloadPublicKey(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            DownloadManager.getInstance(this.f4595a).setDownloadPublicKey(z);
        }
    }

    public void setFileProvider(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            j.a(str);
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.n.h(str);
        }
    }

    public void setIgnore(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.n.k(str);
        }
    }

    public void setOSPlatform(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            try {
                com.baidu.clientupdate.c.a.a(this.f4595a).a(str);
            } catch (Exception e2) {
                LogUtil.logE("ClientUpdater", e2.getMessage());
            }
        }
    }

    public void setOsBranch(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.n.i(str);
        }
    }

    public void setOsName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.n.f(str);
        }
    }

    public void setTime(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.n.l(str);
        }
    }

    public void setTypeId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.n.g(str);
        }
    }

    public void setUseCFG(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            com.baidu.clientupdate.c.a.a(this.f4595a).a(z);
        }
    }

    public void setUseRSA(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            DownloadManager.getInstance(this.f4595a).setUseRSA(z);
        }
    }

    public void setVersionCode(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            this.n.e(str);
        }
    }

    public void setVersionName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            this.n.d(str);
        }
    }

    public void startDownload(ClientUpdateInfo clientUpdateInfo, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048603, this, clientUpdateInfo, str) == null) {
            try {
                com.baidu.clientupdate.d.a.a(this.f4595a).b(clientUpdateInfo, str);
            } catch (Exception e2) {
                LogUtil.logE("ClientUpdater", e2.getMessage());
            }
        }
    }

    public void startDownload(ClientUpdateInfo clientUpdateInfo, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048604, this, clientUpdateInfo, str, z) == null) {
            try {
                com.baidu.clientupdate.d.a.a(this.f4595a).a(clientUpdateInfo, str, z);
            } catch (Exception e2) {
                LogUtil.logE("ClientUpdater", e2.getMessage());
            }
        }
    }

    public void startPatchDownload(ClientUpdateInfo clientUpdateInfo, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048605, this, clientUpdateInfo, str) == null) {
            try {
                com.baidu.clientupdate.d.a.a(this.f4595a).a(clientUpdateInfo, str);
            } catch (Exception e2) {
                LogUtil.logE("ClientUpdater", e2.getMessage());
            }
        }
    }

    public void throwError(JSONObject jSONObject) {
        IClientUpdaterCallback iClientUpdaterCallback;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, jSONObject) == null) {
            try {
                if (this.f4598d) {
                    iClientUpdaterCallback = this.f4599f;
                } else if (this.f4600g == null) {
                    return;
                } else {
                    iClientUpdaterCallback = this.f4600g;
                }
                iClientUpdaterCallback.onError(jSONObject);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}

package com.baidu.mobstat;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.mobstat.bt;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.connect.common.Constants;
import dalvik.system.DexClassLoader;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.jar.JarFile;
/* loaded from: classes4.dex */
public class x {
    public static /* synthetic */ Interceptable $ic;
    public static volatile DexClassLoader a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f35548b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context a;

        /* renamed from: b  reason: collision with root package name */
        public com.baidu.mobstat.a f35549b;

        public a(Context context, com.baidu.mobstat.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.f35549b = aVar;
        }

        private void a(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65538, this, context) == null) {
                this.f35549b.a(context, System.currentTimeMillis());
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0040, code lost:
            if (android.text.TextUtils.isEmpty(r1) == false) goto L11;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private String b(Context context) {
            InterceptResult invokeL;
            String str;
            File fileStreamPath;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, context)) == null) {
                File fileStreamPath2 = context.getFileStreamPath(".remote.jar");
                if (fileStreamPath2 != null && fileStreamPath2.exists() && (fileStreamPath = context.getFileStreamPath(".remote.jar")) != null) {
                    str = x.b(fileStreamPath.getAbsolutePath());
                    bb c2 = bb.c();
                    c2.a("startDownload remote jar file version = " + str);
                }
                str = "24";
                ArrayList<Pair> arrayList = new ArrayList();
                arrayList.add(new Pair("dynamicVersion", "" + str));
                arrayList.add(new Pair("packageName", bw.t(context)));
                arrayList.add(new Pair("appVersion", bw.g(context)));
                arrayList.add(new Pair("cuid", bw.a(context)));
                arrayList.add(new Pair(Constants.PARAM_PLATFORM, "Android"));
                arrayList.add(new Pair("m", android.os.Build.MODEL));
                arrayList.add(new Pair("s", Build.VERSION.SDK_INT + ""));
                arrayList.add(new Pair("o", Build.VERSION.RELEASE));
                arrayList.add(new Pair("i", "24"));
                StringBuilder sb = new StringBuilder();
                for (Pair pair : arrayList) {
                    try {
                        String encode = URLEncoder.encode(((String) pair.first).toString(), "UTF-8");
                        String encode2 = URLEncoder.encode(((String) pair.second).toString(), "UTF-8");
                        if (TextUtils.isEmpty(sb.toString())) {
                            sb.append(encode + "=" + encode2);
                        } else {
                            sb.append("&" + encode + "=" + encode2);
                        }
                    } catch (Exception unused) {
                    }
                }
                return aa.f35000c + "?" + sb.toString();
            }
            return (String) invokeL.objValue;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    int i2 = aa.a ? 3 : 10;
                    bb c2 = bb.c();
                    c2.a("start version check in " + i2 + "s");
                    Thread.sleep((long) (i2 * 1000));
                    a();
                    a(this.a);
                } catch (Exception e2) {
                    bb.c().a(e2);
                }
                boolean unused = x.f35548b = false;
            }
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:16:0x00ce */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:46:0x00ae */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00ee A[Catch: all -> 0x0108, TryCatch #5 {, blocks: (B:5:0x0005, B:34:0x00fa, B:6:0x0032, B:14:0x00ca, B:26:0x00de, B:27:0x00e1, B:28:0x00e2, B:30:0x00ee, B:31:0x00f1, B:33:0x00f7), top: B:50:0x0005 }] */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00f7 A[Catch: all -> 0x0108, TRY_LEAVE, TryCatch #5 {, blocks: (B:5:0x0005, B:34:0x00fa, B:6:0x0032, B:14:0x00ca, B:26:0x00de, B:27:0x00e1, B:28:0x00e2, B:30:0x00ee, B:31:0x00f1, B:33:0x00f7), top: B:50:0x0005 }] */
        /* JADX WARN: Type inference failed for: r5v12 */
        /* JADX WARN: Type inference failed for: r5v13 */
        /* JADX WARN: Type inference failed for: r5v14 */
        /* JADX WARN: Type inference failed for: r5v4, types: [int] */
        /* JADX WARN: Type inference failed for: r5v5 */
        /* JADX WARN: Type inference failed for: r5v8, types: [java.io.Closeable] */
        /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.StringBuilder] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private synchronized void a() throws Exception {
            FileOutputStream fileOutputStream;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, this) == null) {
                synchronized (this) {
                    bb.c().a("start get config and download jar");
                    Context context = this.a;
                    com.baidu.mobstat.a aVar = this.f35549b;
                    String b2 = b(context);
                    bb.c().c("update req url is:" + b2);
                    HttpURLConnection d2 = bo.d(context, b2);
                    d2.connect();
                    String headerField = d2.getHeaderField("X-CONFIG");
                    bb.c().a("config is: " + headerField);
                    String headerField2 = d2.getHeaderField("X-SIGN");
                    bb.c().a("sign is: " + headerField2);
                    ?? responseCode = d2.getResponseCode();
                    bb.c().a("update response code is: " + responseCode);
                    int contentLength = d2.getContentLength();
                    bb.c().a("update response content length is: " + contentLength);
                    Closeable closeable = null;
                    if (responseCode == 200) {
                        try {
                            if (contentLength > 0) {
                                try {
                                    fileOutputStream = context.openFileOutput(".remote.jar", 0);
                                    try {
                                        boolean a = bu.a(d2.getInputStream(), fileOutputStream);
                                        responseCode = fileOutputStream;
                                        if (a) {
                                            bb.c().a("save remote jar success");
                                            responseCode = fileOutputStream;
                                        }
                                    } catch (IOException e2) {
                                        e = e2;
                                        bb.c().b(e);
                                        responseCode = fileOutputStream;
                                        bu.a(responseCode);
                                        DexClassLoader unused = x.a = null;
                                        u.a();
                                        if (!TextUtils.isEmpty(headerField)) {
                                        }
                                        if (!TextUtils.isEmpty(headerField2)) {
                                        }
                                        d2.disconnect();
                                        bb.c().a("finish get config and download jar");
                                    }
                                } catch (IOException e3) {
                                    e = e3;
                                    fileOutputStream = null;
                                } catch (Throwable th) {
                                    th = th;
                                    bu.a(closeable);
                                    throw th;
                                }
                                bu.a(responseCode);
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            closeable = responseCode;
                        }
                    }
                    DexClassLoader unused2 = x.a = null;
                    u.a();
                    if (!TextUtils.isEmpty(headerField)) {
                        aVar.a(context, headerField);
                    }
                    if (!TextUtils.isEmpty(headerField2)) {
                        aVar.b(context, headerField2);
                    }
                    d2.disconnect();
                    bb.c().a("finish get config and download jar");
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1366709524, "Lcom/baidu/mobstat/x;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1366709524, "Lcom/baidu/mobstat/x;");
        }
    }

    public static boolean b(Context context, String str) {
        InterceptResult invokeLL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, context, str)) == null) {
            String b2 = b(str);
            if (TextUtils.isEmpty(b2)) {
                return false;
            }
            try {
                i2 = Integer.valueOf(b2).intValue();
            } catch (Exception e2) {
                bb.c().b(e2);
                i2 = 0;
            }
            return i2 >= 4;
        }
        return invokeLL.booleanValue;
    }

    public static boolean c(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, context, str)) == null) {
            String a2 = bt.b.a(new File(str));
            bb c2 = bb.c();
            c2.a("remote.jar local file digest value digest = " + a2);
            if (TextUtils.isEmpty(a2)) {
                bb.c().a("remote.jar local file digest value fail");
                return false;
            }
            String b2 = b(str);
            bb c3 = bb.c();
            c3.a("remote.jar local file digest value version = " + b2);
            if (TextUtils.isEmpty(b2)) {
                return false;
            }
            String d2 = d(context, b2);
            bb c4 = bb.c();
            c4.a("remote.jar config digest value remoteJarMd5 = " + d2);
            if (TextUtils.isEmpty(d2)) {
                bb.c().a("remote.jar config digest value lost");
                return false;
            }
            return a2.equals(d2);
        }
        return invokeLL.booleanValue;
    }

    public static String d(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, context, str)) == null) ? y.a(context).c(str) : (String) invokeLL.objValue;
    }

    public static Class<?> a(Context context, String str) throws ClassNotFoundException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, str)) == null) {
            DexClassLoader a2 = a(context);
            if (a2 == null) {
                return null;
            }
            return a2.loadClass(str);
        }
        return (Class) invokeLL.objValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        JarFile jarFile;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            JarFile jarFile2 = null;
            try {
                try {
                    File file = new File(str);
                    if (file.exists()) {
                        bb c2 = bb.c();
                        c2.b("file size: " + file.length());
                    }
                    jarFile = new JarFile(str);
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                String value = jarFile.getManifest().getMainAttributes().getValue("Plugin-Version");
                try {
                    jarFile.close();
                } catch (Exception unused) {
                }
                return value;
            } catch (Exception e3) {
                e = e3;
                jarFile2 = jarFile;
                bb.c().a(e);
                bb c3 = bb.c();
                c3.a("baidu remote sdk is not ready" + str);
                if (jarFile2 != null) {
                    try {
                        jarFile2.close();
                        return "";
                    } catch (Exception unused2) {
                        return "";
                    }
                }
                return "";
            } catch (Throwable th2) {
                th = th2;
                jarFile2 = jarFile;
                if (jarFile2 != null) {
                    try {
                        jarFile2.close();
                    } catch (Exception unused3) {
                    }
                }
                throw th;
            }
        }
        return (String) invokeL.objValue;
    }

    public static synchronized DexClassLoader a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            synchronized (x.class) {
                if (a != null) {
                    return a;
                }
                File fileStreamPath = context.getFileStreamPath(".remote.jar");
                if (fileStreamPath == null || fileStreamPath.isFile()) {
                    if (!b(context, fileStreamPath.getAbsolutePath())) {
                        bb.c().a("remote jar version lower than min limit, need delete");
                        if (fileStreamPath.isFile()) {
                            fileStreamPath.delete();
                        }
                        return null;
                    } else if (!c(context, fileStreamPath.getAbsolutePath())) {
                        bb.c().a("remote jar md5 is not right, need delete");
                        if (fileStreamPath.isFile()) {
                            fileStreamPath.delete();
                        }
                        return null;
                    } else {
                        try {
                            a = new DexClassLoader(fileStreamPath.getAbsolutePath(), context.getDir("outdex", 0).getAbsolutePath(), null, context.getClassLoader());
                        } catch (Exception e2) {
                            bb.c().a(e2);
                        }
                        return a;
                    }
                }
                return null;
            }
        }
        return (DexClassLoader) invokeL.objValue;
    }

    public static synchronized void a(Context context, com.baidu.mobstat.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, context, aVar) == null) {
            synchronized (x.class) {
                if (f35548b) {
                    return;
                }
                if (!bw.q(context)) {
                    bb.c().a("isWifiAvailable = false, will not to update");
                } else if (!aVar.a(context)) {
                    bb.c().a("check time, will not to update");
                } else {
                    bb.c().a("can start update config");
                    new a(context, aVar).start();
                    f35548b = true;
                }
            }
        }
    }
}

package b.a.e.k;

import android.content.Context;
import android.text.TextUtils;
import b.a.e.k.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.io.Closeables;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.pms.bean.PackageInfo;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f2380a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f2381b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a extends d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f2382a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f2383b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Context f2384c;

        public a(f fVar, String str, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, str, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2382a = fVar;
            this.f2383b = str;
            this.f2384c = context;
        }

        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.e.k.d.b
        /* renamed from: d */
        public void b(int i2, String str, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str, jSONObject) == null) {
                this.f2382a.a(this.f2383b, -1, null);
                try {
                    try {
                        if (jSONObject != null) {
                            if (i.f2380a) {
                                String str2 = "onResponse " + jSONObject;
                            }
                            PackageInfo k = i.k(this.f2384c, jSONObject);
                            if (k.errNo != 0) {
                                boolean unused = i.f2380a;
                                if (k.errNo != -2) {
                                    String str3 = "patch data errno = " + k.errNo;
                                }
                                this.f2382a.a(this.f2383b, -1, null);
                                synchronized (i.class) {
                                    boolean unused2 = i.f2381b = false;
                                }
                                return;
                            }
                            j.b(this.f2384c, this.f2382a, k, true);
                            synchronized (i.class) {
                                boolean unused3 = i.f2381b = false;
                            }
                            return;
                        }
                        this.f2382a.a(this.f2383b, -1, null);
                        synchronized (i.class) {
                            boolean unused4 = i.f2381b = false;
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        this.f2382a.a(this.f2383b, -1, null);
                        synchronized (i.class) {
                            boolean unused5 = i.f2381b = false;
                        }
                    }
                } catch (Throwable th) {
                    synchronized (i.class) {
                        boolean unused6 = i.f2381b = false;
                        throw th;
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements d.b<InputStream> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ File f2385a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f2386b;

        public b(File file, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {file, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2385a = file;
            this.f2386b = str;
        }

        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // b.a.e.k.d.b
        public /* bridge */ /* synthetic */ InputStream a(int i2, String str, InputStream inputStream) throws IOException {
            d(i2, str, inputStream);
            return inputStream;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:30:0x0072 */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v10 */
        /* JADX WARN: Type inference failed for: r0v2 */
        /* JADX WARN: Type inference failed for: r0v3 */
        /* JADX WARN: Type inference failed for: r0v5, types: [java.io.Closeable] */
        /* JADX WARN: Type inference failed for: r0v9 */
        @Override // b.a.e.k.d.b
        /* renamed from: c */
        public void b(int i2, String str, InputStream inputStream) {
            Throwable th;
            FileOutputStream fileOutputStream;
            Exception e2;
            Interceptable interceptable = $ic;
            ?? r0 = interceptable;
            if (interceptable != null) {
                InterceptResult invokeILL = interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i2, str, inputStream);
                r0 = invokeILL;
                if (invokeILL != null) {
                    return;
                }
            }
            if (inputStream == null) {
                boolean unused = i.f2380a;
                return;
            }
            try {
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                    fileOutputStream = new FileOutputStream(this.f2385a);
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = inputStream.read(bArr, 0, 1024);
                            if (read <= 0) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, read);
                            messageDigest.update(bArr, 0, read);
                        }
                        String e3 = i.e(messageDigest.digest());
                        if (i.f2380a) {
                            String str2 = "download file md5 = " + e3;
                        }
                        if (!TextUtils.equals(this.f2386b, e3)) {
                            fileOutputStream.close();
                            this.f2385a.delete();
                        }
                    } catch (Exception e4) {
                        e2 = e4;
                        this.f2385a.delete();
                        e2.printStackTrace();
                        Closeables.closeSafely(inputStream);
                        Closeables.closeSafely(fileOutputStream);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    Closeables.closeSafely(inputStream);
                    Closeables.closeSafely((Closeable) r0);
                    throw th;
                }
            } catch (Exception e5) {
                fileOutputStream = null;
                e2 = e5;
            } catch (Throwable th3) {
                r0 = 0;
                th = th3;
                Closeables.closeSafely(inputStream);
                Closeables.closeSafely((Closeable) r0);
                throw th;
            }
            Closeables.closeSafely(inputStream);
            Closeables.closeSafely(fileOutputStream);
        }

        public InputStream d(int i2, String str, InputStream inputStream) {
            InterceptResult invokeILL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeILL = interceptable.invokeILL(1048579, this, i2, str, inputStream)) == null) ? inputStream : (InputStream) invokeILL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1303721401, "Lb/a/e/k/i;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1303721401, "Lb/a/e/k/i;");
                return;
            }
        }
        f2380a = b.a.e.k.a.f2363a;
        f2381b = false;
    }

    public i() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String e(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, bArr)) == null) {
            StringBuilder sb = new StringBuilder("");
            if (bArr == null || bArr.length <= 0) {
                return null;
            }
            for (byte b2 : bArr) {
                String hexString = Integer.toHexString(b2 & 255);
                if (hexString.length() < 2) {
                    sb.append(0);
                }
                sb.append(hexString);
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static void f(Context context, String str, f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, context, str, fVar) == null) {
            synchronized (i.class) {
                if (f2381b) {
                    boolean z = f2380a;
                    return;
                }
                f2381b = true;
                String z2 = e.p().z(i());
                if (f2380a) {
                    String str2 = "url = " + z2;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("Content-Type", "application/json");
                d.d(context, z2, "POST", h(), hashMap, new a(fVar, str, context));
            }
        }
    }

    public static String g(Context context, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65544, null, context, str, str2, str3)) == null) {
            File j = j(context);
            for (File file : j.listFiles()) {
                if (file.isFile()) {
                    file.delete();
                }
            }
            File file2 = new File(j, str3);
            d.d(context, str, "GET", null, null, new b(file2, str2));
            if (file2.exists()) {
                return file2.getAbsolutePath();
            }
            return null;
        }
        return (String) invokeLLLL.objValue;
    }

    public static byte[] h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            JSONObject jSONObject4 = new JSONObject();
            h d2 = h.d();
            d2.g();
            JSONObject jSONObject5 = new JSONObject();
            try {
                jSONObject4.put("com.baidu.titan.patch", String.valueOf(d2.b()));
                jSONObject3.put("132", jSONObject4);
                jSONObject2.put("aps", jSONObject3);
                jSONObject.put("versions", jSONObject2);
                jSONObject5.put("bd_version", AppConfig.AppInfo.getVersionName());
                jSONObject5.put("device_ua", "android");
                jSONObject.put("pubparam", jSONObject5);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            try {
                String jSONObject6 = jSONObject.toString();
                if (b.a.e.k.a.f2363a) {
                    String str = "getCcsContent = " + jSONObject6;
                }
                return jSONObject6.getBytes("UTF-8");
            } catch (UnsupportedEncodingException e3) {
                e3.printStackTrace();
                return null;
            }
        }
        return (byte[]) invokeV.objValue;
    }

    public static String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            return b.a.e.k.b.a() + "?runtype=aps_132&appname=tieba";
        }
        return (String) invokeV.objValue;
    }

    public static File j(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
            File file = new File(new File(context.getCacheDir(), "titan_sandbox_cache"), "patch_cache");
            file.mkdirs();
            return file;
        }
        return (File) invokeL.objValue;
    }

    public static PackageInfo k(Context context, JSONObject jSONObject) throws JSONException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, context, jSONObject)) == null) {
            PackageInfo packageInfo = new PackageInfo();
            int optInt = jSONObject.optInt("errno", -1);
            packageInfo.errNo = optInt;
            if (optInt != 0) {
                if (f2380a) {
                    String str = "response errno = " + optInt;
                }
                return packageInfo;
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject("data");
            if (!jSONObject2.has("service")) {
                packageInfo.errNo = -2;
                return packageInfo;
            }
            JSONObject jSONObject3 = jSONObject2.getJSONObject("service");
            if (!jSONObject3.has("aps")) {
                packageInfo.errNo = -2;
                return packageInfo;
            }
            JSONObject jSONObject4 = jSONObject3.getJSONObject("aps");
            if (!jSONObject4.has("132")) {
                packageInfo.errNo = -2;
                return packageInfo;
            }
            JSONObject jSONObject5 = jSONObject4.getJSONObject("132");
            if (!jSONObject5.has("com.baidu.titan.patch")) {
                packageInfo.errNo = -2;
                return packageInfo;
            }
            JSONObject jSONObject6 = jSONObject5.getJSONObject("com.baidu.titan.patch");
            String string = jSONObject6.getString("version");
            JSONObject jSONObject7 = jSONObject6.getJSONObject("data").getJSONObject("pkg_info");
            String string2 = jSONObject7.getString("version");
            String string3 = jSONObject7.getString("name");
            String string4 = jSONObject7.getString(PackageTable.MD5);
            String string5 = jSONObject7.getString("maxv");
            String string6 = jSONObject7.getString("minv");
            String string7 = jSONObject7.getString("download_url");
            if (!TextUtils.isEmpty(string3) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string4) && !TextUtils.isEmpty(string) && !TextUtils.isEmpty(string7)) {
                String g2 = g(context, string7, string4, "com.baidu.titan.patch_" + string4 + ".apk");
                if (g2 == null) {
                    packageInfo.errNo = -4;
                    return packageInfo;
                }
                packageInfo.filePath = g2;
                packageInfo.packageName = "com.baidu.titan.patch";
                packageInfo.version = Long.valueOf(string2).longValue();
                packageInfo.maxHostVersion = string5;
                packageInfo.minHostVersion = string6;
                packageInfo.updateVersion = Long.valueOf(string).longValue();
                return packageInfo;
            }
            packageInfo.errNo = -3;
            return packageInfo;
        }
        return (PackageInfo) invokeLL.objValue;
    }
}

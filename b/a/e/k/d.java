package b.a.e.k;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.io.Closeables;
import com.baidu.mobads.sdk.internal.XAdSDKPorxyConfig;
import com.baidu.searchbox.aperf.bosuploader.BOSTokenRequest;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f2365a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static abstract class a implements b<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.e.k.d.b
        /* renamed from: c */
        public JSONObject a(int i2, String str, InputStream inputStream) throws IOException {
            InterceptResult invokeILL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str, inputStream)) == null) {
                if (i2 != 200) {
                    throw new IOException("parse response error: statuscode is " + i2);
                } else if (inputStream != null) {
                    try {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, read);
                        }
                        JSONObject jSONObject = new JSONObject(byteArrayOutputStream.toString("UTF-8"));
                        if (d.f2365a) {
                            jSONObject.toString();
                        }
                        return jSONObject;
                    } catch (Exception e2) {
                        throw new IOException(e2);
                    }
                } else {
                    throw new IOException("parse response error: input stream is null");
                }
            }
            return (JSONObject) invokeILL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public interface b<T> {
        T a(int i2, String str, InputStream inputStream) throws IOException;

        void b(int i2, String str, T t);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1303721556, "Lb/a/e/k/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1303721556, "Lb/a/e/k/d;");
                return;
            }
        }
        f2365a = b.a.e.k.a.f2363a;
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
                return "0.8";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String c(Context context) {
        InterceptResult invokeL;
        String sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            String property = System.getProperty("http.agent");
            if (TextUtils.isEmpty(property)) {
                sb = "";
            } else {
                StringBuilder sb2 = new StringBuilder();
                int length = property.length();
                for (int i2 = 0; i2 < length; i2++) {
                    char charAt = property.charAt(i2);
                    if (charAt <= 31 || charAt >= 127) {
                        sb2.append(String.format("\\u%04x", Integer.valueOf(charAt)));
                    } else {
                        sb2.append(charAt);
                    }
                }
                sb = sb2.toString();
            }
            String str = Build.VERSION.RELEASE;
            String replace = TextUtils.isEmpty(str) ? XAdSDKPorxyConfig.REMOTE_VERSION_DEFAULT : str.replace("_", "-");
            return sb + " baiduboxapp/" + b(context) + " (Baidu; P1 " + replace + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x00ff A[Catch: all -> 0x0112, TRY_LEAVE, TryCatch #1 {all -> 0x0112, blocks: (B:64:0x00fa, B:66:0x00ff), top: B:80:0x00fa }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:93:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static <T> void d(Context context, String str, String str2, byte[] bArr, Map<String, String> map, b<T> bVar) {
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        OutputStream outputStream;
        HttpURLConnection httpURLConnection2;
        OutputStream outputStream2;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{context, str, str2, bArr, map, bVar}) != null) {
            return;
        }
        OutputStream outputStream3 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setConnectTimeout(30000);
                httpURLConnection.setReadTimeout(30000);
                httpURLConnection.setRequestProperty("User-Agent", c(context));
                httpURLConnection.setRequestProperty(BOSTokenRequest.CHARSET, "UTF-8");
                httpURLConnection.setRequestMethod(str2);
                if (map != null) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                    }
                }
                if (!TextUtils.equals(str2, "POST")) {
                    outputStream2 = null;
                } else if (bArr == null) {
                    boolean z = f2365a;
                    if (bVar != null) {
                        bVar.b(-1, "post requestSync body is null", null);
                    }
                    Closeables.closeSafely((Closeable) null);
                    Closeables.closeSafely((Closeable) null);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                        return;
                    }
                    return;
                } else {
                    httpURLConnection.setDoOutput(true);
                    if (map == null || !map.containsKey("Content-Type")) {
                        httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    }
                    outputStream2 = httpURLConnection.getOutputStream();
                    try {
                        outputStream2.write(bArr);
                    } catch (Exception e2) {
                        e = e2;
                        inputStream = null;
                        outputStream = outputStream2;
                        e = e;
                        httpURLConnection2 = httpURLConnection;
                        try {
                            e.printStackTrace();
                            if (bVar != null) {
                            }
                            Closeables.closeSafely(outputStream);
                            Closeables.closeSafely(inputStream);
                            if (httpURLConnection2 == null) {
                            }
                        } catch (Throwable th) {
                            th = th;
                            outputStream3 = outputStream;
                            httpURLConnection = httpURLConnection2;
                            Closeables.closeSafely(outputStream3);
                            Closeables.closeSafely(inputStream);
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream = null;
                        outputStream3 = outputStream2;
                        th = th;
                        Closeables.closeSafely(outputStream3);
                        Closeables.closeSafely(inputStream);
                        if (httpURLConnection != null) {
                        }
                        throw th;
                    }
                }
                int responseCode = httpURLConnection.getResponseCode();
                String str3 = "request code = " + responseCode + " msg = " + httpURLConnection.getResponseMessage();
                if (responseCode == 200) {
                    inputStream = httpURLConnection.getInputStream();
                    if (bVar != null) {
                        try {
                            t = bVar.a(responseCode, httpURLConnection.getResponseMessage(), inputStream);
                        } catch (Exception e3) {
                            e = e3;
                            outputStream = outputStream2;
                            e = e;
                            httpURLConnection2 = httpURLConnection;
                            e.printStackTrace();
                            if (bVar != null) {
                                bVar.b(-1, e.getMessage(), null);
                            }
                            Closeables.closeSafely(outputStream);
                            Closeables.closeSafely(inputStream);
                            if (httpURLConnection2 == null) {
                                httpURLConnection2.disconnect();
                                return;
                            }
                            return;
                        } catch (Throwable th3) {
                            th = th3;
                            outputStream3 = outputStream2;
                            th = th;
                            Closeables.closeSafely(outputStream3);
                            Closeables.closeSafely(inputStream);
                            if (httpURLConnection != null) {
                            }
                            throw th;
                        }
                    } else {
                        t = null;
                    }
                } else {
                    inputStream = null;
                    t = null;
                }
                if (bVar != null) {
                    bVar.b(responseCode, httpURLConnection.getResponseMessage(), t);
                }
                Closeables.closeSafely(outputStream2);
                Closeables.closeSafely(inputStream);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
            } catch (Exception e4) {
                e = e4;
                httpURLConnection2 = httpURLConnection;
                outputStream = null;
                inputStream = null;
            } catch (Throwable th4) {
                th = th4;
                inputStream = null;
            }
        } catch (Exception e5) {
            e = e5;
            outputStream = null;
            httpURLConnection2 = null;
            inputStream = null;
        } catch (Throwable th5) {
            th = th5;
            httpURLConnection = null;
            inputStream = null;
        }
    }
}

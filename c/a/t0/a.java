package c.a.t0;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.common.others.url.UrlUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.io.Closeables;
import com.baidu.android.util.io.GZIP;
import com.baidu.common.param.CommonUrlParamManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.logsystem.basic.upload.BaseContentUploader;
import com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.codec.binary4util.bdapp.Base64InputStream;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public abstract class a implements u {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f29912b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public e0 f29913a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1350905095, "Lc/a/t0/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1350905095, "Lc/a/t0/a;");
                return;
            }
        }
        f29912b = AppConfig.isDebug();
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f29913a = new e0();
    }

    @Override // c.a.t0.u
    public boolean a(File file, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{file, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? f(BaseContentUploader.ONLINE_URL, file, z, z2) : invokeCommon.booleanValue;
    }

    @Override // c.a.t0.u
    public boolean b(JSONObject jSONObject, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{jSONObject, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? g(BaseContentUploader.ONLINE_URL, jSONObject, z, z2) : invokeCommon.booleanValue;
    }

    public final HashMap<String, String> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            HashMap<String, String> hashMap = new HashMap<>(2);
            hashMap.put("Content-type", "application/x-www-form-urlencoded");
            hashMap.put(BaseContentUploader.NB, "1");
            return hashMap;
        }
        return (HashMap) invokeV.objValue;
    }

    public final String d(String str, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        String str2;
        String processUrl;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            boolean isUBCDebug = this.f29913a.isUBCDebug();
            if (isUBCDebug) {
                str2 = "http://bjyz-mco-searchbox201609-m12xi3-044.bjyz.baidu.com:8080/ztbox?action=zubc";
            } else {
                str2 = str + "/ztbox?action=zubc";
            }
            if (z2) {
                processUrl = CommonUrlParamManager.getInstance().spliceNoPrivacyParams(str2);
            } else {
                processUrl = CommonUrlParamManager.getInstance().processUrl(str2);
            }
            if (isUBCDebug && !TextUtils.isEmpty(processUrl)) {
                processUrl = UrlUtil.addParam(processUrl, "debug", "1");
            }
            if (z) {
                processUrl = UrlUtil.addParam(processUrl, "reallog", "1");
            }
            return g.n().y() ? UrlUtil.addParam(processUrl, "beta", "1") : processUrl;
        }
        return (String) invokeCommon.objValue;
    }

    public final boolean e(c0 c0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, c0Var)) == null) {
            if (c0Var == null) {
                return false;
            }
            if (!c0Var.d()) {
                if (f29912b) {
                    String str = "postByteRequest, fail: " + c0Var.c();
                } else {
                    b0.a().i(c0Var.c(), null);
                }
                c0Var.a();
                return false;
            }
            try {
                int i2 = new JSONObject(c0Var.b()).getInt("error");
                if (i2 != 0) {
                    boolean z = f29912b;
                    if (!f29912b) {
                        b0.a().k(i2);
                    }
                }
            } catch (Exception e2) {
                if (f29912b) {
                    String str2 = "body tostring fail:" + e2.getMessage();
                } else {
                    b0.a().j(Log.getStackTraceString(e2));
                }
            }
            c0Var.a();
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Type inference failed for: r1v6, types: [boolean] */
    public final boolean f(String str, File file, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        ?? exists;
        BufferedInputStream bufferedInputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{str, file, Boolean.valueOf(z), Boolean.valueOf(z2)})) != null) {
            return invokeCommon.booleanValue;
        }
        if (file == null || (exists = file.exists()) == 0) {
            return false;
        }
        String d2 = d(str, z, z2);
        HashMap<String, String> c2 = c();
        Closeable closeable = null;
        try {
            try {
                bufferedInputStream = new BufferedInputStream(new Base64InputStream(new FileInputStream(file), 2));
                try {
                    boolean e2 = e(h(d2, bufferedInputStream, c2));
                    Closeables.closeSafely(bufferedInputStream);
                    return e2;
                } catch (Exception e3) {
                    e = e3;
                    if (!f29912b) {
                        b0.a().i(null, Log.getStackTraceString(e));
                    }
                    Closeables.closeSafely(bufferedInputStream);
                    return false;
                }
            } catch (Throwable th) {
                th = th;
                closeable = exists;
                Closeables.closeSafely(closeable);
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            bufferedInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            Closeables.closeSafely(closeable);
            throw th;
        }
    }

    public boolean g(String str, JSONObject jSONObject, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{str, jSONObject, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (jSONObject == null) {
                return false;
            }
            String d2 = d(str, z, z2);
            HashMap<String, String> c2 = c();
            byte[] gZip = GZIP.gZip(jSONObject.toString().getBytes());
            if (gZip != null && gZip.length >= 2) {
                gZip[0] = LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1;
                gZip[1] = LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_2;
                try {
                    return e(i(d2, gZip, c2));
                } catch (IOException e2) {
                    if (!f29912b) {
                        b0.a().i(null, Log.getStackTraceString(e2));
                    }
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public abstract c0 h(String str, InputStream inputStream, Map<String, String> map) throws IOException;

    public abstract c0 i(String str, byte[] bArr, Map<String, String> map) throws IOException;
}

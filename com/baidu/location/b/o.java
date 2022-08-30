package com.baidu.location.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Handler;
import androidx.core.view.InputDeviceCompat;
import com.baidu.down.utils.Constants;
import com.baidu.location.Jni;
import com.baidu.tieba.rw;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.util.UriUtil;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class o extends com.baidu.location.e.e {
    public static /* synthetic */ Interceptable $ic;
    public static o q;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public String d;
    public int e;
    public Handler f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1037723717, "Lcom/baidu/location/b/o;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1037723717, "Lcom/baidu/location/b/o;");
        }
    }

    public o() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = 1;
        this.f = null;
        this.f = new Handler();
    }

    public static void a(File file, File file2) throws IOException {
        BufferedOutputStream bufferedOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(65539, null, file, file2) != null) {
            return;
        }
        BufferedInputStream bufferedInputStream = null;
        try {
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
                try {
                    byte[] bArr = new byte[5120];
                    while (true) {
                        int read = bufferedInputStream2.read(bArr);
                        if (read == -1) {
                            bufferedOutputStream.flush();
                            file.delete();
                            bufferedInputStream2.close();
                            bufferedOutputStream.close();
                            return;
                        }
                        bufferedOutputStream.write(bArr, 0, read);
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedInputStream = bufferedInputStream2;
                    if (bufferedInputStream != null) {
                        bufferedInputStream.close();
                    }
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedOutputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedOutputStream = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, context)) == null) {
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo == null || activeNetworkInfo.getType() != 0) {
                    return false;
                }
                String a = com.baidu.location.c.d.a(com.baidu.location.c.b.a().e());
                if (a.equals("3G")) {
                    return true;
                }
                return a.equals("4G");
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, str, str2)) == null) {
            File file = new File(com.baidu.location.e.k.j() + File.separator + "tmp");
            if (file.exists()) {
                file.delete();
            }
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                byte[] bArr = new byte[4096];
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                while (true) {
                    int read = bufferedInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                httpURLConnection.disconnect();
                fileOutputStream.close();
                bufferedInputStream.close();
                if (file.length() < Constants.TEST_SPEED_THRESHOLD_DEFAULT) {
                    file.delete();
                    return false;
                }
                file.renameTo(new File(com.baidu.location.e.k.j() + File.separator + str2));
                return true;
            } catch (Exception unused) {
                file.delete();
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static o b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (q == null) {
                q = new o();
            }
            return q;
        }
        return (o) invokeV.objValue;
    }

    private Handler d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) ? this.f : (Handler) invokeV.objValue;
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            try {
                File file = new File(com.baidu.location.e.k.j() + "/grtcfrsa.dat");
                if (!file.exists()) {
                    File file2 = new File(com.baidu.location.e.j.a);
                    if (!file2.exists()) {
                        file2.mkdirs();
                    }
                    if (!file.createNewFile()) {
                        return;
                    }
                    RandomAccessFile randomAccessFile = new RandomAccessFile(file, rw.c);
                    randomAccessFile.seek(2L);
                    randomAccessFile.writeInt(0);
                    randomAccessFile.seek(8L);
                    byte[] bytes = "1980_01_01:0".getBytes();
                    randomAccessFile.writeInt(bytes.length);
                    randomAccessFile.write(bytes);
                    randomAccessFile.seek(200L);
                    randomAccessFile.writeBoolean(false);
                    randomAccessFile.seek(800L);
                    randomAccessFile.writeBoolean(false);
                    randomAccessFile.close();
                }
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, rw.c);
                randomAccessFile2.seek(200L);
                randomAccessFile2.writeBoolean(true);
                if (this.e == 1) {
                    randomAccessFile2.writeBoolean(true);
                } else {
                    randomAccessFile2.writeBoolean(false);
                }
                if (this.d != null) {
                    byte[] bytes2 = this.d.getBytes();
                    randomAccessFile2.writeInt(bytes2.length);
                    randomAccessFile2.write(bytes2);
                } else if (Math.abs(com.baidu.location.f.getFrameVersion() - 7.93f) < 1.0E-8f) {
                    randomAccessFile2.writeInt(0);
                }
                randomAccessFile2.close();
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65548, this) == null) || this.a == null) {
            return;
        }
        new s(this).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, this)) == null) {
            if (this.c == null) {
                return true;
            }
            if (new File(com.baidu.location.e.k.j() + File.separator + this.c).exists()) {
                return true;
            }
            return a("http://" + this.a + "/" + this.c, this.c);
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65550, this) == null) || this.b == null) {
            return;
        }
        File file = new File(com.baidu.location.e.k.j() + File.separator + this.b);
        if (file.exists()) {
            return;
        }
        if (a("http://" + this.a + "/" + this.b, this.b)) {
            String a = com.baidu.location.e.k.a(file, "SHA-256");
            String str = this.d;
            if (str == null || a == null || !com.baidu.location.e.k.b(a, str, "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCiP7BS5IjEOzrKGR9/Ww9oSDhdX1ir26VOsYjT1T6tk2XumRpkHRwZbrucDcNnvSB4QsqiEJnvTSRi7YMbh2H9sLMkcvHlMV5jAErNvnuskWfcvf7T2mq7EUZI/Hf4oVZhHV0hQJRFVdTcjWI6q2uaaKM3VMh+roDesiE7CR2biQIDAQAB")) {
                return;
            }
            File file2 = new File(com.baidu.location.e.k.j() + File.separator + com.baidu.location.f.replaceFileName);
            if (file2.exists()) {
                file2.delete();
            }
            try {
                a(file, file2);
            } catch (Exception unused) {
                file2.delete();
            }
        }
    }

    @Override // com.baidu.location.e.e
    @SuppressLint({"NewApi"})
    public void a() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            StringBuffer stringBuffer = new StringBuffer(128);
            stringBuffer.append("&sdk=");
            stringBuffer.append(7.93f);
            stringBuffer.append("&fw=");
            stringBuffer.append(com.baidu.location.f.getFrameVersion());
            stringBuffer.append("&suit=");
            stringBuffer.append(2);
            if (com.baidu.location.e.b.a().c == null) {
                stringBuffer.append("&im=");
                str = com.baidu.location.e.b.a().a;
            } else {
                stringBuffer.append("&cu=");
                str = com.baidu.location.e.b.a().c;
            }
            stringBuffer.append(str);
            stringBuffer.append("&mb=");
            stringBuffer.append(Build.MODEL);
            stringBuffer.append("&sv=");
            String str2 = Build.VERSION.RELEASE;
            if (str2 != null && str2.length() > 10) {
                str2 = str2.substring(0, 10);
            }
            stringBuffer.append(str2);
            String str3 = null;
            try {
                if (Build.VERSION.SDK_INT > 20) {
                    String[] strArr = Build.SUPPORTED_ABIS;
                    String str4 = null;
                    for (int i = 0; i < strArr.length; i++) {
                        str4 = i == 0 ? strArr[i] + ParamableElem.DIVIDE_PARAM : str4 + strArr[i] + ParamableElem.DIVIDE_PARAM;
                    }
                    str3 = str4;
                } else {
                    str3 = Build.CPU_ABI2;
                }
            } catch (Error | Exception unused) {
            }
            if (str3 != null) {
                stringBuffer.append("&cpuabi=");
                stringBuffer.append(str3);
            }
            stringBuffer.append("&pack=");
            stringBuffer.append(com.baidu.location.e.b.e);
            this.h = com.baidu.location.e.k.f() + "?&it=" + Jni.en1(stringBuffer.toString());
        }
    }

    @Override // com.baidu.location.e.e
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z) {
            try {
                JSONObject jSONObject = new JSONObject(this.j);
                if ("up".equals(jSONObject.getString(UriUtil.LOCAL_RESOURCE_SCHEME))) {
                    this.a = jSONObject.getString("upath");
                    if (jSONObject.has("u1")) {
                        this.b = jSONObject.getString("u1");
                    }
                    if (jSONObject.has("u2")) {
                        this.c = jSONObject.getString("u2");
                    }
                    if (jSONObject.has("u1_rsa")) {
                        this.d = jSONObject.getString("u1_rsa");
                    }
                    d().post(new r(this));
                }
                if (jSONObject.has("ison")) {
                    this.e = jSONObject.getInt("ison");
                }
                e();
            } catch (Exception unused) {
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (System.currentTimeMillis() - com.baidu.location.e.c.a().b() > 86400000) {
                com.baidu.location.e.c.a().a(System.currentTimeMillis());
                d().postDelayed(new p(this), 10000L);
                d().postDelayed(new q(this), 5000L);
            }
        }
    }
}

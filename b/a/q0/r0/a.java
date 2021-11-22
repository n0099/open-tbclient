package b.a.q0.r0;

import android.content.Context;
import android.net.Proxy;
import android.os.Build;
import android.provider.Settings;
import androidx.core.view.InputDeviceCompat;
import b.a.e.f.p.k;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentResolverProxy;
import com.baidu.ar.record.EncoderParams;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f13633a = false;

    /* renamed from: b  reason: collision with root package name */
    public static String f13634b = "";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-77004414, "Lb/a/q0/r0/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-77004414, "Lb/a/q0/r0/a;");
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:58:0x00df */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:59:0x0047 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.lang.Object, java.io.File] */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r8v24 */
    /* JADX WARN: Type inference failed for: r8v25 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v8, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v9 */
    public static String a(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, file)) == null) {
            if (f13633a) {
                return "hasSend_" + f13634b;
            }
            String str = TbConfig.SERVER_ADDRESS + TbConfig.DEBUG_UPLOAD;
            if (file.length() > ((long) EncoderParams.VIDEO_BIT_RATE) || !TbadkCoreApplication.isLogin()) {
                return "notLogin";
            }
            FileInputStream fileInputStream = null;
            try {
                try {
                    if (file.exists()) {
                        FileInputStream fileInputStream2 = new FileInputStream((File) file);
                        try {
                            byte[] bArr = new byte[(int) file.length()];
                            fileInputStream2.read(bArr);
                            fileInputStream2.close();
                            NetWork netWork = new NetWork(str + "?fn=" + file.getName());
                            netWork.addPostData("debugfile", bArr);
                            netWork.addPostData(HttpRequest.TBS, TbadkCoreApplication.getInst().getTbs());
                            netWork.addPostData("type", "android");
                            String postMultiNetData = netWork.postMultiNetData();
                            if (postMultiNetData != null && !postMultiNetData.isEmpty()) {
                                String string = new JSONObject(postMultiNetData).getString("url");
                                f13634b = string;
                                f13633a = true;
                                try {
                                    fileInputStream2.close();
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                }
                                return string;
                            }
                            file = postMultiNetData;
                            fileInputStream = fileInputStream2;
                        } catch (Throwable th) {
                            th = th;
                            fileInputStream = fileInputStream2;
                            try {
                                file = "uploadfail_" + th;
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                    file = file;
                                }
                                return file;
                            } catch (Throwable th2) {
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e3) {
                                        e3.printStackTrace();
                                    }
                                }
                                throw th2;
                            }
                        }
                    } else {
                        file = 0;
                    }
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            } catch (Throwable th3) {
                th = th3;
            }
            if (fileInputStream != null) {
                fileInputStream.close();
                file = file;
            }
            return file;
        }
        return (String) invokeL.objValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            try {
                return Settings.Secure.getInt(ContentResolverProxy.getContentResolver(), "adb_enabled", 0) > 0;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static String c(Context context) {
        InterceptResult invokeL;
        int port;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            try {
                if (Build.VERSION.SDK_INT >= 14) {
                    str = System.getProperty("http.proxyHost");
                    String property = System.getProperty("http.proxyPort");
                    if (property == null) {
                        property = "-1";
                    }
                    port = Integer.parseInt(property);
                } else {
                    String host = Proxy.getHost(context);
                    port = Proxy.getPort(context);
                    str = host;
                }
                if (k.isEmpty(str) || port == -1) {
                    return null;
                }
                return str + ":" + port;
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:74:0x0074 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0092 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0082 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00a0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:96:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean d(File file, File file2, byte[] bArr) {
        InterceptResult invokeLLL;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, file, file2, bArr)) != null) {
            return invokeLLL.booleanValue;
        }
        FileInputStream fileInputStream = null;
        try {
            if (!file.exists()) {
                return false;
            }
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    byte[] bArr2 = new byte[1024];
                    if (bArr != null && bArr.length > 0 && bArr.length < file.length()) {
                        byte[] bArr3 = new byte[bArr.length];
                        fileInputStream2.read(bArr3, 0, bArr.length);
                        int i2 = 0;
                        while (true) {
                            if (i2 >= bArr.length) {
                                break;
                            } else if (bArr[i2] != bArr3[i2]) {
                                fileOutputStream.write(bArr3, 0, bArr.length);
                                break;
                            } else {
                                i2++;
                            }
                        }
                    }
                    while (true) {
                        int read = fileInputStream2.read(bArr2);
                        if (read > 0) {
                            fileOutputStream.write(bArr2, 0, read);
                        } else {
                            fileOutputStream.flush();
                            fileInputStream2.close();
                            try {
                                try {
                                    fileOutputStream.close();
                                    return true;
                                } catch (Exception e2) {
                                    e = e2;
                                    BdLog.e(e.toString());
                                    if (fileInputStream != null) {
                                        try {
                                            fileInputStream.close();
                                        } catch (Exception e3) {
                                            BdLog.e(e3.toString());
                                        }
                                    }
                                    if (fileOutputStream == null) {
                                        try {
                                            fileOutputStream.close();
                                            return false;
                                        } catch (Exception e4) {
                                            BdLog.e(e4.toString());
                                            return false;
                                        }
                                    }
                                    return false;
                                }
                            } catch (Throwable th) {
                                th = th;
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (Exception e5) {
                                        BdLog.e(e5.toString());
                                    }
                                }
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (Exception e6) {
                                        BdLog.e(e6.toString());
                                    }
                                }
                                throw th;
                            }
                        }
                    }
                } catch (Exception e7) {
                    e = e7;
                    fileInputStream = fileInputStream2;
                    BdLog.e(e.toString());
                    if (fileInputStream != null) {
                    }
                    if (fileOutputStream == null) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                    }
                    if (fileOutputStream != null) {
                    }
                    throw th;
                }
            } catch (Exception e8) {
                e = e8;
                fileOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
            }
        } catch (Exception e9) {
            e = e9;
            fileOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
        }
    }
}

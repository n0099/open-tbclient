package com.baidu.cyberplayer.sdk.downloader;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.downloader.b;
import com.baidu.cyberplayer.sdk.o;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a implements b.a {
    public static /* synthetic */ Interceptable $ic;
    public static final String a;
    public transient /* synthetic */ FieldHolder $fh;
    public InterfaceC0089a b;
    public String c;
    public String d;
    public ArrayList<String> e;

    /* renamed from: com.baidu.cyberplayer.sdk.downloader.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0089a {
        void a(String str, long j);

        void a(String str, long j, int i, String str2);

        void a(String str, long j, long j2);

        void a(String str, long j, ArrayList<String> arrayList);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-913107620, "Lcom/baidu/cyberplayer/sdk/downloader/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-913107620, "Lcom/baidu/cyberplayer/sdk/downloader/a;");
                return;
            }
        }
        a = Boolean.toString(true);
    }

    public a() {
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
        this.e = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x004c, code lost:
        if (r2.exists() != false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0034, code lost:
        if (r2.exists() != false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0036, code lost:
        r2.delete();
     */
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0051: MOVE  (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:23:0x0051 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String a() {
        InterceptResult invokeV;
        File file;
        File file2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65538, this)) != null) {
            return (String) invokeV.objValue;
        }
        String str = a;
        File file3 = null;
        try {
            try {
                file = new File(this.d, this.c);
                try {
                    this.e = o.a(file, this.d);
                    CyberLog.d("CyberFileDownloader", "mUnzipFilesList:" + this.e);
                } catch (Exception e) {
                    e = e;
                    this.e = null;
                    str = e.toString();
                    if (file != null) {
                    }
                    return str;
                }
            } catch (Throwable th) {
                th = th;
                file3 = file2;
                if (file3 != null && file3.exists()) {
                    file3.delete();
                }
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            file = null;
        } catch (Throwable th2) {
            th = th2;
            if (file3 != null) {
                file3.delete();
            }
            throw th;
        }
    }

    public static String a(String str, String str2) {
        InterceptResult invokeLL;
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) {
            String str3 = "";
            for (File file : new File(str).listFiles()) {
                if (file.isFile() && file.getName().endsWith(".zip")) {
                    String replace = file.getName().replace(".zip", "");
                    if (replace.contains("cyber-media-dex")) {
                        str3 = replace.split("_")[2];
                    }
                    if (o.m()) {
                        try {
                            if (replace.startsWith("model_")) {
                                o.b(str2);
                                a(str2, o.a(file.getAbsoluteFile(), str2));
                            } else {
                                String str4 = str2 + File.separator + "libs";
                                o.b(str4);
                                a(str4, o.a(file.getAbsoluteFile(), str4));
                            }
                        } catch (Exception unused) {
                        }
                    }
                }
            }
            CyberLog.d("CyberFileDownloader", "external core ver:" + str3);
            return str3;
        }
        return (String) invokeLL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00a4, code lost:
        r1 = "file not found:" + r4.getAbsolutePath();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(String str, ArrayList<String> arrayList) {
        InterceptResult invokeLL;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, arrayList)) == null) {
            String str2 = a;
            if (arrayList != null) {
                int i = 0;
                while (true) {
                    try {
                        if (i >= arrayList.size()) {
                            break;
                        }
                        String str3 = arrayList.get(i);
                        if (!TextUtils.isEmpty(str3)) {
                            File file2 = new File(str, str3);
                            if (!file2.isDirectory()) {
                                String name = file2.getName();
                                String parent = file2.getParent();
                                if (!TextUtils.isEmpty(name) && name.startsWith("md5_") && name.length() > 36) {
                                    if (!file2.exists()) {
                                        break;
                                    }
                                    if (!file2.renameTo(new File(parent, name.substring(37)))) {
                                        str2 = "rename fail";
                                        break;
                                    }
                                    CyberLog.d("CyberFileDownloader", "rename " + file2.getName() + "(" + file2.exists() + ") to " + file.getName() + "(" + file.exists() + SmallTailInfo.EMOTION_SUFFIX);
                                }
                            }
                        }
                        i++;
                    } catch (Exception e) {
                        return e.toString();
                    }
                }
            }
            return str2;
        }
        return (String) invokeLL.objValue;
    }

    private String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            String str = a;
            try {
                if (this.e != null) {
                    CyberLog.d("CyberFileDownloader", "---step---checkUnzipFilesMd5----start");
                    for (int i = 0; i < this.e.size(); i++) {
                        String str2 = this.e.get(i);
                        if (!TextUtils.isEmpty(str2) && str2.startsWith("md5_")) {
                            String substring = str2.substring(4, 36);
                            if (!o.a(substring, this.d + File.separator + str2)) {
                                CyberLog.d("CyberFileDownloader", "---step---checkUnzipFilesMd5----fail");
                                return "md5 check fail.";
                            }
                        }
                    }
                }
                return str;
            } catch (Exception unused) {
                CyberLog.d("CyberFileDownloader", "---step---checkUnzipFilesMd5----fail");
                return "md5 check fail.";
            }
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.cyberplayer.sdk.downloader.b.a
    public void a(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j) == null) {
            this.b.a(str, j);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.downloader.b.a
    public void a(String str, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.b.a(str, j, j2);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.downloader.b.a
    public void a(String str, long j, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, Long.valueOf(j), str2}) == null) {
            this.b.a(str, j, -1, str2 + ",networkstatus:" + o.i() + ",url:" + str);
        }
    }

    public void a(String str, String str2, String str3, InterfaceC0089a interfaceC0089a) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048579, this, str, str2, str3, interfaceC0089a) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || interfaceC0089a == null) {
            return;
        }
        this.c = str2;
        this.b = interfaceC0089a;
        this.d = str3;
        o.b(str3);
        CyberLog.d("CyberFileDownloader", " unzipFolder:" + this.d);
        HashMap hashMap = new HashMap();
        hashMap.put("url", str + File.separator + this.c);
        hashMap.put("file-folder", this.d);
        hashMap.put("file-name", this.c);
        hashMap.put("is-asyn", "0");
        b.a(hashMap, this);
    }

    @Override // com.baidu.cyberplayer.sdk.downloader.b.a
    public void b(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048580, this, str, j) == null) {
            String a2 = a();
            if (!a.equals(a2)) {
                o.a(this.d, this.e);
                this.b.a(str, j, -2, a2);
                return;
            }
            String b = b();
            if (!a.equals(b)) {
                o.a(this.d, this.e);
                this.b.a(str, j, -3, b);
                return;
            }
            String a3 = a(this.d, this.e);
            if (a.equals(a3)) {
                this.b.a(str, j, this.e);
                return;
            }
            o.a(this.d, this.e);
            this.b.a(str, j, -6, a3);
        }
    }
}

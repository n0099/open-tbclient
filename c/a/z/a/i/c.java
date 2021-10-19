package c.a.z.a.i;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.z.a.e;
import c.a.z.a.h;
import com.android.internal.http.multipart.Part;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f31335a;

    /* renamed from: b  reason: collision with root package name */
    public String f31336b;

    /* renamed from: c  reason: collision with root package name */
    public String f31337c;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31335a = null;
        this.f31336b = null;
        this.f31337c = null;
        this.f31337c = "video_session";
        b(c.a.z.a.c.a());
    }

    public c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f31335a = null;
        this.f31336b = null;
        this.f31337c = null;
        this.f31337c = str;
        b(c.a.z.a.c.a());
    }

    public static void c(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, str, str2) == null) {
            File file = new File(str);
            if (file.exists() && file.isFile()) {
                file.renameTo(new File(str2));
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:34:0x0065 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:78:0x001c */
    /* JADX DEBUG: Multi-variable search result rejected for r3v2, resolved type: java.nio.channels.FileLock */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0089 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0093 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.io.RandomAccessFile, java.nio.channels.FileLock] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.nio.channels.FileLock] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x0082 -> B:80:0x0085). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void d(String str, byte[] bArr, String str2) {
        RandomAccessFile randomAccessFile;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65539, null, str, bArr, str2) == null) || bArr == null || TextUtils.isEmpty(str)) {
            return;
        }
        FileLock fileLock = 0;
        fileLock = 0;
        try {
            try {
                try {
                    randomAccessFile = new RandomAccessFile(str, "rw");
                    try {
                    } catch (Exception e2) {
                        e = e2;
                        e.b("DpStatFileWriter", "FileWriter invoke write fail:", e);
                        if (fileLock != 0) {
                            try {
                                fileLock.release();
                            } catch (Exception e3) {
                                e.b("DpStatFileWriter", "file lock release fail", e3);
                            }
                        }
                        if (randomAccessFile != null) {
                            randomAccessFile.close();
                        }
                        return;
                    }
                } catch (Throwable th) {
                    th = th;
                    if (0 != 0) {
                        try {
                            fileLock.release();
                        } catch (Exception e4) {
                            e.b("DpStatFileWriter", "file lock release fail", e4);
                        }
                    }
                    if (0 != 0) {
                        try {
                            fileLock.close();
                        } catch (Exception e5) {
                            e.b("DpStatFileWriter", "file close fail", e5);
                        }
                    }
                    throw th;
                }
            } catch (Exception e6) {
                e = e6;
                randomAccessFile = null;
            } catch (Throwable th2) {
                th = th2;
                if (0 != 0) {
                }
                if (0 != 0) {
                }
                throw th;
            }
        } catch (Exception e7) {
            e.b("DpStatFileWriter", "file close fail", e7);
        }
        if (randomAccessFile.length() > 10485760) {
            try {
                randomAccessFile.close();
                return;
            } catch (Exception e8) {
                e.b("DpStatFileWriter", "file close fail", e8);
                return;
            }
        }
        fileLock = randomAccessFile.getChannel().tryLock();
        if (fileLock != 0 && fileLock.isValid()) {
            randomAccessFile.seek(randomAccessFile.length());
            randomAccessFile.write(bArr);
            if (!TextUtils.isEmpty(str2)) {
                randomAccessFile.write(str2.getBytes());
            }
        }
        if (fileLock != 0) {
            try {
                fileLock.release();
            } catch (Exception e9) {
                e.b("DpStatFileWriter", "file lock release fail", e9);
            }
        }
        randomAccessFile.close();
    }

    public static boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            File file = new File(str);
            return file.exists() && file.isFile() && file.delete();
        }
        return invokeL.booleanValue;
    }

    public static boolean g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            File file = new File(str);
            return file.exists() && file.isFile();
        }
        return invokeL.booleanValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || TextUtils.isEmpty(this.f31335a) || TextUtils.isEmpty(this.f31336b)) {
            return;
        }
        ReentrantLock reentrantLock = new ReentrantLock(true);
        reentrantLock.lock();
        try {
            String str = this.f31335a;
            if (g(str)) {
                String str2 = this.f31336b;
                f(str2);
                if (h(str, str2)) {
                    f(str);
                } else {
                    f(str);
                    c(str2, str);
                }
                f(str2);
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public void b(Context context) {
        String c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) || context == null || (c2 = h.c(context)) == null) {
            return;
        }
        new File(c2).mkdirs();
    }

    public void e(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bArr) == null) || bArr == null || TextUtils.isEmpty(this.f31335a)) {
            return;
        }
        ReentrantLock reentrantLock = new ReentrantLock(true);
        reentrantLock.lock();
        try {
            try {
                d(this.f31335a, bArr, Part.CRLF);
            } catch (AssertionError unused) {
                e.e("DpStatFileWriter", "write data to file fail");
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public boolean h(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            try {
                FileInputStream fileInputStream = new FileInputStream(str);
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                this.f31337c.equals("live_show_session");
                bufferedReader.close();
                inputStreamReader.close();
                fileInputStream.close();
                return true;
            } catch (Exception e2) {
                e2.printStackTrace();
                e.e("DpStatFileWriter", "readAndUploadLogFile failed");
                return true;
            }
        }
        return invokeLL.booleanValue;
    }
}

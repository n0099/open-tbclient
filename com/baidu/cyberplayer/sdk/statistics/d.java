package com.baidu.cyberplayer.sdk.statistics;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.CyberVersion;
import com.baidu.cyberplayer.sdk.o;
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
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f34092b;

    /* renamed from: c  reason: collision with root package name */
    public String f34093c;

    public d() {
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
        this.a = null;
        this.f34092b = null;
        this.f34093c = null;
        this.f34093c = "video_session";
        a(CyberPlayerManager.getApplicationContext());
    }

    public d(String str) {
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
        this.a = null;
        this.f34092b = null;
        this.f34093c = null;
        this.f34093c = str;
        a(CyberPlayerManager.getApplicationContext());
    }

    public static void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, str, str2) == null) {
            File file = new File(str);
            if (file.exists() && file.isFile()) {
                file.renameTo(new File(str2));
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:34:0x0065 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:36:0x0067 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:96:0x001c */
    /* JADX DEBUG: Multi-variable search result rejected for r3v2, resolved type: java.nio.channels.FileLock */
    /* JADX DEBUG: Multi-variable search result rejected for r3v3, resolved type: java.nio.channels.FileLock */
    /* JADX DEBUG: Multi-variable search result rejected for r3v5, resolved type: java.nio.channels.FileLock */
    /* JADX DEBUG: Multi-variable search result rejected for r3v7, resolved type: java.nio.channels.FileLock */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.io.RandomAccessFile, java.nio.channels.FileLock] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.nio.channels.FileLock] */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:63:0x009b -> B:88:0x009e). Please submit an issue!!! */
    public static void a(String str, byte[] bArr, String str2) {
        RandomAccessFile randomAccessFile;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65539, null, str, bArr, str2) == null) || bArr == null || TextUtils.isEmpty(str)) {
            return;
        }
        FileLock fileLock = 0;
        fileLock = 0;
        fileLock = 0;
        fileLock = 0;
        try {
        } catch (Throwable th) {
            th = th;
        }
        try {
            try {
                randomAccessFile = new RandomAccessFile(str, "rw");
            } catch (Exception e2) {
                CyberLog.e("DpStatFileWriter", "file close fail", e2);
            }
            try {
            } catch (Error e3) {
                e = e3;
                CyberLog.e("DpStatFileWriter", "FileWriter invoke write error:", e);
                if (fileLock != 0) {
                    try {
                        fileLock.release();
                    } catch (Exception e4) {
                        CyberLog.e("DpStatFileWriter", "file lock release fail", e4);
                    }
                }
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                return;
            } catch (Exception e5) {
                e = e5;
                CyberLog.e("DpStatFileWriter", "FileWriter invoke write exception:", e);
                if (fileLock != 0) {
                    try {
                        fileLock.release();
                    } catch (Exception e6) {
                        CyberLog.e("DpStatFileWriter", "file lock release fail", e6);
                    }
                }
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                return;
            }
        } catch (Error e7) {
            e = e7;
            randomAccessFile = null;
        } catch (Exception e8) {
            e = e8;
            randomAccessFile = null;
        } catch (Throwable th2) {
            th = th2;
            if (0 != 0) {
                try {
                    fileLock.release();
                } catch (Exception e9) {
                    CyberLog.e("DpStatFileWriter", "file lock release fail", e9);
                }
            }
            if (0 != 0) {
                try {
                    fileLock.close();
                } catch (Exception e10) {
                    CyberLog.e("DpStatFileWriter", "file close fail", e10);
                }
            }
            throw th;
        }
        if (randomAccessFile.length() > 10485760) {
            try {
                randomAccessFile.close();
                return;
            } catch (Exception e11) {
                CyberLog.e("DpStatFileWriter", "file close fail", e11);
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
            } catch (Exception e12) {
                CyberLog.e("DpStatFileWriter", "file lock release fail", e12);
            }
        }
        randomAccessFile.close();
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            File file = new File(str);
            return file.exists() && file.isFile() && file.delete();
        }
        return invokeL.booleanValue;
    }

    public static boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
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
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || TextUtils.isEmpty(this.a) || TextUtils.isEmpty(this.f34092b)) {
            return;
        }
        ReentrantLock reentrantLock = new ReentrantLock(true);
        reentrantLock.lock();
        try {
            String str = this.a;
            if (b(str)) {
                String str2 = this.f34092b;
                a(str2);
                if (b(str, str2)) {
                    a(str);
                } else {
                    a(str);
                    a(str2, str);
                }
                a(str2);
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public void a(Context context) {
        String b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) || context == null || (b2 = o.b(context)) == null) {
            return;
        }
        new File(b2).mkdirs();
        String coreVersionInternal = CyberVersion.getCoreVersionInternal();
        this.a = b2 + File.separator + this.f34093c + "_" + coreVersionInternal + ".bak";
        this.f34092b = b2 + File.separator + this.f34093c + "_log_" + coreVersionInternal + ".tmp";
    }

    public void a(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bArr) == null) || bArr == null || TextUtils.isEmpty(this.a)) {
            return;
        }
        ReentrantLock reentrantLock = new ReentrantLock(true);
        reentrantLock.lock();
        try {
            try {
                a(this.a, bArr, "\r\n");
            } catch (AssertionError unused) {
                CyberLog.e("DpStatFileWriter", "write data to file fail");
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public boolean b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            boolean z = false;
            boolean z2 = true;
            try {
                FileInputStream fileInputStream = new FileInputStream(str);
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String a = DpSessionDatasUploader.getInstance().a("sailor_monitor", this.f34093c.equals("live_show_session") ? 24 : 1);
                if (TextUtils.isEmpty(a)) {
                    z = true;
                } else {
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            } else if (!DpSessionDatasUploader.getInstance().a(Base64.decode(readLine, 2), a, false)) {
                                try {
                                    a(str2, readLine.getBytes(), "\r\n");
                                    z2 = false;
                                } catch (Exception e2) {
                                    e = e2;
                                    e.printStackTrace();
                                    CyberLog.e("DpStatFileWriter", "readAndUploadLogFile failed");
                                    return z;
                                }
                            }
                        } catch (Exception e3) {
                            e = e3;
                            z = z2;
                            e.printStackTrace();
                            CyberLog.e("DpStatFileWriter", "readAndUploadLogFile failed");
                            return z;
                        }
                    }
                    z = z2;
                }
                bufferedReader.close();
                inputStreamReader.close();
                fileInputStream.close();
            } catch (Exception e4) {
                e = e4;
                z = true;
            }
            return z;
        }
        return invokeLL.booleanValue;
    }
}

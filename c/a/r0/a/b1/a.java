package c.a.r0.a.b1;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import c.a.r0.a.k;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.charset.Charset;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(420468641, "Lc/a/r0/a/b1/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(420468641, "Lc/a/r0/a/b1/a;");
                return;
            }
        }
        a = k.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x009d A[Catch: all -> 0x00c8, TryCatch #7 {, blocks: (B:6:0x0007, B:8:0x0012, B:12:0x0018, B:22:0x006a, B:23:0x006d, B:49:0x0095, B:51:0x009d, B:52:0x00b3, B:26:0x0072, B:57:0x00bc, B:58:0x00bf, B:62:0x00c7, B:61:0x00c4, B:44:0x008c, B:45:0x008f), top: B:76:0x0007, inners: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00bc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @SuppressLint({"SwanDebugLog"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized String a(String str) {
        InterceptResult invokeL;
        BufferedReader bufferedReader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            synchronized (a.class) {
                long currentTimeMillis = System.currentTimeMillis();
                FileLock fileLock = null;
                if (TextUtils.isEmpty(str) && a) {
                    return null;
                }
                StringBuffer stringBuffer = new StringBuffer();
                try {
                    FileChannel channel = new RandomAccessFile(str, "rw").getChannel();
                    FileLock lock = channel.lock(0L, Long.MAX_VALUE, true);
                    try {
                        bufferedReader = new BufferedReader(Channels.newReader(channel, Charset.defaultCharset().name()));
                        while (true) {
                            try {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                stringBuffer.append(readLine);
                            } catch (IOException e2) {
                                e = e2;
                                fileLock = lock;
                                try {
                                    Log.getStackTraceString(e);
                                    if (fileLock != null) {
                                        try {
                                            fileLock.release();
                                        } catch (IOException e3) {
                                            e = e3;
                                            Log.getStackTraceString(e);
                                            long currentTimeMillis2 = System.currentTimeMillis();
                                            if (a) {
                                            }
                                            return stringBuffer.toString();
                                        }
                                    }
                                    c.a.r0.w.d.d(bufferedReader);
                                    long currentTimeMillis22 = System.currentTimeMillis();
                                    if (a) {
                                    }
                                    return stringBuffer.toString();
                                } catch (Throwable th) {
                                    th = th;
                                    if (fileLock != null) {
                                        try {
                                            fileLock.release();
                                        } catch (IOException e4) {
                                            Log.getStackTraceString(e4);
                                            throw th;
                                        }
                                    }
                                    c.a.r0.w.d.d(bufferedReader);
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                fileLock = lock;
                                if (fileLock != null) {
                                }
                                c.a.r0.w.d.d(bufferedReader);
                                throw th;
                            }
                        }
                        if (a) {
                            String str2 = "Read file: " + stringBuffer.toString();
                        }
                        if (lock != null) {
                            try {
                                lock.release();
                            } catch (IOException e5) {
                                e = e5;
                                Log.getStackTraceString(e);
                                long currentTimeMillis222 = System.currentTimeMillis();
                                if (a) {
                                }
                                return stringBuffer.toString();
                            }
                        }
                        c.a.r0.w.d.d(bufferedReader);
                    } catch (IOException e6) {
                        e = e6;
                        bufferedReader = null;
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedReader = null;
                    }
                } catch (IOException e7) {
                    e = e7;
                    bufferedReader = null;
                } catch (Throwable th4) {
                    th = th4;
                    bufferedReader = null;
                }
                long currentTimeMillis2222 = System.currentTimeMillis();
                if (a) {
                    String str3 = "Read file done: cost time = " + (currentTimeMillis2222 - currentTimeMillis) + "ms";
                }
                return stringBuffer.toString();
            }
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00a3 A[Catch: all -> 0x00ca, TRY_LEAVE, TryCatch #6 {, blocks: (B:6:0x0007, B:8:0x0012, B:27:0x0070, B:31:0x0078, B:48:0x009b, B:50:0x00a3, B:30:0x0075, B:55:0x00be, B:59:0x00c6, B:60:0x00c9, B:58:0x00c3, B:43:0x0090, B:47:0x0098, B:46:0x0095), top: B:74:0x0007, inners: #2, #3, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00be A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @SuppressLint({"SwanDebugLog"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized boolean b(String str, String str2, boolean z) {
        InterceptResult invokeLLZ;
        FileChannel fileChannel;
        FileChannel channel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65538, null, str, str2, z)) == null) {
            synchronized (a.class) {
                long currentTimeMillis = System.currentTimeMillis();
                boolean z2 = false;
                if (TextUtils.isEmpty(str) && a) {
                    return false;
                }
                FileLock fileLock = null;
                try {
                    File file = new File(str);
                    File file2 = new File(file.getParent());
                    if (!file2.exists()) {
                        file2.mkdirs();
                    }
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    channel = new FileOutputStream(file, z).getChannel();
                } catch (IOException e2) {
                    e = e2;
                    fileChannel = null;
                } catch (Throwable th) {
                    th = th;
                    fileChannel = null;
                }
                try {
                    fileLock = channel.lock();
                    if (TextUtils.isEmpty(str2)) {
                        str2 = "";
                    }
                    channel.write(ByteBuffer.wrap(str2.getBytes()));
                    z2 = true;
                    if (a) {
                        String str3 = "Write file：" + str2;
                    }
                    if (fileLock != null) {
                        try {
                            fileLock.release();
                        } catch (IOException e3) {
                            Log.getStackTraceString(e3);
                        }
                    }
                    c.a.r0.w.d.d(channel);
                } catch (IOException e4) {
                    fileChannel = channel;
                    e = e4;
                    try {
                        Log.getStackTraceString(e);
                        if (fileLock != null) {
                            try {
                                fileLock.release();
                            } catch (IOException e5) {
                                Log.getStackTraceString(e5);
                            }
                        }
                        c.a.r0.w.d.d(fileChannel);
                        long currentTimeMillis2 = System.currentTimeMillis();
                        if (a) {
                        }
                        return z2;
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileLock != null) {
                            try {
                                fileLock.release();
                            } catch (IOException e6) {
                                Log.getStackTraceString(e6);
                            }
                        }
                        c.a.r0.w.d.d(fileChannel);
                        throw th;
                    }
                } catch (Throwable th3) {
                    fileChannel = channel;
                    th = th3;
                    if (fileLock != null) {
                    }
                    c.a.r0.w.d.d(fileChannel);
                    throw th;
                }
                long currentTimeMillis22 = System.currentTimeMillis();
                if (a) {
                    String str4 = "Write file done: cost time =" + (currentTimeMillis22 - currentTimeMillis) + "ms";
                }
                return z2;
            }
        }
        return invokeLLZ.booleanValue;
    }
}

package com.baidu.android.util.io;

import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.zip.ZipFile;
@Deprecated
/* loaded from: classes10.dex */
public class CommentUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public CommentUtils() {
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

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x005d: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:34:0x005d */
    public static String readApk(File file) {
        InterceptResult invokeL;
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65537, null, file)) != null) {
            return (String) invokeL.objValue;
        }
        RandomAccessFile randomAccessFile3 = null;
        try {
        } catch (Throwable th) {
            th = th;
            randomAccessFile3 = randomAccessFile;
        }
        try {
            try {
                randomAccessFile2 = new RandomAccessFile(file, "r");
            } catch (IOException e2) {
                e2.printStackTrace();
                return null;
            }
            try {
                byte[] bArr = new byte[2];
                long length = randomAccessFile2.length() - 2;
                randomAccessFile2.seek(length);
                randomAccessFile2.readFully(bArr);
                int stream2Short = stream2Short(bArr, 0);
                byte[] bArr2 = new byte[stream2Short];
                randomAccessFile2.seek(length - stream2Short);
                randomAccessFile2.readFully(bArr2);
                String str = new String(bArr2, "utf-8");
                try {
                    randomAccessFile2.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
                return str;
            } catch (FileNotFoundException e4) {
                e = e4;
                e.printStackTrace();
                if (randomAccessFile2 != null) {
                    randomAccessFile2.close();
                }
                return null;
            } catch (IOException e5) {
                e = e5;
                e.printStackTrace();
                if (randomAccessFile2 != null) {
                    randomAccessFile2.close();
                }
                return null;
            }
        } catch (FileNotFoundException e6) {
            e = e6;
            randomAccessFile2 = null;
        } catch (IOException e7) {
            e = e7;
            randomAccessFile2 = null;
        } catch (Throwable th2) {
            th = th2;
            if (randomAccessFile3 != null) {
                try {
                    randomAccessFile3.close();
                } catch (IOException e8) {
                    e8.printStackTrace();
                }
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x003c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String readComment(File file) {
        InterceptResult invokeL;
        ZipFile zipFile;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65538, null, file)) != null) {
            return (String) invokeL.objValue;
        }
        ZipFile zipFile2 = null;
        try {
            if (Build.VERSION.SDK_INT >= 19) {
                zipFile = new ZipFile(file);
                try {
                    try {
                        str = zipFile.getComment();
                        zipFile2 = zipFile;
                    } catch (IOException e2) {
                        e = e2;
                        e.printStackTrace();
                        if (zipFile != null) {
                            try {
                                zipFile.close();
                                return null;
                            } catch (Exception e3) {
                                e3.printStackTrace();
                                return null;
                            }
                        }
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                    zipFile2 = zipFile;
                    if (zipFile2 != null) {
                        try {
                            zipFile2.close();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            } else {
                str = null;
            }
            if (zipFile2 != null) {
                try {
                    zipFile2.close();
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
            return str;
        } catch (IOException e6) {
            e = e6;
            zipFile = null;
        } catch (Throwable th2) {
            th = th2;
            if (zipFile2 != null) {
            }
            throw th;
        }
    }

    public static byte[] short2Stream(short s) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Short.valueOf(s)})) == null) {
            ByteBuffer allocate = ByteBuffer.allocate(2);
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            allocate.putShort(s);
            allocate.flip();
            return allocate.array();
        }
        return (byte[]) invokeCommon.objValue;
    }

    public static short stream2Short(byte[] bArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr, i2)) == null) {
            ByteBuffer allocate = ByteBuffer.allocate(2);
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            allocate.put(bArr[i2]);
            allocate.put(bArr[i2 + 1]);
            return allocate.getShort(0);
        }
        return invokeLI.shortValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x00aa A[Catch: Exception -> 0x00a6, TryCatch #9 {Exception -> 0x00a6, blocks: (B:55:0x00a2, B:59:0x00aa, B:61:0x00af), top: B:73:0x00a2 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00af A[Catch: Exception -> 0x00a6, TRY_LEAVE, TryCatch #9 {Exception -> 0x00a6, blocks: (B:55:0x00a2, B:59:0x00aa, B:61:0x00af), top: B:73:0x00a2 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00a2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String writeApk(File file, String str) {
        InterceptResult invokeLL;
        ByteArrayOutputStream byteArrayOutputStream;
        RandomAccessFile randomAccessFile;
        byte[] byteArray;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65541, null, file, str)) != null) {
            return (String) invokeLL.objValue;
        }
        ZipFile zipFile = null;
        try {
            ZipFile zipFile2 = new ZipFile(file);
            try {
                if ((Build.VERSION.SDK_INT >= 19 ? zipFile2.getComment() : "") != null) {
                    try {
                        zipFile2.close();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    return "bad";
                }
                byte[] bytes = str.getBytes();
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    byteArrayOutputStream.write(bytes);
                    byteArrayOutputStream.write(short2Stream((short) bytes.length));
                    byteArray = byteArrayOutputStream.toByteArray();
                    randomAccessFile = new RandomAccessFile(file, "rw");
                } catch (IOException e3) {
                    e = e3;
                    randomAccessFile = null;
                } catch (Throwable th) {
                    th = th;
                    randomAccessFile = null;
                }
                try {
                    randomAccessFile.seek(file.length() - 2);
                    randomAccessFile.write(short2Stream((short) byteArray.length));
                    randomAccessFile.write(byteArray);
                    try {
                        zipFile2.close();
                        byteArrayOutputStream.close();
                        randomAccessFile.close();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                    return "good";
                } catch (IOException e5) {
                    e = e5;
                    zipFile = zipFile2;
                    try {
                        e.printStackTrace();
                        if (zipFile != null) {
                            try {
                                zipFile.close();
                            } catch (Exception e6) {
                                e6.printStackTrace();
                                return "bad";
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        if (randomAccessFile != null) {
                            randomAccessFile.close();
                        }
                        return "bad";
                    } catch (Throwable th2) {
                        th = th2;
                        if (zipFile != null) {
                            try {
                                zipFile.close();
                            } catch (Exception e7) {
                                e7.printStackTrace();
                                throw th;
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        if (randomAccessFile != null) {
                            randomAccessFile.close();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    zipFile = zipFile2;
                    if (zipFile != null) {
                    }
                    if (byteArrayOutputStream != null) {
                    }
                    if (randomAccessFile != null) {
                    }
                    throw th;
                }
            } catch (IOException e8) {
                e = e8;
                byteArrayOutputStream = null;
                randomAccessFile = null;
            } catch (Throwable th4) {
                th = th4;
                byteArrayOutputStream = null;
                randomAccessFile = null;
            }
        } catch (IOException e9) {
            e = e9;
            byteArrayOutputStream = null;
            randomAccessFile = null;
        } catch (Throwable th5) {
            th = th5;
            byteArrayOutputStream = null;
            randomAccessFile = null;
        }
    }
}

package c.a.j0.a.k;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static byte[] a(File file) {
        InterceptResult invokeL;
        FileInputStream fileInputStream;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65536, null, file)) != null) {
            return (byte[]) invokeL.objValue;
        }
        try {
            if (file.exists()) {
                fileInputStream = new FileInputStream(file);
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        try {
                            byte[] bArr = new byte[32768];
                            while (true) {
                                int read = fileInputStream.read(bArr);
                                if (read != -1) {
                                    byteArrayOutputStream.write(bArr, 0, read);
                                } else {
                                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                                    c(byteArrayOutputStream);
                                    c(fileInputStream);
                                    return byteArray;
                                }
                            }
                        } catch (IOException e2) {
                            e = e2;
                            b.i().c("Failed to read file", e);
                            c(byteArrayOutputStream);
                            c(fileInputStream);
                            return null;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        c(byteArrayOutputStream);
                        c(fileInputStream);
                        throw th;
                    }
                } catch (IOException e3) {
                    e = e3;
                    byteArrayOutputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    byteArrayOutputStream = null;
                    c(byteArrayOutputStream);
                    c(fileInputStream);
                    throw th;
                }
            } else {
                throw new FileNotFoundException();
            }
        } catch (IOException e4) {
            e = e4;
            byteArrayOutputStream = null;
            fileInputStream = null;
        } catch (Throwable th4) {
            fileInputStream = null;
            th = th4;
            byteArrayOutputStream = null;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:14:0x002a */
    /* JADX DEBUG: Multi-variable search result rejected for r5v5, resolved type: java.io.BufferedOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r5v7, resolved type: java.io.BufferedOutputStream */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v6 */
    public static void b(byte[] bArr, File file) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        FileOutputStream fileOutputStream3;
        BufferedOutputStream bufferedOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, bArr, file) == null) {
            FileOutputStream fileOutputStream4 = null;
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
                fileOutputStream = new FileOutputStream(file);
                try {
                    bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                    try {
                        bufferedOutputStream.write(bArr);
                        fileOutputStream.flush();
                        bufferedOutputStream.flush();
                        c(fileOutputStream);
                        fileOutputStream3 = bufferedOutputStream;
                    } catch (IOException e2) {
                        e = e2;
                        fileOutputStream4 = fileOutputStream;
                        fileOutputStream2 = bufferedOutputStream;
                        try {
                            b.i().c("Failed to save file", e);
                            c(fileOutputStream4);
                            fileOutputStream3 = fileOutputStream2;
                            c(fileOutputStream3);
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream = fileOutputStream4;
                            fileOutputStream4 = fileOutputStream2;
                            c(fileOutputStream);
                            c(fileOutputStream4);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream4 = bufferedOutputStream;
                        try {
                            b.i().c("Failed to save file", th);
                            c(fileOutputStream);
                            c(fileOutputStream4);
                            return;
                        } catch (Throwable th3) {
                            th = th3;
                            c(fileOutputStream);
                            c(fileOutputStream4);
                            throw th;
                        }
                    }
                } catch (IOException e3) {
                    e = e3;
                    bufferedOutputStream = 0;
                } catch (Throwable th4) {
                    th = th4;
                }
            } catch (IOException e4) {
                e = e4;
                fileOutputStream2 = null;
            } catch (Throwable th5) {
                th = th5;
                fileOutputStream = null;
            }
            c(fileOutputStream3);
        }
    }

    public static void c(Closeable closeable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, closeable) == null) || closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException e2) {
            b.i().f("Failed to close the target", e2);
        }
    }
}

package com.baidu.ar.h;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
/* loaded from: classes10.dex */
public class t {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(ZipInputStream zipInputStream, File file) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(65536, null, zipInputStream, file) != null) {
            return;
        }
        while (true) {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry == null) {
                return;
            }
            File file2 = new File(file, nextEntry.getName());
            i.c(file2);
            if (nextEntry.isDirectory()) {
                file2.mkdirs();
            } else {
                k.a(zipInputStream, file2);
            }
            zipInputStream.closeEntry();
        }
    }

    public static boolean a(File file, File file2) {
        InterceptResult invokeLL;
        ZipInputStream zipInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, file, file2)) == null) {
            ZipInputStream zipInputStream2 = null;
            try {
                try {
                    zipInputStream = new ZipInputStream(new CheckedInputStream(new FileInputStream(file), new CRC32()));
                } catch (IOException e2) {
                    e = e2;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                a(zipInputStream, file2);
                k.closeQuietly(zipInputStream);
                return true;
            } catch (IOException e3) {
                e = e3;
                zipInputStream2 = zipInputStream;
                e.printStackTrace();
                k.closeQuietly(zipInputStream2);
                return false;
            } catch (Throwable th2) {
                th = th2;
                zipInputStream2 = zipInputStream;
                k.closeQuietly(zipInputStream2);
                throw th;
            }
        }
        return invokeLL.booleanValue;
    }
}

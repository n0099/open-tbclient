package com.baidu.fsg.base.utils;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
/* loaded from: classes7.dex */
public abstract class FileCopyUtils {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final int f38400a = 4096;
    public transient /* synthetic */ FieldHolder $fh;

    public FileCopyUtils() {
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

    public static int copy(File file, File file2) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, file, file2)) == null) {
            Assert.notNull(file, "No input File specified");
            Assert.notNull(file2, "No output File specified");
            return copy(new BufferedInputStream(new FileInputStream(file)), new BufferedOutputStream(new FileOutputStream(file2)));
        }
        return invokeLL.intValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE] complete} */
    public static int copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, inputStream, outputStream)) == null) {
            Assert.notNull(inputStream, "No InputStream specified");
            Assert.notNull(outputStream, "No OutputStream specified");
            try {
                byte[] bArr = new byte[4096];
                int i2 = 0;
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    outputStream.write(bArr, 0, read);
                    i2 += read;
                }
                outputStream.flush();
                try {
                    outputStream.close();
                } catch (IOException unused) {
                }
                return i2;
            } finally {
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                }
                try {
                    outputStream.close();
                } catch (IOException unused3) {
                }
            }
        }
        return invokeLL.intValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE] complete} */
    public static int copy(Reader reader, Writer writer) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, reader, writer)) == null) {
            Assert.notNull(reader, "No Reader specified");
            Assert.notNull(writer, "No Writer specified");
            try {
                char[] cArr = new char[4096];
                int i2 = 0;
                while (true) {
                    int read = reader.read(cArr);
                    if (read == -1) {
                        break;
                    }
                    writer.write(cArr, 0, read);
                    i2 += read;
                }
                writer.flush();
                try {
                    writer.close();
                } catch (IOException unused) {
                }
                return i2;
            } finally {
                try {
                    reader.close();
                } catch (IOException unused2) {
                }
                try {
                    writer.close();
                } catch (IOException unused3) {
                }
            }
        }
        return invokeLL.intValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE] complete} */
    public static void copy(String str, Writer writer) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, writer) == null) {
            Assert.notNull(str, "No input String specified");
            Assert.notNull(writer, "No Writer specified");
            try {
                writer.write(str);
            } finally {
                try {
                    writer.close();
                } catch (IOException unused) {
                }
            }
        }
    }

    public static void copy(byte[] bArr, File file) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, bArr, file) == null) {
            Assert.notNull(bArr, "No input byte array specified");
            Assert.notNull(file, "No output File specified");
            copy(new ByteArrayInputStream(bArr), new BufferedOutputStream(new FileOutputStream(file)));
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE] complete} */
    public static void copy(byte[] bArr, OutputStream outputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, bArr, outputStream) == null) {
            Assert.notNull(bArr, "No input byte array specified");
            Assert.notNull(outputStream, "No OutputStream specified");
            try {
                outputStream.write(bArr);
            } finally {
                try {
                    outputStream.close();
                } catch (IOException unused) {
                }
            }
        }
    }

    public static byte[] copyToByteArray(File file) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, file)) == null) {
            Assert.notNull(file, "No input File specified");
            return copyToByteArray(new BufferedInputStream(new FileInputStream(file)));
        }
        return (byte[]) invokeL.objValue;
    }

    public static byte[] copyToByteArray(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, inputStream)) == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(4096);
            copy(inputStream, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        }
        return (byte[]) invokeL.objValue;
    }

    public static boolean copyToFile(InputStream inputStream, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, inputStream, file)) == null) {
            try {
                if (file.exists()) {
                    file.delete();
                }
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read < 0) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                fileOutputStream.flush();
                try {
                    fileOutputStream.getFD().sync();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                fileOutputStream.close();
                return true;
            } catch (IOException e3) {
                e3.printStackTrace();
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static boolean copyToFile(String str, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, str, file)) == null) {
            try {
                if (file.exists()) {
                    file.delete();
                }
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                fileOutputStream.write(str.getBytes());
                fileOutputStream.flush();
                try {
                    fileOutputStream.getFD().sync();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                fileOutputStream.close();
                return true;
            } catch (IOException e3) {
                e3.printStackTrace();
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static String copyToString(Reader reader) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, reader)) == null) {
            StringWriter stringWriter = new StringWriter();
            copy(reader, stringWriter);
            return stringWriter.toString();
        }
        return (String) invokeL.objValue;
    }
}

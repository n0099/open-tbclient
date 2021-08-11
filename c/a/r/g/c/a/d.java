package c.a.r.g.c.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
/* loaded from: classes4.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(InputStream inputStream, OutputStream outputStream, int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLLI(65536, null, inputStream, outputStream, i2) != null) {
            return;
        }
        byte[] bArr = new byte[i2];
        while (true) {
            int read = inputStream.read(bArr);
            if (read <= 0) {
                return;
            }
            outputStream.write(bArr, 0, read);
        }
    }

    public static String b(InputStream inputStream, String str) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65537, null, inputStream, str)) != null) {
            return (String) invokeLL.objValue;
        }
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, str);
        char[] cArr = new char[8192];
        while (true) {
            int read = inputStreamReader.read(cArr);
            if (read > 0) {
                charArrayWriter.write(cArr, 0, read);
            } else {
                return charArrayWriter.toString();
            }
        }
    }
}

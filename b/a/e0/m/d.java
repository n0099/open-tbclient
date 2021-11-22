package b.a.e0.m;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
/* loaded from: classes.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:27:? */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:8:0x0029 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.io.BufferedInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v11, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.io.Closeable[]] */
    public static Bitmap a(String str) {
        InterceptResult invokeL;
        ?? r3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            Bitmap bitmap = null;
            try {
                r3 = new BufferedInputStream(((HttpURLConnection) new URL(str).openConnection()).getInputStream(), 8192);
                try {
                    try {
                        bitmap = BitmapFactory.decodeStream(r3);
                        b.a.e0.r.f.a(new Closeable[]{r3});
                    } catch (Exception e2) {
                        e = e2;
                        e.printStackTrace();
                        b.a.e0.r.f.a(new Closeable[]{r3});
                        return bitmap;
                    }
                } catch (Throwable th) {
                    th = th;
                    bitmap = r3;
                    b.a.e0.r.f.a(new Closeable[]{bitmap});
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                r3 = 0;
            } catch (Throwable th2) {
                th = th2;
                b.a.e0.r.f.a(new Closeable[]{bitmap});
                throw th;
            }
            return bitmap;
        }
        return (Bitmap) invokeL.objValue;
    }

    public static boolean b(String str, OutputStream outputStream) {
        InterceptResult invokeLL;
        Throwable th;
        BufferedOutputStream bufferedOutputStream;
        IOException e2;
        BufferedInputStream bufferedInputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65537, null, str, outputStream)) != null) {
            return invokeLL.booleanValue;
        }
        BufferedInputStream bufferedInputStream2 = null;
        try {
            bufferedInputStream = new BufferedInputStream(((HttpURLConnection) new URL(str).openConnection()).getInputStream());
            try {
                bufferedOutputStream = new BufferedOutputStream(outputStream);
            } catch (IOException e3) {
                e2 = e3;
                bufferedOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                bufferedOutputStream = null;
            }
        } catch (IOException e4) {
            e2 = e4;
            bufferedOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            bufferedOutputStream = null;
        }
        try {
            byte[] bArr = new byte[8192];
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read != -1) {
                    bufferedOutputStream.write(bArr, 0, read);
                } else {
                    b.a.e0.r.f.a(bufferedInputStream, bufferedOutputStream);
                    return true;
                }
            }
        } catch (IOException e5) {
            e2 = e5;
            bufferedInputStream2 = bufferedInputStream;
            try {
                e2.printStackTrace();
                b.a.e0.r.f.a(bufferedInputStream2, bufferedOutputStream);
                return false;
            } catch (Throwable th4) {
                th = th4;
                b.a.e0.r.f.a(bufferedInputStream2, bufferedOutputStream);
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            bufferedInputStream2 = bufferedInputStream;
            b.a.e0.r.f.a(bufferedInputStream2, bufferedOutputStream);
            throw th;
        }
    }
}

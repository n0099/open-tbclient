package c.a.p0.a.z2;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes.dex */
public final class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, str)) == null) {
            if (context == null || TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                c.a.p0.w.d.d(context.getAssets().open(str, 0));
                return true;
            } catch (IOException unused) {
                c.a.p0.w.d.d(null);
                return false;
            } catch (Throwable th) {
                c.a.p0.w.d.d(null);
                throw th;
            }
        }
        return invokeLL.booleanValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:25:0x001b */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:26:0x0005 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [android.content.Context, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    public static String b(Context context, String str) {
        InterceptResult invokeLL;
        InputStream inputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) {
            Closeable closeable = null;
            String str2 = null;
            try {
                try {
                    inputStream = context.getAssets().open(str);
                } catch (Throwable th) {
                    th = th;
                    closeable = context;
                    c.a.p0.w.d.d(closeable);
                    throw th;
                }
            } catch (IOException unused) {
                inputStream = null;
            } catch (Throwable th2) {
                th = th2;
                c.a.p0.w.d.d(closeable);
                throw th;
            }
            if (inputStream == null) {
                c.a.p0.w.d.d(inputStream);
                return null;
            }
            try {
                str2 = c.a.p0.w.g.b(inputStream);
                context = inputStream;
            } catch (IOException unused2) {
                boolean z = c.a.p0.a.k.a;
                context = inputStream;
                c.a.p0.w.d.d(context);
                return str2;
            }
            c.a.p0.w.d.d(context);
            return str2;
        }
        return (String) invokeLL.objValue;
    }
}

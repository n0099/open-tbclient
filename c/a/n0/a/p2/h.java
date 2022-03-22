package c.a.n0.a.p2;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.io.AssetUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
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
                c.a.n0.w.d.d(context.getAssets().open(str, 0));
                return true;
            } catch (IOException unused) {
                c.a.n0.w.d.d(null);
                return false;
            } catch (Throwable th) {
                c.a.n0.w.d.d(null);
                throw th;
            }
        }
        return invokeLL.booleanValue;
    }

    public static String b(Context context, String str) {
        InterceptResult invokeLL;
        InputStream inputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) {
            InputStream inputStream2 = null;
            r0 = null;
            String str2 = null;
            try {
                inputStream = context.getAssets().open(str);
            } catch (IOException e2) {
                e = e2;
                inputStream = null;
            } catch (Throwable th) {
                th = th;
                c.a.n0.w.d.d(inputStream2);
                throw th;
            }
            if (inputStream == null) {
                c.a.n0.w.d.d(inputStream);
                return null;
            }
            try {
                try {
                    str2 = c.a.n0.w.g.b(inputStream);
                } catch (IOException e3) {
                    e = e3;
                    if (c.a.n0.a.a.a) {
                        Log.w(AssetUtils.TAG, "loadPresetDatas", e);
                    }
                    c.a.n0.w.d.d(inputStream);
                    return str2;
                }
                c.a.n0.w.d.d(inputStream);
                return str2;
            } catch (Throwable th2) {
                th = th2;
                inputStream2 = inputStream;
                c.a.n0.w.d.d(inputStream2);
                throw th;
            }
        }
        return (String) invokeLL.objValue;
    }
}

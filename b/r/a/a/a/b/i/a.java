package b.r.a.a.a.b.i;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import androidx.core.view.InputDeviceCompat;
import b.r.a.a.c.b.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static volatile a f33649c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f33650a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f33651b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-274160947, "Lb/r/a/a/a/b/i/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-274160947, "Lb/r/a/a/a/b/i/a;");
        }
    }

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f33651b = false;
        this.f33650a = context;
        this.f33651b = "1".equals(d("persist.sys.identifierid.supported", "0"));
    }

    public static a a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f33649c == null) {
                synchronized (a.class) {
                    if (f33649c == null) {
                        f33649c = new a(context);
                    }
                }
            }
            return f33649c;
        }
        return (a) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0043 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String c(Context context, int i2, String str) {
        InterceptResult invokeLIL;
        Cursor cursor;
        String str2;
        Uri parse;
        Cursor query;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65539, null, context, i2, str)) == null) {
            String str3 = null;
            try {
            } catch (Throwable th) {
                th = th;
                cursor = null;
            }
            if (i2 == 0) {
                str2 = "content://com.vivo.vms.IdProvider/IdentifierId/OAID";
            } else if (i2 == 1) {
                str2 = "content://com.vivo.vms.IdProvider/IdentifierId/VAID_" + str;
            } else if (i2 != 2) {
                parse = null;
                query = context.getContentResolver().query(parse, null, null, null, null);
                if (query != null) {
                    try {
                        if (query.moveToNext()) {
                            str3 = query.getString(query.getColumnIndex("value"));
                        }
                    } catch (Throwable th2) {
                        cursor = query;
                        th = th2;
                        try {
                            c.c(th);
                            return str3;
                        } finally {
                            if (cursor != null) {
                                cursor.close();
                            }
                        }
                    }
                }
                if (query != null) {
                    query.close();
                }
                return str3;
            } else {
                str2 = "content://com.vivo.vms.IdProvider/IdentifierId/AAID_" + str;
            }
            parse = Uri.parse(str2);
            query = context.getContentResolver().query(parse, null, null, null, null);
            if (query != null) {
            }
            if (query != null) {
            }
            return str3;
        }
        return (String) invokeLIL.objValue;
    }

    public static String d(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, "unknown");
            } catch (Throwable unused) {
                return str2;
            }
        }
        return (String) invokeLL.objValue;
    }

    public final String b(int i2, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i2, str)) == null) {
            try {
                return c(this.f33650a, 0, null);
            } catch (Throwable th) {
                c.c(th);
                return null;
            }
        }
        return (String) invokeIL.objValue;
    }

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f33651b : invokeV.booleanValue;
    }

    public final String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f33651b) {
                return b(0, null);
            }
            return null;
        }
        return (String) invokeV.objValue;
    }
}

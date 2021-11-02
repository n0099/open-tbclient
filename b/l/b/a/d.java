package b.l.b.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static volatile d f33127g;

    /* renamed from: h  reason: collision with root package name */
    public static boolean f33128h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public a f33129a;

    /* renamed from: b  reason: collision with root package name */
    public a f33130b;

    /* renamed from: c  reason: collision with root package name */
    public a f33131c;

    /* renamed from: d  reason: collision with root package name */
    public a f33132d;

    /* renamed from: e  reason: collision with root package name */
    public Boolean f33133e;

    /* renamed from: f  reason: collision with root package name */
    public BroadcastReceiver f33134f;

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33129a = new a("udid");
        this.f33130b = new a("oaid");
        this.f33132d = new a("vaid");
        this.f33131c = new a("aaid");
    }

    public static c a(Cursor cursor) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, cursor)) == null) {
            c cVar = new c(null, 0);
            if (cursor == null) {
                str = "parseValue fail, cursor is null.";
            } else if (!cursor.isClosed()) {
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex("value");
                if (columnIndex >= 0) {
                    cVar.f33124a = cursor.getString(columnIndex);
                } else {
                    e("parseValue fail, index < 0.");
                }
                int columnIndex2 = cursor.getColumnIndex("code");
                if (columnIndex2 >= 0) {
                    cVar.f33125b = cursor.getInt(columnIndex2);
                } else {
                    e("parseCode fail, index < 0.");
                }
                int columnIndex3 = cursor.getColumnIndex("expired");
                if (columnIndex3 >= 0) {
                    cVar.f33126c = cursor.getLong(columnIndex3);
                } else {
                    e("parseExpired fail, index < 0.");
                }
                return cVar;
            } else {
                str = "parseValue fail, cursor is closed.";
            }
            e(str);
            return cVar;
        }
        return (c) invokeL.objValue;
    }

    public static final d b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f33127g == null) {
                synchronized (d.class) {
                    f33127g = new d();
                }
            }
            return f33127g;
        }
        return (d) invokeV.objValue;
    }

    public static void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            boolean z = f33128h;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String c(Context context, a aVar) {
        InterceptResult invokeLL;
        String str;
        Cursor cursor;
        boolean f2;
        StringBuilder sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, aVar)) == null) {
            Cursor cursor2 = null;
            r0 = null;
            r0 = null;
            String str2 = null;
            cursor2 = null;
            if (aVar == null) {
                return null;
            }
            if (aVar.d()) {
                return aVar.f33121b;
            }
            e("queryId : " + aVar.f33122c);
            try {
                try {
                    cursor = context.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{aVar.f33122c}, null);
                } catch (Exception e2) {
                    e = e2;
                    str = null;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
            } catch (Exception e3) {
                e = e3;
                str = str2;
                cursor2 = cursor;
                e("queryId, Exception : " + e.getMessage());
                if (cursor2 != null) {
                    cursor = cursor2;
                    str2 = str;
                    cursor.close();
                    return str2;
                }
                return str;
            } catch (Throwable th2) {
                th = th2;
                cursor2 = cursor;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
            if (cursor == null) {
                if (f(context, false)) {
                    f2 = f(context, true);
                    sb = new StringBuilder();
                    sb.append("forceQuery isSupported : ");
                    sb.append(f2);
                    e(sb.toString());
                }
                if (cursor == null) {
                }
                cursor.close();
                return str2;
            }
            c a2 = a(cursor);
            str2 = a2.f33124a;
            aVar.c(str2);
            aVar.b(a2.f33126c);
            aVar.a(a2.f33125b);
            e(aVar.f33122c + " errorCode : " + aVar.f33123d);
            if (a2.f33125b != 1000) {
                d(context);
                if (!f(context, false)) {
                    f2 = f(context, true);
                    sb = new StringBuilder();
                    sb.append("not support, forceQuery isSupported: ");
                    sb.append(f2);
                    e(sb.toString());
                }
            }
            if (cursor == null) {
                return str2;
            }
            cursor.close();
            return str2;
        }
        return (String) invokeLL.objValue;
    }

    public final synchronized void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            synchronized (this) {
                if (this.f33134f != null) {
                    return;
                }
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.meizu.flyme.openid.ACTION_OPEN_ID_CHANGE");
                com.meizu.flyme.openidsdk.d dVar = new com.meizu.flyme.openidsdk.d();
                this.f33134f = dVar;
                context.registerReceiver(dVar, intentFilter, "com.meizu.flyme.openid.permission.OPEN_ID_CHANGE", null);
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:26:0x0054 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:39:0x00a0 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:47:0x0050 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:48:0x0037 */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0056, code lost:
        if (r8 != 0) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0078, code lost:
        if (r8 == 0) goto L24;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a3  */
    /* JADX WARN: Type inference failed for: r8v0, types: [android.content.Context, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v16, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v20 */
    /* JADX WARN: Type inference failed for: r8v21 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean f(Context context, boolean z) {
        InterceptResult invokeLZ;
        Throwable th;
        PackageManager packageManager;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLZ = interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, context, z)) != null) {
            return invokeLZ.booleanValue;
        }
        Boolean bool = this.f33133e;
        if (bool != null && !z) {
            return bool.booleanValue();
        }
        if (!((context == 0 || (packageManager = context.getPackageManager()) == null || packageManager.resolveContentProvider("com.meizu.flyme.openidsdk", 0) == null) ? false : true)) {
            e("is not Supported, for isLegalProvider : false");
            this.f33133e = Boolean.FALSE;
            return false;
        }
        String str = null;
        try {
            try {
                context = context.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"supported"}, null);
            } catch (Throwable th2) {
                th = th2;
                if (context != 0) {
                    context.close();
                }
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            context = 0;
        } catch (Throwable th3) {
            th = th3;
            context = 0;
            if (context != 0) {
            }
            throw th;
        }
        if (context != 0) {
            try {
                str = a(context).f33124a;
                context = context;
            } catch (Exception e3) {
                e = e3;
                e("querySupport, Exception : " + e.getMessage());
                context = context;
            }
            context.close();
            e("querySupport, result : " + str);
            Boolean valueOf = Boolean.valueOf("0".equals(str));
            this.f33133e = valueOf;
            return valueOf.booleanValue();
        }
    }

    public a g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if ("oaid".equals(str)) {
                return this.f33130b;
            }
            if ("vaid".equals(str)) {
                return this.f33132d;
            }
            if ("aaid".equals(str)) {
                return this.f33131c;
            }
            if ("udid".equals(str)) {
                return this.f33129a;
            }
            return null;
        }
        return (a) invokeL.objValue;
    }
}

package com.alipay.sdk.tid;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.alipay.sdk.util.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public final class a extends SQLiteOpenHelper {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f1940a = "msp.db";

    /* renamed from: b  reason: collision with root package name */
    public static final int f1941b = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public WeakReference<Context> f1942c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context) {
        super(context, f1940a, (SQLiteDatabase.CursorFactory) null, 1);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1], (SQLiteDatabase.CursorFactory) objArr2[2], ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1942c = new WeakReference<>(context);
    }

    private String c(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, str, str2)) == null) {
            return str + str2;
        }
        return (String) invokeLL.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, IF, INVOKE] complete} */
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SQLiteDatabase sQLiteDatabase = null;
            try {
                try {
                    sQLiteDatabase = getWritableDatabase();
                    sQLiteDatabase.execSQL("drop table if exists tb_tid");
                    if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
                        return;
                    }
                } catch (Exception e2) {
                    c.a(e2);
                    if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
                        return;
                    }
                }
                sQLiteDatabase.close();
            } catch (Throwable th) {
                if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                    sQLiteDatabase.close();
                }
                throw th;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002e, code lost:
        if (r2.isOpen() != false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0030, code lost:
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x005d, code lost:
        if (r2.isOpen() != false) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String b(String str, String str2) {
        InterceptResult invokeLL;
        SQLiteDatabase sQLiteDatabase;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            Cursor cursor2 = null;
            r1 = null;
            r1 = null;
            String str3 = null;
            cursor2 = null;
            try {
                sQLiteDatabase = getReadableDatabase();
                try {
                    cursor = sQLiteDatabase.rawQuery("select key_tid from tb_tid where name=?", new String[]{c(str, str2)});
                    try {
                        str3 = cursor.moveToFirst() ? cursor.getString(0) : null;
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (sQLiteDatabase != null) {
                        }
                    } catch (Exception unused) {
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (sQLiteDatabase != null) {
                        }
                        return str3;
                    } catch (Throwable th) {
                        th = th;
                        cursor2 = cursor;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                            sQLiteDatabase.close();
                        }
                        throw th;
                    }
                } catch (Exception unused2) {
                    cursor = null;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception unused3) {
                cursor = null;
                sQLiteDatabase = null;
            } catch (Throwable th3) {
                th = th3;
                sQLiteDatabase = null;
            }
            return str3;
        }
        return (String) invokeLL.objValue;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, sQLiteDatabase) == null) {
            sQLiteDatabase.execSQL("create table if not exists tb_tid (name text primary key, tid text, key_tid text, dt datetime);");
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048580, this, sQLiteDatabase, i2, i3) == null) {
            sQLiteDatabase.execSQL("drop table if exists tb_tid");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002e, code lost:
        if (r2.isOpen() != false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0030, code lost:
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x005d, code lost:
        if (r2.isOpen() != false) goto L19;
     */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String a(String str, String str2) {
        InterceptResult invokeLL;
        SQLiteDatabase sQLiteDatabase;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            Cursor cursor2 = null;
            r1 = null;
            r1 = null;
            String str3 = null;
            cursor2 = null;
            try {
                sQLiteDatabase = getReadableDatabase();
                try {
                    cursor = sQLiteDatabase.rawQuery("select tid from tb_tid where name=?", new String[]{c(str, str2)});
                    try {
                        str3 = cursor.moveToFirst() ? cursor.getString(0) : null;
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (sQLiteDatabase != null) {
                        }
                    } catch (Exception unused) {
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (sQLiteDatabase != null) {
                        }
                        if (TextUtils.isEmpty(str3)) {
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor2 = cursor;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                            sQLiteDatabase.close();
                        }
                        throw th;
                    }
                } catch (Exception unused2) {
                    cursor = null;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception unused3) {
                cursor = null;
                sQLiteDatabase = null;
            } catch (Throwable th3) {
                th = th3;
                sQLiteDatabase = null;
            }
            return TextUtils.isEmpty(str3) ? com.alipay.sdk.encrypt.b.b(str3, com.alipay.sdk.util.a.c(this.f1942c.get())) : str3;
        }
        return (String) invokeLL.objValue;
    }
}

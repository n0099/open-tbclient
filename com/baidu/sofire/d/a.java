package com.baidu.sofire.d;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sofire.ac.F;
import com.baidu.sofire.utility.c;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.baidu.wallet.paysdk.b.j;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public static a a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public C1880a f38683b;

    /* renamed from: c  reason: collision with root package name */
    public SQLiteDatabase f38684c;

    /* renamed from: d  reason: collision with root package name */
    public Context f38685d;

    /* renamed from: com.baidu.sofire.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C1880a extends SQLiteOpenHelper {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1880a(a aVar, Context context) {
            super(context, "d.db", (SQLiteDatabase.CursorFactory) null, 3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, context};
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
            this.a = aVar;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onCreate(SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, sQLiteDatabase) == null) {
                sQLiteDatabase.execSQL("create table if not exists r(a integer primary key autoincrement, b text, c integer, e integer,f integer,h text, g integer, i integer, j text, d long);");
                sQLiteDatabase.execSQL("create table if not exists c(a integer primary key autoincrement, b text); ");
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i2, i3) == null) {
                if (i2 <= 1) {
                    sQLiteDatabase.execSQL("alter table r add i integer default 0;");
                }
                if (i2 <= 2) {
                    sQLiteDatabase.execSQL("ALTER TABLE r ADD COLUMN j TEXT");
                }
            }
        }
    }

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f38685d = context;
        C1880a c1880a = new C1880a(this, context);
        this.f38683b = c1880a;
        try {
            this.f38684c = c1880a.getWritableDatabase();
        } catch (Throwable unused) {
            c.a();
        }
    }

    public static synchronized a a(Context context) {
        InterceptResult invokeL;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = new a(context);
                }
                aVar = a;
            }
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, INVOKE, INVOKE] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002f, code lost:
        if (r11 == null) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean b(String str) {
        InterceptResult invokeL;
        boolean z;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048583, this, str)) != null) {
            return invokeL.booleanValue;
        }
        z = true;
        try {
            cursor = this.f38684c.query("c", null, "b=?", new String[]{str}, null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.getCount() > 0) {
                        z = false;
                    }
                } catch (Throwable unused) {
                    try {
                        c.a();
                    } finally {
                        if (cursor != null) {
                            try {
                                cursor.close();
                            } catch (Exception unused2) {
                                c.a();
                            }
                        }
                    }
                }
            }
        } catch (Throwable unused3) {
            cursor = null;
        }
        return z;
    }

    public final int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            com.baidu.sofire.h.a a2 = com.baidu.sofire.h.a.a(this.f38685d);
            long currentTimeMillis = System.currentTimeMillis();
            int i2 = a2.f38707e.getInt("re_net_over", 7) * 86400000;
            try {
                return this.f38684c.delete("r", "(d <= ? or (d < (" + currentTimeMillis + "-f*3600000) and f!= 0)) and b != '1001001'and i != 5 ", new String[]{String.valueOf(currentTimeMillis - i2)});
            } catch (Exception unused) {
                c.a();
                return -1;
            }
        }
        return invokeV.intValue;
    }

    public final long a(com.baidu.sofire.e.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("b", aVar.f38686b);
            contentValues.put("c", Integer.valueOf(aVar.f38687c));
            contentValues.put("d", Long.valueOf(aVar.f38689e));
            contentValues.put("e", Integer.valueOf(aVar.f38691g));
            contentValues.put("g", Integer.valueOf(aVar.f38690f));
            contentValues.put("f", Integer.valueOf(aVar.f38692h));
            contentValues.put("i", Integer.valueOf(aVar.f38693i));
            contentValues.put(j.q, aVar.f38694j);
            String str = aVar.f38688d;
            try {
                str = Base64.encodeToString(F.getInstance().ae(str.getBytes(), "xVOTuxgN3lkRN2v4".getBytes("utf-8")), 0);
            } catch (Exception unused) {
                c.a();
            }
            contentValues.put("h", str);
            try {
                return this.f38684c.insert("r", null, contentValues);
            } catch (Throwable unused2) {
                c.a();
                return -1L;
            }
        }
        return invokeL.longValue;
    }

    private int b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, this, i2)) == null) {
            try {
                return this.f38684c.delete("r", "a=?", new String[]{String.valueOf(i2)});
            } catch (Throwable unused) {
                c.a();
                return -1;
            }
        }
        return invokeI.intValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, INVOKE, INVOKE] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0021, code lost:
        com.baidu.sofire.utility.c.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002a, code lost:
        if (r0 == null) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001b, code lost:
        if (r0 != null) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001d, code lost:
        r0.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int b() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048582, this)) != null) {
            return invokeV.intValue;
        }
        Cursor cursor = null;
        try {
            try {
                cursor = this.f38684c.query("r", null, null, null, null, null, null, null);
                i2 = cursor != null ? cursor.getCount() : 0;
            } catch (Exception unused) {
                c.a();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Exception unused2) {
                    c.a();
                }
            }
            throw th;
        }
        return i2;
    }

    public final long a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("b", str);
            try {
                return this.f38684c.insert("c", null, contentValues);
            } catch (Throwable unused) {
                c.a();
                return -1L;
            }
        }
        return invokeL.longValue;
    }

    public final int a(List<Integer> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            int i2 = -1;
            try {
            } catch (Throwable unused) {
                c.a();
                c.a();
            }
            try {
                try {
                    this.f38684c.beginTransaction();
                    for (Integer num : list) {
                        i2 = b(num.intValue());
                        if (i2 <= 0) {
                            com.baidu.sofire.g.a.f38697d = System.currentTimeMillis();
                        }
                    }
                    this.f38684c.setTransactionSuccessful();
                    this.f38684c.endTransaction();
                } catch (Throwable unused2) {
                    com.baidu.sofire.g.a.f38697d = System.currentTimeMillis();
                    c.a();
                    this.f38684c.endTransaction();
                }
                return i2;
            } catch (Throwable th) {
                try {
                    try {
                        this.f38684c.endTransaction();
                    } catch (Throwable unused3) {
                        com.baidu.sofire.g.a.f38697d = System.currentTimeMillis();
                        c.a();
                        throw th;
                    }
                } catch (Throwable unused4) {
                    c.a();
                    c.a();
                    throw th;
                }
                throw th;
            }
        }
        return invokeL.intValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, INVOKE, INVOKE] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0131, code lost:
        if (r3 != null) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0139, code lost:
        if (r3 == null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x013b, code lost:
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x013f, code lost:
        com.baidu.sofire.utility.c.a();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<com.baidu.sofire.e.a> a(int i2) {
        InterceptResult invokeI;
        ArrayList arrayList;
        String str;
        Cursor query;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeI = interceptable.invokeI(1048580, this, i2)) != null) {
            return (List) invokeI.objValue;
        }
        arrayList = new ArrayList();
        long currentTimeMillis = System.currentTimeMillis();
        com.baidu.sofire.h.a a2 = com.baidu.sofire.h.a.a(this.f38685d);
        int i3 = a2.f38707e.getInt("re_net_wt", 3) * 3600000;
        if (i2 == 2) {
            str = "(d <= (" + currentTimeMillis + "-e*3600000) or e=0 )";
        } else {
            str = "(d <= (" + currentTimeMillis + "-e*3600000) or e=0 ) and (g!=2 or d<=" + (currentTimeMillis - i3) + SmallTailInfo.EMOTION_SUFFIX;
        }
        String str2 = str;
        Cursor cursor = null;
        try {
            try {
                if (i2 == 2) {
                    query = this.f38684c.query("r", null, str2, null, null, null, "d desc", Integer.toString(100));
                } else {
                    query = this.f38684c.query("r", null, str2, null, null, null, "d desc", Integer.toString(a2.v()));
                }
                cursor = query;
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        com.baidu.sofire.e.a aVar = new com.baidu.sofire.e.a();
                        aVar.a = cursor.getInt(cursor.getColumnIndex("a"));
                        aVar.f38686b = cursor.getString(cursor.getColumnIndex("b"));
                        aVar.f38687c = cursor.getInt(cursor.getColumnIndex("c"));
                        aVar.f38689e = cursor.getLong(cursor.getColumnIndex("d"));
                        aVar.f38690f = cursor.getInt(cursor.getColumnIndex("g"));
                        aVar.f38691g = cursor.getInt(cursor.getColumnIndex("e"));
                        aVar.f38692h = cursor.getInt(cursor.getColumnIndex("f"));
                        aVar.f38693i = cursor.getInt(cursor.getColumnIndex("i"));
                        aVar.f38694j = cursor.getString(cursor.getColumnIndex(j.q));
                        String string = cursor.getString(cursor.getColumnIndex("h"));
                        try {
                            string = new String(F.getInstance().ad(Base64.decode(string, 0), "xVOTuxgN3lkRN2v4".getBytes("utf-8")));
                        } catch (Exception unused) {
                            c.a();
                        }
                        aVar.f38688d = string;
                        arrayList.add(aVar);
                    }
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception unused2) {
                        c.a();
                    }
                }
                throw th;
            }
        } catch (Exception unused3) {
            c.a();
        }
        return arrayList;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, INVOKE, INVOKE] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x00c7, code lost:
        if (r10 != null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00cf, code lost:
        if (r10 == null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00d1, code lost:
        r10.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00d5, code lost:
        com.baidu.sofire.utility.c.a();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<com.baidu.sofire.e.a> a() {
        InterceptResult invokeV;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048579, this)) != null) {
            return (List) invokeV.objValue;
        }
        arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            try {
                cursor = this.f38684c.query("r", null, "i=5", null, null, null, "d desc", HomeCfgResponse.ConfigData.GROUP_LAYOUR_GAP);
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        com.baidu.sofire.e.a aVar = new com.baidu.sofire.e.a();
                        aVar.a = cursor.getInt(cursor.getColumnIndex("a"));
                        aVar.f38686b = cursor.getString(cursor.getColumnIndex("b"));
                        aVar.f38687c = cursor.getInt(cursor.getColumnIndex("c"));
                        aVar.f38689e = cursor.getLong(cursor.getColumnIndex("d"));
                        aVar.f38690f = cursor.getInt(cursor.getColumnIndex("g"));
                        aVar.f38691g = cursor.getInt(cursor.getColumnIndex("e"));
                        aVar.f38692h = cursor.getInt(cursor.getColumnIndex("f"));
                        aVar.f38693i = cursor.getInt(cursor.getColumnIndex("i"));
                        aVar.f38694j = cursor.getString(cursor.getColumnIndex(j.q));
                        String string = cursor.getString(cursor.getColumnIndex("h"));
                        try {
                            string = new String(F.getInstance().ad(Base64.decode(string, 0), "xVOTuxgN3lkRN2v4".getBytes("utf-8")));
                        } catch (Exception unused) {
                            c.a();
                        }
                        aVar.f38688d = string;
                        arrayList.add(aVar);
                    }
                }
            } catch (Exception unused2) {
                c.a();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Exception unused3) {
                    c.a();
                }
            }
            throw th;
        }
        return arrayList;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, INVOKE, INVOKE] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0110, code lost:
        if (r11 != null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0118, code lost:
        if (r11 == null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x011a, code lost:
        r11.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x011e, code lost:
        com.baidu.sofire.utility.c.a();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<com.baidu.sofire.e.a> a(boolean z, int i2) {
        InterceptResult invokeCommon;
        ArrayList arrayList;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)})) != null) {
            return (List) invokeCommon.objValue;
        }
        arrayList = new ArrayList();
        long currentTimeMillis = System.currentTimeMillis();
        if (z) {
            str = "(d < (" + currentTimeMillis + "-f*3600000) and f!= 0)";
        } else {
            str = "d<=" + (currentTimeMillis - 259200000);
        }
        String str2 = str;
        Cursor cursor = null;
        try {
            try {
                if (i2 == 2) {
                    cursor = this.f38684c.query("r", null, str2, null, null, null, "d desc", HomeCfgResponse.ConfigData.GROUP_LAYOUR_GAP);
                } else {
                    cursor = this.f38684c.query("r", null, str2, null, null, null, "d desc", Integer.toString(com.baidu.sofire.h.a.a(this.f38685d).v()));
                }
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        com.baidu.sofire.e.a aVar = new com.baidu.sofire.e.a();
                        aVar.a = cursor.getInt(cursor.getColumnIndex("a"));
                        aVar.f38686b = cursor.getString(cursor.getColumnIndex("b"));
                        aVar.f38687c = cursor.getInt(cursor.getColumnIndex("c"));
                        aVar.f38689e = cursor.getLong(cursor.getColumnIndex("d"));
                        aVar.f38690f = cursor.getInt(cursor.getColumnIndex("g"));
                        aVar.f38691g = cursor.getInt(cursor.getColumnIndex("e"));
                        aVar.f38692h = cursor.getInt(cursor.getColumnIndex("f"));
                        aVar.f38693i = cursor.getInt(cursor.getColumnIndex("i"));
                        aVar.f38694j = cursor.getString(cursor.getColumnIndex(j.q));
                        String string = cursor.getString(cursor.getColumnIndex("h"));
                        try {
                            string = new String(F.getInstance().ad(Base64.decode(string, 0), "xVOTuxgN3lkRN2v4".getBytes("utf-8")));
                        } catch (Exception unused) {
                            c.a();
                        }
                        aVar.f38688d = string;
                        arrayList.add(aVar);
                    }
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception unused2) {
                        c.a();
                    }
                }
                throw th;
            }
        } catch (Exception unused3) {
            c.a();
        }
        return arrayList;
    }
}

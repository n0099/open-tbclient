package com.baidu.sofire.f;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Base64;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.model.YYOption;
import com.baidu.sofire.a.b;
import com.baidu.sofire.ac.F;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static a d;
    public transient /* synthetic */ FieldHolder $fh;
    public C0188a a;
    public SQLiteDatabase b;
    public Context c;

    /* renamed from: com.baidu.sofire.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0188a extends SQLiteOpenHelper {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0188a(a aVar, Context context) {
            super(context, "d.db", (SQLiteDatabase.CursorFactory) null, 3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (String) objArr2[1], (SQLiteDatabase.CursorFactory) objArr2[2], ((Integer) objArr2[3]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, sQLiteDatabase) == null) {
                sQLiteDatabase.execSQL("create table if not exists r(a integer primary key autoincrement, b text, c integer, e integer,f integer,h text, g integer, i integer, j text, d long);");
                sQLiteDatabase.execSQL("create table if not exists c(a integer primary key autoincrement, b text); ");
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i, i2) == null) {
                if (i <= 1) {
                    sQLiteDatabase.execSQL("alter table r add i integer default 0;");
                }
                if (i <= 2) {
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = context;
        this.a = new C0188a(this, context);
        a();
    }

    public static synchronized a a(Context context) {
        InterceptResult invokeL;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            synchronized (a.class) {
                if (d == null) {
                    d = new a(context);
                }
                aVar = d;
            }
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[SGET, SGET, SGET, INVOKE, SPUT, IGET, INVOKE, SGET, SGET, SGET, INVOKE, SPUT, SGET, SGET] complete} */
    public int a(List<Integer> list) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            int i2 = -1;
            try {
                this.b.beginTransaction();
                i = -1;
                for (Integer num : list) {
                    try {
                        int intValue = num.intValue();
                        SQLiteDatabase sQLiteDatabase = this.b;
                        i = sQLiteDatabase.delete("r", "a=?", new String[]{intValue + ""});
                        if (i <= 0) {
                            try {
                                com.baidu.sofire.i.a.g = System.currentTimeMillis();
                            } catch (Throwable unused) {
                                try {
                                    com.baidu.sofire.i.a.g = System.currentTimeMillis();
                                    int i3 = b.a;
                                    try {
                                        try {
                                        } catch (Throwable unused2) {
                                            return i;
                                        }
                                    } catch (Throwable unused3) {
                                        return i;
                                    }
                                    return i;
                                } finally {
                                    try {
                                        try {
                                            this.b.endTransaction();
                                        } catch (Throwable unused4) {
                                            com.baidu.sofire.i.a.g = System.currentTimeMillis();
                                            int i4 = b.a;
                                        }
                                    } catch (Throwable unused5) {
                                        int i5 = b.a;
                                        int i42 = b.a;
                                    }
                                }
                            }
                        }
                    } catch (Throwable unused6) {
                        i2 = i;
                        i = i2;
                        com.baidu.sofire.i.a.g = System.currentTimeMillis();
                        int i32 = b.a;
                        return i;
                    }
                }
                this.b.setTransactionSuccessful();
            } catch (Throwable unused7) {
            }
            try {
                try {
                    this.b.endTransaction();
                } catch (Throwable unused8) {
                    com.baidu.sofire.i.a.g = System.currentTimeMillis();
                    int i6 = b.a;
                    return i;
                }
            } catch (Throwable unused9) {
                int i7 = b.a;
                int i62 = b.a;
                return i;
            }
            return i;
        }
        return invokeL.intValue;
    }

    public long a(com.baidu.sofire.g.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("b", aVar.b);
            contentValues.put("c", Integer.valueOf(aVar.c));
            contentValues.put("d", Long.valueOf(aVar.e));
            contentValues.put("e", Integer.valueOf(aVar.g));
            contentValues.put("g", Integer.valueOf(aVar.f));
            contentValues.put("f", Integer.valueOf(aVar.h));
            contentValues.put("i", Integer.valueOf(aVar.i));
            contentValues.put("j", aVar.j);
            String str = aVar.d;
            try {
                str = Base64.encodeToString(F.getInstance().ae(str.getBytes(), "xVOTuxgN3lkRN2v4".getBytes("utf-8")), 0);
            } catch (Exception unused) {
                int i = b.a;
            }
            contentValues.put("h", str);
            try {
                return this.b.insert("r", null, contentValues);
            } catch (Throwable unused2) {
                int i2 = b.a;
                return -1L;
            }
        }
        return invokeL.longValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, SGET, INVOKE, SGET] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x018f, code lost:
        if (r3 != null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0196, code lost:
        if (r3 == null) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0198, code lost:
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x019c, code lost:
        r0 = com.baidu.sofire.a.b.a;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<com.baidu.sofire.g.a> a(int i) {
        InterceptResult invokeI;
        ArrayList arrayList;
        String str;
        Cursor query;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            arrayList = new ArrayList();
            long currentTimeMillis = System.currentTimeMillis();
            com.baidu.sofire.j.a a = com.baidu.sofire.j.a.a(this.c);
            int i2 = a.e.getInt("re_net_wt", 3) * 3600000;
            if (i == 2) {
                str = "(d <= (" + currentTimeMillis + "-e*3600000) or e=0 )";
            } else {
                str = "(d <= (" + currentTimeMillis + "-e*3600000) or e=0 ) and (g!=2 or d<=" + (currentTimeMillis - i2) + SmallTailInfo.EMOTION_SUFFIX;
            }
            String str2 = str;
            Cursor cursor = null;
            try {
                try {
                    if (i == 2) {
                        query = this.b.query("r", null, str2, null, null, null, "d desc", Integer.toString(100));
                    } else {
                        query = this.b.query("r", null, str2, null, null, null, "d desc", Integer.toString(a.e.getInt("up_nu_li", 100)));
                    }
                    cursor = query;
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            com.baidu.sofire.g.a aVar = new com.baidu.sofire.g.a();
                            aVar.a = cursor.getInt(cursor.getColumnIndex("a"));
                            aVar.b = cursor.getString(cursor.getColumnIndex("b"));
                            aVar.c = cursor.getInt(cursor.getColumnIndex("c"));
                            aVar.e = cursor.getLong(cursor.getColumnIndex("d"));
                            aVar.f = cursor.getInt(cursor.getColumnIndex("g"));
                            aVar.g = cursor.getInt(cursor.getColumnIndex("e"));
                            aVar.h = cursor.getInt(cursor.getColumnIndex("f"));
                            aVar.i = cursor.getInt(cursor.getColumnIndex("i"));
                            aVar.j = cursor.getString(cursor.getColumnIndex("j"));
                            String string = cursor.getString(cursor.getColumnIndex("h"));
                            try {
                                string = new String(F.getInstance().ad(Base64.decode(string, 0), "xVOTuxgN3lkRN2v4".getBytes("utf-8")));
                            } catch (Exception unused) {
                                int i3 = b.a;
                            }
                            aVar.d = string;
                            arrayList.add(aVar);
                        }
                    }
                } catch (Throwable th) {
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Exception unused2) {
                            int i4 = b.a;
                        }
                    }
                    throw th;
                }
            } catch (Exception unused3) {
                int i5 = b.a;
            }
        } else {
            return (List) invokeI.objValue;
        }
        return arrayList;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, SGET, INVOKE, SGET] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0139, code lost:
        if (r14 != null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0140, code lost:
        if (r14 == null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0142, code lost:
        r14.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0146, code lost:
        r14 = com.baidu.sofire.a.b.a;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<com.baidu.sofire.g.a> a(boolean z, int i) {
        InterceptResult invokeCommon;
        ArrayList arrayList;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
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
                    if (i == 2) {
                        cursor = this.b.query("r", null, str2, null, null, null, "d desc", YYOption.UrlProtocol.USER);
                    } else {
                        cursor = this.b.query("r", null, str2, null, null, null, "d desc", Integer.toString(com.baidu.sofire.j.a.a(this.c).e.getInt("up_nu_li", 100)));
                    }
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            com.baidu.sofire.g.a aVar = new com.baidu.sofire.g.a();
                            aVar.a = cursor.getInt(cursor.getColumnIndex("a"));
                            aVar.b = cursor.getString(cursor.getColumnIndex("b"));
                            aVar.c = cursor.getInt(cursor.getColumnIndex("c"));
                            aVar.e = cursor.getLong(cursor.getColumnIndex("d"));
                            aVar.f = cursor.getInt(cursor.getColumnIndex("g"));
                            aVar.g = cursor.getInt(cursor.getColumnIndex("e"));
                            aVar.h = cursor.getInt(cursor.getColumnIndex("f"));
                            aVar.i = cursor.getInt(cursor.getColumnIndex("i"));
                            aVar.j = cursor.getString(cursor.getColumnIndex("j"));
                            String string = cursor.getString(cursor.getColumnIndex("h"));
                            try {
                                string = new String(F.getInstance().ad(Base64.decode(string, 0), "xVOTuxgN3lkRN2v4".getBytes("utf-8")));
                            } catch (Exception unused) {
                                int i2 = b.a;
                            }
                            aVar.d = string;
                            arrayList.add(aVar);
                        }
                    }
                } catch (Exception unused2) {
                    int i3 = b.a;
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception unused3) {
                        int i4 = b.a;
                    }
                }
                throw th;
            }
        } else {
            return (List) invokeCommon.objValue;
        }
        return arrayList;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            try {
                this.b = this.a.getWritableDatabase();
            } catch (Throwable unused) {
                int i = b.a;
            }
        }
    }
}

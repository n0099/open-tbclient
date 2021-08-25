package c.a.s0;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.x;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.io.Closeables;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.searchbox.logsystem.basic.upload.Constant;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class z extends SQLiteOpenHelper {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f29992i;

    /* renamed from: j  reason: collision with root package name */
    public static z f29993j;
    public static ReentrantLock k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public long f29994e;

    /* renamed from: f  reason: collision with root package name */
    public b f29995f;

    /* renamed from: g  reason: collision with root package name */
    public Context f29996g;

    /* renamed from: h  reason: collision with root package name */
    public ReentrantReadWriteLock f29997h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1349982349, "Lc/a/s0/z;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1349982349, "Lc/a/s0/z;");
                return;
            }
        }
        f29992i = AppConfig.isDebug();
        f29993j = null;
        k = new ReentrantLock();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(Context context) {
        super(context, "bdbehavior.db", (SQLiteDatabase.CursorFactory) null, 8);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1], (SQLiteDatabase.CursorFactory) objArr2[2], ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f29997h = new ReentrantReadWriteLock(true);
        this.f29995f = new b(context);
        this.f29996g = context;
    }

    public static z N(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f29993j == null) {
                k.lock();
                if (f29993j == null) {
                    f29993j = new z(context);
                }
                k.unlock();
            }
            return f29993j;
        }
        return (z) invokeL.objValue;
    }

    public int A(j0 j0Var, j0 j0Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, j0Var, j0Var2)) == null) {
            int C = C(j0Var, j0Var2);
            if (j0Var.y() && j0Var2.y()) {
                return 1;
            }
            if (j0Var.v() && j0Var2.v()) {
                return 0;
            }
            return B(j0Var, j0Var2) | C;
        }
        return invokeLL.intValue;
    }

    public final int B(j0 j0Var, j0 j0Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j0Var, j0Var2)) == null) {
            this.f29997h.readLock().lock();
            int i2 = 0;
            try {
                try {
                    boolean y = j0Var.y();
                    boolean y2 = j0Var2.y();
                    Cursor cursor = null;
                    try {
                        try {
                            cursor = getReadableDatabase().rawQuery("SELECT * FROM event WHERE flowhandle = -1 AND reallog = \"0\"", null);
                            if (cursor != null && cursor.getCount() > 0) {
                                cursor.moveToFirst();
                                int columnIndex = cursor.getColumnIndex("eventid");
                                int columnIndex2 = cursor.getColumnIndex("begintime");
                                int columnIndex3 = cursor.getColumnIndex("content");
                                int columnIndex4 = cursor.getColumnIndex("reserve1");
                                int columnIndex5 = cursor.getColumnIndex("reserve2");
                                int columnIndex6 = cursor.getColumnIndex("extend");
                                int i3 = 0;
                                do {
                                    try {
                                        String string = cursor.getString(columnIndex);
                                        if (!TextUtils.isEmpty(string)) {
                                            n nVar = new n(string);
                                            boolean e2 = g.n().e(string);
                                            if (y && y2) {
                                                break;
                                            } else if ((!y || !e2) && (!y2 || e2)) {
                                                try {
                                                    if (j0Var.v() && j0Var2.v()) {
                                                        Closeables.closeSafely(cursor);
                                                        return i2;
                                                    } else if ((!e2 || !j0Var.v()) && (!e2 || !j0Var2.v())) {
                                                        nVar.y(cursor.getLong(columnIndex2));
                                                        String string2 = cursor.getString(columnIndex3);
                                                        if (!TextUtils.isEmpty(string2)) {
                                                            nVar.q(string2);
                                                        }
                                                        String string3 = cursor.getString(columnIndex4);
                                                        if (!TextUtils.isEmpty(string3)) {
                                                            nVar.t(string3);
                                                        }
                                                        String string4 = cursor.getString(columnIndex5);
                                                        if (!TextUtils.isEmpty(string4)) {
                                                            nVar.p(string4);
                                                        }
                                                        String string5 = cursor.getString(columnIndex6);
                                                        if (!TextUtils.isEmpty(string5) && new JSONObject(string5).has("ctr")) {
                                                            nVar.r(true);
                                                        }
                                                        int e3 = nVar.e();
                                                        if (e2) {
                                                            if (!a(nVar, e3, j0Var)) {
                                                                i2 = 0;
                                                            } else if (j0Var.y()) {
                                                                y = true;
                                                            }
                                                        } else {
                                                            if (a(nVar, e3, j0Var2)) {
                                                                if (j0Var2.y()) {
                                                                    y2 = true;
                                                                }
                                                            }
                                                            i2 = 0;
                                                        }
                                                        if (i3 == 0) {
                                                            i3 = 1;
                                                        }
                                                        if (!j0Var.v() || !j0Var2.v()) {
                                                            i2 = 0;
                                                            if (y && y2) {
                                                                break;
                                                            }
                                                        } else {
                                                            Closeables.closeSafely(cursor);
                                                            this.f29997h.readLock().unlock();
                                                            return 0;
                                                        }
                                                    }
                                                } catch (SQLException e4) {
                                                    e = e4;
                                                    i2 = i3;
                                                    if (f29992i) {
                                                        e.printStackTrace();
                                                    }
                                                    this.f29995f.h(e);
                                                    return i2;
                                                }
                                            }
                                        }
                                        i2 = 0;
                                    } catch (RuntimeException e5) {
                                        e = e5;
                                        i2 = i3;
                                        if (f29992i) {
                                            e.printStackTrace();
                                        }
                                        Closeables.closeSafely(cursor);
                                        return i2;
                                    } catch (JSONException unused) {
                                        i2 = i3;
                                        boolean z = f29992i;
                                        Closeables.closeSafely(cursor);
                                        return i2;
                                    } catch (Throwable th) {
                                        th = th;
                                        i2 = i3;
                                        Closeables.closeSafely(cursor);
                                        throw th;
                                    }
                                } while (cursor.moveToNext());
                                i2 = i3;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (RuntimeException e6) {
                        e = e6;
                    } catch (JSONException unused2) {
                    }
                    Closeables.closeSafely(cursor);
                } catch (SQLException e7) {
                    e = e7;
                }
                return i2;
            } finally {
                this.f29997h.readLock().unlock();
            }
        }
        return invokeLL.intValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:100:0x01f7 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:112:0x0217 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:127:0x0233 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:177:0x0207 */
    /* JADX WARN: Can't wrap try/catch for region: R(9:14|15|(2:47|(2:49|(7:(8:60|(1:(17:83|84|85|(1:87)|88|(1:90)|91|(1:93)|94|(1:98)|99|100|(3:134|135|(1:137))|102|(3:104|105|(6:107|22|23|24|25|(1:28)(1:27))(2:108|(4:110|(1:112)|113|(5:123|(1:126)|24|25|(0)(0))(4:117|118|119|120))(10:127|128|(0)|113|(1:115)|123|(1:126)|24|25|(0)(0))))(6:129|(11:131|(9:133|(0)|113|(0)|123|(0)|24|25|(0)(0))|128|(0)|113|(0)|123|(0)|24|25|(0)(0))|23|24|25|(0)(0))|31|32))(4:64|65|66|67)|71|72|(1:74)|75|31|32)|56|22|23|24|25|(0)(0))(2:52|53)))|21|22|23|24|25|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0215, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0217, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x0244, code lost:
        r0.printStackTrace();
        r2 = r2;
        r5 = r5;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01fe A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x020a A[LOOP:0: B:168:0x0073->B:109:0x020a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0244 A[Catch: all -> 0x0248, TRY_LEAVE, TryCatch #5 {all -> 0x0248, blocks: (B:133:0x0240, B:135:0x0244), top: B:162:0x0240 }] */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0207 A[EDGE_INSN: B:175:0x0207->B:108:0x0207 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01e2 A[Catch: all -> 0x0215, RuntimeException -> 0x0217, TRY_LEAVE, TryCatch #15 {RuntimeException -> 0x0217, all -> 0x0215, blocks: (B:106:0x0201, B:77:0x019d, B:80:0x01a7, B:93:0x01dc, B:95:0x01e2, B:84:0x01b9, B:87:0x01ce), top: B:170:0x0201 }] */
    /* JADX WARN: Type inference failed for: r18v6 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v26 */
    /* JADX WARN: Type inference failed for: r5v27 */
    /* JADX WARN: Type inference failed for: r5v3, types: [c.a.s0.z] */
    /* JADX WARN: Type inference failed for: r5v5, types: [android.database.sqlite.SQLiteDatabase] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int C(j0 j0Var, j0 j0Var2) {
        InterceptResult invokeLL;
        z zVar;
        z zVar2;
        ?? r2;
        boolean y;
        boolean y2;
        Cursor cursor;
        z zVar3;
        boolean z;
        z zVar4;
        boolean z2;
        SQLiteDatabase sQLiteDatabase;
        int i2;
        boolean z3;
        z zVar5;
        int i3;
        SQLiteDatabase sQLiteDatabase2;
        z zVar6;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, j0Var, j0Var2)) == null) {
            z zVar7 = this;
            ReentrantReadWriteLock.ReadLock readLock = zVar7.f29997h.readLock();
            readLock.lock();
            try {
                try {
                    try {
                        y = j0Var.y();
                        y2 = j0Var2.y();
                        zVar = getReadableDatabase();
                        cursor = null;
                        try {
                            try {
                                cursor = zVar.rawQuery(" SELECT * FROM flow", null);
                            } catch (SQLException e2) {
                                e = e2;
                            }
                        } catch (RuntimeException e3) {
                            e = e3;
                            zVar3 = zVar7;
                            z = false;
                        } catch (Throwable th) {
                            th = th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        r5.f29997h.readLock().unlock();
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    z zVar8 = zVar7;
                    zVar8.f29997h.readLock().unlock();
                    throw th;
                }
            } catch (SQLException e4) {
                e = e4;
                zVar = zVar7;
                readLock = null;
            }
            if (cursor == null || cursor.getCount() <= 0) {
                zVar4 = zVar7;
                z2 = false;
            } else {
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex("flowid");
                int columnIndex2 = cursor.getColumnIndex("flowhandle");
                int columnIndex3 = cursor.getColumnIndex("state");
                int columnIndex4 = cursor.getColumnIndex("begintime");
                int columnIndex5 = cursor.getColumnIndex("endtime");
                int columnIndex6 = cursor.getColumnIndex("content");
                int columnIndex7 = cursor.getColumnIndex(SpeedStatsUtils.UBC_KEY_OPTION);
                int columnIndex8 = cursor.getColumnIndex("reserve1");
                int columnIndex9 = cursor.getColumnIndex("reserve2");
                int columnIndex10 = cursor.getColumnIndex("slot");
                boolean z4 = y;
                int columnIndex11 = cursor.getColumnIndex("extend");
                boolean z5 = false;
                SQLiteDatabase sQLiteDatabase3 = zVar;
                while (true) {
                    try {
                        sQLiteDatabase = sQLiteDatabase3;
                    } catch (RuntimeException e5) {
                        e = e5;
                        zVar = zVar7;
                    } catch (Throwable th4) {
                        th = th4;
                    }
                    if ("2".equals(cursor.getString(columnIndex3)) || (Math.abs(cursor.getLong(columnIndex4) - System.currentTimeMillis()) > 86400000 && (cursor.getInt(columnIndex7) & 4) != 0)) {
                        String string = cursor.getString(columnIndex);
                        int i4 = cursor.getInt(columnIndex2);
                        if (i4 >= 0) {
                            i2 = columnIndex2;
                            boolean e6 = g.n().e(string);
                            if (z4 && y2) {
                                zVar = zVar7;
                                break;
                            }
                            if ((!z4 || !e6) && (!y2 || e6)) {
                                if (j0Var.v() && j0Var2.v()) {
                                    try {
                                        Closeables.closeSafely(cursor);
                                        zVar7.f29997h.readLock().unlock();
                                        return 0;
                                    } catch (SQLException e7) {
                                        e = e7;
                                        zVar = zVar7;
                                    }
                                } else if ((!e6 || !j0Var.v()) && (!e6 || !j0Var2.v())) {
                                    z3 = y2;
                                    p pVar = new p();
                                    pVar.x(cursor.getString(columnIndex));
                                    pVar.w(i4);
                                    try {
                                        pVar.o(cursor.getLong(columnIndex4));
                                        pVar.s(cursor.getLong(columnIndex5));
                                        String string2 = cursor.getString(columnIndex6);
                                        if (!TextUtils.isEmpty(string2)) {
                                            pVar.q(string2.replace("/", ""));
                                        }
                                        String string3 = cursor.getString(columnIndex8);
                                        if (!TextUtils.isEmpty(string3)) {
                                            pVar.v(string3);
                                        }
                                        if (!TextUtils.isEmpty(cursor.getString(columnIndex9))) {
                                            pVar.p(cursor.getString(columnIndex9));
                                        }
                                        String string4 = cursor.getString(columnIndex10);
                                        if (columnIndex10 >= 0 && !TextUtils.isEmpty(string4)) {
                                            pVar.y(string4);
                                        }
                                        if (!TextUtils.isEmpty(cursor.getString(columnIndex11))) {
                                            try {
                                                if (new JSONObject(cursor.getString(columnIndex11)).has("ctr")) {
                                                    pVar.r(true);
                                                }
                                            } catch (JSONException e8) {
                                                e8.printStackTrace();
                                            }
                                        }
                                        int f2 = pVar.f();
                                        if (e6) {
                                            zVar5 = this;
                                            sQLiteDatabase2 = sQLiteDatabase;
                                            if (zVar5.d(sQLiteDatabase2, pVar, f2, j0Var)) {
                                                i3 = columnIndex10;
                                                if (j0Var.y()) {
                                                    y2 = z3;
                                                    z4 = true;
                                                    zVar = zVar5;
                                                    if (!z5) {
                                                        z5 = true;
                                                    }
                                                    if (!j0Var.v() && j0Var2.v()) {
                                                        try {
                                                            Closeables.closeSafely(cursor);
                                                            zVar.f29997h.readLock().unlock();
                                                            return 0;
                                                        } catch (SQLException e9) {
                                                            e = e9;
                                                        }
                                                    } else {
                                                        zVar = zVar;
                                                        zVar = zVar;
                                                        if (z4 && y2) {
                                                            break;
                                                        }
                                                        if (cursor.moveToNext()) {
                                                        }
                                                    }
                                                } else {
                                                    y2 = z3;
                                                    zVar = zVar5;
                                                    if (!z5) {
                                                    }
                                                    if (!j0Var.v()) {
                                                    }
                                                    zVar = zVar;
                                                    zVar = zVar;
                                                    if (z4) {
                                                        break;
                                                        break;
                                                    }
                                                    if (cursor.moveToNext()) {
                                                    }
                                                }
                                            } else {
                                                i3 = columnIndex10;
                                                zVar6 = zVar5;
                                                y2 = z3;
                                                zVar = zVar6;
                                                if (cursor.moveToNext()) {
                                                    break;
                                                }
                                                columnIndex2 = i2;
                                                columnIndex10 = i3;
                                                z zVar9 = zVar;
                                                sQLiteDatabase3 = sQLiteDatabase2;
                                                zVar7 = zVar9;
                                            }
                                        } else {
                                            zVar5 = this;
                                            i3 = columnIndex10;
                                            sQLiteDatabase2 = sQLiteDatabase;
                                            boolean d2 = zVar5.d(sQLiteDatabase2, pVar, f2, j0Var2);
                                            zVar6 = zVar5;
                                            if (d2) {
                                                if (j0Var2.y()) {
                                                    y2 = true;
                                                    zVar = zVar5;
                                                    if (!z5) {
                                                    }
                                                    if (!j0Var.v()) {
                                                    }
                                                    zVar = zVar;
                                                    zVar = zVar;
                                                    if (z4) {
                                                    }
                                                    if (cursor.moveToNext()) {
                                                    }
                                                }
                                                y2 = z3;
                                                zVar = zVar5;
                                                if (!z5) {
                                                }
                                                if (!j0Var.v()) {
                                                }
                                                zVar = zVar;
                                                zVar = zVar;
                                                if (z4) {
                                                }
                                                if (cursor.moveToNext()) {
                                                }
                                            }
                                            y2 = z3;
                                            zVar = zVar6;
                                            if (cursor.moveToNext()) {
                                            }
                                        }
                                    } catch (RuntimeException e10) {
                                        e = e10;
                                        zVar = this;
                                        z = z5;
                                        zVar3 = zVar;
                                        try {
                                            z2 = z;
                                            zVar4 = zVar3;
                                            if (f29992i) {
                                            }
                                            Closeables.closeSafely(cursor);
                                            r2 = z2;
                                            zVar2 = zVar4;
                                            zVar2.f29997h.readLock().unlock();
                                            return r2;
                                        } catch (Throwable th5) {
                                            th = th5;
                                            Closeables.closeSafely(cursor);
                                            throw th;
                                        }
                                    } catch (Throwable th6) {
                                        th = th6;
                                        Closeables.closeSafely(cursor);
                                        throw th;
                                    }
                                    zVar2.f29997h.readLock().unlock();
                                    return r2;
                                }
                                readLock = z5;
                                if (f29992i) {
                                    e.printStackTrace();
                                }
                                zVar.f29995f.h(e);
                                r2 = readLock;
                                zVar2 = zVar;
                                zVar2.f29997h.readLock().unlock();
                                return r2;
                            }
                            zVar5 = zVar7;
                            i3 = columnIndex10;
                            z3 = y2;
                            sQLiteDatabase2 = sQLiteDatabase;
                            zVar6 = zVar5;
                            y2 = z3;
                            zVar = zVar6;
                            if (cursor.moveToNext()) {
                            }
                        }
                    }
                    zVar5 = zVar7;
                    i3 = columnIndex10;
                    z3 = y2;
                    i2 = columnIndex2;
                    sQLiteDatabase2 = sQLiteDatabase;
                    zVar6 = zVar5;
                    y2 = z3;
                    zVar = zVar6;
                    if (cursor.moveToNext()) {
                    }
                }
                z2 = z5;
                zVar4 = zVar;
            }
            Closeables.closeSafely(cursor);
            r2 = z2;
            zVar2 = zVar4;
            zVar2.f29997h.readLock().unlock();
            return r2;
        }
        return invokeLL.intValue;
    }

    public HashMap<String, String> D(ArrayList<String> arrayList) {
        InterceptResult invokeL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, arrayList)) == null) {
            this.f29997h.readLock().lock();
            HashMap<String, String> hashMap = new HashMap<>();
            String M = M(arrayList);
            try {
                try {
                    cursor = null;
                } catch (SQLException e2) {
                    if (f29992i) {
                        e2.printStackTrace();
                    }
                }
                try {
                    try {
                        cursor = getReadableDatabase().rawQuery("SELECT eventid,extend FROM config WHERE eventid in (" + M + SmallTailInfo.EMOTION_SUFFIX, null);
                        if (cursor != null && cursor.moveToFirst()) {
                            do {
                                String string = cursor.getString(cursor.getColumnIndex("eventid"));
                                String string2 = cursor.getString(cursor.getColumnIndex("extend"));
                                if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                                    hashMap.put(string, string2);
                                }
                            } while (cursor.moveToNext());
                        }
                    } catch (SQLiteException e3) {
                        if (f29992i) {
                            e3.printStackTrace();
                        }
                    }
                    return hashMap;
                } finally {
                    Closeables.closeSafely(cursor);
                }
            } finally {
                this.f29997h.readLock().unlock();
            }
        }
        return (HashMap) invokeL.objValue;
    }

    public j E(String str) {
        InterceptResult invokeL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            this.f29997h.readLock().lock();
            try {
                try {
                    try {
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        cursor = getReadableDatabase().rawQuery(String.format("SELECT * FROM %s where eventid = \"%s\"", "config", str), null);
                        if (cursor != null) {
                            try {
                                if (cursor.getCount() > 0) {
                                    cursor.moveToFirst();
                                    String string = cursor.getString(cursor.getColumnIndex("eventid"));
                                    boolean equals = TextUtils.equals(cursor.getString(cursor.getColumnIndex(SetImageWatermarkTypeReqMsg.SWITCH)), "1");
                                    int i2 = cursor.getInt(cursor.getColumnIndex("cycle"));
                                    j jVar = new j(string, equals, i2 == 0, i2, TextUtils.equals("1", cursor.getString(cursor.getColumnIndex("type"))) ? 1 : 0, TextUtils.equals(cursor.getString(cursor.getColumnIndex("reserve1")), "1"));
                                    String string2 = cursor.getString(cursor.getColumnIndex("extend"));
                                    if (!TextUtils.isEmpty(string2)) {
                                        try {
                                            JSONObject jSONObject = new JSONObject(string2);
                                            String optString = jSONObject.optString("dfc");
                                            if (!TextUtils.isEmpty(optString)) {
                                                jVar.y(TextUtils.equals(optString, "1"));
                                            }
                                            String optString2 = jSONObject.optString("version");
                                            if (!TextUtils.isEmpty(optString2)) {
                                                jVar.H(optString2);
                                            }
                                            if (jSONObject.has("uploadType")) {
                                                jVar.G(jSONObject.optInt("uploadType", -1));
                                            }
                                            int optInt = jSONObject.optInt("lcache", 2);
                                            if (optInt == 1 || optInt == 0) {
                                                jVar.C(optInt);
                                            }
                                            if (m.a(string) && jSONObject.has("isSend")) {
                                                jVar.z(jSONObject.optBoolean("isSend", true));
                                            }
                                        } catch (JSONException e2) {
                                            if (f29992i) {
                                                e2.printStackTrace();
                                            }
                                        }
                                    }
                                    jVar.F(TextUtils.equals(cursor.getString(cursor.getColumnIndex("reallog")), "1"));
                                    Closeables.closeSafely(cursor);
                                    return jVar;
                                }
                            } catch (RuntimeException e3) {
                                e = e3;
                                if (f29992i) {
                                    e.printStackTrace();
                                }
                                Closeables.closeSafely(cursor);
                                return null;
                            }
                        }
                    } catch (RuntimeException e4) {
                        e = e4;
                        cursor = null;
                    } catch (Throwable th2) {
                        th = th2;
                        Closeables.closeSafely((Cursor) null);
                        throw th;
                    }
                    Closeables.closeSafely(cursor);
                } catch (SQLException e5) {
                    if (f29992i) {
                        e5.printStackTrace();
                    }
                    this.f29995f.h(e5);
                }
                return null;
            } finally {
                this.f29997h.readLock().unlock();
            }
        }
        return (j) invokeL.objValue;
    }

    public int F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            this.f29997h.readLock().lock();
            int i2 = 0;
            try {
                try {
                    SQLiteDatabase readableDatabase = getReadableDatabase();
                    Cursor cursor = null;
                    try {
                        try {
                            cursor = readableDatabase.rawQuery("SELECT COUNT(eventid) FROM config", null);
                            if (cursor != null) {
                                cursor.moveToFirst();
                                i2 = cursor.getInt(0);
                            }
                        } catch (SQLException e2) {
                            if (f29992i) {
                                e2.printStackTrace();
                            }
                        }
                    } finally {
                        Closeables.closeSafely(cursor);
                    }
                } finally {
                    this.f29997h.readLock().unlock();
                }
            } catch (SQLException e3) {
                if (f29992i) {
                    e3.printStackTrace();
                }
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public int G(ArrayList<String> arrayList, boolean z, j0 j0Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{arrayList, Boolean.valueOf(z), j0Var})) == null) {
            this.f29994e = 0L;
            String L = L(arrayList);
            String str = z ? " in  (" : " not in (";
            if (TextUtils.isEmpty(L) && z) {
                return 0;
            }
            StringBuilder sb = new StringBuilder(256);
            if (!z && TextUtils.isEmpty(L)) {
                sb.append("SELECT * FROM ");
                sb.append("flow");
            } else {
                sb.append("SELECT * ");
                sb.append(" FROM ");
                sb.append("flow");
                sb.append(" WHERE ");
                sb.append("flowid");
                sb.append(str);
                sb.append(L);
                sb.append(SmallTailInfo.EMOTION_SUFFIX);
            }
            int K = K(sb.toString(), j0Var);
            if (j0Var.v()) {
                return 0;
            }
            StringBuilder sb2 = new StringBuilder(256);
            if (!z && TextUtils.isEmpty(L)) {
                sb2.append("SELECT *  FROM ");
                sb2.append("event");
                sb2.append(" WHERE ");
                sb2.append("flowhandle");
                sb2.append(" = ");
                sb2.append(-1);
                sb2.append(" AND ");
                sb2.append("reallog");
                sb2.append(" = \"0\"");
            } else {
                sb2.append("SELECT *  FROM ");
                sb2.append("event");
                sb2.append(" WHERE ");
                sb2.append("eventid");
                sb2.append(str);
                sb2.append(L);
                sb2.append(SmallTailInfo.EMOTION_SUFFIX);
                sb2.append(" AND ");
                sb2.append("flowhandle");
                sb2.append(" = ");
                sb2.append(-1);
                sb2.append(" AND ");
                sb2.append("reallog");
                sb2.append(" = \"0\"");
            }
            return H(sb2.toString(), j0Var) | K;
        }
        return invokeCommon.intValue;
    }

    public final int H(String str, j0 j0Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, j0Var)) == null) {
            this.f29997h.readLock().lock();
            int i2 = 0;
            try {
                try {
                    Cursor cursor = null;
                    try {
                        try {
                            cursor = getReadableDatabase().rawQuery(str, null);
                            if (cursor != null && cursor.getCount() > 0) {
                                cursor.moveToFirst();
                                int columnIndex = cursor.getColumnIndex("eventid");
                                int columnIndex2 = cursor.getColumnIndex("begintime");
                                int columnIndex3 = cursor.getColumnIndex("content");
                                int columnIndex4 = cursor.getColumnIndex("reserve1");
                                int columnIndex5 = cursor.getColumnIndex("reserve2");
                                int columnIndex6 = cursor.getColumnIndex("extend");
                                do {
                                    String string = cursor.getString(columnIndex);
                                    if (!TextUtils.isEmpty(string)) {
                                        n nVar = new n(string);
                                        nVar.y(cursor.getLong(columnIndex2));
                                        String string2 = cursor.getString(columnIndex3);
                                        if (!TextUtils.isEmpty(string2)) {
                                            nVar.q(string2);
                                        }
                                        String string3 = cursor.getString(columnIndex4);
                                        if (!TextUtils.isEmpty(string3)) {
                                            nVar.t(string3);
                                        }
                                        if (!TextUtils.isEmpty(cursor.getString(columnIndex5))) {
                                            nVar.p(cursor.getString(columnIndex5));
                                        }
                                        if (!TextUtils.isEmpty(cursor.getString(columnIndex6))) {
                                            JSONObject jSONObject = new JSONObject(cursor.getString(columnIndex6));
                                            if (jSONObject.has("ctr")) {
                                                nVar.r(true);
                                            }
                                            if (jSONObject.has(SpeedStatsUtils.UBC_KEY_OPTION)) {
                                                nVar.w(jSONObject.optInt(SpeedStatsUtils.UBC_KEY_OPTION, 0));
                                            }
                                        }
                                        int e2 = nVar.e();
                                        if (!a(nVar, e2, j0Var)) {
                                            break;
                                        }
                                        long j2 = this.f29994e + e2;
                                        this.f29994e = j2;
                                        if (j2 >= 10485760) {
                                            break;
                                        }
                                    }
                                } while (cursor.moveToNext());
                                i2 = 1;
                            }
                        } finally {
                            Closeables.closeSafely(cursor);
                        }
                    } catch (RuntimeException e3) {
                        if (f29992i) {
                            e3.printStackTrace();
                        }
                    } catch (JSONException unused) {
                        boolean z = f29992i;
                    }
                } catch (SQLException e4) {
                    if (f29992i) {
                        e4.printStackTrace();
                    }
                    this.f29995f.h(e4);
                }
                return i2;
            } finally {
                this.f29997h.readLock().unlock();
            }
        }
        return invokeLL.intValue;
    }

    public final ContentValues I(n nVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, nVar)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("flowhandle", Integer.valueOf(nVar.h()));
            contentValues.put("eventid", nVar.j());
            contentValues.put("begintime", Long.valueOf(nVar.n()));
            if (!TextUtils.isEmpty(nVar.d())) {
                contentValues.put("content", nVar.d());
            } else if (nVar.k() != null && !TextUtils.isEmpty(nVar.k().toString())) {
                contentValues.put("content", nVar.k().toString());
            }
            if (!TextUtils.isEmpty(nVar.f())) {
                contentValues.put("reserve1", nVar.f());
            }
            if (!TextUtils.isEmpty(nVar.c())) {
                contentValues.put("reserve2", nVar.c());
            }
            JSONObject jSONObject = new JSONObject();
            boolean z = true;
            try {
                boolean z2 = false;
                if (nVar.o()) {
                    jSONObject.put("ctr", "1");
                    z = false;
                }
                if ((nVar.l() & 128) != 0) {
                    jSONObject.put(SpeedStatsUtils.UBC_KEY_OPTION, nVar.l());
                } else {
                    z2 = z;
                }
                if (!z2) {
                    contentValues.put("extend", jSONObject.toString());
                }
            } catch (JSONException e2) {
                if (f29992i) {
                    e2.printStackTrace();
                }
            }
            if (!TextUtils.isEmpty(nVar.m())) {
                contentValues.put("reallog", nVar.m());
            } else {
                contentValues.put("reallog", "0");
            }
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    public final String J(j0 j0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, j0Var)) == null) {
            if (j0Var == null || !j0Var.w()) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ubc_data_backend_type", "1");
                return jSONObject.toString();
            } catch (JSONException e2) {
                if (f29992i) {
                    e2.printStackTrace();
                    return null;
                }
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x012f A[Catch: all -> 0x0158, RuntimeException -> 0x015a, TryCatch #6 {RuntimeException -> 0x015a, blocks: (B:7:0x0016, B:9:0x001c, B:11:0x0022, B:12:0x0067, B:14:0x0073, B:16:0x0088, B:53:0x0140, B:20:0x009a, B:22:0x00c9, B:23:0x00cc, B:25:0x00d6, B:26:0x00d9, B:28:0x00e3, B:29:0x00ea, B:31:0x00f0, B:33:0x00f6, B:34:0x00f9, B:36:0x0103, B:39:0x0115, B:47:0x0122, B:50:0x012f, B:45:0x011d), top: B:91:0x0016, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0148 A[LOOP:0: B:12:0x0067->B:56:0x0148, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0146 A[EDGE_INSN: B:96:0x0146->B:55:0x0146 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x012e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int K(String str, j0 j0Var) {
        InterceptResult invokeLL;
        int i2;
        int i3;
        int i4;
        int f2;
        int i5;
        SQLiteDatabase sQLiteDatabase;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, j0Var)) == null) {
            this.f29997h.readLock().lock();
            try {
                try {
                    SQLiteDatabase readableDatabase = getReadableDatabase();
                    Cursor cursor = null;
                    try {
                        try {
                            cursor = readableDatabase.rawQuery(str, null);
                            if (cursor == null || cursor.getCount() <= 0) {
                                i2 = 0;
                            } else {
                                cursor.moveToFirst();
                                int columnIndex = cursor.getColumnIndex("flowid");
                                int columnIndex2 = cursor.getColumnIndex("flowhandle");
                                int columnIndex3 = cursor.getColumnIndex("state");
                                int columnIndex4 = cursor.getColumnIndex("begintime");
                                int columnIndex5 = cursor.getColumnIndex("endtime");
                                int columnIndex6 = cursor.getColumnIndex("content");
                                int columnIndex7 = cursor.getColumnIndex(SpeedStatsUtils.UBC_KEY_OPTION);
                                int columnIndex8 = cursor.getColumnIndex("reserve1");
                                int columnIndex9 = cursor.getColumnIndex("reserve2");
                                int columnIndex10 = cursor.getColumnIndex("slot");
                                int columnIndex11 = cursor.getColumnIndex("extend");
                                while (true) {
                                    if (!"2".equals(cursor.getString(columnIndex3)) && (Math.abs(cursor.getLong(columnIndex4) - System.currentTimeMillis()) <= 86400000 || (cursor.getInt(columnIndex7) & 4) == 0)) {
                                        i5 = columnIndex11;
                                        sQLiteDatabase = readableDatabase;
                                        i3 = columnIndex;
                                        i4 = columnIndex2;
                                        if (cursor.moveToNext()) {
                                            break;
                                        }
                                        readableDatabase = sQLiteDatabase;
                                        columnIndex = i3;
                                        columnIndex2 = i4;
                                        columnIndex11 = i5;
                                    }
                                    p pVar = new p();
                                    pVar.x(cursor.getString(columnIndex));
                                    pVar.w(cursor.getInt(columnIndex2));
                                    i3 = columnIndex;
                                    i4 = columnIndex2;
                                    pVar.o(cursor.getLong(columnIndex4));
                                    pVar.s(cursor.getLong(columnIndex5));
                                    String string = cursor.getString(columnIndex6);
                                    if (!TextUtils.isEmpty(string)) {
                                        pVar.q(string);
                                    }
                                    String string2 = cursor.getString(columnIndex8);
                                    if (!TextUtils.isEmpty(string2)) {
                                        pVar.v(string2);
                                    }
                                    if (!TextUtils.isEmpty(cursor.getString(columnIndex9))) {
                                        pVar.p(cursor.getString(columnIndex9));
                                    }
                                    String string3 = cursor.getString(columnIndex10);
                                    if (columnIndex10 >= 0 && !TextUtils.isEmpty(string3)) {
                                        pVar.y(string3);
                                    }
                                    if (!TextUtils.isEmpty(cursor.getString(columnIndex11))) {
                                        try {
                                        } catch (JSONException e2) {
                                            e = e2;
                                        }
                                        if (new JSONObject(cursor.getString(columnIndex11)).has("ctr")) {
                                            try {
                                                pVar.r(true);
                                            } catch (JSONException e3) {
                                                e = e3;
                                                e.printStackTrace();
                                                f2 = pVar.f();
                                                if (!d(readableDatabase, pVar, f2, j0Var)) {
                                                }
                                                i2 = 1;
                                                return i2;
                                            }
                                            f2 = pVar.f();
                                            if (!d(readableDatabase, pVar, f2, j0Var)) {
                                                break;
                                            }
                                            i5 = columnIndex11;
                                            sQLiteDatabase = readableDatabase;
                                            long j2 = this.f29994e + f2;
                                            this.f29994e = j2;
                                            if (j2 >= 10485760) {
                                                break;
                                            }
                                            if (cursor.moveToNext()) {
                                            }
                                        }
                                    }
                                    f2 = pVar.f();
                                    if (!d(readableDatabase, pVar, f2, j0Var)) {
                                    }
                                }
                                i2 = 1;
                            }
                            try {
                            } catch (SQLException e4) {
                                e = e4;
                                if (f29992i) {
                                    e.printStackTrace();
                                }
                                this.f29995f.h(e);
                                return i2;
                            }
                        } finally {
                            Closeables.closeSafely(cursor);
                        }
                    } catch (RuntimeException e5) {
                        if (f29992i) {
                            e5.printStackTrace();
                        }
                        Closeables.closeSafely(cursor);
                        i2 = 0;
                    }
                } catch (SQLException e6) {
                    e = e6;
                    i2 = 0;
                }
                return i2;
            } finally {
                this.f29997h.readLock().unlock();
            }
        }
        return invokeLL.intValue;
    }

    public final String L(ArrayList<String> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, arrayList)) == null) {
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                String str = arrayList.get(i2);
                if (i2 > 0) {
                    sb.append(",");
                }
                sb.append(str);
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public final String M(ArrayList arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, arrayList)) == null) {
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                if (i2 > 0) {
                    sb.append(",");
                }
                sb.append(arrayList.get(i2));
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public int O(j0 j0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, j0Var)) == null) {
            StringBuilder sb = new StringBuilder(256);
            sb.append("SELECT * FROM ");
            sb.append("event");
            sb.append(" WHERE ");
            sb.append("flowhandle");
            sb.append(" = ");
            sb.append(-1);
            sb.append(" AND ");
            sb.append("reallog");
            sb.append(" = \"1\"");
            return H(sb.toString(), j0Var);
        }
        return invokeL.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00de A[Catch: all -> 0x0111, SQLException -> 0x0113, DONT_GENERATE, TRY_ENTER, TRY_LEAVE, TryCatch #1 {SQLException -> 0x0113, blocks: (B:8:0x0019, B:41:0x00de, B:44:0x00eb, B:61:0x010d, B:62:0x0110), top: B:78:0x0019, outer: #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Map<String, x.a> P(int i2) {
        InterceptResult invokeI;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) {
            if (i2 <= 0) {
                return null;
            }
            this.f29997h.readLock().lock();
            try {
                try {
                    SQLiteDatabase readableDatabase = getReadableDatabase();
                    HashMap hashMap = new HashMap();
                    try {
                        try {
                            readableDatabase.beginTransactionNonExclusive();
                            try {
                                cursor = readableDatabase.rawQuery("SELECT ubcid" + StringUtil.ARRAY_ELEMENT_SEPARATOR + "ubctime" + StringUtil.ARRAY_ELEMENT_SEPARATOR + "count FROM arrival WHERE date(ubctime) > date('now', '-" + i2 + " day')  ORDER BY date(ubctime" + SmallTailInfo.EMOTION_SUFFIX + " DESC", null);
                                if (cursor != null) {
                                    try {
                                        try {
                                            if (cursor.getCount() > 0) {
                                                cursor.moveToFirst();
                                                int columnIndex = cursor.getColumnIndex("ubcid");
                                                int columnIndex2 = cursor.getColumnIndex("ubctime");
                                                int columnIndex3 = cursor.getColumnIndex("count");
                                                do {
                                                    String string = cursor.getString(columnIndex);
                                                    String string2 = cursor.getString(columnIndex2);
                                                    int i3 = cursor.getInt(columnIndex3);
                                                    if (i3 >= 1 && !TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                                                        x.f().e(hashMap, string2, string, i3);
                                                    }
                                                } while (cursor.moveToNext());
                                            }
                                        } catch (SQLException e2) {
                                            e = e2;
                                            if (f29992i) {
                                                e.printStackTrace();
                                            }
                                            this.f29995f.h(e);
                                            Closeables.closeSafely(cursor);
                                            readableDatabase.setTransactionSuccessful();
                                            if (hashMap.size() > 0) {
                                            }
                                            return null;
                                        }
                                    } catch (Throwable th) {
                                        th = th;
                                        Closeables.closeSafely(cursor);
                                        throw th;
                                    }
                                }
                            } catch (SQLException e3) {
                                e = e3;
                                cursor = null;
                            } catch (Throwable th2) {
                                th = th2;
                                cursor = null;
                                Closeables.closeSafely(cursor);
                                throw th;
                            }
                            Closeables.closeSafely(cursor);
                            readableDatabase.setTransactionSuccessful();
                            if (hashMap.size() > 0) {
                                return hashMap;
                            }
                        } finally {
                            readableDatabase.endTransaction();
                        }
                    } catch (SQLException e4) {
                        if (f29992i) {
                            e4.printStackTrace();
                        }
                        this.f29995f.h(e4);
                    } catch (RuntimeException e5) {
                        if (f29992i) {
                            e5.printStackTrace();
                        }
                    }
                } catch (SQLException e6) {
                    if (f29992i) {
                        e6.printStackTrace();
                    }
                    this.f29995f.h(e6);
                }
                return null;
            } finally {
                this.f29997h.readLock().unlock();
            }
        }
        return (Map) invokeI.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:30:0x00b4 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v7, types: [android.database.Cursor] */
    public o Q(String str) {
        InterceptResult invokeL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            ?? r0 = " , ";
            this.f29997h.readLock().lock();
            o oVar = null;
            try {
                try {
                    try {
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        cursor = getReadableDatabase().rawQuery("SELECT state , reserve1 , reserve2 FROM file WHERE filename=\"" + str + "\"", null);
                        if (cursor != null) {
                            try {
                                if (cursor.getCount() > 0) {
                                    cursor.moveToFirst();
                                    oVar = new o(str, cursor.getString(cursor.getColumnIndex("state")), cursor.isNull(cursor.getColumnIndex("reserve1")) ? "" : cursor.getString(cursor.getColumnIndex("reserve1")), cursor.isNull(cursor.getColumnIndex("reserve2")) ? false : T(cursor.getString(cursor.getColumnIndex("reserve2"))));
                                }
                            } catch (Exception e2) {
                                e = e2;
                                if (f29992i) {
                                    e.printStackTrace();
                                }
                                Closeables.closeSafely(cursor);
                                return oVar;
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                        cursor = null;
                    } catch (Throwable th2) {
                        th = th2;
                        r0 = 0;
                        Closeables.closeSafely((Cursor) r0);
                        throw th;
                    }
                    Closeables.closeSafely(cursor);
                } catch (SQLException e4) {
                    if (f29992i) {
                        e4.printStackTrace();
                    }
                    this.f29995f.h(e4);
                }
                return oVar;
            } finally {
                this.f29997h.readLock().unlock();
            }
        }
        return (o) invokeL.objValue;
    }

    public void R(SparseArray<ArrayList> sparseArray) {
        SQLiteDatabase readableDatabase;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, sparseArray) == null) {
            this.f29997h.readLock().lock();
            try {
                try {
                    readableDatabase = getReadableDatabase();
                    cursor = null;
                } catch (SQLException e2) {
                    if (f29992i) {
                        e2.printStackTrace();
                    }
                    this.f29995f.h(e2);
                }
                try {
                    try {
                        cursor = readableDatabase.rawQuery("SELECT eventid , type , cycle FROM config WHERE " + SetImageWatermarkTypeReqMsg.SWITCH + "=\"1\" AND (reallog = \"0\" OR reallog = \"\")", null);
                        if (cursor != null && cursor.getCount() > 0) {
                            cursor.moveToFirst();
                            int columnIndex = cursor.getColumnIndex("eventid");
                            int columnIndex2 = cursor.getColumnIndex("type");
                            int columnIndex3 = cursor.getColumnIndex("cycle");
                            do {
                                String string = cursor.getString(columnIndex);
                                if (!m.a(string)) {
                                    cursor.getString(columnIndex2);
                                    int i2 = cursor.getInt(columnIndex3);
                                    if (i2 != 0) {
                                        if (i2 < 6) {
                                            i2 = 6;
                                        } else if (i2 > 720) {
                                            i2 = 720;
                                        }
                                    }
                                    if (string != null) {
                                        ArrayList arrayList = sparseArray.get(i2);
                                        if (arrayList == null) {
                                            arrayList = new ArrayList();
                                            sparseArray.put(i2, arrayList);
                                        }
                                        arrayList.add(string);
                                    }
                                }
                            } while (cursor.moveToNext());
                        }
                    } catch (RuntimeException e3) {
                        if (f29992i) {
                            e3.printStackTrace();
                        }
                    }
                } finally {
                    Closeables.closeSafely(cursor);
                }
            } finally {
                this.f29997h.readLock().unlock();
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:3|4|5|6|7|8|9|(3:110|111|112)(1:11)|(6:15|(5:16|17|(5:19|(1:21)(1:37)|22|(3:28|29|(1:31))|24)(13:38|(1:40)(2:89|(1:91))|(1:42)|43|(1:45)|(1:47)|48|(1:50)|(1:53)|54|(13:60|61|(1:63)|64|(1:68)|69|70|71|(1:75)|76|(1:78)|79|(1:82))(1:56)|57|(1:59))|25|(1:27)(0))|94|95|96|97)(0)|93|94|95|96|97) */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x0207, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0208, code lost:
        r1 = r26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x020b, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x020c, code lost:
        r1 = r26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0218, code lost:
        if (c.a.s0.z.f29992i != false) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x021a, code lost:
        r0.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x021d, code lost:
        r1.f29995f.h(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x022c, code lost:
        r1.f29997h.readLock().unlock();
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0235, code lost:
        throw r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01d3 A[Catch: all -> 0x01f5, RuntimeException -> 0x01f9, TryCatch #9 {RuntimeException -> 0x01f9, blocks: (B:7:0x0029, B:9:0x0033, B:15:0x0041, B:17:0x0047, B:18:0x0088, B:21:0x00c8, B:25:0x00d8, B:27:0x00e2, B:29:0x00ed, B:35:0x00fd, B:88:0x01d8, B:32:0x00f6, B:34:0x00fa, B:36:0x0105, B:38:0x010f, B:43:0x0122, B:44:0x0127, B:46:0x012d, B:48:0x0134, B:49:0x013d, B:51:0x0143, B:54:0x014c, B:55:0x0156, B:57:0x015c, B:59:0x0169, B:60:0x016e, B:62:0x0174, B:64:0x017e, B:66:0x0185, B:68:0x018b, B:70:0x0191, B:71:0x019a, B:73:0x01a3, B:74:0x01ac, B:85:0x01cd, B:87:0x01d3, B:77:0x01b8, B:83:0x01c7, B:39:0x0115, B:41:0x011b), top: B:129:0x0029, outer: #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01df A[LOOP:0: B:18:0x0088->B:91:0x01df, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void S(f fVar) {
        Cursor cursor;
        f fVar2;
        String str;
        String str2;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048593, this, fVar) != null) {
            return;
        }
        z zVar = this;
        String str3 = "isSend";
        zVar.f29997h.readLock().lock();
        try {
            try {
                SQLiteDatabase readableDatabase = getReadableDatabase();
                cursor = null;
                try {
                    try {
                        cursor = readableDatabase.rawQuery("SELECT * FROM config", null);
                        if (fVar == null) {
                            try {
                                fVar2 = new f();
                            } catch (Throwable th) {
                                th = th;
                                Closeables.closeSafely(cursor);
                                throw th;
                            }
                        } else {
                            fVar2 = fVar;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        zVar = this;
                    }
                } catch (RuntimeException e2) {
                    if (f29992i) {
                        e2.printStackTrace();
                    }
                }
            } catch (SQLException e3) {
                e = e3;
            }
            if (cursor != null && cursor.getCount() > 0) {
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex("eventid");
                int columnIndex2 = cursor.getColumnIndex(SetImageWatermarkTypeReqMsg.SWITCH);
                int columnIndex3 = cursor.getColumnIndex("sample");
                int columnIndex4 = cursor.getColumnIndex("reserve1");
                int columnIndex5 = cursor.getColumnIndex("reserve2");
                int columnIndex6 = cursor.getColumnIndex("cycle");
                int columnIndex7 = cursor.getColumnIndex("uploadrule");
                int columnIndex8 = cursor.getColumnIndex("recordrule");
                int columnIndex9 = cursor.getColumnIndex("extend");
                int columnIndex10 = cursor.getColumnIndex("reallog");
                String str4 = "gflow";
                while (true) {
                    String string = cursor.getString(columnIndex);
                    String string2 = cursor.getString(columnIndex2);
                    int i3 = cursor.getInt(columnIndex3);
                    int i4 = columnIndex;
                    String string3 = cursor.getString(columnIndex4);
                    int i5 = columnIndex2;
                    String string4 = cursor.getString(columnIndex5);
                    int i6 = columnIndex3;
                    int i7 = cursor.getInt(columnIndex6);
                    int i8 = columnIndex4;
                    int i9 = cursor.getInt(columnIndex7);
                    int i10 = columnIndex5;
                    int i11 = cursor.getInt(columnIndex8);
                    int i12 = columnIndex6;
                    String string5 = cursor.getString(columnIndex9);
                    int i13 = columnIndex7;
                    String string6 = cursor.getString(columnIndex10);
                    int i14 = columnIndex10;
                    if (m.a(string)) {
                        m mVar = new m();
                        mVar.f29947a = TextUtils.equals(string2, "1");
                        mVar.f29948b = i7 == 0;
                        mVar.f29949c = i7;
                        if (!TextUtils.isEmpty(string5)) {
                            try {
                                JSONObject jSONObject = new JSONObject(string5);
                                if (jSONObject.has(str3)) {
                                    mVar.f29950d = jSONObject.optBoolean(str3, true);
                                }
                            } catch (JSONException e4) {
                                if (f29992i) {
                                    e4.printStackTrace();
                                }
                            }
                        }
                        fVar2.f29870a = mVar;
                        str = str3;
                        str2 = str4;
                    } else {
                        str = str3;
                        if (TextUtils.equals(string2, "0")) {
                            fVar2.f29871b.add(string);
                        } else if (TextUtils.equals(string2, "1")) {
                            fVar2.f29875f.add(string);
                        }
                        if (i7 == 0) {
                            fVar2.f29872c.add(string);
                        }
                        if (TextUtils.equals(string3, "1")) {
                            fVar2.f29874e.add(string);
                        }
                        if (i3 > 0) {
                            fVar2.f29877h.put(string, Integer.valueOf(i3));
                        }
                        if (!TextUtils.isEmpty(string4)) {
                            fVar2.f29878i.put(string, string4);
                        }
                        if (i9 != 0 && i11 != 0) {
                            fVar2.f29879j.put(string, new l(string, i11, i9));
                        }
                        if (TextUtils.isEmpty(string5)) {
                            str2 = str4;
                        } else {
                            try {
                                JSONObject jSONObject2 = new JSONObject(string5);
                                if (jSONObject2.has(Constant.ID_TYPE)) {
                                    fVar2.k.add(string);
                                }
                                if (jSONObject2.has("ch") && TextUtils.equals(jSONObject2.getString("ch"), "1")) {
                                    fVar2.f29876g.add(string);
                                }
                                str2 = str4;
                                try {
                                    if (jSONObject2.has(str2) && (i2 = jSONObject2.getInt(str2)) != 0) {
                                        fVar2.m.put(string, Integer.valueOf(i2));
                                    }
                                    int optInt = jSONObject2.optInt("uploadType", -1);
                                    if (optInt != -1) {
                                        fVar2.n.put(string, Integer.valueOf(optInt));
                                    }
                                    int optInt2 = jSONObject2.optInt("lcache", 2);
                                    if (optInt2 == 1 || optInt2 == 0) {
                                        fVar2.o.put(string, Integer.valueOf(optInt2));
                                    }
                                } catch (JSONException e5) {
                                    e = e5;
                                    e.printStackTrace();
                                    if (TextUtils.equals(string6, "1")) {
                                    }
                                    if (cursor.moveToNext()) {
                                    }
                                    Closeables.closeSafely(cursor);
                                    zVar = this;
                                    zVar.f29997h.readLock().unlock();
                                }
                            } catch (JSONException e6) {
                                e = e6;
                                str2 = str4;
                            }
                        }
                        if (TextUtils.equals(string6, "1")) {
                            fVar2.l.add(string);
                        }
                    }
                    if (cursor.moveToNext()) {
                        columnIndex = i4;
                        str4 = str2;
                        columnIndex2 = i5;
                        columnIndex3 = i6;
                        columnIndex4 = i8;
                        columnIndex5 = i10;
                        columnIndex6 = i12;
                        columnIndex7 = i13;
                        str3 = str;
                        columnIndex10 = i14;
                    }
                }
                Closeables.closeSafely(cursor);
                zVar = this;
                zVar.f29997h.readLock().unlock();
            }
            Closeables.closeSafely(cursor);
            zVar = this;
            zVar.f29997h.readLock().unlock();
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public final boolean T(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return TextUtils.equals(new JSONObject(str).optString("ubc_data_backend_type", "0"), "1");
        }
        return invokeL.booleanValue;
    }

    public void U(n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, nVar) == null) {
            if (nVar != null && !TextUtils.isEmpty(nVar.j())) {
                this.f29997h.writeLock().lock();
                try {
                    try {
                        ContentValues I = I(nVar);
                        String i2 = nVar.i();
                        String j2 = nVar.j();
                        int h2 = nVar.h();
                        SQLiteDatabase writableDatabase = getWritableDatabase();
                        writableDatabase.beginTransactionNonExclusive();
                        try {
                            if (i(i2, j2, h2, writableDatabase)) {
                                long insert = writableDatabase.insert("event", null, I);
                                if (f29992i) {
                                    String str = "saveEvent#performTransaction: rowId=" + insert;
                                }
                            }
                            writableDatabase.setTransactionSuccessful();
                            writableDatabase.endTransaction();
                        } catch (Throwable th) {
                            writableDatabase.endTransaction();
                            throw th;
                        }
                    } catch (SQLException e2) {
                        if (f29992i) {
                            e2.printStackTrace();
                        }
                        this.f29995f.h(e2);
                    }
                    return;
                } finally {
                    this.f29997h.writeLock().unlock();
                }
            }
            boolean z = f29992i;
        }
    }

    public void V(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, list) == null) {
            if (list != null && list.size() != 0) {
                for (n nVar : list) {
                    U(nVar);
                }
                return;
            }
            boolean z = f29992i;
        }
    }

    public void W(p pVar) {
        SQLiteDatabase writableDatabase;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, pVar) == null) {
            if (pVar != null && !TextUtils.isEmpty(pVar.j())) {
                this.f29997h.writeLock().lock();
                try {
                    try {
                        writableDatabase = getWritableDatabase();
                        writableDatabase.beginTransactionNonExclusive();
                    } catch (SQLException e2) {
                        if (f29992i) {
                            e2.printStackTrace();
                        }
                        this.f29995f.h(e2);
                    }
                    try {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("flowid", pVar.j());
                        contentValues.put("flowhandle", Integer.valueOf(pVar.i()));
                        contentValues.put("state", pVar.m());
                        contentValues.put("begintime", Long.valueOf(pVar.c()));
                        if (pVar.k() != null) {
                            contentValues.put("content", pVar.k().toString());
                        } else {
                            contentValues.put("content", pVar.e());
                        }
                        contentValues.put(SpeedStatsUtils.UBC_KEY_OPTION, Integer.valueOf(pVar.l()));
                        contentValues.put("reserve1", pVar.h());
                        if (!TextUtils.isEmpty(pVar.d())) {
                            contentValues.put("reserve2", pVar.d());
                        }
                        if (pVar.n()) {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("ctr", "1");
                                contentValues.put("extend", jSONObject.toString());
                            } catch (JSONException e3) {
                                if (f29992i) {
                                    e3.printStackTrace();
                                }
                            }
                        }
                        long insert = writableDatabase.insert("flow", null, contentValues);
                        if (f29992i) {
                            String str = "saveFlow#performTransaction: rowId=" + insert;
                        }
                        writableDatabase.setTransactionSuccessful();
                        writableDatabase.endTransaction();
                        return;
                    } catch (Throwable th) {
                        writableDatabase.endTransaction();
                        throw th;
                    }
                } finally {
                    this.f29997h.writeLock().unlock();
                }
            }
            boolean z = f29992i;
        }
    }

    public void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.f29997h.writeLock().lock();
            try {
                try {
                    SQLiteDatabase writableDatabase = getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                    try {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("state", "1");
                        int update = writableDatabase.update("file", contentValues, null, null);
                        if (f29992i) {
                            String str = "updateAllSentFileFail#performTransaction: update file table:" + update;
                        }
                        writableDatabase.setTransactionSuccessful();
                        writableDatabase.endTransaction();
                    } catch (Throwable th) {
                        writableDatabase.endTransaction();
                        throw th;
                    }
                } catch (SQLException e2) {
                    if (f29992i) {
                        e2.printStackTrace();
                    }
                    this.f29995f.h(e2);
                }
            } finally {
                this.f29997h.writeLock().unlock();
            }
        }
    }

    public boolean Y(List<j> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048599, this, list)) != null) {
            return invokeL.booleanValue;
        }
        if (list == null || list.size() == 0) {
            return false;
        }
        this.f29997h.writeLock().lock();
        try {
            try {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                SQLiteStatement compileStatement = writableDatabase.compileStatement("replace into config(eventid,type,recordrule,uploadrule,cycle," + SetImageWatermarkTypeReqMsg.SWITCH + ",sample,reserve1,reserve2,extend,reallog" + SmallTailInfo.EMOTION_SUFFIX + " values(?,?,?,?,?,?,?,?,?,?,?)");
                writableDatabase.beginTransactionNonExclusive();
                try {
                    try {
                        for (j jVar : list) {
                            compileStatement.clearBindings();
                            compileStatement.bindString(1, jVar.c());
                            if (jVar.i() == 1) {
                                compileStatement.bindString(2, "1");
                            } else {
                                compileStatement.bindString(2, "0");
                            }
                            int e2 = jVar.e();
                            int d2 = jVar.d();
                            if (e2 != 0 && d2 != 0) {
                                compileStatement.bindLong(3, e2);
                                compileStatement.bindLong(4, d2);
                            }
                            if (jVar.p()) {
                                compileStatement.bindLong(5, 0L);
                            } else {
                                compileStatement.bindLong(5, jVar.h());
                            }
                            if (jVar.t()) {
                                compileStatement.bindString(6, "1");
                            } else {
                                compileStatement.bindString(6, "0");
                            }
                            compileStatement.bindLong(7, jVar.g());
                            if (jVar.l()) {
                                compileStatement.bindString(8, "1");
                            } else {
                                compileStatement.bindString(8, "0");
                            }
                            String a2 = jVar.a();
                            if (!TextUtils.isEmpty(a2)) {
                                compileStatement.bindString(9, a2);
                            }
                            JSONObject jSONObject = new JSONObject();
                            if (jVar.n()) {
                                jSONObject.put(Constant.ID_TYPE, "1");
                            }
                            if (jVar.o()) {
                                jSONObject.put("ch", "1");
                            }
                            if (jVar.m()) {
                                jSONObject.put("dfc", "1");
                            }
                            jSONObject.put("version", jVar.k());
                            int b2 = jVar.b();
                            if (jVar.s()) {
                                jSONObject.put("gflow", Integer.toString(b2));
                            }
                            if (!jVar.u()) {
                                jSONObject.put("uploadType", Integer.toString(jVar.j()));
                            }
                            int f2 = jVar.f();
                            if (f2 != 2) {
                                jSONObject.put("lcache", f2);
                            }
                            if (m.a(jVar.c())) {
                                jSONObject.put("isSend", jVar.r());
                            }
                            compileStatement.bindString(10, jSONObject.toString());
                            if (jVar.q()) {
                                compileStatement.bindString(11, "1");
                            } else {
                                compileStatement.bindString(11, "0");
                            }
                            if (compileStatement.executeUpdateDelete() <= 0) {
                                return false;
                            }
                        }
                        writableDatabase.setTransactionSuccessful();
                        if (f29992i) {
                            String str = "updateConfig success count: " + list.size();
                        }
                        return true;
                    } catch (JSONException e3) {
                        if (f29992i) {
                            e3.printStackTrace();
                        }
                        writableDatabase.endTransaction();
                        return false;
                    }
                } finally {
                    writableDatabase.endTransaction();
                }
            } catch (SQLException e4) {
                if (f29992i) {
                    e4.printStackTrace();
                }
                this.f29995f.h(e4);
            }
        } finally {
            this.f29997h.writeLock().unlock();
        }
    }

    public void Z(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048600, this, str, i2, str2) == null) {
            if (i2 >= 0 && !TextUtils.isEmpty(str)) {
                this.f29997h.writeLock().lock();
                try {
                    try {
                        SQLiteDatabase writableDatabase = getWritableDatabase();
                        writableDatabase.beginTransactionNonExclusive();
                        try {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("content", str2);
                            int update = writableDatabase.update("flow", contentValues, "flowid=\"" + str + "\" AND flowhandle = " + i2, null);
                            if (f29992i && update != 1) {
                                String str3 = "updateFlowValue#performTransaction: updateFlowValue count:" + update;
                            }
                            writableDatabase.setTransactionSuccessful();
                            writableDatabase.endTransaction();
                        } catch (Throwable th) {
                            writableDatabase.endTransaction();
                            throw th;
                        }
                    } catch (SQLException e2) {
                        if (f29992i) {
                            e2.printStackTrace();
                        }
                        this.f29995f.h(e2);
                    }
                    return;
                } finally {
                    this.f29997h.writeLock().unlock();
                }
            }
            boolean z = f29992i;
        }
    }

    public final boolean a(n nVar, int i2, j0 j0Var) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048601, this, nVar, i2, j0Var)) == null) {
            boolean c2 = j0Var.c(nVar, i2);
            if (c2) {
                if (!TextUtils.isEmpty(nVar.f())) {
                    j0Var.J("1");
                }
                long n = nVar.n();
                if (n > 0) {
                    if (j0Var.s() == 0 || n < j0Var.s()) {
                        j0Var.I(n, 0L);
                    }
                    if (n > j0Var.r()) {
                        j0Var.I(0L, n);
                    }
                }
            }
            return c2;
        }
        return invokeLIL.booleanValue;
    }

    public void a0(String str) {
        SQLiteDatabase writableDatabase;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            this.f29997h.writeLock().lock();
            try {
                try {
                    writableDatabase = getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                } catch (SQLException e2) {
                    if (f29992i) {
                        e2.printStackTrace();
                    }
                    this.f29995f.h(e2);
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("state", "1");
                    int update = writableDatabase.update("file", contentValues, "filename=\"" + str + "\"", null);
                    if (f29992i) {
                        String str2 = "updateSendedFileFail#performTransaction: update file table:" + update;
                    }
                    writableDatabase.setTransactionSuccessful();
                    writableDatabase.endTransaction();
                } catch (Throwable th) {
                    writableDatabase.endTransaction();
                    throw th;
                }
            } finally {
                this.f29997h.writeLock().unlock();
            }
        }
    }

    public final void b(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, sQLiteDatabase) == null) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE event ADD COLUMN extend TEXT");
                sQLiteDatabase.execSQL("ALTER TABLE flow ADD COLUMN extend TEXT");
            } catch (SQLException e2) {
                if (f29992i) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void b0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048604, this, str, str2) == null) {
            this.f29997h.writeLock().lock();
            try {
                try {
                    SQLiteDatabase writableDatabase = getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                    try {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("state", str2);
                        writableDatabase.update("file", contentValues, "filename=\"" + str + "\"", null);
                        writableDatabase.setTransactionSuccessful();
                        writableDatabase.endTransaction();
                    } catch (Throwable th) {
                        writableDatabase.endTransaction();
                        throw th;
                    }
                } catch (SQLException e2) {
                    if (f29992i) {
                        e2.printStackTrace();
                    }
                    this.f29995f.h(e2);
                }
            } finally {
                this.f29997h.writeLock().unlock();
            }
        }
    }

    public final void c(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, sQLiteDatabase) == null) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE config ADD COLUMN extend TEXT");
            } catch (SQLException e2) {
                if (f29992i) {
                    e2.printStackTrace();
                }
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
        }
    }

    public final boolean d(SQLiteDatabase sQLiteDatabase, p pVar, int i2, j0 j0Var) {
        InterceptResult invokeLLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(1048607, this, sQLiteDatabase, pVar, i2, j0Var)) == null) {
            if (pVar.i() < 0) {
                return false;
            }
            try {
                JSONArray jSONArray = new JSONArray();
                StringBuilder sb = new StringBuilder(256);
                sb.append("SELECT ");
                sb.append("eventid");
                sb.append(" , ");
                sb.append("begintime");
                sb.append(" , ");
                sb.append("content");
                sb.append(" FROM ");
                sb.append("event");
                sb.append(" WHERE ");
                sb.append("flowhandle");
                sb.append(" = ");
                sb.append(pVar.i());
                Cursor rawQuery = sQLiteDatabase.rawQuery(sb.toString(), null);
                if (rawQuery != null && rawQuery.getCount() > 0) {
                    rawQuery.moveToFirst();
                    int columnIndex = rawQuery.getColumnIndex("eventid");
                    int columnIndex2 = rawQuery.getColumnIndex("begintime");
                    int columnIndex3 = rawQuery.getColumnIndex("content");
                    do {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("id", rawQuery.getString(columnIndex));
                        jSONObject.put("timestamp", Long.toString(rawQuery.getLong(columnIndex2)));
                        jSONObject.put("content", rawQuery.getString(columnIndex3));
                        jSONArray.put(jSONObject);
                    } while (rawQuery.moveToNext());
                    pVar.t(jSONArray);
                }
                Closeables.closeSafely(rawQuery);
                if (j0Var.c(pVar, i2)) {
                    if (!TextUtils.isEmpty(pVar.h())) {
                        j0Var.J("1");
                    }
                    if (pVar.g() > 0 && pVar.g() > j0Var.r()) {
                        j0Var.I(0L, pVar.g());
                    }
                    if (pVar.c() > 0) {
                        if (j0Var.s() == 0 || pVar.c() < j0Var.s()) {
                            j0Var.I(pVar.c(), 0L);
                            return true;
                        }
                        return true;
                    }
                    return true;
                }
            } catch (RuntimeException e2) {
                if (f29992i) {
                    e2.printStackTrace();
                }
            } catch (JSONException unused) {
                boolean z = f29992i;
            }
            return false;
        }
        return invokeLLIL.booleanValue;
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048608, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.f29997h.writeLock().lock();
        try {
            try {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    try {
                        SQLiteStatement compileStatement = writableDatabase.compileStatement("UPDATE arrival SET count = count + 1, state = 0 WHERE ubcid = ? AND date(ubctime" + SmallTailInfo.EMOTION_SUFFIX + " = date(\"now\")");
                        compileStatement.clearBindings();
                        compileStatement.bindString(1, str);
                        if (compileStatement.executeUpdateDelete() <= 0) {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("ubcid", str);
                            contentValues.put("count", (Integer) 1);
                            contentValues.put("state", (Integer) 0);
                            writableDatabase.insert("arrival", null, contentValues);
                        }
                        writableDatabase.setTransactionSuccessful();
                    } finally {
                        writableDatabase.endTransaction();
                    }
                } catch (SQLException e2) {
                    if (f29992i) {
                        e2.printStackTrace();
                    }
                    this.f29995f.h(e2);
                }
            } catch (SQLException e3) {
                if (f29992i) {
                    e3.printStackTrace();
                }
                this.f29995f.h(e3);
            }
        } finally {
            this.f29997h.writeLock().unlock();
        }
    }

    public final void f(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, sQLiteDatabase) == null) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE config ADD COLUMN reallog DEFAULT '0'");
                sQLiteDatabase.execSQL("ALTER TABLE event ADD COLUMN reallog DEFAULT '0'");
            } catch (SQLException e2) {
                if (f29992i) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void g(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, sQLiteDatabase) == null) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE config ADD COLUMN sample TEXT");
                sQLiteDatabase.execSQL("ALTER TABLE flow ADD COLUMN slot TEXT");
            } catch (SQLException e2) {
                if (f29992i) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void h(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048611, this, str, i2) == null) {
            if (i2 >= 0 && !TextUtils.isEmpty(str)) {
                this.f29997h.writeLock().lock();
                try {
                    try {
                        SQLiteDatabase writableDatabase = getWritableDatabase();
                        writableDatabase.beginTransactionNonExclusive();
                        try {
                            int delete = writableDatabase.delete("flow", "flowid=\"" + str + "\" AND flowhandle = " + i2, null);
                            if (f29992i) {
                                String str2 = "cancelFlow#performTransaction: cancelFlow flow count:" + delete;
                            }
                            int delete2 = writableDatabase.delete("event", "flowhandle = " + i2, null);
                            if (f29992i) {
                                String str3 = "cancelFlow#performTransaction: cancelFlow event count:" + delete2;
                            }
                            writableDatabase.setTransactionSuccessful();
                            writableDatabase.endTransaction();
                        } catch (Throwable th) {
                            writableDatabase.endTransaction();
                            throw th;
                        }
                    } catch (SQLException e2) {
                        if (f29992i) {
                            e2.printStackTrace();
                        }
                        this.f29995f.h(e2);
                    }
                    return;
                } finally {
                    this.f29997h.writeLock().unlock();
                }
            }
            boolean z = f29992i;
        }
    }

    public final boolean i(String str, String str2, int i2, SQLiteDatabase sQLiteDatabase) {
        InterceptResult invokeLLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(1048612, this, str, str2, i2, sQLiteDatabase)) == null) {
            this.f29997h.writeLock().lock();
            try {
                boolean equals = str.equals(str2);
                boolean z = false;
                if (equals) {
                    z = true;
                } else {
                    Cursor cursor = null;
                    try {
                        cursor = sQLiteDatabase.rawQuery("SELECT state FROM flow WHERE flowhandle = " + i2, null);
                        if (cursor != null && cursor.getCount() > 0) {
                            cursor.moveToFirst();
                            String string = cursor.getString(0);
                            if (!TextUtils.isEmpty(string)) {
                                if ("1".equals(string)) {
                                    z = true;
                                }
                            }
                        }
                    } catch (SQLException e2) {
                        if (f29992i) {
                            e2.printStackTrace();
                        }
                        this.f29995f.h(e2);
                    } catch (RuntimeException e3) {
                        if (f29992i) {
                            e3.printStackTrace();
                        }
                    }
                    Closeables.closeSafely(cursor);
                }
                return z;
            } finally {
                this.f29997h.writeLock().unlock();
            }
        }
        return invokeLLIL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x01a2 A[Catch: all -> 0x01cd, TryCatch #9 {all -> 0x01cd, blocks: (B:54:0x0191, B:55:0x0194, B:62:0x019e, B:64:0x01a2, B:65:0x01a5), top: B:82:0x0191 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void n() {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048613, this) != null) {
            return;
        }
        this.f29997h.writeLock().lock();
        int i4 = 0;
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            try {
                long currentTimeMillis = System.currentTimeMillis() - g.n().j();
                Cursor cursor = null;
                int delete = writableDatabase.delete("flow", "endtime < " + currentTimeMillis, null);
                try {
                    if (f29992i) {
                        String str = "clearInvalidData: delete flow count:" + delete;
                    }
                    i3 = writableDatabase.delete("event", "begintime < " + currentTimeMillis, null);
                    try {
                        if (f29992i) {
                            String str2 = "clearInvalidData: delete event count:" + i3;
                        }
                        StringBuilder sb = new StringBuilder(256);
                        sb.append("SELECT ");
                        sb.append("flowhandle");
                        sb.append(" FROM ");
                        sb.append("flow");
                        sb.append(" WHERE ");
                        sb.append("begintime");
                        sb.append(" < ");
                        sb.append(System.currentTimeMillis() - 86400000);
                        sb.append(" AND ");
                        sb.append("endtime");
                        sb.append(" is NULL ");
                        sb.append(" AND ");
                        sb.append(SpeedStatsUtils.UBC_KEY_OPTION);
                        sb.append(" = 0");
                        ArrayList arrayList = new ArrayList();
                        try {
                            Cursor rawQuery = writableDatabase.rawQuery(sb.toString(), null);
                            if (rawQuery != null) {
                                try {
                                    if (rawQuery.getCount() > 0) {
                                        rawQuery.moveToFirst();
                                        do {
                                            arrayList.add(Integer.valueOf(rawQuery.getInt(rawQuery.getColumnIndex("flowhandle"))));
                                        } while (rawQuery.moveToNext());
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    cursor = rawQuery;
                                    Closeables.closeSafely(cursor);
                                    throw th;
                                }
                            }
                            Closeables.closeSafely(rawQuery);
                            if (arrayList.size() > 0) {
                                if (f29992i) {
                                    String str3 = "clearInvalidData: delete flow count2:" + arrayList.size();
                                }
                                i4 = arrayList.size();
                                try {
                                    String M = M(arrayList);
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append("flowhandle");
                                    sb2.append(" in (");
                                    sb2.append(M);
                                    sb2.append(SmallTailInfo.EMOTION_SUFFIX);
                                    writableDatabase.delete("flow", sb2.toString(), null);
                                    writableDatabase.delete("event", sb2.toString(), null);
                                } catch (Throwable th2) {
                                    th = th2;
                                    i2 = i4;
                                    i4 = delete;
                                    try {
                                        try {
                                            writableDatabase.endTransaction();
                                            throw th;
                                        } catch (SQLException e2) {
                                            e = e2;
                                            if (f29992i) {
                                                e.printStackTrace();
                                            }
                                            this.f29995f.h(e);
                                            this.f29997h.writeLock().unlock();
                                            if (i4 <= 0 || i3 > 0 || i2 > 0) {
                                                b0.a().e(String.valueOf(g.n().j()), i4, i3, i2);
                                            }
                                            return;
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                        this.f29997h.writeLock().unlock();
                                        if (i4 <= 0 || i3 > 0 || i2 > 0) {
                                            b0.a().e(String.valueOf(g.n().j()), i4, i3, i2);
                                        }
                                        throw th;
                                    }
                                }
                            }
                            writableDatabase.setTransactionSuccessful();
                            try {
                                writableDatabase.endTransaction();
                                z("flow");
                                z("event");
                                this.f29997h.writeLock().unlock();
                                if (delete > 0 || i3 > 0 || i4 > 0) {
                                    b0.a().e(String.valueOf(g.n().j()), delete, i3, i4);
                                }
                            } catch (SQLException e3) {
                                e = e3;
                                i2 = i4;
                                i4 = delete;
                                if (f29992i) {
                                }
                                this.f29995f.h(e);
                                this.f29997h.writeLock().unlock();
                                if (i4 <= 0) {
                                }
                                b0.a().e(String.valueOf(g.n().j()), i4, i3, i2);
                            } catch (Throwable th4) {
                                th = th4;
                                i2 = i4;
                                i4 = delete;
                                this.f29997h.writeLock().unlock();
                                if (i4 <= 0) {
                                }
                                b0.a().e(String.valueOf(g.n().j()), i4, i3, i2);
                                throw th;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        i4 = delete;
                        i2 = 0;
                    }
                } catch (Throwable th7) {
                    th = th7;
                    i4 = delete;
                    i2 = 0;
                    i3 = 0;
                    writableDatabase.endTransaction();
                    throw th;
                }
            } catch (Throwable th8) {
                th = th8;
            }
        } catch (SQLException e4) {
            e = e4;
            i2 = 0;
            i3 = 0;
        } catch (Throwable th9) {
            th = th9;
            i2 = 0;
            i3 = 0;
        }
    }

    public void o() {
        SQLiteDatabase writableDatabase;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048614, this) != null) {
            return;
        }
        this.f29997h.writeLock().lock();
        try {
            try {
                writableDatabase = getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                cursor = null;
            } catch (SQLException e2) {
                if (f29992i) {
                    e2.printStackTrace();
                }
                this.f29995f.h(e2);
            }
            try {
                try {
                    int delete = writableDatabase.delete("arrival", "date(ubctime) <= date('now', '-7 day') ", null);
                    if (f29992i) {
                        String str = "clearInvalidUBCRecords delete " + delete + " records";
                    }
                    int delete2 = writableDatabase.delete("arrival", "state = 1 AND date(ubctime) < date('now')", null);
                    if (f29992i) {
                        String str2 = "clearInvalidUBCRecords delete " + delete2 + " records";
                    }
                    Cursor rawQuery = writableDatabase.rawQuery("SELECT COUNT(*), MIN(_id), MAX(_id) FROM arrival", null);
                    int i2 = 0;
                    if (rawQuery != null) {
                        try {
                            if (rawQuery.getCount() > 0) {
                                rawQuery.moveToFirst();
                                if (rawQuery.getInt(0) > 15000) {
                                    i2 = (rawQuery.getInt(1) + rawQuery.getInt(2)) / 3;
                                }
                            }
                        } catch (SQLException e3) {
                            cursor = rawQuery;
                            e = e3;
                            if (f29992i) {
                                e.printStackTrace();
                            }
                            this.f29995f.h(e);
                            Closeables.closeSafely(cursor);
                            writableDatabase.endTransaction();
                        } catch (Throwable th) {
                            cursor = rawQuery;
                            th = th;
                            Closeables.closeSafely(cursor);
                            writableDatabase.endTransaction();
                            throw th;
                        }
                    }
                    int delete3 = writableDatabase.delete("arrival", "_id < " + i2, null);
                    if (f29992i) {
                        String str3 = "clearInvalidUBCRecords delete count:" + delete3;
                    }
                    writableDatabase.setTransactionSuccessful();
                    Closeables.closeSafely(rawQuery);
                } catch (SQLException e4) {
                    e = e4;
                }
                writableDatabase.endTransaction();
            } catch (Throwable th2) {
                th = th2;
            }
        } finally {
            this.f29997h.writeLock().unlock();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onConfigure(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, sQLiteDatabase) == null) {
            sQLiteDatabase.enableWriteAheadLogging();
            super.onConfigure(sQLiteDatabase);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, sQLiteDatabase) == null) {
            boolean z = f29992i;
            try {
                sQLiteDatabase.execSQL("CREATE TABLE event (_id INTEGER PRIMARY KEY AUTOINCREMENT,flowhandle INTEGER,eventid TEXT,begintime LONG,content TEXT,reserve1 TEXT,reserve2 TEXT,extend TEXT,reallog TEXT);");
                sQLiteDatabase.execSQL("CREATE TABLE flow (_id INTEGER PRIMARY KEY AUTOINCREMENT,flowid TEXT,flowhandle INTEGER,state TEXT,begintime LONG,endtime LONG,content TEXT,option INTEGER,reserve1 TEXT,reserve2 TEXT,slot TEXT,extend TEXT );");
                sQLiteDatabase.execSQL("CREATE TABLE config (eventid TEXT PRIMARY KEY,type TEXT,recordrule TEXT,uploadrule TEXT,cycle INTEGER,switch TEXT,sample INTEGER,reserve1 TEXT,reserve2 TEXT,extend TEXT,reallog TEXT);");
                sQLiteDatabase.execSQL("CREATE TABLE file (filename TEXT PRIMARY KEY,state TEXT,reserve1 TEXT,reserve2 TEXT);");
                sQLiteDatabase.execSQL("CREATE TABLE arrival (_id INTEGER PRIMARY KEY AUTOINCREMENT,ubcid TEXT,ubctime TEXT DEFAULT CURRENT_DATE,count INTEGER,state INTEGER,reserve1 TEXT);");
                i0.e().putString(UBCCloudControlProcessor.UBC_CLOUDCONFIG_VERSION, "0");
            } catch (Exception e2) {
                String str = "Error while creating db: " + e2.toString();
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048617, this, sQLiteDatabase, i2, i3) == null) {
            try {
                sQLiteDatabase.beginTransaction();
                while (i2 < i3) {
                    if (i2 == 1) {
                        s(sQLiteDatabase);
                    } else if (i2 == 2) {
                        g(sQLiteDatabase);
                    } else if (i2 == 3) {
                        b(sQLiteDatabase);
                    } else if (i2 == 4) {
                        c(sQLiteDatabase);
                    } else if (i2 == 6) {
                        f(sQLiteDatabase);
                    } else if (i2 == 7) {
                        r(sQLiteDatabase);
                    }
                    i2++;
                }
                sQLiteDatabase.setTransactionSuccessful();
            } finally {
                try {
                } finally {
                }
            }
        }
    }

    public boolean p(j0 j0Var, String str) {
        InterceptResult invokeLL;
        boolean z;
        SQLiteDatabase writableDatabase;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048618, this, j0Var, str)) == null) {
            SparseArray<Integer> q = j0Var.q();
            ArrayList p = j0Var.p();
            boolean A = j0Var.A();
            this.f29997h.writeLock().lock();
            try {
                try {
                    writableDatabase = getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                    if (q != null) {
                        try {
                            if (q.size() > 0) {
                                int size = q.size();
                                ArrayList arrayList = new ArrayList(size);
                                for (int i2 = 0; i2 < size; i2++) {
                                    arrayList.add(Integer.valueOf(q.keyAt(i2)));
                                }
                                String M = M(arrayList);
                                if (f29992i) {
                                    String str2 = "save file name " + str + " delete flow handle ids = " + M;
                                }
                                StringBuilder sb = new StringBuilder();
                                sb.append("flowhandle");
                                sb.append(" in (");
                                sb.append(M);
                                sb.append(SmallTailInfo.EMOTION_SUFFIX);
                                int delete = writableDatabase.delete("flow", sb.toString(), null);
                                if (f29992i) {
                                    String str3 = "clearUploadedData#performTransaction: flow table delete count:" + delete;
                                }
                                int delete2 = writableDatabase.delete("event", sb.toString(), null);
                                if (f29992i) {
                                    String str4 = "clearUploadedData#performTransaction:  delete flow -> event table count:" + delete2;
                                }
                            }
                        } catch (Throwable th) {
                            writableDatabase.endTransaction();
                            throw th;
                        }
                    }
                    if (p != null && p.size() > 0) {
                        String M2 = M(p);
                        if (f29992i) {
                            String str5 = "delete event ids = " + M2;
                        }
                        int delete3 = writableDatabase.delete("event", "eventid in (" + M2 + SmallTailInfo.EMOTION_SUFFIX + " AND flowhandle = -1", null);
                        if (f29992i) {
                            String str6 = "clearUploadedData#performTransaction: event table count2:" + delete3;
                        }
                    }
                    q(writableDatabase, j0Var);
                    if ((q != null && q.size() > 0) || (p != null && p.size() > 0)) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("filename", str);
                        contentValues.put("state", "0");
                        contentValues.put("reserve1", A ? "1" : "0");
                        if (j0Var.w()) {
                            String J = J(j0Var);
                            if (!TextUtils.isEmpty(J)) {
                                contentValues.put("reserve2", J);
                            }
                        }
                        long insert = writableDatabase.insert("file", null, contentValues);
                        if (f29992i) {
                            String str7 = "clearUploadedData#save file: rowId=" + insert;
                        }
                    }
                    writableDatabase.setTransactionSuccessful();
                } catch (SQLException e2) {
                    e = e2;
                    z = false;
                }
                try {
                    writableDatabase.endTransaction();
                    this.f29997h.writeLock().unlock();
                    return true;
                } catch (SQLException e3) {
                    e = e3;
                    z = true;
                    if (f29992i) {
                        e.printStackTrace();
                    }
                    this.f29995f.h(e);
                    return z;
                }
            } finally {
                this.f29997h.writeLock().unlock();
            }
        }
        return invokeLL.booleanValue;
    }

    public void q(SQLiteDatabase sQLiteDatabase, j0 j0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048619, this, sQLiteDatabase, j0Var) == null) || j0Var == null || j0Var.x() || j0Var.l().size() < 1) {
            return;
        }
        this.f29997h.writeLock().lock();
        try {
            try {
                Set<String> l = j0Var.l();
                String[] strArr = (String[]) l.toArray(new String[l.size()]);
                String[] strArr2 = new String[l.size()];
                Arrays.fill(strArr2, "?");
                String join = TextUtils.join(",", strArr2);
                StringBuilder sb = new StringBuilder();
                sb.append("date(");
                sb.append("ubctime");
                sb.append(") in (");
                sb.append(join);
                sb.append(SmallTailInfo.EMOTION_SUFFIX);
                String sb2 = sb.toString();
                sb.append(" AND ");
                sb.append("date(");
                sb.append("ubctime");
                sb.append(") < date('now')");
                int delete = sQLiteDatabase.delete("arrival", sb.toString(), strArr);
                if (f29992i) {
                    String str = "clearUploadedUBCRecords delete " + delete + " records";
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("state", (Integer) 1);
                int update = sQLiteDatabase.update("arrival", contentValues, sb2, strArr);
                if (f29992i) {
                    String str2 = "clearUploadedUBCRecords update " + update + " records";
                }
            } catch (SQLException e2) {
                if (f29992i) {
                    e2.printStackTrace();
                }
                this.f29995f.h(e2);
            }
        } finally {
            this.f29997h.writeLock().unlock();
        }
    }

    public final void r(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, sQLiteDatabase) == null) {
            try {
                sQLiteDatabase.execSQL("CREATE TABLE arrival (_id INTEGER PRIMARY KEY AUTOINCREMENT,ubcid TEXT,ubctime TEXT DEFAULT CURRENT_DATE,count INTEGER,state INTEGER,reserve1 TEXT);");
            } catch (SQLException e2) {
                if (f29992i) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void s(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, sQLiteDatabase) == null) {
            try {
                sQLiteDatabase.execSQL("CREATE TABLE file (filename TEXT PRIMARY KEY,state TEXT,reserve1 TEXT,reserve2 TEXT);");
            } catch (SQLException e2) {
                if (f29992i) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean t() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            this.f29997h.writeLock().lock();
            try {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    try {
                        i2 = writableDatabase.delete("event", "reallog =?", new String[]{"1"});
                        try {
                            writableDatabase.setTransactionSuccessful();
                        } catch (SQLException e2) {
                            e = e2;
                            if (f29992i) {
                                e.printStackTrace();
                            }
                            this.f29995f.h(e);
                            return i2 > 0;
                        }
                    } catch (SQLException e3) {
                        e = e3;
                        i2 = 0;
                    }
                    return i2 > 0;
                } finally {
                    writableDatabase.endTransaction();
                }
            } catch (SQLException e4) {
                if (f29992i) {
                    e4.printStackTrace();
                }
                this.f29995f.h(e4);
                return false;
            } finally {
                this.f29997h.writeLock().unlock();
            }
        }
        return invokeV.booleanValue;
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            this.f29997h.writeLock().lock();
            try {
                try {
                    SQLiteDatabase writableDatabase = getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                    try {
                        int delete = writableDatabase.delete("file", null, null);
                        if (f29992i) {
                            String str = "deleteAllSentFile#performTransaction: delete file table:" + delete;
                        }
                        writableDatabase.setTransactionSuccessful();
                        writableDatabase.endTransaction();
                    } catch (Throwable th) {
                        writableDatabase.endTransaction();
                        throw th;
                    }
                } catch (SQLException e2) {
                    if (f29992i) {
                        e2.printStackTrace();
                    }
                    this.f29995f.h(e2);
                }
            } finally {
                this.f29997h.writeLock().unlock();
            }
        }
    }

    public boolean w(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048624, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            this.f29997h.writeLock().lock();
            try {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                Cursor cursor = null;
                try {
                    cursor = writableDatabase.rawQuery("SELECT * FROM config WHERE eventid=\"" + str + "\"", null);
                    if (cursor != null && cursor.getCount() != 0) {
                        int delete = writableDatabase.delete("config", "eventid =? ", new String[]{str});
                        writableDatabase.setTransactionSuccessful();
                        return delete > 0;
                    }
                    return true;
                } finally {
                    Closeables.closeSafely(cursor);
                    writableDatabase.endTransaction();
                }
            } catch (SQLException e2) {
                if (f29992i) {
                    e2.printStackTrace();
                }
                this.f29995f.h(e2);
                return false;
            } finally {
                this.f29997h.writeLock().unlock();
            }
        }
        return invokeL.booleanValue;
    }

    public void x(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, str) == null) {
            this.f29997h.writeLock().lock();
            try {
                try {
                    SQLiteDatabase writableDatabase = getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                    try {
                        int delete = writableDatabase.delete("file", "filename=\"" + str + "\"", null);
                        if (f29992i) {
                            String str2 = "deleteSendedFile#performTransaction: delete file table:" + delete;
                        }
                        writableDatabase.setTransactionSuccessful();
                        writableDatabase.endTransaction();
                    } catch (Throwable th) {
                        writableDatabase.endTransaction();
                        throw th;
                    }
                } catch (SQLException e2) {
                    if (f29992i) {
                        e2.printStackTrace();
                    }
                    this.f29995f.h(e2);
                }
            } finally {
                this.f29997h.writeLock().unlock();
            }
        }
    }

    public void y(String str, int i2, long j2, JSONArray jSONArray) {
        SQLiteDatabase writableDatabase;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048626, this, new Object[]{str, Integer.valueOf(i2), Long.valueOf(j2), jSONArray}) == null) {
            if (i2 >= 0 && !TextUtils.isEmpty(str)) {
                this.f29997h.writeLock().lock();
                try {
                    try {
                        writableDatabase = getWritableDatabase();
                        writableDatabase.beginTransactionNonExclusive();
                    } catch (SQLException e2) {
                        if (f29992i) {
                            e2.printStackTrace();
                        }
                        this.f29995f.h(e2);
                    }
                    try {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("state", "2");
                        contentValues.put("endtime", Long.valueOf(j2));
                        if (jSONArray != null && jSONArray.length() > 0) {
                            contentValues.put("slot", jSONArray.toString());
                        }
                        int update = writableDatabase.update("flow", contentValues, "flowid=\"" + str + "\" AND flowhandle = " + i2, null);
                        if (f29992i && update != 1) {
                            String str2 = "endFlow#performTransaction: endFlow count:" + update;
                        }
                        x.f().a(str);
                        writableDatabase.setTransactionSuccessful();
                        writableDatabase.endTransaction();
                        return;
                    } catch (Throwable th) {
                        writableDatabase.endTransaction();
                        throw th;
                    }
                } finally {
                    this.f29997h.writeLock().unlock();
                }
            }
            boolean z = f29992i;
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE, INVOKE]}, finally: {[IGET, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, IF] complete} */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:37:0x00b7 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0095 A[Catch: all -> 0x00bc, TryCatch #6 {all -> 0x00bc, blocks: (B:6:0x0017, B:19:0x0066, B:29:0x007c, B:31:0x0095, B:32:0x00a5, B:28:0x0078, B:38:0x00b8, B:39:0x00bb), top: B:66:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v7, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void z(String str) {
        SQLiteDatabase writableDatabase;
        Throwable th;
        Cursor cursor;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, str) == null) {
            this.f29997h.writeLock().lock();
            int i3 = 0;
            try {
                try {
                    writableDatabase = getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                } catch (SQLException e2) {
                    if (f29992i) {
                        e2.printStackTrace();
                    }
                    this.f29995f.h(e2);
                    this.f29997h.writeLock().unlock();
                    if (0 <= 0) {
                        return;
                    }
                }
                try {
                    ?? sb = new StringBuilder();
                    sb.append("SELECT COUNT(*), MIN(");
                    sb.append("_id");
                    sb.append("), MAX(");
                    sb.append("_id");
                    sb.append(") FROM ");
                    sb.append(str);
                    try {
                        try {
                            cursor = writableDatabase.rawQuery(sb.toString(), null);
                        } catch (Throwable th2) {
                            th = th2;
                            Closeables.closeSafely((Cursor) sb);
                            throw th;
                        }
                    } catch (RuntimeException e3) {
                        e = e3;
                        cursor = null;
                    } catch (Throwable th3) {
                        sb = 0;
                        th = th3;
                        Closeables.closeSafely((Cursor) sb);
                        throw th;
                    }
                    if (cursor != null) {
                        try {
                        } catch (RuntimeException e4) {
                            e = e4;
                            if (f29992i) {
                                e.printStackTrace();
                            }
                            Closeables.closeSafely(cursor);
                            i2 = 0;
                            i3 = writableDatabase.delete(str, "_id < " + i2, null);
                            if (f29992i) {
                            }
                            writableDatabase.setTransactionSuccessful();
                            this.f29997h.writeLock().unlock();
                            if (i3 <= 0) {
                            }
                            b0.a().b(String.valueOf(g.n().k()), i3, str);
                        }
                        if (cursor.getCount() > 0) {
                            cursor.moveToFirst();
                            if (cursor.getInt(0) > g.n().k()) {
                                i2 = (cursor.getInt(1) + cursor.getInt(2)) / 2;
                                Closeables.closeSafely(cursor);
                                i3 = writableDatabase.delete(str, "_id < " + i2, null);
                                if (f29992i) {
                                    String str2 = "ensureDataBaseLimit#performTransaction: delete count:" + i3;
                                }
                                writableDatabase.setTransactionSuccessful();
                                this.f29997h.writeLock().unlock();
                                if (i3 <= 0) {
                                    return;
                                }
                                b0.a().b(String.valueOf(g.n().k()), i3, str);
                            }
                        }
                    }
                    i2 = 0;
                    Closeables.closeSafely(cursor);
                    i3 = writableDatabase.delete(str, "_id < " + i2, null);
                    if (f29992i) {
                    }
                    writableDatabase.setTransactionSuccessful();
                    this.f29997h.writeLock().unlock();
                    if (i3 <= 0) {
                    }
                    b0.a().b(String.valueOf(g.n().k()), i3, str);
                } finally {
                    writableDatabase.endTransaction();
                }
            } catch (Throwable th4) {
                this.f29997h.writeLock().unlock();
                if (0 > 0) {
                    b0.a().b(String.valueOf(g.n().k()), 0, str);
                }
                throw th4;
            }
        }
    }
}

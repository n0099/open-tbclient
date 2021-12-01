package c.a.t0;

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
import c.a.t0.i0;
import c.a.t0.x;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteKey;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.searchbox.logsystem.basic.upload.Constant;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.searchbox.updateprocessor.UpdateCloudControlProcessor;
import com.baidu.tbadk.core.data.SmallTailInfo;
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
/* loaded from: classes7.dex */
public class z extends SQLiteOpenHelper {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f26471h;

    /* renamed from: i  reason: collision with root package name */
    public static z f26472i;

    /* renamed from: j  reason: collision with root package name */
    public static ReentrantLock f26473j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public b f26474e;

    /* renamed from: f  reason: collision with root package name */
    public Context f26475f;

    /* renamed from: g  reason: collision with root package name */
    public ReentrantReadWriteLock f26476g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1350905870, "Lc/a/t0/z;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1350905870, "Lc/a/t0/z;");
                return;
            }
        }
        f26471h = b0.m();
        f26472i = null;
        f26473j = new ReentrantLock();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(Context context) {
        super(context, "bdbehavior.db", (SQLiteDatabase.CursorFactory) null, 9);
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
        this.f26476g = new ReentrantReadWriteLock(true);
        this.f26474e = new b(context);
        this.f26475f = context;
    }

    public static z N(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f26472i == null) {
                f26473j.lock();
                if (f26472i == null) {
                    f26472i = new z(context);
                }
                f26473j.unlock();
            }
            return f26472i;
        }
        return (z) invokeL.objValue;
    }

    public final String A(boolean z, boolean z2, boolean z3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT a.* FROM ");
            if (z) {
                sb.append("event");
                sb.append(" a ");
                sb.append("LEFT JOIN ");
                sb.append(UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME);
                sb.append(" b ");
                sb.append("ON a.");
                sb.append("eventid");
                sb.append(" = b.");
                sb.append("eventid");
                sb.append(" WHERE ");
                sb.append("a.");
                sb.append("flowhandle");
                sb.append(" = ");
                sb.append(-1);
                sb.append(" AND ");
                sb.append("(a.");
                sb.append("reallog");
                sb.append(" = '0' OR a.");
                sb.append("reallog");
                sb.append(" = '')");
            } else {
                sb.append("flow");
                sb.append(" a ");
                sb.append("LEFT JOIN ");
                sb.append(UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME);
                sb.append(" b ");
                sb.append("ON a.");
                sb.append("flowid");
                sb.append(" = b.");
                sb.append("eventid");
                sb.append(" WHERE ");
                sb.append("a.");
                sb.append("endtime");
                sb.append(" IS NOT NULL");
            }
            if (z3) {
                sb.append(" AND (b.");
                sb.append("switch");
                sb.append(" IS NULL OR b.");
                sb.append("switch");
                sb.append(" = '");
                sb.append("1");
                sb.append("')");
            } else {
                sb.append(" AND b.");
                sb.append("switch");
                sb.append(" = '");
                sb.append("1");
                sb.append("'");
            }
            if (z2) {
                sb.append(" AND ");
                sb.append("(b.");
                sb.append("cycle");
                sb.append(" = 0)");
                sb.append(" ORDER BY a.");
                sb.append("begintime");
                sb.append(" DESC");
            } else {
                sb.append(" AND ");
                sb.append("(b.");
                sb.append("cycle");
                sb.append(" > 0)");
                sb.append(" ORDER BY a.");
                sb.append("begintime");
                sb.append(" ASC");
            }
            return sb.toString();
        }
        return (String) invokeCommon.objValue;
    }

    public int B(l0 l0Var, l0 l0Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, l0Var, l0Var2)) == null) {
            int D = D(l0Var, l0Var2);
            if (l0Var.z() && l0Var2.z()) {
                return 1;
            }
            if (l0Var.w() && l0Var2.w()) {
                return 0;
            }
            return C(l0Var, l0Var2) | D;
        }
        return invokeLL.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:134:0x0162 A[EDGE_INSN: B:134:0x0162->B:88:0x0162 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0164 A[LOOP:0: B:129:0x0055->B:89:0x0164, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int C(l0 l0Var, l0 l0Var2) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, l0Var, l0Var2)) == null) {
            this.f26476g.readLock().lock();
            int i2 = 0;
            try {
                try {
                    boolean z2 = l0Var.z();
                    boolean z3 = l0Var2.z();
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
                                while (true) {
                                    try {
                                        String string = cursor.getString(columnIndex);
                                        if (!TextUtils.isEmpty(string)) {
                                            n nVar = new n(string);
                                            boolean e2 = g.o().e(string);
                                            if (z2 && z3) {
                                                break;
                                            } else if ((!z2 || !e2) && (!z3 || e2)) {
                                                try {
                                                    if (l0Var.w() && l0Var2.w()) {
                                                        c.a.t0.q0.a.a(cursor);
                                                        return i2;
                                                    } else if ((!e2 || !l0Var.w()) && (!e2 || !l0Var2.w())) {
                                                        z = z2;
                                                        nVar.B(cursor.getLong(columnIndex2));
                                                        String string2 = cursor.getString(columnIndex3);
                                                        if (!TextUtils.isEmpty(string2)) {
                                                            nVar.t(string2);
                                                        }
                                                        String string3 = cursor.getString(columnIndex4);
                                                        if (!TextUtils.isEmpty(string3)) {
                                                            nVar.w(string3);
                                                        }
                                                        String string4 = cursor.getString(columnIndex5);
                                                        if (!TextUtils.isEmpty(string4)) {
                                                            nVar.s(string4);
                                                        }
                                                        String string5 = cursor.getString(columnIndex6);
                                                        if (!TextUtils.isEmpty(string5)) {
                                                            JSONObject jSONObject = new JSONObject(string5);
                                                            if (jSONObject.has("ctr")) {
                                                                nVar.u(true);
                                                            }
                                                            if (jSONObject.has("bizInfo")) {
                                                                nVar.r(jSONObject.optString("bizInfo"));
                                                            }
                                                        }
                                                        int g2 = nVar.g();
                                                        if (e2) {
                                                            if (d(nVar, g2, l0Var)) {
                                                                if (l0Var.z()) {
                                                                    z = true;
                                                                }
                                                                if (i3 == 0) {
                                                                    i3 = 1;
                                                                }
                                                                if (!l0Var.w() && l0Var2.w()) {
                                                                    c.a.t0.q0.a.a(cursor);
                                                                    this.f26476g.readLock().unlock();
                                                                    return 0;
                                                                }
                                                                i2 = 0;
                                                                if (z && z3) {
                                                                    break;
                                                                }
                                                                if (!cursor.moveToNext()) {
                                                                }
                                                            } else {
                                                                i2 = 0;
                                                                if (!cursor.moveToNext()) {
                                                                    break;
                                                                }
                                                                z2 = z;
                                                            }
                                                        } else {
                                                            if (d(nVar, g2, l0Var2)) {
                                                                if (l0Var2.z()) {
                                                                    z3 = true;
                                                                }
                                                                if (i3 == 0) {
                                                                }
                                                                if (!l0Var.w()) {
                                                                }
                                                                i2 = 0;
                                                                if (z) {
                                                                    break;
                                                                    break;
                                                                }
                                                                if (!cursor.moveToNext()) {
                                                                }
                                                            }
                                                            i2 = 0;
                                                            if (!cursor.moveToNext()) {
                                                            }
                                                        }
                                                    }
                                                } catch (SQLException e3) {
                                                    e = e3;
                                                    i2 = i3;
                                                    if (f26471h) {
                                                        e.printStackTrace();
                                                    }
                                                    this.f26474e.h(e);
                                                    return i2;
                                                }
                                            }
                                        }
                                        z = z2;
                                        i2 = 0;
                                        if (!cursor.moveToNext()) {
                                        }
                                    } catch (RuntimeException e4) {
                                        e = e4;
                                        i2 = i3;
                                        if (f26471h) {
                                            e.printStackTrace();
                                        }
                                        c.a.t0.q0.a.a(cursor);
                                        return i2;
                                    } catch (JSONException unused) {
                                        i2 = i3;
                                        boolean z4 = f26471h;
                                        c.a.t0.q0.a.a(cursor);
                                        return i2;
                                    } catch (Throwable th) {
                                        th = th;
                                        i2 = i3;
                                        c.a.t0.q0.a.a(cursor);
                                        throw th;
                                    }
                                }
                                i2 = i3;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (RuntimeException e5) {
                        e = e5;
                    } catch (JSONException unused2) {
                    }
                    c.a.t0.q0.a.a(cursor);
                } catch (SQLException e6) {
                    e = e6;
                }
                return i2;
            } finally {
                this.f26476g.readLock().unlock();
            }
        }
        return invokeLL.intValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:102:0x01f5 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:114:0x0216 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:129:0x0231 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:179:0x0204 */
    /* JADX WARN: Can't wrap try/catch for region: R(8:(2:14|15)|(2:47|(2:49|(7:(8:60|(1:(18:83|84|85|(1:87)|88|(1:90)|91|(1:93)|94|(1:98)|99|100|(5:133|134|(1:136)|137|(1:139))|102|(3:104|105|(6:107|22|23|24|25|(1:28)(1:27))(3:108|(1:110)|111))(6:128|(2:130|(1:132))|23|24|25|(0)(0))|(1:113)|114|(5:124|(1:127)|24|25|(0)(0))(4:118|119|120|121)))(4:64|65|66|67)|71|72|(1:74)|75|31|32)|56|22|23|24|25|(0)(0))(2:52|53)))|21|22|23|24|25|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0214, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0216, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x0240, code lost:
        r0.printStackTrace();
        r3 = r3;
        r6 = r6;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0207 A[LOOP:0: B:172:0x0077->B:111:0x0207, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0240 A[Catch: all -> 0x0244, TRY_LEAVE, TryCatch #4 {all -> 0x0244, blocks: (B:135:0x023c, B:137:0x0240), top: B:161:0x023c }] */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0204 A[EDGE_INSN: B:177:0x0204->B:110:0x0204 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r18v6 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v4, types: [int] */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v26 */
    /* JADX WARN: Type inference failed for: r6v27 */
    /* JADX WARN: Type inference failed for: r6v3, types: [c.a.t0.z] */
    /* JADX WARN: Type inference failed for: r6v5, types: [android.database.sqlite.SQLiteDatabase] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int D(l0 l0Var, l0 l0Var2) {
        InterceptResult invokeLL;
        z zVar;
        z zVar2;
        ?? r3;
        boolean z;
        boolean z2;
        Cursor cursor;
        z zVar3;
        boolean z3;
        z zVar4;
        boolean z4;
        SQLiteDatabase sQLiteDatabase;
        int i2;
        int i3;
        String str;
        SQLiteDatabase sQLiteDatabase2;
        z zVar5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, l0Var, l0Var2)) == null) {
            z zVar6 = this;
            String str2 = "bizInfo";
            ReentrantReadWriteLock.ReadLock readLock = zVar6.f26476g.readLock();
            readLock.lock();
            try {
                try {
                    try {
                        z = l0Var.z();
                        z2 = l0Var2.z();
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
                            zVar3 = zVar6;
                            z3 = false;
                        } catch (Throwable th) {
                            th = th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        r6.f26476g.readLock().unlock();
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    z zVar7 = zVar6;
                    zVar7.f26476g.readLock().unlock();
                    throw th;
                }
            } catch (SQLException e4) {
                e = e4;
                zVar = zVar6;
                readLock = null;
            }
            if (cursor == null || cursor.getCount() <= 0) {
                zVar4 = zVar6;
                z4 = false;
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
                boolean z5 = z;
                int columnIndex10 = cursor.getColumnIndex("slot");
                boolean z6 = z2;
                int columnIndex11 = cursor.getColumnIndex("extend");
                boolean z7 = false;
                SQLiteDatabase sQLiteDatabase3 = zVar;
                while (true) {
                    try {
                        sQLiteDatabase = sQLiteDatabase3;
                    } catch (RuntimeException e5) {
                        e = e5;
                        zVar = zVar6;
                    } catch (Throwable th4) {
                        th = th4;
                    }
                    if ("2".equals(cursor.getString(columnIndex3)) || (Math.abs(cursor.getLong(columnIndex4) - System.currentTimeMillis()) > 86400000 && (cursor.getInt(columnIndex7) & 4) != 0)) {
                        String string = cursor.getString(columnIndex);
                        int i4 = cursor.getInt(columnIndex2);
                        if (i4 >= 0) {
                            i2 = columnIndex2;
                            boolean e6 = g.o().e(string);
                            if (z5 && z6) {
                                zVar = zVar6;
                                break;
                            }
                            if ((!z5 || !e6) && (!z6 || e6)) {
                                if (l0Var.w() && l0Var2.w()) {
                                    try {
                                        c.a.t0.q0.a.a(cursor);
                                        zVar6.f26476g.readLock().unlock();
                                        return 0;
                                    } catch (SQLException e7) {
                                        e = e7;
                                        zVar = zVar6;
                                    }
                                } else if ((!e6 || !l0Var.w()) && (!e6 || !l0Var2.w())) {
                                    i3 = columnIndex3;
                                    p pVar = new p();
                                    pVar.A(cursor.getString(columnIndex));
                                    pVar.z(i4);
                                    try {
                                        pVar.q(cursor.getLong(columnIndex4));
                                        pVar.v(cursor.getLong(columnIndex5));
                                        String string2 = cursor.getString(columnIndex6);
                                        if (!TextUtils.isEmpty(string2)) {
                                            pVar.t(string2);
                                        }
                                        String string3 = cursor.getString(columnIndex8);
                                        if (!TextUtils.isEmpty(string3)) {
                                            pVar.y(string3);
                                        }
                                        if (!TextUtils.isEmpty(cursor.getString(columnIndex9))) {
                                            pVar.s(cursor.getString(columnIndex9));
                                        }
                                        String string4 = cursor.getString(columnIndex10);
                                        if (columnIndex10 >= 0 && !TextUtils.isEmpty(string4)) {
                                            pVar.B(string4);
                                        }
                                        if (!TextUtils.isEmpty(cursor.getString(columnIndex11))) {
                                            try {
                                                JSONObject jSONObject = new JSONObject(cursor.getString(columnIndex11));
                                                if (jSONObject.has("ctr")) {
                                                    pVar.u(true);
                                                }
                                                if (jSONObject.has(str2)) {
                                                    pVar.r(jSONObject.optString(str2));
                                                }
                                            } catch (JSONException e8) {
                                                e8.printStackTrace();
                                            }
                                        }
                                        int h2 = pVar.h();
                                        if (e6) {
                                            zVar = this;
                                            sQLiteDatabase2 = sQLiteDatabase;
                                            if (zVar.g(sQLiteDatabase2, pVar, h2, l0Var)) {
                                                str = str2;
                                                if (l0Var.z()) {
                                                    z5 = true;
                                                }
                                            } else {
                                                str = str2;
                                                zVar5 = zVar;
                                                zVar = zVar5;
                                                if (!cursor.moveToNext()) {
                                                    break;
                                                }
                                                columnIndex2 = i2;
                                                columnIndex3 = i3;
                                                str2 = str;
                                                z zVar8 = zVar;
                                                sQLiteDatabase3 = sQLiteDatabase2;
                                                zVar6 = zVar8;
                                            }
                                        } else {
                                            zVar = this;
                                            str = str2;
                                            sQLiteDatabase2 = sQLiteDatabase;
                                            boolean g2 = zVar.g(sQLiteDatabase2, pVar, h2, l0Var2);
                                            zVar5 = zVar;
                                            if (g2) {
                                                if (l0Var2.z()) {
                                                    z6 = true;
                                                }
                                            }
                                            zVar = zVar5;
                                            if (!cursor.moveToNext()) {
                                            }
                                        }
                                        if (!z7) {
                                            z7 = true;
                                        }
                                        if (l0Var.w() && l0Var2.w()) {
                                            try {
                                                c.a.t0.q0.a.a(cursor);
                                                zVar.f26476g.readLock().unlock();
                                                return 0;
                                            } catch (SQLException e9) {
                                                e = e9;
                                            }
                                        } else {
                                            zVar = zVar;
                                            zVar = zVar;
                                            if (z5 && z6) {
                                                break;
                                            }
                                            if (!cursor.moveToNext()) {
                                            }
                                        }
                                    } catch (RuntimeException e10) {
                                        e = e10;
                                        zVar = this;
                                        z3 = z7;
                                        zVar3 = zVar;
                                        try {
                                            z4 = z3;
                                            zVar4 = zVar3;
                                            if (f26471h) {
                                            }
                                            c.a.t0.q0.a.a(cursor);
                                            r3 = z4;
                                            zVar2 = zVar4;
                                            zVar2.f26476g.readLock().unlock();
                                            return r3;
                                        } catch (Throwable th5) {
                                            th = th5;
                                            c.a.t0.q0.a.a(cursor);
                                            throw th;
                                        }
                                    } catch (Throwable th6) {
                                        th = th6;
                                        c.a.t0.q0.a.a(cursor);
                                        throw th;
                                    }
                                }
                                readLock = z7;
                                if (f26471h) {
                                    e.printStackTrace();
                                }
                                zVar.f26474e.h(e);
                                r3 = readLock;
                                zVar2 = zVar;
                                zVar2.f26476g.readLock().unlock();
                                return r3;
                            }
                            zVar = zVar6;
                            str = str2;
                            i3 = columnIndex3;
                            sQLiteDatabase2 = sQLiteDatabase;
                            zVar5 = zVar;
                            zVar = zVar5;
                            if (!cursor.moveToNext()) {
                            }
                        }
                    }
                    zVar = zVar6;
                    str = str2;
                    i2 = columnIndex2;
                    i3 = columnIndex3;
                    sQLiteDatabase2 = sQLiteDatabase;
                    zVar5 = zVar;
                    zVar = zVar5;
                    if (!cursor.moveToNext()) {
                    }
                }
                z4 = z7;
                zVar4 = zVar;
            }
            c.a.t0.q0.a.a(cursor);
            r3 = z4;
            zVar2 = zVar4;
            zVar2.f26476g.readLock().unlock();
            return r3;
        }
        return invokeLL.intValue;
    }

    public HashMap<String, String> E(ArrayList<String> arrayList) {
        InterceptResult invokeL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, arrayList)) == null) {
            this.f26476g.readLock().lock();
            HashMap<String, String> hashMap = new HashMap<>();
            String M = M(arrayList);
            try {
                try {
                    cursor = null;
                } catch (SQLException e2) {
                    if (f26471h) {
                        e2.printStackTrace();
                    }
                }
                try {
                    try {
                        cursor = getReadableDatabase().rawQuery("SELECT eventid,extend FROM " + UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME + " WHERE eventid in (" + M + SmallTailInfo.EMOTION_SUFFIX, null);
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
                        if (f26471h) {
                            e3.printStackTrace();
                        }
                    }
                    return hashMap;
                } finally {
                    c.a.t0.q0.a.a(cursor);
                }
            } finally {
                this.f26476g.readLock().unlock();
            }
        }
        return (HashMap) invokeL.objValue;
    }

    public j F(String str) {
        InterceptResult invokeL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            this.f26476g.readLock().lock();
            try {
                try {
                    try {
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        cursor = getReadableDatabase().rawQuery(String.format("SELECT * FROM %s where eventid = \"%s\"", UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME, str), null);
                        if (cursor != null) {
                            try {
                                if (cursor.getCount() > 0) {
                                    cursor.moveToFirst();
                                    String string = cursor.getString(cursor.getColumnIndex("eventid"));
                                    boolean equals = TextUtils.equals(cursor.getString(cursor.getColumnIndex("switch")), "1");
                                    int i2 = cursor.getInt(cursor.getColumnIndex("cycle"));
                                    j jVar = new j(string, equals, i2 == 0, i2, TextUtils.equals("1", cursor.getString(cursor.getColumnIndex("type"))) ? 1 : 0, TextUtils.equals(cursor.getString(cursor.getColumnIndex("reserve1")), "1"));
                                    String string2 = cursor.getString(cursor.getColumnIndex("extend"));
                                    if (!TextUtils.isEmpty(string2)) {
                                        try {
                                            JSONObject jSONObject = new JSONObject(string2);
                                            String optString = jSONObject.optString("dfc");
                                            if (!TextUtils.isEmpty(optString)) {
                                                jVar.x(TextUtils.equals(optString, "1"));
                                            }
                                            String optString2 = jSONObject.optString("version");
                                            if (!TextUtils.isEmpty(optString2)) {
                                                jVar.G(optString2);
                                            }
                                            if (jSONObject.has("uploadType")) {
                                                jVar.F(jSONObject.optInt("uploadType", -1));
                                            }
                                            int optInt = jSONObject.optInt("lcache", 2);
                                            if (optInt == 1 || optInt == 0) {
                                                jVar.B(optInt);
                                            }
                                            if (m.a(string) && jSONObject.has("isSend")) {
                                                jVar.y(jSONObject.optBoolean("isSend", true));
                                            }
                                        } catch (JSONException e2) {
                                            if (f26471h) {
                                                e2.printStackTrace();
                                            }
                                        }
                                    }
                                    jVar.E(TextUtils.equals(cursor.getString(cursor.getColumnIndex("reallog")), "1"));
                                    c.a.t0.q0.a.a(cursor);
                                    return jVar;
                                }
                            } catch (RuntimeException e3) {
                                e = e3;
                                if (f26471h) {
                                    e.printStackTrace();
                                }
                                c.a.t0.q0.a.a(cursor);
                                return null;
                            }
                        }
                    } catch (RuntimeException e4) {
                        e = e4;
                        cursor = null;
                    } catch (Throwable th2) {
                        th = th2;
                        c.a.t0.q0.a.a(null);
                        throw th;
                    }
                    c.a.t0.q0.a.a(cursor);
                } catch (SQLException e5) {
                    if (f26471h) {
                        e5.printStackTrace();
                    }
                    this.f26474e.h(e5);
                }
                return null;
            } finally {
                this.f26476g.readLock().unlock();
            }
        }
        return (j) invokeL.objValue;
    }

    public int G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            this.f26476g.readLock().lock();
            int i2 = 0;
            try {
                try {
                    SQLiteDatabase readableDatabase = getReadableDatabase();
                    Cursor cursor = null;
                    try {
                        try {
                            cursor = readableDatabase.rawQuery("SELECT COUNT(eventid) FROM " + UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME, null);
                            if (cursor != null) {
                                cursor.moveToFirst();
                                i2 = cursor.getInt(0);
                            }
                        } catch (SQLException e2) {
                            if (f26471h) {
                                e2.printStackTrace();
                            }
                        }
                    } finally {
                        c.a.t0.q0.a.a(cursor);
                    }
                } finally {
                    this.f26476g.readLock().unlock();
                }
            } catch (SQLException e3) {
                if (f26471h) {
                    e3.printStackTrace();
                }
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public int H(ArrayList<String> arrayList, boolean z, l0 l0Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{arrayList, Boolean.valueOf(z), l0Var})) == null) {
            String M = M(arrayList);
            String str = z ? " in  (" : " not in (";
            if (TextUtils.isEmpty(M) && z) {
                return 0;
            }
            StringBuilder sb = new StringBuilder(256);
            if (!z && TextUtils.isEmpty(M)) {
                sb.append("SELECT * FROM ");
                sb.append("flow");
            } else {
                sb.append("SELECT * ");
                sb.append(" FROM ");
                sb.append("flow");
                sb.append(" WHERE ");
                sb.append("flowid");
                sb.append(str);
                sb.append(M);
                sb.append(SmallTailInfo.EMOTION_SUFFIX);
            }
            int L = L(sb.toString(), l0Var);
            if (l0Var.w()) {
                return 0;
            }
            StringBuilder sb2 = new StringBuilder(256);
            if (!z && TextUtils.isEmpty(M)) {
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
                sb2.append(M);
                sb2.append(SmallTailInfo.EMOTION_SUFFIX);
                sb2.append(" AND ");
                sb2.append("flowhandle");
                sb2.append(" = ");
                sb2.append(-1);
                sb2.append(" AND ");
                sb2.append("reallog");
                sb2.append(" = \"0\"");
            }
            return I(sb2.toString(), l0Var) | L;
        }
        return invokeCommon.intValue;
    }

    public final int I(String str, l0 l0Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, l0Var)) == null) {
            this.f26476g.readLock().lock();
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
                                        nVar.B(cursor.getLong(columnIndex2));
                                        String string2 = cursor.getString(columnIndex3);
                                        if (!TextUtils.isEmpty(string2)) {
                                            nVar.t(string2);
                                        }
                                        String string3 = cursor.getString(columnIndex4);
                                        if (!TextUtils.isEmpty(string3)) {
                                            nVar.w(string3);
                                        }
                                        if (!TextUtils.isEmpty(cursor.getString(columnIndex5))) {
                                            nVar.s(cursor.getString(columnIndex5));
                                        }
                                        if (!TextUtils.isEmpty(cursor.getString(columnIndex6))) {
                                            JSONObject jSONObject = new JSONObject(cursor.getString(columnIndex6));
                                            if (jSONObject.has("ctr")) {
                                                nVar.u(true);
                                            }
                                            if (jSONObject.has(SpeedStatsUtils.UBC_KEY_OPTION)) {
                                                nVar.z(jSONObject.optInt(SpeedStatsUtils.UBC_KEY_OPTION, 0));
                                            }
                                            if (jSONObject.has("bizInfo")) {
                                                nVar.r(jSONObject.optString("bizInfo"));
                                            }
                                        }
                                        if (!d(nVar, nVar.g(), l0Var)) {
                                            break;
                                        } else if (l0Var.z()) {
                                            break;
                                        }
                                    }
                                } while (cursor.moveToNext());
                                i2 = 1;
                            }
                        } finally {
                            c.a.t0.q0.a.a(cursor);
                        }
                    } catch (RuntimeException e2) {
                        if (f26471h) {
                            e2.printStackTrace();
                        }
                    } catch (JSONException unused) {
                        boolean z = f26471h;
                    }
                } catch (SQLException e3) {
                    if (f26471h) {
                        e3.printStackTrace();
                    }
                    this.f26474e.h(e3);
                }
                return i2;
            } finally {
                this.f26476g.readLock().unlock();
            }
        }
        return invokeLL.intValue;
    }

    public final ContentValues J(n nVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, nVar)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("flowhandle", Integer.valueOf(nVar.j()));
            contentValues.put("eventid", nVar.l());
            contentValues.put("begintime", Long.valueOf(nVar.p()));
            if (!TextUtils.isEmpty(nVar.f())) {
                contentValues.put("content", nVar.f());
            } else if (nVar.m() != null && !TextUtils.isEmpty(nVar.m().toString())) {
                contentValues.put("content", nVar.m().toString());
            }
            if (!TextUtils.isEmpty(nVar.h())) {
                contentValues.put("reserve1", nVar.h());
            }
            if (!TextUtils.isEmpty(nVar.e())) {
                contentValues.put("reserve2", nVar.e());
            }
            JSONObject jSONObject = new JSONObject();
            boolean z = true;
            try {
                boolean z2 = false;
                if (nVar.q()) {
                    jSONObject.put("ctr", "1");
                    z = false;
                }
                if ((nVar.n() & 128) != 0) {
                    jSONObject.put(SpeedStatsUtils.UBC_KEY_OPTION, nVar.n());
                    z = false;
                }
                String c2 = nVar.c();
                if (TextUtils.isEmpty(c2)) {
                    z2 = z;
                } else {
                    jSONObject.put("bizInfo", c2);
                }
                if (!z2) {
                    contentValues.put("extend", jSONObject.toString());
                }
            } catch (JSONException e2) {
                if (f26471h) {
                    e2.printStackTrace();
                }
            }
            if (!TextUtils.isEmpty(nVar.o())) {
                contentValues.put("reallog", nVar.o());
            } else {
                contentValues.put("reallog", "0");
            }
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    public final String K(l0 l0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, l0Var)) == null) {
            if (l0Var == null || !l0Var.x()) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ubc_data_backend_type", "1");
                return jSONObject.toString();
            } catch (JSONException e2) {
                if (f26471h) {
                    e2.printStackTrace();
                    return null;
                }
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:121:0x0142 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0150 A[EDGE_INSN: B:123:0x0150->B:62:0x0150 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0143 A[Catch: RuntimeException -> 0x0159, all -> 0x017c, TryCatch #10 {all -> 0x017c, blocks: (B:60:0x014a, B:54:0x013c, B:57:0x0143, B:79:0x0170, B:81:0x0174), top: B:113:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0152 A[LOOP:0: B:12:0x0069->B:63:0x0152, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x018d A[Catch: all -> 0x019f, TryCatch #12 {all -> 0x019f, blocks: (B:71:0x0165, B:93:0x0189, B:95:0x018d, B:96:0x0190, B:82:0x0177, B:84:0x017d, B:85:0x0180), top: B:116:0x0011 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int L(String str, l0 l0Var) {
        InterceptResult invokeLL;
        z zVar;
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, str, l0Var)) == null) {
            this.f26476g.readLock().lock();
            try {
                try {
                    SQLiteDatabase readableDatabase = getReadableDatabase();
                    Cursor cursor = null;
                    try {
                        try {
                            try {
                                cursor = readableDatabase.rawQuery(str, null);
                                if (cursor == null || cursor.getCount() <= 0) {
                                    zVar = this;
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
                                        try {
                                            if (!"2".equals(cursor.getString(columnIndex3)) && (Math.abs(cursor.getLong(columnIndex4) - System.currentTimeMillis()) <= 86400000 || (cursor.getInt(columnIndex7) & 4) == 0)) {
                                                i3 = columnIndex;
                                                i4 = columnIndex2;
                                                zVar = this;
                                                try {
                                                    if (cursor.moveToNext()) {
                                                        break;
                                                    }
                                                    columnIndex = i3;
                                                    columnIndex2 = i4;
                                                } catch (RuntimeException e2) {
                                                    e = e2;
                                                    if (f26471h) {
                                                        e.printStackTrace();
                                                    }
                                                    c.a.t0.q0.a.a(cursor);
                                                    i2 = 0;
                                                    zVar.f26476g.readLock().unlock();
                                                    return i2;
                                                }
                                            }
                                            p pVar = new p();
                                            pVar.A(cursor.getString(columnIndex));
                                            pVar.z(cursor.getInt(columnIndex2));
                                            i3 = columnIndex;
                                            i4 = columnIndex2;
                                            pVar.q(cursor.getLong(columnIndex4));
                                            pVar.v(cursor.getLong(columnIndex5));
                                            String string = cursor.getString(columnIndex6);
                                            if (!TextUtils.isEmpty(string)) {
                                                pVar.t(string);
                                            }
                                            String string2 = cursor.getString(columnIndex8);
                                            if (!TextUtils.isEmpty(string2)) {
                                                pVar.y(string2);
                                            }
                                            if (!TextUtils.isEmpty(cursor.getString(columnIndex9))) {
                                                pVar.s(cursor.getString(columnIndex9));
                                            }
                                            String string3 = cursor.getString(columnIndex10);
                                            if (columnIndex10 >= 0 && !TextUtils.isEmpty(string3)) {
                                                pVar.B(string3);
                                            }
                                            if (!TextUtils.isEmpty(cursor.getString(columnIndex11))) {
                                                try {
                                                    JSONObject jSONObject = new JSONObject(cursor.getString(columnIndex11));
                                                    if (jSONObject.has("ctr")) {
                                                        try {
                                                            pVar.u(true);
                                                        } catch (JSONException e3) {
                                                            e = e3;
                                                            e.printStackTrace();
                                                            zVar = this;
                                                            if (!zVar.g(readableDatabase, pVar, pVar.h(), l0Var)) {
                                                            }
                                                            i2 = 1;
                                                            c.a.t0.q0.a.a(cursor);
                                                            zVar.f26476g.readLock().unlock();
                                                            return i2;
                                                        }
                                                    }
                                                    if (jSONObject.has("bizInfo")) {
                                                        pVar.r(jSONObject.optString("bizInfo"));
                                                    }
                                                } catch (JSONException e4) {
                                                    e = e4;
                                                }
                                            }
                                            zVar = this;
                                            if (!zVar.g(readableDatabase, pVar, pVar.h(), l0Var)) {
                                                break;
                                            }
                                            if (!l0Var.z()) {
                                                break;
                                            }
                                            if (cursor.moveToNext()) {
                                            }
                                        } catch (RuntimeException e5) {
                                            e = e5;
                                            zVar = this;
                                        } catch (Throwable th) {
                                            th = th;
                                            c.a.t0.q0.a.a(cursor);
                                            throw th;
                                        }
                                    }
                                    i2 = 1;
                                }
                            } catch (SQLException e6) {
                                e = e6;
                                i2 = 0;
                                if (f26471h) {
                                    e.printStackTrace();
                                }
                                zVar.f26474e.h(e);
                                zVar.f26476g.readLock().unlock();
                                return i2;
                            }
                            try {
                                c.a.t0.q0.a.a(cursor);
                            } catch (SQLException e7) {
                                e = e7;
                                if (f26471h) {
                                }
                                zVar.f26474e.h(e);
                                zVar.f26476g.readLock().unlock();
                                return i2;
                            }
                        } catch (RuntimeException e8) {
                            e = e8;
                            zVar = this;
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    this.f26476g.readLock().unlock();
                    throw th;
                }
            } catch (SQLException e9) {
                e = e9;
                zVar = this;
            } catch (Throwable th5) {
                th = th5;
                this.f26476g.readLock().unlock();
                throw th;
            }
            zVar.f26476g.readLock().unlock();
            return i2;
        }
        return invokeLL.intValue;
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
                sb.append("'");
                sb.append(arrayList.get(i2));
                sb.append("'");
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:103:0x0203 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:115:0x0222 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:39:0x0116 */
    /* JADX DEBUG: Multi-variable search result rejected for r3v7, resolved type: c.a.t0.z */
    /* JADX DEBUG: Multi-variable search result rejected for r3v8, resolved type: c.a.t0.z */
    /* JADX WARN: Can't wrap try/catch for region: R(18:3|(12:4|5|6|7|8|9|10|(9:102|103|104|105|106|107|108|109|110)(6:12|13|14|15|16|17)|18|19|20|21)|(3:70|71|(18:73|74|75|76|24|25|26|27|(1:29)(1:55)|30|31|32|33|(1:37)|39|40|41|42))|23|24|25|26|27|(0)(0)|30|31|32|33|(2:35|37)|39|40|41|42) */
    /* JADX WARN: Can't wrap try/catch for region: R(29:3|4|5|6|7|8|9|10|(9:102|103|104|105|106|107|108|109|110)(6:12|13|14|15|16|17)|18|19|20|21|(3:70|71|(18:73|74|75|76|24|25|26|27|(1:29)(1:55)|30|31|32|33|(1:37)|39|40|41|42))|23|24|25|26|27|(0)(0)|30|31|32|33|(2:35|37)|39|40|41|42) */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x020e, code lost:
        if (c.a.t0.z.f26471h != false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0210, code lost:
        r0.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0213, code lost:
        r3.f26474e.h(r0);
        r1 = r1;
        r3 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0223, code lost:
        r3.f26476g.readLock().unlock();
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x022c, code lost:
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01d8, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01d9, code lost:
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01dd, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x01de, code lost:
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01f2, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01f3, code lost:
        r3 = r24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01f6, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01f7, code lost:
        r3 = r24;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:65:0x014c A[Catch: all -> 0x01fa, TRY_LEAVE, TryCatch #23 {all -> 0x01fa, blocks: (B:37:0x0113, B:63:0x0148, B:65:0x014c), top: B:124:0x0113 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x018d A[Catch: all -> 0x01d8, RuntimeException -> 0x01dd, TryCatch #22 {RuntimeException -> 0x01dd, all -> 0x01d8, blocks: (B:67:0x0150, B:69:0x018d, B:71:0x01ba, B:70:0x01a7), top: B:148:0x0150 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01a7 A[Catch: all -> 0x01d8, RuntimeException -> 0x01dd, TryCatch #22 {RuntimeException -> 0x01dd, all -> 0x01d8, blocks: (B:67:0x0150, B:69:0x018d, B:71:0x01ba, B:70:0x01a7), top: B:148:0x0150 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01c5 A[Catch: RuntimeException -> 0x01d6, all -> 0x01ec, TryCatch #0 {RuntimeException -> 0x01d6, blocks: (B:73:0x01bf, B:75:0x01c5, B:77:0x01cb), top: B:122:0x01bf }] */
    /* JADX WARN: Type inference failed for: r1v12, types: [c.a.t0.i0$d] */
    /* JADX WARN: Type inference failed for: r1v2, types: [c.a.t0.z] */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public i0.d O() {
        InterceptResult invokeV;
        SQLiteDatabase readableDatabase;
        String str;
        Cursor cursor;
        String str2;
        i0.d dVar;
        String str3;
        Cursor cursor2;
        Cursor cursor3;
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048589, this)) != null) {
            return (i0.d) invokeV.objValue;
        }
        ?? r1 = this;
        String str5 = "'";
        String str6 = " AND b.";
        String str7 = "')";
        i0.d dVar2 = new i0.d();
        boolean H = g.o().H();
        z readLock = r1.f26476g.readLock();
        readLock.lock();
        try {
            try {
                try {
                    readableDatabase = getReadableDatabase();
                    try {
                        try {
                            StringBuilder sb = new StringBuilder();
                            sb.append("SELECT COUNT(*) FROM ");
                            str = "SELECT COUNT(*) FROM ";
                            try {
                                sb.append("event");
                                sb.append(" a ");
                                sb.append("LEFT JOIN ");
                                sb.append(UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME);
                                sb.append(" b ");
                                sb.append("ON a.");
                                sb.append("eventid");
                                sb.append(" = b.");
                                sb.append("eventid");
                                sb.append(" WHERE ");
                                sb.append("a.");
                                sb.append("flowhandle");
                                sb.append(" = ");
                                sb.append(-1);
                                sb.append(" AND ");
                                sb.append("(a.");
                                sb.append("reallog");
                                sb.append(" = '0' OR a.");
                                sb.append("reallog");
                                sb.append(" = '')");
                                if (H) {
                                    try {
                                        try {
                                            sb.append(" AND (b.");
                                            sb.append("switch");
                                            sb.append(" IS NULL OR b.");
                                            sb.append("switch");
                                            sb.append(" = '");
                                            str2 = "1";
                                        } catch (RuntimeException e2) {
                                            e = e2;
                                            str2 = "1";
                                        }
                                        try {
                                            sb.append(str2);
                                            str3 = " IS NULL OR b.";
                                        } catch (RuntimeException e3) {
                                            e = e3;
                                            str3 = " IS NULL OR b.";
                                            dVar = dVar2;
                                            cursor2 = null;
                                            r1 = dVar;
                                            if (f26471h) {
                                            }
                                            c.a.t0.q0.a.a(cursor2);
                                            StringBuilder sb2 = new StringBuilder();
                                            sb2.append(str);
                                            sb2.append("flow");
                                            sb2.append(" a ");
                                            sb2.append("LEFT JOIN ");
                                            sb2.append(UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME);
                                            sb2.append(" b ");
                                            sb2.append("ON a.");
                                            sb2.append("flowid");
                                            sb2.append(" = b.");
                                            sb2.append("eventid");
                                            sb2.append(" WHERE ");
                                            sb2.append(" a.");
                                            sb2.append("endtime");
                                            sb2.append(" IS NOT NULL");
                                            if (H) {
                                            }
                                            cursor3 = null;
                                            try {
                                                cursor3 = readableDatabase.rawQuery(sb2.toString(), null);
                                                if (cursor3 != null) {
                                                }
                                            } catch (RuntimeException e4) {
                                                e = e4;
                                                if (f26471h) {
                                                    e.printStackTrace();
                                                }
                                                c.a.t0.q0.a.a(cursor3);
                                                z zVar = this;
                                                i0.d dVar3 = r1;
                                                zVar.f26476g.readLock().unlock();
                                                return dVar3;
                                            }
                                            c.a.t0.q0.a.a(cursor3);
                                            z zVar2 = this;
                                            i0.d dVar32 = r1;
                                            zVar2.f26476g.readLock().unlock();
                                            return dVar32;
                                        }
                                        try {
                                            sb.append(str7);
                                            str7 = str7;
                                            str4 = str5;
                                        } catch (RuntimeException e5) {
                                            e = e5;
                                            str7 = str7;
                                            dVar = dVar2;
                                            cursor2 = null;
                                            r1 = dVar;
                                            if (f26471h) {
                                            }
                                            c.a.t0.q0.a.a(cursor2);
                                            StringBuilder sb22 = new StringBuilder();
                                            sb22.append(str);
                                            sb22.append("flow");
                                            sb22.append(" a ");
                                            sb22.append("LEFT JOIN ");
                                            sb22.append(UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME);
                                            sb22.append(" b ");
                                            sb22.append("ON a.");
                                            sb22.append("flowid");
                                            sb22.append(" = b.");
                                            sb22.append("eventid");
                                            sb22.append(" WHERE ");
                                            sb22.append(" a.");
                                            sb22.append("endtime");
                                            sb22.append(" IS NOT NULL");
                                            if (H) {
                                            }
                                            cursor3 = null;
                                            cursor3 = readableDatabase.rawQuery(sb22.toString(), null);
                                            if (cursor3 != null) {
                                            }
                                            c.a.t0.q0.a.a(cursor3);
                                            z zVar22 = this;
                                            i0.d dVar322 = r1;
                                            zVar22.f26476g.readLock().unlock();
                                            return dVar322;
                                        }
                                    } catch (Throwable th) {
                                        th = th;
                                        cursor = null;
                                        c.a.t0.q0.a.a(cursor);
                                        throw th;
                                    }
                                } else {
                                    str2 = "1";
                                    str3 = " IS NULL OR b.";
                                    try {
                                        sb.append(str6);
                                        sb.append("switch");
                                        sb.append(" = '");
                                        sb.append(str2);
                                        str6 = str6;
                                        str4 = str5;
                                    } catch (RuntimeException e6) {
                                        e = e6;
                                        str6 = str6;
                                        dVar = dVar2;
                                        cursor2 = null;
                                        r1 = dVar;
                                        if (f26471h) {
                                        }
                                        c.a.t0.q0.a.a(cursor2);
                                        StringBuilder sb222 = new StringBuilder();
                                        sb222.append(str);
                                        sb222.append("flow");
                                        sb222.append(" a ");
                                        sb222.append("LEFT JOIN ");
                                        sb222.append(UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME);
                                        sb222.append(" b ");
                                        sb222.append("ON a.");
                                        sb222.append("flowid");
                                        sb222.append(" = b.");
                                        sb222.append("eventid");
                                        sb222.append(" WHERE ");
                                        sb222.append(" a.");
                                        sb222.append("endtime");
                                        sb222.append(" IS NOT NULL");
                                        if (H) {
                                        }
                                        cursor3 = null;
                                        cursor3 = readableDatabase.rawQuery(sb222.toString(), null);
                                        if (cursor3 != null) {
                                        }
                                        c.a.t0.q0.a.a(cursor3);
                                        z zVar222 = this;
                                        i0.d dVar3222 = r1;
                                        zVar222.f26476g.readLock().unlock();
                                        return dVar3222;
                                    }
                                    try {
                                        sb.append(str4);
                                    } catch (RuntimeException e7) {
                                        e = e7;
                                        str5 = str4;
                                        dVar = dVar2;
                                        cursor2 = null;
                                        r1 = dVar;
                                        if (f26471h) {
                                        }
                                        c.a.t0.q0.a.a(cursor2);
                                        StringBuilder sb2222 = new StringBuilder();
                                        sb2222.append(str);
                                        sb2222.append("flow");
                                        sb2222.append(" a ");
                                        sb2222.append("LEFT JOIN ");
                                        sb2222.append(UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME);
                                        sb2222.append(" b ");
                                        sb2222.append("ON a.");
                                        sb2222.append("flowid");
                                        sb2222.append(" = b.");
                                        sb2222.append("eventid");
                                        sb2222.append(" WHERE ");
                                        sb2222.append(" a.");
                                        sb2222.append("endtime");
                                        sb2222.append(" IS NOT NULL");
                                        if (H) {
                                        }
                                        cursor3 = null;
                                        cursor3 = readableDatabase.rawQuery(sb2222.toString(), null);
                                        if (cursor3 != null) {
                                        }
                                        c.a.t0.q0.a.a(cursor3);
                                        z zVar2222 = this;
                                        i0.d dVar32222 = r1;
                                        zVar2222.f26476g.readLock().unlock();
                                        return dVar32222;
                                    }
                                }
                                str5 = str4;
                            } catch (RuntimeException e8) {
                                e = e8;
                                str2 = "1";
                                dVar = dVar2;
                                str3 = " IS NULL OR b.";
                                cursor2 = null;
                                r1 = dVar;
                                if (f26471h) {
                                }
                                c.a.t0.q0.a.a(cursor2);
                                StringBuilder sb22222 = new StringBuilder();
                                sb22222.append(str);
                                sb22222.append("flow");
                                sb22222.append(" a ");
                                sb22222.append("LEFT JOIN ");
                                sb22222.append(UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME);
                                sb22222.append(" b ");
                                sb22222.append("ON a.");
                                sb22222.append("flowid");
                                sb22222.append(" = b.");
                                sb22222.append("eventid");
                                sb22222.append(" WHERE ");
                                sb22222.append(" a.");
                                sb22222.append("endtime");
                                sb22222.append(" IS NOT NULL");
                                if (H) {
                                }
                                cursor3 = null;
                                cursor3 = readableDatabase.rawQuery(sb22222.toString(), null);
                                if (cursor3 != null) {
                                }
                                c.a.t0.q0.a.a(cursor3);
                                z zVar22222 = this;
                                i0.d dVar322222 = r1;
                                zVar22222.f26476g.readLock().unlock();
                                return dVar322222;
                            }
                            try {
                                cursor2 = readableDatabase.rawQuery(sb.toString(), null);
                            } catch (RuntimeException e9) {
                                e = e9;
                                dVar = dVar2;
                                cursor2 = null;
                                r1 = dVar;
                                if (f26471h) {
                                }
                                c.a.t0.q0.a.a(cursor2);
                                StringBuilder sb222222 = new StringBuilder();
                                sb222222.append(str);
                                sb222222.append("flow");
                                sb222222.append(" a ");
                                sb222222.append("LEFT JOIN ");
                                sb222222.append(UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME);
                                sb222222.append(" b ");
                                sb222222.append("ON a.");
                                sb222222.append("flowid");
                                sb222222.append(" = b.");
                                sb222222.append("eventid");
                                sb222222.append(" WHERE ");
                                sb222222.append(" a.");
                                sb222222.append("endtime");
                                sb222222.append(" IS NOT NULL");
                                if (H) {
                                }
                                cursor3 = null;
                                cursor3 = readableDatabase.rawQuery(sb222222.toString(), null);
                                if (cursor3 != null) {
                                }
                                c.a.t0.q0.a.a(cursor3);
                                z zVar222222 = this;
                                i0.d dVar3222222 = r1;
                                zVar222222.f26476g.readLock().unlock();
                                return dVar3222222;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            cursor = null;
                        }
                    } catch (RuntimeException e10) {
                        e = e10;
                        str = "SELECT COUNT(*) FROM ";
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (SQLException e11) {
                e = e11;
            }
        } catch (SQLException e12) {
            e = e12;
            readLock = r1;
            r1 = dVar2;
        } catch (Throwable th4) {
            th = th4;
            readLock = r1;
        }
        try {
            if (cursor2 != null) {
                try {
                } catch (RuntimeException e13) {
                    e = e13;
                    dVar = dVar2;
                } catch (Throwable th5) {
                    th = th5;
                    cursor = cursor2;
                    c.a.t0.q0.a.a(cursor);
                    throw th;
                }
                if (cursor2.getCount() > 0) {
                    cursor2.moveToFirst();
                    dVar = dVar2;
                    try {
                        try {
                            dVar.a = cursor2.getInt(0);
                            r1 = dVar;
                        } catch (RuntimeException e14) {
                            e = e14;
                            r1 = dVar;
                            if (f26471h) {
                                e.printStackTrace();
                                r1 = dVar;
                            }
                            c.a.t0.q0.a.a(cursor2);
                            StringBuilder sb2222222 = new StringBuilder();
                            sb2222222.append(str);
                            sb2222222.append("flow");
                            sb2222222.append(" a ");
                            sb2222222.append("LEFT JOIN ");
                            sb2222222.append(UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME);
                            sb2222222.append(" b ");
                            sb2222222.append("ON a.");
                            sb2222222.append("flowid");
                            sb2222222.append(" = b.");
                            sb2222222.append("eventid");
                            sb2222222.append(" WHERE ");
                            sb2222222.append(" a.");
                            sb2222222.append("endtime");
                            sb2222222.append(" IS NOT NULL");
                            if (H) {
                            }
                            cursor3 = null;
                            cursor3 = readableDatabase.rawQuery(sb2222222.toString(), null);
                            if (cursor3 != null) {
                            }
                            c.a.t0.q0.a.a(cursor3);
                            z zVar2222222 = this;
                            i0.d dVar32222222 = r1;
                            zVar2222222.f26476g.readLock().unlock();
                            return dVar32222222;
                        }
                        c.a.t0.q0.a.a(cursor2);
                        StringBuilder sb22222222 = new StringBuilder();
                        sb22222222.append(str);
                        sb22222222.append("flow");
                        sb22222222.append(" a ");
                        sb22222222.append("LEFT JOIN ");
                        sb22222222.append(UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME);
                        sb22222222.append(" b ");
                        sb22222222.append("ON a.");
                        sb22222222.append("flowid");
                        sb22222222.append(" = b.");
                        sb22222222.append("eventid");
                        sb22222222.append(" WHERE ");
                        sb22222222.append(" a.");
                        sb22222222.append("endtime");
                        sb22222222.append(" IS NOT NULL");
                        if (H) {
                            sb22222222.append(" AND (b.");
                            sb22222222.append("switch");
                            sb22222222.append(str3);
                            sb22222222.append("switch");
                            sb22222222.append(" = '");
                            sb22222222.append(str2);
                            sb22222222.append(str7);
                        } else {
                            sb22222222.append(str6);
                            sb22222222.append("switch");
                            sb22222222.append(" = '");
                            sb22222222.append(str2);
                            sb22222222.append(str5);
                        }
                        cursor3 = null;
                        cursor3 = readableDatabase.rawQuery(sb22222222.toString(), null);
                        if (cursor3 != null && cursor3.getCount() > 0) {
                            cursor3.moveToFirst();
                            r1.f26378b = cursor3.getInt(0);
                        }
                        c.a.t0.q0.a.a(cursor3);
                        z zVar22222222 = this;
                        i0.d dVar322222222 = r1;
                        zVar22222222.f26476g.readLock().unlock();
                        return dVar322222222;
                    } catch (Throwable th6) {
                        th = th6;
                        cursor = cursor2;
                        c.a.t0.q0.a.a(cursor);
                        throw th;
                    }
                }
            }
            cursor3 = readableDatabase.rawQuery(sb22222222.toString(), null);
            if (cursor3 != null) {
                cursor3.moveToFirst();
                r1.f26378b = cursor3.getInt(0);
            }
            c.a.t0.q0.a.a(cursor3);
            z zVar222222222 = this;
            i0.d dVar3222222222 = r1;
            zVar222222222.f26476g.readLock().unlock();
            return dVar3222222222;
        } catch (Throwable th7) {
            th = th7;
            c.a.t0.q0.a.a(cursor3);
            throw th;
        }
        r1 = dVar2;
        c.a.t0.q0.a.a(cursor2);
        StringBuilder sb222222222 = new StringBuilder();
        sb222222222.append(str);
        sb222222222.append("flow");
        sb222222222.append(" a ");
        sb222222222.append("LEFT JOIN ");
        sb222222222.append(UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME);
        sb222222222.append(" b ");
        sb222222222.append("ON a.");
        sb222222222.append("flowid");
        sb222222222.append(" = b.");
        sb222222222.append("eventid");
        sb222222222.append(" WHERE ");
        sb222222222.append(" a.");
        sb222222222.append("endtime");
        sb222222222.append(" IS NOT NULL");
        if (H) {
        }
        cursor3 = null;
    }

    public int P(l0 l0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, l0Var)) == null) {
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
            return I(sb.toString(), l0Var);
        }
        return invokeL.intValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:46:0x0100 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:79:0x001b */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ef A[Catch: all -> 0x0122, SQLException -> 0x0124, DONT_GENERATE, TRY_ENTER, TRY_LEAVE, TryCatch #1 {SQLException -> 0x0124, blocks: (B:8:0x001b, B:41:0x00ef, B:44:0x00fc, B:61:0x011e, B:62:0x0121), top: B:79:0x001b, outer: #2 }] */
    /* JADX WARN: Type inference failed for: r15v0, types: [int] */
    /* JADX WARN: Type inference failed for: r15v8, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r15v9 */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock] */
    /* JADX WARN: Type inference failed for: r6v2, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r6v3, types: [android.database.sqlite.SQLiteDatabase] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Map<String, x.a> Q(int i2) {
        InterceptResult invokeI;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) {
            if (i2 <= 0) {
                return null;
            }
            ?? readLock = this.f26476g.readLock();
            readLock.lock();
            try {
                try {
                    try {
                        readLock = getReadableDatabase();
                        HashMap hashMap = new HashMap();
                        try {
                            try {
                                readLock.beginTransactionNonExclusive();
                            } catch (Throwable th) {
                                th = th;
                            }
                            try {
                                cursor = readLock.rawQuery("SELECT ubcid" + StringUtil.ARRAY_ELEMENT_SEPARATOR + "ubctime" + StringUtil.ARRAY_ELEMENT_SEPARATOR + "count" + StringUtil.ARRAY_ELEMENT_SEPARATOR + "callcnt FROM arrival WHERE date(ubctime) > date('now', '-" + ((int) i2) + " day')  ORDER BY date(ubctime" + SmallTailInfo.EMOTION_SUFFIX + " DESC", null);
                                if (cursor != null) {
                                    try {
                                        if (cursor.getCount() > 0) {
                                            cursor.moveToFirst();
                                            int columnIndex = cursor.getColumnIndex("ubcid");
                                            int columnIndex2 = cursor.getColumnIndex("ubctime");
                                            int columnIndex3 = cursor.getColumnIndex("count");
                                            int columnIndex4 = cursor.getColumnIndex("callcnt");
                                            do {
                                                String string = cursor.getString(columnIndex);
                                                String string2 = cursor.getString(columnIndex2);
                                                int i3 = cursor.getInt(columnIndex3);
                                                int i4 = cursor.getInt(columnIndex4);
                                                if (i3 >= 1 && !TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                                                    x.f().e(hashMap, string2, string, i3, i4);
                                                }
                                            } while (cursor.moveToNext());
                                        }
                                    } catch (SQLException e2) {
                                        e = e2;
                                        if (f26471h) {
                                            e.printStackTrace();
                                        }
                                        this.f26474e.h(e);
                                        c.a.t0.q0.a.a(cursor);
                                        readLock.setTransactionSuccessful();
                                        if (hashMap.size() > 0) {
                                        }
                                        return null;
                                    }
                                }
                            } catch (SQLException e3) {
                                e = e3;
                                cursor = null;
                            } catch (Throwable th2) {
                                th = th2;
                                i2 = 0;
                                c.a.t0.q0.a.a(i2);
                                throw th;
                            }
                            c.a.t0.q0.a.a(cursor);
                            readLock.setTransactionSuccessful();
                            if (hashMap.size() > 0) {
                                return hashMap;
                            }
                        } catch (SQLException e4) {
                            if (f26471h) {
                                e4.printStackTrace();
                            }
                            this.f26474e.h(e4);
                        } catch (RuntimeException e5) {
                            if (f26471h) {
                                e5.printStackTrace();
                            }
                        }
                    } catch (SQLException e6) {
                        if (f26471h) {
                            e6.printStackTrace();
                        }
                        this.f26474e.h(e6);
                    }
                    return null;
                } finally {
                    readLock.endTransaction();
                }
            } finally {
                this.f26476g.readLock().unlock();
            }
        }
        return (Map) invokeI.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:30:0x00b4 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v7, types: [android.database.Cursor] */
    public o R(String str) {
        InterceptResult invokeL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            ?? r0 = " , ";
            this.f26476g.readLock().lock();
            o oVar = null;
            try {
                try {
                    try {
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        cursor = getReadableDatabase().rawQuery("SELECT state , reserve1 , reserve2 FROM file WHERE " + BreakpointSQLiteKey.FILENAME + "=\"" + str + "\"", null);
                        if (cursor != null) {
                            try {
                                if (cursor.getCount() > 0) {
                                    cursor.moveToFirst();
                                    oVar = new o(str, cursor.getString(cursor.getColumnIndex("state")), cursor.isNull(cursor.getColumnIndex("reserve1")) ? "" : cursor.getString(cursor.getColumnIndex("reserve1")), cursor.isNull(cursor.getColumnIndex("reserve2")) ? false : U(cursor.getString(cursor.getColumnIndex("reserve2"))));
                                }
                            } catch (Exception e2) {
                                e = e2;
                                if (f26471h) {
                                    e.printStackTrace();
                                }
                                c.a.t0.q0.a.a(cursor);
                                return oVar;
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                        cursor = null;
                    } catch (Throwable th2) {
                        th = th2;
                        r0 = 0;
                        c.a.t0.q0.a.a(r0);
                        throw th;
                    }
                    c.a.t0.q0.a.a(cursor);
                } catch (SQLException e4) {
                    if (f26471h) {
                        e4.printStackTrace();
                    }
                    this.f26474e.h(e4);
                }
                return oVar;
            } finally {
                this.f26476g.readLock().unlock();
            }
        }
        return (o) invokeL.objValue;
    }

    public void S(SparseArray<ArrayList> sparseArray) {
        SQLiteDatabase readableDatabase;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, sparseArray) == null) {
            this.f26476g.readLock().lock();
            try {
                try {
                    readableDatabase = getReadableDatabase();
                    cursor = null;
                } catch (SQLException e2) {
                    if (f26471h) {
                        e2.printStackTrace();
                    }
                    this.f26474e.h(e2);
                }
                try {
                    try {
                        cursor = readableDatabase.rawQuery("SELECT eventid , type , cycle FROM " + UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME + " WHERE switch=\"1\" AND (reallog = \"0\" OR reallog = \"\")", null);
                        if (cursor != null && cursor.getCount() > 0) {
                            cursor.moveToFirst();
                            int columnIndex = cursor.getColumnIndex("eventid");
                            int columnIndex2 = cursor.getColumnIndex("type");
                            int columnIndex3 = cursor.getColumnIndex("cycle");
                            boolean I = g.o().I();
                            int w = g.o().w();
                            do {
                                String string = cursor.getString(columnIndex);
                                if (!m.a(string)) {
                                    cursor.getString(columnIndex2);
                                    int i2 = cursor.getInt(columnIndex3);
                                    if (i2 != 0) {
                                        if (I) {
                                            i2 = w;
                                        } else if (i2 < 1) {
                                            i2 = 1;
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
                        if (f26471h) {
                            e3.printStackTrace();
                        }
                    }
                } finally {
                    c.a.t0.q0.a.a(cursor);
                }
            } finally {
                this.f26476g.readLock().unlock();
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
        if (c.a.t0.z.f26471h != false) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x021a, code lost:
        r0.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x021d, code lost:
        r1.f26474e.h(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x022c, code lost:
        r1.f26476g.readLock().unlock();
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0235, code lost:
        throw r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01d3 A[Catch: all -> 0x01f5, RuntimeException -> 0x01f9, TryCatch #9 {RuntimeException -> 0x01f9, blocks: (B:7:0x0029, B:9:0x0033, B:15:0x0041, B:17:0x0047, B:18:0x0088, B:21:0x00c8, B:25:0x00d8, B:27:0x00e2, B:29:0x00ed, B:35:0x00fd, B:88:0x01d8, B:32:0x00f6, B:34:0x00fa, B:36:0x0105, B:38:0x010f, B:43:0x0122, B:44:0x0127, B:46:0x012d, B:48:0x0134, B:49:0x013d, B:51:0x0143, B:54:0x014c, B:55:0x0156, B:57:0x015c, B:59:0x0169, B:60:0x016e, B:62:0x0174, B:64:0x017e, B:66:0x0185, B:68:0x018b, B:70:0x0191, B:71:0x019a, B:73:0x01a3, B:74:0x01ac, B:85:0x01cd, B:87:0x01d3, B:77:0x01b8, B:83:0x01c7, B:39:0x0115, B:41:0x011b), top: B:129:0x0029, outer: #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01df A[LOOP:0: B:18:0x0088->B:91:0x01df, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void T(f fVar) {
        Cursor cursor;
        f fVar2;
        String str;
        String str2;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048594, this, fVar) != null) {
            return;
        }
        z zVar = this;
        String str3 = "isSend";
        zVar.f26476g.readLock().lock();
        try {
            try {
                SQLiteDatabase readableDatabase = getReadableDatabase();
                cursor = null;
                try {
                    try {
                        cursor = readableDatabase.rawQuery("SELECT * FROM " + UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME, null);
                        if (fVar == null) {
                            try {
                                fVar2 = new f();
                            } catch (Throwable th) {
                                th = th;
                                c.a.t0.q0.a.a(cursor);
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
                    if (f26471h) {
                        e2.printStackTrace();
                    }
                }
            } catch (SQLException e3) {
                e = e3;
            }
            if (cursor != null && cursor.getCount() > 0) {
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex("eventid");
                int columnIndex2 = cursor.getColumnIndex("switch");
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
                        mVar.a = TextUtils.equals(string2, "1");
                        mVar.f26415b = i7 == 0;
                        mVar.f26416c = i7;
                        if (!TextUtils.isEmpty(string5)) {
                            try {
                                JSONObject jSONObject = new JSONObject(string5);
                                if (jSONObject.has(str3)) {
                                    mVar.f26417d = jSONObject.optBoolean(str3, true);
                                }
                            } catch (JSONException e4) {
                                if (f26471h) {
                                    e4.printStackTrace();
                                }
                            }
                        }
                        fVar2.a = mVar;
                        str = str3;
                        str2 = str4;
                    } else {
                        str = str3;
                        if (TextUtils.equals(string2, "0")) {
                            fVar2.f26341b.add(string);
                        } else if (TextUtils.equals(string2, "1")) {
                            fVar2.f26345f.add(string);
                        }
                        if (i7 == 0) {
                            fVar2.f26342c.add(string);
                        }
                        if (TextUtils.equals(string3, "1")) {
                            fVar2.f26344e.add(string);
                        }
                        if (i3 > 0) {
                            fVar2.f26347h.put(string, Integer.valueOf(i3));
                        }
                        if (!TextUtils.isEmpty(string4)) {
                            fVar2.f26348i.put(string, string4);
                        }
                        if (i9 != 0 && i11 != 0) {
                            fVar2.f26349j.put(string, new l(string, i11, i9));
                        }
                        if (TextUtils.isEmpty(string5)) {
                            str2 = str4;
                        } else {
                            try {
                                JSONObject jSONObject2 = new JSONObject(string5);
                                if (jSONObject2.has(Constant.ID_TYPE)) {
                                    fVar2.f26350k.add(string);
                                }
                                if (jSONObject2.has("ch") && TextUtils.equals(jSONObject2.getString("ch"), "1")) {
                                    fVar2.f26346g.add(string);
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
                                    c.a.t0.q0.a.a(cursor);
                                    zVar = this;
                                    zVar.f26476g.readLock().unlock();
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
                c.a.t0.q0.a.a(cursor);
                zVar = this;
                zVar.f26476g.readLock().unlock();
            }
            c.a.t0.q0.a.a(cursor);
            zVar = this;
            zVar.f26476g.readLock().unlock();
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public final boolean U(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
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

    public void V(n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, nVar) == null) {
            if (nVar != null && !TextUtils.isEmpty(nVar.l())) {
                this.f26476g.writeLock().lock();
                try {
                    try {
                        ContentValues J = J(nVar);
                        String k2 = nVar.k();
                        String l = nVar.l();
                        int j2 = nVar.j();
                        SQLiteDatabase writableDatabase = getWritableDatabase();
                        writableDatabase.beginTransactionNonExclusive();
                        try {
                            if (l(k2, l, j2, writableDatabase)) {
                                long insert = writableDatabase.insert("event", null, J);
                                if (f26471h) {
                                    String str = "saveEvent#performTransaction: rowId=" + insert;
                                }
                                if (insert > 0) {
                                    i0.m().x(l, j2);
                                    if (nVar.j() == -1) {
                                        x.f().a(nVar.l(), false);
                                    }
                                }
                            }
                            writableDatabase.setTransactionSuccessful();
                            writableDatabase.endTransaction();
                        } catch (Throwable th) {
                            writableDatabase.endTransaction();
                            throw th;
                        }
                    } catch (SQLException e2) {
                        if (f26471h) {
                            e2.printStackTrace();
                        }
                        this.f26474e.h(e2);
                    }
                    return;
                } finally {
                    this.f26476g.writeLock().unlock();
                }
            }
            boolean z = f26471h;
        }
    }

    public void W(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, list) == null) {
            if (list != null && list.size() != 0) {
                for (n nVar : list) {
                    V(nVar);
                }
                return;
            }
            boolean z = f26471h;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00c7 A[Catch: all -> 0x00f2, TryCatch #0 {all -> 0x00f2, blocks: (B:10:0x0022, B:13:0x005b, B:15:0x006e, B:17:0x008e, B:18:0x0097, B:20:0x009d, B:22:0x00a4, B:23:0x00ac, B:25:0x00b6, B:33:0x00c7, B:34:0x00d0, B:36:0x00db, B:37:0x00eb, B:28:0x00bd, B:30:0x00c1, B:14:0x0067), top: B:58:0x0022, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00db A[Catch: all -> 0x00f2, TryCatch #0 {all -> 0x00f2, blocks: (B:10:0x0022, B:13:0x005b, B:15:0x006e, B:17:0x008e, B:18:0x0097, B:20:0x009d, B:22:0x00a4, B:23:0x00ac, B:25:0x00b6, B:33:0x00c7, B:34:0x00d0, B:36:0x00db, B:37:0x00eb, B:28:0x00bd, B:30:0x00c1, B:14:0x0067), top: B:58:0x0022, inners: #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void X(p pVar) {
        SQLiteDatabase writableDatabase;
        ContentValues contentValues;
        JSONObject jSONObject;
        boolean z;
        boolean z2;
        String d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, pVar) == null) {
            if (pVar != null && !TextUtils.isEmpty(pVar.l())) {
                this.f26476g.writeLock().lock();
                try {
                    try {
                        writableDatabase = getWritableDatabase();
                        writableDatabase.beginTransactionNonExclusive();
                        try {
                            contentValues = new ContentValues();
                            contentValues.put("flowid", pVar.l());
                            contentValues.put("flowhandle", Integer.valueOf(pVar.k()));
                            contentValues.put("state", pVar.o());
                            contentValues.put("begintime", Long.valueOf(pVar.c()));
                            if (pVar.m() != null) {
                                contentValues.put("content", pVar.m().toString());
                            } else {
                                contentValues.put("content", pVar.g());
                            }
                            contentValues.put(SpeedStatsUtils.UBC_KEY_OPTION, Integer.valueOf(pVar.n()));
                            contentValues.put("reserve1", pVar.j());
                            if (!TextUtils.isEmpty(pVar.f())) {
                                contentValues.put("reserve2", pVar.f());
                            }
                            jSONObject = new JSONObject();
                            z = true;
                            try {
                                z2 = false;
                                if (pVar.p()) {
                                    jSONObject.put("ctr", "1");
                                    z = false;
                                }
                                d2 = pVar.d();
                            } catch (JSONException e2) {
                                if (f26471h) {
                                    e2.printStackTrace();
                                }
                            }
                        } catch (Throwable th) {
                            writableDatabase.endTransaction();
                            throw th;
                        }
                    } catch (SQLException e3) {
                        if (f26471h) {
                            e3.printStackTrace();
                        }
                        this.f26474e.h(e3);
                    }
                    if (!TextUtils.isEmpty(d2)) {
                        jSONObject.put("bizInfo", d2);
                        if (!z2) {
                            contentValues.put("extend", jSONObject.toString());
                        }
                        long insert = writableDatabase.insert("flow", null, contentValues);
                        if (f26471h) {
                            String str = "saveFlow#performTransaction: rowId=" + insert;
                        }
                        writableDatabase.setTransactionSuccessful();
                        writableDatabase.endTransaction();
                        return;
                    }
                    z2 = z;
                    if (!z2) {
                    }
                    long insert2 = writableDatabase.insert("flow", null, contentValues);
                    if (f26471h) {
                    }
                    writableDatabase.setTransactionSuccessful();
                    writableDatabase.endTransaction();
                    return;
                } finally {
                    this.f26476g.writeLock().unlock();
                }
            }
            boolean z3 = f26471h;
        }
    }

    public void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.f26476g.writeLock().lock();
            try {
                try {
                    SQLiteDatabase writableDatabase = getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                    try {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("state", "1");
                        int update = writableDatabase.update("file", contentValues, null, null);
                        if (f26471h) {
                            String str = "updateAllSentFileFail#performTransaction: update file table:" + update;
                        }
                        writableDatabase.setTransactionSuccessful();
                        writableDatabase.endTransaction();
                    } catch (Throwable th) {
                        writableDatabase.endTransaction();
                        throw th;
                    }
                } catch (SQLException e2) {
                    if (f26471h) {
                        e2.printStackTrace();
                    }
                    this.f26474e.h(e2);
                }
            } finally {
                this.f26476g.writeLock().unlock();
            }
        }
    }

    public boolean Z(List<j> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048600, this, list)) != null) {
            return invokeL.booleanValue;
        }
        if (list == null || list.size() == 0) {
            return false;
        }
        this.f26476g.writeLock().lock();
        try {
            try {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                SQLiteStatement compileStatement = writableDatabase.compileStatement("replace into " + UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME + "(eventid,type,recordrule,uploadrule,cycle,switch,sample,reserve1,reserve2,extend,reallog" + SmallTailInfo.EMOTION_SUFFIX + " values(?,?,?,?,?,?,?,?,?,?,?)");
                writableDatabase.beginTransactionNonExclusive();
                try {
                    try {
                        for (j jVar : list) {
                            compileStatement.clearBindings();
                            compileStatement.bindString(1, jVar.c());
                            if (jVar.getType() == 1) {
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
                            if (jVar.o()) {
                                compileStatement.bindLong(5, 0L);
                            } else {
                                compileStatement.bindLong(5, jVar.h());
                            }
                            if (jVar.s()) {
                                compileStatement.bindString(6, "1");
                            } else {
                                compileStatement.bindString(6, "0");
                            }
                            compileStatement.bindLong(7, jVar.g());
                            if (jVar.k()) {
                                compileStatement.bindString(8, "1");
                            } else {
                                compileStatement.bindString(8, "0");
                            }
                            String a = jVar.a();
                            if (!TextUtils.isEmpty(a)) {
                                compileStatement.bindString(9, a);
                            }
                            JSONObject jSONObject = new JSONObject();
                            if (jVar.m()) {
                                jSONObject.put(Constant.ID_TYPE, "1");
                            }
                            if (jVar.n()) {
                                jSONObject.put("ch", "1");
                            }
                            if (jVar.l()) {
                                jSONObject.put("dfc", "1");
                            }
                            jSONObject.put("version", jVar.j());
                            int b2 = jVar.b();
                            if (jVar.r()) {
                                jSONObject.put("gflow", Integer.toString(b2));
                            }
                            if (!jVar.t()) {
                                jSONObject.put("uploadType", Integer.toString(jVar.i()));
                            }
                            int f2 = jVar.f();
                            if (f2 != 2) {
                                jSONObject.put("lcache", f2);
                            }
                            if (m.a(jVar.c())) {
                                jSONObject.put("isSend", jVar.q());
                            }
                            compileStatement.bindString(10, jSONObject.toString());
                            if (jVar.p()) {
                                compileStatement.bindString(11, "1");
                            } else {
                                compileStatement.bindString(11, "0");
                            }
                            if (compileStatement.executeUpdateDelete() <= 0) {
                                return false;
                            }
                        }
                        writableDatabase.setTransactionSuccessful();
                        if (f26471h) {
                            String str = "updateConfig success count: " + list.size();
                        }
                        return true;
                    } catch (JSONException e3) {
                        if (f26471h) {
                            e3.printStackTrace();
                        }
                        writableDatabase.endTransaction();
                        return false;
                    }
                } finally {
                    writableDatabase.endTransaction();
                }
            } catch (SQLException e4) {
                if (f26471h) {
                    e4.printStackTrace();
                }
                this.f26474e.h(e4);
            }
        } finally {
            this.f26476g.writeLock().unlock();
        }
    }

    public void a(l0 l0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048601, this, l0Var) != null) {
            return;
        }
        z zVar = this;
        boolean H = g.o().H();
        zVar.f26476g.readLock().lock();
        try {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("SELECT a.* FROM ");
                sb.append("event");
                sb.append(" a ");
                sb.append("LEFT JOIN ");
                sb.append(UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME);
                sb.append(" b ");
                sb.append("ON a.");
                sb.append("eventid");
                sb.append(" = b.");
                sb.append("eventid");
                sb.append(" WHERE ");
                sb.append("a.");
                sb.append("flowhandle");
                sb.append(" = ");
                sb.append(-1);
                sb.append(" AND ");
                sb.append("(a.");
                sb.append("reallog");
                sb.append(" = '0' OR a.");
                sb.append("reallog");
                sb.append(" = '')");
                if (H) {
                    sb.append(" AND (b.");
                    sb.append("switch");
                    sb.append(" IS NULL OR b.");
                    sb.append("switch");
                    sb.append(" = '");
                    sb.append("1");
                    sb.append("')");
                } else {
                    sb.append(" AND b.");
                    sb.append("switch");
                    sb.append(" = '");
                    sb.append("1");
                    sb.append("'");
                }
                sb.append(" ORDER BY b.");
                sb.append("cycle");
                sb.append(" ASC");
                zVar.I(sb.toString(), l0Var);
            } catch (SQLException e2) {
                e = e2;
            }
            if (!l0Var.w() && !l0Var.z()) {
                StringBuilder sb2 = new StringBuilder();
                try {
                    sb2.append("SELECT a.* FROM ");
                    sb2.append("flow");
                    sb2.append(" a ");
                    sb2.append("LEFT JOIN ");
                    sb2.append(UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME);
                    sb2.append(" b ");
                    sb2.append("ON a.");
                    sb2.append("flowid");
                    sb2.append(" = b.");
                    sb2.append("eventid");
                    sb2.append(" WHERE ");
                    sb2.append(" a.");
                    sb2.append("endtime");
                    sb2.append(" IS NOT NULL");
                    if (H) {
                        sb2.append(" AND (b.");
                        sb2.append("switch");
                        sb2.append(" IS NULL OR b.");
                        sb2.append("switch");
                        sb2.append(" = '");
                        sb2.append("1");
                        sb2.append("')");
                    } else {
                        sb2.append(" AND b.");
                        sb2.append("switch");
                        sb2.append(" = '");
                        sb2.append("1");
                        sb2.append("'");
                    }
                    sb2.append(" ORDER BY b.");
                    sb2.append("cycle");
                    sb2.append(" ASC");
                    zVar = this;
                    zVar.L(sb2.toString(), l0Var);
                } catch (SQLException e3) {
                    e = e3;
                    zVar = this;
                    if (f26471h) {
                        e.printStackTrace();
                    }
                    zVar.f26474e.h(e);
                    zVar.f26476g.readLock().unlock();
                    return;
                } catch (Throwable th) {
                    th = th;
                    zVar = this;
                    zVar.f26476g.readLock().unlock();
                    throw th;
                }
                zVar.f26476g.readLock().unlock();
                return;
            }
            zVar.f26476g.readLock().unlock();
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public void a0(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048602, this, str, i2, str2) == null) {
            if (i2 >= 0 && !TextUtils.isEmpty(str)) {
                this.f26476g.writeLock().lock();
                try {
                    try {
                        SQLiteDatabase writableDatabase = getWritableDatabase();
                        writableDatabase.beginTransactionNonExclusive();
                        try {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("content", str2);
                            int update = writableDatabase.update("flow", contentValues, "flowid=\"" + str + "\" AND flowhandle = " + i2, null);
                            if (f26471h && update != 1) {
                                String str3 = "updateFlowValue#performTransaction: updateFlowValue count:" + update;
                            }
                            writableDatabase.setTransactionSuccessful();
                            writableDatabase.endTransaction();
                        } catch (Throwable th) {
                            writableDatabase.endTransaction();
                            throw th;
                        }
                    } catch (SQLException e2) {
                        if (f26471h) {
                            e2.printStackTrace();
                        }
                        this.f26474e.h(e2);
                    }
                    return;
                } finally {
                    this.f26476g.writeLock().unlock();
                }
            }
            boolean z = f26471h;
        }
    }

    public void b(l0 l0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, l0Var) == null) {
            boolean H = g.o().H();
            this.f26476g.readLock().lock();
            try {
                try {
                    I(A(true, true, H), l0Var);
                } catch (SQLException e2) {
                    if (f26471h) {
                        e2.printStackTrace();
                    }
                    this.f26474e.h(e2);
                }
                if (!l0Var.w() && !l0Var.z()) {
                    I(A(true, false, H), l0Var);
                    if (!l0Var.w() && !l0Var.z()) {
                        L(A(false, true, H), l0Var);
                        if (!l0Var.w() && !l0Var.z()) {
                            L(A(false, false, H), l0Var);
                        }
                    }
                }
            } finally {
                this.f26476g.readLock().unlock();
            }
        }
    }

    public void b0(String str) {
        SQLiteDatabase writableDatabase;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, str) == null) {
            this.f26476g.writeLock().lock();
            try {
                try {
                    writableDatabase = getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                } catch (SQLException e2) {
                    if (f26471h) {
                        e2.printStackTrace();
                    }
                    this.f26474e.h(e2);
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("state", "1");
                    int update = writableDatabase.update("file", contentValues, BreakpointSQLiteKey.FILENAME + "=\"" + str + "\"", null);
                    if (f26471h) {
                        String str2 = "updateSendedFileFail#performTransaction: update file table:" + update;
                    }
                    writableDatabase.setTransactionSuccessful();
                    writableDatabase.endTransaction();
                } catch (Throwable th) {
                    writableDatabase.endTransaction();
                    throw th;
                }
            } finally {
                this.f26476g.writeLock().unlock();
            }
        }
    }

    public final void c(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, sQLiteDatabase) == null) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE arrival ADD COLUMN callcnt INTEGER");
            } catch (SQLException e2) {
                if (f26471h) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void c0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048606, this, str, str2) == null) {
            this.f26476g.writeLock().lock();
            try {
                try {
                    SQLiteDatabase writableDatabase = getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                    try {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("state", str2);
                        writableDatabase.update("file", contentValues, BreakpointSQLiteKey.FILENAME + "=\"" + str + "\"", null);
                        writableDatabase.setTransactionSuccessful();
                        writableDatabase.endTransaction();
                    } catch (Throwable th) {
                        writableDatabase.endTransaction();
                        throw th;
                    }
                } catch (SQLException e2) {
                    if (f26471h) {
                        e2.printStackTrace();
                    }
                    this.f26474e.h(e2);
                }
            } finally {
                this.f26476g.writeLock().unlock();
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
        }
    }

    public final boolean d(n nVar, int i2, l0 l0Var) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048608, this, nVar, i2, l0Var)) == null) {
            boolean c2 = l0Var.c(nVar, i2);
            if (c2) {
                if (!TextUtils.isEmpty(nVar.h())) {
                    l0Var.K("1");
                }
                long p = nVar.p();
                if (p > 0) {
                    if (l0Var.t() == 0 || p < l0Var.t()) {
                        l0Var.J(p, 0L);
                    }
                    if (p > l0Var.s()) {
                        l0Var.J(0L, p);
                    }
                }
            }
            return c2;
        }
        return invokeLIL.booleanValue;
    }

    public final void e(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, sQLiteDatabase) == null) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE event ADD COLUMN extend TEXT");
                sQLiteDatabase.execSQL("ALTER TABLE flow ADD COLUMN extend TEXT");
            } catch (SQLException e2) {
                if (f26471h) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void f(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, sQLiteDatabase) == null) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE config ADD COLUMN extend TEXT");
            } catch (SQLException e2) {
                if (f26471h) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final boolean g(SQLiteDatabase sQLiteDatabase, p pVar, int i2, l0 l0Var) {
        InterceptResult invokeLLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(1048611, this, sQLiteDatabase, pVar, i2, l0Var)) == null) {
            if (pVar.k() < 0) {
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
                sb.append(pVar.k());
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
                    pVar.w(jSONArray);
                }
                c.a.t0.q0.a.a(rawQuery);
                if (l0Var.c(pVar, i2)) {
                    if (!TextUtils.isEmpty(pVar.j())) {
                        l0Var.K("1");
                    }
                    if (pVar.i() > 0 && pVar.i() > l0Var.s()) {
                        l0Var.J(0L, pVar.i());
                    }
                    if (pVar.c() > 0) {
                        if (l0Var.t() == 0 || pVar.c() < l0Var.t()) {
                            l0Var.J(pVar.c(), 0L);
                            return true;
                        }
                        return true;
                    }
                    return true;
                }
            } catch (RuntimeException e2) {
                if (f26471h) {
                    e2.printStackTrace();
                }
            } catch (JSONException unused) {
                boolean z = f26471h;
            }
            return false;
        }
        return invokeLLIL.booleanValue;
    }

    public void h(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048612, this, str, z) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.f26476g.writeLock().lock();
        String str2 = z ? "callcnt" : "count";
        String str3 = z ? "count" : "callcnt";
        try {
            try {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    try {
                        SQLiteStatement compileStatement = writableDatabase.compileStatement("UPDATE arrival SET " + str2 + " = " + str2 + " + 1, state = 0 WHERE ubcid = ? AND date(ubctime" + SmallTailInfo.EMOTION_SUFFIX + " = date(\"now\")");
                        compileStatement.clearBindings();
                        compileStatement.bindString(1, str);
                        if (compileStatement.executeUpdateDelete() <= 0) {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("ubcid", str);
                            contentValues.put(str2, (Integer) 1);
                            contentValues.put(str3, (Integer) 0);
                            contentValues.put("state", (Integer) 0);
                            writableDatabase.insert("arrival", null, contentValues);
                        }
                        writableDatabase.setTransactionSuccessful();
                    } catch (SQLException e2) {
                        if (f26471h) {
                            e2.printStackTrace();
                        }
                        this.f26474e.h(e2);
                    }
                } finally {
                    writableDatabase.endTransaction();
                }
            } catch (SQLException e3) {
                if (f26471h) {
                    e3.printStackTrace();
                }
                this.f26474e.h(e3);
            }
        } finally {
            this.f26476g.writeLock().unlock();
        }
    }

    public final void i(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, sQLiteDatabase) == null) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE config ADD COLUMN reallog DEFAULT '0'");
                sQLiteDatabase.execSQL("ALTER TABLE event ADD COLUMN reallog DEFAULT '0'");
            } catch (SQLException e2) {
                if (f26471h) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void j(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, sQLiteDatabase) == null) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE config ADD COLUMN sample TEXT");
                sQLiteDatabase.execSQL("ALTER TABLE flow ADD COLUMN slot TEXT");
            } catch (SQLException e2) {
                if (f26471h) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void k(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048615, this, str, i2) == null) {
            if (i2 >= 0 && !TextUtils.isEmpty(str)) {
                this.f26476g.writeLock().lock();
                try {
                    try {
                        SQLiteDatabase writableDatabase = getWritableDatabase();
                        writableDatabase.beginTransactionNonExclusive();
                        try {
                            int delete = writableDatabase.delete("flow", "flowid=\"" + str + "\" AND flowhandle = " + i2, null);
                            if (f26471h) {
                                String str2 = "cancelFlow#performTransaction: cancelFlow flow count:" + delete;
                            }
                            int delete2 = writableDatabase.delete("event", "flowhandle = " + i2, null);
                            if (f26471h) {
                                String str3 = "cancelFlow#performTransaction: cancelFlow event count:" + delete2;
                            }
                            writableDatabase.setTransactionSuccessful();
                            writableDatabase.endTransaction();
                        } catch (Throwable th) {
                            writableDatabase.endTransaction();
                            throw th;
                        }
                    } catch (SQLException e2) {
                        if (f26471h) {
                            e2.printStackTrace();
                        }
                        this.f26474e.h(e2);
                    }
                    return;
                } finally {
                    this.f26476g.writeLock().unlock();
                }
            }
            boolean z = f26471h;
        }
    }

    public final boolean l(String str, String str2, int i2, SQLiteDatabase sQLiteDatabase) {
        InterceptResult invokeLLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(1048616, this, str, str2, i2, sQLiteDatabase)) == null) {
            this.f26476g.writeLock().lock();
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
                        if (f26471h) {
                            e2.printStackTrace();
                        }
                        this.f26474e.h(e2);
                    } catch (RuntimeException e3) {
                        if (f26471h) {
                            e3.printStackTrace();
                        }
                    }
                    c.a.t0.q0.a.a(cursor);
                }
                return z;
            } finally {
                this.f26476g.writeLock().unlock();
            }
        }
        return invokeLLIL.booleanValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            x(false);
        }
    }

    public void n() {
        SQLiteDatabase writableDatabase;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048618, this) != null) {
            return;
        }
        this.f26476g.writeLock().lock();
        try {
            try {
                writableDatabase = getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                cursor = null;
            } catch (SQLException e2) {
                if (f26471h) {
                    e2.printStackTrace();
                }
                this.f26474e.h(e2);
            }
            try {
                try {
                    int delete = writableDatabase.delete("arrival", "date(ubctime) <= date('now', '-7 day') ", null);
                    if (f26471h) {
                        String str = "clearInvalidUBCRecords delete " + delete + " records";
                    }
                    int delete2 = writableDatabase.delete("arrival", "state = 1 AND date(ubctime) < date('now')", null);
                    if (f26471h) {
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
                            if (f26471h) {
                                e.printStackTrace();
                            }
                            this.f26474e.h(e);
                            c.a.t0.q0.a.a(cursor);
                            writableDatabase.endTransaction();
                        } catch (Throwable th) {
                            cursor = rawQuery;
                            th = th;
                            c.a.t0.q0.a.a(cursor);
                            writableDatabase.endTransaction();
                            throw th;
                        }
                    }
                    int delete3 = writableDatabase.delete("arrival", "_id < " + i2, null);
                    if (f26471h) {
                        String str3 = "clearInvalidUBCRecords delete count:" + delete3;
                    }
                    writableDatabase.setTransactionSuccessful();
                    c.a.t0.q0.a.a(rawQuery);
                } catch (SQLException e4) {
                    e = e4;
                }
                writableDatabase.endTransaction();
            } catch (Throwable th2) {
                th = th2;
            }
        } finally {
            this.f26476g.writeLock().unlock();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x015c A[Catch: all -> 0x01a0, TryCatch #0 {all -> 0x01a0, blocks: (B:39:0x012b, B:41:0x0130, B:46:0x013e, B:49:0x0153, B:51:0x015c, B:53:0x0166, B:54:0x016b, B:56:0x0175, B:57:0x0185, B:44:0x0138), top: B:81:0x012b }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0175 A[Catch: all -> 0x01a0, TryCatch #0 {all -> 0x01a0, blocks: (B:39:0x012b, B:41:0x0130, B:46:0x013e, B:49:0x0153, B:51:0x015c, B:53:0x0166, B:54:0x016b, B:56:0x0175, B:57:0x0185, B:44:0x0138), top: B:81:0x012b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean o(l0 l0Var, String str) {
        InterceptResult invokeLL;
        boolean z;
        int i2;
        int i3;
        l0 l0Var2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(1048619, this, l0Var, str)) != null) {
            return invokeLL.booleanValue;
        }
        SparseArray<Integer> r = l0Var.r();
        ArrayList q = l0Var.q();
        boolean B = l0Var.B();
        this.f26476g.writeLock().lock();
        try {
            try {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    try {
                        if (r != null) {
                            try {
                                if (r.size() > 0) {
                                    int size = r.size();
                                    ArrayList arrayList = new ArrayList(size);
                                    for (int i4 = 0; i4 < size; i4++) {
                                        arrayList.add(Integer.valueOf(r.keyAt(i4)));
                                    }
                                    String M = M(arrayList);
                                    if (f26471h) {
                                        String str2 = "save file name " + str + " delete flow handle ids = " + M;
                                    }
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("flowhandle");
                                    sb.append(" in (");
                                    sb.append(M);
                                    sb.append(SmallTailInfo.EMOTION_SUFFIX);
                                    i2 = writableDatabase.delete("flow", sb.toString(), null);
                                    if (f26471h) {
                                        String str3 = "clearUploadedData#performTransaction: flow table delete count:" + i2;
                                    }
                                    try {
                                        int delete = writableDatabase.delete("event", sb.toString(), null);
                                        if (f26471h) {
                                            String str4 = "clearUploadedData#performTransaction:  delete flow -> event table count:" + delete;
                                        }
                                        if (q != null || q.size() <= 0) {
                                            l0Var2 = l0Var;
                                            i3 = 0;
                                        } else {
                                            String M2 = M(q);
                                            if (f26471h) {
                                                String str5 = "delete event ids = " + M2;
                                            }
                                            i3 = writableDatabase.delete("event", "eventid in (" + M2 + SmallTailInfo.EMOTION_SUFFIX + " AND flowhandle = -1", null);
                                            if (f26471h) {
                                                String str6 = "clearUploadedData#performTransaction: event table count2:" + i3;
                                            }
                                            l0Var2 = l0Var;
                                        }
                                        p(writableDatabase, l0Var2);
                                        if ((r != null && r.size() > 0) || (q != null && q.size() > 0)) {
                                            ContentValues contentValues = new ContentValues();
                                            contentValues.put(BreakpointSQLiteKey.FILENAME, str);
                                            contentValues.put("state", "0");
                                            contentValues.put("reserve1", B ? "1" : "0");
                                            if (l0Var.x()) {
                                                String K = K(l0Var);
                                                if (!TextUtils.isEmpty(K)) {
                                                    contentValues.put("reserve2", K);
                                                }
                                            }
                                            long insert = writableDatabase.insert("file", null, contentValues);
                                            if (f26471h) {
                                                String str7 = "clearUploadedData#save file: rowId=" + insert;
                                            }
                                        }
                                        writableDatabase.setTransactionSuccessful();
                                        writableDatabase.endTransaction();
                                        i0.m().s(i3, i2);
                                        this.f26476g.writeLock().unlock();
                                        return true;
                                    } catch (Throwable th) {
                                        th = th;
                                        i3 = 0;
                                        writableDatabase.endTransaction();
                                        i0.m().s(i3, i2);
                                        throw th;
                                    }
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                i2 = 0;
                                i3 = 0;
                                writableDatabase.endTransaction();
                                i0.m().s(i3, i2);
                                throw th;
                            }
                        }
                        if (r != null) {
                            ContentValues contentValues2 = new ContentValues();
                            contentValues2.put(BreakpointSQLiteKey.FILENAME, str);
                            contentValues2.put("state", "0");
                            contentValues2.put("reserve1", B ? "1" : "0");
                            if (l0Var.x()) {
                            }
                            long insert2 = writableDatabase.insert("file", null, contentValues2);
                            if (f26471h) {
                            }
                            writableDatabase.setTransactionSuccessful();
                            writableDatabase.endTransaction();
                            i0.m().s(i3, i2);
                            this.f26476g.writeLock().unlock();
                            return true;
                        }
                        writableDatabase.endTransaction();
                        i0.m().s(i3, i2);
                        this.f26476g.writeLock().unlock();
                        return true;
                    } catch (SQLException e2) {
                        e = e2;
                        z = true;
                        if (f26471h) {
                            e.printStackTrace();
                        }
                        this.f26474e.h(e);
                        return z;
                    }
                    p(writableDatabase, l0Var2);
                    ContentValues contentValues22 = new ContentValues();
                    contentValues22.put(BreakpointSQLiteKey.FILENAME, str);
                    contentValues22.put("state", "0");
                    contentValues22.put("reserve1", B ? "1" : "0");
                    if (l0Var.x()) {
                    }
                    long insert22 = writableDatabase.insert("file", null, contentValues22);
                    if (f26471h) {
                    }
                    writableDatabase.setTransactionSuccessful();
                } catch (Throwable th3) {
                    th = th3;
                    writableDatabase.endTransaction();
                    i0.m().s(i3, i2);
                    throw th;
                }
                i2 = 0;
                if (q != null) {
                }
                l0Var2 = l0Var;
                i3 = 0;
            } catch (SQLException e3) {
                e = e3;
                z = false;
            }
        } finally {
            this.f26476g.writeLock().unlock();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onConfigure(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, sQLiteDatabase) == null) {
            sQLiteDatabase.enableWriteAheadLogging();
            super.onConfigure(sQLiteDatabase);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, sQLiteDatabase) == null) {
            boolean z = f26471h;
            try {
                sQLiteDatabase.execSQL("CREATE TABLE event (_id INTEGER PRIMARY KEY AUTOINCREMENT,flowhandle INTEGER,eventid TEXT,begintime LONG,content TEXT,reserve1 TEXT,reserve2 TEXT,extend TEXT,reallog TEXT);");
                sQLiteDatabase.execSQL("CREATE TABLE flow (_id INTEGER PRIMARY KEY AUTOINCREMENT,flowid TEXT,flowhandle INTEGER,state TEXT,begintime LONG,endtime LONG,content TEXT,option INTEGER,reserve1 TEXT,reserve2 TEXT,slot TEXT,extend TEXT );");
                sQLiteDatabase.execSQL("CREATE TABLE config (eventid TEXT PRIMARY KEY,type TEXT,recordrule TEXT,uploadrule TEXT,cycle INTEGER,switch TEXT,sample INTEGER,reserve1 TEXT,reserve2 TEXT,extend TEXT,reallog TEXT);");
                sQLiteDatabase.execSQL("CREATE TABLE file (filename TEXT PRIMARY KEY,state TEXT,reserve1 TEXT,reserve2 TEXT);");
                sQLiteDatabase.execSQL("CREATE TABLE arrival (_id INTEGER PRIMARY KEY AUTOINCREMENT,ubcid TEXT,ubctime TEXT DEFAULT CURRENT_DATE,count INTEGER,state INTEGER,reserve1 TEXT,callcnt INTEGER);");
                k0.a().f(UBCCloudControlProcessor.UBC_CLOUDCONFIG_VERSION, "0");
            } catch (Exception e2) {
                String str = "Error while creating db: " + e2.toString();
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048622, this, sQLiteDatabase, i2, i3) == null) {
            try {
                sQLiteDatabase.beginTransaction();
                while (i2 < i3) {
                    switch (i2) {
                        case 1:
                            r(sQLiteDatabase);
                            break;
                        case 2:
                            j(sQLiteDatabase);
                            break;
                        case 3:
                            e(sQLiteDatabase);
                            break;
                        case 4:
                            f(sQLiteDatabase);
                            break;
                        case 6:
                            i(sQLiteDatabase);
                            break;
                        case 7:
                            q(sQLiteDatabase);
                            break;
                        case 8:
                            c(sQLiteDatabase);
                            break;
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

    public void p(SQLiteDatabase sQLiteDatabase, l0 l0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048623, this, sQLiteDatabase, l0Var) == null) || l0Var == null || l0Var.y() || l0Var.l().size() < 1) {
            return;
        }
        this.f26476g.writeLock().lock();
        try {
            try {
                Set<String> l = l0Var.l();
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
                if (f26471h) {
                    String str = "clearUploadedUBCRecords delete " + delete + " records";
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("state", (Integer) 1);
                int update = sQLiteDatabase.update("arrival", contentValues, sb2, strArr);
                if (f26471h) {
                    String str2 = "clearUploadedUBCRecords update " + update + " records";
                }
            } catch (SQLException e2) {
                if (f26471h) {
                    e2.printStackTrace();
                }
                this.f26474e.h(e2);
            }
        } finally {
            this.f26476g.writeLock().unlock();
        }
    }

    public final void q(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, sQLiteDatabase) == null) {
            try {
                sQLiteDatabase.execSQL("CREATE TABLE arrival (_id INTEGER PRIMARY KEY AUTOINCREMENT,ubcid TEXT,ubctime TEXT DEFAULT CURRENT_DATE,count INTEGER,state INTEGER,reserve1 TEXT,callcnt INTEGER);");
            } catch (SQLException e2) {
                if (f26471h) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void r(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, sQLiteDatabase) == null) {
            try {
                sQLiteDatabase.execSQL("CREATE TABLE file (filename TEXT PRIMARY KEY,state TEXT,reserve1 TEXT,reserve2 TEXT);");
            } catch (SQLException e2) {
                if (f26471h) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean s() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            this.f26476g.writeLock().lock();
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
                            if (f26471h) {
                                e.printStackTrace();
                            }
                            this.f26474e.h(e);
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
                if (f26471h) {
                    e4.printStackTrace();
                }
                this.f26474e.h(e4);
                return false;
            } finally {
                this.f26476g.writeLock().unlock();
            }
        }
        return invokeV.booleanValue;
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            this.f26476g.writeLock().lock();
            try {
                try {
                    SQLiteDatabase writableDatabase = getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                    try {
                        int delete = writableDatabase.delete("file", null, null);
                        if (f26471h) {
                            String str = "deleteAllSentFile#performTransaction: delete file table:" + delete;
                        }
                        writableDatabase.setTransactionSuccessful();
                        writableDatabase.endTransaction();
                    } catch (Throwable th) {
                        writableDatabase.endTransaction();
                        throw th;
                    }
                } catch (SQLException e2) {
                    if (f26471h) {
                        e2.printStackTrace();
                    }
                    this.f26474e.h(e2);
                }
            } finally {
                this.f26476g.writeLock().unlock();
            }
        }
    }

    public boolean u(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048628, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            this.f26476g.writeLock().lock();
            try {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                Cursor cursor = null;
                try {
                    cursor = writableDatabase.rawQuery("SELECT * FROM " + UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME + " WHERE eventid=\"" + str + "\"", null);
                    if (cursor != null && cursor.getCount() != 0) {
                        int delete = writableDatabase.delete(UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME, "eventid =? ", new String[]{str});
                        writableDatabase.setTransactionSuccessful();
                        return delete > 0;
                    }
                    return true;
                } finally {
                    c.a.t0.q0.a.a(cursor);
                    writableDatabase.endTransaction();
                }
            } catch (SQLException e2) {
                if (f26471h) {
                    e2.printStackTrace();
                }
                this.f26474e.h(e2);
                return false;
            } finally {
                this.f26476g.writeLock().unlock();
            }
        }
        return invokeL.booleanValue;
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            x(true);
        }
    }

    public void w(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, str) == null) {
            this.f26476g.writeLock().lock();
            try {
                try {
                    SQLiteDatabase writableDatabase = getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                    try {
                        int delete = writableDatabase.delete("file", BreakpointSQLiteKey.FILENAME + "=\"" + str + "\"", null);
                        if (f26471h) {
                            String str2 = "deleteSendedFile#performTransaction: delete file table:" + delete;
                        }
                        writableDatabase.setTransactionSuccessful();
                        writableDatabase.endTransaction();
                    } catch (Throwable th) {
                        writableDatabase.endTransaction();
                        throw th;
                    }
                } catch (SQLException e2) {
                    if (f26471h) {
                        e2.printStackTrace();
                    }
                    this.f26474e.h(e2);
                }
            } finally {
                this.f26476g.writeLock().unlock();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:81:0x01eb A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x020a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void x(boolean z) {
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048631, this, z) == null) {
            this.f26476g.writeLock().lock();
            try {
                try {
                    SQLiteDatabase writableDatabase = getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                    try {
                        long currentTimeMillis = System.currentTimeMillis() - g.o().k();
                        Cursor cursor = null;
                        i4 = writableDatabase.delete("flow", "endtime < " + currentTimeMillis, null);
                        try {
                            if (f26471h) {
                                String str = "clearInvalidData: delete flow count:" + i4;
                            }
                            i3 = writableDatabase.delete("event", "begintime < " + currentTimeMillis, null);
                            try {
                                if (f26471h) {
                                    String str2 = "clearInvalidData: delete event count:" + i3;
                                }
                                long currentTimeMillis2 = System.currentTimeMillis() - 86400000;
                                StringBuilder sb = new StringBuilder(256);
                                sb.append("SELECT ");
                                sb.append("flowhandle");
                                sb.append(" FROM ");
                                sb.append("flow");
                                sb.append(" WHERE ");
                                if (!z) {
                                    sb.append("begintime");
                                    sb.append(" < ");
                                    sb.append(currentTimeMillis2);
                                    sb.append(" AND ");
                                }
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
                                            c.a.t0.q0.a.a(cursor);
                                            throw th;
                                        }
                                    }
                                    c.a.t0.q0.a.a(rawQuery);
                                    if (arrayList.size() > 0) {
                                        if (f26471h) {
                                            String str3 = "clearInvalidData: delete flow count2:" + arrayList.size();
                                        }
                                        String M = M(arrayList);
                                        StringBuilder sb2 = new StringBuilder();
                                        sb2.append("flowhandle");
                                        sb2.append(" in (");
                                        sb2.append(M);
                                        sb2.append(SmallTailInfo.EMOTION_SUFFIX);
                                        writableDatabase.delete("flow", sb2.toString(), null);
                                        writableDatabase.delete("event", sb2.toString(), null);
                                    }
                                    writableDatabase.setTransactionSuccessful();
                                    writableDatabase.endTransaction();
                                    i2 = z("flow");
                                    try {
                                        try {
                                            int z2 = z("event");
                                            this.f26476g.writeLock().unlock();
                                            if (i4 > 0 || i3 > 0) {
                                                d0.a().e(String.valueOf(g.o().k()), i4, i3, 0);
                                                i0.m().s(i3, i4);
                                            }
                                            if (i2 <= 0 && z2 <= 0) {
                                                return;
                                            }
                                        } catch (SQLException e2) {
                                            e = e2;
                                            if (f26471h) {
                                                e.printStackTrace();
                                            }
                                            this.f26474e.h(e);
                                            this.f26476g.writeLock().unlock();
                                            if (i4 > 0 || i3 > 0) {
                                                d0.a().e(String.valueOf(g.o().k()), i4, i3, 0);
                                                i0.m().s(i3, i4);
                                            }
                                            if (i2 <= 0) {
                                                return;
                                            }
                                            i0.m().t();
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        this.f26476g.writeLock().unlock();
                                        if (i4 <= 0 || i3 > 0) {
                                            d0.a().e(String.valueOf(g.o().k()), i4, i3, 0);
                                            i0.m().s(i3, i4);
                                        }
                                        if (i2 > 0) {
                                            i0.m().t();
                                        }
                                        throw th;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                writableDatabase.endTransaction();
                                throw th;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                    }
                } catch (SQLException e3) {
                    e = e3;
                    i2 = 0;
                } catch (Throwable th7) {
                    th = th7;
                    i2 = 0;
                    this.f26476g.writeLock().unlock();
                    if (i4 <= 0) {
                    }
                    d0.a().e(String.valueOf(g.o().k()), i4, i3, 0);
                    i0.m().s(i3, i4);
                    if (i2 > 0) {
                    }
                    throw th;
                }
            } catch (SQLException e4) {
                e = e4;
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } catch (Throwable th8) {
                th = th8;
                i2 = 0;
                i3 = 0;
                i4 = 0;
                this.f26476g.writeLock().unlock();
                if (i4 <= 0) {
                }
                d0.a().e(String.valueOf(g.o().k()), i4, i3, 0);
                i0.m().s(i3, i4);
                if (i2 > 0) {
                }
                throw th;
            }
            i0.m().t();
        }
    }

    public void y(String str, int i2, long j2, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048632, this, new Object[]{str, Integer.valueOf(i2), Long.valueOf(j2), jSONArray}) == null) {
            if (i2 >= 0 && !TextUtils.isEmpty(str)) {
                this.f26476g.writeLock().lock();
                try {
                    try {
                        SQLiteDatabase writableDatabase = getWritableDatabase();
                        writableDatabase.beginTransactionNonExclusive();
                        try {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("state", "2");
                            contentValues.put("endtime", Long.valueOf(j2));
                            if (jSONArray != null && jSONArray.length() > 0) {
                                contentValues.put("slot", jSONArray.toString());
                            }
                            int update = writableDatabase.update("flow", contentValues, "flowid=\"" + str + "\" AND flowhandle = " + i2, null);
                            if (f26471h && update != 1) {
                                String str2 = "endFlow#performTransaction: endFlow count:" + update;
                            }
                            x.f().a(str, false);
                            i0.m().y(str, update);
                            writableDatabase.setTransactionSuccessful();
                            writableDatabase.endTransaction();
                        } catch (Throwable th) {
                            writableDatabase.endTransaction();
                            throw th;
                        }
                    } catch (SQLException e2) {
                        if (f26471h) {
                            e2.printStackTrace();
                        }
                        this.f26474e.h(e2);
                    }
                    return;
                } finally {
                    this.f26476g.writeLock().unlock();
                }
            }
            boolean z = f26471h;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x00fa, code lost:
        if (0 <= 0) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00fd, code lost:
        return r1;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a3 A[Catch: all -> 0x00dd, TryCatch #6 {all -> 0x00dd, blocks: (B:6:0x0017, B:22:0x0074, B:32:0x008a, B:34:0x00a3, B:35:0x00b3, B:31:0x0086, B:41:0x00d9, B:42:0x00dc), top: B:70:0x0017 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int z(String str) {
        InterceptResult invokeL;
        Cursor cursor;
        Throwable th;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048633, this, str)) != null) {
            return invokeL.intValue;
        }
        this.f26476g.writeLock().lock();
        int i3 = 0;
        try {
            try {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    try {
                        cursor = writableDatabase.rawQuery("SELECT COUNT(*), MIN(_id), MAX(_id) FROM " + str, null);
                    } catch (RuntimeException e2) {
                        e = e2;
                        cursor = null;
                    } catch (Throwable th2) {
                        cursor = null;
                        th = th2;
                        c.a.t0.q0.a.a(cursor);
                        throw th;
                    }
                    if (cursor != null) {
                        try {
                            try {
                            } catch (RuntimeException e3) {
                                e = e3;
                                if (f26471h) {
                                    e.printStackTrace();
                                }
                                c.a.t0.q0.a.a(cursor);
                                i2 = 0;
                                i3 = writableDatabase.delete(str, "_id < " + i2, null);
                                if (f26471h) {
                                }
                                writableDatabase.setTransactionSuccessful();
                            }
                            if (cursor.getCount() > 0) {
                                cursor.moveToFirst();
                                if (cursor.getInt(0) > i0.m().l()) {
                                    int i4 = cursor.getInt(1);
                                    int i5 = cursor.getInt(2);
                                    if (i0.m().o()) {
                                        i2 = (i4 + i5) / 3;
                                    } else {
                                        i2 = (i4 + i5) / 2;
                                    }
                                    c.a.t0.q0.a.a(cursor);
                                    i3 = writableDatabase.delete(str, "_id < " + i2, null);
                                    if (f26471h) {
                                        String str2 = "ensureDataBaseLimit#performTransaction: delete count:" + i3;
                                    }
                                    writableDatabase.setTransactionSuccessful();
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            c.a.t0.q0.a.a(cursor);
                            throw th;
                        }
                    }
                    i2 = 0;
                    c.a.t0.q0.a.a(cursor);
                    i3 = writableDatabase.delete(str, "_id < " + i2, null);
                    if (f26471h) {
                    }
                    writableDatabase.setTransactionSuccessful();
                } finally {
                    writableDatabase.endTransaction();
                }
            } catch (SQLException e4) {
                if (f26471h) {
                    e4.printStackTrace();
                }
                this.f26474e.h(e4);
                this.f26476g.writeLock().unlock();
            }
        } finally {
            this.f26476g.writeLock().unlock();
            if (0 > 0) {
                d0.a().b(String.valueOf(g.o().l()), 0, str);
            }
        }
    }
}

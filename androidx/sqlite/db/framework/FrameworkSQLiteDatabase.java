package androidx.sqlite.db.framework;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.database.sqlite.SQLiteTransactionListener;
import android.os.CancellationSignal;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
/* loaded from: classes.dex */
public class FrameworkSQLiteDatabase implements SupportSQLiteDatabase {
    public static /* synthetic */ Interceptable $ic;
    public static final String[] CONFLICT_VALUES;
    public static final String[] EMPTY_STRING_ARRAY;
    public transient /* synthetic */ FieldHolder $fh;
    public final SQLiteDatabase mDelegate;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-902759505, "Landroidx/sqlite/db/framework/FrameworkSQLiteDatabase;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-902759505, "Landroidx/sqlite/db/framework/FrameworkSQLiteDatabase;");
                return;
            }
        }
        CONFLICT_VALUES = new String[]{"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};
        EMPTY_STRING_ARRAY = new String[0];
    }

    public FrameworkSQLiteDatabase(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sQLiteDatabase};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mDelegate = sQLiteDatabase;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionWithListener(SQLiteTransactionListener sQLiteTransactionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sQLiteTransactionListener) == null) {
            this.mDelegate.beginTransactionWithListener(sQLiteTransactionListener);
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionWithListenerNonExclusive(SQLiteTransactionListener sQLiteTransactionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, sQLiteTransactionListener) == null) {
            this.mDelegate.beginTransactionWithListenerNonExclusive(sQLiteTransactionListener);
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public SupportSQLiteStatement compileStatement(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            return new FrameworkSQLiteStatement(this.mDelegate.compileStatement(str));
        }
        return (SupportSQLiteStatement) invokeL.objValue;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void execSQL(String str) throws SQLException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.mDelegate.execSQL(str);
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean needUpgrade(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048600, this, i)) == null) {
            return this.mDelegate.needUpgrade(i);
        }
        return invokeI.booleanValue;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(SupportSQLiteQuery supportSQLiteQuery) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, supportSQLiteQuery)) == null) {
            return this.mDelegate.rawQueryWithFactory(new SQLiteDatabase.CursorFactory(this, supportSQLiteQuery) { // from class: androidx.sqlite.db.framework.FrameworkSQLiteDatabase.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FrameworkSQLiteDatabase this$0;
                public final /* synthetic */ SupportSQLiteQuery val$supportQuery;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, supportSQLiteQuery};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$supportQuery = supportSQLiteQuery;
                }

                @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
                public Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
                    InterceptResult invokeLLLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLLLL = interceptable2.invokeLLLL(1048576, this, sQLiteDatabase, sQLiteCursorDriver, str, sQLiteQuery)) == null) {
                        this.val$supportQuery.bindTo(new FrameworkSQLiteProgram(sQLiteQuery));
                        return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
                    }
                    return (Cursor) invokeLLLL.objValue;
                }
            }, supportSQLiteQuery.getSql(), EMPTY_STRING_ARRAY, null);
        }
        return (Cursor) invokeL.objValue;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setForeignKeyConstraintsEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            this.mDelegate.setForeignKeyConstraintsEnabled(z);
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setLocale(Locale locale) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, locale) == null) {
            this.mDelegate.setLocale(locale);
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setMaxSqlCacheSize(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i) == null) {
            this.mDelegate.setMaxSqlCacheSize(i);
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long setMaximumSize(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048608, this, j)) == null) {
            return this.mDelegate.setMaximumSize(j);
        }
        return invokeJ.longValue;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setPageSize(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048609, this, j) == null) {
            this.mDelegate.setPageSize(j);
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setVersion(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i) == null) {
            this.mDelegate.setVersion(i);
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean yieldIfContendedSafely(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048614, this, j)) == null) {
            return this.mDelegate.yieldIfContendedSafely(j);
        }
        return invokeJ.booleanValue;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransaction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mDelegate.beginTransaction();
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionNonExclusive() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.mDelegate.beginTransactionNonExclusive();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.mDelegate.close();
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void disableWriteAheadLogging() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.mDelegate.disableWriteAheadLogging();
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean enableWriteAheadLogging() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.mDelegate.enableWriteAheadLogging();
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void endTransaction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.mDelegate.endTransaction();
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public List<Pair<String, String>> getAttachedDbs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.mDelegate.getAttachedDbs();
        }
        return (List) invokeV.objValue;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long getMaximumSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.mDelegate.getMaximumSize();
        }
        return invokeV.longValue;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long getPageSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.mDelegate.getPageSize();
        }
        return invokeV.longValue;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public String getPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.mDelegate.getPath();
        }
        return (String) invokeV.objValue;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int getVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.mDelegate.getVersion();
        }
        return invokeV.intValue;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean inTransaction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.mDelegate.inTransaction();
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isDatabaseIntegrityOk() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.mDelegate.isDatabaseIntegrityOk();
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isDbLockedByCurrentThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.mDelegate.isDbLockedByCurrentThread();
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isOpen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.mDelegate.isOpen();
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isReadOnly() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.mDelegate.isReadOnly();
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isWriteAheadLoggingEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.mDelegate.isWriteAheadLoggingEnabled();
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setTransactionSuccessful() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            this.mDelegate.setTransactionSuccessful();
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean yieldIfContendedSafely() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return this.mDelegate.yieldIfContendedSafely();
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int delete(String str, String str2, Object[] objArr) {
        InterceptResult invokeLLL;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, str, str2, objArr)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("DELETE FROM ");
            sb.append(str);
            if (TextUtils.isEmpty(str2)) {
                str3 = "";
            } else {
                str3 = " WHERE " + str2;
            }
            sb.append(str3);
            SupportSQLiteStatement compileStatement = compileStatement(sb.toString());
            SimpleSQLiteQuery.bind(compileStatement, objArr);
            return compileStatement.executeUpdateDelete();
        }
        return invokeLLL.intValue;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void execSQL(String str, Object[] objArr) throws SQLException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, str, objArr) == null) {
            this.mDelegate.execSQL(str, objArr);
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(SupportSQLiteQuery supportSQLiteQuery, CancellationSignal cancellationSignal) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048602, this, supportSQLiteQuery, cancellationSignal)) == null) {
            return this.mDelegate.rawQueryWithFactory(new SQLiteDatabase.CursorFactory(this, supportSQLiteQuery) { // from class: androidx.sqlite.db.framework.FrameworkSQLiteDatabase.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FrameworkSQLiteDatabase this$0;
                public final /* synthetic */ SupportSQLiteQuery val$supportQuery;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, supportSQLiteQuery};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$supportQuery = supportSQLiteQuery;
                }

                @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
                public Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
                    InterceptResult invokeLLLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLLLL = interceptable2.invokeLLLL(1048576, this, sQLiteDatabase, sQLiteCursorDriver, str, sQLiteQuery)) == null) {
                        this.val$supportQuery.bindTo(new FrameworkSQLiteProgram(sQLiteQuery));
                        return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
                    }
                    return (Cursor) invokeLLLL.objValue;
                }
            }, supportSQLiteQuery.getSql(), EMPTY_STRING_ARRAY, null, cancellationSignal);
        }
        return (Cursor) invokeLL.objValue;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long insert(String str, int i, ContentValues contentValues) throws SQLException {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048594, this, str, i, contentValues)) == null) {
            return this.mDelegate.insertWithOnConflict(str, null, contentValues, i);
        }
        return invokeLIL.longValue;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, str)) == null) {
            return query(new SimpleSQLiteQuery(str));
        }
        return (Cursor) invokeL.objValue;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(String str, Object[] objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048604, this, str, objArr)) == null) {
            return query(new SimpleSQLiteQuery(str, objArr));
        }
        return (Cursor) invokeLL.objValue;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int update(String str, int i, ContentValues contentValues, String str2, Object[] objArr) {
        InterceptResult invokeCommon;
        int length;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048612, this, new Object[]{str, Integer.valueOf(i), contentValues, str2, objArr})) == null) {
            if (contentValues != null && contentValues.size() != 0) {
                StringBuilder sb = new StringBuilder(120);
                sb.append("UPDATE ");
                sb.append(CONFLICT_VALUES[i]);
                sb.append(str);
                sb.append(" SET ");
                int size = contentValues.size();
                if (objArr == null) {
                    length = size;
                } else {
                    length = objArr.length + size;
                }
                Object[] objArr2 = new Object[length];
                int i2 = 0;
                for (String str4 : contentValues.keySet()) {
                    if (i2 > 0) {
                        str3 = ",";
                    } else {
                        str3 = "";
                    }
                    sb.append(str3);
                    sb.append(str4);
                    objArr2[i2] = contentValues.get(str4);
                    sb.append("=?");
                    i2++;
                }
                if (objArr != null) {
                    for (int i3 = size; i3 < length; i3++) {
                        objArr2[i3] = objArr[i3 - size];
                    }
                }
                if (!TextUtils.isEmpty(str2)) {
                    sb.append(" WHERE ");
                    sb.append(str2);
                }
                SupportSQLiteStatement compileStatement = compileStatement(sb.toString());
                SimpleSQLiteQuery.bind(compileStatement, objArr2);
                return compileStatement.executeUpdateDelete();
            }
            throw new IllegalArgumentException("Empty values");
        }
        return invokeCommon.intValue;
    }
}

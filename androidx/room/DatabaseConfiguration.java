package androidx.room;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public class DatabaseConfiguration {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean allowMainThreadQueries;
    @Nullable
    public final List<RoomDatabase.Callback> callbacks;
    @NonNull
    public final Context context;
    public final RoomDatabase.JournalMode journalMode;
    public final Set<Integer> mMigrationNotRequiredFrom;
    @NonNull
    public final RoomDatabase.MigrationContainer migrationContainer;
    @Nullable
    public final String name;
    @NonNull
    public final Executor queryExecutor;
    public final boolean requireMigration;
    @NonNull
    public final SupportSQLiteOpenHelper.Factory sqliteOpenHelperFactory;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public DatabaseConfiguration(@NonNull Context context, @Nullable String str, @NonNull SupportSQLiteOpenHelper.Factory factory, @NonNull RoomDatabase.MigrationContainer migrationContainer, @Nullable List<RoomDatabase.Callback> list, boolean z, RoomDatabase.JournalMode journalMode, @NonNull Executor executor, boolean z2, @Nullable Set<Integer> set) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, factory, migrationContainer, list, Boolean.valueOf(z), journalMode, executor, Boolean.valueOf(z2), set};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.sqliteOpenHelperFactory = factory;
        this.context = context;
        this.name = str;
        this.migrationContainer = migrationContainer;
        this.callbacks = list;
        this.allowMainThreadQueries = z;
        this.journalMode = journalMode;
        this.queryExecutor = executor;
        this.requireMigration = z2;
        this.mMigrationNotRequiredFrom = set;
    }

    public boolean isMigrationRequiredFrom(int i) {
        InterceptResult invokeI;
        Set<Integer> set;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            if (this.requireMigration && ((set = this.mMigrationNotRequiredFrom) == null || !set.contains(Integer.valueOf(i)))) {
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }
}

package androidx.sqlite.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
import java.util.List;
/* loaded from: classes.dex */
public interface SupportSQLiteOpenHelper {

    /* loaded from: classes.dex */
    public static abstract class Callback {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String TAG = "SupportSQLite";
        public transient /* synthetic */ FieldHolder $fh;
        public final int version;

        public Callback(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.version = i2;
        }

        private void deleteDatabaseFile(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(65537, this, str) == null) || str.equalsIgnoreCase(":memory:") || str.trim().length() == 0) {
                return;
            }
            Log.w(TAG, "deleting the database file: " + str);
            try {
                if (Build.VERSION.SDK_INT >= 16) {
                    SQLiteDatabase.deleteDatabase(new File(str));
                } else {
                    try {
                        if (!new File(str).delete()) {
                            Log.e(TAG, "Could not delete the database file " + str);
                        }
                    } catch (Exception e2) {
                        Log.e(TAG, "error while deleting corrupted database file", e2);
                    }
                }
            } catch (Exception e3) {
                Log.w(TAG, "delete failed: ", e3);
            }
        }

        public void onConfigure(SupportSQLiteDatabase supportSQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, supportSQLiteDatabase) == null) {
            }
        }

        public void onCorruption(SupportSQLiteDatabase supportSQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, supportSQLiteDatabase) == null) {
                Log.e(TAG, "Corruption reported by sqlite on database: " + supportSQLiteDatabase.getPath());
                if (!supportSQLiteDatabase.isOpen()) {
                    deleteDatabaseFile(supportSQLiteDatabase.getPath());
                    return;
                }
                List<Pair<String, String>> list = null;
                try {
                    try {
                        list = supportSQLiteDatabase.getAttachedDbs();
                    } finally {
                        if (list != null) {
                            for (Pair<String, String> next : list) {
                                deleteDatabaseFile((String) next.second);
                            }
                        } else {
                            deleteDatabaseFile(supportSQLiteDatabase.getPath());
                        }
                    }
                } catch (SQLiteException unused) {
                }
                try {
                    supportSQLiteDatabase.close();
                } catch (IOException unused2) {
                }
            }
        }

        public abstract void onCreate(SupportSQLiteDatabase supportSQLiteDatabase);

        public void onDowngrade(SupportSQLiteDatabase supportSQLiteDatabase, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048579, this, supportSQLiteDatabase, i2, i3) == null) {
                throw new SQLiteException("Can't downgrade database from version " + i2 + " to " + i3);
            }
        }

        public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, supportSQLiteDatabase) == null) {
            }
        }

        public abstract void onUpgrade(SupportSQLiteDatabase supportSQLiteDatabase, int i2, int i3);
    }

    /* loaded from: classes.dex */
    public static class Configuration {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public final Callback callback;
        @NonNull
        public final Context context;
        @Nullable
        public final String name;

        /* loaded from: classes.dex */
        public static class Builder {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public Callback mCallback;
            public Context mContext;
            public String mName;

            public Builder(@NonNull Context context) {
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
                this.mContext = context;
            }

            public Configuration build() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    Callback callback = this.mCallback;
                    if (callback != null) {
                        Context context = this.mContext;
                        if (context != null) {
                            return new Configuration(context, this.mName, callback);
                        }
                        throw new IllegalArgumentException("Must set a non-null context to create the configuration.");
                    }
                    throw new IllegalArgumentException("Must set a callback to create the configuration.");
                }
                return (Configuration) invokeV.objValue;
            }

            public Builder callback(@NonNull Callback callback) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, callback)) == null) {
                    this.mCallback = callback;
                    return this;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder name(@Nullable String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                    this.mName = str;
                    return this;
                }
                return (Builder) invokeL.objValue;
            }
        }

        public Configuration(@NonNull Context context, @Nullable String str, @NonNull Callback callback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, str, callback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.context = context;
            this.name = str;
            this.callback = callback;
        }

        public static Builder builder(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) ? new Builder(context) : (Builder) invokeL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public interface Factory {
        SupportSQLiteOpenHelper create(Configuration configuration);
    }

    void close();

    String getDatabaseName();

    SupportSQLiteDatabase getReadableDatabase();

    SupportSQLiteDatabase getWritableDatabase();

    @RequiresApi(api = 16)
    void setWriteAheadLoggingEnabled(boolean z);
}
